/**
 */
package org.gravity.mapping.secdfd;

import graph.Node;

import org.eclipse.emf.ecore.EObject;

import org.gravity.typegraph.basic.TMethodDefinition;

import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defintion2 Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.Defintion2Node#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.Defintion2Node#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getDefintion2Node()
 * @model
 * @generated
 */
public interface Defintion2Node extends EObject, AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TMethodDefinition)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getDefintion2Node_Source()
	 * @model required="true"
	 * @generated
	 */
	TMethodDefinition getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Defintion2Node#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TMethodDefinition value);

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
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getDefintion2Node_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.Defintion2Node#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // Defintion2Node
