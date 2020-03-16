package org.gravity.mapping.secdfd.ui.views.actions;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.views.DFDSelectionView;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.secdfd.model.EDFD;

public final class UserdefinedAction extends Action {
	
	/**
	 * The logger of this action
	 */
	private static final Logger LOGGER = Logger.getLogger(UserdefinedAction.class);
	
	/**
	 * The source element which should be mapped
	 */
	private List<EObject> source;
	
	
	private final MappingView mappingView;
	private final DFDSelectionView selectionView;

	private IStructuredSelection selection;

	
	public UserdefinedAction(MappingView mappingView, DFDSelectionView selectionView) {
		this.mappingView = mappingView;
		this.selectionView = selectionView;
	}

	@Override
	public String getText() {
		return "map";
	}

	@Override
	public String getToolTipText() {
		return "Maps this element to the given element from the program model";
	}

	@Override
	public void run() {
		Stream<?> stream = selection.toList().stream();
		stream.filter(e -> !(e instanceof EDFD)).forEach(e -> {
			Optional<Mapping> result = mappingView.getMappings().stream()
					.filter(c -> c.getTarget().equals(((EObject) e).eContainer())).findAny();
			if (!result.isPresent()) {
				LOGGER.log(Level.ERROR, "Didn't found mapping");
				return;
			}
			Mapping mapping = result.get();
			Mapper mapper = mappingView.getMapper(mapping);
			source.forEach(s -> mapper.userdefined(s, (EObject) e));
			mappingView.update();
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(selectionView);
		});
	}
	
	@Override
	public boolean isEnabled(){
		return true;//source != null;
	}

	public void setSource(List<EObject> source) {
		this.source = source;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}
}