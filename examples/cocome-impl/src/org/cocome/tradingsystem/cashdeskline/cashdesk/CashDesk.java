package org.cocome.tradingsystem.cashdeskline.cashdesk;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.cocome.tradingsystem.cashdeskline.cashdesk.application.impl.ApplicationEventHandlerImpl;
import org.cocome.tradingsystem.cashdeskline.cashdesk.cardreadercontroller.impl.CardReader;
import org.cocome.tradingsystem.cashdeskline.cashdesk.cashboxcontroller.impl.CashBox;
import org.cocome.tradingsystem.cashdeskline.cashdesk.gui.impl.CashDeskGUI;
import org.cocome.tradingsystem.cashdeskline.cashdesk.lightdisplaycontroller.impl.LightDisplayController;
import org.cocome.tradingsystem.cashdeskline.cashdesk.printercontroller.impl.PrinterController;
import org.cocome.tradingsystem.cashdeskline.cashdesk.scannercontroller.impl.ScannerController;

/**
 * This class is the main entry point for the CashDesk. It creates the
 * cashdesk components and the GUI to manage them.
 * 
 * @author Yannick Welsch
 */
@SuppressWarnings("serial")
public class CashDesk extends JDesktopPane {

	private CashDesk(String[] args) {
		String registryurl = args[0];
		int port = Integer.parseInt(args[1]);
		String eventchannel = args[2];
		String extchannel = args[3];
		String bankname = args[4];

		new ApplicationEventHandlerImpl(registryurl, port, bankname,
				eventchannel, extchannel);

		add(createFrame(new CashDeskGUI(eventchannel), "CashDeskGUI", 5, 5, 0,
				0));
		add(createFrame(new LightDisplayController(eventchannel),
				"LightDisplay", 5, 100, 100, 60));
		add(createFrame(new ScannerController(eventchannel), "BarCodeScanner",
				400, 5, 0, 0));
		add(createFrame(new CardReader(eventchannel), "CardReader", 5, 400, 0,
				0));
		add(createFrame(new CashBox(eventchannel), "CashBox", 100, 200, 0, 0));
		add(createFrame(new PrinterController(eventchannel),
				"PrinterController", 150, 400, 0, 0));
	}

	private JInternalFrame createFrame(JPanel p, String title, int offsetx,
			int offsety, int sizex, int sizey) {
		JInternalFrame newframe = new JInternalFrame(title, true, false, true,
				true);
		newframe.setLocation(offsetx, offsety);
		newframe.getContentPane().add(p);
		if (sizex != 0 && sizey != 0) {
			newframe.setSize(sizex, sizey);
		} else {
			newframe.pack();
		}
		newframe.setVisible(true);
		return newframe;
	}

	private static void createAndShowGUI(String[] args) {
		// Create and set up the window.
		JFrame frame = new JFrame("Cashdesk on channel " + args[2] +  " connected to store at " + args[0] + ":" + args[1] + "/"
				+ args[3]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		frame.getContentPane().add(new CashDesk(args));

		// Display the window.
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(args);
			}
		});
		while (true) {
			Thread.sleep(5000);
		}
	}
}
