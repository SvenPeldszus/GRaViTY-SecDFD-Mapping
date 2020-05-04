/**
 * 
 */
package org.gravity.flowdroid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.secdfd.dsl.validation.SResult;
import org.secdfd.model.NamedEntity;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

/**
 * @author katjat
 *
 */

@RunWith(Parameterized.class)
public class ContractEvaluator {
	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final Logger LOGGER = Logger.getLogger(ContractEvaluator.class);

	private Mapper mapper;
	private ContractCheck checker;
	private ContractInjector injector;
	private Set<Responsibility> injected;
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
		try {
			this.checker = new ContractCheck(mapper.getGravityFolder(), mapper.getPM(), Collections.singleton(mapper),
					"encrypt-signatures.txt", "decrypt-signatures.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("contracts"),
				mapper.getDFD().getName(), new NullProgressMonitor());
		this.absenceGT = absenceGT;
		this.convergenceGT = convergenceGT;
		this.injector = new ContractInjector(output, new HashMap<>(), mapper, absenceGT, convergenceGT);
		this.injected = new HashSet<>();
		this.truePositives = new HashSet<>();
		this.falsePositives = new HashSet<>();
		this.falseNegatives = new HashSet<>();
		LOGGER.info("Start validation with: " + testName);
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 * First inject contracts, then validate Decrypt
	 */
	@Test
	public void injectAndValdiateDecrypt() throws IOException, CoreException {
		injector.getInjectTask().put(ResponsibilityType.DECRYPT, 5);
		try {
			absenceGT = injector.performTasks();
			injected = injector.getInjected();
			checker.checkDecryptContract();
		} catch (IOException e) {
			e.printStackTrace();
		}
		validateContract("injected-decrypt-results");
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 * First inject contracts, then validate Encrypt
	 */
	@Test
	public void injectAndValdiateEncrypt() throws IOException, CoreException {
		injector.getInjectTask().put(ResponsibilityType.ENCRYPT_OR_HASH, 5);
		try {
			absenceGT = injector.performTasks();
			injected = injector.getInjected();
			checker.checkEncryptContract();
		} catch (IOException e) {
			e.printStackTrace();
		}
		validateContract("injected-encrypt-results");
	}
	
	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 * First inject contracts, then validate Join
	 */
	@Test
	public void injectAndValdiateJoin() throws IOException, CoreException {
		injector.getInjectTask().put(ResponsibilityType.JOINER, 5);
		absenceGT = injector.performTasks();
		injected = injector.getInjected();
		checker.checkJoinContract();
		validateContract("injected-join-results");
	}
	
	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 * First inject contracts, then validate Encrypt
	 */
	@Test
	public void injectAndValdiateForwards() throws IOException, CoreException {
		injector.getInjectTask().put(ResponsibilityType.FORWARD, 5);
		absenceGT = injector.performTasks();
		injected = injector.getInjected();
		checker.checkForwardContract();
		validateContract("injected-forward-results");
	}
	
	/**
	 * Run checks for decrypt contracts
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void valdiateDecrypt() throws IOException, CoreException {
		try {
			checker.checkDecryptContract();
		} catch (IOException e) {
			e.printStackTrace();
		}
		validateContract("decrypt-results");
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void valdiateEncrypt() throws IOException, CoreException {
		try {
			checker.checkEncryptContract();
		} catch (IOException e) {
			e.printStackTrace();
		}
		validateContract("encrypt-results");
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void valdiateForward() throws IOException, CoreException {
		checker.checkForwardContract();
		validateContract("forward-results");
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void valdiateJoin() throws IOException, CoreException {
		checker.checkJoinContract();
		validateContract("join-results");
	}

	/**
	 * @throws CoreException
	 */
	private void validateContract(String resultFileName) throws CoreException {
		Set<SResult> results = checker.getProblems();
		String SecDFDName = mapper.getDFD().getName();

		// count TP,FP,FN
		results.forEach(result -> {
			countTPandFP(result, SecDFDName);
		});
		if (!results.isEmpty())
			countFN(results, SecDFDName);

		accummulatedTP += truePositives.size();
		accummulatedFP += falsePositives.size();
		accummulatedFN += falseNegatives.size();

		// build a string
		Collection<String> toWrite = ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives);
		if (injected.size() > 0) {
			toWrite.add("\nInjected " + injected.size() + " responsibilities: \n");
			for (Responsibility r : injected) {
				toWrite.add("Name: " + r.getName() + ", Process: " + r.getProcess().getName() + ", Incoming assets: "
						+ r.getIncomeassets().toString() + ", Ougoing assets: " + r.getOutcomeassets().toString()
						+ "\n");
			}

		}
		// log to file
		ExperimentHelper.writeToTxt(output, toWrite, resultFileName, new NullProgressMonitor(), false);
	}

	// ========================================================================

	/**
	 * @param problem
	 * @param secdfdName
	 */
	private void countTPandFP(SResult problem, String secdfdName) {
		String resultState = problem.getState().toString();
		switch (resultState) {
		case "WARNING":
			count(problem, secdfdName, absenceGT);
			break;
		case "SUCCESS":
			count(problem, secdfdName, convergenceGT);
			break;
		default:
			LOGGER.info("Not supported result state: " + resultState);
			break;
		}
	}

	/**
	 * @param problem
	 * @param secdfdName
	 * @param groundtruth
	 */
	private void count(SResult problem, String secdfdName, Map<String, List<Map<String, String>>> groundtruth) {
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
	 * @param results
	 * @param secdfdName
	 * @param encryptOrHash
	 */
	private void countFN(Set<SResult> results, String secdfdName) {
		countFN(results, secdfdName, absenceGT, "absence");
		countFN(results, secdfdName, convergenceGT, "convergence");
	}

	/**
	 * @param results
	 * @param secdfdName
	 * @param groundtruth
	 * @param FNType
	 * @param contractType
	 */
	private void countFN(Set<SResult> results, String secdfdName, Map<String, List<Map<String, String>>> groundtruth,
			String FNType) {
		String ctype = results.parallelStream().findAny().get().getType().getName().toLowerCase();

		List<Map<String, String>> entries = groundtruth.get(ctype);

		if (entries != null) {
			for (Map<String, String> expectedTP : entries) {
				if (expectedTP.get("secdfd").equals(secdfdName)) {
					Set<SResult> matches = new HashSet<SResult>();
					for (SResult result : results) {
						String dfdString = MappingLabelProvider.prettyPrint(result.getDfdElement()).toLowerCase();
						dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
						if (dfdString.equals(expectedTP.get("element")))
							matches.add(result);

					}
					if (matches.isEmpty())
						addFN(FNType, ctype, expectedTP);
				}

			}
		} else {
			LOGGER.info("Ground truth does not contain any expected TPS for this contract.");
		}

	}

	/**
	 * @param problem
	 * @param dfdElementName
	 */
	private void addTP(SResult problem, String dfdElementName) {
		truePositives.add("Problem type: " + problem.getType().toString() + ", Problem state: " + problem.getState()
				+ ", Element: " + dfdElementName);
	}

	/**
	 * @param problem
	 * @param dfdElementName
	 */
	private void addFP(SResult problem, String dfdElementName) {
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
