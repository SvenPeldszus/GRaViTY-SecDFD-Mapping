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
	final Set<String> sources;
	final Set<String> sinks;
	final Set<String> epoint;
	
	/**
	 * Initializes sources and sinks with given values
	 */
	public SourceAndSink(Set<String> sources, Set<String> sinks, Set<String> epoint) {
		this.sources = sources;
		this.sinks = sinks;
		this.epoint = epoint;
	}
	
	/**
	 * Initializes sources and sinks with no values
	 */
	public SourceAndSink() {
		this.sources = new HashSet<>();
		this.sinks = new HashSet<>();
		this.epoint = new HashSet<>();
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
