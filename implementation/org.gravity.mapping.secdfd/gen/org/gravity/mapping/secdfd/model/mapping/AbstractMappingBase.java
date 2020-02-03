/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.common.util.EList;

import org.gravity.mapping.secdfd.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Mapping Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase#getDeriving <em>Deriving</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingBase()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AbstractMappingBase extends AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Deriving</b></em>' reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived}.
	 * It is bidirectional and its opposite is '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived#getDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deriving</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingBase_Deriving()
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived#getDerived
	 * @model opposite="derived"
	 * @generated
	 */
	EList<AbstractMappingDerived> getDeriving();

} // AbstractMappingBase
