/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethodDefinition;

/**
 * @author speldszus
 *
 */
public class MarkerHelper {

	private static final Logger LOGGER = Logger.getLogger(MarkerHelper.class);
	
	public static final String MAPPING_MARKER = "org.gravity.mapping.secdfd.markers.java";

	/**
	 * Creates a marker on the given program model element
	 * 
	 * @param astTypes A mapping between names and Eclipse AST types
	 * @param element  The pm element
	 * @param kind     The marker kind
	 * @param message  The marker message
	 * @param priority The marker priority
	 */
	static void createMarker(Map<String, IType> astTypes, EObject element, String message, int priority) {
		IJavaElement javaElement = getJavaElement(astTypes, element);
		if (javaElement != null) {
			try {
				int line = getLine(javaElement);

				IMarker marker = javaElement.getUnderlyingResource().createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.MESSAGE, message);
				marker.setAttribute(IMarker.PRIORITY, priority);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				marker.setAttribute(IMarker.LINE_NUMBER, line);
			} catch (CoreException e) {
				LOGGER.log(Level.ERROR, e);
			}
		}
	}

	/**
	 * @param astTypes
	 * @param element
	 * @return
	 */
	private static IJavaElement getJavaElement(Map<String, IType> astTypes, EObject element) {
		IJavaElement javaElement = null;
		if (element instanceof TAbstractType) {
			javaElement = astTypes.get(((TAbstractType) element).getFullyQualifiedName());
		} else if (element instanceof TMethodDefinition) {
			TMethodDefinition member = (TMethodDefinition) element;
			IType iType = astTypes.get(member.getDefinedBy().getFullyQualifiedName());
			try {
				javaElement = JavaASTUtil.getIMethod(member.getSignature(), iType);
			} catch (JavaModelException e) {
				LOGGER.log(Level.ERROR, e);
			}
		}
		return javaElement;
	}

	static void deleteMarker(Map<String, IType> astTypes, EObject element) {
		IJavaElement javaElement = getJavaElement(astTypes, element);
		if (javaElement != null) {
			try {
				int line = getLine(javaElement);
				for (IMarker marker : javaElement.getUnderlyingResource().findMarkers(IMarker.PROBLEM, true,
						IResource.DEPTH_ONE)) {
					Object attribute = marker.getAttribute(IMarker.LINE_NUMBER);
					if (((Integer) attribute).intValue() == line) {
						marker.delete();
					}
				}
			} catch (CoreException e) {
				LOGGER.log(Level.ERROR, e);
			}
		}
	}

	/**
	 * @param javaElement
	 * @return
	 * @throws JavaModelException
	 * @throws CoreException
	 */
	private static int getLine(IJavaElement javaElement) throws JavaModelException, CoreException {
		IResource underlyingResource = javaElement.getUnderlyingResource();
		int line = 1;
		if (underlyingResource.getFileExtension().equals("java")) {
			try (InputStream stream = ((IFile) underlyingResource).getContents()) {
				char ch;
				int count = ((ISourceReference) javaElement).getSourceRange().getOffset();
				while ((ch = (char) stream.read()) != -1 && count-- > 0) {
					if (ch == '\n') {
						line++;
					}
				}
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, e);
			}
		}
		return line;
	}
}
