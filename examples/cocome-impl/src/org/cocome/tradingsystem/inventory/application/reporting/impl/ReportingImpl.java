package org.cocome.tradingsystem.inventory.application.reporting.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.ReportTO;
import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.data.DataIfFactory;
import org.cocome.tradingsystem.inventory.data.enterprise.EnterpriseQueryIf;
import org.cocome.tradingsystem.inventory.data.enterprise.ProductSupplier;
import org.cocome.tradingsystem.inventory.data.enterprise.TradingEnterprise;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;
import org.cocome.tradingsystem.inventory.data.persistence.TransactionContext;
import org.cocome.tradingsystem.inventory.data.store.StockItem;
import org.cocome.tradingsystem.inventory.data.store.Store;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;

/**
 * 
 * @author Yannick Welsch
 */
public class ReportingImpl extends UnicastRemoteObject implements ReportingIf {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1393595223298557552L;
	
	private StoreQueryIf storequery = 
		DataIfFactory.getInstance().getStoreQueryIf();
	private EnterpriseQueryIf enterprisequery = 
		DataIfFactory.getInstance().getEnterpriseQueryIf();
	private PersistenceIf persistmanager = 
		DataIfFactory.getInstance().getPersistenceManager();
	
	
	public ReportingImpl() throws RemoteException {
		super();
	}
	
	/**
	 * Used for implementation of UC 6:ShowDeliveryReports
	 */
	public ReportTO getMeanTimeToDeliveryReport(EnterpriseTO enterpriseTO) {
		ReportTO result = new ReportTO();
		
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		StringBuilder reportText = new StringBuilder("");
		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();
			
			reportText.append("<html><body>");
			TradingEnterprise enterprise =
				enterprisequery.queryEnterpriseById(enterpriseTO.getId(), pctx);
			
			reportText.append("<table><tr>"
					+"<th>Supplier ID</th>"
					+"<th>Supplier Name</th>"
					+"<th>Mean Time To Delivery</th>"
					+"</tr>");
			for (ProductSupplier supplier : enterprise.getSuppliers()) {
				long mtdelivery = enterprisequery.getMeanTimeToDelivery(supplier, enterprise, pctx);
				
				if (mtdelivery == 0)
					continue;
				
				reportText.append("<tr>"
						+ "<td>" + supplier.getId() + "</td>"
						+ "<td>" + supplier.getName() + "</td>"
						+ "<td>" + mtdelivery + "</td>"
						+ "</tr>");
				
			}
			reportText.append("</table>");
		
			reportText.append("</body></html>");
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		result.setReportText(reportText.toString());
		return result;
	}

	/**
	 * Used for implementation of UC 5:ShowStockReports
	 */
	public ReportTO getStockReport(StoreTO storeTO) {
		ReportTO result = new ReportTO();
		
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		StringBuilder reportText = new StringBuilder("");
		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			Store store = storequery.queryStoreById(storeTO.getId(), pctx);
			if (store == null) {
				//TODO: throw appropriate exception
				throw new NullPointerException();
			}
			reportText.append("<html><body>");
			
			append(reportText, storeTO, pctx);
			
			reportText.append("</body></html>");
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		result.setReportText(reportText.toString());
		return result;
	}

	
	public ReportTO getStockReport(EnterpriseTO enterpriseTO) {
		ReportTO result = new ReportTO();
		
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		StringBuilder reportText = new StringBuilder("");
		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			TradingEnterprise enterprise =
				enterprisequery.queryEnterpriseById(enterpriseTO.getId(), pctx);
			
			reportText.append("<html><body>");
			reportText.append("Stock report for enterprise "+enterprise.getName()+" <br/>");
			
			for (Store store : enterprise.getStores()) {
				StoreTO storeTO = new StoreTO();
				storeTO.setId(store.getId());
				append(reportText, storeTO, pctx);
			}
			reportText.append("</body></html>");
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		result.setReportText(reportText.toString());
		return result;
	}
	
	private void append(StringBuilder reportText, 
			StoreTO storeTO, PersistenceContext pctx) {
		Collection<StockItem> stockitems = 
			storequery.queryAllStockItems(storeTO.getId(), pctx);
		reportText.append("Report for store " + storequery.queryStoreById(storeTO.getId(), pctx).getName() + "</br>");
		
		reportText.append("<table><tr>"
				+"<th>StockItem ID</th>"
				+"<th>Product Name</th>"
				+"<th>Amount</th>"
				+"<th>Min Stock</th>"
				+"<th>Max Stock</th>"
				+"</tr>");
		for (StockItem si : stockitems) {
			reportText.append("<tr>"
					+ "<td>" + si.getId() + "</td>"
					+ "<td>" + si.getProduct().getName() + "</td>"
					+ "<td>" + si.getAmount() + "</td>"
					+ "<td>" + si.getMinStock() + "</td>"
					+ "<td>" + si.getMaxStock() + "</td>"
					+ "</tr>");
		}
		reportText.append("</table></br>");
	}

}
