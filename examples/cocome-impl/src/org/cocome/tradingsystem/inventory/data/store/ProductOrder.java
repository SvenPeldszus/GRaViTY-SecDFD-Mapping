package org.cocome.tradingsystem.inventory.data.store;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * The ProductOrder class represents an ProductOrder of a Store in the database.
 * @author Yannick Welsch
 */
@Entity
public class ProductOrder {
	
	private long id;
	private Date deliveryDate;
	private Date orderingDate;
	private Collection<OrderEntry> orderEntries;
	private Store store;
	
	/**
	 * @return A unique identifier for ProductOrder objects
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	/**
	 * @param id A unique identifier for ProductOrder objects
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return A list of OrderEntry objects (pairs of Product-Amount-pairs)
	 */
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Collection<OrderEntry> getOrderEntries() {
		return orderEntries;
	}
	
	/**
	 * @param orderEntries A list of OrderEntry objects (pairs of Product-Amount-pairs)
	 */
	public void setOrderEntries(Collection<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}
	
	/**
	 * @return The date of ordering
	 */
	@Basic
	public Date getOrderingDate() {
		return orderingDate;
	}
	
	/**
	 * @param orderingDate The date of order
	 */
	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
	}
	
	/**
	 * The delivery date is used for computing the mean time to delivery
	 * 
	 * @return The date of order fulfillment
	 */
	@Basic
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	/**
	 * The delivery date is used for computing the mean time to delivery
	 * 
	 * @param deliveryDate The date of order fulfillment
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * @return The store where the order is placed
	 */
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Store getStore() {
		return store;
	}
	
	/**
	 * @param store The store where the order is placed
	 */
	public void setStore(Store store) {
		this.store = store;
	}
}
