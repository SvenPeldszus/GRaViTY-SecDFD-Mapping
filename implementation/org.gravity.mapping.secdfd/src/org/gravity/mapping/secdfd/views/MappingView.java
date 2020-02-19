/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.eclipse.io.ModelSaver;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;
import org.gravity.mapping.secdfd.ui.wizard.TrafoJob;
import org.gravity.mapping.secdfd.views.actions.AcceptAction;
import org.gravity.mapping.secdfd.views.actions.AcceptAllAction;
import org.gravity.mapping.secdfd.views.actions.CheckContractsAction;
import org.gravity.mapping.secdfd.views.actions.ContinueAction;
import org.gravity.mapping.secdfd.views.actions.MapProjectAction;
import org.gravity.mapping.secdfd.views.actions.RejectAction;
import org.gravity.mapping.secdfd.views.actions.RejectAllAction;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.SecDFDStandaloneSetup;

import com.google.inject.Injector;

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

	private ResourceSet resourceSet;

	private Entry<IFile, TypeGraph> pm;

	private Collection<EDFD> dfds;

	private final Map<Mapping, Mapper> mappers = new HashMap<>();

	private ContinueAction continueAction;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		label = new Label(parent, SWT.NONE);
		label.setText(POPULATE_TEXT);

		IViewSite viewSite = getViewSite();
		IActionBars bars = viewSite.getActionBars();
		IToolBarManager tm = bars.getToolBarManager(); // Buttons on top
		tm.add((continueAction = new ContinueAction(this)));
		tm.add(new AcceptAllAction(this));
		tm.add(new RejectAllAction(this));
		tm.add(new CheckContractsAction(this));
		IMenuManager mm = bars.getMenuManager(); // Drop down menu
		mm.add(new MapProjectAction());
	}

	public Mapper getMapper(Mapping mapping) {
		return mappers.get(mapping);
	}

	@Override
	public void setFocus() {
		if (!label.isDisposed()) {
			label.setFocus();
		}
	}

	/**
	 * Populates the view with the given content
	 * 
	 * @param gravityFolder The folder holding all temp files
	 * @param dfdFiles      The selected DFDs
	 * @param trafoJob      The job creating a program model
	 */
	public void populate(IFolder gravityFolder, Collection<IFile> dfdFiles, TrafoJob trafoJob) {
		this.gravityFolder = gravityFolder;

		Map<IFile, EDFD> dfds = loadDFDs(dfdFiles);
		try {
			trafoJob.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.ERROR, e.getLocalizedMessage(), e);
			Thread.currentThread().interrupt();
		}

		pm = getProgramModel(trafoJob);

		this.mappers.clear();
		for (Entry<IFile, EDFD> entry : dfds.entrySet()) {
			IFile key = entry.getKey();
			String name = key.getName();
			name = name.substring(0, name.length() - key.getFileExtension().length() - 1) + ".corr.xmi";
			IFile destination = gravityFolder.getFile(name);
			Mapper mapper = new Mapper(pm.getValue(), entry.getValue(), destination);
			mappers.put(mapper.getMapping(), mapper);
			mapper.optimize();
			mapper.addUserdefinedListener(continueAction);
		}
		if (!label.isDisposed()) {
			label.dispose();
			parent.setLayout(new GridLayout(1, false));
			treeViewer = new TreeViewer(parent, SWT.BORDER);
			treeViewer.addDoubleClickListener(new OpenJavaFileDoubleClickListener(gravityFolder));
			MappingContentProvider mappingProvider = new MappingContentProvider();
			MappingLabelProvider labelProvider = new MappingLabelProvider();
			treeViewer.setContentProvider(mappingProvider);
			treeViewer.setLabelProvider(labelProvider);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.widthHint = parent.getSize().x - 10;
			layoutData.heightHint = parent.getSize().y - 10;
			treeViewer.getControl().setLayoutData(layoutData);
			treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					ISelection selection = event.getSelection();
					if (selection instanceof IStructuredSelection) {
						Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
						labelProvider.getText(mappingProvider.getParent(selectedElement)).equals("suggested");

						MenuManager menuMgr = new MenuManager();
						Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
//						menu.setEnabled(enabled);
						treeViewer.getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr, treeViewer);
						menuMgr.add(new RejectAction(((IStructuredSelection) selection).toList()));
						menuMgr.add(new AcceptAction(((IStructuredSelection) selection).toList()));

					}
				}
			});
		}
		treeViewer.setInput(mappers.keySet());
		treeViewer.refresh();
		parent.pack();
		parent.layout(true);
	}

	/**
	 * Requests the program model from the transformation job and adds it to the
	 * resource set of the DFDs
	 * 
	 * @param trafoJob The job creating the program model
	 * 
	 * @return The program model
	 */
	private Entry<IFile, TypeGraph> getProgramModel(TrafoJob trafoJob) {
		TypeGraph pm = trafoJob.getPM();
		IFile pmFile = gravityFolder.getFile(pm.getTName() + ".xmi");
		URI pmUri = URI.createURI(pmFile.getLocation().makeRelativeTo(gravityFolder.getLocation()).toString());
		Resource resource = pm.eResource();
		if (resource == null) {
			Optional<Resource> result = this.resourceSet.getResources().parallelStream()
					.filter(r -> r.getURI().equals(pmUri)).findAny();
			if (result.isPresent()) {
				resource = result.get();
			} else {
				resource = this.resourceSet.createResource(pmUri);
			}
			resource.getContents().clear();
			resource.getContents().add(pm);
		} else {
			resource.setURI(pmUri);
			this.resourceSet.getResources().add(resource);
		}
		if (!pmFile.exists()) {
			ModelSaver.saveModel(resource, pmFile, new NullProgressMonitor());
		}
		return new SimpleEntry<IFile, TypeGraph>(pmFile, pm);
	}

	/**
	 * Loads the selected DFDs
	 * 
	 * @param files
	 * 
	 * @return A stream of DFDs and the files they are stored in
	 */
	private Map<IFile, EDFD> loadDFDs(Collection<IFile> files) {
		Map<IFile, EDFD> loadedDFDs = new HashMap<>();
		this.dfds = new HashSet<>();
		Injector injector = new SecDFDStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		this.resourceSet = resourceSet;
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		for (IFile f : files) {
			URI uri = URI.createURI(f.getLocation().makeRelativeTo(gravityFolder.getLocation()).toString());
			Resource resource = resourceSet.createResource(uri);
			try {
				resource.load(f.getContents(), Collections.emptyMap());
			} catch (IOException | CoreException e) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
			EDFD dfd = (EDFD) resource.getContents().get(0);
			this.dfds.add(dfd);
			loadedDFDs.put(f, dfd);
		}
		return loadedDFDs;
	}

	/**
	 * @param pm the pm to set
	 */
	public void setPm(Entry<IFile, TypeGraph> pm) {
		this.pm = pm;
	}

	/**
	 * @return the pm
	 */
	public Entry<IFile, TypeGraph> getProgramModel() {
		return pm;
	}

	public Collection<EDFD> getDFDs() {
		return this.dfds;
	}

	public Collection<Mapping> getMappings() {
		return this.mappers.keySet();
	}

	public Map<Mapping, Mapper> getMappers() {
		return mappers;
	}

	public void update() {
		for (Mapper mapper : mappers.values()) {
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
		} catch (PartInitException e) {
			MappingWizard.LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTree() {
		return treeViewer;
	}

	public IFolder getGravityFolder() {
		return gravityFolder;
	}
}
