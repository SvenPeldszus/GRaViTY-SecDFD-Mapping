package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

public class CreditCardScanEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1641242396544822553L;

	// The type of creditCardInformation could be defined in more detail;
	// a corresponding data type should be provided by the banking component.
	private String creditCardInformation;

	public CreditCardScanEvent(String creditCardInformation) {
		this.creditCardInformation = creditCardInformation;
	}

	public String getCreditCardInformation() {
		return creditCardInformation;
	}
}
