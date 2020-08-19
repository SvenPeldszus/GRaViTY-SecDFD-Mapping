/**
 * 
 */
package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.BasicFactory;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TConstructor;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;

import com.google.common.collect.Streams;

import org.secdfd.model.Asset;
import org.secdfd.model.EDFD;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
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
		Stream<TFlow> returnFlows = methods.stream()
				.flatMap(method -> method.getSignature().getOutgoingFlows().stream()).map(TFlow.class::cast);
		Set<TFlow> flows = Streams.concat(flowsOwnedByMethods, flowsOwnedByCallsOfMethods, returnFlows)
				.collect(Collectors.toSet());
		Set<TFlow> entries = getBorderFlows(flows, methods, false);
		Set<TFlow> exits = getBorderFlows(flows, methods, true);

		// TODO: Create Dummy flows for external entities?
		for (Flow flow : process.getInflows()) {
			if (flow.getSource() instanceof ExternalEntity) {
				for (Asset asset : flow.getAssets()) {
					for (TAbstractType assetType : mapper.getMapping(asset)) {
						entries.addAll(addDummyFlowIntoParameter(methods, assetType));
//						for (TMethodDefinition def : methods) {
//							for (TAccess access : def.getTAccessing()) {
//								TSignature member = access.getTTarget().getSignature();
//								if (member instanceof TMethodSignature
//										&& ((TMethodSignature) member).getReturnType().isSuperTypeOf(assetType)) {
//									for (TAbstractFlowElement potentialFlow : member.getOutgoingFlows()) {
//										if (potentialFlow.eContainer().equals(access)) {
//											entries.add((TFlow) potentialFlow);
//										}
//									}
//								}
//							}
//						}
					}
				}
			}
		}

		for (Flow flow : process.getOutflows()) {
			if (flow.getTarget().parallelStream().anyMatch(element -> element instanceof ExternalEntity)) {
				for (Asset asset : flow.getAssets()) {
					for (TAbstractType assetType : mapper.getMapping(asset)) {
						for (TMethodDefinition def : methods) {
							TAbstractType returnType;
							if (TConstructor.isConstructor(def)) {
								returnType = def.getDefinedBy();
							} else {
								returnType = def.getReturnType();
							}
							if (returnType.isSuperTypeOf(assetType)) {
								TFlow dummyFlow = createFlow(def.getSignature(), null, def.eResource());
								exits.add(dummyFlow);
							}
						}
					}
				}
			}
		}
		return new FlowEntryExit(entries, exits);
	}

	/**
	 * @param methods
	 * @param entries
	 * @param assetType
	 * @return
	 */
	private static Set<TFlow> addDummyFlowIntoParameter(Set<TMethodDefinition> methods, TAbstractType assetType) {
		Set<TFlow> entries = new HashSet<>();
		for (TMethodDefinition def : methods) {
			for (TParameter param : def.getSignature().getParameters()) {
				if (param.getType().isSuperTypeOf(assetType)) {
					TFlow dummyFlow = createFlow(null, param, param.eResource());
					entries.add(dummyFlow);
				}
			}
		}
		return entries;
	}

	private static TFlow createFlow(TAbstractFlowElement src, TAbstractFlowElement trg, Resource resource) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(resource);

		TFlow flow = BasicFactory.eINSTANCE.createTFlow();
		if (src != null) {
			if (domain != null) {
				CommandStack stack = domain.getCommandStack();
				stack.execute(AddCommand.create(domain, flow,
						BasicPackage.eINSTANCE.getTAbstractFlowElement_IncomingFlows(), src));
				stack.execute(AddCommand.create(domain, src,
						BasicPackage.eINSTANCE.getTAbstractFlowElement_OutgoingFlows(), flow));

			} else {
				flow.getIncomingFlows().add(src);
				src.getOutgoingFlows().add(flow);
			}
		}
		if (trg != null) {
			if (domain != null) {
				CommandStack stack = domain.getCommandStack();
				stack.execute(AddCommand.create(domain, trg,
						BasicPackage.eINSTANCE.getTAbstractFlowElement_IncomingFlows(), flow));
				stack.execute(AddCommand.create(domain, flow,
						BasicPackage.eINSTANCE.getTAbstractFlowElement_OutgoingFlows(), trg));

			} else {
				flow.getOutgoingFlows().add(trg);
				trg.getIncomingFlows().add(flow);
			}
		}
		return flow;
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
