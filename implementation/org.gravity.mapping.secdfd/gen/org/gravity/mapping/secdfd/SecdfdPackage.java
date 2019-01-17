/**
 */
package org.gravity.mapping.secdfd;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.gravity.mapping.secdfd.SecdfdFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='org.gravity.mapping'"
 * @generated
 */
public interface SecdfdPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "secdfd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/org.gravity.mapping.secdfd/model/Secdfd.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gravity.mapping.secdfd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecdfdPackage eINSTANCE = org.gravity.mapping.secdfd.impl.SecdfdPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Type2GraphAssetImpl <em>Type2 Graph Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Type2GraphAssetImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getType2GraphAsset()
	 * @generated
	 */
	int TYPE2_GRAPH_ASSET = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_GRAPH_ASSET__SOURCE = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_GRAPH_ASSET__TARGET = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type2 Graph Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_GRAPH_ASSET_FEATURE_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type2 Graph Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_GRAPH_ASSET_OPERATION_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Method2NodeImpl <em>Method2 Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Method2NodeImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getMethod2Node()
	 * @generated
	 */
	int METHOD2_NODE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_NODE__SOURCE = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_NODE__TARGET = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method2 Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_NODE_FEATURE_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Method2 Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_NODE_OPERATION_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.TypeGraph2GraphImpl <em>Type Graph2 Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.TypeGraph2GraphImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getTypeGraph2Graph()
	 * @generated
	 */
	int TYPE_GRAPH2_GRAPH = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_GRAPH__SOURCE = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_GRAPH__TARGET = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Graph2 Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_GRAPH_FEATURE_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type Graph2 Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_GRAPH_OPERATION_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Defintion2NodeImpl <em>Defintion2 Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Defintion2NodeImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getDefintion2Node()
	 * @generated
	 */
	int DEFINTION2_NODE = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_NODE__SOURCE = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_NODE__TARGET = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Defintion2 Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_NODE_FEATURE_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Defintion2 Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_NODE_OPERATION_COUNT = RuntimePackage.ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Type2GraphAsset <em>Type2 Graph Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type2 Graph Asset</em>'.
	 * @see org.gravity.mapping.secdfd.Type2GraphAsset
	 * @generated
	 */
	EClass getType2GraphAsset();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Type2GraphAsset#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Type2GraphAsset#getSource()
	 * @see #getType2GraphAsset()
	 * @generated
	 */
	EReference getType2GraphAsset_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Type2GraphAsset#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Type2GraphAsset#getTarget()
	 * @see #getType2GraphAsset()
	 * @generated
	 */
	EReference getType2GraphAsset_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Method2Node <em>Method2 Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method2 Node</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Node
	 * @generated
	 */
	EClass getMethod2Node();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Method2Node#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Node#getSource()
	 * @see #getMethod2Node()
	 * @generated
	 */
	EReference getMethod2Node_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Method2Node#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Node#getTarget()
	 * @see #getMethod2Node()
	 * @generated
	 */
	EReference getMethod2Node_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.TypeGraph2Graph <em>Type Graph2 Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Graph2 Graph</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2Graph
	 * @generated
	 */
	EClass getTypeGraph2Graph();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2Graph#getSource()
	 * @see #getTypeGraph2Graph()
	 * @generated
	 */
	EReference getTypeGraph2Graph_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.TypeGraph2Graph#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2Graph#getTarget()
	 * @see #getTypeGraph2Graph()
	 * @generated
	 */
	EReference getTypeGraph2Graph_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Defintion2Node <em>Defintion2 Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defintion2 Node</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Node
	 * @generated
	 */
	EClass getDefintion2Node();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Defintion2Node#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Node#getSource()
	 * @see #getDefintion2Node()
	 * @generated
	 */
	EReference getDefintion2Node_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Defintion2Node#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Node#getTarget()
	 * @see #getDefintion2Node()
	 * @generated
	 */
	EReference getDefintion2Node_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SecdfdFactory getSecdfdFactory();

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
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Type2GraphAssetImpl <em>Type2 Graph Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Type2GraphAssetImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getType2GraphAsset()
		 * @generated
		 */
		EClass TYPE2_GRAPH_ASSET = eINSTANCE.getType2GraphAsset();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE2_GRAPH_ASSET__SOURCE = eINSTANCE.getType2GraphAsset_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE2_GRAPH_ASSET__TARGET = eINSTANCE.getType2GraphAsset_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Method2NodeImpl <em>Method2 Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Method2NodeImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getMethod2Node()
		 * @generated
		 */
		EClass METHOD2_NODE = eINSTANCE.getMethod2Node();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD2_NODE__SOURCE = eINSTANCE.getMethod2Node_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD2_NODE__TARGET = eINSTANCE.getMethod2Node_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.TypeGraph2GraphImpl <em>Type Graph2 Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.TypeGraph2GraphImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getTypeGraph2Graph()
		 * @generated
		 */
		EClass TYPE_GRAPH2_GRAPH = eINSTANCE.getTypeGraph2Graph();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_GRAPH2_GRAPH__SOURCE = eINSTANCE.getTypeGraph2Graph_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_GRAPH2_GRAPH__TARGET = eINSTANCE.getTypeGraph2Graph_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Defintion2NodeImpl <em>Defintion2 Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Defintion2NodeImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getDefintion2Node()
		 * @generated
		 */
		EClass DEFINTION2_NODE = eINSTANCE.getDefintion2Node();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINTION2_NODE__SOURCE = eINSTANCE.getDefintion2Node_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINTION2_NODE__TARGET = eINSTANCE.getDefintion2Node_Target();

	}

} //SecdfdPackage
