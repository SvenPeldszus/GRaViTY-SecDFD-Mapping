/**
 */
package org.gravity.mapping.secdfd;

import eDFDFlowTracking.NamedEntity;

import org.gravity.typegraph.basic.TAbstractType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type2 Named Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Type2NamedEntity#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Type2NamedEntity#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2NamedEntity()
 * @model
 * @generated
 */
public interface Type2NamedEntity extends AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TAbstractType)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2NamedEntity_Source()
	 * @model required="true"
	 * @generated
	 */
	TAbstractType getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Type2NamedEntity#getSource <em>Source</em>}' reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NamedEntity)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getType2NamedEntity_Target()
	 * @model required="true"
	 * @generated
	 */
	NamedEntity getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Type2NamedEntity#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NamedEntity value);

} // Type2NamedEntity
