/**
 */
package eDFDFlowTracking.impl;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.Assumption;
import eDFDFlowTracking.AttackerProfile;
import eDFDFlowTracking.Channel;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTracking1Factory;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.ExternalEntity;
import eDFDFlowTracking.Flow;
import eDFDFlowTracking.Layer;
import eDFDFlowTracking.Objective;
import eDFDFlowTracking.Priority;
import eDFDFlowTracking.Responsibility;
import eDFDFlowTracking.ResponsibilityType;
import eDFDFlowTracking.TrustZone;
import eDFDFlowTracking.Value;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EDFDFlowTracking1FactoryImpl extends EFactoryImpl implements EDFDFlowTracking1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EDFDFlowTracking1Factory init() {
		try {
			EDFDFlowTracking1Factory theEDFDFlowTracking1Factory = (EDFDFlowTracking1Factory)EPackage.Registry.INSTANCE.getEFactory(EDFDFlowTracking1Package.eNS_URI);
			if (theEDFDFlowTracking1Factory != null) {
				return theEDFDFlowTracking1Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EDFDFlowTracking1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDFDFlowTracking1FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EDFDFlowTracking1Package.ASSET: return createAsset();
			case EDFDFlowTracking1Package.PROCESS: return createProcess();
			case EDFDFlowTracking1Package.EDFD: return createEDFD();
			case EDFDFlowTracking1Package.DATA_STORE: return createDataStore();
			case EDFDFlowTracking1Package.FLOW: return createFlow();
			case EDFDFlowTracking1Package.EXTERNAL_ENTITY: return createExternalEntity();
			case EDFDFlowTracking1Package.VALUE: return createValue();
			case EDFDFlowTracking1Package.ASSUMPTION: return createAssumption();
			case EDFDFlowTracking1Package.ATTACKER_PROFILE: return createAttackerProfile();
			case EDFDFlowTracking1Package.TRUST_ZONE: return createTrustZone();
			case EDFDFlowTracking1Package.RESPONSIBILITY: return createResponsibility();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EDFDFlowTracking1Package.PRIORITY:
				return createPriorityFromString(eDataType, initialValue);
			case EDFDFlowTracking1Package.CHANNEL:
				return createChannelFromString(eDataType, initialValue);
			case EDFDFlowTracking1Package.RESPONSIBILITY_TYPE:
				return createResponsibilityTypeFromString(eDataType, initialValue);
			case EDFDFlowTracking1Package.OBJECTIVE:
				return createObjectiveFromString(eDataType, initialValue);
			case EDFDFlowTracking1Package.LAYER:
				return createLayerFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EDFDFlowTracking1Package.PRIORITY:
				return convertPriorityToString(eDataType, instanceValue);
			case EDFDFlowTracking1Package.CHANNEL:
				return convertChannelToString(eDataType, instanceValue);
			case EDFDFlowTracking1Package.RESPONSIBILITY_TYPE:
				return convertResponsibilityTypeToString(eDataType, instanceValue);
			case EDFDFlowTracking1Package.OBJECTIVE:
				return convertObjectiveToString(eDataType, instanceValue);
			case EDFDFlowTracking1Package.LAYER:
				return convertLayerToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Asset createAsset() {
		AssetImpl asset = new AssetImpl();
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public eDFDFlowTracking.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDFD createEDFD() {
		EDFDImpl edfd = new EDFDImpl();
		return edfd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataStore createDataStore() {
		DataStoreImpl dataStore = new DataStoreImpl();
		return dataStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Flow createFlow() {
		FlowImpl flow = new FlowImpl();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalEntity createExternalEntity() {
		ExternalEntityImpl externalEntity = new ExternalEntityImpl();
		return externalEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Assumption createAssumption() {
		AssumptionImpl assumption = new AssumptionImpl();
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttackerProfile createAttackerProfile() {
		AttackerProfileImpl attackerProfile = new AttackerProfileImpl();
		return attackerProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TrustZone createTrustZone() {
		TrustZoneImpl trustZone = new TrustZoneImpl();
		return trustZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Responsibility createResponsibility() {
		ResponsibilityImpl responsibility = new ResponsibilityImpl();
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriorityFromString(EDataType eDataType, String initialValue) {
		Priority result = Priority.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Channel createChannelFromString(EDataType eDataType, String initialValue) {
		Channel result = Channel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChannelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityType createResponsibilityTypeFromString(EDataType eDataType, String initialValue) {
		ResponsibilityType result = ResponsibilityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResponsibilityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Objective createObjectiveFromString(EDataType eDataType, String initialValue) {
		Objective result = Objective.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectiveToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer createLayerFromString(EDataType eDataType, String initialValue) {
		Layer result = Layer.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayerToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDFDFlowTracking1Package getEDFDFlowTracking1Package() {
		return (EDFDFlowTracking1Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EDFDFlowTracking1Package getPackage() {
		return EDFDFlowTracking1Package.eINSTANCE;
	}

} //EDFDFlowTracking1FactoryImpl
