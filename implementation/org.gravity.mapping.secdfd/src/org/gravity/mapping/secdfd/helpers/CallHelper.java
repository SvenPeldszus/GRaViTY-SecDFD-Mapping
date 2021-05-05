package org.gravity.mapping.secdfd.helpers;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;

public class CallHelper {

	public static Set<TMember> getAllOutCalls(final TMember member) {
		final Set<TMember> calledMembers = new HashSet<>();
		for (final TAccess access : member.getAccessing()) {
			final TMember called = access.getTarget();
			if (called instanceof TMethodDefinition) {
				final Deque<TMethodDefinition> stack = new LinkedList<>();
				stack.add((TMethodDefinition) called);
				while (!stack.isEmpty()) {
					final TMethodDefinition method = stack.pop();
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

	public static Set<TMember> getAllInCalls(final TMember member) {
		final Set<TMember> calledMembers = new HashSet<>();
		for (final TAccess access : member.getAccessedBy()) {
			final TMember calledBy = access.getSource();
			if (calledBy instanceof TMethodDefinition) {
				final Deque<TMethodDefinition> stack = new LinkedList<>();
				stack.add((TMethodDefinition) calledBy);
				while (!stack.isEmpty()) {
					final TMethodDefinition method = stack.pop();
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
