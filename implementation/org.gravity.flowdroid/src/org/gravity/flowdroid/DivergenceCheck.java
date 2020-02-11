package org.gravity.flowdroid;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.ExternalEntity;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.Process;

import org.apache.log4j.Logger;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TCall;
import org.gravity.typegraph.basic.TFieldSignature;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TVisibility;

public class DivergenceCheck {

	private static final Logger LOGGER = Logger.getLogger(DivergenceCheck.class);

	List<String> warnings;
	List<String> errors;

	private Mapper mapper;

	public void check(Mapper mapper) {
		this.warnings = new LinkedList<>();
		this.errors = new LinkedList<>();
		this.mapper = mapper;
		List<Process> processes = mapper.getDFD().getElements().parallelStream()
				.filter(element -> (element instanceof Process)).map(element -> (Process) element)
				.collect(Collectors.toList());
		for (Process process : processes) {
			checkOutgoingFlows(process);
		}
	}

	/**
	 * Checks if illegal outgoing flows have been implemented
	 * 
	 * @param process The process to check
	 */
	private void checkOutgoingFlows(Process process) {
		Set<TMethodDefinition> methodsImplementingProcess = mapper.getMapping(process);
		for (Asset asset : process.getAssets()) {
			Collection<TAbstractType> typesImplementingAsset = mapper.getMapping(asset);
			Collection<Element> allowedFlowTargets = getAllowedFlowTargets(asset, process);
			boolean flowsToExternal = allowedFlowTargets.parallelStream().anyMatch(ExternalEntity.class::isInstance);
			for (TMethodDefinition method : methodsImplementingProcess) {
				checkReturnFlow(process, method, asset, typesImplementingAsset, allowedFlowTargets, flowsToExternal);
				checkCallFlow(process, method, allowedFlowTargets, typesImplementingAsset);

				
			}
		}
	}

	/**
	 * @param process
	 * @param method
	 * @param allowedFlowTargets
	 * @param typesImplementingAsset
	 */
	private void checkCallFlow(Process process, TMethodDefinition method, Collection<Element> allowedFlowTargets,
			Collection<TAbstractType> typesImplementingAsset) {
		for (TAccess access : method.getTAccessing()) {
			if (access instanceof TCall) {
				TSignature target = access.getTTarget().getSignature();
				boolean relevant;
				if (target instanceof TMethodSignature) {
					relevant = ((TMethodSignature) target).getParameters().parallelStream()
							.map(TParameter::getType)
							.anyMatch(typesImplementingAsset::contains);
				} else if (target instanceof TFieldSignature) {
					relevant = typesImplementingAsset.contains(((TFieldSignature) target).getType());
				} else {
					throw new IllegalStateException();
				}
				if (relevant) {
					Process targetProcess = mapper.getMapping((TMethodDefinition) access.getTTarget());
					if (targetProcess != null && targetProcess != process
							&& !allowedFlowTargets.contains(targetProcess)) {
						LOGGER.error("The asset flow from \"" + process.getName() + "\" to \""
								+ targetProcess.getName() + "\" is not specified in the DFD!");
					}
				}
			}
		}
	}

	/**
	 * @param process
	 * @param method
	 * @param asset
	 * @param typesImplementingAsset
	 * @param allowedFlowTargets
	 * @param flowsToExternal
	 */
	private void checkReturnFlow(Process process, TMethodDefinition method, Asset asset,
			Collection<TAbstractType> typesImplementingAsset, Collection<Element> allowedFlowTargets,
			boolean flowsToExternal) {
		TAbstractType returnType = method.getSignature().getReturnType();
		if (typesImplementingAsset.contains(returnType)) {
			if (!(method.getDefinedBy() instanceof TInterface)) {
				boolean isPublic = TVisibility.TPUBLIC.equals(method.getTModifier().getTVisibility());
				if (isPublic && !flowsToExternal) {
					String warning = "Public method is returning the asset \"" + asset.getName() + "\": "
							+ method.getSignatureString();
					warnings.add(warning);
					LOGGER.warn(warning);
				}
			}
			for (TAbstractFlowElement flow : method.getSignature().getOutgoingFlows()) {
				Set<Process> targets = flow.getOutgoingFlows().parallelStream().flatMap(trg -> {
					if (trg instanceof TFlow) {
						return trg.getOutgoingFlows().stream();
					}
					if (trg instanceof TAccess) {
						return Stream.of(((TAccess) trg).getTSource());
					}
					return Stream.of(trg);
				}).map(trg -> mapper.getMapping((TMethodDefinition) trg)).filter(Objects::nonNull)
						.filter(trg -> trg != process).collect(Collectors.toSet());
				if (!allowedFlowTargets.containsAll(targets)) {
					LOGGER.error(targets.stream().filter(t -> !allowedFlowTargets.contains(t)).map(Process::getName)
							.collect(Collectors.joining("\", \"", "Flow from \"" + process.getName() + "\" to \"",
									"\" not specified in DFD!")));
				}
			}
		}
	}

	private static Set<Element> getAllowedFlowTargets(final Asset asset, final Process source) {
		return source.getOutflows().parallelStream().filter(flow -> flow.getAssets().contains(asset))
				.map(Flow::getTarget).flatMap(Collection::parallelStream).collect(Collectors.toSet());
	}

}
