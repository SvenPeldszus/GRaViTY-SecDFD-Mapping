/**
 */
package eDFDFlowTracking.tests;

import eDFDFlowTracking.EDFDFlowTracking1Factory;
import eDFDFlowTracking.Responsibility;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Responsibility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResponsibilityTest extends TestCase {

	/**
	 * The fixture for this Responsibility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Responsibility fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResponsibilityTest.class);
	}

	/**
	 * Constructs a new Responsibility test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Responsibility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Responsibility fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Responsibility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Responsibility getFixture() {
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
		setFixture(EDFDFlowTracking1Factory.eINSTANCE.createResponsibility());
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

} //ResponsibilityTest
