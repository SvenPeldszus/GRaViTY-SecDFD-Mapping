package org.gravity.flowdroid;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
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

	
	/**
	 * 
	 * @param gravity 
	 * @param mapper
	 * @param dfd
	 * @return
	 * @throws IOException 
	 */
	public SourceAndSink getSourceSinks(IFolder gravity, Mapper mapper, EDFD dfd) throws IOException {
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
					Set<AbstractCorrespondence> flowSinkCorrespondences = SinkFinder.findTrustZoneSinks(mapper, asset, dfd);
					//else, find correspondences for asset targets and set as sinks
					if (flowSinkCorrespondences.isEmpty()) {
						//TODO: raise an issue to developer to model attacker observation in trust zone!
						LOGGER.log(Level.ERROR, "Modeling attacker observation zones in the SecDFD are required for executing data flow analysis.");
						//TODO: Debug sinks are empty!!!
						flowSinkCorrespondences = SinkFinder.findSinks(mapper, asset, assetsource,
								assettargets);
						//flowSinkCorrespondences = SinkFinder.loadSinksFromFile(gravity, flowSinkCorrespondences);
					}
					//TODO: add all signatures from Susi lists, that are not in conflict with the flowSinkCorrespondences
					addSootSignatures(flowSourceCorrespondences, sourceAndSink.getSources());
					addSootSignatures(flowSinkCorrespondences, sourceAndSink.getSinks());
					
				}
			}
		}
		addSootSignatures(findEpoints(mapper, mapper.getDFD()), sourceAndSink.getEpoints());
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

	public Set<AbstractCorrespondence> findEpoints(Mapper mapper, EDFD dfd) {
		Set<AbstractCorrespondence> epoints = null;
		for (Element element : dfd.getElements()) {
			//TODO: add outgoing from DataStore!
			if (element instanceof ExternalEntity) {
				//even if only one element on DFD, we can have several mappings, therefore several entry points for the analyzer
				epoints = SinkFinder.getMappings(mapper, element);
				if (epoints.isEmpty()) {
					// there is no mapping of epoint element -> get the next elements
					Set<Flow> transporterflows = element.getOutflows().parallelStream()
							.filter(flow -> flow.getTarget().size()>0).collect(Collectors.toSet());
					// collect the processes of the outgoing flows					
					Set<AbstractCorrespondence> e = transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
							.flatMap(target -> SinkFinder.getMappings(mapper, target).parallelStream()).collect(Collectors.toSet());
					epoints.addAll(transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> SinkFinder.getMappings(mapper, target).parallelStream()).collect(Collectors.toSet()));
				}				
			}	
		}
		return epoints;
	}


	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource) {
		Set<AbstractCorrespondence> sources = SinkFinder.getMappings(m, assetsource);
		if (sources.isEmpty()) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getSourceFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> SinkFinder.getMappings(m, target).parallelStream()).collect(Collectors.toSet());
		}
		return sources;
	}

	private Stream<Flow> getSourceFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getOutflows().parallelStream()
				.filter(outflow -> outflow.getAssets().contains(asset)).distinct();
	}

}
