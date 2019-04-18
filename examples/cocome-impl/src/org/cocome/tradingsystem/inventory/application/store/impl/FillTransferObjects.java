package org.cocome.tradingsystem.inventory.application.store.impl;

import java.util.ArrayList;
import java.util.List;

import org.cocome.tradingsystem.inventory.application.reporting.EnterpriseTO;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.ComplexOrderEntryTO;
import org.cocome.tradingsystem.inventory.application.store.ComplexOrderTO;
import org.cocome.tradingsystem.inventory.application.store.OrderEntryTO;
import org.cocome.tradingsystem.inventory.application.store.OrderTO;
import org.cocome.tradingsystem.inventory.application.store.ProductTO;
import org.cocome.tradingsystem.inventory.application.store.ProductWithStockItemTO;
import org.cocome.tradingsystem.inventory.application.store.ProductWithSupplierAndStockItemTO;
import org.cocome.tradingsystem.inventory.application.store.ProductWithSupplierTO;
import org.cocome.tradingsystem.inventory.application.store.StockItemTO;
import org.cocome.tradingsystem.inventory.application.store.StoreWithEnterpriseTO;
import org.cocome.tradingsystem.inventory.application.store.SupplierTO;
import org.cocome.tradingsystem.inventory.data.enterprise.*;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.store.*;

/**
 * Helper class to transfer the data from 
 * the persistent objects to the transfer objects
 * @author Yannick Welsch
 */
public class FillTransferObjects {

	public static ComplexOrderEntryTO fillComplexOrderEntry(OrderEntry orderentry) {
		ComplexOrderEntryTO result = new ComplexOrderEntryTO();
		result.setAmount(orderentry.getAmount());
		result.setProductTO(fillProductWithSupplierTO(orderentry.getProduct()));
		return result;
	}

	public static ComplexOrderTO fillComplexOrderTO(ProductOrder order) {
		ComplexOrderTO result = new ComplexOrderTO();
		result.setId(order.getId());
		result.setDeliveryDate(order.getDeliveryDate());
		result.setOrderingDate(order.getOrderingDate());
		List<ComplexOrderEntryTO> oeto = new ArrayList<ComplexOrderEntryTO>();
		for (OrderEntry orderentry : order.getOrderEntries()) {
			oeto.add(fillComplexOrderEntry(orderentry));
		}
		result.setOrderEntryTO(oeto);
		return result;
	}

	public static EnterpriseTO fillEnterpriseTO(TradingEnterprise enterprise) {
		EnterpriseTO result = new EnterpriseTO();
		result.setId(enterprise.getId());
		result.setName(enterprise.getName());
		return result;
	}

	public static OrderEntryTO fillOrderEntryTO(OrderEntry orderentry) {
		OrderEntryTO result = new OrderEntryTO();
		result.setAmount(orderentry.getAmount());
		return result;
	}

	public static OrderTO fillOrderTO(ProductOrder order) {
		OrderTO result = new OrderTO();
		result.setId(order.getId());
		result.setDeliveryDate(order.getDeliveryDate());
		result.setOrderingDate(order.getOrderingDate());
		return result;
	}

	public static ProductTO fillProductTO(Product product) {
		ProductTO result = new ProductTO();
		result.setId(product.getId());
		result.setName(product.getName());
		result.setBarcode(product.getBarcode());
		result.setPurchasePrice(product.getPurchasePrice());
		return result;
	}

	public static ProductWithStockItemTO fillProductWithStockItemTO(
			StockItem stockitem) {
		ProductWithStockItemTO result = new ProductWithStockItemTO();
		Product product = stockitem.getProduct();
		result.setId(product.getId());
		result.setName(product.getName());
		result.setBarcode(product.getBarcode());
		result.setPurchasePrice(product.getPurchasePrice());
		result.setStockItemTO(fillStockItemTO(stockitem));
		return result;
	}
	
	public static ProductWithSupplierAndStockItemTO fillProductWithSupplierAndStockItemTO(StoreQueryIf storequery, long storeid, Product product, PersistenceContext pctx) {
		ProductWithSupplierAndStockItemTO result = new ProductWithSupplierAndStockItemTO();
		result.setSupplierTO(fillSupplierTO(product.getSupplier()));
		result.setId(product.getId());
		result.setName(product.getName());
		result.setBarcode(product.getBarcode());
		result.setPurchasePrice(product.getPurchasePrice());
		StockItem stockitem = storequery.queryStockItem(storeid, product.getBarcode(), pctx);
		if (stockitem != null) {
			result.setStockItemTO(fillStockItemTO(stockitem));
		}
		return result;
	}

	public static ProductWithSupplierTO fillProductWithSupplierTO(Product product) {
		ProductWithSupplierTO result = new ProductWithSupplierTO();
		result.setId(product.getId());
		result.setBarcode(product.getBarcode());
		result.setName(product.getName());
		result.setPurchasePrice(product.getPurchasePrice());
		result.setSupplierTO(fillSupplierTO(product.getSupplier()));
		return result;
	}

	public static StockItemTO fillStockItemTO(StockItem stockitem) {
		StockItemTO result = new StockItemTO();
		result.setId(stockitem.getId());
		result.setAmount(stockitem.getAmount());
		result.setMinStock(stockitem.getMinStock());
		result.setMaxStock(stockitem.getMaxStock());
		result.setSalesPrice(stockitem.getSalesPrice());
		return result;
	}

	public static StoreTO fillStoreTO(Store store) {
		StoreTO result = new StoreTO();
		result.setId(store.getId());
		result.setName(store.getName());
		result.setLocation(store.getLocation());
		return result;
	}

	public static StoreWithEnterpriseTO fillStoreWithEnterpriseTO(Store store) {
		StoreWithEnterpriseTO result = new StoreWithEnterpriseTO();
		result.setId(store.getId());
		result.setName(store.getName());
		result.setLocation(store.getLocation());
		result.setEnterpriseTO(fillEnterpriseTO(store.getEnterprise()));
		return result;
	}

	public static SupplierTO fillSupplierTO(ProductSupplier supplier) {
		SupplierTO result = new SupplierTO();
		result.setId(supplier.getId());
		result.setName(supplier.getName());
		return result;
	}
}
