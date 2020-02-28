package org.gravity.flowdroid;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
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
	 * Gets entry points, sources and sinks
	 * 
	 * @param gravity
	 * @param mapper
	 * @param dfd
	 * @return
	 * @throws IOException
	 */
	public SourceAndSink getSourceSinks(IFolder gravity, Mapper mapper, EDFD dfd) throws IOException {
		SourceAndSink sourceAndSink = new SourceAndSink();
		// find entry points
		addSootSignatures(findEpoints(mapper, mapper.getDFD()), sourceAndSink.getEpoints());

		// find source by confidential assets
		for (Asset asset : dfd.getAsset()) {
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				NamedEntity assetsource = asset.getSource();
				// only taking EE, DS
				if (assetsource instanceof ExternalEntity || assetsource instanceof DataStore) {
					// find source correspondences
					Set<AbstractCorrespondence> flowSourceCorrespondences = findSources(mapper, asset, assetsource);
					// format to soot signature
					addSootSignatures(flowSourceCorrespondences, sourceAndSink.getSources());
				}

			}
		}
		// find sinks
		Set<AbstractCorrespondence> flowSinkCorrespondences = SinkFinder.findSinks(mapper, dfd);
		addSootSignatures(flowSinkCorrespondences, sourceAndSink.getSinks());
		// else, find correspondences for incoming flows to EE and DS
		if (flowSinkCorrespondences.isEmpty()) {
			// TODO: raise an issue to developer to model attacker
			LOGGER.log(Level.ERROR,
					"No sinks found. Modeling attacker observation zones in the SecDFD are required for executing data flow analysis.");
		}
		Set<String> susisinks = SinkFinder.loadSinksFromFile(gravity);
		sourceAndSink.getSinks().addAll(susisinks);
		return sourceAndSink;
	}

	/**
	 * Adds the signatures of the correspondences to the set
	 * 
	 * @param correspondences The correspondences
	 * @param signatures      The set of signatures to be populated
	 */
	private void addSootSignatures(Collection<AbstractCorrespondence> correspondences, Set<String> signatures) {
		for (AbstractCorrespondence c : correspondences) {
			EObject source = CorrespondenceHelper.getSource(c);
			if (source instanceof TMethodDefinition && !TConstructor.isConstructor((TMember) source)) {
				signatures.add(SignatureHelper.getSootSignature((TMethodDefinition) source));
			}
		}
	}

	/**
	 * Finds the entry points of dfd by collecting the correspondences of outgoing
	 * processes from EE and DS
	 * 
	 * @param mapper
	 * @param dfd
	 * @return
	 */
	public Set<AbstractCorrespondence> findEpoints(Mapper mapper, EDFD dfd) {
		Set<AbstractCorrespondence> epoints = null;
		// EE and DS with outgoing flows
		Set<Element> elements = dfd.getElements().parallelStream().filter(el -> !el.getOutflows().isEmpty())
				.filter(el -> (el instanceof ExternalEntity || el instanceof DataStore)).collect(Collectors.toSet());
		for (Element element : elements) {
			epoints = SinkFinder.getMappings(mapper, element);
			if (epoints.isEmpty()) {
				// there is no mapping of epoint element -> get the next elements
				Set<Flow> transporterflows = element.getOutflows().parallelStream()
						.filter(flow -> flow.getTarget().size() > 0).collect(Collectors.toSet());
				// collect the processes correspondences of the outgoing flows
				epoints.addAll(transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> SinkFinder.getMappings(mapper, target).parallelStream())
						.collect(Collectors.toSet()));
			}
		}
		return epoints;
	}

	/**
	 * Finds correspondences of assetsource outgoing processes that receive that
	 * asset
	 * 
	 * @param m
	 * @param asset
	 * @param assetsource
	 * @return
	 */
	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource) {
		Set<AbstractCorrespondence> sources = SinkFinder.getMappings(m, assetsource);
		if (sources.isEmpty()) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getTargetFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> SinkFinder.getMappings(m, target).parallelStream()).collect(Collectors.toSet());
		}
		return sources;
	}
	
	private Set<AbstractCorrespondence> findParameterTaintMethods(Mapper m, Asset asset) {
		Set<AbstractCorrespondence> paramTaintMethods = SinkFinder.getMappings(m, asset);
		//find pm method signatures that take mapped type as parameter
		// filter, will get many FP
		//set them as parameterTaintMethods for FlowDroid
		
		return paramTaintMethods;
	}
	
	private Set<AbstractCorrespondence> findReturnTaintMethods(Mapper m, Asset a) {
		return null;
	}
	
	

	/**
	 * Gets outgoing flows that communicate that asset
	 * 
	 * @param asset
	 * @param assetsource
	 * @return
	 */
	private Stream<Flow> getTargetFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getOutflows().parallelStream()
				.filter(outflow -> outflow.getAssets().contains(asset)).distinct();
	}

}
