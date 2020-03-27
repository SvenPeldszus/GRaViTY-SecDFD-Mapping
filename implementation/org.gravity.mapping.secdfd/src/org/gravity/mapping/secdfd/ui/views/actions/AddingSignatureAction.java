package org.gravity.mapping.secdfd.ui.views.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.gravity.mapping.secdfd.checks.ContractCheck;
import org.gravity.mapping.secdfd.checks.Crypto;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.ResponsibilityType;

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
		ContractCheck checker;
		if(encrypt) {
			checker = new ContractCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values(),
					Collections.singleton(new Crypto(ResponsibilityType.ENCRYPT_OR_HASH)));
		}else {
			checker = new ContractCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values(),
					Collections.singleton(new Crypto(ResponsibilityType.DECRYPT)));
		}
		selectedPMObjects.forEach(sig -> checker.addSignature(sig));
		// mappingView.update();
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