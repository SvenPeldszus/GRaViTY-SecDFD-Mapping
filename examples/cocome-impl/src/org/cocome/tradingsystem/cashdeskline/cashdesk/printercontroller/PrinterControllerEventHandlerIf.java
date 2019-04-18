package org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller;

import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;

/**
 * This interface defines event handlers related to printer-relevant topics
 * during process sale
 * 
 * @author Holger Klus
 * 
 */
public interface PrinterControllerEventHandlerIf {
	void onEvent(RunningTotalChangedEvent runningTotalChangedEvent);

	void onEvent(CashAmountEnteredEvent cashAmountEnteredEvent);

	void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent);

	void onEvent(SaleStartedEvent saleStartedEvent);

	void onEvent(SaleFinishedEvent saleFinishedEvent);

	void onEvent(CashBoxClosedEvent cashBoxClosedEvent);

	void onEvent(SaleSuccessEvent saleSuccessEvent);
}
