package org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller.impl;

/**
 * Description of the states the PrinterController can be in
 * @author Yannick Welsch
 */
public enum PrinterStates {
	STARTED, 
	STOPPED, 
	SALE_FINISHED, 
	CASH_AMOUNT_ENTERED, 
	CHANGE_AMOUNT_CALCULATED
}
