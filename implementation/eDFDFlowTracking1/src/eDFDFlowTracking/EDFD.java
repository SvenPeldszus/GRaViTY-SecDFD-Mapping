/**
 */
package eDFDFlowTracking;

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
 *   <li>{@link eDFDFlowTracking.EDFD#getAsset <em>Asset</em>}</li>
 *   <li>{@link eDFDFlowTracking.EDFD#getTrustzones <em>Trustzones</em>}</li>
 *   <li>{@link eDFDFlowTracking.EDFD#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getEDFD()
 * @model
 * @generated
 */
public interface EDFD extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Asset</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getEDFD_Asset()
	 * @model containment="true"
	 * @generated
	 */
	EList<Asset> getAsset();

	/**
	 * Returns the value of the '<em><b>Trustzones</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.TrustZone}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trustzones</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trustzones</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getEDFD_Trustzones()
	 * @model containment="true"
	 * @generated
	 */
	EList<TrustZone> getTrustzones();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getEDFD_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // EDFD
