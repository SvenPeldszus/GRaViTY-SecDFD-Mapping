package org.cocome.tradingsystem.inventory.application.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;

/**
 * Structure to represent products moved from one store to another.
 * Stores the delivering and target Store and a list of product amounts.
 * <p>
 * Required for UC 8
 * @author kelsaka
 *
 */
public class ProductMovementTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6086062214137352097L;
	private StoreTO deliveringStore;
	private StoreTO targetStore;
	private Collection<ProductAmountTO> products;
	
	/**
	 * Initializes an empty product list.
	 */
	public ProductMovementTO() {
		this.products = new ArrayList<ProductAmountTO>();
	}
	
	/**
	 * A list of product that have to be delivered
	 * by the store {@link getDeliveringStore}.
	 * @return
	 */
	public Collection<ProductAmountTO> getProducts() {
		return products;
	}
	
	/**
	 * A list of product that have to be delivered
	 * by the store {@link getDeliveringStore}.
	 * @param products product list
	 */
	
	public void setProducts(Collection<ProductAmountTO> products) {
		this.products = products;
	}
	
	/**
	 * The store that has to deliver the products.
	 * @return
	 */
	public StoreTO getDeliveringStore() {
		return deliveringStore;
	}
	
	/**
	 * The store that has to deliver the products.
	 * @param deliveringStore Store Identifier
	 */
	public void setDeliveringStore(StoreTO deliveringStore) {
		this.deliveringStore = deliveringStore;
	}

	/**
	 * The store that receives the products.
	 * @return
	 */
	public StoreTO getTargetStore() {
		return targetStore;
	}

	/**
	 * The store that receives the products.
	 * @param targetStore set the target store
	 */
	public void setTargetStore(StoreTO targetStore) {
		this.targetStore = targetStore;
	}
	
	
}
