/**
 */
package org.gravity.mapping.secdfd.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gravity.mapping.secdfd.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecdfdFactoryImpl extends EFactoryImpl implements SecdfdFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SecdfdFactory init() {
		try {
			SecdfdFactory theSecdfdFactory = (SecdfdFactory)EPackage.Registry.INSTANCE.getEFactory(SecdfdPackage.eNS_URI);
			if (theSecdfdFactory != null) {
				return theSecdfdFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SecdfdFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecdfdFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SecdfdPackage.TYPE2_GRAPH_ASSET: return createType2GraphAsset();
			case SecdfdPackage.METHOD2_NODE: return createMethod2Node();
			case SecdfdPackage.TYPE_GRAPH2_GRAPH: return createTypeGraph2Graph();
			case SecdfdPackage.DEFINTION2_NODE: return createDefintion2Node();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type2GraphAsset createType2GraphAsset() {
		Type2GraphAssetImpl type2GraphAsset = new Type2GraphAssetImpl();
		return type2GraphAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method2Node createMethod2Node() {
		Method2NodeImpl method2Node = new Method2NodeImpl();
		return method2Node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeGraph2Graph createTypeGraph2Graph() {
		TypeGraph2GraphImpl typeGraph2Graph = new TypeGraph2GraphImpl();
		return typeGraph2Graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Defintion2Node createDefintion2Node() {
		Defintion2NodeImpl defintion2Node = new Defintion2NodeImpl();
		return defintion2Node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecdfdPackage getSecdfdPackage() {
		return (SecdfdPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SecdfdPackage getPackage() {
		return SecdfdPackage.eINSTANCE;
	}

} //SecdfdFactoryImpl
