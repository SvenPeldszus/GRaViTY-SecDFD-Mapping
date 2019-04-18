package org.cocome.tradingsystem.inventory.data.persistence.impl;

import javax.persistence.EntityTransaction;

import org.cocome.tradingsystem.inventory.data.persistence.TransactionContext;

/**
 * 
 * @author Yannick Welsch
 */
public class TransactionContextImpl implements TransactionContext {
	
	private EntityTransaction t;
	
	public TransactionContextImpl(EntityTransaction t) {
		this.t = t;
	}

	public void beginTransaction() {
		t.begin();
	}

	public void commit() {
		t.commit();
	}

	public void rollback() {
		t.rollback();
	}

	public Boolean isActive() {
		return t.isActive();
	}
}
