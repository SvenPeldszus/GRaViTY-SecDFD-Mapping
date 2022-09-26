/**
 */
package org.secdfd.model;

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
 *   <li>{@link org.secdfd.model.Value#getObjective <em>Objective</em>}</li>
 *   <li>{@link org.secdfd.model.Value#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends EObject {
	/**
	 * Returns the value of the '<em><b>Objective</b></em>' attribute.
	 * The literals are from the enumeration {@link org.secdfd.model.Objective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective</em>' attribute.
	 * @see org.secdfd.model.Objective
	 * @see #setObjective(Objective)
	 * @see org.secdfd.model.ModelPackage#getValue_Objective()
	 * @model
	 * @generated
	 */
	Objective getObjective();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Value#getObjective <em>Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective</em>' attribute.
	 * @see org.secdfd.model.Objective
	 * @see #getObjective()
	 * @generated
	 */
	void setObjective(Objective value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"H"</code>.
	 * The literals are from the enumeration {@link org.secdfd.model.Priority}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.secdfd.model.Priority
	 * @see #setPriority(Priority)
	 * @see org.secdfd.model.ModelPackage#getValue_Priority()
	 * @model default="H"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Value#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see org.secdfd.model.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

} // Value
