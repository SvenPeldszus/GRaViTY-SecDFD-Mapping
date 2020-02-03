/**
 */
package eDFDFlowTracking;

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
 *   <li>{@link eDFDFlowTracking.TrustZone#getElements <em>Elements</em>}</li>
 *   <li>{@link eDFDFlowTracking.TrustZone#getSubzones <em>Subzones</em>}</li>
 *   <li>{@link eDFDFlowTracking.TrustZone#getAttackerprofile <em>Attackerprofile</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getTrustZone()
 * @model
 * @generated
 */
public interface TrustZone extends Element {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getTrustZone_Elements()
	 * @model
	 * @generated
	 */
	EList<Element> getElements();

	/**
	 * Returns the value of the '<em><b>Subzones</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.TrustZone}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subzones</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subzones</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getTrustZone_Subzones()
	 * @model containment="true"
	 * @generated
	 */
	EList<TrustZone> getSubzones();

	/**
	 * Returns the value of the '<em><b>Attackerprofile</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.AttackerProfile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attackerprofile</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attackerprofile</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getTrustZone_Attackerprofile()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackerProfile> getAttackerprofile();

} // TrustZone
