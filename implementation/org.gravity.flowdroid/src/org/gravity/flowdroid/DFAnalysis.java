package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.model.Asset;
import org.secdfd.model.Objective;

import soot.SootMethod;
import soot.jimple.Stmt;
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

	private Mapper mapper;
	private String appPath;
	private String libPath;
	SourcesAndSinkFinder sas;
	private int limit;

	public DFAnalysis(Mapper mapper, IJavaProject project, boolean susi, int limit)
			throws IOException, JavaModelException {
		this.mapper = mapper;
		this.limit = limit;
		
		// get base line sources (FlowDroid published sources) and sinks (FlowDroid
		// sinks + SuSi list of sinks) for experiment
		this.sas = new SourcesAndSinkFinder(mapper, susi);

		// set up paths for application and library to pass to flowdroid
		IPath outputLocation = project.getOutputLocation();
		IPath projectLocation = project.getProject().getLocation();
		this.appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		this.libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
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
	 * @param asset The asset to check
	 * @return The results of the DF-analysis per entry point
	 */
	private AssetResults checkAsset(Asset asset) {
		SourceAndSink sourcesAndSinks = sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyMap());
		}

		List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());

		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, Collections.emptyMap());
		}

		Set<String> epoints = sas.getEntryPoints();
		Map<String, InfoflowResults> map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, map);
	}

	/**
	 * @param sources
	 * @param sinks
	 * @param epoints
	 * @return
	 */
	public Map<String, InfoflowResults> check(Collection<String> sources, Collection<String> sinks, Collection<String> epoints) {
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
		IInfoflow infoflow = initInfoflow(Collections.emptyMap(), limit);
		infoflow.computeInfoflow(appPath, libPath, entryPoint, sources, sinks);
		InfoflowResults results = infoflow.getResults();
		if(results.isEmpty()) {
			return results;
		}
		MultiMap<ResultSinkInfo, ResultSourceInfo> map = results.getResults();
		//FIXME: Remove sinks that are allowed sinks
		for(ResultSinkInfo sink : map.keySet()) {
			SootMethod method = sink.getStmt().getInvokeExpr().getMethod();
			if(!sinks.contains(method.toString())){
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
