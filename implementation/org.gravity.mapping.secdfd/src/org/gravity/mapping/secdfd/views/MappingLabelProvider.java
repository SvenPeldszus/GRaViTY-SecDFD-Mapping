package org.gravity.mapping.secdfd.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
//import org.eclipse.xtext.util.Files;
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
			Logging.init(object);
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
			String prefix = Logging.getTruePositive(object, source, target) + "\t\t";
			if (element instanceof MappingRanking) {
				prefix += "ranking: " + Integer.toString(((MappingRanking) element).getRanking()) + "\t\t";
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

	/**
	 * Created a human readable string
	 * 
	 * @param eObject The object which should be printed
	 * @return the string
	 */
	public static String prettyPrint(EObject eObject) {
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

	public static class Logging {
		public static HashSet<String> true_positives = new HashSet<String>();
		public static HashSet<String> false_positives = new HashSet<String>();
		public static HashSet<String> JsonFileTP = new HashSet<String>();
		public static HashSet<String> copyJsonFileTP = new HashSet<String>();
	
		static void init(JsonObject object) {
			for (JsonElement mapping : object.getAsJsonArray("mappings")) {
				if (mapping instanceof JsonObject) {
					String pm = ((JsonObject) mapping).get("pm").getAsString().toLowerCase();
					String dfd = ((JsonObject) mapping).get("secdfd").getAsString().toLowerCase();
					JsonFileTP.add(pm + dfd);
				}
			}
		}
	
		public static void logging() {
			// logg
			File file = MappingView.getMappingView().getProgramModel().getKey().getProject()
					.getFile("precision_recall.log").getLocation().toFile();
			String build = "Precision "
					.concat(Double.toString(
							(double) true_positives.size() / (true_positives.size() + false_positives.size())))
					.concat(", Recall: ".concat(Double.toString(
							(double) true_positives.size() / (true_positives.size() + copyJsonFileTP.size()))))
					.concat("\n").concat("TP: ").concat(Integer.toString(true_positives.size())).concat("\n")
					.concat("FP: ").concat(Integer.toString(false_positives.size())).concat("\n").concat("FN: ")
					.concat(Integer.toString(copyJsonFileTP.size())).concat("\n");
			try {
				file.createNewFile();
				Files.write(file.toPath(), build.getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			copyJsonFileTP = new HashSet<String>(JsonFileTP);
			true_positives = new HashSet<>();
			false_positives = new HashSet<>();
		}
	
		static String getTruePositive(JsonObject object, EObject source, EObject target) {
			String sourceString = prettyPrint(source).toLowerCase();
			sourceString = sourceString.substring(sourceString.indexOf(':') + 1).trim();
			String targetString = prettyPrint(target).toLowerCase();
			targetString = targetString.substring(targetString.indexOf(':') + 1).trim();
			String string = "! FALSE POSITIVE";
			for (JsonElement mapping : object.getAsJsonArray("mappings")) {
				if (mapping instanceof JsonObject) {
					String pm = ((JsonObject) mapping).get("pm").getAsString().toLowerCase();
					if (pm.contains(sourceString)) {
						String dfd = ((JsonObject) mapping).get("secdfd").getAsString().toLowerCase();
						if (targetString.equals(dfd)) {
							if ((source instanceof TMember || source instanceof TAbstractType)) {
								true_positives.add(sourceString + targetString);
								copyJsonFileTP.remove(sourceString + targetString);
							}
							string = "+ TRUE POSITIVE";
							break;
						}
					}
				}
			}
			if ((source instanceof TMember || source instanceof TAbstractType) && string == "! FALSE POSITIVE") {
				false_positives.add(sourceString + targetString);
			}
			return string;
		}
	}
}
