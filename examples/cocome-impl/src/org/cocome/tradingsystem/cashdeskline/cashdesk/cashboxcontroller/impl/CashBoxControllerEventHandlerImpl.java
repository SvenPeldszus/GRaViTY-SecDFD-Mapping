package org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller.impl;

import java.io.Serializable;

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
import org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller.CashBoxControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PaymentModeEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;

/**
 * Implementation for the CashBox component
 * 
 * @author Yannick Welsch
 */
public class CashBoxControllerEventHandlerImpl implements MessageListener,
		CashBoxControllerEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private Context jndiContext;

	private TopicPublisher cashBoxPublisher;

	private TopicSession topicSession;

	private Logger log = Logger
			.getLogger(CashBoxControllerEventHandlerImpl.class);

	private CashBox cashbox;

	protected CashBoxControllerEventHandlerImpl(CashBox cashbox,
			String eventchannel) {
		try {
			this.cashbox = cashbox;

			topicName = eventchannel;

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

			cashBoxPublisher = topicSession.createPublisher(cashDeskTopic);

			topicConnection.start();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is called by the channel if an event has been published. The
	 * medhod then unmarshalls the message and calls the appropriate local event
	 * handler methods.
	 */
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
				Serializable eventObject = objMessage.getObject();

				// A ExpressModeEnabledEvent has been received
				if (eventObject instanceof ChangeAmountCalculatedEvent) {
					ChangeAmountCalculatedEvent changeAmountCalculatedEvent = (ChangeAmountCalculatedEvent) eventObject;
					onEvent(changeAmountCalculatedEvent);
				}
			} catch (JMSException e) {
				log.error(e);
				e.printStackTrace();
			}
		}
	}

	public void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent) {
		log.info("ChangeAmountCalculatedEvent received");
		cashbox.openCashBox();
	}

	public void sendSaleStartedEvent(SaleStartedEvent saleStartedEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(saleStartedEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendSaleFinishedEvent(SaleFinishedEvent saleFinishedEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(saleFinishedEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendPaymentModeEvent(PaymentModeEvent paymentModeEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(paymentModeEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendCashAmountEnteredEvent(
			CashAmountEnteredEvent cashAmountEnteredEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(cashAmountEnteredEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendCashBoxClosedEvent(CashBoxClosedEvent cashBoxClosedEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(cashBoxClosedEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendExpressModeDisabledEvent(
			ExpressModeDisabledEvent expressModeDisabledEvent) {
		try {
			cashBoxPublisher.publish(topicSession
					.createObjectMessage(expressModeDisabledEvent));
		} catch (JMSException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

}
