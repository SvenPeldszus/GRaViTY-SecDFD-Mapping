package org.cocome.tradingsystem.inventory.gui.store;


import java.awt.GridLayout;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cocome.tradingsystem.inventory.application.store.StoreIf;
import org.cocome.tradingsystem.inventory.application.store.StoreWithEnterpriseTO;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class StoreDescr extends JPanel implements Refreshable {

	private StoreIf store;
	private StoreWithEnterpriseTO sto;
	
	private JLabel lx1, lx2, lx3, lx4, lx5;
	
	public StoreDescr(StoreIf store) {
		super();
		this.store = store;
		
		this.setLayout(new GridLayout(5, 2));
		JLabel l1 = new JLabel("Store ID: ");
		JLabel l2 = new JLabel("Store Name: ");
		JLabel l3 = new JLabel("Store Location: ");
		JLabel l4 = new JLabel("Enterprise ID: ");
		JLabel l5 = new JLabel("Enterprise Name: ");
		lx1 = new JLabel();
		lx2 = new JLabel();
		lx3 = new JLabel();
		lx4 = new JLabel();
		lx5 = new JLabel();


		refresh();
		
		add(l1);
		add(lx1);
		add(l2);
		add(lx2);
		add(l3);
		add(lx3);
		add(l4);
		add(lx4);
		add(l5);
		add(lx5);
	}
	
	public void refresh() {
		try {
			sto = store.getStore();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lx1.setText(sto.getId()+"");
		lx2.setText(sto.getName());
		lx3.setText(sto.getLocation());
		lx4.setText(sto.getEnterpriseTO().getId()+"");
		lx5.setText(sto.getEnterpriseTO().getName());
	}

}
