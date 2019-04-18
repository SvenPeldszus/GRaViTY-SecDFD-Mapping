package org.cocome.tradingsystem.inventory.application.productdispatcher;

import java.rmi.RemoteException;
import java.util.Collection;

import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.ProductAmountTO;
import org.cocome.tradingsystem.inventory.application.store.ProductTO;

/**
 * This interface provides enterprise specific business logic (business logic that is
 * not available for stores)
 * @author kelsaka
 *
 */
public interface ProductDispatcherIf {

	/**
	 * Executes a query to search for a product (that ran out of stock at one store) at
	 * other stores in the region.  
	 * <p>
	 * Required for Use-Case 8 (product exchange (on low stock) among stores). Called by
	 * an {@link InventoryApplication}.
	 * @param callingStore The store running out of stock.
	 * @param enterpriseTO The enterprise managing the transfer
	 * @param productAmounts The products running out at the calling store and the required
	 * amount of those products.
	 * @return Returns a list of the required products that will be made available by the
	 * enterprise. The included amount of products might be "0" to indicate that a product
	 * is not available in the enterprise.
	 * <p>
	 * Products that are indicates to be available (amount > 0) are prepared for delivery
	 * by the delivering store (markProductsUnavailableInStock).
	 */
	ProductAmountTO[] orderProductsAvailableAtOtherStores(EnterpriseTO enterpriseTO, 
			StoreTO callingStore, Collection<ProductAmountTO> productAmounts)
		throws RemoteException;		
}
