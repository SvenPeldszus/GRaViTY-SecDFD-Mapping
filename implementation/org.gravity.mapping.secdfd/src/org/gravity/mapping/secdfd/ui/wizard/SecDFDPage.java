package org.gravity.mapping.secdfd.ui.wizard;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.gravity.eclipse.io.ExtensionFileVisitor;

public class SecDFDPage extends WizardPage {

	private IProject project;
	private Table list;

	public SecDFDPage(IJavaProject project) {
		super("SecDFDs");
		setDescription("Select the SecDFDs to Map");
		this.project = project.getProject();
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		Layout layout = new RowLayout();
		container.setLayout(layout);

		list = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		try {
			Path projectPath = project.getLocation().toFile().toPath();
			ExtensionFileVisitor visitor = new ExtensionFileVisitor("mydsl");
			project.getProject().accept(visitor);
			for (Path p : visitor.getFiles()) {
				String string = projectPath.relativize(p).toString();
				TableItem item = new TableItem(list, SWT.NONE);
				item.setText(string);
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

		list.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean complete = false;
				for (TableItem item : list.getItems()) {
					if (item.getChecked()) {
						complete = true;
						break;
					}
				}
				setPageComplete(complete);
				getWizard().getContainer().updateButtons();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		RowData gd = new RowData();
		list.setLayoutData(gd);

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}

	protected java.util.List<IFile> getSelection() {
		return Arrays.asList(list.getItems()).stream().filter(i -> {
			return i.getChecked();
		}).map(i -> {
			return i.getText();
		}).map(f -> {
			return project.getFile(f);
		}).collect(Collectors.toList());
	}
}
