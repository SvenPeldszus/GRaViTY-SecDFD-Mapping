/**
 */
package org.gravity.mapping.secdfd.model.mapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gravity.mapping.secdfd.SecdfdPackage;

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
	 * The feature id for the '<em><b>Userdefined</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__USERDEFINED = 0;

	/**
	 * The feature id for the '<em><b>Ignored</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IGNORED = 1;

	/**
	 * The feature id for the '<em><b>Suggested</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SUGGESTED = 2;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ACCEPTED = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TARGET = 6;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CORRESPONDENCES = 7;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = 0;

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
	int ABSTRACT_MAPPING_DERIVED__DERIVED = SecdfdPackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Mapping Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_DERIVED_FEATURE_COUNT = SecdfdPackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Mapping Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_DERIVED_OPERATION_COUNT = SecdfdPackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME__RANKING = SecdfdPackage.METHOD2_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deriving</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME__DERIVING = SecdfdPackage.METHOD2_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_NAME_FEATURE_COUNT = SecdfdPackage.METHOD2_ELEMENT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Derived</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE__DERIVED = SecdfdPackage.SIGNATURE2_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deriving</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE__DERIVING = SecdfdPackage.SIGNATURE2_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_SIGNATURE_FEATURE_COUNT = SecdfdPackage.SIGNATURE2_ELEMENT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Deriving</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION__DERIVING = SecdfdPackage.DEFINTION2_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION_FEATURE_COUNT = SecdfdPackage.DEFINTION2_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Process Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROCESS_DEFINITION_OPERATION_COUNT = SecdfdPackage.DEFINTION2_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingRankingImpl <em>Abstract Mapping Ranking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingRankingImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingRanking()
	 * @generated
	 */
	int ABSTRACT_MAPPING_RANKING = 5;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_RANKING__RANKING = 0;

	/**
	 * The number of structural features of the '<em>Abstract Mapping Ranking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_RANKING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract Mapping Ranking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_RANKING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingEntityTypeImpl <em>Entity Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingEntityTypeImpl
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingEntityType()
	 * @generated
	 */
	int MAPPING_ENTITY_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE__SOURCE = SecdfdPackage.TYPE2_NAMED_ENTITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE__TARGET = SecdfdPackage.TYPE2_NAMED_ENTITY__TARGET;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE__RANKING = SecdfdPackage.TYPE2_NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deriving</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE__DERIVING = SecdfdPackage.TYPE2_NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE_FEATURE_COUNT = SecdfdPackage.TYPE2_NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entity Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ENTITY_TYPE_OPERATION_COUNT = SecdfdPackage.TYPE2_NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase <em>Abstract Mapping Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase
	 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingBase()
	 * @generated
	 */
	int ABSTRACT_MAPPING_BASE = 7;

	/**
	 * The feature id for the '<em><b>Deriving</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_BASE__DERIVING = SecdfdPackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Mapping Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_BASE_FEATURE_COUNT = SecdfdPackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Mapping Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_BASE_OPERATION_COUNT = SecdfdPackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the attribute '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getName()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Name();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getSource()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getTarget()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gravity.mapping.secdfd.model.mapping.Mapping#getCorrespondences <em>Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correspondences</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.Mapping#getCorrespondences()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Correspondences();

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
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking <em>Abstract Mapping Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Mapping Ranking</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking
	 * @generated
	 */
	EClass getAbstractMappingRanking();

	/**
	 * Returns the meta object for the attribute '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking#getRanking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ranking</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking#getRanking()
	 * @see #getAbstractMappingRanking()
	 * @generated
	 */
	EAttribute getAbstractMappingRanking_Ranking();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.MappingEntityType <em>Entity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Type</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingEntityType
	 * @generated
	 */
	EClass getMappingEntityType();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase <em>Abstract Mapping Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Mapping Base</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase
	 * @generated
	 */
	EClass getAbstractMappingBase();

	/**
	 * Returns the meta object for the reference list '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase#getDeriving <em>Deriving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deriving</em>'.
	 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase#getDeriving()
	 * @see #getAbstractMappingBase()
	 * @generated
	 */
	EReference getAbstractMappingBase_Deriving();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__NAME = eINSTANCE.getMapping_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SOURCE = eINSTANCE.getMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__TARGET = eINSTANCE.getMapping_Target();

		/**
		 * The meta object literal for the '<em><b>Correspondences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CORRESPONDENCES = eINSTANCE.getMapping_Correspondences();

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

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingRankingImpl <em>Abstract Mapping Ranking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.AbstractMappingRankingImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingRanking()
		 * @generated
		 */
		EClass ABSTRACT_MAPPING_RANKING = eINSTANCE.getAbstractMappingRanking();

		/**
		 * The meta object literal for the '<em><b>Ranking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MAPPING_RANKING__RANKING = eINSTANCE.getAbstractMappingRanking_Ranking();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.impl.MappingEntityTypeImpl <em>Entity Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingEntityTypeImpl
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getMappingEntityType()
		 * @generated
		 */
		EClass MAPPING_ENTITY_TYPE = eINSTANCE.getMappingEntityType();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase <em>Abstract Mapping Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase
		 * @see org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl#getAbstractMappingBase()
		 * @generated
		 */
		EClass ABSTRACT_MAPPING_BASE = eINSTANCE.getAbstractMappingBase();

		/**
		 * The meta object literal for the '<em><b>Deriving</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MAPPING_BASE__DERIVING = eINSTANCE.getAbstractMappingBase_Deriving();

	}

} //MappingPackage
