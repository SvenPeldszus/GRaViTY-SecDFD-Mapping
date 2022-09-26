package org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller.CardReaderControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.PINEnteredEvent;

/**
 * GUI for the CardReader component
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class CardReader extends JPanel {
	private CardReaderControllerEventHandlerIf cardReaderController;

	public CardReader(String eventchannel) {
		super(new BorderLayout());
		cardReaderController = new CardReaderControllerEventHandlerImpl(
				eventchannel);

		JButton btnScanCard = new JButton("Scan Card");
		add(btnScanCard, BorderLayout.NORTH);
		final JTextField field = new JTextField();
		add(field, BorderLayout.CENTER);
		JButton btnScanItem = new JButton("Submit PIN");
		add(btnScanItem, BorderLayout.SOUTH);

		btnScanCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String creditInfo = "blablabla";
				cardReaderController
						.sendCreditCardScannedEvent(new CreditCardScannedEvent(
								creditInfo));
			}
		});

		btnScanItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String text = field.getText();
				try {
					int pin = Integer.parseInt(text);
					// We simulate a hardware defect here
					if (Math.random() < 0.1) {
						// Read out wrong value
						pin++;
					}
					cardReaderController
							.sendPINEnteredEvent(new PINEnteredEvent(pin));
					field.setText("");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});
	}
}