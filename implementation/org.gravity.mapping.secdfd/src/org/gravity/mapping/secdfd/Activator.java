package org.gravity.mapping.secdfd;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator of the mapping plugin
 * 
 * @author speldszus
 *
 */
public class Activator extends Plugin {

	/**
	 * The ID of the mapping plugin
	 */
	public static final String PLUGIN_ID = "org.gravity.mapping.secdfd";

	private static Activator instance;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		instance = null;
	}
	
	public static Activator getInstance() {
		return instance;
	}
}
