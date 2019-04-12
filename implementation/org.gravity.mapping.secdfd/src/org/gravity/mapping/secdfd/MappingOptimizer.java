package org.gravity.mapping.secdfd;

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
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TConstructorDefinition;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import com.google.common.collect.Streams;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;
import eDFDFlowTracking.Process;

public class MappingOptimizer {

	private static final Logger LOGGER = Logger.getLogger(MappingOptimizer.class);

	private final CorrespondenceHelper helper;
	private final MappingCache cache;
	private final Mapping mapping;

	public MappingOptimizer(CorrespondenceHelper helper, MappingCache cache, Mapping mapping) {
		this.helper = helper;
		this.cache = cache;
		this.mapping = mapping;
	}

	/**
	 * Optimizes the mapping and returns the optimized mapping
	 * 
	 * @return The optimized mapping
	 */
	public Mapping optimize() {
		return optimize(new HashMap<>());
	}

	private Mapping optimize(Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		LOGGER.log(Level.INFO, "\nStart optimization >>>>>\n");
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		HashMap<Element, Set<TMember>> elementMemberMapping = cache.getElementMemberMapping();
		HashMap<Element, Set<TSignature>> elementSignatureMapping = cache.getElementSignatureMapping();

		for (Entry<NamedEntity, Set<TAbstractType>> entry : entityTypeMapping.entrySet()) {
			if (entry.getKey() instanceof Element) {
				Element element = (Element) entry.getKey();
				Set<TMember> collect = mapToMembers(element, entry.getValue(), entityTypeMapping, excludes)
						.map(corr -> corr.getSource()).collect(Collectors.toSet());
				elementMemberMapping.put(element, collect);
				change |= !collect.isEmpty();
			}
		}

		for (Entry<Element, Set<TMethod>> entry : cache.getElementMethodMapping().entrySet()) {
			Element node = entry.getKey();
			Set<TSignature> collect = mapToSignature(node, entry.getValue(), entityTypeMapping, excludes)
					.map(corr -> corr.getSource()).collect(Collectors.toSet());
			cache.addAllSignatures(collect, node);
			change |= !collect.isEmpty();
		}

		for (Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
			Element mappedElement = entry.getKey();
			for (TSignature mappedSignature : entry.getValue()) {
				change |= mapToParamFlow(mappedElement, mappedSignature, excludes);
				change |= mapToReturnFlow(mappedElement, mappedSignature, excludes);
				for (TSignature calledSignature : entry.getValue()) {
					if (mappedElement instanceof Process) {
						change |= mapIntraProcessFlow((Process) mappedElement, calledSignature,
								(TMethodSignature) mappedSignature, excludes);
					}

				}
			}
		}

		EDFD dfd = (EDFD) mapping.getTarget();
		Set<NamedEntity> unmapped = dfd.getAsset().parallelStream()
				.filter(asset -> !entityTypeMapping.containsKey(asset) || entityTypeMapping.get(asset).isEmpty())
				.collect(Collectors.toSet());

		for (Element element : dfd.getElements()) {
			if (element instanceof Process) {
				for (Asset asset : element.getAssets()) {
					if (unmapped.contains(asset) && elementMemberMapping.containsKey(element)) {
						change |= mapToFieldsInProcess((Process) element, asset, excludes);
					}
				}
			} else if (element instanceof DataStore) {
				Stream<Element> targetStream = element.getOutflows().parallelStream()
						.flatMap(flow -> flow.getTarget().parallelStream());
				Stream<Element> sourceStream = element.getInflows().parallelStream().map(flow -> flow.getSource());
				for (Process process : Streams.concat(targetStream, sourceStream).filter(e -> e instanceof Process)
						.map(e -> (Process) e).collect(Collectors.toSet())) {
					change |= mapToFieldsInProcess(process, element, excludes);
				}
			}
		}

		findForwardedFlows(dfd, excludes);

		removeDefinitionsWithoutCouplingToProcess(excludes);
		removeUnusedAssetMappings(dfd, excludes);

		if (change) {
			optimize(excludes);
		}
		LOGGER.log(Level.INFO, "\n<<<<< Stop optimization\n");
		return mapping;
	}

	/**
	 * Search definitions which don't have coupling with the other definitions
	 * mapped to the same process and remove the mapping
	 * 
	 * @param excludes
	 */
	private void removeDefinitionsWithoutCouplingToProcess(Map<EObject, Set<EObject>> excludes) {
		for (Entry<Element, Set<TMember>> entry : cache.getElementMemberMapping().entrySet()) {
			Set<TMember> values = entry.getValue();
			if (values.size() < 3) {
				continue;
			}
			Collection<AbstractCorrespondence> remove = new LinkedList<>();
			for (TMember member : values) {
				if (member.getDefinedBy() instanceof TInterface) {
					continue;
				}
				int coupling = 0;
				for (TAccess access : member.getAccessedBy()) {
					if (values.contains(access.getTSource())) {
						coupling++;
					}
				}
				for (TAccess access : member.getTAccessing()) {
					if (values.contains(access.getTTarget())) {
						coupling++;
					}
				}
				if (coupling == 0) {
					remove.add(helper.getCorrespondence(member, entry.getKey()));
				}
			}
			remove.forEach(corr -> {
				EObject key = CorrespondenceHelper.getTarget(corr);
				Set<EObject> set;
				if (excludes.containsKey(key)) {
					set = excludes.get(key);
				} else {
					set = new HashSet<>();
					excludes.put(key, set);
				}
				set.add(CorrespondenceHelper.getSource(corr));
				helper.delete(corr);
			});
		}
	}

	/**
	 * Se4arch for asset mappings not used in mapped definitions and remove them
	 * 
	 * @param dfd      The DFD which has been mapped
	 * @param excludes
	 */
	private void removeUnusedAssetMappings(EDFD dfd, Map<EObject, Set<EObject>> excludes) {
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		HashMap<Element, Set<TMember>> elementMemberMapping = cache.getElementMemberMapping();
		Set<AbstractCorrespondence> assetsToRemove = dfd.getAsset().parallelStream()
				.flatMap(asset -> helper.getCorrespondences(asset).parallelStream()).collect(Collectors.toSet());
		for (Entry<Element, Set<TMember>> entry : elementMemberMapping.entrySet()) {
			Set<Asset> assets = Streams.concat(
					entry.getKey().getOutflows().parallelStream().flatMap(flow -> flow.getAssets().parallelStream()),
					entry.getKey().getInflows().parallelStream().flatMap(flow -> flow.getAssets().parallelStream()),
					entry.getKey().getAssets().parallelStream()).collect(Collectors.toSet());
			Set<TAbstractType> assetTypes = new HashSet<>();
			Set<TMember> values = entry.getValue();
			for (TMember member : values) {
				TSignature signature = member.getSignature();
				if (signature instanceof TFieldSignature) {
					TAbstractType fieldType = ((TFieldSignature) signature).getType();
					Set<TAbstractType> allChildClasses = getAllChildClasses(fieldType);
					assetTypes.addAll(allChildClasses);
				} else if (signature instanceof TMethodSignature) {
					TMethodSignature tMethodSignature = (TMethodSignature) signature;
					TAbstractType returnType = tMethodSignature.getReturnType();
					assetTypes.addAll(getAllParents(returnType));
					for (TParameter param : tMethodSignature.getParamList().getEntries()) {
						TAbstractType paramType = param.getType();
						assetTypes.addAll(getAllChildClasses(paramType));
					}
				}
			}
			for (Asset asset : assets) {
				if (entityTypeMapping.containsKey(asset)) {
					Set<TAbstractType> correspondingTypes = entityTypeMapping.get(asset);
					for (TAbstractType type : assetTypes) {
						if (correspondingTypes.contains(type)) {
							assetsToRemove.remove(helper.getCorrespondence(type, asset));
							continue;
						}
					}
				}
			}
		}
		assetsToRemove.forEach(corr -> {
			EObject key = CorrespondenceHelper.getTarget(corr);
			Set<EObject> set;
			if (excludes.containsKey(key)) {
				set = excludes.get(key);
			} else {
				set = new HashSet<>();
				excludes.put(key, set);
			}
			set.add(CorrespondenceHelper.getSource(corr));
			helper.delete(corr);
		});
	}

	/**
	 * Finds cases where the return value of a member is forwarded to an other
	 * member
	 * 
	 * @param dfd      The dfd to analyze
	 * @param excludes
	 * @return if there was a change
	 */
	private boolean findForwardedFlows(EDFD dfd, Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		HashMap<Element, Set<TSignature>> elementSignatureMapping = cache.getElementSignatureMapping();
		for (Element sourceElement : dfd.getElements()) {
			if (!elementSignatureMapping.containsKey(sourceElement)) {
				continue;
			}
			for (Flow flow : sourceElement.getOutflows()) {
				Set<TAbstractType> assets = flow.getAssets().parallelStream()
						.filter(asset -> entityTypeMapping.containsKey(asset))
						.flatMap(asset -> entityTypeMapping.get(asset).parallelStream()).collect(Collectors.toSet());

				for (TSignature sourceSignature : elementSignatureMapping.get(sourceElement)) {
					// Only continue for relevant source members (return or field type fits to asset
					// on flow)
					List<? extends TMember> sourceMembers;
					TAbstractType assetType;
					if (sourceSignature instanceof TMethodSignature) {
						TMethodSignature tMethodSignature = (TMethodSignature) sourceSignature;
						assetType = tMethodSignature.getReturnType();
						if (assets.contains(assetType)) {
							sourceMembers = tMethodSignature.getDefinitions();
						} else {
							continue;
						}
					} else if (sourceSignature instanceof TFieldSignature) {
						TFieldSignature tFieldSignature = (TFieldSignature) sourceSignature;
						assetType = tFieldSignature.getType();
						if (assets.contains(assetType)) {
							sourceMembers = tFieldSignature.getDefinitions();
						} else {
							continue;
						}
					} else {
						continue;
					}
					for (Element targetElement : flow.getTarget()) {
						if (!elementSignatureMapping.containsKey(targetElement)) {
							continue;
						}
						// Select all targets with field type or one parameter type fitting to the asset
						// on the flow
						Set<TSignature> targetSignatures = elementSignatureMapping.get(targetElement).parallelStream()
								.filter(sig -> {
									if (sig instanceof TFieldSignature) {
										return assetType.equals(((TFieldSignature) sig).getType());
									}
									if (sig instanceof TMethodSignature) {
										for (TParameter param : ((TMethodSignature) sig).getParamList().getEntries()) {
											if (assetType.equals(param.getType())) {
												return true;
											}
										}
									}
									return false;
								}).collect(Collectors.toSet());
						for (TMember sourceMember : sourceMembers) {
							for (TMember accessor : sourceMember.getAccessedBy().parallelStream()
									.map(access -> access.getTSource()).collect(Collectors.toSet())) {
								Set<TMember> targetMembers = accessor.getTAccessing().parallelStream()
										.map(access -> access.getTTarget())
										.filter(target -> targetSignatures.contains(target.getSignature()))
										.collect(Collectors.toSet());
								if (targetMembers.size() > 0 && sourceMember instanceof TMethodDefinition) {
									if (helper.canCreate(sourceMember, targetElement, excludes)
											&& sourceMember instanceof TMethodDefinition) {
										MappingProcessDefinition corr = helper.createCorrespondence(
												(TMethodDefinition) sourceMember, sourceElement, 50,
												Collections.emptySet());
										mapping.getSuggested().add(corr);
										cache.add(sourceMember, sourceElement);
										change = true;
									}
								}
								for (TMember targetMember : targetMembers) {
									if (helper.canCreate(targetMember, targetElement, excludes)
											&& targetMember instanceof TMethodDefinition) {
										MappingProcessDefinition corr = helper.createCorrespondence(
												(TMethodDefinition) targetMember, targetElement, 50,
												Collections.emptySet());
										mapping.getSuggested().add(corr);
										cache.add(targetMember, targetElement);
										change = true;
									}
								}
							}
						}
					}
				}
			}
		}
		return change;
	}

	/**
	 * @param process
	 * @param entity
	 * @param excludes
	 * @return
	 */
	private boolean mapToFieldsInProcess(Process process, NamedEntity entity, Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		for (TMember member : cache.getElementMemberMapping().get(process)) {
			for (TFieldDefinition field : member.getTAccessing().parallelStream().map(access -> access.getTTarget())
					.filter(definition -> definition instanceof TFieldDefinition)
					.map(definition -> (TFieldDefinition) definition).collect(Collectors.toSet())) {
				String fieldName = field.getSignature().getField().getTName();
				int result = StringCompare.compare(fieldName, entity.getName());
				if (result > 0) {
					TAbstractType fieldType = field.getSignature().getType();
					if (helper.canCreate(fieldType, entity, excludes)) {
						MappingEntityType corr = helper.createCorrespondence(fieldType, entity, 50);
						mapping.getSuggested().add(corr);
						cache.add(fieldType, entity);
						change = true;
					}
				}
			}
		}
		return change;
	}

	/**
	 * @param process
	 * @param calledSignature
	 * @param callingSignature
	 * @param excludes
	 * @return
	 */
	private boolean mapIntraProcessFlow(Process process, TSignature calledSignature, TMethodSignature callingSignature,
			Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		if (callingSignature != calledSignature) {
			for (TMethodDefinition callingDefiniton : callingSignature.getDefinitions()) {
				for (TAccess access : callingDefiniton.getTAccessing()) {
					TMember calledDefinition = access.getTTarget();
					if (calledDefinition.getSignature().equals(calledSignature)) {
						if (helper.canCreate(callingDefiniton, process, excludes)) {
							MappingProcessDefinition corr = helper.createCorrespondence(callingDefiniton, process, 60,
									Collections.emptyList());
							mapping.getSuggested().add(corr);
							cache.add(callingDefiniton, process);
							change = true;
						}
						if (helper.canCreate(calledDefinition, process, excludes)) {
							TMethodDefinition calledMethodDefinition = (TMethodDefinition) calledDefinition;
							MappingProcessDefinition corr = helper.createCorrespondence(calledMethodDefinition, process,
									60, Collections.emptyList());
							mapping.getSuggested().add(corr);
							cache.add(calledDefinition, process);
							change = true;
						}
					}
				}
			}
		}
		return change;
	}

	/**
	 * Map return flow in the pm to asset flow in the DFD
	 * 
	 * @param sourceOfFlow    The source of a flow in the DFD
	 * @param calledSignature A signature corresponding with the DFD element
	 * @param excludes
	 * @return
	 */
	private boolean mapToReturnFlow(Element sourceOfFlow, TSignature calledSignature,
			Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		TAbstractType returnType = ((TMethodSignature) calledSignature).getReturnType();
		for (Flow flow : sourceOfFlow.getOutflows()) {
			Map<TAbstractType, Asset> compatible = new HashMap<>();
			for (Asset asset : flow.getAssets()) {
				if (entityTypeMapping.containsKey(asset)) {
					Set<TAbstractType> types = entityTypeMapping.get(asset).stream()
							.flatMap(type -> getAllParents(type).stream()).collect(Collectors.toSet());
					if (types.contains(returnType)) {
						compatible.put(returnType, asset);
					}
				}
			}
			boolean compatibleReturnType = !compatible.isEmpty();

			if (compatibleReturnType) {
				for (Element targetElement : flow.getTarget()) {
					Set<TSignature> callingSignatures = helper.getCorrespondences(targetElement).stream()
							.filter(corr -> corr instanceof MappingProcessSignature)
							.map(corr -> (TSignature) CorrespondenceHelper.getSource(corr)).collect(Collectors.toSet());

					for (TMethodDefinition calledDefinition : ((TMethodSignature) calledSignature).getDefinitions()) {
						for (TAccess access : calledDefinition.getAccessedBy()) {
							TMember callingDefiniton = access.getTSource();
							TSignature callingSignature = callingDefiniton.getSignature();
							if (callingSignatures.contains(callingSignature)) {
								if (helper.canCreate(calledDefinition, sourceOfFlow, excludes)) {
									AbstractMappingBase returnCorr = (AbstractMappingBase) helper
											.getCorrespondence(returnType, compatible.get(returnType));
									helper.createCorrespondence(calledDefinition, sourceOfFlow, 80,
											Collections.singleton(returnCorr));
									cache.add(calledDefinition, sourceOfFlow);
									change = true;
								}
								if (helper.canCreate(callingDefiniton, targetElement, excludes)) {
									AbstractMappingBase returnCorr = (AbstractMappingBase) helper
											.getCorrespondence(returnType, compatible.get(returnType));
									helper.createCorrespondence((TMethodDefinition) callingDefiniton, targetElement, 80,
											Collections.singleton(returnCorr));
									cache.add(callingDefiniton, targetElement);
									change = true;
								}
							}
						}
					}
				}
			}
		}
		return change;
	}

	private Set<TAbstractType> getAllParents(TAbstractType type) {
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

	private Set<TAbstractType> getAllChildClasses(TAbstractType type) {
		Set<TAbstractType> types = new HashSet<>();
		types.add(type);
		Stack<TAbstractType> stack = new Stack<>();
		stack.add(type);
		while (!stack.isEmpty()) {
			TAbstractType nextType = stack.pop();
			types.add(nextType);
			if (nextType instanceof TClass) {
				stack.addAll(((TClass) nextType).getChildClasses());
			} else if (nextType instanceof TInterface) {
				stack.addAll(((TInterface) nextType).getChildInterfaces());
			}
		}
		return types;
	}

	/**
	 * Search a path from the source to the target of a flow
	 * 
	 * @param sourceElement
	 * @param sourceSignature
	 * @param excludes
	 */
	private boolean mapToParamFlow(Element sourceElement, TSignature sourceSignature,
			Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		for (Flow flow : sourceElement.getOutflows()) {
			for (Element targetElement : flow.getTarget()) {
				if (cache.getElementSignatureMapping().containsKey(targetElement)) {
					for (TSignature targetSignature : cache.getElementSignatureMapping().get(targetElement)) {
						for (TMethodDefinition sourceDefinition : ((TMethodSignature) sourceSignature)
								.getDefinitions()) {
							Set<TMember> targets = getPath(sourceDefinition, targetSignature);
							if (!targets.isEmpty()) {
								if (helper.canCreate(sourceDefinition, sourceElement, excludes)) {
									Defintion2Element sourceCorr = helper.createCorrespondence(sourceDefinition,
											sourceElement, 90, Collections.emptyList());
									mapping.getCorrespondences().add(sourceCorr);
									mapping.getSuggested().add(sourceCorr);
									cache.add(sourceDefinition, sourceElement);
									change = true;
								}
								for (TMember targetDefinition : targets) {
									if (helper.canCreate(targetDefinition, targetElement, excludes)) {
										Defintion2Element corr = helper.createCorrespondence(
												(TMethodDefinition) targetDefinition, targetElement, 90,
												Collections.emptyList());
										mapping.getCorrespondences().add(corr);
										mapping.getSuggested().add(corr);
										cache.add(targetDefinition, targetElement);
										change = true;
									}
								}
							}
						}
					}
				}
			}
		}
		return change;
	}

	/**
	 * Searches if there is a path form the source definitions to a definition
	 * implementing the target signature
	 * 
	 * @param source The source definition
	 * @param target The target signature
	 * @return the reached definitions implementing the signature;
	 */
	private Set<TMember> getPath(TMethodDefinition source, TSignature target) {
		Set<TMember> reachedTargets = new HashSet<>();
		Set<TMember> seen = new HashSet<>();
		List<TMember> stack = new LinkedList<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			TMember current = stack.remove(0);
			for (TAccess access : current.getTAccessing()) {
				TMember tTarget = access.getTTarget();
				if (!seen.contains(tTarget)) {
					stack.add(tTarget);
					if (tTarget.getSignature().equals(target)) {
						reachedTargets.add(tTarget);
					}
				}
			}
			seen.add(current);
		}

		return reachedTargets;
	}

	/**
	 * Takes a set of mapped method names and type mappings for finding a
	 * corresponding signatures.
	 * 
	 * @param node                 The element which should be mapped
	 * @param correspondingMethods The method names corresponding to the element
	 * @param mapping              A mapping between assets and types
	 * @param excludes
	 * @return
	 */
	private Stream<MappingProcessSignature> mapToSignature(Element node, Set<TMethod> correspondingMethods,
			HashMap<NamedEntity, Set<TAbstractType>> mapping, Map<EObject, Set<EObject>> excludes) {
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
			for (Entry<Asset, Set<TAbstractType>> entry : paramTypes.entrySet()) {
				Set<TAbstractType> expectedAssetTypes = entry.getValue();
				if (expectedAssetTypes.contains(signature.getReturnType())) {
					matchedAssets.put(entry.getKey(), signature.getReturnType());
				}
				for (TParameter param : signature.getParamList().getEntries()) {
					if (expectedAssetTypes.contains(param.getType())) {
						matchedAssets.put(entry.getKey(), param.getType());
					}

				}
			}
			if (matchedAssets.size() == 0) {
				return null;
			}
			MappingProcessSignature newCorr = null;
			if (helper.canCreate(signature, node, excludes)) {
				Collection<AbstractMappingBase> derived = matchedAssets.entrySet().parallelStream()
						.map(entry -> (AbstractMappingBase) helper.getCorrespondence(entry.getValue(), entry.getKey()))
						.collect(Collectors.toSet());
				newCorr = helper.createCorrespondence(signature, node, 80, derived);
				this.mapping.getSuggested().add(newCorr);
			}
			return newCorr;
		}).filter(Objects::nonNull);
	}

	private Stream<Defintion2Element> mapToMembers(Element element, Set<TAbstractType> typescorrespondingToElement,
			HashMap<NamedEntity, Set<TAbstractType>> typeMapping, Map<EObject, Set<EObject>> excludes) {
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
									&& helper.canCreate(member, element, excludes)) {
								Defintion2Element corr = helper.createCorrespondence((TMethodDefinition) member,
										element, 90, Collections.emptyList());
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
}
