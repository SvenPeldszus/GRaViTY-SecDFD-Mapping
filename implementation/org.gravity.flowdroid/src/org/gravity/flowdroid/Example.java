package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.junit.Test;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.InfoflowConfiguration.ImplicitFlowMode;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;

public class Example {

	/*
	 * @Test public void test() throws NoSuchMethodException { soot.G.reset();
	 * 
	 * IInfoflow infoflow = initInfoflow(false); String appPath =
	 * "examples/SecureDependencyExample/bin"; String libPath =
	 * System.getProperty("java.home") + File.separator + "lib" + File.separator +
	 * "rt.jar";
	 * 
	 * ArrayList<String> sources = new ArrayList<>();
	 * //sources.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
	 * sources.add("<keygeneration.RandomGenerator: java.lang.Double random()>");
	 * 
	 * ArrayList<String> sinks = new ArrayList<>();
	 * //sinks.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
	 * sinks.add(print(PrintStream.class.getDeclaredMethod("println",
	 * Object.class))); List<String> epoints = new ArrayList<>();
	 * 
	 * //epoints.add("<keygeneration.RandomGenerator: java.lang.Double random()>");
	 * epoints.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
	 * infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
	 * infoflow.getResults(); }
	 */

	@Test
	public void testSecureStorage() {
		soot.G.reset();

		IInfoflow infoflow = initInfoflow(false);
		String appPath = "examples/org.eclipse.equinox.security/bin";
		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

		ArrayList<String> sources = new ArrayList<>();
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:"
				+ " org.eclipse.equinox.internal.security.storage.PasswordExt "
				+ "getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:"
				+ " org.eclipse.equinox.internal.security.storage.PasswordExt "
				+ "getModulePassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer)>");
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferences:" + " java.lang.float "
				+ "getFloat(java.lang.String, java.lang.float, org.eclipse.equinox.internal.security.storage.SecurePreferencesContainer)>");

		ArrayList<String> sinks = new ArrayList<>();
		sinks.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:"
				+ " org.eclipse.equinox.internal.security.storage.PasswordExt "
				+ "getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		sinks.add("<org.eclipse.equinox.internal.security.storage.JavaEncryption:"
				+ "byte[] internalDecrypt(org.eclipse.equinox.internal.security.storage.PasswordExt, org.eclipse.equinox.internal.security.storage.CryptoData)>");
		List<String> epoints = new ArrayList<String>();

		epoints.add("<org.eclipse.equinox.internal.security.storage.SecurePreferencesRoot:"
				+ " org.eclipse.equinox.internal.security.storage.PasswordExt "
				+ "getPassword(java.lang.String, org.eclipse.equinox.security.storage.provider.IPreferencesContainer, boolean)>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		infoflow.getResults();
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
		result.getConfig().setImplicitFlowMode(ImplicitFlowMode.AllImplicitFlows);
		return result;
	}

	public static String getSootSignature(Method method) {
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

	public static String getSootSignature(TMethodDefinition method) {
		StringBuilder buffer = new StringBuilder("<");
		buffer.append(method.getDefinedBy().getSignature());
		buffer.append(": ");
		buffer.append(method.getReturnType().getSignature());
		buffer.append(' ');
		buffer.append(method.getSignature().getMethod().getTName());
		buffer.append('(');
		TParameter param = method.getSignature().getFirstParameter();
		while(param != null) {
			buffer.append(param.getType().getSignature());
			TParameter next = param.getNext();
			if(next!=null) {
				buffer.append(',');
			}
		}
		buffer.append(")>");
		return buffer.toString();
	}

	public static Set<AbstractCorrespondence> getAcceptedMappings(Mapper mapper, EObject dfdelement) {
		return mapper.getMapping().getAccepted().parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement)).collect(Collectors.toSet());
	}

	Map<String, ArrayList<String>> getSourceSinks(Mapper mapper, EDFD dfd) {
		ArrayList<String> sources = new ArrayList<>();
		ArrayList<String> sinks = new ArrayList<>();

		for (Asset asset : dfd.getAsset()) {
			if (asset.getValue().stream().anyMatch(value -> "Confidentiality".equals(value.getObjective().getName()))) {
				NamedEntity assetsource = asset.getSource();
				List<Element> assettargets = asset.getTargets();

				Set<AbstractCorrespondence> flowSourceCorrespondences = findSources(mapper, asset, assetsource);

				Set<AbstractCorrespondence> flowSinkCorrespondences = findSinks(mapper, asset, assetsource,
						assettargets);

				// set all as source for analyzer
				for (AbstractCorrespondence c : flowSourceCorrespondences) {
					// TODO: change print method
					// sources.addAll(print(CorrespondenceHelper.getSource(c)));
				}
				// set all as sinks for analyzer
				for (AbstractCorrespondence c : flowSinkCorrespondences) {
					// TODO: change print method
					// sinks.addAll(print(CorrespondenceHelper.getSource(c)));
				}
			}
		}
		HashMap<String, ArrayList<String>> sourcesinks = new HashMap<>();
		sourcesinks.put("sources", sources);
		sourcesinks.put("sinks", sinks);
		return sourcesinks;
	}

	private Set<AbstractCorrespondence> findSinks(Mapper m, Asset asset, NamedEntity assetsource,
			List<Element> assettargets) {
		Set<AbstractCorrespondence> sinks = new HashSet<>();
		for (Element el : assettargets) {
			sinks.addAll(getAcceptedMappings(m, el));

			if (sinks.isEmpty()) {
				// there is no mapping of asset source element -> get the previous element
				Stream<Flow> transporterFlows = getTargetFlows(asset, assetsource);
				// collect the processes of the incoming flows:
				// TODO: Is this assignment correct?
				sinks = transporterFlows.flatMap(flow -> flow.getTarget().parallelStream())
						.flatMap(target -> getAcceptedMappings(m, target).parallelStream()).collect(Collectors.toSet());

			}
		}
		return sinks;
	}

	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource) {
		Set<AbstractCorrespondence> sources = getAcceptedMappings(m, assetsource);
		if (sources.isEmpty()) {
			// there is no mapping of asset source element -> get the next element
			Stream<Flow> transporterflows = getSourceFlows(asset, assetsource);
			// collect the processes of the outgoing flows:
			return transporterflows.flatMap(flow -> flow.getTarget().parallelStream())
					.flatMap(target -> getAcceptedMappings(m, target).parallelStream()).collect(Collectors.toSet());
		}
		return sources;
	}

	private Stream<Flow> getTargetFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getInflows().parallelStream()
				.filter(inflow -> inflow.getAssets().contains(asset)).distinct();
	}

	private Stream<Flow> getSourceFlows(Asset asset, NamedEntity assetsource) {
		return ((Element) assetsource).getOutflows().parallelStream()
				.filter(outflow -> outflow.getAssets().contains(asset)).distinct();
	}
}
