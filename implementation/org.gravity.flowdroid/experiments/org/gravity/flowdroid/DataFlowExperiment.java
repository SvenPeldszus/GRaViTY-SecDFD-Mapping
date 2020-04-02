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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.secdfd.model.Asset;
import org.secdfd.model.Objective;

import soot.jimple.infoflow.results.InfoflowResults;

@RunWith(Parameterized.class)
public class DataFlowExperiment {

	private static final int MAX_VIOLATION = 10;
	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperiment.class);

	private Mapper mapper;
	private IJavaProject project;
	private IFolder output;

	public DataFlowExperiment(String testName, Mapper mapper, IJavaProject project) throws CoreException {
		this.mapper = mapper;
		this.project = project;
		this.output = ExperimentHelper.create(mapper.getGravityFolder().getFolder("dataflow"), mapper.getDFD().getName(), new NullProgressMonitor());
		LOGGER.info("Start experiment with: " + testName);
	}

	/**
	 * Run as JUnit plugin test
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void experimentOurConfig() throws IOException, CoreException {
		Results results = new DFAnalysis(mapper, project, true, MAX_VIOLATION).checkAllAssets();

		IProgressMonitor monitor = new NullProgressMonitor();
		writeResults(results, ExperimentHelper.create(output, "our", monitor), monitor);
	}

	@Test
	public void experimentFlowDroidConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		Set<String> sources = dfAnalysis.sas.getBaselineSources();
		Set<String> sinks = dfAnalysis.sas.getBaselineSinks();
		Set<String> epoints = dfAnalysis.sas.getEntryPoints();
		Map<String, InfoflowResults> results = dfAnalysis.check(sources, sinks, epoints);

		NullProgressMonitor monitor = new NullProgressMonitor();
		IFolder out = ExperimentHelper.create(output, "flowDroid", monitor);
		write(out, sources, sinks, epoints, monitor);
		for (Entry<String, InfoflowResults> entry : results.entrySet()) {
			writeReport(out, entry.getKey(), entry.getValue());
		}

	}

	@Test
	public void experimentFlowDroidConfigAndOurSources() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, MAX_VIOLATION);

		SourcesAndSinkFinder finder = new SourcesAndSinkFinder(mapper, true);
		Set<String> sinks = finder.getBaselineSinks();
		Set<String> epoints = dfAnalysis.sas.getEntryPoints();
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
		writeResults(results, ExperimentHelper.create(output, "flowDroidAndOurSources", monitor), monitor);

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
			//empty folder
			//if (assetResultOutputFolder.members().length < 1) {
			//	assetResultOutputFolder.delete(false, monitor);
			//}
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
		//we just wrote an empty file 
		//if (file.length()==0) {
		//	file.delete();
		//}
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
