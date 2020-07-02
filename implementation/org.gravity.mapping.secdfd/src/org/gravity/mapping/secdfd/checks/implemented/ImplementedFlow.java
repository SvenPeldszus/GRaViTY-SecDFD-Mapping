package org.gravity.mapping.secdfd.checks.implemented;

import java.util.HashSet;
import java.util.Set;

import org.secdfd.model.Asset;

public class ImplementedFlow {

	private final ImplementedProcess source;
	private final ImplementedProcess target;
	private final Set<Asset> possibleAssets;
	private final Set<ImplementedFlow> internalSources;
	private final Set<ImplementedFlow> internalTargets;

	public ImplementedFlow(ImplementedProcess src, ImplementedProcess trg,
			Set<Asset> possibleAssets) {
		this.possibleAssets = possibleAssets;
		this.source = src;
		this.source.addOutgoing(this);
		this.target = trg;
		this.target.addIncoming(this);
		this.internalSources = new HashSet<>();
		this.internalTargets = new HashSet<>();
	}

	public void addSources(Set<ImplementedFlow> sources) {
		this.getInternalSources().addAll(getInternalTargets());
		sources.forEach(src -> src.getInternalTargets().add(this));
	}

	public void addTargets(Set<ImplementedFlow> targets) {
		this.getInternalTargets().addAll(targets);
		targets.forEach(trg -> trg.getInternalSources().add(this));
	}

	/**
	 * @return the internalSources
	 */
	public Set<ImplementedFlow> getInternalSources() {
		return internalSources;
	}

	/**
	 * @return the internalTargets
	 */
	public Set<ImplementedFlow> getInternalTargets() {
		return internalTargets;
	}

	/**
	 * @return the possibleAssets
	 */
	public Set<Asset> getPossibleAssets() {
		return possibleAssets;
	}
}