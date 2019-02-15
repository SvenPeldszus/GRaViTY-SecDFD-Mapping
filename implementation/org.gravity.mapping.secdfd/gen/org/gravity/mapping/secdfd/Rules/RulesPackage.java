/**
 */
package org.gravity.mapping.secdfd.Rules;

import org.eclipse.emf.ecore.EClass;
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
	 * The number of operations of the '<em>Type Graph2 EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD_OPERATION_COUNT = RuntimePackage.ABSTRACT_RULE_OPERATION_COUNT + 0;


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

	}

} //RulesPackage
