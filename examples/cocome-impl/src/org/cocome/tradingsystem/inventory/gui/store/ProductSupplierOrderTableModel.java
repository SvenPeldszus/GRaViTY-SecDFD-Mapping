package org.cocome.tradingsystem.inventory.gui.store;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.cocome.tradingsystem.inventory.application.store.ComplexOrderEntryTO;
import org.cocome.tradingsystem.inventory.application.store.ComplexOrderTO;
import org.cocome.tradingsystem.inventory.application.store.ProductWithSupplierTO;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class ProductSupplierOrderTableModel extends AbstractTableModel implements Refreshable {

	private List<ProductWithSupplierTO> products;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	private List<Long> amounts = new ArrayList<Long>();
	
	private StoreIf store;
	
	public ProductSupplierOrderTableModel(StoreIf store) throws RemoteException {
		super();
		this.store = store;
		refresh();
	}

	public int getColumnCount() {
		return 7;
	}

	public int getRowCount() {
		return products.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Product ID";
		case 1:
			return "Product Name";
		case 2:
			return "Product Barcode";
		case 3:
			return "Product Purchase Price";
		case 4:
			return "Supplier ID";
		case 5:
			return "Supplier Name";
		case 6:
			return "Amount";

		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductWithSupplierTO p = products.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getId();
		case 1:
			return p.getName();
		case 2:
			return p.getBarcode();
		case 3:
			return p.getPurchasePrice();
		case 4:
			return p.getSupplierTO().getId();
		case 5:
			return p.getSupplierTO().getName();
		case 6:
			return amounts.get(rowIndex);

		default:
			return null;
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col == 6) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setValueAt(Object value, int row, int col) {
		if (col == 6) {
			if (value instanceof String) {
				String input = (String) value;
				long amount;
				try {
					amount = Long.parseLong(input);
					long oldamount = amounts.get(row);
					if (amount != oldamount) {
						amounts.set(row, new Long(amount));
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
					// do nothing
				}

			}
		}
		fireTableCellUpdated(row, col);
	}
	
	public void refresh() {
		try {
			products = store.getAllProducts();
			amounts = new ArrayList<Long>();
			for (int i = 0; i < products.size(); i++) {
				amounts.add(new Long(0));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (TableModelListener l : listeners) {
			l.tableChanged(new TableModelEvent(this));
		}
	}
	
	public List<ComplexOrderTO> order() {
		ComplexOrderTO order = new ComplexOrderTO();
		List<ComplexOrderEntryTO> oes = new ArrayList<ComplexOrderEntryTO>();
		for (int i = 0; i < products.size(); i++) {
			ProductWithSupplierTO pwsto = products.get(i);
			Long amount = amounts.get(i);
			if (amount.longValue() > 0) {
				ComplexOrderEntryTO oe = new ComplexOrderEntryTO();
				oe.setAmount(amount.longValue());
				oe.setProductTO(pwsto);
				oes.add(oe);
			}
		}
		order.setOrderEntryTO(oes);
		List<ComplexOrderTO> resultorders = Collections.emptyList();
		try {
			resultorders = store.orderProducts(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refresh();
		JFrame frame = new JFrame("Product Order");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p = new ProductOrderDisplay(resultorders);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(new JScrollPane(p));
		
		frame.pack();
		frame.setVisible(true);
		return resultorders;
	}

	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
		super.addTableModelListener(l);
	}

}
