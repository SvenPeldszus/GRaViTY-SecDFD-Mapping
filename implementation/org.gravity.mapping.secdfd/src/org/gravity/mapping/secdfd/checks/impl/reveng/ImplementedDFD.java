package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.gravity.mapping.secdfd.helpers.AssetHelper;
import org.gravity.mapping.secdfd.helpers.FlowHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.BasicFactory;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Process;

public class ImplementedDFD {

	private final ImplementedProcess process;
	private final Map<TFlow, Set<ImplementedFlow>> incoming;
	private final Map<TFlow, Set<ImplementedFlow>> outgoing;

	public ImplementedDFD(Process process, Mapper mapper) {
		Map<Element, ImplementedProcess> wrappers = new HashMap<>();
		this.process = new ImplementedProcess(process);

		FlowEntryExit entriesAndExits = FlowEntryExit.getEntriesExits(mapper, process);

		incoming = createIncomingFlows(mapper, wrappers, entriesAndExits,
				process.getInflows().stream().anyMatch(src -> {
					Element source = src.getSource();
					return source instanceof ExternalEntity || source instanceof DataStore;
				}), getInAssets(process));
		outgoing = createOutgoingFlows(mapper, wrappers, entriesAndExits,
				process.getOutflows().stream().anyMatch(src -> {
					EList<Element> target = src.getTarget();
					return target instanceof ExternalEntity || target instanceof DataStore;
				}), getOutAssets(process));

		linkFwd(incoming, outgoing, mapper);
		linkBwd(incoming, outgoing, mapper);

	}

	private Set<Asset> getInAssets(Process process) {
		return process.getInflows().stream().flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toSet());
	}

	private Set<Asset> getOutAssets(Process process) {
		return process.getOutflows().stream().flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toSet());
	}

	/**
	 * @param incoming
	 * @param outgoing
	 * @param mapper
	 */
	private void linkBwd(Map<TFlow, Set<ImplementedFlow>> incoming, Map<TFlow, Set<ImplementedFlow>> outgoing,
			Mapper mapper) {
		for (Entry<TFlow, Set<ImplementedFlow>> entry : outgoing.entrySet()) {
			Set<TFlow> sources = bwd(entry.getKey(), incoming.keySet(), mapper);
			for (ImplementedFlow target : entry.getValue()) {
				boolean realTarget = !target.getTarget().getName().startsWith("ExternalDummyProcess");
				for (TFlow source : sources) {
					Set<ImplementedFlow> sourceSet = incoming.get(source);
					if (realTarget && sourceSet.stream()
							.anyMatch(s -> !s.getSource().getName().startsWith("ExternalDummyProcess"))) {
						target.addSources(sourceSet);
					}
				}
			}
		}
	}

	/**
	 * @param incoming
	 * @param outgoing
	 * @param mapper
	 */
	private void linkFwd(Map<TFlow, Set<ImplementedFlow>> incoming, Map<TFlow, Set<ImplementedFlow>> outgoing,
			Mapper mapper) {
		for (Entry<TFlow, Set<ImplementedFlow>> entry : incoming.entrySet()) {
			TFlow flow = entry.getKey();
			Set<TFlow> targets = fwd(flow, outgoing.keySet(), mapper);
			for (ImplementedFlow source : entry.getValue()) {
				boolean realSource = !source.getSource().getName().startsWith("ExternalDummyProcess");
				for (TFlow target : targets) {
					Set<ImplementedFlow> targetSet = outgoing.get(target);
					if (realSource || targetSet.stream()
							.anyMatch(t -> !t.getTarget().getName().startsWith("ExternalDummyProcess"))) {
						source.addTargets(targetSet);
					}
				}
			}
		}
	}

	private Set<TFlow> bwd(TFlow flow, Set<TFlow> sources, Mapper mapper) {
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
				}
				if (next instanceof TMethodDefinition) {
					Set<Element> mapping = mapper.getMapping((TMethodDefinition) next);
					if (mapping != null && !mapping.isEmpty() && !mapping.contains(process.getUnderlyingProcess())) {
						continue;
					}
				}
				queue.addAll(next.getIncomingFlows());

			}
		}
		return values;
	}

	private Set<TFlow> fwd(TFlow flow, Set<TFlow> targets, Mapper mapper) {
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
				}
				if (next instanceof TMethodDefinition) {
					Set<Element> mapping = mapper.getMapping((TMethodDefinition) next);
					if (mapping != null && !mapping.isEmpty() && !mapping.contains(process.getUnderlyingProcess())) {
						continue;
					}
				}
				queue.addAll(next.getOutgoingFlows());
				if (next instanceof TMember) {
					queue.add(((TMember) next).getSignature());
				}
				if (next instanceof TParameter) {
					TMethodSignature sig = (TMethodSignature) next.eContainer();
					if (sig.getDefinitions().stream().anyMatch(def -> def.getDefinedBy().isTLib())) {
						queue.addAll(sig.getOutgoingFlows());
					}
				}
			}
		}
		return values;
	}

	/**
	 * @param mapper
	 * @param member
	 * @param dummies
	 * @return
	 */
	private Set<? extends Element> findDFDElementOrCreateDummy(Mapper mapper, TMember member, boolean dummies) {
		Set<? extends Element> mapping = mapper.getMapping((TMethodDefinition) member);
		if (mapping == null || mapping.isEmpty()) {
			TAbstractType definingType = member.getDefinedBy();
			Set<DataStore> store = mapper.getDataStoreMapping(definingType);
			if (store.isEmpty()) {
				if (!dummies || (definingType != null && definingType.isTLib())) {
					return Collections.emptySet();
				}
				Process dummy = ModelFactory.eINSTANCE.createProcess();
				StringBuilder builder = new StringBuilder("ExternalDummyProcess->");
				if (definingType != null) {
					builder.append(definingType.getTName());
				} else {
					builder.append("UnknownType");
				}
				builder.append('.');
				if (member.getSignature() != null) {
					builder.append(member.getSignatureString());
				} else {
					builder.append("dummyMethod");
				}
				dummy.setName(builder.toString());
				mapping = Collections.singleton(dummy);
			} else {
				mapping = store;
			}
		}
		return mapping;
	}

	/**
	 * @param mapper
	 * @param process
	 * @param wrappers
	 * @param entriesAndExits
	 * @param assetsToConsider 
	 * @return
	 */
	private Map<TFlow, Set<ImplementedFlow>> createOutgoingFlows(Mapper mapper,
			Map<Element, ImplementedProcess> wrappers, FlowEntryExit entriesAndExits, boolean dummies, Set<Asset> assetsToConsider) {
		Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (TFlow flow : entriesAndExits.getExits()) {
			Set<Asset> assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.stream().noneMatch(a -> assetsToConsider.contains(a))) {
				continue;
			}

			Set<TMember> flowTargets = FlowHelper.getTargetMember(flow);
			TMember flowOwner = FlowHelper.getCausingMember(flow);
			Set<Element> processes = Stream.concat(flowTargets.parallelStream(), Stream.of(flowOwner))
					.filter(TMethodDefinition.class::isInstance)
					.flatMap(trg -> findDFDElementOrCreateDummy(mapper, trg, dummies).stream())
					.filter(p -> !process.equals(p)).collect(Collectors.toSet());

			if (!processes.isEmpty()) {
				Set<ImplementedFlow> implementedFlows = new HashSet<>();
				for (Element trg : processes) {
					implementedFlows.add(new ImplementedFlow(process,
							wrappers.computeIfAbsent(trg, ImplementedProcess::new), assets));
				}
				flows.put(flow, implementedFlows);
			}
		}
		return flows;
	}

	/**
	 * @param mapper
	 * @param process
	 * @param wrappers
	 * @param entriesAndExits
	 * @param dummies
	 * @param assetsToConsider 
	 * @return
	 */
	private Map<TFlow, Set<ImplementedFlow>> createIncomingFlows(Mapper mapper,
			Map<Element, ImplementedProcess> wrappers, FlowEntryExit entriesAndExits, boolean dummies, Set<Asset> assetsToConsider) {
		Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (TFlow flow : entriesAndExits.getEntries()) {
			Set<Asset> assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.stream().noneMatch(a -> assetsToConsider.contains(a))) {
				continue;
			}

			// Find sources of the flow in the DFD
			Set<TMember> flowSource = FlowHelper.getSourceMember(flow);
			if (flow.eContainer() != null && flowSource.stream().noneMatch(m -> m instanceof TMethodDefinition)) {
				continue;
			}
			if (flowSource.isEmpty()) {
				if (!dummies) {
					continue;
				}
				flowSource = Collections.singleton(BasicFactory.eINSTANCE.createTMethodDefinition());
			}
			TMember flowOwner = FlowHelper.getCausingMember(flow);
			Set<Element> processes = Stream.concat(flowSource.parallelStream(), Stream.of(flowOwner))
					.filter(TMethodDefinition.class::isInstance)
					.flatMap(src -> findDFDElementOrCreateDummy(mapper, src, dummies).stream())
					.filter(p -> !process.equals(p)).collect(Collectors.toSet());
			if (!processes.isEmpty()) {
				Set<ImplementedFlow> implementedFlows = new HashSet<>();
				for (Element src : processes) {
					implementedFlows.add(new ImplementedFlow(wrappers.computeIfAbsent(src, ImplementedProcess::new),
							process, assets));
				}
				flows.put(flow, implementedFlows);
			}

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
