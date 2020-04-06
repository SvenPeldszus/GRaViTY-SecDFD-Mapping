package org.gravity.mapping.secdfd.ui.views.actions;

import java.io.IOException;
import java.util.Collection;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.gravity.mapping.secdfd.checks.ContractCheck;
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
	private ResponsibilityType rs;

	public AddingSignatureAction(MappingView map, ResponsibilityType rs, Collection<TMethodDefinition> selected) {
		this.selectedPMObjects = selected;
		this.rs = rs;
		this.mappingView = map;
	}

	@Override
	public void run() {
		try {
			ContractCheck checker = new ContractCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values(),
					"encrypt-signatures.txt", "decrypt-signatures.txt");
			selectedPMObjects.forEach(sig -> checker.addSignature(sig, rs));
			// mappingView.update();
		} catch (IOException e) {
			e.printStackTrace();
		}

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