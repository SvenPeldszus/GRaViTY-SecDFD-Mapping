/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.eclipse.io.ModelSaver;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;
import org.gravity.mapping.secdfd.ui.wizard.TrafoJob;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.xtext.example.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

import eDFDFlowTracking.EDFD;

/**
 * @author speldszus
 *
 */
public class MappingView extends ViewPart {

	private final class AcceptAction extends Action {
		private final ISelection selection;
		private final Map<IFile, Mapping> corrs;

		private AcceptAction(ISelection selection, Map<IFile, Mapping> corrs) {
			this.selection = selection;
			this.corrs = corrs;
		}

		@Override
		public String getText() {
			return "accept";
		}

		@Override
		public String getToolTipText() {
			return "Accepts this mapping";
		}

		public void run() {
			Stream<? extends Object> stream = ((IStructuredSelection) selection).toList().stream();
			stream.filter(e -> e instanceof AbstractCorrespondence).map(e -> {
				return (AbstractCorrespondence) e;
			}).forEach(e -> {
				Mapping mapping = (Mapping) ((EObject) e).eContainer();
				if(!mapping.getUserdefined().contains(e)) {
					if(mapping.getIgnored().remove(e)) {
						mapping.getCorrespondences().add(e);
					}
					mapping.getSuggested().remove(e);
					mapping.getAccepted().add(e);
					treeViewer.refresh();
					updateMappingOnFilesystem(corrs, mapping);
				}
			});
		}
	}

	private final class RejectAction extends Action {
		private final ISelection selection;
		private final Map<IFile, Mapping> corrs;

		private RejectAction(ISelection selection, Map<IFile, Mapping> corrs) {
			this.selection = selection;
			this.corrs = corrs;
		}

		@Override
		public String getText() {
			return "reject";
		}

		@Override
		public String getToolTipText() {
			return "Rejects this mapping";
		}

		public void run() {
			Stream<? extends Object> stream = ((IStructuredSelection) selection).toList().stream();
			stream.filter(e -> e instanceof AbstractCorrespondence).map(e -> {
				return (AbstractCorrespondence) e;
			}).forEach(e -> {
				Mapping mapping = (Mapping) ((EObject) e).eContainer();
				mapping.getIgnored().add(e);
				mapping.getUserdefined().remove(e);
				mapping.getAccepted().remove(e);
				treeViewer.remove(e);
				updateMappingOnFilesystem(corrs, mapping);
			});
		}
	}

	private static final String POPULATE_TEXT = "Please wait while this view is populated";

	/**
	 * The ID of this view
	 */
	public static final String VIEW_ID = "org.gravity.mapping.secdfd.view";

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(MappingView.class);

	private Label label;
	private TreeViewer treeViewer;

	private IFolder gravityFolder;

	private ResourceSet resourceSet;

	private Entry<IFile, TypeGraph> pm;

	private Collection<EDFD> dfds;

	private Collection<Mapping> mapping;

	@Override
	public void createPartControl(Composite parent) {
		label = new Label(parent, SWT.NONE);
		label.setText(POPULATE_TEXT);

		IViewSite viewSite = getViewSite();
		IActionBars bars = viewSite.getActionBars();
		IToolBarManager tm = bars.getToolBarManager(); // Buttons on top
		IMenuManager mm = bars.getMenuManager(); // Drop down menu
		mm.add(new Action("Map project") {
			@Override
			public void run() {
				WizardDialog wizard = new WizardDialog(GravityUiActivator.getShell(),
						new MappingWizard(Collections.emptyList()));
				if (wizard.open() == Window.OK) {
					System.out.println("OK pressed");
				}
			}
		});
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

		Stream<SimpleEntry<IFile, EDFD>> dfds = loadDFDs(dfdFiles);
		try {
			trafoJob.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.ERROR, e.getLocalizedMessage(), e);
		}

		pm = getProgramModel(trafoJob);

		Map<IFile, Mapping> corrs = dfds.map(entry -> {
			Mapping corr = new Mapper().map(pm.getValue(), entry.getValue());
			String name = entry.getKey().getName() + ".corr.xmi";
			IFile corrFile = gravityFolder.getFile(name);
			URI uri = URI.createURI(corrFile.getLocation().makeRelativeTo(this.gravityFolder.getLocation()).toString());
			EList<EObject> contents = this.resourceSet.createResource(uri).getContents();
			contents.add(corr);
			ModelSaver.saveModel(corr, corrFile, new NullProgressMonitor());
			return new SimpleEntry<IFile, Mapping>(corrFile, corr);
		}).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		this.mapping = corrs.values();
		
		System.out.println(pm);
		System.out.println(corrs);

		Composite parent = label.getParent();
		if (!label.isDisposed()) {
			label.dispose();
			parent.setLayout(new GridLayout(1, false));
			treeViewer = new TreeViewer(parent, SWT.BORDER);
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
						boolean enabled = selectedElement instanceof AbstractCorrespondence && labelProvider
								.getText(mappingProvider.getParent(selectedElement)).equals("suggested");

						MenuManager menuMgr = new MenuManager();
						Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
//						menu.setEnabled(enabled);
						treeViewer.getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr, treeViewer);
						menuMgr.add(new RejectAction(selection, corrs));
						menuMgr.add(new AcceptAction(selection, corrs));

					}
				}
			});
		}
		treeViewer.setInput(corrs.entrySet());
		treeViewer.refresh();
		parent.pack();
		parent.layout(true);
	}

	/** 
	 * Requests the program model from the transformation job and adds it to the
	 * resource set of the DFDs
	 * 
	 * @param trafoJob The job creating the prohram model
	 * 
	 * @return The program model
	 */
	private Entry<IFile, TypeGraph> getProgramModel(TrafoJob trafoJob) {
		TypeGraph pm = trafoJob.getPM();
		IFile pmFile = gravityFolder.getFile(pm.getTName() + ".xmi");
		Resource resource = pm.eResource();
		URI pmUri = URI.createURI(pmFile.getLocation().makeRelativeTo(gravityFolder.getLocation()).toString());
		resource.setURI(pmUri);
		this.resourceSet.getResources().add(resource);
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
	private Stream<SimpleEntry<IFile, EDFD>> loadDFDs(Collection<IFile> files) {
		this.dfds = new HashSet<>();
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		this.resourceSet = resourceSet;
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Stream<SimpleEntry<IFile, EDFD>> dfds = files.parallelStream().map(f -> {
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
			return new SimpleEntry<IFile, EDFD>(f, dfd);
		}).filter(Objects::nonNull);
		return dfds;
	}

	/**
	 * @param pm the pm to set
	 */
	public void setPm(Entry<IFile, TypeGraph> pm) {
		this.pm = pm;
	}

	/**
	 * @param corrs
	 * @param mapping
	 */
	private void updateMappingOnFilesystem(Map<IFile, Mapping> corrs, Mapping mapping) {
		try {
			Optional<IFile> file = corrs.entrySet().parallelStream().filter(entry -> entry.getValue().equals(mapping)).map(entry -> entry.getKey()).findAny();
			if(file.isPresent()) {
				mapping.eResource().save(new FileOutputStream(file.get().getLocation().toString()), Collections.emptyMap());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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

	public Collection<Mapping> getMapping() {
		return this.mapping;
	}

	public void update() {
		this.treeViewer.refresh();
	}

}
