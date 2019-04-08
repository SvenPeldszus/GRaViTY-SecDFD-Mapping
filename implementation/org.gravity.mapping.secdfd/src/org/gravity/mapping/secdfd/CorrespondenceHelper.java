package org.gravity.mapping.secdfd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.model.mapping.MappingRanking;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.AbstractCorrespondence;

import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.NamedEntity;

/**
 * Helper methods for correspondences
 * 
 * @author speldszus
 *
 */
public class CorrespondenceHelper {

	private static final Logger LOGGER = Logger.getLogger(CorrespondenceHelper.class);

	private Mapping mapping;

	private HashMap<EObject, Collection<AbstractCorrespondence>> correspondences = new HashMap<>();

	public CorrespondenceHelper(Mapping mapping) {
		this.mapping = mapping;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param element A node object
	 * @param member  A method object
	 * @return The correspondence
	 * @throws AddingIgnoredCorrespondenceException
	 */
	Method2Element createCorrespondence(TMethod member, Element element, Integer ranking) {
		MappingProcessName corr;
		Optional<AbstractCorrespondence> existing = getCorrespondence(member, element).parallelStream()
				.filter(c -> c instanceof MappingProcessName).findAny();
		if (existing.isPresent()) {
			corr = (MappingProcessName) existing.get();
		} else {
			corr = MappingFactory.eINSTANCE.createMappingProcessName();
			corr.setSource(member);
			corr.setTarget(element);
			addToMap(element, corr);
			addToMap(member, corr);
			mapping.getCorrespondences().add(corr);
		}
		corr.setRanking(ranking);
		Collection<AbstractCorrespondence> bonusCorr = getCorrespondence(member, element);
		if (!bonusCorr.isEmpty()) {
			AbstractCorrespondence ac = bonusCorr.iterator().next();
			// increase the ranking
			if (((MappingRanking) ac).getRanking() < 100) {
				((MappingRanking) ac).setRanking(((MappingRanking) ac).getRanking() + 15);
			}
		} else if (bonusCorr.size() > 1) {
			// logg it
			LOGGER.log(Level.INFO, "More than one corresponcende: " + MappingLabelProvider.prettyPrint(corr));
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		return corr;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param asset   An element
	 * @param type    A signature
	 * @param ranking A ranking
	 * 
	 * @return The correspondence
	 */
	MappingProcessSignature createCorrespondence(TMethodSignature signature, Element element, Integer ranking,
			Collection<AbstractCorrespondence> derived) {
		MappingProcessSignature corr;
		Optional<AbstractCorrespondence> existing = getCorrespondence(signature, element).parallelStream()
				.filter(c -> c instanceof MappingProcessName).findAny();
		if (existing.isPresent()) {
			corr = (MappingProcessSignature) existing.get();
		} else {
			corr = MappingFactory.eINSTANCE.createMappingProcessSignature();
			corr.setSource(signature);
			corr.setTarget(element);
			addToMap(element, corr);
			addToMap(signature, corr);
			mapping.getCorrespondences().add(corr);
		}
		corr.setRanking(ranking);
		corr.getDerived().addAll(derived);
		Collection<AbstractCorrespondence> bonusCorr = getCorrespondence(signature, element);
		if (!bonusCorr.isEmpty()) {
			AbstractCorrespondence ac = bonusCorr.iterator().next();
			// increase the ranking
			if (((MappingRanking) ac).getRanking() < 100) {
				((MappingRanking) ac).setRanking(((MappingRanking) ac).getRanking() + 15);
			}
		} else if (bonusCorr.size() > 1) {
			// logg it
			LOGGER.log(Level.INFO, "More than one corresponcende: " + MappingLabelProvider.prettyPrint(corr));
		}
		if (getCorrespondences(signature.getMethod()).isEmpty()) {
			Method2Element parentCorr = createCorrespondence(signature.getMethod(), element, ranking);
			corr.getDerived().add(parentCorr);
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		return corr;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param element A node object
	 * @param member  A method object
	 * @param ranking
	 * @return The correspondence
	 */
	MappingProcessDefinition createCorrespondence(TMember member, Element element, Integer ranking,
			Collection<AbstractCorrespondence> derived) {
		MappingProcessDefinition corr;
		Optional<AbstractCorrespondence> existing = getCorrespondence(member, element).parallelStream()
				.filter(c -> c instanceof MappingProcessDefinition).findAny();
		if (existing.isPresent()) {
			corr = (MappingProcessDefinition) existing.get();
		} else {
			corr = MappingFactory.eINSTANCE.createMappingProcessDefinition();
			corr.setSource(member);
			corr.setTarget(element);
			addToMap(element, corr);
			addToMap(member, corr);
			mapping.getCorrespondences().add(corr);
		}
		corr.setRanking(ranking);
		corr.getDerived().addAll(derived);
		Collection<AbstractCorrespondence> bonusCorr = getCorrespondence(member, element);
		if (!bonusCorr.isEmpty()) {
			AbstractCorrespondence ac = bonusCorr.iterator().next();
			// increase the ranking
			if (((MappingRanking) ac).getRanking() < 100) {
				((MappingRanking) ac).setRanking(((MappingRanking) ac).getRanking() + 15);

			}
		} else if (bonusCorr.size() > 1) {
			// logg it
			LOGGER.log(Level.INFO, "More than one corresponcende: " + MappingLabelProvider.prettyPrint(corr));
		}
		if (getCorrespondences(member.getSignature()).isEmpty()) {
			TMethodSignature signature = ((TMethodDefinition) member).getSignature();
			corr.getDerived().add(createCorrespondence(signature, element, ranking, Collections.emptyList()));
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		return corr;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param asset An named entity
	 * @param type  A type object
	 * @return The correspondence
	 */
	Type2NamedEntity createCorrespondence(TAbstractType type, NamedEntity entity, Integer ranking) {
		MappingEntityType corr;
		Optional<AbstractCorrespondence> existing = getCorrespondence(type, entity).parallelStream()
				.filter(c -> c instanceof MappingEntityType).findAny();
		if (existing.isPresent()) {
			corr = (MappingEntityType) existing.get();
		} else {
			corr = MappingFactory.eINSTANCE.createMappingEntityType();
			corr.setSource(type);
			corr.setTarget(entity);
			addToMap(type, corr);
			addToMap(entity, corr);
			mapping.getCorrespondences().add(corr);
		}
		corr.setRanking(ranking);
		Collection<AbstractCorrespondence> bonusCorr = getCorrespondence(type, entity);
		if (!bonusCorr.isEmpty()) {
			AbstractCorrespondence ac = bonusCorr.iterator().next();
			// increase the ranking
			if (((MappingRanking) ac).getRanking() < 100) {
				((MappingRanking) ac).setRanking(((MappingRanking) ac).getRanking() + 15);
			}
		} else if (bonusCorr.size() > 1) {
			// logg it
			LOGGER.log(Level.INFO, "More than one corresponcende: " + MappingLabelProvider.prettyPrint(corr));
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		return corr;
	}

	/**
	 * Creates a new correspondence between a program model and a data flow diagram
	 * and adds it to the correspondence model
	 * 
	 * @param pm  The program model
	 * @param dfd The data flow diagram
	 */
	TypeGraph2EDFD createCorrespondence(TypeGraph pm, EDFD dfd) {
		TypeGraph2EDFD corr = SecdfdFactory.eINSTANCE.createTypeGraph2EDFD();
		corr.setSource(pm);
		corr.setTarget(dfd);
		addToMap(pm, corr);
		addToMap(dfd, corr);
		mapping.getCorrespondences().add(corr);
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		return corr;
	}

	/**
	 * Checks if there is a ignored correspondence between the two objects or has
	 * already been created
	 * 
	 * @param pmObject  A object from a program model
	 * @param dfdObject A object from a DFD
	 * @return true, if this correspondence is not ignored and not already created
	 */
	boolean canCreate(EObject pmObject, EObject dfdObject) {
		boolean isIgnored = mapping.getIgnored().stream()
				.filter(ignored -> getSource(ignored).equals(pmObject) && getTarget(ignored).equals(dfdObject))
				.findAny().isPresent();
		if (isIgnored) {
			return false;
		}
		boolean isPresent = mapping.getCorrespondences().stream()
				.filter(ignored -> getSource((AbstractCorrespondence) ignored).equals(pmObject)
						&& getTarget((AbstractCorrespondence) ignored).equals(dfdObject))
				.findAny().isPresent();
		return !isPresent;
	}

	private void addToMap(EObject key, AbstractCorrespondence corr) {
		Collection<AbstractCorrespondence> values;
		if (correspondences.containsKey(key)) {
			values = correspondences.get(key);
		} else {
			values = new HashSet<>();
			correspondences.put(key, values);
		}
		values.add(corr);
	}

	/**
	 * Checks the correspondences of the given object
	 * 
	 * @param object An object
	 * @return The correspondences
	 */
	Collection<AbstractCorrespondence> getCorrespondences(EObject object) {
		if (correspondences.containsKey(object)) {
			return correspondences.get(object);
		}
		return Collections.emptySet();
	}

	/**
	 * A getter for the source of a correspondence
	 * 
	 * @param correspondence The correspondence for which the source is requested
	 * @return The source
	 */
	public static EObject getSource(AbstractCorrespondence correspondence) {
		Method method;
		try {
			method = correspondence.getClass().getDeclaredMethod("getSource");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			try {
				method = correspondence.getClass().getMethod("getSource");
			} catch (NoSuchMethodException | SecurityException e1) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
		}
		try {
			return (EObject) method.invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	/**
	 * A getter for the target of a correspondence
	 * 
	 * @param correspondence The correspondence for which the target is requested
	 * @return The target
	 */
	public static EObject getTarget(AbstractCorrespondence correspondence) {
		Method method;
		try {
			method = correspondence.getClass().getDeclaredMethod("getTarget");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			try {
				method = correspondence.getClass().getMethod("getTarget");
			} catch (NoSuchMethodException | SecurityException e1) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
		}
		try {
			return (EObject) method.invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	Collection<AbstractCorrespondence> getCorrespondence(EObject pmElement, EObject dfdElement) {
		return getCorrespondences(pmElement).stream().filter(corr -> getTarget(corr).equals(dfdElement))
				.collect(Collectors.toList());
	}

}
