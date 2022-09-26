package org.cocome.tradingsystem.cashdeskline.cashdesk.scannercontroller.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.cocome.tradingsystem.cashdeskline.cashdesk.scannercontroller.ScannerControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeScannedEvent;

/**
 * Implementation of the ScannerController component
 * 
 * @author Yannick Welsch
 */
public class ScannerControllerEventHandlerImpl implements
		ScannerControllerEventHandlerIf {
	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private javax.jms.TopicConnectionFactory channelConnectionFactory;

	private TopicConnection topicConnection;

	private TopicSession topicSession;

	private javax.jms.Topic cashDeskTopic;

	private TopicPublisher barcodePublisher;

	private Context jndiContext;

	protected ScannerControllerEventHandlerImpl(String eventchannel) {
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

			barcodePublisher = topicSession.createPublisher(cashDeskTopic);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void sendProductBarcodeScannedEvent(
			ProductBarcodeScannedEvent productBarcodeScannedEvent) {
		try {
			barcodePublisher.publish(topicSession
					.createObjectMessage(productBarcodeScannedEvent));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
