/**
 */
package org.gravity.mapping.secdfd;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gravity.mapping.secdfd.SecdfdPackage
 * @generated
 */
public interface SecdfdFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecdfdFactory eINSTANCE = org.gravity.mapping.secdfd.impl.SecdfdFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Method2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method2 Element</em>'.
	 * @generated
	 */
	Method2Element createMethod2Element();

	/**
	 * Returns a new object of class '<em>Type2 Named Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type2 Named Entity</em>'.
	 * @generated
	 */
	Type2NamedEntity createType2NamedEntity();

	/**
	 * Returns a new object of class '<em>Type Graph2 EDFD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Graph2 EDFD</em>'.
	 * @generated
	 */
	TypeGraph2EDFD createTypeGraph2EDFD();

	/**
	 * Returns a new object of class '<em>Defintion2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defintion2 Element</em>'.
	 * @generated
	 */
	Defintion2Element createDefintion2Element();

	/**
	 * Returns a new object of class '<em>Flow2 Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow2 Access</em>'.
	 * @generated
	 */
	Flow2Access createFlow2Access();

	/**
	 * Returns a new object of class '<em>Signature2 Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signature2 Element</em>'.
	 * @generated
	 */
	Signature2Element createSignature2Element();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SecdfdPackage getSecdfdPackage();

} //SecdfdFactory
