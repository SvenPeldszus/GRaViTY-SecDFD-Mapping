package org.gravity.flowdroid;

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
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Objective;
import org.secdfd.model.Priority;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;
import org.secdfd.model.Value;

import com.google.common.collect.Sets;

import soot.SootMethod;
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

	private Mapper mapper;
	private String appPath;
	private String libPath;
	SourcesAndSinkFinder sas;
	private Integer allowedSinksToRemove;
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

	public DFAnalysis(Mapper mapper, IJavaProject project, boolean susi, int limit)
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

	public Results checkAllAssets(Integer toInject) {
		// try to inject 5 leaks by setting allowed sinks (if any) as forbidden in
		this.allowedSinksToRemove = toInject;
		Results results = new Results();
		for (Asset asset : mapper.getDFD().getAsset()) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
				results.add(checkAsset(asset));
			}
		}
		if (allowedSinksToRemove > 0)
			LOGGER.info("Did not manage to inject: " + allowedSinksToRemove
					+ "more leaks. The SecDFD could not contain enough valid candidate elements (confidential assets flowing to a DS/EE).");
		return results;
	}
	 
	/**
	 * try to inject high labels (as many as candidates)
	 * @return
	 */
	public Results checkAllAssetsInject() {
		this.allowedSinksToRemove = 0; //FIXME: removing allowed sinks even needed?
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
		
		
		//check remaining assets
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
			//inject confidentiality high		
			modifyCandidates(candidates);
			candidates.forEach(asset -> {
				

				/*
				 * an expected FP = source and forbidden sink matches (not sinks from susi, the one we derive)
				but for secure storage the forbidden sink is empty for injections, because writing to DS is allowed sink (fieldId, path)
				 */
				
				// look for sources, sinks, epoints, put all allowed to forbidden, run FlowDroid
				AssetResults result = checkAssetRemoveAllowed(asset);
				// forbidden by deriving from DFD - not SuSi sinks
				Collection<String> forbidden = result.getForbiddenSinks();
				

				//flatten results
				Set<MultiMap<ResultSinkInfo, ResultSourceInfo>> infoflowres = result.getSingleResults()
						.parallelStream()
						.map(res -> res.getValue())
						.map(r -> r.getResults())
						.collect(Collectors.toSet());
				
				infoflowres.remove(null);
				//remember all source,sink pairs as possible leaks
				infoflowres.forEach(map -> {
					for (ResultSinkInfo sink : map.keySet()) {
						String sinkMethod = sink.getStmt().getInvokeExpr().getMethod().getSignature();
						Set<String> sourceMethods = map.get(sink).parallelStream()
								.map(s -> s.getStmt().getInvokeExpr().getMethod().getSignature())
								.collect(Collectors.toSet());
						if (forbidden.contains(sinkMethod)) {
							//add all pairs to 'expected FPs'
							sourceMethods.forEach(source -> {
								if (result.getSources().contains(source)) {
									possibleLeaks.add(source+", "+sinkMethod);
								}
							});							
						}
					}
				});
				allRes.add(result);
			});
		return allRes;
	}

	/**
	 * @param nonconfidentialAssets
	 * 
	 */
	private void modifyCandidates(Set<Asset> nonconfidentialAssets) {
		nonconfidentialAssets.forEach(asset -> {
			Value injectedValue = ModelFactory.eINSTANCE.createValue();
			injectedValue.setObjective(Objective.CONFIDENTIALITY);
			injectedValue.setPriority(Priority.H);
			asset.getValue().add(injectedValue);
			LOGGER.info("Injected high confidentiality label to asset: "+asset.getName());
		});
	}

	/**
	 * @param dfd
	 * @return Set<Asset>
	 * 	find non-confidential assets that exit the system (i.e., the asset target is EE or DS)
	 *	for storepassword.secdfd -> fieldID 
	 *	for setpasswordrecovery.secdfd -> path
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
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyMap());
		}

		List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		List<String> forbinnedSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());
		List<? extends TMember> allowed = new ArrayList<>(sourcesAndSinks.getAllowed());
		// try to inject a leak
		if (allowedSinksToRemove > 0) {
			if (allowed.size() > 0) {
				TMethodDefinition randomAllowedSink = (TMethodDefinition) allowed
						.get(ThreadLocalRandom.current().nextInt(0, allowed.size()));
				Set<TMethodDefinition> allMappedSinks = correspondingProcessAlsoMappedTo(randomAllowedSink);
				// remove a random allowed sink, and sinks also mapped to the same process
				allMappedSinks.forEach(sink -> {
					allowed.remove(sink);
					// put it to forbidden sink
					sinks.add(SignatureHelper.getSootSignature(sink));
					// remember as possible leak (ground truth for experiments)
					possibleLeaks.add(SignatureHelper.getSootSignature(sink));
				});
				// removal of allMappedSinks from allowed sinks = removing confidential asset of
				// the data flow going into EE or DS
				allowedSinksToRemove--;
			}
		}
		// allowedSinks.put(asset, allowed);

		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, forbinnedSinks, Collections.emptyMap());
		}

		Set<String> epoints = sas.getEntryPoints();
		// injection need to happen before this call
		Map<String, InfoflowResults> map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, forbinnedSinks, map);
	}
	
	private AssetResults checkAssetRemoveAllowed(Asset asset) {
		// calculate source and sinks for the asset
		SourceAndSink sourcesAndSinks = sas.getSourceSinks(asset);
		if (sourcesAndSinks == null) {
			return new AssetResults(asset, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyMap());
		}

		List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
		List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
		List<String> forbinnedSinks = new ArrayList<>(sourcesAndSinks.getForbiddenSinks());
		List<? extends TMember> allowed = new ArrayList<>(sourcesAndSinks.getAllowed());
		
		for (TMember allowedsink : allowed) {
			sinks.add(SignatureHelper.getSootSignature((TMethodDefinition)allowedsink));
			forbinnedSinks.add(SignatureHelper.getSootSignature((TMethodDefinition)allowedsink));
		}
		
		if (sources.isEmpty()) {
			return new AssetResults(asset, sources, sinks, forbinnedSinks, Collections.emptyMap());
		}
		
		Set<String> epoints = sas.getEntryPoints();
		
		Map<String, InfoflowResults> map = check(sources, sinks, epoints);
		return new AssetResults(asset, sources, sinks, forbinnedSinks, map);
	}

	private Set<TMethodDefinition> correspondingProcessAlsoMappedTo(TMethodDefinition randomAllowedSink) {
		Set<Process> mappedTo = mapper.getMapping(randomAllowedSink);
		return mappedTo.parallelStream().flatMap(p -> mapper.getMapping(p).stream()).collect(Collectors.toSet());
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
		IInfoflow infoflow = initInfoflow(Collections.emptyMap(), limit);
		infoflow.computeInfoflow(appPath, libPath, entryPoint, sources, sinks);
		InfoflowResults results = infoflow.getResults();
		if (results.isEmpty()) {
			return results;
		}
		MultiMap<ResultSinkInfo, ResultSourceInfo> map = results.getResults();
		// FIXME: Remove sinks that are allowed sinks -> EasyTaintWrapper.txt might be
		// the reason
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
