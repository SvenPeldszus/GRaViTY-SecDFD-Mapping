package org.cocome.tradingsystem.cashdeskline.cashdesk.scannercontroller;

import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeScannedEvent;

/**
 * @author Holger Klus
 */
public interface ScannerControllerEventHandlerIf {
	public void sendProductBarcodeScannedEvent(
			ProductBarcodeScannedEvent productBarcodeScannedEvent);
}
