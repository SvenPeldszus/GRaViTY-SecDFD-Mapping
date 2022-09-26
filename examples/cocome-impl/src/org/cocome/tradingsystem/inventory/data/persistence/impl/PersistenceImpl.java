package org.cocome.tradingsystem.inventory.data.persistence.impl;

import javax.persistence.EntityManagerFactory;

import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;

/**
 * 
 * @author Yannick Welsch
 */
public class PersistenceImpl implements PersistenceIf {
	
	private EntityManagerFactory emf;
	
	public PersistenceImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public PersistenceContext getPersistenceContext() {
		return new PersistenceContextImpl(emf.createEntityManager());
	}
}
