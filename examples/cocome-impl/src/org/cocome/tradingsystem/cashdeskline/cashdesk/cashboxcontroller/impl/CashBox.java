package org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller.impl;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller.CashBoxControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.datatypes.KeyStroke;
import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;
import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PaymentModeEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;


/**
 * GUI for the CashBox component
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class CashBox extends JPanel {
	
	private CashBoxControllerEventHandlerIf cashBoxControllerEventHandler;
	private JLabel cashbox;
	
	public CashBox(String eventchannel) {
		super();
		double size[][] =
        {{0.25, 0.25, 0.25, 0.25}, // Columns
         {TableLayout.PREFERRED, TableLayout.PREFERRED, 
        	TableLayout.PREFERRED, TableLayout.PREFERRED}}; // Rows
		setLayout(new TableLayout(size));
		
		JButton btnStartNewSale = new JButton("Start New Sale");
		JButton btnSaleFinished = new JButton("Sale Finished");
		JButton btnBarPayment = new JButton("Bar Payment");
		JButton btnCardPayment = new JButton("Card Payment");
		JButton btnExpressMode = new JButton("Disable ExpressMode");
		
		// Add the tabbed pane to this panel.
		add(btnStartNewSale, "0, 0");
		add(btnSaleFinished, "1, 0");
		add(btnBarPayment, "2, 0");
		add(btnCardPayment, "3, 0");
		add(btnExpressMode, "2, 2");
		
		JPanel numpad = new JPanel();
		numpad.setLayout(new TableLayout(size));
		for (int i = 0; i <= 9; i++) {
			final JButton b = new JButton("" + i);
			if (i == 0) {
				numpad.add(b, "0, 3");
			} else {
				String xloc = ((i - 1) % 3) + "";
				String yloc = (2 - ((i - 1) / 3)) + "";
				numpad.add(b, xloc + ", " + yloc);
			}
			addListenerToButton(b);
		}
		final JButton bComma = new JButton(".");
		addListenerToButton(bComma);
		numpad.add(bComma, "1, 3");
		
		final JButton bEnter = new JButton("ENTER");
		addListenerToButton(bEnter);
		numpad.add(bEnter, "2, 3");
		
		add(numpad, "0, 1, 2, 1");
		
		cashbox = new JLabel("cashbox closed");
		add(cashbox, "0, 2, 2, 2");
		
		final JButton bclose = new JButton("Close CashBox");
		add(bclose, "3, 2");
		
		bclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendCashBoxClosedEvent(new CashBoxClosedEvent());
				closeCashBox();
			}
		});
		
		btnStartNewSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendSaleStartedEvent(new SaleStartedEvent());
			}
		});
		
		btnSaleFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendSaleFinishedEvent(new SaleFinishedEvent());
			}
		});
		
		btnBarPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendPaymentModeEvent(new PaymentModeEvent(PaymentMode.CASH));
			}
		});
		
		btnCardPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendPaymentModeEvent(new PaymentModeEvent(PaymentMode.CREDITCARD));
			}
		});
		
		btnExpressMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				cashBoxControllerEventHandler.sendExpressModeDisabledEvent(new ExpressModeDisabledEvent());
			}
		});
		
		CashBoxControllerEventHandlerImpl cbcontrol = new CashBoxControllerEventHandlerImpl(this, eventchannel);
		
		cashBoxControllerEventHandler = cbcontrol;
	}
	
	private void addListenerToButton(final JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == b) {
					KeyStroke keystroke = null;
					String text = b.getText();
					if (text.equals("1"))
						keystroke = KeyStroke.ONE;
					if (text.equals("2"))
						keystroke = KeyStroke.TWO;
					if (text.equals("3"))
						keystroke = KeyStroke.THREE;
					if (text.equals("4"))
						keystroke = KeyStroke.FOUR;
					if (text.equals("5"))
						keystroke = KeyStroke.FIVE;
					if (text.equals("6"))
						keystroke = KeyStroke.SIX;
					if (text.equals("7"))
						keystroke = KeyStroke.SEVEN;
					if (text.equals("8"))
						keystroke = KeyStroke.EIGHT;
					if (text.equals("9"))
						keystroke = KeyStroke.NINE;
					if (text.equals("0"))
						keystroke = KeyStroke.ZERO;
					if (text.equals("."))
						keystroke = KeyStroke.COMMA;
					if (text.equals("ENTER"))
						keystroke = KeyStroke.ENTER;
					
					cashBoxControllerEventHandler.sendCashAmountEnteredEvent(new CashAmountEnteredEvent(keystroke));
				}
			}
		});
	}

	public void openCashBox() {
		cashbox.setForeground(Color.PINK);
		cashbox.setText("cashbox open");
	}
	
	public void closeCashBox() {
		cashbox.setForeground(Color.BLACK);
		cashbox.setText("cashbox closed");
	}
}
