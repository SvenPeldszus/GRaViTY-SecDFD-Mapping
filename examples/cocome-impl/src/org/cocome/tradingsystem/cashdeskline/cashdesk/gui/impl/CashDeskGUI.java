package org.cocome.tradingsystem.cashdeskline.cashdesk.gui.impl;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cocome.tradingsystem.cashdeskline.events.CreditCardScanFailedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.InvalidCreditCardEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;

/**
 * GUI for the CashDeskGUI component
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class CashDeskGUI extends JPanel {
	private final JLabel field;

	public CashDeskGUI(String eventchannel) {
		super();
		double size[][] = { { TableLayout.MINIMUM, TableLayout.MINIMUM }, // Columns
				{ TableLayout.PREFERRED, TableLayout.PREFERRED } }; // Rows
		setLayout(new TableLayout(size));
		field = new JLabel(
				"No product barcode has been entered yet                             ");
		add(field, "0, 1");
		new GUIEventHandlerImpl(eventchannel, this);
	}

	public void updateProductInfo(String productname, double price,
			double runningTotal) {
		field.setText(productname + ": " + price + " Total: " + runningTotal);
		field.setForeground(Color.BLACK);
	}

	public void setBarcodeNotValid(long barcode) {
		field.setText("Barcode '" + barcode + "' is not valid");
		field.setForeground(Color.RED);
	}

	public void setCashAmount(double amount) {
		field.setText("Change amount :" + amount + "");
		field.setForeground(Color.BLACK);
	}

	public void onFinished(SaleSuccessEvent saleSuccessEvent) {
		field.setText("Have a nice day");
		field.setForeground(Color.BLUE);
	}

	public void onStarted(SaleStartedEvent saleStartedEvent) {
		field.setText("New sale");
		field.setForeground(Color.BLUE);
	}

	public void onInvalidCreditCard(
			InvalidCreditCardEvent invalidCreditCardEvent) {
		field.setText("Invalid Credit Card information");
		field.setForeground(Color.RED);
	}

	public void onCreditCardScanFailed(
			CreditCardScanFailedEvent creditCardScanFailedEvent) {
		field.setText("Credit Card Scan failed");
		field.setForeground(Color.RED);
	}

	public void onExpressModeDisabledEvent(
			ExpressModeDisabledEvent expressModeDisabledEvent) {
		field.setText("Express mode disabled");
		field.setForeground(Color.BLUE);
	}

	public void onExpressModeEnabledEvent(
			ExpressModeEnabledEvent expressModeEnabledEvent) {
		field.setText("Express mode enabled");
		field.setForeground(Color.BLUE);
	}
}