package org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller.impl;

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
import org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller.PrinterControllerEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;

/**
 * Implementation of the PrinterController component
 * 
 * @author Yannick Welsch
 */
public class PrinterControllerEventHandlerImpl implements MessageListener,
		PrinterControllerEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String topicName;

	private Context jndiContext;

	private PrinterController printercontroller;

	private PrinterStates state = PrinterStates.STOPPED;

	private Logger log = Logger
			.getLogger(PrinterControllerEventHandlerImpl.class);

	protected PrinterControllerEventHandlerImpl(String eventchannel,
			PrinterController printercontroller) {
		try {
			this.printercontroller = printercontroller;
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

				// A SaleStartedEvent has been received
				if (eventObject instanceof SaleStartedEvent) {
					SaleStartedEvent saleStartedEvent = (SaleStartedEvent) eventObject;
					onEvent(saleStartedEvent);
				}

				// A SaleFinishedEvent has been received
				if (eventObject instanceof SaleFinishedEvent) {
					SaleFinishedEvent saleFinishedEvent = (SaleFinishedEvent) eventObject;
					onEvent(saleFinishedEvent);
				}
				
				// A CashBoxClosedEvent has been received
				if (eventObject instanceof CashBoxClosedEvent) {
					CashBoxClosedEvent cashBoxClosedEvent = (CashBoxClosedEvent) eventObject;
					onEvent(cashBoxClosedEvent);
				}
				
				//A SaleSuccessEvent has been received
				if (eventObject instanceof SaleSuccessEvent) {
					SaleSuccessEvent saleSuccessEvent = (SaleSuccessEvent) eventObject;
					onEvent(saleSuccessEvent);
				}
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void onEvent(RunningTotalChangedEvent runningTotalChangedEvent) {
		log.info("RunningTotalChangedEvent received");
		if (state.equals(PrinterStates.STARTED)) {
			printercontroller.updatePrintout(runningTotalChangedEvent);
		}
	}

	public void onEvent(CashAmountEnteredEvent cashAmountEnteredEvent) {
		log.info("CashAmountEnteredEvent received");
		if (state.equals(PrinterStates.SALE_FINISHED)) {
			switch (cashAmountEnteredEvent.getKeyStroke()) {
			case ONE:
				printercontroller.append("1");
				break;
			case TWO:
				printercontroller.append("2");
				break;
			case THREE:
				printercontroller.append("3");
				break;
			case FOUR:
				printercontroller.append("4");
				break;
			case FIVE:
				printercontroller.append("5");
				break;
			case SIX:
				printercontroller.append("6");
				break;
			case SEVEN:
				printercontroller.append("7");
				break;
			case EIGHT:
				printercontroller.append("8");
				break;
			case NINE:
				printercontroller.append("9");
				break;
			case ZERO:
				printercontroller.append("0");
				break;
			case COMMA:
				printercontroller.append(".");
				break;
			case ENTER:
				printercontroller.cashamountentered();
				state = PrinterStates.CASH_AMOUNT_ENTERED;
				break;
			}
		}
	}

	public void onEvent(ChangeAmountCalculatedEvent changeAmountCalculatedEvent) {
		log.info("ChangeAmountCalculatedEvent received");
		if (state.equals(PrinterStates.CASH_AMOUNT_ENTERED)) {
			state = PrinterStates.CHANGE_AMOUNT_CALCULATED;
			printercontroller.updatePrintout(changeAmountCalculatedEvent);
		}
	}

	public void onEvent(SaleStartedEvent saleStartedEvent) {
		log.info("SaleStartedEvent received");
		if (state.equals(PrinterStates.STOPPED)) {
			state = PrinterStates.STARTED;
			printercontroller.newSale();
		}
	}

	public void onEvent(SaleFinishedEvent saleFinishedEvent) {
		log.info("SaleFinishedEvent received");
		if (state.equals(PrinterStates.STARTED)) {
			state = PrinterStates.SALE_FINISHED;
			printercontroller.finishSale();
		}
	}

	public void onEvent(CashBoxClosedEvent cashBoxClosedEvent) {
		log.info("CashBoxClosedEvent received");
		if (state.equals(PrinterStates.CHANGE_AMOUNT_CALCULATED)) {
			state = PrinterStates.STOPPED;
		}
	}

	public void onEvent(SaleSuccessEvent saleSuccessEvent) {
		log.info("SaleSuccessEvent received");
		state = PrinterStates.STOPPED;;
	}
}
