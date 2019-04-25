package org.gravity.mapping.secdfd.helpers;

import java.util.stream.Stream;

import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.NamedEntity;

public class RankingHelper {

	public static int getRanking(AbstractCorrespondence corr) {
		Mapping mapping = (Mapping) corr.eContainer();
		if (mapping.getUserdefined().contains(corr) || mapping.getAccepted().contains(corr)) {
			return 100;
		}
		if (corr instanceof MappingProcessName) {
			return getRanking((MappingProcessName) corr);
		} else if (corr instanceof MappingProcessSignature) {
			return getRanking((MappingProcessSignature) corr);
		} else if (corr instanceof MappingProcessDefinition) {
			return getRanking((MappingProcessDefinition) corr);
		} else if (corr instanceof MappingEntityType) {
			return getRanking((MappingEntityType) corr);
		}
		throw new IllegalStateException("Unknown correspondence type: " + corr);
	}

	public static int getRanking(MappingProcessName corr) {
		Mapping mapping = (Mapping) corr.eContainer();
		if (mapping.getUserdefined().contains(corr) || mapping.getAccepted().contains(corr)) {
			return 100;
		}
		return corr.getRanking();
	}

	public static int getRanking(MappingProcessSignature corr) {
		Mapping mapping = (Mapping) corr.eContainer();
		if (mapping.getUserdefined().contains(corr) || mapping.getAccepted().contains(corr)) {
			return 100;
		}
		int nameRanking = 0;
		long assets = Stream
				.concat(corr.getTarget().getInflows().parallelStream(), corr.getTarget().getOutflows().parallelStream())
				.flatMap(flow -> flow.getAssets().parallelStream()).count();
		int matchedAssets = 0;
		for(AbstractMappingBase derivedFrom : corr.getDerived()) {
			if(derivedFrom instanceof MappingProcessName) {
				nameRanking = getRanking(derivedFrom);
			}
			else {
				matchedAssets++;
			}
		}
		int assetRanking = (int) ((matchedAssets * 100) / assets);
		return (nameRanking + assetRanking) / 2;
	}
	
	public static int getRanking(MappingProcessDefinition corr) {
		Mapping mapping = (Mapping) corr.eContainer();
		if (mapping.getUserdefined().contains(corr) || mapping.getAccepted().contains(corr)) {
			return 100;
		}
		int signatureRanking = 0;
		for(AbstractMappingBase derivedFrom : corr.getDerived()) {
			if(derivedFrom instanceof MappingProcessSignature) {
				signatureRanking = getRanking((MappingProcessSignature) derivedFrom);
			}
		}
		return signatureRanking;
	}
	
	public static int getRanking(MappingEntityType corr) {
		int nameRanking = corr.getRanking();
		NamedEntity dfdElement = corr.getTarget();
		if(dfdElement instanceof Asset) {
			int numMappedUsages = corr.getDeriving().size();
			int numUsages = ((Asset) dfdElement).getTargets().size() + 1;
			int assetRanking = Math.min(100, (100 * numMappedUsages) / numUsages);
			nameRanking = (nameRanking + assetRanking) / 2;
		}
		return nameRanking;
	}
}
