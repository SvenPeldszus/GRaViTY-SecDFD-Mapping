package org.gravity.mapping.secdfd.eval.flowdroid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.io.ExtensionFileVisitor;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.eclipse.util.JavaProjectUtil;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.AssetResults;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.DFAnalysis;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.Results;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SignatureHelper;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SourceAndSink;
import org.gravity.mapping.secdfd.checks.impl.flowdroid.SourcesAndSinkFinder;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.Flow;
import org.secdfd.model.Objective;
import soot.jimple.infoflow.results.InfoflowResults;

@RunWith(Parameterized.class)
public class DataFlowExperiment {
	public enum TestCaseID {
		FDSourceSink, OptSourceFDSink, FDSourceOptSink, OptSourceSink, OptSourceSinkInjectLabels;
	}

	private static final int MAX_VIOLATION = 10;
//	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final String[] PROJECT_NAMES = new String[] { "iTrust21.0" };
//	private static final String[] PROJECT_NAMES = new String[] { "jpetstore" }; // can inject 3
//	private static final String[] PROJECT_NAMES = new String[] { "ATMsimulator" }; // no violations in any, injected 1
//	private static final String[] PROJECT_NAMES = new String[] { "cocome-impl" }; // no violations in any, injected 0 (nothing leaves the system)
//	private static final String[] PROJECT_NAMES = new String[] { "JPMail" }; // no correspondence model
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperiment.class);

	private Mapper mapper;
	private IJavaProject project;
	private IFolder output;
	private static Map<IJavaProject, DataFlowExperimentMeasurer> projectMeasurers;

	/**
	 * 
	 * @param testName
	 * @param mapper
	 * @param project
	 * @param measurer
	 * @throws CoreException
	 */
	public DataFlowExperiment(String testName, Mapper mapper, IJavaProject project,
			Map<IJavaProject, DataFlowExperimentMeasurer> measurers) throws CoreException {
		this.mapper = mapper;
		this.project = project;
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("dataflow"),
				mapper.getDFD().getName(), new NullProgressMonitor());
		DataFlowExperiment.projectMeasurers = measurers;
		LOGGER.info("Start experiment with: " + testName);
	}

	/**
	 * Base line, experiment with SuSi sources, SuSi sinks
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void experimentFlowDroidConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		Set<String> sources = dfAnalysis.getSas().getBaselineSources();
		Set<String> sinks = dfAnalysis.getSas().getBaselineSinks();
		Set<String> epoints = dfAnalysis.getSas().getEntryPoints();

		Map<String, InfoflowResults> results = dfAnalysis.check(sources, sinks, epoints);

		NullProgressMonitor monitor = new NullProgressMonitor();
		IFolder out = ExperimentHelper.create(output, "flowDroid", monitor);
		write(out, sources, sinks, epoints, monitor);

		projectMeasurers.get(project).setCurrentExperimentResults(TestCaseID.FDSourceSink, mapper.getDFD().getName(),
				results, sources, sinks);
	}

	/**
	 * Experiment with SecDFD sources, and SecDFD sinks
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void experimentOurConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);
		Results results = dfAnalysis.checkAllAssets();

		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "our", monitor);
		writeResults(results, destination, monitor);

		projectMeasurers.get(project).setCurrentExperimentResults(TestCaseID.OptSourceSink, mapper.getDFD().getName(),
				results);
	}

	/**
	 * Experiment with SecDFD sources, SuSi sinks
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void experimentFlowDroidConfigAndOurSources() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		SourcesAndSinkFinder finder = new SourcesAndSinkFinder(mapper, true);
		Set<String> sinks = finder.getBaselineSinks();
		Set<String> epoints = dfAnalysis.getSas().getEntryPoints();
		Results results = new Results();
		for (Asset asset : mapper.getDFD().getAsset()) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
				SourceAndSink sourceSinks = finder.getSourceSinks(asset);
				if (sourceSinks != null) {
					Set<String> sources = sourceSinks.getSources();
					Map<String, InfoflowResults> allResults = dfAnalysis.check(sources, sinks, epoints);
					results.add(new AssetResults(asset, sources, sinks, Collections.emptySet(), allResults,
							Collections.emptySet()));
				}
			}
		}
		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "flowDroidAndOurSources", monitor);
		writeResults(results, destination, monitor);

		projectMeasurers.get(project).setCurrentExperimentResults(TestCaseID.OptSourceFDSink, mapper.getDFD().getName(),
				results);

	}

	/**
	 * Experiment with SecDFD derived source and sinks, injection of high labels --
	 * this should be compared to OptSources + FD sinks, else wont make sense...
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	// @Test
	public void experimentOurconfigInjectLabels() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		// try to inject labels
		Results results = dfAnalysis.checkAllAssetsInject();

		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "ourinject", monitor);
		writeResults(results, destination, monitor);

		projectMeasurers.get(project).setCurrentExperimentResults(TestCaseID.OptSourceSinkInjectLabels,
				mapper.getDFD().getName(), dfAnalysis.getTPInjectedLeaks(), results);// TODO: add also FN and FP
	}

	@Test
	public void experimentOurconfigRemoveFlows() throws IOException, CoreException {
		EDFD dfd = mapper.getDFD();
		Set<Flow> candidates = dfd.getElements().parallelStream().filter(el -> (el instanceof DataStore))
				.flatMap(ds -> ds.getInflows().stream()).collect(Collectors.toSet());

		if (!candidates.isEmpty()) {
			Set<String> originalResults = null;
			try {
				DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);
				originalResults = projectMeasurers.get(project)
						.flattenAssetResultsForSecDFD(dfAnalysis.checkAllAssets());
			} catch (JavaModelException | IOException e) {
				throw new IllegalStateException("Initial run failed", e);
			}

			int injections = 0;
			int falsePositives = 0;
			int truePositives = 0;
			int falseNegatives = 0;

			for (Flow candidate : candidates) {
				for (Asset asset : new HashSet<>(candidate.getAssets())) {
					if (asset.getValue().stream()
							.anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
						candidate.getAssets().remove(asset);

						try {
							Set<String> tp = new HashSet<>();
							Set<String> fp = new HashSet<>();
							Set<String> fn = new HashSet<>();

							executeAndValidate(candidate, asset, tp, fp, fn, originalResults);

							injections++;
							truePositives += tp.size();
							falsePositives += fp.size();
							falseNegatives += fn.size();

						} catch (JavaModelException | IOException e) {
							e.printStackTrace();
						}
						candidate.getAssets().add(asset);
					}
				}
			}
			String result = "dfd=" + dfd.getName() + " ,injections=" + injections + ", tp=" + truePositives + ", fp="
					+ falsePositives + ", fn=" + falseNegatives;
			System.out.println(result);
			Path out = Paths.get("df-results.txt");
			System.out.println("Writing results to: "+out.toFile().getAbsolutePath());
			Files.write(out,
					result.getBytes(Charset.defaultCharset()),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} else {
			LOGGER.info("Found no candidate flow to remove asset.");
		}
	}

	/**
	 * @param flow
	 * @param asset
	 * @param tp
	 * @param fp
	 * @param fn
	 * @param ignore
	 * @throws IOException
	 * @throws JavaModelException
	 */
	private void executeAndValidate(Flow flow, Asset asset, Set<String> tp, Set<String> fp, Set<String> fn,
			Set<String> ignore) throws IOException, JavaModelException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);
		Results results = dfAnalysis.checkAllAssets();

		Set<String> resultsModifiedFlow = projectMeasurers.get(project).flattenAssetResultsForSecDFD(results);
		resultsModifiedFlow.removeAll(ignore);
		// compare remaining to expected source,sink pair

		Set<Element[]> dfdLevelResults = resultsModifiedFlow.stream().flatMap(result -> {
			String[] sourceSink = result.split(",\\s+");

			TMethodDefinition source = SignatureHelper.getDefinition(mapper.getPM(), sourceSink[0]);
			Set<Element> sources = new HashSet<>(mapper.getMapping(source));
			sources.addAll(mapper.getDataStoreMapping(source.getDefinedBy()));

			TMethodDefinition sink = SignatureHelper.getDefinition(mapper.getPM(), sourceSink[1]);
			Set<Element> sinks = new HashSet<>(mapper.getMapping(sink));
			sinks.addAll(mapper.getDataStoreMapping(sink.getDefinedBy()));

			Set<Element[]> stream = new HashSet<>();
			for (Element s : sources) {
				if (sinks.isEmpty()) {
					fp.add(s.getName() + ", " + source.getSignatureString());
				}
				for (Element t : sinks) {
					stream.add(new Element[] { s, t });
				}
			}
			return stream.stream();
		}).collect(Collectors.toSet());

		Element expectedSource = asset.getSource();
		Element expectedSink = flow.getTarget().get(0);

		boolean found = false;
		for (Element[] result : dfdLevelResults) {
			if (result[0] == expectedSource && result[1] == expectedSink) {
				found = true;
				tp.add(result[0].getName() + ", " + result[1].getName());
			} else {
				fp.add(result[0].getName() + ", " + result[1].getName());
			}
		}
		if (!found) {
			fn.add(expectedSource.getName() + ", " + expectedSink.getName());
		}
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
		HashMap<IJavaProject, DataFlowExperimentMeasurer> projectM = new HashMap<>();

		for (String projectName : PROJECT_NAMES) {
			try {
				IProject project = EclipseProjectUtil.getProjectByName(projectName);
				IJavaProject javaProject = JavaProjectUtil.getJavaProject(project);
				if (!javaProject.isOpen()) {
					javaProject.open(monitor);
				}
				// build the project to analyze
				project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

				// paths for secdfd-gravity tool, setup correspondence model, mapper, dfd
				IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);
				ExperimentHelper.create(gravity, "dataflow", monitor);
				ExtensionFileVisitor visitor = new ExtensionFileVisitor(".corr.xmi");
				gravity.accept(visitor);

				// create measurer class instance
				DataFlowExperimentMeasurer m = new DataFlowExperimentMeasurer();
				projectM.put(javaProject, m);

				for (Path corr : visitor.getFiles()) {
					String corrModelFileName = corr.getFileName().toString();
					Mapper mapper = new Mapper(gravity.getFile(corrModelFileName));
					data.add(new Object[] { project.getName() + " -> " + corrModelFileName, mapper, javaProject,
							projectM });
				}
			} catch (CoreException | IOException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		return data;
	}

	/**
	 * For each analyzed project this method counts the tps,fps,fns and creates a
	 * String 'build', saving it to report file. Also creates a local map for
	 * counting all the tps,fps,fns for each executed configuration, prints it to
	 * the standard output.
	 */
	@AfterClass
	public static void measureTestConfigurations() throws CoreException {
		IProgressMonitor monitor = new NullProgressMonitor();
		Map<String, ArrayList<Integer>> perConfig = new HashMap<>();

		// print name of all executed projects
		System.out.print("Max violation: " + MAX_VIOLATION + ", Analyzed projects:\n");
		for (IJavaProject measuredProject : projectMeasurers.keySet()) {
			IProject measuredIProject = measuredProject.getProject();
			System.out.print(measuredIProject.getName() + "\n");

			DataFlowExperimentMeasurer measurer = projectMeasurers.get(measuredProject);
			measurer.calculateMeasures();

			Map<String, Set<String>> tps = measurer.getTruePositives();
			Map<String, Set<String>> fps = measurer.getFalsePositives();
			Map<String, Set<String>> fns = measurer.getFalseNegatives();

			for (String key : measurer.getExecutedExperiments()) {
				String testcaseid = key.split(", ")[0];
				// String secdfdName = key.split(", ")[1];
				// count per configuration for all projects
				if (!perConfig.containsKey(testcaseid)) {
					ArrayList<Integer> newlist = new ArrayList<Integer>();
					newlist.add(0, 0);
					newlist.add(0, 0);
					newlist.add(0, 0);
					perConfig.put(testcaseid, newlist);
				}
				ArrayList<Integer> list = perConfig.get(testcaseid);
				list.set(0, list.get(0) + tps.get(key).size());
				list.set(1, list.get(1) + fps.get(key).size());
				list.set(2, list.get(2) + fns.get(key).size());

			}

			// summary of configuration run on this project
			for (String testcaseid : measurer.getExecutedExperimentTestCaseIDs()) {
				String build = "";
				build += "Summary for configuration run: " + testcaseid + "\n=============================\n";
				for (String k : fps.keySet().parallelStream().filter(k -> k.split(", ")[0].equals(testcaseid))
						.collect(Collectors.toSet())) {
					build += "\nSecDFD: " + k.split(", ")[1] + "\n TPs: \n";
					for (String pair : tps.get(k)) {
						build += pair + "\n";
					}
					build += "\n FPs: \n";
					for (String pair : fps.get(k)) {
						build += pair + "\n";
					}
					build += "\nTP: " + tps.get(k).size() + "\n";
					build += "FP: " + fps.get(k).size() + "\n";
					build += "FN: " + fns.get(k).size() + "\n";

				}

				// write report file for current project
				IFolder reportFolder = measuredIProject.getFolder("report");
				if (!reportFolder.exists()) {
					reportFolder.create(true, true, monitor);
				}
				IFolder configFolder = ExperimentHelper.create(reportFolder, testcaseid.toString(), monitor);
				ExperimentHelper.writeToTxt(configFolder, Collections.singleton(build), measuredIProject.getName(),
						monitor, false);

			}

			// print count of unique sources and sinks per configuration
			Map<String, Set<String>> Usources = measurer.getUniqueSources();
			Map<String, Set<String>> USinks = measurer.getUniqueAllowedSinks();
			Map<String, List<String>> DupSinks = measurer.getAllAllowedSinks();
			System.out.print("Unique source count" + "\n====================+\n");
			for (String key : Usources.keySet()) {
				System.out.println(key + ": " + Usources.get(key).size());
			}
			Set<String> SuSiSinks = measurer.getSuSiSinks();
			System.out.print("Unique removed sinks" + "\n====================+\n");
			for (String key : USinks.keySet()) {
				if (!key.contains("FDSourceSink") && !key.contains("OptSourceFDSink")) {
					// if in allowed && in susisink, then it was removed
					Set<String> intersection = new HashSet<String>(SuSiSinks);
					Set<String> c = USinks.get(key);
					intersection.retainAll(c);
					System.out.println(key + ": ");
					for (String a : intersection) {
						System.out.print(a + ", ");
					}
					System.out.print("\nTotal = " + intersection.size() + "\n");
				}
			}
			System.out.print("Non-unique removed sinks" + "\n====================+\n");
			for (String key : DupSinks.keySet()) {
				if (!key.contains("FDSourceSink") && !key.contains("OptSourceFDSink")) {
					System.out.println(key + ": ");
					// list of duplicates
					int count = 0;
					for (String allowedsink : DupSinks.get(key)) {
						if (SuSiSinks.contains(allowedsink)) {
							System.out.print(allowedsink + ", ");
							count++;
						}
					}
					System.out.print("\nTotal = " + count + "\n");
				}
			}
		}

		// print total per configuration
		for (String k : perConfig.keySet()) {
			Integer tps = perConfig.get(k).get(0);
			Integer fps = perConfig.get(k).get(1);
			Integer fns = perConfig.get(k).get(2);
			System.out.print(
					"\nConfiguration " + k + ":\n" + "TPs = " + tps + ", FPs = " + fps + ", FNs = " + fns + "\n\n");
		}

	}

	/**
	 * Writes the results to the given folder
	 * 
	 * @param results The results object
	 * @param out     The folder to which the results should be written
	 * @param monitor A progress monitor
	 * @throws CoreException
	 * @throws IOException
	 */
	private void writeResults(Results results, IFolder out, IProgressMonitor monitor)
			throws CoreException, IOException {
		for (AssetResults assetResults : results.getResultsPerAsset()) {
			Asset asset = assetResults.getAsset();
			IFolder assetResultOutputFolder = ExperimentHelper.create(out, asset.getName(), monitor);
			write(assetResultOutputFolder, assetResults.getSources(), assetResults.getSinks(),
					assetResults.getEPoints(), monitor);
			for (Entry<String, InfoflowResults> entry : assetResults.getSingleResults()) {
				writeReport(ExperimentHelper.create(assetResultOutputFolder, entry.getKey(), monitor), asset.getName(),
						entry.getValue());
			}
		}
	}

	/**
	 * Prints the results of the analysis
	 * 
	 * @param out     The location to which the results should be written
	 * @param asset   The asset for which the results will be written
	 * @param results The info flow results
	 * @throws IOException
	 */
	private void writeReport(IFolder out, String asset, InfoflowResults results) throws IOException {
		// truncate, else too long (Soot signatures)
		String filename = asset + "-FlowDroid-results.txt";
		File file = null;
		if (filename.length() > 200) {
			file = out.getFile(filename.substring(filename.length() - 200)).getLocation().toFile();
		} else {
			file = out.getFile(asset + "-FlowDroid-results.txt").getLocation().toFile();
		}
		if (!file.exists() && !file.createNewFile()) {
			throw new IOException("Couldn't create: " + file.toString());
		}
		try (Writer wr = new FileWriter(file)) {
			results.printResults(wr);
		}
	}

	/**
	 * Writes the sources, sinks and entry points to txt files
	 * 
	 * @param out     The folder in which the files should be stored
	 * @param sources The sources
	 * @param sinks   The sinks
	 * @param epoints The entry points
	 * @param monitor A progress monitor
	 * @throws CoreException
	 */
	private void write(IFolder out, Collection<String> sources, Collection<String> sinks, Collection<String> epoints,
			IProgressMonitor monitor) throws CoreException {
		ExperimentHelper.writeToTxt(out, epoints, "entrypoints", monitor, true);
		ExperimentHelper.writeToTxt(out, sources, "sources", monitor, true);
		ExperimentHelper.writeToTxt(out, sinks, "sinks", monitor, true);
	}

}
