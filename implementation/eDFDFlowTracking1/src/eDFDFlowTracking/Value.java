/**
 */
package eDFDFlowTracking;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.Value#getObjective <em>Objective</em>}</li>
 *   <li>{@link eDFDFlowTracking.Value#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getValue()
 * @model
 * @generated
 */
public interface Value extends EObject {
	/**
	 * Returns the value of the '<em><b>Objective</b></em>' attribute.
	 * The literals are from the enumeration {@link eDFDFlowTracking.Objective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective</em>' attribute.
	 * @see eDFDFlowTracking.Objective
	 * @see #setObjective(Objective)
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getValue_Objective()
	 * @model
	 * @generated
	 */
	Objective getObjective();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Value#getObjective <em>Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective</em>' attribute.
	 * @see eDFDFlowTracking.Objective
	 * @see #getObjective()
	 * @generated
	 */
	void setObjective(Objective value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"H"</code>.
	 * The literals are from the enumeration {@link eDFDFlowTracking.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see eDFDFlowTracking.Priority
	 * @see #setPriority(Priority)
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getValue_Priority()
	 * @model default="H"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Value#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see eDFDFlowTracking.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

} // Value
