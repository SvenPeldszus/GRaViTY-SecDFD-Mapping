/**
 */
package eDFDFlowTracking;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.Assumption#getObjective <em>Objective</em>}</li>
 *   <li>{@link eDFDFlowTracking.Assumption#getLayer <em>Layer</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getAssumption()
 * @model
 * @generated
 */
public interface Assumption extends EObject {
	/**
	 * Returns the value of the '<em><b>Objective</b></em>' attribute list.
	 * The list contents are of type {@link eDFDFlowTracking.Objective}.
	 * The literals are from the enumeration {@link eDFDFlowTracking.Objective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective</em>' attribute list.
	 * @see eDFDFlowTracking.Objective
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getAssumption_Objective()
	 * @model
	 * @generated
	 */
	EList<Objective> getObjective();

	/**
	 * Returns the value of the '<em><b>Layer</b></em>' attribute.
	 * The literals are from the enumeration {@link eDFDFlowTracking.Layer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer</em>' attribute.
	 * @see eDFDFlowTracking.Layer
	 * @see #setLayer(Layer)
	 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getAssumption_Layer()
	 * @model
	 * @generated
	 */
	Layer getLayer();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Assumption#getLayer <em>Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer</em>' attribute.
	 * @see eDFDFlowTracking.Layer
	 * @see #getLayer()
	 * @generated
	 */
	void setLayer(Layer value);

} // Assumption
