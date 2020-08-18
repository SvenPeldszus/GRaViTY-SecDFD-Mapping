package org.gravity.mapping.secdfd.checks.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;
import org.apache.log4j.Logger;
import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TCall;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TModifier;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TVisibility;

public class StructuralDivergenceCheck implements ICheck {

	private static final Logger LOGGER = Logger.getLogger(StructuralDivergenceCheck.class);

	private Mapper mapper;

	public Collection<SResult> check(Mapper mapper) {
		this.mapper = mapper;
		List<Process> processes = mapper.getDFD().getElements().parallelStream()
				.filter(element -> (element instanceof Process)).map(element -> (Process) element)
				.collect(Collectors.toList());
		

		Collection<SResult> results = new LinkedList<>();
		for (Process process : processes) {
			results.addAll(checkOutgoingFlows(process));
		}
		return results;
	}

	/**
	 * Checks if illegal outgoing flows have been implemented
	 * 
	 * @param process The process to check
	 * @return 
	 */
	private Collection<? extends SResult> checkOutgoingFlows(Process process) {
		Collection<SResult> results = new LinkedList<>();
		Set<TMethodDefinition> methodsImplementingProcess = mapper.getMapping(process);
		for (Asset asset : process.getAssets()) {
			Collection<TAbstractType> typesImplementingAsset = mapper.getMapping(asset);
			Collection<Element> allowedFlowTargets = getAllowedFlowTargets(asset, process);
			boolean flowsToExternal = allowedFlowTargets.parallelStream().anyMatch(ExternalEntity.class::isInstance);
			for (TMethodDefinition method : methodsImplementingProcess) {
				results.addAll(checkReturnFlow(process, method, asset, typesImplementingAsset, allowedFlowTargets, flowsToExternal));
				results.addAll(checkCallFlow(process, method, allowedFlowTargets, typesImplementingAsset));

			}
		}
		return results;
	}

	/**
	 * @param process
	 * @param method
	 * @param allowedFlowTargets
	 * @param typesImplementingAsset
	 * @return 
	 */
	private Collection<? extends SResult> checkCallFlow(Process process, TMethodDefinition method, Collection<Element> allowedFlowTargets,
			Collection<TAbstractType> typesImplementingAsset) {
		Collection<SResult> results = new LinkedList<>();
		for (TAccess access : method.getTAccessing()) {
			if (access instanceof TCall) {
				TSignature target = access.getTTarget().getSignature();
				boolean relevant;
				if (target instanceof TMethodSignature) {
					relevant = ((TMethodSignature) target).getParameters().parallelStream().map(TParameter::getType)
							.anyMatch(typesImplementingAsset::contains);
				} else if (target instanceof TFieldSignature) {
					relevant = typesImplementingAsset.contains(((TFieldSignature) target).getType());
				} else {
					throw new IllegalStateException();
				}
				if (relevant) {
					Set<Element> targetProcesses = mapper.getMapping((TMethodDefinition) access.getTTarget());
//					if (!targetProcesses.isEmpty() && !targetProcesses.contains(process)
//							&& !allowedFlowTargets.contains(targetProcess)) {
//						LOGGER.error("The asset flow from \"" + process.getName() + "\" to \""
//								+ targetProcess.getName() + "\" is not specified in the DFD!");
//					}
				}
			}
		}
		return results;
	}

	/**
	 * @param process
	 * @param method
	 * @param asset
	 * @param typesImplementingAsset
	 * @param allowedFlowTargets
	 * @param flowsToExternal
	 * @return 
	 */
	private Collection<SResult> checkReturnFlow(Process process, TMethodDefinition method, Asset asset,
			Collection<TAbstractType> typesImplementingAsset, Collection<Element> allowedFlowTargets,
			boolean flowsToExternal) {
		Collection<SResult> results = new LinkedList<>();
		TAbstractType returnType = method.getSignature().getReturnType();
		if (typesImplementingAsset.contains(returnType)) {
			if (!(method.getDefinedBy() instanceof TInterface)) {
				TModifier tModifier = method.getTModifier();
				boolean isPublic = tModifier == null || TVisibility.TPUBLIC.equals(tModifier.getTVisibility());
				if (isPublic && !flowsToExternal) {
					String warning = "Public method is returning the asset \"" + asset.getName() + "\": "
							+ method.getSignatureString();
					results.add(new SResult(PState.WARNING, null, process, Collections.singleton(method), warning));
					LOGGER.warn(warning);
				}
			}
			for (TAbstractFlowElement flow : method.getSignature().getOutgoingFlows()) {
				Set<Element> targets = flow.getOutgoingFlows().parallelStream().flatMap(trg -> {
					if (trg instanceof TFlow) {
						return trg.getOutgoingFlows().stream();
					}
					if (trg instanceof TAccess) {
						return Stream.of(((TAccess) trg).getTSource());
					}
					return Stream.of(trg);
				}).flatMap(trg -> mapper.getMapping((TMethodDefinition) trg).stream()).filter(trg -> trg != process)
						.collect(Collectors.toSet());
				if (!allowedFlowTargets.containsAll(targets)) {
					LOGGER.error(targets.stream().filter(t -> !allowedFlowTargets.contains(t)).map(Element::getName)
							.collect(Collectors.joining("\", \"", "Flow from \"" + process.getName() + "\" to \"",
									"\" not specified in DFD!")));
				}
			}
		}
		return results;
	}

	private static Set<Element> getAllowedFlowTargets(final Asset asset, final Process source) {
		return source.getOutflows().parallelStream().filter(flow -> flow.getAssets().contains(asset))
				.map(Flow::getTarget).flatMap(Collection::parallelStream).collect(Collectors.toSet());
	}

}
