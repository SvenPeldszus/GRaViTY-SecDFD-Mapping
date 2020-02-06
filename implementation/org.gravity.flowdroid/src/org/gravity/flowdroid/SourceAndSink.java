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
	final ArrayList<String> epoint;
	
	/**
	 * 
	 */
	public SourceAndSink(ArrayList<String> sources, ArrayList<String> sinks, ArrayList<String> epoint) {
		this.sources = sources;
		this.sinks = sinks;
		this.epoint = epoint;
	}

}
