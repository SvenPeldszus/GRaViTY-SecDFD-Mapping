/**
 */
package org.gravity.mapping.secdfd;

import graph.Node;

import org.eclipse.emf.ecore.EObject;

import org.gravity.typegraph.basic.TMethod;

import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method2 Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Method2Node#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Method2Node#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Node()
 * @model
 * @generated
 */
public interface Method2Node extends EObject, AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TMethod)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Node_Source()
	 * @model required="true"
	 * @generated
	 */
	TMethod getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Method2Node#getSource <em>Source</em>}' reference.
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
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getMethod2Node_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Method2Node#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // Method2Node
