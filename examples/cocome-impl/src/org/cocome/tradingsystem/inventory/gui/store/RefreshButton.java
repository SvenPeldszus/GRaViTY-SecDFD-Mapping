package org.cocome.tradingsystem.inventory.gui.store;

import java.awt.event.ActionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class RefreshButton extends JButton {
	
	JTabbedPane pane;
	List<Refreshable> refreshables = new ArrayList<Refreshable>();
	
	public RefreshButton(JTabbedPane pane) {
		//TODO: This has to be linked to a specific JTabbedPane later on
		super("Refresh");
		this.pane = pane;
	}
	
	public void addElem(Refreshable r) {
		refreshables.add(new WeakReference<Refreshable>(r).get());
	}
	

	public void actionPerformed(ActionEvent e) {
		//Component c = pane.getSelectedComponent();
		for (Refreshable r : refreshables) {
			r.refresh();
		}
	}

}
