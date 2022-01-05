package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.mapping.secdfd.helpers.AssetHelper;
import org.gravity.mapping.secdfd.helpers.FlowHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.BasicFactory;
import org.gravity.typegraph.basic.TAbstractFlowElement;
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

	public ImplementedDFD(final Process process, final Mapper mapper) {
		final Map<Element, ImplementedProcess> wrappers = new HashMap<>();
		this.process = new ImplementedProcess(process);

		final var entriesAndExits = FlowEntryExit.getEntriesExits(mapper, process);

		this.incoming = createIncomingFlows(mapper, wrappers, entriesAndExits,
				process.getInflows().stream().anyMatch(src -> {
					final var source = src.getSource();
					return (source instanceof ExternalEntity) || (source instanceof DataStore);
				}), getInAssets(process));
		this.outgoing = createOutgoingFlows(mapper, wrappers, entriesAndExits,
				process.getOutflows().stream().anyMatch(src -> {
					final var target = src.getTarget();
					return (target instanceof ExternalEntity) || (target instanceof DataStore);
				}), getOutAssets(process));

		linkFwd(this.incoming, this.outgoing, mapper);
		linkBwd(this.incoming, this.outgoing, mapper);

	}

	private Set<Asset> getInAssets(final Process process) {
		return process.getInflows().stream().flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toSet());
	}

	private Set<Asset> getOutAssets(final Process process) {
		return process.getOutflows().stream().flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toSet());
	}

	/**
	 * @param incoming
	 * @param outgoing
	 * @param mapper
	 */
	private void linkBwd(final Map<TFlow, Set<ImplementedFlow>> incoming, final Map<TFlow, Set<ImplementedFlow>> outgoing,
			final Mapper mapper) {
		for (final Entry<TFlow, Set<ImplementedFlow>> entry : outgoing.entrySet()) {
			final var sources = bwd(entry.getKey(), incoming.keySet(), mapper);
			for (final ImplementedFlow target : entry.getValue()) {
				final var realTarget = !target.getTarget().getName().startsWith("ExternalDummyProcess");
				for (final TFlow source : sources) {
					final var sourceSet = incoming.get(source);
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
	private void linkFwd(final Map<TFlow, Set<ImplementedFlow>> incoming, final Map<TFlow, Set<ImplementedFlow>> outgoing,
			final Mapper mapper) {
		for (final Entry<TFlow, Set<ImplementedFlow>> entry : incoming.entrySet()) {
			final var flow = entry.getKey();
			final var targets = fwd(flow, outgoing.keySet(), mapper);
			for (final ImplementedFlow source : entry.getValue()) {
				final var realSource = !source.getSource().getName().startsWith("ExternalDummyProcess");
				for (final TFlow target : targets) {
					final var targetSet = outgoing.get(target);
					if (realSource || targetSet.stream()
							.anyMatch(t -> !t.getTarget().getName().startsWith("ExternalDummyProcess"))) {
						source.addTargets(targetSet);
					}
				}
			}
		}
	}

	private Set<TFlow> bwd(final TFlow flow, final Set<TFlow> sources, final Mapper mapper) {
		final Set<TFlow> values = new HashSet<>();
		final Set<TAbstractFlowElement> seen = new HashSet<>();
		final Deque<TAbstractFlowElement> queue = new LinkedList<>();
		queue.add(flow);
		while (!queue.isEmpty()) {
			final var next = queue.pop();
			if (!seen.contains(next)) {
				seen.add(next);
				if (sources.contains(next)) {
					values.add((TFlow) next);
				}
				if (next instanceof TMethodDefinition) {
					final var mapping = mapper.getMapping((TMethodDefinition) next);
					if ((mapping != null) && !mapping.isEmpty() && !mapping.contains(this.process.getUnderlyingProcess())) {
						continue;
					}
				}
				queue.addAll(next.getIncomingFlows());

			}
		}
		return values;
	}

	private Set<TFlow> fwd(final TFlow flow, final Set<TFlow> targets, final Mapper mapper) {
		final Set<TFlow> values = new HashSet<>();
		final Set<TAbstractFlowElement> seen = new HashSet<>();
		final Deque<TAbstractFlowElement> queue = new LinkedList<>();
		queue.add(flow);
		while (!queue.isEmpty()) {
			final var next = queue.pop();
			if (!seen.contains(next)) {
				seen.add(next);
				if (targets.contains(next)) {
					values.add((TFlow) next);
				}
				if (next instanceof TMethodDefinition) {
					final var mapping = mapper.getMapping((TMethodDefinition) next);
					if ((mapping != null) && !mapping.isEmpty() && !mapping.contains(this.process.getUnderlyingProcess())) {
						continue;
					}
				}
				queue.addAll(next.getOutgoingFlows());
				if (next instanceof TMember) {
					queue.add(((TMember) next).getSignature());
				}
				if (next instanceof TParameter) {
					final var sig = (TMethodSignature) next.eContainer();
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
	private Set<? extends Element> findDFDElementOrCreateDummy(final Mapper mapper, final TMember member, final boolean dummies) {
		Set<? extends Element> mapping = mapper.getMapping((TMethodDefinition) member);
		if ((mapping == null) || mapping.isEmpty()) {
			final var definingType = member.getDefinedBy();
			final var store = mapper.getDataStoreMapping(definingType);
			if (store.isEmpty()) {
				if (!dummies || ((definingType != null) && definingType.isTLib())) {
					return Collections.emptySet();
				}
				final var dummy = ModelFactory.eINSTANCE.createProcess();
				final var builder = new StringBuilder("ExternalDummyProcess->");
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
	private Map<TFlow, Set<ImplementedFlow>> createOutgoingFlows(final Mapper mapper,
			final Map<Element, ImplementedProcess> wrappers, final FlowEntryExit entriesAndExits, final boolean dummies, final Set<Asset> assetsToConsider) {
		final Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (final TFlow flow : entriesAndExits.getExits()) {
			final var assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.stream().flatMap(Collection::stream).noneMatch(assetsToConsider::contains)) {
				continue;
			}

			final var flowTargets = FlowHelper.getTargetMember(flow);
			final var flowOwner = FlowHelper.getCausingMember(flow);
			final Set<Element> processes = Stream.concat(flowTargets.parallelStream(), Stream.of(flowOwner))
					.filter(TMethodDefinition.class::isInstance)
					.flatMap(trg -> findDFDElementOrCreateDummy(mapper, trg, dummies).stream())
					.filter(p -> !this.process.equals(p)).collect(Collectors.toSet());

			if (!processes.isEmpty()) {
				final Set<ImplementedFlow> implementedFlows = new HashSet<>();
				for (final Element trg : processes) {
					implementedFlows.add(new ImplementedFlow(this.process,
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
	private Map<TFlow, Set<ImplementedFlow>> createIncomingFlows(final Mapper mapper,
			final Map<Element, ImplementedProcess> wrappers, final FlowEntryExit entriesAndExits, final boolean dummies, final Set<Asset> assetsToConsider) {
		final Map<TFlow, Set<ImplementedFlow>> flows = new HashMap<>();
		for (final TFlow flow : entriesAndExits.getEntries()) {
			final var assets = AssetHelper.getCommunicatedAssets(flow, mapper.getAssets());
			if (assets.stream().flatMap(Collection::stream).noneMatch(assetsToConsider::contains)) {
				continue;
			}

			// Find sources of the flow in the DFD
			var flowSource = FlowHelper.getSourceMember(flow);
			if ((flow.eContainer() != null) && flowSource.stream().noneMatch(m -> m instanceof TMethodDefinition)) {
				continue;
			}
			if (flowSource.isEmpty()) {
				if (!dummies) {
					continue;
				}
				flowSource = Collections.singleton(BasicFactory.eINSTANCE.createTMethodDefinition());
			}
			final var flowOwner = FlowHelper.getCausingMember(flow);
			final Set<Element> processes = Stream.concat(flowSource.parallelStream(), Stream.of(flowOwner))
					.filter(TMethodDefinition.class::isInstance)
					.flatMap(src -> findDFDElementOrCreateDummy(mapper, src, dummies).stream())
					.filter(p -> !this.process.equals(p)).collect(Collectors.toSet());
			if (!processes.isEmpty()) {
				final Set<ImplementedFlow> implementedFlows = new HashSet<>();
				for (final Element src : processes) {
					implementedFlows.add(new ImplementedFlow(wrappers.computeIfAbsent(src, ImplementedProcess::new),
							this.process, assets));
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
		return this.incoming;
	}

	/**
	 * @return the outgoing
	 */
	public Map<TFlow, Set<ImplementedFlow>> getOutgoingFlows() {
		return this.outgoing;
	}

	/**
	 * @return the process
	 */
	public ImplementedProcess getImplementedProcess() {
		return this.process;
	}

}
