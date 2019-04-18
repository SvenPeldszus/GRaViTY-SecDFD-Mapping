package org.cocome.tradingsystem.inventory.data.persistence;

/**
 * This interface is used by the application layer to handle persistence
 * @author Yannick Welsch
 */
public interface PersistenceIf {
	/**
	 * Method used to get a PersistenceContext 
	 * (to start transactions and persist objects for example)
	 * @return 
	 * 	the new PersistenceContext
	 */
	 PersistenceContext getPersistenceContext();
}
