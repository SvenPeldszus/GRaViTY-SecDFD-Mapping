/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.common.util.EList;
import org.moflon.tgg.runtime.AbstractCorrespondence;

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
public interface AbstractMappingDerived extends MappingRanking {
	/**
	 * Returns the value of the '<em><b>Derived</b></em>' reference list.
	 * The list contents are of type {@link org.moflon.tgg.runtime.AbstractCorrespondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' reference list.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingDerived_Derived()
	 * @model
	 * @generated
	 */
	EList<AbstractCorrespondence> getDerived();

} // AbstractMappingDerived
