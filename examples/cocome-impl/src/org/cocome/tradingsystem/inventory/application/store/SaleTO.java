package org.cocome.tradingsystem.inventory.application.store;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <code>SaleTO</code> is used as transfer object class for transferring sale information
 * between client and the service-oriented application layer. It has no persistent pendant.
 *
 * @author herold
 *
 */
public class SaleTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5164217707863683479L;
	protected Date date;
	protected List<ProductWithStockItemTO> productTOs;

	/**
	 * Gets date of sale.
	 * @return Date of sale.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets date of sale.
	 * @param date Date to be set.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets list of products and corresponding item in stock which the sale consists of.
	 * @return List of contained products.
	 */
	public List<ProductWithStockItemTO> getProductTOs() {
		return productTOs;
	}
	/**
	 * Sets list of products for the sale.
	 * @param productTOs List of products the sale should contain.
	 */
	public void setProductTOs(List<ProductWithStockItemTO> productTOs) {
		this.productTOs = productTOs;
	}

}
