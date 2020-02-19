package org.gravity.flowdroid;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.typegraph.basic.TConstructor;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.Flow;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.NamedEntity;


public class SourcesAndSinks {
	
	/**
	 * The logger of this class
	 */
	static final Logger LOGGER = Logger.getLogger(SourcesAndSinks.class);
	
	public static Set<AbstractCorrespondence> getMappings(Mapper mapper, EObject dfdelement) {
		EList<AbstractCorrespondence> allcorresp = mapper.getMapping().getUserdefined();
		allcorresp.addAll(mapper.getMapping().getSuggested());
		allcorresp.addAll(mapper.getMapping().getAccepted());
		
		return allcorresp.parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement)).collect(Collectors.toSet());
	}

	public SourceAndSink getSourceSinks(Mapper mapper, EDFD dfd) {
		SourceAndSink sourceAndSink = new SourceAndSink();

		for (Asset asset : dfd.getAsset()) {
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				NamedEntity assetsource = asset.getSource();
				//optimize by only taking entry points (EE, DS)
				if (assetsource instanceof ExternalEntity || assetsource instanceof DataStore) {
					List<Element> assettargets = asset.getTargets();
					//find source correspondences
					Set<AbstractCorrespondence> flowSourceCorrespondences = findSources(mapper, asset, assetsource);
					//if user has set attacker zone, find correspondences of those for sinks
					Set<AbstractCorrespondence> flowSinkCorrespondences = findTrustZoneSinks(mapper, asset, dfd);
					//else, find correspondences for asset targets and set as sinks
					if (flowSinkCorrespondences.isEmpty()) {
						//TODO: raise an issue to developer to model attacker observation in trust zone!
						LOGGER.log(Level.ERROR, "Modeling attacker observation zones in the SecDFD are required for executing data flow analysis.");
						//flowSinkCorrespondences = findSinks(mapper, asset, assetsource,
						//		assettargets);					
					}
					//TODO: add all signatures from Susi lists, that are not in conflict with the flowSinkCorrespondences
					addSootSignatures(flowSourceCorrespondences, sourceAndSink.getSources());
					addSootSignatures(flowSinkCorrespondences, sourceAndSink.getSinks());
				}
			}
		}
		// new structure for hashmap
		return sourceAndSink;
	}

	/**
	 * Adds the signatures of the correspondences to the set
	 * 
	 * @param correspondences The correspondences
	 * @param signatures The set of signatures to be populated
	 */
	private void addSootSignatures(Collection<AbstractCorrespondence> correspondences, Set<String> signatures) {
		for (AbstractCorrespondence c : correspondences) {
			EObject source = CorrespondenceHelper.getSource(c);
			if (source instanceof TMethodDefinition && !TConstructor.isConstructor((TMember) source)) {
				signatures.add(SignatureHelper.getSootSignature((TMethodDefinition) source));
			}
		}
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
			sinks.addAll(getMappings(mapper, e));
		}
		return sinks;
	}

	private Set<AbstractCorrespondence> findEpoints(Mapper mapper, Element element) {
		//even if only one element on DFD, we can have several mappings, therefore several entry points for the analyzer
		Set<AbstractCorrespondence> epoints = getMappings(mapper, element);
		if (epoints.isEmpty()) {
			// there is no mapping of epoint element -> get the next elements
			EList<Flow> transporterflows = element.getOutflows();
			// collect the processes of the outgoing flows
			return transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
			.flatMap(target -> getMappings(mapper, target).parallelStream()).collect(Collectors.toSet());
		}
		return epoints;
	}

	private Set<AbstractCorrespondence> findSinks(Mapper m, Asset asset, NamedEntity assetsource,
			List<Element> assettargets) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		for (Element el : assettargets) {
			sinks.addAll(getMappings(m, el));

			if (sinks.isEmpty()) {
				// there is no mapping of asset source element -> get the previous element
				Stream<Flow> transporterFlows = getTargetFlows(asset, assetsource);
				// collect the processes of the incoming flows:
				sinks.addAll(transporterFlows.flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> getMappings(m, target).parallelStream()).collect(Collectors.toSet()));
			}
		}
		return sinks;
	}

	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource) {
		Set<AbstractCorrespondence> sources = getMappings(m, assetsource);
		if (sources.isEmpty()) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getSourceFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> getMappings(m, target).parallelStream()).collect(Collectors.toSet());
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
