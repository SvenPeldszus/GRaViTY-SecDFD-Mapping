package org.gravity.flowdroid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
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
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.model.Asset;
import org.secdfd.model.Objective;
import soot.jimple.infoflow.results.InfoflowResults;

@RunWith(Parameterized.class)
public class DataFlowExperiment {
	public enum TestCaseID {
		FDSourceSink, FDSourceOptSink, OptSourceSink, OptSourceSinkInject;
	}

	private static final int MAX_VIOLATION = 10;
	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperiment.class);
	public static Integer accummulatedTP = 0;
	public static Integer accummulatedFP = 0;
	public static Integer accummulatedFN = 0;
	public static Integer accFNAllowedSinks = 0;

	private Mapper mapper;
	private IJavaProject project;
	private IFolder output;
	private static DataFlowExperimentMeasurer measurer;

	public DataFlowExperiment(String testName, Mapper mapper, IJavaProject project, DataFlowExperimentMeasurer measurer)
			throws CoreException {
		this.mapper = mapper;
		this.project = project;
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("dataflow"),
				mapper.getDFD().getName(), new NullProgressMonitor());
		DataFlowExperiment.measurer = measurer;
		LOGGER.info("Start experiment with: " + testName);
	}

	//@Test
	public void experimentFlowDroidConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		Set<String> sources = dfAnalysis.getSas().getBaselineSources();
		Set<String> sinks = dfAnalysis.getSas().getBaselineSinks();
		Set<String> epoints = dfAnalysis.getSas().getEntryPoints();

		Map<String, InfoflowResults> results = dfAnalysis.check(sources, sinks, epoints);

		NullProgressMonitor monitor = new NullProgressMonitor();
		IFolder out = ExperimentHelper.create(output, "flowDroid", monitor);
		write(out, sources, sinks, epoints, monitor);

		measurer.setCurrentExperimentResults(TestCaseID.FDSourceSink, mapper.getDFD().getName(), results, out);

		for (Entry<String, InfoflowResults> entry : results.entrySet()) {
			writeReport(out, entry.getKey(), entry.getValue());
		}

	}

	/**
	 * Run as JUnit plugin test
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void experimentOurConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);
		//inject 0 leaks
		Results results = dfAnalysis.checkAllAssets(0);

		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "our", monitor);
		writeResults(results, destination, monitor);

		measurer.setCurrentExperimentResults(TestCaseID.OptSourceSink, mapper.getDFD().getName(), results, destination);
	}

	@Test
	public void experimentOurConfigInjectLeaks() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);
		
		//try to inject 5 leaks in total
		Results results = dfAnalysis.checkAllAssets(5);
		
		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "our", monitor);
		writeResults(results, destination, monitor);

		measurer.setCurrentExperimentResults(TestCaseID.OptSourceSinkInject, mapper.getDFD().getName(), dfAnalysis.getPossibleLeaks(), results, destination);
	}

	//@Test
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
					results.add(new AssetResults(asset, sources, sinks, allResults));
				}
			}
		}
		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder destination = ExperimentHelper.create(output, "flowDroidAndOurSources", monitor);
		writeResults(results, destination, monitor);

		measurer.setCurrentExperimentResults(TestCaseID.FDSourceOptSink, mapper.getDFD().getName(), results,
				destination);

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
				// build the project to analyze
				project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

				// paths for secdfd-gravity tool, setup correspondence model, mapper, dfd
				IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);
				ExperimentHelper.create(gravity, "dataflow", monitor);
				ExtensionFileVisitor visitor = new ExtensionFileVisitor(".corr.xmi");
				gravity.accept(visitor);

				// create measurer class instance
				DataFlowExperimentMeasurer m = new DataFlowExperimentMeasurer();

				for (Path corr : visitor.getFiles()) {
					String corrModelFileName = corr.getFileName().toString();
					Mapper mapper = new Mapper(gravity.getFile(corrModelFileName));
					data.add(new Object[] { project.getName() + " -> " + corrModelFileName, mapper, javaProject, m });
				}
			} catch (CoreException | IOException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		return data;
	}

	/**
	 * @param dfAnalysis
	 * @param results
	 * @param destination
	 * @throws CoreException
	 */
	@AfterClass
	public static void measureTestConfigurations() throws CoreException {
		// TODO: count measures compared to GT (which is a secure model - no violation)
		// ->inject leaks into models, compare to GT with a injected leaks
		measurer.calculateMeasures();
		for (TestCaseID id : measurer.getExecutedTestCaseIDs()) {
			System.out.println("Summary for configuration run: " + id + "\n=============================\n");
			Map<String, Set<String>> tps = measurer.getTruePositives().get(id);
			Map<String, Set<String>> fps = measurer.getFalsePositives().get(id);
			Map<String, Set<String>> fns = measurer.getFalseNegatives().get(id);
			
			for (String secdfdName : tps.keySet()){
				String fpsprint = "";
				for (String pair : fps.get(secdfdName)) {
					fpsprint+="\nSource: " + pair.split(", ")[0] + "\nSink: "+ pair.split(", ")[1];
				}				
				System.out.print("Secdfd: " + secdfdName + "\nTP = " + tps.get(secdfdName).size() + "\n" + "FP = " + fps.get(secdfdName).size()
						+ "\n" + "FN = " + fns.get(secdfdName).size() + "\n" + fpsprint +"\n");

			}

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
