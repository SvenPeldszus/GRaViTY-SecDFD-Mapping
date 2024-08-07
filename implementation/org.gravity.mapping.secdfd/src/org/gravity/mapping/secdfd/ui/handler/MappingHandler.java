package org.gravity.mapping.secdfd.ui.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.ui.handler.UISelectionHelper;
import org.gravity.mapping.secdfd.ui.wizard.MappingWizard;

/**
 * A handler for triggering the initial creation of a new UML models for the
 * selected projects
 *
 * @author speldszus
 *
 */
public class MappingHandler extends AbstractHandler {

	static final Logger LOGGER = Logger.getLogger(MappingHandler.class);

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<?> selection = UISelectionHelper.getSelection(event);
		final List<IJavaProject> projects = selection.parallelStream().filter(IJavaProject.class::isInstance)
				.map(p -> (IJavaProject) p).collect(Collectors.toList());

		final var wizard = new WizardDialog(GravityUiActivator.getShell(), new MappingWizard(projects));
		if (wizard.open() == Window.OK) {
			System.out.println("OK pressed");
		} else {
			System.out.println("CANCEL");
		}

		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}
}
