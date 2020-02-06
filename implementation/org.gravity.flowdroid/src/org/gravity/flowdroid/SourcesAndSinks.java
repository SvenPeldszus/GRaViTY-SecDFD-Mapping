package org.gravity.flowdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;

public class SourcesAndSinks {
	public static Set<AbstractCorrespondence> getAcceptedMappings(Mapper mapper, EObject dfdelement) {
		return mapper.getMapping().getAccepted().parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement)).collect(Collectors.toSet());
	}

	public SourceAndSink getSourceSinks(Mapper mapper, EDFD dfd) {
		ArrayList<String> sources = new ArrayList<>();
		ArrayList<String> sinks = new ArrayList<>();

		for (Asset asset : dfd.getAsset()) {
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				NamedEntity assetsource = asset.getSource();
				List<Element> assettargets = asset.getTargets();

				Set<AbstractCorrespondence> flowSourceCorrespondences = findSources(mapper, asset, assetsource);

				Set<AbstractCorrespondence> flowSinkCorrespondences = findSinks(mapper, asset, assetsource,
						assettargets);

				// set all as source for analyzer
				for (AbstractCorrespondence c : flowSourceCorrespondences) {
					sinks.add(SignatureHelper.getSootSignature((TMethodDefinition) CorrespondenceHelper.getSource(c)));
				}
				// set all as sinks for analyzer
				for (AbstractCorrespondence c : flowSinkCorrespondences) {
					sinks.add(SignatureHelper.getSootSignature((TMethodDefinition) CorrespondenceHelper.getSource(c)));
				}
			}
		}
		// new structure for hashmap
		SourceAndSink sourcesinks = new SourceAndSink(sources, sinks);
		return sourcesinks;
	}

	private Set<AbstractCorrespondence> findSinks(Mapper m, Asset asset, NamedEntity assetsource,
			List<Element> assettargets) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		for (Element el : assettargets) {
			sinks.addAll(getAcceptedMappings(m, el));

			if (sinks.isEmpty()) {
				// there is no mapping of asset source element -> get the previous element
				Stream<Flow> transporterFlows = getTargetFlows(asset, assetsource);
				// collect the processes of the incoming flows:
				// TODO: Is this assignment correct?
				sinks = transporterFlows.flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> getAcceptedMappings(m, target).parallelStream()).collect(Collectors.toSet());

			}
		}
		return sinks;
	}

	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource) {
		Set<AbstractCorrespondence> sources = getAcceptedMappings(m, assetsource);
		if (sources.isEmpty()) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getSourceFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> getAcceptedMappings(m, target).parallelStream()).collect(Collectors.toSet());
		}
		return sources;
	}

	private Stream<Flow> getTargetFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getInflows().parallelStream()
				.filter(inflow -> inflow.getAssets().contains(asset)).distinct();
	}

	private Stream<Flow> getSourceFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getOutflows().parallelStream()
				.filter(outflow -> outflow.getAssets().contains(asset)).distinct();
	}
}
