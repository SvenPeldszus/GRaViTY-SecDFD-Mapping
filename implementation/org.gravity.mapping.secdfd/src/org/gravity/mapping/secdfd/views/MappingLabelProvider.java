package org.gravity.mapping.secdfd.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
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
			String prefix = Logging.getTruePositive(source, target) + "\t\t";
			prefix += "ranking: " + Integer.toString(getTotalRanking(corr)) + "\t\t";
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
	 * @param element
	 * @return
	 */
	public static int getTotalRanking(AbstractCorrespondence corr) {
		if (corr instanceof MappingProcessDefinition) {
			return 150;
		}
		if (corr instanceof MappingProcessSignature) {
			return 120;
		}
		int rank = 0;
		if (corr instanceof AbstractMappingRanking) {
			rank += ((AbstractMappingRanking) corr).getRanking();
		}
		if (corr instanceof AbstractMappingBase) {
			rank += 5 * ((AbstractMappingBase) corr).getDeriving().size();
		}
		return Math.min(100, rank);
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

		private static Map<String, Set<String>> map = null;

		public static HashSet<String> truePositives = new HashSet<String>();
		public static HashSet<String> falsePositives = new HashSet<String>();
		public static HashSet<String> expectedPositives = new HashSet<String>();
		public static HashSet<String> falseNegaives = new HashSet<String>();

		static void init() {
			MappingView mappingView = MappingView.getMappingView();
			for (Mapping mapping : mappingView.getMappings()) {
				File file = mappingView.getProgramModel().getKey().getProject()
						.getFile("groundtruth/" + mapping.getName() + ".json").getLocation().toFile();
				if (file.exists()) {
					if (map == null) {
						map = new HashMap<>();
					}
					try {
						JsonObject object = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
						for (JsonElement jsonElement : object.getAsJsonArray("mappings")) {
							if (jsonElement instanceof JsonObject) {
								String pm = ((JsonObject) jsonElement).get("pm").getAsString().toLowerCase()
										.replaceAll(" ", "");
								String dfd = ((JsonObject) jsonElement).get("secdfd").getAsString().toLowerCase()
										.replaceAll(" ", "");
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
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			falseNegaives = new HashSet<String>(expectedPositives);
			truePositives = new HashSet<>();
			falsePositives = new HashSet<>();
			if (map == null) {
				map = new HashMap<>();
			}
		}

		public static void logging() {
			if (map == null || map.size() == 0) {
				return;
			}

			// logg
			if (expectedPositives.size() > 0) {
				File file = MappingView.getMappingView().getProgramModel().getKey().getProject()
						.getFile("log/precision_recall_"+System.currentTimeMillis()+".log").getLocation().toFile();
				int tp = truePositives.size();
				int fp = falsePositives.size();
				int fn = falseNegaives.size();
				double precission = (double) tp / (tp + fp);
				double recall = (double) tp / (tp + fn);
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
					try (FileWriter writer = new FileWriter(file, true)) {
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
						for(String missed: falseNegaives) {
							writer.append(missed);
							writer.append('\n');
						}
						writer.append("\nFalse positives:\n");
						for(String wrong: falsePositives) {
							writer.append(wrong);
							writer.append('\n');
						}
						writer.append('\n');
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				falseNegaives = new HashSet<String>(expectedPositives);
				truePositives = new HashSet<>();
				falsePositives = new HashSet<>();
			}
		}

		static String getTruePositive(EObject pmObject, EObject dfdObject) {
			if (map == null || map.size() == 0) {
				init();
			}
			if (map.size() == 0) {
				return "";
			}

			String pmString = prettyPrint(pmObject).toLowerCase();
			pmString = pmString.substring(pmString.indexOf(':') + 1).replaceAll(" ", "");
			String dfdString = prettyPrint(dfdObject).toLowerCase();
			dfdString = dfdString.substring(dfdString.indexOf(':') + 1).replaceAll(" ", "");
			if (map.containsKey(dfdString)) {
				if (map.get(dfdString).contains(pmString)) {
					truePositives.add(pmString + " <-> " + dfdString);
					falseNegaives.remove(pmString + " <-> " + dfdString);
					return "+ TRUE POSITIVE";
				}
			}
			if (pmObject instanceof TMember || pmObject instanceof TAbstractType) {
				falsePositives.add(pmString + " <-> " + dfdString);
			}
			return "! FALSE POSITIVE";
		}
	}
}
