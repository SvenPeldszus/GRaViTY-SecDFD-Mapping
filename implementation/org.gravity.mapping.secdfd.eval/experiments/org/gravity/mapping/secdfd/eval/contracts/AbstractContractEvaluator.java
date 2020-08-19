/**
 * 
 */
package org.gravity.mapping.secdfd.eval.contracts;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.gravity.eclipse.io.ExtensionFileVisitor;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.eclipse.util.JavaProjectUtil;
import org.gravity.mapping.secdfd.checks.ICheck;
import org.gravity.mapping.secdfd.eval.contracts.injection.ChangeInjector;
import org.gravity.mapping.secdfd.eval.contracts.injection.ExpectedError;
import org.gravity.mapping.secdfd.eval.flowdroid.ExperimentHelper;
import org.gravity.mapping.secdfd.eval.flowdroid.GroundTruthParser;
import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;

/**
 * @author katjat
 *
 */

@RunWith(Parameterized.class)
public abstract class AbstractContractEvaluator {
	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security", "iTrust21.0" };
	private static final Logger LOGGER = Logger.getLogger(AbstractContractEvaluator.class);

	protected Mapper mapper;
	protected ICheck checker;
	protected ChangeInjector injector;
	private IFolder output;

	private static EvaluationResults data = new EvaluationResults();

	/**
	 * @param testName
	 * @param mapper
	 * @param absenceGT
	 * @param convergenceGT
	 * @throws CoreException
	 */
	public AbstractContractEvaluator(String testName, ICheck checker, Mapper mapper, ChangeInjector injector)
			throws CoreException {
		this.mapper = mapper;
		this.checker = checker;
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("contracts"),
				mapper.getDFD().getName(), new NullProgressMonitor());
		this.injector = injector;
		LOGGER.info("Start validation with: " + testName);
	}

	/**
	 * @throws IOException
	 * @throws CoreException
	 * 
	 *                       First inject contracts, then validate Join
	 */
	@Test
	public void eval() throws CoreException {
		System.out.println("\n Start experiment on: " + mapper.getDFD().getName());

		List<SResult> initialErrors = checker.check(mapper).parallelStream()
				.filter(p -> PState.ERROR.equals(p.getState())).collect(Collectors.toList());
		assertTrue("Expected an initially sound implementatrion of the DFD but detected: " + initialErrors,
				initialErrors.isEmpty());

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(mapper.getDFD().eResource());
		CommandStack commandStack = domain.getCommandStack();

		Entry<ExpectedError, Command> change;
		while ((change = injector.next()) != null) {
			Command command = change.getValue();
			commandStack.execute(command);
//			System.out.println("\nPerfrom Cange: " + command.getLabel() + " - " + command.getDescription());

			runAndValidate(change);

			while (commandStack.canUndo()) {
				commandStack.undo();
			}
		}
	}

	/**
	 * @param change
	 * @return 
	 */
	private boolean runAndValidate(Entry<ExpectedError, Command> change) {
		Set<SResult> problems = runAndGetErrors();

		ExpectedError description = change.getKey();
		boolean success = validateContract(problems, description, "injected-join-results");
		return success;
	}

	/**
	 * Collects the projects specified in the constant PROJECT_NAMES for execution
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

	/**
	 * @return
	 */
	protected Set<SResult> runAndGetErrors() {
		Collection<SResult> allResults = checker.check(mapper);
		Set<SResult> errors = allResults.parallelStream().filter(p -> PState.ERROR.equals(p.getState()))
				.collect(Collectors.toSet());
		return errors;
	}

	/**
	 * @param expectedError
	 * @return
	 * @throws CoreException
	 */
	protected boolean validateContract(Set<SResult> results, ExpectedError expectedError, String resultFileName) {
		if (results.isEmpty()) {
			data.fn(mapper.getDFD().getName());
			System.out.println("Expected Error: " + expectedError.getDescription());
			System.out.println("False Negative");
			return false;
		}
		boolean detected = false;
		boolean success = true;
		for (SResult result : results) {
			if (expectedError.isDetected(result)) {
				detected = true;
//					System.out.println("Expected Error: " + expectedError.getDescription());
//					System.out.println("True Positive: " + result.getDescription());
				data.tp(mapper.getDFD().getName());
			} else {
				data.fp(mapper.getDFD().getName());
				System.out.println("Expected Error: " + expectedError.getDescription());
				System.out.println("False Positive: " + result.getDescription());
				success = false;
			}
		}
		if (!detected) {
			System.out.println("False Negative");
			data.fn(mapper.getDFD().getName());
			return false;
		}
		return success;
	}

	@AfterClass
	public static void printSummary() {
		printSummary(data);
	}

	public static void printSummary(EvaluationResults data) {
		String[] keys = data.getRecordedKeys().toArray(new String[0]);
		System.out.println();
		System.out.println("########################");
		System.out.println("#### Result Summary ####");
		System.out.println("########################");
		System.out.print("\n\t\t& ");
		for (String key : keys) {
			System.out.print(key + "\t& ");
		}
		System.out.println("Sum \\");

		System.out.print("TPs\t\t& ");
		for (String key : keys) {
			System.out.print(data.getTruePositives(key) + "\t\t\t& ");
		}
		int sumTruePositives = data.getSumTruePositives();
		System.out.println(sumTruePositives+"\\");

		System.out.print("FPs\t\t& ");
		for (String key : keys) {
			System.out.print(data.getFalsePositives(key) + "\t\t\t& ");
		}
		int sumFalsePositives = data.getSumFalsePositives();
		System.out.println(sumFalsePositives+"\\");

		System.out.print("FNs\t\t& ");
		for (String key : keys) {
			System.out.print(data.getFalseNegatives(key) + "\t\t\t& ");
		}
		int sumFalseNegatives = data.getSumFalseNegatives();
		System.out.println(sumFalseNegatives+"\\");

		System.out.print("precision\t& ");
		for (String key : keys) {
			int accummulatedTP = data.getTruePositives(key);
			int accummulatedFP = data.getFalsePositives(key);
			System.out.print(((double) accummulatedTP) / (accummulatedFP + accummulatedTP) + "\t& ");
		}
		System.out.println(((double) sumTruePositives) / (sumFalsePositives + sumTruePositives)+"\\");

		System.out.print("recall\t\t& ");
		for (String key : keys) {
			int accummulatedTP = data.getTruePositives(key);
			int accummulatedFN = data.getFalseNegatives(key);
			System.out.print(((double) accummulatedTP) / (accummulatedFN + accummulatedTP) + "\t& ");
		}
		System.out.println(((double) sumTruePositives) / (sumFalseNegatives + sumTruePositives)+"\\");
	}

}
