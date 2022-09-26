package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the cashdesk application component after an unsuccessful attempt
 * to validate a credit card by the banking component.
 *
 */
public class InvalidCreditCardEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2910273526834186955L;

	public InvalidCreditCardEvent() {}
}
