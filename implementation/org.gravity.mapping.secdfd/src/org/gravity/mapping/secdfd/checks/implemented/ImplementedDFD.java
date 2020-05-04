package org.gravity.mapping.secdfd.checks.implemented;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.mapping.secdfd.checks.FlowEntryExit;
import org.gravity.mapping.secdfd.helpers.AssetHelper;
import org.gravity.mapping.secdfd.helpers.FlowHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;

public class ImplementedDFD {
	
	private final ImplementedProcess process;
	private final Map<TFlow, Set<ImplementedFlow>> incoming;
	private final Map<TFlow, Set<ImplementedFlow>> outgoing;
	
	private ImplementedDFD(ImplementedProcess process, Map<TFlow, Set<ImplementedFlow>> incoming, Map<TFlow, Set<ImplementedFlow>> outgoing) {
		this.process = process;
		this.incoming = incoming;
		this.outgoing = outgoing;
	}

	public static ImplementedDFD create(Process process, Mapper mapper) {
		Map<Process, ImplementedProcess> wrappers = new HashMap<>();
		ImplementedProcess wrapper = new ImplementedProcess(process);

		FlowEntryExit entriesAndExits = FlowEntryExit.getEntriesExits(mapper, process);
		Map<TFlow, Set<ImplementedFlow>> incoming = createIncomingFlows(mapper, wrapper, wrappers, entriesAndExits);
		Map<TFlow, Set<ImplementedFlow>> outgoing = createOutgoingFlows(mapper, wrapper, wrappers, entriesAndExits);

		linkFwd(incoming, outgoing);
		linkBwd(incoming, outgoing);
		return new ImplementedDFD(wrapper, incoming, outgoing);
	}

	/**
	 * @param incoming
	 * @param outgoing
	 */
	private static void linkBwd(Map<TFlow, Set<ImplementedFlow>> incoming, Map<TFlow, Set<ImplementedFlow>> outgoing) {
		for (Entry<TFlow, Set<ImplementedFlow>> entry : outgoing.entrySet()) {
			Set<TFlow> sources = bwd(entry.getKey(), incoming.keySet());
			for (ImplementedFlow target : entry.getValue()) {
				for (TFlow source : sources) {
					target.addSources(incoming.get(source));
				}
			}
		}
	}

	/**
	 * @param incoming
	 * @param outgoing
	 */
	private static void linkFwd(Map<TFlow, Set<ImplementedFlow>> incoming, Map<TFlow, Set<ImplementedFlow>> outgoing) {
		for (Entry<TFlow, Set<ImplementedFlow>> entry : incoming.entrySet()) {
			Set<TFlow> targets = fwd(entry.getKey(), outgoing.keySet());
			for (ImplementedFlow source : entry.getValue()) {
				for (TFlow target : targets) {
					source.addTargets(outgoing.get(target));
				}
			}
		}
	}

	private static Set<TFlow> bwd(TFlow flow, Set<TFlow> sources) {
		Set<TFlow> values = new HashSet<>();
		Set<TAbstractFlowElement> seen = new HashSet<>();
		Deque<TAbstractFlowElement> queue = new LinkedList<>();
		queue.add(flow);
		while (!queue.isEmpty()) {
			TAbstractFlowElement next = queue.pop();
			if (!seen.contains(next)) {
				seen.add(next);
				if (sources.contains(next)) {
					values.add((TFlow) next);
				} else {
					queue.addAll(next.getIncomingFlows());
				}
			}
		}
		return values;
	}

	private static Set<TFlow> fwd(TFlow flow, Set<TFlow> targets) {
		Set<TFlow> values = new HashSet<>();
		Set<TAbstractFlowElement> seen = new HashSet<>();
		Deque<TAbstractFlowElement> queue = new LinkedList<>();
		queue.add(flow);
		while (!queue.isEmpty()) {
			TAbstractFlowElement next = queue.pop();
			if (!seen.contains(next)) {
				seen.add(next);
				if (targets.contains(next)) {
					values.add((TFlow) next);
				} else {
					queue.addAll(next.getOutgoingFlows());
					if (next instanceof TMember) {
						queue.add(((TMember) next).getSignature());
					}
				}
			}
		}
		return values;
	}

	/**
	 * @param mapper 
	 * @param process
	 * @param wrappers
	 * @param entriesAndExits
	 * @return
	 */
	private static Map<TFlow, Set<ImplementedFlow>> createOutgoingFlows(Mapper mapper, ImplementedProcess process,
			Map<Process, ImplementedProcess> wrappers, FlowEntryExit entriesAndExits) {
		Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (TFlow flow : entriesAndExits.getExits()) {
			Set<Asset> assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.isEmpty()) {
				continue;
			}

			Stream<TMember> flowTargets = FlowHelper.getTargetMember(flow).parallelStream();
			Stream<TMember> flowOwner = Stream.of(FlowHelper.getCausingMember(flow));
			Set<ImplementedFlow> implementedFlows = Stream.concat(flowTargets, flowOwner)
					.filter(TMethodDefinition.class::isInstance).map(trg -> mapper.getMapping((TMethodDefinition) trg))
					.filter(Objects::nonNull).flatMap(src -> src.parallelStream()).filter(p -> !process.equals(p))
					.distinct().sequential().map(trg -> new ImplementedFlow(flow, process,
							wrappers.computeIfAbsent(trg, ImplementedProcess::new), assets))
					.collect(Collectors.toSet());
			flows.put(flow, implementedFlows);
		}
		return flows;
	}

	/**
	 * @param mapper 
	 * @param process
	 * @param wrappers
	 * @param entriesAndExits
	 * @return
	 */
	private static Map<TFlow, Set<ImplementedFlow>> createIncomingFlows(Mapper mapper, ImplementedProcess process,
			Map<Process, ImplementedProcess> wrappers, FlowEntryExit entriesAndExits) {
		Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (TFlow flow : entriesAndExits.getEntries()) {
			Set<Asset> assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.isEmpty()) {
				continue;
			}

			// Find sources of the flow in the DFD
			Set<TMember> flowSource = FlowHelper.getSourceMember(flow);
			TMember flowOwner = FlowHelper.getCausingMember(flow);
			Set<ImplementedFlow> implementedFlows = Stream.concat(flowSource.parallelStream(), Stream.of(flowOwner))
					.filter(TMethodDefinition.class::isInstance).map(src -> mapper.getMapping((TMethodDefinition) src))
					.filter(Objects::nonNull).flatMap(src -> src.parallelStream()).filter(p -> !process.equals(p))
					.distinct().sequential().map(src -> new ImplementedFlow(flow,
							wrappers.computeIfAbsent(src, ImplementedProcess::new), process, assets))
					.collect(Collectors.toSet());
			flows.put(flow, implementedFlows);

		}
		return flows;
	}

	/**
	 * @return the incoming
	 */
	public Map<TFlow, Set<ImplementedFlow>> getIncomingFlows() {
		return incoming;
	}

	/**
	 * @return the outgoing
	 */
	public Map<TFlow, Set<ImplementedFlow>> getOutgoingFlows() {
		return outgoing;
	}

	/**
	 * @return the process
	 */
	public ImplementedProcess getImplementedProcess() {
		return process;
	}

}
