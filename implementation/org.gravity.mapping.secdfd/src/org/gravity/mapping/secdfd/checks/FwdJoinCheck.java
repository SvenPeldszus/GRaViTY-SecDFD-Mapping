package org.gravity.mapping.secdfd.checks;

import org.gravity.mapping.secdfd.checks.implemented.ImplementedDFD;
import org.gravity.mapping.secdfd.checks.implemented.ImplementedFlow;
import org.gravity.mapping.secdfd.checks.implemented.ImplementedFlowPattern;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;
import static org.secdfd.model.ResponsibilityType.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FwdJoinCheck {

	private final Mapper mapper;

	public FwdJoinCheck(Mapper mapper) {
		this.mapper = mapper;
	}

	public SResult check(Process process) {
		Set<ImplementedFlowPattern> flows;
		try {
			flows = getImplementedFlowPatterns(process);
		} catch (IllegalStateException e) {
			return new SResult(PState.ERROR, FORWARD, process, mapper.getMapping(process), e.getMessage());
		}

		List<Responsibility> responsibilities = getFwdAndJoinResponsibilities(process);
		if (responsibilities.isEmpty()) {
			if (flows.isEmpty()) {
				return new SResult(PState.SUCCESS, FORWARD, process, mapper.getMapping(process),
						"No fwd or join contract to check");
			} else {
				return new SResult(PState.ERROR, FORWARD, process, mapper.getMapping(process),
						"No fwd or join contract specified but implemented");
			}
		}

		Map<Responsibility, Set<ImplementedFlowPattern>> mapping = new HashMap<>();
		for (Responsibility responsibility : responsibilities) {
			Asset outgoingAsset = responsibility.getOutcomeassets().get(0);
			Set<ImplementedFlowPattern> possible = flows.parallelStream()
					.filter(flow -> flow.getPossibleOutgoingAssets().contains(outgoingAsset))
					.collect(Collectors.toSet());
			for (ImplementedFlowPattern pattern : possible) {
				Map<Asset, Set<ImplementedFlow>> possibleFlows;
				try {
					possibleFlows = getPossibleIncomingFlows(responsibility, pattern);
				} catch (IllegalStateException e) {
					continue;
				}
				reduce(possibleFlows);
				if (possibleFlows.isEmpty()) {
					mapping.computeIfAbsent(responsibility, x -> new HashSet<>()).add(pattern);
				}
			}

		}
		if (!mapping.keySet().containsAll(responsibilities)) {
			responsibilities.removeAll(mapping.keySet());
			return new SResult(PState.ERROR, JOINER, process, mapper.getMapping(process),
					responsibilities.stream().map(r -> r.toString())
							.collect(Collectors.joining(", ", "The following contracts are not fulfilled: \"", "\".")));
		}

		reduce(mapping);

		if (mapping.isEmpty()) {
			return new SResult(PState.SUCCESS, JOINER, process, mapper.getMapping(process),
					"All FWD and JOIN contracts have been found.");
		}
		return null;

	}

	/**
	 * @param possibleFlows
	 * @return
	 */
	private <K, V> boolean reduce(Map<K, Set<V>> possibleFlows) {
		removeAllUniqueEntries(possibleFlows);

		if (!reduceFromElementWithOneValue(possibleFlows)) {
			return false;
		}

		while (!possibleFlows.isEmpty()) {
			Entry<K, Set<V>> next = possibleFlows.entrySet().iterator().next();
			if (new ArrayList<>(next.getValue()).stream().noneMatch(toCheck -> {
				next.setValue(Collections.singleton(toCheck));
				return reduceFromElementWithOneValue(possibleFlows);
			})) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param <V>
	 * @param <K>
	 * @param possibleFlows
	 * @return true, if all elements with only one value could be reduced without
	 *         conflicts
	 */
	private <V, K> boolean reduceFromElementWithOneValue(Map<K, Set<V>> possibleFlows) {
		Optional<Entry<K, Set<V>>> next;
		while ((next = possibleFlows.entrySet().parallelStream().filter(entry -> entry.getValue().size() == 1)
				.findAny()).isPresent()) {
			Entry<K, Set<V>> assetWithOnePossibleFlow = next.get();
			possibleFlows.remove(assetWithOnePossibleFlow.getKey());
			V onlyPossibleFlow = assetWithOnePossibleFlow.getValue().iterator().next();

			Optional<Entry<K, Set<V>>> unmapableAsset = possibleFlows.entrySet().stream().filter(entry -> {
				Set<V> possibleFlowsForEntry = entry.getValue();
				possibleFlowsForEntry.remove(onlyPossibleFlow);
				return possibleFlowsForEntry.isEmpty();
			}).findAny();
			if (unmapableAsset.isPresent()) {
				return false;
			}
		}
		return true;
	}

	private <K, V> void removeAllUniqueEntries(Map<K, Set<V>> possibleFlows) {
		List<Entry<K, Set<V>>> onlyOneFlow = possibleFlows.entrySet().parallelStream()
				.filter(entry -> entry.getValue().size() == 1).collect(Collectors.toList());
		for (Entry<K, Set<V>> entry : onlyOneFlow) {
			K key = entry.getKey();
			V flow = entry.getValue().iterator().next();
			if (possibleFlows.entrySet().parallelStream()
					.noneMatch(other -> !key.equals(other.getKey()) && other.getValue().contains(flow))) {
				possibleFlows.remove(key);
			}
		}
	}

	/**
	 * @param responsibility
	 * @param pattern
	 * @return
	 */
	private Map<Asset, Set<ImplementedFlow>> getPossibleIncomingFlows(Responsibility responsibility,
			ImplementedFlowPattern pattern) {
		Map<Asset, Set<ImplementedFlow>> possibleIncomingFlowsForAssets = new HashMap<>();
		Set<ImplementedFlow> matchedFlows = new HashSet<>();
		for (Asset incomingAsset : responsibility.getIncomeassets()) {
			Set<ImplementedFlow> possibleIncomingFlows = pattern.getPossibleIncomingFlows(incomingAsset);
			if (possibleIncomingFlows.isEmpty()) {
				throw new IllegalStateException("No flow found for asset -> pattern doesn't fit");
			} else {
				matchedFlows.addAll(possibleIncomingFlows);
				possibleIncomingFlowsForAssets.put(incomingAsset, possibleIncomingFlows);
			}
		}
		if (!matchedFlows.containsAll(pattern.allIncomingFlows())) {
			throw new IllegalStateException("There are unmatched flows!");
		}
		return possibleIncomingFlowsForAssets;
	}

	/**
	 * @param process
	 * @param dfd
	 * @return
	 */
	private Set<ImplementedFlowPattern> getImplementedFlowPatterns(Process process) {
		ImplementedDFD dfd = ImplementedDFD.create(process, mapper);
		Set<ImplementedFlowPattern> flows = new HashSet<>();
		for (ImplementedFlow flow : dfd.getImplementedProcess().getOutgoingFlows()) {
			Set<ImplementedFlow> sources = flow.getInternalSources();
			if (sources.isEmpty()) {
				continue;
			}
			for (ImplementedFlow source : sources) {
				if (source.getInternalTargets().size() != 1) {
					throw new IllegalStateException("There is a splitting flow!");
				}
			}
			flows.add(new ImplementedFlowPattern(sources, flow));
		}
		return flows;
	}

	/**
	 * Searches all FWD and JOIN responsibilities of the process
	 * 
	 * @param process The process for which the responsibilities should be retrieved
	 * @return The responsibilities
	 */
	private List<Responsibility> getFwdAndJoinResponsibilities(Process process) {
		return process.getResponsibility().stream().filter(responsibility -> {
			Collection<ResponsibilityType> actions = responsibility.getAction();
			return actions.contains(JOINER) || actions.contains(FORWARD);
		}).collect(Collectors.toList());
	}
}
