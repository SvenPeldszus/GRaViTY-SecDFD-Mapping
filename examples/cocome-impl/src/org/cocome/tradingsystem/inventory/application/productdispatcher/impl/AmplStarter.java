package org.cocome.tradingsystem.inventory.application.productdispatcher.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.cocome.tradingsystem.inventory.application.productdispatcher.OptimisationSolverIf;
import org.cocome.tradingsystem.inventory.application.reporting.StoreTO;
import org.cocome.tradingsystem.inventory.application.store.ProductAmountTO;
import org.cocome.tradingsystem.inventory.application.store.ProductTO;
import org.cocome.tradingsystem.inventory.application.store.impl.FillTransferObjects;
import org.cocome.tradingsystem.inventory.data.DataIfFactory;
import org.cocome.tradingsystem.inventory.data.enterprise.Product;
import org.cocome.tradingsystem.inventory.data.persistence.PersistenceContext;
import org.cocome.tradingsystem.inventory.data.store.StockItem;
import org.cocome.tradingsystem.inventory.data.store.Store;
import org.cocome.tradingsystem.inventory.data.store.StoreQueryIf;
import org.netlib.ampl.Ampl;

import de.uka.ipd.sdq.cplexparser.ICplexParser;
import de.uka.ipd.sdq.cplexparser.exception.CplexParserException;
import de.uka.ipd.sdq.cplexparser.impl.CplexParser;

/**
 * Solves the optimisation problem described in method solveOptimization().
 * AMPL / CPLEX is used.
 * <p>
 * Required for UC 8 (Optimization part)
 * @author kelsaka
 *
 */
public class AmplStarter implements OptimisationSolverIf {
	private static String amplCmd = "ampl.exe"; // ampl executable
	private static String amplDir = "." + File.separatorChar; // ampl base directory
	
	private StoreQueryIf storeQuery = DataIfFactory.getInstance()
		.getStoreQueryIf();
	private PersistenceContext pctx;
	
	/**
	 * Constructor.
	 * @param pctx PersistenceContext is used for searching existing entities only.
	 */
	public AmplStarter(PersistenceContext pctx) {
		this.pctx = pctx;
	}
	
	/**
	 * Solves an optimisation problem:
	 * Optimal transportation costs with respect to
	 * <ol>
	 * 	<li>The required products and the required amount</li>
	 * 	<li>The available products and their provided amount per providing store</li>
	 *	<li>The distances between the requiring and the providing store</li> 
	 * </ol>
	 * @param requiredProductAmounts Products/Amounts required by the requiring
	 * store
	 * @param storeStockItems Stock item availability per store.
	 * @param storeDistances Distances between requiring store and each
	 * providing stores
	 * @return A Hashtable: For each Store the product/amount tuple is given.
	 * Those products/amounts have to be delivered by the store.
	 */
	public Hashtable<StoreTO, Collection<ProductAmountTO>> solveOptimization(
			Collection<ProductAmountTO> requiredProductAmounts,
    		Hashtable<Store, Collection<StockItem>> storeStockItems,
    		Hashtable<Store, Integer> storeDistances) {
		
		Hashtable<StoreTO, Collection<ProductAmountTO>> returnTable =
			new Hashtable<StoreTO, Collection<ProductAmountTO>>();
		StringBuffer output = new StringBuffer();
		Ampl ampl = null;
		
		//grant pre-conditions of the solver:
		requiredProductAmounts = removeUnavailableProducts(requiredProductAmounts, storeStockItems);
		
		// pre-condition: > 0 product remain required after removeUnavailableProducts()
		if(requiredProductAmounts.size() > 0) { //else empty hashtable is returned
			try {		
				// create the data input file
				createTmpFile(amplDir + "cocome.dat",
						createDataString(requiredProductAmounts,
								storeStockItems, storeDistances)
					);
				
				// set up commands for ampl:
				String amplCommands = 
					"option solver " + "cplex.exe;\n" +
					"model " + amplDir + "cocome.mod;\n" +
					"data " + amplDir + "cocome.dat;\n" +				
					"solve;\n" + 
					"display shipping_amount;\n";			
				
				// execute the command line solver: AMPL / CPLEX
				ampl = new Ampl(amplCmd);			
				ampl.send(amplCommands);
				output.append(ampl.rcv());	
	
			} catch (Exception e) {
				System.err.println(e + " starting " + amplCmd);
				e.printStackTrace();
			}
			System.out.println(output);
			returnTable = parseOutput(output.toString());
		} 
			
		return returnTable;
	}

	/**
	 * CPLEX (solver) is not able to handle sub-optimal solutions where
	 * not all required products are available with a suffient amount.
	 * Products that are not available at all are removed from the
	 * requiredProductAmounts.
	 * <p>
	 * Used to grant pre-conditions of CPLEX: there must be a solution
	 * to make CPLEX deliver results.
	 * @param requiredProductAmounts products and amounts required by
	 * the requring store
	 * @param storeStockItems stock items available per store
	 */
	private Collection<ProductAmountTO> removeUnavailableProducts(
			Collection<ProductAmountTO> requiredProductAmounts,
			Hashtable<Store, Collection<StockItem>> storeStockItems) {
		
		Collection<ProductAmountTO> foundProductAmounts = new ArrayList<ProductAmountTO>();
		
		Iterator<ProductAmountTO> requiredProductAmountsIterator = requiredProductAmounts.iterator();
		while(requiredProductAmountsIterator.hasNext()) {
			ProductAmountTO currentProductAmountTO = requiredProductAmountsIterator.next();
			
			Iterator<Collection<StockItem>> storeStockItemCollectionsIterator = storeStockItems.values().iterator();
			while(storeStockItemCollectionsIterator.hasNext()) { //iterate over stock of stores
				Collection<StockItem> currentStockItemCollection = storeStockItemCollectionsIterator.next();
				
				StockItem stockItem =
					searchForProductOffered(currentStockItemCollection, currentProductAmountTO);
				if (stockItem != null && currentStockItemCollection.contains(stockItem)) {
					foundProductAmounts.add(currentProductAmountTO);
				} else {
					//TODO: remove debug:
//					System.out.println("KK: NOT found");
				}
				
				//no need to search for the same product at other stores: found --> available
				break;
			}
		}
		
		return foundProductAmounts;
	}

	private Hashtable<StoreTO, Collection<ProductAmountTO>> parseOutput(String output) { 
	    Hashtable<StoreTO, Collection<ProductAmountTO>> resultList =
	    	new Hashtable<StoreTO, Collection<ProductAmountTO>>();	    	    
	    
		ICplexParser parser = new  CplexParser();
		try {
			List<de.uka.ipd.sdq.cplexparser.impl.Store> stores = parser.parseString(output);
			
			if(stores == null) { //no or not enough products offered
				return resultList; //return empty list 				
			}
			
			Store currentStore;			
			StoreTO currentStoreTO;
			Product currentProduct;
			ProductTO currentProductTO;			
			ProductAmountTO currentProductAmountTO;
			
			for (de.uka.ipd.sdq.cplexparser.impl.Store s:stores){
				// (SDQ)Store --> Store --> StoreID
				currentStore = storeQuery.queryStoreById(
						s.getAttributeId(), pctx);			
				currentStoreTO = FillTransferObjects.fillStoreTO(currentStore);								
				//System.out.println(" Store "+s.getName());
				
				List<de.uka.ipd.sdq.cplexparser.impl.Product> products = s.getProductList();
				Collection<ProductAmountTO> productsTOs = new ArrayList<ProductAmountTO>();
				for (de.uka.ipd.sdq.cplexparser.impl.Product p:products){
					// (SDQ)Product --> Product --> ProductTO
					currentProduct = storeQuery.queryProductById(
							p.getAttributeId(), pctx); 
					currentProductTO = FillTransferObjects.fillProductTO(currentProduct);
					currentProductAmountTO = new ProductAmountTO();
					currentProductAmountTO.setProduct(currentProductTO);
					currentProductAmountTO.setAmount(p.getAmount());					
					//System.out.println("  Product "+ p.getName()+ " "+p.getAmount());					
					
					productsTOs.add(currentProductAmountTO);				
				}
				resultList.put(currentStoreTO, productsTOs);
			}
		} catch (CplexParserException e)
		{
			e.printStackTrace();
			System.err.println("AMPL/CPLEX Parse Error for UC 8 Optimization");
			//throw new RuntimeException("AMPL/CPLEX Parse Error for UC 8 Optimization", e);
		}

		return resultList;
	}

    
    private static void createTmpFile(String file, String fileContent) {
    	try {
	    	File f = new File(file);
	    	//f.deleteOnExit(); //TODO: re-activate
	
			FileWriter out = new FileWriter(f);
			out.write(fileContent);
			out.close();
    	} catch (IOException e) {
    		RuntimeException t = 
    			new RuntimeException("Error either writing file or data for ampl.");
    		t.initCause(e);
    		throw t;
    	}
    }
    
    /**
     * Creates the AMPL input data format string.
     * 
	 *	  Typical output:
	 *	     	param: STORE: dist :=
	 *	     		  "KA"    			20
	 *	     		  "OL"      			32 
	 *	     		  "FFM"      			74 
	 *	     		  "M"      			30 
	 *	     		  "B"      			50 ;
	 *	
	 *	     		param:  PRODUCT:                amount  :=
	 *	     		  "Nutella"    			5
	 *	     		  "Snickers"      		3 ;
	 *	
	 *	     		param stock (tr):
	 *	     		        "Nutella" "Snickers" :=
	 *	     		  "KA"	30	2
	 *	     		  "OL"  4	40 
	 *	     		  "FFM" 0	10 
	 *	     		  "M"	10	0 
	 *	     		  "B"	25	7 ;
     * 
     * @param requiredProductAmounts
     * @param storeStockItems
     * @param storeDistances
     * @return
     */
    private static String createDataString(
    		Collection<ProductAmountTO> requiredProductAmounts,
    		Hashtable<Store, Collection<StockItem>> storeStockItems,
    		Hashtable<Store, Integer> storeDistances) {
    	
    	StringBuffer output = new StringBuffer();

    	appendStoreDistances(storeDistances, output);    	
    	
    	appendRequiredProductAmounts(requiredProductAmounts, output);
    	
    	appendOfferingStoresProductsAmountsMatrix(storeStockItems, requiredProductAmounts, output);
    	
    	return output.toString();
   	 

    }

	private static void appendOfferingStoresProductsAmountsMatrix(
			Hashtable<Store, Collection<StockItem>> storeStockItems,
			Collection<ProductAmountTO> requiredProductAmounts,
			StringBuffer output) {
		
		appendMatrixHeader(output, requiredProductAmounts);
		
		boolean first = true;
    	Enumeration<Store> offeringStores = storeStockItems.keys();
    	Store currentOfferingStore;
    	Iterator<ProductAmountTO> requiredProductsIterator;    	       	
    	while(offeringStores.hasMoreElements()) { //for each offering store
    		if(!first)
    			output.append("\n");
    		first = false;
    		
    		currentOfferingStore = offeringStores.nextElement();

    		Collection<StockItem> offeredStockItems = storeStockItems.get(currentOfferingStore);
    		requiredProductsIterator = requiredProductAmounts.iterator();
    	    		
    		// content rows "StoreId AmountForProductA AmountForProductB ..
    		output.append("\"Store" + currentOfferingStore.getId() + "\" ");    		
    		while(requiredProductsIterator.hasNext()) {
    			ProductAmountTO currentRequiredProduct = requiredProductsIterator.next();
    			
    			StockItem stockItem = searchForProductOffered(offeredStockItems, currentRequiredProduct);
    			if(stockItem != null) { //offered by currentOfferingStore
	    			output.append(stockItem.getAmount() + " ");
    			} else {
    				output.append("0 "); //no products available at currently selected store 
    			}
    		}    		
		}
    	output.append(" ;\n");
	}


	/**
	 * Searches offeredStockItems for currentRequiredProduct
	 * @param offeredStockItems
	 * @param currentRequiredProduct
	 * @return The matching stock item found if currentRequiredProduct is found among offeredStockItems; null else
	 */
	private static StockItem searchForProductOffered(Collection<StockItem> offeredStockItems, ProductAmountTO currentRequiredProduct) {	
		Iterator<StockItem> stockItemIterator = offeredStockItems.iterator();
		StockItem currentStockItem;
		while(stockItemIterator.hasNext()) {
			currentStockItem = stockItemIterator.next();
			ProductTO productTO = FillTransferObjects.fillProductTO(currentStockItem.getProduct());
			if(productTO.equals(currentRequiredProduct.getProduct())) {
				return currentStockItem;
			}
		}		
		
		return null;
	}

	private static void appendMatrixHeader(StringBuffer output, Collection<ProductAmountTO> requiredProductAmounts) {
		output.append("param stock (tr):\n");
		Iterator<ProductAmountTO> requiredProductsIterator = requiredProductAmounts.iterator();
		while(requiredProductsIterator.hasNext()) {
			ProductAmountTO currentStockItem = requiredProductsIterator.next();
			output.append("\"Product" + currentStockItem.getProduct().getId() + "\" ");
		}	
		output.append(":=\n");
	}

	private static void appendRequiredProductAmounts(Collection<ProductAmountTO> productAmounts, StringBuffer output) {
		output.append("param: PRODUCT: amount :=\n");
    	Iterator<ProductAmountTO> productAmountsIterator = productAmounts.iterator();
    	ProductAmountTO currentProduct;
    	while(productAmountsIterator.hasNext()) {
    		currentProduct = productAmountsIterator.next();
    		output.append("\"Product" + currentProduct.getProduct().getId() + "\" " + currentProduct.getAmount() + "\n");    		
    	}
    	output.append(" ;\n\n");
	}

	private static void appendStoreDistances(Hashtable<Store, Integer> storeDistances, StringBuffer output) {
		output.append("param: STORE: dist :=\n");
    	Enumeration<Store> stores = storeDistances.keys();
    	Store currentStore;
    	while(stores.hasMoreElements()) {
    		currentStore = stores.nextElement();
    		output.append("\"Store" + currentStore.getId() + "\" " + storeDistances.get(currentStore) + "\n");    		
    	}
    	output.append(" ;\n\n");
	}
	
	private String testString() { //Data input for AMPL
	    return
	       "CPLEX 10.1.0: optimal integer solution; objective 0\n" +
	       "0 MIP simplex iterations\n" +
	       "0 branch-and-bound nodes\n" +
	       "shipping_amount [*,*] (tr)\n" +
	       "# $1 = Product98464\n" +
	       "# $2 = Product98783\n" +
	       "# $4 = Product98989\n" +
	       "# $6 = Product99172\n" +
	       "# $7 = Product98911\n" +
	       "# $8 = Product98970\n" +
	       "# $9 = Product98991\n" +
	       "# $10 = Product99022\n" +
	       "# $11 = Product98803\n" +
	       ":           $1  $2 Product98731  $4 Product99036   $6   $7   $8   $9  $10  $11 :\n" +
	       "=\n" +
	       "Store65536   9   9        0       9       19       11   11   16   12   12   17\n" +
	       "Store65583   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65581   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65627   0   0        18       0        0        0    0    0    0    0    0\n" +
	       "Store65542   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65631   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65546   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65625   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65610   0   0        0       3        4        0    0    0    0    0    0\n" +
	       "Store65620   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65603   0   0        0       0        0        0    0    0    0    0    0\n" +
	       "Store65634   0   1        0       0        0        0    0    0    0    0    222\n" +
	       ";\n";
	}
}
