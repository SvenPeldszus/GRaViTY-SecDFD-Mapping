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
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.secdfd.dsl.SecDFDStandaloneSetup;

public class CorrPage extends WizardPage {

	private static final Logger LOGGER = Logger.getLogger(CorrPage.class);

	private final IJavaProject project;
	private final Map<String, Path> corrFiles;
	private List<IFile> selectedCorrFiles;
	private final MappingWizard wizard;

	protected CorrPage(final IJavaProject project, final Collection<Path> corrFiles, final MappingWizard wizard) {
		super("Existing Correspondences");
		this.setDescription("Select the existing mappings you want to use.");
		this.project = project;
		this.corrFiles = corrFiles.parallelStream().collect(Collectors.toMap(f -> f.getFileName().toString(), f -> f));
		this.wizard = wizard;
		this.selectedCorrFiles = new ArrayList<>();
	}

	@Override
	public void createControl(final Composite parent) {
		final var container = new Composite(parent, SWT.NONE);
		final Layout layout = new RowLayout();
		container.setLayout(layout);

		final var list = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		list.setSize(400, 600);
		this.corrFiles.keySet().stream().forEach(string -> {
			final var item = new TableItem(list, SWT.NONE);
			item.setText(string);
		});

		list.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				final var projectPath = CorrPage.this.project.getProject().getLocation().toFile().toPath();

				CorrPage.this.selectedCorrFiles = Stream.of(list.getItems()).filter(TableItem::getChecked)
						.map(TableItem::getText)
						.map(CorrPage.this.corrFiles::get)
						.map(path -> CorrPage.this.project.getProject()
								.getFile(projectPath.relativize(path).toString()))
						.collect(Collectors.toList());
//				getWizard().getContainer().updateButtons();
			}
		});

		final var gd = new RowData();
		list.setLayoutData(gd);

		// required to avoid an error in the system
		this.setControl(container);
	}

	@Override
	public IWizardPage getNextPage() {
		try {
			final var secDFDPage = this.wizard.getSecDFDPage(this.project);
			final Set<String> selectedDFDs = new HashSet<>();
			final var injector = new SecDFDStandaloneSetup().createInjectorAndDoEMFRegistration();
			final var rs = injector.getInstance(XtextResourceSet.class);
			for (final IFile corr : this.selectedCorrFiles) {
				final var corrFileURI = URI.createPlatformResourceURI(
						this.project.getProject().getName() + '/' + corr.getProjectRelativePath(), true);
				final var r = rs.getResource(corrFileURI, true);
				final var inst = r.getContents().get(0);
				if (inst instanceof final Mapping mapping) {
					final var target = mapping.getTarget();
					final var uri = target.eResource().getURI();
					String dfdPath;
					if (!uri.isPlatform()) {
						throw new IllegalStateException();
					}
					dfdPath = uri.toPlatformString(true);
					selectedDFDs.add(dfdPath);
				}
			}
			secDFDPage.setAlreadyTranslated(selectedDFDs);
			return secDFDPage;
		} catch (final CoreException e) {
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
		return this.selectedCorrFiles;
	}
}
