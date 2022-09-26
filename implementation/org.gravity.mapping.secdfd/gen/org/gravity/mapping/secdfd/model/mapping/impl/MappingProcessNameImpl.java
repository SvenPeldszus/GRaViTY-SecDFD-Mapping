/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gravity.mapping.secdfd.impl.Method2ElementImpl;

import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl#getDeriving <em>Deriving</em>}</li>
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
	 * The cached value of the '{@link #getDeriving() <em>Deriving</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeriving()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractMappingDerived> deriving;

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
	@Override
	public int getRanking() {
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public EList<AbstractMappingDerived> getDeriving() {
		if (deriving == null) {
			deriving = new EObjectWithInverseResolvingEList.ManyInverse<AbstractMappingDerived>(AbstractMappingDerived.class, this, MappingPackage.MAPPING_PROCESS_NAME__DERIVING, MappingPackage.ABSTRACT_MAPPING_DERIVED__DERIVED);
		}
		return deriving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeriving()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				return ((InternalEList<?>)getDeriving()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_PROCESS_NAME__RANKING:
				return getRanking();
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				return getDeriving();
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
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				getDeriving().clear();
				getDeriving().addAll((Collection<? extends AbstractMappingDerived>)newValue);
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
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				getDeriving().clear();
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
			case MappingPackage.MAPPING_PROCESS_NAME__DERIVING:
				return deriving != null && !deriving.isEmpty();
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
		if (baseClass == AbstractMappingRanking.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_PROCESS_NAME__RANKING: return MappingPackage.ABSTRACT_MAPPING_RANKING__RANKING;
				default: return -1;
			}
		}
		if (baseClass == AbstractMappingBase.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_PROCESS_NAME__DERIVING: return MappingPackage.ABSTRACT_MAPPING_BASE__DERIVING;
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
		if (baseClass == AbstractMappingRanking.class) {
			switch (baseFeatureID) {
				case MappingPackage.ABSTRACT_MAPPING_RANKING__RANKING: return MappingPackage.MAPPING_PROCESS_NAME__RANKING;
				default: return -1;
			}
		}
		if (baseClass == AbstractMappingBase.class) {
			switch (baseFeatureID) {
				case MappingPackage.ABSTRACT_MAPPING_BASE__DERIVING: return MappingPackage.MAPPING_PROCESS_NAME__DERIVING;
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
