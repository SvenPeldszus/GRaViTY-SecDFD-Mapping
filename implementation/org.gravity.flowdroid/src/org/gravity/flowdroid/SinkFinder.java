/**
 * 
 */
package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.checks.EncryptionCheck.Crypto;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
import org.secdfd.model.NamedEntity;

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
	 * The location at which the SuSi sinks are stored
	 */
	private static IFolder destination = "org.gravity.flowdroid";

	/**
	 *  A class for preparing a list of sinks by:
	 *  1) loading SuiSi lists
	 *  2) asset final targets (in case of DataStore, ExternalEntity)
	 *  3) (if present) specified attacker zone elements
	 *  4? source code flows - secdfd flows. Not sure if this makes sense
	 *
	 */
	private SinkFinder() {
		// This class shouldn't be instantiated
	}
	
	
	/**
	 * @throws IOException
	 */
	static Set<AbstractCorrespondence> loadSinksFromFile(Set<AbstractCorrespondence> sinks) throws IOException {
		IOException exception = null;
		File SuSiSinksFile = destination.getFile("Ouput_CatSinks_v0_9.txt").getLocation().toFile();
		if (SuSiSinksFile.exists()) {
			try {
				for (String s : Files.readAllLines(SuSiSinksFile.toPath())) {
					//parse file 
					//	- ignore lines that do not start with "<"
					//	- skip lines that contain string android
					// 	- take <thesignatureishere> (SOMEOTHERSTUFF) 
					//compare signature from susi to correspondence (call getSootSignature) - if sink already present, ignore, else add
				}
			} catch (IOException e) {
				exception = e;
			}
		}
		if (exception != null) {
			throw exception;
		}
		
		return sinks;
	}
	

	/**
	 * 2) asset final target
	 * @param m
	 * @param asset
	 * @param assetsource
	 * @param assettargets
	 * @return
	 */
	public static Set<AbstractCorrespondence> findSinks(Mapper m, Asset asset, NamedEntity assetsource,
			List<Element> assettargets) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		for (Element el : assettargets) {
			if (el instanceof ExternalEntity || el instanceof DataStore) {
				sinks.addAll(getMappings(m, el));
				if (sinks.isEmpty()) {
					// there is no mapping of asset source element -> get the previous element
					Stream<Flow> transporterFlows = getTargetFlows(asset, assetsource);
					// collect the processes of the incoming flows:
					sinks.addAll(transporterFlows.flatMap(flow -> flow.getTarget().parallelStream())
							.flatMap(target -> getMappings(m, target).parallelStream()).collect(Collectors.toSet()));
				}
			}
		}
		return sinks;
	}
	
	/**
	 * 3) modeler specified trust zones
	 * @param mapper
	 * @param asset
	 * @param dfd
	 * @return
	 */
	public static Set<AbstractCorrespondence> findTrustZoneSinks(Mapper mapper, Asset asset, EDFD dfd) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		//get trust zones with attacker observation > 0 and contains elements that handle asset
		Set<Element> trustzones = dfd.getTrustzones().parallelStream()
		.filter(zone -> zone.getAttackerprofile().parallelStream()
				.anyMatch(profile -> profile.getObservation()>0)
				)		
		.flatMap(zone -> zone.getElements().parallelStream())
				.filter(el -> el.getAssets().contains(asset))			
		.collect(Collectors.toSet());
		
		//since each Element has an Attacker attribute, easier to do
		Set<Element> attackerelements = dfd.getElements().parallelStream()
		.filter(el -> el.getAssets().contains(asset))
		.filter(el -> el.isAttacker())
		.collect(Collectors.toSet());
		//take the union of elements
		attackerelements.addAll(trustzones);
		
		for (Element e : attackerelements) {
			sinks.addAll(getMappings(mapper, e));
		}
		return sinks;
	}
	
	/**
	 * 4? Will probably not use
	 * @param m
	 * @param asset
	 */
	public static void computeSlice(Mapper m, Asset asset) {
		Element sourceElement = asset.getSource();
		if (sourceElement instanceof Process){
			Set<TMethodDefinition> methods = m.getMapping((Process)sourceElement);
			Set<TFlow> flows = methods.stream().flatMap(meth -> meth.getOwnedFlows().stream())
					 .collect(Collectors.toSet());
			
			for (TFlow flow : flows) {
				//forward search
				EList<TAbstractFlowElement> targets = flow.getOutgoingFlows();
				for (TAbstractFlowElement afe : targets) {
						Set<TFlow> slice = null;
						findSlice(slice, afe, asset);		
					}					
			}
		}

	}

	private static void findSlice(Set<TFlow> slice, TAbstractFlowElement afe, Asset asset){
		//stop when no more outgoing flow for asset (get communicated types?)
		if (!canContinue(afe,asset)) {
			//update map
			slice.add((TFlow) afe);
			return;
		}else {
			if (afe instanceof TMethodDefinition) {
				findSlice(slice, ((TMethodDefinition) afe).getSignature(), asset);
 			}
			else {
				//step fwd
				for (TAbstractFlowElement forwards : afe.getOutgoingFlows()) {
					findSlice(slice, forwards, asset);
					assetFlowSlices.put(asset, slice);
				}
			}
			
		}
	
	}
	private static boolean canContinue(TAbstractFlowElement afe, Asset asset) {
		//Should be something similar to the method classifyFlows in DataProcessingCheck.java to find if the type are communicated forward.
		return false;
	}


	
	public static Set<AbstractCorrespondence> getMappings(Mapper mapper, EObject dfdelement) {
		EList<AbstractCorrespondence> allcorresp = mapper.getMapping().getUserdefined();
		allcorresp.addAll(mapper.getMapping().getSuggested());
		allcorresp.addAll(mapper.getMapping().getAccepted());
		
		return allcorresp.parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement)).collect(Collectors.toSet());
	}
	
	private static Stream<Flow> getTargetFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getInflows().parallelStream()
				.filter(inflow -> inflow.getAssets().contains(asset)).distinct();
	}

}
