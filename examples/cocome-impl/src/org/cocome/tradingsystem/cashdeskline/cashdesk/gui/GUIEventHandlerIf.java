package org.cocome.tradingsystem.cashdeskline.cashdesk.gui;

import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScanFailedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.InvalidCreditCardEvent;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeNotValidEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;

/**
 * This interface defines event handlers related to the Store at the cash desk
 * 
 * @author Holger Klus
 */
public interface GUIEventHandlerIf {
	void onEvent(RunningTotalChangedEvent runningTotalChangedEvent);

	void onEvent(CashAmountEnteredEvent moneyAmountEnteredEvent);

	void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent);

	void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent);

	void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent);

	void onEvent(InvalidCreditCardEvent invalidCreditCardEvent);

	void onEvent(CreditCardScanFailedEvent creditCardScanFailedEvent);

	void onEvent(ProductBarcodeNotValidEvent productBarcodeNotValidEvent);

	void onEvent(SaleSuccessEvent saleSuccessEvent);

	void onEvent(SaleStartedEvent saleStartedEvent);
}
