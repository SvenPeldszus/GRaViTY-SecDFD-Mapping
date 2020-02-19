package org.secdfd.dsl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.HashMultimap;

import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;

public class eSTRIDEMap {
	retrieveEDFDObject eDFD = new retrieveEDFDObject();
	XtextParser parser = new XtextParser();

	public ArrayList<String> strideCategories() {
		ArrayList<String> stride_categories = new ArrayList<>();
		stride_categories.add("Spoofing");
		stride_categories.add("Tampering");
		stride_categories.add("Repudiation");
		stride_categories.add("Information Disclosure");
		stride_categories.add("Denial of Service");
		stride_categories.add("Elevation of Privilege");

		return stride_categories;
	}

	public HashMap<String, String> mappedTable() {

		ArrayList<String> security_objectives = new ArrayList<>();
		security_objectives.add("Authentication");
		security_objectives.add("Integrity");
		security_objectives.add("Accountability");
		security_objectives.add("Confidentiality");
		security_objectives.add("Availability");
		security_objectives.add("Authorization");

		HashMap<String, String> mapped_table = new HashMap<>();
		for (int i = 0; i <= 5; i++) {
			mapped_table.put(security_objectives.get(i), strideCategories().get(i));
		}
		return mapped_table;
	}

	public HashMultimap<String, String> STRIDEMap(File f) throws IOException {
		org.secdfd.model.EDFD contents = (EDFD) parser.parse(URI.createFileURI(f.toString()));

		HashMultimap<String, String> strideMap = HashMultimap.create();

		ArrayList<ExternalEntity> externalEntities = eDFD.getListsOfExternal(contents);
		ArrayList<Process> processes = eDFD.getListsOfProcess(contents);
		ArrayList<DataStore> dataStores = eDFD.getListsOfDataStore(contents);
		for (int i = 0; i < externalEntities.size(); i++) { // External Entities
			strideMap.put(externalEntities.get(i).getName(), strideCategories().get(0));
			strideMap.put(externalEntities.get(i).getName(), strideCategories().get(2));
		}

		for (int i = 0; i < processes.size(); i++) { // Process
			strideMap.put(processes.get(i).getName(), strideCategories().get(0));
			strideMap.put(processes.get(i).getName(), strideCategories().get(1));
			strideMap.put(processes.get(i).getName(), strideCategories().get(2));
			strideMap.put(processes.get(i).getName(), strideCategories().get(3));
			strideMap.put(processes.get(i).getName(), strideCategories().get(4));
			strideMap.put(processes.get(i).getName(), strideCategories().get(5));
		}

		for (int i = 0; i < dataStores.size(); i++) { // Data Store
			strideMap.put(dataStores.get(i).getName(), strideCategories().get(1));
			strideMap.put(dataStores.get(i).getName(), strideCategories().get(2)); // ??
			strideMap.put(dataStores.get(i).getName(), strideCategories().get(3));
			strideMap.put(dataStores.get(i).getName(), strideCategories().get(4));
		}

		for (Element element : contents.getElements()) { // Flows
			for (Flow flow : element.getOutflows()) {
				strideMap.put(flow.getName(), strideCategories().get(1));
				strideMap.put(flow.getName(), strideCategories().get(3));
				strideMap.put(flow.getName(), strideCategories().get(4));
			}
		}
		return strideMap;

	}

	public HashMultimap<String, String> mapToeSTRIDE(File f) throws IOException {
		org.secdfd.model.EDFD contents = (EDFD) parser.parse(URI.createFileURI(f.toString()));
		HashMultimap<String, String> eSTRIDE_table = HashMultimap.create();
		ArrayList<Element> elementAssetsList = new ArrayList<Element>();
		ArrayList<Flow> flowAssetsList = new ArrayList<Flow>();
		HashMultimap<String, String> StrideMap = HashMultimap.create();
		ArrayList<String> keyList_strideMap = new ArrayList<>();

		StrideMap = STRIDEMap(f);
		// GET ASSETS FOR ELEMENTS
		for (Element e : contents.getElements()) { // go through elements
			if (!e.getAssets().isEmpty()) { // check element asset not empty
				for (int i = 0; i < e.getAssets().size(); i++) { // go through elements assets (i)
					if (!e.getAssets().get(i).getValue().isEmpty()) { // check assets values not empty
						for (int j = 0; j < e.getAssets().get(i).getValue().size(); j++) { // go through asset values
																							// (j)
							elementAssetsList.add(e);
						}
					}
				}
			}
			// GET ASSETS FOR FLOWS
			for (Flow flow : e.getOutflows()) {
				if (!flow.getAssets().isEmpty()) {
					for (int i = 0; i < flow.getAssets().size(); i++) {
						if (!flow.getAssets().get(i).getValue().isEmpty()) { // check assets values not empty
							for (int j = 0; j < flow.getAssets().get(i).getValue().size(); j++) { // go through asset
																									// values (j)
								flowAssetsList.add(flow);
							}
						}
					}
				}
			}

		}

		for (String keys : STRIDEMap(f).keySet()) { // Get keys from Stride Map
			keyList_strideMap.add(keys);
		}

		ArrayList<String> keyList_mappedTable = new ArrayList<>();
		for (String keys : mappedTable().keySet()) { // Get keys from Mapped Table
			keyList_mappedTable.add(keys);
		}

// ESTRIDE ELEMENTS
		for (int j = 0; j < elementAssetsList.size(); j++) { // Go through AssetList of elements

			for (int k = 0; k < elementAssetsList.get(j).getAssets().size(); k++) { // Go through elements assets

				for (int l = 0; l < elementAssetsList.get(j).getAssets().get(k).getValue().size(); l++) { // Go through
																											// assets
																											// values

					for (int m = 0; m < keyList_mappedTable.size(); m++) { // Go through keyList for mappedTable
						//
						if (elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()
								.equals(keyList_mappedTable.get(m))) { // Compare Assets objective with mappedTable

							if (elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName()
									.equals("H")
									|| elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority()
											.getName().equals("M")) {

								
								if (StrideMap.get(elementAssetsList.get(j).getName()).contains(mappedTable().get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()))) {
									eSTRIDE_table.put(elementAssetsList.get(j).getName(), mappedTable().get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
								}
//								eSTRIDE_table.put(elementAssetsList.get(j).getName(),
//										mappedTable().get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l)
//												.getObjective().getName()));
							}
						}
						if (StrideMap.get(elementAssetsList.get(j).getName()).contains("Spoofing")) {
							eSTRIDE_table.put(elementAssetsList.get(j).getName(), "Spoofing");
						}
						if (StrideMap.get(elementAssetsList.get(j).getName()).contains("Elevation of Privilege")) {
							eSTRIDE_table.put(elementAssetsList.get(j).getName(), "Elevation of Privilege");
						}
					}
				}
			}
		}

// ESTRIDE FLOWS
		for (int j = 0; j < flowAssetsList.size(); j++) { // Go through AssetList of flow

			for (int k = 0; k < flowAssetsList.get(j).getAssets().size(); k++) { // Go through flow assets

				for (int l = 0; l < flowAssetsList.get(j).getAssets().get(k).getValue().size(); l++) { // Go through
																										// assets values

					for (int m = 0; m < keyList_mappedTable.size(); m++) { // Go through keyList for mappedTable

						if (flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()
								.equals(keyList_mappedTable.get(m))) { // Compare Assets objective with mappedTable

							if (flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName()
									.equals("H")
									|| flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority()
											.getName().equals("M")) {
								
								if (StrideMap.get(flowAssetsList.get(j).getName()).contains(mappedTable().get(flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()))) {
									eSTRIDE_table.put(flowAssetsList.get(j).getName(), mappedTable().get(flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
								}
//								eSTRIDE_table.put(flowAssetsList.get(j).getName(), mappedTable().get(flowAssetsList
//										.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
							}
						}
					}
				}
			}
		}
		return eSTRIDE_table;
	}

}
