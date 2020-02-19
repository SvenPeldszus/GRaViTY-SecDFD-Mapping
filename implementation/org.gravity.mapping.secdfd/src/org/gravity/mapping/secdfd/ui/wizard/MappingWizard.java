package org.gravity.mapping.secdfd.ui.wizard;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.wizard.IWizardPage;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.mapping.secdfd.views.MappingView;

/**
 * A wizard for creating a mapping between SecDFDs and a Java implementation
 * 
 * @author speldszus
 *
 */
public class MappingWizard extends org.eclipse.jface.wizard.Wizard {

	public static final Logger LOGGER = Logger.getLogger(MappingWizard.class);

	private JavaProjectPage pageOne;
	private SecDFDPage pageTwo;

	private Collection<IJavaProject> selection;

	private TrafoJob trafoJob = null;

	private IJavaProject javaProject;

	private IFolder gravityFolder;
	
	

	public MappingWizard() {
		this(Collections.emptyList());
	}

	public MappingWizard(Collection<IJavaProject> selection) {
		super();
		setNeedsProgressMonitor(true);
		this.selection = selection;
	}

	@Override
	public String getWindowTitle() {
		return "Map SecDFD with Code";
	}

	@Override
	public void addPages() {
		if (selection.size() != 1) {
			pageOne = new JavaProjectPage();
			addPage(pageOne);
			setForcePreviousAndNextButtons(true);
		} else {
			createTrafoJob(selection.iterator().next());
			pageTwo = new SecDFDPage(javaProject);
			addPage(pageTwo);
		}
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof JavaProjectPage) {
			if (!createTrafoJob((((JavaProjectPage) page).getProject()))) {
				return page;
			}
			pageTwo = new SecDFDPage(((JavaProjectPage) page).getProject());
			addPage(pageTwo);
			return pageTwo;
		}
		return super.getNextPage(page);
	}

	/**
	 * Creates and launches a job for converting the java project into a program
	 * model
	 * 
	 * @return true, if the job could be launched for the selected project or is
	 *         already running
	 */
	private boolean createTrafoJob(IJavaProject javaProject) {
		if (!javaProject.equals(this.javaProject)) {
			if (trafoJob != null && !trafoJob.cancel()) {
				LOGGER.log(Level.ERROR, "Cannot stop trafo thread!");
				return false;
			} else {
				if (!setJavaProject(javaProject)) {
					return false;
				}
				trafoJob = new TrafoJob(javaProject);
				trafoJob.setUser(true);
				trafoJob.schedule();
			}
		}
		return true;
	}

	/**
	 * Sets the selected Java project and related information
	 * 
	 * @param javaProject The java project
	 * @return true, if all related informations could be derived
	 */
	private boolean setJavaProject(IJavaProject javaProject) {
		try {
			this.gravityFolder = EclipseProjectUtil.getGravityFolder(javaProject.getProject(),
					new NullProgressMonitor());
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e);
			return false;
		}
		this.javaProject = javaProject;
		return true;
	}

	@Override
	public boolean canFinish() {
		return pageTwo != null && pageTwo.isPageComplete();
	}

	@Override
	public boolean performFinish() {
		final List<IFile> selectedDFDs = pageTwo.getSelection();
		MappingView mappingView = MappingView.getMappingView();
		GravityUiActivator.getShell().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				mappingView.populate(gravityFolder, selectedDFDs, trafoJob);
			}
		});
		return true;
	}

	@Override
	public boolean performCancel() {
		if (trafoJob != null) {
			trafoJob.cancel();
		}
		return super.performCancel();
	}

}
