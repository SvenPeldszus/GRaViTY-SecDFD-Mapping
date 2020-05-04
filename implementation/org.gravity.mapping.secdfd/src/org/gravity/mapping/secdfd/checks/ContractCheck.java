/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.dsl.validation.SecDFDValidator;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

/**
 * A class managing the encryption/decryption signatures and checking their
 * presence in the source corresponding to the target
 * 
 * @author katjat
 *
 */
public class ContractCheck {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(ContractCheck.class);

	public static final String MAPPING_MARKER = "org.gravity.mapping.secdfd.markers.java";

	Map<ResponsibilityType, Set<TMethodDefinition>> signatures;

	Set<SResult> results;

	/**
	 * The location at which the signatures should be stored
	 */
	private IFolder destination;
	private Map<ResponsibilityType, String> files;
	/**
	 * The correspondence model
	 */
	private Collection<Mapper> mappers;

	private TypeGraph pm;

	public ContractCheck(IFolder dest, TypeGraph pm, Collection<Mapper> mappers, String encryptFilename,
			String decryptFilename) throws IOException {
		this.destination = dest;
		this.mappers = mappers;
		this.pm = pm;
		this.files = new HashMap<>();
		files.put(ResponsibilityType.ENCRYPT_OR_HASH, encryptFilename);
		files.put(ResponsibilityType.DECRYPT, decryptFilename);

		signatures = loadSignaturesFromFile();
		results = new HashSet<>();
		// write to user displayed file
		// writeSignaturesToFile();
	}

	public void checkDecryptContract() throws IOException {
		mappers.forEach(mapper -> {
			ResponsibilityType contractType = ResponsibilityType.DECRYPT;
			Set<Process> processes = getRelevantProcesses(mapper, contractType);
			if (processes.isEmpty())
				return;
			results.addAll(findResults(mapper, processes, contractType));
		});
		updateMarkers();
	}
	
	public void checkEncryptContract() throws IOException {
		mappers.forEach(mapper -> {
			ResponsibilityType contractType = ResponsibilityType.ENCRYPT_OR_HASH;
			Set<Process> processes = getRelevantProcesses(mapper, contractType);
			if (processes.isEmpty())
				return;
			results.addAll(findResults(mapper, processes, contractType));
		});
		updateMarkers();
	}
	
	public void checkForwardContract() {
		mappers.forEach(mapper -> {
			ResponsibilityType contractType = ResponsibilityType.FORWARD;
			Set<Process> processes = getRelevantProcesses(mapper, contractType);
			if (processes.isEmpty())
				return;
			DataProcessingCheck dataProcessing = new DataProcessingCheck();
			processes.forEach(process -> {
				Set<Responsibility> responsibilities = process.eContents().parallelStream()
						.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r)
						.collect(Collectors.toSet());
				responsibilities.forEach(res -> {
					FlowEntryExit entryExit = FlowEntryExit.getEntriesExits(mapper, process);
					results.addAll(dataProcessing.check(entryExit.getEntries(), entryExit.getExits(), process, mapper, res));
				});
			});
		});
		updateMarkers();
	}
	
	// Katja: copy of fwd check for now
	public void checkJoinContract() {
		mappers.forEach(mapper -> {
			ResponsibilityType contractType = ResponsibilityType.JOINER;
			Set<Process> processes = getRelevantProcesses(mapper, contractType);
			if (processes.isEmpty())
				return;
			DataProcessingCheck dataProcessing = new DataProcessingCheck();
			processes.forEach(process -> {
				Set<Responsibility> responsibilities = process.eContents().parallelStream()
						.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r)
						.collect(Collectors.toSet());
				responsibilities.forEach(res -> {
					FlowEntryExit entryExit = FlowEntryExit.getEntriesExits(mapper, process);
					results.addAll(dataProcessing.check(entryExit.getEntries(), entryExit.getExits(), process, mapper, res));
				});
			});
		});
		updateMarkers();
	}

	private Set<Process> getRelevantProcesses(Mapper mapper, ResponsibilityType resType) {
		Set<Process> relevantProcesses = new HashSet<>();
		Set<Process> processes = mapper.getDFD().getElements().parallelStream().filter(Process.class::isInstance)
				.map(p -> (Process) p).collect(Collectors.toSet());
		processes.forEach(p -> {
			Set<Responsibility> responsibilities = p.eContents().parallelStream()
					.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r).collect(Collectors.toSet());
			responsibilities.forEach(r -> {
				// check if any responsibility is of type 'resType'
				Set<ResponsibilityType> rtype = r.getAction().parallelStream()
						.filter(rt -> rt.getName().contains(resType.getName())).collect(Collectors.toSet());
				if (rtype.size() > 0)
					relevantProcesses.add(p);
			});
		});
		return relevantProcesses;
	}

	/**
	 * @param mapper
	 * @param processes
	 * @param contractType
	 * @return A set of contract violations (results) for resType contract.
	 *         Currently this supports encrypt and decrypt contract types
	 */
	private Set<SResult> findResults(Mapper mapper, Set<Process> processes, ResponsibilityType ctype) {
		Set<SResult> problems = new HashSet<>();
		Set<TMethodDefinition> definitions = signatures.get(ctype);

		// find all the method definitions that are called by each method in
		// "methods'; if the list of signatures contains at least one, contract is
		// implemented.
		processes.forEach(p -> {
			Set<TMethodDefinition> methods = mapper.getMapping(p);
			boolean flag = false;
			for (TMethodDefinition method : methods) {
				flag = method.getTAccessing().parallelStream().map(m -> m.getTTarget())
						.filter(target -> target instanceof TMethodDefinition).anyMatch(c -> {
							return definitions.contains(c);
						});

				if (flag) {
					problems.add(new SResult(PState.SUCCESS, ctype, (EObject) p, methods,
							"The " + ctype.getName() + " contract is implemented."));
					return;
				}
			}
			problems.add(new SResult(PState.WARNING, ctype, (EObject) p, methods,
					"The " + ctype.getName() + " contract is not implemented."));
		});
		return problems;
	}

	/**
	 * @param contractType
	 * @throws IOException
	 */
	private void loadSignaturesFromFile(ResponsibilityType contractType) throws IOException {
		signatures = new HashMap<>();
		IOException exception = null;
		File signaturesFile = destination.getFile(files.get(contractType)).getLocation().toFile();
		if (signaturesFile.exists()) {
			try {
				for (String s : Files.readAllLines(signaturesFile.toPath())) {
					signatures.computeIfAbsent(contractType, Set -> new HashSet<TMethodDefinition>())
							.add(pm.getMethodDefinition(s));
				}
			} catch (IOException e) {
				exception = e;
			}
		}
		if (exception != null) {
			throw exception;
		}
	}

	private Map<ResponsibilityType, Set<TMethodDefinition>> loadSignaturesFromFile() throws IOException {
		Map<ResponsibilityType, Set<TMethodDefinition>> sigs = new HashMap<>();
		IOException exception = null;
		for (Entry<ResponsibilityType, String> entry : files.entrySet()) {
			File filename = destination.getFile(entry.getValue()).getLocation().toFile();
			if (filename.exists()) {
				try {
					for (String s : Files.readAllLines(filename.toPath())) {
						sigs.computeIfAbsent(entry.getKey(), Set -> new HashSet<TMethodDefinition>())
								.add(pm.getMethodDefinition(s));
					}
				} catch (IOException e) {
					exception = e;
				}
			}
		}
		if (exception != null) {
			throw exception;
		}
		return sigs;
	}

	/**
	 * Prepare a file for the user to see all the en/decryption signatures at
	 * runtime
	 * 
	 * @param contractType
	 * 
	 */
	private void writeSignaturesToFile() {
		if (!destination.exists()) {
			// create new folder
			try {
				destination.create(false, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		for (Entry<ResponsibilityType, Set<TMethodDefinition>> entry : signatures.entrySet()) {
			File signaturesFile = destination.getFile(files.get(entry.getKey())).getLocation().toFile();
			if (!signaturesFile.exists()) {
				try {
					signaturesFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try (FileWriter writer = new FileWriter(signaturesFile, false)) {
				for (TMethodDefinition obj : entry.getValue()) {
					writer.append(obj.getDefinedBy().getFullyQualifiedName() + '.' + obj.getSignatureString() + '\n');
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param sig
	 */
	public void addSignature(TMethodDefinition sig, ResponsibilityType contractType) {
		try {
			loadSignaturesFromFile(contractType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		signatures.computeIfAbsent(contractType, set -> new HashSet<>()).add(sig);
		writeSignaturesToFile();
	
	}

	/**
	 * Update the marker data for the DFD
	 */
	private void updateMarkers() {
		mappers.forEach(mapper -> {
			SecDFDValidator.setProblems(results);
			IFile file = destination.getParent()
					.getFile(new Path("secdfds/" + mapper.getDFD().getName().toString() + ".secdfd"));
			try {
				file.touch(new NullProgressMonitor());
			} catch (CoreException e) {
				LOGGER.log(Level.ERROR, e);
			}
		});

		// Debug
		Map<Process, FlowEntryExit> fee = FlowEntryExit.getEntriesExits(mappers);
	}

	/**
	 * @return the results
	 */
	public Set<SResult> getProblems() {
		return results;
	}

}
