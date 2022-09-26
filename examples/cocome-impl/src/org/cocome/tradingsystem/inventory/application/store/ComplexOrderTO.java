package org.cocome.tradingsystem.inventory.application.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * <code>ComplexOrderTO</code> is used as transfer object class for transferring full order information
 * between client and the service-oriented application layer. It contains either copies of persisted
 * data which are transferred to the client, or data which is transferred from the client to the
 * application layer for being processed and persisted.
 * @author herold
 *
 */
public class ComplexOrderTO extends OrderTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7826213625996223229L;
	protected List<ComplexOrderEntryTO> orderEntryTO = Collections.emptyList();

	/**
	 * Gets list of order entry transfer objects which the order consists of.
	 * @return List of containing order entries.
	 */
	public List<ComplexOrderEntryTO> getOrderEntryTO() {
		return new ArrayList<ComplexOrderEntryTO>(orderEntryTO);
	}

	/**
	 * Sets list of order entry transfer objects.
	 * @param orderEntryTO The list.
	 */
	public void setOrderEntryTO(List<ComplexOrderEntryTO> orderEntryTO) {
		this.orderEntryTO = new ArrayList<ComplexOrderEntryTO>(orderEntryTO);
	}


}
