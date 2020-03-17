package org.gravity.mapping.secdfd.ui.wizard;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.wizard.IWizardPage;
import org.gravity.eclipse.io.ExtensionFileVisitor;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.mapping.secdfd.ui.views.MappingView;

/**
 * A wizard for creating a mapping between SecDFDs and a Java implementation
 * 
 * @author speldszus
 *
 */
public class MappingWizard extends org.eclipse.jface.wizard.Wizard {

	public static final Logger LOGGER = Logger.getLogger(MappingWizard.class);

	private SecDFDPage pageTwo;

	private Collection<IJavaProject> selection;

	private TrafoJob trafoJob = null;

	private IJavaProject javaProject;

	private IFolder gravityFolder;

	private CorrPage corrPage;

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
			addPage(new JavaProjectPage());
		} else {
			List<Path> corrFiles = null;
			IJavaProject project = selection.iterator().next();
			try {
				IFolder gravity = EclipseProjectUtil.getGravityFolder(project.getProject(), new NullProgressMonitor());
				ExtensionFileVisitor visitor = new ExtensionFileVisitor("corr.xmi");
				gravity.accept(visitor);
				corrFiles = visitor.getFiles();

			} catch (CoreException | IOException e) {
				LOGGER.error(e);
			}
			if (corrFiles != null && !corrFiles.isEmpty()) {
				corrPage = new CorrPage(project, corrFiles, this);
				addPage(corrPage);
			} 
			try {
				createSecDFDPage(project);
			} catch (CoreException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		if(getPageCount() > 0) {
			setForcePreviousAndNextButtons(true);
		}
	}

	/**
	 * @param project
	 * @return
	 * @throws CoreException 
	 */
	SecDFDPage createSecDFDPage(IJavaProject project) throws CoreException {
		pageTwo = new SecDFDPage(project);
		createTrafoJob(project);
		addPage(pageTwo);
		return pageTwo;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof JavaProjectPage) {
			if (!createTrafoJob((((JavaProjectPage) page).getProject()))) {
				return page;
			}
			try {
				pageTwo = new SecDFDPage(((JavaProjectPage) page).getProject());
			} catch (CoreException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
				return null;
			}
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
		return !corrPage.getSelection().isEmpty() || (pageTwo != null && !pageTwo.getSelection().isEmpty());
	}

	@Override
	public boolean performFinish() {
		final Collection<IFile> selectedMappings = corrPage.getSelection();
		final Collection<IFile> selectedDFDs = pageTwo.getSelection();
		MappingView mappingView = MappingView.getMappingView();
		GravityUiActivator.getShell().getDisplay()
				.asyncExec(() -> {
					try {
						mappingView.populate(gravityFolder, selectedDFDs, selectedMappings, trafoJob);
					} catch (IOException | CoreException e) {
						LOGGER.error(e.getLocalizedMessage(), e);
						throw new IllegalStateException(e);
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

	public SecDFDPage getSecDFDPage(IJavaProject javaProject) throws CoreException {
		if(pageTwo != null) {
			return pageTwo;
		}
		return createSecDFDPage(javaProject);
	}

}
