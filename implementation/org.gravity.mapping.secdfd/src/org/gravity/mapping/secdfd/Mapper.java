/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TConstructorDefinition;
import org.gravity.typegraph.basic.TConstructorName;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.DataStore;
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

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(Mapper.class);

	/**
	 * The correspondence model built by this class
	 */
	private Mapping mapping;

	/**
	 * All types and operations from the program model
	 */
	private static List<TAbstractType> types;
	private static List<TMethod> methods;

	/**
	 * HashMaps for the mapped entries
	 */
	private HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = new HashMap<>();
	private HashMap<Element, Set<TMethod>> elementMethodMapping = new HashMap<>();
	private HashMap<Element, Set<TSignature>> elementSignatureMapping = new HashMap<>();
	private HashMap<Element, Set<TMember>> elementMemberMapping = new HashMap<>();

	/**
	 * The program model for which a mapping has been created
	 */
	private final TypeGraph pm;

	/**
	 * The DFD for which a mapping has been created
	 */
	private final EDFD dfd;

	/**
	 * The location at which the mapping should be stored
	 */
	private IPath destination;

	private CorrespondenceHelper helper;

	public Mapper(TypeGraph pm, EDFD dfd, IPath destination) {
		this.pm = pm;
		this.dfd = dfd;
		this.destination = destination;

		// Save types and methods from the program model in fields as they are accessed
		// very often
		types = pm.getOwnedTypes().stream().filter(t -> !"T".equals(t.getTName()))
				.filter(t -> !"Anonymous".equals(t.getTName())).collect(Collectors.toList());
		methods = pm.getMethods().stream().filter(m -> !(m instanceof TConstructorName)).collect(Collectors.toList());

		initializeMapping(pm, dfd, destination);

		for (Asset asset : dfd.getAsset()) {
			entityTypeMapping.put(asset, mapToType(asset).map(c -> c.getSource()).collect(Collectors.toSet()));
		}

		for (Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (EDFDFlowTracking1Package.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					Set<TMethod> correspondingMethods = mapToMethod(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					elementMethodMapping.put(node, correspondingMethods);
				} else if (EDFDFlowTracking1Package.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					Set<TAbstractType> correspondingTypes = mapToType(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					entityTypeMapping.put(node, correspondingTypes);
				}
			}
		}
		optimize();
	}

	/**
	 * Create a correspondence model between the two models
	 * 
	 * @param pm           The program model
	 * @param dfd          The DFD
	 * @param destination The location where the model should be stored
	 */
	private void initializeMapping(TypeGraph pm, EDFD dfd, IPath destination) {
		// Create a correspondence model between the two models
		mapping = MappingFactory.eINSTANCE.createMapping();
		mapping.setSource(pm);
		mapping.setTarget(dfd);
		URI uri = URI.createURI(destination.toString());
		EList<EObject> contents = pm.eResource().getResourceSet().createResource(uri).getContents();
		contents.add(mapping);
		helper = new CorrespondenceHelper(mapping);
		helper.createCorrespondence(pm, dfd);
	}

	/**
	 * Optimizes the mapping and returns the optimized mapping
	 * 
	 * @return The optimized mapping
	 */
	public Mapping optimize() {
		entityTypeMapping.entrySet().stream().filter(e -> e.getKey() instanceof Element).forEach(e -> {
			Element node = (Element) e.getKey();
			elementMemberMapping.put(node, mapToMembers(node, e.getValue(), entityTypeMapping)
					.map(corr -> corr.getSource()).collect(Collectors.toSet()));
		});

		for (Entry<Element, Set<TMethod>> entry : elementMethodMapping.entrySet()) {
			Element node = entry.getKey();
			elementSignatureMapping.put(node, mapToSignature(node, entry.getValue(), entityTypeMapping)
					.map(corr -> corr.getSource()).collect(Collectors.toSet()));
		}

		for (Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
			Element sourceElement = entry.getKey();
			Set<TSignature> signatures = entry.getValue();
			for (TSignature signature : signatures) {
				for (Flow flow : sourceElement.getOutflows()) {
					for (Element targetElement : flow.getTarget()) {
						if (elementSignatureMapping.containsKey(targetElement)) {
							for (TSignature targetSignature : elementSignatureMapping.get(targetElement)) {
								for (TMethodDefinition sourceDefinition : ((TMethodSignature) signature)
										.getDefinitions()) {
									if (getPath(sourceDefinition, targetSignature)) {
										Defintion2Element corr = helper.createCorrespondence(sourceElement, sourceDefinition);
										mapping.getSuggested().add(corr);
									}
								}
							}
						}
					}
				}

			}
		}
		updateMappingOnFilesystem();
		return mapping;
	}

	public void accept(AbstractCorrespondence corr) {
		if ((mapping.getCorrespondences().contains(corr) && !mapping.getUserdefined().contains(corr))
				|| mapping.getIgnored().contains(corr)) {
			boolean remove = mapping.getIgnored().remove(corr);
			if (remove) {
				mapping.getCorrespondences().add(corr);
				// TODO: Add to maps
			} else {
				mapping.getSuggested().remove(corr);
			}
			mapping.getAccepted().add(corr);
			updateMappingOnFilesystem();
		}
	}

	public void reject(AbstractCorrespondence corr) {
		if (mapping.getCorrespondences().contains(corr)) {
			mapping.getIgnored().add(corr);
			mapping.getUserdefined().remove(corr);
			mapping.getSuggested().remove(corr);
			mapping.getAccepted().remove(corr);
			EObject source = CorrespondenceHelper.getSource(corr);
			EObject target = CorrespondenceHelper.getTarget(corr);
			if (source instanceof Process) {

			} else if (source instanceof Asset) {
				Set<TAbstractType> value = entityTypeMapping.get(source);
				if (value != null) {
					value.remove(target);
				}
			} else if (source instanceof DataStore) {
				Set<TAbstractType> value = entityTypeMapping.get(source);
				if (value != null) {
					value.remove(target);
				}
			}
		}
		updateMappingOnFilesystem();
	}

	/**
	 * Writes the mapping to the file system
	 */
	public void updateMappingOnFilesystem() {
		try {
			mapping.eResource().save(new FileOutputStream(destination.makeAbsolute().toFile()), Collections.emptyMap());
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	private boolean getPath(TMethodDefinition source, TSignature target) {
		Set<TMember> seen = new HashSet<>();
		List<TMember> stack = new LinkedList<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			TMember current = stack.remove(0);
			for (TAccess access : current.getTAccessing()) {
				TMember tTarget = access.getTTarget();
				if (tTarget.getSignature().equals(target)) {
					return true;
				}
				if (!seen.contains(tTarget)) {
					stack.add(tTarget);
				}
			}
			seen.add(current);
		}

		return false;
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
								Defintion2Element corr = helper.createCorrespondence(node, member);
								this.mapping.getSuggested().add(corr);
								correspondingMembers.add(corr);
							}
						}
					}
				}
			}
		}

		return correspondingMembers.stream();
	}

	/**
	 * Takes a set of mapped method names and type mappings for finding a
	 * corresponding signatures.
	 * 
	 * @param node                 The element which should be mapped
	 * @param correspondingMethods The method names corresponding to the element
	 * @param mapping              A mapping between assets and types
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
		return correspondingMethods.stream().flatMap(method -> method.getSignatures().stream()).filter(signature -> {
			int matchedParams = 0;
			for (TParameter param : signature.getParamList().getEntries()) {
				if (paramTypes.contains(param.getType())) {
					matchedParams++;
				}
			}
			return matchedParams > 0;
		}).map(signature -> {
			MappingProcessSignature newCorr = helper.createCorrespondence(node, signature);
			this.mapping.getSuggested().add(newCorr);
			return newCorr;
		});
	}

	/**
	 * Search methods in the pm corresponding to the node and create correspondences
	 * for them
	 * 
	 * @param asset The node for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Method2Element> mapToMethod(Element node) {
		Integer rank = 0;
		ArrayList<Method2Element> list = new ArrayList<Method2Element>();
		for (TMethod m : methods) {
			rank = StringCompare.compare(node.getName(), m.getTName());
			if (rank>0) {
				Method2Element corr = helper.createCorrespondence(node, m, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
		}
		return list.stream();
		
		
//		return methods.stream()
//				.filter(m -> StringCompare.compare(node.getName(), m.getTName())>0)
//				.map(m -> {
//			Method2Element corr = helper.createCorrespondence(node, m, r);
//			mapping.getSuggested().add(corr);
//			return corr;
//		});
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param entity The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2NamedEntity> mapToType(NamedEntity entity) {
		Integer rank = 0;
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		for (TAbstractType t : types) {
			rank = StringCompare.compare(entity.getName(), t.getTName());
			if (rank>0) {
				Type2NamedEntity corr = helper.createCorrespondence(entity, t, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
		}
		return list.stream();
		
		
//		return types.stream().filter(t -> StringCompare.compare(entity.getName(), t.getTName())).map(t -> {
//			Type2NamedEntity corr = helper.createCorrespondence(entity, t);
//			mapping.getSuggested().add(corr);
//			return corr;
//		});

	}

	/**
	 * A getter for the created mapping
	 * 
	 * @return the mapping
	 */
	public Mapping getMapping() {
		return mapping;
	}

	/**
	 * A getter for the proggram model
	 * 
	 * @return the pm
	 */
	public TypeGraph getPM() {
		return pm;
	}

	/**
	 * A getter for the DFD
	 * 
	 * @return the DFD
	 */
	public EDFD getDFD() {
		return dfd;
	}

	/**
	 * A getter for the location where the mapping is stored
	 * 
	 * @return The location
	 */
	public IPath getFile() {
		return destination;
	}

}
