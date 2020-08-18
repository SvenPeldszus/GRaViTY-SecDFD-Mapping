package org.gravity.flowdroid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.gravity.flowdroid.DataFlowExperiment.TestCaseID;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;

public class DataFlowExperimentMeasurer {
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperimentMeasurer.class);

	/*
	 * violations found for all experiment of current project
	 * the key String is TestCaseID + secdfdName
	 */
	private Map<String, Set<String>> allExperiments;
	/*
	 * all true injected violations found for all experiment of current project
	 */
	private Map<String, Set<String>> injectedTruePositives;
	private Map<String, Set<String>> falsePositives;
	private Map<String, Set<String>> injectedFalseNegatives;
	// injected, expected false positives for current project
	private Map<String, Set<String>> possibleLeaks;
	// number of unique sources/sinks for testcaseid
	private Map<String, Set<String>> uniqueSources;
	private Map<String, Set<String>> uniqueAllowedSinks;
	private Map<String, List<String>> allAllowedSinks;
	/**
	 * @return the uniqueSources
	 */
	public Map<String, Set<String>> getUniqueSources() {
		return uniqueSources;
	}

	/**
	 * @return the uniqueAllowedSinks
	 */
	public Map<String, Set<String>> getUniqueAllowedSinks() {
		return uniqueAllowedSinks;
	}

	

	
	public DataFlowExperimentMeasurer() {
		this.allExperiments = new HashMap<>();
		this.injectedTruePositives = new HashMap<>();
		this.falsePositives = new HashMap<>();
		this.injectedFalseNegatives = new HashMap<>();
		this.possibleLeaks = new HashMap<>();
		this.uniqueSources = new HashMap<>();
		this.uniqueAllowedSinks = new HashMap<>();
		this.allAllowedSinks = new HashMap<>();
	}

	public Set<String> getExecutedExperiments(){
		return allExperiments.keySet();
	}
	
	public Set<String> getExecutedExperimentTestCaseIDs(){
		return allExperiments.keySet().parallelStream().map(k -> k.split(", ")[0]).collect(Collectors.toSet());
	}
	
	
	/**
	 * @return 
	 * @return the injectedTruePositives
	 */
	public Map<String, Set<String>> getTruePositives() {
		return injectedTruePositives;
	}
	
	/**
	 * @return the falsePositives
	 */
	public Map<String, Set<String>> getFalsePositives() {
		return falsePositives;
	}

	/**
	 * @return the injectedFalseNegatives
	 */
	public Map<String, Set<String>> getFalseNegatives() {
		return injectedFalseNegatives;
	}

	/**
	 * @param string
	 * @param set    current experiment results
	 */
	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Results results) {
		Set<String> sources = new HashSet<>();
		Set<String> sinks = new HashSet<>();
		
		for (AssetResults assetRes : results.getResultsPerAsset()) {
			sources.addAll(assetRes.getSources());
			sinks.addAll(assetRes.getAllowedSinks());
		}
		String TestIDandDFDName = id.toString();//+","+secdfd;
		if (!uniqueSources.containsKey(TestIDandDFDName)) {
			uniqueSources.put(TestIDandDFDName, sources);
		} else {
			uniqueSources.get(TestIDandDFDName).addAll(sources);
		}
		if (!uniqueAllowedSinks.containsKey(TestIDandDFDName)) {
			uniqueAllowedSinks.put(TestIDandDFDName, sinks);
		} else {
			uniqueAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		if (!allAllowedSinks.containsKey(TestIDandDFDName)) {
			List<String> mainList = new ArrayList<String>();
			mainList.addAll(sinks);
			allAllowedSinks.put(TestIDandDFDName, mainList);
		} else {
			allAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		
		setCurrentExperimentResults(id, secdfd, flattenAssetResultsForSecDFD(results));
	}
	
	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Map<String, InfoflowResults> results, Set<String> sources, Set<String> sinks) {
		// sum for FD SuSi run
		String TestIDandDFDName = id.toString();//+","+secdfd;
		if (!uniqueSources.containsKey(TestIDandDFDName)) {
			uniqueSources.put(TestIDandDFDName, sources);
		} else {
			uniqueSources.get(TestIDandDFDName).addAll(sources);
		}
		if (!uniqueAllowedSinks.containsKey(TestIDandDFDName)) {
			uniqueAllowedSinks.put(TestIDandDFDName, sinks);
		} else {
			uniqueAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}		
		if (!allAllowedSinks.containsKey(TestIDandDFDName)) {
			List<String> mainList = new ArrayList<String>();
			mainList.addAll(sinks);
			allAllowedSinks.put(TestIDandDFDName, mainList);
		} else {
			allAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		setCurrentExperimentResults(id, secdfd, flatten(results));
	}

	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Set<String> possible,
			Results results) {
		String key = id.toString() + ", " + secdfd;
		possibleLeaks.put(key, possible);
		setCurrentExperimentResults(id, secdfd, results);
	}

	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Set<String> results) {
		String key = id.toString() + ", " + secdfd;
		allExperiments.put(key, results);
		injectedTruePositives.put(key, new HashSet<>());
		falsePositives.put(key, new HashSet<>());
		injectedFalseNegatives.put(key, new HashSet<>());
		if (!possibleLeaks.containsKey(key)) {
			// this run has no injected leaks -> initialize empty map (ground truth is empty, secure model)
			possibleLeaks.put(key, new HashSet<>());
		}
	}

	/**
	 * @return the allAllowedSinks
	 */
	public Map<String, List<String>> getAllAllowedSinks() {
		return allAllowedSinks;
	}

	/**
	 * @param results
	 */
	Set<String> flattenAssetResultsForSecDFD(Results results) {
		Set<String> flattened = new HashSet<>();

		Set<Map<String, InfoflowResults>> resultSet = results.getResultsPerAsset().parallelStream()
				.map(assetResults -> assetResults.getResults()).collect(Collectors.toSet());
		
		resultSet.forEach(map -> {
			flattened.addAll(flatten(map));
		});
		
		return flattened;
	}

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

	/**
	 * Populates the injectedTruePositives and injectedFalseNegatives maps. Results of each asset
	 * are compared to FDSourceSink. Criteria for TP: same entry point & sink
	 * definition.
	 * 
	 * @param map
	 * 
	 */
	public void calculateMeasures() {
		// go through all executed experiments
		allExperiments.keySet().forEach(key -> {
			Set<String> secdfdResults = allExperiments.get(key);
			secdfdResults.forEach(sourceSinkPair -> {
				getTPFP(sourceSinkPair, key);
			});
			getFN(secdfdResults, key);			
		});
	}

	private void getFN(Set<String> secdfdResults, String key) {
		Set<String> possiblePairs = possibleLeaks.get(key);
		possiblePairs.forEach(pair -> {
			if (!secdfdResults.contains(pair)) {
				addFN(pair, key);
			}
		});
		LOGGER.info("No false negatives.");
	}


	/**
	 * @param resSet
	 * @param epoint
	 * @param testcaseid
	 * @param secdfdName
	 */
	private void getTPFP(String sourceSinkPair, String key) {
		if (inPossibleLeaks(sourceSinkPair, key)) addTP(sourceSinkPair, key);
		else addFP(sourceSinkPair, key);
	}

	private void addTP(String pair, String key) {
		injectedTruePositives.get(key).add(pair);
	}

	private void addFP(String pair, String key) {
		falsePositives.get(key).add(pair);
	}

	private void addFN(String pair, String key) {
		injectedFalseNegatives.get(key).add(pair);
	}

	private boolean inPossibleLeaks(String pair, String key) {
		return possibleLeaks.get(key).contains(pair);
	}

	public Set<String> getSuSiSinks() {
		for (String key : uniqueAllowedSinks.keySet()) {
			if (key.contains("FDSourceSink")){
				return uniqueAllowedSinks.get(key);
			}
		}
		return Collections.emptySet();
	}
}
