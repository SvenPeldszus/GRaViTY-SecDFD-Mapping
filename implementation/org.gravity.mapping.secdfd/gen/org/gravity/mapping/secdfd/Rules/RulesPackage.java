/**
 */
package org.gravity.mapping.secdfd.Rules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.gravity.mapping.secdfd.Rules.RulesFactory
 * @model kind="package"
 * @generated
 */
public interface RulesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Rules";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/org.gravity.mapping.secdfd/model/Secdfd.ecore#//Rules";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Rules";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RulesPackage eINSTANCE = org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.Rules.impl.TypeGraph2EDFDImpl <em>Type Graph2 EDFD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.Rules.impl.TypeGraph2EDFDImpl
	 * @see org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl#getTypeGraph2EDFD()
	 * @generated
	 */
	int TYPE_GRAPH2_EDFD = 0;

	/**
	 * The number of structural features of the '<em>Type Graph2 EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD_FEATURE_COUNT = RuntimePackage.ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Appropriate FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_FWD__MATCH_TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Perform FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___PERFORM_FWD__ISAPPLICABLEMATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Applicable FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_FWD__MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Register Objects To Match FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_TO_MATCH_FWD__MATCH_TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Appropriate solve Csp FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_SOLVE_CSP_FWD__MATCH_TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Appropriate check Csp FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_CHECK_CSP_FWD__CSP = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Applicable solve Csp FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_FWD__ISAPPLICABLEMATCH_TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Applicable check Csp FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_FWD__CSP = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Register Objects FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_FWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Check Types FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_TYPES_FWD__MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Appropriate BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_BWD__MATCH_EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Perform BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___PERFORM_BWD__ISAPPLICABLEMATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Applicable BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_BWD__MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Register Objects To Match BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_TO_MATCH_BWD__MATCH_EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Appropriate solve Csp BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_SOLVE_CSP_BWD__MATCH_EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Appropriate check Csp BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_CHECK_CSP_BWD__CSP = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Applicable solve Csp BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_BWD__ISAPPLICABLEMATCH_EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Applicable check Csp BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_BWD__CSP = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Register Objects BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_BWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Check Types BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_TYPES_BWD__MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Appropriate BWD EDFD 2</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_BWD_EDFD_2__EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is Appropriate FWD Type Graph 2</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPROPRIATE_FWD_TYPE_GRAPH_2__TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Check Attributes FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_ATTRIBUTES_FWD__TRIPLEMATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Check Attributes BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_ATTRIBUTES_BWD__TRIPLEMATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Is Applicable CC</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_CC__MATCH_MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Is Applicable solve Csp CC</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_CC__EDFD_TYPEGRAPH_MATCH_MATCH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Is Applicable check Csp CC</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_CC__CSP = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Check DEC FWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_DEC_FWD__TYPEGRAPH = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Check DEC BWD</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD___CHECK_DEC_BWD__EDFD = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 28;

	/**
	 * The number of operations of the '<em>Type Graph2 EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD_OPERATION_COUNT = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 29;


	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD <em>Type Graph2 EDFD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Graph2 EDFD</em>'.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD
	 * @generated
	 */
	EClass getTypeGraph2EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph) <em>Is Appropriate FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_FWD__Match_TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#perform_FWD(org.moflon.tgg.runtime.IsApplicableMatch) <em>Perform FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Perform FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#perform_FWD(org.moflon.tgg.runtime.IsApplicableMatch)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__Perform_FWD__IsApplicableMatch();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_FWD(org.moflon.tgg.runtime.Match) <em>Is Applicable FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_FWD(org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_FWD__Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjectsToMatch_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph) <em>Register Objects To Match FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register Objects To Match FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjectsToMatch_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__RegisterObjectsToMatch_FWD__Match_TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_solveCsp_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph) <em>Is Appropriate solve Csp FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate solve Csp FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_solveCsp_FWD(org.moflon.tgg.runtime.Match, org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_solveCsp_FWD__Match_TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_checkCsp_FWD(org.moflon.tgg.language.csp.CSP) <em>Is Appropriate check Csp FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate check Csp FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_checkCsp_FWD(org.moflon.tgg.language.csp.CSP)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_checkCsp_FWD__CSP();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_FWD(org.moflon.tgg.runtime.IsApplicableMatch, org.gravity.typegraph.basic.TypeGraph) <em>Is Applicable solve Csp FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable solve Csp FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_FWD(org.moflon.tgg.runtime.IsApplicableMatch, org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_solveCsp_FWD__IsApplicableMatch_TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_FWD(org.moflon.tgg.language.csp.CSP) <em>Is Applicable check Csp FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable check Csp FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_FWD(org.moflon.tgg.language.csp.CSP)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_checkCsp_FWD__CSP();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjects_FWD(org.moflon.tgg.runtime.PerformRuleResult, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject) <em>Register Objects FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register Objects FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjects_FWD(org.moflon.tgg.runtime.PerformRuleResult, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__RegisterObjects_FWD__PerformRuleResult_EObject_EObject_EObject();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkTypes_FWD(org.moflon.tgg.runtime.Match) <em>Check Types FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Types FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkTypes_FWD(org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckTypes_FWD__Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD) <em>Is Appropriate BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_BWD__Match_EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#perform_BWD(org.moflon.tgg.runtime.IsApplicableMatch) <em>Perform BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Perform BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#perform_BWD(org.moflon.tgg.runtime.IsApplicableMatch)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__Perform_BWD__IsApplicableMatch();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_BWD(org.moflon.tgg.runtime.Match) <em>Is Applicable BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_BWD(org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_BWD__Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjectsToMatch_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD) <em>Register Objects To Match BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register Objects To Match BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjectsToMatch_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__RegisterObjectsToMatch_BWD__Match_EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_solveCsp_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD) <em>Is Appropriate solve Csp BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate solve Csp BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_solveCsp_BWD(org.moflon.tgg.runtime.Match, eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_solveCsp_BWD__Match_EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_checkCsp_BWD(org.moflon.tgg.language.csp.CSP) <em>Is Appropriate check Csp BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate check Csp BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_checkCsp_BWD(org.moflon.tgg.language.csp.CSP)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_checkCsp_BWD__CSP();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_BWD(org.moflon.tgg.runtime.IsApplicableMatch, eDFDFlowTracking.EDFD) <em>Is Applicable solve Csp BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable solve Csp BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_BWD(org.moflon.tgg.runtime.IsApplicableMatch, eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_solveCsp_BWD__IsApplicableMatch_EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_BWD(org.moflon.tgg.language.csp.CSP) <em>Is Applicable check Csp BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable check Csp BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_BWD(org.moflon.tgg.language.csp.CSP)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_checkCsp_BWD__CSP();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjects_BWD(org.moflon.tgg.runtime.PerformRuleResult, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject) <em>Register Objects BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register Objects BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#registerObjects_BWD(org.moflon.tgg.runtime.PerformRuleResult, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__RegisterObjects_BWD__PerformRuleResult_EObject_EObject_EObject();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkTypes_BWD(org.moflon.tgg.runtime.Match) <em>Check Types BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Types BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkTypes_BWD(org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckTypes_BWD__Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_BWD_EDFD_2(eDFDFlowTracking.EDFD) <em>Is Appropriate BWD EDFD 2</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate BWD EDFD 2</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_BWD_EDFD_2(eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_BWD_EDFD_2__EDFD();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_FWD_TypeGraph_2(org.gravity.typegraph.basic.TypeGraph) <em>Is Appropriate FWD Type Graph 2</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Appropriate FWD Type Graph 2</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isAppropriate_FWD_TypeGraph_2(org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsAppropriate_FWD_TypeGraph_2__TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkAttributes_FWD(org.moflon.tgg.runtime.TripleMatch) <em>Check Attributes FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Attributes FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkAttributes_FWD(org.moflon.tgg.runtime.TripleMatch)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckAttributes_FWD__TripleMatch();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkAttributes_BWD(org.moflon.tgg.runtime.TripleMatch) <em>Check Attributes BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Attributes BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkAttributes_BWD(org.moflon.tgg.runtime.TripleMatch)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckAttributes_BWD__TripleMatch();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_CC(org.moflon.tgg.runtime.Match, org.moflon.tgg.runtime.Match) <em>Is Applicable CC</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable CC</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_CC(org.moflon.tgg.runtime.Match, org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_CC__Match_Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_CC(eDFDFlowTracking.EDFD, org.gravity.typegraph.basic.TypeGraph, org.moflon.tgg.runtime.Match, org.moflon.tgg.runtime.Match) <em>Is Applicable solve Csp CC</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable solve Csp CC</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_solveCsp_CC(eDFDFlowTracking.EDFD, org.gravity.typegraph.basic.TypeGraph, org.moflon.tgg.runtime.Match, org.moflon.tgg.runtime.Match)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_solveCsp_CC__EDFD_TypeGraph_Match_Match();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_CC(org.moflon.tgg.language.csp.CSP) <em>Is Applicable check Csp CC</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Applicable check Csp CC</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#isApplicable_checkCsp_CC(org.moflon.tgg.language.csp.CSP)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__IsApplicable_checkCsp_CC__CSP();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkDEC_FWD(org.gravity.typegraph.basic.TypeGraph) <em>Check DEC FWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check DEC FWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkDEC_FWD(org.gravity.typegraph.basic.TypeGraph)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckDEC_FWD__TypeGraph();

	/**
	 * Returns the meta object for the '{@link org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkDEC_BWD(eDFDFlowTracking.EDFD) <em>Check DEC BWD</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check DEC BWD</em>' operation.
	 * @see org.gravity.mapping.secdfd.Rules.TypeGraph2EDFD#checkDEC_BWD(eDFDFlowTracking.EDFD)
	 * @generated
	 */
	EOperation getTypeGraph2EDFD__CheckDEC_BWD__EDFD();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RulesFactory getRulesFactory();

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
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.Rules.impl.TypeGraph2EDFDImpl <em>Type Graph2 EDFD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.Rules.impl.TypeGraph2EDFDImpl
		 * @see org.gravity.mapping.secdfd.Rules.impl.RulesPackageImpl#getTypeGraph2EDFD()
		 * @generated
		 */
		EClass TYPE_GRAPH2_EDFD = eINSTANCE.getTypeGraph2EDFD();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_FWD__MATCH_TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_FWD__Match_TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Perform FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___PERFORM_FWD__ISAPPLICABLEMATCH = eINSTANCE.getTypeGraph2EDFD__Perform_FWD__IsApplicableMatch();

		/**
		 * The meta object literal for the '<em><b>Is Applicable FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_FWD__MATCH = eINSTANCE.getTypeGraph2EDFD__IsApplicable_FWD__Match();

		/**
		 * The meta object literal for the '<em><b>Register Objects To Match FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_TO_MATCH_FWD__MATCH_TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__RegisterObjectsToMatch_FWD__Match_TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate solve Csp FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_SOLVE_CSP_FWD__MATCH_TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_solveCsp_FWD__Match_TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate check Csp FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_CHECK_CSP_FWD__CSP = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_checkCsp_FWD__CSP();

		/**
		 * The meta object literal for the '<em><b>Is Applicable solve Csp FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_FWD__ISAPPLICABLEMATCH_TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__IsApplicable_solveCsp_FWD__IsApplicableMatch_TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Is Applicable check Csp FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_FWD__CSP = eINSTANCE.getTypeGraph2EDFD__IsApplicable_checkCsp_FWD__CSP();

		/**
		 * The meta object literal for the '<em><b>Register Objects FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_FWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT = eINSTANCE.getTypeGraph2EDFD__RegisterObjects_FWD__PerformRuleResult_EObject_EObject_EObject();

		/**
		 * The meta object literal for the '<em><b>Check Types FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_TYPES_FWD__MATCH = eINSTANCE.getTypeGraph2EDFD__CheckTypes_FWD__Match();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_BWD__MATCH_EDFD = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_BWD__Match_EDFD();

		/**
		 * The meta object literal for the '<em><b>Perform BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___PERFORM_BWD__ISAPPLICABLEMATCH = eINSTANCE.getTypeGraph2EDFD__Perform_BWD__IsApplicableMatch();

		/**
		 * The meta object literal for the '<em><b>Is Applicable BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_BWD__MATCH = eINSTANCE.getTypeGraph2EDFD__IsApplicable_BWD__Match();

		/**
		 * The meta object literal for the '<em><b>Register Objects To Match BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_TO_MATCH_BWD__MATCH_EDFD = eINSTANCE.getTypeGraph2EDFD__RegisterObjectsToMatch_BWD__Match_EDFD();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate solve Csp BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_SOLVE_CSP_BWD__MATCH_EDFD = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_solveCsp_BWD__Match_EDFD();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate check Csp BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_CHECK_CSP_BWD__CSP = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_checkCsp_BWD__CSP();

		/**
		 * The meta object literal for the '<em><b>Is Applicable solve Csp BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_BWD__ISAPPLICABLEMATCH_EDFD = eINSTANCE.getTypeGraph2EDFD__IsApplicable_solveCsp_BWD__IsApplicableMatch_EDFD();

		/**
		 * The meta object literal for the '<em><b>Is Applicable check Csp BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_BWD__CSP = eINSTANCE.getTypeGraph2EDFD__IsApplicable_checkCsp_BWD__CSP();

		/**
		 * The meta object literal for the '<em><b>Register Objects BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___REGISTER_OBJECTS_BWD__PERFORMRULERESULT_EOBJECT_EOBJECT_EOBJECT = eINSTANCE.getTypeGraph2EDFD__RegisterObjects_BWD__PerformRuleResult_EObject_EObject_EObject();

		/**
		 * The meta object literal for the '<em><b>Check Types BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_TYPES_BWD__MATCH = eINSTANCE.getTypeGraph2EDFD__CheckTypes_BWD__Match();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate BWD EDFD 2</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_BWD_EDFD_2__EDFD = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_BWD_EDFD_2__EDFD();

		/**
		 * The meta object literal for the '<em><b>Is Appropriate FWD Type Graph 2</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPROPRIATE_FWD_TYPE_GRAPH_2__TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__IsAppropriate_FWD_TypeGraph_2__TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Check Attributes FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_ATTRIBUTES_FWD__TRIPLEMATCH = eINSTANCE.getTypeGraph2EDFD__CheckAttributes_FWD__TripleMatch();

		/**
		 * The meta object literal for the '<em><b>Check Attributes BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_ATTRIBUTES_BWD__TRIPLEMATCH = eINSTANCE.getTypeGraph2EDFD__CheckAttributes_BWD__TripleMatch();

		/**
		 * The meta object literal for the '<em><b>Is Applicable CC</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_CC__MATCH_MATCH = eINSTANCE.getTypeGraph2EDFD__IsApplicable_CC__Match_Match();

		/**
		 * The meta object literal for the '<em><b>Is Applicable solve Csp CC</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_SOLVE_CSP_CC__EDFD_TYPEGRAPH_MATCH_MATCH = eINSTANCE.getTypeGraph2EDFD__IsApplicable_solveCsp_CC__EDFD_TypeGraph_Match_Match();

		/**
		 * The meta object literal for the '<em><b>Is Applicable check Csp CC</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___IS_APPLICABLE_CHECK_CSP_CC__CSP = eINSTANCE.getTypeGraph2EDFD__IsApplicable_checkCsp_CC__CSP();

		/**
		 * The meta object literal for the '<em><b>Check DEC FWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_DEC_FWD__TYPEGRAPH = eINSTANCE.getTypeGraph2EDFD__CheckDEC_FWD__TypeGraph();

		/**
		 * The meta object literal for the '<em><b>Check DEC BWD</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_GRAPH2_EDFD___CHECK_DEC_BWD__EDFD = eINSTANCE.getTypeGraph2EDFD__CheckDEC_BWD__EDFD();

	}

} //RulesPackage
