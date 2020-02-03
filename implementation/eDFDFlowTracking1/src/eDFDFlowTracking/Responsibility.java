/**
 */
package eDFDFlowTracking;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Responsibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.Responsibility#getAction <em>Action</em>}</li>
 *   <li>{@link eDFDFlowTracking.Responsibility#getIncomeassets <em>Incomeassets</em>}</li>
 *   <li>{@link eDFDFlowTracking.Responsibility#getOutcomeassets <em>Outcomeassets</em>}</li>
 *   <li>{@link eDFDFlowTracking.Responsibility#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getResponsibility()
 * @model
 * @generated
 */
public interface Responsibility extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute list.
	 * The list contents are of type {@link eDFDFlowTracking.ResponsibilityType}.
	 * The literals are from the enumeration {@link eDFDFlowTracking.ResponsibilityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute list.
	 * @see eDFDFlowTracking.ResponsibilityType
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getResponsibility_Action()
	 * @model
	 * @generated
	 */
	EList<ResponsibilityType> getAction();

	/**
	 * Returns the value of the '<em><b>Incomeassets</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomeassets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomeassets</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getResponsibility_Incomeassets()
	 * @model
	 * @generated
	 */
	EList<Asset> getIncomeassets();

	/**
	 * Returns the value of the '<em><b>Outcomeassets</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcomeassets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcomeassets</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getResponsibility_Outcomeassets()
	 * @model
	 * @generated
	 */
	EList<Asset> getOutcomeassets();

	/**
	 * Returns the value of the '<em><b>Process</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eDFDFlowTracking.Process#getResponsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' container reference.
	 * @see #setProcess(eDFDFlowTracking.Process)
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getResponsibility_Process()
	 * @see eDFDFlowTracking.Process#getResponsibility
	 * @model opposite="responsibility" transient="false"
	 * @generated
	 */
	eDFDFlowTracking.Process getProcess();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Responsibility#getProcess <em>Process</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' container reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(eDFDFlowTracking.Process value);

} // Responsibility
