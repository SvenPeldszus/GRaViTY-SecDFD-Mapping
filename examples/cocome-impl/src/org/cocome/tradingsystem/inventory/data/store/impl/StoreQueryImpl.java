package org.cocome.tradingsystem.inventory.data.store.impl;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.EntityManager;

import org.cocome.tradingsystem.inventory.data.enterprise.Product;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.impl.PersistenceContextImpl;
import org.cocome.tradingsystem.inventory.data.store.ProductOrder;
import org.cocome.tradingsystem.inventory.data.store.StockItem;
import org.cocome.tradingsystem.inventory.data.store.Store;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;

/**
 * 
 * @author Yannick Welsch
 */
public class StoreQueryImpl implements StoreQueryIf {

	@SuppressWarnings("unchecked")
	public Collection<StockItem> queryLowStockItems(long storeId,
			PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		Collection<StockItem> result = Collections.emptySet();
		Store store = em.getReference(Store.class, storeId);

		result = em
				.createQuery(
						"select stockitem from StockItem as stockitem where stockitem.store = ?1 and stockitem.amount < stockitem.minStock")
				.setParameter(1, store).getResultList();

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<StockItem> queryAllStockItems(long storeId,
			PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		Collection<StockItem> result = Collections.emptySet();
		Store store = em.getReference(Store.class, storeId);

		result = em
				.createQuery(
						"select stockitem from StockItem as stockitem where stockitem.store = ?1")
				.setParameter(1, store).getResultList();

		return result;
	}

	public ProductOrder queryOrderById(long orderId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		ProductOrder result = null;

		result = em.find(ProductOrder.class, orderId);

		return result;
	}

	public Store queryStoreById(long storeId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		Store result = null;

		result = em.find(Store.class, storeId);

		return result;
	}

	@SuppressWarnings("unchecked")
	public Collection<Product> queryProducts(long storeId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		Collection<Product> result = Collections.emptySet();

		Store store = em.getReference(Store.class, storeId);
		result = em
				.createQuery(
						"select product from Product as product where exists (select stockitem from StockItem as stockitem where stockitem.store = ?1 and stockitem.product = product)")
				.setParameter(1, store).getResultList();

		return result;
	}

	@SuppressWarnings("unchecked")
	public StockItem queryStockItem(long storeId, long productbarcode,
			PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		StockItem result = null;

		Collection<Product> prodref = em
				.createQuery(
						"select product from Product as product where product.barcode = ?1")
				.setParameter(1, productbarcode)
				.getResultList();
		if (prodref.size() == 0) {
			return null;
		}
		
		Store store = em.getReference(Store.class, storeId);
		Collection<StockItem> results = em
				.createQuery(
						"select stockitem from StockItem as stockitem where stockitem.store = ?1 and stockitem.product = ?2")
				.setParameter(1, store)
				.setParameter(2, prodref.iterator().next())
				.getResultList();
		//TODO: print Error if result.size() > 1
		if (results.size() > 0)
			result = results.iterator().next();

		return result;
	}

	public StockItem queryStockItemById(long stockId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		return em.getReference(StockItem.class, stockId);
	}

	public Product queryProductById(long productId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		return em.getReference(Product.class, productId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.cocome.tradingsystem.inventory.data.store.StoreQueryIf#getStockItems(long[])
	 */
	@SuppressWarnings("unchecked")
	public Collection<StockItem> getStockItems(long storeId, long[] productIds, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();	

		//TODO: implement SDQ
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x < productIds.length; x++) {
			sb.append("stockitem.product.id = " + productIds[0]);
			if(x < productIds.length - 1) { //not last
				sb.append(" OR "); 
			}
		}
		
		Store store = em.getReference(Store.class, storeId);
		Collection<StockItem> results = em
				.createQuery(
						"SELECT stockitem FROM StockItem AS stockitem WHERE stockitem.store = ?1 AND (" + sb.toString() + ")")
				.setParameter(1, store)
				.getResultList();

		return results;
	}
}
