package org.cocome.tradingsystem.inventory.gui.store;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cocome.tradingsystem.inventory.application.store.ComplexOrderTO;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class RolledInPanel extends JPanel {
	public RolledInPanel(final StoreIf store, final JFrame frame) {
		super(new BorderLayout());
		add(new JLabel("Enter order number and press 'Roll in received order'"), BorderLayout.PAGE_START);
		final JTextField field = new JTextField();
		add(field, BorderLayout.CENTER);
		final JButton button = new JButton("Roll in received order");
		add(button, BorderLayout.PAGE_END);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					String btext = field.getText();
					long orderId;
					try {
						orderId = Long.parseLong(btext);
					} catch (NumberFormatException e) {
						field.setText("");
						//TODO: Pop- up error dialog
						e.printStackTrace();
						return;
					}
					ComplexOrderTO order = new ComplexOrderTO();
					order.setId(orderId);
					try {
						store.rollInReceivedOrder(order);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					JOptionPane.showMessageDialog(frame, "Order " + orderId + " successfully rolled in");
					field.setText("");
				}
			}
		});
	}
}
