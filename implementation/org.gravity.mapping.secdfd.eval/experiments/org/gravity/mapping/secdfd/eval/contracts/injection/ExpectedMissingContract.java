package org.gravity.mapping.secdfd.eval.contracts.injection;

import java.util.Arrays;
import java.util.List;

import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.ResponsibilityType;

public class ExpectedMissingContract extends ExpectedError {

	
	public ExpectedMissingContract(Process process, ResponsibilityType type, List<Asset> inVal, List<Asset> outVal, String change) {
		super(process, type, inVal, outVal, change);
	}

	@Override
	public boolean isDetected(SResult result) {
		switch (type) {
		case FORWARD:
		case JOINER:
			if (process.equals(result.getDfdElement())) {
				return result.getDescription().startsWith("No fwd or join contract specified but implemented:");
			}
			return false;
		case ENCRYPT_OR_HASH:
		case DECRYPT:
			throw new UnsupportedOperationException();
		default:
			return false;
		}
	}

	@Override
	public String getDescription() {
		return "Expect missing contract in DFD: "+process.getName()+": "+PrintHelper.getStringRepresentation(in, Arrays.asList(type), out);
	}

}
