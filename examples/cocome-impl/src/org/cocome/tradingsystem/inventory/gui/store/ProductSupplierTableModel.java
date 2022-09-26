package org.cocome.tradingsystem.inventory.gui.store;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.cocome.tradingsystem.inventory.application.store.ProductWithSupplierTO;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class ProductSupplierTableModel extends AbstractTableModel implements Refreshable {

	private List<ProductWithSupplierTO> products;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	private StoreIf store;
	
	public ProductSupplierTableModel(StoreIf store) throws RemoteException {
		super();
		this.store = store;
		refresh();
	}

	public int getColumnCount() {
		return 6;
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

		default:
			return null;
		}
	}
	
	public void refresh() {
		try {
			products = store.getAllProducts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (TableModelListener l : listeners) {
			l.tableChanged(new TableModelEvent(this));
		}
	}

	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
		super.addTableModelListener(l);
	}

}
