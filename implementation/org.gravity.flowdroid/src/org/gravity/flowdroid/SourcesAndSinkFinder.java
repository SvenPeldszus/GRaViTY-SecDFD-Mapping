package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TConstructor;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.Flow;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.NamedEntity;
import org.secdfd.model.Process;

public class SourcesAndSinkFinder {

	/**
	 * The logger of this class
	 */
	static final Logger LOGGER = Logger.getLogger(SourcesAndSinkFinder.class);

	private Set<String> entryPoints;
	private Set<String> susisinks;

	private Mapper mapper;

	private Set<String> baselineSources;

	public SourcesAndSinkFinder(Mapper mapper, boolean susi) throws IOException {
		this.mapper = mapper;

		// find entry points
		Set<TMethodDefinition> entryPointDefinitions = findEntryPoints();
		this.entryPoints = getSootSignatures(entryPointDefinitions);
		if (susi) {
			susisinks = SinkFinder.loadSinksFromFile(mapper.getGravityFolder().getFile("susiSinks.txt"));
		} else {
			susisinks = Collections.emptySet();
		}
	}

	/**
	 * Gets entry points, sources and sinks
	 * 
	 * @param gravity
	 * @param mapper
	 * @param susi
	 * @return
	 * @throws IOException
	 */
	public SourceAndSink getSourceSinks(Asset asset) {
		// find sources
		// find source correspondences
		Set<? extends TMember> flowSourceCorrespondences = findSources(asset);
		if (flowSourceCorrespondences.isEmpty()) {
			return null;
		}
		// format to soot signature
		Set<String> sources = getSootSignatures(flowSourceCorrespondences);

		// find sinks
		SinkFinder sinkFinder = new SinkFinder(mapper, asset, false);
		Set<? extends TMember> flowSinkCorrespondences = sinkFinder.getForbiddensinks();
		Set<String> sinks = getSootSignatures(flowSinkCorrespondences);
		if (flowSinkCorrespondences.isEmpty()) {
			// TODO: raise an issue to developer to model attacker
			LOGGER.log(Level.ERROR,
					"No sinks found. Modeling attacker observation zones in the SecDFD are required for executing data flow analysis.");
		}
		// sinks.addAll(susisinks);
		// add only relevant susi sinks (remove allowed)
		sinks.addAll(addSinksFromSusiSinks(sinkFinder, susisinks));

		return new SourceAndSink(sources, sinks, entryPoints);
	}

	/**
	 * Adds the signatures of the correspondences to the set
	 * 
	 * @param correspondenceOrAFE The correspondences or abstract flow elements
	 */
	private Set<String> getSootSignatures(Collection<? extends TMember> correspondenceOrAFE) {
		Set<String> signatures = new HashSet<>(correspondenceOrAFE.size());
		for (TMember source : correspondenceOrAFE) {
			if (source instanceof TMethodDefinition && !TConstructor.isConstructor(source)) {
				signatures.add(SignatureHelper.getSootSignature((TMethodDefinition) source));
			}
		}
		return signatures;
	}

	/**
	 * Searches the call-graph backwards until the DFD is exited starting from the
	 * ExternalEnties
	 * 
	 * @return The methods at the border of the DFD
	 */
	private Set<TMethodDefinition> findEntryPoints() {
		Set<TMethodDefinition> entryProcesses = mapper.getDFD().getElements().parallelStream()
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
			definitions.addAll(def.getOverriddenBy());
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
	 * Finds correspondences of assetsource outgoing processes that receive that
	 * asset
	 * 
	 * @param m
	 * @param asset
	 * @param assetsource
	 * @return
	 */
	// TODO: Improve
	private Set<? extends TMember> findSources(Asset asset) {
		NamedEntity assetsource = asset.getSource();
		if (assetsource instanceof ExternalEntity) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getTargetFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> mapper.getMapping(target).parallelStream())
					.filter(TMember.class::isInstance).map(TMember.class::cast)
					.collect(Collectors.toSet());
		}
		if (assetsource instanceof DataStore) {
			final Collection<TAbstractType> assetTypes = mapper.getMapping(asset);
			final Collection<TMember> processMembers = ((DataStore) assetsource).getOutflows().parallelStream()
					.map(Flow::getTarget).flatMap(Collection::parallelStream).filter(Process.class::isInstance)
					.map(Process.class::cast).map(mapper::getMapping).flatMap(Collection::parallelStream)
					.collect(Collectors.toSet());
			Set<? extends EObject> pmElements = mapper.getMapping((DataStore) assetsource);
			Set<TMember> members = pmElements.parallelStream().flatMap(element -> {
				if (element instanceof TMember) {
					return Stream.of((TMember) element);
				} else if (element instanceof TAbstractType) {
					TAbstractType tType = (TAbstractType) element;
					return tType.getDefines().parallelStream().filter(defined -> {
						if (defined instanceof TMethodDefinition) {
							TMethodDefinition method = (TMethodDefinition) defined;
							return assetTypes.contains(method.getReturnType());
						} else {
							return false;
						}
					}).map(TMethodDefinition.class::cast).filter(method -> {
						for (TAccess accessing : method.getAccessedBy()) {
							if (processMembers.contains(accessing.getTSource())) {
								return true;
							}
						}
						return false;
					});
				} else {
					return Stream.empty();
				}
			}).collect(Collectors.toSet());
			return members;
		}
		return mapper.getMapping((Process) assetsource);
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

	public Map<String, Set<String>> getBaseline() throws IOException {
		baselineSources = new HashSet<>();
		Set<String> baselineSinks = new HashSet<>();
		// susi list
		baselineSinks.addAll(susisinks);
		
		// get sinks from fiel flowdroid-sources-sinks.txt
		IOException exception = null;
		File file = mapper.getGravityFolder().getFile("flowdroid-sources-sinks.txt").getLocation().toFile();
		Set<String> additionalSinks = new HashSet<>();
		if (file.exists()) {
			try {
				for (String s : Files.readAllLines(file.toPath())) {
					// parse line
					if (s.endsWith("_SINK_") && (s.indexOf('<') > -1) && (s.indexOf('>') > -1) && !s.contains("android")) {
						s = s.substring(s.indexOf('<'), s.indexOf('>') + 1);
						additionalSinks.add(s);
					}
					if (s.endsWith("_SOURCE_") && (s.indexOf('<') > -1) && (s.indexOf('>') > -1) && !s.contains("android")) {
						s = s.substring(s.indexOf('<'), s.indexOf('>') + 1);
						baselineSources.add(s);
					}
				}
			} catch (IOException e) {
				exception = e;
			}
		}
		if (exception != null) {
			throw exception;
		}
		
		Map<String, Set<String>> baseline = new HashMap<>();
		baseline.put("baselineSources", baselineSources);
		baseline.put("baselineSinks", baselineSinks);
		return baseline;
	}
	
	public Set<String> addSinksFromSusiSinks(SinkFinder sinkFinder, Set<String> susisinks) {
		Set<String> sinks = new HashSet<>();
		Set<TMember> allowedSinks = sinkFinder.getAllowedsinks();
		
		if (allowedSinks != null) {
			Set<String> allowed = getSootSignatures(allowedSinks);
			for (String susi : susisinks) {
				if (!allowed.contains(susi)) {
					sinks.add(susi);
				} else {
					System.out.println("Removed an allowed sink: " + susi);
				}
			}
			return sinks;
		} else {
			sinks.addAll(susisinks);
			return sinks;
		}

	}

}
