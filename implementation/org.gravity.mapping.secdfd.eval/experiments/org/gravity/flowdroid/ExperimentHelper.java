/**
 * 
 */
package org.gravity.flowdroid;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author katjat
 *
 */
public final class ExperimentHelper {

	private ExperimentHelper() {
		// This class shouldn't be instantiated
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
	public static void writeToTxt(IFolder out, Collection<String> lines, String name, IProgressMonitor monitor,
			boolean join) throws CoreException {
		IFile epointsfile = out.getFile(name + ".txt");
		if (epointsfile.exists()) {
			epointsfile.delete(true, monitor);
		}
		if (join)
			epointsfile.create(new ByteArrayInputStream(
					lines.parallelStream().collect(Collectors.joining(",\n", '\n' + name + ":\n", "\n")).getBytes()),
					true, monitor);
		else
			epointsfile.create(
					new ByteArrayInputStream(
							lines.parallelStream().collect(Collectors.joining("", "" + "" + "", "")).getBytes()),
					true, monitor);
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
	public static IFolder create(IFolder parent, String name, IProgressMonitor monitor) throws CoreException {
		IFolder assetResultOutputFolder = parent.getFolder(name);
		if (!assetResultOutputFolder.exists()) {
			assetResultOutputFolder.create(true, true, monitor);
		}
		return assetResultOutputFolder;
	}

	/**
	 * @param tps
	 * @param fps
	 * @param fns
	 * @return
	 */
	public static Collection<String> stringBuilder(Set<String> tps, Set<String> fps,
			Set<String> fns) {
		List<String> built = new ArrayList<String>();
		built.add("True Positives: \n" + "==================================\n");
		for (String i : tps) {
			built.add(i + '\n');
		}
		built.add("\n\nFalse Positives: \n" + "==================================\n");
		for (String i : fps) {
			built.add(i + '\n');
		}
		built.add("\n\nFalse Negatives: \n" + "==================================\n");
		for (String i : fns) {
			built.add(i + '\n');
		}
		built.add("\n\n\n==================================\n");
		built.add("Precision = " + ((double) tps.size()) / (tps.size() + fps.size())
				+ '\n');
		built.add(
				"Recall = " + ((double) tps.size()) / (tps.size() + fns.size()) + '\n');
		return built;
	}
	


	/**
	 * @param accummulatedTP
	 * @param accummulatedFP
	 * @param accummulatedFN
	 * @return
	 */
	public static Collection<String> stringBuilderAccummulated(Integer accummulatedTP, Integer accummulatedFP, Integer accummulatedFN) {
		List<String> built = new ArrayList<String>();
		built.add("\n==================================\n");
		built.add("Contract validation in current workspace: \n");
		built.add("TP = " + accummulatedTP + "\n");
		built.add("FP = " + accummulatedFP + "\n");
		built.add("FN = " + accummulatedFN + "\n");
		built.add("\n\n");
		built.add("Precision = " + ((double) accummulatedTP) / (accummulatedFP + accummulatedTP) + '\n');
		built.add("Recall = " + ((double) accummulatedTP) / (accummulatedFN + accummulatedTP));
		built.add("\n==================================\n");
		return built;
	}

	public static Collection<String> stringBuilderAccummulated(Integer accummulatedTP, Integer accummulatedFP,
			Integer accummulatedFN, Integer accFNAllowedSinks) {
		List<String> built = new ArrayList<String>();
		built.addAll(stringBuilderAccummulated(accummulatedTP, accummulatedFP, accummulatedFN));
		built.add(built.size()-4, "FN from allowed sinks = " + accFNAllowedSinks + "\n");
		return built;
	}

	public static Collection<String> stringBuilder(HashMap<String, String> tps, HashMap<String, String> fps,
			HashMap<String, String> fns) {
		List<String> built = new ArrayList<String>();
		built.add("True Positives: \n" + "==================================\n");
		if (!tps.isEmpty()) {
			tps.keySet().forEach(key -> {
				built.add("Source: " + key + "\nSink: " + tps.get(key)+"\n\n");
			});
		} else built.add("None.\n");
		built.add("\n\nFalse Positives: \n" + "==================================\n");
		if (!fps.isEmpty()) {
		fps.keySet().forEach(key -> {
			built.add("Source: " + key + "\nSink: " + fps.get(key)+"\n\n");
		});
		} else built.add("None.\n");
		built.add("\n\nFalse Negatives: \n" + "==================================\n");
		if (!fns.isEmpty()) {
		fns.keySet().forEach(key -> {
			built.add("Source: " + key + "\nSink: " + fns.get(key)+"\n\n");
		});
		} else built.add("None.\n");
		built.add("\n\n\n==================================\n");
		built.add("Precision = " + ((double) tps.size()) / (tps.size() + fps.size())
				+ '\n');
		built.add(
				"Recall = " + ((double) tps.size()) / (tps.size() + fns.size()) + '\n');
		return built;
	}

}
