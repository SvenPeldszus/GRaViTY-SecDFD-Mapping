package org.gravity.mapping.secdfd.eval.contracts.injection;

import java.util.List;

import org.secdfd.dsl.validation.SResult;
import org.secdfd.model.Asset;
import org.secdfd.model.Process;
import org.secdfd.model.ResponsibilityType;

public abstract class ExpectedError {

	protected Process process;
	protected ResponsibilityType type;
	protected List<Asset> in;
	protected List<Asset> out;
	private String change;

	public ExpectedError(Process process, ResponsibilityType type, List<Asset> inVal, List<Asset> outVal,
			String change) {
		this.process = process;
		this.type = type;
		this.in = inVal;
		this.out = outVal;
		this.change = change;
	}

	public abstract boolean isDetected(SResult result);

	public abstract String getDescription();

	public String getChange() {
		return this.change;
	}

}
