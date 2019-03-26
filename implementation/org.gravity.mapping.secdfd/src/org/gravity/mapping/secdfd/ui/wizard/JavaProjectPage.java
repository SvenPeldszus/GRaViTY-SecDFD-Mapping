package org.gravity.mapping.secdfd.ui.wizard;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;

public class JavaProjectPage extends WizardPage {

	private IJavaProject project;
	
	public JavaProjectPage() {
		super("Java Project");
		setDescription("Select the Java Project to Map");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		Layout layout = new RowLayout();
		container.setLayout(layout);

		List list = new List(container, SWT.V_SCROLL);
		list.setSize(400, 600);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		Iterator<String> iterator = Arrays.asList(root.getProjects())
				.parallelStream().filter(p -> {
					try {
						return p.hasNature(JavaCore.NATURE_ID);
					} catch (CoreException e) {
						return false;
					}
				}).map(p -> p.getName()).iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		list.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				project = JavaCore.create(root.getProject(list.getSelection()[0]));
				setPageComplete(true);
				getWizard().getContainer().updateButtons();
			}
		});

		RowData gd = new RowData();
		list.setLayoutData(gd);

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return project != null;
	}
	
	/**
	 * A getter for the selected project
	 * 
	 * @return the project
	 */
	protected IJavaProject getProject() {
		return project;
	}
}
