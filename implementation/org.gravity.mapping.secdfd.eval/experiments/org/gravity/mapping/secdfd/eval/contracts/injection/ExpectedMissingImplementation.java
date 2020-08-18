package org.gravity.mapping.secdfd.eval.contracts.injection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.gravity.mapping.secdfd.checks.impl.CryptoCheck;
import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.ResponsibilityType;

public class ExpectedMissingImplementation extends ExpectedError {

	private final List<String> inAssetNames;
	private final List<String> outAssetNames;

	public ExpectedMissingImplementation(Process process, ResponsibilityType type, List<Asset> inVal,
			List<Asset> outVal, String change) {
		super(process, type, inVal, outVal, change);
		inAssetNames = inVal.stream().map(Asset::getName).collect(Collectors.toList());
		outAssetNames = outVal.stream().map(Asset::getName).collect(Collectors.toList());
	}

	@Override
	public boolean isDetected(SResult result) {
		if(!process.equals(result.getDfdElement())){
			return false;
		}
		ResponsibilityType contractType = result.getType();
		switch (type) {
		case FORWARD:
		case JOINER:
			if ((contractType == ResponsibilityType.FORWARD || contractType == ResponsibilityType.JOINER)) {
				String description = result.getDescription();
				if (description.startsWith("No fwd or join contract specified but implemented:")) {
					return true;
				} else if (description.startsWith("The following FWD and JOIN contracts are not fulfilled:")) {
					String[] io = description.split("\"")[1].split("--\\[" + type.getLiteral() + "\\]-->");
					return checkAssets(inAssetNames, io[0]) && checkAssets(outAssetNames, io[1]);
				}
			}
			return false;
		case ENCRYPT_OR_HASH:
		case DECRYPT:
			if (contractType == type) {
				return CryptoCheck.createErrorMessage(type).equals(result.getDescription());
			}
			
		default:
			return false;
		}
	}

	/**
	 * @param expected
	 * @param assets
	 * @return
	 */
	private boolean checkAssets(List<String> expected, String assets) {
		String tmp = assets.trim();
		String[] assetsArray = tmp.substring(1, tmp.length() - 1).split(", *");
		return expected.size() == assetsArray.length && expected.containsAll(Arrays.asList(assetsArray));
	}

	@Override
	public String getDescription() {
		return "Expect missing implementation of contract: " + process.getName() + ": "
				+ PrintHelper.getStringRepresentation(in, Arrays.asList(type), out);
	}

}
