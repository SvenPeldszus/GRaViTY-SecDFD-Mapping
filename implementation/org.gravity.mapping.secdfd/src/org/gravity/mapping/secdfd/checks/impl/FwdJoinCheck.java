package org.gravity.mapping.secdfd.checks.impl;

import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.checks.impl.reveng.ImplementedDFD;
import org.gravity.mapping.secdfd.checks.impl.reveng.ImplementedFlow;
import org.gravity.mapping.secdfd.checks.impl.reveng.ImplementedFlowPattern;
import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;
import static org.secdfd.model.ResponsibilityType.*;

import java.util.ArrayList;
import java.util.Arrays;
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

public class FwdJoinCheck implements ICheck {

	@Override
	public Collection<SResult> check(Mapper mapper) {
		List<SResult> results = new ArrayList<>();
		for (Element element : mapper.getDFD().getElements()) {
			if (element instanceof Process) {
				results.add(check((Process) element, mapper));
			}
		}
		return results;
	}

	public SResult check(Process process, Mapper mapper) {
		Set<ImplementedFlowPattern> flows;
		try {
			flows = getImplementedFlowPatterns(process, mapper);
		} catch (IllegalStateException e) {
			return new SResult(PState.ERROR, FORWARD, process, mapper.getMapping(process), e.getMessage());
		}

		List<Responsibility> responsibilities = getFwdAndJoinResponsibilities(process);
		if (responsibilities.isEmpty()) {
			if (flows.isEmpty()) {
				return new SResult(PState.SUCCESS, FORWARD, process, mapper.getMapping(process),
						"No fwd or join contract to check");
			} else {
				StringBuilder description = new StringBuilder("No fwd or join contract specified but implemented:");
				for (ImplementedFlowPattern pattern : flows) {
					List<Asset> outgoingAssets = new ArrayList<>(pattern.getPossibleOutgoingAssets());
					List<Asset> incomingAssets = new ArrayList<>(pattern.getPossibleIncomingAssets());
					description.append('\n');
					description.append(PrintHelper.getStringRepresentation(incomingAssets,
							Arrays.asList(ResponsibilityType.FORWARD, ResponsibilityType.JOINER), outgoingAssets));
				}
				return new SResult(PState.ERROR, FORWARD, process, mapper.getMapping(process), description.toString());
			}
		}

		Map<Responsibility, Set<ImplementedFlowPattern>> mapping = new HashMap<>();
		for (Responsibility responsibility : responsibilities) {
			Set<ImplementedFlowPattern> flowPatternsWithOutgoingAssets = getFlowPatternsForOutgoingAssets(flows,
					responsibility);
			for (ImplementedFlowPattern pattern : flowPatternsWithOutgoingAssets) {
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
			if (responsibilities.stream()
					.noneMatch(res -> res.getAction().contains(ENCRYPT_OR_HASH) || res.getAction().contains(DECRYPT))) {
				return new SResult(PState.ERROR, JOINER, process, mapper.getMapping(process),
						responsibilities.stream().map(PrintHelper::getStringRepresentation).collect(Collectors
								.joining("; ", "The following FWD and JOIN contracts are not fulfilled: \"", "\".")));
			}

		}

		reduce(mapping);

		if (mapping.isEmpty()) {
			return new SResult(PState.SUCCESS, JOINER, process, mapper.getMapping(process),
					"All FWD and JOIN contracts have been found.");
		}
		return new SResult(PState.ERROR, JOINER, process, mapper.getMapping(process),
				mapping.keySet().stream().map(PrintHelper::getStringRepresentation).collect(
						Collectors.joining("; ", "The following FWD and JOIN contracts are not fulfilled: \"", "\".")));

	}

	/**
	 * @param flowPatterns
	 * @param responsibility
	 * @return
	 */
	private Set<ImplementedFlowPattern> getFlowPatternsForOutgoingAssets(Set<ImplementedFlowPattern> flowPatterns,
			Responsibility responsibility) {
		List<Flow> out = ((Process) responsibility.eContainer()).getOutflows();
		Set<ImplementedFlowPattern> matches = new HashSet<>();
		for (ImplementedFlowPattern pattern : flowPatterns) {
			Set<Asset> allOutgoingAssets = pattern.getPossibleOutgoingAssets();
			Set<Asset> noDummyAssets = getOnlyConcreteFlows(pattern);
			for (Asset asset : responsibility.getOutcomeassets()) {
				if (flowsToExternalEntity(out, asset)) {
					if (allOutgoingAssets.contains(asset)) {
						matches.add(pattern);
					}
				} else {
					if (noDummyAssets.contains(asset)) {
						matches.add(pattern);
					}
				}
			}

		}
		return matches;
	}

	/**
	 * @param pattern
	 * @return
	 */
	private Set<Asset> getOnlyConcreteFlows(ImplementedFlowPattern pattern) {
		return pattern.allOutgoingFlows().parallelStream()
				.filter(f -> !f.getTarget().getName().startsWith("ExternalDummy")) // TODO: Also DummyDBs?
				.flatMap(f -> f.getPossibleAssets().parallelStream()).collect(Collectors.toSet());
	}

	/**
	 * @param flows
	 * @param asset
	 * @return
	 */
	private boolean flowsToExternalEntity(List<Flow> flows, Asset asset) {
		return flows.parallelStream().filter(f -> f.getAssets().contains(asset)).flatMap(f -> f.getTarget().stream())
				.anyMatch(e -> e instanceof ExternalEntity);
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
		Set<ImplementedFlow> concreteFlows = new HashSet<>();
		for (Asset incomingAsset : responsibility.getIncomeassets()) {
			Set<ImplementedFlow> possibleIncomingFlows = pattern.getPossibleIncomingFlows(incomingAsset);
			if (possibleIncomingFlows.isEmpty()) {
				throw new IllegalStateException("No flow found for asset -> pattern doesn't fit");
			} else {
				possibleIncomingFlowsForAssets.put(incomingAsset, possibleIncomingFlows);
				for (ImplementedFlow in : possibleIncomingFlows) {
					if (!in.getSource().getName().startsWith("ExternalDummy")) {
						concreteFlows.add(in);
					}
				}
			}
		}
		Set<ImplementedFlow> allAssignedFlows = possibleIncomingFlowsForAssets.values().stream()
				.flatMap(Collection::stream).collect(Collectors.toSet());
		if (!allAssignedFlows.containsAll(concreteFlows)) {
			throw new IllegalStateException("Not all concrete flows are part of the contract");
		}

		// TODO: Don't consider flow patterns with too many incoming flows
//		ArrayList<ImplementedFlow> flows = new ArrayList<>(pattern.allIncomingFlows());
//		flows.removeAll(matchedFlows);
//		if (!flows.isEmpty()) {
//			for(int i = flows.size() - 1 ; i >= 0; i--) {
//				ImplementedFlow flow = flows.get(i);
//			}
//			throw new IllegalStateException("There are unmatched flows!");
//		}
		return possibleIncomingFlowsForAssets;
	}

	/**
	 * @param process
	 * @param dfd
	 * @return
	 */
	private Set<ImplementedFlowPattern> getImplementedFlowPatterns(Process process, Mapper mapper) {
		ImplementedDFD dfd = new ImplementedDFD(process, mapper);
		EDFD edfd = ((EDFD) process.eContainer());
		Set<ImplementedFlowPattern> flows = new HashSet<>();
		for (ImplementedFlow flow : dfd.getImplementedProcess().getOutgoingFlows()) {
			Set<ImplementedFlow> sources = flow.getInternalSources();
			if (sources.isEmpty()) {
				continue;
			}
			if (flow.getTarget().getUnderlyingProcess().eContainer() == edfd
					|| sources.stream().anyMatch(src -> src.getSource().getUnderlyingProcess().eContainer() == edfd))
				flows.add(new ImplementedFlowPattern(sources, Collections.singleton(flow)));
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
			return actions.contains(JOINER) || actions.contains(FORWARD) || actions.contains(ENCRYPT_OR_HASH)
					|| actions.contains(DECRYPT);
		}).collect(Collectors.toList());
	}
}
