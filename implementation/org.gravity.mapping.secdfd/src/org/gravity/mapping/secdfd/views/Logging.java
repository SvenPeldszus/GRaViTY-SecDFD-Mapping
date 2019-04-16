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
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Logging {

	private static Map<String, Set<String>> map = null;

	public static HashSet<String> truePositives = new HashSet<String>();
	public static HashSet<String> falsePositives = new HashSet<String>();
	public static HashSet<String> expectedPositives = new HashSet<String>();
	public static HashSet<String> falseNegaives = new HashSet<String>();

	public static boolean init() {
		MappingView mappingView = MappingView.getMappingView();
		for (Mapping mapping : mappingView.getMappings()) {
			File file = mappingView.getProgramModel().getKey().getProject()
					.getFile("groundtruth/" + mapping.getName() + ".json").getLocation().toFile();
			if (file.exists()) {
				try {
					JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
					if (map == null) {
						map = new HashMap<>();
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
		falseNegaives = new HashSet<String>(expectedPositives);
		truePositives = new HashSet<>();
		falsePositives = new HashSet<>();
		if (map == null) {
			map = new HashMap<>();
		}
		return map.size() > 0;
	}

	public static void writeLog(Collection<EObject> corrs) {
		if (map == null || map.size() == 0) {
			return;
		}
		update(corrs);

		// logg
		if (expectedPositives.size() > 0) {
			File file = MappingView.getMappingView().getProgramModel().getKey().getProject()
					.getFile("log/precision_recall_" + System.currentTimeMillis() + ".log").getLocation().toFile();
			int tp = truePositives.size();
			int fp = falsePositives.size();
			int fn = falseNegaives.size();
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
					for (String missed : falseNegaives) {
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
			falseNegaives = new HashSet<String>(expectedPositives);
			truePositives = new HashSet<>();
			falsePositives = new HashSet<>();
		}
	}

	public static void update(Collection<EObject> corrs) {
		if (map == null || map.size() == 0) {
			if (!init()) {
				return;
			}
		}
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
					falseNegaives.remove(pmString + " <-> " + dfdString);
					continue;
				}
			}
			if (pmObject instanceof TMember || pmObject instanceof TAbstractType) {
				falsePositives.add(pmString + " <-> " + dfdString);
			}
		}
	}

	public static String getTruePositive(AbstractCorrespondence corr) {
		EObject source = CorrespondenceHelper.getSource(corr);
		EObject target = CorrespondenceHelper.getTarget(corr);
		return Logging.getTruePositive(source, target);
	}

	public static String getTruePositive(EObject pmObject, EObject dfdObject) {
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
				falseNegaives.remove(pmString + " <-> " + dfdString);
				return "+ TRUE POSITIVE";
			}
		}
		if (pmObject instanceof TMember || pmObject instanceof TAbstractType) {
			falsePositives.add(pmString + " <-> " + dfdString);
		}
		return "! FALSE POSITIVE";
	}
}