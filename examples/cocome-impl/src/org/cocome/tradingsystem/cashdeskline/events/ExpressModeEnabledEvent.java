package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the cashdesk coordinator component.
 * @author herold
 *
 */
public class ExpressModeEnabledEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6894844300001277997L;

	private String cashdesk;
	
	public ExpressModeEnabledEvent(String cashdesk) {
		this.cashdesk = cashdesk;
	}

	public String getCashdesk() {
		return cashdesk;
	}
}
