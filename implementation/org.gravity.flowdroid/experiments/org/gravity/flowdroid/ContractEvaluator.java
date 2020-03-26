/**
 * 
 */
package org.gravity.flowdroid;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
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
import org.gravity.mapping.secdfd.checks.EncryptionCheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.mapping.secdfd.ui.views.MappingLabelProvider;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.dsl.validation.SProblem;
import org.secdfd.model.EDFD;
import org.gravity.typegraph.basic.TMethodDefinition;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperiment.class);

	private Mapper mapper;
	private IJavaProject project;
	private IFolder output;

	private static Map<String, List<Map<String, String>>> absenceGT;
	private static Map<String, List<Map<String, String>>> convergenceGT;
	public static Integer accummulatedTP = 0;
	public static Integer accummulatedFP = 0;
	public static Integer accummulatedFN = 0;
	
	public HashSet<String> truePositives = new HashSet<String>();
	public HashSet<String> falsePositives = new HashSet<String>();
	public HashSet<String> falseNegatives = new HashSet<String>();

	public ContractEvaluator(String testName, Mapper mapper, IJavaProject project) throws CoreException {
		this.mapper = mapper;
		this.project = project;
		IFolder resultOutputFolder = mapper.getGravityFolder().getFolder("contracts")
				.getFolder(mapper.getDFD().getName());
		if (!resultOutputFolder.exists()) {
			resultOutputFolder.create(true, true, new NullProgressMonitor());
		}
		this.output = resultOutputFolder;
		LOGGER.info("Start validation with: " + testName);

	}

	/**
	 * @param problems
	 * @param secdfd
	 */
	private void countFNConvergence(Set<SProblem> problems, EDFD secdfd) {
		// convergence
		for (String ctype : convergenceGT.keySet()) {
			for (Map<String, String> expectedTP : convergenceGT.get(ctype)) {
				if (expectedTP.get("secdfd").equals(secdfd.getName())) {
					Set<SProblem> matches = new HashSet<SProblem>();
					for (SProblem problem : problems) {
						String dfdString = MappingLabelProvider.prettyPrint(problem.getDfdElement()).toLowerCase();
						dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
						if (dfdString.equals(expectedTP.get("element")))
							matches.add(problem);
					}
					if (matches.size() > 0) {
						/*
						for (SProblem match : matches) {
							if (match.getTMethodDefinitions() != null) {
								boolean foundit = false;
								for (TMethodDefinition pmObject : match.getTMethodDefinitions()) {
									// check if also signature matches
									String stringpm = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
									stringpm = stringpm.substring(stringpm.indexOf(':') + 1).replaceAll(" ", "");
									String pmString = stringpm;
									if (pmString.equals(expectedTP.get("signature"))) {
										foundit = true;
									}
								}
								if (!foundit)
									falseNegatives.add(match.getType().toString() + " convergence: "
											+ expectedTP.get("signature") + " <-> " + expectedTP.get("element"));
							}
						}*/
					} else {
						falseNegatives.add(ctype.toUpperCase() + " convergence: " + expectedTP.get("signature")
								+ " <-> " + expectedTP.get("element"));
					}
				}
			}
		}
	}

	/**
	 * @param problems
	 * @param secdfd
	 */
	private void countFNAbsence(Set<SProblem> problems, EDFD secdfd) {
		// absence
		for (String ctype : absenceGT.keySet()) {
			for (Map<String, String> expectedTP : absenceGT.get(ctype)) {
				if (expectedTP.get("secdfd").equals(secdfd.getName())) {
					Set<SProblem> matches = new HashSet<SProblem>();
					for (SProblem problem : problems) {
						String dfdString = MappingLabelProvider.prettyPrint(problem.getDfdElement()).toLowerCase();
						dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
						if (dfdString.equals(expectedTP.get("element")))
							matches.add(problem);
					}
					if (matches.size() < 1)
						falseNegatives.add(ctype.toUpperCase() + " absence: " + expectedTP.get("element"));
				}
			}
		}
	}

	private void countTPandFP(SProblem problem, EDFD secdfd) {
		String dfdString = MappingLabelProvider.prettyPrint(problem.getDfdElement()).toLowerCase();
		dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");

		// absence
		if (problem.getState().toString().equals("WARNING")) {
			checkAbsence(problem, secdfd, dfdString);
			// convergence
		} else if (problem.getState().toString().equals("OK")) {
			//if (problem.getTMethodDefinitions() != null)
				checkConvergence(problem, secdfd, dfdString);
			//else
			//	LOGGER.info("All SProblems of convergence must have a list of signatures to the mapped elements.");
		} else {
			LOGGER.info("Not supported SProblem type yet: " + problem.getState().toString());
		}

	}

	/**
	 * @param problem
	 * @param secdfd
	 * @param dfdString
	 * @param ctype
	 */
	private void checkConvergence(SProblem problem, EDFD secdfd, String dfdString) {
		String ctype = problem.getType().toString().toLowerCase();
		String stringpm;
		if (convergenceGT.get(ctype) == null) {
			// FP
			falsePositives.add(problem.getType().toString() + " convergence: " + dfdString);
			return;
		}
		Set<Map<String, String>> matches = convergenceGT.get(ctype).parallelStream()
				.filter(c -> c.get("secdfd").equals(secdfd.getName())).filter(c -> c.get("element").equals(dfdString))
				.collect(Collectors.toSet());
		if (matches.size() > 0) {
			truePositives.add(problem.getType().toString() + " convergence: " + dfdString);
			/*
			for (TMethodDefinition pmObject : problem.getTMethodDefinitions()) {
				// check if also signature matches
				stringpm = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
				stringpm = stringpm.substring(stringpm.indexOf(':') + 1).replaceAll(" ", "");
				String pmString = stringpm;
				Set<Map<String, String>> refinedmatches = matches.parallelStream()
						.filter(c -> c.get("signature").equals(pmString)).collect(Collectors.toSet());
				if (refinedmatches.size() > 0) {
					truePositives.add(problem.getType().toString() + " convergence: " + pmString + " <-> " + dfdString);
				} else {
					falsePositives
							.add(problem.getType().toString() + " convergence: " + pmString + " <-> " + dfdString);
				}
			}*/
		} else {
			falsePositives.add(problem.getType().toString() + " convergence: " + dfdString);
		}
	}

	/**
	 * @param problem
	 * @param secdfd
	 * @param dfdString
	 * @param ctype
	 */
	private void checkAbsence(SProblem problem, EDFD secdfd, String dfdString) {
		String ctype = problem.getType().toString().toLowerCase();
		if (absenceGT.get(ctype) == null) {
			// FP
			falsePositives.add(problem.getType().toString() + " absence: " + dfdString);
			return;
		}
		Set<Map<String, String>> matches = absenceGT.get(ctype).parallelStream()
				.filter(c -> c.get("secdfd").equals(secdfd.getName())).filter(c -> c.get("element").equals(dfdString))
				.collect(Collectors.toSet());
		if (matches.size() > 0) {
			// there can be only one absence for a particular contract on particular secdfd
			// element
			truePositives.add(problem.getType().toString() + " absence: " + dfdString);
		} else {
			falsePositives.add(problem.getType().toString() + " absence: " + dfdString);
		}
	}

	private static void parseGroundTruth(File file) {
		if (file.exists()) {
			try {
				JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
				for (JsonElement contract : object.getAsJsonArray("contracts")) {
					if (contract instanceof JsonObject) {
						for (Entry<String, JsonElement> e : ((JsonObject) contract).entrySet()) {
							String ctype = e.getKey();
							if (((JsonObject) contract).get(e.getKey()) != null) {
								for (JsonElement entry : ((JsonObject) contract).get(ctype).getAsJsonArray()) {
									processJsonEntry(ctype, entry);
								}

							}
						}

					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param ctype
	 * @param entry
	 */
	private static void processJsonEntry(String ctype, JsonElement entry) {
		if (entry instanceof JsonObject) {
			// parse entry of GT
			HashMap<String, String> newitem = new HashMap<String, String>();
			newitem.put("secdfd", ((JsonObject) entry).get("secdfd").getAsString().toLowerCase().replaceAll(" ", ""));
			newitem.put("element", ((JsonObject) entry).get("element").getAsString().toLowerCase().replaceAll(" ", ""));
			if (((JsonObject) entry).keySet().contains("signature")) {
				// convergence
				newitem.put("signature",
						((JsonObject) entry).get("signature").getAsString().toLowerCase().replaceAll(" ", ""));
				updateGTmap(ctype, newitem, true);
			} else {
				// absence
				updateGTmap(ctype, newitem, false);

			}
		}
	}

	/**
	 * @param ctype
	 * @param newitem
	 * @param update
	 */
	private static void updateGTmap(String ctype, HashMap<String, String> newitem, boolean convergence) {
		List<Map<String, String>> items = null;
		if (convergence)
			items = convergenceGT.get(ctype);
		else
			absenceGT.get(ctype);
		if (items != null) {
			items.add(newitem);
		} else {
			items = new ArrayList<Map<String, String>>();
			items.add(newitem);
		}
		if (convergence)
			items = convergenceGT.put(ctype, items);
		else
			absenceGT.put(ctype, items);
	}

	/**
	 * @throws IOException   Run checks for encrypt and decrypt
	 * @throws CoreException
	 */
	@Test
	public void runEncryptDecryptChecks() throws IOException, CoreException {
		// run checks
		EncryptionCheck checker = new EncryptionCheck(mapper.getGravityFolder(), mapper.getPM(),
				Collections.singleton(mapper));
		checker.checkSecurityContracts();
		Set<SProblem> problems = checker.getProblems();
		// count TP,FP,FN
		for (SProblem p : problems) {
			if (p.getType().toString().equals("ENCRYPT") || p.getType().toString().equals("DECRYPT")) {
				countTPandFP(p, mapper.getDFD());
			} else
				LOGGER.info("Not supported SProblem type yet: " + p.getState().toString());
		}
		countFNAbsence(problems, mapper.getDFD());
		countFNConvergence(problems, mapper.getDFD());

		accummulatedTP+=truePositives.size();
		accummulatedFP+=falsePositives.size();
		accummulatedFN+=falseNegatives.size();
		// log to file
		ExperimentHelper.writeToTxt(output,
				ExperimentHelper.stringBuilder(truePositives, falsePositives, falseNegatives), "results",
				new NullProgressMonitor(), false);
	}

	/**
	 * @param project
	 */
	public static void readGT(IJavaProject project) {
		File absenceGTf = project.getProject()
				.getFile("groundtruth/contracts/" + project.getResource().getName() + "_absence.json").getLocation()
				.toFile();
		File convergenceGTf = project.getProject()
				.getFile("groundtruth/contracts/" + project.getResource().getName() + "_convergence.json").getLocation()
				.toFile();
		// parse the JSON file into groundtruth
		absenceGT = new HashMap<String, List<Map<String, String>>>();
		convergenceGT = new HashMap<String, List<Map<String, String>>>();
		parseGroundTruth(absenceGTf);
		parseGroundTruth(convergenceGTf);
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

				// read the ground truth
				readGT(javaProject);
				// append to object array, added to the data: for every entry also add parameter to the constructor

				ExtensionFileVisitor visitor = new ExtensionFileVisitor(".corr.xmi");
				gravity.accept(visitor);
				for (Path corr : visitor.getFiles()) {
					String corrModelFileName = corr.getFileName().toString();
					Mapper mapper = new Mapper(gravity.getFile(corrModelFileName));
					data.add(new Object[] { project.getName() + " -> " + corrModelFileName, mapper, javaProject });
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
