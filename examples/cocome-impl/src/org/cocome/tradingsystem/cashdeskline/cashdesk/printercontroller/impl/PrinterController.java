package org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller.impl;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;

/**
 * GUI for the PrinterController component
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class PrinterController extends JPanel {
	private final JTextArea textArea;
	
	private double total = 0.0;
	
	private boolean first = true;
		
	public PrinterController(String eventchannel) {
		super(new BorderLayout());
		textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = 
		    new JScrollPane(textArea,
		                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		add(scrollPane);
		
		new PrinterControllerEventHandlerImpl(eventchannel, this);	
	}
	
	public void updatePrintout(RunningTotalChangedEvent runningTotalChangedEvent) {
		textArea.append(runningTotalChangedEvent.getProductName() 
				+ ": " + runningTotalChangedEvent.getProductPrice() 
				+ "\n");
		total = runningTotalChangedEvent.getRunningTotal();
	}
	
	public void updatePrintout(ChangeAmountCalculatedEvent changeAmountCalculatedEvent) {
		textArea.append(changeAmountCalculatedEvent.getChangeAmount()
				+ "\n");
	}
	
	public void newSale() {
		textArea.setText("");
		first = true;
	}
	
	public void append(String s) {
		if (first) {
			textArea.append("\nCash received: ");
		}
		textArea.append(s);
		first = false;
	}
	
	public void cashamountentered() {
		textArea.append("\nChange Amount: ");
	}
	
	public void finishSale() {
		if (total != 0.0) {
			total = Math.rint(100 * total) /100;
			textArea.append("-------------------\nTotal: "+total);
		}
	}
}