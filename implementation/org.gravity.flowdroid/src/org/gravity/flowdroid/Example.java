package org.gravity.flowdroid;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.eclipse.util.JavaProjectUtil;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.junit.Test;
import org.secdfd.model.Asset;
import org.secdfd.model.EDFD;

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration.AliasingAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.CallgraphAlgorithm;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;

public class Example {

	private static final boolean SUSI = true;
	private static List<String> baselineSources;
	private static List<String> baselineSinks;

	static String print(Method method) {
		StringBuilder buffer = new StringBuilder("<");
		buffer.append(method.getDeclaringClass().getName());
		buffer.append(": ");
		buffer.append(method.getReturnType().getName());
		buffer.append(' ');
		buffer.append(method.getName());
		buffer.append('(');
		buffer.append(Stream.of(method.getParameterTypes()).map(Class::getName).collect(Collectors.joining(",")));
		buffer.append(")>");
		return buffer.toString();
	}

	/**
	 * Run as JUnit plugin test
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	@Test
	public void testSecureStorageDF() throws IOException, CoreException {
		IProject project = EclipseProjectUtil.getProjectByName("org.eclipse.equinox.security");
		IProgressMonitor monitor = new NullProgressMonitor();
		IJavaProject javaProject = JavaProjectUtil.getJavaProject(project);
		if (!javaProject.isOpen()) {
			javaProject.open(monitor);
		}
		// build the project to analyze
		project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		// set up paths for application and library to pass to flowdroid
		IPath outputLocation = javaProject.getOutputLocation();
		IPath projectLocation = project.getLocation();
		String appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();
		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";
		
		// reset soot and initialize flowdroid configuration
		soot.G.reset();
		IInfoflow infoflow = initInfoflow(Collections.emptyMap());
		
		// paths for secdfd-gravity tool, setup correspondence model, mapper, dfd
		IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);
		IFile corr = gravity.getFile("storepassword.corr.xmi");
		Mapper mapper = new Mapper(corr);
		EDFD dfd = mapper.getDFD();
	
		// get base line sources (FlowDroid published sources) and sinks (FlowDroid sinks + SuSi list of sinks) for experiment
		SourcesAndSinkFinder sas = new SourcesAndSinkFinder(mapper, SUSI);
		Map<String, Set<String>> baseline = sas.getBaseline();
		baselineSources = new ArrayList<>(baseline.get("baselineSources"));
		baselineSinks = new ArrayList<>(baseline.get("baselineSinks"));	

		for (Asset asset : dfd.getAsset()) {
			// look for sources, sinks, epoints if confidential asset
//			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				SourceAndSink sourcesAndSinks = sas.getSourceSinks(asset);
				if(sourcesAndSinks == null) {
					continue;
				}

				List<String> sources = new ArrayList<>(sourcesAndSinks.getSources());
				List<String> sinks = new ArrayList<>(sourcesAndSinks.getSinks());
				Set<String> epoints = sourcesAndSinks.getEpoints();

				if (sources.isEmpty()) {
					continue;
				}
				print(gravity, asset, sources, sinks, epoints, monitor);

				for (String entryPoint : epoints) {
					infoflow.computeInfoflow(appPath, libPath, entryPoint, sources, sinks);
					InfoflowResults results = infoflow.getResults();

					printReport(gravity, asset, results);
				}
			}
//		}

	}

	/**
	 * @param gravity
	 * @param asset
	 * @param results
	 * @throws IOException
	 */
	private void printReport(IFolder gravity, Asset asset, InfoflowResults results) throws IOException {
		File file = gravity.getFile(asset.getName() + "-FlowDroid-results.txt").getLocation().toFile();
		if (!file.exists()) {
			file.createNewFile();
		}
		try (Writer wr = new FileWriter(file)) {
			results.printResults(wr);
		}
	}

	/**
	 * @param gravity
	 * @param asset
	 * @param sources
	 * @param sinks
	 * @param epoints
	 * @param monitor
	 * @throws CoreException
	 */
	private void print(IFolder gravity, Asset asset, List<String> sources, List<String> sinks, Set<String> epoints,
			IProgressMonitor monitor) throws CoreException {
		IFile epointsfile = gravity.getFile(asset.getName() + "-entrypoints.txt");
		IFile sourcesfile = gravity.getFile(asset.getName() + "-sources.txt");
		IFile sinksfile = gravity.getFile(asset.getName() + "-sinks.txt");
		if (epointsfile.exists())
			epointsfile.delete(true, monitor);
		if (sourcesfile.exists())
			sourcesfile.delete(true, monitor);
		if (sinksfile.exists())
			sinksfile.delete(true, monitor);
		epointsfile.create(new ByteArrayInputStream(
				epoints.parallelStream().collect(Collectors.joining(",\n", "\nEntry points:\n", "\n")).getBytes()),
				true, monitor);
		sourcesfile.create(
				new ByteArrayInputStream(
						sources.parallelStream().collect(Collectors.joining(",\n", "\nSources:\n", "\n")).getBytes()),
				true, monitor);
		sinksfile.create(
				new ByteArrayInputStream(
						sinks.parallelStream().collect(Collectors.joining(",\n", "\nSinks:\n", "\n")).getBytes()),
				true, monitor);
	}

	protected IInfoflow initInfoflow(Map<String, Set<String>> taintedMethods) {
		Infoflow result = new Infoflow("", false, null);
		result.setSootConfig((options, config) -> {
			options.set_whole_program(true);
			options.set_exclude(Collections.emptyList());
			options.set_no_bodies_for_excluded(true);
			options.set_allow_phantom_refs(true);
			options.setPhaseOption("jb", "use-original-names:true");
			options.set_ignore_classpath_errors(true);
			options.set_verbose(true);

			config.setInspectSources(true);
			config.setInspectSinks(true);
			config.setCallgraphAlgorithm(CallgraphAlgorithm.AutomaticSelection);
			config.setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows);
			config.setAliasingAlgorithm(AliasingAlgorithm.FlowSensitive);
			config.setStopAfterFirstFlow(true);
		});
		result.setTaintWrapper(new EasyTaintWrapper(taintedMethods));
		return result;
	}
}
