package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

import org.cocome.tradingsystem.inventory.application.store.SaleTO;

/**
 * 
 * @author Yannick Welsch
 */
public class AccountSaleEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5441935251526952790L;

	private SaleTO sale;

	public AccountSaleEvent(SaleTO sale) {
		this.sale = sale;
	}

	public SaleTO getSale() {
		return sale;
	}
}
