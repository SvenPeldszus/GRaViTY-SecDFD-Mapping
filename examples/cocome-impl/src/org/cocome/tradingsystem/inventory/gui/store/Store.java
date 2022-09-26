package org.cocome.tradingsystem.inventory.gui.store;

import javax.swing.*;

import org.cocome.tradingsystem.inventory.application.store.StoreIf;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

/**
 * Main class for displaying the Store GUI
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class Store extends JPanel {

	private StoreIf store;

	public Store(String serveraddress, int port, String name)
			throws RemoteException {
		super(new BorderLayout());

		// get remote reference
		store = new Connector(serveraddress, port, name).getStore();

		// create TabbedPane in which are displayed the items
		JTabbedPane tabbedPane = new JTabbedPane();

		// create Store Description View
		StoreDescr storedescr = new StoreDescr(store);

		// create Product Supplier View
		ProductSupplierTableModel ptm = new ProductSupplierTableModel(store);
		JTable table = new JTable(ptm);
		JScrollPane scrollPane = new JScrollPane(table);

		// create Product StockItem View
		JPanel pan2 = new JPanel(new BorderLayout());
		pan2.add(new JLabel(
			"The StockItem sales price can be edited in-place"),
			BorderLayout.PAGE_START);
		ProductStockItemTableModel psm = new ProductStockItemTableModel(store);
		JTable table2 = new JTable(psm);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		pan2.add(scrollPane2, BorderLayout.CENTER);
		
		// create Product Supplier StockItem View
		JPanel pan3 = new JPanel(new BorderLayout());
		pan3.add(new JLabel(
			"The StockItem sales price can be edited in-place"),
			BorderLayout.PAGE_START);
		ProductSupplierStockItemTableModel pssm = new ProductSupplierStockItemTableModel(
				store);
		JTable table3 = new JTable(pssm);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		pan3.add(scrollPane3, BorderLayout.CENTER);

		// create Product Supplier Order View with the Order Button
		JPanel pan = new JPanel(new BorderLayout());
		pan.add(new JLabel(
			"Enter Amount for specific Product and press Order"),
			BorderLayout.PAGE_START);
		ProductSupplierOrderTableModel psom = new ProductSupplierOrderTableModel(
				store);
		JTable table4 = new JTable(psom);
		JScrollPane scrollPane4 = new JScrollPane(table4);
		pan.add(scrollPane4, BorderLayout.CENTER);
		final OrderButton ob = new OrderButton(psom);
		ob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == ob) {
					ob.actionPerformed(e);
				}
			}
		});
		pan.add(ob, BorderLayout.PAGE_END);

		// configure Tab Pane
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// add the Tabs to the Tab Pane
		tabbedPane.addTab("Store Information", null, storedescr, "");
		tabbedPane.addTab("Product Information", null, scrollPane, "");
		tabbedPane.addTab("StockItem Overview", null, pan3,
				"");
		tabbedPane.setToolTipTextAt(2, "Use Case 7");
		tabbedPane.addTab("Products with low stock", null, pan2, "");
		tabbedPane.setToolTipTextAt(3, "Use Case 3");
		tabbedPane.addTab("Ordering", null, pan, "");
		tabbedPane.setToolTipTextAt(4, "Use Case 3");
		tabbedPane.addTab("Receiving", null, new RolledInPanel(store,
				(JFrame) this.getParent()), "");
		tabbedPane.setToolTipTextAt(5, "Use Case 4");

		// Add Refresh Button
		final RefreshButton b = new RefreshButton(tabbedPane);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b) {
					b.actionPerformed(e);
				}
			}
		});
		b.setSize(50, 100);
		add(b, BorderLayout.PAGE_START);

		// Register elements to Refresh Button
		b.addElem(ptm);
		b.addElem(psm);
		b.addElem(pssm);
		b.addElem(psom);
		b.addElem(storedescr);

		// Add the tabbed pane to this panel.
		add(tabbedPane);
	}

	/**
	 * Create the Store and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI(String serveraddress, int port,
			String name) {
		// Create and set up the window.
		JFrame frame = new JFrame("Store at " + serveraddress + ":" + port + "/"
				+ name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		try {
			frame.getContentPane().add(new Store(serveraddress, port, name),
					BorderLayout.CENTER);
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
		if (args.length != 3) {
			throw new IllegalArgumentException();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(args[0], Integer.valueOf(args[1]).intValue(),
						args[2]);
			}
		});
	}

}
