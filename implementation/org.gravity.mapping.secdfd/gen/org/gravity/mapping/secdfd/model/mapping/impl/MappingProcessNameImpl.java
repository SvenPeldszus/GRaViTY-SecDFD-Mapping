/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gravity.mapping.secdfd.impl.Method2ElementImpl;

import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;

import org.gravity.mapping.secdfd.model.mapping.MappingRanking;
import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl#getDerived <em>Derived</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingProcessNameImpl extends Method2ElementImpl implements MappingProcessName {
	/**
	 * The default value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected static final int RANKING_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected int ranking = RANKING_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDerived() <em>Derived</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerived()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractCorrespondence> derived;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingProcessNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_PROCESS_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRanking(int newRanking) {
		int oldRanking = ranking;
		ranking = newRanking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_PROCESS_NAME__RANKING, oldRanking, ranking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractCorrespondence> getDerived() {
		if (derived == null) {
			derived = new EObjectResolvingEList<AbstractCorrespondence>(AbstractCorrespondence.class, this, MappingPackage.MAPPING_PROCESS_NAME__DERIVED);
		}
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.MAPPING_PROCESS_NAME__RANKING:
				return getRanking();
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVED:
				return getDerived();
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
			case MappingPackage.MAPPING_PROCESS_NAME__RANKING:
				setRanking((Integer)newValue);
				return;
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVED:
				getDerived().clear();
				getDerived().addAll((Collection<? extends AbstractCorrespondence>)newValue);
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
			case MappingPackage.MAPPING_PROCESS_NAME__RANKING:
				setRanking(RANKING_EDEFAULT);
				return;
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVED:
				getDerived().clear();
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
			case MappingPackage.MAPPING_PROCESS_NAME__RANKING:
				return ranking != RANKING_EDEFAULT;
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVED:
				return derived != null && !derived.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MappingRanking.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_PROCESS_NAME__RANKING: return MappingPackage.MAPPING_RANKING__RANKING;
				default: return -1;
			}
		}
		if (baseClass == AbstractMappingDerived.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_PROCESS_NAME__DERIVED: return MappingPackage.ABSTRACT_MAPPING_DERIVED__DERIVED;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MappingRanking.class) {
			switch (baseFeatureID) {
				case MappingPackage.MAPPING_RANKING__RANKING: return MappingPackage.MAPPING_PROCESS_NAME__RANKING;
				default: return -1;
			}
		}
		if (baseClass == AbstractMappingDerived.class) {
			switch (baseFeatureID) {
				case MappingPackage.ABSTRACT_MAPPING_DERIVED__DERIVED: return MappingPackage.MAPPING_PROCESS_NAME__DERIVED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (Ranking: ");
		result.append(ranking);
		result.append(')');
		return result.toString();
	}

} //MappingProcessNameImpl
