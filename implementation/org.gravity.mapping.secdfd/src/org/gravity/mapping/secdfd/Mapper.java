/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TConstructorDefinition;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.CorrespondenceModel;
import org.moflon.tgg.runtime.RuntimeFactory;
import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;

/**
 * @author speldszus
 *
 */
public class Mapper {

	private static final SecdfdFactory FACTORY = SecdfdFactory.eINSTANCE;

	/**
	 * The correspondence model built by this class
	 */
	private CorrespondenceModel corr;

	/**
	 * All types and operations from the program model
	 */
	private static List<TAbstractType> types;
	private static List<TMethod> methods;

	public CorrespondenceModel map(TypeGraph pm, EDFD dfd) {
		// Save types and methods from the program model in fields as they are accessed
		// very often
		types = pm.getOwnedTypes().parallelStream()
				.filter(t -> t.isDeclared())
				.collect(Collectors.toList());
		methods = pm.getMethods();

		// Create a correspondence model between the two models
		corr = RuntimeFactory.eINSTANCE.createCorrespondenceModel();
		createCorrespondence(pm, dfd);

		// Search for correspondences between graph assets and types in the pm
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = new HashMap<>();
		for (Asset asset : dfd.getAsset()) {
			entityTypeMapping.put(asset, mapToType(asset).map(c -> c.getSource()).collect(Collectors.toSet()));
		}

		// Search for correspondences between nodes and operations
		HashMap<Element, Set<TMethod>> elementMethodMapping = new HashMap<>();
		HashMap<Element, Set<TSignature>> elementSignatureMapping = new HashMap<>();
		HashMap<Element, Set<TMember>> elementMemberMapping = new HashMap<>();
		for (Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (EDFDFlowTracking1Package.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					Set<TMethod> correspondingMethods = mapToMethod(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					elementMethodMapping.put(node, correspondingMethods);
					elementSignatureMapping.put(node, mapToSignature(node, correspondingMethods, entityTypeMapping)
							.map(corr -> corr.getSource()).collect(Collectors.toSet()));
				} else if (EDFDFlowTracking1Package.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					Set<TAbstractType> correspondingTypes = mapToType(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					entityTypeMapping.put(node, correspondingTypes);
					elementMemberMapping.put(node, mapToMembers(node, correspondingTypes, entityTypeMapping).map(corr -> corr.getSource()).collect(Collectors.toSet()));
				}
			}
		}
		
		for(Set<TSignature> signatures : elementSignatureMapping.values()) {
			for(TSignature signature : signatures) {
				for(TMethodDefinition defintion : ((TMethodSignature) signature).getDefinitions()) {
					
				}
			}
		}

		return corr;
	}

	private Stream<Defintion2Element> mapToMembers(Element node, Set<TAbstractType> correspondingTypes,
			HashMap<NamedEntity, Set<TAbstractType>> mapping) {
		Set<Defintion2Element> correspondingMembers = new HashSet<>();
		for (TAbstractType type : correspondingTypes) {
			for (Asset asset : node.getAssets()) {
				if (mapping.containsKey(asset)) {
					List<TMember> members = type.getDefines();
					for (TAbstractType assetType : mapping.get(asset)) {
						for (TMember member : members) {
							TAbstractType memberType;
							if (member instanceof TFieldDefinition) {
								memberType = ((TFieldDefinition) member).getSignature().getType();
							} else if (member instanceof TConstructorDefinition) {
								memberType = type;
							} else {
								memberType = ((TMethodDefinition) member).getReturnType();
							}
							if (memberType.equals(assetType) || memberType.isSuperTypeOf((TAbstractType) assetType)) {
								correspondingMembers.add(createCorrespondence(node, member));
							}
						}
					}
				}
			}
		}
		
		return correspondingMembers.parallelStream();
	}

	/**
	 * @param node
	 * @param correspondingMethods
	 * @param mapping
	 * @return
	 */
	private Stream<Signature2Element> mapToSignature(Element node, Set<TMethod> correspondingMethods,
			HashMap<NamedEntity, Set<TAbstractType>> mapping) {
		Set<TAbstractType> paramTypes = new HashSet<>();
		for (Flow flow : node.getInflows()) {
			for (Asset asset : flow.getAssets()) {
				if (mapping.containsKey(asset)) {
					for (TAbstractType eObject : mapping.get(asset)) {
						Stack<TAbstractType> stack = new Stack<>();
						stack.add(eObject);
						while (!stack.isEmpty()) {
							TAbstractType type = stack.pop();
							paramTypes.add(type);
							if (type instanceof TClass) {
								TClass tClass = (TClass) type;
								TClass parentClass = tClass.getParentClass();
								if (parentClass != null) {
									stack.add(parentClass);
								}
								stack.addAll(tClass.getImplements());
							} else if (type instanceof TInterface) {
								stack.addAll(((TInterface) type).getParentInterfaces());
							}
						}
					}
				}
			}
		}
		return correspondingMethods.parallelStream().flatMap(method -> method.getSignatures().parallelStream())
				.filter(signature -> {
					int matchedParams = 0;
					for (TParameter param : signature.getParamList().getEntries()) {
						if (paramTypes.contains(param.getType())) {
							matchedParams++;
						}
					}
					return matchedParams > 0;
				}).map(signature -> createCorrespondence(node, signature));
	}

	/**
	 * Search methods in the pm corresponding to the node and create correspondences
	 * for them
	 * 
	 * @param asset The node for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Method2Element> mapToMethod(Element node) {
		return methods.parallelStream().filter(m -> StringCompare.compare(node.getName(), m.getTName()))
				.map(m -> createCorrespondence(node, m));
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param entity The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2NamedEntity> mapToType(NamedEntity entity) {
		return types.parallelStream().filter(t -> StringCompare.compare(entity.getName(), t.getTName()))
				.map(t -> createCorrespondence(entity, t));

	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param element A node object
	 * @param member  A method object
	 * @return The correspondence
	 */
	private Method2Element createCorrespondence(Element element, TMethod member) {
		Method2Element method2element = FACTORY.createMethod2Element();
		method2element.setSource(member);
		method2element.setTarget(element);
		corr.getCorrespondences().add(method2element);
		return method2element;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param element A node object
	 * @param member  A method object
	 * @return The correspondence
	 */
	private Defintion2Element createCorrespondence(Element element, TMember member) {
		Defintion2Element method2element = FACTORY.createDefintion2Element();
		method2element.setSource(member);
		method2element.setTarget(element);
		corr.getCorrespondences().add(method2element);
		return method2element;
	}

	private Signature2Element createCorrespondence(Element node, TMethodSignature signature) {
		Signature2Element signature2element = FACTORY.createSignature2Element();
		signature2element.setSource(signature);
		signature2element.setTarget(node);
		corr.getCorrespondences().add(signature2element);
		return signature2element;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param asset An named entity
	 * @param type  A type object
	 * @return The correspondence
	 */
	private Type2NamedEntity createCorrespondence(NamedEntity entity, TAbstractType type) {
		Type2NamedEntity type2asset = FACTORY.createType2NamedEntity();
		type2asset.setSource(type);
		type2asset.setTarget(entity);
		corr.getCorrespondences().add(type2asset);
		return type2asset;
	}

	/**
	 * Creates a new correspondence between a program model and a data flow diagram
	 * and adds it to the correspondence model
	 * 
	 * @param pm  The program model
	 * @param dfd The data flow diagram
	 */
	private TypeGraph2EDFD createCorrespondence(TypeGraph pm, EDFD dfd) {
		TypeGraph2EDFD pm2dfd = FACTORY.createTypeGraph2EDFD();
		pm2dfd.setSource(pm);
		pm2dfd.setTarget(dfd);
		corr.getCorrespondences().add(pm2dfd);
		return pm2dfd;
	}

}
