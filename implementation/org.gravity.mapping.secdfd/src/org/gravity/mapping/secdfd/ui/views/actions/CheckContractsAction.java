package org.gravity.mapping.secdfd.ui.views.actions;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.checks.ContractCheck;
import org.gravity.mapping.secdfd.checks.Crypto;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.secdfd.model.ResponsibilityType;

public class CheckContractsAction extends Action {
	private final MappingView mappingView;

	public CheckContractsAction(MappingView mappingView) {
		super("Check process contracts");
		this.mappingView = mappingView;
	}

	public void run() {
		Set<Crypto> tocheck = new HashSet<>();
		tocheck.add(new Crypto(ResponsibilityType.ENCRYPT_OR_HASH, Optional.ofNullable("encrypt-signatures.txt")));
		tocheck.add(new Crypto(ResponsibilityType.DECRYPT, Optional.ofNullable("decrypt-signatures.txt")));
		
		ContractCheck checker = new ContractCheck(mappingView.getGravityFolder(),
				mappingView.getProgramModel().getValue(), mappingView.getMappers().values(), tocheck);
		
		try {
			checker.checkSecurityContracts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mappingView.update();
	}
}