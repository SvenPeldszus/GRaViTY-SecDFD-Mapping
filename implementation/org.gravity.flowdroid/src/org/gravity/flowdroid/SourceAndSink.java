/**
 * 
 */
package org.gravity.flowdroid;

import java.util.Set;

import org.gravity.typegraph.basic.TMember;

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
	final Set<? extends TMember> allowed;
	
	/**
	 * Initializes sources and sinks with given values
	 */
	public SourceAndSink(Set<String> sources, Set<String> sinks,Set<? extends TMember> allowed) {
		this.sources = sources;
		this.sinks = sinks;
		this.allowed = allowed;
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
	
	/**
	 * @return the allowed sinks
	 */
	public Set<? extends TMember> getAllowed() {
		return allowed;
	}
}
