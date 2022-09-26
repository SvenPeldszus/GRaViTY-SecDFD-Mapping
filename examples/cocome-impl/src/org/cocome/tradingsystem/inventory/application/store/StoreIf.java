package org.cocome.tradingsystem.inventory.application.store;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This interface represents the interface StoreIf  of the component InventoryApplication, as shown
 * in the component diagram of figure xx.
 * @author herold
 *
 */
public interface StoreIf extends Remote {

	/**
	 * Gets transfer object with information of the store in which the component is running. This information
	 * is retrieved by the component during configuration and initialization.
	 * @return Store and enterprise information about the local store.
	 */
	StoreWithEnterpriseTO getStore() throws RemoteException;

	/**
	 * Determines products and stock items which are nearly out of stock, meaning amount is lower than 10%
	 * of maximal stock.
	 * Used for realization of UC 3.
	 * @return Returns a list of products and their stock item in the given store.
	 */
	List<ProductWithStockItemTO> getProductsWithLowStock() throws RemoteException;

	/**
	 * Determines all products of the portfolio of a given store and the supplier for each of them.
	 * Used for realization of UC 3.
	 * @return Returns a list of products and their suppliers
	 */
	List<ProductWithSupplierTO> getAllProducts() throws RemoteException;

	/**
	 * Determines all products of the portfolio of a given store and the supplier for each of them. 
	 * Additionally the corresponding stockitems are queried
	 * @return Returns a list of products, their suppliers and the corresponding StockItem if they have any
	 */
	List<ProductWithSupplierAndStockItemTO> getAllProductsWithOptionalStockItem() throws RemoteException;
	
	/**
	 * Creates a list of orders for different suppliers for an initial list of products
	 * to be ordered by a store. ProductOrder is persisted and ordering date is set to date of
	 * method execution. Used for realization of UC 3.
	 * @param complexOrder Initial order which contains all products to be ordered.
	 * @return Returns a list of orders, one for each supplier that is affected.
	 */
	List<ComplexOrderTO> orderProducts(ComplexOrderTO complexOrder) throws RemoteException;

	/**
	 * Returns order information for a given order id.
	 * Used for realization of UC 4.
	 * @param orderId The id of the order.
	 * @return Detailed order information of the desired order. NULL, if there is no order
	 * with the given id.
	 */
	ComplexOrderTO getOrder(long orderId) throws RemoteException;

	/**
	 * Updates stocks after order delivery. Adds amount of ordered items to the stock items
	 * of the store. Sets delivery date to date of method execution.
	 * Used for realization of UC 4.
	 * @param complexOrderTO Contains the order which is rolled in.
	 */
	void rollInReceivedOrder(ComplexOrderTO complexOrderTO) throws RemoteException;

	/**
	 * Updates sales price of a stock item.
	 * Used for realization of UC 7.
	 * @param stockItemTO Stock item with new price.
	 * @return Returns instance of ProductWithStockItemTO which holds product information
	 * and updated price information for stock item identified by <code>stockItemTO</code>.
	 */
	ProductWithStockItemTO changePrice(StockItemTO stockItemTO) throws RemoteException;
	
	/**
	 * @author SDQ
	 * Initiates the delivery of a single product, that ran out at another store.
	 * The requiredProduct is marked as unavailable at this store afterwards.
	 * <p>
	 * Method required for UC 8 (product exchange (on low stock) among stores).
	 * @param requiredProductsAndAmount The product required at another store; includes
	 * the amount of required products. 
	 * @throws ProductNotAvailableException Thrown if the local stock of the
	 * required product is less than the required amount.
	 */
	void markProductsUnavailableInStock(ProductMovementTO requiredProductsAndAmount)
		throws RemoteException, ProductNotAvailableException;	
	
	/**
	 * @author SDQ
	 * Returns the stock for the given products.
	 * <p>
	 * Required for UC 8
	 * @param requiredProductTOs The products to look up in the stock
	 * @return The products including amounts from the stock
	 */
	ComplexOrderEntryTO[] getStockItems(ProductTO[] requiredProductTOs)
		throws RemoteException;
	
}
