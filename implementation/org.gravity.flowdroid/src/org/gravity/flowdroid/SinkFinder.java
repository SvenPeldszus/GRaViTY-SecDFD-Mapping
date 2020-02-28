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
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TFlow;
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
	 * @param gravity
	 * @return
	 * @throws IOException
	 */
	static Set<String> loadSinksFromFile(IFolder gravity) throws IOException {
		IOException exception = null;
		File SuSiSinksFile = gravity.getFile("Ouput_CatSinks_v0_9.txt").getLocation().toFile();
		Set<String> susisinks = new HashSet<>();
		if (SuSiSinksFile.exists()) {
			try {
				for (String s : Files.readAllLines(SuSiSinksFile.toPath())) {
					// parse file
					if ((s.indexOf("<") > -1) && (s.indexOf(">") > -1) && !s.contains("android")) {
						s = s.substring(s.indexOf("<"), s.indexOf(">") + 1);
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
	 * 2) incoming data flows to DS and EE 
	 * 3) + if modeler specified trust zones, attacker attribute
	 * 
	 * @param mapper
	 * @param dfd
	 * @return
	 */
	public static Set<AbstractCorrespondence> findSinks(Mapper mapper, EDFD dfd) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		Set<Element> attackerzones = dfd.getTrustzones().parallelStream().filter(
				zone -> zone.getAttackerprofile().parallelStream().anyMatch(profile -> profile.getObservation() > 0))
				.flatMap(zone -> zone.getElements().parallelStream())
				// .filter(el -> el.getAssets().contains(asset))
				.collect(Collectors.toSet());

		// elements with incoming data flow
		Set<Element> elements = dfd.getElements().parallelStream().filter(el -> !el.getInflows().isEmpty())
				.collect(Collectors.toSet());
		for (Element el : elements) {
			Set<AbstractCorrespondence> mappings = getMappings(mapper, el);
			if (attackerzones.contains(el) || el.isAttacker()) {
				sinks.addAll(mappings);
			} else {
				if (el instanceof ExternalEntity || el instanceof DataStore) {
					if (mappings.isEmpty()) {
						// find mappings of previous element (processes of the incoming flows)
						sinks.addAll(el.getInflows().parallelStream()
								.flatMap(flow -> getMappings(mapper, flow.getSource()).parallelStream())
								.collect(Collectors.toSet()));

					} else {
						sinks.addAll(mappings);
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
