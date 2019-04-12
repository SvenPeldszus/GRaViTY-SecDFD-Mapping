package org.gravity.mapping.secdfd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TInterface;
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

	private final Mapping mapping;
	private MappingCache cache;
	private final IJavaProject project;

	private HashMap<EObject, Collection<AbstractCorrespondence>> correspondences = new HashMap<>();



	public CorrespondenceHelper(Mapping mapping, IJavaProject project, MappingCache cache) {
		this.mapping = mapping;
		this.project = project;
		this.cache = cache;
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
	MappingProcessName createCorrespondence(TMethod member, Element element, Integer ranking) {
		MappingProcessName corr = (MappingProcessName) getCorrespondence(member, element);
		if (corr != null) {
			return (MappingProcessName) corr;
		} else {
			corr = MappingFactory.eINSTANCE.createMappingProcessName();
			corr.setSource(member);
			corr.setTarget(element);
			addToMap(element, corr);
			addToMap(member, corr);
			cache.add(member, element);
			mapping.getCorrespondences().add(corr);
		}
		corr.setRanking(ranking);
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
			Collection<AbstractMappingBase> derived) {
		MappingProcessSignature corr = (MappingProcessSignature) getCorrespondence(signature, element);
		if (corr != null) {
			return corr;
		} else {
			corr = MappingFactory.eINSTANCE.createMappingProcessSignature();
			corr.setSource(signature);
			corr.setTarget(element);
			corr.getDerived().addAll(derived);
			addToMap(element, corr);
			addToMap(signature, corr);
			cache.add(signature, element);
			mapping.getCorrespondences().add(corr);
		}
		MappingProcessName nameCorr = (MappingProcessName) getCorrespondence(signature.getMethod(), element);
		if (nameCorr == null) {
			nameCorr = createCorrespondence(signature.getMethod(), element, ranking);
			mapping.getSuggested().add(nameCorr);
		}
		corr.getDerived().add(nameCorr);
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
	MappingProcessDefinition createCorrespondence(TMethodDefinition member, Element element, Integer ranking,
			Collection<? extends AbstractMappingBase> derived) {
		MappingProcessDefinition corr = (MappingProcessDefinition) getCorrespondence(member, element);
		if (corr != null) {
			return corr;
		}
		corr = MappingFactory.eINSTANCE.createMappingProcessDefinition();
		corr.setSource(member);
		corr.setTarget(element);
		corr.getDerived().addAll(derived);
		addToMap(element, corr);
		addToMap(member, corr);
		cache.add(member, element);
		mapping.getCorrespondences().add(corr);
		MappingProcessSignature sigCorr = (MappingProcessSignature) getCorrespondence(member.getSignature(), element);
		if (sigCorr == null) {
			TMethodSignature signature = member.getSignature();
			sigCorr = createCorrespondence(signature, element, ranking, Collections.emptyList());
			mapping.getSuggested().add(sigCorr);
		}
		corr.getDerived().add(sigCorr);
		
		TMethodDefinition overriding = member.getOverriding();
		if(overriding != null && overriding.getDefinedBy() instanceof TInterface){
			MappingProcessDefinition overCorr = (MappingProcessDefinition) getCorrespondence(overriding, element);
			if(overCorr == null) {
				overCorr = createCorrespondence(overriding, element, ranking, Collections.singletonList(corr));
				mapping.getSuggested().add(overCorr);
			}
		}
		
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		
		try {
			final HashMap<String, IType> astTypes = JavaASTUtil.getTypesForProject(project);
			MarkerHelper.createMarker(astTypes, member, element.getName(), IMarker.PRIORITY_NORMAL);
		} catch (JavaModelException e) {
			LOGGER.log(Level.ERROR, e);
		}
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
	MappingEntityType createCorrespondence(TAbstractType type, NamedEntity entity, Integer ranking) {
		MappingEntityType corr = (MappingEntityType) getCorrespondence(type, entity);
		if (corr != null) {
			return corr;
		}
		corr = MappingFactory.eINSTANCE.createMappingEntityType();
		corr.setSource(type);
		corr.setTarget(entity);
		corr.setRanking(ranking);
		addToMap(type, corr);
		addToMap(entity, corr);
		cache.add(type, entity);
		mapping.getCorrespondences().add(corr);

		if (type instanceof TInterface) {
			TInterface tInterface = (TInterface) type;
			tInterface.getImplementedBy().forEach(child -> mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
			tInterface.getChildInterfaces().forEach(child -> mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
		} else if (type instanceof TClass) {
			((TClass) type).getChildClasses().forEach(child -> mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		try {
			final HashMap<String, IType> astTypes = JavaASTUtil.getTypesForProject(project);
			MarkerHelper.createMarker(astTypes, type, entity.getName(), IMarker.PRIORITY_NORMAL);
		} catch (JavaModelException e) {
			LOGGER.log(Level.ERROR, e);
		}
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
	boolean canCreate(EObject pmObject, EObject dfdObject, Map<EObject, Set<EObject>> excludes) {
		if(excludes.containsKey(dfdObject) && excludes.get(dfdObject).contains(pmObject)) {
			return false;
		}
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

	AbstractCorrespondence getCorrespondence(EObject pmElement, EObject dfdElement) {
		List<AbstractCorrespondence> collect = getCorrespondences(pmElement).stream()
				.filter(corr -> getTarget(corr).equals(dfdElement)).collect(Collectors.toList());
		if (collect.isEmpty()) {
			return null;
		}
		if (collect.size() > 1) {
			LOGGER.log(Level.ERROR, "Multiple correspondences: " + collect);
		}
		return collect.get(0);
	}

	public void delete(AbstractCorrespondence corr) {
		EObject pmElement = getSource(corr);
		EObject dfdElement = getTarget(corr);
		Collection<AbstractCorrespondence> pm2corr = correspondences.get(pmElement);
		if(pm2corr != null) {
			pm2corr.remove(corr);
		}
		Collection<AbstractCorrespondence> dfd2corr = correspondences.get(dfdElement);
		if(dfd2corr !=null) {
			dfd2corr.remove(corr);
		}
		mapping.getCorrespondences().remove(corr);
		mapping.getSuggested().remove(corr);
		mapping.getIgnored().remove(corr);
		mapping.getAccepted().remove(corr);
		mapping.getUserdefined().remove(corr);
		cache.remove(pmElement, dfdElement);
		if(corr instanceof AbstractMappingBase) {
			for(AbstractMappingDerived derived : ((AbstractMappingBase) corr).getDeriving()) {
				if(derived.getDerived().size() <= 1) {
					delete(derived);
				}
			}
			((AbstractMappingBase) corr).getDeriving().clear();
		}
		EcoreUtil.delete(corr);
	}

}
