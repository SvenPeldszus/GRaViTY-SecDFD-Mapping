package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;

/**
 * This event is raised by the cashdesk application component when a sale is
 * finished and registered in the inventory. It contains statistical information
 * about the sale (number of items, mode of payment).
 * 
 */

public class SaleRegisteredEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6202472706841986582L;

	private int numberOfItems;

	private PaymentMode paymentMode;
	
	private String cashdesk;

	public SaleRegisteredEvent(String cashdesk, int numberOfItems, PaymentMode paymentMode) {
		this.numberOfItems = numberOfItems;
		this.paymentMode = paymentMode;
		this.cashdesk = cashdesk;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public String getCashdesk() {
		return cashdesk;
	}
}
