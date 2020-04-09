/**
 */
package org.secdfd.model.tests;

import junit.textui.TestRunner;

import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>External Entity</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalEntityTest extends ElementTest {

	public void test() {
		//TODO: Implement test here
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExternalEntityTest.class);
	}

	/**
	 * Constructs a new External Entity test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalEntityTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this External Entity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ExternalEntity getFixture() {
		return (ExternalEntity)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createExternalEntity());
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

} //ExternalEntityTest
