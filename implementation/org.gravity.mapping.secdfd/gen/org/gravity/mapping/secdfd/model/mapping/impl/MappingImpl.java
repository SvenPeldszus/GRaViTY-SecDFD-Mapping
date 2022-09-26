/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gravity.mapping.secdfd.AbstractCorrespondence;

import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getUserdefined <em>Userdefined</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getIgnored <em>Ignored</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getSuggested <em>Suggested</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getAccepted <em>Accepted</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl#getCorrespondences <em>Correspondences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends MinimalEObjectImpl.Container implements Mapping {
	/**
	 * The cached value of the '{@link #getUserdefined() <em>Userdefined</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserdefined()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> userdefined;

	/**
	 * The cached value of the '{@link #getIgnored() <em>Ignored</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnored()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> ignored;

	/**
	 * The cached value of the '{@link #getSuggested() <em>Suggested</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuggested()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> suggested;

	/**
	 * The cached value of the '{@link #getAccepted() <em>Accepted</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccepted()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> accepted;

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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EObject source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The cached value of the '{@link #getCorrespondences() <em>Correspondences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondences()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> correspondences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getUserdefined() {
		if (userdefined == null) {
			userdefined = new EObjectResolvingEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING__USERDEFINED);
		}
		return userdefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getIgnored() {
		if (ignored == null) {
			ignored = new EObjectContainmentEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING__IGNORED);
		}
		return ignored;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getSuggested() {
		if (suggested == null) {
			suggested = new EObjectResolvingEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING__SUGGESTED);
		}
		return suggested;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getAccepted() {
		if (accepted == null) {
			accepted = new EObjectResolvingEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING__ACCEPTED);
		}
		return accepted;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(EObject newSource) {
		EObject oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getCorrespondences() {
		if (correspondences == null) {
			correspondences = new EObjectContainmentEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING__CORRESPONDENCES);
		}
		return correspondences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING__IGNORED:
				return ((InternalEList<?>)getIgnored()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING__CORRESPONDENCES:
				return ((InternalEList<?>)getCorrespondences()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING__USERDEFINED:
				return getUserdefined();
			case MappingPackage.MAPPING__IGNORED:
				return getIgnored();
			case MappingPackage.MAPPING__SUGGESTED:
				return getSuggested();
			case MappingPackage.MAPPING__ACCEPTED:
				return getAccepted();
			case MappingPackage.MAPPING__NAME:
				return getName();
			case MappingPackage.MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MappingPackage.MAPPING__CORRESPONDENCES:
				return getCorrespondences();
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
			case MappingPackage.MAPPING__USERDEFINED:
				getUserdefined().clear();
				getUserdefined().addAll((Collection<? extends AbstractCorrespondence>)newValue);
				return;
			case MappingPackage.MAPPING__IGNORED:
				getIgnored().clear();
				getIgnored().addAll((Collection<? extends AbstractCorrespondence>)newValue);
				return;
			case MappingPackage.MAPPING__SUGGESTED:
				getSuggested().clear();
				getSuggested().addAll((Collection<? extends AbstractCorrespondence>)newValue);
				return;
			case MappingPackage.MAPPING__ACCEPTED:
				getAccepted().clear();
				getAccepted().addAll((Collection<? extends AbstractCorrespondence>)newValue);
				return;
			case MappingPackage.MAPPING__NAME:
				setName((String)newValue);
				return;
			case MappingPackage.MAPPING__SOURCE:
				setSource((EObject)newValue);
				return;
			case MappingPackage.MAPPING__TARGET:
				setTarget((EObject)newValue);
				return;
			case MappingPackage.MAPPING__CORRESPONDENCES:
				getCorrespondences().clear();
				getCorrespondences().addAll((Collection<? extends AbstractCorrespondence>)newValue);
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
			case MappingPackage.MAPPING__USERDEFINED:
				getUserdefined().clear();
				return;
			case MappingPackage.MAPPING__IGNORED:
				getIgnored().clear();
				return;
			case MappingPackage.MAPPING__SUGGESTED:
				getSuggested().clear();
				return;
			case MappingPackage.MAPPING__ACCEPTED:
				getAccepted().clear();
				return;
			case MappingPackage.MAPPING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MappingPackage.MAPPING__SOURCE:
				setSource((EObject)null);
				return;
			case MappingPackage.MAPPING__TARGET:
				setTarget((EObject)null);
				return;
			case MappingPackage.MAPPING__CORRESPONDENCES:
				getCorrespondences().clear();
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
			case MappingPackage.MAPPING__USERDEFINED:
				return userdefined != null && !userdefined.isEmpty();
			case MappingPackage.MAPPING__IGNORED:
				return ignored != null && !ignored.isEmpty();
			case MappingPackage.MAPPING__SUGGESTED:
				return suggested != null && !suggested.isEmpty();
			case MappingPackage.MAPPING__ACCEPTED:
				return accepted != null && !accepted.isEmpty();
			case MappingPackage.MAPPING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MappingPackage.MAPPING__SOURCE:
				return source != null;
			case MappingPackage.MAPPING__TARGET:
				return target != null;
			case MappingPackage.MAPPING__CORRESPONDENCES:
				return correspondences != null && !correspondences.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MappingImpl
