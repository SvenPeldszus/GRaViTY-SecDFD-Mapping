package org.gravity.flowdroid;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.Mapper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import eDFDFlowTracking.Asset;
import eDFDFlowTracking.Process;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.ExternalEntity;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.NamedEntity;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;


public class Example {
	
	

	/*
	@Test
	public void test() throws NoSuchMethodException {
		soot.G.reset();

		IInfoflow infoflow = initInfoflow(false);
		String appPath = "examples/SecureDependencyExample/bin";
		String libPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";

		ArrayList<String> sources = new ArrayList<>();
		//sources.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
		sources.add("<keygeneration.RandomGenerator: java.lang.Double random()>");
		
		ArrayList<String> sinks = new ArrayList<>();
		//sinks.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
		sinks.add(print(PrintStream.class.getDeclaredMethod("println", Object.class)));
		List<String> epoints = new ArrayList<String>();

		//epoints.add("<keygeneration.RandomGenerator: java.lang.Double random()>");
		epoints.add("<keygeneration.KeyGenerator: void main(java.lang.String[])>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		infoflow.getResults();
	}*/
	

	@Test
	public void testSecureStorage() throws NoSuchMethodException {
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
		sources.add("<org.eclipse.equinox.internal.security.storage.SecurePreferences:"
				+ " java.lang.float "
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
	
	Set<AbstractCorrespondence> getAcceptedMappings (Mapper m, EObject dfdelement) {
		return m.getMapping().getAccepted().parallelStream()
				.filter(cor -> CorrespondenceHelper.getTarget(cor).equals(dfdelement))
				.collect(Collectors.toSet());
	}
	
	@SuppressWarnings("unchecked")
	HashMap<String, ArrayList<String>> getSourceSinks(Mapper m, EDFD dfd) {
		ArrayList<String> sources = new ArrayList<String>();
		ArrayList<String> sinks = new ArrayList<String>();
		
		for (Asset asset : dfd.getAsset()) {
			if(asset.getValue().stream().filter(value -> value.getObjective().getName()=="Confidentiality").collect(Collectors.toSet()).size()>0) {
				NamedEntity assetsource = ((Asset) asset).getSource();
				EList<Element> assettargets = ((Asset) asset).getTargets();
				
				Set<AbstractCorrespondence> s = new HashSet<>();
				findSources(m, asset, assetsource, s);
				
				Set<AbstractCorrespondence> t = new HashSet<>();
				findSinks(m, asset, assetsource, assettargets, t);
				
				//set all as source for analyzer
				for (AbstractCorrespondence c : s) {
					//TODO: change print method
					//sources.addAll(print(CorrespondenceHelper.getSource(c)));
				}
				// set all as sinks for analyzer
				for (AbstractCorrespondence c : t) {
					//TODO: change print method
					//sinks.addAll(print(CorrespondenceHelper.getSource(c)));
				}
			}
		}
		HashMap<String, ArrayList<String>> sourcesinks = new HashMap<>();
		sourcesinks.put("sources", sources);
		sourcesinks.put("sinks", sinks);
		return sourcesinks;
	}

	private void findSinks(Mapper m, Asset asset, NamedEntity assetsource, EList<Element> assettargets,
			Set<AbstractCorrespondence> t) {
		for (Element el : assettargets) {
			t.addAll(getAcceptedMappings(m, el));
			
			if (t.size()<1) {
				//there is no mapping of asset source element -> get the previous element
				ArrayList<Process> sourceprocesses = new ArrayList<Process>();
				Set<Flow> transporterflows = new HashSet<>();
				transporterflows = getTargetFlows(asset, assetsource, transporterflows);
				//collect the processes of the incoming flows: assume they are processes for now (should be checked)
				for (Flow f : transporterflows) {
					sourceprocesses.addAll((Collection<? extends Process>) f.getTarget());
				}
				for (Process p : sourceprocesses) {
					t.addAll(getAcceptedMappings(m, p));
				}
			}
		}
	}

	private Set<AbstractCorrespondence> findSources(Mapper m, Asset asset, NamedEntity assetsource, Set<AbstractCorrespondence> s) {
		s = getAcceptedMappings(m, assetsource);
		if (s.size()<1) {
			//there is no mapping of asset source element -> get the next element
			ArrayList<Process> sourceprocesses = new ArrayList<Process>();
			Set<Flow> transporterflows = new HashSet<>();
			transporterflows = getSourceFlows(asset, assetsource, transporterflows);
			//collect the processes of the outgoing flows: assume they are processes for now (should be checked)
			for (Flow f : transporterflows) {
				sourceprocesses.addAll((Collection<? extends Process>) f.getTarget());
			}
			for (Process p : sourceprocesses) {
				s.addAll(getAcceptedMappings(m, p));
			}
		}
		return s;
	}

	private Set<Flow> getTargetFlows(Asset asset, NamedEntity assetsource, Set<Flow> transporterflows) {
		if (assetsource instanceof ExternalEntity) {
			transporterflows = ((ExternalEntity) assetsource).getInflows()
					.parallelStream().filter(inflow -> inflow.getAssets().contains(asset)).collect(Collectors.toSet());
		}else if (assetsource instanceof Process) {
			transporterflows = ((Process) assetsource).getInflows()
					.parallelStream().filter(inflow -> inflow.getAssets().contains(asset)).collect(Collectors.toSet());
		}else if (assetsource instanceof DataStore){
			transporterflows = ((DataStore) assetsource).getInflows()
					.parallelStream().filter(inflow -> inflow.getAssets().contains(asset)).collect(Collectors.toSet());
		} else {
			//wrong model, asset source can not be a trust zone or dataflow
			//TODO: handle later
		}
		return transporterflows;
	}

	private Set<Flow> getSourceFlows(Asset asset, NamedEntity assetsource, Set<Flow> transporterflows) {
		if (assetsource instanceof ExternalEntity) {
			transporterflows = ((ExternalEntity) assetsource).getOutflows()
					.parallelStream().filter(outflow -> outflow.getAssets().contains(asset)).collect(Collectors.toSet());
		}else if (assetsource instanceof Process) {
			transporterflows = ((Process) assetsource).getOutflows()
					.parallelStream().filter(outflow -> outflow.getAssets().contains(asset)).collect(Collectors.toSet());
		}else if (assetsource instanceof DataStore){
			transporterflows = ((DataStore) assetsource).getOutflows()
					.parallelStream().filter(outflow -> outflow.getAssets().contains(asset)).collect(Collectors.toSet());
		} else {
			//wrong model, asset source can not be a trust zone or dataflow
			//TODO: handle later
		}
		return transporterflows;
	}
}
