package org.cocome.tradingsystem.inventory.data.test;

import org.cocome.tradingsystem.inventory.data.enterprise.*;
import org.cocome.tradingsystem.inventory.data.store.*;

import static org.junit.Assert.*;
import java.util.*;
import javax.persistence.*;
import org.junit.*;

/**
 * Used to fill the DB with dummy data
 * This data is not yet valid in all means
 * @author Yannick Welsch
 */
public class FillDB {
	
	private static EntityManagerFactory emf;
	public static final int NUMBEROF_ENTERPRISES = 10;
	public static final int NUMBEROF_STORES = 100;
	public static final int NUMBEROF_STOCKITEMS = 10000;
	public static final int NUMBEROF_SUPPLIERS = 20;
	public static final int NUMBEROF_PRODUCTS = 1000;
	public static final int NUMBEROF_PRODUCTORDERS = 200;
	public static final int NUMBEROF_ORDERENTRIES = 20;
	
	EntityManager em = null;
	
	List<TradingEnterprise> enterprises = new ArrayList<TradingEnterprise>();
	List<Store> stores = new ArrayList<Store>();
	List<ProductSupplier> suppliers = new ArrayList<ProductSupplier>();
	List<Product> products = new ArrayList<Product>();
	List<ProductOrder> productorders = new ArrayList<ProductOrder>();
	List<StockItem> stockitems = new ArrayList<StockItem>();
	List<OrderEntry> orderentries = new ArrayList<OrderEntry>();
	
	@BeforeClass
	public static void setUpClass() {
		emf = Persistence.createEntityManagerFactory("inventory-manager");
	}
	
	@Before
	public void setUp() {
		//Pseudo-random
		Random r = new Random(777);
		//fill Enterprises
		for(int i = 0; i < NUMBEROF_ENTERPRISES; i++) {
			TradingEnterprise enterprise = new TradingEnterprise();
			enterprise.setName("TradingEnterprise " + i);
			enterprises.add(enterprise);
		}
		
		//fill Stores and connect to Enterprises
		for(int i = 0; i < NUMBEROF_STORES; i++) {
			Store store = new Store();
			store.setName("Store " + i);
			store.setLocation("StoreLocation " + i);
			//select randomly TradingEnterprise to connect to Store
			TradingEnterprise enterprise = enterprises.get(
					r.nextInt(enterprises.size()));
			store.setEnterprise(enterprise);
			stores.add(store);
		}
		//fill Suppliers
		for(int i = 0; i < NUMBEROF_SUPPLIERS; i++) {
			ProductSupplier supplier = new ProductSupplier();
			supplier.setName("ProductSupplier " + i);
			suppliers.add(supplier);
		}
		//fill Products and connect to Suppliers
		for(int i = 0; i < NUMBEROF_PRODUCTS; i++) {
			Product product = new Product();
			//each barcode is different
			product.setBarcode(i + 777);
			product.setName("Product " + i);
			product.setPurchasePrice(Math.rint(100 *r.nextInt(10000) * 0.01) /100);
			//select randomly ProductSupplier to connect to Product
			ProductSupplier supplier = suppliers.get(
					r.nextInt(suppliers.size()));
			product.setSupplier(supplier);
			products.add(product);
		}
		//fill StockItems and connect to Stores and Products
		for(int i = 0; i < NUMBEROF_STOCKITEMS; i++) {
			StockItem stockitem = new StockItem();
			stockitem.setSalesPrice(Math.rint(100 *r.nextInt(10000) * 0.01) /100);
			stockitem.setAmount(r.nextInt(100));
			stockitem.setMinStock(r.nextInt(20));
			stockitem.setMaxStock(90+r.nextInt(18));
			//select randomly Store to connect to StockItem
			Store store = stores.get(
					r.nextInt(stores.size()));
			stockitem.setStore(store);
			//select randomly Product to connect to StockItem
			Product product = products.get(
					r.nextInt(products.size() - (NUMBEROF_PRODUCTS / 10)
							) );
			stockitem.setProduct(product);
			stockitems.add(stockitem);
		}
		//connect TradingEnterprise and ProductSupplier (n:m)
		for(TradingEnterprise enterprise : enterprises) {
			List<ProductSupplier> sup = new ArrayList<ProductSupplier>();
			for(double ra = r.nextDouble() * 1.0; ra < 1.; ra = r.nextDouble() * 1.2) {
				ProductSupplier supplier = suppliers.get(
						(int)Math.floor(ra * suppliers.size()));
				sup.add(supplier);
			}
			enterprise.setSuppliers(sup);
		}
		//fill ProductOrders and connect to Store
		for(int i = 0; i < NUMBEROF_PRODUCTORDERS; i++) {
			ProductOrder productorder = new ProductOrder();
			productorder.setOrderingDate(
					new Date(1166832000000L + ((long)i) * 86400000L));
			productorder.setDeliveryDate(
					new Date(1166832000000L + 2592000000L + ((long)i) * 86400000L));
			//select randomly Store to connect to ProductOrder
			Store store = stores.get(
					r.nextInt(stores.size()));
			productorder.setStore(store);
			productorders.add(productorder);
		}
		//fill OrderEntries and connect to Orders and Products
		for(int i = 0; i < NUMBEROF_ORDERENTRIES; i++) {
			OrderEntry orderentry = new OrderEntry();
			orderentry.setAmount(r.nextInt(1000) + 1);
			//select randomly ProductOrder to connect to OrderEntry
			ProductOrder productorder = productorders.get(
					r.nextInt(productorders.size()));
			orderentry.setOrder(productorder);
			//select randomly Product to connect to OrderEntry
			Product product = products.get(
					r.nextInt(products.size()));
			orderentry.setProduct(product);
			orderentries.add(orderentry);
		}
		
		System.out.println("Objects initialized");



	}

	
	@Test
	public void filltheDB() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
		    tx = em.getTransaction();
		    tx.begin();

		    for(TradingEnterprise o : enterprises)
		    	em.persist(o);
		    for(Store o : stores)
		    	em.persist(o);
		    for(ProductSupplier o : suppliers)
		    	em.persist(o);
		    for(Product o : products)
		    	em.persist(o);
		    for(ProductOrder o : productorders)
		    	em.persist(o);
		    for(StockItem o : stockitems)
		    	em.persist(o);
		    for(OrderEntry o : orderentries)
		    	em.persist(o);

		    tx.commit();
		}
		catch (RuntimeException e) {
		    if ( tx != null && tx.isActive() ) tx.rollback();
		    throw e; // or display error message
		}
		finally {
		    em.close();
		}
		//Success
		System.out.println("Objects written to DB");
		assertTrue(true);
	}
	
	public static void main(String[] args) {
		FillDB f = new FillDB();
		setUpClass();
		f.setUp();
		f.filltheDB();
	}
	
}
