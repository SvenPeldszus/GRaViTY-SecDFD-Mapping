/**
 */
package eDFDFlowTracking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.AttackerProfile#getObservation <em>Observation</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAttackerProfile()
 * @model
 * @generated
 */
public interface AttackerProfile extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Observation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observation</em>' attribute.
	 * @see #setObservation(int)
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAttackerProfile_Observation()
	 * @model required="true"
	 * @generated
	 */
	int getObservation();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.AttackerProfile#getObservation <em>Observation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observation</em>' attribute.
	 * @see #getObservation()
	 * @generated
	 */
	void setObservation(int value);

} // AttackerProfile
