package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.secdfd.model.Asset;

public class ImplementedFlow {

	private final ImplementedProcess source;
	private final ImplementedProcess target;
	private final Set<Set<Asset>> possibleAssets;
	private final Set<ImplementedFlow> internalSources;
	private final Set<ImplementedFlow> internalTargets;

	public ImplementedFlow(final ImplementedProcess src, final ImplementedProcess trg, final Set<Set<Asset>> possibleAssets) {
		this.possibleAssets = possibleAssets;
		this.source = src;
		this.source.addOutgoing(this);
		this.target = trg;
		this.target.addIncoming(this);
		this.internalSources = new HashSet<>();
		this.internalTargets = new HashSet<>();
	}

	public void addSources(final Set<ImplementedFlow> sources) {
		getInternalSources().addAll(getInternalTargets());
		sources.forEach(src -> src.getInternalTargets().add(this));
	}

	public void addTargets(final Set<ImplementedFlow> targets) {
		getInternalTargets().addAll(targets);
		targets.forEach(trg -> trg.getInternalSources().add(this));
	}

	/**
	 * @return the internalSources
	 */
	public Set<ImplementedFlow> getInternalSources() {
		return this.internalSources;
	}

	/**
	 * @return the internalTargets
	 */
	public Set<ImplementedFlow> getInternalTargets() {
		return this.internalTargets;
	}

	/**
	 * @return the possibleAssets
	 */
	public Set<Asset> getPossibleAssets() {
		return this.possibleAssets.parallelStream().flatMap(Collection::stream).collect(Collectors.toSet());
	}

	/**
	 * @return the possibleAssets
	 */
	public Set<Set<Asset>> getPossibleAssetsSeparately() {
		return this.possibleAssets;
	}

	public ImplementedProcess getSource() {
		return this.source;
	}

	public ImplementedProcess getTarget() {
		return this.target;
	}

	@Override
	public String toString() {
		return this.source.getUnderlyingProcess().getName() + " --> " + this.target.getUnderlyingProcess().getName();
	}
}