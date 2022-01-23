/**
 *
 */
package org.gravity.mapping.secdfd.ui.views;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.eclipse.io.ModelSaver;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.views.actions.AcceptAction;
import org.gravity.mapping.secdfd.ui.views.actions.AcceptAllAction;
import org.gravity.mapping.secdfd.ui.views.actions.CheckContractsAction;
import org.gravity.mapping.secdfd.ui.views.actions.ContinueAction;
import org.gravity.mapping.secdfd.ui.views.actions.MapProjectAction;
import org.gravity.mapping.secdfd.ui.views.actions.RejectAction;
import org.gravity.mapping.secdfd.ui.views.actions.RejectAllAction;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;
import org.gravity.mapping.secdfd.ui.wizard.TrafoJob;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.SecDFDStandaloneSetup;
import org.secdfd.model.EDFD;

/**
 * @author speldszus
 *
 */
public class MappingView extends ViewPart {

	private static final String POPULATE_TEXT = "Please wait while this view is populated";

	/**
	 * The ID of this view
	 */
	public static final String VIEW_ID = "org.gravity.mapping.secdfd.view";

	/**
	 * The logger of this class
	 */
	static final Logger LOGGER = Logger.getLogger(MappingView.class);

	private Label label;
	private TreeViewer treeViewer;
	private Composite parent;

	private IFolder gravityFolder;

	private Entry<IFile, TypeGraph> pm;

	private Collection<EDFD> dfds;

	private final Map<Mapping, Mapper> mappers = new HashMap<>();

	private ContinueAction continueAction;

	@Override
	public void createPartControl(final Composite parent) {
		this.parent = parent;
		this.label = new Label(parent, SWT.NONE);
		this.label.setText(POPULATE_TEXT);

		final var viewSite = getViewSite();
		final var bars = viewSite.getActionBars();
		final var tm = bars.getToolBarManager(); // Buttons on top
		tm.add((this.continueAction = new ContinueAction(this)));
		tm.add(new AcceptAllAction(this));
		tm.add(new RejectAllAction(this));
		tm.add(new CheckContractsAction(this));
		final var mm = bars.getMenuManager(); // Drop down menu
		mm.add(new MapProjectAction());
	}

	public Mapper getMapper(final Mapping mapping) {
		return this.mappers.get(mapping);
	}

	@Override
	public void setFocus() {
		if (!this.label.isDisposed()) {
			this.label.setFocus();
		}
	}

	/**
	 * Populates the view with the given content
	 *
	 * @param gravityFolder The folder holding all temp files
	 * @param dfdFiles      The selected DFDs
	 * @param selectedMappings
	 * @param trafoJob      The job creating a program model
	 * @throws CoreException
	 * @throws IOException
	 */
	public void populate(final IFolder gravityFolder, final Collection<IFile> dfdFiles, final Collection<IFile> selectedMappings, final TrafoJob trafoJob) throws IOException, CoreException {

		final Map<IFile, EDFD> dfdMap = new HashMap<>(dfdFiles.size());

		final var rs = loadDFDs(dfdFiles, gravityFolder, dfdMap);
		try {
			trafoJob.join();
		} catch (final InterruptedException e) {
			LOGGER.log(Level.ERROR, e.getLocalizedMessage(), e);
			Thread.currentThread().interrupt();
		}
		final var pmx = getProgramModel(trafoJob, rs, gravityFolder);

		populate(gravityFolder, dfdMap, pmx, selectedMappings);
	}

	/**
	 * Populates the view with the given content
	 *
	 * @param gravityFolder The folder holding all temp files
	 * @param dfdMap        The selected DFDs and the files they are stored in
	 * @param pm            the File holding the program model and the model
	 * @throws CoreException
	 * @throws IOException
	 */
	private void populate(final IFolder gravityFolder, final Map<IFile, EDFD> dfdMap, final Entry<IFile, TypeGraph> pm, final Collection<IFile> selectedMappings) throws IOException, CoreException {
		this.gravityFolder = gravityFolder;
		this.dfds = new HashSet<>(dfdMap.values());
		this.pm = pm;
		if (!this.label.isDisposed()) {
			this.label.dispose();
			createMappingTable(gravityFolder.getProject());
		}

		clearMappers();
		for (final Entry<IFile, EDFD> entry : dfdMap.entrySet()) {
			final var key = entry.getKey();
			var name = key.getName();
			name = name.substring(0, name.length() - key.getFileExtension().length() - 1) + ".corr.xmi";
			final var destination = gravityFolder.getFile(name);
			final var mapper = new Mapper(pm.getValue(), entry.getValue(), destination);
			mapper.optimize();
			mapper.addUserdefinedListener(this.continueAction);
			this.mappers.put(mapper.getMapping(), mapper);
		}

		final var rs = pm.getValue().eResource().getResourceSet();
		for(final IFile mappingFile : selectedMappings) {
			final var mapper = new Mapper(mappingFile, rs);
			mapper.addUserdefinedListener(this.continueAction);
			this.mappers.put(mapper.getMapping(), mapper);
			this.dfds.add(mapper.getDFD());
		}

		this.treeViewer.setInput(this.mappers.keySet());
		this.treeViewer.refresh();
		this.parent.pack();
		this.parent.layout(true);
	}

	/**
	 * Clears the exisitng mappers
	 */
	private void clearMappers() {
		this.mappers.clear();
	}

	/**
	 * @param project The project the table should be linked to
	 */
	private void createMappingTable(final IProject project) {
		this.parent.setLayout(new GridLayout(1, false));
		this.treeViewer = new TreeViewer(this.parent, SWT.BORDER);
		this.treeViewer.addDoubleClickListener(new OpenJavaFileDoubleClickListener(project));
		final var mappingProvider = new MappingContentProvider();
		final var labelProvider = new MappingLabelProvider();
		this.treeViewer.setContentProvider(mappingProvider);
		this.treeViewer.setLabelProvider(labelProvider);
		final var layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = this.parent.getSize().x - 10;
		layoutData.heightHint = this.parent.getSize().y - 10;
		this.treeViewer.getControl().setLayoutData(layoutData);
		this.treeViewer.addSelectionChangedListener(event -> {
			final var selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				final var selectedElement = ((IStructuredSelection) selection).getFirstElement();
				labelProvider.getText(mappingProvider.getParent(selectedElement)).equals("suggested");

				final var menuMgr = new MenuManager();
				final var menu = menuMgr.createContextMenu(this.treeViewer.getControl());
				//				menu.setEnabled(enabled);
				this.treeViewer.getControl().setMenu(menu);
				getSite().registerContextMenu(menuMgr, this.treeViewer);
				menuMgr.add(new RejectAction(((IStructuredSelection) selection).toList()));
				menuMgr.add(new AcceptAction(((IStructuredSelection) selection).toList()));

			}
		});
	}

	/**
	 * Requests the program model from the transformation job and adds it to the
	 * resource set of the DFDs
	 *
	 * @param trafoJob The job creating the program model
	 *
	 * @return The program model
	 */
	private static Entry<IFile, TypeGraph> getProgramModel(final TrafoJob trafoJob, final ResourceSet rs, final IFolder gravityFolder) {
		final var model = trafoJob.getPM();
		final var pmFile = gravityFolder.getFile(model.getTName() + ".xmi");
		final var pmUri = URI.createPlatformResourceURI(pmFile.getProject().getName()+'/'+pmFile.getProjectRelativePath().toString(), true);
		var resource = model.eResource();
		if (resource == null) {
			final var result = rs.getResources().parallelStream().filter(r -> r.getURI().equals(pmUri))
					.findAny();
			if (result.isPresent()) {
				resource = result.get();
			} else {
				resource = rs.createResource(pmUri);
			}
			resource.getContents().clear();
			resource.getContents().add(model);
		} else {
			resource.setURI(pmUri);
			rs.getResources().add(resource);
		}
		if (!pmFile.exists()) {
			ModelSaver.saveModel(model, pmFile);
		}
		return new SimpleEntry<>(pmFile, model);
	}

	/**
	 * Loads the selected DFDs
	 *
	 * @param files
	 *
	 * @return A stream of DFDs and the files they are stored in
	 */
	private static ResourceSet loadDFDs(final Collection<IFile> files, final IFolder gravityFolder, Map<IFile, EDFD> loadedDFDs) {
		if(loadedDFDs == null) {
			loadedDFDs = new HashMap<>();
		}
		final var injector = new SecDFDStandaloneSetup().createInjectorAndDoEMFRegistration();
		final var resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		for (final IFile f : files) {
			final var uri = URI.createPlatformResourceURI(f.getProject().getName()+'/'+f.getProjectRelativePath().toString(), true);
			final var resource = resourceSet.createResource(uri);
			try {
				resource.load(f.getContents(), Collections.emptyMap());
			} catch (IOException | CoreException e) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
			final var dfd = (EDFD) resource.getContents().get(0);
			loadedDFDs.put(f, dfd);
		}
		return resourceSet;
	}

	/**
	 * @param pm the pm to set
	 */
	public void setPm(final Entry<IFile, TypeGraph> pm) {
		this.pm = pm;
	}

	/**
	 * @return the pm
	 */
	public Entry<IFile, TypeGraph> getProgramModel() {
		return this.pm;
	}

	public Collection<EDFD> getDFDs() {
		return this.dfds;
	}

	public Collection<Mapping> getMappings() {
		return this.mappers.keySet();
	}

	public Map<Mapping, Mapper> getMappers() {
		return this.mappers;
	}

	public void update() {
		for (final Mapper mapper : this.mappers.values()) {
			mapper.updateMappingOnFilesystem();
		}
		this.treeViewer.refresh();
	}

	/**
	 * A getter for the mapping view
	 *
	 * @return The mapping view
	 */
	public static MappingView getMappingView() {
		try {
			return (MappingView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(VIEW_ID);
		} catch (final PartInitException e) {
			MappingWizard.LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTree() {
		return this.treeViewer;
	}

	public IFolder getGravityFolder() {
		return this.gravityFolder;
	}
}
