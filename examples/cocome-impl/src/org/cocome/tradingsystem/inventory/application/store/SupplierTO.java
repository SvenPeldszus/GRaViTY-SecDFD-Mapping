package org.cocome.tradingsystem.inventory.application.store;

import java.io.Serializable;

/**
 * <code>SupplierTO</code> is used as transfer object class for transferring basic supplier information
 * between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class SupplierTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8178666207666411060L;
	protected long id;
	protected String name;

	/**
	 * Gets identifier.
	 * @return The identifier.
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
	 * Gets name of supplier.
	 * @return Name of supplier.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of supplier.
	 * @param name Name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
