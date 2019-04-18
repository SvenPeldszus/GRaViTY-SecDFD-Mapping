package org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller;

import org.cocome.tradingsystem.cashdeskline.events.CreditCardScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PINEnteredEvent;

/**
 * This interface defines an event handler for events related to card reader
 * controller.
 * @author Holger Klus
 */
public interface CardReaderControllerEventHandlerIf {
	void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent);
	
	void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent);

	void sendPINEnteredEvent(PINEnteredEvent pINEnteredEvent);

	void sendCreditCardScannedEvent(
			CreditCardScannedEvent creditCardScannedEvent);
}
