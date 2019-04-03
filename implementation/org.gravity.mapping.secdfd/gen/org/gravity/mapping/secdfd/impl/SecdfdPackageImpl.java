/**
 */
package org.gravity.mapping.secdfd.impl;

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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gravity.mapping.secdfd.Defintion2Element;
import org.gravity.mapping.secdfd.Flow2Access;
import org.gravity.mapping.secdfd.Method2Element;

import org.gravity.mapping.secdfd.Rules.RulesPackage;

import org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl;

import org.gravity.mapping.secdfd.SecdfdFactory;
import org.gravity.mapping.secdfd.SecdfdPackage;
import org.gravity.mapping.secdfd.Signature2Element;
import org.gravity.mapping.secdfd.Type2NamedEntity;
import org.gravity.mapping.secdfd.TypeGraph2EDFD;

import org.gravity.typegraph.basic.BasicPackage;

import org.moflon.tgg.language.LanguagePackage;

import org.moflon.tgg.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecdfdPackageImpl extends EPackageImpl implements SecdfdPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass method2ElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass type2NamedEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signature2ElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeGraph2EDFDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defintion2ElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flow2AccessEClass = null;

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
	 * @see org.gravity.mapping.secdfd.SecdfdPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SecdfdPackageImpl() {
		super(eNS_URI, SecdfdFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SecdfdPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SecdfdPackage init() {
		if (isInited) return (SecdfdPackage)EPackage.Registry.INSTANCE.getEPackage(SecdfdPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSecdfdPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SecdfdPackageImpl theSecdfdPackage = registeredSecdfdPackage instanceof SecdfdPackageImpl ? (SecdfdPackageImpl)registeredSecdfdPackage : new SecdfdPackageImpl();

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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(org.gravity.mapping.secdfd.model.mapping.MappingPackage.eNS_URI);
		org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl theMappingPackage = (org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl)(registeredPackage instanceof org.gravity.mapping.secdfd.model.mapping.impl.MappingPackageImpl ? registeredPackage : org.gravity.mapping.secdfd.model.mapping.MappingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		RulesPackageImpl theRulesPackage = (RulesPackageImpl)(registeredPackage instanceof RulesPackageImpl ? registeredPackage : RulesPackage.eINSTANCE);

		// Create package meta-data objects
		theSecdfdPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theRulesPackage.createPackageContents();

		// Initialize created meta-data
		theSecdfdPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theRulesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSecdfdPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SecdfdPackage.eNS_URI, theSecdfdPackage);
		return theSecdfdPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMethod2Element() {
		return method2ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethod2Element_Source() {
		return (EReference)method2ElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethod2Element_Target() {
		return (EReference)method2ElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType2NamedEntity() {
		return type2NamedEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getType2NamedEntity_Source() {
		return (EReference)type2NamedEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getType2NamedEntity_Target() {
		return (EReference)type2NamedEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSignature2Element() {
		return signature2ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSignature2Element_Source() {
		return (EReference)signature2ElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSignature2Element_Target() {
		return (EReference)signature2ElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeGraph2EDFD() {
		return typeGraph2EDFDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeGraph2EDFD_Source() {
		return (EReference)typeGraph2EDFDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeGraph2EDFD_Target() {
		return (EReference)typeGraph2EDFDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefintion2Element() {
		return defintion2ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefintion2Element_Source() {
		return (EReference)defintion2ElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefintion2Element_Target() {
		return (EReference)defintion2ElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFlow2Access() {
		return flow2AccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFlow2Access_Source() {
		return (EReference)flow2AccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFlow2Access_Target() {
		return (EReference)flow2AccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecdfdFactory getSecdfdFactory() {
		return (SecdfdFactory)getEFactoryInstance();
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
		method2ElementEClass = createEClass(METHOD2_ELEMENT);
		createEReference(method2ElementEClass, METHOD2_ELEMENT__SOURCE);
		createEReference(method2ElementEClass, METHOD2_ELEMENT__TARGET);

		type2NamedEntityEClass = createEClass(TYPE2_NAMED_ENTITY);
		createEReference(type2NamedEntityEClass, TYPE2_NAMED_ENTITY__SOURCE);
		createEReference(type2NamedEntityEClass, TYPE2_NAMED_ENTITY__TARGET);

		typeGraph2EDFDEClass = createEClass(TYPE_GRAPH2_EDFD);
		createEReference(typeGraph2EDFDEClass, TYPE_GRAPH2_EDFD__SOURCE);
		createEReference(typeGraph2EDFDEClass, TYPE_GRAPH2_EDFD__TARGET);

		defintion2ElementEClass = createEClass(DEFINTION2_ELEMENT);
		createEReference(defintion2ElementEClass, DEFINTION2_ELEMENT__SOURCE);
		createEReference(defintion2ElementEClass, DEFINTION2_ELEMENT__TARGET);

		flow2AccessEClass = createEClass(FLOW2_ACCESS);
		createEReference(flow2AccessEClass, FLOW2_ACCESS__SOURCE);
		createEReference(flow2AccessEClass, FLOW2_ACCESS__TARGET);

		signature2ElementEClass = createEClass(SIGNATURE2_ELEMENT);
		createEReference(signature2ElementEClass, SIGNATURE2_ELEMENT__SOURCE);
		createEReference(signature2ElementEClass, SIGNATURE2_ELEMENT__TARGET);
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
		RulesPackage theRulesPackage = (RulesPackage)EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		RuntimePackage theRuntimePackage = (RuntimePackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI);
		BasicPackage theBasicPackage = (BasicPackage)EPackage.Registry.INSTANCE.getEPackage(BasicPackage.eNS_URI);
		EDFDFlowTracking1Package theEDFDFlowTracking1Package = (EDFDFlowTracking1Package)EPackage.Registry.INSTANCE.getEPackage(EDFDFlowTracking1Package.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRulesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		method2ElementEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		type2NamedEntityEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		typeGraph2EDFDEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		defintion2ElementEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		flow2AccessEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		signature2ElementEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());

		// Initialize classes, features, and operations; add parameters
		initEClass(method2ElementEClass, Method2Element.class, "Method2Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethod2Element_Source(), theBasicPackage.getTMethod(), null, "source", null, 1, 1, Method2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod2Element_Target(), theEDFDFlowTracking1Package.getElement(), null, "target", null, 1, 1, Method2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(type2NamedEntityEClass, Type2NamedEntity.class, "Type2NamedEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType2NamedEntity_Source(), theBasicPackage.getTAbstractType(), null, "source", null, 1, 1, Type2NamedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getType2NamedEntity_Target(), theEDFDFlowTracking1Package.getNamedEntity(), null, "target", null, 1, 1, Type2NamedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeGraph2EDFDEClass, TypeGraph2EDFD.class, "TypeGraph2EDFD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeGraph2EDFD_Source(), theBasicPackage.getTypeGraph(), null, "source", null, 1, 1, TypeGraph2EDFD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeGraph2EDFD_Target(), theEDFDFlowTracking1Package.getEDFD(), null, "target", null, 1, 1, TypeGraph2EDFD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defintion2ElementEClass, Defintion2Element.class, "Defintion2Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefintion2Element_Source(), theBasicPackage.getTMember(), null, "source", null, 1, 1, Defintion2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefintion2Element_Target(), theEDFDFlowTracking1Package.getElement(), null, "target", null, 1, 1, Defintion2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flow2AccessEClass, Flow2Access.class, "Flow2Access", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlow2Access_Source(), theBasicPackage.getTAccess(), null, "source", null, 1, 1, Flow2Access.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlow2Access_Target(), theEDFDFlowTracking1Package.getFlow(), null, "target", null, 1, 1, Flow2Access.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signature2ElementEClass, Signature2Element.class, "Signature2Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSignature2Element_Source(), theBasicPackage.getTSignature(), null, "source", null, 1, 1, Signature2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSignature2Element_Target(), theEDFDFlowTracking1Package.getElement(), null, "target", null, 1, 1, Signature2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SecdfdPackageImpl
