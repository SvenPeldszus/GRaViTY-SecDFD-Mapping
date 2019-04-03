package org.gravity.mapping.secdfd.ui.handler;

import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NodeFinder;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.internal.ui.javaeditor.ClassFileEditor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.views.DFDSelectionView;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TypeGraph;

/**
 * A handler for manually mapping code to DFDs
 * 
 * @author speldszus
 *
 */
public class TextEditorHandler extends AbstractHandler {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(TextEditorHandler.class);

	private MappingView mappingView;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ASTNode node = getSelectedASTNode(event);
		TypeGraph pm = mappingView.getProgramModel().getValue();

		EObject selected = null;
		if (node.getNodeType() == ASTNode.SIMPLE_NAME) {
			node = node.getParent();
		}
		switch (node.getNodeType()) {
		case ASTNode.METHOD_DECLARATION:
			MethodDeclaration method = (MethodDeclaration) node;
			TMethodSignature tMethodSignature = JavaASTUtil.getTMethodSignature(method, pm);
			System.out.println(tMethodSignature);
			TAbstractType tDeclaringType = JavaASTUtil.getTClass((TypeDeclaration) method.getParent(), pm);
			selected = tMethodSignature.getTDefinition(tDeclaringType);
			;
			break;
		case ASTNode.TYPE_DECLARATION:
			TAbstractType tType = JavaASTUtil.getTClass((TypeDeclaration) node, pm);
			System.out.println(tType);
			selected = tType;
			break;
		}
		if (selected == null) {
			LOGGER.log(Level.ERROR, "Cannot find element in model: " + node);
			return null;
		}
		DFDSelectionView dfdView;
		try {
			dfdView = (DFDSelectionView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView(DFDSelectionView.VIEW_ID);

		} catch (PartInitException e) {
			LOGGER.log(Level.ERROR, e);
			return false;
		}
		final EObject finalCopy = selected;
		GravityUiActivator.getShell().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				dfdView.populate(finalCopy, mappingView);
			}
		});
		return null;
	}

	/**
	 * Searches the selected AST node
	 * 
	 * @param event An execution event
	 * @return The selected node
	 */
	private ASTNode getSelectedASTNode(ExecutionEvent event) {
		ITextEditor editor = (ITextEditor) HandlerUtil.getActiveEditor(event);
		ITextSelection sel = (ITextSelection) editor.getSelectionProvider().getSelection();
		ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
		final ASTParser parser = ASTParser.newParser(AST.JLS11);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		if (typeRoot.getElementType() == IJavaElement.CLASS_FILE) {
			IClassFile icf = typeRoot.getAdapter(IClassFile.class);
			parser.setSource(icf);
		} else {
			ICompilationUnit icu = typeRoot.getAdapter(ICompilationUnit.class);
			parser.setSource(icu);
		}
		ASTNode outerNode = parser.createAST(null);
		NodeFinder finder = new NodeFinder(outerNode, sel.getOffset(), sel.getLength());
		return finder.getCoveringNode();
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
		if (entry == null) {
			return false;
		}
		return true;
	}

	protected static CompilationUnit parse(ICompilationUnit icu) {
		final ASTParser parser = ASTParser.newParser(AST.JLS11);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(icu);
		return (CompilationUnit) parser.createAST(null);
	}
}
