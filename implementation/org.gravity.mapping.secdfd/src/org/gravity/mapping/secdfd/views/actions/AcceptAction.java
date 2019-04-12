package org.gravity.mapping.secdfd.views.actions;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.views.MappingView;
import org.moflon.tgg.runtime.AbstractCorrespondence;

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

	public void run() {
		MappingView mappingView = MappingView.getMappingView();
		selection.stream()
		.filter(e -> e instanceof AbstractCorrespondence).map(e -> {
			return (AbstractCorrespondence) e;
		}).forEach(e -> {
			Mapping mapping = (Mapping) ((EObject) e).eContainer();
			if(!mapping.getUserdefined().contains(e)) {
				mappingView.getMapper(mapping).accept(e);
			}
		});
		mappingView.update();
	}
}