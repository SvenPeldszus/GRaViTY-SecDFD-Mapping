/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.gravity.mapping.secdfd.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getUserdefined <em>Userdefined</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getIgnored <em>Ignored</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getSuggested <em>Suggested</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getAccepted <em>Accepted</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getName <em>Name</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getCorrespondences <em>Correspondences</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Userdefined</b></em>' reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userdefined</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Userdefined()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getUserdefined();

	/**
	 * Returns the value of the '<em><b>Ignored</b></em>' containment reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored</em>' containment reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Ignored()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractCorrespondence> getIgnored();

	/**
	 * Returns the value of the '<em><b>Suggested</b></em>' reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suggested</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Suggested()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getSuggested();

	/**
	 * Returns the value of the '<em><b>Accepted</b></em>' reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Accepted()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getAccepted();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Source()
	 * @model
	 * @generated
	 */
	EObject getSource();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EObject value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Correspondences</b></em>' containment reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correspondences</em>' containment reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Correspondences()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractCorrespondence> getCorrespondences();

} // Mapping
