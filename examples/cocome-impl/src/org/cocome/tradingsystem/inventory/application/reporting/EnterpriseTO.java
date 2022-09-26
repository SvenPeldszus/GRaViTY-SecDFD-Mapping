package org.cocome.tradingsystem.inventory.application.reporting;

import java.io.Serializable;

public class EnterpriseTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7516714574375972227L;
	protected long id;
	protected String name;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
