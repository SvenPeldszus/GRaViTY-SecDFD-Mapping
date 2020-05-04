package org.gravity.mapping.secdfd.checks;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.helpers.AssetHelper;
import org.gravity.mapping.secdfd.helpers.FlowHelper;
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
		Map<TAbstractType, Set<Asset>> assets = mapper.getAssets();
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
								+ AssetHelper.getCommunicatedAssets(f, assets).stream().map(Object::toString)
										.collect(Collectors.joining(", ")))
						.collect(Collectors.joining(",\n", "Found the following entry flows:\n", "\n")));
	
				for (Asset expectedAsset : responsibility.getIncomeassets()) {
					// Exactly one found flow has to communicate this asset
					int counter = 0;
					for (TFlow ff : found) {
						Set<Asset> comma = AssetHelper.getCommunicatedAssets(ff, assets);
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
				for (TMember source : FlowHelper.getSourceMember((TFlow) next)) {
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

	

	private Map<Asset, Set<TFlow>> classifyFlows(Set<TFlow> flows, Map<TAbstractType, Set<Asset>> assets) {
		Map<Asset, Set<TFlow>> map = new HashMap<>();

		for (TFlow flow : flows) {
			Set<Asset> foundAssets = AssetHelper.getCommunicatedAssets(flow, assets);
			for (Asset asset : foundAssets) {
				map.computeIfAbsent(asset, s -> new HashSet<>()).add(flow);
			}
		}

		return map;
	}

}
