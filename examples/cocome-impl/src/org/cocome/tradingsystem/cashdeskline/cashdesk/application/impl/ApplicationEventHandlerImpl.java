package org.cocome.tradingsystem.cashdeskline.cashdesk.application.impl;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.cocome.tradingsystem.cashdeskline.cashdesk.application.ApplicationEventHandlerIf;
import org.cocome.tradingsystem.cashdeskline.datatypes.PaymentMode;
import org.cocome.tradingsystem.cashdeskline.events.AccountSaleEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashAmountEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.CashBoxClosedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ChangeAmountCalculatedEvent;
import org.cocome.tradingsystem.cashdeskline.events.CreditCardScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.InvalidCreditCardEvent;
import org.cocome.tradingsystem.cashdeskline.events.PINEnteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.PaymentModeEvent;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeNotValidEvent;
import org.cocome.tradingsystem.cashdeskline.events.ProductBarcodeScannedEvent;
import org.cocome.tradingsystem.cashdeskline.events.RunningTotalChangedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleFinishedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleRegisteredEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleStartedEvent;
import org.cocome.tradingsystem.cashdeskline.events.SaleSuccessEvent;
import org.cocome.tradingsystem.external.Bank;
import org.cocome.tradingsystem.external.Debit;
import org.cocome.tradingsystem.external.TransactionID;
import org.cocome.tradingsystem.inventory.application.store.CashDeskConnectorIf;
import org.cocome.tradingsystem.inventory.application.store.NoSuchProductException;
import org.cocome.tradingsystem.inventory.application.store.ProductWithStockItemTO;
import org.cocome.tradingsystem.inventory.application.store.SaleTO;

import javax.jms.MessageListener;
import static org.cocome.tradingsystem.cashdeskline.cashdesk.application.impl.CashDeskStates.*;

/**
 * Implementation of the ApplicationEventHandler
 * 
 * @author Yannick Welsch
 */
public class ApplicationEventHandlerImpl implements MessageListener,
		ApplicationEventHandlerIf {

	final String CHANNEL_CONNECTION_FACTORY = "ChannelConnectionFactory";

	private String bankname;

	private String registrybaseurl;

	private int registryport;

	private String topicName;

	private CashDeskConnectorIf inventory;

	private Context jndiContext;

	private TopicSession topicSession;

	private TopicPublisher appPublisher;

	private TopicPublisher externalPublisher;

	private CashDeskStates currState = INITIALIZED;

	private Logger log = Logger.getLogger(ApplicationEventHandlerImpl.class);

	private String cardInformation = null;

	private double runningtotal = 0.0;

	private TransactionID transactionid;

	private StringBuilder total = new StringBuilder("");

	private List<ProductWithStockItemTO> products = new ArrayList<ProductWithStockItemTO>();

	private boolean expressModeEnabled = false;

	public ApplicationEventHandlerImpl(String registryurl, int port,
			String bankName, String topicName, String storeName) {
		try {
			this.topicName = topicName;

			this.bankname = bankName;

			this.registrybaseurl = registryurl;

			this.registryport = port;

			jndiContext = new InitialContext();

			inventory = (CashDeskConnectorIf) connect(storeName);

			// get TopicConnectionFactory
			javax.jms.TopicConnectionFactory topicConnectionFactory = (javax.jms.TopicConnectionFactory) jndiContext
					.lookup(this.CHANNEL_CONNECTION_FACTORY);

			// createTopicConnection
			TopicConnection topicConnection = topicConnectionFactory
					.createTopicConnection();

			// createTopicSession (TransactionMode ENABLED)
			topicSession = topicConnection.createTopicSession(true,
					Session.AUTO_ACKNOWLEDGE);

			// getTopic
			Topic cashDeskTopic = (javax.jms.Topic) jndiContext
					.lookup(this.topicName);
			Topic externalTopic = (javax.jms.Topic) jndiContext
					.lookup(storeName);

			TopicSubscriber topicSubscriber = topicSession
					.createSubscriber(cashDeskTopic);
			topicSubscriber.setMessageListener(this);

			TopicSubscriber externalSubscriber = topicSession
					.createSubscriber(externalTopic);
			externalSubscriber.setMessageListener(this);

			appPublisher = topicSession.createPublisher(cashDeskTopic);

			externalPublisher = topicSession.createPublisher(externalTopic);

			topicConnection.start();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private Remote connect(String name) throws RemoteException {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Registry r = LocateRegistry.getRegistry(registrybaseurl,
					registryport);
			return r.lookup(name);
		} catch (NotBoundException e) {
			e.printStackTrace();
			throw new RemoteException("NotBoundException", e);
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

				// A SaleStartedEvent has been received
				if (eventObject instanceof SaleStartedEvent) {
					SaleStartedEvent saleStartedEvent = (SaleStartedEvent) eventObject;
					onEvent(saleStartedEvent);
				}

				// A ProductBarcodeScannedEvent has been received
				if (eventObject instanceof ProductBarcodeScannedEvent) {
					ProductBarcodeScannedEvent barcodeEvent = (ProductBarcodeScannedEvent) eventObject;
					onEvent(barcodeEvent);
				}

				// A SaleFinishedEvent has been received
				if (eventObject instanceof SaleFinishedEvent) {
					SaleFinishedEvent saleFinishedEvent = (SaleFinishedEvent) eventObject;
					onEvent(saleFinishedEvent);
				}

				// A CashAmountEnteredEvent has been received
				if (eventObject instanceof CashAmountEnteredEvent) {
					CashAmountEnteredEvent cashAmountEnteredEvent = (CashAmountEnteredEvent) eventObject;
					onEvent(cashAmountEnteredEvent);
				}

				// A CashBoxClosedEvent has been received
				if (eventObject instanceof CashBoxClosedEvent) {
					CashBoxClosedEvent cashBoxClosedEvent = (CashBoxClosedEvent) eventObject;
					onEvent(cashBoxClosedEvent);
				}

				// A CreditCardScannedEvent has been received
				if (eventObject instanceof CreditCardScannedEvent) {
					CreditCardScannedEvent creditCardScannedEvent = (CreditCardScannedEvent) eventObject;
					onEvent(creditCardScannedEvent);
				}

				// A PINEnteredEvent has been received
				if (eventObject instanceof PINEnteredEvent) {
					PINEnteredEvent pinEnteredEvent = (PINEnteredEvent) eventObject;
					onEvent(pinEnteredEvent);
				}

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

				// A PaymentModeEvent has been received
				if (eventObject instanceof PaymentModeEvent) {
					PaymentModeEvent paymentModeEvent = (PaymentModeEvent) eventObject;
					onEvent(paymentModeEvent);
				}

			} catch (JMSException e) {
				e.printStackTrace();
			}

		}
	}

	// From here the various event handler methods are implemented

	public void onEvent(SaleStartedEvent saleStartedEvent) {
		log.info("Application: SaleStartedEvent received");
		if (currState.equals(INITIALIZED)) {
			reset();
			currState = SALE_STARTED;
		}
	}

	public void onEvent(ProductBarcodeScannedEvent productBarcodeScannedEvent) {
		log.info("Application: ProductBarcodeScannedEvent("
				+ productBarcodeScannedEvent.getScannedBarcode()
				+ ") received");
		if (currState.equals(SALE_STARTED)) {
			// stop scanning if more than 8 products in express mode
			if (expressModeEnabled && products.size() == 8) {
				return;
			}
			ProductWithStockItemTO product = null;
			try {
				try {
					product = inventory
							.getProductWithStockItem(productBarcodeScannedEvent
									.getScannedBarcode());
				} catch (NoSuchProductException e) {
					log.error(e.getMessage());
					appPublisher
							.publish(topicSession
									.createObjectMessage(new ProductBarcodeNotValidEvent(
											productBarcodeScannedEvent
													.getScannedBarcode())));
					topicSession.commit();
					return;
				}

				String productname = product.getName();
				double price = product.getStockItemTO().getSalesPrice();
				// calculate running total
				runningtotal += price;
				// round
				runningtotal = Math.rint(100 * runningtotal) / 100;
				// send event to GUI
				appPublisher.publish(topicSession
						.createObjectMessage(new RunningTotalChangedEvent(
								productname, price, runningtotal)));
				topicSession.commit();
				// if crash here, abort anyway
				products.add(product);
			} catch (RemoteException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			} catch (JMSException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			try {
				topicSession.commit();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void onEvent(SaleFinishedEvent saleFinishedEvent) {
		log.info("Application: SaleFinishedEvent received");
		if (currState.equals(SALE_STARTED)) {
			currState = SALE_FINISHED;
		}
	}

	public void onEvent(CashAmountEnteredEvent cashAmountEnteredEvent) {
		log.info("Application: CashAmountEnteredEvent received");
		if (currState.equals(PAYING_BY_CASH)) {
			switch (cashAmountEnteredEvent.getKeyStroke()) {
			case ONE:
				total = total.append("1");
				break;
			case TWO:
				total = total.append("2");
				break;
			case THREE:
				total = total.append("3");
				break;
			case FOUR:
				total = total.append("4");
				break;
			case FIVE:
				total = total.append("5");
				break;
			case SIX:
				total = total.append("6");
				break;
			case SEVEN:
				total = total.append("7");
				break;
			case EIGHT:
				total = total.append("8");
				break;
			case NINE:
				total = total.append("9");
				break;
			case ZERO:
				total = total.append("0");
				break;
			case COMMA:
				total = total.append(".");
				break;
			case ENTER:
				try {
					double amount = Double.parseDouble(total.toString());
					double changeamount = amount - runningtotal;
					// round
					changeamount = Math.rint(100 * changeamount) / 100;
					appPublisher
							.publish(topicSession
									.createObjectMessage(new ChangeAmountCalculatedEvent(
											changeamount)));
					topicSession.commit();
					currState = PAID;
					return;
				} catch (NumberFormatException e) {
					// TODO: Handle properly
					log.error(e.toString());
				} catch (JMSException e) {
					log.error(e.toString());
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void onEvent(CashBoxClosedEvent cashBoxClosedEvent) {
		log.info("Application: CashBoxClosedEvent received");
		if (currState.equals(PAID)) {
			try {
				makeSale(PaymentMode.CASH);
				topicSession.commit();
				reset();
				currState = INITIALIZED;
			} catch (JMSException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void onEvent(CreditCardScannedEvent creditCardScannedEvent) {
		log.info("Application: CreditCardScannedEvent received");
		if (currState.equals(PAYING_BY_CREDITCARD)
				|| currState.equals(CREDIT_CARD_SCANNED)) {
			cardInformation = creditCardScannedEvent.getCreditCardInformation();
			currState = CREDIT_CARD_SCANNED;
		}
	}

	public void onEvent(PINEnteredEvent pinEnteredEvent) {
		log.info("Application: PINEnteredEvent received");
		if (currState.equals(CREDIT_CARD_SCANNED)) {
			try {
				Bank bank = (Bank) connect(bankname);
				transactionid = bank.validateCard(cardInformation,
						pinEnteredEvent.getPIN());
				if (transactionid == null) {
					appPublisher.publish(topicSession
							.createObjectMessage(new InvalidCreditCardEvent()));
					topicSession.commit();
					return;
				}
				Debit info = bank.debitCard(transactionid);
				if (info.equals(Debit.OK)) {
					// make the sale
					makeSale(PaymentMode.CREDITCARD);
					topicSession.commit();
					reset();
					currState = INITIALIZED;
				}
				if (info.equals(Debit.TRANSACTION_ID_NOT_VALID)) {
					// we have to rescan the card
					log.info("Transaction id not valid");
					appPublisher.publish(topicSession
							.createObjectMessage(new InvalidCreditCardEvent()));
					topicSession.commit();
					currState = PAYING_BY_CREDITCARD;
				}
				if (info.equals(Debit.NOT_ENOUGH_MONEY)) {
					// Other failures
					// TODO: this has to be refined
					log.info("Not enough money on the account");
					appPublisher.publish(topicSession
							.createObjectMessage(new InvalidCreditCardEvent()));
					topicSession.commit();
				}

			} catch (RemoteException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			} catch (JMSException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}
		}
		try {
			topicSession.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void onEvent(ExpressModeEnabledEvent expressModeEnabledEvent) {
		log.info("Application: ExpressModeEnabledEvent received");
		if (!expressModeEnabled
				&& expressModeEnabledEvent.getCashdesk().equals(topicName)) {
			try {
				appPublisher.publish(topicSession
						.createObjectMessage(expressModeEnabledEvent));
				topicSession.commit();
				expressModeEnabled = true;
			} catch (JMSException e) {
				e.printStackTrace();
				try {
					topicSession.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void onEvent(PaymentModeEvent paymentModeEvent) {
		log.info("Application: PaymentModeEvent received");
		if (currState.equals(SALE_FINISHED) || currState.equals(PAYING_BY_CREDITCARD)) {
			PaymentMode mode = paymentModeEvent.getMode();
			if (mode.equals(PaymentMode.CASH)) {
				currState = PAYING_BY_CASH;
			}
			if (mode.equals(PaymentMode.CREDITCARD) && !expressModeEnabled) {
				currState = PAYING_BY_CREDITCARD;
			}
		}
	}

	public void onEvent(ExpressModeDisabledEvent expressModeDisabledEvent) {
		log.info("Application: ExpressModeDisabledEvent received");
		if (expressModeEnabled) {
			expressModeEnabled = false;
		}
	}
	
	private void reset() {
		runningtotal = 0.0;
		total = new StringBuilder("");
		products = new ArrayList<ProductWithStockItemTO>();
		cardInformation = null;
	}
	
	private void makeSale(PaymentMode mode) throws JMSException {
		SaleTO saleTO = new SaleTO();
		saleTO.setProductTOs(products);
		//The old synchronous call
		/*inventory.bookSale(saleTO);*/
		
		appPublisher.publish(topicSession
				.createObjectMessage(new SaleSuccessEvent()));
		//goes to store
		externalPublisher.publish(topicSession
				.createObjectMessage(new AccountSaleEvent(saleTO)));
		//goes to coordinator
		externalPublisher.publish(topicSession
						.createObjectMessage(new SaleRegisteredEvent(
								topicName, saleTO.getProductTOs()
										.size(), mode)));
	}
}
