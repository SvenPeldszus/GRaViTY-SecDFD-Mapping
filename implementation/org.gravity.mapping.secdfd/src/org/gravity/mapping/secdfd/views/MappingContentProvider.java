package org.gravity.mapping.secdfd.views;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingRanking;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.moflon.tgg.runtime.CorrespondenceModel;

public class MappingContentProvider implements ITreeContentProvider {

	private final class compareByRanking implements Comparator<Object> {
		@Override
		public int compare(Object a, Object b) {
			if (a instanceof MappingProcessName || a instanceof MappingEntityType || a instanceof AbstractMappingDerived) {
				//a has a ranking
				if (a instanceof MappingProcessName || a instanceof MappingEntityType || a instanceof AbstractMappingDerived) {
					//b has a ranking
					if (((MappingRanking) a).getRanking()>((MappingRanking) b).getRanking()) return -1;
					else if ( ((MappingRanking) a).getRanking()==((MappingRanking) b).getRanking() ) {
						return 0;
					}else return 1;
				}else {
					//b has no ranking, a is smaller
					return 1;
				}
			}else {
				//a has no ranking, a is greater
				return -1;
			}
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection) {
			return ((Collection<?>) inputElement).toArray();
		}
		return null;
	}

	public boolean firstHigherRank(Object a, Object b) {
		if (a instanceof MappingProcessName || a instanceof MappingEntityType || a instanceof AbstractMappingDerived) {
			//a has a ranking
			if (a instanceof MappingProcessName || a instanceof MappingEntityType || a instanceof AbstractMappingDerived) {
				//b has a ranking
				return ((MappingRanking) a).getRanking()>((MappingRanking) b).getRanking();
			}else {
				//b has no ranking
				return false;
			}
		}else {
			//a has no ranking
			return true;
		}
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
			//order by ranking
			Object[] to_sort = ((CorrespondenceModel) parentElement).getCorrespondences().toArray();
			ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(to_sort));
			list.sort(new compareByRanking());
			return list.toArray();
			//((CorrespondenceModel) parentElement).getCorrespondences().toArray();
		} else if (parentElement instanceof Collection) {
			//order by ranking
			ArrayList<Object> list = (ArrayList<Object>) new ArrayList<Object>(Arrays.asList(((Collection<?>) parentElement).toArray()));
			list.sort(new compareByRanking());
			return list.toArray();
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
