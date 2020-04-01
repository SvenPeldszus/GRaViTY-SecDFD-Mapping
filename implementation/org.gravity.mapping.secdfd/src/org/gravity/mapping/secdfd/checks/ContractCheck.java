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
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.Map.Entry;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.validation.SecDFDValidator;
import org.secdfd.dsl.validation.SProblem;
import org.secdfd.dsl.validation.SProblem.PState;
import org.secdfd.dsl.validation.SProblem.PType;

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

	Map<Crypto, Set<TMethodDefinition>> signatures;

	Set<SProblem> problems;

	/**
	 * The location at which the signatures should be stored
	 */
	private IFolder destination;
	/**
	 * The correspondence model
	 */
	private Collection<Mapper> mappers;

	private TypeGraph pm;
	private Collection<Crypto> crypto;

	/**
	 * @param dest
	 * @param pm
	 * @param mappers
	 */
	/**
	 * @param dest
	 * @param pm
	 * @param mappers
	 */
	public ContractCheck(IFolder dest, TypeGraph pm, Collection<Mapper> mappers, Collection<Crypto> crypto) {
		this.destination = dest;
		this.mappers = mappers;
		this.pm = pm;
		this.crypto = crypto;

		signatures = new HashMap<>();
		problems = new HashSet<>();
		// write to user displayed file
		writeSignaturesToFile();
	}

	/*
	 * 1) find existing correspondences for secDFD 'encrypt/decrypt' contracts on
	 * processes 2) if correspondences include at least one implementation
	 * (TMethodImpl) with signature, consider it implemented (we don't care how
	 * correct it is implemented) ?3) optional extension: propagate encrypted values
	 * FlowDroid
	 *
	 */
	/**
	 * @return
	 * @throws IOException
	 */
	public void checkSecurityContracts() throws IOException {
		mappers.forEach(mapper -> {
			crypto.forEach(c -> {
				try {
					checkContract(mapper, c);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		});
	}

	private void checkContract(Mapper mapper, Crypto cryptoType) throws IOException {
		Set<Process> processes = getRelevantProcesses(mapper, cryptoType.getType());
		if (processes.isEmpty())
			return;
		if (cryptoType.getFileName()!=null) {
			// load signatures from file (encrypt/decrypt)
			loadSignaturesFromFile(cryptoType);
			problems.addAll(findProblems(mapper, processes, cryptoType));
		} else {
			// some other contract type (fwd, join,...) to be refined when fwd/join check is
			// cleaned
			DataProcessingCheck dataProcessing = new DataProcessingCheck();
			FlowEntryExit entryExit = new FlowEntryExit(mappers);
			processes.forEach(p -> {
				Set<Responsibility> responsibilities = p.eContents().parallelStream()
						.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r)
						.collect(Collectors.toSet());
				responsibilities.forEach(res -> {
					problems.addAll(dataProcessing.check(entryExit.entries, entryExit.exits, p, mapper, res));
				});
			});
		}
		updateMarkers();
	}

	/**
	 * @param cryptoType
	 * @throws IOException
	 */
	private void loadSignaturesFromFile(Crypto cryptoType) throws IOException {
		signatures = new HashMap<>();
		IOException exception = null;
		File signaturesFile = destination.getFile(cryptoType.getFileName().get()).getLocation().toFile();
		if (signaturesFile.exists()) {
			try {
				for (String s : Files.readAllLines(signaturesFile.toPath())) {
					signatures.computeIfAbsent(cryptoType, Set -> new HashSet<TMethodDefinition>())
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

	/**
	 * @param sig
	 */
	public void addSignature(TMethodDefinition sig) {
		if (crypto.size() > 1) {
			LOGGER.info("Signature can only be added to a single contract type at a time.");
			return;
		} else {
			Crypto type = crypto.stream().findAny().get();
			try {
				loadSignaturesFromFile(type);
			} catch (IOException e) {
				e.printStackTrace();
			}
			signatures.computeIfAbsent(type, set -> new HashSet<>()).add(sig);
			writeSignaturesToFile();
		}
	}

	public Set<Process> getRelevantProcesses(Mapper mapper, ResponsibilityType resType) {
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
	 * @param resType
	 * @return A set of contract violations (problems) for resType contract.
	 *         Currently this supports encrypt and decrypt contract types
	 */
	private Set<SProblem> findProblems(Mapper mapper, Set<Process> processes, Crypto resType) {
		Set<SProblem> problems = new HashSet<>();
		PType problemType;
		if (resType.getType().getName().toUpperCase().contains("ENCRYPT")) {
			problemType = PType.ENCRYPT;
		} else {
			problemType = PType.DECRYPT;
		}
		// find all the method definitions that are called by each method in
		// "methods'; if the list of signatures contains at least one, contract is
		// implemented.
		processes.forEach(p -> {
			Set<TMethodDefinition> methods = mapper.getMapping(p);
			boolean flag = false;
			for (TMethodDefinition method : methods) {
				Set<TMember> calling = method.getTAccessing().parallelStream().map(m -> m.getTTarget())
						.filter(target -> target instanceof TMethodDefinition).collect(Collectors.toSet());
				flag = calling.parallelStream().anyMatch(c -> {
					return signatures.get(resType).contains(c);
				});

				if (flag) {
					problems.add(new SProblem(PState.OK, problemType, (EObject) p, methods,
							"The " + resType.getType().getName() + " contract is implemented."));
					return;
				}
			}
			problems.add(new SProblem(PState.WARNING, problemType, (EObject) p, methods,
					"The " + resType.getType().getName() + " contract is not implemented."));
		});
		return problems;
	}

	/**
	 * Prepare a file for the user to see all the en/decryption signatures at
	 * runtime
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
		for (Entry<Crypto, Set<TMethodDefinition>> entry : signatures.entrySet()) {
			File encryptSignaturesFile = destination.getFile(entry.getKey().getFileName().get()).getLocation().toFile();
			if (!encryptSignaturesFile.exists()) {
				try {
					encryptSignaturesFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try (FileWriter writer = new FileWriter(encryptSignaturesFile, false)) {
				for (TMethodDefinition obj : entry.getValue()) {
					writer.append(obj.getDefinedBy().getFullyQualifiedName() + '.' + obj.getSignatureString() + '\n');
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Update the marker data for the DFD
	 */
	private void updateMarkers() {
		mappers.forEach(mapper -> {
			SecDFDValidator.setProblems(problems);
			IFile file = destination.getParent()
					.getFile(new Path("secdfds/" + mapper.getDFD().getName().toString() + ".secdfd"));
			try {
				file.touch(new NullProgressMonitor());
			} catch (CoreException e) {
				LOGGER.log(Level.ERROR, e);
			}
		});

		// Debug
		FlowEntryExit fee = new FlowEntryExit(mappers);
		fee.getEntriesExits();
	}

	/**
	 * @return the problems
	 */
	public Set<SProblem> getProblems() {
		return problems;
	}

}
