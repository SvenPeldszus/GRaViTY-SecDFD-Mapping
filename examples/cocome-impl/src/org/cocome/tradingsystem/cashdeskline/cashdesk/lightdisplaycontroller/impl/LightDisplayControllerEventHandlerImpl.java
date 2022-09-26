package org.cocome.tradingsystem.cashdeskline.cashdesk.lightdisplaycontroller.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.cashdesk.lightdisplaycontroller.LightDisplayControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LightDisplayControllerEventHandlerImpl implements MessageListener,
		LightDisplayControllerEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private Context jndiContext;

	private LightDisplayController controller;

	private Logger log = Logger
			.getLogger(LightDisplayControllerEventHandlerImpl.class);

	/**
	 * 
	 * @param eventchannel
	 */
	public LightDisplayControllerEventHandlerImpl(String eventchannel,
			LightDisplayController controller) {
		try {
			this.controller = controller;
			topicName = eventchannel;

			jndiContext = new InitialContext();

			// get TopicConnectionFactory
			javax.jms.TopicConnectionFactory topicConnectionFactory = (javax.jms.TopicConnectionFactory) jndiContext
					.lookup(this.CHANNEL_CONNECTION_FACTORY);

			// createTopicConnection
			TopicConnection topicConnection = topicConnectionFactory
					.createTopicConnection();

			// createTopicSession
			TopicSession topicSession = topicConnection.createTopicSession(
					false, Session.AUTO_ACKNOWLEDGE);

			// getTopic
			javax.jms.Topic cashDeskTopic = (javax.jms.Topic) jndiContext
					.lookup(this.topicName);

			TopicSubscriber topicSubscriber = topicSession
					.createSubscriber(cashDeskTopic);
			topicSubscriber.setMessageListener(this);
			topicConnection.start();

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
		controller.update(expressModeEnabledEvent);
	}

	public void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent) {
		log.info("ExpressModeDisabledEvent received");
		controller.update(expressModeDisabledEvent);
	}

}
