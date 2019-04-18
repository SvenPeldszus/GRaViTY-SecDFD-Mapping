package org.cocome.tradingsystem.inventory.gui.store;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.cocome.tradingsystem.inventory.application.store.StoreIf;

/**
 * Helper class to connect to the remote application.store component
 * @author Yannick Welsch
 */
public class Connector {

	private StoreIf store;

	public Connector(String serveraddress, int port, String name)
			throws RemoteException {
		connect(serveraddress, port, name);
	}

	public void connect(String serveraddress, int port, String name)
			throws RemoteException {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Registry r = LocateRegistry.getRegistry(serveraddress, port);
			store = (StoreIf) r.lookup(name);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("NotBoundException", e);
		}
	}

	public StoreIf getStore() {
		return store;
	}
}
