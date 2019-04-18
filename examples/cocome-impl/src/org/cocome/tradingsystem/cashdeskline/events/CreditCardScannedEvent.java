package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the scanner controller after successfully scanning a
 * credit card. The contained information has to be defined by the external
 * banking component.
 * 
 * @author herold
 * 
 */
public class CreditCardScannedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143156662313299874L;

	// The type of creditCardInformation could be defined in more detail;
	// a corresponding data type should be provided by the banking component.
	private String creditCardInformation;

	public CreditCardScannedEvent(String creditCardInformation) {
		this.creditCardInformation = creditCardInformation;
	}

	public String getCreditCardInformation() {
		return creditCardInformation;
	}
}
