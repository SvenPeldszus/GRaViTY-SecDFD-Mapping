/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gravity.mapping.secdfd.SecdfdPackage;

import org.moflon.tgg.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gravity.mapping.secdfd.model.mapping.MappingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='org.gravity.mapping.secdfd.model'"
 * @generated
 */
public interface MappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gravity.mapping.secdfd/mapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gravity.mapping.secdfd.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingPackage eINSTANCE = org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CORRESPONDENCES = RuntimePackage.CORRESPONDENCE_MODEL__CORRESPONDENCES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE = RuntimePackage.CORRESPONDENCE_MODEL__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TARGET = RuntimePackage.CORRESPONDENCE_MODEL__TARGET;

	/**
	 * The feature id for the '<em><b>Userdefined</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__USERDEFINED = RuntimePackage.CORRESPONDENCE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ignored</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IGNORED = RuntimePackage.CORRESPONDENCE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Suggested</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SUGGESTED = RuntimePackage.CORRESPONDENCE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ACCEPTED = RuntimePackage.CORRESPONDENCE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = RuntimePackage.CORRESPONDENCE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = RuntimePackage.CORRESPONDENCE_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingDerivedImpl <em>Abstract Mapping Derived</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingDerivedImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingDerived()
	 * @generated
	 */
	int ABSTRACT_MAPPING_DERIVED = 1;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_DERIVED__DERIVED = 0;

	/**
	 * The number of structural features of the '<em>Abstract Mapping Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_DERIVED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract Mapping Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_DERIVED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl <em>Process Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessName()
	 * @generated
	 */
	int MAPPING_PROCESS_NAME = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME__SOURCE = SecdfdPackage.METHOD2_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME__TARGET = SecdfdPackage.METHOD2_ELEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME__DERIVED = SecdfdPackage.METHOD2_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME_FEATURE_COUNT = SecdfdPackage.METHOD2_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Process Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME_OPERATION_COUNT = SecdfdPackage.METHOD2_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessSignatureImpl <em>Process Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessSignatureImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessSignature()
	 * @generated
	 */
	int MAPPING_PROCESS_SIGNATURE = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE__SOURCE = SecdfdPackage.SIGNATURE2_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE__TARGET = SecdfdPackage.SIGNATURE2_ELEMENT__TARGET;

	/**
	 * The number of structural features of the '<em>Process Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE_FEATURE_COUNT = SecdfdPackage.SIGNATURE2_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE_OPERATION_COUNT = SecdfdPackage.SIGNATURE2_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessDefinitionImpl <em>Process Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessDefinitionImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessDefinition()
	 * @generated
	 */
	int MAPPING_PROCESS_DEFINITION = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION__SOURCE = SecdfdPackage.DEFINTION2_ELEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION__TARGET = SecdfdPackage.DEFINTION2_ELEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION__DERIVED = SecdfdPackage.DEFINTION2_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION_FEATURE_COUNT = SecdfdPackage.DEFINTION2_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Process Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION_OPERATION_COUNT = SecdfdPackage.DEFINTION2_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference list '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getUserdefined <em>Userdefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Userdefined</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getUserdefined()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Userdefined();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getIgnored <em>Ignored</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ignored</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getIgnored()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Ignored();

	/**
	 * Returns the meta object for the reference list '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getSuggested <em>Suggested</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Suggested</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getSuggested()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Suggested();

	/**
	 * Returns the meta object for the reference list '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getAccepted <em>Accepted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accepted</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getAccepted()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Accepted();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived <em>Abstract Mapping Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Mapping Derived</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived
	 * @generated
	 */
	EClass getAbstractMappingDerived();

	/**
	 * Returns the meta object for the reference list '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived#getDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived#getDerived()
	 * @see #getAbstractMappingDerived()
	 * @generated
	 */
	EReference getAbstractMappingDerived_Derived();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.MappingProcessName <em>Process Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Name</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingProcessName
	 * @generated
	 */
	EClass getMappingProcessName();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature <em>Process Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Signature</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature
	 * @generated
	 */
	EClass getMappingProcessSignature();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition <em>Process Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Definition</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition
	 * @generated
	 */
	EClass getMappingProcessDefinition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MappingFactory getMappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Userdefined</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__USERDEFINED = eINSTANCE.getMapping_Userdefined();

		/**
		 * The meta object literal for the '<em><b>Ignored</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__IGNORED = eINSTANCE.getMapping_Ignored();

		/**
		 * The meta object literal for the '<em><b>Suggested</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SUGGESTED = eINSTANCE.getMapping_Suggested();

		/**
		 * The meta object literal for the '<em><b>Accepted</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__ACCEPTED = eINSTANCE.getMapping_Accepted();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingDerivedImpl <em>Abstract Mapping Derived</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingDerivedImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingDerived()
		 * @generated
		 */
		EClass ABSTRACT_MAPPING_DERIVED = eINSTANCE.getAbstractMappingDerived();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MAPPING_DERIVED__DERIVED = eINSTANCE.getAbstractMappingDerived_Derived();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl <em>Process Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessNameImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessName()
		 * @generated
		 */
		EClass MAPPING_PROCESS_NAME = eINSTANCE.getMappingProcessName();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessSignatureImpl <em>Process Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessSignatureImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessSignature()
		 * @generated
		 */
		EClass MAPPING_PROCESS_SIGNATURE = eINSTANCE.getMappingProcessSignature();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessDefinitionImpl <em>Process Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingProcessDefinitionImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingProcessDefinition()
		 * @generated
		 */
		EClass MAPPING_PROCESS_DEFINITION = eINSTANCE.getMappingProcessDefinition();

	}

} //MappingPackage
