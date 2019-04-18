package org.cocome.tradingsystem.inventory.gui.store;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.cocome.tradingsystem.inventory.application.store.ProductWithSupplierAndStockItemTO;
import org.cocome.tradingsystem.inventory.application.store.StockItemTO;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class ProductSupplierStockItemTableModel extends AbstractTableModel
		implements Refreshable {

	private List<ProductWithSupplierAndStockItemTO> products;

	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	private StoreIf store;

	public ProductSupplierStockItemTableModel(StoreIf store)
			throws RemoteException {
		super();
		this.store = store;
		refresh();
	}

	public int getColumnCount() {
		return 11;
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
			return "Stockitem ID";
		case 7:
			return "Stockitem Amount";
		case 8:
			return "Stockitem Min Stock";
		case 9:
			return "Stockitem Max Stock";
		case 10:
			return "Stockitem Sales Price";

		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductWithSupplierAndStockItemTO p = products.get(rowIndex);
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
			return p.getStockItemTO().getId();
		case 7:
			return p.getStockItemTO().getAmount();
		case 8:
			return p.getStockItemTO().getMinStock();
		case 9:
			return p.getStockItemTO().getMaxStock();
		case 10:
			return p.getStockItemTO().getSalesPrice();

		default:
			return null;
		}
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 10) {
			return true;
		} else {
			return false;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		if (col == 10) {
			StockItemTO sto = products.get(row).getStockItemTO();
			if (sto != null & value instanceof String) {
				String input = (String) value;
				double price;
				try {
					price = Double.parseDouble(input);
					double oldprice = sto.getSalesPrice();
					if (price != oldprice) {
						sto.setSalesPrice(price);
						try {
							store.changePrice(sto);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							sto.setSalesPrice(oldprice);
							e.printStackTrace();
						}
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
			products = store.getAllProductsWithOptionalStockItem();
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
