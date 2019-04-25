package org.gravity.mapping.secdfd.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Logging {

	private static Map<Resource, Map<String, Set<String>>> maps = new HashMap<>();
	

	public static Map<Resource, HashSet<String>> allExpectedPositives = new HashMap<>();

	public static HashSet<String> truePositives = new HashSet<String>();
	public static HashSet<String> falsePositives = new HashSet<String>();
	public static HashSet<String> falseNegatives = new HashSet<String>();

	public static void init() {
		MappingView mappingView = MappingView.getMappingView();
		for (Mapping mapping : mappingView.getMappings()) {
			File file = mappingView.getProgramModel().getKey().getProject()
					.getFile("groundtruth/" + mapping.getName() + ".json").getLocation().toFile();
			if (file.exists()) {
				Resource eResource = mapping.getTarget().eResource();
				HashSet<String> expectedPositives = new HashSet<>();
				allExpectedPositives.put(eResource, expectedPositives);
				try {
					JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
					Map<String, Set<String>> map = maps.get(eResource);
					if (map == null) {
						map = new HashMap<>();
						maps.put(eResource, map);
					}
					for (JsonElement jsonElement : object.getAsJsonArray("mappings")) {
						if (jsonElement instanceof JsonObject) {
							String pm = ((JsonObject) jsonElement).get("pm").getAsString().toLowerCase().replaceAll(" ",
									"");
							String dfd = ((JsonObject) jsonElement).get("secdfd").getAsString().toLowerCase()
									.replaceAll(" ", "");
							Set<String> pmNames;
							if (map.containsKey(dfd)) {
								pmNames = map.get(dfd);
							} else {
								pmNames = new HashSet<>();
								map.put(dfd, pmNames);
							}
							pmNames.add(pm);
							expectedPositives.add(pm + " <-> " + dfd);
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		falseNegatives = new HashSet<String>();
		truePositives = new HashSet<>();
		falsePositives = new HashSet<>();
	}

	public static void writeLog(Collection<EObject> corrs) {
		if (update(corrs)) {
			File file = MappingView.getMappingView().getProgramModel().getKey().getProject()
					.getFile("log/precision_recall_" + System.currentTimeMillis() + ".log").getLocation().toFile();
			int tp = truePositives.size();
			int fp = falsePositives.size();
			int fn = falseNegatives.size();
			double precission = (double) tp / (tp + fp);
			double recall = (double) tp / (tp + fn);
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
				try (FileWriter writer = new FileWriter(file, true)) {
					writer.append("Precision ");
					writer.append(Double.toString(precission));
					writer.append(", Recall: ");
					writer.append(Double.toString(recall));
					writer.append("\nTP: ");
					writer.append(Integer.toString(tp));
					writer.append("\nFP: ");
					writer.append(Integer.toString(fp));
					writer.append("\nFN: ");
					writer.append(Integer.toString(fn));
					writer.append("\n\nFalse negatives:\n");
					for (String missed : falseNegatives) {
						writer.append(missed);
						writer.append('\n');
					}
					writer.append("\nFalse positives:\n");
					for (String wrong : falsePositives) {
						writer.append(wrong);
						writer.append('\n');
					}
					writer.append('\n');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean update(Collection<EObject> corrs) {
		if(corrs.isEmpty()) {
			return true;
		}
		Resource eResource = CorrespondenceHelper.getTarget((AbstractCorrespondence) corrs.iterator().next()).eResource();
		Map<String, Set<String>> map = maps.get(eResource);
		if(map == null || map.isEmpty()) {
			init();
			map = maps.get(eResource);
		}
		if(map == null || map.isEmpty()) {
			return false;
		}
		
		falseNegatives = new HashSet<String>(allExpectedPositives.get(eResource));
		truePositives = new HashSet<>();
		falsePositives = new HashSet<>();
		for (AbstractCorrespondence corr : corrs.parallelStream().filter(corr -> corr instanceof AbstractCorrespondence)
				.map(corr -> (AbstractCorrespondence) corr).collect(Collectors.toList())) {
			EObject pmObject = CorrespondenceHelper.getSource(corr);
			String pmString = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
			pmString = pmString.substring(pmString.indexOf(':') + 1).replaceAll(" ", "");

			EObject dfdObject = CorrespondenceHelper.getTarget(corr);
			String dfdString = MappingLabelProvider.prettyPrint(dfdObject).toLowerCase();
			dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");

			if (map.containsKey(dfdString)) {
				if (map.get(dfdString).contains(pmString)) {
					truePositives.add(pmString + " <-> " + dfdString);
					falseNegatives.remove(pmString + " <-> " + dfdString);
					continue;
				}
			}
			if (pmObject instanceof TMember || pmObject instanceof TAbstractType) {
				falsePositives.add(pmString + " <-> " + dfdString);
			}
		}
		return true;
	}

	public static String getTruePositive(AbstractCorrespondence corr) {
		EObject source = CorrespondenceHelper.getSource(corr);
		EObject target = CorrespondenceHelper.getTarget(corr);
		return Logging.getTruePositive(source, target);
	}

	public static String getTruePositive(EObject pmObject, EObject dfdObject) {
		Map<String, Set<String>> map = maps.get(dfdObject.eResource());
		if (map == null || map.size() == 0) {
			init();
		}
		if (map.size() == 0) {
			return "";
		}

		String pmString = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
		pmString = pmString.substring(pmString.indexOf(':') + 1).replaceAll(" ", "");
		String dfdString = MappingLabelProvider.prettyPrint(dfdObject).toLowerCase();
		dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
		if (map.containsKey(dfdString)) {
			if (map.get(dfdString).contains(pmString)) {
				truePositives.add(pmString + " <-> " + dfdString);
				falseNegatives.remove(pmString + " <-> " + dfdString);
				return "+ TRUE POSITIVE";
			}
		}
		if (pmObject instanceof TMember || pmObject instanceof TAbstractType) {
			falsePositives.add(pmString + " <-> " + dfdString);
		}
		return "! FALSE POSITIVE";
	}
}