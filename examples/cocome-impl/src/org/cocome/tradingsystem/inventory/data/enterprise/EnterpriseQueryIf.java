package org.cocome.tradingsystem.inventory.data.enterprise;

import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;

/**
 * This interface provides methods for querying the database. 
 * It is used by the InventoryApplication. The methods are
 * derived from methods defined in ReportingIf.
 * @author Yannick Welsch
 */
public interface EnterpriseQueryIf {
	/**
	 * 
	 * @param enterpriseId
	 * 	The unique identifier of an TradingEnterprise object
	 * @param pctx
	 * 	The persistence context
	 * @return 
	 * 	A TradingEnterprise object which has the specified id
	 */
	TradingEnterprise queryEnterpriseById(long enterpriseId, PersistenceContext pctx);
	
	/**
	 * 
	 * @param supplier 
	 * 	The supplier which delivers the products
	 * @param enterprise
	 * 	The enterprise for which the products are delivered
	 * @param pctx
	 * 	The persistence context
	 * @return The mean time to delivery in milliseconds
	 */
	long getMeanTimeToDelivery(ProductSupplier supplier, 
			TradingEnterprise enterprise, PersistenceContext pctx);
}
