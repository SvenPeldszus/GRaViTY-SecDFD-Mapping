/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.common.util.EList;

import org.gravity.mapping.secdfd.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Mapping Derived</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived#getDerived <em>Derived</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingDerived()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMappingDerived extends AbstractCorrespondence {
	/**
	 * Returns the value of the '<em><b>Derived</b></em>' reference list.
	 * The list contents are of type {@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase}.
	 * It is bidirectional and its opposite is '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase#getDeriving <em>Deriving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingDerived_Derived()
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase#getDeriving
	 * @model opposite="deriving"
	 * @generated
	 */
	EList<AbstractMappingBase> getDerived();

} // AbstractMappingDerived
