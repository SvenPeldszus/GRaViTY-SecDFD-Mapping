package org.gravity.mapping.secdfd.ui.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
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
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NodeFinder;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.gravity.eclipse.ui.GravityUiActivator;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.helpers.CallHelper;
import org.gravity.mapping.secdfd.views.DFDSelectionView;
import org.gravity.mapping.secdfd.views.MappingView;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFieldDefinition;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
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

		List<EObject> selected = getSelectedPMElement(node, pm);
		if (selected == null || selected.isEmpty()) {
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
		GravityUiActivator.getShell().getDisplay().asyncExec(() -> dfdView.populate(selected, mappingView));
		return null;
	}

	/**
	 * Searches the selected element in the program model
	 * 
	 * @param node A AST node
	 * @param pm   The program model
	 * @return the selected element
	 */
	public static List<EObject> getSelectedPMElement(ASTNode node, TypeGraph pm) {
		switch (node.getNodeType()) {
		case ASTNode.METHOD_INVOCATION:
			MethodInvocation invoc = (MethodInvocation) node;
			String calledMethodName = invoc.getName().getFullyQualifiedName();
			int numParams = invoc.arguments().size();
			ASTNode parentOfInvocation = invoc.getParent();
			while (parentOfInvocation.getNodeType() != ASTNode.METHOD_DECLARATION) {
				parentOfInvocation = parentOfInvocation.getParent();
			}
			List<EObject> parentMethod = getSelectedPMElement(parentOfInvocation, pm);
			if (parentMethod.isEmpty()) {
				return Collections.emptyList();
			}
			List<EObject> matches = new LinkedList<>();
			for (TMember calledMember : CallHelper.getAllOutCalls((TMember) parentMethod.get(0))) {
				if (calledMember instanceof TMethodDefinition) {
					TMethodDefinition calledMethod = (TMethodDefinition) calledMember;
					TMethodSignature signature = calledMethod.getSignature();
					if (signature.getParameters().size() == numParams
							&& calledMethodName.equals(signature.getMethod().getTName())) {
						matches.add(calledMethod);
					}
				}
			}
			return matches;
		case ASTNode.PRIMITIVE_TYPE:
			String primitive = ((PrimitiveType) node).getPrimitiveTypeCode().toString();
			return Collections.singletonList(pm.getClass(primitive));
		case ASTNode.SIMPLE_NAME:
			return getSelectedPMElement(node.getParent(), pm);
		case ASTNode.SINGLE_VARIABLE_DECLARATION:
			SingleVariableDeclaration var = ((SingleVariableDeclaration) node);
			ASTNode varParent = var.getParent();
			if (varParent.getNodeType() == ASTNode.METHOD_DECLARATION) {
				MethodDeclaration varMethod = (MethodDeclaration) varParent;
				TMethodDefinition varMethodDef = (TMethodDefinition) getSelectedPMElement(varMethod, pm).get(0);
				int index = varMethod.parameters().indexOf(var);
				TParameter tParam = varMethodDef.getSignature().getFirstParameter();
				for (int i = 0; i < index; i++) {
					tParam = tParam.getNext();
				}
				List<EObject> list = new ArrayList<>(3);
				list.add(tParam.getType());
				list.add(tParam);
				list.add(varMethodDef);
				return list;
			}
			break;
		case ASTNode.VARIABLE_DECLARATION_FRAGMENT:
			ASTNode parent = node.getParent();
			if (parent.getNodeType() == ASTNode.FIELD_DECLARATION) {
				FieldDeclaration field = (FieldDeclaration) parent;
				String name = ((VariableDeclarationFragment) node).getName().toString();
				TAbstractType tType = JavaASTUtil.getTClass((TypeDeclaration) field.getParent(), pm);
				List<EObject> fieldList = new LinkedList<>(tType.getDefines().stream()
						.filter(member -> (member instanceof TFieldDefinition))
						.filter(def -> ((TFieldDefinition) def).getSignature().getField().getTName().equals(name))
						.collect(Collectors.toList()));
				TAbstractType fieldType = ((TFieldDefinition) fieldList.get(0)).getSignature().getType();
				fieldList.add(0, fieldType);
				return fieldList;
			}
			break;
		case ASTNode.METHOD_DECLARATION:
			MethodDeclaration method = (MethodDeclaration) node;
			TMethodSignature tMethodSignature = JavaASTUtil.getTMethodSignature(method, pm);
			System.out.println(tMethodSignature);
			TypeDeclaration definingType = (TypeDeclaration) method.getParent();
			PackageDeclaration containingPackage = ((CompilationUnit) definingType.getParent()).getPackage();
			;
			String fullyQualifiedName = containingPackage.getName().getFullyQualifiedName() + "." //$NON-NLS-1$
					+ definingType.getName();
			TAbstractType tDeclaringType = pm.getType(fullyQualifiedName);
			return Collections.singletonList(tMethodSignature.getTDefinition(tDeclaringType));
		case ASTNode.TYPE_DECLARATION:
			ASTNode tmpASTNode2 = node.getParent();
			if (tmpASTNode2 instanceof CompilationUnit) {
				PackageDeclaration childPackage = ((CompilationUnit) tmpASTNode2).getPackage();
				String name = childPackage.getName().getFullyQualifiedName() + "." + ((TypeDeclaration) node).getName(); //$NON-NLS-1$
				TAbstractType tType = pm.getType(name);
				if (tType != null) {
					return Collections.singletonList(tType);
				}
			}
			return Collections.singletonList(JavaASTUtil.getTClass((TypeDeclaration) node, pm));
		default:
			LOGGER.error("Unknown ASTNode kind: " + node.getNodeType());
		}

		return null;
	}

	/**
	 * Searches the selected AST node
	 * 
	 * @param event An execution event
	 * @return The selected node
	 */
	public static ASTNode getSelectedASTNode(ExecutionEvent event) {
		ITextEditor editor = (ITextEditor) HandlerUtil.getActiveEditor(event);
		ITextSelection sel = (ITextSelection) editor.getSelectionProvider().getSelection();
		ITypeRoot typeRoot = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
		final ASTParser parser = ASTParser.newParser(AST.JLS10);
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
		return entry != null;
	}

	protected static CompilationUnit parse(ICompilationUnit icu) {
		final ASTParser parser = ASTParser.newParser(AST.JLS10);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(icu);
		return (CompilationUnit) parser.createAST(null);
	}
}
