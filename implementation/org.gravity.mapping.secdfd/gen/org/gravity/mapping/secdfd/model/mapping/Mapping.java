/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;

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
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject, CorrespondenceModel {
	/**
	 * Returns the value of the '<em><b>Userdefined</b></em>' reference list.
	 * The list contents are of type {@link org.moflon.tgg.runtime.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Userdefined</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userdefined</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Userdefined()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getUserdefined();

	/**
	 * Returns the value of the '<em><b>Ignored</b></em>' containment reference list.
	 * The list contents are of type {@link org.moflon.tgg.runtime.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignored</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored</em>' containment reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Ignored()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractCorrespondence> getIgnored();

	/**
	 * Returns the value of the '<em><b>Suggested</b></em>' reference list.
	 * The list contents are of type {@link org.moflon.tgg.runtime.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suggested</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suggested</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Suggested()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getSuggested();

	/**
	 * Returns the value of the '<em><b>Accepted</b></em>' reference list.
	 * The list contents are of type {@link org.moflon.tgg.runtime.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accepted</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getMapping_Accepted()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getAccepted();

} // Mapping
