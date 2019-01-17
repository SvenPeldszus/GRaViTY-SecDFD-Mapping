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
	 * Returns a new object of class '<em>Type2 Graph Asset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type2 Graph Asset</em>'.
	 * @generated
	 */
	Type2GraphAsset createType2GraphAsset();

	/**
	 * Returns a new object of class '<em>Method2 Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method2 Node</em>'.
	 * @generated
	 */
	Method2Node createMethod2Node();

	/**
	 * Returns a new object of class '<em>Type Graph2 Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Graph2 Graph</em>'.
	 * @generated
	 */
	TypeGraph2Graph createTypeGraph2Graph();

	/**
	 * Returns a new object of class '<em>Defintion2 Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defintion2 Node</em>'.
	 * @generated
	 */
	Defintion2Node createDefintion2Node();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SecdfdPackage getSecdfdPackage();

} //SecdfdFactory
