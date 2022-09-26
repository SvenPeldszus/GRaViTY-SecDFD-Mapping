package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

/**
 * This event is raised by the scanner controller component after the barcode
 * scanner read a barcode.
 * 
 * @author herold
 * 
 */
public class ProductBarcodeScannedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1603344911255933167L;

	private long scannedBarcode;

	public ProductBarcodeScannedEvent(long scannedBarcode) {
		this.scannedBarcode = scannedBarcode;
	}

	public long getScannedBarcode() {
		return scannedBarcode;
	}
}
