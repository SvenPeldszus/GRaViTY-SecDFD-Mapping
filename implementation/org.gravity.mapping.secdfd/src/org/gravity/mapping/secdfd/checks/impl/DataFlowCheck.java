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
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.AssetResults;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.Results;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SignatureHelper;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SourceAndSink;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SourcesAndSinkFinder;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Objective;
import org.secdfd.model.Priority;
import org.secdfd.model.Value;

import soot.SootMethod;
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

	private Mapper mapper;
	private String appPath;
	private String libPath;
	SourcesAndSinkFinder sas;
	private Set<String> possibleLeaks;

	public Set<String> getPossibleLeaks() {
		return possibleLeaks;
	}

	/**
	 * @return the sas
	 */
	public SourcesAndSinkFinder getSas() {
		return sas;
	}

	private int limit;

	public DataFlowCheck(Mapper mapper, IJavaProject project, boolean susi, int limit)
			throws IOException, JavaModelException {
		this.mapper = mapper;
		this.limit = limit;

		// get base line sources (FlowDroid published sources) and sinks (FlowDroid
		// sinks + SuSi list of sinks) for experiment
		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.possibleLeaks = new HashSet<>();

		// set up paths for application and library to pass to flowdroid
		IPath outputLocation = project.getOutputLocation();
		IPath projectLocation = project.getProject().getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	// when called from UI, we have to get project from gravity folder
	public DataFlowCheck(Mapper mapper, boolean susi, int limit, IFolder gravityFolder)
			throws IOException, CoreException {
		this.mapper = mapper;
		this.limit = limit;

		this.sas = new SourcesAndSinkFinder(mapper, susi);
		this.possibleLeaks = new HashSet<>();

		IProject iproject = gravityFolder.getProject();
		IJavaProject ijavaProj = (IJavaProject) iproject.getNature(JavaCore.NATURE_ID);
		IPath outputLocation = ijavaProj.getOutputLocation();
		IPath projectLocation = iproject.getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
	}

	@Override
	public Collection<SResult> check(Mapper mapper) {
		if(this.mapper != mapper) {
			return null;
		}
		Results dfResults = checkAllAssets();
		return createMarkersForDFAnalysisResults(dfResults);
	}

	// add problems to each asset (duplicated source-sink pairs, because developer
	// may want to see which asset the leak effects)
	private Collection<SResult> createMarkersForDFAnalysisResults(Results DFresults) {
		Set<SResult> problems = new HashSet<>();
		for (AssetResults assetRes : DFresults.getResultsPerAsset()) {
			Set<String> strings = flatten(assetRes.getResults());
			if (!strings.isEmpty()) {
				String description = "";
				for (String str : strings) {
					description += str + '\n';
				}
				problems.add(new SResult(PState.ERROR, null, (EObject) assetRes.getAsset(), null,
						"The following source -> sink leaks have been detected: " + description));
			}
		}
		return problems;
	}

	/**
	 * @param map : asset results for each entry point
	 * @return flattened results of asset (merged entry points)
	 */
	private Set<String> flatten(Map<String, InfoflowResults> map) {
		Set<String> flattened = new HashSet<>();
		map.values().forEach(value -> {
			Set<DataFlowResult> rs = value.getResultSet();
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

	private boolean inFlattened(DataFlowResult result, Set<String> flattened) {
		for (String entry : flattened) {
			if (result.getSource().getDefinition().toString().contains(entry.split(", ")[0])
					&& result.getSink().getDefinition().toString().contains(entry.split(", ")[1])) {
				return true;
			}
		}
		return false;
	}

	public Results checkAllAssets() {
		Results results = new Results();
		for (Asset asset : mapper.getDFD().getAsset()) {
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
		Results results = new Results();
		EDFD dfd = mapper.getDFD();
		Set<Asset> candidates = getAssetsForInjection(dfd);

		if (!candidates.isEmpty()) {
			injectAndCheckAssets(candidates).forEach(res -> {
				results.add(res);
			});
		} else {
			LOGGER.info("Found no candidate asset to inject a high label. Proceeding as usual...");
		}

		// check remaining assets
		EList<Asset> rest = dfd.getAsset();
		rest.removeAll(candidates);
		for (Asset asset : rest) {
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
	private Set<AssetResults> injectAndCheckAssets(Set<Asset> candidates) {
		Set<AssetResults> allRes = new HashSet<>();
		// inject confidentiality high
		modifyCandidates(candidates);
		for (Asset asset : candidates) {
			// look for sources, sinks, epoints, put all allowed to forbidden
			AssetResults result = GetAssetSourceSinks(asset);
			// the allowed were added as forbidden sinks (and to sinks) now due to injection
			Collection<String> forbidden = result.getForbiddenSinks();
			// if no application specific (DFD derived) forbidden sinks, then we only get
			// FPs - skip...
			// also if forbidden == sources -> means we want to inject a leak within the
			// same DFD element, makes no sense, skip...
			if (!forbidden.isEmpty() && !result.getSources().containsAll(forbidden)) {
				// run flow droid
				System.out.println("Injecting for asset: " + asset.getName());
				Set<String> epoints = sas.getEntryPoints();
				result.addAllResults(check(result.getSources(), result.getSinks(), epoints));

				// flatten results
				Set<MultiMap<ResultSinkInfo, ResultSourceInfo>> infoflowres = result.getSingleResults().parallelStream()
						.map(res -> res.getValue()).map(r -> r.getResults()).collect(Collectors.toSet());

				infoflowres.remove(null);
				/*
				 * an expected FP = source and forbidden sink matches (not sinks from susi, the
				 * one we derive) but for secure storage the forbidden sink is empty for
				 * injections, because writing to DS is allowed sink (fieldId, path) - so we
				 * also ignore the allowedsinks and put them as forbidden (to effectively inject
				 * the leak)
				 */
				infoflowres.forEach(map -> {
					for (ResultSinkInfo sink : map.keySet()) {
						String sinkMethod = sink.getStmt().getInvokeExpr().getMethod().getSignature();
						Set<String> sourceMethods = map.get(sink).parallelStream()
								.map(s -> s.getStmt().getInvokeExpr().getMethod().getSignature())
								.collect(Collectors.toSet());
						if (forbidden.contains(sinkMethod)) {
							// add all pairs to 'expected FPs'
							sourceMethods.forEach(source -> {
								if (result.getSources().contains(source)) {
									possibleLeaks.add(source + ", " + sinkMethod);
								}
							});
						}
					}
				});
				allRes.add(result);
			}
		}
		return allRes;
	}

	/**
	 * @param assets
	 * 
	 */
	private void modifyCandidates(Set<Asset> assets) {
		assets.forEach(asset -> {
			// if it's not confidential, inject label
			// if(asset.getValue().stream().noneMatch(value ->
			// Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
			Value injectedValue = ModelFactory.eINSTANCE.createValue();
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
	private Set<Asset> getAssetsForInjection(EDFD dfd) {
		Set<Asset> nonconfidentialAssets = dfd.getAsset().parallelStream()
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
	private AssetResults checkAsset(Asset asset) {
		// calculate source and sinks for the asset
		SourceAndSink sourcesAndSinks = sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
					Collections.emptyMap(), Collections.emptyList());
		}

		List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		List<String> forbinnedSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());

		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, forbinnedSinks, Collections.emptyMap());
		}

		Set<String> epoints = sas.getEntryPoints();
		Map<String, InfoflowResults> map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, forbinnedSinks, map);
	}

	private AssetResults GetAssetSourceSinks(Asset asset) {
		// calculate source and sinks for the asset
		SourceAndSink sourcesAndSinks = sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(),
					Collections.emptyMap());
		}

		List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		List<String> derivedAsForbiddenSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());
		List<? extends TMember> allowed = new ArrayList<>(sourcesAndSinks.getAllowed());

		// add all allowed sinks
		for (TMember allowedsink : allowed) {
			if (allowedsink instanceof TMethodDefinition) {
				String allowedSinkSootSig = SignatureHelper.getSootSignature((TMethodDefinition) allowedsink);
				if (allowedSinkSootSig != "") {
					sinks.add(allowedSinkSootSig);
					derivedAsForbiddenSinks.add(allowedSinkSootSig);
				}
			}
		}
		return new AssetResults(asset, sources, sinks, derivedAsForbiddenSinks, Collections.emptyMap());
	}

	/**
	 * @param sources
	 * @param sinks
	 * @param epoints
	 * @return
	 */
	public Map<String, InfoflowResults> check(Collection<String> sources, Collection<String> sinks,
			Collection<String> epoints) {
		return epoints.stream()
				.collect(Collectors.toMap(entryPoint -> entryPoint, entryPoint -> check(sources, sinks, entryPoint)));
	}

	/**
	 * @param sources
	 * @param sinks
	 * @param entryPoint
	 * @return
	 */
	public InfoflowResults check(Collection<String> sources, Collection<String> sinks, String entryPoint) {
		// for itrust add_health_record, this violation should be found!?
//		sinks.contains("<java.sql.Connection: java.sql.PreparedStatement prepareStatement(java.lang.String)>");
//		sources.add("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
//		sources.contains("<edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO: boolean add(edu.ncsu.csc.itrust.beans.HealthRecord)>");
		IInfoflow infoflow = initInfoflow(Collections.emptyMap(), limit);
		infoflow.computeInfoflow(appPath, libPath, entryPoint, sources, sinks);
		InfoflowResults results = infoflow.getResults();
		if (results == null) {
			return new InfoflowResults();
		}
		if (results.isEmpty()) {
			return results;
		}
		MultiMap<ResultSinkInfo, ResultSourceInfo> map = results.getResults();
		// Remove sinks that are allowed sinks -> removed EasyTaintWrapper.txt (might be
		// the reason)
		for (ResultSinkInfo sink : map.keySet()) {
			SootMethod method = sink.getStmt().getInvokeExpr().getMethod();
			if (!sinks.contains(method.toString())) {
				map.remove(sink);
			}
		}
		return results;
	}

	protected IInfoflow initInfoflow(Map<String, Set<String>> taintedMethods, int limit) {
		// reset soot and initialize flowdroid configuration
		soot.G.reset();
		Infoflow result = new Infoflow("", false, null);
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
