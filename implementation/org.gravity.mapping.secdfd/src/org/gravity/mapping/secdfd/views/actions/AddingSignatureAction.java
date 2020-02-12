package org.gravity.mapping.secdfd.views.actions;

import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.gravity.mapping.secdfd.ImplementedEncryptionChecker;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.typegraph.basic.TMethodDefinition;

/**
 * 
 * @author katjat
 *
 */
public final class AddingSignatureAction extends Action {

	/**
	 * The logger of this action
	 */
	private static final Logger LOGGER = Logger.getLogger(AddingSignatureAction.class);

	private final MappingView mappingView;

	private final Collection<TMethodDefinition> selectedPMObjects;
	private IStructuredSelection selection;
	private Boolean encrypt;

	public AddingSignatureAction(MappingView map, Boolean encrypt, Collection<TMethodDefinition> selected) {
		this.selectedPMObjects = selected;
		this.encrypt = encrypt;
		this.mappingView = map;
	}

	public void run() {
		ImplementedEncryptionChecker checker = new ImplementedEncryptionChecker(mappingView.getGravityFolder(),
				mappingView.getProgramModel().getValue(), mappingView.getMappers().values());
		selectedPMObjects.forEach(sig -> checker.addSignature(encrypt, sig));
		//mappingView.update();
	}

	@Override
	public boolean isEnabled() {
		return true;// source != null;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}
}