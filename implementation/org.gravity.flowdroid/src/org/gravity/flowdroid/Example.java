package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.gravity.mapping.secdfd.checks.StructuralDivergenceCheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.junit.Test;

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;

public class Example {

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
		epoints.addAll(sourcesAndSinks.getEpoints());
		Set<String> sources = sourcesAndSinks.getSources();
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot: org.eclipse.equinox.internal.security.storage.PasswordExt getModulePassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferences: java.lang.float getFloat(java.lang.String, java.lang.float, org.eclipse.equinox.internal.security.storage.SecurePreferencesContainer)>");
		System.out.println("Sources:\n" + String.join(",\n", sources));
		Set<String> sinks = sourcesAndSinks.getSinks();
		System.out.println("Sinks:\n" + String.join(",\n", sinks));
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		InfoflowResults results = infoflow.getResults();
		results.printResults();
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
