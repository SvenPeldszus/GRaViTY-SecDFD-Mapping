/**
 */
package org.gravity.mapping.secdfd;

import eDFDFlowTracking.Asset;

import org.eclipse.emf.ecore.EObject;

import org.gravity.typegraph.basic.TAbstractType;

import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type2 Asset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Type2Asset#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Type2Asset#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2Asset()
 * @model
 * @generated
 */
public interface Type2Asset extends EObject, AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TAbstractType)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2Asset_Source()
	 * @model required="true"
	 * @generated
	 */
	TAbstractType getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Type2Asset#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TAbstractType value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Asset)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2Asset_Target()
	 * @model required="true"
	 * @generated
	 */
	Asset getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Type2Asset#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Asset value);

} // Type2Asset
