package org.gravity.mapping.secdfd.mapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.Defintion2Element;
import org.gravity.mapping.secdfd.StringCompare;
import org.gravity.mapping.secdfd.helpers.CallHelper;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.helpers.RankingHelper;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TConstructor;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.Flow;
import org.secdfd.model.NamedEntity;
import org.secdfd.model.Process;

import com.google.common.collect.Streams;

public class MappingOptimizer {

	private static final Logger LOGGER = Logger.getLogger(MappingOptimizer.class);

	private final CorrespondenceManager helper;
	private final MappingCache cache;
	private final Mapping mapping;

	public MappingOptimizer(final CorrespondenceManager helper, final MappingCache cache, final Mapping mapping) {
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

	private Mapping optimize(final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		LOGGER.log(Level.INFO, "\nStart optimization >>>>>\n");
		final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = this.cache.getEntityTypeMapping();
		final Map<Element, Set<TMember>> elementMemberMapping = this.cache.getElementMemberMapping();
		final Map<Element, Set<TSignature>> elementSignatureMapping = this.cache.getElementSignatureMapping();

		for (final Entry<NamedEntity, Set<TAbstractType>> entry : entityTypeMapping.entrySet()) {
			if (entry.getKey() instanceof Element) {
				final Element element = (Element) entry.getKey();
				final Set<TMember> collect = mapToMembers(element, entry.getValue(), entityTypeMapping, excludes)
						.map(Defintion2Element::getSource).collect(Collectors.toSet());
				elementMemberMapping.put(element, collect);
				change |= !collect.isEmpty();
			}
		}

		for (final Entry<Element, Set<TMethod>> entry : this.cache.getElementMethodMapping().entrySet()) {
			final Element node = entry.getKey();
			final Set<TSignature> collect = mapToSignature(node, entry.getValue(), entityTypeMapping, excludes)
					.map(MappingProcessSignature::getSource).collect(Collectors.toSet());
			this.cache.addAllSignatures(collect, node);
			change |= !collect.isEmpty();
		}

		for (final Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
			final Element mappedElement = entry.getKey();
			for (final TSignature mappedSignature : entry.getValue()) {
				change |= mapToParamFlow(mappedElement, mappedSignature, excludes);
				change |= mapToReturnFlow(mappedElement, mappedSignature, excludes);
				for (final TSignature calledSignature : entry.getValue()) {
					if (mappedElement instanceof Process) {
						change |= mapIntraProcessFlow((Process) mappedElement, calledSignature,
								(TMethodSignature) mappedSignature, excludes);
					}

				}
			}
		}

		final EDFD dfd = (EDFD) this.mapping.getTarget();
		final Set<NamedEntity> unmapped = dfd.getAsset().parallelStream()
				.filter(asset -> !entityTypeMapping.containsKey(asset) || entityTypeMapping.get(asset).isEmpty())
				.collect(Collectors.toSet());

		for (final Element element : dfd.getElements()) {
			if (element instanceof Process) {
				for (final Asset asset : element.getAssets()) {
					if (unmapped.contains(asset) && elementMemberMapping.containsKey(element)) {
						change |= mapToFieldsInProcess((Process) element, asset, excludes);
					}
				}
			} else if (element instanceof DataStore) {
				final Stream<Element> targetStream = element.getOutflows().parallelStream()
						.flatMap(flow -> flow.getTarget().parallelStream());
				final Stream<Element> sourceStream = element.getInflows().parallelStream().map(Flow::getSource);
				for (final Process process : Streams.concat(targetStream, sourceStream).filter(e -> e instanceof Process)
						.map(e -> (Process) e).collect(Collectors.toSet())) {
					change |= mapToFieldsInProcess(process, element, excludes);
				}
			}
		}

		findForwardedFlows(dfd, excludes);

		for (final Element element : dfd.getElements()) {
			if (!elementMemberMapping.containsKey(element) && elementSignatureMapping.containsKey(element)) {
				final Set<TSignature> signatures = elementSignatureMapping.get(element);
				if (signatures.size() == 1) {
					final TMethodSignature sig = (TMethodSignature) signatures.iterator().next();
					final MappingProcessName nameCorr = (MappingProcessName) this.helper.getCorrespondence(sig.getMethod(),
							element);
					if (nameCorr.getRanking() > 70) {
						final EList<TMethodDefinition> defs = sig.getMethodDefinitions();
						if (defs.size() < 3) {
							defs.forEach(def -> {
								if (this.helper.canCreate(def, element, excludes)) {
									final MappingProcessDefinition corr = this.helper.createCorrespondence(def, element, 70,
											Collections.emptyList());
									this.mapping.getSuggested().add(corr);
								}
							});
						}
					}
				}
			}
		}

		//		removeDefinitionsWithoutCouplingToProcess(excludes);
		//		removeUnusedAssetMappings(dfd, excludes);
		if (change) {
			optimize(excludes);
		}
		LOGGER.log(Level.INFO, "\n<<<<< Stop optimization\n");
		return this.mapping;
	}

	/**
	 * @param values
	 */
	private void removeBasedOnRanking(final List<AbstractCorrespondence> values) {
		final List<Integer> ranks = values.parallelStream().map(RankingHelper::getRanking).distinct().sorted()
				.collect(Collectors.toList());
		final int median = ranks.get(ranks.size() / 2);
		final List<AbstractCorrespondence> remove = values.parallelStream()
				.filter(o -> RankingHelper.getRanking(o) < median)
				.collect(Collectors.toList());
		for (int i = 0; i < remove.size(); i++) {
			this.helper.delete(remove.remove(0));
		}
	}

	/**
	 * Search definitions which don't have coupling with the other definitions
	 * mapped to the same process and remove the mapping
	 *
	 * @param excludes
	 */
	private void removeDefinitionsWithoutCouplingToProcess(final Map<EObject, Set<EObject>> excludes) {
		for (final Entry<Element, Set<TMember>> entry : this.cache.getElementMemberMapping().entrySet()) {
			final Set<TMember> values = entry.getValue();
			if (values.size() < 3) {
				continue;
			}
			final Collection<AbstractCorrespondence> remove = new LinkedList<>();
			for (final TMember member : values) {
				if (member.getDefinedBy() instanceof TInterface) {
					continue;
				}
				int coupling = 0;
				for (final TMember access : CallHelper.getAllInCalls(member)) {
					if (values.contains(access)) {
						coupling++;
					}
				}
				for (final TMember access : CallHelper.getAllOutCalls(member)) {
					if (values.contains(access)) {
						coupling++;
					}
				}
				if (coupling == 0) {
					remove.add(this.helper.getCorrespondence(member, entry.getKey()));
				}
			}
			remove.forEach(corr -> {
				if (this.mapping.getUserdefined().contains(corr) || this.mapping.getAccepted().contains(corr)) {
					return;
				}
				if ((corr instanceof AbstractMappingRanking) && (((AbstractMappingRanking) corr).getRanking() > 70)) {
					// Don't remove high quality mappings
					return;
				}
				final EObject key = CorrespondenceHelper.getTarget(corr);
				Set<EObject> set;
				if (excludes.containsKey(key)) {
					set = excludes.get(key);
				} else {
					set = new HashSet<>();
					excludes.put(key, set);
				}
				set.add(CorrespondenceHelper.getSource(corr));
				this.helper.delete(corr);
			});
		}
	}

	/**
	 * Se4arch for asset mappings not used in mapped definitions and remove them
	 *
	 * @param dfd      The DFD which has been mapped
	 * @param excludes
	 */
	private void removeUnusedAssetMappings(final EDFD dfd, final Map<EObject, Set<EObject>> excludes) {
		final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = this.cache.getEntityTypeMapping();
		final Map<Element, Set<TMember>> elementMemberMapping = this.cache.getElementMemberMapping();
		final Set<AbstractCorrespondence> assetsToRemove = dfd.getAsset().parallelStream()
				.flatMap(asset -> this.helper.getCorrespondences(asset).parallelStream()).collect(Collectors.toSet());
		for (final Entry<Element, Set<TMember>> entry : elementMemberMapping.entrySet()) {
			final Set<Asset> assets = Streams.concat(
					entry.getKey().getOutflows().parallelStream().flatMap(flow -> flow.getAssets().parallelStream()),
					entry.getKey().getInflows().parallelStream().flatMap(flow -> flow.getAssets().parallelStream()),
					entry.getKey().getAssets().parallelStream()).collect(Collectors.toSet());
			final Set<TAbstractType> assetTypes = new HashSet<>();
			final Set<TMember> values = entry.getValue();
			for (final TMember member : values) {
				final TSignature signature = member.getSignature();
				if (signature instanceof TFieldSignature) {
					final TAbstractType fieldType = ((TFieldSignature) signature).getType();
					final Set<TAbstractType> allChildClasses = getAllChildClasses(fieldType);
					assetTypes.addAll(allChildClasses);
				} else if (signature instanceof TMethodSignature) {
					final TMethodSignature tMethodSignature = (TMethodSignature) signature;
					final TAbstractType returnType = tMethodSignature.getReturnType();
					assetTypes.addAll(getAllParents(returnType));
					for (final TParameter param : tMethodSignature.getParameters()) {
						final TAbstractType paramType = param.getType();
						assetTypes.addAll(getAllChildClasses(paramType));
					}
				}
			}
			for (final Asset asset : assets) {
				if (entityTypeMapping.containsKey(asset)) {
					final Set<TAbstractType> correspondingTypes = entityTypeMapping.get(asset);
					for (final TAbstractType type : assetTypes) {
						if (correspondingTypes.contains(type)) {
							assetsToRemove.remove(this.helper.getCorrespondence(type, asset));
							continue;
						}
					}
				}
			}
		}
		assetsToRemove.forEach(corr -> {
			if (this.mapping.getUserdefined().contains(corr) || this.mapping.getAccepted().contains(corr)) {
				return;
			}
			if ((corr instanceof AbstractMappingRanking) && (((AbstractMappingRanking) corr).getRanking() > 70)) {
				// Don't remove high quality mappings
				return;
			}
			final EObject key = CorrespondenceHelper.getTarget(corr);
			Set<EObject> set;
			if (excludes.containsKey(key)) {
				set = excludes.get(key);
			} else {
				set = new HashSet<>();
				excludes.put(key, set);
			}
			set.add(CorrespondenceHelper.getSource(corr));
			this.helper.delete(corr);
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
	private boolean findForwardedFlows(final EDFD dfd, final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = this.cache.getEntityTypeMapping();
		final Map<Element, Set<TSignature>> elementSignatureMapping = this.cache.getElementSignatureMapping();
		for (final Element sourceElement : dfd.getElements()) {
			if (!elementSignatureMapping.containsKey(sourceElement)) {
				continue;
			}
			for (final Flow flow : sourceElement.getOutflows()) {
				final Set<TAbstractType> assets = flow.getAssets().parallelStream()
						.filter(entityTypeMapping::containsKey)
						.flatMap(asset -> entityTypeMapping.get(asset).parallelStream()).collect(Collectors.toSet());

				for (final TSignature sourceSignature : elementSignatureMapping.get(sourceElement)) {
					// Only continue for relevant source members (return or field type fits to asset
					// on flow)
					List<? extends TMember> sourceMembers;
					TAbstractType assetType;
					if (sourceSignature instanceof TMethodSignature) {
						final TMethodSignature tMethodSignature = (TMethodSignature) sourceSignature;
						assetType = tMethodSignature.getReturnType();
						if (assets.contains(assetType)) {
							sourceMembers = tMethodSignature.getDefinitions();
						} else {
							continue;
						}
					} else if (sourceSignature instanceof TFieldSignature) {
						final TFieldSignature tFieldSignature = (TFieldSignature) sourceSignature;
						assetType = tFieldSignature.getType();
						if (assets.contains(assetType)) {
							sourceMembers = tFieldSignature.getDefinitions();
						} else {
							continue;
						}
					} else {
						continue;
					}
					for (final Element targetElement : flow.getTarget()) {
						if (!elementSignatureMapping.containsKey(targetElement)) {
							continue;
						}
						// Select all targets with field type or one parameter type fitting to the asset
						// on the flow
						final Set<TSignature> targetSignatures = elementSignatureMapping.get(targetElement).parallelStream()
								.filter(sig -> {
									if (sig instanceof TFieldSignature) {
										return assetType.equals(((TFieldSignature) sig).getType());
									}
									if (sig instanceof TMethodSignature) {
										for (final TParameter param : ((TMethodSignature) sig).getParameters()) {
											if (assetType.equals(param.getType())) {
												return true;
											}
										}
									}
									return false;
								}).collect(Collectors.toSet());
						for (final TMember sourceMember : sourceMembers) {
							for (final TMember accessor : CallHelper.getAllInCalls(sourceMember)) {
								final Set<TMember> targetMembers = CallHelper.getAllOutCalls(accessor).parallelStream()
										.filter(target -> targetSignatures.contains(target.getSignature()))
										.collect(Collectors.toSet());
								if (!targetMembers.isEmpty() && (sourceMember instanceof TMethodDefinition)
										&& this.helper.canCreate(sourceMember, sourceElement, excludes)) {
									final MappingProcessDefinition corr = this.helper.createCorrespondence(
											(TMethodDefinition) sourceMember, sourceElement, 70,
											Collections.emptySet());
									this.mapping.getSuggested().add(corr);
									this.cache.add(sourceMember, sourceElement);
									change = true;

								}
								for (final TMember targetMember : targetMembers) {
									if (this.helper.canCreate(targetMember, targetElement, excludes)
											&& (targetMember instanceof TMethodDefinition)) {
										final MappingProcessDefinition corr = this.helper.createCorrespondence(
												(TMethodDefinition) targetMember, targetElement, 70,
												Collections.emptySet());
										this.mapping.getSuggested().add(corr);
										this.cache.add(targetMember, targetElement);
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
	private boolean mapToFieldsInProcess(final Process process, final NamedEntity entity, final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		if (!this.cache.getElementMemberMapping().containsKey(process)) {
			return false;
		}
		for (final TMember member : this.cache.getElementMemberMapping().get(process)) {
			for (final TFieldDefinition field : CallHelper.getAllOutCalls(member).parallelStream()
					.filter(definition -> definition instanceof TFieldDefinition)
					.map(definition -> (TFieldDefinition) definition).collect(Collectors.toSet())) {
				final String fieldName = field.getSignature().getField().getTName();
				final int result = StringCompare.compare(fieldName, entity.getName());
				if (result > 0) {
					final TAbstractType fieldType = field.getSignature().getType();
					if (this.helper.canCreate(fieldType, entity, excludes)) {
						final MappingEntityType corr = this.helper.createCorrespondence(fieldType, entity, 50);
						this.mapping.getSuggested().add(corr);
						this.cache.add(fieldType, entity);
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
	private boolean mapIntraProcessFlow(final Process process, final TSignature calledSignature, final TMethodSignature callingSignature,
			final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		if (callingSignature != calledSignature) {
			for (final TMethodDefinition callingDefiniton : callingSignature.getMethodDefinitions()) {
				for (final TMember calledDefinition : CallHelper.getAllOutCalls(callingDefiniton)) {
					if (calledDefinition.getSignature().equals(calledSignature)) {
						if (this.helper.canCreate(callingDefiniton, process, excludes)) {
							final MappingProcessDefinition corr = this.helper.createCorrespondence(callingDefiniton, process, 60,
									Collections.emptyList());
							this.mapping.getSuggested().add(corr);
							this.cache.add(callingDefiniton, process);
							change = true;
						}
						if (this.helper.canCreate(calledDefinition, process, excludes)) {
							final TMethodDefinition calledMethodDefinition = (TMethodDefinition) calledDefinition;
							final MappingProcessDefinition corr = this.helper.createCorrespondence(calledMethodDefinition, process,
									60, Collections.emptyList());
							this.mapping.getSuggested().add(corr);
							this.cache.add(calledDefinition, process);
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
	private boolean mapToReturnFlow(final Element sourceOfFlow, final TSignature calledSignature,
			final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = this.cache.getEntityTypeMapping();
		final TAbstractType returnType = ((TMethodSignature) calledSignature).getReturnType();
		for (final Flow flow : sourceOfFlow.getOutflows()) {
			final Map<TAbstractType, Asset> compatible = new HashMap<>();
			for (final Asset asset : flow.getAssets()) {
				if (entityTypeMapping.containsKey(asset)) {
					final Set<TAbstractType> types = entityTypeMapping.get(asset).stream()
							.flatMap(type -> getAllParents(type).stream()).collect(Collectors.toSet());
					if (types.contains(returnType)) {
						compatible.put(returnType, asset);
					}
				}
			}
			final boolean compatibleReturnType = !compatible.isEmpty();

			if (compatibleReturnType) {
				for (final Element targetElement : flow.getTarget()) {
					final Set<TSignature> callingSignatures = this.helper.getCorrespondences(targetElement).stream()
							.filter(corr -> corr instanceof MappingProcessSignature)
							.map(corr -> (TSignature) CorrespondenceHelper.getSource(corr)).collect(Collectors.toSet());

					for (final TMethodDefinition calledDefinition : ((TMethodSignature) calledSignature)
							.getMethodDefinitions()) {
						for (final TMember callingDefiniton : CallHelper.getAllInCalls(calledDefinition)) {
							final TSignature callingSignature = callingDefiniton.getSignature();
							if (callingSignatures.contains(callingSignature)) {
								if (this.helper.canCreate(calledDefinition, sourceOfFlow, excludes)) {
									final AbstractMappingBase returnCorr = (AbstractMappingBase) this.helper
											.getCorrespondence(returnType, compatible.get(returnType));
									this.helper.createCorrespondence(calledDefinition, sourceOfFlow, 80,
											Collections.singleton(returnCorr));
									this.cache.add(calledDefinition, sourceOfFlow);
									change = true;
								}
								if (this.helper.canCreate(callingDefiniton, targetElement, excludes)) {
									final AbstractMappingBase returnCorr = (AbstractMappingBase) this.helper
											.getCorrespondence(returnType, compatible.get(returnType));
									this.helper.createCorrespondence((TMethodDefinition) callingDefiniton, targetElement, 80,
											Collections.singleton(returnCorr));
									this.cache.add(callingDefiniton, targetElement);
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

	private static Set<TAbstractType> getAllParents(final TAbstractType type) {
		final Set<TAbstractType> types = new HashSet<>();
		types.add(type);
		final Deque<TAbstractType> stack = new LinkedList<>();
		stack.add(type);
		while (!stack.isEmpty()) {
			final TAbstractType nextType = stack.pop();
			types.add(nextType);
			if (nextType instanceof TClass) {
				final TClass tClass = (TClass) nextType;
				final EList<TClass> parentClass = tClass.getParentClasses();
				if (parentClass != null) {
					stack.addAll(parentClass);
				}
				stack.addAll(tClass.getImplements());
			} else if (nextType instanceof TInterface) {
				stack.addAll(((TInterface) nextType).getParentInterfaces());
			}
		}
		return types;
	}

	public static Set<TAbstractType> getAllChildClasses(final TAbstractType type) {
		final Set<TAbstractType> types = new HashSet<>();
		types.add(type);
		final Deque<TAbstractType> stack = new LinkedList<>();
		stack.add(type);
		while (!stack.isEmpty()) {
			final TAbstractType nextType = stack.pop();
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
	private boolean mapToParamFlow(final Element sourceElement, final TSignature sourceSignature,
			final Map<EObject, Set<EObject>> excludes) {
		boolean change = false;
		for (final Flow flow : sourceElement.getOutflows()) {
			for (final Element targetElement : flow.getTarget()) {
				if (this.cache.getElementSignatureMapping().containsKey(targetElement)) {
					for (final TSignature targetSignature : this.cache.getElementSignatureMapping().get(targetElement)) {
						for (final TMethodDefinition sourceDefinition : ((TMethodSignature) sourceSignature)
								.getMethodDefinitions()) {
							final Set<TMember> targets = getPath(sourceDefinition, targetSignature);
							if (!targets.isEmpty()) {
								if (this.helper.canCreate(sourceDefinition, sourceElement, excludes)) {
									final Defintion2Element sourceCorr = this.helper.createCorrespondence(sourceDefinition,
											sourceElement, 90, Collections.emptyList());
									this.mapping.getCorrespondences().add(sourceCorr);
									this.mapping.getSuggested().add(sourceCorr);
									this.cache.add(sourceDefinition, sourceElement);
									change = true;
								}
								for (final TMember targetDefinition : targets) {
									if (this.helper.canCreate(targetDefinition, targetElement, excludes)) {
										final Defintion2Element corr = this.helper.createCorrespondence(
												(TMethodDefinition) targetDefinition, targetElement, 90,
												Collections.emptyList());
										this.mapping.getCorrespondences().add(corr);
										this.mapping.getSuggested().add(corr);
										this.cache.add(targetDefinition, targetElement);
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
	private Set<TMember> getPath(final TMethodDefinition source, final TSignature target) {
		final Set<TMember> reachedTargets = new HashSet<>();
		final Set<TMember> seen = new HashSet<>();
		final List<TMember> stack = new LinkedList<>();
		stack.add(source);
		while (!stack.isEmpty()) {
			final TMember current = stack.remove(0);
			for (final TMember tTarget : CallHelper.getAllOutCalls(current)) {
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
	private Stream<MappingProcessSignature> mapToSignature(final Element node, final Set<TMethod> correspondingMethods,
			final Map<NamedEntity, Set<TAbstractType>> mapping, final Map<EObject, Set<EObject>> excludes) {
		final Map<Asset, Set<TAbstractType>> paramTypes = new HashMap<>();
		for (final Flow flow : node.getInflows()) {
			for (final Asset asset : flow.getAssets()) {
				if (mapping.containsKey(asset)) {
					final Set<TAbstractType> compatipbleTypes = mapping.get(asset).stream()
							.flatMap(type -> mapping.get(asset).stream()).collect(Collectors.toSet());
					paramTypes.put(asset, compatipbleTypes);
				}
			}
		}
		return correspondingMethods.stream().flatMap(method -> method.getSignatures().stream()).map(signature -> {
			final Map<Asset, TAbstractType> matchedAssets = new HashMap<>();
			for (final Entry<Asset, Set<TAbstractType>> entry : paramTypes.entrySet()) {
				final Set<TAbstractType> expectedAssetTypes = entry.getValue();
				if (expectedAssetTypes.contains(signature.getReturnType())) {
					matchedAssets.put(entry.getKey(), signature.getReturnType());
				}
				for (final TParameter param : signature.getParameters()) {
					if (expectedAssetTypes.contains(param.getType())) {
						matchedAssets.put(entry.getKey(), param.getType());
					}

				}
			}
			if (matchedAssets.isEmpty()) {
				return null;
			}
			MappingProcessSignature newCorr = null;
			if (this.helper.canCreate(signature, node, excludes)) {
				final Collection<AbstractMappingBase> derived = matchedAssets.entrySet().parallelStream()
						.map(entry -> (AbstractMappingBase) this.helper.getCorrespondence(entry.getValue(), entry.getKey()))
						.collect(Collectors.toSet());
				newCorr = this.helper.createCorrespondence(signature, node, 80, derived);
				this.mapping.getSuggested().add(newCorr);
			}
			return newCorr;
		}).filter(Objects::nonNull);
	}

	private Stream<Defintion2Element> mapToMembers(final Element element, final Set<TAbstractType> typescorrespondingToElement,
			final Map<NamedEntity, Set<TAbstractType>> typeMapping, final Map<EObject, Set<EObject>> excludes) {
		final Set<Defintion2Element> correspondingMembers = new HashSet<>();
		for (final TAbstractType type : typescorrespondingToElement) {
			for (final Asset asset : element.getAssets()) {
				if (typeMapping.containsKey(asset)) {
					final List<TMember> members = type.getDefines();
					for (final TAbstractType assetType : typeMapping.get(asset)) {
						for (final TMember member : members) {
							TAbstractType memberType;
							if (member instanceof TFieldDefinition) {
								memberType = ((TFieldDefinition) member).getSignature().getType();
								continue;
							} else {
								final TMethodDefinition tMethodDefinition = (TMethodDefinition) member;
								if (TConstructor.isConstructor(tMethodDefinition)) {
									memberType = type;
								} else {
									memberType = tMethodDefinition.getReturnType();
								}
							}
							if ((memberType.equals(assetType) || memberType.isSuperTypeOf(assetType))
									&& this.helper.canCreate(member, element, excludes)) {
								final Defintion2Element corr = this.helper.createCorrespondence((TMethodDefinition) member,
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
