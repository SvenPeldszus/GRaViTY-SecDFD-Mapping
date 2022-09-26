/**
 */
package org.secdfd.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.Asset#getValue <em>Value</em>}</li>
 *   <li>{@link org.secdfd.model.Asset#getSource <em>Source</em>}</li>
 *   <li>{@link org.secdfd.model.Asset#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.secdfd.model.Asset#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getAsset()
 * @model
 * @generated
 */
public interface Asset extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.secdfd.model.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see org.secdfd.model.ModelPackage#getAsset_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getValue();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Element)
	 * @see org.secdfd.model.ModelPackage#getAsset_Source()
	 * @model required="true"
	 * @generated
	 */
	Element getSource();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Asset#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Element value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getAsset_Targets()
	 * @model required="true"
	 * @generated
	 */
	EList<Element> getTargets();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"String"</code>.
	 * The literals are from the enumeration {@link org.secdfd.model.AssetType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.secdfd.model.AssetType
	 * @see #setType(AssetType)
	 * @see org.secdfd.model.ModelPackage#getAsset_Type()
	 * @model default="String"
	 * @generated
	 */
	AssetType getType();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Asset#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.secdfd.model.AssetType
	 * @see #getType()
	 * @generated
	 */
	void setType(AssetType value);

} // Asset
