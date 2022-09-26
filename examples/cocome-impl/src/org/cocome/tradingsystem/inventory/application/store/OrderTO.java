package org.cocome.tradingsystem.inventory.application.store;

import java.io.Serializable;
import java.util.Date;

/**
 * <code>OrderTO</code> is used as transfer object class for transferring basic order information
 * between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class OrderTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2560032621725754893L;
	protected long id;
	protected Date deliveryDate;
	protected Date orderingDate;

	/**
	 * Gets delivery date value.
	 * @return Returns saved delivery date of the <code>OrderTO</code> instance.
	 * @see java.util.Date
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Sets delivery date value.
	 * @param deliveryDate Delivery date to be set.
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Gets the unique identifier of the <code>OrderTO</code> instance.
	 * @return Returns instance identifier
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
	 * Gets ordering date value.
	 * @return Returns saved ordering date of the <code>OrderTO</code> instance.
	 */
	public Date getOrderingDate() {
		return orderingDate;
	}

	/**
	 * Sets delivery date value.
	 * @param orderingDate Ordering date to be set.
	 */
	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
	}
}
