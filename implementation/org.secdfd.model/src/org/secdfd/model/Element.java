/**
 */
package org.secdfd.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.Element#getOutflows <em>Outflows</em>}</li>
 *   <li>{@link org.secdfd.model.Element#getAssumption <em>Assumption</em>}</li>
 *   <li>{@link org.secdfd.model.Element#getAssets <em>Assets</em>}</li>
 *   <li>{@link org.secdfd.model.Element#getInflows <em>Inflows</em>}</li>
 *   <li>{@link org.secdfd.model.Element#isAttacker <em>Attacker</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Outflows</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.Flow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outflows</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getElement_Outflows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Flow> getOutflows();

	/**
	 * Returns the value of the '<em><b>Assumption</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.Assumption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assumption</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getElement_Assumption()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assumption> getAssumption();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Asset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getElement_Assets()
	 * @model
	 * @generated
	 */
	EList<Asset> getAssets();

	/**
	 * Returns the value of the '<em><b>Inflows</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Flow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inflows</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getElement_Inflows()
	 * @model
	 * @generated
	 */
	EList<Flow> getInflows();

	/**
	 * Returns the value of the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attacker</em>' attribute.
	 * @see #setAttacker(boolean)
	 * @see org.secdfd.model.ModelPackage#getElement_Attacker()
	 * @model
	 * @generated
	 */
	boolean isAttacker();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Element#isAttacker <em>Attacker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacker</em>' attribute.
	 * @see #isAttacker()
	 * @generated
	 */
	void setAttacker(boolean value);

} // Element
