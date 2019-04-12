/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.views.Logging;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TConstructorName;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.AbstractCorrespondence;
import org.xtext.example.mydsl.validation.MyDslValidator;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.NamedEntity;
import eDFDFlowTracking.Process;

/**
 * @author speldszus
 *
 */
public class Mapper {

	/**
	 * The logger of this class
	 */
	private static final Logger LOGGER = Logger.getLogger(Mapper.class);

	/**
	 * The correspondence model built by this class
	 */
	private Mapping mapping;

	/**
	 * All types and operations from the program model
	 */
	private static List<TAbstractType> types;
	private static List<TMethod> methods;

	private MappingCache cache = new MappingCache();

	/**
	 * The program model for which a mapping has been created
	 */
	private final TypeGraph pm;

	/**
	 * The DFD for which a mapping has been created
	 */
	private final EDFD dfd;

	/**
	 * The location at which the mapping should be stored
	 */
	private IFile destination;

	private CorrespondenceHelper helper;

	private MappingOptimizer optimizer;

	public Mapper(TypeGraph pm, EDFD dfd, IFile destination) {
		this.pm = pm;
		this.dfd = dfd;
		this.destination = destination;

		// Save types and methods from the program model in fields as they are accessed
		// very often
		types = pm.getOwnedTypes().stream().filter(t -> !"T".equals(t.getTName()))
				.filter(t -> !"Anonymous".equals(t.getTName())).collect(Collectors.toList());
		methods = pm.getMethods().stream().filter(m -> !(m instanceof TConstructorName)).collect(Collectors.toList());

		initializeMapping(pm, dfd, destination);

		for (Asset asset : dfd.getAsset()) {
			cache.addAll(mapToType(asset).map(c -> c.getSource()).collect(Collectors.toSet()), asset);
		}

		for (Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (EDFDFlowTracking1Package.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					Set<TMethod> correspondingMethods = mapToMethod(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					cache.addAllMethods(correspondingMethods, node);
				} else if (EDFDFlowTracking1Package.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					Set<TAbstractType> correspondingTypes = mapToType(node).map(c -> c.getSource())
							.collect(Collectors.toSet());
					cache.addAll(correspondingTypes, node);
				}
			}
		}
		optimizer = new MappingOptimizer(helper, cache, mapping);
		optimize();
	}

	/**
	 * Create a correspondence model between the two models
	 * 
	 * @param pm          The program model
	 * @param dfd         The DFD
	 * @param destination The location where the model should be stored
	 */
	private void initializeMapping(TypeGraph pm, EDFD dfd, IFile destination) {
		// Create a correspondence model between the two models
		mapping = MappingFactory.eINSTANCE.createMapping();
		mapping.setSource(pm);
		mapping.setTarget(dfd);
		mapping.setName(dfd.getName());
		URI uri = URI.createURI(destination.toString());
		EList<EObject> contents = pm.eResource().getResourceSet().createResource(uri).getContents();
		contents.add(mapping);
		helper = new CorrespondenceHelper(mapping, JavaCore.create(destination.getProject()), cache);
		helper.createCorrespondence(pm, dfd);
	}

	/**
	 * Accept the given correspondence
	 * 
	 * @param corr   The correspondence
	 * @param update If the serialized files should be updated
	 */
	public void accept(AbstractCorrespondence corr) {
		if ((mapping.getCorrespondences().contains(corr) && !mapping.getUserdefined().contains(corr))
				|| mapping.getIgnored().contains(corr)) {
			boolean remove = mapping.getIgnored().remove(corr);
			if (remove) {
				mapping.getCorrespondences().add(corr);
				// add(CorrespondenceHelper.getSource(corr),
				// CorrespondenceHelper.getTarget(corr));
			} else {
				mapping.getSuggested().remove(corr);
			}
			mapping.getAccepted().add(corr);
			updateRanking(corr, 100);
			if (corr instanceof AbstractMappingDerived) {
				((AbstractMappingDerived) corr).getDerived().forEach(parent -> accept(parent));
			}
		}
	}

	/**
	 * Reject the given correspondence
	 * 
	 * @param corr The correspondence
	 */
	public void reject(AbstractCorrespondence corr) {
		if (mapping.getCorrespondences().contains(corr)) {
			mapping.getIgnored().add(corr);
			mapping.getUserdefined().remove(corr);
			mapping.getSuggested().remove(corr);
			mapping.getAccepted().remove(corr);
			EObject pmObject = CorrespondenceHelper.getSource(corr);
			EObject dfdObject = CorrespondenceHelper.getTarget(corr);
			if (dfdObject instanceof Process) {
				if (pmObject instanceof TMember) {
					Set<TMember> value = cache.getElementMemberMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
				} else if (pmObject instanceof TSignature) {
					Set<TSignature> value = cache.getElementSignatureMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
					((TMethodSignature) pmObject).getDefinitions().forEach(definiton -> {
						helper.getCorrespondences(definiton).forEach(defCorr -> reject(defCorr));
					});
				} else if (pmObject instanceof TMethod) {
					Set<TMethod> value = cache.getElementMethodMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
					((TMethod) pmObject).getSignatures().forEach(signature -> {
						helper.getCorrespondences(signature).forEach(sigCorr -> reject(sigCorr));
					});
				}
			} else if (pmObject instanceof Asset || pmObject instanceof DataStore) {
				Set<TAbstractType> value = cache.getEntityTypeMapping().get(dfdObject);
				if (value != null) {
					value.remove(pmObject);
				}
			}
		}
		try {
			final HashMap<String, IType> astTypes = JavaASTUtil
					.getTypesForProject(JavaCore.create(destination.getProject()));
			MarkerHelper.deleteMarker(astTypes, CorrespondenceHelper.getSource(corr));
		} catch (JavaModelException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * Set the correspondence between the two objects to userdefined or create a
	 * correspondence
	 * 
	 * @param pmObject  An object from a program model
	 * @param dfdObject An object from a DFD
	 */
	public void userdefined(EObject pmObject, EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		Collection<AbstractCorrespondence> correspondences = helper.getCorrespondences(pmObject);
		if (!correspondences.isEmpty()) {
			for (AbstractCorrespondence corr : correspondences) {
				if (CorrespondenceHelper.getTarget(corr).equals(dfdObject)) {
					userCorr = corr;
					break;
				}
			}
			mapping.getSuggested().remove(userCorr);
			mapping.getAccepted().remove(userCorr);
			if (mapping.getIgnored().contains(userCorr)) {
				try {
					final HashMap<String, IType> astTypes = JavaASTUtil
							.getTypesForProject(JavaCore.create(destination.getProject()));
					MarkerHelper.createMarker(astTypes, CorrespondenceHelper.getSource(userCorr),
							((NamedEntity) CorrespondenceHelper.getTarget(userCorr)).getName(),
							IMarker.PRIORITY_NORMAL);
				} catch (JavaModelException e) {
					LOGGER.log(Level.ERROR, e);
				}
			}
		}
		if (userCorr == null) {
			userCorr = addNewUserdefinedCorr(pmObject, dfdObject);
		}
		if (userCorr != null) {
			Stack<AbstractCorrespondence> stack = new Stack<>();
			stack.add(userCorr);
			while (!stack.isEmpty()) {
				AbstractCorrespondence next = stack.pop();
				mapping.getCorrespondences().add(next);
				mapping.getUserdefined().add(next);
				if (next instanceof AbstractMappingDerived) {
					stack.addAll(((AbstractMappingDerived) next).getDerived());
				}
			}
		}
	}

	/**
	 * Creates a new user defined correspondence
	 * 
	 * @param pmObject  The object from the program model
	 * @param dfdObject The object from the DFD
	 * @return The correspondence
	 */
	private AbstractCorrespondence addNewUserdefinedCorr(EObject pmObject, EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		if (pmObject instanceof TMethodDefinition) {
			TMethodDefinition method = (TMethodDefinition) pmObject;
			if (dfdObject instanceof Process) {
				Process process = (Process) dfdObject;
				userCorr = helper.createCorrespondence(method, process, 100, Collections.emptyList());
				cache.add(method, process);
			} else if (dfdObject instanceof DataStore) {
				DataStore store = (DataStore) dfdObject;
				userCorr = helper.createCorrespondence(method, store, 100, Collections.emptyList());
				cache.add(method, store);
			}
		} else if (pmObject instanceof TAbstractType) {
			TAbstractType type = (TAbstractType) pmObject;
			if (dfdObject instanceof Asset) {
				Asset asset = (Asset) dfdObject;
				userCorr = helper.createCorrespondence(type, asset, 100);
				cache.add(type, asset);
			} else if (dfdObject instanceof DataStore) {
				DataStore store = (DataStore) dfdObject;
				userCorr = helper.createCorrespondence(type, store, 100);
				cache.add(type, store);
			}
		}
		if (userCorr == null) {
			LOGGER.log(Level.ERROR, "Cannot add userdefinded correlation between " + pmObject + " and " + dfdObject);
		}
		return userCorr;
	}

	public void optimize() {
		this.optimizer.optimize();
		updateMappingOnFilesystem();
		Logging.writeLog(mapping.getCorrespondences());
	}

	/**
	 * Recursively updates the ranking
	 * 
	 * @param corr A correspondence
	 */
	private void updateRanking(AbstractCorrespondence corr, int ranking) {
		if (corr instanceof AbstractMappingRanking) {
			((AbstractMappingRanking) corr).setRanking(ranking);
		} else if (corr instanceof MappingProcessSignature) {
			for (AbstractCorrespondence parentCorr : helper.getCorrespondences(
					((TMethodSignature) ((MappingProcessSignature) corr).getSource()).getMethod())) {
				if (CorrespondenceHelper.getTarget(parentCorr).equals(((MappingProcessSignature) corr).getTarget())) {
					((AbstractMappingRanking) parentCorr).setRanking(ranking);
				}
			}
		} else if (corr instanceof MappingProcessDefinition) {
			for (AbstractCorrespondence parentCorr : helper.getCorrespondences(
					((TMethodDefinition) ((MappingProcessDefinition) corr).getSource()).getSignature().getMethod())) {
				if (CorrespondenceHelper.getTarget(parentCorr).equals(((MappingProcessDefinition) corr).getTarget())) {
					((AbstractMappingRanking) parentCorr).setRanking(ranking);
				}
			}
		}
	}

	/**
	 * Update the marker data for the DFD
	 */
	private void updateMarkers() {
		try {
			Map<String, Set<String>> map = new HashMap<>();
			mapping.getCorrespondences().stream()
					.filter(corr -> corr instanceof MappingProcessDefinition || corr instanceof MappingEntityType)
					.forEach(corr -> {
						String dfdElementName = ((NamedEntity) CorrespondenceHelper
								.getTarget((AbstractCorrespondence) corr)).getName();
						Set<String> pmElementStrings;
						if (map.containsKey(dfdElementName)) {
							pmElementStrings = map.get(dfdElementName);
						} else {
							pmElementStrings = new HashSet<>();
							map.put(dfdElementName, pmElementStrings);
						}
						EObject pmElement = CorrespondenceHelper.getSource((AbstractCorrespondence) corr);
						String pmElementString = MappingLabelProvider.prettyPrint(pmElement);
						pmElementStrings.add(pmElementString);
					});
			MyDslValidator.setMap(map);
			IFile file = destination.getParent().getFile(new Path(dfd.eResource().getURI().toFileString()));
			file.touch(new NullProgressMonitor());
		} catch (CoreException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * Writes the mapping to the file system
	 */
	public void updateMappingOnFilesystem() {
		updateMarkers();
		try {
			mapping.eResource().save(new FileOutputStream(destination.getLocation().toFile()), Collections.emptyMap());
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * Search methods in the pm corresponding to the node and create correspondences
	 * for them
	 * 
	 * @param asset The node for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Method2Element> mapToMethod(Element element) {
		ArrayList<Method2Element> list = new ArrayList<Method2Element>();
		for (TMethod method : methods) {
			int rank = StringCompare.compare(element.getName(), method.getTName());
			if (rank > 0 && helper.canCreate(method, element, Collections.emptyMap())) {
				Method2Element corr = helper.createCorrespondence(method, element, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
		}
		return list.stream();

//		return methods.stream()
//				.filter(m -> StringCompare.compare(node.getName(), m.getTName())>0)
//				.map(m -> {
//			Method2Element corr = helper.createCorrespondence(node, m, r);
//			mapping.getSuggested().add(corr);
//			return corr;
//		});
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param entity The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2NamedEntity> mapToType(Asset asset) {
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		switch (asset.getType()) {
		case NUMBER:
		case VECTOR:
		case OBJECT:
			return mapToType((NamedEntity) asset);
		case STRING:
			TAbstractType string = pm.getAbstractType("java.lang.String");
			if (helper.canCreate(string, asset, Collections.emptyMap())) {
				Type2NamedEntity corr = helper.createCorrespondence(string, asset, 100);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		}
		return list.stream();
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param entity The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2NamedEntity> mapToType(NamedEntity entity) {
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		for (TAbstractType type : types) {
			int rank = StringCompare.compare(entity.getName(), type.getTName());
			if (rank > 0 && helper.canCreate(type, entity, Collections.emptyMap())) {
				Type2NamedEntity corr = helper.createCorrespondence(type, entity, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
		}
		return list.stream();
	}

	/**
	 * A getter for the created mapping
	 * 
	 * @return the mapping
	 */
	public Mapping getMapping() {
		return mapping;
	}

	/**
	 * A getter for the proggram model
	 * 
	 * @return the pm
	 */
	public TypeGraph getPM() {
		return pm;
	}

	/**
	 * A getter for the DFD
	 * 
	 * @return the DFD
	 */
	public EDFD getDFD() {
		return dfd;
	}

	/**
	 * A getter for the location where the mapping is stored
	 * 
	 * @return The location
	 */
	public IFile getFile() {
		return destination;
	}

}
