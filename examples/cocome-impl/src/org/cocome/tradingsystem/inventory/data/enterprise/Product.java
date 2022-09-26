package org.cocome.tradingsystem.inventory.data.enterprise;

import javax.persistence.*;

/**
 * This class represents a Product in the database
 * @author Yannick Welsch
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"barcode"}))
public class Product {

	private long id;
	private long barcode;
	private double purchasePrice;
	private String name;
	private ProductSupplier supplier;
	
	/**
	 * Gets identifier value
	 * @return The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	/**
	 * Sets identifier.
	 * @param id Identifier value.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return The barcode of the product
	 */
	@Basic
	public long getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode The barcode of the product
	 */
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return The name of the product
	 */
	@Basic
	public String getName() {
		return name;
	}

	/**
	 * @param name The name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The ProductSupplier of this product
	 */
	@ManyToOne
	public ProductSupplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier The ProductSupplier of this product
	 */
	public void setSupplier(ProductSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return The purchase price of this product
	 */
	@Basic
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice The purchase price of this product
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

}
