/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Mapping Ranking</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking#getRanking <em>Ranking</em>}</li>
 * </ul>
 *
 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingRanking()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMappingRanking extends EObject {
	/**
	 * Returns the value of the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking</em>' attribute.
	 * @see #setRanking(int)
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#getAbstractMappingRanking_Ranking()
	 * @model
	 * @generated
	 */
	int getRanking();

	/**
	 * Sets the value of the '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking#getRanking <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ranking</em>' attribute.
	 * @see #getRanking()
	 * @generated
	 */
	void setRanking(int value);

} // AbstractMappingRanking
