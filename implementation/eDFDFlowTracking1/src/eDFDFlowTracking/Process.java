/**
 */
package eDFDFlowTracking;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.Process#getResponsibility <em>Responsibility</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Element {
	/**
	 * Returns the value of the '<em><b>Responsibility</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Responsibility}.
	 * It is bidirectional and its opposite is '{@link eDFDFlowTracking.Responsibility#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsibility</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsibility</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getProcess_Responsibility()
	 * @see eDFDFlowTracking.Responsibility#getProcess
	 * @model opposite="process" containment="true"
	 * @generated
	 */
	EList<Responsibility> getResponsibility();

} // Process
