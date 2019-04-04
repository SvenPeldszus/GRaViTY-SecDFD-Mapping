/**
 */
package eDFDFlowTracking.tests;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFDFlowTracking1Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssetTest extends TestCase {

	/**
	 * The fixture for this Asset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Asset fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AssetTest.class);
	}

	/**
	 * Constructs a new Asset test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssetTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Asset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Asset fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Asset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Asset getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EDFDFlowTracking1Factory.eINSTANCE.createAsset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AssetTest
