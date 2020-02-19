package org.gravity.mapping.secdfd.views.actions;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.views.MappingView;

public final class AcceptAllAction extends Action {
	private final MappingView mappingView;

	public AcceptAllAction(MappingView mappingView) {
		super("Accept all");
		this.mappingView = mappingView;
	}

	public void run() {
		for (Mapper mapper : mappingView.getMappers().values()) {
			Mapping mapping = mapper.getMapping();
			new ArrayList<>(mapping.getSuggested()).forEach(mapper::accept);
			mappingView.update();
		}
	}
}