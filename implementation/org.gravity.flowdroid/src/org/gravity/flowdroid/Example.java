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
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.entryPointCreators.DefaultEntryPointCreator;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.sourcesSinks.manager.DefaultSourceSinkManager;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;

public class Example {

	private static final boolean SUSI = false;

	public void test() throws IOException {

		soot.G.reset();

		IInfoflow infoflow = initInfoflow();
		String appPath = "examples/SecureDependencyExample/bin";
		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

		ArrayList<String> sources = new ArrayList<>();
		sources.add("<keygeneration.RandomGenerator: java.lang.Double random()>");

		ArrayList<String> sinks = new ArrayList<>();
// 		sinks.add(print(PrintStream.class.getDeclaredMethod("println", Object.class)));
		sinks.add("<keygeneration.RandomGenerator: java.lang.Double leaksecret(java.lang.Double)>");
		List<String> epoints = new ArrayList<String>();

		epoints.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
		// infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		infoflow.computeInfoflow(appPath, libPath, new DefaultEntryPointCreator(epoints),
				new DefaultSourceSinkManager(sources, sinks, sources, sinks));
		InfoflowResults res = infoflow.getResults();
		Writer wr;
		wr = new FileWriter("examples/SecureDependencyExample/results.txt");
		res.printResults(wr);
		wr.close();
	}

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
		IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);
		IFile corr = gravity.getFile("storepassword.corr.xmi");
		Mapper mapper = new Mapper(corr);
		SourcesAndSinks sas = new SourcesAndSinks();

		soot.G.reset();

		IInfoflow infoflow = initInfoflow();
		IJavaProject javaProject = JavaProjectUtil.getJavaProject(project);
		if (!javaProject.isOpen()) {
			javaProject.open(monitor);
		}
		project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

		IPath outputLocation = javaProject.getOutputLocation();
		IPath projectLocation = project.getLocation();
		String appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();

		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

		EDFD dfd = mapper.getDFD();
		for (Asset asset : dfd.getAsset()) {
			// look for sources, sinks, epoints if confidential asset
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				SourceAndSink sourcesAndSinks = sas.getSourceSinks(gravity, mapper, dfd, false, asset);
				if (sourcesAndSinks!=null) {

					Set<String> epoints = sourcesAndSinks.getEpoints();
//					epoints.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesWrapper: java.lang.String get(java.lang.String,java.lang.String)>");
//					epoints.add("<org.eclipse.equinox.internal.security.storage.friends.ReEncrypter: void decrypt(org.eclipse.equinox.security.storage.ISecurePreferences)>");

					Set<String> sources = sourcesAndSinks.getSources();
//					sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getPassword(java.lang.String,org.eclipse.equinox.security.storage.provider.IPreferencesContainer,boolean)>");
//					sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getModulePassword(java.lang.String,org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>");

					Set<String> sinks = sourcesAndSinks.getSinks();
//					sinks.add("<org.eclipse.equinox.security.storage.ISecurePreferences: java.lang.String get(java.lang.String,java.lang.String)>");

									
					gravity.getFile(asset.getName() + "-entrypoints.txt")
							.create(new ByteArrayInputStream(epoints.parallelStream()
									.collect(Collectors.joining(",\n", "\nEntry points:\n", "\n")).getBytes()), true,
									monitor);
					gravity.getFile(asset.getName() + "-sources.txt").create(new ByteArrayInputStream(
							sources.parallelStream().collect(Collectors.joining(",\n", "\nSources:\n", "\n")).getBytes()),
							true, monitor);
					gravity.getFile(asset.getName() + "-sinks.txt").create(new ByteArrayInputStream(
							sinks.parallelStream().collect(Collectors.joining(",\n", "\nSinks:\n", "\n")).getBytes()), true,
							monitor);
					 
					infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
					InfoflowResults results = infoflow.getResults();
					File file = gravity.getFile(asset.getName() + "-FlowDroid-results.txt").getLocation().toFile();
					if (!file.exists()) {
						file.createNewFile();
					}
					try (Writer wr = new FileWriter(file)) {
						results.printResults(wr);
					}
				}				
			}
			

		}

	}

	protected IInfoflow initInfoflow() {
		Infoflow result = new Infoflow("", false, null);
		result.setSootConfig((options, config) -> {
			options.set_no_bodies_for_excluded(true);
			options.set_allow_phantom_refs(true);
			options.set_output_format(Options.output_format_none);
			options.setPhaseOption("jb", "use-original-names:true");
			options.set_ignore_classpath_errors(true);
			options.set_whole_program(true);
			options.set_verbose(true);
		});
		Map<String, Set<String>> taintedMethods = Collections.emptyMap();
		EasyTaintWrapper easyWrapper = new EasyTaintWrapper(taintedMethods);
		result.setTaintWrapper(easyWrapper);

		result.getConfig().setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows);
		return result;
	}
}
