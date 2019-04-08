/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gravity.mapping.secdfd.impl.Defintion2ElementImpl;

import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessDefinitionImpl#getDerived <em>Derived</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingProcessDefinitionImpl extends Defintion2ElementImpl implements MappingProcessDefinition {
	/**
	 * The cached value of the '{@link #getDerived() <em>Derived</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerived()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractMappingBase> derived;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingProcessDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_PROCESS_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractMappingBase> getDerived() {
		if (derived == null) {
			derived = new EObjectWithInverseResolvingEList.ManyInverse<AbstractMappingBase>(AbstractMappingBase.class, this, MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED, MappingPackage.ABSTRACT_MAPPING_BASE__DERIVING);
		}
		return derived;
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDerived()).basicAdd(otherEnd, msgs);
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
				return ((InternalEList<?>)getDerived()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
				getDerived().clear();
				getDerived().addAll((Collection<? extends AbstractMappingBase>)newValue);
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
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
			case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED:
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
		if (baseClass == AbstractMappingDerived.class) {
			switch (derivedFeatureID) {
				case MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED: return MappingPackage.ABSTRACT_MAPPING_DERIVED__DERIVED;
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
		if (baseClass == AbstractMappingDerived.class) {
			switch (baseFeatureID) {
				case MappingPackage.ABSTRACT_MAPPING_DERIVED__DERIVED: return MappingPackage.MAPPING_PROCESS_DEFINITION__DERIVED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //MappingProcessDefinitionImpl
