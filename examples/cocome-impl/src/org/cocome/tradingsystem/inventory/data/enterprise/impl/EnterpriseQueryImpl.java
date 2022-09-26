package org.cocome.tradingsystem.inventory.data.enterprise.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.cocome.tradingsystem.inventory.data.enterprise.EnterpriseQueryIf;
import org.cocome.tradingsystem.inventory.data.enterprise.ProductSupplier;
import org.cocome.tradingsystem.inventory.data.enterprise.TradingEnterprise;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.impl.PersistenceContextImpl;
import org.cocome.tradingsystem.inventory.data.store.ProductOrder;

/**
 * 
 * @author Yannick Welsch
 */
public class EnterpriseQueryImpl implements EnterpriseQueryIf {

	public TradingEnterprise queryEnterpriseById(long enterpriseId, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		return em.getReference(TradingEnterprise.class, enterpriseId);
	}
	
	@SuppressWarnings("unchecked")
	public long getMeanTimeToDelivery(ProductSupplier supplier, 
			TradingEnterprise enterprise, PersistenceContext pctx) {
		EntityManager em = ((PersistenceContextImpl)pctx).getEntityManager();
		List<ProductOrder> pos = em.createQuery(
				"select productorder from ProductOrder as productorder where " +
				"productorder.deliveryDate is not null and " +
				"exists (select orderentry from OrderEntry as orderentry where orderentry.order = productorder and " +
				"exists (select product from Product as product where product.supplier = ?1 and orderentry.product = product)) " +
				"and exists (select store from Store as store where productorder.store = store and store.enterprise = ?2) ")
			.setParameter(1, supplier)
			.setParameter(2, enterprise)
			.getResultList();
		
		long result = 0;
		
		for (ProductOrder po : pos) {
			result = result +
				(po.getDeliveryDate().getTime() - po.getOrderingDate().getTime());
		}
		return result;
		
	}
}
