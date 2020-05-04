package org.gravity.flowdroid;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.gravity.flowdroid.DataFlowExperiment.TestCaseID;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;

public class DataFlowExperimentMeasurer {

	private Map<TestCaseID, Map<String, Set<String>>> allExperiments;
	private Map<TestCaseID, Map<String, Set<String>>> truePositives;
	private Map<TestCaseID, Map<String, Set<String>>> falsePositives;
	private Map<TestCaseID, Map<String, Set<String>>> falseNegatives;
	private Map<TestCaseID, Map<String, Set<String>>> possibleLeaks;
	private IFolder output;

	
	public DataFlowExperimentMeasurer() {
		this.allExperiments = new HashMap<>();
		this.truePositives = new HashMap<>();
		this.falsePositives = new HashMap<>();
		this.falseNegatives = new HashMap<>();
		this.possibleLeaks = new HashMap<>();
		this.output = null;
	}

	public Collection<TestCaseID> getExecutedTestCaseIDs() {
		return allExperiments.keySet();
	}

	/**
	 * @return the truePositives
	 */
	public Map<TestCaseID, Map<String, Set<String>>> getTruePositives() {
		return truePositives;
	}

	/**
	 * @return the falsePositives
	 */
	public Map<TestCaseID, Map<String, Set<String>>> getFalsePositives() {
		return falsePositives;
	}

	/**
	 * @return the falseNegatives
	 */
	public Map<TestCaseID, Map<String, Set<String>>> getFalseNegatives() {
		return falseNegatives;
	}

	/**
	 * @param string
	 * @param set    current experiment results
	 */
	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Results results, IFolder out) {
		setCurrentExperimentResults(id, secdfd, flattenAssetResultsForSecDFD(results), out);
	}
	
	public void setCurrentExperimentResults(TestCaseID fdsourcesink, String secdfd, Map<String, InfoflowResults> results,
			IFolder out) {
		setCurrentExperimentResults(fdsourcesink, secdfd, flatten(results), out);
	}
	
	public void setCurrentExperimentResults(TestCaseID testcaseid, String secdfd, Set<String> possible,
			Results results, IFolder destination) {
		possibleLeaks.put(testcaseid, new HashMap<>());
		possibleLeaks.get(testcaseid).put(secdfd, possible);
		setCurrentExperimentResults(testcaseid, secdfd, results, destination);
	}

	public void setCurrentExperimentResults(TestCaseID id, String secdfd, Set<String> results,
			IFolder out) {
		Map<String, Set<String>> secdfdRes = new HashMap<>();
		secdfdRes.put(secdfd, results);
		allExperiments.put(id, secdfdRes);
		output = out;
		truePositives.put(id, new HashMap<>());
		truePositives.get(id).put(secdfd, new HashSet<>());
		falsePositives.put(id, new HashMap<>());
		falsePositives.get(id).put(secdfd, new HashSet<>());
		falseNegatives.put(id, new HashMap<>());
		falseNegatives.get(id).put(secdfd, new HashSet<>());
		if (!possibleLeaks.containsKey(id)) {
			// this run has no injected leaks -> initialize empty map (ground truth is empty, secure model)
			possibleLeaks.put(id, new HashMap<>());
			possibleLeaks.get(id).put(secdfd, new HashSet<>());
		}
	}

	/**
	 * @param results
	 */
	private Set<String> flattenAssetResultsForSecDFD(Results results) {
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
	 * Populates the truePositives and falseNegatives maps. Results of each asset
	 * are compared to FDSourceSink. Criteria for TP: same entry point & sink
	 * definition.
	 * 
	 * @param map
	 * 
	 */
	public void calculateMeasures() {
		// go through all experiment
		allExperiments.keySet().forEach(testcaseid -> {
			Map<String, Set<String>> testCaseResults = allExperiments.get(testcaseid);
			testCaseResults.keySet().forEach(secdfdName -> {
				Set<String> secdfdResults = testCaseResults.get(secdfdName);
				secdfdResults.forEach(sourceSinkPair -> {
					getTPFP(secdfdResults, testcaseid, secdfdName);
					getFN(secdfdResults, testcaseid, secdfdName);
				});
				try {
					ExperimentHelper.writeToTxt(output,
							ExperimentHelper.stringBuilder(truePositives.get(testcaseid).get(secdfdName),
									falsePositives.get(testcaseid).get(secdfdName),
									falseNegatives.get(testcaseid).get(secdfdName)),
							"performance", new NullProgressMonitor(), false);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			});

		});

	}

	private void getFN(Set<String> secdfdResults, TestCaseID testcaseid, String secdfdName) {
		possibleLeaks.get(testcaseid).get(secdfdName).forEach(sink -> {
			//for now I only have sinks
			if (!secdfdResults.contains(sink)) addFN(sink, testcaseid, secdfdName);
		});
	}


	/**
	 * @param resSet
	 * @param epoint
	 * @param testcaseid
	 * @param secdfdName
	 */
	private void getTPFP(Set<String> sourceSinkPairs, TestCaseID testcaseid, String secdfdName) {
		sourceSinkPairs.forEach(pair -> {
			if (inPossibleLeaks(pair, testcaseid, secdfdName)) {
				addTP(pair, testcaseid, secdfdName);
			} else {
				addFP(pair, testcaseid, secdfdName);
			}
		});

	}

	private void addTP(String pair, TestCaseID testcaseid, String secdfdName) {
		truePositives.get(testcaseid).get(secdfdName).add(pair);
	}
	private void addFP(String pair, TestCaseID testcaseid, String secdfdName) {
		falsePositives.get(testcaseid).get(secdfdName).add(pair);
	}
	private void addFN(String pair, TestCaseID testcaseid, String secdfdName) {
		falseNegatives.get(testcaseid).get(secdfdName).add(pair);
	}
	
	private boolean inPossibleLeaks(String pair, TestCaseID testcaseid, String secdfdName) {
		if (possibleLeaks.containsKey(testcaseid)) {
			if (possibleLeaks.get(testcaseid).containsKey(secdfdName)) {
				String sink = pair.split(", ")[1];
				return possibleLeaks.get(testcaseid).get(secdfdName).contains(sink);
			}
		}
		return false;
	}
}
