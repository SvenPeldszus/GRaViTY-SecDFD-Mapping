package org.cocome.tradingsystem.external.impl;

import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.cocome.tradingsystem.external.Bank;
import org.cocome.tradingsystem.external.Debit;
import org.cocome.tradingsystem.external.TransactionID;

/**
 * Very basic implementation of the bank
 * 
 * @author Yannick Welsch
 */
public class BankImpl extends UnicastRemoteObject implements Bank {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5047848653168860307L;

	public BankImpl() throws RemoteException {
		super();
	}

	public Debit debitCard(TransactionID id) {
		if (!id.equals(new TransactionID(23L))) {
			return Debit.TRANSACTION_ID_NOT_VALID;
		}
		if (Math.random() > 0.5) {
			return Debit.NOT_ENOUGH_MONEY;
		}
		return Debit.OK;
	}

	public TransactionID validateCard(String cardInformation, int cardnumber) {
		if (cardInformation.equals("blablabla") && cardnumber == 7777) {
			return new TransactionID(23L);
		}
		return null;
	}

	private static void registerAtRegistry(String name, Remote r, String host,
			int port) throws RemoteException {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		Registry reg = LocateRegistry.getRegistry(host, port);
		reg.rebind(name, r);
		System.out.println("Registered with name " + name);
	}

	public static void main(String[] args) throws RemoteException,
			InterruptedException {
		if (args.length == 3) {
			try {
				registerAtRegistry(args[0], new BankImpl(), args[1], Integer
						.parseInt(args[2]));
				Thread.sleep(999999999999999L);
			} catch (RemoteException e) {
				e.printStackTrace();
				throw e;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
