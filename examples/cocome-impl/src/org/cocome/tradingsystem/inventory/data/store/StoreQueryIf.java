package org.cocome.tradingsystem.inventory.data.store;

import java.util.Collection;

import org.cocome.tradingsystem.inventory.data.enterprise.*;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;

/**
 * This interface provides methods for querying the database. The interface will
 * be used by the InventoryApplication. The methods are derived from methods
 * defined in StoreIf and CashdeskIf.
 * 
 * @author Yannick Welsch
 */
public interface StoreQueryIf {

	/**
	 * 
	 * @param storeId
	 *            A unique identifier of a Store object
	 * @param pctx
	 *            the persistence context
	 * @return A Store object which has the the specified id
	 */
	Store queryStoreById(long storeId, PersistenceContext pctx);

	/**
	 * 
	 * @param storeId
	 *            A unique identifier of a Store object
	 * @param pctx
	 *            the persistence context
	 * @return The products owned by this store
	 */
	Collection<Product> queryProducts(long storeId, PersistenceContext pctx);

	/**
	 * queries the stockitems which are low on stock
	 * 
	 * @param storeId
	 *            A unique identifier of a Store object
	 * @param pctx
	 *            the persistence context
	 * @return A list of StockItem objects
	 */
	Collection<StockItem> queryLowStockItems(long storeId,
			PersistenceContext pctx);

	/**
	 * 
	 * @param storeId
	 *            A unique identifier of a Store object
	 * @param pctx
	 *            the persistence context
	 * @return A list of StockItem objects
	 */
	Collection<StockItem> queryAllStockItems(long storeId,
			PersistenceContext pctx);

	/**
	 * The following methods from StoreIf use this method: List<ComplexOrderTO>
	 * orderProducts(ComplexOrderTO complexOrder, StoreTO storeTO);
	 * ComplexOrderTO getOrder(int orderId); void
	 * rollInReceivedOrder(ComplexOrderTO complexOrder, StoreTO store);
	 * 
	 * @param orderId
	 *            A unique identifier of an ProductOrder object
	 * @param pctx
	 *            the persistence context
	 * @return An ProductOrder object which has the specified id
	 */
	ProductOrder queryOrderById(long orderId, PersistenceContext pctx);

	/**
	 * The following methods from StoreIf use this method:
	 * ProductWithStockItemTO getProductWithStockItem(int productBarCode);
	 * 
	 * @param storeId
	 *            A unique identifier of a Store object
	 * @param productbarcode
	 * @param pctx
	 *            the persistence context
	 * @return the stockitem from the Store with storeId and being of
	 * 	product type with barcode productbarcode.
	 * Return null if the product was not found in the store.
	 */
	StockItem queryStockItem(long storeId, long productbarcode,
			PersistenceContext pctx);

	/**
	 * 
	 * @param stockId A unique identifier of a StockItem object
	 * @param pctx
	 * @return the StockItem which has this id
	 */
	StockItem queryStockItemById(long stockId, PersistenceContext pctx);

	/**
	 * 
	 * @param productId A unique identifier of a Product object
	 * @param pctx
	 *            the persistence context
	 * @return the Product which has this id
	 */
	Product queryProductById(long productId, PersistenceContext pctx);

	/**
	 * @author SDQ
	 * Returns the stock for the given productIds.
	 * @param storeId The store to search StockItems for.
	 * @param productIds The products to look up in the stock
	 * @param pctx the persistence context
	 * @return The products as StockItems (including amounts)
	 */
	Collection<StockItem> getStockItems(long storeId, long[] productIds, PersistenceContext pctx);
}
