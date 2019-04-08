/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gravity.eclipse.io.ModelSaver;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;
import org.gravity.mapping.secdfd.ui.wizard.TrafoJob;
import org.gravity.mapping.secdfd.views.actions.AcceptAction;
import org.gravity.mapping.secdfd.views.actions.RejectAction;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.hamcrest.core.IsInstanceOf;
import org.moflon.tgg.runtime.AbstractCorrespondence;
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

	private Label label;
	private TreeViewer treeViewer;
	private Composite parent;

	private IFolder gravityFolder;

	private ResourceSet resourceSet;

	private Entry<IFile, TypeGraph> pm;

	private Collection<EDFD> dfds;

	private Map<Mapping, Mapper> mappers;


	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		label = new Label(parent, SWT.NONE);
		label.setText(POPULATE_TEXT);

		IViewSite viewSite = getViewSite();
		IActionBars bars = viewSite.getActionBars();
		IToolBarManager tm = bars.getToolBarManager(); // Buttons on top
		tm.add(new Action("Continue") {
			
			public void run() {
				for(Mapper mapper : mappers.values()) {
					Mapping mapping = mapper.getMapping();
					System.out.println("Continue with: "+mapper);
					mapper.optimize();
					update();					
				}
			}
			
		});
		tm.add(new Action("Accept all") {
			
			public void run() {
				for(Mapper mapper : mappers.values()) {
					Mapping mapping = mapper.getMapping();
					new ArrayList<>(mapping.getSuggested()).forEach(corr -> mapper.accept(corr));
					update();					
				}
			}
			
		});
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

		Stream<SimpleEntry<IFile, EDFD>> dfds = loadDFDs(dfdFiles);
		try {
			trafoJob.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.ERROR, e.getLocalizedMessage(), e);
		}

		pm = getProgramModel(trafoJob);

		this.mappers = dfds.map(entry -> {
			IFile key = entry.getKey();
			String name = key.getName();
			name = name.substring(0, name.length() - key.getFileExtension().length() -1) + ".corr.xmi";
			IFile destination = gravityFolder.getFile(name);
			return new Mapper(pm.getValue(), entry.getValue(), destination);
		}).collect(Collectors.toMap(mapper -> mapper.getMapping(), mapper -> mapper));
		
		if (!label.isDisposed()) {
			label.dispose();
			parent.setLayout(new GridLayout(1, false));
			treeViewer = new TreeViewer(parent, SWT.BORDER);
			treeViewer.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					HashMap<String, IType> astTypes = null;
					try {
						astTypes = JavaASTUtil.getTypesForProject(JavaCore.create(gravityFolder.getProject()));
					} catch (JavaModelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					AbstractCorrespondence corr = null;
					ISelection s = event.getSelection();
					if (s instanceof StructuredSelection) {
						Object selection = ((IStructuredSelection) s).getFirstElement();
						if (selection instanceof MappingProcessDefinition) {
							corr = (AbstractCorrespondence) selection;
						}else if (selection instanceof MappingEntityType) {
							corr = (AbstractCorrespondence) selection;
						}//else root element was double clicked
					}
					if (corr != null) {
						EObject pmElement = CorrespondenceHelper.getSource(corr);
						TAbstractType type = null ;
						if (pmElement instanceof TMethodDefinition) {
							TMethodDefinition member = (TMethodDefinition) pmElement;
							type = member.getDefinedBy();
						}
						else if(pmElement instanceof TAbstractType){
						    type = (TAbstractType) pmElement;
						}
						else {
							LOGGER.log(Level.ERROR, "pmElement is not the correct instance type. (double click)");
						}
						if (type!=null) {
							//TODO: iType is null for type=TAbstractType
							IType iType = astTypes.get(type.getFullyQualifiedName());
							try {
								//TODO: open the file on this path in the left side from the package explorer
								File f = iType.getUnderlyingResource().getFullPath().toFile();
								try {
									java.awt.Desktop.getDesktop().open(f);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								//TODO: navigate to the line where the method is defined OR where the Type is defined
							} catch (JavaModelException e) {
								e.printStackTrace();
							}
						}
					}else {
						LOGGER.log(Level.ERROR, "Correspondence is null - something is wrong.");
					}

				}
			});
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
						labelProvider
								.getText(mappingProvider.getParent(selectedElement)).equals("suggested");

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

	public void update() {
		this.treeViewer.refresh();
	}

	/**
	 * A getter for the mapping view
	 * 
	 * @return The mapping view
	 */
	public static MappingView getMappingView() {
		try {
			return (MappingView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView(VIEW_ID);
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
}
