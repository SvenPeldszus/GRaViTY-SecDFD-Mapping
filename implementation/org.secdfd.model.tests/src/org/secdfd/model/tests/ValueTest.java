/**
 */
package org.secdfd.model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.secdfd.model.ModelFactory;
import org.secdfd.model.Value;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ValueTest extends TestCase {

	public void test() {
		//TODO: Implement test here
	}

	/**
	 * The fixture for this Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Value fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ValueTest.class);
	}

	/**
	 * Constructs a new Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Value fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Value getFixture() {
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
		setFixture(ModelFactory.eINSTANCE.createValue());
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

} //ValueTest
