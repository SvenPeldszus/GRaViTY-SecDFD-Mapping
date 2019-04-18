package org.cocome.tradingsystem.inventory.gui.store;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Represents the button to execute an order of Products
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class OrderButton extends JButton {
	
	ProductSupplierOrderTableModel p;
	
	public OrderButton(ProductSupplierOrderTableModel p) {
		super("Order");
		this.p = p;
	}

	public void actionPerformed(ActionEvent e) {
		p.order();
	}
}
