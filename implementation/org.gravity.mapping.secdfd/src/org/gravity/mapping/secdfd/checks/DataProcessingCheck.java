package org.gravity.mapping.secdfd.checks;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;

import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

public class DataProcessingCheck {

	public Set<SResult> check(Set<TFlow> entries, Set<TFlow> exits, Process process, Mapper mapper,
			Responsibility responsibility) {
		Map<TAbstractType, Asset> assets = mapper.getAssets();
		Map<Asset, Set<TFlow>> exitMapping = classifyFlows(exits, assets);
		Set<TMethodDefinition> methods = mapper.getMapping(process);
		Set<SResult> problems = new HashSet<>();
	
		for (Asset outComeAsset : responsibility.getOutcomeassets()) {
			Set<TFlow> outgoingAssetFlows = exitMapping.get(outComeAsset);
	
			if (outgoingAssetFlows == null || outgoingAssetFlows.isEmpty()) {
				// absence of outgoing flow or asset
				problems.add(new SResult(PState.WARNING, ResponsibilityType.FORWARD, (EObject) process, methods,
						"Outgoing asset <" + outComeAsset.getName() + "> from a contract hasn't been implemented."));
				System.err.println("Outgoing asset hasn't been implemented.");
				continue;
			}
			for (TFlow flow : outgoingAssetFlows) {
				Set<TFlow> found = searchBackwards(flow, methods);
	
				System.out.println(found.stream()
						.map(f -> f.toString() + " - asset: "
								+ getCommunicatedAssets(f, assets).stream().map(Object::toString)
										.collect(Collectors.joining(", ")))
						.collect(Collectors.joining(",\n", "Found the following entry flows:\n", "\n")));
	
				for (Asset expectedAsset : responsibility.getIncomeassets()) {
					// Exactly one found flow has to communicate this asset
					int counter = 0;
					for (TFlow ff : found) {
						Set<Asset> comma = getCommunicatedAssets(ff, assets);
						if (comma.contains(expectedAsset)) {
							counter += 1;
							if (counter > 1) {
								// TODO: if expectedAsset has been mapped to the same type more than once, check
								// if ok: could be that two parameters are passed of the same type (String asset
								// A, String asset B)
							}
						}
					}
					if (counter > 1) {
						// divergence
						problems.add(new SResult(PState.WARNING, ResponsibilityType.FORWARD, (EObject) process, methods,
								"More than one flow is communicating the asset <" + expectedAsset.getName()
										+ "> upon process entry."));
						System.err.println("More than one flow is communicating the asset <" + expectedAsset.getName()
								+ "> upon process entry.");
					} else if (counter < 1) {
						// absence
						problems.add(new SResult(PState.WARNING, ResponsibilityType.FORWARD, (EObject) process, methods,
								"No flow is communicating the asset <" + expectedAsset.getName()
										+ "> upon process entry."));
						System.err.println("No flow is communicating the asset <" + expectedAsset.getName()
								+ "> upon process entry.");
					} else {
						// convergence
						problems.add(new SResult(PState.SUCCESS, ResponsibilityType.FORWARD, (EObject) process, methods,
								"Outgoing asset <" + outComeAsset.getName() + "> has correct flow."));
						System.out.println("Outgoing asset has correct flow: <" + outComeAsset.getName() + ">");
					}
				}
			}
		}
		return problems;
	}

	private static Set<TFlow> searchBackwards(TFlow exit, Set<? extends TMember> methods) {
		Set<TFlow> found = new HashSet<>();
		Deque<TAbstractFlowElement> stack = new LinkedList<>();
		stack.add(exit);
		Set<TAbstractFlowElement> seen = new HashSet<>();
		while (!stack.isEmpty()) {
			TAbstractFlowElement next = stack.pop();
			if (seen.contains(next)) {
				continue;
			}
			seen.add(next);

			if (next instanceof TMethodDefinition) {
				if (methods.contains(next)) {
					stack.addAll(next.getIncomingFlows());
				}
			} else if (next instanceof TMethodSignature) {
				stack.addAll(next.getIncomingFlows());
				stack.addAll(((TMethodSignature) next).getDefinitions());
			} else if (next instanceof TParameter || next instanceof TAccess) {
				stack.addAll(next.getIncomingFlows());
			} else if (next instanceof TFlow) {
				boolean leftProcess = false;
				for (TMember source : getSourceMember((TFlow) next)) {
					if (!methods.contains(source)) {
						found.add((TFlow) next);
						leftProcess = true;
						break;
					}
				}
				if (!leftProcess) {
					stack.addAll(next.getIncomingFlows());
				}
			} else {
				throw new IllegalStateException("Flow to not supported element: " + next.eClass().getName());
			}
		}
		return found;
	}

	private static Set<TMember> getSourceMember(TFlow next) {
		Set<TMember> members = new HashSet<>();
		for (TAbstractFlowElement source : next.getIncomingFlows()) {
			if (source instanceof TMember) {
				members.add((TMember) source);
			} else if (source instanceof TParameter) {
				members.addAll(((TMethodSignature) ((TParameter) source).eContainer()).getDefinitions());
			} else if (source instanceof TFlow) {
				members.addAll(getSourceMember((TFlow) source));
			} else if (source instanceof TAccess) {
				members.addAll(((TAccess) source).getIncomingFlows().stream()
						.flatMap(in -> getSourceMember((TFlow) in).stream()).collect(Collectors.toSet()));
			} else if (source instanceof TSignature) {
				members.addAll(((TSignature) source).getDefinitions());
			}
		}
		return members;
	}

	static Map<Asset, Set<TFlow>> classifyFlows(Set<TFlow> flows, Map<TAbstractType, Asset> assets) {
		Map<Asset, Set<TFlow>> map = new HashMap<>();

		for (TFlow flow : flows) {
			Set<Asset> foundAssets = getCommunicatedAssets(flow, assets);
			for (Asset asset : foundAssets) {
				map.computeIfAbsent(asset, s -> new HashSet<>()).add(flow);
			}
		}

		return map;
	}

	/**
	 * @param flow
	 * @param assets
	 * @return
	 */
	private static Set<Asset> getCommunicatedAssets(TFlow flow, Map<TAbstractType, Asset> assets) {
		Set<TAbstractType> foundTypes = getCommunicatedTypes(flow);
		Set<Asset> foundAssets = new HashSet<>();
		for (TAbstractType type : foundTypes) {
			addToAssetsIfMapped(foundAssets, assets, type);
		}
		return foundAssets;
	}

	/**
	 * @param flow
	 * @return
	 */
	private static Set<TAbstractType> getCommunicatedTypes(TFlow flow) {
		Set<TAbstractType> foundTypes = new HashSet<>();
		for (TAbstractFlowElement source : flow.getIncomingFlows()) {
			if (source instanceof TMethodSignature) {
				foundTypes.add(((TMethodSignature) source).getReturnType());
			} else if (source instanceof TMethodDefinition) {
				TMethodDefinition def = (TMethodDefinition) source;
				if (def.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()) {
					throw new IllegalStateException("Method definition has outgoing flow but is not a constructor!");
				}
				TAbstractType type = def.getDefinedBy();
				foundTypes.add(type);
			} else if (source instanceof TParameter) {
				TAbstractType type = ((TParameter) source).getType();
				foundTypes.add(type);
			} else if (source instanceof TFieldDefinition) {
				foundTypes.add(((TFieldDefinition) source).getSignature().getType());
			} else if (source instanceof TFieldSignature) {
				foundTypes.add(((TFieldSignature) source).getType());
			} else if (source instanceof TAccess) {
				// Skip
			} else {
				throw new IllegalStateException("Unkown source of flow: " + source.eClass().getName());
			}
		}
		for (TAbstractFlowElement target : flow.getOutgoingFlows()) {
			if (target instanceof TParameter) {
				foundTypes.add(((TParameter) target).getType());
			} else if (target instanceof TAccess || target instanceof TMethodDefinition) {
				// Skip
			} else if (target instanceof TFieldDefinition) {
				foundTypes.add(((TFieldDefinition) target).getSignature().getType());
			} else if (target instanceof TFieldSignature) {
				foundTypes.add(((TFieldSignature) target).getType());
			} else {
				throw new IllegalStateException("Unkown target of flow: " + target.eClass().getName());
			}
		}
		return foundTypes;
	}

	/**
	 * @param assets  The set of assets the types corresponding asset should be
	 *                added to
	 * @param mapping A mapping of all assets
	 * @param type    The type whose corresponding asset should be added to the set
	 * @return true, if the asset was mapped
	 */
	private static boolean addToAssetsIfMapped(Set<Asset> assets, Map<TAbstractType, Asset> mapping,
			TAbstractType type) {
		if (mapping.containsKey(type)) {
			assets.add(mapping.get(type));
			return true;
		}
		return false;
	}

}
