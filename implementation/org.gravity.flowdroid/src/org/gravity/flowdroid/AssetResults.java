package org.gravity.flowdroid;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.secdfd.model.Asset;

import soot.jimple.infoflow.results.InfoflowResults;

public class AssetResults {

	private final Asset asset;
	private final Map<String, InfoflowResults> allResults;
	private final Collection<String> sources;
	private final Collection<String> sinks;
	private final Collection<String> forbiddenSinks;

	public AssetResults(Asset asset, Collection<String> sources, Collection<String> sinks, Collection<String> forbiddensinks, Map<String, InfoflowResults> allResults) {
		this(asset, sources, sinks, forbiddensinks);
		this.allResults.putAll(allResults);
	}
	
	public AssetResults(Asset asset, Collection<String> sources, Collection<String> sinks, Collection<String> forbiddensinks) {
		this.asset = asset;
		this.sources = sources;
		this.sinks = sinks;
		this.forbiddenSinks = forbiddensinks;
		this.allResults = new HashMap<>();
	}

	public void addResult(String entryPoint, InfoflowResults results) {
		allResults.put(entryPoint, results);
	}

	public Set<Entry<String, InfoflowResults>> getSingleResults() {
		return allResults.entrySet();
	}
	
	public Map<String, InfoflowResults> getResults() {
		return allResults;
	}

	/**
	 * @return the asset
	 */
	public Asset getAsset() {
		return asset;
	}

	/**
	 * @return the sources
	 */
	public Collection<String> getSources() {
		return sources;
	}

	/**
	 * @return the sinks
	 */
	public Collection<String> getSinks() {
		return sinks;
	}

	public Collection<String> getForbiddenSinks() {
		return forbiddenSinks;
	}
	
	public Set<String> getEPoints() {
		return allResults.keySet();
	}

}
