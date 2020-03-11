/**
 * 
 */
package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;

/**
 * @author katjat
 *
 */
public final class SinkFinder {

	/**
	 * The Map of Assets and their flows in the program (
	 */
	static Map<Asset, Set<TFlow>> assetFlowSlices;

	/**
	 * A class for preparing a list of sinks by: 1) loading SuiSi lists 2) asset
	 * final targets (in case of DataStore, ExternalEntity) 3) (if present)
	 * specified attacker zone elements 4? source code flows - secdfd flows. Not
	 * sure if this makes sense
	 *
	 */
	private SinkFinder() {

	}

	/**
	 * 1) susi list
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	static Set<String> loadSinksFromFile(IFile file) throws IOException {
		IOException exception = null;
		File suSiSinksFile = file.getLocation().toFile();
		Set<String> susisinks = new HashSet<>();
		if (suSiSinksFile.exists()) {
			try {
				for (String s : Files.readAllLines(suSiSinksFile.toPath())) {
					// parse file
					if ((s.indexOf('<') > -1) && (s.indexOf('>') > -1) && !s.contains("android")) {
						s = s.substring(s.indexOf('<'), s.indexOf('>') + 1);
						susisinks.add(s);
					}
				}
			} catch (IOException e) {
				exception = e;
			}
		}
		if (exception != null) {
			throw exception;
		}

		return susisinks;
	}

	/**
	 * 2) incoming data flows to DS and EE per asset. only add to sinks if on
	 * incoming flows the asset is not expected but we have it as return value in
	 * method signature. 3) + if modeler specified trust zones, attacker attribute
	 * 
	 * @param mapper
	 * @param dfd
	 * @return
	 */
	// TODO: split into allowed and forbidden sinks
	public static Set<? extends TMember> findSinks(Mapper mapper, Asset asset, boolean disableReturnTypeCheck) {
		EDFD dfd = mapper.getDFD();
		Set<TMember> sinks = new HashSet<>();
		Set<Element> attackerzones = dfd.getTrustzones().parallelStream().filter(
				zone -> zone.getAttackerprofile().parallelStream().anyMatch(profile -> profile.getObservation() > 0))
				.flatMap(zone -> zone.getElements().parallelStream()).collect(Collectors.toSet());

		// elements with incoming data flow
		Set<Element> elements = dfd.getElements().parallelStream().filter(el -> !el.getInflows().isEmpty())
				.collect(Collectors.toSet());
		for (Element el : elements) {
			if (attackerzones.contains(el) || el.isAttacker()) {
				sinks.addAll(mapper.getMapping(el).parallelStream().filter(TMember.class::isInstance)
						.map(TMember.class::cast).collect(Collectors.toList()));
			} else {
				if (el instanceof ExternalEntity || el instanceof DataStore) {
					// if any incoming flow contains current asset, then sink allowed.
					if (!el.getInflows().parallelStream().flatMap(inflow -> inflow.getAssets().parallelStream())
							.collect(Collectors.toSet()).contains(asset)) {
						// find mappings of previous element (processes of the incoming flows)
						Set<TMember> borderProcesses = el.getInflows().parallelStream()
								.flatMap(flow -> mapper.getMapping(flow.getSource()).parallelStream())
								.filter(TMember.class::isInstance).map(TMember.class::cast).collect(Collectors.toSet());
						if (disableReturnTypeCheck) {
							sinks.addAll(borderProcesses);
						} else {
							// get mapped types of asset
							Set<EObject> assetMappedTypes = getMappings(mapper, asset).parallelStream()
									.map(CorrespondenceHelper::getSource).collect(Collectors.toSet());

							// if method definition contains mapped asset type on return value then its a
							// sink
							for (TMember source : borderProcesses) {
								if (source instanceof TMethodDefinition) {
									if (assetMappedTypes.contains(((TMethodDefinition) source).getReturnType())) {
										// add to list of not allowed sinks
										sinks.add(source);
									}
								}
							}

						}

					}

				}
			}
		}
		return sinks;
	}

	public static Set<AbstractCorrespondence> getMappings(Mapper mapper, EObject dfdelement) {
		EList<AbstractCorrespondence> allcorresp = mapper.getMapping().getUserdefined();
		allcorresp.addAll(mapper.getMapping().getSuggested());
		allcorresp.addAll(mapper.getMapping().getAccepted());

		return allcorresp.parallelStream().filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement))
				.collect(Collectors.toSet());
	}

	/**
	 * 4? Will probably not use
	 * 
	 * @param m
	 * @param asset
	 */
	public static void computeSlice(Mapper m, Asset asset) {
		Element sourceElement = asset.getSource();
		if (sourceElement instanceof Process) {
			Set<TMethodDefinition> methods = m.getMapping((Process) sourceElement);
			Set<TFlow> flows = methods.stream().flatMap(meth -> meth.getOwnedFlows().stream())
					.collect(Collectors.toSet());

			for (TFlow flow : flows) {
				// forward search
				EList<TAbstractFlowElement> targets = flow.getOutgoingFlows();
				for (TAbstractFlowElement afe : targets) {
					Set<TFlow> slice = null;
					findSlice(slice, afe, asset);
				}
			}
		}

	}

	private static void findSlice(Set<TFlow> slice, TAbstractFlowElement afe, Asset asset) {
		// stop when no more outgoing flow for asset (get communicated types?)
		if (!canContinue(afe, asset)) {
			// update map
			slice.add((TFlow) afe);
			return;
		} else {
			if (afe instanceof TMethodDefinition) {
				findSlice(slice, ((TMethodDefinition) afe).getSignature(), asset);
			} else {
				// step fwd
				for (TAbstractFlowElement forwards : afe.getOutgoingFlows()) {
					findSlice(slice, forwards, asset);
					assetFlowSlices.put(asset, slice);
				}
			}

		}

	}

	private static boolean canContinue(TAbstractFlowElement afe, Asset asset) {
		// Should be something similar to the method classifyFlows in
		// DataProcessingCheck.java to find if the type are communicated forward.
		return false;
	}
}
