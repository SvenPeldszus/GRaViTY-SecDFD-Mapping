package org.gravity.mapping.secdfd.views;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.stream.Stream;

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
		if (parentElement instanceof Mapping) {
			return new Object[] {
					new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("suggested",
							((Mapping) parentElement).getSuggested()),
					new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("userdefined",
							((Mapping) parentElement).getUserdefined()),
					new AbstractMap.SimpleEntry<String, Collection<AbstractCorrespondence>>("accepted",
							((Mapping) parentElement).getAccepted()) };
		} else if (parentElement instanceof CorrespondenceModel) {
			return ((CorrespondenceModel) parentElement).getCorrespondences().toArray();
		} else if (parentElement instanceof Collection) {
			return ((Collection<?>) parentElement).toArray();
		} else if (parentElement instanceof Stream) {
			return ((Stream<?>) parentElement).toArray();
		}
		if(parentElement instanceof Entry) {
			return getChildren(((Entry<?,?>) parentElement).getValue());
		}

		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Mapping) {
			return true;
		}
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
