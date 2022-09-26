package org.cocome.tradingsystem.inventory.data.persistence;

/**
 * 
 * @author Yannick Welsch
 */
public interface PersistenceContext {
	/**
	 * @return 
	 * 	the TransactionContext
	 */
	TransactionContext getTransactionContext();
	
	/**
	 * persists the given object
	 * @param o
	 * 	the object to be persisted
	 */
	void makePersistent(Object o);

	/**
	 * disposes the current PersistenceContext.
	 * No method on the current Context should be called after
	 * calling this method.
	 */
	void close();
}
