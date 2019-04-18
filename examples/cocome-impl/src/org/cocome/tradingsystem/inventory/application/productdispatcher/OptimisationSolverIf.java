package org.cocome.tradingsystem.inventory.application.productdispatcher;

import java.util.Collection;
import java.util.Hashtable;

import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.ProductAmountTO;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.store.StockItem;
import org.cocome.tradingsystem.inventory.data.store.Store;

/**
 * For description see method solveOptimization()
 * <p>
 * Required for UC8
 * @author kelsaka
 *
 */
public interface OptimisationSolverIf {
	/**
	 * Solves an optimisation problem:
	 * Optimal transportation costs with respect to
	 * <ol>
	 * 	<li>The required products and the required amount</li>
	 * 	<li>The available products and their provided amount per providing store</li>
	 *	<li>The distances between the requiring and the providing store</li> 
	 * </ol>
	 * @param requiredProductAmounts Products/Amounts required by the requiring
	 * store
	 * @param storeStockItems Stock item availability per store.
	 * @param storeDistances Distances between requiring store and each
	 * providing stores	 
	 * @return A Hashtable: For each Store the product/amount tuple is given.
	 * Those products/amounts have to be delivered by the store.
	 */
	public Hashtable<StoreTO, Collection<ProductAmountTO>> solveOptimization(
			Collection<ProductAmountTO> requiredProductAmounts,
    		Hashtable<Store, Collection<StockItem>> storeStockItems,
    		Hashtable<Store, Integer> storeDistances);
}