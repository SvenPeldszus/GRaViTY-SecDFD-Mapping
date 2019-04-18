package org.cocome.tradingsystem.cashdeskline.events;

import java.io.Serializable;

public class ProductBarcodeScanEnvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5821305367377342325L;

	private int scannedBarcode;

	public ProductBarcodeScanEnvent(int scannedBarcode) {
		this.scannedBarcode = scannedBarcode;
	}

	public int getScannedBarcode() {
		return scannedBarcode;
	}
}
