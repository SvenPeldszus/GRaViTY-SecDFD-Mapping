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

import eDFDFlowTracking.EDFDFlowTrackingPackage;

import graph.GraphPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gravity.mapping.secdfd.Defintion2Node;
import org.gravity.mapping.secdfd.Method2Node;

import org.gravity.mapping.secdfd.Rules.RulesPackage;

import org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl;

import org.gravity.mapping.secdfd.SecdfdFactory;
import org.gravity.mapping.secdfd.SecdfdPackage;
import org.gravity.mapping.secdfd.Type2GraphAsset;
import org.gravity.mapping.secdfd.TypeGraph2Graph;

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
	private EClass type2GraphAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass method2NodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeGraph2GraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defintion2NodeEClass = null;

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
		LanguagePackage.eINSTANCE.eClass();
		RuntimePackage.eINSTANCE.eClass();
		EDFDFlowTrackingPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		RulesPackageImpl theRulesPackage = (RulesPackageImpl)(registeredPackage instanceof RulesPackageImpl ? registeredPackage : RulesPackage.eINSTANCE);

		// Create package meta-data objects
		theSecdfdPackage.createPackageContents();
		theRulesPackage.createPackageContents();

		// Initialize created meta-data
		theSecdfdPackage.initializePackageContents();
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
	public EClass getType2GraphAsset() {
		return type2GraphAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType2GraphAsset_Source() {
		return (EReference)type2GraphAssetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType2GraphAsset_Target() {
		return (EReference)type2GraphAssetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod2Node() {
		return method2NodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod2Node_Source() {
		return (EReference)method2NodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod2Node_Target() {
		return (EReference)method2NodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeGraph2Graph() {
		return typeGraph2GraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeGraph2Graph_Source() {
		return (EReference)typeGraph2GraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeGraph2Graph_Target() {
		return (EReference)typeGraph2GraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefintion2Node() {
		return defintion2NodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefintion2Node_Source() {
		return (EReference)defintion2NodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefintion2Node_Target() {
		return (EReference)defintion2NodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		type2GraphAssetEClass = createEClass(TYPE2_GRAPH_ASSET);
		createEReference(type2GraphAssetEClass, TYPE2_GRAPH_ASSET__SOURCE);
		createEReference(type2GraphAssetEClass, TYPE2_GRAPH_ASSET__TARGET);

		method2NodeEClass = createEClass(METHOD2_NODE);
		createEReference(method2NodeEClass, METHOD2_NODE__SOURCE);
		createEReference(method2NodeEClass, METHOD2_NODE__TARGET);

		typeGraph2GraphEClass = createEClass(TYPE_GRAPH2_GRAPH);
		createEReference(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH__SOURCE);
		createEReference(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH__TARGET);

		defintion2NodeEClass = createEClass(DEFINTION2_NODE);
		createEReference(defintion2NodeEClass, DEFINTION2_NODE__SOURCE);
		createEReference(defintion2NodeEClass, DEFINTION2_NODE__TARGET);
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
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRulesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		type2GraphAssetEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		method2NodeEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		typeGraph2GraphEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());
		defintion2NodeEClass.getESuperTypes().add(theRuntimePackage.getAbstractCorrespondence());

		// Initialize classes, features, and operations; add parameters
		initEClass(type2GraphAssetEClass, Type2GraphAsset.class, "Type2GraphAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType2GraphAsset_Source(), theBasicPackage.getTAbstractType(), null, "source", null, 1, 1, Type2GraphAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getType2GraphAsset_Target(), theGraphPackage.getGraphAsset(), null, "target", null, 1, 1, Type2GraphAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(method2NodeEClass, Method2Node.class, "Method2Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethod2Node_Source(), theBasicPackage.getTMethod(), null, "source", null, 1, 1, Method2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod2Node_Target(), theGraphPackage.getNode(), null, "target", null, 1, 1, Method2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeGraph2GraphEClass, TypeGraph2Graph.class, "TypeGraph2Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeGraph2Graph_Source(), theBasicPackage.getTypeGraph(), null, "source", null, 1, 1, TypeGraph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeGraph2Graph_Target(), theGraphPackage.getGraph(), null, "target", null, 1, 1, TypeGraph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defintion2NodeEClass, Defintion2Node.class, "Defintion2Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefintion2Node_Source(), theBasicPackage.getTMethodDefinition(), null, "source", null, 1, 1, Defintion2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefintion2Node_Target(), theGraphPackage.getNode(), null, "target", null, 1, 1, Defintion2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SecdfdPackageImpl
