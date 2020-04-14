/**
 * 
 */
package org.gravity.flowdroid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
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
	 * The location of ground truth files
	 */
	private IFolder destination;

	/**
	 * The correspondence model
	 */
	private Mapper mapper;
	private Map<String, List<Map<String, String>>> absenceGT;
	private Map<String, List<Map<String, String>>> convergenceGT;
	private Map<ResponsibilityType, Integer> injectTask;

	/**
	 * Constructor
	 */
	public ContractInjector(IFolder destination, HashMap<ResponsibilityType, Integer> injectTask, Mapper mapper,
			Map<String, List<Map<String, String>>> absenceGT, Map<String, List<Map<String, String>>> convergenceGT) {
		this.destination = destination;
		this.injectTask = injectTask;
		this.mapper = mapper;
		this.absenceGT = absenceGT;
		this.convergenceGT = convergenceGT;
	}

	public Map<ResponsibilityType, Integer> getInjectTask() {
		return injectTask;
	}

	public void setInjectTask(Map<ResponsibilityType, Integer> injectTask) {
		this.injectTask = injectTask;
	}

	public void performTasks() {
		EDFD secdfd = mapper.getDFD();
		injectTask.keySet().forEach(key -> {
			Integer amount = injectTask.get(key);
			while (amount > 0) {
				// get a random process
				Optional<Process> randProcess = secdfd.getElements().parallelStream().filter(Process.class::isInstance)
						.map(p -> (Process) p).findAny();
				if (randProcess.isPresent()) {
					if (!inConvergenceGT(secdfd, randProcess, key)) {
						// inject contract
						inject(key, randProcess.get(), secdfd);
						// add to absenceGT map
						Map<String, String> newEntry = new HashMap<>();
						newEntry.put("secdfd", secdfd.getName().toLowerCase());
						newEntry.put("element", randProcess.get().getName().toLowerCase());
						absenceGT.get(key.getName().toLowerCase()).add(newEntry);
					} else
						break;
					amount--;
				}
			}
			// remove finished tasks
			injectTask.remove(key);
		});

		// update GT file
		GroundTruthParser.updateGTFile(
				destination.getFile(secdfd.getName().toLowerCase() + ".json").getLocation().toFile(), convergenceGT);
	}

	/**
	 * @param secdfd
	 * @param randProcess
	 * @param item
	 */
	private boolean inConvergenceGT(EDFD secdfd, Optional<Process> randProcess, ResponsibilityType key) {
		List<Map<String, String>> items = convergenceGT.get(key.getName().toLowerCase());
		for (Map<String, String> item : items) {
			if (item.get("secdfd").contains(secdfd.getName().toLowerCase())
					&& item.get("element").contains(randProcess.get().getName().toLowerCase())) {
				return true;
			}
		}
		return false;

	}

	private void inject(ResponsibilityType key, Process randProcess, EDFD secdfd) {
		Responsibility r = ModelFactory.eINSTANCE.createResponsibility();
		Asset a = randProcess.getAssets().parallelStream().findAny().get();
		Asset c = randProcess.getAssets().parallelStream().findAny().get();
		r.setProcess(randProcess);
		r.getAction().add(key);
		r.getIncomeassets().add(a);
		switch (key) {
		case JOINER:
			Asset b = randProcess.getAssets().parallelStream().findAny().get();
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
			r.setName("Injected Encrypt");
			r.getOutcomeassets().add(c);
			break;
		default:
			r.setName("Injected Other Responsibility");
			r.getOutcomeassets().add(c);
			break;
		}
		randProcess.getResponsibility().add(r);
		// if secdfd files are rewritten, we loose the mappings
	}
}
