/**
 */
package org.secdfd.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Responsibility Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.secdfd.model.ModelPackage#getResponsibilityType()
 * @model
 * @generated
 */
public enum ResponsibilityType implements Enumerator {
	/**
	 * The '<em><b>Store</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORE_VALUE
	 * @generated
	 * @ordered
	 */
	STORE(1, "Store", "Store"),

	/**
	 * The '<em><b>Comparator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	COMPARATOR(2, "Comparator", "Comparator"),

	/**
	 * The '<em><b>Discarder</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCARDER_VALUE
	 * @generated
	 * @ordered
	 */
	DISCARDER(3, "Discarder", "Discarder"),

	/**
	 * The '<em><b>Joiner</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOINER_VALUE
	 * @generated
	 * @ordered
	 */
	JOINER(4, "Joiner", "Joiner"),

	/**
	 * The '<em><b>Copier</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPIER_VALUE
	 * @generated
	 * @ordered
	 */
	COPIER(5, "Copier", "Copier"),

	/**
	 * The '<em><b>Splitter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLITTER_VALUE
	 * @generated
	 * @ordered
	 */
	SPLITTER(6, "Splitter", "Splitter"),

	/**
	 * The '<em><b>Forward</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORWARD_VALUE
	 * @generated
	 * @ordered
	 */
	FORWARD(7, "Forward", "Forward"),

	/**
	 * The '<em><b>Encrypt Or Hash</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_OR_HASH_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPT_OR_HASH(8, "EncryptOrHash", "EncryptOrHash"),

	/**
	 * The '<em><b>Decrypt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECRYPT_VALUE
	 * @generated
	 * @ordered
	 */
	DECRYPT(9, "Decrypt", "Decrypt"),

	/**
	 * The '<em><b>Authenticator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATOR_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHENTICATOR(10, "Authenticator", "Authenticator"),

	/**
	 * The '<em><b>Authoriser</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHORISER_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHORISER(11, "Authoriser", "Authoriser"),

	/**
	 * The '<em><b>Verifier</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERIFIER_VALUE
	 * @generated
	 * @ordered
	 */
	VERIFIER(13, "Verifier", "Verifier"),

	/**
	 * The '<em><b>User</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_VALUE
	 * @generated
	 * @ordered
	 */
	USER(14, "User", "User");

	/**
	 * The '<em><b>Store</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORE
	 * @model name="Store"
	 * @generated
	 * @ordered
	 */
	public static final int STORE_VALUE = 1;

	/**
	 * The '<em><b>Comparator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPARATOR
	 * @model name="Comparator"
	 * @generated
	 * @ordered
	 */
	public static final int COMPARATOR_VALUE = 2;

	/**
	 * The '<em><b>Discarder</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCARDER
	 * @model name="Discarder"
	 * @generated
	 * @ordered
	 */
	public static final int DISCARDER_VALUE = 3;

	/**
	 * The '<em><b>Joiner</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOINER
	 * @model name="Joiner"
	 * @generated
	 * @ordered
	 */
	public static final int JOINER_VALUE = 4;

	/**
	 * The '<em><b>Copier</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPIER
	 * @model name="Copier"
	 * @generated
	 * @ordered
	 */
	public static final int COPIER_VALUE = 5;

	/**
	 * The '<em><b>Splitter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLITTER
	 * @model name="Splitter"
	 * @generated
	 * @ordered
	 */
	public static final int SPLITTER_VALUE = 6;

	/**
	 * The '<em><b>Forward</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORWARD
	 * @model name="Forward"
	 * @generated
	 * @ordered
	 */
	public static final int FORWARD_VALUE = 7;

	/**
	 * The '<em><b>Encrypt Or Hash</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_OR_HASH
	 * @model name="EncryptOrHash"
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPT_OR_HASH_VALUE = 8;

	/**
	 * The '<em><b>Decrypt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECRYPT
	 * @model name="Decrypt"
	 * @generated
	 * @ordered
	 */
	public static final int DECRYPT_VALUE = 9;

	/**
	 * The '<em><b>Authenticator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATOR
	 * @model name="Authenticator"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHENTICATOR_VALUE = 10;

	/**
	 * The '<em><b>Authoriser</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHORISER
	 * @model name="Authoriser"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHORISER_VALUE = 11;

	/**
	 * The '<em><b>Verifier</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERIFIER
	 * @model name="Verifier"
	 * @generated
	 * @ordered
	 */
	public static final int VERIFIER_VALUE = 13;

	/**
	 * The '<em><b>User</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER
	 * @model name="User"
	 * @generated
	 * @ordered
	 */
	public static final int USER_VALUE = 14;

	/**
	 * An array of all the '<em><b>Responsibility Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResponsibilityType[] VALUES_ARRAY =
		new ResponsibilityType[] {
			STORE,
			COMPARATOR,
			DISCARDER,
			JOINER,
			COPIER,
			SPLITTER,
			FORWARD,
			ENCRYPT_OR_HASH,
			DECRYPT,
			AUTHENTICATOR,
			AUTHORISER,
			VERIFIER,
			USER,
		};

	/**
	 * A public read-only list of all the '<em><b>Responsibility Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResponsibilityType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Responsibility Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResponsibilityType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResponsibilityType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Responsibility Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResponsibilityType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResponsibilityType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Responsibility Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResponsibilityType get(int value) {
		switch (value) {
			case STORE_VALUE: return STORE;
			case COMPARATOR_VALUE: return COMPARATOR;
			case DISCARDER_VALUE: return DISCARDER;
			case JOINER_VALUE: return JOINER;
			case COPIER_VALUE: return COPIER;
			case SPLITTER_VALUE: return SPLITTER;
			case FORWARD_VALUE: return FORWARD;
			case ENCRYPT_OR_HASH_VALUE: return ENCRYPT_OR_HASH;
			case DECRYPT_VALUE: return DECRYPT;
			case AUTHENTICATOR_VALUE: return AUTHENTICATOR;
			case AUTHORISER_VALUE: return AUTHORISER;
			case VERIFIER_VALUE: return VERIFIER;
			case USER_VALUE: return USER;
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
	private ResponsibilityType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	
} //ResponsibilityType
