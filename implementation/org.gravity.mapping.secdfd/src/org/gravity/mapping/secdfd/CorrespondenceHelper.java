package org.gravity.mapping.secdfd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
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
	 */
	Method2Element createCorrespondence(Element element, TMethod member, Integer ranking) {
		MappingProcessName corr = MappingFactory.eINSTANCE.createMappingProcessName();
		corr.setSource(member);
		corr.setTarget(element);
		corr.setRanking(ranking);
		mapping.getCorrespondences().add(corr);
		addToMap(element, corr);
		addToMap(member, corr);
		return corr;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param element A node object
	 * @param member  A method object
	 * @return The correspondence
	 */
	Defintion2Element createCorrespondence(Element element, TMember member) {
		Defintion2Element corr = MappingFactory.eINSTANCE.createMappingProcessDefinition();
		corr.setSource(member);
		corr.setTarget(element);
		mapping.getCorrespondences().add(corr);
		addToMap(element, corr);
		addToMap(member, corr);
		return corr;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param asset An element
	 * @param type  A signature
	 * @return The correspondence
	 */
	MappingProcessSignature createCorrespondence(Element element, TMethodSignature signature) {
		MappingProcessSignature corr = MappingFactory.eINSTANCE.createMappingProcessSignature();
		corr.setSource(signature);
		corr.setTarget(element);
		mapping.getCorrespondences().add(corr);
		addToMap(element, corr);
		addToMap(signature, corr);
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
	Type2NamedEntity createCorrespondence(NamedEntity entity, TAbstractType type, Integer ranking) {
		MappingEntityType corr = (MappingEntityType) SecdfdFactory.eINSTANCE.createType2NamedEntity();
		corr.setSource(type);
		corr.setTarget(entity);
		corr.setRanking(ranking);
		mapping.getCorrespondences().add(corr);
		addToMap(entity, corr);
		addToMap(type, corr);
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
		return corr;
	}

	private void addToMap(EObject element, AbstractCorrespondence corr) {
		Collection<AbstractCorrespondence> values;
		if(correspondences.containsKey(element)) {
			values = correspondences.get(element);
		}
		else {
			values = new HashSet<>();
		}
		values.add(corr);
	}
	
	/**
	 * Checks the correspondences of the given object
	 * 
	 * @param object An object
	 * @return The correspondences
	 */
	Collection<AbstractCorrespondence> getCorrespondences(EObject object){
		if(correspondences.containsKey(object)) {
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
		} catch (IllegalArgumentException | NoSuchMethodException
				| SecurityException e) {
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
		} catch (IllegalArgumentException | NoSuchMethodException
				| SecurityException e) {
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

}
