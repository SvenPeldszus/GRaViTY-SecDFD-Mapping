package org.secdfd.dsl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;

public class retrieveEDFDObject {
	
	public ArrayList<Asset> getListsOfAssets(EObject e) {

		ArrayList<Asset> assets = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				assets.add((Asset) e.eContents().get(i));
			} catch (Exception es) {
				// TODO: handle exception
			}
		}
		return assets;
	}

	public ArrayList<Process> getListsOfProcess(EObject e) {

		ArrayList<Process> processes = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				processes.add((Process) e.eContents().get(i));
			} catch (Exception es) {
				// TODO: handle exception
			}
		}
		return processes;
	}

	public ArrayList<ExternalEntity> getListsOfExternal(EObject e) {

		ArrayList<ExternalEntity> externalEntities = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				externalEntities.add((ExternalEntity) e.eContents().get(i));
			} catch (Exception es) {
				// TODO: handle exception
			}
		}
		return externalEntities;
	}

	public ArrayList<DataStore> getListsOfDataStore(EObject e) {

		ArrayList<DataStore> dataStores = new ArrayList<>();
		for (int i = 0; i < e.eContents().size(); i++) {
			try {
				dataStores.add((DataStore) e.eContents().get(i));
			} catch (Exception es) {
				// TODO: handle exception
			}
		}
		return dataStores;
	}

	public ArrayList<Flow> getFlowsOfProcess(ArrayList<Process> list) {

		ArrayList<Flow> flowsOfProcess = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
				flowsOfProcess.add((Flow) list.get(i).getOutflows().get(j));
			}
		}
		return flowsOfProcess;
	}

	public ArrayList<Flow> getFlowsOfExternal(ArrayList<ExternalEntity> list) {

		ArrayList<Flow> flowsOfExternalEntities = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
				flowsOfExternalEntities.add((Flow) list.get(i).getOutflows().get(j));
			}
		}
		return flowsOfExternalEntities;
	}

	public ArrayList<Flow> getFlowsOfData(ArrayList<DataStore> list) {

		ArrayList<Flow> flowsOfData = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getOutflows().size(); j++) {
				flowsOfData.add((Flow) list.get(i).getOutflows().get(j));
			}
		}
		return flowsOfData;
	}

}
