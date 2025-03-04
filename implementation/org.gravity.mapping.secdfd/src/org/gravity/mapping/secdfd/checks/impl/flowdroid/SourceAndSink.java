/**
 * 
 */
package org.gravity.mapping.secdfd.checks.impl.flowdroid;

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
	final Set<String> allowed;
	final Set<String> forbiddenSinks;
	
	/**
	 * Initializes sources and sinks with given values
	 */
	public SourceAndSink(Set<String> sources, Set<String> sinks, Set<String> forbiddenSinks ,Set<String> allowed) {
		this.sources = sources;
		this.sinks = sinks;
		this.forbiddenSinks = forbiddenSinks;
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

	public Set<String> getForbiddenSinks() {
		return forbiddenSinks;
	}
	
	/**
	 * @return the allowed sinks
	 */
	public Set<String> getAllowed() {
		return allowed;
	}
}
