package org.cocome.tradingsystem.cashdeskline.coordinator.impl;

import java.util.Date;

import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;

/**
 * Helper class to keep track of the sales
 * @author Yannick Welsch
 */
public class Sale {
	private int numberofItems;
	private PaymentMode paymentmode;
	private Date timeofSale;
	
	protected Sale(int numberofItems, PaymentMode paymentmode, Date timeofSale) {
		this.numberofItems = numberofItems;
		this.paymentmode = paymentmode;
		this.timeofSale = timeofSale;
	}

	public int getNumberofItems() {
		return numberofItems;
	}

	public PaymentMode getPaymentmode() {
		return paymentmode;
	}

	public Date getTimeofSale() {
		return timeofSale;
	}
}
