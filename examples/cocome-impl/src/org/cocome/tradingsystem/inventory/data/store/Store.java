package org.cocome.tradingsystem.inventory.data.store;

import java.util.Collection;

import javax.persistence.*;

import org.cocome.tradingsystem.inventory.data.enterprise.TradingEnterprise;


/**
 * The class Store represents a store in the database
 * @author Yannick Welsch
 */
@Entity
public class Store {

	private long id;
	private String name;
	private String location;
	private TradingEnterprise enterprise;
	private Collection<ProductOrder> productOrders;
	private Collection<StockItem> stockItems;
	
	
	
	/**
	 * @return A unique identifier for Store objects
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	/**
	 * @param id A unique identifier for Store objects
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return The enterprise which the Store belongs to
	 */
	@ManyToOne
	public TradingEnterprise getEnterprise() {
		return enterprise;
	}
	
	/**
	 * @param enterprise The enterprise which the Store belongs to
	 */
	public void setEnterprise(TradingEnterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	/**
	 * @return The location of the Store
	 */
	@Basic
	public String getLocation() {
		return location;
	}
	
	/**
	 * @param location The location of the Store
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return The name of the Store
	 */
	@Basic
	public String getName() {
		return name;
	}
	
	/**
	 * @param name The name of the Store
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return All productOrders of the Store
	 */
	@OneToMany(mappedBy="store", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Collection<ProductOrder> getOrders() {
		return productOrders;
	}
	
	/**
	 * @param productOrders All productOrders of the Store
	 */
	public void setOrders(Collection<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
	
	/**
	 * @return A list of StockItem objects.
	 *         A StockItem represents a concrete product in the store including sales price, ...
	 */
	@OneToMany(mappedBy="store", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Collection<StockItem> getStockItems() {
		return stockItems;
	}
	
	/**
	 * @param stockItems A list of StockItem objects.
	 *        A StockItem represents a concrete product in the store including sales price, ...
	 */
	public void setStockItems(Collection<StockItem> stockItems) {
		this.stockItems = stockItems;
	}
	
	
}
