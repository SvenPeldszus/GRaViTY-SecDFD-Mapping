package org.gravity.mapping.secdfd.helpers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;

public class FlowHelper {

	/**
	 * Checks which types can be communicated over this flow
	 * 
	 * @param flow The flow
	 * @return The communicated types
	 */
	public static Set<TAbstractType> getCommunicatedTypes(TFlow flow) {
		Set<TAbstractType> foundTypes = new HashSet<>();
		for (TAbstractFlowElement source : flow.getIncomingFlows()) {
			if (source instanceof TMethodSignature) {
				foundTypes.add(((TMethodSignature) source).getReturnType());
			} else if (source instanceof TMethodDefinition) {
				TMethodDefinition def = (TMethodDefinition) source;
				if (def.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()) {
					throw new IllegalStateException("Method definition has outgoing flow but is not a constructor!");
				}
				TAbstractType type = def.getDefinedBy();
				foundTypes.add(type);
			} else if (source instanceof TParameter) {
				TAbstractType type = ((TParameter) source).getType();
				foundTypes.add(type);
			} else if (source instanceof TFieldDefinition) {
				foundTypes.add(((TFieldDefinition) source).getSignature().getType());
			} else if (source instanceof TFieldSignature) {
				foundTypes.add(((TFieldSignature) source).getType());
			} else if (source instanceof TAccess) {
				// Skip
			} else {
				throw new IllegalStateException("Unkown source of flow: " + source.eClass().getName());
			}
		}
		for (TAbstractFlowElement target : flow.getOutgoingFlows()) {
			if (target instanceof TParameter) {
				foundTypes.add(((TParameter) target).getType());
			} else if (target instanceof TAccess || target instanceof TMethodDefinition) {
				// Skip
			} else if (target instanceof TFieldDefinition) {
				foundTypes.add(((TFieldDefinition) target).getSignature().getType());
			} else if (target instanceof TFieldSignature) {
				foundTypes.add(((TFieldSignature) target).getType());
			} else {
				throw new IllegalStateException("Unkown target of flow: " + target.eClass().getName());
			}
		}
		return foundTypes;
	}
	
	public static TMember getCausingMember(TFlow flow) {
		TAbstractFlowElement owner = flow.getFlowOwner();
		if (owner instanceof TMember) {
			return (TMember) owner;
		} else if (owner instanceof TAccess) {
			return (TMember) ((TAccess) owner).eContainer();
		}
		return null;
	}

	public static Set<TMember> getSourceMember(TFlow next) {
		Set<TMember> members = new HashSet<>();
		for (TAbstractFlowElement source : next.getIncomingFlows()) {
			if (source instanceof TMember) {
				members.add((TMember) source);
			} else if (source instanceof TParameter) {
				members.addAll(((TMethodSignature) ((TParameter) source).eContainer()).getDefinitions());
			} else if (source instanceof TFlow) {
				members.addAll(getSourceMember((TFlow) source));
			} else if (source instanceof TAccess) {
				members.addAll(((TAccess) source).getIncomingFlows().stream()
						.flatMap(in -> getSourceMember((TFlow) in).stream()).collect(Collectors.toSet()));
			} else if (source instanceof TSignature) {
				members.addAll(((TSignature) source).getDefinitions());
			}
		}
		return members;
	}

	public static Set<TMember> getTargetMember(TFlow next) {
		Set<TMember> members = new HashSet<>();
		for (TAbstractFlowElement target : next.getOutgoingFlows()) {
			if (target instanceof TMember) {
				members.add((TMember) target);
			} else if (target instanceof TParameter) {
				members.addAll(((TMethodSignature) ((TParameter) target).eContainer()).getDefinitions());
			} else if (target instanceof TFlow) {
				members.addAll(getTargetMember((TFlow) target));
			} else if (target instanceof TAccess) {
				members.addAll(((TAccess) target).getOutgoingFlows().stream()
						.flatMap(in -> getTargetMember((TFlow) in).stream()).collect(Collectors.toSet()));
			} else if (target instanceof TSignature) {
				members.addAll(((TSignature) target).getDefinitions());
			}
		}
		return members;
	}
}
