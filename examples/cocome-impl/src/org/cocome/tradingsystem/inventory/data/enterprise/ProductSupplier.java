package org.cocome.tradingsystem.inventory.data.enterprise;

import java.util.Collection;

import javax.persistence.*;

/**
 * This class represents a ProductSupplier in the database.
 * @author Yannick Welsch
 */
@Entity
public class ProductSupplier {
	
	private long id;
	private String name;
	private Collection<Product> products;
	
	/**
	 * @return A unique identifier for ProductSupplier objects
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	/**
	 * @param id A unique identifier for ProductSupplier objects
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return The name of the ProductSupplier
	 */
	@Basic
	public String getName() {
		return name;
	}
	
	/**
	 * @param name The name of the ProductSupplier
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return The list of Products provided by the ProductSupplier
	 */
	@OneToMany(mappedBy="supplier", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Collection<Product> getProducts() {
		return products;
	}
	
	/**
	 * @param products The list of Products provided by the ProductSupplier
	 */
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
}
