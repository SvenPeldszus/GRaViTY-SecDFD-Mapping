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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.xtext.example.mydsl.validation.MyDslValidator;
import org.xtext.example.mydsl.validation.SProblem;
import org.xtext.example.mydsl.validation.SProblem.PState;
import org.xtext.example.mydsl.validation.SProblem.PType;

import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Process;
import eDFDFlowTracking.Responsibility;
import eDFDFlowTracking.ResponsibilityType;

/**
 * A class managing the encryption/decryption signatures and checking their
 * presence in the source corresponding to the target
 * 
 * @author katjat
 *
 */
public class EncryptionCheck {

	public static enum Crypto {
		ENCRYPT("encrypt-signatures.txt"), DECRYPT("decrypt-signatures.txt");

		public String file;

		private Crypto(String file) {
			this.file = file;
		}

		public String getFileName() {
			return file;
		}
	}

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(EncryptionCheck.class);

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
	public EncryptionCheck(IFolder dest, TypeGraph pm, Collection<Mapper> mappers) {
		this.destination = dest;
		this.mappers = mappers;
		this.pm = pm;

		signatures = new HashMap<>();
		problems = new HashSet<>();
		// write to user displayed file
		writeSignaturesToFile();

	}

	/**
	 * @param encrypt
	 * @param sig
	 */
	public void addSignature(Boolean encrypt, TMethodDefinition sig) {
		try {
			loadSignaturesFromFile();
		} catch (IOException e1) {
			signatures = new HashMap<>();
		}
		if (encrypt) {
			signatures.computeIfAbsent(Crypto.ENCRYPT, Set -> new HashSet<>()).add(sig);
		} else {
			signatures.computeIfAbsent(Crypto.DECRYPT, Set -> new HashSet<>()).add(sig);
		}
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
	public void checkImplementedEncyption() throws IOException {
		// load signatures from file
		loadSignaturesFromFile();
		DataProcessingCheck dataProcessing = new DataProcessingCheck();
		FlowEntryExit entryExit = new FlowEntryExit(mappers);
		
		for (Mapper mapper : mappers) {
			EDFD dfd = (EDFD) mapper.getDFD();
			Set<Element> processes = dfd.getElements().parallelStream().filter(Process.class::isInstance)
					.collect(Collectors.toSet());
			
			for (Element pr : processes) {
				Process p = (Process) pr;
				EList<EObject> a = p.eContents();
				for (EObject obj : a) {
					if (obj instanceof Responsibility) {
						Responsibility res = (Responsibility) obj;
						EList<ResponsibilityType> ac = res.getAction();
						for (ResponsibilityType rt : ac) {
							if (rt == ResponsibilityType.ENCRYPT_OR_HASH && signatures.containsKey(Crypto.ENCRYPT)) {
								findProblems(mapper, p, true);
							}
							if (rt == ResponsibilityType.DECRYPT && signatures.containsKey(Crypto.DECRYPT)) {
								findProblems(mapper, p, false);
							}
							if (rt == ResponsibilityType.FORWARD || rt == ResponsibilityType.COPIER) {
								//run check for fwd
								problems.addAll(dataProcessing.check(entryExit.entries, entryExit.exits, p, mapper, res));
							}
							if (rt == ResponsibilityType.JOINER) {
								//run check for join
								problems.addAll(dataProcessing.check(entryExit.entries, entryExit.exits,p , mapper, res));
							}
						}
					}
				}
			}
		}
		updateMarkers();
	}

	/**
	 * @param corr
	 * @param p
	 * @param rt
	 * @param isEncrypt
	 */
	private void findProblems(Mapper mapper, Process p, boolean isEncrypt) {
		Set<TMethodDefinition> methods = mapper.getMapping(p);
		if (isEncrypt) {
			// check if (at least one) correspondence exists with (at least one) encryption
			// signature
			boolean enc = methods.parallelStream().anyMatch(c -> {
				return signatures.get(Crypto.ENCRYPT).contains(c);
			});
			// If some correspondences of current process do not contain encrypt signature,
			// do not report problem
			// report problem for all correspondence of current process for user to check
			// manually
			if (!enc)
				getProblems().add(new SProblem(PState.WARNING, PType.ENCRYPT, (EObject) p, methods,
						"The encrypt process contract is not implemented."));
			else {
				getProblems().add(new SProblem(PState.OK, PType.ENCRYPT, (EObject) p, methods,
						"The encrypt process contract is implemented."));
			}
		} else {
			// it is a decrypt
			boolean enc = methods.parallelStream().anyMatch(c -> {
				return signatures.get(Crypto.DECRYPT).contains(c);
			});
			if (!enc)
				getProblems().add(new SProblem(PState.WARNING, PType.DECRYPT, (EObject) p, methods,
						"The decrypt process contract is not implemented."));
			else {

				getProblems().add(new SProblem(PState.OK, PType.DECRYPT, (EObject) p, methods,
						"The decrypt process contract is implemented."));
			}
		}
		
		//
	}

	/**
	 * @throws IOException
	 */
	private void loadSignaturesFromFile() throws IOException {
		signatures = new HashMap<>();
		IOException exception = null;
		File encryptSignaturesFile = destination.getFile(Crypto.ENCRYPT.getFileName()).getLocation().toFile();
		if (encryptSignaturesFile.exists()) {
			try {
				for (String s : Files.readAllLines(encryptSignaturesFile.toPath())) {
					signatures.computeIfAbsent(Crypto.ENCRYPT, Set -> new HashSet<TMethodDefinition>())
							.add(pm.getMethodDefinition(s));
				}
			} catch (IOException e) {
				exception = e;
			}
		}

		File decryptSignaturesFile = destination.getFile(Crypto.DECRYPT.getFileName()).getLocation().toFile();
		if (decryptSignaturesFile.exists()) {
			for (String s : Files.readAllLines(decryptSignaturesFile.toPath())) {
				signatures.computeIfAbsent(Crypto.DECRYPT, Set -> new HashSet<TMethodDefinition>())
						.add(pm.getMethodDefinition(s));
			}
		}
		if (exception != null) {
			throw exception;
		}
	}

	/**
	 * Prepare a file for the user to see all the en/decryption signatures at
	 * runtime
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
		for (Crypto k : signatures.keySet()) {
			File encryptSignaturesFile = destination.getFile(k.getFileName()).getLocation().toFile();
			if (!encryptSignaturesFile.exists()) {
				try {
					encryptSignaturesFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			FileWriter writer = null;
			try {
				writer = new FileWriter(encryptSignaturesFile, false);
				for (TMethodDefinition obj : signatures.get(k)) {
					writer.append(obj.getDefinedBy().getFullyQualifiedName() + '.' + obj.getSignatureString() + '\n');
				}
				writer.close();
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
			MyDslValidator.setProblems(problems);
			IFile file = destination.getParent().getFile(new Path("secdfds/"+mapper.getDFD().getName().toString()+".mydsl"));
			try {
				file.touch(new NullProgressMonitor());
			} catch (CoreException e) {
				LOGGER.log(Level.ERROR, e);
			}
		});
		
		//Debug
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