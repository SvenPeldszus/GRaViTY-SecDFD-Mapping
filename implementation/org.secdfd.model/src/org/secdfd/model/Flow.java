/**
 */
package org.secdfd.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.secdfd.model.Flow#getChannel <em>Channel</em>}</li>
 *   <li>{@link org.secdfd.model.Flow#getTarget <em>Target</em>}</li>
 *   <li>{@link org.secdfd.model.Flow#getSource <em>Source</em>}</li>
 *   <li>{@link org.secdfd.model.Flow#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.secdfd.model.ModelPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends Element {
	/**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * The literals are from the enumeration {@link org.secdfd.model.Channel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see org.secdfd.model.Channel
	 * @see #setChannel(Channel)
	 * @see org.secdfd.model.ModelPackage#getFlow_Channel()
	 * @model
	 * @generated
	 */
	Channel getChannel();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Flow#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see org.secdfd.model.Channel
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(Channel value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.secdfd.model.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.secdfd.model.ModelPackage#getFlow_Target()
	 * @model
	 * @generated
	 */
	EList<Element> getTarget();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Element)
	 * @see org.secdfd.model.ModelPackage#getFlow_Source()
	 * @model
	 * @generated
	 */
	Element getSource();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Flow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Element value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(int)
	 * @see org.secdfd.model.ModelPackage#getFlow_Label()
	 * @model
	 * @generated
	 */
	int getLabel();

	/**
	 * Sets the value of the '{@link org.secdfd.model.Flow#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(int value);

} // Flow
