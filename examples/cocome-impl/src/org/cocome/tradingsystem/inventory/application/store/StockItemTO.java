package org.cocome.tradingsystem.inventory.application.store;

import java.io.Serializable;


/**
 * <code>StockItemTO</code> is used as transfer object class for transferring basic stock item information
 * between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class StockItemTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5874806761123366899L;
	protected long id;
	protected double salesPrice;
	protected long amount;
	protected long minStock;
	protected long maxStock;

	/**
	 * Gets the unique identifier of the <code>OrderTO</code> instance.
	 * @return Returns instance identifier.
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Gets amount of the stock item.
	 * @return Amount of stock item.
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * Sets amount of the stock item.
	 * @param amount New amount of stock item.
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}

	/**
	 * Gets minimum amount in stock
	 * @return Minimum stock.
	 */
	public long getMinStock() {
		return minStock;
	}

	/**
	 * Sets minimum stock.
	 * @param minStock New minimum stock.
	 */
	public void setMinStock(long minStock) {
		this.minStock = minStock;
	}
	
	/**
	 * Gets maximum amount in stock
	 * @return Maximum stock.
	 */
	public long getMaxStock() {
		return maxStock;
	}

	/**
	 * Sets maximum stock.
	 * @param maxStock New maximum stock.
	 */
	public void setMaxStock(long maxStock) {
		this.maxStock = maxStock;
	}

	/**
	 * Gets the sales price of one piece of this stock item.
	 * @return The sales price.
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * Set sales pice.
	 * @param salesPrice New sales price.
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

}
