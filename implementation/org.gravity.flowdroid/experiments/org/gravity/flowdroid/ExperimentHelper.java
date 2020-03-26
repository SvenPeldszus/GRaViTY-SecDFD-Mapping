/**
 * 
 */
package org.gravity.flowdroid;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;

/**
 * @author katjat
 *
 */
public final class ExperimentHelper {

	private static final Logger LOGGER = Logger.getLogger(CorrespondenceHelper.class);

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

	public static Collection<String> stringBuilder(HashSet<String> truePositives, HashSet<String> falsePositives,
			HashSet<String> falseNegatives) {
		List<String> built = new ArrayList<String>();
		built.add("True Positives: \n" + "==================================\n");
		for (String i : truePositives) {
			built.add(i + '\n');
		}
		built.add("\n\nFalse Positives: \n" + "==================================\n");
		for (String i : falsePositives) {
			built.add(i + '\n');
		}
		built.add("\n\nFalse Negatives: \n" + "==================================\n");
		for (String i : falseNegatives) {
			built.add(i + '\n');
		}
		built.add("\n\n\n==================================\n");
		built.add("Precision = " + ((double) truePositives.size()) / (truePositives.size() + falsePositives.size())
				+ '\n');
		built.add(
				"Recall = " + ((double) truePositives.size()) / (truePositives.size() + falseNegatives.size()) + '\n');
		return built;
	}

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

}
