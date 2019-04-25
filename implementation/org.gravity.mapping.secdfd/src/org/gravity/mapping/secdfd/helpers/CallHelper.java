package org.gravity.mapping.secdfd.helpers;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

public class CallHelper {

	public static Set<TMember> getAllOutCalls(TMember member) {
		Set<TMember> calledMembers = new HashSet<>();
		for(TAccess access : member.getTAccessing()) {
			TMember called = access.getTTarget();
			if (called instanceof TMethodDefinition) {
				TMethodDefinition method = (TMethodDefinition) called;
				while(method != null) {
					calledMembers.add(called);
					method = method.getOverriding();
				}
			}
			else {
				calledMembers.add(called);
			}
		}
		return calledMembers;
	}
	
	public static Set<TMember> getAllInCalls(TMember member) {
		Set<TMember> calledMembers = new HashSet<>();
		for(TAccess access : member.getAccessedBy()) {
			TMember calledBy = access.getTSource();
			if (calledBy instanceof TMethodDefinition) {
				Stack<TMethodDefinition> stack = new Stack<>();
				stack.add((TMethodDefinition) calledBy);
				while(!stack.isEmpty()) {
					TMethodDefinition method = stack.pop();
					calledMembers.add(method);
					stack.addAll(method.getOverriddenBy());
				}
			}
			else {
				calledMembers.add(calledBy);
			}
		}
		return calledMembers;
	}
}
