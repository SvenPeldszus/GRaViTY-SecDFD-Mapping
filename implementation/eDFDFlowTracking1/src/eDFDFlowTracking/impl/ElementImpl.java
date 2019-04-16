/**
 */
package eDFDFlowTracking.impl;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.Assumption;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.Flow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getOutflows <em>Outflows</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getAssumption <em>Assumption</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getAssets <em>Assets</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#getInflows <em>Inflows</em>}</li>
 *   <li>{@link eDFDFlowTracking.impl.ElementImpl#isAttacker <em>Attacker</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementImpl extends MinimalEObjectImpl.Container implements Element {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutflows() <em>Outflows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutflows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> outflows;

	/**
	 * The cached value of the '{@link #getAssumption() <em>Assumption</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssumption()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> assumption;

	/**
	 * The cached value of the '{@link #getAssets() <em>Assets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssets()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> assets;

	/**
	 * The cached value of the '{@link #getInflows() <em>Inflows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInflows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> inflows;

	/**
	 * The default value of the '{@link #isAttacker() <em>Attacker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacker()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTACKER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAttacker() <em>Attacker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacker()
	 * @generated
	 * @ordered
	 */
	protected boolean attacker = ATTACKER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EDFDFlowTracking1Package.Literals.ELEMENT;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EDFDFlowTracking1Package.ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EDFDFlowTracking1Package.ELEMENT__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Flow> getOutflows() {
		if (outflows == null) {
			outflows = new EObjectContainmentEList<Flow>(Flow.class, this, EDFDFlowTracking1Package.ELEMENT__OUTFLOWS);
		}
		return outflows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Assumption> getAssumption() {
		if (assumption == null) {
			assumption = new EObjectContainmentEList<Assumption>(Assumption.class, this, EDFDFlowTracking1Package.ELEMENT__ASSUMPTION);
		}
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Asset> getAssets() {
		if (assets == null) {
			assets = new EObjectResolvingEList<Asset>(Asset.class, this, EDFDFlowTracking1Package.ELEMENT__ASSETS);
		}
		return assets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Flow> getInflows() {
		if (inflows == null) {
			inflows = new EObjectResolvingEList<Flow>(Flow.class, this, EDFDFlowTracking1Package.ELEMENT__INFLOWS);
		}
		return inflows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAttacker() {
		return attacker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttacker(boolean newAttacker) {
		boolean oldAttacker = attacker;
		attacker = newAttacker;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EDFDFlowTracking1Package.ELEMENT__ATTACKER, oldAttacker, attacker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EDFDFlowTracking1Package.ELEMENT__OUTFLOWS:
				return ((InternalEList<?>)getOutflows()).basicRemove(otherEnd, msgs);
			case EDFDFlowTracking1Package.ELEMENT__ASSUMPTION:
				return ((InternalEList<?>)getAssumption()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EDFDFlowTracking1Package.ELEMENT__NAME:
				return getName();
			case EDFDFlowTracking1Package.ELEMENT__NUMBER:
				return getNumber();
			case EDFDFlowTracking1Package.ELEMENT__OUTFLOWS:
				return getOutflows();
			case EDFDFlowTracking1Package.ELEMENT__ASSUMPTION:
				return getAssumption();
			case EDFDFlowTracking1Package.ELEMENT__ASSETS:
				return getAssets();
			case EDFDFlowTracking1Package.ELEMENT__INFLOWS:
				return getInflows();
			case EDFDFlowTracking1Package.ELEMENT__ATTACKER:
				return isAttacker();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EDFDFlowTracking1Package.ELEMENT__NAME:
				setName((String)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__NUMBER:
				setNumber((Integer)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__OUTFLOWS:
				getOutflows().clear();
				getOutflows().addAll((Collection<? extends Flow>)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__ASSUMPTION:
				getAssumption().clear();
				getAssumption().addAll((Collection<? extends Assumption>)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__ASSETS:
				getAssets().clear();
				getAssets().addAll((Collection<? extends Asset>)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__INFLOWS:
				getInflows().clear();
				getInflows().addAll((Collection<? extends Flow>)newValue);
				return;
			case EDFDFlowTracking1Package.ELEMENT__ATTACKER:
				setAttacker((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EDFDFlowTracking1Package.ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EDFDFlowTracking1Package.ELEMENT__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case EDFDFlowTracking1Package.ELEMENT__OUTFLOWS:
				getOutflows().clear();
				return;
			case EDFDFlowTracking1Package.ELEMENT__ASSUMPTION:
				getAssumption().clear();
				return;
			case EDFDFlowTracking1Package.ELEMENT__ASSETS:
				getAssets().clear();
				return;
			case EDFDFlowTracking1Package.ELEMENT__INFLOWS:
				getInflows().clear();
				return;
			case EDFDFlowTracking1Package.ELEMENT__ATTACKER:
				setAttacker(ATTACKER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EDFDFlowTracking1Package.ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EDFDFlowTracking1Package.ELEMENT__NUMBER:
				return number != NUMBER_EDEFAULT;
			case EDFDFlowTracking1Package.ELEMENT__OUTFLOWS:
				return outflows != null && !outflows.isEmpty();
			case EDFDFlowTracking1Package.ELEMENT__ASSUMPTION:
				return assumption != null && !assumption.isEmpty();
			case EDFDFlowTracking1Package.ELEMENT__ASSETS:
				return assets != null && !assets.isEmpty();
			case EDFDFlowTracking1Package.ELEMENT__INFLOWS:
				return inflows != null && !inflows.isEmpty();
			case EDFDFlowTracking1Package.ELEMENT__ATTACKER:
				return attacker != ATTACKER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", number: ");
		result.append(number);
		result.append(", Attacker: ");
		result.append(attacker);
		result.append(')');
		return result.toString();
	}

} //ElementImpl
