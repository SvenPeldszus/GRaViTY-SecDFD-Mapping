package org.gravity.flowdroid;

import java.io.IOException;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
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
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAccess;
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
import org.secdfd.model.Process;

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
	 * @param susi 
	 * @return
	 * @throws IOException
	 */
	public SourceAndSink getSourceSinks(IFolder gravity, Mapper mapper, EDFD dfd, boolean susi) throws IOException {
		SourceAndSink sourceAndSink = new SourceAndSink();
		// find entry points
		Set<TMethodDefinition> entryPoints = findEntryPoints(mapper, mapper.getDFD());
		addSootSignatures(entryPoints, sourceAndSink.getEpoints());

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
		if (susi) {
			Set<String> susisinks = SinkFinder.loadSinksFromFile(gravity);
			sourceAndSink.getSinks().addAll(susisinks);
		}
		return sourceAndSink;
	}

	/**
	 * Adds the signatures of the correspondences to the set
	 * 
	 * @param correspondences The correspondences or abstract flow elements
	 * @param signatures      The set of signatures to be populated
	 */
	private void addSootSignatures(Collection<? extends EObject> correspondenceOrAFE, Set<String> signatures) {
		for (EObject el : correspondenceOrAFE) {
			EObject source = null;
			if (el instanceof AbstractCorrespondence) {
				source = CorrespondenceHelper.getSource((AbstractCorrespondence) el);
			} else if (el instanceof TAbstractFlowElement) {
				source = el;
			}
			if (source instanceof TMethodDefinition && !TConstructor.isConstructor((TMember) source)) {
				signatures.add(SignatureHelper.getSootSignature((TMethodDefinition) source));
			}
		}
	}

	public Set<TMethodDefinition> findEntryPoints(Mapper mapper, EDFD dfd) {
		Set<TMethodDefinition> entryProcesses = dfd.getElements().parallelStream()
				.filter(ExternalEntity.class::isInstance)
				.flatMap(external -> Stream.concat(external.getInflows().parallelStream().map(Flow::getSource),
						external.getOutflows().parallelStream().map(Flow::getTarget)
								.flatMap(Collection::parallelStream)))
				.filter(Process.class::isInstance).map(e -> (Process) e).map(mapper::getMapping)
				.flatMap(Collection::parallelStream).collect(Collectors.toSet());

		Set<TMethodDefinition> epoints = new HashSet<>();
		Set<TMethodDefinition> seen = new HashSet<>();
		Deque<TMethodDefinition> definitions = new LinkedList<>(entryProcesses);
		while (!definitions.isEmpty()) {
			TMethodDefinition def = definitions.pop();
			if (seen.contains(def)) {
				continue;
			}
			seen.add(def);

			Set<TMethodDefinition> sources = def.getAccessedBy().parallelStream().map(TAccess::getTSource)
					.filter(TMethodDefinition.class::isInstance).map(m -> (TMethodDefinition) m)
					.filter(source -> (!mapper.getMapping(source).isEmpty())).collect(Collectors.toSet());
			if (sources.isEmpty()) {
				epoints.add(def);
			} else {
				definitions.addAll(sources);
			}
		}
		return epoints;
	}

	/**
	 * Finds the entry points of dfd by collecting the correspondences of outgoing
	 * processes from EE and DS then backward step through call graph to find the
	 * root method that calls this process simply following accessedBy in PM
	 * 
	 * @param mapper
	 * @param dfd
	 * @return
	 */
	public Set<AbstractCorrespondence> findEpoints(Mapper mapper, EDFD dfd) {
		Set<AbstractCorrespondence> corr_epoints = new HashSet<>();
		// EE and DS with outgoing flows
		Set<Element> elements = dfd.getElements().parallelStream().filter(el -> !el.getOutflows().isEmpty())
				.filter(el -> (el instanceof ExternalEntity)).collect(Collectors.toSet());
		for (Element element : elements) {
			Set<AbstractCorrespondence> corresp = SinkFinder.getMappings(mapper, element);
			if (corresp.isEmpty()) {
				// there is no mapping of epoint element -> get the next elements
				Set<Flow> transporterflows = element.getOutflows().parallelStream()
						.filter(flow -> flow.getTarget().size() > 0).collect(Collectors.toSet());
				// collect the processes correspondences of the outgoing flows
				corr_epoints.addAll(transporterflows.parallelStream().flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> SinkFinder.getMappings(mapper, target).parallelStream())
						.collect(Collectors.toSet()));
			}

		}
		// optionally find other entry points (outside the scenario of the secDFD)
		// Set<EObject> root_epoints = new HashSet<>();
		// root_epoints = epoints_outside_secdfd(corr_epoints, root_epoints);

		return corr_epoints;
	}

	/**
	 * @param corr_epoints
	 * @param root_epoints
	 * @return
	 */
	// so far we only found correspondences, need to find root method call (e.g.,
	// main method) to get entry point
	private Set<EObject> epoints_outside_secdfd(Set<AbstractCorrespondence> corr_epoints, Set<EObject> root_epoints) {
		Set<TMethodDefinition> methods = corr_epoints.parallelStream()
				.filter(cor -> (CorrespondenceHelper.getSource(cor) instanceof TMethodDefinition))
				.map(m -> (TMethodDefinition) CorrespondenceHelper.getSource(m)).collect(Collectors.toSet());

		for (TMethodDefinition m : methods) {
			// find root of access, backwards search
			for (TAccess access : m.getAccessedBy()) {
				root_epoints.add(findRootAccess(access));
			}
		}
		return root_epoints;
	}

	private TMethodDefinition findRootAccess(TAccess access) {
		// exit when no incoming flows (EE)
		EObject el = access.eContainer();
		if (el instanceof TMethodDefinition) {
			TMethodDefinition meth = (TMethodDefinition) el;
			if (meth.getAccessedBy().isEmpty()) {
				return meth;
			} else {
				for (TAccess naccess : meth.getAccessedBy()) {
					return findRootAccess(naccess);
				}
			}
		}
		return null;
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
		// find pm method signatures that take mapped type as parameter
		// filter, will get many FP
		// set them as parameterTaintMethods for FlowDroid

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
