/**
 */
package org.gravity.mapping.secdfd.Rules.impl;

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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gravity.mapping.secdfd.Rules.RulesFactory;
import org.gravity.mapping.secdfd.Rules.RulesPackage;
import org.gravity.mapping.secdfd.Rules.TypeGraph2Graph;

import org.gravity.mapping.secdfd.SecdfdPackage;

import org.gravity.mapping.secdfd.impl.SecdfdPackageImpl;

import org.gravity.typegraph.basic.BasicPackage;

import org.moflon.tgg.language.LanguagePackage;

import org.moflon.tgg.language.csp.CspPackage;

import org.moflon.tgg.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RulesPackageImpl extends EPackageImpl implements RulesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeGraph2GraphEClass = null;

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
	 * @see org.gravity.mapping.secdfd.Rules.RulesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RulesPackageImpl() {
		super(eNS_URI, RulesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RulesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RulesPackage init() {
		if (isInited) return (RulesPackage)EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRulesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RulesPackageImpl theRulesPackage = registeredRulesPackage instanceof RulesPackageImpl ? (RulesPackageImpl)registeredRulesPackage : new RulesPackageImpl();

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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SecdfdPackage.eNS_URI);
		SecdfdPackageImpl theSecdfdPackage = (SecdfdPackageImpl)(registeredPackage instanceof SecdfdPackageImpl ? registeredPackage : SecdfdPackage.eINSTANCE);

		// Create package meta-data objects
		theRulesPackage.createPackageContents();
		theSecdfdPackage.createPackageContents();

		// Initialize created meta-data
		theRulesPackage.initializePackageContents();
		theSecdfdPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRulesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RulesPackage.eNS_URI, theRulesPackage);
		return theRulesPackage;
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
	public EOperation getTypeGraph2Graph__IsAppropriate_FWD__Match_TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__Perform_FWD__IsApplicableMatch() {
		return typeGraph2GraphEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_FWD__Match() {
		return typeGraph2GraphEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__RegisterObjectsToMatch_FWD__Match_TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_solveCsp_FWD__Match_TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_checkCsp_FWD__CSP() {
		return typeGraph2GraphEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_solveCsp_FWD__IsApplicableMatch_TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_checkCsp_FWD__CSP() {
		return typeGraph2GraphEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__RegisterObjects_FWD__PerformRuleResult_EObject_EObject_EObject() {
		return typeGraph2GraphEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckTypes_FWD__Match() {
		return typeGraph2GraphEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_BWD__Match_Graph() {
		return typeGraph2GraphEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__Perform_BWD__IsApplicableMatch() {
		return typeGraph2GraphEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_BWD__Match() {
		return typeGraph2GraphEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__RegisterObjectsToMatch_BWD__Match_Graph() {
		return typeGraph2GraphEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_solveCsp_BWD__Match_Graph() {
		return typeGraph2GraphEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_checkCsp_BWD__CSP() {
		return typeGraph2GraphEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_solveCsp_BWD__IsApplicableMatch_Graph() {
		return typeGraph2GraphEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_checkCsp_BWD__CSP() {
		return typeGraph2GraphEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__RegisterObjects_BWD__PerformRuleResult_EObject_EObject_EObject() {
		return typeGraph2GraphEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckTypes_BWD__Match() {
		return typeGraph2GraphEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_BWD_Graph_1__Graph() {
		return typeGraph2GraphEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsAppropriate_FWD_TypeGraph_1__TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckAttributes_FWD__TripleMatch() {
		return typeGraph2GraphEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckAttributes_BWD__TripleMatch() {
		return typeGraph2GraphEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_CC__Match_Match() {
		return typeGraph2GraphEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_solveCsp_CC__Graph_TypeGraph_Match_Match() {
		return typeGraph2GraphEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__IsApplicable_checkCsp_CC__CSP() {
		return typeGraph2GraphEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckDEC_FWD__TypeGraph() {
		return typeGraph2GraphEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypeGraph2Graph__CheckDEC_BWD__Graph() {
		return typeGraph2GraphEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulesFactory getRulesFactory() {
		return (RulesFactory)getEFactoryInstance();
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
		typeGraph2GraphEClass = createEClass(TYPE_GRAPH2_GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_FWD__MATCH_TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___PERFORM_FWD__ISAPPLICABLEMATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_FWD__MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___REGISTER_OBJECTS_TO_MATCH_FWD__MATCH_TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_SOLVE_CSP_FWD__MATCH_TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_CHECK_CSP_FWD__CSP);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_SOLVE_CSP_FWD__ISAPPLICABLEMATCH_TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_CHECK_CSP_FWD__CSP);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___REGISTER_OBJECTS_FWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_TYPES_FWD__MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_BWD__MATCH_GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___PERFORM_BWD__ISAPPLICABLEMATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_BWD__MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___REGISTER_OBJECTS_TO_MATCH_BWD__MATCH_GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_SOLVE_CSP_BWD__MATCH_GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_CHECK_CSP_BWD__CSP);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_SOLVE_CSP_BWD__ISAPPLICABLEMATCH_GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_CHECK_CSP_BWD__CSP);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___REGISTER_OBJECTS_BWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_TYPES_BWD__MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_BWD_GRAPH_1__GRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPROPRIATE_FWD_TYPE_GRAPH_1__TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_ATTRIBUTES_FWD__TRIPLEMATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_ATTRIBUTES_BWD__TRIPLEMATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_CC__MATCH_MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_SOLVE_CSP_CC__GRAPH_TYPEGRAPH_MATCH_MATCH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___IS_APPLICABLE_CHECK_CSP_CC__CSP);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_DEC_FWD__TYPEGRAPH);
		createEOperation(typeGraph2GraphEClass, TYPE_GRAPH2_GRAPH___CHECK_DEC_BWD__GRAPH);
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
		BasicPackage theBasicPackage = (BasicPackage)EPackage.Registry.INSTANCE.getEPackage(BasicPackage.eNS_URI);
		CspPackage theCspPackage = (CspPackage)EPackage.Registry.INSTANCE.getEPackage(CspPackage.eNS_URI);
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		typeGraph2GraphEClass.getESuperTypes().add(theRuntimePackage.getAbstractRule());

		// Initialize classes, features, and operations; add parameters
		initEClass(typeGraph2GraphEClass, TypeGraph2Graph.class, "TypeGraph2Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getTypeGraph2Graph__IsAppropriate_FWD__Match_TypeGraph(), ecorePackage.getEBoolean(), "isAppropriate_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__Perform_FWD__IsApplicableMatch(), theRuntimePackage.getPerformRuleResult(), "perform_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getIsApplicableMatch(), "isApplicableMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_FWD__Match(), theRuntimePackage.getIsApplicableRuleResult(), "isApplicable_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__RegisterObjectsToMatch_FWD__Match_TypeGraph(), null, "registerObjectsToMatch_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_solveCsp_FWD__Match_TypeGraph(), theCspPackage.getCSP(), "isAppropriate_solveCsp_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_checkCsp_FWD__CSP(), ecorePackage.getEBoolean(), "isAppropriate_checkCsp_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCspPackage.getCSP(), "csp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_solveCsp_FWD__IsApplicableMatch_TypeGraph(), theCspPackage.getCSP(), "isApplicable_solveCsp_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getIsApplicableMatch(), "isApplicableMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_checkCsp_FWD__CSP(), ecorePackage.getEBoolean(), "isApplicable_checkCsp_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCspPackage.getCSP(), "csp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__RegisterObjects_FWD__PerformRuleResult_EObject_EObject_EObject(), null, "registerObjects_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getPerformRuleResult(), "ruleresult", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pm2Graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckTypes_FWD__Match(), ecorePackage.getEBoolean(), "checkTypes_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_BWD__Match_Graph(), ecorePackage.getEBoolean(), "isAppropriate_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__Perform_BWD__IsApplicableMatch(), theRuntimePackage.getPerformRuleResult(), "perform_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getIsApplicableMatch(), "isApplicableMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_BWD__Match(), theRuntimePackage.getIsApplicableRuleResult(), "isApplicable_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__RegisterObjectsToMatch_BWD__Match_Graph(), null, "registerObjectsToMatch_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_solveCsp_BWD__Match_Graph(), theCspPackage.getCSP(), "isAppropriate_solveCsp_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_checkCsp_BWD__CSP(), ecorePackage.getEBoolean(), "isAppropriate_checkCsp_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCspPackage.getCSP(), "csp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_solveCsp_BWD__IsApplicableMatch_Graph(), theCspPackage.getCSP(), "isApplicable_solveCsp_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getIsApplicableMatch(), "isApplicableMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_checkCsp_BWD__CSP(), ecorePackage.getEBoolean(), "isApplicable_checkCsp_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCspPackage.getCSP(), "csp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__RegisterObjects_BWD__PerformRuleResult_EObject_EObject_EObject(), null, "registerObjects_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getPerformRuleResult(), "ruleresult", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pm2Graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckTypes_BWD__Match(), ecorePackage.getEBoolean(), "checkTypes_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_BWD_Graph_1__Graph(), theRuntimePackage.getEObjectContainer(), "isAppropriate_BWD_Graph_1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsAppropriate_FWD_TypeGraph_1__TypeGraph(), theRuntimePackage.getEObjectContainer(), "isAppropriate_FWD_TypeGraph_1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckAttributes_FWD__TripleMatch(), theRuntimePackage.getAttributeConstraintsRuleResult(), "checkAttributes_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getTripleMatch(), "__tripleMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckAttributes_BWD__TripleMatch(), theRuntimePackage.getAttributeConstraintsRuleResult(), "checkAttributes_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getTripleMatch(), "__tripleMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_CC__Match_Match(), theRuntimePackage.getIsApplicableRuleResult(), "isApplicable_CC", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "sourceMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "targetMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_solveCsp_CC__Graph_TypeGraph_Match_Match(), theCspPackage.getCSP(), "isApplicable_solveCsp_CC", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "sourceMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRuntimePackage.getMatch(), "targetMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__IsApplicable_checkCsp_CC__CSP(), ecorePackage.getEBoolean(), "isApplicable_checkCsp_CC", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCspPackage.getCSP(), "csp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckDEC_FWD__TypeGraph(), ecorePackage.getEBoolean(), "checkDEC_FWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBasicPackage.getTypeGraph(), "pm", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTypeGraph2Graph__CheckDEC_BWD__Graph(), ecorePackage.getEBoolean(), "checkDEC_BWD", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGraphPackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);
	}

} //RulesPackageImpl
