package org.cocome.tradingsystem.external;

/**
 * Description of the possible return values of the debit operation at the Bank
 * interface
 * 
 * @author Yannick Welsch
 */
public enum Debit {
	OK, 
	NOT_ENOUGH_MONEY, 
	TRANSACTION_ID_NOT_VALID
}
