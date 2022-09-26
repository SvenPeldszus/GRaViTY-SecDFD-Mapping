package org.cocome.tradingsystem.cashdeskline.cashdesk.gui.impl;

import java.io.Serializable;

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

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.cashdesk.gui.GUIEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScanFailedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.InvalidCreditCardEvent;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeNotValidEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;

/**
 * Implementation of the CashDeskGUI component
 * 
 * @author Yannick Welsch
 */
public class GUIEventHandlerImpl implements MessageListener, GUIEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private Context jndiContext;

	private Logger log = Logger.getLogger(GUIEventHandlerImpl.class);

	private CashDeskGUI gui;

	public GUIEventHandlerImpl(String eventchannel, CashDeskGUI gui) {
		try {
			this.gui = gui;
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

				// A RunningTotalChangedEvent has been received
				if (eventObject instanceof RunningTotalChangedEvent) {
					RunningTotalChangedEvent runningTotalChangedEvent = (RunningTotalChangedEvent) eventObject;
					onEvent(runningTotalChangedEvent);
				}

				// A CashAmountEnteredEvent has been received
				if (eventObject instanceof CashAmountEnteredEvent) {
					CashAmountEnteredEvent cashAmountEnteredEvent = (CashAmountEnteredEvent) eventObject;
					onEvent(cashAmountEnteredEvent);
				}

				// A ChangeAmountCalculatedEvent has been received
				if (eventObject instanceof ChangeAmountCalculatedEvent) {
					ChangeAmountCalculatedEvent changeAmountCalculatedEvent = (ChangeAmountCalculatedEvent) eventObject;
					onEvent(changeAmountCalculatedEvent);
				}

				// A ExpressModeDisabledEvent has been received
				if (eventObject instanceof ExpressModeDisabledEvent) {
					ExpressModeDisabledEvent expressModeDisabledEvent = (ExpressModeDisabledEvent) eventObject;
					onEvent(expressModeDisabledEvent);
				}

				// A ExpressModeEnabledEvent has been received
				if (eventObject instanceof ExpressModeEnabledEvent) {
					ExpressModeEnabledEvent expressModeEnabledEvent = (ExpressModeEnabledEvent) eventObject;
					onEvent(expressModeEnabledEvent);
				}

				// A InvalidCreditCardEvent has been received
				if (eventObject instanceof InvalidCreditCardEvent) {
					InvalidCreditCardEvent invalidCreditCardEvent = (InvalidCreditCardEvent) eventObject;
					onEvent(invalidCreditCardEvent);
				}

				// A CreditCardScanFailedEvent has been received
				if (eventObject instanceof CreditCardScanFailedEvent) {
					CreditCardScanFailedEvent creditCardScanFailedEvent = (CreditCardScanFailedEvent) eventObject;
					onEvent(creditCardScanFailedEvent);
				}

				if (eventObject instanceof ProductBarcodeNotValidEvent) {
					ProductBarcodeNotValidEvent productBarcodeNotValidEvent = (ProductBarcodeNotValidEvent) eventObject;
					onEvent(productBarcodeNotValidEvent);
				}

				if (eventObject instanceof SaleSuccessEvent) {
					SaleSuccessEvent saleSuccessEvent = (SaleSuccessEvent) eventObject;
					onEvent(saleSuccessEvent);
				}

				if (eventObject instanceof SaleStartedEvent) {
					SaleStartedEvent saleStartedEvent = (SaleStartedEvent) eventObject;
					onEvent(saleStartedEvent);
				}

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void onEvent(RunningTotalChangedEvent runningTotalChangedEvent) {
		log.info("RunningTotal changed");

		gui.updateProductInfo(runningTotalChangedEvent.getProductName(),
				runningTotalChangedEvent.getProductPrice(),
				runningTotalChangedEvent.getRunningTotal());
	}

	public void onEvent(CashAmountEnteredEvent moneyAmountEnteredEvent) {
		// TODO Auto-generated method stub
	}

	public void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent) {
		log.info("ChangeAmountCalculatedEvent received");
		gui.setCashAmount(changeAmountCalculatedEvent.getChangeAmount());
	}

	public void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent) {
		log.info("ExpressModeDisabledEvent received");
		gui.onExpressModeDisabledEvent(expressModeDisabledEvent);
	}

	public void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent) {
		log.info("ExpressModeEnabledEvent received");
		gui.onExpressModeEnabledEvent(expressModeEnabledEvent);
	}

	public void onEvent(InvalidCreditCardEvent invalidCreditCardEvent) {
		log.info("InvalidCreditCardEvent received");
		gui.onInvalidCreditCard(invalidCreditCardEvent);
	}

	public void onEvent(CreditCardScanFailedEvent creditCardScanFailedEvent) {
		log.info("CreditCardScanFailedEvent received");
		gui.onCreditCardScanFailed(creditCardScanFailedEvent);
	}

	public void onEvent(ProductBarcodeNotValidEvent productBarcodeNotValidEvent) {
		log.info("ProductBarcodeNotValidEvent received");
		gui.setBarcodeNotValid(productBarcodeNotValidEvent.getBarcode());
	}

	public void onEvent(SaleSuccessEvent saleSuccessEvent) {
		log.info("SaleSuccessEvent received");
		gui.onFinished(saleSuccessEvent);
	}

	public void onEvent(SaleStartedEvent saleStartedEvent) {
		log.info("SaleSuccessEvent received");
		gui.onStarted(saleStartedEvent);
	}

}
