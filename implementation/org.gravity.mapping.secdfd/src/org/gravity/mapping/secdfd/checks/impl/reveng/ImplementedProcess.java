package org.gravity.mapping.secdfd.checks.impl.reveng;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
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
import org.secdfd.model.Element;
import org.secdfd.model.Flow;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;

public class ImplementedProcess implements Process {

	private final Element process;
	private final Set<ImplementedFlow> incoming;
	private final Set<ImplementedFlow> outgoing;

	public ImplementedProcess(Element process) {
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
		return this.getUnderlyingProcess().getOutflows();
	}

	@Override
	public EList<Assumption> getAssumption() {
		return this.getUnderlyingProcess().getAssumption();
	}

	@Override
	public EList<Asset> getAssets() {
		return this.getUnderlyingProcess().getAssets();
	}

	@Override
	public EList<Flow> getInflows() {
		return this.getUnderlyingProcess().getInflows();
	}

	@Override
	public boolean isAttacker() {
		return this.getUnderlyingProcess().isAttacker();
	}

	@Override
	public void setAttacker(boolean value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");
	}

	@Override
	public String getName() {
		return this.getUnderlyingProcess().getName();
	}

	@Override
	public void setName(String value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public int getNumber() {
		return this.getUnderlyingProcess().getNumber();
	}

	@Override
	public void setNumber(int value) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public EClass eClass() {
		return this.getUnderlyingProcess().eClass();
	}

	@Override
	public Resource eResource() {
		return this.getUnderlyingProcess().eResource();
	}

	@Override
	public EObject eContainer() {
		return this.getUnderlyingProcess().eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return this.getUnderlyingProcess().eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return this.getUnderlyingProcess().eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return this.getUnderlyingProcess().eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return this.getUnderlyingProcess().eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return this.getUnderlyingProcess().eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return this.getUnderlyingProcess().eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return this.getUnderlyingProcess().eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return this.getUnderlyingProcess().eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return this.getUnderlyingProcess().eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");

	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return this.getUnderlyingProcess().eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return this.getUnderlyingProcess().eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return this.getUnderlyingProcess().eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new UnsupportedOperationException("Changing the wrapped object is not allowed!");
	}

	@Override
	public void eNotify(Notification notification) {
		this.getUnderlyingProcess().eNotify(notification);
	}

	@Override
	public EList<Responsibility> getResponsibility() {
		if(process instanceof Process) {
			return ((Process) this.getUnderlyingProcess()).getResponsibility();
		}
		return new BasicEList<>(0);
	}

	@Override
	public boolean equals(Object obj) {
		return getUnderlyingProcess().equals(obj);
	}

	@Override
	public int hashCode() {
		return getUnderlyingProcess().hashCode();
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

	/**
	 * @return the process
	 */
	public Element getUnderlyingProcess() {
		return process;
	}
}