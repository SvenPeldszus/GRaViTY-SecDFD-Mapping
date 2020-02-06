package org.gravity.flowdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;
import eDFDFlowTracking.TrustZone;

public class SourcesAndSinks {
	public static Set<AbstractCorrespondence> getAcceptedMappings(Mapper mapper, EObject dfdelement) {
		return mapper.getMapping().getAccepted().parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement)).collect(Collectors.toSet());
	}

	public SourceAndSink getSourceSinks(Mapper mapper, EDFD dfd) {
		ArrayList<String> sources = new ArrayList<>();
		ArrayList<String> sinks = new ArrayList<>();
		ArrayList<String> epoints = new ArrayList<>();

		for (Asset asset : dfd.getAsset()) {
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				NamedEntity assetsource = asset.getSource();
				List<Element> assettargets = asset.getTargets();

				Set<AbstractCorrespondence> flowSourceCorrespondences = findSources(mapper, asset, assetsource);
				
				//if user has set attacker zone, set those elements as sinks
				Set<AbstractCorrespondence> flowSinkCorrespondences = findTrustZoneSinks(mapper, asset, dfd);
				
				//else, set asset targets as sinks
				if (flowSinkCorrespondences.isEmpty()) {
					flowSinkCorrespondences = findSinks(mapper, asset, assetsource,
							assettargets);					
				}

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
		// search for first flow (0 or 1)
		Optional<Element> firstflow = dfd.getElements().stream().filter(Flow.class::isInstance).reduce((a,b) -> a.getNumber() > b.getNumber() ? b : a);
		if(firstflow.isPresent()) {
			//entry point can be inferred from model
			firstflow.get();
			findEpoints(mapper, ((Flow)firstflow.get()).getSource())
			.forEach(c -> 
				epoints.add(SignatureHelper.getSootSignature((TMethodDefinition) CorrespondenceHelper.getSource(c))));
			;
		}
		
		SourceAndSink sourcesinks = new SourceAndSink(sources, sinks, epoints);
		return sourcesinks;
	}

	private Set<AbstractCorrespondence> findTrustZoneSinks(Mapper mapper, Asset asset, EDFD dfd) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		
		//get trust zones with attacker observation > 0 and contains elements that handle asset
		Set<Element> trustzones = dfd.getTrustzones().parallelStream()
		.filter(zone -> zone.getAttackerprofile().parallelStream()
				.anyMatch(profile -> profile.getObservation()>0)
				)		
		.flatMap(zone -> zone.getElements().parallelStream())
				.filter(el -> el.getAssets().contains(asset))			
		.collect(Collectors.toSet());
		
		//since each Element has an Attacker attribute, easier to do
		Set<Element> attackerelements = dfd.getElements().parallelStream()
		.filter(el -> el.getAssets().contains(asset))
		.filter(el -> el.isAttacker())
		.collect(Collectors.toSet());
		//take the union of elements
		attackerelements.addAll(trustzones);
		
		for (Element e : attackerelements) {
			sinks.addAll(getAcceptedMappings(mapper, e));
		}
		return sinks;
	}

	private Set<AbstractCorrespondence> findEpoints(Mapper mapper, Element element) {
		//even if only one element on DFD, we can have several mappings, therefore several entry points for the analyzer
		Set<AbstractCorrespondence> epoints = getAcceptedMappings(mapper, element);
		if (epoints.isEmpty()) {
			// there is no mapping of epoint element -> get the next elements
			EList<Flow> transporterflows = element.getOutflows();
			// collect the processes of the outgoing flows
			return transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
			.flatMap(target -> getAcceptedMappings(mapper, target).parallelStream()).collect(Collectors.toSet());
		}
		return epoints;
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
				sinks.addAll(transporterFlows.flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> getAcceptedMappings(m, target).parallelStream()).collect(Collectors.toSet()));
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
