/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

import com.google.common.collect.Streams;

import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Process;

/**
 * 
 * A class preparing the entry and exit points for each (flow,process) pair 
 * 
 * @author katjat
 *
 */
public class FlowEntryExit {
	public static enum Direction {
		FWD, BKW;
	}

	Set<TFlow> entries;
	Set<TFlow> exits;
	
	/**
	 * The correspondence model
	 */
	private Collection<Mapper> mappers;

		
	public FlowEntryExit(Collection<Mapper> mappers) {
		this.mappers = mappers;
		entries = new HashSet<>();
		exits = new HashSet<>();
		getEntriesExits();
	}
	
	public void getEntriesExits() {
		for (Mapper mapper : mappers) {
			EDFD dfd = (EDFD) mapper.getDFD();
			Set<Process> processes = dfd.getElements().parallelStream().filter(Process.class::isInstance)
					.map(c -> (Process) c)
					.collect(Collectors.toSet());
			
			for (Process process : processes) {
				Set<TMethodDefinition> methods = mapper.getMapping(process);				
				//only search if flow part of process
				Set<TFlow> flows = Streams.concat(methods.stream().flatMap(meth -> meth.getOwnedFlows().stream())
						, methods.stream().flatMap(m -> m.getTAccessing().stream()).flatMap(a -> a.getOwnedFlows().stream()))
						.collect(Collectors.toSet());
				
				for (TFlow flow : flows) {
					//get entries
					EList<TAbstractFlowElement> sources = flow.getIncomingFlows();
					for (TAbstractFlowElement afe : sources) {
						if (!belongsToProcess(afe, methods)) {
							entries.add(flow);
						}
					}
					//get exits
					EList<TAbstractFlowElement> targets = flow.getOutgoingFlows();
					for (TAbstractFlowElement afe : targets) {
						if (!belongsToProcess(afe, methods)) {
							exits.add(flow);
						}		
					}					
				}
			}
		}
	}

	private boolean belongsToProcess(TAbstractFlowElement afe, Set<? extends TMember> members) {
		EObject parent = afe.eContainer();
		while(parent != null && !(parent instanceof TMember)) {
			parent = parent.eContainer();
		}
		return members.contains(parent);
	}

}
