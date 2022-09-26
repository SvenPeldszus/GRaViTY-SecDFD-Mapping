package org.cocome.tradingsystem.cashdeskline.coordinator.impl;

/**
 * GUI for the Coordinator component
 * @author Yannick Welsch
 */
public class Coordinator {
	
	/**
	 * Starts the Coordinator
	 * @param args where args[0] is the externComm channel
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new CoordinatorEventHandlerImpl(args[0]);
		Thread.sleep(99999999999L);
	}

}
