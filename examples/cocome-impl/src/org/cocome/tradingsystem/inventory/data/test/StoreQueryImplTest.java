package org.cocome.tradingsystem.inventory.data.test;

import static org.junit.Assert.*;



import java.util.Collection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cocome.tradingsystem.inventory.data.DataIfFactory;
import org.cocome.tradingsystem.inventory.data.enterprise.Product;
import org.cocome.tradingsystem.inventory.data.persistence.impl.PersistenceContextImpl;
import org.cocome.tradingsystem.inventory.data.store.*;
import org.junit.*;

/**
 * tests the StoreQueryIf interface
 * @author Yannick Welsch
 */
public class StoreQueryImplTest {
		
	private static EntityManagerFactory emf;
	EntityManager em = null;
	static StoreQueryIf store;
	
	Store s1;
	StockItem si1, si2;
	ProductOrder o1;
	Product p1;
	
	@BeforeClass
	public static void setUpClass() {
		emf = Persistence.createEntityManagerFactory("inventory-manager");
		store = DataIfFactory.getInstance().getStoreQueryIf();
	}
	
	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		s1 = new Store();
		em.persist(s1);
		
		si1 = new StockItem();
		si1.setAmount(100);
		si1.setMinStock(50);
		si1.setStore(s1);
		si2 = new StockItem();
		si2.setAmount(100);
		si2.setMinStock(200);
		si2.setStore(s1);
		
		o1 = new ProductOrder();
		o1.setStore(s1);
		p1 = new Product();
		si2.setProduct(p1);
		
		em.persist(s1);
		em.persist(si1);
		em.persist(si2);
		em.persist(o1);
		em.persist(p1);

		em.getTransaction().commit();

	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	public void queryLowStockItems() {
		em.getTransaction().begin();
		em.refresh(s1);
		em.refresh(si2);
		Collection<StockItem> result = store.queryLowStockItems(s1.getId(), new PersistenceContextImpl(em));
		assertTrue(result.size() == 1 && result.iterator().next().getId() == si2.getId());
		em.getTransaction().commit();
	}
	
	@Test
	public void queryProducts() {
		em.getTransaction().begin();
		em.refresh(s1);
		em.refresh(p1);
		Collection<Product> result = store.queryProducts(s1.getId(), new PersistenceContextImpl(em));
		assertTrue(result.size() == 1 && result.iterator().next().getId() == p1.getId());
		em.getTransaction().commit();
	}
	
	@Test
	public void queryOrderById() {
		em.getTransaction().begin();
		em.refresh(o1);
		ProductOrder result = store.queryOrderById(o1.getId(), new PersistenceContextImpl(em));
		//TODO: Compare real equality
		assertTrue(result.getId() == o1.getId());
		em.getTransaction().commit();
	}

	@Test
	public void queryStoreById() {
		em.getTransaction().begin();
		em.refresh(s1);
		Store result = store.queryStoreById(s1.getId(), new PersistenceContextImpl(em));
		//TODO: Compare real equality
		assertTrue(result.getId() == s1.getId());
		em.getTransaction().commit();
	}
	
}
