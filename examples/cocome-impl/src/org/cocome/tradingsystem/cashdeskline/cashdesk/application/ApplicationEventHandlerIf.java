package org.cocome.tradingsystem.cashdeskline.cashdesk.application;

import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PINEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.PaymentModeEvent;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;

/**
 * This interface defines event handlers for event related to all kinds of
 * topics which are important for the application component of the cash desk.
 * 
 * @author Holger Klus
 * 
 */
public interface ApplicationEventHandlerIf {
	/**
	 * Event handler for SaleStartedEvent events.
	 */
	public void onEvent(SaleStartedEvent saleStartedEvent);

	/**
	 * Event handler for ProductBarcodeScannedEvent events.
	 */
	public void onEvent(ProductBarcodeScannedEvent productBarcodeScannedEvent);

	/**
	 * Event handler for SaleFinishedEvent events.
	 */
	public void onEvent(SaleFinishedEvent saleFinishedEvent);

	/**
	 * Event handler for CashAmountEnteredEvent events.
	 */
	public void onEvent(CashAmountEnteredEvent moneyAmountEnteredEvent);

	/**
	 * Event handler for CashBoxClosedEvent events.
	 */
	public void onEvent(CashBoxClosedEvent cashBoxClosedEvent);

	/**
	 * Event handler for CreditCardScannedEvent events.
	 */
	public void onEvent(CreditCardScannedEvent creditCardScannedEvent);

	/**
	 * Event handler for PINEnteredEvent events.
	 */
	public void onEvent(PINEnteredEvent pinEnteredEvent);

	/**
	 * Event handler for ExpressModeEnabledEvent events.
	 */
	public void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent);

	/**
	 * Event handler for ExpressModeEnabledEvent events.
	 */
	public void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent);
	
	/**
	 * Event handler for PaymentModeEvent events.
	 */
	public void onEvent(PaymentModeEvent paymentModeEvent);
}
