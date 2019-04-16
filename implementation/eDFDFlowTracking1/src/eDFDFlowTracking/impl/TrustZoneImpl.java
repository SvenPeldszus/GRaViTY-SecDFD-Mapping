/**
 */
package eDFDFlowTracking.impl;

import eDFDFlowTracking.AttackerProfile;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.TrustZone;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trust Zone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.impl.TrustZoneImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.TrustZoneImpl#getSubzones <em>Subzones</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.TrustZoneImpl#getAttackerprofile <em>Attackerprofile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrustZoneImpl extends ElementImpl implements TrustZone {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

	/**
	 * The cached value of the '{@link #getSubzones() <em>Subzones</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubzones()
	 * @generated
	 * @ordered
	 */
	protected EList<TrustZone> subzones;

	/**
	 * The cached value of the '{@link #getAttackerprofile() <em>Attackerprofile</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerprofile()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerProfile> attackerprofile;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrustZoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EDFDFlowTracking1Package.Literals.TRUST_ZONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<Element>(Element.class, this, EDFDFlowTracking1Package.TRUST_ZONE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TrustZone> getSubzones() {
		if (subzones == null) {
			subzones = new EObjectContainmentEList<TrustZone>(TrustZone.class, this, EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES);
		}
		return subzones;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttackerProfile> getAttackerprofile() {
		if (attackerprofile == null) {
			attackerprofile = new EObjectContainmentEList<AttackerProfile>(AttackerProfile.class, this, EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE);
		}
		return attackerprofile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES:
				return ((InternalEList<?>)getSubzones()).basicRemove(otherEnd, msgs);
			case EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE:
				return ((InternalEList<?>)getAttackerprofile()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EDFDFlowTracking1Package.TRUST_ZONE__ELEMENTS:
				return getElements();
			case EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES:
				return getSubzones();
			case EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE:
				return getAttackerprofile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EDFDFlowTracking1Package.TRUST_ZONE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
				return;
			case EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES:
				getSubzones().clear();
				getSubzones().addAll((Collection<? extends TrustZone>)newValue);
				return;
			case EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE:
				getAttackerprofile().clear();
				getAttackerprofile().addAll((Collection<? extends AttackerProfile>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EDFDFlowTracking1Package.TRUST_ZONE__ELEMENTS:
				getElements().clear();
				return;
			case EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES:
				getSubzones().clear();
				return;
			case EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE:
				getAttackerprofile().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EDFDFlowTracking1Package.TRUST_ZONE__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case EDFDFlowTracking1Package.TRUST_ZONE__SUBZONES:
				return subzones != null && !subzones.isEmpty();
			case EDFDFlowTracking1Package.TRUST_ZONE__ATTACKERPROFILE:
				return attackerprofile != null && !attackerprofile.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TrustZoneImpl
