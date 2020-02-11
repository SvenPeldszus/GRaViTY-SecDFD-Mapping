/**
 * 
 */
package org.gravity.flowdroid;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * This class provides a custom structure for storing sources and sinks for the analyzer
 * 
 * @author katjat
 *
 */
public class SourceAndSink {
	
	private final Set<String> sources;
	private final Set<String> sinks;
	
	/**
	 * Initializes sources and sinks with given values
	 */
	public SourceAndSink(Set<String> sources, Set<String> sinks) {
		this.sources = new HashSet<>(sources);
		this.sinks = new HashSet<>(sinks);
	}
	
	/**
	 * Initializes sources and sinks with no values
	 */
	public SourceAndSink() {
		this.sources = new HashSet<>();
		this.sinks = new HashSet<>();
	}

	/**
	 * @return the sources
	 */
	public Set<String> getSources() {
		return sources;
	}

	/**
	 * @return the sinks
	 */
	public Set<String> getSinks() {
		return sinks;
	}

}
