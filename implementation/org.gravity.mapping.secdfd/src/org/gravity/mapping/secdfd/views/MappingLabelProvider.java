package org.gravity.mapping.secdfd.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingRanking;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TSignature;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.NamedEntity;

public class MappingLabelProvider implements ILabelProvider {

	private JsonObject object;

	public MappingLabelProvider() {
		File file = MappingView.getMappingView().getProgramModel().getKey().getProject()
				.getFile("groundtruth/storepassword.json").getLocation().toFile();
		try {
			object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// There is no need to clean up
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Entry) {
			Object key = ((Entry<?, ?>) element).getKey();
			if (key instanceof IFile) {
				return ((IFile) key).getName();
			}
			if (key instanceof String) {
				return (String) key;
			}
		} else if (element instanceof AbstractCorrespondence) {
			AbstractCorrespondence corr = (AbstractCorrespondence) element;
			EObject source = CorrespondenceHelper.getSource(corr);
			EObject target = CorrespondenceHelper.getTarget(corr);
			String prefix = getTruePositive(source, target)+"\t\t";
			if (element instanceof MappingRanking) {
				prefix += "ranking: " + Integer.toString(((MappingRanking) element).getRanking())+"\t\t";
			}
			return prefix + prettyPrint(source, target);
		} else if (element instanceof EDFD) {
			return ((EDFD) element).getName();
		} else if (element instanceof Mapping) {
			return ((Mapping) element).getName();
		} else if (element instanceof EObject) {
			return prettyPrint((EObject) element);
		}
		return "ERROR: not handled by the label provider: " + element;
	}

	private String getTruePositive(EObject source, EObject target) {
		String sourceString = prettyPrint(source).toLowerCase();
		String targetString = prettyPrint(target).toLowerCase();
		String string = "! FALSE POSITIVE";
		for (JsonElement mapping : object.getAsJsonArray("mappings")) {
			if (mapping instanceof JsonObject) {
				String pm = ((JsonObject) mapping).get("pm").getAsString().toLowerCase();
				if (sourceString.endsWith(pm)) {
					String dfd = ((JsonObject) mapping).get("secdfd").getAsString().toLowerCase();
					if (targetString.endsWith(dfd)) {
						string = "+ TRUE POSITIVE";
						break;
					}
				}
			}
		}
		return string;
	}

	/**
	 * @param source
	 * @param target
	 * @return
	 */
	private String prettyPrint(EObject eObject) {
		StringBuilder builder = new StringBuilder();
		EClass sType = eObject.eClass();
		if (BasicPackage.eINSTANCE.getTMethod().isSuperTypeOf(sType)) {
			builder.append("Member Name: ");
			builder.append(((TMethod) eObject).getTName());
		} else if (BasicPackage.eINSTANCE.getTSignature().isSuperTypeOf(sType)) {
			builder.append("Member Signature: ");
			builder.append(((TSignature) eObject).getSignatureString());
		} else if (BasicPackage.eINSTANCE.getTMember().isSuperTypeOf(sType)) {
			builder.append("Member Definition: ");
			builder.append(((TMember) eObject).getDefinedBy().getFullyQualifiedName());
			builder.append('.');
			builder.append(((TMember) eObject).getSignatureString());
		} else if (BasicPackage.eINSTANCE.getTAbstractType().isSuperTypeOf(sType)) {
			builder.append("Type: ");
			builder.append(((TAbstractType) eObject).getFullyQualifiedName());
		} else if (EDFDFlowTracking1Package.eINSTANCE.getNamedEntity().isSuperTypeOf(sType)) {
			if (EDFDFlowTracking1Package.eINSTANCE.getProcess().isSuperTypeOf(sType)) {
				builder.append("Process: ");
			} else if (EDFDFlowTracking1Package.eINSTANCE.getAsset().isSuperTypeOf(sType)) {
				builder.append("Asset: ");
			} else if (EDFDFlowTracking1Package.eINSTANCE.getDataStore().isSuperTypeOf(sType)) {
				builder.append("DataStore: ");
			}
			builder.append(((NamedEntity) eObject).getName());
		} else {
			return eObject.toString();
		}
		return builder.toString();
	}

	private String prettyPrint(EObject source, EObject target) {
		return prettyPrint(source) + " <-> " + prettyPrint(target);
	}
}
