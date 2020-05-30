/**
 * 
 */
package org.gravity.flowdroid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.model.Asset;
import org.secdfd.model.EDFD;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

/**
 * @author katjat This class is used to inject responsibilities (contracts) to
 *         existing secdfds in the project. The contracts are injected on
 *         existing Processes, and secdfd files are not rewritten (else we loose
 *         the mappings). These injected contracts are only used for validation
 *         purpose, therefore only the Absence ground truth files are updated
 *         upon every inject.
 *
 */
public class ContractInjector {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(ContractInjector.class);

	/**
	 * The correspondence model
	 */
	private Mapper mapper;
	private Map<String, List<Map<String, String>>> absenceGT;
	private Map<String, List<Map<String, String>>> convergenceGT;
	private Map<ResponsibilityType, Integer> injectTasks;
	private Set<Responsibility> injected;

	// if we want to inject a data flow leak, we need to remove a confidential asset
	// from the data flow going into a sink. This results in a forbidden sink (not
	// whitelist), for which FlowDroid id run.
	//private Map<String, Set<String>> possibleLeaks;
	//private Integer removeTasks;
	//private Set<Objective> injectedE;

	/**
	 * Constructor (contracts)
	 */
	public ContractInjector(IFolder destination, HashMap<ResponsibilityType, Integer> injectTasks, Mapper mapper,
			Map<String, List<Map<String, String>>> absenceGT, Map<String, List<Map<String, String>>> convergenceGT) {
		this.injectTasks = injectTasks;
		this.mapper = mapper;
		this.absenceGT = absenceGT;
		this.convergenceGT = convergenceGT;
		this.injected = new HashSet<>();
	}


	/**
	 * @return the injectTasks
	 */
	public Map<ResponsibilityType, Integer> getInjectTask() {
		return injectTasks;
	}

	/**
	 * @return the injected
	 */
	public Set<Responsibility> getInjected() {
		return injected;
	}


	public Map<String, List<Map<String, String>>> performTasks() {
		EDFD secdfd = mapper.getDFD();
		injectTasks.keySet().forEach(key -> {
			Integer amount = injectTasks.get(key);
			Integer skipped = 0;
			while (amount > 0) {
				// get a random process, which does not have contract 'key' in convergenceGT
				Process randProcess = (Process) getRandom(
						secdfd.getElements().parallelStream().filter(Process.class::isInstance).map(p -> (Process) p)
								.filter(p -> !inGT(secdfd, p, key, convergenceGT)).collect(Collectors.toSet()));
				String keyStringLC = key.getName().toLowerCase();
				if (randProcess != null) {
					// try a randomly generated responsibility
					Responsibility r = generateResponsibility(key, randProcess, secdfd);
					// try to inject contract
					if (!inModel(r, randProcess)) {
						randProcess.getResponsibility().add(r);
						injected.add(r);
						// try to add to absenceGT map
						if (!inGT(secdfd, randProcess, key, absenceGT)) {
							Map<String, String> newEntry = new HashMap<>();
							newEntry.put("secdfd", secdfd.getName().toLowerCase());
							newEntry.put("element", randProcess.getName().toLowerCase());
							// absenceGT.get(keyStringLC).add(newEntry);
							List<Map<String, String>> existingEntries = absenceGT.get(keyStringLC);
							if (existingEntries != null) {
								existingEntries.add(newEntry);
							} else {
								List<Map<String, String>> newList = new ArrayList<>();
								newList.add(newEntry);
								absenceGT.put(keyStringLC, newList);
							}
						}
					} else {
						skipped++;
						LOGGER.info(
								"Generated responsibility already exists in the model and will be skipped. The amount of injected contracts will be less than specified.");
					}
					amount--;
				} else {
					// inject will not be possible
					skipped = amount;
					amount = 0;
					LOGGER.info("SecDFD only contains processes for which there is a convergence of contract "
							+ keyStringLC + ".");
				}

			}
			LOGGER.info("Skipped " + skipped + " inject tasks.");
		});
		// remove finished tasks
		injectTasks.clear();
		return absenceGT;
	}

	/**
	 * @param allowedSinksMap: This map is populated with sink that are allowed per
	 *                         asset. It was filled during source sink finding. The
	 *                         allowed sinks are there, because the asset is
	 *                         expected to flow to that sink (e.g., HasMap put
	 *                         operation). The assets with allowed sinks are
	 *                         candidates for removal to inject leaks.
	 * @return 
	 * @return
	 */
	/*
	public DFAnalysis performRemovalTasks(DFAnalysis dfAnalysis) {
		String SecDFDName = mapper.getDFD().getName();
		Map<Asset, List<String>> allowedSinksMap = dfAnalysis.getAllowedMap();
		while (removeTasks > 0) {
			Set<EObject> assets = allowedSinksMap.keySet().parallelStream()
					.filter(asset -> !allowedSinksMap.get(asset).isEmpty()).filter(EObject.class::isInstance)
					.map(a -> (EObject) a).collect(Collectors.toSet());
			if (assets.isEmpty()) {
				LOGGER.info("SecDFD does not contain a single asset which has allowed sinks.");
				removeTasks = 0;
				return dfAnalysis;
			}
			Asset randomAsset = (Asset) getRandom(assets);
			// get random allowed sink
			List<String> allowedSinks = allowedSinksMap.get(randomAsset);
			String randomAllowedSink = allowedSinks
					.get(ThreadLocalRandom.current().nextInt(0, allowedSinks.size() + 1));

			// remove from allowed sinks
			dfAnalysis.getAllowedMap().get(randomAsset).remove(randomAllowedSink);
			// add to forbidden sinks
			
			
			// add to ground truth
			possibleLeaks.get(SecDFDName).add(randomAllowedSink);

			removeTasks--;
		}
		return dfAnalysis;
	}*/

	private boolean inModel(Responsibility r, Process randProcess) {
		for (Responsibility res : randProcess.getResponsibility()) {
			if (res.getAction().containsAll(r.getAction()) && res.getIncomeassets().containsAll(r.getIncomeassets())
					&& res.getOutcomeassets().containsAll(r.getOutcomeassets())) {
				// already part of this process
				return true;
			}
		}
		return false;
	}

	private Responsibility generateResponsibility(ResponsibilityType key, Process randProcess, EDFD secdfd) {
		Responsibility r = ModelFactory.eINSTANCE.createResponsibility();
		Set<EObject> assets = randProcess.getAssets().parallelStream().map(a -> (EObject) a)
				.collect(Collectors.toSet());
		Asset a = (Asset) getRandom(assets);
		Asset c = (Asset) getRandom(assets);
		r.getAction().add(key);
		r.getIncomeassets().add(a);
		switch (key) {
		case JOINER:
			Asset b = (Asset) getRandom(assets);
			r.setName("Injected Join");
			r.getIncomeassets().add(b);
			r.getOutcomeassets().add(c);
			break;
		case FORWARD:
			r.setName("Injected Forward");
			r.getOutcomeassets().add(a);
			break;
		case ENCRYPT_OR_HASH:
			r.setName("Injected Encrypt");
			r.getOutcomeassets().add(c);
			break;
		case DECRYPT:
			r.setName("Injected Decrypt");
			r.getOutcomeassets().add(c);
			break;
		default:
			r.setName("Injected Other");
			r.getOutcomeassets().add(c);
			break;
		}
		return r;
	}

	private EObject getRandom(Collection<EObject> setOfElements) {
		int item = new Random().nextInt(setOfElements.size());
		int i = 0;
		for (EObject obj : setOfElements) {
			if (i == item)
				return obj;
			i++;
		}
		return null;
	}

	private boolean inGT(EDFD secdfd, Process randProcess, ResponsibilityType key,
			Map<String, List<Map<String, String>>> GT) {
		List<Map<String, String>> items = GT.get(key.getName().toLowerCase());
		if (items != null) {
			for (Map<String, String> item : items) {
				if (item.get("secdfd").contains(secdfd.getName().toLowerCase())
						&& item.get("element").contains(randProcess.getName().toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
}
