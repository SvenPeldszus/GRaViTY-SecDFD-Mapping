package org.gravity.mapping.secdfd.ui.views.actions;

import java.io.IOException;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;
import org.gravity.mapping.secdfd.checks.ContractCheck;
import org.gravity.mapping.secdfd.ui.views.MappingView;
import org.gravity.typegraph.basic.BasicFactory;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TCall;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TypeGraph;

public class CheckContractsAction extends Action {
	private final MappingView mappingView;

	public CheckContractsAction(MappingView mappingView) {
		super("Check process contracts");
		this.mappingView = mappingView;
	}

	public void run() {
		try {
			ContractCheck checker = new ContractCheck(mappingView.getGravityFolder(),
					mappingView.getProgramModel().getValue(), mappingView.getMappers().values(),
					"encrypt-signatures.txt", "decrypt-signatures.txt");

//			TypeGraph pm = mappingView.getProgramModel().getValue();
//			TMember getDefault = pm.getDefinition(
//					"org.eclipse.equinox.security.storage.SecurePreferencesFactory.getDefault():ISecurePreferences");
//			TMember node = pm.getDefinition(
//					"org.eclipse.equinox.security.storage.ISecurePreferences.node(java.lang.String):ISecurePreferences");
//			TMember get = pm.getDefinition(
//					"org.eclipse.equinox.security.storage.ISecurePreferences.get(java.lang.String,java.lang.String):java.lang.String");
//
//			TMethod method = BasicFactory.eINSTANCE.createTMethod();
//			TMethodSignature signature = BasicFactory.eINSTANCE.createTMethodSignature();
//			TMethodDefinition definiton = BasicFactory.eINSTANCE.createTMethodDefinition();
//
//			method.setTName("dummyRead");
//			signature.setMethod(method);
//			definiton.setSignature(signature);
//
//			TCall callGetDefault = BasicFactory.eINSTANCE.createTCall();
//			callGetDefault.setTSource(definiton);
//			callGetDefault.setTTarget(getDefault);
//
//			TCall callNode = BasicFactory.eINSTANCE.createTCall();
//			callNode.setTSource(definiton);
//			callNode.setTTarget(node);
//
//			TCall callGet = BasicFactory.eINSTANCE.createTCall();
//			callGet.setTSource(definiton);
//			callGet.setTTarget(get);
//
//			createFlow(callGetDefault, getDefault.getSignature(), callNode);
//			createFlow(callNode, node.getSignature(), callGet);
//			createFlow(callGet, get.getSignature(), definiton);

			new Job("Check Contracts") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						SubMonitor sub = SubMonitor.convert(monitor, "Check encrypt contracts", 1);
						checker.checkEncryptContract();
						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								mappingView.update();
							}
						});
						sub.done();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						SubMonitor sub = SubMonitor.convert(monitor, "Check decrypt contracts", 1);
						checker.checkDecryptContract();
						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								mappingView.update();
							}
						});
						sub.done();
					} catch (IOException e) {
						e.printStackTrace();
					}
					SubMonitor sub = SubMonitor.convert(monitor, "Check fwd and join contracts", 1);
					checker.checkForwardAndJoinContract();
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							mappingView.update();
						}
					});
					sub.done();
					return Status.OK_STATUS;
				}
			}.schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param owner
	 * @param src
	 * @param trg
	 */
	private void createFlow(TAbstractFlowElement owner, TAbstractFlowElement src, TAbstractFlowElement trg) {
		TFlow f0 = BasicFactory.eINSTANCE.createTFlow();
		f0.setFlowOwner(src);
		f0.getIncomingFlows().add(owner);
		owner.getOutgoingFlows().add(f0);
		f0.getOutgoingFlows().add(trg);
		trg.getIncomingFlows().add(f0);
	}
}