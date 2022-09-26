/**
 */
package org.secdfd.model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.secdfd.model.ModelFactory;
import org.secdfd.model.Responsibility;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Responsibility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResponsibilityTest extends TestCase {

	public void test() {
		//TODO: Implement test here
	}

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
		setFixture(ModelFactory.eINSTANCE.createResponsibility());
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
