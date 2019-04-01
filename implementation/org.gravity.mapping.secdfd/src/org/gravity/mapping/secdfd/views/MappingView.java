/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.internal.views.markers.MarkersTreeViewer;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.eclipse.io.ModelSaver;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;
import org.gravity.mapping.secdfd.ui.wizard.TrafoJob;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;
import org.xtext.example.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

import eDFDFlowTracking.EDFD;

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
	private static final Logger LOGGER = Logger.getLogger(MappingView.class);
	
	Label label;

	private IFolder gravityFolder;

	private ResourceSet resourceSet;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		
		TreeViewer viewer = new TreeViewer(new Tree(parent, SWT.H_SCROLL
				/*| SWT.VIRTUAL */| SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION));
		viewer.getTree().setLinesVisible(true);
		viewer.setUseHashlookup(true);
		Tree tree = viewer.getTree();
		TableLayout layout = new TableLayout();
		for(String col : new String[] {"Keep","Program Model", "SecDFD"}) {
			TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
			column.getColumn().setText(col);
		}
		viewer.getTree().setLayout(layout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.layout(true);
		
		IViewSite viewSite = getViewSite();
		IActionBars bars = viewSite.getActionBars();
		IToolBarManager tm = bars.getToolBarManager(); // Buttons on top
		IMenuManager mm = bars.getMenuManager(); // Drop down  menu
		mm.add(new Action("Map project") {
			@Override
			public void run() {
				WizardDialog wizard = new WizardDialog(GravityUiActivator.getShell(),new MappingWizard(Collections.emptyList()));
				if(wizard.open() == Window.OK) {
					System.out.println("OK pressed");
				}
			}
		});
		
		label = new Label(parent, SWT.NONE);
	}

	@Override
	public void setFocus() {
		label.setFocus();
	}

	/**
	 * Populates the view with the given content
	 * 
	 * @param gravityFolder The folder holding all temp files
	 * @param dfdFiles The selected DFDs
	 * @param trafoJob The job creating a program model
	 */
	public void populate(IFolder gravityFolder, Collection<IFile> dfdFiles, TrafoJob trafoJob) {
		clearView();
		
		this.gravityFolder = gravityFolder;

		Stream<SimpleEntry<IFile, EDFD>> dfds = loadDFDs(dfdFiles);
		try {
			trafoJob.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.ERROR, e.getLocalizedMessage(), e);
		}

		Entry<IFile, TypeGraph> pm = getProgramModel(trafoJob);

		Map<IFile, CorrespondenceModel> corrs = dfds.map(entry -> {
			CorrespondenceModel corr = new Mapper().map(pm.getValue(), entry.getValue());
			String name = entry.getKey().getName() + ".corr.xmi";
			IFile corrFile = gravityFolder.getFile(name);
			URI uri = URI.createURI(corrFile.getLocation().makeRelativeTo(this.gravityFolder.getLocation()).toString());
			EList<EObject> contents = this.resourceSet.createResource(uri).getContents();
			contents.add(corr);
			ModelSaver.saveModel(corr, corrFile, new NullProgressMonitor());
			return new SimpleEntry<IFile, CorrespondenceModel>(corrFile, corr);
		}).collect(Collectors.toMap(e -> e.getKey(), e->e.getValue()));
		
		System.out.println(pm);
		System.out.println(corrs);
		
		StringBuilder builder = new StringBuilder("Mappings for ");
		builder.append(pm.getValue().getTName());
		builder.append(":\n\n");
		for(Entry<IFile, CorrespondenceModel> e : corrs.entrySet()) {
			builder.append(e.getKey().getName());
			builder.append('\n');
			for(EObject c : e.getValue().getCorrespondences()) {
				builder.append(CorrespondenceHelper.getSource((AbstractCorrespondence) c));
				builder.append(" <--> ");
				builder.append(CorrespondenceHelper.getTarget((AbstractCorrespondence) c));
				builder.append('\n');
			}
		}
		label.setText(builder.toString());
		label.getParent().update();
	}

	/**
	 * Removes everything from the view
	 */
	private void clearView() {
		label.setText(POPULATE_TEXT);
		label.getParent().update();
	}

	/**
	 * Requests the program model from the transformation job and adds it to the
	 * resource set of the DFDs
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
		if(!pmFile.exists()) {
			ModelSaver.saveModel(resource, pmFile, new NullProgressMonitor());
		}
		return new SimpleEntry<IFile, TypeGraph>(pmFile, pm);
	}
	
	/**
	 * Loads the selected DFDs
	 * @param files 
	 * 
	 * @return A stream of DFDs and the files they are stored in
	 */
	private Stream<SimpleEntry<IFile, EDFD>> loadDFDs(Collection<IFile> files) {
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
			return new SimpleEntry<IFile, EDFD>(f, (EDFD) resource.getContents().get(0));
		}).filter(Objects::nonNull);
		return dfds;
	}

}
