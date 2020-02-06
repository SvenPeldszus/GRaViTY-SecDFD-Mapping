/**
 * 
 */
package org.gravity.flowdroid;

import java.util.ArrayList;

/**
 * 
 * This class provides a custom structure for storing sources and sinks for the analyzer
 * 
 * @author katjat
 *
 */
public class SourceAndSink {
	final ArrayList<String> sources;
	final ArrayList<String> sinks;
	
	/**
	 * 
	 */
	public SourceAndSink(ArrayList<String> sources, ArrayList<String> sinks) {
		this.sources = sources;
		this.sinks = sinks;
	}

}
