package org.gravity.mapping.secdfd.eval.contracts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.gravity.mapping.secdfd.checks.impl.CryptoCheck;
import org.gravity.mapping.secdfd.eval.contracts.injection.ChangeInjector;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.model.ResponsibilityType;

public class EvalCryptoContracts extends AbstractContractEvaluator {

	public EvalCryptoContracts(String testName, Mapper mapper, Map<String, List<Map<String, String>>> absenceGT,
			Map<String, List<Map<String, String>>> convergenceGT) throws CoreException, IOException {
		super(testName, new CryptoCheck(mapper), mapper,
				new ChangeInjector(mapper.getDFD(), false, true, ResponsibilityType.ENCRYPT_OR_HASH, ResponsibilityType.DECRYPT));
	}

}
