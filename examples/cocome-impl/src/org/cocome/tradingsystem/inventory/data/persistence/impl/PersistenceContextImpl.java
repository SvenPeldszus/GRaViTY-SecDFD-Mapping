package org.cocome.tradingsystem.inventory.data.persistence.impl;

import javax.persistence.EntityManager;

import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.TransactionContext;

/**
 * 
 * @author Yannick Welsch
 */
public class PersistenceContextImpl implements PersistenceContext {
	
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public PersistenceContextImpl(EntityManager em) {
		this.em = em;
	}

	public TransactionContext getTransactionContext() {
		return new TransactionContextImpl(em.getTransaction());
	}

	public void makePersistent(Object o) {
		em.persist(o);
	}

	public void close() {
		em.close();
	}
}
