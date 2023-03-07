package org.gravity.mapping.secdfd.checks.impl.flowdroid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Objective;
import org.secdfd.model.Priority;

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration.AliasingAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.CallgraphAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.util.MultiMap;

public class DFAnalysis {
	private static final Logger LOGGER = Logger.getLogger(DFAnalysis.class);

	private final Mapper mapper;
	private final String appPath;
	private final String libPath;
	SourcesAndSinkFinder sas;
	private final Set<String> truePositives;
	private final Set<String> falsePositives;
	private final Set<String> falseNegatives;

	public Set<String> getTPInjectedLeaks() {
		return this.truePositives;
	}

	public Set<String> getFPInjectedLeaks() {
		return this.falsePositives;
	}

	public Set<String> getFNInjectedLeaks() {
		return this.falseNegatives;
	}

	/**
	 * @return the sas
	 */
	public SourcesAndSinkFinder getSas() {
		return this.sas;
	}

	private final int limit;

	public DFAnalysis(final Mapper mapper, final IJavaProject project, final boolean susi, final int limit)
			throws IOException, JavaModelException {
		this.mapper = mapper;
		this.limit = limit;

		// get base line sources (FlowDroid published sources) and sinks (FlowDroid
		// sinks + SuSi list of sinks) for experiment
		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.truePositives = new HashSet<>();
		this.falsePositives = new HashSet<>();
		this.falseNegatives = new HashSet<>();

		// set up paths for application and library to pass to flowdroid
		final var outputLocation = project.getOutputLocation();
		final var projectLocation = project.getProject().getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	// when called from UI, we have to get project from gravity folder
	public DFAnalysis(final Mapper mapper, final boolean susi, final int limit, final IFolder gravityFolder)
			throws IOException, CoreException {
		this.mapper = mapper;
		this.limit = limit;

		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.truePositives = new HashSet<>();
		this.falsePositives = new HashSet<>();
		this.falseNegatives = new HashSet<>();

		final var iproject = gravityFolder.getProject();
		final var ijavaProj = (IJavaProject) iproject.getNature(JavaCore.NATURE_ID);
		final var outputLocation = ijavaProj.getOutputLocation();
		final var projectLocation = iproject.getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	public Results checkAllAssets() {
		final var results = new Results();
		for (final Asset asset : this.mapper.getDFD().getAsset()) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
				results.add(checkAsset(asset));
			}
		}
		return results;
	}

	/**
	 * try to inject high labels (as many as candidates)
	 *
	 * @return
	 */
	public Results checkAllAssetsInject() {
		final var results = new Results();
		final var dfd = this.mapper.getDFD();
		final var candidates = getAssetsForInjection(dfd);

		if (!candidates.isEmpty()) {
			injectAndCheckAssets(candidates).forEach(res -> {
				results.add(res);
			});
		} else {
			LOGGER.info("Found no candidate asset to inject a high label. Proceeding as usual...");
		}

		// check remaining assets
		final var rest = dfd.getAsset();
		rest.removeAll(candidates);
		for (final Asset asset : rest) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
				results.add(checkAsset(asset));
			}
		}
		return results;
	}



	/**
	 * @param candidates
	 * @return Set of asset results
	 */
	private Set<AssetResults> injectAndCheckAssets(final Set<Asset> candidates) {
		final Set<AssetResults> allRes = new HashSet<>();
		// inject confidentiality high
		modifyCandidates(candidates);
		for (final Asset asset : candidates) {
			// look for sources, sinks, epoints, put all allowed to forbidden
			final var result = GetAssetSourceSinks(asset);
			// the allowed were added as forbidden sinks (and to sinks) now due to injection
			final var forbidden = result.getForbiddenSinks();
			// if no application specific (DFD derived) forbidden sinks, then we only get
			// FPs - skip...
			// also if forbidden == sources -> means we want to inject a leak within the
			// same DFD element, makes no sense, skip...
			if (!forbidden.isEmpty() && !result.getSources().containsAll(forbidden)) {
				// run flow droid
				System.out.println("Injecting for asset: " + asset.getName());
				final var epoints = this.sas.getEntryPoints();
				final Set<Element> DFDForbiddenElements = forbidden.parallelStream()
						.map(forbid -> SignatureHelper.getDefinition(this.mapper.getPM(), forbid))
						.filter(Objects::nonNull)
						.flatMap(TMethodDefForbidden -> {
							final var stream1 = this.mapper.getMapping(TMethodDefForbidden);
							final var stream2 = this.mapper.getDataStoreMapping(TMethodDefForbidden.getDefinedBy());
							return Stream.concat(stream1.stream(),
									stream2.stream());})
						.collect(Collectors.toSet());

				result.addAllResults(check(result.getSources(), result.getSinks(), epoints));

				// flatten results
				final Set<MultiMap<ResultSinkInfo, ResultSourceInfo>> infoflowres = result.getSingleResults().parallelStream()
						.map(Entry::getValue).map(InfoflowResults::getResults).collect(Collectors.toSet());

				infoflowres.remove(null);

				final Set<TMethodDefinition> identifiedSinks = new HashSet<>();


				final Set<Element> unmatchedDFDElements = new HashSet<>(DFDForbiddenElements);
				infoflowres.forEach(map -> {
					for (final ResultSinkInfo sink : map.keySet()) {
						final var sinkMethod = sink.getStmt().getInvokeExpr().getMethod().getSignature();
						final var mappedSink = SignatureHelper.getDefinition(this.mapper.getPM(),sinkMethod);
						identifiedSinks.add(mappedSink);
						final Set<Element> dfdelements = new HashSet<>(this.mapper.getMapping(mappedSink));
						//we need to add the mappings of the defined type (data stores)
						dfdelements.addAll(this.mapper.getDataStoreMapping(mappedSink.getDefinedBy()));

						if (!dfdelements.isEmpty() && containsAny(dfdelements, DFDForbiddenElements)) {
							//expected FP (TP)
							dfdelements.forEach(dfdel -> {
								this.truePositives.add(asset.getSource().getName() + ", " + dfdel.getName());
								unmatchedDFDElements.remove(dfdel);
							});
						} else {
							//FP
							this.falsePositives.add(asset.getSource().getName() + ", " + mappedSink.getSignatureString());
						}

					}
				});
				// FN
				for (final Element i : unmatchedDFDElements) {
					this.falseNegatives.add(asset.getSource().getName() + ", " + i.getName());
				}
				allRes.add(result);
			}
		}
		return allRes;
	}

	/**
	 * @param mappedSink
	 * @param DFDForbiddenElements
	 * @return
	 */
	private boolean containsAny(final Set<Element> dfel, final Set<Element> DFDForbiddenElements) {
		return dfel.parallelStream().anyMatch(m -> DFDForbiddenElements.contains(m));
	}

	/**
	 * @param assets
	 *
	 */
	private void modifyCandidates(final Set<Asset> assets) {
		assets.forEach(asset -> {
			// if it's not confidential, inject label
			// if(asset.getValue().stream().noneMatch(value ->
			// Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
			final var injectedValue = ModelFactory.eINSTANCE.createValue();
			injectedValue.setObjective(Objective.CONFIDENTIALITY);
			injectedValue.setPriority(Priority.H);
			asset.getValue().add(injectedValue);
			LOGGER.info("Injected high confidentiality label to asset: " + asset.getName());
			// }
		});
	}

	/**
	 * @param dfd
	 * @return Set<Asset> find non-confidential assets that exit the system (i.e.,
	 *         the asset target is EE or DS).
	 */
	private Set<Asset> getAssetsForInjection(final EDFD dfd) {
		final Set<Asset> nonconfidentialAssets = dfd.getAsset().parallelStream()
				.filter(asset -> asset.getValue().stream()
						.noneMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective())))
				.filter(asset -> asset.getTargets().stream()
						.anyMatch(target -> (target instanceof ExternalEntity) || (target instanceof DataStore)))
				.collect(Collectors.toSet());
		return nonconfidentialAssets;
	}

	/**
	 * @param asset The asset to check
	 * @return The results of the DF-analysis per entry point
	 */
	private AssetResults checkAsset(final Asset asset) {
		// calculate source and sinks for the asset
		final var sourcesAndSinks = this.sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(),
					Collections.emptyMap(), Collections.emptySet());
		}

		final List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		final List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		final List<String> forbinnedSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());

		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, forbinnedSinks, Collections.emptyMap(), sourcesAndSinks.getAllowed());
		}

		final var epoints = this.sas.getEntryPoints();
		final var map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, forbinnedSinks, map, sourcesAndSinks.getAllowed());
	}

	private AssetResults GetAssetSourceSinks(final Asset asset) {
		// calculate source and sinks for the asset
		final var sourcesAndSinks = this.sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(),
					Collections.emptyMap(), Collections.emptySet());
		}

		final List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		final List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		final List<String> derivedAsForbiddenSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());
		final var allowed = sourcesAndSinks.getAllowed();

		// add all allowed sinks
		for (final String allowedsink : allowed) {
			if (allowedsink != "") {
				sinks.add(allowedsink);
				derivedAsForbiddenSinks.add(allowedsink);

			}
		}
		return new AssetResults(asset, sources, sinks, derivedAsForbiddenSinks, Collections.emptyMap(), allowed);
	}

	/**
	 * @param sources
	 * @param sinks
	 * @param epoints
	 * @return
	 */
	public Map<String, InfoflowResults> check(final Collection<String> sources, final Collection<String> sinks,
			final Collection<String> epoints) {
		return epoints.stream()
				.collect(Collectors.toMap(entryPoint -> entryPoint, entryPoint -> check(sources, sinks, entryPoint)));
	}

	/**
	 * @param sources
	 * @param sinks
	 * @param entryPoint
	 * @return
	 */
	public InfoflowResults check(final Collection<String> sources, final Collection<String> sinks, final String entryPoint) {
		// for itrust add_health_record, this violation should be found!?
		//		sinks.contains("<java.sql.Connection: java.sql.PreparedStatement prepareStatement(java.lang.String)>");
		//		sources.add("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
		//		sources.contains("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
		final var infoflow = initInfoflow(Collections.emptyMap(), this.limit);
		infoflow.computeInfoflow(this.appPath, this.libPath, entryPoint, sources, sinks);
		final var results = infoflow.getResults();
		if (results == null) {
			return new InfoflowResults();
		}
		if (results.isEmpty()) {
			return results;
		}
		final var map = results.getResults();
		// Remove sinks that are allowed sinks -> removed EasyTaintWrapper.txt (might be
		// the reason)
		for (final ResultSinkInfo sink : map.keySet()) {
			final var method = sink.getStmt().getInvokeExpr().getMethod();
			if (!sinks.contains(method.toString())) {
				map.remove(sink);
			}
		}
		return results;
	}

	protected IInfoflow initInfoflow(final Map<String, Set<String>> taintedMethods, final int limit) {
		// reset soot and initialize flowdroid configuration
		soot.G.reset();
		final var result = new Infoflow("", false, null);
		result.setSootConfig((options, config) -> {
			options.set_whole_program(true);
			options.set_exclude(Arrays.asList("java.util.*"));
			options.set_no_bodies_for_excluded(true);
			options.set_allow_phantom_refs(true);
			options.setPhaseOption("jb", "use-original-names:true");
			options.set_ignore_classpath_errors(true);
			options.set_verbose(true);

			config.setInspectSources(false);
			config.setInspectSinks(false);
			config.setCallgraphAlgorithm(CallgraphAlgorithm.AutomaticSelection);
			config.setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows); //try without
			config.setAliasingAlgorithm(AliasingAlgorithm.FlowSensitive); //try without
			config.setStopAfterFirstKFlows(limit);
		});
		result.setTaintWrapper(new EasyTaintWrapper(taintedMethods));
		return result;
	}

}
