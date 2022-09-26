package org.cocome.tradingsystem.external;

import java.io.Serializable;

/**
 * Represents a transaction id issued to validate a pin number
 * @author Yannick Welsch
 */
public class TransactionID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1275459601912497741L;
	
	private long id;
	
	public TransactionID(long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof TransactionID) {
			return ((TransactionID)o).id == id;
		}
		return false;
	}
}
