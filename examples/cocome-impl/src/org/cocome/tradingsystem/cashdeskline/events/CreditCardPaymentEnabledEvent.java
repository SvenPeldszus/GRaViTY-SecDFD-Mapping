package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the cash box controller component when cashier presses button to activate
 * credit card payment.
 * @author herold
 *
 */
public class CreditCardPaymentEnabledEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 825223758213963922L;

	public CreditCardPaymentEnabledEvent() {}
}
