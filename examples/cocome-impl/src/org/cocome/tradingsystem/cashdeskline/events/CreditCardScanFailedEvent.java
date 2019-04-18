package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the credit card reader controller if the scan of a
 * credit card failed.
 * 
 * @author herold
 * 
 */
public class CreditCardScanFailedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2407849186409109443L;

	public CreditCardScanFailedEvent() {}
}
