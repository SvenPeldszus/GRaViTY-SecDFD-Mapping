package org.cocome.tradingsystem.inventory.gui.reporting;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

/**
 * Main Class for the Reporting GUI
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class Reporting extends JPanel {
	
	private ReportingIf rep;
	
	public Reporting(String serveraddress, int port, String name) throws RemoteException {
		super(new BorderLayout());
		
		//get remote reference
		rep = new Connector(serveraddress, port, name).getReporting();
				
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//add the different components
		tabbedPane.addTab(
				"Mean Time to Delivery", null, 
				new MTDeliveryReport(rep, (JFrame)this.getParent()), "");
		tabbedPane.setToolTipTextAt(0, "Use Case 6");
		tabbedPane.addTab(
				"Store Stock Report", null, 
				new StoreStockReport(rep, (JFrame)this.getParent()), "");
		tabbedPane.setToolTipTextAt(1, "Use Case 5");
		tabbedPane.addTab(
				"Enterprise Stock Report", null, 
				new EnterpriseStockReport(rep, (JFrame)this.getParent()), "");
		tabbedPane.setToolTipTextAt(2, "Use Case 5");

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		// Add the tabbed pane to this panel.
		add(tabbedPane);
	}

	/**
	 * Create the Store and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI(String serveraddress, int port, String name) {
		// Create and set up the window.
		JFrame frame = new JFrame("Reporting at " + serveraddress + ":" + port + "/"
				+ name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		try {
			frame.getContentPane().add(new Reporting(serveraddress, port, name), BorderLayout.CENTER);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// Display the window.
		frame.pack();
		frame.setSize(640, 480);
		frame.setVisible(true);
	}

	/**
	 * The graphical user interface is started with the following arguments
	 * pointing at an RMI Registry: "host port identifier" Example: localhost
	 * 1099 store1
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(args[0], Integer.valueOf(args[1]).intValue(), args[2]);
			}
		});
	}
}
