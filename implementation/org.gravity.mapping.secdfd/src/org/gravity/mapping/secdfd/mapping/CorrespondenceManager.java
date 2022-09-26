package org.gravity.mapping.secdfd.mapping;

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
import org.gravity.eclipse.util.MarkerUtil;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.SecdfdFactory;
import org.gravity.mapping.secdfd.TypeGraph2EDFD;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessName;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.ui.views.MappingLabelProvider;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TClass;
import org.gravity.typegraph.basic.TInterface;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.NamedEntity;

/**
 * Helper methods for correspondences
 *
 * @author speldszus
 *
 */
public class CorrespondenceManager {

	private static final Logger LOGGER = Logger.getLogger(CorrespondenceManager.class);

	private final Mapping mapping;
	private final MappingCache cache;
	private final IJavaProject project;

	private final HashMap<EObject, Collection<AbstractCorrespondence>> correspondences = new HashMap<>();

	public CorrespondenceManager(final Mapping mapping, final IJavaProject project, final MappingCache cache) {
		this.mapping = mapping;
		this.project = project;
		this.cache = cache;
		createCorrespondence((TypeGraph) mapping.getSource(), (EDFD) mapping.getTarget());
		mapping.getUserdefined().forEach(corr -> {
			addToMap(CorrespondenceHelper.getSource(corr), corr);
			addToMap(CorrespondenceHelper.getTarget(corr), corr);
		});
		mapping.getAccepted().forEach(corr -> {
			addToMap(CorrespondenceHelper.getSource(corr), corr);
			addToMap(CorrespondenceHelper.getTarget(corr), corr);
		});
		mapping.getSuggested().forEach(corr -> {
			addToMap(CorrespondenceHelper.getSource(corr), corr);
			addToMap(CorrespondenceHelper.getTarget(corr), corr);
		});
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
	MappingProcessName createCorrespondence(final TMethod member, final Element element, final Integer ranking) {
		MappingProcessName corr = (MappingProcessName) getCorrespondence(member, element);
		if (corr != null) {
			return corr;
		}
		corr = MappingFactory.eINSTANCE.createMappingProcessName();
		corr.setSource(member);
		corr.setTarget(element);
		addToMap(element, corr);
		addToMap(member, corr);
		this.cache.add(member, element);
		this.mapping.getCorrespondences().add(corr);

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
	MappingProcessSignature createCorrespondence(final TMethodSignature signature, final Element element, final Integer ranking,
			final Collection<AbstractMappingBase> derived) {
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
			this.cache.add(signature, element);
			this.mapping.getCorrespondences().add(corr);
		}
		MappingProcessName nameCorr = (MappingProcessName) getCorrespondence(signature.getMethod(), element);
		if (nameCorr == null) {
			nameCorr = createCorrespondence(signature.getMethod(), element, ranking);
			this.mapping.getSuggested().add(nameCorr);
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
	MappingProcessDefinition createCorrespondence(final TMethodDefinition member, final Element element, final Integer ranking,
			final Collection<? extends AbstractMappingBase> derived) {
		if (element instanceof ExternalEntity) {
			return null;
		}
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
		this.cache.add(member, element);
		this.mapping.getCorrespondences().add(corr);
		MappingProcessSignature sigCorr = (MappingProcessSignature) getCorrespondence(member.getSignature(), element);
		if (sigCorr == null) {
			final TMethodSignature signature = member.getSignature();
			sigCorr = createCorrespondence(signature, element, ranking, Collections.emptyList());
			this.mapping.getSuggested().add(sigCorr);
		}
		corr.getDerived().add(sigCorr);

		final TMethodDefinition overriding = (TMethodDefinition) member.getOverriding();
		if ((overriding != null) && (overriding.getDefinedBy() instanceof TInterface)) {
			MappingProcessDefinition overCorr = (MappingProcessDefinition) getCorrespondence(overriding, element);
			if (overCorr == null) {
				overCorr = createCorrespondence(overriding, element, ranking, Collections.singletonList(corr));
				this.mapping.getSuggested().add(overCorr);
			}
		}

		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));

		try {
			final Map<String, IType> astTypes = JavaASTUtil.getTypesForProject(this.project);
			MarkerUtil.createMarker(astTypes, member, element.getName(), IMarker.PRIORITY_NORMAL,
					IMarker.SEVERITY_INFO);
		} catch (final JavaModelException e) {
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
	MappingEntityType createCorrespondence(final TAbstractType type, final NamedEntity entity, final Integer ranking) {
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
		this.cache.add(type, entity);
		this.mapping.getCorrespondences().add(corr);

		if (type instanceof TInterface) {
			final TInterface tInterface = (TInterface) type;
			tInterface.getImplementedBy()
			.forEach(child -> this.mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
			tInterface.getChildInterfaces()
			.forEach(child -> this.mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
		} else if (type instanceof TClass) {
			((TClass) type).getChildClasses()
			.forEach(child -> this.mapping.getSuggested().add(createCorrespondence(child, entity, ranking)));
		}
		LOGGER.log(Level.INFO, "Create correspondence: " + MappingLabelProvider.prettyPrint(corr));
		try {
			final Map<String, IType> astTypes = JavaASTUtil.getTypesForProject(this.project);
			MarkerUtil.createMarker(astTypes, type, entity.getName(), IMarker.PRIORITY_NORMAL, IMarker.SEVERITY_INFO);
		} catch (final JavaModelException e) {
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
	TypeGraph2EDFD createCorrespondence(final TypeGraph pm, final EDFD dfd) {
		final TypeGraph2EDFD corr = SecdfdFactory.eINSTANCE.createTypeGraph2EDFD();
		corr.setSource(pm);
		corr.setTarget(dfd);
		addToMap(pm, corr);
		addToMap(dfd, corr);
		this.mapping.getCorrespondences().add(corr);
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
	boolean canCreate(final EObject pmObject, final EObject dfdObject, final Map<EObject, Set<EObject>> excludes) {
		if (dfdObject instanceof ExternalEntity) {
			return false;
		}
		if (excludes.containsKey(dfdObject) && excludes.get(dfdObject).contains(pmObject)) {
			return false;
		}
		final boolean isIgnored = this.mapping.getIgnored().stream()
				.anyMatch(ignored -> CorrespondenceHelper.getSource(ignored).equals(pmObject) && CorrespondenceHelper.getTarget(ignored).equals(dfdObject));
		if (isIgnored) {
			return false;
		}
		final boolean isPresent = this.mapping.getCorrespondences().stream()
				.anyMatch(ignored -> CorrespondenceHelper.getSource(ignored).equals(pmObject)
						&& CorrespondenceHelper.getTarget(ignored).equals(dfdObject));
		return !isPresent;
	}

	private void addToMap(final EObject key, final AbstractCorrespondence corr) {
		Collection<AbstractCorrespondence> values;
		if (this.correspondences.containsKey(key)) {
			values = this.correspondences.get(key);
		} else {
			values = new HashSet<>();
			this.correspondences.put(key, values);
		}
		values.add(corr);
	}

	/**
	 * Checks the correspondences of the given object
	 *
	 * @param object An object
	 * @return The correspondences
	 */
	Collection<AbstractCorrespondence> getCorrespondences(final EObject object) {
		if (this.correspondences.containsKey(object)) {
			final Collection<AbstractCorrespondence> value = this.correspondences.get(object);
			if (value != null) {
				return value;
			}
			this.correspondences.remove(object);
		}
		return Collections.emptySet();
	}

	AbstractCorrespondence getCorrespondence(final EObject pmElement, final EObject dfdElement) {
		final List<AbstractCorrespondence> collect = getCorrespondences(pmElement).stream()
				.filter(corr -> CorrespondenceHelper.getTarget(corr).equals(dfdElement)).collect(Collectors.toList());
		if (collect.isEmpty()) {
			return null;
		}
		if (collect.size() > 1) {
			LOGGER.log(Level.ERROR, "Multiple correspondences: " + collect);
		}
		return collect.get(0);
	}

	public void delete(final AbstractCorrespondence corr) {
		final EObject pmElement = CorrespondenceHelper.getSource(corr);
		final EObject dfdElement = CorrespondenceHelper.getTarget(corr);
		final Collection<AbstractCorrespondence> pm2corr = this.correspondences.get(pmElement);
		if (pm2corr != null) {
			pm2corr.remove(corr);
		}
		final Collection<AbstractCorrespondence> dfd2corr = this.correspondences.get(dfdElement);
		if (dfd2corr != null) {
			dfd2corr.remove(corr);
		}
		this.mapping.getCorrespondences().remove(corr);
		this.mapping.getSuggested().remove(corr);
		this.mapping.getIgnored().remove(corr);
		this.mapping.getAccepted().remove(corr);
		this.mapping.getUserdefined().remove(corr);
		this.cache.remove(pmElement, dfdElement);
		if (corr instanceof AbstractMappingBase) {
			for (final AbstractMappingDerived derived : ((AbstractMappingBase) corr).getDeriving()) {
				if (derived.getDerived().size() <= 1) {
					delete(derived);
				}
			}
			((AbstractMappingBase) corr).getDeriving().clear();
		}
		EcoreUtil.delete(corr);
	}

}
