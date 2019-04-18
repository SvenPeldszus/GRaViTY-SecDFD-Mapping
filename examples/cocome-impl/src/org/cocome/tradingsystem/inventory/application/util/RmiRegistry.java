package org.cocome.tradingsystem.inventory.application.util;

import java.io.DataInput;
import java.io.DataInputStream;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import sun.rmi.registry.RegistryImpl;

/**
 * Helper class to start rmiregistry from an ant target
 * @author Yannick Welsch
 */
public class RmiRegistry {
	public static void main(String[] args) throws RemoteException {
		int port;
		if (args.length == 0)
			throw new IllegalArgumentException();
		if (args.length < 1)
			port = 1099;
		else
			port = Integer.valueOf(args[0]).intValue();

		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			new RegistryImpl(port);
			//LocateRegistry.createRegistry(port);

			DataInput in = new DataInputStream(System.in);
			// Serve clients
			while (true) {
				System.out.println("Type EXIT to shutdown the registry.");
				if ("EXIT".equalsIgnoreCase(in.readLine())) {
					break;
				}
			}
			System.out.println("BYE");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
			System.exit(2);
		}
	}
}
