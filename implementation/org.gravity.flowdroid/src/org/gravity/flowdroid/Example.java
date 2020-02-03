package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;

public class Example {

	@Test
	public void test() throws NoSuchMethodException {
		soot.G.reset();

		IInfoflow infoflow = initInfoflow(false);
		String appPath = "examples/SecureDependencyExample/bin";
		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

		ArrayList<String> sources = new ArrayList<>();
		sources.add("<keygeneration.RandomGenerator: java.lang.Double random()>");

		ArrayList<String> sinks = new ArrayList<>();
		sinks.add(print(PrintStream.class.getDeclaredMethod("println", Object.class)));
		List<String> epoints = new ArrayList<String>();

		epoints.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		infoflow.getResults();
	}

	protected IInfoflow initInfoflow(boolean useTaintWrapper) {
		Infoflow result = new Infoflow("", false, null);
		result.setSootConfig(new IInfoflowConfig() {

			@Override
			public void setSootOptions(Options options, InfoflowConfiguration config) {
				// explicitly include packages for shorter runtime:
				List<String> includeList = new LinkedList<String>();
				includeList.add("java.lang.*");
				includeList.add("java.util.*");
				includeList.add("java.io.*");
				includeList.add("sun.misc.*");
				includeList.add("java.net.*");
				includeList.add("javax.servlet.*");
				includeList.add("javax.crypto.*");
				Options.v().set_no_bodies_for_excluded(true);
				Options.v().set_allow_phantom_refs(true);
				options.set_include(includeList);
				options.set_output_format(Options.output_format_none);
				Options.v().setPhaseOption("jb", "use-original-names:true");
				Options.v().set_ignore_classpath_errors(true);
			}

		});
		if (useTaintWrapper) {
			EasyTaintWrapper easyWrapper;
			try {
				easyWrapper = new EasyTaintWrapper();
				result.setTaintWrapper(easyWrapper);
			} catch (IOException e) {
				System.err.println("Could not initialized Taintwrapper:");
				e.printStackTrace();
			}

		}
		return result;
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

}
