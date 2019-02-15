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
			case SecdfdPackage.TYPE_GRAPH2_EDFD: return createTypeGraph2EDFD();
			case SecdfdPackage.TYPE2_ASSET: return createType2Asset();
			case SecdfdPackage.DEFINTION2_ELEMENT: return createDefintion2Element();
			case SecdfdPackage.METHOD2_ELEMENT: return createMethod2Element();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeGraph2EDFD createTypeGraph2EDFD() {
		TypeGraph2EDFDImpl typeGraph2EDFD = new TypeGraph2EDFDImpl();
		return typeGraph2EDFD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type2Asset createType2Asset() {
		Type2AssetImpl type2Asset = new Type2AssetImpl();
		return type2Asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Defintion2Element createDefintion2Element() {
		Defintion2ElementImpl defintion2Element = new Defintion2ElementImpl();
		return defintion2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method2Element createMethod2Element() {
		Method2ElementImpl method2Element = new Method2ElementImpl();
		return method2Element;
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
