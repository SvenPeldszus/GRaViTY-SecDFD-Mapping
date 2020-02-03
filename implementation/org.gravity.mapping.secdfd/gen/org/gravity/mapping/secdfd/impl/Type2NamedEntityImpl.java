/**
 */
package org.gravity.mapping.secdfd.impl;

import eDFDFlowTracking.NamedEntity;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gravity.mapping.secdfd.SecdfdPackage;
import org.gravity.mapping.secdfd.Type2NamedEntity;

import org.gravity.typegraph.basic.TAbstractType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type2 Named Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Type2NamedEntityImpl extends MinimalEObjectImpl.Container implements Type2NamedEntity {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected TAbstractType source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected NamedEntity target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Type2NamedEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecdfdPackage.Literals.TYPE2_NAMED_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TAbstractType getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (TAbstractType)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TAbstractType basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(TAbstractType newSource) {
		TAbstractType oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedEntity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (NamedEntity)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEntity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(NamedEntity newTarget) {
		NamedEntity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE:
				setSource((TAbstractType)newValue);
				return;
			case SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET:
				setTarget((NamedEntity)newValue);
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
			case SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE:
				setSource((TAbstractType)null);
				return;
			case SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET:
				setTarget((NamedEntity)null);
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
			case SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE:
				return source != null;
			case SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //Type2NamedEntityImpl
