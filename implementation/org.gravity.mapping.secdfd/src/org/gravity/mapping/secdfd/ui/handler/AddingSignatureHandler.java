package org.gravity.mapping.secdfd.ui.handler;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gravity.mapping.secdfd.checks.impl.CryptoCheck;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.model.ResponsibilityType;

/**
 * A handler for manually adding source code signature to a file of encryption
 * and decryption signatures
 * 
 * @author katjat
 *
 */
public class AddingSignatureHandler extends AbstractHandler {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(AddingSignatureHandler.class);

	private MappingView mappingView;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ASTNode node = TextEditorHandler.getSelectedASTNode(event);
		TypeGraph pm = mappingView.getProgramModel().getValue();
		boolean encrypt = event.getCommand().getId().contains("encrypt");
		final ResponsibilityType rs;
		if (encrypt) {
			rs = ResponsibilityType.ENCRYPT_OR_HASH;
		} else {
			rs = ResponsibilityType.DECRYPT;
		}

		// TODO: Get signature string from node

		List<EObject> selected = TextEditorHandler.getSelectedPMElement(node, pm);
		if (selected == null || selected.isEmpty()) {
			LOGGER.log(Level.ERROR, "Cannot find element in model: " + node);
			return null;
		}

		// only if method definition/method signature, ignore other user attempts
		Set<TMethodDefinition> selectedSignatures = selected.parallelStream()
				.filter(TMethodDefinition.class::isInstance).map(e -> (TMethodDefinition) e)
				.collect(Collectors.toSet());

		CryptoCheck checker;
		try {
			IProject project = mappingView.getGravityFolder().getProject();
			checker = new CryptoCheck(mappingView.getProgramModel().getValue(),
					CryptoCheck.getDefaultEncrypSignaturesFile(project),
					CryptoCheck.getDefaultDecrypSignaturesFile(project));
			selectedSignatures.forEach(sig -> checker.addSignature(sig, rs));
		} catch (IOException e) {
			throw new ExecutionException(e.getLocalizedMessage(), e);
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		try {
			mappingView = (MappingView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView(MappingView.VIEW_ID);
		} catch (PartInitException e) {
			LOGGER.log(Level.ERROR, e);
			return false;
		}
		Entry<IFile, TypeGraph> entry = mappingView.getProgramModel();
		return entry != null;
	}

}
