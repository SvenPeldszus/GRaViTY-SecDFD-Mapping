/**
 */
package eDFDFlowTracking;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.Element#getOutflows <em>Outflows</em>}</li>
 *   <li>{@link eDFDFlowTracking.Element#getAssumption <em>Assumption</em>}</li>
 *   <li>{@link eDFDFlowTracking.Element#getAssets <em>Assets</em>}</li>
 *   <li>{@link eDFDFlowTracking.Element#getInflows <em>Inflows</em>}</li>
 *   <li>{@link eDFDFlowTracking.Element#isAttacker <em>Attacker</em>}</li>
 * </ul>
 *
 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Outflows</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Flow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outflows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outflows</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement_Outflows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Flow> getOutflows();

	/**
	 * Returns the value of the '<em><b>Assumption</b></em>' containment reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Assumption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assumption</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assumption</em>' containment reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement_Assumption()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assumption> getAssumption();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement_Assets()
	 * @model
	 * @generated
	 */
	EList<Asset> getAssets();

	/**
	 * Returns the value of the '<em><b>Inflows</b></em>' reference list.
	 * The list contents are of type {@link eDFDFlowTracking.Flow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inflows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inflows</em>' reference list.
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement_Inflows()
	 * @model
	 * @generated
	 */
	EList<Flow> getInflows();

	/**
	 * Returns the value of the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attacker</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attacker</em>' attribute.
	 * @see #setAttacker(boolean)
	 * @see eDFDFlowTracking.EDFDFlowTrackingPackage#getElement_Attacker()
	 * @model
	 * @generated
	 */
	boolean isAttacker();

	/**
	 * Sets the value of the '{@link eDFDFlowTracking.Element#isAttacker <em>Attacker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacker</em>' attribute.
	 * @see #isAttacker()
	 * @generated
	 */
	void setAttacker(boolean value);

} // Element
