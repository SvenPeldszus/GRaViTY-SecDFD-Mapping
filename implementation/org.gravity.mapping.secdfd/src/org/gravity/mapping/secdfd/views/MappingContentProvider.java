package org.gravity.mapping.secdfd.views;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.gravity.mapping.secdfd.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.typegraph.basic.TClass;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;

public class MappingContentProvider implements ITreeContentProvider {

	private final class CompareByRanking implements Comparator<AbstractCorrespondence> {
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
		} else if (parentElement instanceof Collection) {
			final Map<EObject, List<AbstractCorrespondence>> map = new HashMap<>();
			Collection<?> collection = ((Collection<?>) parentElement);
			collection.stream()
					.filter(e -> (e instanceof MappingProcessDefinition
							&& ((MappingProcessDefinition) e).getSource().getDefinedBy() instanceof TClass)
							|| e instanceof MappingEntityType)
					.map(e -> (AbstractCorrespondence) e).forEach(e -> {
						EObject key = CorrespondenceHelper.getTarget(e);
						List<AbstractCorrespondence> values;
						if (map.containsKey(key)) {
							values = map.get(key);
						} else {
							values = new LinkedList<>();
							map.put(key, values);
						}
						values.add(e);
					});
			return map.entrySet().toArray();
		}
		if (parentElement instanceof Entry) {
			Entry<?, ?> entry = (Entry<?, ?>) parentElement;
			if (entry.getKey() instanceof EObject) {
				return ((Collection<?>) entry.getValue()).toArray();
			}
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
