package org.gravity.mapping.secdfd.ui.handler;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.mapping.secdfd.ui.views.actions.AddingSignatureAction;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;

/**
 * A handler for manually adding source code signature to a file of encryption and decryption signatures
 * 
 * @author katjat
 *
 */
public class AddingSignatureHandler extends AbstractHandler {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(TextEditorHandler.class);

	private MappingView mappingView;
	private AddingSignatureAction signatureAction;
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ASTNode node = TextEditorHandler.getSelectedASTNode(event);
		TypeGraph pm = mappingView.getProgramModel().getValue();
		Boolean encrypt = false; 
		if (event.getCommand().getId().contains("encrypt")) {
			encrypt = true;
		}else encrypt = false;
		
		List<EObject> selected = TextEditorHandler.getSelectedPMElement(node, pm);
		if (selected == null || selected.isEmpty()) {
			LOGGER.log(Level.ERROR, "Cannot find element in model: " + node);
			return null;
		}
		
		//only if method definition/method signature, ignore other user attempts
		Set<TMethodDefinition> selectedSignatures = selected.parallelStream().filter(TMethodDefinition.class::isInstance).map(e -> (TMethodDefinition) e).collect(Collectors.toSet());
		signatureAction = new AddingSignatureAction(mappingView, encrypt, selectedSignatures);
		signatureAction.run();
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
