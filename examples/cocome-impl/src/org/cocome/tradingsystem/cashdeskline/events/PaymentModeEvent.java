package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;

public class PaymentModeEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7394495671841623726L;

	private PaymentMode mode;

	public PaymentModeEvent(PaymentMode mode) {
		this.mode = mode;
	}

	public PaymentMode getMode() {
		return mode;
	}

}
