package org.cocome.tradingsystem.inventory.application.reporting;

import java.io.Serializable;


/**
 * <code>StoreTO</code> is used as transfer object class for transferring basic store information
 * between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class StoreTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1635539555697050823L;
	protected long id;
	protected String name;
	protected String location;

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
	 * Gets name of store.
	 * @return the name of the store
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of store.
	 * @param name New store name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets location of store.
	 * @return Location of store.
	 */
	public String getLocation()
	{
		return location;
	}

	/**
	 * Sets location of this store.
	 * @param location Location string.
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}
}
