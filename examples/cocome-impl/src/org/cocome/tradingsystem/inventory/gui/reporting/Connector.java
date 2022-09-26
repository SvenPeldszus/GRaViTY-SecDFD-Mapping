package org.cocome.tradingsystem.inventory.gui.reporting;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;

/**
 * Helper class to connect to the remote application.reporting component 
 * @author Yannick Welsch
 */
public class Connector {

	private ReportingIf rep;

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
			rep = (ReportingIf) r.lookup(name);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("NotBoundException", e);
		}
	}

	public ReportingIf getReporting() {
		return rep;
	}
}
