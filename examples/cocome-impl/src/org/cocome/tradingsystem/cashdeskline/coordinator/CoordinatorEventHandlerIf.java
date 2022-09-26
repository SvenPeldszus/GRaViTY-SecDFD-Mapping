package org.cocome.tradingsystem.cashdeskline.coordinator;

import org.cocome.tradingsystem.cashdeskline.events.SaleRegisteredEvent;

/**
 * This interface defines an event handler for event related to the cash desk
 * coordination task.
 * 
 * @author Holger Klus
 * 
 */
public interface CoordinatorEventHandlerIf {
	public void onEvent(SaleRegisteredEvent saleRegisteredEvent);
}
