package org.gravity.mapping.secdfd.eval.contracts;

import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.gravity.mapping.secdfd.checks.impl.FwdJoinCheck;
import org.gravity.mapping.secdfd.eval.contracts.injection.ChangeInjector;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.model.ResponsibilityType;

public class EvalFwdJoinContracts extends AbstractContractEvaluator {
	
	private static final boolean DELETE = false;

	public EvalFwdJoinContracts(String testName, Mapper mapper, Map<String, List<Map<String, String>>> absenceGT,
			Map<String, List<Map<String, String>>> convergenceGT) throws CoreException {
		super(testName, new FwdJoinCheck(), mapper, new ChangeInjector(mapper.getDFD(), DELETE, true, ResponsibilityType.FORWARD,
				ResponsibilityType.JOINER));
	}
}
