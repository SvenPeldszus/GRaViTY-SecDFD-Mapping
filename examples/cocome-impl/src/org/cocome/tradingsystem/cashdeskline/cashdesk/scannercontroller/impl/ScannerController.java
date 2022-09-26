package org.cocome.tradingsystem.cashdeskline.cashdesk.scannercontroller.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeScannedEvent;

/**
 * GUI for the ScannerController component
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class ScannerController extends JPanel {

	private ScannerControllerEventHandlerImpl scannerController;
		
	public ScannerController(String eventchannel) {
		super(new BorderLayout());
		scannerController = new ScannerControllerEventHandlerImpl(eventchannel);
		
		add(new JLabel("Enter barcode number which is scanned and press 'Scan Item'"), BorderLayout.NORTH);
		final JTextField field = new JTextField();
		add(field, BorderLayout.CENTER);
		JButton btnScanItem = new JButton("Scan Item");
		add(btnScanItem, BorderLayout.SOUTH);
		
		btnScanItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String text = field.getText();
				try {
					long barcode = Long.parseLong(text);
					scannerController.sendProductBarcodeScannedEvent(new ProductBarcodeScannedEvent(barcode));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
