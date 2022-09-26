package org.cocome.tradingsystem.inventory.application.store;



/**
 * <code>ProductWithSupplierAndStockItemTO</code> is used as transfer object class for transferring basic product, stockitem and additional supplier
 * information between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class ProductWithSupplierAndStockItemTO extends ProductWithSupplierTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7188831293897975665L;
	protected StockItemTO stockitemTO;

	/**
	 * Gets transfer object for stockitem
	 * @return stockitemTO StockItem Transfer object
	 */
	public StockItemTO getStockItemTO() {
		return stockitemTO;
	}

	/**
	 * Sets transfer object for supplier
	 * @param stockitemTO New stockitem transfer object.
	 */
	public void setStockItemTO(StockItemTO stockitemTO) {
		this.stockitemTO = stockitemTO;
	}
}
