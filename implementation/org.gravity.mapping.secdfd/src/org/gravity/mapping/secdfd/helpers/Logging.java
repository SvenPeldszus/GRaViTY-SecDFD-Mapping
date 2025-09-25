package org.gravity.mapping.secdfd.helpers;

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
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.ui.views.MappingLabelProvider;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Logging {

	private static Map<Resource, Map<String, Set<String>>> maps = new HashMap<>();

	public static Map<Resource, HashSet<String>> allExpectedPositives = new HashMap<>();

	public static HashSet<String> truePositives = new HashSet<>();
	public static HashSet<String> falsePositives = new HashSet<>();
	public static HashSet<String> falseNegatives = new HashSet<>();

	public static void init() {
		final var mappingView = MappingView.getMappingView();
		for (final Mapping mapping : mappingView.getMappings()) {
			final var file = mappingView.getProgramModel().getKey().getProject()
					.getFile("groundtruth/" + mapping.getName() + ".json").getLocation().toFile();
			if (file.exists()) {
				final var eResource = mapping.getTarget().eResource();
				final var expectedPositives = new HashSet<String>();
				allExpectedPositives.put(eResource, expectedPositives);
				try {
					final var object = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
					var map = maps.get(eResource);
					if (map == null) {
						map = new HashMap<>();
						maps.put(eResource, map);
					}
					for (final JsonElement jsonElement : object.getAsJsonArray("mappings")) {
						if (jsonElement instanceof JsonObject) {
							final var pm = ((JsonObject) jsonElement).get("pm").getAsString().toLowerCase().replace(
									" ",
									"");
							final var dfd = ((JsonObject) jsonElement).get("secdfd").getAsString().toLowerCase()
									.replace(" ", "");
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
				} catch (final FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		falseNegatives = new HashSet<>();
		truePositives = new HashSet<>();
		falsePositives = new HashSet<>();
	}

	public static void writeLog(final Collection<AbstractCorrespondence> corrs) {
		if (update(corrs)) {
			final var file = MappingView.getMappingView().getProgramModel().getKey().getProject()
					.getFile("log/precision_recall_" + System.currentTimeMillis() + ".log").getLocation().toFile();
			final var tp = truePositives.size();
			final var fp = falsePositives.size();
			final var fn = falseNegatives.size();
			final var precission = (double) tp / (tp + fp);
			final var recall = (double) tp / (tp + fn);
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
				try (var writer = new FileWriter(file, true)) {
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
					for (final String missed : falseNegatives) {
						writer.append(missed);
						writer.append('\n');
					}
					writer.append("\nFalse positives:\n");
					for (final String wrong : falsePositives) {
						writer.append(wrong);
						writer.append('\n');
					}
					writer.append('\n');
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean update(final Collection<AbstractCorrespondence> corrs) {
		if (corrs.isEmpty()) {
			return true;
		}
		final var eResource = CorrespondenceHelper.getTarget(corrs.iterator().next()).eResource();
		var map = maps.get(eResource);
		if (map == null || map.isEmpty()) {
			init();
			map = maps.get(eResource);
		}
		if (map == null || map.isEmpty()) {
			return false;
		}

		falseNegatives = new HashSet<>(allExpectedPositives.get(eResource));
		truePositives = new HashSet<>();
		falsePositives = new HashSet<>();
		for (final AbstractCorrespondence corr : corrs.parallelStream()
				.filter(AbstractCorrespondence.class::isInstance)
				.map(corr -> corr).collect(Collectors.toList())) {
			final var pmObject = CorrespondenceHelper.getSource(corr);
			var pmString = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
			pmString = pmString.substring(pmString.indexOf(':') + 1).replace(" ", "");

			final var dfdObject = CorrespondenceHelper.getTarget(corr);
			var dfdString = MappingLabelProvider.prettyPrint(dfdObject).toLowerCase();
			dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replace(" ", "");

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

	public static String getTruePositive(final AbstractCorrespondence corr) {
		final var source = CorrespondenceHelper.getSource(corr);
		final var target = CorrespondenceHelper.getTarget(corr);
		return Logging.getTruePositive(source, target);
	}

	public static String getTruePositive(final EObject pmObject, final EObject dfdObject) {
		var map = maps.get(dfdObject.eResource());
		if (map == null || map.isEmpty()) {
			init();
			map = maps.get(dfdObject.eResource());
		}
		if (map == null || map.isEmpty()) {
			return "";
		}

		var pmString = MappingLabelProvider.prettyPrint(pmObject).toLowerCase();
		pmString = pmString.substring(pmString.indexOf(':') + 1).replace(" ", "");
		var dfdString = MappingLabelProvider.prettyPrint(dfdObject).toLowerCase();
		dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replace(" ", "");
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