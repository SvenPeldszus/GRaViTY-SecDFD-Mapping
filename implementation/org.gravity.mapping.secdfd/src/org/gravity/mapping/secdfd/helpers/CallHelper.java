package org.gravity.mapping.secdfd.helpers;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

public class CallHelper {

	public static Set<TMember> getAllOutCalls(TMember member) {
		Set<TMember> calledMembers = new HashSet<>();
		for (TAccess access : member.getTAccessing()) {
			TMember called = access.getTTarget();
			if (called instanceof TMethodDefinition) {
				Deque<TMethodDefinition> stack = new LinkedList<>();
				stack.add((TMethodDefinition) called);
				while (!stack.isEmpty()) {
					TMethodDefinition method = stack.pop();
					if (!calledMembers.contains(method)) {
						calledMembers.add(method);
						stack.addAll(method.getOverriddenBy());
					}
				}
			} else {
				calledMembers.add(called);
			}
		}
		return calledMembers;
	}

	public static Set<TMember> getAllInCalls(TMember member) {
		Set<TMember> calledMembers = new HashSet<>();
		for (TAccess access : member.getAccessedBy()) {
			TMember calledBy = access.getTSource();
			if (calledBy instanceof TMethodDefinition) {
				Deque<TMethodDefinition> stack = new LinkedList<>();
				stack.add((TMethodDefinition) calledBy);
				while (!stack.isEmpty()) {
					TMethodDefinition method = stack.pop();
					calledMembers.add(method);
					stack.addAll(method.getOverriddenBy());
				}
			} else {
				calledMembers.add(calledBy);
			}
		}
		return calledMembers;
	}
}
