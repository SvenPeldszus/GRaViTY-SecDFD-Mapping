package org.gravity.flowdroid;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.secdfd.model.Asset;

public class Results {
	
	private final Map<Asset, AssetResults> resultsPerAsset;
	
	public Results() {
		this.resultsPerAsset = new HashMap<>();
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
