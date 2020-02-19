/**
 */
package org.secdfd.model;

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
 *   <li>{@link org.secdfd.model.Assumption#getObjective <em>Objective</em>}</li>
 *   <li>{@link org.secdfd.model.Assumption#getLayer <em>Layer</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getAssumption()
 * @model
 * @generated
 */
public interface Assumption extends EObject {
	/**
	 * Returns the value of the '<em><b>Objective</b></em>' attribute list.
	 * The list contents are of type {@link org.secdfd.model.Objective}.
	 * The literals are from the enumeration {@link org.secdfd.model.Objective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective</em>' attribute list.
	 * @see org.secdfd.model.Objective
	 * @see org.secdfd.model.ModelPackage#getAssumption_Objective()
	 * @model
	 * @generated
	 */
	EList<Objective> getObjective();

	/**
	 * Returns the value of the '<em><b>Layer</b></em>' attribute.
	 * The literals are from the enumeration {@link org.secdfd.model.Layer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer</em>' attribute.
	 * @see org.secdfd.model.Layer
	 * @see #setLayer(Layer)
	 * @see org.secdfd.model.ModelPackage#getAssumption_Layer()
	 * @model
	 * @generated
	 */
	Layer getLayer();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Assumption#getLayer <em>Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer</em>' attribute.
	 * @see org.secdfd.model.Layer
	 * @see #getLayer()
	 * @generated
	 */
	void setLayer(Layer value);

} // Assumption
