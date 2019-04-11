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
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
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
		MappingLabelProvider.Logging.logging();

		boolean change = false;
		LOGGER.log(Level.INFO, "\nStart optimization >>>>>\n");
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		HashMap<Element, Set<TMember>> elementMemberMapping = cache.getElementMemberMapping();
		HashMap<Element, Set<TSignature>> elementSignatureMapping = cache.getElementSignatureMapping();

		for (Entry<NamedEntity, Set<TAbstractType>> entry : entityTypeMapping.entrySet()) {
			if (entry.getKey() instanceof Element) {
				Element element = (Element) entry.getKey();
				Set<TMember> collect = mapToMembers(element, entry.getValue(), entityTypeMapping)
						.map(corr -> corr.getSource()).collect(Collectors.toSet());
				elementMemberMapping.put(element, collect);
				change |= !collect.isEmpty();
			}
		}

		for (Entry<Element, Set<TMethod>> entry : cache.getElementMethodMapping().entrySet()) {
			Element node = entry.getKey();
			Set<TSignature> collect = mapToSignature(node, entry.getValue(), entityTypeMapping)
					.map(corr -> corr.getSource()).collect(Collectors.toSet());
			cache.addAllSignatures(collect, node);
			change |= !collect.isEmpty();
		}

		for (Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
			Element mappedElement = entry.getKey();
			for (TSignature mappedSignature : entry.getValue()) {
				change |= mapToParamFlow(mappedElement, mappedSignature);
				change |= mapToReturnFlow(mappedElement, mappedSignature);
				for (TSignature calledSignature : entry.getValue()) {
					change |= mapIntraProcessFlow((Process) mappedElement, calledSignature,
							(TMethodSignature) mappedSignature);
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
						change |= mapToFieldsInProcess((Process) element, asset);
					}
				}
			} else if (element instanceof DataStore) {
				Stream<Element> targetStream = element.getOutflows().parallelStream()
						.flatMap(flow -> flow.getTarget().parallelStream());
				Stream<Element> sourceStream = element.getInflows().parallelStream().map(flow -> flow.getSource());
				for (Process process : Streams.concat(targetStream, sourceStream).filter(e -> e instanceof Process)
						.map(e -> (Process) e).collect(Collectors.toSet())) {
					change |= mapToFieldsInProcess(process, element);
				}
			}
		}

		findForwardedFlows(dfd);

		if (change) {
			optimize();
		}
		LOGGER.log(Level.INFO, "\n<<<<< Stop optimization\n");
		return mapping;
	}

	/**
	 * Finds cases where the return value of a member is forwarded to an other member
	 * 
	 * @param dfd The dfd to analyze
	 * @return if there was a change
	 */
	private boolean findForwardedFlows(EDFD dfd) {
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
					// Only continue for relevant source members (return or field type fits to asset on flow)
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
						// Select all targets with field type or one parameter type fitting to the asset on the flow
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
									if (helper.canCreate(sourceMember, targetElement)
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
									if (helper.canCreate(targetMember, targetElement)
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
	 * @return
	 */
	private boolean mapToFieldsInProcess(Process process, NamedEntity entity) {
		boolean change = false;
		for (TMember member : cache.getElementMemberMapping().get(process)) {
			for (TFieldDefinition field : member.getTAccessing().parallelStream().map(access -> access.getTTarget())
					.filter(definition -> definition instanceof TFieldDefinition)
					.map(definition -> (TFieldDefinition) definition).collect(Collectors.toSet())) {
				String fieldName = field.getSignature().getField().getTName();
				int result = StringCompare.compare(fieldName, entity.getName());
				if (result > 0) {
					TAbstractType fieldType = field.getSignature().getType();
					if (helper.canCreate(fieldType, entity)) {
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
	 * @return
	 */
	private boolean mapIntraProcessFlow(Process process, TSignature calledSignature,
			TMethodSignature callingSignature) {
		boolean change = false;
		if (callingSignature != calledSignature) {
			for (TMethodDefinition callingDefiniton : callingSignature.getDefinitions()) {
				for (TAccess access : callingDefiniton.getTAccessing()) {
					TMember calledDefinition = access.getTTarget();
					if (calledDefinition.getSignature().equals(calledSignature)) {
						if (helper.canCreate(callingDefiniton, process)) {
							MappingProcessDefinition corr = helper.createCorrespondence(callingDefiniton, process, 60,
									Collections.emptyList());
							mapping.getSuggested().add(corr);
							cache.add(callingDefiniton, process);
							change = true;
						}
						if (helper.canCreate(calledDefinition, process)) {
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
	 * @return
	 */
	private boolean mapToReturnFlow(Element sourceOfFlow, TSignature calledSignature) {
		boolean change = false;
		HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();
		TAbstractType returnType = ((TMethodSignature) calledSignature).getReturnType();
		for (Flow flow : sourceOfFlow.getOutflows()) {
			Map<TAbstractType, Asset> compatible = new HashMap<>();
			for (Asset asset : flow.getAssets()) {
				if (entityTypeMapping.containsKey(asset)) {
					Set<TAbstractType> types = entityTypeMapping.get(asset).stream()
							.flatMap(type -> getAllCompatibleTypes(type).stream()).collect(Collectors.toSet());
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
								if (helper.canCreate(calledDefinition, sourceOfFlow)) {
									AbstractMappingBase returnCorr = (AbstractMappingBase) helper
											.getCorrespondence(returnType, compatible.get(returnType));
									helper.createCorrespondence(calledDefinition, sourceOfFlow, 80,
											Collections.singleton(returnCorr));
									cache.add(calledDefinition, sourceOfFlow);
									change = true;
								}
								if (helper.canCreate(callingDefiniton, targetElement)) {
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
	 * Search a path from the source to the target of a flow
	 * 
	 * @param sourceElement
	 * @param sourceSignature
	 */
	private boolean mapToParamFlow(Element sourceElement, TSignature sourceSignature) {
		boolean change = false;
		for (Flow flow : sourceElement.getOutflows()) {
			for (Element targetElement : flow.getTarget()) {
				if (cache.getElementSignatureMapping().containsKey(targetElement)) {
					for (TSignature targetSignature : cache.getElementSignatureMapping().get(targetElement)) {
						for (TMethodDefinition sourceDefinition : ((TMethodSignature) sourceSignature)
								.getDefinitions()) {
							Set<TMember> targets = getPath(sourceDefinition, targetSignature);
							if (!targets.isEmpty()) {
								if (helper.canCreate(sourceDefinition, sourceElement)) {
									Defintion2Element sourceCorr = helper.createCorrespondence(sourceDefinition,
											sourceElement, 90, Collections.emptyList());
									mapping.getCorrespondences().add(sourceCorr);
									mapping.getSuggested().add(sourceCorr);
									cache.add(sourceDefinition, sourceElement);
									change = true;
								}
								for (TMember targetDefinition : targets) {
									if (helper.canCreate(targetDefinition, targetElement)) {
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
