package org.cocome.tradingsystem.inventory.application.reporting;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * This interface provides methods for generating reports. It corresponds to the interface
 * ReportingIf in figure xx.
 * @author herold
 *
 */
public interface ReportingIf extends Remote {
	/**
	 * Generates report of available stocks in the specified store.
	 * @param storeTO Store for which report should be generated.
	 * @return Report transfer object containing stock information.
	 */
	public ReportTO getStockReport(StoreTO storeTO) throws RemoteException;
	
	/**
	 * Generates report of cumulated available stocks of specified enterprise.
	 * @param enterpriseTO The enterprise for which the report should be generated.
	 * @return Report transfer object containing cumulated stock information.
	 */
	public ReportTO getStockReport(EnterpriseTO enterpriseTO) throws RemoteException;

	/**
	 * Genrates report which informs about the mean time to delivery
	 * for each supplier of the specified enterprise.
	 * @param enterpriseTO TradingEnterprise for which the report should be generated.
	 * @return Report transfer object containing mean time to delivery information.
	 */
	public ReportTO getMeanTimeToDeliveryReport(EnterpriseTO enterpriseTO) throws RemoteException;
}
