package org.gravity.mapping.secdfd.checks.impl.flowdroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.Activator;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TClass;
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

	public class Pair {
		private NamedEntity element;
		private Asset asset;

		Pair(NamedEntity el, Asset as) {
			this.element = el;
			this.asset = as;
		}
	}

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(SourcesAndSinkFinder.class);

	private static final String SOURCES = "susi/sources.txt"; //already includes SQL sources
	private static final String SINKS = "susi/sinks.txt"; //already includes SQL sources
	// private static final String ADDITIONAL_SOURCES =
	// "susi/additional-sources.txt";
	private static final String ADDITIONAL_SINKS = "susi/additional-sinks.txt";

	private final Set<String> entryPoints;
	private final Set<String> baselineSources;
	private final Set<String> baselineSinks;
	private final Set<String> additionalSinks;
	private Set<String> forbiddenSinks;

	private Mapper mapper;

	public SourcesAndSinkFinder(Mapper mapper, boolean susi) throws IOException {
		this.mapper = mapper;
		this.forbiddenSinks = new HashSet<>();
		this.additionalSinks = read(ADDITIONAL_SINKS);

		// find entry points
		Set<TMethodDefinition> entryPointDefinitions = findEntryPoints();
		this.entryPoints = getSootSignatures(entryPointDefinitions);

		if (susi) {
			this.baselineSources = read(SOURCES);
			this.baselineSinks = read(SINKS);
		} else {
			baselineSources = Collections.emptySet();
			baselineSinks = Collections.emptySet();
		}
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private Set<String> read(String file) throws IOException {
		Set<String> tmp;
		URL sourcesEntry = Activator.getInstance().getBundle().getEntry(file);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(sourcesEntry.openStream()))) {
			tmp = reader.lines().collect(Collectors.toSet());
		}
		return tmp;
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
		// find source correspondences
		// Set<? extends TMember> flowSourceCorrespondences = findSources(asset);
		Set<? extends TMember> flowSourceCorrespondences = findSourcesBackwards(asset);
		if (flowSourceCorrespondences.isEmpty()) {
			return null;
		}
		// format to soot signature
		Set<String> sources = getSootSignatures(flowSourceCorrespondences);

		// find sinks
		SinkFinder sinkFinder = new SinkFinder(mapper, asset);
		Set<? extends TMember> flowSinkCorrespondences = sinkFinder.getForbiddensinks();
		Set<? extends TMember> flowAllowedSinkCorrespondences = sinkFinder.getAllowedsinks();

		if (flowSinkCorrespondences.isEmpty()) {
			LOGGER.log(Level.ERROR,
					"No sinks found. Modeling attacker observation zones in the SecDFD are required for executing data flow analysis.");
		}

		Set<String> sinks = getSootSignatures(flowSinkCorrespondences);
		// add only relevant susi sinks (remove allowed)
		sinks.addAll(getForbiddenSinks(sinkFinder, getBaselineSinks()));
		// remember also just the DFD derived sinks
		forbiddenSinks = getSootSignatures(flowSinkCorrespondences);
		forbiddenSinks.removeIf(sink -> sink.equals(""));// remove empty strings
		return new SourceAndSink(sources, sinks, forbiddenSinks, getSootSignatures(flowAllowedSinkCorrespondences));
	}

	/**
	 * Adds the signatures of the correspondences to the set
	 * 
	 * @param correspondenceOrAFE The correspondences or abstract flow elements
	 */
	public Set<String> getSootSignatures(Collection<? extends TMember> correspondenceOrAFE) {
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
				TAbstractType definedBy = def.getDefinedBy();
				if (definedBy instanceof TClass) {
					epoints.add(def);
				}
			} else {
				definitions.addAll(sources);
			}
		}
		return epoints;
	}

	// When looking for sources - if Process has a contact for asset, follow
	// backwards
	private Set<? extends TMember> findSourcesBackwards(Asset asset) {
		NamedEntity assetsource = asset.getSource();
		Set<TMember> allSources = new HashSet<>();
		Set<Pair> seen = new HashSet<>();

		Deque<Pair> elementsToCheck = new LinkedList<Pair>();
		Pair firstPair = new Pair(assetsource, asset);
		elementsToCheck.add(firstPair);

		while (!elementsToCheck.isEmpty()) {
			Pair c = elementsToCheck.pop();
			NamedEntity currentEl = c.element;
			Asset currentAs = c.asset;
			if (seen.contains(c)) {
				continue;
			}
			// if process possibly go backwards
			if (currentEl instanceof Process) {
				// incoming assets to contract are possible to track backwards (if multiple
				// incoming assets -- join, conservatively follow
				// all paths)
				Set<Asset> assetsToFollow = ((Process) currentEl).getResponsibility().parallelStream()
						.filter(r -> r.getOutcomeassets().contains(currentAs))
						.flatMap(contract -> contract.getIncomeassets().stream()).collect(Collectors.toSet());
				if (!assetsToFollow.isEmpty()) {
					for (Asset toFollow : assetsToFollow) {
						Set<NamedEntity> checkAlso = ((Process) currentEl).getInflows().parallelStream()
								.filter(dataflow -> dataflow.getAssets().contains(toFollow))
								.map(flow -> flow.getSource()).collect(Collectors.toSet());
						for (NamedEntity el : checkAlso) {
							elementsToCheck.add(new Pair(el, toFollow));
						}
					}
				} else {
					// the asset can't be traced backwards anymore
					allSources.addAll(mapper.getMapping((Process) assetsource));
				}
			}
			// if DS or EE, get sources as usual
			if (currentEl instanceof ExternalEntity) {
				allSources.addAll(findEntitySources(currentAs, currentEl));
			}
			if (currentEl instanceof DataStore) {
				allSources.addAll(findStoreSources(currentAs, currentEl));
			}
			seen.add(c);
		}
		return allSources;

	}

	/**
	 * @param asset
	 * @param currentEl
	 */
	private Set<? extends TMember> findStoreSources(Asset asset, NamedEntity currentEl) {
		final Collection<TAbstractType> assetTypes = mapper.getMapping(asset);
		final Collection<TMember> processMembers = ((DataStore) currentEl).getOutflows().parallelStream()
				.map(Flow::getTarget).flatMap(Collection::parallelStream).filter(Process.class::isInstance)
				.map(Process.class::cast).map(mapper::getMapping).flatMap(Collection::parallelStream)
				.collect(Collectors.toSet());
		Set<? extends EObject> pmElements = mapper.getMapping((DataStore) currentEl);
		return pmElements.parallelStream().flatMap(element -> {
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

	}

	/**
	 * @param asset
	 * @param currentEl
	 */
	private Set<? extends TMember> findEntitySources(Asset asset, NamedEntity currentEl) {
		// there is no mapping of EE source element -> get the next element
		Stream<Flow> transporterflows = getTargetFlows(asset, currentEl);
		// collect the processes of the outgoing flows:
		return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
				.flatMap(target -> mapper.getMapping(target).parallelStream()).filter(TMember.class::isInstance)
				.map(TMember.class::cast).collect(Collectors.toSet());

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

	public Set<String> getForbiddenSinks(SinkFinder sinkFinder, Set<String> susisinks) {
		Set<TMember> allowedSinks = sinkFinder.getAllowedsinks();
		if (allowedSinks != null) {
			Set<String> sinks = new HashSet<>();
			Set<String> allowed = getSootSignatures(allowedSinks);
			// allowed (PM) have a different return type as additional sinks - disregard
			allowed = checkReturnTypeOfAllowed(allowed);

			for (String susi : susisinks) {
				if (!allowed.contains(susi)) {
					sinks.add(susi);
				} else {
					System.out.println("Removed an allowed sink: " + susi);
				}
			}
			return sinks;
		} else {
			return new HashSet<>(susisinks);
		}

	}

	/**
	 * @param allowed
	 * @return
	 * @throws IOException
	 */
	private Set<String> checkReturnTypeOfAllowed(Set<String> allowed) {
		Set<String> all = new HashSet<>();
		all.addAll(allowed);
		allowed.forEach(allowedSink -> {
			additionalSinks.forEach(additionalSink -> {
				if (allowedSink.split(" ")[0].equals(additionalSink.split(" ")[0])
						&& allowedSink.split(" ")[2].equals(additionalSink.split(" ")[2])) {
					// only return type differs, set to correct string - void (same as original)
					all.remove(allowedSink);
					all.add(additionalSink);
				}
			});
		});
		return all;
	}

	/**
	 * @return the baselineSinks
	 */
	public Set<String> getBaselineSinks() {
		return baselineSinks;
	}

	public Set<String> getForbiddenSinks() {
		return forbiddenSinks;
	}

	/**
	 * @return the baselineSources
	 */
	public Set<String> getBaselineSources() {
		return baselineSources;
	}

	public Set<String> getEntryPoints() {
		return entryPoints;
	}

}
