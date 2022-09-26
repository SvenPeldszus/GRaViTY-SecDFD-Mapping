/**
 */
package org.secdfd.model;

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
 *   <li>{@link org.secdfd.model.Responsibility#getAction <em>Action</em>}</li>
 *   <li>{@link org.secdfd.model.Responsibility#getIncomeassets <em>Incomeassets</em>}</li>
 *   <li>{@link org.secdfd.model.Responsibility#getOutcomeassets <em>Outcomeassets</em>}</li>
 *   <li>{@link org.secdfd.model.Responsibility#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getResponsibility()
 * @model
 * @generated
 */
public interface Responsibility extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute list.
	 * The list contents are of type {@link org.secdfd.model.ResponsibilityType}.
	 * The literals are from the enumeration {@link org.secdfd.model.ResponsibilityType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute list.
	 * @see org.secdfd.model.ResponsibilityType
	 * @see org.secdfd.model.ModelPackage#getResponsibility_Action()
	 * @model
	 * @generated
	 */
	EList<ResponsibilityType> getAction();

	/**
	 * Returns the value of the '<em><b>Incomeassets</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Asset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomeassets</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getResponsibility_Incomeassets()
	 * @model
	 * @generated
	 */
	EList<Asset> getIncomeassets();

	/**
	 * Returns the value of the '<em><b>Outcomeassets</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Asset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcomeassets</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getResponsibility_Outcomeassets()
	 * @model
	 * @generated
	 */
	EList<Asset> getOutcomeassets();

	/**
	 * Returns the value of the '<em><b>Process</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.secdfd.model.Process#getResponsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' container reference.
	 * @see #setProcess(org.secdfd.model.Process)
	 * @see org.secdfd.model.ModelPackage#getResponsibility_Process()
	 * @see org.secdfd.model.Process#getResponsibility
	 * @model opposite="responsibility" transient="false"
	 * @generated
	 */
	org.secdfd.model.Process getProcess();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Responsibility#getProcess <em>Process</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' container reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(org.secdfd.model.Process value);

} // Responsibility
