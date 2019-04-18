package org.cocome.tradingsystem.inventory.data;

import org.cocome.tradingsystem.inventory.data.enterprise.EnterpriseQueryIf;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;

/**
 * Interface for the Data component
 * @author Yannick Welsch
 */
public interface DataIf {
	/**
	 * creates a new EnterpriseQuery component
	 * @return 
	 * 	the new EnterpriseQuery component
	 */
	EnterpriseQueryIf getEnterpriseQueryIf();
	
	/**
	 * creates a new StoreQuery component
	 * @return 
	 * 	the new StoreQuery component
	 */
	StoreQueryIf getStoreQueryIf();
	
	/**
	 * creates a new PersistenceIf component
	 * @return 
	 * 	the new PersistenceIf component
	 */
	PersistenceIf getPersistenceManager();
}
