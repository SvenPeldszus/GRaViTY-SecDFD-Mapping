/**
 */
package org.secdfd.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDFD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.EDFD#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.secdfd.model.EDFD#getTrustzones <em>Trustzones</em>}</li>
 *   <li>{@link org.secdfd.model.EDFD#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getEDFD()
 * @model
 * @generated
 */
public interface EDFD extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Asset</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.Asset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getEDFD_Asset()
	 * @model containment="true"
	 * @generated
	 */
	EList<Asset> getAsset();

	/**
	 * Returns the value of the '<em><b>Trustzones</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.TrustZone}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trustzones</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getEDFD_Trustzones()
	 * @model containment="true"
	 * @generated
	 */
	EList<TrustZone> getTrustzones();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getEDFD_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // EDFD
