package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.secdfd.model.Asset;

public class ImplementedFlowPattern {

	private final Set<ImplementedFlow> sources;
	private final Set<ImplementedFlow> targets;

	public ImplementedFlowPattern(Set<ImplementedFlow> sources, Set<ImplementedFlow> target) {
		this.sources = sources;
		this.targets = target;
	}

	public Set<Asset> getPossibleOutgoingAssets() {
		return targets.stream().map(ImplementedFlow::getPossibleAssets).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}

	public Set<Asset> getPossibleIncomingAssets() {
		return sources.stream().map(ImplementedFlow::getPossibleAssets).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}

	public Set<ImplementedFlow> getPossibleIncomingFlows(Asset asset) {
		Set<ImplementedFlow> possibleFlows = new HashSet<>();
		for (ImplementedFlow flow : sources) {
			if (flow.getPossibleAssets().contains(asset)) {
				possibleFlows.add(flow);
			}
		}
		return possibleFlows;
	}

	public Set<ImplementedFlow> allIncomingFlows() {
		return sources;
	}

	public Set<ImplementedFlow> allOutgoingFlows() {
		return targets;
	}

	@Override
	public String toString() {
		return targets.stream().map(s -> s.getTarget().getUnderlyingProcess().getName())
				.collect(Collectors.joining(", ", "[", "]")) + " <-- "
				+ sources.stream().map(s -> s.getSource().getUnderlyingProcess().getName())
						.collect(Collectors.joining(", ", "[", "]"));
	}
}
