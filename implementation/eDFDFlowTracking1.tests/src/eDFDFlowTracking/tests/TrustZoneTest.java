/**
 */
package eDFDFlowTracking.tests;

import eDFDFlowTracking.EDFDFlowTrackingFactory;
import eDFDFlowTracking.TrustZone;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Trust Zone</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrustZoneTest extends ElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TrustZoneTest.class);
	}

	/**
	 * Constructs a new Trust Zone test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrustZoneTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Trust Zone test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TrustZone getFixture() {
		return (TrustZone)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EDFDFlowTrackingFactory.eINSTANCE.createTrustZone());
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

} //TrustZoneTest
