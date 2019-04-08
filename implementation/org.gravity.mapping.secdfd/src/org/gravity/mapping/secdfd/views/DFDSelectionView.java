/**
 * 
 */
package org.gravity.mapping.secdfd.views;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
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
import org.gravity.mapping.secdfd.views.actions.UserdefinedAction;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TMethodDefinition;

import com.google.common.collect.Streams;

import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Process;

/**
 * @author speldszus
 *
 */
public class DFDSelectionView extends ViewPart {

	private final class DFDSelectionContentProvider implements ITreeContentProvider {
		private EObject source;

		private DFDSelectionContentProvider(EObject source) {
			this.source = source;
		}

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
					return Streams.concat(dfd.getElements().stream().filter(e -> e instanceof DataStore),
							dfd.getAsset().stream()).toArray();
				} else if (source instanceof TFieldDefinition) {
					Set<EObject> results = new HashSet<>();
					results.addAll(dfd.getAsset());
					results.addAll(dfd.getElements().stream().filter(element -> (element instanceof DataStore))
							.collect(Collectors.toSet()));
					return results.toArray();
				} else if (source instanceof TMethodDefinition) {
					return dfd.getElements().stream().filter(element -> (element instanceof Process)).toArray();
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

		public void updateSouce(EObject source) {
			this.source = source;
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
	static final Logger LOGGER = Logger.getLogger(DFDSelectionView.class);

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
	public void populate(List<EObject> source, MappingView mappingView) {
		if (treeViewer == null) {
			initTree(source.get(0), mappingView);
		}
		action.setSource(source);
		((DFDSelectionContentProvider) treeViewer.getContentProvider()).updateSouce(source.get(0));
		treeViewer.refresh(mappingView.getDFDs(), true);
		treeViewer.getControl().update();
		parent.pack();
		parent.layout(true);
	}

	/**
	 * Creates a new tree showing the possible elements corresponding with a source
	 * element
	 * 
	 * @param source      The source element
	 * @param mappingView The view holding all mappings
	 */
	private void initTree(EObject source, MappingView mappingView) {
		parent.setLayout(new GridLayout(1, false));
		treeViewer = new TreeViewer(parent, SWT.BORDER);
		MappingLabelProvider labelProvider = new MappingLabelProvider();
		treeViewer.setContentProvider(new DFDSelectionContentProvider(source));
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
					action.setSelection((IStructuredSelection) selection);
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
}
