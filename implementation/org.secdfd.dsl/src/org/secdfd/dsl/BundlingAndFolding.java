package org.secdfd.dsl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import org.secdfd.model.Asset;
import org.secdfd.model.Assumption;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.Flow;
import org.secdfd.model.Objective;
import org.secdfd.model.Process;
import org.secdfd.model.Value;

public class BundlingAndFolding {
	retrieveEDFDObject eDFD = new retrieveEDFDObject();
	XtextParser parser = new XtextParser();

	public Set<Flow> FlowBundle(File f) throws IOException {
		org.secdfd.model.EDFD contents = (EDFD) parser.parse(URI.createFileURI(f.toString()));

		Set<Flow> suggestionList = new HashSet<>();
		for (Element ee : contents.getElements()) { // Get all elements
			for (Flow flow : ee.getOutflows()) { // Get all outflows for those elements
				for (Flow matchFlow : ee.getOutflows()) { // Get all outflows for the same element to compare

					boolean toBundle = true;

					if (flow != matchFlow && flow.getTarget().equals(matchFlow.getTarget())) { // Check if flows have
																								// same target
						if (!flow.getAssets().isEmpty() && !matchFlow.getAssets().isEmpty()) { // Check if Assets are
																								// empty
							for (Value value : flow.getAssets().get(0).getValue()) { // Add only if the asset priority
																						// is low or medium
//								System.out.println("1st value: " + value);
//								System.out.println("1st priority: " + value.getPriority());

								if (value.getPriority().getName().equals("H")) {
									toBundle = false;
								}
							}
							for (Value value : matchFlow.getAssets().get(0).getValue()) {
								if (value.getPriority().getName().equals("H")) {
									toBundle = false;
								}
							}
							if (toBundle && flow.getChannel() == matchFlow.getChannel()) {
								suggestionList.add(flow);
								suggestionList.add(matchFlow);
							}
						}
					}
				}
			}
		}
		return suggestionList;
	}

	public ArrayList<ArrayList<Process>> ProcessFold(File f) throws IOException {
		org.secdfd.model.EDFD contents = (EDFD) parser.parse(URI.createFileURI(f.toString()));
		ArrayList<Process> processes = eDFD.getListsOfProcess(contents);

		Set<Process> suggestionListProcess = new HashSet<>();
		Set<Process> suggestionListObjectivesMatched = new HashSet<>();
		Set<Process> suggestionListAssumptionNotMatched = new HashSet<>();
		ArrayList<ArrayList<Process>> pair = new ArrayList<ArrayList<Process>>();
		ArrayList<ArrayList<Process>> finalPair = new ArrayList<ArrayList<Process>>();

		for (Process p : processes) { 
				for (int i = 0; i < processes.size(); i++) {
					boolean isCritical = false;
					ArrayList<Flow> srcTar = new ArrayList<>();
					ArrayList<Process> flowsMatch = new ArrayList<>();
					for (Flow outflow : p.getOutflows()) {
						if (outflow.getTarget().get(0).getName().equals(processes.get(i).getName())) { // Target check
																										// and get flows
																										// between
																										// source and
																										// target, check
																										// if flows between processes
																										// are critical
							
							if (!outflow.getAssets().isEmpty()) {
								for (Asset as : outflow.getAssets()) {
									for (Value v : as.getValue()) {
										if (v.getPriority().getName().equals("H")) {
//									System.out.println("NO Folding possible : " + p.getName());
											isCritical = true;
										}
									}
								}
							}
							
							srcTar.add(outflow);
							// Outflow check for carrying assets
							Iterator<Asset> iterator = outflow.getAssets().iterator();
							while (iterator.hasNext()) {
								for (Value val : iterator.next().getValue()) {
									// Get first process and check surrounding assumptions that are assigned,
									// if ass = true, check, if ass = false, Make an assumption

									if (!p.getAssumption().isEmpty()) {
										Iterator<Assumption> assumptionIt = p.getAssumption().iterator();
										while (assumptionIt.hasNext()) {
											for (Objective obj : assumptionIt.next().getObjective()) {
												// Check assumption objective value == assets objective value,
												// suggestion list
												if (obj.getName().equals(val.getObjective().getName())) {
													suggestionListObjectivesMatched.add(p); // Objectives Matched
													flowsMatch.add(processes.get(i));
												}
												suggestionListAssumptionNotMatched.add(p); // Objectives do not match
											}
										}
									} else {
										suggestionListProcess.add(p); // No assumption made
									}

								}
							}
						}

						for (Flow inflows : p.getInflows()) {// check for priorities of flows that dont go to process
							if (inflows.getSource().getName().equals(processes.get(i).getName())) { // Target check and
																									// get flows between
																									// source and
																									// target, check if
																									// flows between processes
																									// critical
								
								if (!inflows.getAssets().isEmpty()) {
									for (Asset as : inflows.getAssets()) {
										for (Value v : as.getValue()) {
											if (v.getPriority().getName().equals("H")) {
//										System.out.println("NO Folding possible : " + p.getName());
												isCritical = true;
											}
										}
									}
								}
								
								srcTar.add(inflows);
								// Outflow check for carrying assets
								Iterator<Asset> iterator = inflows.getAssets().iterator();
								while (iterator.hasNext()) {
									for (Value val : iterator.next().getValue()) {
										// Get first process and check surrounding assumptions that are assigned,
										// if ass = true, check, if ass = false, Make an assumption

										if (!p.getAssumption().isEmpty()) {
											Iterator<Assumption> assumptionIt = p.getAssumption().iterator();
											while (assumptionIt.hasNext()) {
												for (Objective obj : assumptionIt.next().getObjective()) {
													// Check assumption objective value == assets objective value,
													// suggestion list
													if (obj.getName().equals(val.getObjective().getName())) {
														suggestionListObjectivesMatched.add(p); // Objectives Matched
														flowsMatch.add(processes.get(i));
													}
													suggestionListAssumptionNotMatched.add(p); // Objectives do not
																								// match
												}
											}
										} else {
											suggestionListProcess.add(p); // No assumption made
										}

									}
								}
							}
						}	
					}
					
					if(!isCritical) { // Compare A and B process that had an assumption If they are not critical, after target/source loops
						for (Process process : flowsMatch) {
							ArrayList<Process> First = new ArrayList<>();
							First.add(p);
							First.add(process);
							pair.add(First); // and add both processes as pairs
						}
					}
					
//					boolean isNotSame = false;   //check if they have the same channels
//					for (int j = 1; j < srcTar.size(); j++) {
//						if (!srcTar.get(j).getChannel().getName().equals(srcTar.get(0).getChannel().getName())) { // not
//																													// equal
//							isNotSame = true;
//						}
//					}
//					if (isNotSame == false) {
//						for (Process process : flowsMatch) {
//							ArrayList<Process> First = new ArrayList<>();
//							First.add(p);
//							First.add(process);
//							pair.add(First);
//						}
//					}
				}
			} // Compare A and B process If they are not critical, after target/source loops
				// and both processes as pairs

//		}
		for (ArrayList<Process> l : pair) {
//			boolean First = false;
//			boolean Second = false;
//			for (int i = 0; i < nonCriticalProcess.size(); i++) {
//
//				if (l.get(0).equals(nonCriticalProcess.get(i))) {
//					First = true;
//				}
//				if (l.get(1).equals(nonCriticalProcess.get(i))) {
//					Second = true;
//				}
//			}
//			if (First == true && Second == true) {
				if (!finalPair.contains(l)) {
					finalPair.add(l);
				}
//			}
		}
		return finalPair;
	}

	public ArrayList<Process> getListsOfProcess(EObject e) {

		ArrayList<Process> processes = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				processes.add((Process) e.eContents().get(i));
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return processes;
	}

	public ArrayList<Asset> getListsOfAssets(EObject e) {

		ArrayList<Asset> assets = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				assets.add((Asset) e.eContents().get(i));
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return assets;
	}

}
