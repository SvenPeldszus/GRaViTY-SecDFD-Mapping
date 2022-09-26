package org.cocome.tradingsystem.inventory.application;

import java.io.Serializable;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import org.cocome.tradingsystem.inventory.application.productdispatcher.ProductDispatcherIf;
import org.cocome.tradingsystem.inventory.application.productdispatcher.impl.ProductDispatcher;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.events.AccountSaleEvent;
import org.cocome.tradingsystem.inventory.application.reporting.ReportingIf;
import org.cocome.tradingsystem.inventory.application.reporting.impl.ReportingImpl;
import org.cocome.tradingsystem.inventory.application.store.CashDeskConnectorIf;
import org.cocome.tradingsystem.inventory.application.store.StoreIf;
import org.cocome.tradingsystem.inventory.application.store.impl.StoreImpl;

/**
 * Factory to create an application component
 *
 * @author Yannick Welsch
 */
public class ApplicationFactory {
	final static String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private static final Logger log = Logger
			.getLogger(ApplicationFactory.class);

	/**
	 *
	 * @return a new Reporting component instance
	 */
	public static ReportingIf getReportingInstance() {
		ReportingIf result = null;
		try {
			result = new ReportingImpl();
		} catch (RemoteException e) {
			// Cannot happen, is locally created
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * @param storeid
	 *            the store to be affected
	 * @return a new Store component instance with StoreIf interface
	 */
	public static StoreIf getStoreInstance(long storeid) {
		StoreIf result = null;
		try {
			result = new StoreImpl(storeid);
		} catch (RemoteException e) {
			// Cannot happen, is locally created
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * @param storeid
	 *            the store to be affected
	 * @return a new Store component instance with CashDeskConnectorIf interface
	 */
	public static CashDeskConnectorIf getCashDeskInstance(long storeid) {
		CashDeskConnectorIf result = null;
		try {
			result = new StoreImpl(storeid);
		} catch (RemoteException e) {
			// Cannot happen, is locally created
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author SDQ
	 * @return a new instance of the ProductDispatcher
	 */
	public static ProductDispatcherIf getProductDispatcherInstance() {
		ProductDispatcherIf result = null;
		try {
			result = new ProductDispatcher();
		} catch (RemoteException e) {
			// Cannot happen, is locally created
			e.printStackTrace();
		}
		return result;
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

	private static void registerAtMessageQueue(String topicName, final CashDeskConnectorIf store) throws JMSException, NamingException {
		Context jndiContext = new InitialContext();

		// get TopicConnectionFactory
		TopicConnectionFactory channelConnectionFactory = (TopicConnectionFactory) jndiContext
				.lookup(CHANNEL_CONNECTION_FACTORY);

		// createTopicConnection
		TopicConnection topicConnection = channelConnectionFactory.createTopicConnection();

		// createTopicSession
		TopicSession topicSession = topicConnection.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// getTopic
		Topic storeTopic = (javax.jms.Topic) jndiContext
				.lookup(topicName);

		TopicSubscriber externalSubscriber = topicSession.createSubscriber(storeTopic);

		externalSubscriber.setMessageListener(new MessageListener() {

			public void onMessage(Message message) {
				if (message instanceof ObjectMessage) {
					ObjectMessage objMessage = (ObjectMessage) message;
					try {
						Serializable eventObject = objMessage.getObject();

						// A AccountSaleEvent has been received
						if (eventObject instanceof AccountSaleEvent) {
							AccountSaleEvent accountSaleEvent = (AccountSaleEvent) eventObject;
							log.info("AccountSaleEvent received");
							try {
								store.bookSale(accountSaleEvent.getSale());
							} catch (RemoteException e) {
								//never happens, called locally
							}
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}

		});

		topicConnection.start();
	}

	/**
	 * used by ant target to register store or reporting component at rmi
	 * registry - for store registration, call with "type name storeid" - for
	 * cashdesk registration, call with "type name storeid" - for reporting
	 * registration, call with "type name"
	 *
	 * @param args
	 *            where arg[0] == 1 if store is to be registered or arg[0] == 0
	 *            if reporting is to be registered
	 * @throws RemoteException
	 * @throws NamingException
	 * @throws JMSException
	 */
	public static void main(String[] args) throws RemoteException,
			InterruptedException, JMSException, NamingException {
		if (args.length == 4 && args[0].equals("0")) {
			try {
				registerAtRegistry(args[3], getReportingInstance(), args[1],
						Integer.parseInt(args[2]));
				Thread.sleep(999999999999999L);
			} catch (RemoteException e) {
				e.printStackTrace();
				throw e;
			}
		} else if (args.length == 5 && args[0].equals("1")) {
			try {
				StoreImpl store = new StoreImpl(Long
						.parseLong(args[4]));

				registerAtRegistry(args[3], store, args[1], Integer
						.parseInt(args[2]));

				registerAtMessageQueue(args[3], store);

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