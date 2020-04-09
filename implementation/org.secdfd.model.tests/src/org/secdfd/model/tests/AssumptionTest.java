/**
 */
package org.secdfd.model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.secdfd.model.Assumption;
import org.secdfd.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssumptionTest extends TestCase {

	public void test() {
		//TODO: Implement test here
	}

	/**
	 * The fixture for this Assumption test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Assumption fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AssumptionTest.class);
	}

	/**
	 * Constructs a new Assumption test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssumptionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Assumption test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Assumption fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Assumption test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Assumption getFixture() {
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
		setFixture(ModelFactory.eINSTANCE.createAssumption());
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

} //AssumptionTest
