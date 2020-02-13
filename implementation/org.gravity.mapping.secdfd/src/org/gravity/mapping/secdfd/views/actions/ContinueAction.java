package org.gravity.mapping.secdfd.views.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.views.IListener;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.mapping.Mapper;

import eDFDFlowTracking.EDFD;

public final class ContinueAction extends Action implements IListener {

	/**
	 * The mapping view
	 */
	private final MappingView mappingView;

	private final Map<Mapping, Collection<AbstractCorrespondence>> userdefined;
	private final Set<Mapping> waiting;

	public ContinueAction(MappingView mappingView) {
		super("Continue");
		this.mappingView = mappingView;
		this.userdefined = mappingView.getMappings().parallelStream()
				.collect(Collectors.toMap(mapping -> mapping, mapping -> new ArrayList<>(mapping.getUserdefined())));
		this.waiting = new HashSet<>();
	}

	public void run() {
		for (Mapping mapping : this.mappingView.getMappings()) {
			if (!userdefined.containsKey(mapping)) {
				userdefined.put(mapping, new HashSet<>(mapping.getUserdefined()));
			}
//			if(userdefined.get(mapping).containsAll(mapping.getUserdefined())) {
//				waiting.add(mapping);
//				JOptionPane.showMessageDialog(null, "Please map an element from the DFD \""+((EDFD) mapping.getTarget()).getName()+"\" manually.\nThe automated mapping will continue afterwards.");
//			} else {
				continueAutomatedMapping(mapping);
//			}
		}
	}

	/**
	 * Continues the automated detection for the given mapping
	 * 
	 * @param mapping The mapping
	 */
	private void continueAutomatedMapping(Mapping mapping) {
		Mapper mapper = this.mappingView.getMapper(mapping);
		int before = mapping.getCorrespondences().size();
		mapper.optimize();
		if (before <= mapping.getCorrespondences().size()) {
			mapper.addRandom();
		}
		this.mappingView.update();
		this.waiting.remove(mapping);
	}

	@Override
	public void notify(Collection<AbstractCorrespondence> added) {
//		for(Mapping mapping : added.parallelStream().map(corr -> (Mapping) corr.eContainer()).filter(mapping -> waiting.contains(mapping)).collect(Collectors.toSet())){
//			continueAutomatedMapping(mapping);
//			userdefined.get(mapping).addAll(mapping.getUserdefined());
//		}
	}
}