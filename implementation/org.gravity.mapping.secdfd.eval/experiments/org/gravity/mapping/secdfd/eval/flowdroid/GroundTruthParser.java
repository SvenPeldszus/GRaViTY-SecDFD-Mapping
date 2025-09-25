/**
 *
 */
package org.gravity.mapping.secdfd.eval.flowdroid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IJavaProject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author katjat
 *
 */
public final class GroundTruthParser {

	private static final Logger LOGGER = Logger.getLogger(GroundTruthParser.class);

	private GroundTruthParser() {
		// This class shouldn't be instantiated
	}

	/**
	 * @param project
	 * @param dfdName
	 */
	public static Map<String, List<Map<String, String>>> readGT(final IJavaProject project, final String fileName,
			final String dfdName) {
		final var groundtruthFile = project.getProject().getFile(fileName).getLocation().toFile();
		return parseGroundTruth(groundtruthFile, dfdName);
	}

	/**
	 * @param file
	 * @param dfdName
	 * @return
	 */
	private static Map<String, List<Map<String, String>>> parseGroundTruth(final File file, final String dfdName) {
		final Map<String, List<Map<String, String>>> groundtruth = new HashMap<>();
		if (file.exists()) {
			try {
				final var object = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
				object.getAsJsonArray("contracts").forEach(contract -> {
					if (contract instanceof JsonObject) {
						((JsonObject) contract).entrySet().forEach(e -> {
							final var ctype = e.getKey();
							if (((JsonObject) contract).get(e.getKey()) != null) {
								((JsonObject) contract).get(ctype).getAsJsonArray().forEach(entry -> {
									if (((JsonObject) entry).get("secdfd").getAsString().toLowerCase()
											.equals(dfdName)) {
										processJsonEntry(ctype, entry, groundtruth);
									}
								});
							}
						});
					}
				});
			} catch (final FileNotFoundException e) {
				e.printStackTrace();
				LOGGER.error("Ground truth file was not found:" + e.toString());
			}
		} else {
			LOGGER.info("The ground truth file does not exist.");
		}
		return groundtruth;

	}

	/**
	 * @param ctype
	 * @param entry
	 * @param groundtruth
	 * @return
	 */
	private static Map<String, List<Map<String, String>>> processJsonEntry(final String ctype, final JsonElement entry,
			final Map<String, List<Map<String, String>>> groundtruth) {
		if (entry instanceof JsonObject) {
			final var newitem = new HashMap<String, String>();
			newitem.put("secdfd", ((JsonObject) entry).get("secdfd").getAsString().toLowerCase());
			newitem.put("element", ((JsonObject) entry).get("element").getAsString().toLowerCase());
			updateGTmap(ctype, newitem, groundtruth);
		}
		return groundtruth;
	}

	/**
	 * @param ctype
	 * @param newitem
	 * @param update
	 */
	private static Map<String, List<Map<String, String>>> updateGTmap(final String ctype,
			final HashMap<String, String> newitem,
			final Map<String, List<Map<String, String>>> groundtruth) {
		List<Map<String, String>> items = null;
		items = groundtruth.get(ctype);
		if ((items == null)) {
			items = new ArrayList<>();
		}
		items.add(newitem);
		groundtruth.put(ctype, items);
		return groundtruth;
	}

	private static JsonElement toJSON(final Object object) throws JsonIOException {
		if (object instanceof HashMap) {
			final var json = new JsonObject();
			final HashMap<?, ?> map = (HashMap<?, ?>) object;
			for (final Object key : map.keySet()) {
				json.add(key.toString(), toJSON(map.get(key)));
			}
			return json;
		}
		if (!(object instanceof Iterable)) {
			return (JsonElement) object;
		}
		final var json = new JsonArray();
		for (final Object value : ((Iterable<?>) object)) {
			json.add(toJSON(value));
		}
		return json;
	}

	public static void updateGTFile(final File file, final Map<String, List<Map<String, String>>> newContent) {
		if (file.exists()) {
			// Write JSON file
			try (var f = new FileWriter(file.toString())) {
				f.write(toJSON(newContent).toString());
				f.flush();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		} else {
			LOGGER.info("The ground truth file does not exist.");
		}
	}

}
