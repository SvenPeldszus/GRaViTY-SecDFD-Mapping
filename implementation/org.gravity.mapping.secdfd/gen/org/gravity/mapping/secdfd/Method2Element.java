/**
 */
package org.gravity.mapping.secdfd;

import org.gravity.typegraph.basic.TMethod;

import org.secdfd.model.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method2 Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Method2Element#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Method2Element#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Element()
 * @model
 * @generated
 */
public interface Method2Element extends AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TMethod)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Element_Source()
	 * @model required="true"
	 * @generated
	 */
	TMethod getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Method2Element#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TMethod value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Element)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Element_Target()
	 * @model required="true"
	 * @generated
	 */
	Element getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Method2Element#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Element value);

} // Method2Element
