package org.gravity.mapping.secdfd.ui.views.actions;

import java.io.IOException;
import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.checks.ContractCheck;
import org.gravity.mapping.secdfd.ui.views.MappingView;

public class CheckContractsAction extends Action {
	private final MappingView mappingView;

	public CheckContractsAction(MappingView mappingView) {
		super("Check process contracts");
		this.mappingView = mappingView;
	}

	public void run() {		
		try {
			ContractCheck checker = new ContractCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values(),
					"encrypt-signatures.txt", "decrypt-signatures.txt");
			checker.checkEncryptContract();
			checker.checkDecryptContract();
			checker.checkForwardContract();
			// checker.checkJoinContract();
			mappingView.update();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}