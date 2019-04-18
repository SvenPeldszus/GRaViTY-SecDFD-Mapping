package org.cocome.tradingsystem.inventory.data.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cocome.tradingsystem.inventory.data.DataIf;
import org.cocome.tradingsystem.inventory.data.enterprise.EnterpriseQueryIf;
import org.cocome.tradingsystem.inventory.data.enterprise.impl.EnterpriseQueryImpl;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;
import org.cocome.tradingsystem.inventory.data.persistence.impl.PersistenceImpl;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;
import org.cocome.tradingsystem.inventory.data.store.impl.StoreQueryImpl;

/**
 * 
 * @author Yannick Welsch
 */
public class DataImpl implements DataIf {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("inventory-manager");
	
	public EnterpriseQueryIf getEnterpriseQueryIf() {
		return new EnterpriseQueryImpl();
	}

	public PersistenceIf getPersistenceManager() {
		return new PersistenceImpl(emf);
	}

	public StoreQueryIf getStoreQueryIf() {
		return new StoreQueryImpl();
	}

}
