/**
 */
package org.secdfd.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trust Zone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.TrustZone#getElements <em>Elements</em>}</li>
 *   <li>{@link org.secdfd.model.TrustZone#getSubzones <em>Subzones</em>}</li>
 *   <li>{@link org.secdfd.model.TrustZone#getAttackerprofile <em>Attackerprofile</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getTrustZone()
 * @model
 * @generated
 */
public interface TrustZone extends Element {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getTrustZone_Elements()
	 * @model
	 * @generated
	 */
	EList<Element> getElements();

	/**
	 * Returns the value of the '<em><b>Subzones</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.TrustZone}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subzones</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getTrustZone_Subzones()
	 * @model containment="true"
	 * @generated
	 */
	EList<TrustZone> getSubzones();

	/**
	 * Returns the value of the '<em><b>Attackerprofile</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.AttackerProfile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attackerprofile</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getTrustZone_Attackerprofile()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackerProfile> getAttackerprofile();

} // TrustZone
