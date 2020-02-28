package org.gravity.flowdroid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.entryPointCreators.DefaultEntryPointCreator;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.sourcesSinks.manager.DefaultSourceSinkManager;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;

public class Example {
	@Test
 	public void test() throws NoSuchMethodException, IOException {
		soot.G.reset();

 		IInfoflow infoflow = initInfoflow(false);
 		String appPath = "examples/SecureDependencyExample/bin";
 		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

 		ArrayList<String> sources = new ArrayList<>();
 		sources.add("<keygeneration.RandomGenerator: java.lang.Double random()>");

 		ArrayList<String> sinks = new ArrayList<>();
// 		sinks.add(print(PrintStream.class.getDeclaredMethod("println", Object.class)));
 		sinks.add("<keygeneration.RandomGenerator: java.lang.Double leaksecret(java.lang.Double)>");
 		List<String> epoints = new ArrayList<String>();

 		epoints.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
 		//infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
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
	
	public void testSecureStorageDF() throws IOException, CoreException {
		IProject project = EclipseProjectUtil.getProjectByName("org.eclipse.equinox.security");
		IProgressMonitor monitor = new NullProgressMonitor();
		IFolder gravity = EclipseProjectUtil.getGravityFolder(project, monitor);
		IFile corr = gravity.getFile("storepassword.corr.xmi");
		Mapper mapper = new Mapper(corr);

		//already creates epoints
		SourceAndSink sourcesAndSinks = new SourcesAndSinks().getSourceSinks(gravity, mapper, mapper.getDFD());

		soot.G.reset();

		IInfoflow infoflow = initInfoflow(false);
		IJavaProject javaProject = JavaProjectUtil.getJavaProject(project);
		if (!javaProject.isOpen()) {
			javaProject.open(monitor);
		}
		project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

		IPath outputLocation = javaProject.getOutputLocation();
		IPath projectLocation = project.getLocation();
		String appPath = projectLocation.append(outputLocation.removeFirstSegments(1)).toOSString();

		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

// Sources:
//		<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:" org.eclipse.equinox.internal.security.storage.PasswordExt getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>
//		<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getModulePassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>
//		<org.eclipse.equinox.internal.security.storage.SecurePreferences:" + " java.lang.float getFloat(java.lang.String, java.lang.float, org.eclipse.equinox.internal.security.storage.SecurePreferencesContainer)>
//
// Sinks:
//		<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>
//		<org.eclipse.equinox.internal.security.storage.JavaEncryption: byte[] internalDecrypt(org.eclipse.equinox.internal.security.storage.PasswordExt, org.eclipse.equinox.internal.security.storage.CryptoData)>

		List<String> epoints = new ArrayList<String>();
		
		epoints.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:"
				+ " org.eclipse.equinox.internal.security.storage.PasswordExt "
				+ "getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		epoints.add("<org.eclipse.equinox.internal.security.storage.PasswordManagement: void setupRecovery(java.lang.String[][], java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>");
		//epoints.addAll(sourcesAndSinks.getEpoints());
		ArrayList<String> sources = new ArrayList<String>();
				//sourcesAndSinks.getSources();
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getModulePassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferences: java.lang.float getFloat(java.lang.String, java.lang.float, org.eclipse.equinox.internal.security.storage.SecurePreferencesContainer)>");
		sources.addAll(sourcesAndSinks.getSources());
		//System.out.println("Sources:\n" + String.join(",\n", sources));
		Set<String> sinks = sourcesAndSinks.getSinks();
		//System.out.println("Sinks:\n" + String.join(",\n", sinks));
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		InfoflowResults results = infoflow.getResults();
 		Writer wr;
 		wr = new FileWriter("org.eclipse.equinox.security/.gravity/FlowDroid-results.txt");
 		results.printResults(wr);
 		wr.close();
	}

	protected IInfoflow initInfoflow(boolean useTaintWrapper) {
		Infoflow result = new Infoflow("", false, null);
		result.setSootConfig(new IInfoflowConfig() {

			@Override
			public void setSootOptions(Options options, InfoflowConfiguration config) {
				// explicitly include packages for shorter runtime:
				List<String> includeList = Arrays.asList("java.lang.*", "java.util.*", "java.io.*", "sun.misc.*",
						"java.net.*", "javax.servlet.*", "javax.crypto.*");
				Options.v().set_no_bodies_for_excluded(true);
				Options.v().set_allow_phantom_refs(true);
				options.set_include(includeList);
				options.set_output_format(Options.output_format_none);
				Options.v().setPhaseOption("jb", "use-original-names:true");
				Options.v().set_ignore_classpath_errors(true);
			}

		});
		Map<String, Set<String>> taintedMethods = Collections.emptyMap();
		EasyTaintWrapper easyWrapper = new EasyTaintWrapper(taintedMethods);
		result.setTaintWrapper(easyWrapper);
		

		result.getConfig().setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows);
		return result;
	}
}
