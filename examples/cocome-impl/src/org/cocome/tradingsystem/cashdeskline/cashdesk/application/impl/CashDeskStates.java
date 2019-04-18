package org.cocome.tradingsystem.cashdeskline.cashdesk.application.impl;

/**
 * Description of the states the ApplicationEventHandler can be in
 * @author Yannick Welsch
 */
public enum CashDeskStates {
	/**
	 * Initial state
	 */
	INITIALIZED,
	/**
	 * After a sale has started (New Sale button pushed)
	 */
	SALE_STARTED,
	/**
	 * After a sale has finished (All products have been scanned)
	 * and Finish Sale button pushed
	 */
	SALE_FINISHED,
	/**
	 * After the selection for credit card payment was made
	 */
	PAYING_BY_CREDITCARD,
	/**
	 * After the credit card was scanned
	 */
	CREDIT_CARD_SCANNED,
	/**
	 * After the selection for cash payment was made
	 */
	PAYING_BY_CASH,
	/**
	 * After the payment per cash
	 */
	PAID
}
