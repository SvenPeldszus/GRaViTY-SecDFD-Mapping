package org.secdfd.dsl;
//package org.secdfd.dsl;
//
//import java.awt.List;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EObject;
//import com.google.common.collect.HashMultimap;
//import org.secdfd.model.Asset;
//import org.secdfd.model.Assumption;
//import org.secdfd.model.DataStore;
//import org.secdfd.model.EDFD;
//import org.secdfd.model.Element;
//import org.secdfd.model.ExternalEntity;
//import org.secdfd.model.Flow;
//import org.secdfd.model.Objective;
//import org.secdfd.model.Process;
//import org.secdfd.model.Value;
//
//public class old_eSTRIDE_file {
//
//	public static void main(String[] args) throws IOException {
//
//		XtextParser parser = new XtextParser();
//
//		File f = new File(
//				"C:\\Users\\Karan\\Git Projects\\Thesis\\ArchitecturalThreatAnalysis\\runtime\\xText\\src\\eDFD.secdfd");
//		org.secdfd.model.EDFD contents = (EDFD) parser.parse(URI.createFileURI(f.toString()));
//		/*
//		 * for(int i = 0; i < contents.getAsset().size(); i++) { //
//		 * System.out.println(contents.getAsset().get(i) + " "+
//		 * contents.getAsset().get(i).getValue().get(0).getPriority()); //
//		 * System.out.println(contents.getAsset().get(i)); }
//		 * 
//		 * for(int i = 0; i < contents.getElements().size(); i++) { //
//		 * System.out.println(contents.getElements().get(i)); }
//		 */
//		retrieveEDFDObject eDFD = new retrieveEDFDObject();
//
//		ArrayList<String> stride_categories = new ArrayList<>();
//		stride_categories.add("Spoofing");
//		stride_categories.add("Tampering");
//		stride_categories.add("Repudiation");
//		stride_categories.add("Information Disclosure");
//		stride_categories.add("Denial of Service");
//		stride_categories.add("Elevation of Privilege");
//
//		ArrayList<String> security_objectives = new ArrayList<>();
//		security_objectives.add("Authentication");
//		security_objectives.add("Integrity");
//		security_objectives.add("Accountability");
//		security_objectives.add("Confidentiality");
//		security_objectives.add("Availability");
//		security_objectives.add("Authorization");
//
//		HashMap<String, String> mapped_table = new HashMap<>();
//		for(int i = 0 ; i <=5 ; i++) {
//			mapped_table.put(security_objectives.get(i), stride_categories.get(i));
//		}
//		
//	//	System.out.println(Collections.singletonList(mapped_table));
//
//		Set<Flow> suggestionList = new HashSet<>();
//
//		HashMultimap<String, String> strideMap = HashMultimap.create();
//		
//		ArrayList<ExternalEntity> externalEntities = eDFD.getListsOfExternal(contents);
//		ArrayList<Process> processes = eDFD.getListsOfProcess(contents);
//		ArrayList<DataStore> dataStores = eDFD.getListsOfDataStore(contents);
//		for (int i = 0; i < externalEntities.size(); i++) { // External Entities
//			strideMap.put(externalEntities.get(i).getName(), stride_categories.get(0));
//			strideMap.put(externalEntities.get(i).getName(), stride_categories.get(2));
//		}
//
//		for (int i = 0; i < processes.size(); i++) { // Process
//			strideMap.put(processes.get(i).getName(), stride_categories.get(0));
//			strideMap.put(processes.get(i).getName(), stride_categories.get(1));
//			strideMap.put(processes.get(i).getName(), stride_categories.get(2));
//			strideMap.put(processes.get(i).getName(), stride_categories.get(3));
//			strideMap.put(processes.get(i).getName(), stride_categories.get(4));
//			strideMap.put(processes.get(i).getName(), stride_categories.get(5));
//		}
//
//		for (int i = 0; i < dataStores.size(); i++) { // Data Store
//			strideMap.put(dataStores.get(i).getName(), stride_categories.get(1));
//			strideMap.put(dataStores.get(i).getName(), stride_categories.get(2)); // ??
//			strideMap.put(dataStores.get(i).getName(), stride_categories.get(3));
//			strideMap.put(dataStores.get(i).getName(), stride_categories.get(4));
//		}
//
//		for (Element element : contents.getElements()) { // Flows
//			for (Flow flow : element.getOutflows()) {
//				strideMap.put(flow.getName(), stride_categories.get(1));
//				strideMap.put(flow.getName(), stride_categories.get(3));
//				strideMap.put(flow.getName(), stride_categories.get(4));
//			}
//		}
//
////		System.out.println("STRIDE MAP: " + Collections.singletonList(strideMap));
//	
////		for(String keys : strideMap.keySet()) {
////			System.out.println(keys + " :   " +strideMap.get(keys));
////		}
////		System.out.println(strideMap.keySet().size());
//		
//		
//		
//
////------Data Bundling Process---------------------------      
//		for (Element ee : contents.getElements()) { // Get all elements
//			for (Flow flow : ee.getOutflows()) { // Get all outflows for those elements
//				for (Flow matchFlow : ee.getOutflows()) { // Get all outflows for the same element to compare
//
//					boolean toBundle = true;
//
//					if (flow != matchFlow && flow.getTarget().equals(matchFlow.getTarget())) { // Check if flows have
//																								// same target
//						if (!flow.getAssets().isEmpty() && !matchFlow.getAssets().isEmpty()) { // Check if Assets are
//																								// empty
//							for (Value value : flow.getAssets().get(0).getValue()) { // Add only if the asset priority
//																						// is low or medium
////								System.out.println("1st value: " + value);
////								System.out.println("1st priority: " + value.getPriority());
//
//								if (value.getPriority().getName().equals("H")) {
//									toBundle = false;
//								}
//							}
//							for (Value value : matchFlow.getAssets().get(0).getValue()) {
//								if (value.getPriority().getName().equals("H")) {
//									toBundle = false;
//								}
//							}
//							if (toBundle && flow.getChannel() == matchFlow.getChannel()) {
//								suggestionList.add(flow);
//								suggestionList.add(matchFlow);
//							}
//						}
//					}
//				}
//			}
//		}
//
////		System.out.println(suggestionList.size());
////		System.out.println(suggestionList.toString());
//		/*
//		 * for (Flow temp : suggestionList) {
//		 * System.out.println("Flows that can be bundled: " + temp.getName()); }
//		 */
////------------------------------------------------
//		
//		
////------eSTRIDE----------------------------------- 
//
//					
//			ArrayList<Element> elementAssetsList = new ArrayList<Element>();
//			
//			ArrayList<Flow> flowAssetsList = new ArrayList<Flow>();
//			
//			// GET ASSETS FOR ELEMENTS
//			for(Element e : contents.getElements()) {	//go through elements
//				if(!e.getAssets().isEmpty()) {	//check element asset not empty
//					for(int i =0; i < e.getAssets().size(); i++) {	// go through elements assets (i)
//						if(!e.getAssets().get(i).getValue().isEmpty()) {	//check assets values not empty
//							for(int j = 0 ; j < e.getAssets().get(i).getValue().size() ; j++) {	//go through asset values (j)
//								elementAssetsList.add(e);
//			//					System.out.println(
//			//							"\n  Element: " + e.getName() +
//			//							"\n  Assets Name: " + e.getAssets().get(i).getName() +
//			//							"\n  Asset Objective: "+ e.getAssets().get(i).getValue().get(j).getObjective());
//							}
//						}
//					}
//				}
//			//System.out.println(elementAssetsList.toString());
//			// GET ASSETS FOR FLOWS	
//				for(Flow flow : e.getOutflows()) {
//					if(!flow.getAssets().isEmpty()) {
//						for(int i =0; i < flow.getAssets().size(); i++) {
//							if(!flow.getAssets().get(i).getValue().isEmpty()) {	//check assets values not empty
//								for(int j = 0 ; j < flow.getAssets().get(i).getValue().size() ; j++) {	//go through asset values (j)
//									flowAssetsList.add(flow);
//			//						System.out.println(
//			//								"\n  Flow: " + flow.getName() +
//			//								"\n  Assets Name: " + flow.getAssets().get(i).getName() +
//			//								"\n  Asset Objective: "+ flow.getAssets().get(i).getValue().get(j).getObjective());
//								}
//							}
//						}
//					}
//				}
//				
//			}
//
//// MAPPING 
//			HashMultimap<String, String> eSTRIDE_table = HashMultimap.create();;
//			
//			ArrayList<String> keyList_strideMap = new ArrayList<>();
//			for(String keys : strideMap.keySet()) {		// Get keys from Stride Map
//				keyList_strideMap.add(keys);
//			}
//	
//			ArrayList<String> keyList_mappedTable = new ArrayList<>();
//			for(String keys : mapped_table.keySet()) {		// Get keys from Mapped Table
//				keyList_mappedTable.add(keys);
//			}
//			
//	//		System.out.println("Mapped table : " +Collections.singletonList(mapped_table));		
//	//		System.out.println(Collections.singletonList(keyList));
//			
//			// Go through stride map and take the first element
//			// Get Assets Name and Objectives from above
//			// Check if Asset exists in the stride map 		
//			// Go through Mapped Table to get all the security obj
//			// Compare Assets Objectives with Sec objectives(mapped table)
//			// If any assets objective matches the table and priority is H, we add to eSTRIDE Table		
//				System.out.println();	
//// ESTRIDE ELEMENTS
//			for(int j = 0 ; j < elementAssetsList.size() ; j++) {	// Go through AssetList of elements
//				
//				for(int k = 0 ; k < elementAssetsList.get(j).getAssets().size() ; k++) {	// Go through elements assets
//					
//					for(int l = 0; l < elementAssetsList.get(j).getAssets().get(k).getValue().size(); l++) {	// Go through assets values
//						
//						for(int m = 0 ; m < keyList_mappedTable.size(); m++) {		// Go through keyList for mappedTable
//							//
//							if(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName().equals(keyList_mappedTable.get(m))) {	// Compare Assets objective with mappedTable
//					
//								if(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName().equals("H") 
//										|| elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName().equals("M")){
//									
////									System.out.println("Name: "+elementAssetsList.get(j).getName() 
////											+"  Matches: " + elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName() 
////											+"  has priority: "+ elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority()
////											+"  STRIDE Category: " + mapped_table.get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
//									//check if stridemap for key element.name and corresponding values if includes S or E and add if does									
//									eSTRIDE_table.put(elementAssetsList.get(j).getName(),mapped_table.get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
//								}						
//							}
//								if (strideMap.get(elementAssetsList.get(j).getName()).contains("Spoofing")) {
//									// System.out.println(strideMap.get(elementAssetsList.get(j).getName()) + "" +
//									// elementAssetsList.get(j).getName());
//									eSTRIDE_table.put(elementAssetsList.get(j).getName(), "Spoofing");
//								}
//								if (strideMap.get(elementAssetsList.get(j).getName()).contains("Elevation of Privilege")) {
//									// System.out.println(strideMap.get(elementAssetsList.get(j).getName()) + "" +
//									// elementAssetsList.get(j).getName());
//									eSTRIDE_table.put(elementAssetsList.get(j).getName(), "Elevation of Privilege");
//								}
//						}
//					}
//				}
//			}
//
//// ESTRIDE FLOWS
//			for(int j = 0 ; j < flowAssetsList.size() ; j++) {	// Go through AssetList of flow
//							
//							for(int k = 0 ; k < flowAssetsList.get(j).getAssets().size() ; k++) {	// Go through flow assets
//								
//								for(int l = 0; l < flowAssetsList.get(j).getAssets().get(k).getValue().size(); l++) {	// Go through assets values
//									
//									for(int m = 0 ; m < keyList_mappedTable.size(); m++) {		// Go through keyList for mappedTable
//										
//										if(flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName().equals(keyList_mappedTable.get(m))) {	// Compare Assets objective with mappedTable
//								
//											if(flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName().equals("H") 
//													|| flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority().getName().equals("M")){
//												
//												
////												System.out.println("Name: "+elementAssetsList.get(j).getName() 
////														+"  Matches: " + elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName() 
////														+"  has priority: "+ elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getPriority()
////														+"  STRIDE Category: " + mapped_table.get(elementAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
//												eSTRIDE_table.put(flowAssetsList.get(j).getName(),mapped_table.get(flowAssetsList.get(j).getAssets().get(k).getValue().get(l).getObjective().getName()));
//											}	
//										}
//									}
//								}
//							}
//						}
//
//	//		System.out.println("eSTRIDE Table is : " + Collections.singletonList(eSTRIDE_table));
//		//-------------------------------------------------------------------
//
////------Process Folding----------------------------------------------
//			Set<Process> suggestionListPr = new HashSet<>();
//			Set<Process> suggestionListObj = new HashSet<>();
//			Set<Process> suggestionListPrFlow = new HashSet<>();
//			Set<Process> suggestionListAssumptionNot = new HashSet<>();
//			ArrayList<Process> nonCriticalProcess = new ArrayList<>();
//			ArrayList<ArrayList<Process>> pair = new ArrayList<ArrayList<Process>>();
//			ArrayList<ArrayList<Process>> finalPair = new ArrayList<ArrayList<Process>>();
//			
//			for (Process p : processes) { // Get Inflows too
//				boolean isCritical = false;
//				if(!p.getAssets().isEmpty()){
//				for(Asset as: p.getAssets()) {//we should actually check the inflows and outflows as well , unless our model adds all assets to a Process
//				for(Value v: as.getValue())  {
//					if (v.getPriority().getName().equals("H")) {
//	//					System.out.println("NO Folding possible : " + p.getName());
//						isCritical = true;
//					} 
//				}
//				}
//				}
//				
//				if(isCritical == false) {
//					nonCriticalProcess.add(p);
//
//				for (int i = 0; i < processes.size(); i++) {	
//					ArrayList<Flow> srcTar = new ArrayList<>();
//					ArrayList<Process> outflowMatch = new ArrayList<>();
//					for (Flow outflow : p.getOutflows()) {
//							if(outflow.getTarget().get(0).getName().equals(processes.get(i).getName())) { //Target check and get flows between source and target, check if Process.get(i) is critical
//								srcTar.add(outflow);
//									// Outflow check for carrying assets
//									Iterator<Asset> iterator = outflow.getAssets().iterator();
//									while (iterator.hasNext()) {
//										for (Value val : iterator.next().getValue()) {
//											// Get first process and check surrounding assumptions that are assigned,
//											// if ass = true, check, if ass = false, Make an assumption
//											
//											if(!p.getAssumption().isEmpty()) {
//												Iterator<Assumption> assumptionIt = p.getAssumption().iterator();
//												while (assumptionIt.hasNext()) {
//													for (Objective obj : assumptionIt.next().getObjective()) { 
//														// Check assumption objective value == assets objective value, suggestion list
//														if(obj.getName().equals(val.getObjective().getName())) {
//															suggestionListObj.add(p); //Objectives Matched
//															outflowMatch.add(processes.get(i));
//														}
//														suggestionListAssumptionNot.add(p); // Objectives do not match
//													}
//												}
//											} else {
//											suggestionListPr.add(p);  // No assumption made
//											}
//													
//										}
//									}
//									}
//						 
//					
//					for (Flow inflows : p.getInflows()) {//check for priorities of flows that dont go to process
//						if(inflows.getSource().getName().equals(processes.get(i).getName())) { //Target check and get flows between source and target, check if Process.get(i) is critical
//							srcTar.add(inflows);
//								// Outflow check for carrying assets
//								Iterator<Asset> iterator = inflows.getAssets().iterator();
//								while (iterator.hasNext()) {
//									for (Value val : iterator.next().getValue()) {
//										// Get first process and check surrounding assumptions that are assigned,
//										// if ass = true, check, if ass = false, Make an assumption
//										
//										if(!p.getAssumption().isEmpty()) {
//											Iterator<Assumption> assumptionIt = p.getAssumption().iterator();
//											while (assumptionIt.hasNext()) {
//												for (Objective obj : assumptionIt.next().getObjective()) { 
//													// Check assumption objective value == assets objective value, suggestion list
//													if(obj.getName().equals(val.getObjective().getName())) {
//														suggestionListObj.add(p); //Objectives Matched
//														outflowMatch.add(processes.get(i));
//													}
//													suggestionListAssumptionNot.add(p); // Objectives do not match
//												}
//											}
//										} else {
//										suggestionListPr.add(p);  // No assumption made
//										}
//												
//									}
//								}
//								}
//					} 
//					}
//					boolean isNotSame = false;
//					for(int j = 1 ; j < srcTar.size(); j++) {
//						if(!srcTar.get(j).getChannel().getName().equals(srcTar.get(0).getChannel().getName())) { // not equal
//							isNotSame = true;
//						} 
//					}
//					if(isNotSame == false) {
//						for(Process pp : outflowMatch) {
//							ArrayList<Process> First = new ArrayList<>();
//							First.add(p);
//							First.add(pp);
//							pair.add(First);
//						}
//						suggestionListPrFlow.add(p);
//					} 
//				}
//			}// Compare A and B process If they are not critical, after target/source loops and both processes as pairs
//				
//			}
//		for(ArrayList<Process> l : pair) {
//			boolean First = false;
//			boolean Second = false;
//			for(int i = 0 ; i < nonCriticalProcess.size() ; i++) {
//				
//		if(l.get(0).equals(nonCriticalProcess.get(i))) {
//			First = true;
//		}
//		if(l.get(1).equals(nonCriticalProcess.get(i))) {
//			Second = true;
//		}
//		}
//		if(First == true && Second == true) {
//			if(!finalPair.contains(l)) {
//				finalPair.add(l);	
//			}
//		} 
//		}
//		
////-------------------------Process Folding Suggestions------------------------------------------------		
//			System.out.println(String.format("%25s %25s", "Process Folding Suggestions", "|" ));
//			System.out.println(String.format("%s", "-----------------------------------------------------"));
//			for(int i =0; i < finalPair.size();i++) {
//				System.out.println(String.format("%-25s %25s", finalPair.get(i).get(i).getName(),finalPair.get(i).get(i+1).getName()));
//			}
//			System.out.println();
//			System.out.println();
////-------------------------------eSTRIDE Threat Table-------------------------------------------
//			System.out.println("eSTRIDE Threat Table: ");
//			System.out.println();
//			System.out.println(String.format("%25s %25s %70s %50s", "Entity", "|", "STRIDE Category", "|" ));
//			System.out.println(String.format("%s", "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
//
//			for(String key: eSTRIDE_table.keySet()) {	
//				System.out.println(String.format("%-25s %25s %-70s %50s", key, "|", eSTRIDE_table.get(key), "|"  ));			
//			}
////--------------------------------------------------------------------------
//
//	}
//	
//}
//
//class retrieveEDFDObject {
//
//	public ArrayList<Asset> getListsOfAssets(EObject e) {
//
//		ArrayList<Asset> assets = new ArrayList<>();
//		for (int i = 0; i < e.eContents().size(); i++) {
//			try {
//				assets.add((Asset) e.eContents().get(i));
//			} catch (Exception es) {
//				// TODO: handle exception
//			}
//		}
//		return assets;
//	}
//
//	public ArrayList<Process> getListsOfProcess(EObject e) {
//
//		ArrayList<Process> processes = new ArrayList<>();
//		for (int i = 0; i < e.eContents().size(); i++) {
//			try {
//				processes.add((Process) e.eContents().get(i));
//			} catch (Exception es) {
//				// TODO: handle exception
//			}
//		}
//		return processes;
//	}
//
//	public ArrayList<ExternalEntity> getListsOfExternal(EObject e) {
//
//		ArrayList<ExternalEntity> externalEntities = new ArrayList<>();
//		for (int i = 0; i < e.eContents().size(); i++) {
//			try {
//				externalEntities.add((ExternalEntity) e.eContents().get(i));
//			} catch (Exception es) {
//				// TODO: handle exception
//			}
//		}
//		return externalEntities;
//	}
//
//	public ArrayList<DataStore> getListsOfDataStore(EObject e) {
//
//		ArrayList<DataStore> dataStores = new ArrayList<>();
//		for (int i = 0; i < e.eContents().size(); i++) {
//			try {
//				dataStores.add((DataStore) e.eContents().get(i));
//			} catch (Exception es) {
//				// TODO: handle exception
//			}
//		}
//		return dataStores;
//	}
//
//	public ArrayList<Flow> getFlowsOfProcess(ArrayList<Process> list) {
//
//		ArrayList<Flow> flowsOfProcess = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
//				flowsOfProcess.add((Flow) list.get(i).getOutflows().get(j));
//			}
//		}
//		return flowsOfProcess;
//	}
//
//	public ArrayList<Flow> getFlowsOfExternal(ArrayList<ExternalEntity> list) {
//
//		ArrayList<Flow> flowsOfExternalEntities = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
//				flowsOfExternalEntities.add((Flow) list.get(i).getOutflows().get(j));
//			}
//		}
//		return flowsOfExternalEntities;
//	}
//
//	public ArrayList<Flow> getFlowsOfData(ArrayList<DataStore> list) {
//
//		ArrayList<Flow> flowsOfData = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
//				flowsOfData.add((Flow) list.get(i).getOutflows().get(j));
//			}
//		}
//		return flowsOfData;
//	}
//	/*
//	 * public ArrayList<Flow> getFlowsOfElement(ArrayList<org.secdfd.model.Element>
//	 * list) {
//	 * 
//	 * ArrayList<Flow> flowsOfElement = new ArrayList<>(); for (int i = 0; i <
//	 * list.size(); i++) { for (int j = 0; j < list.get(i).getOutflows().size();
//	 * j++) { flowsOfElement.add((Flow) list.get(i).getOutflows().get(j)); } }
//	 * return flowsOfElement; }
//	 */
//
//}
