/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.util.Optional;
import java.util.Collection;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.ViewPart;
import org.gravity.mapping.secdfd.Defintion2Element;
import org.gravity.mapping.secdfd.SecdfdFactory;
import org.gravity.mapping.secdfd.Type2NamedEntity;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import eDFDFlowTracking.Asset;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.NamedEntity;
import eDFDFlowTracking.Process;

/**
 * @author speldszus
 *
 */
public class DFDSelectionView extends ViewPart {

	private final class UserdefinedAction extends Action {
		private EObject source;
		private final MappingView map;
		private IStructuredSelection selection;

		private UserdefinedAction(MappingView map) {
			this.map = map;
		}

		@Override
		public String getText() {
			return "map";
		}

		@Override
		public String getToolTipText() {
			return "Maps this element to the given element from the program model";
		}

		public void run() {
			Stream<? extends Object> stream = ((IStructuredSelection) selection).toList().stream();
			stream.filter(e -> !(e instanceof EDFD)).forEach(e -> {
				// TODO: Add to mapping
				Optional<Mapping> result = map.getMapping().stream()
						.filter(c -> c.getTarget().equals(((EObject) e).eContainer())).findAny();
				if (!result.isPresent()) {
					LOGGER.log(Level.ERROR, "Didn't found mapping");
					return;
				}
				Mapping mapping = result.get();
				AbstractCorrespondence userCorr = null;
				if (e instanceof Process) {
					MappingProcessDefinition corr = MappingFactory.eINSTANCE.createMappingProcessDefinition();
					corr.setSource((TMember) source);
					corr.setTarget((Element) e);
					userCorr = corr;
				} else if (e instanceof Asset) {
					Type2NamedEntity corr = SecdfdFactory.eINSTANCE.createType2NamedEntity();
					corr.setSource((TAbstractType) source);
					corr.setTarget((NamedEntity) e);
				} else if (e instanceof DataStore) {
					if (source instanceof TAbstractType) {
						Type2NamedEntity corr = SecdfdFactory.eINSTANCE.createType2NamedEntity();
						corr.setSource((TAbstractType) source);
						corr.setTarget((NamedEntity) e);
					} else {
						Defintion2Element corr = SecdfdFactory.eINSTANCE.createDefintion2Element();
						corr.setSource((TMember) source);
						corr.setTarget((Element) e);
					}
				}
				mapping.getCorrespondences().add(userCorr);
				mapping.getUserdefined().add(userCorr);
				map.update();
				System.out.println("Manually mapped: " + e);
			});
		}
	}

	private static final String POPULATE_TEXT = "Please wait while this view is populated";

	/**
	 * The ID of this view
	 */
	public static final String VIEW_ID = "org.gravity.mapping.secdfd.view.select";

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(DFDSelectionView.class);

	private Composite parent;
	private TreeViewer treeViewer;

	private UserdefinedAction action;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
	}

	@Override
	public void setFocus() {

	}

	/**
	 * Populates the view with the given content
	 *
	 */
	public void populate(EObject source, MappingView mappingView) {
		if (treeViewer == null) {
			parent.setLayout(new GridLayout(1, false));
			treeViewer = new TreeViewer(parent, SWT.BORDER);
			MappingLabelProvider labelProvider = new MappingLabelProvider();
			treeViewer.setContentProvider(new ITreeContentProvider() {

				@Override
				public Object[] getElements(Object inputElement) {
					if (inputElement instanceof Collection) {
						return ((Collection<?>) inputElement).toArray();
					}
					return null;
				}

				@Override
				public Object[] getChildren(Object parentElement) {
					if (parentElement instanceof EDFD) {
						EDFD dfd = ((EDFD) parentElement);
						if (source instanceof TAbstractType) {
							return dfd.getAsset().toArray();
						} else {
							return dfd.getElements().toArray();
						}
					}
					return null;
				}

				@Override
				public Object getParent(Object element) {
					return null;
				}

				@Override
				public boolean hasChildren(Object element) {
					return element instanceof EDFD;
				}
			});
			treeViewer.setLabelProvider(labelProvider);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.widthHint = parent.getSize().x - 10;
			layoutData.heightHint = parent.getSize().y - 10;
			treeViewer.getControl().setLayoutData(layoutData);

			action = new UserdefinedAction(mappingView);
			treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					ISelection selection = event.getSelection();
					if (selection instanceof IStructuredSelection) {
						action.selection = (IStructuredSelection) selection;
						MenuManager menuMgr = new MenuManager();
						Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
						treeViewer.getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr, treeViewer);
						menuMgr.add(action);
					}
				}
			});
			treeViewer.setInput(mappingView.getDFDs());
		}
		action.source = source;
		treeViewer.refresh(mappingView.getDFDs());
		parent.pack();
		parent.layout(true);
	}
}
