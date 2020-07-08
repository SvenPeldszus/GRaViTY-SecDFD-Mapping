package org.gravity.flowdroid;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.secdfd.model.Asset;

import soot.jimple.infoflow.results.InfoflowResults;

public class Results {
	
	private final Map<Asset, AssetResults> resultsPerAsset;
	
	public Results() {
		this.resultsPerAsset = new HashMap<>();
	}

	public Results(Asset a, Map<String, InfoflowResults> allResults) {
		this.resultsPerAsset = new HashMap<>();
		AssetResults emptyAsset = new AssetResults(a, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), allResults, Collections.emptySet());
		resultsPerAsset.put(a, emptyAsset);
	}
	
	public Collection<Asset> getCheckedAssets() {
		return resultsPerAsset.keySet();
	}

	public void add(AssetResults checkAsset) {
		resultsPerAsset.put(checkAsset.getAsset(), checkAsset);
	}

	public Collection<AssetResults> getResultsPerAsset() {
		return resultsPerAsset.values();
	}

}
