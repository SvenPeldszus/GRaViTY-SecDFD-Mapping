/**
 */
package org.gravity.mapping.secdfd.model.mapping.impl;

import MocaTree.MocaTreePackage;

import SDMLanguage.SDMLanguagePackage;

import SDMLanguage.activities.ActivitiesPackage;

import SDMLanguage.calls.CallsPackage;

import SDMLanguage.calls.callExpressions.CallExpressionsPackage;

import SDMLanguage.expressions.ExpressionsPackage;

import SDMLanguage.patterns.AttributeConstraints.AttributeConstraintsPackage;

import SDMLanguage.patterns.PatternsPackage;

import SDMLanguage.patterns.patternExpressions.PatternExpressionsPackage;

import SDMLanguage.sdmUtil.SdmUtilPackage;

import eDFDFlowTracking.EDFDFlowTracking1Package;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gravity.mapping.secdfd.Rules.RulesPackage;

import org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl;

import org.gravity.mapping.secdfd.SecdfdPackage;

import org.gravity.mapping.secdfd.impl.SecdfdPackageImpl;

import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingPackage;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;

import org.gravity.mapping.secdfd.model.mapping.MappingRanking;
import org.gravity.typegraph.basic.BasicPackage;

import org.moflon.tgg.language.LanguagePackage;

import org.moflon.tgg.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMappingDerivedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingProcessNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingProcessSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingProcessDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRankingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEntityTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gravity.mapping.secdfd.model.mapping.MappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MappingPackageImpl() {
		super(eNS_URI, MappingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MappingPackage init() {
		if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMappingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MappingPackageImpl theMappingPackage = registeredMappingPackage instanceof MappingPackageImpl ? (MappingPackageImpl)registeredMappingPackage : new MappingPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicPackage.eINSTANCE.eClass();
		EDFDFlowTracking1Package.eINSTANCE.eClass();
		LanguagePackage.eINSTANCE.eClass();
		RuntimePackage.eINSTANCE.eClass();
		PatternsPackage.eINSTANCE.eClass();
		SDMLanguagePackage.eINSTANCE.eClass();
		ActivitiesPackage.eINSTANCE.eClass();
		MocaTreePackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		CallExpressionsPackage.eINSTANCE.eClass();
		SdmUtilPackage.eINSTANCE.eClass();
		AttributeConstraintsPackage.eINSTANCE.eClass();
		PatternExpressionsPackage.eINSTANCE.eClass();
		CallsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SecdfdPackage.eNS_URI);
		SecdfdPackageImpl theSecdfdPackage = (SecdfdPackageImpl)(registeredPackage instanceof SecdfdPackageImpl ? registeredPackage : SecdfdPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		RulesPackageImpl theRulesPackage = (RulesPackageImpl)(registeredPackage instanceof RulesPackageImpl ? registeredPackage : RulesPackage.eINSTANCE);

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		theSecdfdPackage.createPackageContents();
		theRulesPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		theSecdfdPackage.initializePackageContents();
		theRulesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMappingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
		return theMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Userdefined() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Ignored() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Suggested() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Accepted() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractMappingDerived() {
		return abstractMappingDerivedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractMappingDerived_Derived() {
		return (EReference)abstractMappingDerivedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingProcessName() {
		return mappingProcessNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingProcessSignature() {
		return mappingProcessSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingProcessDefinition() {
		return mappingProcessDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRanking() {
		return mappingRankingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRanking_Ranking() {
		return (EAttribute)mappingRankingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingEntityType() {
		return mappingEntityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingFactory getMappingFactory() {
		return (MappingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__USERDEFINED);
		createEReference(mappingEClass, MAPPING__IGNORED);
		createEReference(mappingEClass, MAPPING__SUGGESTED);
		createEReference(mappingEClass, MAPPING__ACCEPTED);

		abstractMappingDerivedEClass = createEClass(ABSTRACT_MAPPING_DERIVED);
		createEReference(abstractMappingDerivedEClass, ABSTRACT_MAPPING_DERIVED__DERIVED);

		mappingProcessNameEClass = createEClass(MAPPING_PROCESS_NAME);

		mappingProcessSignatureEClass = createEClass(MAPPING_PROCESS_SIGNATURE);

		mappingProcessDefinitionEClass = createEClass(MAPPING_PROCESS_DEFINITION);

		mappingRankingEClass = createEClass(MAPPING_RANKING);
		createEAttribute(mappingRankingEClass, MAPPING_RANKING__RANKING);

		mappingEntityTypeEClass = createEClass(MAPPING_ENTITY_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RuntimePackage theRuntimePackage = (RuntimePackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI);
		SecdfdPackage theSecdfdPackage = (SecdfdPackage)EPackage.Registry.INSTANCE.getEPackage(SecdfdPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingEClass.getESuperTypes().add(theRuntimePackage.getCorrespondenceModel());
		abstractMappingDerivedEClass.getESuperTypes().add(this.getMappingRanking());
		mappingProcessNameEClass.getESuperTypes().add(theSecdfdPackage.getMethod2Element());
		mappingProcessNameEClass.getESuperTypes().add(this.getAbstractMappingDerived());
		mappingProcessNameEClass.getESuperTypes().add(this.getMappingRanking());
		mappingProcessSignatureEClass.getESuperTypes().add(theSecdfdPackage.getSignature2Element());
		mappingProcessSignatureEClass.getESuperTypes().add(this.getMappingRanking());
		mappingProcessDefinitionEClass.getESuperTypes().add(theSecdfdPackage.getDefintion2Element());
		mappingProcessDefinitionEClass.getESuperTypes().add(this.getAbstractMappingDerived());
		mappingProcessDefinitionEClass.getESuperTypes().add(this.getMappingRanking());
		mappingEntityTypeEClass.getESuperTypes().add(theSecdfdPackage.getType2NamedEntity());
		mappingEntityTypeEClass.getESuperTypes().add(this.getMappingRanking());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Userdefined(), theRuntimePackage.getAbstractCorrespondence(), null, "userdefined", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Ignored(), theRuntimePackage.getAbstractCorrespondence(), null, "ignored", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Suggested(), theRuntimePackage.getAbstractCorrespondence(), null, "suggested", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Accepted(), theRuntimePackage.getAbstractCorrespondence(), null, "accepted", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMappingDerivedEClass, AbstractMappingDerived.class, "AbstractMappingDerived", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMappingDerived_Derived(), theRuntimePackage.getAbstractCorrespondence(), null, "derived", null, 0, -1, AbstractMappingDerived.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingProcessNameEClass, MappingProcessName.class, "MappingProcessName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingProcessSignatureEClass, MappingProcessSignature.class, "MappingProcessSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingProcessDefinitionEClass, MappingProcessDefinition.class, "MappingProcessDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingRankingEClass, MappingRanking.class, "MappingRanking", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingRanking_Ranking(), ecorePackage.getEInt(), "Ranking", null, 0, 1, MappingRanking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEntityTypeEClass, MappingEntityType.class, "MappingEntityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MappingPackageImpl
