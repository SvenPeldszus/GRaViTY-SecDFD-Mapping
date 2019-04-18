package org.cocome.tradingsystem.external;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface to the Bank
 * 
 * @author Yannick Welsch
 */
public interface Bank extends Remote {
	/**
	 * Used to validate a credit card
	 * 
	 * @param cardInformation
	 * @param pinnumber
	 * @return
	 * @throws RemoteException
	 */
	TransactionID validateCard(String cardInformation, int pinnumber)
			throws RemoteException;

	/**
	 * Used to debit an bank account
	 * 
	 * @param id
	 *            The corresponding TransactionID
	 * @return
	 * @throws RemoteException
	 */
	Debit debitCard(TransactionID id) throws RemoteException;
}
