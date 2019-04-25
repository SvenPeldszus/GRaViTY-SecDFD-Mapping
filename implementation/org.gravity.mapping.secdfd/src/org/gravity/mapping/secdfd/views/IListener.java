package org.gravity.mapping.secdfd.views;

import java.util.Collection;

import org.moflon.tgg.runtime.AbstractCorrespondence;

public interface IListener {
	
	public void notify(Collection<AbstractCorrespondence> added);

}
