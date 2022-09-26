package org.gravity.mapping.secdfd.ui.views.actions;

import java.io.IOException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.jface.action.Action;
import org.gravity.mapping.secdfd.checks.ContractCheckExecution;
import org.gravity.mapping.secdfd.ui.views.MappingView;

public class CheckContractsAction extends Action {
	private final MappingView mappingView;

	public CheckContractsAction(MappingView mappingView) {
		super("Check process contracts");
		this.mappingView = mappingView;
	}

	@Override
	public void run() {
		try {
			new Job("Check Contracts") {
				final ContractCheckExecution checker = new ContractCheckExecution(mappingView.getGravityFolder(), mappingView.getProgramModel().getValue(),
						mappingView.getMappers().values(), "encrypt-signatures.txt", "decrypt-signatures.txt");

				@Override
				protected IStatus run(IProgressMonitor monitor) {
			        SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
					
					checkEncrypt(subMonitor.split(10));
					checkDecrypt(subMonitor.split(10));
					
					checkDataFlow(subMonitor.split(60));

					checkFwdJoin(subMonitor.split(20));
					
					return Status.OK_STATUS;
				}

				/**
				 * @param monitor
				 */
				private void checkFwdJoin(IProgressMonitor monitor) {
					SubMonitor sub = SubMonitor.convert(monitor, "Check fwd and join contracts", 1);
					checker.checkForwardAndJoinContract();
					// PlatformUI.getWorkbench().getDisplay().asyncExec(mappingView::update);
					sub.done();
				}

				/**
				 * @param monitor
				 */
				private void checkDecrypt(IProgressMonitor monitor) {
					SubMonitor sub = SubMonitor.convert(monitor, "Check decrypt contracts", 1);
					checker.checkDecryptContract();
					// PlatformUI.getWorkbench().getDisplay().asyncExec(mappingView::update);
					sub.done();
				}

				/**
				 * @param monitor
				 */
				private void checkDataFlow(IProgressMonitor monitor) {
					SubMonitor	sub = SubMonitor.convert(monitor, "Check data flow", 1);
					// set default to 10
					checker.runDataFlowAnalyzer(10);
					// PlatformUI.getWorkbench().getDisplay().asyncExec(mappingView::update);
					sub.done();
				}

				/**
				 * @param monitor
				 */
				private void checkEncrypt(IProgressMonitor monitor) {
					SubMonitor sub = SubMonitor.convert(monitor, "Check encrypt contracts", 1);
					checker.checkEncryptContract();
					// PlatformUI.getWorkbench().getDisplay().asyncExec(mappingView::update);
					sub.done();
				}
			}.schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
