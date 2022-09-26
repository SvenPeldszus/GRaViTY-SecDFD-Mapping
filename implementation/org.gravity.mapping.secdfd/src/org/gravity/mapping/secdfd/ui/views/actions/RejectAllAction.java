package org.gravity.mapping.secdfd.ui.views.actions;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.views.MappingView;

public final class RejectAllAction extends Action {
	private final MappingView mappingView;

	public RejectAllAction(MappingView mappingView) {
		super("Reject all");
		this.mappingView = mappingView;
	}

	@Override
	public void run() {
		for (Mapper mapper : mappingView.getMappers().values()) {
			Mapping mapping = mapper.getMapping();
			new ArrayList<>(mapping.getSuggested()).forEach(mapper::reject);
			mappingView.update();
		}
	}
}