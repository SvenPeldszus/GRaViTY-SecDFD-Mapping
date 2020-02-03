/**
 */
package org.gravity.mapping.secdfd;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.gravity.mapping.secdfd.SecdfdFactory
 * @model kind="package"
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
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.AbstractCorrespondence <em>Abstract Correspondence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.AbstractCorrespondence
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getAbstractCorrespondence()
	 * @generated
	 */
	int ABSTRACT_CORRESPONDENCE = 0;

	/**
	 * The number of structural features of the '<em>Abstract Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CORRESPONDENCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CORRESPONDENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Method2ElementImpl <em>Method2 Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Method2ElementImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getMethod2Element()
	 * @generated
	 */
	int METHOD2_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_ELEMENT__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_ELEMENT__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_ELEMENT_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Method2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD2_ELEMENT_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl <em>Type2 Named Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getType2NamedEntity()
	 * @generated
	 */
	int TYPE2_NAMED_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_NAMED_ENTITY__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_NAMED_ENTITY__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type2 Named Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_NAMED_ENTITY_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type2 Named Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_NAMED_ENTITY_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.TypeGraph2EDFDImpl <em>Type Graph2 EDFD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.TypeGraph2EDFDImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getTypeGraph2EDFD()
	 * @generated
	 */
	int TYPE_GRAPH2_EDFD = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Graph2 EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type Graph2 EDFD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_GRAPH2_EDFD_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Defintion2ElementImpl <em>Defintion2 Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Defintion2ElementImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getDefintion2Element()
	 * @generated
	 */
	int DEFINTION2_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_ELEMENT__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_ELEMENT__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Defintion2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_ELEMENT_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Defintion2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINTION2_ELEMENT_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Flow2AccessImpl <em>Flow2 Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Flow2AccessImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getFlow2Access()
	 * @generated
	 */
	int FLOW2_ACCESS = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW2_ACCESS__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW2_ACCESS__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Flow2 Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW2_ACCESS_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Flow2 Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW2_ACCESS_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gravity.mapping.secdfd.impl.Signature2ElementImpl <em>Signature2 Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gravity.mapping.secdfd.impl.Signature2ElementImpl
	 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getSignature2Element()
	 * @generated
	 */
	int SIGNATURE2_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE2_ELEMENT__SOURCE = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE2_ELEMENT__TARGET = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Signature2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE2_ELEMENT_FEATURE_COUNT = ABSTRACT_CORRESPONDENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Signature2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE2_ELEMENT_OPERATION_COUNT = ABSTRACT_CORRESPONDENCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.AbstractCorrespondence <em>Abstract Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Correspondence</em>'.
	 * @see org.gravity.mapping.secdfd.AbstractCorrespondence
	 * @generated
	 */
	EClass getAbstractCorrespondence();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Method2Element <em>Method2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method2 Element</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Element
	 * @generated
	 */
	EClass getMethod2Element();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Method2Element#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Element#getSource()
	 * @see #getMethod2Element()
	 * @generated
	 */
	EReference getMethod2Element_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Method2Element#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Method2Element#getTarget()
	 * @see #getMethod2Element()
	 * @generated
	 */
	EReference getMethod2Element_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Type2NamedEntity <em>Type2 Named Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type2 Named Entity</em>'.
	 * @see org.gravity.mapping.secdfd.Type2NamedEntity
	 * @generated
	 */
	EClass getType2NamedEntity();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Type2NamedEntity#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Type2NamedEntity#getSource()
	 * @see #getType2NamedEntity()
	 * @generated
	 */
	EReference getType2NamedEntity_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Type2NamedEntity#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Type2NamedEntity#getTarget()
	 * @see #getType2NamedEntity()
	 * @generated
	 */
	EReference getType2NamedEntity_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.TypeGraph2EDFD <em>Type Graph2 EDFD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Graph2 EDFD</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2EDFD
	 * @generated
	 */
	EClass getTypeGraph2EDFD();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.TypeGraph2EDFD#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2EDFD#getSource()
	 * @see #getTypeGraph2EDFD()
	 * @generated
	 */
	EReference getTypeGraph2EDFD_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.TypeGraph2EDFD#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.TypeGraph2EDFD#getTarget()
	 * @see #getTypeGraph2EDFD()
	 * @generated
	 */
	EReference getTypeGraph2EDFD_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Defintion2Element <em>Defintion2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defintion2 Element</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Element
	 * @generated
	 */
	EClass getDefintion2Element();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Defintion2Element#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Element#getSource()
	 * @see #getDefintion2Element()
	 * @generated
	 */
	EReference getDefintion2Element_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Defintion2Element#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Defintion2Element#getTarget()
	 * @see #getDefintion2Element()
	 * @generated
	 */
	EReference getDefintion2Element_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Flow2Access <em>Flow2 Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow2 Access</em>'.
	 * @see org.gravity.mapping.secdfd.Flow2Access
	 * @generated
	 */
	EClass getFlow2Access();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Flow2Access#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Flow2Access#getSource()
	 * @see #getFlow2Access()
	 * @generated
	 */
	EReference getFlow2Access_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Flow2Access#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Flow2Access#getTarget()
	 * @see #getFlow2Access()
	 * @generated
	 */
	EReference getFlow2Access_Target();

	/**
	 * Returns the meta object for class '{@link org.gravity.mapping.secdfd.Signature2Element <em>Signature2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature2 Element</em>'.
	 * @see org.gravity.mapping.secdfd.Signature2Element
	 * @generated
	 */
	EClass getSignature2Element();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Signature2Element#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gravity.mapping.secdfd.Signature2Element#getSource()
	 * @see #getSignature2Element()
	 * @generated
	 */
	EReference getSignature2Element_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gravity.mapping.secdfd.Signature2Element#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gravity.mapping.secdfd.Signature2Element#getTarget()
	 * @see #getSignature2Element()
	 * @generated
	 */
	EReference getSignature2Element_Target();

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
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.AbstractCorrespondence <em>Abstract Correspondence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.AbstractCorrespondence
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getAbstractCorrespondence()
		 * @generated
		 */
		EClass ABSTRACT_CORRESPONDENCE = eINSTANCE.getAbstractCorrespondence();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Method2ElementImpl <em>Method2 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Method2ElementImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getMethod2Element()
		 * @generated
		 */
		EClass METHOD2_ELEMENT = eINSTANCE.getMethod2Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD2_ELEMENT__SOURCE = eINSTANCE.getMethod2Element_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD2_ELEMENT__TARGET = eINSTANCE.getMethod2Element_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl <em>Type2 Named Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Type2NamedEntityImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getType2NamedEntity()
		 * @generated
		 */
		EClass TYPE2_NAMED_ENTITY = eINSTANCE.getType2NamedEntity();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE2_NAMED_ENTITY__SOURCE = eINSTANCE.getType2NamedEntity_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE2_NAMED_ENTITY__TARGET = eINSTANCE.getType2NamedEntity_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.TypeGraph2EDFDImpl <em>Type Graph2 EDFD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.TypeGraph2EDFDImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getTypeGraph2EDFD()
		 * @generated
		 */
		EClass TYPE_GRAPH2_EDFD = eINSTANCE.getTypeGraph2EDFD();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_GRAPH2_EDFD__SOURCE = eINSTANCE.getTypeGraph2EDFD_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_GRAPH2_EDFD__TARGET = eINSTANCE.getTypeGraph2EDFD_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Defintion2ElementImpl <em>Defintion2 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Defintion2ElementImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getDefintion2Element()
		 * @generated
		 */
		EClass DEFINTION2_ELEMENT = eINSTANCE.getDefintion2Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINTION2_ELEMENT__SOURCE = eINSTANCE.getDefintion2Element_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINTION2_ELEMENT__TARGET = eINSTANCE.getDefintion2Element_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Flow2AccessImpl <em>Flow2 Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Flow2AccessImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getFlow2Access()
		 * @generated
		 */
		EClass FLOW2_ACCESS = eINSTANCE.getFlow2Access();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW2_ACCESS__SOURCE = eINSTANCE.getFlow2Access_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW2_ACCESS__TARGET = eINSTANCE.getFlow2Access_Target();

		/**
		 * The meta object literal for the '{@link org.gravity.mapping.secdfd.impl.Signature2ElementImpl <em>Signature2 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gravity.mapping.secdfd.impl.Signature2ElementImpl
		 * @see org.gravity.mapping.secdfd.impl.SecdfdPackageImpl#getSignature2Element()
		 * @generated
		 */
		EClass SIGNATURE2_ELEMENT = eINSTANCE.getSignature2Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE2_ELEMENT__SOURCE = eINSTANCE.getSignature2Element_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE2_ELEMENT__TARGET = eINSTANCE.getSignature2Element_Target();

	}

} //SecdfdPackage
