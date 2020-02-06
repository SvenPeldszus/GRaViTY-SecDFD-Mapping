package org.gravity.mapping.secdfd.views.actions;

import java.util.List;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.mapping.secdfd.AbstractCorrespondence;

public final class RejectAction extends Action {
	/**
	 * 
	 */
	private final List<?> selection;
	
	public RejectAction(List<?> selection) {
		this.selection = selection;
	}

	@Override
	public String getText() {
		return "reject";
	}

	@Override
	public String getToolTipText() {
		return "Rejects this mapping";
	}

	@Override
	public void run() {
		Stream<?> stream = selection.stream();
		stream.filter(e -> e instanceof AbstractCorrespondence)
		.forEach(e -> {
			Mapping mapping = (Mapping) ((EObject) e).eContainer();
			MappingView mappingView = MappingView.getMappingView();
			mappingView.getMapper(mapping).reject((AbstractCorrespondence) e);
//			mappingView.getTree().remove(e);
			mappingView.update();
		});
	}
}