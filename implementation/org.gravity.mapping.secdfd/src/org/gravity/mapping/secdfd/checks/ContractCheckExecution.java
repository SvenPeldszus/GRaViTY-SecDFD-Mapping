/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.io.IOException;
import java.util.Collection;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.gravity.mapping.secdfd.checks.impl.CryptoCheck;
import org.gravity.mapping.secdfd.checks.impl.DataFlowCheck;
import org.gravity.mapping.secdfd.checks.impl.FwdJoinCheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SecDFDValidator;

/**
 * A class managing the encryption/decryption signatures and checking their
 * presence in the source corresponding to the target
 * 
 * @author katjat
 *
 */
public class ContractCheckExecution {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(ContractCheckExecution.class);

	public static final String MAPPING_MARKER = "org.gravity.mapping.secdfd.markers.java";

	/**
	 * The location at which the signatures should be stored
	 */
	private IFolder destination;
	/**
	 * The correspondence model
	 */
	private Collection<Mapper> mappers;

	private final CryptoCheck cryptoCheck;

	public ContractCheckExecution(IFolder dest, TypeGraph pm, Collection<Mapper> mappers, String encryptFilename,
			String decryptFilename) throws IOException {
		this.destination = dest;
		this.mappers = mappers;
		this.cryptoCheck = new CryptoCheck(pm, dest.getFile(encryptFilename), dest.getFile(decryptFilename));
	}

	public void checkDecryptContract() {
		mappers.forEach(mapper -> updateMarkers(mapper, cryptoCheck.checkDecryptContract(mapper)));
	}

	public void checkEncryptContract() {
		mappers.forEach(mapper -> updateMarkers(mapper, cryptoCheck.checkEncryptContract(mapper)));
	}

	public void checkForwardAndJoinContract() {
		FwdJoinCheck check = new FwdJoinCheck();
		mappers.forEach(mapper -> updateMarkers(mapper, check.check(mapper)));
	}

	public void runDataFlowAnalyzer(int limit) {
		mappers.forEach(mapper -> {
			try {
				updateMarkers(mapper, new DataFlowCheck(mapper, true, limit, destination).check(mapper));
			} catch (IOException | CoreException e) {
				LOGGER.error(e);
			}
		});
	}

	/**
	 * Update the marker data for the DFD
	 * 
	 * @param results
	 */
	private void updateMarkers(Mapper mapper, Collection<SResult> results) {
		SecDFDValidator.setProblems(results);
		IFile file = destination.getParent().getFile(new Path("secdfds/" + mapper.getDFD().getName() + ".secdfd"));
		try {
			file.touch(new NullProgressMonitor());
		} catch (CoreException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

}
