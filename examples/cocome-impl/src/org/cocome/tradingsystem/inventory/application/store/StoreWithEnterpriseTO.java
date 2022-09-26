package org.cocome.tradingsystem.inventory.application.store;

import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;


/**
 * <code>StoreWithEnterpriseTO</code> is used as transfer object class for transferring basic store information
 * and additional enterprise information between client and the service-oriented application layer.
 * It contains either copies of persisted data which are transferred to the client, or data which
 * is transferred from the client to the application layer for being processed and persisted.
 * @author herold
 *
 */
public class StoreWithEnterpriseTO extends StoreTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5339232518833582866L;
	protected EnterpriseTO enterpriseTO;

	/**
	 * Gets <code>EnterpriseTO</code> instance for enterprise which the store belongs to.
	 * @return the enterprise this store belongs to
	 */
	public EnterpriseTO getEnterpriseTO() {
		return enterpriseTO;
	}

	/**
	 * Sets enterprise which store belongs to.
	 * @param enterpriseTO
	 */
	public void setEnterpriseTO(EnterpriseTO enterpriseTO) {
		this.enterpriseTO = enterpriseTO;
	}
}
