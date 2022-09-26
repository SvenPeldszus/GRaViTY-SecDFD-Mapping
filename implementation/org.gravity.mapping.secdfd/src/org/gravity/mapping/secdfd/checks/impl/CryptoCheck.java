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

	public CryptoCheck(final TypeGraph pm, final IFile encryptFilename, final IFile decryptFilename) throws IOException {
		this.pm = pm;
		this.files = new EnumMap<>(ResponsibilityType.class);
		this.files.put(ResponsibilityType.ENCRYPT_OR_HASH, encryptFilename);
		this.files.put(ResponsibilityType.DECRYPT, decryptFilename);
		this.signatures = loadSignaturesFromFile(this.files, pm);
	}

	public CryptoCheck(final Mapper mapper) throws IOException {
		this(mapper.getPM(), getDefaultEncrypSignaturesFile(mapper.getGravityFolder()),
				getDefaultDecrypSignaturesFile(mapper.getGravityFolder()));
	}

	@Override
	public Collection<SResult> check(final Mapper mapper) {
		final Collection<SResult> encrypt = checkEncryptContract(mapper);
		final Collection<SResult> decrypt = checkDecryptContract(mapper);
		final ArrayList<SResult> results = new ArrayList<>(encrypt.size() + decrypt.size());
		results.addAll(encrypt);
		results.addAll(decrypt);
		return results;
	}

	public Collection<SResult> checkDecryptContract(final Mapper mapper) {
		if (!this.pm.equals(mapper.getPM())) {
			throw new IllegalStateException("The check hasn't been initialized for this program model");
		}
		final ResponsibilityType contractType = ResponsibilityType.DECRYPT;
		final Set<Process> processes = getRelevantProcesses(mapper.getDFD(), contractType);
		if (processes.isEmpty()) {
			return Collections.emptyList();
		}
		return findResults(mapper, processes, contractType);
	}

	public Collection<SResult> checkEncryptContract(final Mapper mapper) {
		if (!this.pm.equals(mapper.getPM())) {
			throw new IllegalStateException("The check hasn't been initialized for this program model");
		}
		final ResponsibilityType contractType = ResponsibilityType.ENCRYPT_OR_HASH;
		final Set<Process> processes = getRelevantProcesses(mapper.getDFD(), contractType);
		if (processes.isEmpty()) {
			return Collections.emptyList();
		}
		return findResults(mapper, processes, contractType);
	}

	private Set<Process> getRelevantProcesses(final EDFD dfd, final ResponsibilityType resType) {
		final Set<Process> relevantProcesses = new HashSet<>();
		dfd.getElements().parallelStream().filter(Process.class::isInstance).map(p -> (Process) p).forEach(p -> {
			final Set<Responsibility> responsibilities = p.eContents().parallelStream()
					.filter(Responsibility.class::isInstance).map(r -> (Responsibility) r).collect(Collectors.toSet());
			responsibilities.forEach(r -> {
				// check if any responsibility is of type 'resType'
				final Set<ResponsibilityType> rtype = r.getAction().parallelStream()
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
	private Set<SResult> findResults(final Mapper mapper, final Set<Process> processes, final ResponsibilityType ctype) {
		final Set<SResult> problems = new HashSet<>();
		final Set<TMethodDefinition> definitions = this.signatures.getOrDefault(ctype, Collections.emptySet());

		// find all the method definitions that are called by each method in
		// "methods'; if the list of signatures contains at least one, contract is
		// implemented.
		processes.forEach(p -> {
			final Set<TMethodDefinition> methods = mapper.getMapping(p);
			boolean flag = false;
			for (final TMethodDefinition method : methods) {
				flag = method.getAccessing().parallelStream().map(TAccess::getTarget)
						.filter(target -> target instanceof TMethodDefinition).anyMatch(definitions::contains);
				if (flag) {
					problems.add(new SResult(PState.SUCCESS, ctype, p, methods,
							"The " + ctype.getName() + " contract is implemented."));
					return;
				}
			}
			problems.add(new SResult(PState.ERROR, ctype, p, methods,
					createErrorMessage(ctype)));
		});
		return problems;
	}

	/**
	 * @param ctype
	 * @return
	 */
	public static String createErrorMessage(final ResponsibilityType ctype) {
		return "The " + ctype.getName() + " contract is not implemented.";
	}

	private static Map<ResponsibilityType, Set<TMethodDefinition>> loadSignaturesFromFile(
			final Map<ResponsibilityType, IFile> files, final TypeGraph pm) throws IOException {
		final Map<ResponsibilityType, Set<TMethodDefinition>> signatures = new EnumMap<>(ResponsibilityType.class);
		IOException exception = null;
		for (final Entry<ResponsibilityType, IFile> entry : files.entrySet()) {
			final IFile file = entry.getValue();
			if (file.exists()) {
				try {
					for (final String s : Files.readAllLines(file.getLocation().toFile().toPath())) {
						final TMethodDefinition methodDefinition = pm.getMethodDefinition(s);
						if (methodDefinition != null) {
							signatures.computeIfAbsent(entry.getKey(), set -> new HashSet<>())
							.add(methodDefinition);
						} else {
							// TODO: log
						}
					}
				} catch (final IOException e) {
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
		for (final Entry<ResponsibilityType, Set<TMethodDefinition>> entry : this.signatures.entrySet()) {
			final IFile iFile = this.files.get(entry.getKey());
			final File file = iFile.getLocation().toFile();
			if (!iFile.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
			try (FileWriter writer = new FileWriter(file, false)) {
				for (final TMethodDefinition obj : entry.getValue()) {
					writer.append(obj.getDefinedBy().getFullyQualifiedName() + '.' + obj.getSignatureString() + '\n');
				}
			} catch (final IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param sig
	 */
	public void addSignature(final TMethodDefinition sig, final ResponsibilityType contractType) {
		this.signatures.computeIfAbsent(contractType, set -> new HashSet<>()).add(sig);
		writeSignaturesToFile();
	}

	/**
	 * @param mappingView
	 * @return
	 * @throws IOException
	 */
	public static IFile getDefaultDecrypSignaturesFile(final IProject project) throws IOException {
		final IFolder gravityFolder = EclipseProjectUtil.getGravityFolder(project, null);
		return getDefaultDecrypSignaturesFile(gravityFolder);
	}

	private static IFile getDefaultDecrypSignaturesFile(final IFolder gravityFolder) {
		return gravityFolder.getFile("decrypt-signatures.txt");
	}

	/**
	 * @param mappingView
	 * @return
	 */
	public static IFile getDefaultEncrypSignaturesFile(final IProject project) throws IOException {
		final IFolder gravityFolder = EclipseProjectUtil.getGravityFolder(project, null);
		return getDefaultEncrypSignaturesFile(gravityFolder);
	}

	private static IFile getDefaultEncrypSignaturesFile(final IFolder gravityFolder) {
		return gravityFolder.getFile("encrypt-signatures.txt");
	}

}
