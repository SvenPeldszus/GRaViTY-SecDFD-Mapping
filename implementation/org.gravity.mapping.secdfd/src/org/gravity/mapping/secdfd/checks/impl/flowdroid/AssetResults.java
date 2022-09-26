package org.gravity.mapping.secdfd.checks.impl.flowdroid;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.secdfd.model.Asset;

import soot.jimple.infoflow.results.InfoflowResults;

public class AssetResults {

	private final Asset asset;
	private Map<String, InfoflowResults> allResults;
	private final Collection<String> sources;
	private final Collection<String> sinks;
	private final Collection<String> forbiddenSinks;
	private final Collection<String> allowedSinks;

	public AssetResults(Asset asset, Collection<String> sources, Collection<String> sinks, Collection<String> forbiddensinks, Map<String, InfoflowResults> allResults, Collection<String> allowedSinks) {
		this(asset, sources, sinks, forbiddensinks, allowedSinks);
		this.allResults.putAll(allResults);
	}
	
	public AssetResults(Asset asset, Collection<String> sources, Collection<String> sinks, Collection<String> forbiddensinks, Collection<String> allowedSinks) {
		this.allowedSinks = allowedSinks;
		this.asset = asset;
		this.sources = sources;
		this.sinks = sinks;
		this.forbiddenSinks = forbiddensinks;
		this.allResults = new HashMap<>();
	}

	/**
	 * @return the allowedSinks
	 */
	public Collection<String> getAllowedSinks() {
		return allowedSinks;
	}

	public void addResult(String entryPoint, InfoflowResults results) {
		allResults.put(entryPoint, results);
	}
	
	public void addAllResults(Map<String, InfoflowResults> allResults) {
		this.allResults = allResults;
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
