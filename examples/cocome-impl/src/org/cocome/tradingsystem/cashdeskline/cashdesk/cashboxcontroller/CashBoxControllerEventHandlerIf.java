package org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller;

import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PaymentModeEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;

/**
 * This interface defines an event handler for events related to the cash box.
 * 
 * @author Holger Klus
 */
public interface CashBoxControllerEventHandlerIf {
	void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent);

	void sendSaleStartedEvent(SaleStartedEvent saleStartedEvent);

	void sendSaleFinishedEvent(SaleFinishedEvent saleFinishedEvent);

	void sendPaymentModeEvent(PaymentModeEvent paymentModeEvent);

	void sendCashAmountEnteredEvent(
			CashAmountEnteredEvent cashAmountEnteredEvent);

	void sendCashBoxClosedEvent(CashBoxClosedEvent cashBoxClosedEvent);

	void sendExpressModeDisabledEvent(
			ExpressModeDisabledEvent expressModeDisabledEvent);
}
