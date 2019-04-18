package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

public class ProductBarcodeNotValidEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -354692220702852330L;

	private long barcode;

	public ProductBarcodeNotValidEvent(long barcode) {
		this.barcode = barcode;
	}

	public long getBarcode() {
		return barcode;
	}
}
