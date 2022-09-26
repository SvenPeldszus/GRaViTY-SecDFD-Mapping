/**
 */
package org.gravity.mapping.secdfd.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gravity.mapping.secdfd.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gravity.mapping.secdfd.SecdfdPackage
 * @generated
 */
public class SecdfdSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SecdfdPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecdfdSwitch() {
		if (modelPackage == null) {
			modelPackage = SecdfdPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SecdfdPackage.ABSTRACT_CORRESPONDENCE: {
				AbstractCorrespondence abstractCorrespondence = (AbstractCorrespondence)theEObject;
				T result = caseAbstractCorrespondence(abstractCorrespondence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.METHOD2_ELEMENT: {
				Method2Element method2Element = (Method2Element)theEObject;
				T result = caseMethod2Element(method2Element);
				if (result == null) result = caseAbstractCorrespondence(method2Element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.TYPE2_NAMED_ENTITY: {
				Type2NamedEntity type2NamedEntity = (Type2NamedEntity)theEObject;
				T result = caseType2NamedEntity(type2NamedEntity);
				if (result == null) result = caseAbstractCorrespondence(type2NamedEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.TYPE_GRAPH2_EDFD: {
				TypeGraph2EDFD typeGraph2EDFD = (TypeGraph2EDFD)theEObject;
				T result = caseTypeGraph2EDFD(typeGraph2EDFD);
				if (result == null) result = caseAbstractCorrespondence(typeGraph2EDFD);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.DEFINTION2_ELEMENT: {
				Defintion2Element defintion2Element = (Defintion2Element)theEObject;
				T result = caseDefintion2Element(defintion2Element);
				if (result == null) result = caseAbstractCorrespondence(defintion2Element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.FLOW2_ACCESS: {
				Flow2Access flow2Access = (Flow2Access)theEObject;
				T result = caseFlow2Access(flow2Access);
				if (result == null) result = caseAbstractCorrespondence(flow2Access);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SecdfdPackage.SIGNATURE2_ELEMENT: {
				Signature2Element signature2Element = (Signature2Element)theEObject;
				T result = caseSignature2Element(signature2Element);
				if (result == null) result = caseAbstractCorrespondence(signature2Element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Correspondence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractCorrespondence(AbstractCorrespondence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method2 Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethod2Element(Method2Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type2 Named Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type2 Named Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType2NamedEntity(Type2NamedEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Graph2 EDFD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Graph2 EDFD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeGraph2EDFD(TypeGraph2EDFD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defintion2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defintion2 Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefintion2Element(Defintion2Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow2 Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow2 Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow2Access(Flow2Access object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signature2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signature2 Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignature2Element(Signature2Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SecdfdSwitch
