package org.gravity.mapping.secdfd.ui.views.actions;

import java.util.List;
import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.mapping.secdfd.AbstractCorrespondence;

public final class AcceptAction extends Action {
	/**
	 * 
	 */
	private final List<?> selection;
	
	public AcceptAction(List<?> selection) {
		this.selection = selection;
	}

	@Override
	public String getText() {
		return "accept";
	}

	@Override
	public String getToolTipText() {
		return "Accepts this mapping";
	}

	@Override
	public void run() {
		MappingView mappingView = MappingView.getMappingView();
		selection.stream()
		.filter(e -> e instanceof AbstractCorrespondence).map(e -> (AbstractCorrespondence) e).forEach(e -> {
			Mapping mapping = (Mapping) e.eContainer();
			if(!mapping.getUserdefined().contains(e)) {
				mappingView.getMapper(mapping).accept(e);
			}
		});
		mappingView.update();
	}
}