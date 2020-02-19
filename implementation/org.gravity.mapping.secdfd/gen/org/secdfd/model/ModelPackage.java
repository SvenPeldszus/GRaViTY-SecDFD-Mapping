/**
 */
package org.secdfd.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.secdfd.model.ModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.secdfd.org/secdfd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.secdfd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.secdfd.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.secdfd.model.NamedEntity <em>Named Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.NamedEntity
	 * @see org.secdfd.model.impl.ModelPackageImpl#getNamedEntity()
	 * @generated
	 */
	int NAMED_ENTITY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY__NUMBER = 1;

	/**
	 * The number of structural features of the '<em>Named Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Named Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.AssetImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__NUMBER = NAMED_ENTITY__NUMBER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__VALUE = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__SOURCE = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TARGETS = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TYPE = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_OPERATION_COUNT = NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.ElementImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NUMBER = NAMED_ENTITY__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OUTFLOWS = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ASSUMPTION = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ASSETS = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__INFLOWS = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ATTACKER = NAMED_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.ProcessImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NUMBER = ELEMENT__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__OUTFLOWS = ELEMENT__OUTFLOWS;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ASSUMPTION = ELEMENT__ASSUMPTION;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ASSETS = ELEMENT__ASSETS;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__INFLOWS = ELEMENT__INFLOWS;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ATTACKER = ELEMENT__ATTACKER;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__RESPONSIBILITY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.EDFDImpl <em>EDFD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.EDFDImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getEDFD()
	 * @generated
	 */
	int EDFD = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD__NUMBER = NAMED_ENTITY__NUMBER;

	/**
	 * The feature id for the '<em><b>Asset</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD__ASSET = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trustzones</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD__TRUSTZONES = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD__ELEMENTS = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDFD_OPERATION_COUNT = NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.DataStoreImpl <em>Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.DataStoreImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getDataStore()
	 * @generated
	 */
	int DATA_STORE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__NUMBER = ELEMENT__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__OUTFLOWS = ELEMENT__OUTFLOWS;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ASSUMPTION = ELEMENT__ASSUMPTION;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ASSETS = ELEMENT__ASSETS;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__INFLOWS = ELEMENT__INFLOWS;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ATTACKER = ELEMENT__ATTACKER;

	/**
	 * The number of structural features of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.FlowImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__NUMBER = ELEMENT__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__OUTFLOWS = ELEMENT__OUTFLOWS;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__ASSUMPTION = ELEMENT__ASSUMPTION;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__ASSETS = ELEMENT__ASSETS;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__INFLOWS = ELEMENT__INFLOWS;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__ATTACKER = ELEMENT__ATTACKER;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__CHANNEL = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__SOURCE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__LABEL = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.ExternalEntityImpl <em>External Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.ExternalEntityImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getExternalEntity()
	 * @generated
	 */
	int EXTERNAL_ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__NUMBER = ELEMENT__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__OUTFLOWS = ELEMENT__OUTFLOWS;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ASSUMPTION = ELEMENT__ASSUMPTION;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ASSETS = ELEMENT__ASSETS;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__INFLOWS = ELEMENT__INFLOWS;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY__ATTACKER = ELEMENT__ATTACKER;

	/**
	 * The number of structural features of the '<em>External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ENTITY_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.ValueImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 8;

	/**
	 * The feature id for the '<em><b>Objective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__OBJECTIVE = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__PRIORITY = 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.AssumptionImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 9;

	/**
	 * The feature id for the '<em><b>Objective</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__OBJECTIVE = 0;

	/**
	 * The feature id for the '<em><b>Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__LAYER = 1;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.AttackerProfileImpl <em>Attacker Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.AttackerProfileImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getAttackerProfile()
	 * @generated
	 */
	int ATTACKER_PROFILE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__NUMBER = NAMED_ENTITY__NUMBER;

	/**
	 * The feature id for the '<em><b>Observation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE__OBSERVATION = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attacker Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attacker Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_PROFILE_OPERATION_COUNT = NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.TrustZoneImpl <em>Trust Zone</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.TrustZoneImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getTrustZone()
	 * @generated
	 */
	int TRUST_ZONE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__NUMBER = ELEMENT__NUMBER;

	/**
	 * The feature id for the '<em><b>Outflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__OUTFLOWS = ELEMENT__OUTFLOWS;

	/**
	 * The feature id for the '<em><b>Assumption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__ASSUMPTION = ELEMENT__ASSUMPTION;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__ASSETS = ELEMENT__ASSETS;

	/**
	 * The feature id for the '<em><b>Inflows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__INFLOWS = ELEMENT__INFLOWS;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__ATTACKER = ELEMENT__ATTACKER;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__ELEMENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subzones</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__SUBZONES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attackerprofile</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE__ATTACKERPROFILE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Trust Zone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Trust Zone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUST_ZONE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.impl.ResponsibilityImpl
	 * @see org.secdfd.model.impl.ModelPackageImpl#getResponsibility()
	 * @generated
	 */
	int RESPONSIBILITY = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__NAME = NAMED_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__NUMBER = NAMED_ENTITY__NUMBER;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__ACTION = NAMED_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incomeassets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__INCOMEASSETS = NAMED_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outcomeassets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__OUTCOMEASSETS = NAMED_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Process</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__PROCESS = NAMED_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Responsibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_FEATURE_COUNT = NAMED_ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Responsibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_OPERATION_COUNT = NAMED_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.secdfd.model.Priority <em>Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.Priority
	 * @see org.secdfd.model.impl.ModelPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 13;

	/**
	 * The meta object id for the '{@link org.secdfd.model.Channel <em>Channel</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.Channel
	 * @see org.secdfd.model.impl.ModelPackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 14;

	/**
	 * The meta object id for the '{@link org.secdfd.model.ResponsibilityType <em>Responsibility Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.ResponsibilityType
	 * @see org.secdfd.model.impl.ModelPackageImpl#getResponsibilityType()
	 * @generated
	 */
	int RESPONSIBILITY_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.secdfd.model.Objective <em>Objective</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.Objective
	 * @see org.secdfd.model.impl.ModelPackageImpl#getObjective()
	 * @generated
	 */
	int OBJECTIVE = 16;

	/**
	 * The meta object id for the '{@link org.secdfd.model.Layer <em>Layer</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.Layer
	 * @see org.secdfd.model.impl.ModelPackageImpl#getLayer()
	 * @generated
	 */
	int LAYER = 17;

	/**
	 * The meta object id for the '{@link org.secdfd.model.AssetType <em>Asset Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.secdfd.model.AssetType
	 * @see org.secdfd.model.impl.ModelPackageImpl#getAssetType()
	 * @generated
	 */
	int ASSET_TYPE = 18;


	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see org.secdfd.model.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.Asset#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.secdfd.model.Asset#getValue()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Value();

	/**
	 * Returns the meta object for the reference '{@link org.secdfd.model.Asset#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.secdfd.model.Asset#getSource()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Asset#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.secdfd.model.Asset#getTargets()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Targets();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Asset#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.secdfd.model.Asset#getType()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Type();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.secdfd.model.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.Process#getResponsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Responsibility</em>'.
	 * @see org.secdfd.model.Process#getResponsibility()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Responsibility();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.EDFD <em>EDFD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDFD</em>'.
	 * @see org.secdfd.model.EDFD
	 * @generated
	 */
	EClass getEDFD();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.EDFD#getAsset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Asset</em>'.
	 * @see org.secdfd.model.EDFD#getAsset()
	 * @see #getEDFD()
	 * @generated
	 */
	EReference getEDFD_Asset();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.EDFD#getTrustzones <em>Trustzones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trustzones</em>'.
	 * @see org.secdfd.model.EDFD#getTrustzones()
	 * @see #getEDFD()
	 * @generated
	 */
	EReference getEDFD_Trustzones();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.EDFD#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.secdfd.model.EDFD#getElements()
	 * @see #getEDFD()
	 * @generated
	 */
	EReference getEDFD_Elements();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store</em>'.
	 * @see org.secdfd.model.DataStore
	 * @generated
	 */
	EClass getDataStore();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see org.secdfd.model.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Flow#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see org.secdfd.model.Flow#getChannel()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_Channel();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Flow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see org.secdfd.model.Flow#getTarget()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Target();

	/**
	 * Returns the meta object for the reference '{@link org.secdfd.model.Flow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.secdfd.model.Flow#getSource()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Flow#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.secdfd.model.Flow#getLabel()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_Label();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.ExternalEntity <em>External Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Entity</em>'.
	 * @see org.secdfd.model.ExternalEntity
	 * @generated
	 */
	EClass getExternalEntity();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.secdfd.model.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.Element#getOutflows <em>Outflows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outflows</em>'.
	 * @see org.secdfd.model.Element#getOutflows()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Outflows();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.Element#getAssumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assumption</em>'.
	 * @see org.secdfd.model.Element#getAssumption()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Assumption();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Element#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assets</em>'.
	 * @see org.secdfd.model.Element#getAssets()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Assets();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Element#getInflows <em>Inflows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inflows</em>'.
	 * @see org.secdfd.model.Element#getInflows()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Inflows();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Element#isAttacker <em>Attacker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacker</em>'.
	 * @see org.secdfd.model.Element#isAttacker()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Attacker();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.NamedEntity <em>Named Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Entity</em>'.
	 * @see org.secdfd.model.NamedEntity
	 * @generated
	 */
	EClass getNamedEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.NamedEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.secdfd.model.NamedEntity#getName()
	 * @see #getNamedEntity()
	 * @generated
	 */
	EAttribute getNamedEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.NamedEntity#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.secdfd.model.NamedEntity#getNumber()
	 * @see #getNamedEntity()
	 * @generated
	 */
	EAttribute getNamedEntity_Number();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.secdfd.model.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Value#getObjective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Objective</em>'.
	 * @see org.secdfd.model.Value#getObjective()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Objective();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Value#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.secdfd.model.Value#getPriority()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Priority();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see org.secdfd.model.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for the attribute list '{@link org.secdfd.model.Assumption#getObjective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Objective</em>'.
	 * @see org.secdfd.model.Assumption#getObjective()
	 * @see #getAssumption()
	 * @generated
	 */
	EAttribute getAssumption_Objective();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.Assumption#getLayer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layer</em>'.
	 * @see org.secdfd.model.Assumption#getLayer()
	 * @see #getAssumption()
	 * @generated
	 */
	EAttribute getAssumption_Layer();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.AttackerProfile <em>Attacker Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker Profile</em>'.
	 * @see org.secdfd.model.AttackerProfile
	 * @generated
	 */
	EClass getAttackerProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.secdfd.model.AttackerProfile#getObservation <em>Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observation</em>'.
	 * @see org.secdfd.model.AttackerProfile#getObservation()
	 * @see #getAttackerProfile()
	 * @generated
	 */
	EAttribute getAttackerProfile_Observation();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.TrustZone <em>Trust Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trust Zone</em>'.
	 * @see org.secdfd.model.TrustZone
	 * @generated
	 */
	EClass getTrustZone();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.TrustZone#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.secdfd.model.TrustZone#getElements()
	 * @see #getTrustZone()
	 * @generated
	 */
	EReference getTrustZone_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.TrustZone#getSubzones <em>Subzones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subzones</em>'.
	 * @see org.secdfd.model.TrustZone#getSubzones()
	 * @see #getTrustZone()
	 * @generated
	 */
	EReference getTrustZone_Subzones();

	/**
	 * Returns the meta object for the containment reference list '{@link org.secdfd.model.TrustZone#getAttackerprofile <em>Attackerprofile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attackerprofile</em>'.
	 * @see org.secdfd.model.TrustZone#getAttackerprofile()
	 * @see #getTrustZone()
	 * @generated
	 */
	EReference getTrustZone_Attackerprofile();

	/**
	 * Returns the meta object for class '{@link org.secdfd.model.Responsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility</em>'.
	 * @see org.secdfd.model.Responsibility
	 * @generated
	 */
	EClass getResponsibility();

	/**
	 * Returns the meta object for the attribute list '{@link org.secdfd.model.Responsibility#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Action</em>'.
	 * @see org.secdfd.model.Responsibility#getAction()
	 * @see #getResponsibility()
	 * @generated
	 */
	EAttribute getResponsibility_Action();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Responsibility#getIncomeassets <em>Incomeassets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomeassets</em>'.
	 * @see org.secdfd.model.Responsibility#getIncomeassets()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Incomeassets();

	/**
	 * Returns the meta object for the reference list '{@link org.secdfd.model.Responsibility#getOutcomeassets <em>Outcomeassets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outcomeassets</em>'.
	 * @see org.secdfd.model.Responsibility#getOutcomeassets()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Outcomeassets();

	/**
	 * Returns the meta object for the container reference '{@link org.secdfd.model.Responsibility#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Process</em>'.
	 * @see org.secdfd.model.Responsibility#getProcess()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Process();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority</em>'.
	 * @see org.secdfd.model.Priority
	 * @generated
	 */
	EEnum getPriority();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Channel</em>'.
	 * @see org.secdfd.model.Channel
	 * @generated
	 */
	EEnum getChannel();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.ResponsibilityType <em>Responsibility Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Responsibility Type</em>'.
	 * @see org.secdfd.model.ResponsibilityType
	 * @generated
	 */
	EEnum getResponsibilityType();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objective</em>'.
	 * @see org.secdfd.model.Objective
	 * @generated
	 */
	EEnum getObjective();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Layer</em>'.
	 * @see org.secdfd.model.Layer
	 * @generated
	 */
	EEnum getLayer();

	/**
	 * Returns the meta object for enum '{@link org.secdfd.model.AssetType <em>Asset Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Asset Type</em>'.
	 * @see org.secdfd.model.AssetType
	 * @generated
	 */
	EEnum getAssetType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.secdfd.model.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.AssetImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__VALUE = eINSTANCE.getAsset_Value();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__SOURCE = eINSTANCE.getAsset_Source();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__TARGETS = eINSTANCE.getAsset_Targets();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__TYPE = eINSTANCE.getAsset_Type();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.ProcessImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Responsibility</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__RESPONSIBILITY = eINSTANCE.getProcess_Responsibility();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.EDFDImpl <em>EDFD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.EDFDImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getEDFD()
		 * @generated
		 */
		EClass EDFD = eINSTANCE.getEDFD();

		/**
		 * The meta object literal for the '<em><b>Asset</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDFD__ASSET = eINSTANCE.getEDFD_Asset();

		/**
		 * The meta object literal for the '<em><b>Trustzones</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDFD__TRUSTZONES = eINSTANCE.getEDFD_Trustzones();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDFD__ELEMENTS = eINSTANCE.getEDFD_Elements();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.DataStoreImpl <em>Data Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.DataStoreImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getDataStore()
		 * @generated
		 */
		EClass DATA_STORE = eINSTANCE.getDataStore();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.FlowImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__CHANNEL = eINSTANCE.getFlow_Channel();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__TARGET = eINSTANCE.getFlow_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__SOURCE = eINSTANCE.getFlow_Source();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__LABEL = eINSTANCE.getFlow_Label();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.ExternalEntityImpl <em>External Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.ExternalEntityImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getExternalEntity()
		 * @generated
		 */
		EClass EXTERNAL_ENTITY = eINSTANCE.getExternalEntity();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.ElementImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Outflows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OUTFLOWS = eINSTANCE.getElement_Outflows();

		/**
		 * The meta object literal for the '<em><b>Assumption</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ASSUMPTION = eINSTANCE.getElement_Assumption();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ASSETS = eINSTANCE.getElement_Assets();

		/**
		 * The meta object literal for the '<em><b>Inflows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__INFLOWS = eINSTANCE.getElement_Inflows();

		/**
		 * The meta object literal for the '<em><b>Attacker</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ATTACKER = eINSTANCE.getElement_Attacker();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.NamedEntity <em>Named Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.NamedEntity
		 * @see org.secdfd.model.impl.ModelPackageImpl#getNamedEntity()
		 * @generated
		 */
		EClass NAMED_ENTITY = eINSTANCE.getNamedEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ENTITY__NAME = eINSTANCE.getNamedEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ENTITY__NUMBER = eINSTANCE.getNamedEntity_Number();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.ValueImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Objective</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__OBJECTIVE = eINSTANCE.getValue_Objective();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__PRIORITY = eINSTANCE.getValue_Priority();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.AssumptionImpl <em>Assumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.AssumptionImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getAssumption()
		 * @generated
		 */
		EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '<em><b>Objective</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSUMPTION__OBJECTIVE = eINSTANCE.getAssumption_Objective();

		/**
		 * The meta object literal for the '<em><b>Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSUMPTION__LAYER = eINSTANCE.getAssumption_Layer();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.AttackerProfileImpl <em>Attacker Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.AttackerProfileImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getAttackerProfile()
		 * @generated
		 */
		EClass ATTACKER_PROFILE = eINSTANCE.getAttackerProfile();

		/**
		 * The meta object literal for the '<em><b>Observation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_PROFILE__OBSERVATION = eINSTANCE.getAttackerProfile_Observation();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.TrustZoneImpl <em>Trust Zone</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.TrustZoneImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getTrustZone()
		 * @generated
		 */
		EClass TRUST_ZONE = eINSTANCE.getTrustZone();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUST_ZONE__ELEMENTS = eINSTANCE.getTrustZone_Elements();

		/**
		 * The meta object literal for the '<em><b>Subzones</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUST_ZONE__SUBZONES = eINSTANCE.getTrustZone_Subzones();

		/**
		 * The meta object literal for the '<em><b>Attackerprofile</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUST_ZONE__ATTACKERPROFILE = eINSTANCE.getTrustZone_Attackerprofile();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.impl.ResponsibilityImpl
		 * @see org.secdfd.model.impl.ModelPackageImpl#getResponsibility()
		 * @generated
		 */
		EClass RESPONSIBILITY = eINSTANCE.getResponsibility();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSIBILITY__ACTION = eINSTANCE.getResponsibility_Action();

		/**
		 * The meta object literal for the '<em><b>Incomeassets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__INCOMEASSETS = eINSTANCE.getResponsibility_Incomeassets();

		/**
		 * The meta object literal for the '<em><b>Outcomeassets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__OUTCOMEASSETS = eINSTANCE.getResponsibility_Outcomeassets();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__PROCESS = eINSTANCE.getResponsibility_Process();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.Priority <em>Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.Priority
		 * @see org.secdfd.model.impl.ModelPackageImpl#getPriority()
		 * @generated
		 */
		EEnum PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.Channel <em>Channel</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.Channel
		 * @see org.secdfd.model.impl.ModelPackageImpl#getChannel()
		 * @generated
		 */
		EEnum CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.ResponsibilityType <em>Responsibility Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.ResponsibilityType
		 * @see org.secdfd.model.impl.ModelPackageImpl#getResponsibilityType()
		 * @generated
		 */
		EEnum RESPONSIBILITY_TYPE = eINSTANCE.getResponsibilityType();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.Objective <em>Objective</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.Objective
		 * @see org.secdfd.model.impl.ModelPackageImpl#getObjective()
		 * @generated
		 */
		EEnum OBJECTIVE = eINSTANCE.getObjective();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.Layer <em>Layer</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.Layer
		 * @see org.secdfd.model.impl.ModelPackageImpl#getLayer()
		 * @generated
		 */
		EEnum LAYER = eINSTANCE.getLayer();

		/**
		 * The meta object literal for the '{@link org.secdfd.model.AssetType <em>Asset Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.secdfd.model.AssetType
		 * @see org.secdfd.model.impl.ModelPackageImpl#getAssetType()
		 * @generated
		 */
		EEnum ASSET_TYPE = eINSTANCE.getAssetType();

	}

} //ModelPackage
