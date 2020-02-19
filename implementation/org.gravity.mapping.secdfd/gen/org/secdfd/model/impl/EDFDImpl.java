/**
 */
package org.secdfd.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.secdfd.model.Asset;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ModelPackage;
import org.secdfd.model.TrustZone;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDFD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.impl.EDFDImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.secdfd.model.impl.EDFDImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.secdfd.model.impl.EDFDImpl#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.secdfd.model.impl.EDFDImpl#getTrustzones <em>Trustzones</em>}</li>
 *   <li>{@link org.secdfd.model.impl.EDFDImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EDFDImpl extends MinimalEObjectImpl.Container implements EDFD {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAsset() <em>Asset</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsset()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> asset;

	/**
	 * The cached value of the '{@link #getTrustzones() <em>Trustzones</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustzones()
	 * @generated
	 * @ordered
	 */
	protected EList<TrustZone> trustzones;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDFDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.EDFD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EDFD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EDFD__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Asset> getAsset() {
		if (asset == null) {
			asset = new EObjectContainmentEList<Asset>(Asset.class, this, ModelPackage.EDFD__ASSET);
		}
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TrustZone> getTrustzones() {
		if (trustzones == null) {
			trustzones = new EObjectContainmentEList<TrustZone>(TrustZone.class, this, ModelPackage.EDFD__TRUSTZONES);
		}
		return trustzones;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<Element>(Element.class, this, ModelPackage.EDFD__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.EDFD__ASSET:
				return ((InternalEList<?>)getAsset()).basicRemove(otherEnd, msgs);
			case ModelPackage.EDFD__TRUSTZONES:
				return ((InternalEList<?>)getTrustzones()).basicRemove(otherEnd, msgs);
			case ModelPackage.EDFD__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.EDFD__NAME:
				return getName();
			case ModelPackage.EDFD__NUMBER:
				return getNumber();
			case ModelPackage.EDFD__ASSET:
				return getAsset();
			case ModelPackage.EDFD__TRUSTZONES:
				return getTrustzones();
			case ModelPackage.EDFD__ELEMENTS:
				return getElements();
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
			case ModelPackage.EDFD__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.EDFD__NUMBER:
				setNumber((Integer)newValue);
				return;
			case ModelPackage.EDFD__ASSET:
				getAsset().clear();
				getAsset().addAll((Collection<? extends Asset>)newValue);
				return;
			case ModelPackage.EDFD__TRUSTZONES:
				getTrustzones().clear();
				getTrustzones().addAll((Collection<? extends TrustZone>)newValue);
				return;
			case ModelPackage.EDFD__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
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
			case ModelPackage.EDFD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.EDFD__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ModelPackage.EDFD__ASSET:
				getAsset().clear();
				return;
			case ModelPackage.EDFD__TRUSTZONES:
				getTrustzones().clear();
				return;
			case ModelPackage.EDFD__ELEMENTS:
				getElements().clear();
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
			case ModelPackage.EDFD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.EDFD__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ModelPackage.EDFD__ASSET:
				return asset != null && !asset.isEmpty();
			case ModelPackage.EDFD__TRUSTZONES:
				return trustzones != null && !trustzones.isEmpty();
			case ModelPackage.EDFD__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //EDFDImpl
