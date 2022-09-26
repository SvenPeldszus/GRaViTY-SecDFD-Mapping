/**
 */
package org.secdfd.model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.secdfd.model.AttackerProfile;
import org.secdfd.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attacker Profile</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttackerProfileTest extends TestCase {

	public void test() {
		//TODO: Implement test here
	}

	/**
	 * The fixture for this Attacker Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackerProfile fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AttackerProfileTest.class);
	}

	/**
	 * Constructs a new Attacker Profile test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackerProfileTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Attacker Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AttackerProfile fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Attacker Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackerProfile getFixture() {
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
		setFixture(ModelFactory.eINSTANCE.createAttackerProfile());
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

} //AttackerProfileTest
