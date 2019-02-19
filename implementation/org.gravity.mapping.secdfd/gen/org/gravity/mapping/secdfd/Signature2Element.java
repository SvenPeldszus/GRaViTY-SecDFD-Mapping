/**
 */
package org.gravity.mapping.secdfd;

import eDFDFlowTracking.Element;

import org.eclipse.emf.ecore.EObject;

import org.gravity.typegraph.basic.TSignature;

import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature2 Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Signature2Element#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Signature2Element#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getSignature2Element()
 * @model
 * @generated
 */
public interface Signature2Element extends EObject, AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TSignature)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getSignature2Element_Source()
	 * @model required="true"
	 * @generated
	 */
	TSignature getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Signature2Element#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TSignature value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Element)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getSignature2Element_Target()
	 * @model required="true"
	 * @generated
	 */
	Element getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Signature2Element#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Element value);

} // Signature2Element
