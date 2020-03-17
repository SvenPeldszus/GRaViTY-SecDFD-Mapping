package org.gravity.mapping.secdfd.ui.wizard;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
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
	private Set<String> selectedDFDs;
	private Set<String> dfds;

	public SecDFDPage(IJavaProject javaProject) throws CoreException {
		super("SecDFDs");
		setDescription("Select the SecDFDs to Map");
		this.project = javaProject.getProject();
		this.selectedDFDs = Collections.emptySet();
		Path projectPath = this.project.getLocation().toFile().toPath();
		ExtensionFileVisitor visitor = new ExtensionFileVisitor("secdfd");
		this.project.getProject().accept(visitor);
		this.dfds = visitor.getFiles().parallelStream().map(p -> projectPath.relativize(p).toString())
				.collect(Collectors.toSet());
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		Layout layout = new RowLayout();
		container.setLayout(layout);

		list = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		for (String string : dfds) {
			if (!selectedDFDs.contains(string)) {
				TableItem item = new TableItem(list, SWT.NONE);
				item.setText(string);
			}
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
				// There are no defualt selections
			}
		});

		RowData gd = new RowData();
		list.setLayoutData(gd);

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}

	protected java.util.List<IFile> getSelection() {
		return Arrays.asList(list.getItems()).stream().filter(TableItem::getChecked).map(TableItem::getText)
				.map(project::getFile).collect(Collectors.toList());
	}

	public void setAlreadyTranslated(Set<String> selectedDFDs) {
		this.selectedDFDs = selectedDFDs;
		LinkedList<Integer> remove = new LinkedList<>();
		Set<String> add = new HashSet<>(this.dfds);
		TableItem[] items = this.list.getItems();
		for (int i = 0; i < items.length; i++) {
			String text = items[i].getText();
			if (selectedDFDs.contains(text)) {
				remove.push(i);
			}
			else {
			}
			add.remove(text);
		}
		for (int i : remove) {
			list.remove(i);
		}
		add.removeAll(selectedDFDs);
		for (String string : add) {
			TableItem item = new TableItem(list, SWT.NONE);
			item.setText(string);
		}
		checkAndSetComplete();
	}

	/**
	 * Checks if this page is complete and updates the pages can finish state
	 */
	public void checkAndSetComplete() {
		boolean complete = false;
		for(TableItem item : list.getItems()) {
			complete |= item.getChecked();
		}
		setPageComplete(complete || list.getItems().length == 0|| !selectedDFDs.isEmpty());
		getWizard().getContainer().updateButtons();
	}

	@Override
	public boolean isPageComplete() {
		boolean complete = false;
		for(TableItem item : list.getItems()) {
			complete |= item.getChecked();
		}
		
		return complete || list.getItems().length == 0|| !selectedDFDs.isEmpty();
	}

}
