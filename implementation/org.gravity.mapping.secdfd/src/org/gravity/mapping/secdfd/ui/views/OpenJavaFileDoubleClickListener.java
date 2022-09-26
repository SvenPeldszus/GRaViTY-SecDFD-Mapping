package org.gravity.mapping.secdfd.ui.views;

import java.util.Map;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethodDefinition;

final class OpenJavaFileDoubleClickListener implements IDoubleClickListener {
	private final IProject project;

	OpenJavaFileDoubleClickListener(final IProject project) {
		this.project = project;
	}

	@Override
	public void doubleClick(final DoubleClickEvent event) {
		final var corr = getSelectedCorrespondence(event);
		if (corr != null) {
			final var pmElement = CorrespondenceHelper.getSource(corr);
			final var javaElement = getJavaElement(pmElement);
			if (javaElement != null) {
				try {
					open(javaElement);
				} catch (final CoreException e) {
					MappingView.LOGGER.log(Level.ERROR, e);

				}
			} else {
				MappingView.LOGGER.log(Level.ERROR, "AstTypes does not include general library types (String).");
			}
		} else {
			MappingView.LOGGER.log(Level.ERROR, "Correspondence is null - something is wrong.");
		}

	}

	/**
	 * @param javaElement
	 * @throws JavaModelException
	 * @throws PartInitException
	 */
	private void open(final IJavaElement javaElement) throws JavaModelException, PartInitException {
		final var file = (IFile) javaElement.getUnderlyingResource();
		final var page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final var editor = IDE.openEditor(page, file, "org.eclipse.jdt.ui.CompilationUnitEditor", true);
		((AbstractTextEditor) editor).selectAndReveal(((ISourceReference) javaElement).getSourceRange().getOffset(), 0);
	}

	/**
	 * @param pmElement An element from the program model
	 * @return The corresponding element from the AST
	 * @throws JavaModelException
	 */
	private IJavaElement getJavaElement(final EObject pmElement) {
		try {
			final var astTypes = JavaASTUtil
					.getTypesForProject(JavaCore.create(this.project));

			IJavaElement javaElement = null;
			if (pmElement instanceof TMethodDefinition) {
				final var member = (TMethodDefinition) pmElement;
				final var type = member.getDefinedBy();
				javaElement = JavaASTUtil.getIMethod(member.getSignature(), astTypes.get(type.getFullyQualifiedName()));
			} else if (pmElement instanceof TAbstractType) {
				final var type = (TAbstractType) pmElement;
				javaElement = astTypes.get(type.getFullyQualifiedName());
			} else {
				MappingView.LOGGER.log(Level.ERROR, "pmElement is not the correct instance type. (double click)");
				return null;
			}
			return javaElement;
		} catch (final JavaModelException e) {
			MappingView.LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	/**
	 * @param event
	 * @return
	 */
	private AbstractCorrespondence getSelectedCorrespondence(final DoubleClickEvent event) {
		AbstractCorrespondence corr = null;
		final var s = event.getSelection();
		if (s instanceof StructuredSelection) {
			final var selection = ((IStructuredSelection) s).getFirstElement();
			if (selection instanceof MappingProcessDefinition) {
				corr = (AbstractCorrespondence) selection;
			} else if (selection instanceof MappingEntityType) {
				corr = (AbstractCorrespondence) selection;
			} // else root element was double clicked
		}
		return corr;
	}
}