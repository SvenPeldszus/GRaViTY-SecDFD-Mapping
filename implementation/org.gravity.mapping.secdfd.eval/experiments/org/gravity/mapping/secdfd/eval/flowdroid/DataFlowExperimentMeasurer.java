package org.gravity.mapping.secdfd.eval.flowdroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.AssetResults;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.Results;
import org.gravity.mapping.secdfd.eval.flowdroid.DataFlowExperiment.TestCaseID;

import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;

public class DataFlowExperimentMeasurer {
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperimentMeasurer.class);

	/*
	 * violations found for all experiment of current project
	 * the key String is TestCaseID + secdfdName
	 */
	private final Map<String, Set<String>> allExperiments;
	/*
	 * all true injected violations found for all experiment of current project
	 */
	private final Map<String, Set<String>> injectedTruePositives;
	private final Map<String, Set<String>> falsePositives;
	private final Map<String, Set<String>> injectedFalseNegatives;
	// injected, expected false positives for current project
	private final Map<String, Set<String>> possibleLeaks;
	// number of unique sources/sinks for testcaseid
	private final Map<String, Set<String>> uniqueSources;
	private final Map<String, Set<String>> uniqueAllowedSinks;
	private final Map<String, List<String>> allAllowedSinks;
	/**
	 * @return the uniqueSources
	 */
	public Map<String, Set<String>> getUniqueSources() {
		return this.uniqueSources;
	}

	/**
	 * @return the uniqueAllowedSinks
	 */
	public Map<String, Set<String>> getUniqueAllowedSinks() {
		return this.uniqueAllowedSinks;
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
		return this.allExperiments.keySet();
	}

	public Set<String> getExecutedExperimentTestCaseIDs(){
		return this.allExperiments.keySet().parallelStream().map(k -> k.split(", ")[0]).collect(Collectors.toSet());
	}


	/**
	 * @return
	 * @return the injectedTruePositives
	 */
	public Map<String, Set<String>> getTruePositives() {
		return this.injectedTruePositives;
	}

	/**
	 * @return the falsePositives
	 */
	public Map<String, Set<String>> getFalsePositives() {
		return this.falsePositives;
	}

	/**
	 * @return the injectedFalseNegatives
	 */
	public Map<String, Set<String>> getFalseNegatives() {
		return this.injectedFalseNegatives;
	}

	/**
	 * @param string
	 * @param set    current experiment results
	 */
	public void setCurrentExperimentResults(final TestCaseID id, final String secdfd, final Results results) {
		final Set<String> sources = new HashSet<>();
		final Set<String> sinks = new HashSet<>();

		for (final AssetResults assetRes : results.getResultsPerAsset()) {
			sources.addAll(assetRes.getSources());
			sinks.addAll(assetRes.getAllowedSinks());
		}
		final var TestIDandDFDName = id.toString();//+","+secdfd;
		if (!this.uniqueSources.containsKey(TestIDandDFDName)) {
			this.uniqueSources.put(TestIDandDFDName, sources);
		} else {
			this.uniqueSources.get(TestIDandDFDName).addAll(sources);
		}
		if (!this.uniqueAllowedSinks.containsKey(TestIDandDFDName)) {
			this.uniqueAllowedSinks.put(TestIDandDFDName, sinks);
		} else {
			this.uniqueAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		if (!this.allAllowedSinks.containsKey(TestIDandDFDName)) {
			final List<String> mainList = new ArrayList<>(sinks);
			this.allAllowedSinks.put(TestIDandDFDName, mainList);
		} else {
			this.allAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}

		setCurrentExperimentResults(id, secdfd, flattenAssetResultsForSecDFD(results));
	}

	public void setCurrentExperimentResults(final TestCaseID id, final String secdfd, final Map<String, InfoflowResults> results, final Set<String> sources, final Set<String> sinks) {
		// sum for FD SuSi run
		final var TestIDandDFDName = id.toString();//+","+secdfd;
		if (!this.uniqueSources.containsKey(TestIDandDFDName)) {
			this.uniqueSources.put(TestIDandDFDName, sources);
		} else {
			this.uniqueSources.get(TestIDandDFDName).addAll(sources);
		}
		if (!this.uniqueAllowedSinks.containsKey(TestIDandDFDName)) {
			this.uniqueAllowedSinks.put(TestIDandDFDName, sinks);
		} else {
			this.uniqueAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		if (!this.allAllowedSinks.containsKey(TestIDandDFDName)) {
			final List<String> mainList = new ArrayList<>(sinks);
			this.allAllowedSinks.put(TestIDandDFDName, mainList);
		} else {
			this.allAllowedSinks.get(TestIDandDFDName).addAll(sinks);
		}
		setCurrentExperimentResults(id, secdfd, flatten(results));
	}

	public void setCurrentExperimentResults(final TestCaseID id, final String secdfd, final Set<String> possible,
			final Results results) {
		final var key = id.toString() + ", " + secdfd;
		this.possibleLeaks.put(key, possible);
		setCurrentExperimentResults(id, secdfd, results);
	}

	public void setCurrentExperimentResults(final TestCaseID id, final String secdfd, final Set<String> results) {
		final var key = id.toString() + ", " + secdfd;
		this.allExperiments.put(key, results);
		this.injectedTruePositives.put(key, new HashSet<>());
		this.falsePositives.put(key, new HashSet<>());
		this.injectedFalseNegatives.put(key, new HashSet<>());
		if (!this.possibleLeaks.containsKey(key)) {
			// this run has no injected leaks -> initialize empty map (ground truth is empty, secure model)
			this.possibleLeaks.put(key, new HashSet<>());
		}
	}

	/**
	 * @return the allAllowedSinks
	 */
	public Map<String, List<String>> getAllAllowedSinks() {
		return this.allAllowedSinks;
	}

	/**
	 * @param results
	 */
	Set<String> flattenAssetResultsForSecDFD(final Results results) {
		final Set<String> flattened = new HashSet<>();

		final Set<Map<String, InfoflowResults>> resultSet = results.getResultsPerAsset().parallelStream()
				.map(AssetResults::getResults).collect(Collectors.toSet());

		resultSet.forEach(map -> {
			flattened.addAll(flatten(map));
		});

		return flattened;
	}

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
		this.allExperiments.keySet().forEach(key -> {
			final var secdfdResults = this.allExperiments.get(key);
			secdfdResults.forEach(sourceSinkPair -> {
				getTPFP(sourceSinkPair, key);
			});
			getFN(secdfdResults, key);
		});
	}

	private void getFN(final Set<String> secdfdResults, final String key) {
		final var possiblePairs = this.possibleLeaks.get(key);
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
	private void getTPFP(final String sourceSinkPair, final String key) {
		if (inPossibleLeaks(sourceSinkPair, key)) {
			addTP(sourceSinkPair, key);
		} else {
			addFP(sourceSinkPair, key);
		}
	}

	private void addTP(final String pair, final String key) {
		this.injectedTruePositives.get(key).add(pair);
	}

	private void addFP(final String pair, final String key) {
		this.falsePositives.get(key).add(pair);
	}

	private void addFN(final String pair, final String key) {
		this.injectedFalseNegatives.get(key).add(pair);
	}

	private boolean inPossibleLeaks(final String pair, final String key) {
		return this.possibleLeaks.get(key).contains(pair);
	}

	public Set<String> getSuSiSinks() {
		for (final String key : this.uniqueAllowedSinks.keySet()) {
			if (key.contains("FDSourceSink")){
				return this.uniqueAllowedSinks.get(key);
			}
		}
		return Collections.emptySet();
	}
}
