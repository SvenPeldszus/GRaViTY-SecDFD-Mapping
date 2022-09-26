package org.gravity.mapping.secdfd.ui.wizard;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.gravity.mapping.secdfd.model.mapping.Mapping;

public class CorrPage extends WizardPage {

	private static final Logger LOGGER = Logger.getLogger(CorrPage.class);

	private IJavaProject project;
	private Map<String, Path> corrFiles;
	private List<IFile> selectedCorrFiles;
	private MappingWizard wizard;

	protected CorrPage(IJavaProject project, Collection<Path> corrFiles, MappingWizard wizard) {
		super("Existing Correspondences");
		setDescription("Select the existing mappings you want to use.");
		this.project = project;
		this.corrFiles = corrFiles.parallelStream().collect(Collectors.toMap(f -> f.getFileName().toString(), f -> f));
		this.wizard = wizard;
		this.selectedCorrFiles = new ArrayList<>();
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		Layout layout = new RowLayout();
		container.setLayout(layout);

		Table list = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		list.setSize(400, 600);
		corrFiles.keySet().stream().forEach(string -> {
			TableItem item = new TableItem(list, SWT.NONE);
			item.setText(string);
		});

		list.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Path projectPath = project.getProject().getLocation().toFile().toPath();

				selectedCorrFiles = Stream.of(list.getItems()).filter(TableItem::getChecked).map(TableItem::getText)
						.map(corrFiles::get)
						.map(path -> project.getProject().getFile(projectPath.relativize(path).toString()))
						.collect(Collectors.toList());
//				getWizard().getContainer().updateButtons();
			}
		});

		RowData gd = new RowData();
		list.setLayoutData(gd);

		// required to avoid an error in the system
		setControl(container);
	}

	@Override
	public IWizardPage getNextPage() {
		try {
			SecDFDPage secDFDPage = wizard.getSecDFDPage(project);
			Set<String> selectedDFDs = new HashSet<>();
			ResourceSet rs = new ResourceSetImpl();
			for (IFile corr : selectedCorrFiles) {
				URI corrFileURI = URI.createPlatformResourceURI(
						project.getProject().getName() + '/' + corr.getProjectRelativePath(), true);
				Resource r = rs.getResource(corrFileURI, true);
				EObject inst = r.getContents().get(0);
				if (inst instanceof Mapping) {
					EObject target = ((Mapping) inst).getTarget();
					URI uri = target.eResource().getURI();
					String dfdPath;
					if (uri.isPlatform()) {
						dfdPath = uri.toPlatformString(true);
					} else {
						throw new IllegalStateException();
					}
					selectedDFDs.add(dfdPath);
				}
			}
			secDFDPage.setAlreadyTranslated(selectedDFDs);
			return secDFDPage;
		} catch (CoreException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			return null;
		}
	}

	@Override
	public boolean canFlipToNextPage() {
		return true;
	}

	@Override
	public boolean isPageComplete() {
		return true;
	}

	public Collection<IFile> getSelection() {
		return selectedCorrFiles;
	}
}
