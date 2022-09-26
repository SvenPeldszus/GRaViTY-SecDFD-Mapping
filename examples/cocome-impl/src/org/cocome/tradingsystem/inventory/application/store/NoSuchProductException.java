package org.cocome.tradingsystem.inventory.application.store;

/**
 * This exception is thrown if there is no product for a specific barcode
 * in the database
 * @author Yannick Welsch
 */
public class NoSuchProductException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6026652539932418410L;

	public NoSuchProductException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchProductException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoSuchProductException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoSuchProductException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
