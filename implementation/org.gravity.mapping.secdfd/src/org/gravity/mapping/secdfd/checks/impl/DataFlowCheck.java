package org.gravity.mapping.secdfd.checks.impl;

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
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.AssetResults;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.Results;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SourcesAndSinkFinder;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Objective;
import org.secdfd.model.Priority;

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration.AliasingAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.CallgraphAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.util.MultiMap;

public class DataFlowCheck implements ICheck {
	private static final Logger LOGGER = Logger.getLogger(DataFlowCheck.class);

	private final Mapper mapper;
	private final String appPath;
	private final String libPath;
	SourcesAndSinkFinder sas;
	private final Set<String> possibleLeaks;

	public Set<String> getPossibleLeaks() {
		return this.possibleLeaks;
	}

	/**
	 * @return the sas
	 */
	public SourcesAndSinkFinder getSas() {
		return this.sas;
	}

	private final int limit;

	public DataFlowCheck(final Mapper mapper, final IJavaProject project, final boolean susi, final int limit)
			throws IOException, JavaModelException {
		this.mapper = mapper;
		this.limit = limit;

		// get base line sources (FlowDroid published sources) and sinks (FlowDroid
		// sinks + SuSi list of sinks) for experiment
		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.possibleLeaks = new HashSet<>();

		// set up paths for application and library to pass to flowdroid
		final var outputLocation = project.getOutputLocation();
		final var projectLocation = project.getProject().getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	// when called from UI, we have to get project from gravity folder
	public DataFlowCheck(final Mapper mapper, final boolean susi, final int limit, final IFolder gravityFolder)
			throws IOException, CoreException {
		this.mapper = mapper;
		this.limit = limit;

		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.possibleLeaks = new HashSet<>();

		final var iproject = gravityFolder.getProject();
		final var ijavaProj = (IJavaProject) iproject.getNature(JavaCore.NATURE_ID);
		final var outputLocation = ijavaProj.getOutputLocation();
		final var projectLocation = iproject.getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	@Override
	public Collection<SResult> check(final Mapper mapper) {
		if (this.mapper != mapper) {
			return Collections.emptyList();
		}
		final var dfResults = checkAllAssets();
		return createMarkersForDFAnalysisResults(dfResults);
	}

	// add problems to each asset (duplicated source-sink pairs, because developer
	// may want to see which asset the leak effects)
	private Collection<SResult> createMarkersForDFAnalysisResults(final Results results) {
		final Set<SResult> problems = new HashSet<>();
		for (final AssetResults assetRes : results.getResultsPerAsset()) {
			final var strings = flatten(assetRes.getResults());
			if (!strings.isEmpty()) {
				final var description = new StringBuilder();
				for (final String str : strings) {
					description.append(str).append('\n');
				}
				problems.add(new SResult(PState.ERROR, null, assetRes.getAsset(), null,
						"The following source -> sink leaks have been detected: " + description.toString()));
			}
		}
		return problems;
	}

	/**
	 * @param map : asset results for each entry point
	 * @return flattened results of asset (merged entry points)
	 */
	private Set<String> flatten(final Map<String, InfoflowResults> map) {
		final Set<String> flattened = new HashSet<>();
		map.values().forEach(value -> {
			final var rs = value.getResultSet();
			if (rs != null) {
				rs.forEach(result -> {
					if (!inFlattened(result, flattened)) {
						flattened.add(result.getSource().getDefinition().toString() + ", "
								+ result.getSink().getDefinition().toString());
					}
				});
			}
		});
		return flattened;
	}

	private boolean inFlattened(final DataFlowResult result, final Set<String> flattened) {
		for (final String entry : flattened) {
			if (result.getSource().getDefinition().toString().contains(entry.split(", ")[0])
					&& result.getSink().getDefinition().toString().contains(entry.split(", ")[1])) {
				return true;
			}
		}
		return false;
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
			injectAndCheckAssets(candidates).forEach(results::add);
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
			final var result = getAssetSourceSinks(asset);
			// the allowed were added as forbidden sinks (and to sinks) now due to injection
			final var forbidden = result.getForbiddenSinks();
			// if no application specific (DFD derived) forbidden sinks, then we only get
			// FPs - skip...
			// also if forbidden == sources -> means we want to inject a leak within the
			// same DFD element, makes no sense, skip...
			if (!forbidden.isEmpty() && !result.getSources().containsAll(forbidden)) {
				// run flow droid
				LOGGER.info("Injecting for asset: " + asset.getName());
				final var epoints = this.sas.getEntryPoints();
				result.addAllResults(check(result.getSources(), result.getSinks(), epoints));

				// flatten results
				final Set<MultiMap<ResultSinkInfo, ResultSourceInfo>> infoflowres = result.getSingleResults()
						.parallelStream().map(Entry::getValue).map(InfoflowResults::getResults)
						.collect(Collectors.toSet());

				infoflowres.remove(null);
				/*
				 * an expected FP = source and forbidden sink matches (not sinks from susi, the
				 * one we derive) but for secure storage the forbidden sink is empty for
				 * injections, because writing to DS is allowed sink (fieldId, path) - so we
				 * also ignore the allowedsinks and put them as forbidden (to effectively inject
				 * the leak)
				 */
				infoflowres.forEach(map -> addPossibleLeaks(result, forbidden, map));
				allRes.add(result);
			}
		}
		return allRes;
	}

	private void addPossibleLeaks(final AssetResults result, final Collection<String> forbidden,
			final MultiMap<ResultSinkInfo, ResultSourceInfo> map) {
		for (final ResultSinkInfo sink : map.keySet()) {
			final var sinkMethod = sink.getStmt().getInvokeExpr().getMethod().getSignature();
			final Set<String> sourceMethods = map.get(sink).parallelStream()
					.map(s -> s.getStmt().getInvokeExpr().getMethod().getSignature()).collect(Collectors.toSet());
			if (forbidden.contains(sinkMethod)) {
				// add all pairs to 'expected FPs'
				sourceMethods.forEach(source -> {
					if (result.getSources().contains(source)) {
						this.possibleLeaks.add(source + ", " + sinkMethod);
					}
				});
			}
		}
	}

	/**
	 * @param assets
	 *
	 */
	private void modifyCandidates(final Set<Asset> assets) {
		assets.forEach(asset -> {
			final var injectedValue = ModelFactory.eINSTANCE.createValue();
			injectedValue.setObjective(Objective.CONFIDENTIALITY);
			injectedValue.setPriority(Priority.H);
			asset.getValue().add(injectedValue);
			LOGGER.info("Injected high confidentiality label to asset: " + asset.getName());
		});
	}

	/**
	 * @param dfd
	 * @return Set<Asset> find non-confidential assets that exit the system (i.e.,
	 *         the asset target is EE or DS).
	 */
	private Set<Asset> getAssetsForInjection(final EDFD dfd) {
		return dfd.getAsset().parallelStream()
				.filter(asset -> asset.getValue().stream()
						.noneMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective())))
				.filter(asset -> asset.getTargets().stream()
						.anyMatch(target -> (target instanceof ExternalEntity) || (target instanceof DataStore)))
				.collect(Collectors.toSet());
	}

	/**
	 * @param asset The asset to check
	 * @return The results of the DF-analysis per entry point
	 */
	private AssetResults checkAsset(final Asset asset) {
		// calculate source and sinks for the asset
		final var sourcesAndSinks = this.sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
					Collections.emptyMap(), Collections.emptyList());
		}

		final List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		final List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		final List<String> forbinnedSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());

		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, forbinnedSinks, Collections.emptyMap(),
					Collections.emptyList());
		}

		final var epoints = this.sas.getEntryPoints();
		final var map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, forbinnedSinks, map, Collections.emptyList());
	}

	private AssetResults getAssetSourceSinks(final Asset asset) {
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
			if (!"".equals(allowedsink)) {
				sinks.add(allowedsink);
				derivedAsForbiddenSinks.add(allowedsink);

			}
		}
		return new AssetResults(asset, sources, sinks, derivedAsForbiddenSinks, Collections.emptyMap(), allowed);
	}

	public Map<String, InfoflowResults> check(final Collection<String> sources, final Collection<String> sinks,
			final Collection<String> epoints) {
		return epoints.stream()
				.collect(Collectors.toMap(entryPoint -> entryPoint, entryPoint -> check(sources, sinks, entryPoint)));
	}

	public InfoflowResults check(final Collection<String> sources, final Collection<String> sinks,
			final String entryPoint) {
		// for itrust add_health_record, this violation should be found!?
		// sinks.contains("<java.sql.Connection: java.sql.PreparedStatement
		// prepareStatement(java.lang.String)>");
		// sources.add("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean
		// add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
		// sources.contains("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean
		// add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
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
			config.setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows);
			config.setAliasingAlgorithm(AliasingAlgorithm.FlowSensitive);
			config.setStopAfterFirstKFlows(limit);
		});
		result.setTaintWrapper(new EasyTaintWrapper(taintedMethods));
		return result;
	}

}
