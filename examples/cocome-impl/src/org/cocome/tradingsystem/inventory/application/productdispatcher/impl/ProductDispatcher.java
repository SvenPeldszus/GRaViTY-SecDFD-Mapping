package org.cocome.tradingsystem.inventory.application.productdispatcher.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.cocome.tradingsystem.inventory.application.ApplicationFactory;
import org.cocome.tradingsystem.inventory.application.productdispatcher.OptimisationSolverIf;
import org.cocome.tradingsystem.inventory.application.productdispatcher.ProductDispatcherIf;
import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.ProductAmountTO;
import org.cocome.tradingsystem.inventory.application.store.ProductMovementTO;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;
import org.cocome.tradingsystem.inventory.data.DataIfFactory;
import org.cocome.tradingsystem.inventory.data.enterprise.EnterpriseQueryIf;
import org.cocome.tradingsystem.inventory.data.enterprise.TradingEnterprise;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;
import org.cocome.tradingsystem.inventory.data.persistence.TransactionContext;
import org.cocome.tradingsystem.inventory.data.store.StockItem;
import org.cocome.tradingsystem.inventory.data.store.Store;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;

public class ProductDispatcher extends UnicastRemoteObject implements ProductDispatcherIf {

	private static final long serialVersionUID = -4570575471689265815L;
	
	private PersistenceIf persistmanager =
		DataIfFactory.getInstance().getPersistenceManager();
	private PersistenceContext pctx;
	private StoreQueryIf storeQuery = 
		DataIfFactory.getInstance().getStoreQueryIf();
	private EnterpriseQueryIf enterpriseQuery = 
		DataIfFactory.getInstance().getEnterpriseQueryIf();
	
	public ProductDispatcher() throws RemoteException {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.cocome.tradingsystem.inventory.application.productdispatcher.ProductDispatcherIf#isProductAvailableAtOtherStores(org.cocome.tradingsystem.inventory.application.reporting.StoreTO, org.cocome.tradingsystem.inventory.application.store.ProductTO[])
	 */
	public ProductAmountTO[] orderProductsAvailableAtOtherStores(
			EnterpriseTO enterpriseTO, StoreTO callingStore,
			Collection<ProductAmountTO> productAmounts) {
		
		this.pctx = persistmanager.getPersistenceContext();		
		ProductAmountTO[] result = null;		

		TradingEnterprise enterprise =
			enterpriseQuery.queryEnterpriseById(enterpriseTO.getId(), pctx);
		Collection<Store> stores = enterprise.getStores();
		
		// distributed action:
		letAllStoresFlushDatabase(pctx, stores);
				
		// solve the optimization problem using ampl/cplex:
		long[] productIds = getProductIds(productAmounts);		
		OptimisationSolverIf solver = new AmplStarter(pctx);
		Hashtable<StoreTO, Collection<ProductAmountTO>> storeProductAmounts =
			solver.solveOptimization(
				productAmounts,
				getOfferedStockItemsPerStore(stores, productIds),
				getStoreDistances(stores, callingStore));

		// distributed action:
		markProductsUnavailableInStock(				
				storeProductAmounts, callingStore);	
		
		result = sumUpIncomingProducts(storeProductAmounts);			
		return result;
	}
	
	/**
	 * Sums up the incoming productAmounts of all stores
	 * @param storeProductAmounts
	 * @param callingStore
	 * @return List of ProductAmounts. Might contain duplicate product
	 * entries. Those duplicates have to be respected.
	 */
	private ProductAmountTO[] sumUpIncomingProducts(
			Hashtable<StoreTO, Collection<ProductAmountTO>> storeProductAmounts) {

		List<ProductAmountTO> resultList = new ArrayList<ProductAmountTO>();
		
		Enumeration<StoreTO> deliveringStores = storeProductAmounts.keys();
		StoreTO currentStore;
		while(deliveringStores.hasMoreElements())
		{
			currentStore = deliveringStores.nextElement();						
			resultList.addAll(storeProductAmounts.get(currentStore));
		}
		System.out.println("KK: ResultList.size: " + resultList.size());
		
		return resultList.toArray(new ProductAmountTO[resultList.size()]);
	}

	/**
	 * Marks all products (passed by storeProductAmounts) as incoming.
	 * Creates distributed calls at all store servers, whose store
	 * have to deliver products.
	 * @param storeProductAmounts Products/Amounts that habe to be delivered
	 * @param targetStore The target store to deliver to. (The initially calling
	 * store)
	 */
	private void markProductsUnavailableInStock(
			Hashtable<StoreTO, Collection<ProductAmountTO>> storeProductAmounts,			
			StoreTO targetStore) {

		Enumeration<StoreTO> deliveringStores = storeProductAmounts.keys();

		StoreTO currentStore;
		StoreIf storeIf;
		while(deliveringStores.hasMoreElements())
		{
			currentStore = deliveringStores.nextElement();			
			storeIf = 
				ApplicationFactory.getStoreInstance(currentStore.getId());						
			
			try {
				storeIf.markProductsUnavailableInStock(
						createProductMovements(storeProductAmounts, currentStore, targetStore)
						);
			} catch (RemoteException e) {
				throw new RuntimeException("Error setting products for delivery " +
						"for store " + currentStore.getName(), e);
			}	
		}
	} 
	
	/**
	 * Helper method to build a ProductMovement for a given
	 * combination of deliveringStore and targetStore
	 * @param storeProductAmounts
	 * @param deliveringStore
	 * @param targetStore
	 * @return new ProductMovement based on createProductMovements
	 */
	private ProductMovementTO createProductMovements(
			Hashtable<StoreTO, Collection<ProductAmountTO>> storeProductAmounts,
			StoreTO deliveringStore, StoreTO targetStore) {		
		
		ProductMovementTO productMovement = new ProductMovementTO();
		productMovement.setTargetStore(targetStore);
		productMovement.setDeliveringStore(deliveringStore);
		productMovement.setProducts(
				storeProductAmounts.get(deliveringStore));
		
		return productMovement;
	}
	

	/**
	 * Determines the available products for
	 * every store from the list of stores
	 * @param pctx The lookup is done locally within
	 * this PersistenceContext.
	 * @param stores The stores to look up
	 * @param productIds The products ids to loop up for.
	 * @return A Hashtable containing the available StockItems
	 * per Store.
	 */
	private Hashtable<Store, Collection<StockItem>>
			getOfferedStockItemsPerStore(
				Collection<Store> stores,
				long[] productIds) {
		Hashtable<Store, Collection<StockItem>> returnValue = 
			new Hashtable<Store, Collection<StockItem>>();
		
		Iterator<Store> iterator = stores.iterator();
		Store currentStore;
		while(iterator.hasNext())
		{
			currentStore = iterator.next();
			Collection<StockItem> stockItems =
				storeQuery.getStockItems(currentStore.getId(), productIds, pctx);
			returnValue.put(currentStore, stockItems);
		}
		
		return returnValue;
	}
	
	/**
	 * Advices all store servers from the given list to
	 * flush their local data. The data is written to
	 * the enterprise server database.
	 * @param pctx TODO: parameters need to be fixed. 
	 * @param stores
	 */
	private void letAllStoresFlushDatabase(
			PersistenceContext pctx,
			Collection<Store> stores) {
	
		Iterator<Store> iterator = stores.iterator();
		Store currentStore;
		while(iterator.hasNext())
		{
			currentStore = iterator.next();
			// TODO: multi-thread
			// TODO: The calls should be done at the store
			// servers via RMI (currently not supported by 
			// architecture
			// TODO: Introduce time-out for multi-threaded RMI
			// connections					
		}
	}

	/**
	 * Simple test for geograhical adjacency: the location
	 * strings of each store are compared to the callings stores
	 * location using "compareTo". 
	 * @param stores All stores possibly in the region.
	 * @param callingStore The store to check adjacency for.
	 * @return A list of stores and their distance to
	 * the calling store.
	 */
	private Hashtable<Store, Integer> getStoreDistances(
			Collection<Store> stores,
			StoreTO callingStore) {
		Hashtable<Store, Integer> storeDistances = new Hashtable<Store, Integer>();
		
		Iterator<Store> iterator = stores.iterator();
		while(iterator.hasNext())
		{
			Store currentStore = iterator.next();
			String location = currentStore.getLocation();
			String callingLocation = callingStore.getLocation();

			// currently simply abs(CompareTo):
			storeDistances.put(currentStore, 
					Math.abs(callingLocation.compareTo(location)));							
		}
		
		return storeDistances;
	}
	
	/**
	 * Returns a lists of ids of the given products (of the ProductAmounts)
	 * @param productAmounts
	 * @return
	 */
	private long[] getProductIds(Collection<ProductAmountTO> productAmounts) {
		long[] productIds = new long[productAmounts.size()];
		Iterator<ProductAmountTO> iterator = productAmounts.iterator();
		for(int x = 0; iterator.hasNext(); x++) {
			productIds[x] = iterator.next().getProduct().getId();
		}
		return productIds;
	}

}
