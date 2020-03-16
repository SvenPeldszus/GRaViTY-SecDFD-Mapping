package org.gravity.mapping.secdfd.ui.views.actions;

import java.util.Collections;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;

public class MapProjectAction extends Action {
	public MapProjectAction() {
		super("Map project");
	}

	@Override
	public void run() {
		WizardDialog wizard = new WizardDialog(GravityUiActivator.getShell(),
				new MappingWizard(Collections.emptyList()));
		if (wizard.open() == Window.OK) {
			System.out.println("OK pressed");
		}
	}
}