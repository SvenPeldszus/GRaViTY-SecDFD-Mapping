package org.cocome.tradingsystem.cashdeskline.coordinator.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.coordinator.CoordinatorEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleRegisteredEvent;

/**
 * Implementation of the Coordinator component
 * 
 * The coordinator is responsible for deciding which CashDesk to be switched to express mode or normal mode, respectively.
 * 
 * @author Yannick Welsch
 */
public class CoordinatorEventHandlerImpl implements MessageListener,
		CoordinatorEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private Context jndiContext;

	private TopicPublisher coordinatorPublisher;

	private TopicSession topicSession;

	private List<Sale> sales = new ArrayList<Sale>();

	private Logger log = Logger.getLogger(CoordinatorEventHandlerImpl.class);

	protected CoordinatorEventHandlerImpl(String externalchannel) {
		try {
			topicName = externalchannel;

			jndiContext = new InitialContext();

			// get TopicConnectionFactory
			javax.jms.TopicConnectionFactory channelConnectionFactory = (javax.jms.TopicConnectionFactory) jndiContext
					.lookup(this.CHANNEL_CONNECTION_FACTORY);

			// createTopicConnection
			TopicConnection topicConnection = channelConnectionFactory
					.createTopicConnection();

			// createTopicSession
			topicSession = topicConnection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// getTopic
			javax.jms.Topic cashDeskTopic = (javax.jms.Topic) jndiContext
					.lookup(this.topicName);

			TopicSubscriber topicSubscriber = topicSession
					.createSubscriber(cashDeskTopic);
			topicSubscriber.setMessageListener(this);

			coordinatorPublisher = topicSession.createPublisher(cashDeskTopic);

			topicConnection.start();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			List<Sale> copy = sales;
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
				Serializable eventObject = objMessage.getObject();

				// A SaleRegisteredEvent has been received
				if (eventObject instanceof SaleRegisteredEvent) {
					SaleRegisteredEvent saleRegisteredEvent = (SaleRegisteredEvent) eventObject;
					onEvent(saleRegisteredEvent);
					// reset Condition
					sales = new ArrayList<Sale>();
				}
			} catch (JMSException e) {
				sales = copy;
				e.printStackTrace();
			}
		}
	}

	public void onEvent(SaleRegisteredEvent saleRegisteredEvent) {
		log.info("SaleRegisteredEvent received");
		updateStatistics(saleRegisteredEvent.getNumberOfItems(),
				saleRegisteredEvent.getPaymentMode());
		if (isExpressModeNeeded()) {
			log.info("ExpressMode activated");
			try {
				coordinatorPublisher.publish(topicSession
						.createObjectMessage(new ExpressModeEnabledEvent(
								saleRegisteredEvent.getCashdesk())));
			} catch (JMSException e) {
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		} else {
			// The disabling of the ExpressMode is done manually by the cashier
			// at the CashDeskGUI
		}
	}

	private void updateStatistics(int numberofitems, PaymentMode paymentmode) {
		sales.add(new Sale(numberofitems, paymentmode, new Date()));
	}

	
	/*
	 * Checks the condition for UC 2:ManageExpressCheckout:
	 * 50% of all sales during the last 60 minutes meet the requirements of an express checkout.
	 * That is: up to 8 products per sale and customer pays cash.
	 */
	private boolean isExpressModeNeeded() {
		Date now = new Date();
		int meetscondition = 0;
		int total = 0;
		// clean list of old (non-relevant) entries
		for (Iterator<Sale> i = sales.iterator(); i.hasNext();) {
			Sale s = i.next();
			if (s.getTimeofSale().getTime() + 3600000 < now.getTime()) {
				i.remove();
			} else {
				if (s.getPaymentmode().equals(PaymentMode.CASH)
						&& s.getNumberofItems() <= 8) {
					meetscondition++;
				}
				total++;
			}
		}
		if (((double) meetscondition) / ((double) total) > 0.5) {
			return true;
		}
		return false;
	}
}
