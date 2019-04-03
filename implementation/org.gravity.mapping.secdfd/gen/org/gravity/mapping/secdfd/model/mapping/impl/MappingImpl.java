/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;

import org.moflon.tgg.runtime.AbstractCorrespondence;

import org.moflon.tgg.runtime.impl.CorrespondenceModelImpl;

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
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends CorrespondenceModelImpl implements Mapping {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING__IGNORED:
				return ((InternalEList<?>)getIgnored()).basicRemove(otherEnd, msgs);
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
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
