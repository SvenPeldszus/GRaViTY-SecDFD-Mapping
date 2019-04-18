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

import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.ReportTO;
import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class EnterpriseStockReport extends JPanel {
	public EnterpriseStockReport(final ReportingIf rep, final JFrame frame) {
		super(new BorderLayout());
		JPanel pan = new JPanel(new BorderLayout());
		pan.add(new JLabel("Enter enterprise id and press 'Create Report'"), BorderLayout.NORTH);
		final JTextField field = new JTextField();
		pan.add(field, BorderLayout.SOUTH);
		add(pan, BorderLayout.NORTH);
		final JButton button = new JButton("Create Report");
		add(button, BorderLayout.SOUTH);
		final JTextPane textpane = new JTextPane();
		textpane.setEditorKit(new HTMLEditorKit());
		JScrollPane scrollPane = new JScrollPane(textpane);
		add(scrollPane, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					String btext = field.getText();
					long epId;
					try {
						epId = Long.parseLong(btext);
					} catch (NumberFormatException e) {
						field.setText("");
						// TODO: Pop- up error dialog
						e.printStackTrace();
						return;
					}
					EnterpriseTO ep = new EnterpriseTO();
					ep.setId(epId);
					ReportTO report;
					try {
						report = rep.getStockReport(ep);
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
