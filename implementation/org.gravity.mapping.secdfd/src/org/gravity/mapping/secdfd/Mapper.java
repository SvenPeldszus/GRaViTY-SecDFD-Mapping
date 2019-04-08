/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
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
import eDFDFlowTracking.Process;

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

	private MappingCache cache = new MappingCache();

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
	private IFile destination;

	private CorrespondenceHelper helper;

	public Mapper(TypeGraph pm, EDFD dfd, IFile destination) {
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
			cache.addAll(mapToType(asset).map(c -> c.getSource()).collect(Collectors.toSet()), asset);
		}

		for (Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (EDFDFlowTracking1Package.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					Set<TMethod> correspondingMethods = mapToMethod(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					cache.addAllMethods(correspondingMethods, node);
				} else if (EDFDFlowTracking1Package.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					Set<TAbstractType> correspondingTypes = mapToType(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					cache.addAll(correspondingTypes, node);
				}
			}
		}
		optimize();
	}

	/**
	 * Create a correspondence model between the two models
	 * 
	 * @param pm          The program model
	 * @param dfd         The DFD
	 * @param destination The location where the model should be stored
	 */
	private void initializeMapping(TypeGraph pm, EDFD dfd, IFile destination) {
		// Create a correspondence model between the two models
		mapping = MappingFactory.eINSTANCE.createMapping();
		mapping.setSource(pm);
		mapping.setTarget(dfd);
		mapping.setName(dfd.getName());
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
		MappingLabelProvider.Logging.logging();
		LOGGER.log(Level.INFO, "\nStart optimization >>>>>\n");
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();

		entityTypeMapping.entrySet().stream().filter(entry -> entry.getKey() instanceof Element).forEach(entry -> {
			Element element = (Element) entry.getKey();
			cache.getElementMemberMapping().put(element, mapToMembers(element, entry.getValue(), entityTypeMapping)
					.map(corr -> corr.getSource()).collect(Collectors.toSet()));
		});

		for (Entry<Element, Set<TMethod>> entry : cache.getElementMethodMapping().entrySet()) {
			Element node = entry.getKey();
			cache.addAllSignatures(mapToSignature(node, entry.getValue(), entityTypeMapping)
					.map(corr -> corr.getSource()).collect(Collectors.toSet()), node);
		}

		HashMap<Element, Set<TSignature>> elementSignatureMapping = cache.getElementSignatureMapping();
		for (Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
			Element sourceElement = entry.getKey();
			Set<TSignature> signatures = entry.getValue();
			for (TSignature calledSignature : signatures) {
				TAbstractType returnType = ((TMethodSignature) calledSignature).getReturnType();
				mapToParamFlow(sourceElement, calledSignature);
				for (Flow flow : sourceElement.getOutflows()) {
					Collection<TSignature> callingSignatures = flow.getTarget().stream()
							.filter(key -> elementSignatureMapping.containsKey(key))
							.map(target -> elementSignatureMapping.get(target)).filter(Objects::nonNull)
							.flatMap(target -> target.stream()).collect(Collectors.toSet());
					
					Map<TAbstractType, Asset> compatible = new HashMap<>();
					for(Asset asset : flow.getAssets()) {
						if(entityTypeMapping.containsKey(asset)) {
							Set<TAbstractType> types = entityTypeMapping.get(asset).stream()
							.flatMap(type -> getAllCompatibleTypes(type).stream()).collect(Collectors.toSet());
							if(types.contains(returnType)) {
								compatible.put(returnType, asset);
							}
						}
					}
					if (!compatible.isEmpty()) {
						for (TMethodDefinition def : ((TMethodSignature) calledSignature).getDefinitions()) {
							def.getAccessedBy().stream().map(access -> access.getTSource().getSignature())
									.filter(calling -> callingSignatures.contains(calling)).forEach(calling -> {
										if (helper.canCreate(def, sourceElement)) {
											AbstractMappingBase returnCorr = (AbstractMappingBase) helper.getCorrespondence(returnType, compatible.get(returnType));
											helper.createCorrespondence(def, sourceElement, 80,
													Collections.singleton(returnCorr));
											cache.add(def, sourceElement);
										}
									});
							;
						}
					}
				}
			}
		}
		updateMappingOnFilesystem();
		LOGGER.log(Level.INFO, "\n<<<<< Stop optimization\n");
		return mapping;
	}

	/**
	 * @param sourceElement
	 * @param signature
	 */
	private void mapToParamFlow(Element sourceElement, TSignature signature) {
		for (Flow flow : sourceElement.getOutflows()) {
			for (Element targetElement : flow.getTarget()) {
				if (cache.getElementSignatureMapping().containsKey(targetElement)) {
					for (TSignature targetSignature : cache.getElementSignatureMapping().get(targetElement)) {
						for (TMethodDefinition sourceDefinition : ((TMethodSignature) signature).getDefinitions()) {
							if (getPath(sourceDefinition, targetSignature)
									&& helper.canCreate(sourceDefinition, sourceElement)) {
								AbstractMappingBase derived = (AbstractMappingBase) helper.getCorrespondence(signature, sourceElement);
								Defintion2Element corr = helper.createCorrespondence(sourceDefinition, sourceElement,
										90, Collections.singleton(derived));
								mapping.getCorrespondences().add(corr);
								mapping.getSuggested().add(corr);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Accept the given correspondence
	 * 
	 * @param corr The correspondence
	 */
	public void accept(AbstractCorrespondence corr) {
		if ((mapping.getCorrespondences().contains(corr) && !mapping.getUserdefined().contains(corr))
				|| mapping.getIgnored().contains(corr)) {
			boolean remove = mapping.getIgnored().remove(corr);
			if (remove) {
				mapping.getCorrespondences().add(corr);
//				add(CorrespondenceHelper.getSource(corr), CorrespondenceHelper.getTarget(corr));
			} else {
				mapping.getSuggested().remove(corr);
			}
			mapping.getAccepted().add(corr);
			updateRanking(corr, 100);
			if (corr instanceof AbstractMappingDerived) {
				((AbstractMappingDerived) corr).getDerived().forEach(parent -> accept(parent));
			}
			updateMappingOnFilesystem();
		}
	}

	/**
	 * Reject the given correspondence
	 * 
	 * @param corr The correspondence
	 */
	public void reject(AbstractCorrespondence corr) {
		if (mapping.getCorrespondences().contains(corr)) {
			mapping.getIgnored().add(corr);
			mapping.getUserdefined().remove(corr);
			mapping.getSuggested().remove(corr);
			mapping.getAccepted().remove(corr);
			EObject pmObject = CorrespondenceHelper.getSource(corr);
			EObject dfdObject = CorrespondenceHelper.getTarget(corr);
			if (dfdObject instanceof Process) {
				if (pmObject instanceof TMember) {
					Set<TMember> value = cache.getElementMemberMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
				} else if (pmObject instanceof TSignature) {
					Set<TSignature> value = cache.getElementSignatureMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
					((TMethodSignature) pmObject).getDefinitions().forEach(definiton -> {
						helper.getCorrespondences(definiton).forEach(defCorr -> reject(defCorr));
					});
				} else if (pmObject instanceof TMethod) {
					Set<TMethod> value = cache.getElementMethodMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
					((TMethod) pmObject).getSignatures().forEach(signature -> {
						helper.getCorrespondences(signature).forEach(sigCorr -> reject(sigCorr));
					});
				}
			} else if (pmObject instanceof Asset || pmObject instanceof DataStore) {
				Set<TAbstractType> value = cache.getEntityTypeMapping().get(dfdObject);
				if (value != null) {
					value.remove(pmObject);
				}
			}
		}
		updateMappingOnFilesystem();
	}

	/**
	 * Set the correspondence between the two objects to userdefined or create a
	 * correspondence
	 * 
	 * @param pmObject  An object from a program model
	 * @param dfdObject An object from a DFD
	 */
	public void userdefined(EObject pmObject, EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		Collection<AbstractCorrespondence> correspondences = helper.getCorrespondences(pmObject);
		if (!correspondences.isEmpty()) {
			for (AbstractCorrespondence corr : correspondences) {
				if (CorrespondenceHelper.getTarget(corr).equals(dfdObject)) {
					userCorr = corr;
					break;
				}
			}
			mapping.getSuggested().remove(userCorr);
			mapping.getAccepted().remove(userCorr);
		}
		if (userCorr == null) {
			userCorr = addNewUserdefinedCorr(pmObject, dfdObject);
		}
		if (userCorr != null) {
			Stack<AbstractCorrespondence> stack = new Stack<>();
			stack.add(userCorr);
			while (!stack.isEmpty()) {
				AbstractCorrespondence next = stack.pop();
				mapping.getCorrespondences().add(next);
				mapping.getUserdefined().add(next);
				if (next instanceof AbstractMappingDerived) {
					stack.addAll(((AbstractMappingDerived) next).getDerived());
				}
			}
			updateMappingOnFilesystem();
		}
	}

	/**
	 * Creates a new user defined correspondence
	 * 
	 * @param pmObject  The object from the program model
	 * @param dfdObject The object from the DFD
	 * @return The correspondence
	 */
	private AbstractCorrespondence addNewUserdefinedCorr(EObject pmObject, EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		if (pmObject instanceof TMethodDefinition) {
			TMethodDefinition method = (TMethodDefinition) pmObject;
			if (dfdObject instanceof Process) {
				Process process = (Process) dfdObject;
				userCorr = helper.createCorrespondence(method, process, 100, Collections.emptyList());
				cache.add(method, process);
			} else if (dfdObject instanceof DataStore) {
				DataStore store = (DataStore) dfdObject;
				userCorr = helper.createCorrespondence(method, store, 100, Collections.emptyList());
				cache.add(method, store);
			}
		} else if (pmObject instanceof TAbstractType) {
			TAbstractType type = (TAbstractType) pmObject;
			if (dfdObject instanceof Asset) {
				Asset asset = (Asset) dfdObject;
				userCorr = helper.createCorrespondence(type, asset, 100);
				cache.add(type, asset);
			} else if (dfdObject instanceof DataStore) {
				DataStore store = (DataStore) dfdObject;
				userCorr = helper.createCorrespondence(type, store, 100);
				cache.add(type, store);
			}
		}
		if (userCorr == null) {
			LOGGER.log(Level.ERROR, "Cannot add userdefinded correlation between " + pmObject + " and " + dfdObject);
		}
		return userCorr;
	}

	/**
	 * Recursively updates the ranking
	 * 
	 * @param corr A correspondence
	 */
	private void updateRanking(AbstractCorrespondence corr, int ranking) {
		if (corr instanceof AbstractMappingRanking) {
			((AbstractMappingRanking) corr).setRanking(ranking);
		} else if (corr instanceof MappingProcessSignature) {
			for (AbstractCorrespondence parentCorr : helper.getCorrespondences(
					((TMethodSignature) ((MappingProcessSignature) corr).getSource()).getMethod())) {
				if (CorrespondenceHelper.getTarget(parentCorr).equals(((MappingProcessSignature) corr).getTarget())) {
					((AbstractMappingRanking) parentCorr).setRanking(ranking);
				}
			}
		} else if (corr instanceof MappingProcessDefinition) {
			for (AbstractCorrespondence parentCorr : helper.getCorrespondences(
					((TMethodDefinition) ((MappingProcessDefinition) corr).getSource()).getSignature().getMethod())) {
				if (CorrespondenceHelper.getTarget(parentCorr).equals(((MappingProcessDefinition) corr).getTarget())) {
					((AbstractMappingRanking) parentCorr).setRanking(ranking);
				}
			}
		}
	}

	/**
	 * Writes the mapping to the file system
	 */
	public void updateMappingOnFilesystem() {
		try {
			mapping.eResource().save(new FileOutputStream(destination.getLocation().toFile()), Collections.emptyMap());
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

	private Stream<Defintion2Element> mapToMembers(Element element, Set<TAbstractType> typescorrespondingToElement,
			HashMap<NamedEntity, Set<TAbstractType>> typeMapping) {
		Set<Defintion2Element> correspondingMembers = new HashSet<>();
		for (TAbstractType type : typescorrespondingToElement) {
			for (Asset asset : element.getAssets()) {
				if (typeMapping.containsKey(asset)) {
					List<TMember> members = type.getDefines();
					for (TAbstractType assetType : typeMapping.get(asset)) {
						for (TMember member : members) {
							TAbstractType memberType;
							if (member instanceof TFieldDefinition) {
								memberType = ((TFieldDefinition) member).getSignature().getType();
							} else if (member instanceof TConstructorDefinition) {
								memberType = type;
							} else {
								memberType = ((TMethodDefinition) member).getReturnType();
							}
							if ((memberType.equals(assetType) || memberType.isSuperTypeOf((TAbstractType) assetType))
									&& helper.canCreate(member, element)) {
								Defintion2Element corr = helper.createCorrespondence(member, element, 90,
										Collections.emptyList());
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
	private Stream<MappingProcessSignature> mapToSignature(Element node, Set<TMethod> correspondingMethods,
			HashMap<NamedEntity, Set<TAbstractType>> mapping) {
		Map<Asset, Set<TAbstractType>> paramTypes = new HashMap<>();
		for (Flow flow : node.getInflows()) {
			for (Asset asset : flow.getAssets()) {
				if (mapping.containsKey(asset)) {
					Set<TAbstractType> compatipbleTypes = mapping.get(asset).stream()
							.flatMap(type -> mapping.get(asset).stream()).collect(Collectors.toSet());
					paramTypes.put(asset, compatipbleTypes);
				}
			}
		}
		return correspondingMethods.stream().flatMap(method -> method.getSignatures().stream()).map(signature -> {
			Map<Asset, TAbstractType> matchedAssets = new HashMap<>();
			for (TParameter param : signature.getParamList().getEntries()) {
				for (Entry<Asset, Set<TAbstractType>> entry : paramTypes.entrySet()) {
					if (entry.getValue().contains(param.getType())) {
						matchedAssets.put(entry.getKey(), param.getType());
					}
				}
			}
			if (matchedAssets.size() == 0) {
				return null;
			}
			MappingProcessSignature newCorr = null;
			if (helper.canCreate(signature, node)) {
				Collection<AbstractMappingBase> derived = matchedAssets.entrySet().parallelStream()
						.map(entry -> (AbstractMappingBase) helper.getCorrespondence(entry.getValue(), entry.getKey()))
						.collect(Collectors.toSet());
				newCorr = helper.createCorrespondence(signature, node, 80, derived);
				this.mapping.getSuggested().add(newCorr);
			}
			return newCorr;
		}).filter(Objects::nonNull);
	}

	/**
	 * Searches all types to which this type is compatible
	 * 
	 * @param type The type for which the set should be calculated
	 * @return All types the type is compatible to
	 */
	private Set<TAbstractType> getAllCompatibleTypes(TAbstractType type) {
		Set<TAbstractType> types = new HashSet<>();
		types.add(type);
		Stack<TAbstractType> stack = new Stack<>();
		stack.add(type);
		while (!stack.isEmpty()) {
			TAbstractType nextType = stack.pop();
			types.add(nextType);
			if (nextType instanceof TClass) {
				TClass tClass = (TClass) nextType;
				TClass parentClass = tClass.getParentClass();
				if (parentClass != null) {
					stack.add(parentClass);
				}
				stack.addAll(tClass.getImplements());
			} else if (nextType instanceof TInterface) {
				stack.addAll(((TInterface) nextType).getParentInterfaces());
			}
		}
		return types;
	}

	/**
	 * Search methods in the pm corresponding to the node and create correspondences
	 * for them
	 * 
	 * @param asset The node for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Method2Element> mapToMethod(Element element) {
		ArrayList<Method2Element> list = new ArrayList<Method2Element>();
		for (TMethod method : methods) {
			int rank = StringCompare.compare(element.getName(), method.getTName());
			if (rank > 0 && helper.canCreate(method, element)) {
				Method2Element corr = helper.createCorrespondence(method, element, rank);
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
	private Stream<Type2NamedEntity> mapToType(Asset asset) {
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		switch (asset.getType()) {
		case NUMBER:
		case VECTOR:
		case OBJECT:
			return mapToType((NamedEntity) asset);
		case STRING:
			TAbstractType string = pm.getAbstractType("java.lang.String");
			if (helper.canCreate(string, asset)) {
				Type2NamedEntity corr = helper.createCorrespondence(string, asset, 100);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		}
		return list.stream();
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param entity The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2NamedEntity> mapToType(NamedEntity entity) {
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		for (TAbstractType type : types) {
			int rank = StringCompare.compare(entity.getName(), type.getTName());
			if (rank > 0 && helper.canCreate(type, entity)) {
				Type2NamedEntity corr = helper.createCorrespondence(type, entity, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
		}
		return list.stream();
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
	public IFile getFile() {
		return destination;
	}

}
