/**
 */
package eDFDFlowTracking;

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
 *   <li>{@link eDFDFlowTracking.Asset#getValue <em>Value</em>}</li>
 *   <li>{@link eDFDFlowTracking.Asset#getSource <em>Source</em>}</li>
 *   <li>{@link eDFDFlowTracking.Asset#getTargets <em>Targets</em>}</li>
 *   <li>{@link eDFDFlowTracking.Asset#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAsset()
 * @model
 * @generated
 */
public interface Asset extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAsset_Value()
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
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAsset_Source()
	 * @model required="true"
	 * @generated
	 */
	Element getSource();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Asset#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Element value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAsset_Targets()
	 * @model required="true"
	 * @generated
	 */
	EList<Element> getTargets();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"String"</code>.
	 * The literals are from the enumeration {@link eDFDFlowTracking.AssetType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eDFDFlowTracking.AssetType
	 * @see #setType(AssetType)
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getAsset_Type()
	 * @model default="String"
	 * @generated
	 */
	AssetType getType();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Asset#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eDFDFlowTracking.AssetType
	 * @see #getType()
	 * @generated
	 */
	void setType(AssetType value);

} // Asset
