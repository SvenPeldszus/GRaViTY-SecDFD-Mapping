package org.cocome.tradingsystem.cashdeskline.cashdesk.lightdisplaycontroller.impl;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.cocome.tradingsystem.cashdeskline.events.ExpressModeDisabledEvent;
import org.cocome.tradingsystem.cashdeskline.events.ExpressModeEnabledEvent;

@SuppressWarnings("serial")
public class LightDisplayController extends JPanel {
		
	public LightDisplayController(String eventchannel) {
		super(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		new LightDisplayControllerEventHandlerImpl(eventchannel, this);
	}
	
	public void update(ExpressModeEnabledEvent expressModeEnabledEvent) {
		this.setBackground(Color.GREEN);
	}
	
	public void update(ExpressModeDisabledEvent expressModeDisabledEvent) {
		this.setBackground(Color.DARK_GRAY);
	}
}