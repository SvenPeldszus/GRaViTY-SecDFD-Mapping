package org.gravity.mapping.secdfd;

import java.util.*;

import org.gravity.mapping.secdfd.helpers.CallHelper;
import org.gravity.typegraph.basic.TMember;

public class PathSearch {
	
	private final TMember destination;

	private final NavigableSet<Step> pending = new TreeSet<>();

	public PathSearch(TMember source, TMember target) {
		this.destination = target;
		this.pending.add(new Step(source, null, 0));
	}

	public List<TMember> nextShortestPath() {
		Step current = this.pending.pollFirst();
		while (current != null) {
			if (current.getMember() == this.destination) {
				return current.generatePath();
			}
			for (TMember neighbor : CallHelper.getAllOutCalls(current.member)) {
				if (!current.seen(neighbor)) {
					final Step nextStep = new Step(neighbor, current, current.cost + 1);
					this.pending.add(nextStep);
				}
			}
			current = this.pending.pollFirst();
		}
		return null;
	}

	private static class Step {
		final TMember member;
		final Step parent;
		final int cost;

		public Step(TMember source, Step parent, int cost) {
			this.member = source;
			this.parent = parent;
			this.cost = cost;
		}

		public TMember getMember() {
			return member;
		}

		public boolean seen(TMember node) {
			if (this.member == node) {
				return true;
			}
			else if (parent == null) {
				return false;
			}
			else {
				return this.parent.seen(node);
			}
		}

		public List<TMember> generatePath() {
			final List<TMember> path;
			if (this.parent != null) {
				path = this.parent.generatePath();
			} else {
				path = new ArrayList<>();
			}
			path.add(this.member);
			return path;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Step step = (Step) o;
			return member == step.member && cost == step.cost && Objects.equals(parent, step.parent);
		}

		@Override
		public int hashCode() {
			return Objects.hash(member, parent, cost);
		}
	}
}
