package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the credit card reader component after entering a
 * PIN.
 * 
 */
public class PINEnteredEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89778823632347027L;

	private int PIN;

	public PINEnteredEvent(int pin) {
		this.PIN = pin;
	}

	public int getPIN() {
		return PIN;
	}
}
