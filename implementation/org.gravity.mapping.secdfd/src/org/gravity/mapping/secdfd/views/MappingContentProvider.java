package org.gravity.mapping.secdfd.views;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;

public class MappingContentProvider implements ITreeContentProvider {

	private final class compareByRanking implements Comparator<AbstractCorrespondence> {
		@Override
		public int compare(AbstractCorrespondence a, AbstractCorrespondence b) {
			return MappingLabelProvider.getTotalRanking(b) - MappingLabelProvider.getTotalRanking(a);
		}
	}

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
			// order by ranking
			List<AbstractCorrespondence> list = ((CorrespondenceModel) parentElement).getCorrespondences().stream()
					.filter(e -> e instanceof MappingProcessDefinition || e instanceof MappingEntityType).map(e -> (AbstractCorrespondence) e)
					.collect(Collectors.toList());
			list.sort(new compareByRanking());
			return list.toArray();
		} else if (parentElement instanceof Collection) {
			// order by ranking
			List<AbstractCorrespondence> list = ((Collection<?>) parentElement).stream()
					.filter(e -> e instanceof MappingProcessDefinition || e instanceof MappingEntityType).map(e -> (AbstractCorrespondence) e)
					.collect(Collectors.toList());
			list.sort(new compareByRanking());
			return list.toArray();
		} else if (parentElement instanceof Stream) {
			return ((Stream<?>) parentElement).toArray();
		}
		if (parentElement instanceof Entry) {
			return getChildren(((Entry<?, ?>) parentElement).getValue());
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
