package org.gravity.mapping.secdfd.views.actions;

import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.checks.EncryptionCheck;
import org.gravity.mapping.secdfd.views.MappingView;

public class CheckContractsAction extends Action {
	private final MappingView mappingView;
	public CheckContractsAction(MappingView mappingView) {
		super("Check process contracts");
		this.mappingView = mappingView;
	}

	public void run() {
		try {
			EncryptionCheck checker = new EncryptionCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values());
			checker.checkImplementedEncyption();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}