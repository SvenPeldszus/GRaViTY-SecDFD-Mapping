package org.gravity.mapping.secdfd.views.actions;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.gravity.mapping.secdfd.checks.EncryptionCheck;
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
	private Boolean encrypt;

	public AddingSignatureAction(MappingView map, Boolean encrypt, Collection<TMethodDefinition> selected) {
		this.selectedPMObjects = selected;
		this.encrypt = encrypt;
		this.mappingView = map;
	}

	@Override
	public void run() {
		EncryptionCheck checker = new EncryptionCheck(mappingView.getGravityFolder(),
				mappingView.getProgramModel().getValue(), mappingView.getMappers().values());
		//write selection to file, not selectedPMObject
		
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
	}
}