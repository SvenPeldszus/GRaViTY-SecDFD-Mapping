/**
 * 
 */
package org.gravity.flowdroid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.gravity.eclipse.io.ExtensionFileVisitor;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.eclipse.util.JavaProjectUtil;
import org.gravity.mapping.secdfd.checks.ContractCheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.ui.views.MappingLabelProvider;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.dsl.validation.SProblem;
import org.secdfd.dsl.validation.SProblem.PType;
import org.secdfd.model.NamedEntity;
import org.secdfd.model.ResponsibilityType;
import org.gravity.mapping.secdfd.checks.Crypto;

/**
 * @author katjat
 *
 */

@RunWith(Parameterized.class)
public class ContractEvaluator {
	public static Set<String> ContractTypes = new HashSet<String>(Arrays.asList("ENCRYPT", "DECRYPT", "FWDJOIN"));

	public static enum ComplianceType {
		ABSENCE, CONVERGENCE;
	}

	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final Logger LOGGER = Logger.getLogger(ContractEvaluator.class);

	private Mapper mapper;
	private IFolder output;
	private Map<String, List<Map<String, String>>> absenceGT;
	private Map<String, List<Map<String, String>>> convergenceGT;
	private HashSet<String> truePositives;
	private HashSet<String> falsePositives;
	private HashSet<String> falseNegatives;

	public static Integer accummulatedTP = 0;
	public static Integer accummulatedFP = 0;
	public static Integer accummulatedFN = 0;

	/**
	 * @param testName
	 * @param mapper
	 * @param absenceGT
	 * @param convergenceGT
	 * @throws CoreException
	 */
	public ContractEvaluator(String testName, Mapper mapper, Map<String, List<Map<String, String>>> absenceGT,
			Map<String, List<Map<String, String>>> convergenceGT) throws CoreException {
		this.mapper = mapper;
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("contracts"),
				mapper.getDFD().getName(), new NullProgressMonitor());
		this.absenceGT = absenceGT;
		this.convergenceGT = convergenceGT;
		this.truePositives = new HashSet<String>();
		this.falsePositives = new HashSet<String>();
		this.falseNegatives = new HashSet<String>();
		LOGGER.info("Start validation with: " + testName);
	}

	/**
	 * Run checks for decrypt contracts
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void valdiateDecrypt() throws IOException, CoreException {
		Set<Crypto> tocheck = new HashSet<>();
		tocheck.add(new Crypto(ResponsibilityType.DECRYPT, Optional.ofNullable("decrypt-signatures.txt")));
		ContractCheck checker = new ContractCheck(mapper.getGravityFolder(), mapper.getPM(),
				Collections.singleton(mapper), tocheck);

		try {
			checker.checkSecurityContracts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<SProblem> problems = checker.getProblems();

		// count TP,FP,FN
		problems.forEach(problem -> {
			if (problem.getType().toString().toLowerCase().contains("decrypt")) {
				countTPandFP(problem, mapper.getDFD().getName());
			}
		});
		countFN(problems, mapper.getDFD().getName(), SProblem.PType.DECRYPT);

		accummulatedTP += truePositives.size();
		accummulatedFP += falsePositives.size();
		accummulatedFN += falseNegatives.size();
		// log to file
		ExperimentHelper.writeToTxt(output,
				ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives), "decrypt-results",
				new NullProgressMonitor(), false);
	}

	/**
	 * Run checks for encrypt
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void validateEncrypt() throws IOException, CoreException {
		Set<Crypto> tocheck = new HashSet<>();
		tocheck.add(new Crypto(ResponsibilityType.ENCRYPT_OR_HASH, Optional.ofNullable("encrypt-signatures.txt")));
		ContractCheck checker = new ContractCheck(mapper.getGravityFolder(), mapper.getPM(),
				Collections.singleton(mapper), tocheck);

		try {
			checker.checkSecurityContracts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<SProblem> problems = checker.getProblems();

		// count TP,FP,FN
		problems.forEach(problem -> {
			if (problem.getType().toString().toLowerCase().contains("encrypt")) {
				countTPandFP(problem, mapper.getDFD().getName());
			}
		});
		countFN(problems, mapper.getDFD().getName(), SProblem.PType.ENCRYPT);

		accummulatedTP += truePositives.size();
		accummulatedFP += falsePositives.size();
		accummulatedFN += falseNegatives.size();
		// log to file
		ExperimentHelper.writeToTxt(output,
				ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives), "encrypt-results",
				new NullProgressMonitor(), false);
	}

	/**
	 * Run checks for forward
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void validateForward() throws IOException, CoreException {
		Set<Crypto> tocheck = new HashSet<>();
		tocheck.add(new Crypto(ResponsibilityType.FORWARD));
		ContractCheck checker = new ContractCheck(mapper.getGravityFolder(), mapper.getPM(),
				Collections.singleton(mapper), tocheck);

		try {
			checker.checkSecurityContracts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<SProblem> problems = checker.getProblems();

		// count TP,FP,FN
		problems.forEach(problem -> {
			if (problem.getType().toString().toLowerCase().contains("fwdjoin")) {
				countTPandFP(problem, mapper.getDFD().getName());
			}
		});
		countFN(problems, mapper.getDFD().getName(), SProblem.PType.FWDJOIN);

		accummulatedTP += truePositives.size();
		accummulatedFP += falsePositives.size();
		accummulatedFN += falseNegatives.size();
		// log to file
		ExperimentHelper.writeToTxt(output,
				ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives), "forward-results",
				new NullProgressMonitor(), false);
	}
	
	/**
	 * Run checks for join
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void validateJoin() throws IOException, CoreException {
		Set<Crypto> tocheck = new HashSet<>();
		tocheck.add(new Crypto(ResponsibilityType.JOINER));
		
		ContractCheck checker = new ContractCheck(mapper.getGravityFolder(), mapper.getPM(),
				Collections.singleton(mapper), tocheck);

		try {
			checker.checkSecurityContracts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<SProblem> problems = checker.getProblems();

		// count TP,FP,FN
		problems.forEach(problem -> {
			if (problem.getType().toString().toLowerCase().contains("fwdjoin")) {
				countTPandFP(problem, mapper.getDFD().getName());
			}
		});
		// TODO: decide to either split into forward and join, or process as the same responsibility in GT
		//countFN(problems, mapper.getDFD().getName(), SProblem.PType.FWDJOIN);

		accummulatedTP += truePositives.size();
		accummulatedFP += falsePositives.size();
		accummulatedFN += falseNegatives.size();
		// log to file
		ExperimentHelper.writeToTxt(output,
				ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives), "join-results",
				new NullProgressMonitor(), false);
	}

	// ========================================================================

	/**
	 * @param problem
	 * @param secdfdName
	 */
	private void countTPandFP(SProblem problem, String secdfdName) {
		if (problem.getState().toString().equals("WARNING")) {
			check(problem, secdfdName, absenceGT);
		} else if (problem.getState().toString().equals("OK")) {
			check(problem, secdfdName, convergenceGT);
		} else {
			LOGGER.info("Not supported SProblem type yet: " + problem.getState().toString());
		}

	}

	/**
	 * @param problem
	 * @param secdfdName
	 * @param groundtruth
	 */
	private void check(SProblem problem, String secdfdName, Map<String, List<Map<String, String>>> groundtruth) {
		String dfdElementName = ((NamedEntity) problem.getDfdElement()).getName().toLowerCase();
		String ctype = problem.getType().toString().toLowerCase();
		if (groundtruth.get(ctype) == null) {
			addFP(problem, dfdElementName);
			return;
		}
		Set<Map<String, String>> matches = groundtruth.get(ctype).parallelStream()
				.filter(c -> c.get("secdfd").equals(secdfdName)).filter(c -> c.get("element").equals(dfdElementName))
				.collect(Collectors.toSet());
		if (!matches.isEmpty()) {
			addTP(problem, dfdElementName);
		} else {
			addFP(problem, dfdElementName);
		}
	}

	/**
	 * @param problems
	 * @param secdfdName
	 * @param encryptOrHash
	 */
	private void countFN(Set<SProblem> problems, String secdfdName, PType ctype) {
		countFN(problems, secdfdName, absenceGT, "absence", ctype);
		countFN(problems, secdfdName, convergenceGT, "convergence", ctype);
	}

	/**
	 * @param problems
	 * @param secdfdName
	 * @param groundtruth
	 * @param FNType
	 * @param contractType
	 */
	private void countFN(Set<SProblem> problems, String secdfdName, Map<String, List<Map<String, String>>> groundtruth,
			String FNType, PType contractType) {
		for (String ctype : groundtruth.keySet()) {
			if (contractType.toString().toLowerCase().contains(ctype)) {
				for (Map<String, String> expectedTP : groundtruth.get(ctype)) {
					if (expectedTP.get("secdfd").equals(secdfdName)) {
						Set<SProblem> matches = new HashSet<SProblem>();
						for (SProblem problem : problems) {
							String dfdString = MappingLabelProvider.prettyPrint(problem.getDfdElement()).toLowerCase();
							dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
							if (dfdString.equals(expectedTP.get("element")))
								matches.add(problem);
						}
						if (matches.isEmpty())
							addFN(FNType, ctype, expectedTP);
					}
				}
			}
		}
	}

	/**
	 * @param problem
	 * @param dfdElementName
	 */
	private void addTP(SProblem problem, String dfdElementName) {
		truePositives.add("Problem type: " + problem.getType().toString() + ", Problem state: " + problem.getState()
				+ ", Element: " + dfdElementName);
	}

	/**
	 * @param problem
	 * @param dfdElementName
	 */
	private void addFP(SProblem problem, String dfdElementName) {
		falsePositives.add("Problem type: " + problem.getType().toString() + ", Problem state: " + problem.getState()
				+ ", Element: " + dfdElementName);
	}

	/**
	 * @param FNType
	 * @param ctype
	 * @param expectedTP
	 */
	private void addFN(String FNType, String ctype, Map<String, String> expectedTP) {
		falseNegatives.add("Contract: " + ctype.toUpperCase() + ", FN Type: " + FNType + ", Element: "
				+ expectedTP.get("element"));
	}

	/**
	 * Collects the projects specified in the constant PROJECT_NAMES for executint
	 * the experiments on them
	 * 
	 * THIS METHOD SHOULD ONLY BE CALLED BY THE JUNIT RUNNER!
	 * 
	 * @return The experiment data
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> collectProjects() {
		IProgressMonitor monitor = new NullProgressMonitor();
		Collection<Object[]> data = new ArrayList<>(PROJECT_NAMES.length);
		for (String projectName : PROJECT_NAMES) {
			try {
				IProject project = EclipseProjectUtil.getProjectByName(projectName);
				IJavaProject javaProject = JavaProjectUtil.getJavaProject(project);
				if (!javaProject.isOpen()) {
					javaProject.open(monitor);
				}
				// build the project to validate
				project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

				// paths for secdfd-gravity tool, setup correspondence model, mapper, dfd
				IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);

				// create result folder
				IFolder resultOutputFolder = gravity.getFolder("contracts");
				if (!resultOutputFolder.exists()) {
					resultOutputFolder.create(true, true, new NullProgressMonitor());
				}

				// ground truth file names
				String absenceFileName = "groundtruth/contracts/" + javaProject.getResource().getName()
						+ "_absence.json";
				String convergenceFileName = "groundtruth/contracts/" + javaProject.getResource().getName()
						+ "_convergence.json";

				ExtensionFileVisitor visitor = new ExtensionFileVisitor(".corr.xmi");
				gravity.accept(visitor);
				for (Path corr : visitor.getFiles()) {
					String corrModelFileName = corr.getFileName().toString();
					Mapper mapper = new Mapper(gravity.getFile(corrModelFileName));
					data.add(new Object[] { project.getName() + " -> " + corrModelFileName, mapper,
							GroundTruthParser.readGT(javaProject, absenceFileName,
									mapper.getDFD().getName().toLowerCase()),
							GroundTruthParser.readGT(javaProject, convergenceFileName,
									mapper.getDFD().getName().toLowerCase()) });
				}
			} catch (CoreException | IOException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		return data;
	}

	@AfterClass
	public static void printSummary() throws CoreException {
		for (String i : ExperimentHelper.stringBuilderAccummulated(accummulatedTP, accummulatedFP, accummulatedFN)) {
			System.out.print(i);
		}
	}

}
