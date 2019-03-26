package org.gravity.mapping.secdfd.ui.wizard;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.gravity.eclipse.GravityAPI;
import org.gravity.eclipse.exceptions.TransformationFailedException;
import org.gravity.mapping.secdfd.Activator;
import org.gravity.typegraph.basic.TypeGraph;

/**
 * A job for creating a program model from a Java project
 * 
 * @author speldszus
 *
 */
public final class TrafoJob extends Job {
	private final IJavaProject javaProject;

	private TypeGraph pm;

	/**
	 * Creates a new job for creating a program model from a Java project
	 * 
	 * @param javaProject The Java project
	 */
	TrafoJob(IJavaProject javaProject) {
		super("Parse Java Project");
		this.javaProject = javaProject;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			pm = GravityAPI.createProgramModel(javaProject, monitor);
		} catch (TransformationFailedException e) {
			new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
		}
		return Status.OK_STATUS;
	}

	/**
	 * A getter for the parsed program model.
	 * 
	 * @return the program model or null if the job hasn't finished yet
	 */
	public TypeGraph getPM() {
		return pm;
	}
}