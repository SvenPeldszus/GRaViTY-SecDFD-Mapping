package org.gravity.mapping.secdfd.views;

import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.helpers.RankingHelper;
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
import org.gravity.mapping.secdfd.AbstractCorrespondence;

import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTrackingPackage;
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
			if(key instanceof EObject) {
				return prettyPrint((EObject) key);
			}
		} else if (element instanceof AbstractCorrespondence) {
			AbstractCorrespondence corr = (AbstractCorrespondence) element;
			EObject source = CorrespondenceHelper.getSource(corr);
			String prefix = Logging.getTruePositive(corr);
			if(prefix.length() > 0) {
				prefix += "\t\t";
			}
			prefix += RankingHelper.getRanking(corr) + "\t\t";
			return prefix + prettyPrint(source);
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
		} else if (EDFDFlowTrackingPackage.eINSTANCE.getNamedEntity().isSuperTypeOf(sType)) {
			if (EDFDFlowTrackingPackage.eINSTANCE.getProcess().isSuperTypeOf(sType)) {
				builder.append("Process: ");
			} else if (EDFDFlowTrackingPackage.eINSTANCE.getAsset().isSuperTypeOf(sType)) {
				builder.append("Asset: ");
			} else if (EDFDFlowTrackingPackage.eINSTANCE.getDataStore().isSuperTypeOf(sType)) {
				builder.append("DataStore: ");
			}
			builder.append(((NamedEntity) eObject).getName());
		} else if(eObject instanceof AbstractCorrespondence){
			return prettyPrint(CorrespondenceHelper.getSource((AbstractCorrespondence) eObject), CorrespondenceHelper.getTarget((AbstractCorrespondence) eObject));
		}else {
			return eObject.toString();
		}
		return builder.toString();
	}

	private static String prettyPrint(EObject source, EObject target) {
		return prettyPrint(source) + " <-> " + prettyPrint(target);
	}
}
