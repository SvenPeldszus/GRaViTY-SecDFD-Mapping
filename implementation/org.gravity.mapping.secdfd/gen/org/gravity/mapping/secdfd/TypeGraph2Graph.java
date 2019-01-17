/**
 */
package org.gravity.mapping.secdfd;

import graph.Graph;

import org.eclipse.emf.ecore.EObject;

import org.gravity.typegraph.basic.TypeGraph;

import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Graph2 Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.SecdfdPackage#getTypeGraph2Graph()
 * @model
 * @generated
 */
public interface TypeGraph2Graph extends EObject, AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(TypeGraph)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getTypeGraph2Graph_Source()
	 * @model required="true"
	 * @generated
	 */
	TypeGraph getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TypeGraph value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Graph)
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#getTypeGraph2Graph_Target()
	 * @model required="true"
	 * @generated
	 */
	Graph getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Graph value);

} // TypeGraph2Graph
