/**
 * 
 */
package org.gravity.flowdroid;

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
	
	/**
	 * Initializes sources and sinks with given values
	 */
	public SourceAndSink(Set<String> sources, Set<String> sinks) {
		this.sources = sources;
		this.sinks = sinks;
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
