package org.cocome.tradingsystem.inventory.data;

import org.cocome.tradingsystem.inventory.data.impl.DataImpl;

/**
 * Factory for creating the Data component
 * @author Yannick Welsch
 */
public class DataIfFactory {
	
	private static DataIf dataaccess = null;
	
	private DataIfFactory() {}
	
	/**
	 * 
	 * @return a Data component
	 */
	public static DataIf getInstance() {
		if (dataaccess == null) {
			dataaccess = new DataImpl();
		}
		return dataaccess;
	}
}
