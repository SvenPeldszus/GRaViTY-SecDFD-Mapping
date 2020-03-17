package org.gravity.mapping.secdfd.ui.views;

import java.util.Collection;

import org.gravity.mapping.secdfd.AbstractCorrespondence;

public interface IListener {
	
	public void notify(Collection<AbstractCorrespondence> added);

}
