/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMethodDefinition;

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
	
	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(EncryptionCheck.class);
	
	Set<EObject> entries;
	Set<EObject> exits;
	
	/**
	 * The correspondence model
	 */
	private Collection<Mapper> mappers;

		
	public FlowEntryExit(Collection<Mapper> mappers) {
		this.mappers = mappers;
		entries = new HashSet<>();
		exits = new HashSet<>();
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
				Set<TFlow> flows = methods.stream().flatMap(meth -> meth.getOwnedFlows().stream())
						 .collect(Collectors.toSet());
				for (TFlow flow : flows) {
					//get entries
					EList<TAbstractFlowElement> sources = flow.getIncomingFlows();
					for (TAbstractFlowElement afe : sources) {
						findEntriesExitsRec(Direction.BKW, methods, afe);
					}
					//get exits
					EList<TAbstractFlowElement> targets = flow.getOutgoingFlows();
					for (TAbstractFlowElement afe : targets) {
						findEntriesExitsRec(Direction.FWD, methods, afe);		
					}					
				}
			}
		}
	}

	public void findEntriesExitsRec(Direction dir, Set<TMethodDefinition> methods, TAbstractFlowElement afe){
		//if mapped to another DFD element
		if (!methods.contains(afe)) {
			//we exited the current process - this is the entry/exits of flow
			if (dir.equals(Direction.BKW)) {
				entries.add(afe);
			}else{
				exits.add(afe);
			}
			return;
		} else {
			if (afe instanceof TMethodDefinition) {
				findEntriesExitsRec(dir, methods, ((TMethodDefinition) afe).getSignature());
			} else {
				if (dir.equals(Direction.BKW)) {
					//step back
					for (TAbstractFlowElement backwards : afe.getIncomingFlows()) {
						findEntriesExitsRec(dir, methods, backwards);
					}
				}else {
					//step fwd
					for (TAbstractFlowElement forwards : afe.getOutgoingFlows()) {
						findEntriesExitsRec(dir, methods, forwards);
					}
				}
			}
		}		
	}	
}
