package org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller.CardReaderControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.PINEnteredEvent;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Implementation of the CardReader component
 * 
 * @author Yannick Welsch
 */
public class CardReaderControllerEventHandlerImpl implements MessageListener,
		CardReaderControllerEventHandlerIf {
	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private javax.jms.TopicConnectionFactory channelConnectionFactory;

	private TopicConnection topicConnection;

	private TopicSession topicSession;

	private javax.jms.Topic cashDeskTopic;

	private TopicPublisher cardreaderPublisher;

	private boolean expressModeEnabled = false;

	private Context jndiContext;

	private Logger log = Logger
			.getLogger(CardReaderControllerEventHandlerImpl.class);

	/**
	 * 
	 * @param args
	 *            args[0] should contain the name of the topic, for example
	 *            CashDeskChannel1
	 */
	protected CardReaderControllerEventHandlerImpl(String eventchannel) {
		try {
			topicName = eventchannel;

			jndiContext = new InitialContext();

			// get TopicConnectionFactory
			channelConnectionFactory = (javax.jms.TopicConnectionFactory) jndiContext
					.lookup(this.CHANNEL_CONNECTION_FACTORY);

			// createTopicConnection
			topicConnection = channelConnectionFactory.createTopicConnection();

			// createTopicSession
			topicSession = topicConnection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// getTopic
			cashDeskTopic = (javax.jms.Topic) jndiContext
					.lookup(this.topicName);

			cardreaderPublisher = topicSession.createPublisher(cashDeskTopic);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
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
				if (eventObject instanceof ExpressModeEnabledEvent) {
					ExpressModeEnabledEvent expressModeEnabledEvent = (ExpressModeEnabledEvent) eventObject;
					onEvent(expressModeEnabledEvent);
				}

				// A ExpressModeDisabledEvent has been received
				if (eventObject instanceof ExpressModeDisabledEvent) {
					ExpressModeDisabledEvent expressModeDisabledEvent = (ExpressModeDisabledEvent) eventObject;
					onEvent(expressModeDisabledEvent);
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent) {
		log.info("ExpressModeEnabledEvent received");
		expressModeEnabled = true;
	}

	public void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent) {
		log.info("ExpressModeDisabledEvent received");
		expressModeEnabled = false;
	}

	public void sendCreditCardScannedEvent(
			CreditCardScannedEvent creditCardScannedEvent) {
		if (!expressModeEnabled) {
			try {
				cardreaderPublisher.publish(topicSession
						.createObjectMessage(creditCardScannedEvent));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendPINEnteredEvent(PINEnteredEvent pINEnteredEvent) {
		if (!expressModeEnabled) {
			try {
				cardreaderPublisher.publish(topicSession
						.createObjectMessage(pINEnteredEvent));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
