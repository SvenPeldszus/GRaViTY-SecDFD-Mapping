/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;

import com.google.common.collect.Streams;

import org.secdfd.model.EDFD;
import org.secdfd.model.Process;

/**
 * 
 * A class preparing the entry and exit points for each process
 * 
 * @author katjat, speldszus
 *
 */
public class FlowEntryExit {

	private final Set<TFlow> entries;
	private final Set<TFlow> exits;

	public FlowEntryExit(Set<TFlow> entries, Set<TFlow> exits) {
		this.entries = entries;
		this.exits = exits;
	}

	public static Map<Process, FlowEntryExit> getEntriesExits(Collection<Mapper> mappers) {
		Map<Process, FlowEntryExit> values = new HashMap<>();
		for (Mapper mapper : mappers) {
			EDFD dfd = mapper.getDFD();
			Set<Process> processes = dfd.getElements().parallelStream().filter(Process.class::isInstance)
					.map(c -> (Process) c).collect(Collectors.toSet());

			for (Process process : processes) {
				values.put(process, getEntriesExits(mapper, process));
			}
		}
		return values;
	}

	/**
	 * Calculates the entries and exits of the process
	 * 
	 * @param mapper  The mapper used to create a mapping for the process
	 * @param process The process whose entry and exit flows are needed
	 */
	public static FlowEntryExit getEntriesExits(Mapper mapper, Process process) {
		Set<TMethodDefinition> methods = mapper.getMapping(process);
		// only search if flow part of process
		Stream<TFlow> flowsOwnedByMethods = methods.stream().flatMap(meth -> meth.getOwnedFlows().stream());
		Stream<TFlow> flowsOwnedByCallsOfMethods = methods.stream().flatMap(m -> m.getTAccessing().stream())
				.flatMap(a -> a.getOwnedFlows().stream());
		Stream<TFlow> returnFlows = methods.stream().flatMap(method -> method.getSignature().getOutgoingFlows().stream()).map(TFlow.class::cast);
		Set<TFlow> flows = Streams.concat(flowsOwnedByMethods, flowsOwnedByCallsOfMethods, returnFlows).collect(Collectors.toSet());
		Set<TFlow> entries = getBorderFlows(flows, methods, false);
		Set<TFlow> exits = getBorderFlows(flows, methods, true);
		return new FlowEntryExit(entries, exits);
	}

	/**
	 * Searches all flows entering or leaving a process
	 * 
	 * @param flows   The flows owned by the methods mapped to the process
	 * @param methods The methods mapped to the process
	 * @return The flows
	 */
	private static Set<TFlow> getBorderFlows(Set<TFlow> flows, Set<TMethodDefinition> methods, boolean fwd) {
		Set<TFlow> exits = new HashSet<>();
		Deque<TAbstractFlowElement> stack = new LinkedList<>();
		stack.addAll(flows);
		Set<TAbstractFlowElement> seen = new HashSet<>();
		while (!stack.isEmpty()) {
			TAbstractFlowElement next = stack.pop();
			if (seen.add(next)) {
				if (!belongsToProcess(next, methods, fwd)) {
					exits.add((TFlow) next);
				} else if (fwd) {
					stack.addAll(next.getOutgoingFlows());
				} else {
					stack.addAll(next.getIncomingFlows());
				}
			}
		}
		return exits;
	}

	private static boolean belongsToProcess(TAbstractFlowElement element, Set<? extends TMember> members, boolean fwd) {
		if (element instanceof TMember) {
			return members.contains(element);
		} else if (element instanceof TAccess) {
			return members.contains(((TAccess) element).eContainer());

		} else if (element instanceof TSignature) {
			for (TMember member : ((TSignature) element).getDefinitions()) {
				if (members.contains(member)) {
					return true;
				}
			}
			return false;
		} else if (element instanceof TParameter) {
			return belongsToProcess((TMethodSignature) ((TParameter) element).eContainer(), members, fwd);
		} else if (element instanceof TFlow) {
			TFlow flow = (TFlow) element;
			if (fwd) {
				return flow.getOutgoingFlows().stream().allMatch(trg -> belongsToProcess(trg, members, fwd));
			} else {
				return flow.getIncomingFlows().stream().allMatch(src -> belongsToProcess(src, members, fwd));
			}
		}
		return true;
	}

	/**
	 * @return the entries
	 */
	public Set<TFlow> getEntries() {
		return entries;
	}

	/**
	 * @return the exits
	 */
	public Set<TFlow> getExits() {
		return exits;
	}

}
