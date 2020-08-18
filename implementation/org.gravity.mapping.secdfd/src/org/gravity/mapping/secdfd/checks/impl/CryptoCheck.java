/**
 * 
 */
package org.gravity.mapping.secdfd.checks.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.EDFD;
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
public class CryptoCheck implements ICheck {

	public static final String MAPPING_MARKER = "org.gravity.mapping.secdfd.markers.java";

	Map<ResponsibilityType, Set<TMethodDefinition>> signatures;

	/**
	 * The location at which the signatures should be stored
	 */
	private final Map<ResponsibilityType, IFile> files;

	private final TypeGraph pm;

	public CryptoCheck(TypeGraph pm, IFile encryptFilename, IFile decryptFilename) throws IOException {
		this.pm = pm;
		this.files = new EnumMap<>(ResponsibilityType.class);
		this.files.put(ResponsibilityType.ENCRYPT_OR_HASH, encryptFilename);
		this.files.put(ResponsibilityType.DECRYPT, decryptFilename);
		this.signatures = loadSignaturesFromFile(files, pm);
	}

	public CryptoCheck(Mapper mapper) throws IOException {
		this(mapper.getPM(), getDefaultEncrypSignaturesFile(mapper.getGravityFolder()),
				getDefaultDecrypSignaturesFile(mapper.getGravityFolder()));
	}

	@Override
	public Collection<SResult> check(Mapper mapper) {
		Collection<SResult> encrypt = checkEncryptContract(mapper);
		Collection<SResult> decrypt = checkDecryptContract(mapper);
		ArrayList<SResult> results = new ArrayList<>(encrypt.size() + decrypt.size());
		results.addAll(encrypt);
		results.addAll(decrypt);
		return results;
	}

	public Collection<SResult> checkDecryptContract(Mapper mapper) {
		if (!this.pm.equals(mapper.getPM())) {
			throw new IllegalStateException("The check hasn't been initialized for this program model");
		}
		ResponsibilityType contractType = ResponsibilityType.DECRYPT;
		Set<Process> processes = getRelevantProcesses(mapper.getDFD(), contractType);
		if (processes.isEmpty())
			return Collections.emptyList();
		return findResults(mapper, processes, contractType);
	}

	public Collection<SResult> checkEncryptContract(Mapper mapper) {
		if (!this.pm.equals(mapper.getPM())) {
			throw new IllegalStateException("The check hasn't been initialized for this program model");
		}
		ResponsibilityType contractType = ResponsibilityType.ENCRYPT_OR_HASH;
		Set<Process> processes = getRelevantProcesses(mapper.getDFD(), contractType);
		if (processes.isEmpty())
			return Collections.emptyList();
		return findResults(mapper, processes, contractType);
	}

	private Set<Process> getRelevantProcesses(EDFD dfd, ResponsibilityType resType) {
		Set<Process> relevantProcesses = new HashSet<>();
		dfd.getElements().parallelStream().filter(Process.class::isInstance).map(p -> (Process) p).forEach(p -> {
			Set<Responsibility> responsibilities = p.eContents().parallelStream()
					.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r).collect(Collectors.toSet());
			responsibilities.forEach(r -> {
				// check if any responsibility is of type 'resType'
				Set<ResponsibilityType> rtype = r.getAction().parallelStream()
						.filter(rt -> rt.getName().contains(resType.getName())).collect(Collectors.toSet());
				if (!rtype.isEmpty()) {
					relevantProcesses.add(p);
				}
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
		Set<TMethodDefinition> definitions = signatures.getOrDefault(ctype, Collections.emptySet());

		// find all the method definitions that are called by each method in
		// "methods'; if the list of signatures contains at least one, contract is
		// implemented.
		processes.forEach(p -> {
			Set<TMethodDefinition> methods = mapper.getMapping(p);
			boolean flag = false;
			for (TMethodDefinition method : methods) {
				flag = method.getTAccessing().parallelStream().map(TAccess::getTTarget)
						.filter(target -> target instanceof TMethodDefinition).anyMatch(definitions::contains);
				if (flag) {
					problems.add(new SResult(PState.SUCCESS, ctype, (EObject) p, methods,
							"The " + ctype.getName() + " contract is implemented."));
					return;
				}
			}
			problems.add(new SResult(PState.ERROR, ctype, (EObject) p, methods,
					createErrorMessage(ctype)));
		});
		return problems;
	}

	/**
	 * @param ctype
	 * @return
	 */
	public static String createErrorMessage(ResponsibilityType ctype) {
		return "The " + ctype.getName() + " contract is not implemented.";
	}

	private static Map<ResponsibilityType, Set<TMethodDefinition>> loadSignaturesFromFile(
			Map<ResponsibilityType, IFile> files, TypeGraph pm) throws IOException {
		Map<ResponsibilityType, Set<TMethodDefinition>> signatures = new EnumMap<>(ResponsibilityType.class);
		IOException exception = null;
		for (Entry<ResponsibilityType, IFile> entry : files.entrySet()) {
			IFile file = entry.getValue();
			if (file.exists()) {
				try {
					for (String s : Files.readAllLines(file.getLocation().toFile().toPath())) {
						TMethodDefinition methodDefinition = pm.getMethodDefinition(s);
						if (methodDefinition != null) {
							signatures.computeIfAbsent(entry.getKey(), set -> new HashSet<TMethodDefinition>())
									.add(methodDefinition);
						} else {
							// TODO: log
						}
					}
				} catch (IOException e) {
					exception = e;
				}
			}
		}
		if (exception != null) {
			throw exception;
		}
		return signatures;
	}

	/**
	 * Prepare a file for the user to see all the en/decryption signatures at
	 * runtime
	 * 
	 * @param contractType
	 * 
	 */
	private void writeSignaturesToFile() {
		for (Entry<ResponsibilityType, Set<TMethodDefinition>> entry : signatures.entrySet()) {
			IFile iFile = files.get(entry.getKey());
			File file = iFile.getLocation().toFile();
			if (!iFile.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try (FileWriter writer = new FileWriter(file, false)) {
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
		signatures.computeIfAbsent(contractType, set -> new HashSet<>()).add(sig);
		writeSignaturesToFile();
	}

	/**
	 * @param mappingView
	 * @return
	 * @throws IOException
	 */
	public static IFile getDefaultDecrypSignaturesFile(IProject project) throws IOException {
		IFolder gravityFolder = EclipseProjectUtil.getGravityFolder(project, null);
		return getDefaultDecrypSignaturesFile(gravityFolder);
	}

	private static IFile getDefaultDecrypSignaturesFile(IFolder gravityFolder) {
		return gravityFolder.getFile("decrypt-signatures.txt");
	}

	/**
	 * @param mappingView
	 * @return
	 */
	public static IFile getDefaultEncrypSignaturesFile(IProject project) throws IOException {
		IFolder gravityFolder = EclipseProjectUtil.getGravityFolder(project, null);
		return getDefaultEncrypSignaturesFile(gravityFolder);
	}

	private static IFile getDefaultEncrypSignaturesFile(IFolder gravityFolder) {
		return gravityFolder.getFile("encrypt-signatures.txt");
	}

}
