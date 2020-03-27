/**
 * 
 */
package org.gravity.flowdroid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IJavaProject;
import com.google.gson.JsonElement;
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
	public static Map<String, List<Map<String, String>>> readGT(IJavaProject project, String fileName, String dfdName) {
		File groundtruthFile = project.getProject().getFile(fileName).getLocation().toFile();
		return parseGroundTruth(groundtruthFile, dfdName);
	}

	/**
	 * @param file
	 * @param dfdName
	 * @return
	 */
	private static Map<String, List<Map<String, String>>> parseGroundTruth(File file, String dfdName) {
		Map<String, List<Map<String, String>>> groundtruth = new HashMap<String, List<Map<String, String>>>();
		if (file.exists()) {
			try {
				JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
				object.getAsJsonArray("contracts").forEach(contract -> {
					if (contract instanceof JsonObject) {
						((JsonObject) contract).entrySet().forEach(e -> {
							String ctype = e.getKey();
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
			} catch (FileNotFoundException e) {
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
	private static Map<String, List<Map<String, String>>> processJsonEntry(String ctype, JsonElement entry,
			Map<String, List<Map<String, String>>> groundtruth) {
		if (entry instanceof JsonObject) {
			HashMap<String, String> newitem = new HashMap<String, String>();
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
	private static Map<String, List<Map<String, String>>> updateGTmap(String ctype, HashMap<String, String> newitem,
			Map<String, List<Map<String, String>>> groundtruth) {
		List<Map<String, String>> items = null;
		items = groundtruth.get(ctype);
		if (items != null) {
			items.add(newitem);
		} else {
			items = new ArrayList<Map<String, String>>();
			items.add(newitem);
		}
		groundtruth.put(ctype, items);
		return groundtruth;
	}

}
