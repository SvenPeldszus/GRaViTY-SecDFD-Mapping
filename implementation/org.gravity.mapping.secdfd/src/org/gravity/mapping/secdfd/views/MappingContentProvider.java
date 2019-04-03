package org.gravity.mapping.secdfd.views;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;

public class MappingContentProvider implements ITreeContentProvider {
	
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection) {
			return ((Collection<?>) inputElement).toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Entry) {
			Object value = ((Entry<?, ?>) parentElement).getValue();
			if (value instanceof Mapping) {
				return new Object[] {
						new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("suggested",
								((Mapping) value).getSuggested()),
						new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("userdefined",
								((Mapping) value).getUserdefined()),
						new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("accepted",
								((Mapping) value).getAccepted()) };
			}
			else if (value instanceof CorrespondenceModel) {
				return ((CorrespondenceModel) value).getCorrespondences().toArray();
			}
			else if (value instanceof Collection) {
				return ((Collection<?>) value).toArray();		
			}
		
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Entry) {
			Object value = ((Entry<?, ?>) element).getValue();
			if (value instanceof CorrespondenceModel) {
				return true;
			}
			if (value instanceof Collection) {
				return !((Collection<?>) value).isEmpty();
			}
		}
		return false;
	}
}
