package org.cocome.tradingsystem.inventory.application.store.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.cocome.tradingsystem.inventory.application.ApplicationFactory;
import org.cocome.tradingsystem.inventory.application.productdispatcher.impl.ProductDispatcher;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.*;
import org.cocome.tradingsystem.inventory.data.DataIfFactory;
import org.cocome.tradingsystem.inventory.data.enterprise.*;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceIf;
import org.cocome.tradingsystem.inventory.data.persistence.TransactionContext;
import org.cocome.tradingsystem.inventory.data.store.*;

/**
 *
 * @author Yannick Welsch
 */
public class StoreImpl extends UnicastRemoteObject implements StoreIf, CashDeskConnectorIf {

	/**
	 *
	 */
	private static final long serialVersionUID = -529765757261183369L;

	private StoreQueryIf storequery = DataIfFactory.getInstance()
			.getStoreQueryIf();

	private EnterpriseQueryIf enterpriseQuery = DataIfFactory.getInstance()
			.getEnterpriseQueryIf();

	private PersistenceIf persistmanager = DataIfFactory.getInstance()
			.getPersistenceManager();

	private long storeid;

	public StoreImpl(long storeid) throws RemoteException {
		super();
		this.storeid = storeid;
	}

	public ProductWithStockItemTO changePrice(StockItemTO stockItemTO) {
		ProductWithStockItemTO result = new ProductWithStockItemTO();

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			StockItem si = storequery.queryStockItemById(stockItemTO.getId(),
					pctx);
			si.setSalesPrice(stockItemTO.getSalesPrice());

			result = FillTransferObjects.fillProductWithStockItemTO(si);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	public List<ProductWithSupplierTO> getAllProducts() {
		List<ProductWithSupplierTO> result = new ArrayList<ProductWithSupplierTO>();

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			Collection<Product> products = storequery.queryProducts(storeid,
					pctx);
			for (Product p : products) {
				result.add(FillTransferObjects.fillProductWithSupplierTO(p));
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}

		return result;
	}

	public List<ProductWithSupplierAndStockItemTO> getAllProductsWithOptionalStockItem() {
		List<ProductWithSupplierAndStockItemTO> result = new ArrayList<ProductWithSupplierAndStockItemTO>();

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			Collection<Product> products = storequery.queryProducts(storeid,
					pctx);
			for (Product p : products) {
				result.add(FillTransferObjects
						.fillProductWithSupplierAndStockItemTO(storequery,
								storeid, p, pctx));
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}

		return result;
	}

	public ComplexOrderTO getOrder(long orderId) {
		ComplexOrderTO result = null;

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			ProductOrder order = storequery.queryOrderById(orderId, pctx);
			result = FillTransferObjects.fillComplexOrderTO(order);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	public List<ProductWithStockItemTO> getProductsWithLowStock() {
		List<ProductWithStockItemTO> result = new ArrayList<ProductWithStockItemTO>();

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			Collection<StockItem> stockitems = storequery.queryLowStockItems(
					storeid, pctx);
			for (StockItem s : stockitems) {
				result.add(FillTransferObjects.fillProductWithStockItemTO(s));
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	public StoreWithEnterpriseTO getStore() {
		StoreWithEnterpriseTO result = null;

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			result = FillTransferObjects.fillStoreWithEnterpriseTO(storequery
					.queryStoreById(storeid, pctx));

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	public List<ComplexOrderTO> orderProducts(ComplexOrderTO complexOrder) {
		List<ComplexOrderTO> result = new ArrayList<ComplexOrderTO>();

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			List<ProductOrder> orders = new ArrayList<ProductOrder>();

			HashMap<Long, List<OrderEntry>> ordersuppl = new HashMap<Long, List<OrderEntry>>();

			for (ComplexOrderEntryTO coeto : complexOrder.getOrderEntryTO()) {
				Product p = storequery.queryProductById(coeto.getProductTO()
						.getId(), pctx);
				System.out.println("Product found");
				OrderEntry oe = new OrderEntry();
				oe.setProduct(p);
				oe.setAmount(coeto.getAmount());
				pctx.makePersistent(oe);

				long supplierid = p.getSupplier().getId();

				if (!ordersuppl.containsKey(new Long(supplierid))) {
					ordersuppl.put(new Long(supplierid),
							new ArrayList<OrderEntry>());
				}
				ordersuppl.get(new Long(supplierid)).add(oe);
			}
			System.out.println(ordersuppl);
			for (List<OrderEntry> loe : ordersuppl.values()) {
				ProductOrder po = new ProductOrder();
				pctx.makePersistent(po);
				po.setOrderEntries(loe);
				po.setStore(storequery.queryStoreById(storeid, pctx));
				// set OrderingDate to NOW
				po.setOrderingDate(new Date());
				orders.add(po);
			}

			for (ProductOrder po : orders) {
				result.add(FillTransferObjects.fillComplexOrderTO(po));
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	public void rollInReceivedOrder(ComplexOrderTO complexOrderTO) {
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			ProductOrder po = storequery.queryOrderById(complexOrderTO.getId(),
					pctx);

			if (po == null) {
				// TODO: throw exception
				throw new NullPointerException();
			}

			if (po.getDeliveryDate() != null) {
				System.out.println("already rolled in");
				// Already delivered
				// TODO: throw exception
				return;
			}

			if (po.getStore().getId() != storeid) {
				System.out.println("Cannot be executed by this store");
				// Cannot be executed by this store
				// TODO: throw exception
				return;
			}

			// set DeliveryDate to NOW
			po.setDeliveryDate(new Date());

			for (OrderEntry oe : po.getOrderEntries()) {
				StockItem si = storequery.queryStockItem(storeid, oe
						.getProduct().getBarcode(), pctx);
				si.setAmount(si.getAmount() + oe.getAmount());
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
	}

	public void bookSale(SaleTO saleTO) {
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			for (ProductWithStockItemTO pwsto : saleTO.getProductTOs()) {
				StockItem si = storequery.queryStockItemById(pwsto
						.getStockItemTO().getId(), pctx);
				// TODO: THIS CLASS IS USED IN 2 DIFFERENT WAYS!!!
				si.setAmount(si.getAmount()
						- 1);
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}

		// permanent check; required for UC 8
		// (alternative design decision: check initiated by timer event)
		checkForLowRunningGoods();
	}

	public ProductWithStockItemTO getProductWithStockItem(long productBarCode) throws NoSuchProductException {
		ProductWithStockItemTO result = null;

		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			StockItem stockitem = storequery.queryStockItem(
					storeid, productBarCode, pctx);
			if (stockitem == null) {
				tx.commit();
				throw new NoSuchProductException(
						"There exists no product with barcode " + productBarCode);
			}

			result = FillTransferObjects.fillProductWithStockItemTO(stockitem);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see org.cocome.tradingsystem.inventory.application.store.StoreIf#getStockItems(org.cocome.tradingsystem.inventory.application.store.ProductTO[])
	 */
	public ComplexOrderEntryTO[] getStockItems(ProductTO[] requiredProductTOs) {
		// TODO Auto-generated method stub
		throw new RuntimeException("TODO: SDQ implement");
	}

	/*
	 * (non-Javadoc)
	 * @see org.cocome.tradingsystem.inventory.application.store.StoreIf#markProductsUnavailableInStock(org.cocome.tradingsystem.inventory.application.store.ProductMovementTO[])
	 */
	public void markProductsUnavailableInStock(ProductMovementTO requiredProductsAndAmount) throws RemoteException, ProductNotAvailableException {
		PersistenceContext pctx = persistmanager.getPersistenceContext();		
		TransactionContext tx = null;
		
		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();

			Iterator<ProductAmountTO> productAmountIterator =
				requiredProductsAndAmount.getProducts().iterator();
			ProductAmountTO currentProductAmountForDelivery;
			while(productAmountIterator.hasNext()) {
				currentProductAmountForDelivery = productAmountIterator.next();

				StockItem si = storequery.queryStockItem(
						this.storeid,
						currentProductAmountForDelivery.getProduct().getBarcode(),
						pctx);
				if(si == null) {
					throw new RuntimeException(
							"Query in store " + this.storeid +
							" for product with barcode "
							+ currentProductAmountForDelivery.getProduct().getBarcode()
							+ " failed.");
				}
				// set new remaining stock amount:
				si.setAmount( si.getAmount() - currentProductAmountForDelivery.getAmount() );

				// TODO: virtual printout is missing: a list of all products that need 
				// to be delivered should be printed out.
				System.out.println(
						"[Virtual Print Device] Ship Product " +
						si.getProduct().getId() + ", " +
						"Amount " + currentProductAmountForDelivery.getAmount() + 
						"to Store " + requiredProductsAndAmount.getTargetStore() );				
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
	}

	/**
	 * Checks for goods that run low. If there are goods running low
	 * they are ordered at the enterprise.
	 * <p>
	 * Required for UC 8
	 */
	private void checkForLowRunningGoods() {
		PersistenceContext pctx = persistmanager.getPersistenceContext();

		Collection<StockItem> lowRunningStockItems =
			storequery.queryLowStockItems(storeid, pctx);
		Collection<ProductAmountTO> productAmounts =
			calculateProductAmounts(lowRunningStockItems);

		Store thisStore = storequery.queryStoreById(storeid, pctx);

		TransactionContext tx = null;
		ProductAmountTO[] incomingProductAmounts;
		try {
			//TODO: should be a remote call:
			incomingProductAmounts =
				ApplicationFactory.getProductDispatcherInstance().
					orderProductsAvailableAtOtherStores(
					FillTransferObjects.fillEnterpriseTO(
							thisStore.getEnterprise()),
					FillTransferObjects.fillStoreTO(thisStore),
					productAmounts);
			
			if(incomingProductAmounts != null) {				
				tx = pctx.getTransactionContext();
				tx.beginTransaction();
			
				for(ProductAmountTO p : incomingProductAmounts) {
					StockItem s = storequery.queryStockItem(
							this.storeid, p.getProduct().getBarcode(), pctx);
					// increase incoming amount by required amount:
					s.setIncomingAmount(s.getIncomingAmount() + p.getAmount()); 
					System.out.println("KK: " + p.getProduct().getId());
				}
				
				tx.commit();
			} else {
				String msg = "incomingProductAmounts not initialized / set";
				System.err.println(msg);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new RuntimeException("Error on connecting to the enterprise server. " +
					"Cannot finish UC 8.", e);
			// TODO: error handling
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			e.printStackTrace();
			throw e; // or display error message
		} finally {
			pctx.close();
		}
	}

	/**
	 * Orders by default the minimum stock items for each
	 * low running product/good.
	 * <p>
	 * Required for UC 8
	 * @param lowRunningStockItems collection of product that
	 * run low
	 * @return product / amount tuples for each productr
	 * represent the required amount per products.
	 */
	private Collection<ProductAmountTO> calculateProductAmounts(
			Collection<StockItem> lowRunningStockItems) {

		Collection<ProductAmountTO> productAmounts =
			new ArrayList<ProductAmountTO>();
		Iterator<StockItem> stockItemsIterator =
			lowRunningStockItems.iterator();

		while(stockItemsIterator.hasNext()) {
			StockItem currentStockItem =
				stockItemsIterator.next();

			// do not exeed stock limits:
			long orderAmount = currentStockItem.getMinStock();
			if(2 * currentStockItem.getMinStock() >= currentStockItem.getMaxStock()) {
				orderAmount = currentStockItem.getMaxStock() - currentStockItem.getMinStock();
			}

			ProductAmountTO pa = new ProductAmountTO();
			pa.setProduct( FillTransferObjects.fillProductTO(
						currentStockItem.getProduct()) );
			pa.setAmount(orderAmount);
			productAmounts.add(pa);
		}
		return productAmounts;
	}

}
