package org.secdfd.dsl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import com.google.common.collect.HashMultimap;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;

public class eSTRIDE {

	public static void main(String[] args) throws IOException {

		BundlingAndFolding bundle = new BundlingAndFolding();
		eSTRIDEMap estride = new eSTRIDEMap();
		Scanner choice = new Scanner(System.in);
		Date now = new java.util.Date();
		Timestamp current = new java.sql.Timestamp(now.getTime());
		PrintWriter writer = new PrintWriter("results" + current.getNanos() +  ".txt", "UTF-8");		
		
		System.out.println("Input path to the .secdfd file, including the file name + extension name");
		String path = choice.next();
		File inputModel = new File(path);
		Set<Flow> suggestionList = new HashSet<>();
		HashMultimap<String, String> FlowBundlingTable = HashMultimap.create();
		
		// ------Data Bundling Process---------------------------
		suggestionList = bundle.FlowBundle(inputModel);
		// ------eSTRIDE-----------------------------------
		HashMultimap<String, String> eSTRIDETable = estride.mapToeSTRIDE(inputModel);
		// ------Process Folding----------------------------------------------
		ArrayList<ArrayList<Process>> finalPair = new ArrayList<ArrayList<Process>>();
		finalPair = bundle.ProcessFold(inputModel);
		// ----PRINTING----
		while (true) {
			System.out.println("0 Suggestion List, 1 eSTRIDE, 2 exit");
			int n = choice.nextInt();
			if (n == 0) {
				// -------------------------Process Folding
				// Suggestions------------------------------------------------
				System.out.println(String.format("%25s %23s", "Process Folding Suggestions", "|"));
				System.out.println(String.format("%s", "---------------------------------------------------"));
				writer.println(String.format("%25s %23s", "Process Folding Suggestions", "|"));
				writer.println(String.format("%s", "---------------------------------------------------"));
				for (int i = 0; i < finalPair.size(); i++) {
					System.out.println(String.format("%-25s %25s", finalPair.get(i).get(0).getName(),
							finalPair.get(i).get(1).getName()));
					writer.println(String.format("%-25s %25s", finalPair.get(i).get(0).getName(),
							finalPair.get(i).get(1).getName()));
				}
				System.out.println();
				writer.println();
				System.out.println();
				writer.println();

				// -------------------------Flow Bundling
				// Suggestions------------------------------------------------
				System.out.println("Data Bundling Suggestions: ");
				System.out.println(String.format("%25s %25s %70s %50s", "Entity", "|", "Flows", "|"));
				System.out.println(String.format("%s",
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
				writer.println("Data Bundling Suggestions: ");
				writer.println(String.format("%25s %25s %70s %50s", "Entity", "|", "Flows", "|"));
				writer.println(String.format("%s",
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));

				for (Flow flow : suggestionList) {
					for (Flow matchFlow : suggestionList) {
						if (flow.getSource().getName().equals(matchFlow.getSource().getName())) {
							FlowBundlingTable.put(flow.getSource().getName(), flow.getName());
							FlowBundlingTable.put(matchFlow.getSource().getName(), flow.getName());
						}
					}
				}
				for (String key : FlowBundlingTable.keySet()) {
					System.out
							.println(String.format("%-25s %25s %-70s %50s", key, "|", FlowBundlingTable.get(key), "|"));
					writer.println(String.format("%-25s %25s %-70s %50s", key, "|", FlowBundlingTable.get(key), "|"));
				}
				System.out.println("");
				writer.println("");
				System.out.println("");
				writer.println("");
			} else if (n == 1) {
//-------------------------------eSTRIDE Threat Table-------------------------------------------
				System.out.println("eSTRIDE Threat Table: ");
				System.out.println();
				System.out.println(String.format("%25s %25s %70s %50s", "Entity", "|", "STRIDE Category", "|"));
				System.out.println(String.format("%s",
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
				writer.println("eSTRIDE Threat Table: ");
				writer.println();
				writer.println(String.format("%25s %25s %70s %50s", "Entity", "|", "STRIDE Category", "|"));
				writer.println(String.format("%s",
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));

				for (String key : eSTRIDETable.keySet()) {
					System.out.println(String.format("%-25s %25s %-70s %50s", key, "|", eSTRIDETable.get(key), "|"));
					writer.println(String.format("%-25s %25s %-70s %50s", key, "|", eSTRIDETable.get(key), "|"));
				}
			} else {
				break;
			}
		}
		writer.close();
		choice.close();
	}

}