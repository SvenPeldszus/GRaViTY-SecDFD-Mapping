package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the cashbox controller component after the cashier
 * signals the beginning of a sale process (by hitting a key).
 * 
 */
public class SaleStartedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961207092223934936L;

	public SaleStartedEvent() {

	}
}
