package org.gravity.mapping.secdfd.checks.implemented;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.secdfd.model.Asset;

public class ImplementedFlowPattern {

	private final Set<ImplementedFlow> sources;
	private final ImplementedFlow target;

	public ImplementedFlowPattern(Set<ImplementedFlow> sources, ImplementedFlow target) {
		this.sources = sources;
		this.target = target;
	}
	
	public Set<Asset> getPossibleOutgoingAssets(){
		return target.getPossibleAssets();
	}
	
	public Set<ImplementedFlow> getPossibleIncomingFlows(Asset asset) {
		Set<ImplementedFlow> possibleFlows = new HashSet<>();
		for(ImplementedFlow flow : sources) {
			if(flow.getPossibleAssets().contains(asset)){
				possibleFlows.add(flow);
			}
		}
		return possibleFlows;
	}

	public Set<ImplementedFlow> allIncomingFlows() {
		return sources;
	}

}
