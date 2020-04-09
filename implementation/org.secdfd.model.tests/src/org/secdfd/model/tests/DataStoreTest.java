/**
 */
package org.secdfd.model.tests;

import junit.textui.TestRunner;

import org.secdfd.model.DataStore;
import org.secdfd.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Data Store</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataStoreTest extends ElementTest {

	public void test() {
		//TODO: Implement test here
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DataStoreTest.class);
	}

	/**
	 * Constructs a new Data Store test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStoreTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Data Store test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DataStore getFixture() {
		return (DataStore)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createDataStore());
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

} //DataStoreTest
