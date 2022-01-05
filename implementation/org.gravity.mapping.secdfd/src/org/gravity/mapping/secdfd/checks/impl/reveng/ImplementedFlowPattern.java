package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.secdfd.model.Asset;

public class ImplementedFlowPattern {

	private final Set<ImplementedFlow> sources;
	private final Set<ImplementedFlow> targets;

	public ImplementedFlowPattern(final Set<ImplementedFlow> sources, final Set<ImplementedFlow> target) {
		this.sources = sources;
		this.targets = target;
	}

	public Set<Set<Asset>> getPossibleOutgoingAssetsSeparately() {
		return this.targets.stream().map(ImplementedFlow::getPossibleAssetsSeparately).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}
	public Set<Asset> getPossibleOutgoingAssets() {
		return this.targets.stream().map(ImplementedFlow::getPossibleAssets).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}

	public Set<Set<Asset>> getPossibleIncomingAssetsSeparately() {
		return this.sources.stream().map(ImplementedFlow::getPossibleAssetsSeparately).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}

	public Set<Asset> getPossibleIncomingAssets() {
		return this.sources.stream().map(ImplementedFlow::getPossibleAssets).flatMap(Collection::stream)
				.collect(Collectors.toSet());
	}

	public Set<ImplementedFlow> getPossibleIncomingFlows(final Asset asset) {
		final Set<ImplementedFlow> possibleFlows = new HashSet<>();
		for (final ImplementedFlow flow : this.sources) {
			if (flow.getPossibleAssets().contains(asset)) {
				possibleFlows.add(flow);
			}
		}
		return possibleFlows;
	}

	public Set<ImplementedFlow> allIncomingFlows() {
		return this.sources;
	}

	public Set<ImplementedFlow> allOutgoingFlows() {
		return this.targets;
	}

	@Override
	public String toString() {
		return this.targets.stream().map(s -> s.getTarget().getUnderlyingProcess().getName())
				.collect(Collectors.joining(", ", "[", "]")) + " <-- "
				+ this.sources.stream().map(s -> s.getSource().getUnderlyingProcess().getName())
				.collect(Collectors.joining(", ", "[", "]"));
	}
}
