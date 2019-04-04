/**
 */
package eDFDFlowTracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Objective</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eDFDFlowTracking.EDFDFlowTracking1Package#getObjective()
 * @model
 * @generated
 */
public enum Objective implements Enumerator {
	/**
	 * The '<em><b>Integrity</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGRITY_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGRITY(0, "Integrity", "Integrity"),

	/**
	 * The '<em><b>Confidentiality</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFIDENTIALITY_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIDENTIALITY(1, "Confidentiality", "Confidentiality"),

	/**
	 * The '<em><b>Availability</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AVAILABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	AVAILABILITY(2, "Availability", "Availability"),

	/**
	 * The '<em><b>Accountability</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCOUNTABILITY_VALUE
	 * @generated
	 * @ordered
	 */
	ACCOUNTABILITY(3, "Accountability", "Accountability");

	/**
	 * The '<em><b>Integrity</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integrity</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGRITY
	 * @model name="Integrity"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGRITY_VALUE = 0;

	/**
	 * The '<em><b>Confidentiality</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Confidentiality</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONFIDENTIALITY
	 * @model name="Confidentiality"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIDENTIALITY_VALUE = 1;

	/**
	 * The '<em><b>Availability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Availability</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AVAILABILITY
	 * @model name="Availability"
	 * @generated
	 * @ordered
	 */
	public static final int AVAILABILITY_VALUE = 2;

	/**
	 * The '<em><b>Accountability</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accountability</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCOUNTABILITY
	 * @model name="Accountability"
	 * @generated
	 * @ordered
	 */
	public static final int ACCOUNTABILITY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Objective</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Objective[] VALUES_ARRAY =
		new Objective[] {
			INTEGRITY,
			CONFIDENTIALITY,
			AVAILABILITY,
			ACCOUNTABILITY,
		};

	/**
	 * A public read-only list of all the '<em><b>Objective</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Objective> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Objective result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Objective result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective get(int value) {
		switch (value) {
			case INTEGRITY_VALUE: return INTEGRITY;
			case CONFIDENTIALITY_VALUE: return CONFIDENTIALITY;
			case AVAILABILITY_VALUE: return AVAILABILITY;
			case ACCOUNTABILITY_VALUE: return ACCOUNTABILITY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Objective(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Objective
