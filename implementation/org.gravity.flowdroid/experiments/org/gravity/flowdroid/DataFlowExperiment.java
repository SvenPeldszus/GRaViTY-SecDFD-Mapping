package org.gravity.flowdroid;

import java.io.ByteArrayInputStream;
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
import java.util.stream.Collectors;
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

	private static final String[] PROJECT_NAMES = new String[] { "org.eclipse.equinox.security" };
	private static final Logger LOGGER = Logger.getLogger(DataFlowExperiment.class);

	private Mapper mapper;
	private IJavaProject project;
	private IFolder output;

	public DataFlowExperiment(String testName, Mapper mapper, IJavaProject project) throws CoreException {
		this.mapper = mapper;
		this.project = project;
		this.output = create(mapper.getGravityFolder(), "dataflow", new NullProgressMonitor());
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
		Results results = new DFAnalysis(mapper, project, true, 1).checkAllAssets();

		IProgressMonitor monitor = new NullProgressMonitor();
		writeResults(results, create(output, "our", monitor), monitor);
	}

	@Test
	public void experimentFlowDroidConfig() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, 1);

		Set<String> sources = dfAnalysis.sas.getBaselineSources();
		Set<String> sinks = dfAnalysis.sas.getBaselineSinks();
		Set<String> epoints = dfAnalysis.sas.getEntryPoints();
		Map<String, InfoflowResults> results = dfAnalysis.check(sources, sinks, epoints);

		NullProgressMonitor monitor = new NullProgressMonitor();
		IFolder out = create(output, "flowDroid", monitor);
		write(out, sources, sinks, epoints, monitor);
		for (Entry<String, InfoflowResults> entry : results.entrySet()) {
			writeReport(out, entry.getKey(), entry.getValue());
		}

	}

	@Test
	public void experimentFlowDroidConfigAndOurSources() throws IOException, CoreException {
		DFAnalysis dfAnalysis = new DFAnalysis(mapper, project, true, 1);

		SourcesAndSinkFinder finder = new SourcesAndSinkFinder(mapper, true);
		Set<String> sinks = finder.getBaselineSinks();
		Set<String> epoints = dfAnalysis.sas.getEntryPoints();
		Results results = new Results();
		for (Asset asset : mapper.getDFD().getAsset()) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> Objective.CONFIDENTIALITY.equals(value.getObjective()))) {
				Set<String> sources = finder.getSourceSinks(asset).getSources();
				Map<String, InfoflowResults> allResults = dfAnalysis.check(sources, sinks, epoints);
				results.add(new AssetResults(asset, sources, sinks, allResults));
			}
		}
		IProgressMonitor monitor = new NullProgressMonitor();
		writeResults(results, create(output, "flowDroidAndOurSources", monitor), monitor);

	}

	/**
	 * Collects the projects specified in the constant PROJECT_NAMES for executint
	 * the experiments on them
	 * 
	 * THIS METHOD SHOULD ONLY BE CALLED BY THE JUNIT RUNNER!
	 * 
	 * @return The experiment data
	 */
	@Parameters
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
			IFolder assetResultOutputFolder = create(out, asset.getName(), monitor);
			write(assetResultOutputFolder, assetResults.getSources(), assetResults.getSinks(),
					assetResults.getEPoints(), monitor);
			for (Entry<String, InfoflowResults> entry : assetResults.getSingleResults()) {
				writeReport(create(assetResultOutputFolder, entry.getKey(), monitor), asset.getName(),
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
		File file = out.getFile(asset + "-FlowDroid-results.txt").getLocation().toFile();
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
		writeToTxt(out, epoints, "entrypoints", monitor);
		writeToTxt(out, sources, "sources", monitor);
		writeToTxt(out, sinks, "sinks", monitor);
	}

	/**
	 * Writes the data to a txt file
	 * 
	 * @param out     The folder in which the file should be stored
	 * @param lines   The lines that should be written to the file
	 * @param name    The name of the file
	 * @param monitor A progress monitor
	 * @throws CoreException
	 */
	private void writeToTxt(IFolder out, Collection<String> lines, String name, IProgressMonitor monitor)
			throws CoreException {
		IFile epointsfile = out.getFile(name + ".txt");
		if (epointsfile.exists()) {
			epointsfile.delete(true, monitor);
		}
		epointsfile.create(new ByteArrayInputStream(
				lines.parallelStream().collect(Collectors.joining(",\n", '\n' + name + ":\n", "\n")).getBytes()), true,
				monitor);
	}

	/**
	 * Creates a folder with the given name
	 * 
	 * @param parent  The parent folder in which the folder should be created
	 * @param name    The name of the new folder
	 * @param monitor a progress monitor
	 * @return The new folder
	 * @throws CoreException
	 */
	private static IFolder create(IFolder parent, String name, IProgressMonitor monitor) throws CoreException {
		IFolder assetResultOutputFolder = parent.getFolder(name);
		if (!assetResultOutputFolder.exists()) {
			assetResultOutputFolder.create(true, true, monitor);
		}
		return assetResultOutputFolder;
	}
}
