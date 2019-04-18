package org.cocome.tradingsystem.cashdeskline.cashdesk.lightdisplaycontroller;

import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;

/**
 * This interface defines event handlers related to switching between express
 * mode and normal mode.
 * 
 * @author Holger Klus
 * 
 */
public interface LightDisplayControllerEventHandlerIf {
	void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent);

	void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent);
}
