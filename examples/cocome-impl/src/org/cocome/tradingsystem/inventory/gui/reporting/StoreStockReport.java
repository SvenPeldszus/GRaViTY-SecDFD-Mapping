package org.cocome.tradingsystem.inventory.gui.reporting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLEditorKit;

import org.cocome.tradingsystem.inventory.application.reporting.ReportTO;
import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class StoreStockReport extends JPanel {
	public StoreStockReport(final ReportingIf rep, final JFrame frame) {
		super(new BorderLayout());
		JPanel pan = new JPanel(new BorderLayout());
		pan.add(new JLabel("Enter store id and press 'Create Report'"), BorderLayout.NORTH);
		final JTextField field = new JTextField();
		pan.add(field, BorderLayout.SOUTH);
		add(pan, BorderLayout.NORTH);
		final JButton button = new JButton("Create Report");
		add(button, BorderLayout.SOUTH);
		final JTextPane textpane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textpane);
		textpane.setEditorKit(new HTMLEditorKit());
		add(scrollPane, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					String btext = field.getText();
					long storeId;
					try {
						storeId = Long.parseLong(btext);
					} catch (NumberFormatException e) {
						field.setText("");
						//TODO: Pop- up error dialog
						e.printStackTrace();
						return;
					}
					StoreTO store = new StoreTO();
					store.setId(storeId);
					ReportTO report;
					try {
						report = rep.getStockReport(store);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					textpane.setText(report.getReportText());
					field.setText("");
				}		
			}
		});
	}
}
