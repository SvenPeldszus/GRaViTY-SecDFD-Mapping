package org.gravity.mapping.secdfd.checks.implemented;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.secdfd.model.Asset;
import org.secdfd.model.Assumption;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;

public class ImplementedProcess implements Process {

	private final Process process;
	private final Set<ImplementedFlow> incoming;
	private final Set<ImplementedFlow> outgoing;

	public ImplementedProcess(Process process) {
		this.process = process;
		this.incoming = new HashSet<>();
		this.outgoing = new HashSet<>();
	}

	public void addIncoming(ImplementedFlow implementedFlow) {
		this.getIncomingFlows().add(implementedFlow);
	}

	public void addOutgoing(ImplementedFlow implementedFlow) {
		this.getOutgoingFlows().add(implementedFlow);
	}

	@Override
	public EList<Flow> getOutflows() {
		return this.process.getOutflows();
	}

	@Override
	public EList<Assumption> getAssumption() {
		return this.process.getAssumption();
	}

	@Override
	public EList<Asset> getAssets() {
		return this.process.getAssets();
	}

	@Override
	public EList<Flow> getInflows() {
		return this.process.getInflows();
	}

	@Override
	public boolean isAttacker() {
		return this.process.isAttacker();
	}

	@Override
	public void setAttacker(boolean value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");
	}

	@Override
	public String getName() {
		return this.process.getName();
	}

	@Override
	public void setName(String value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public int getNumber() {
		return this.process.getNumber();
	}

	@Override
	public void setNumber(int value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public EClass eClass() {
		return this.process.eClass();
	}

	@Override
	public Resource eResource() {
		return this.process.eResource();
	}

	@Override
	public EObject eContainer() {
		return this.process.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return this.process.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return this.process.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return this.process.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return this.process.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return this.process.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return this.process.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return this.process.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return this.process.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return this.process.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return this.process.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return this.process.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return this.process.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");
	}

	@Override
	public void eNotify(Notification notification) {
		this.process.eNotify(notification);
	}

	@Override
	public EList<Responsibility> getResponsibility() {
		return this.process.getResponsibility();
	}

	@Override
	public boolean equals(Object obj) {
		return process.equals(obj);
	}

	@Override
	public int hashCode() {
		return process.hashCode();
	}

	/**
	 * @return the outgoing
	 */
	public Set<ImplementedFlow> getOutgoingFlows() {
		return outgoing;
	}

	/**
	 * @return the incoming
	 */
	public Set<ImplementedFlow> getIncomingFlows() {
		return incoming;
	}
}