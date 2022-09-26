package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the cashdesk application component after another item
 * has been scanned, identified and internally added to the current sale. It
 * contains information about the current item, its price and the running total.
 * 
 */
public class RunningTotalChangedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -300914931510566066L;

	private String productName;

	private double productPrice;

	private double runningTotal;

	public RunningTotalChangedEvent(String productName, double productPrice,
			double runningTotal) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.runningTotal = runningTotal;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public double getRunningTotal() {
		return runningTotal;
	}
}
