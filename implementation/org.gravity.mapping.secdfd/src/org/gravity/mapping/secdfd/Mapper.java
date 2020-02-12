/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.eclipse.util.MarkerUtil;
import org.gravity.mapping.secdfd.helpers.CallHelper;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.views.IListener;
import org.gravity.mapping.secdfd.views.Logging;
import org.gravity.mapping.secdfd.views.MappingLabelProvider;
import org.gravity.typegraph.basic.BasicFactory;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TConstructorName;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TPackage;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.xtext.example.mydsl.validation.MyDslValidator;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.DataStore;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTrackingPackage;
import eDFDFlowTracking.Element;
import eDFDFlowTracking.ExternalEntity;
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

	public static final String MAPPING_MARKER = "org.gravity.mapping.secdfd.markers.java";

	/**
	 * The correspondence model built by this class
	 */
	private Mapping mapping;

	/**
	 * All types and operations from the program model
	 */
	private List<TAbstractType> types;
	private List<TMethod> methods;

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

	private Set<IListener> userefinedListeners = new HashSet<>();	

	public Mapper(TypeGraph pm, EDFD dfd, IFile destination) {
		this.pm = pm;
		this.dfd = dfd;
		this.destination = destination;

		initMethodsAndTypes(pm);

		initializeMapping(pm, dfd, destination);

		for (Asset asset : dfd.getAsset()) {
			cache.addAll(mapToType(asset).map(Type2NamedEntity::getSource).collect(Collectors.toSet()), asset);
		}

		for (Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (EDFDFlowTrackingPackage.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					Set<TMethod> correspondingMethods = mapToMethod(node).map(Method2Element::getSource)
							.collect(Collectors.toSet());
					cache.addAllMethods(correspondingMethods, node);
				} else if (EDFDFlowTrackingPackage.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					Set<TAbstractType> correspondingTypes = mapToType(node).map(Type2NamedEntity::getSource)
							.collect(Collectors.toSet());
					cache.addAll(correspondingTypes, node);
				}
			}
		}
		optimizer = new MappingOptimizer(helper, cache, mapping);
	}

	public Mapper(IFile mappingFile) throws IOException, CoreException {
		this.destination = mappingFile;
		this.mapping = loadMapping(mappingFile);
		this.pm = (TypeGraph) mapping.getSource();
		this.dfd = (EDFD) mapping.getTarget();

		initMethodsAndTypes(pm);

		cache.load(mapping);
		helper = new CorrespondenceHelper(mapping, JavaCore.create(destination.getProject()), cache);

		optimizer = new MappingOptimizer(helper, cache, mapping);
	}

	/**
	 * Searches all methods and types in the program model
	 * 
	 * @param pm The program model
	 */
	private void initMethodsAndTypes(TypeGraph pm) {
		// Save types and methods from the program model in fields as they are accessed
		// very often
		types = pm.getOwnedTypes().stream().filter(t -> !"T".equals(t.getTName()))
				.filter(t -> !"Anonymous".equals(t.getTName())).collect(Collectors.toList());
		methods = pm.getMethods().stream().filter(m -> !(m instanceof TConstructorName)).collect(Collectors.toList());
	}

	/**
	 * @param corr
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 */
	private Mapping loadMapping(IFile corr) throws IOException, CoreException {
		String path = corr.getFullPath().toString();
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource corrRes = rs.createResource(URI.createPlatformResourceURI(path, true));
		corrRes.load(corr.getContents(), Collections.emptyMap());
		EcoreUtil.resolveAll(rs);
		return (Mapping) corrRes.getContents().get(0);
	}

	public void addUserdefinedListener(IListener listener) {
		userefinedListeners.add(listener);
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
			if (corr instanceof MappingProcessDefinition) {
				helper.getCorrespondences(CorrespondenceHelper.getSource(corr)).forEach(other -> {
					if (other != corr) {
						reject(other);
					}
				});
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
			} else if (dfdObject instanceof Asset || dfdObject instanceof DataStore) {
				if (pmObject instanceof TMember) {
					Set<TMember> value = cache.getElementMemberMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
				} else {
					Set<TAbstractType> value = cache.getEntityTypeMapping().get(dfdObject);
					if (value != null) {
						value.remove(pmObject);
					}
					EList<AbstractMappingDerived> deriving = ((MappingEntityType) corr).getDeriving();
					for (int i = 0; i < deriving.size(); i++) {
						AbstractMappingDerived derivingCorr = deriving.remove(0);
						EList<AbstractMappingBase> derivedFrom = derivingCorr.getDerived();
						derivedFrom.remove(corr);
						if (derivedFrom.size() == 1) {
							reject(derivingCorr);
						}
					}
				}
			}
		}
		try {
			final Map<String, IType> astTypes = JavaASTUtil
					.getTypesForProject(JavaCore.create(destination.getProject()));
			MarkerUtil.deleteMarker(astTypes, CorrespondenceHelper.getSource(corr));
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
					final Map<String, IType> astTypes = JavaASTUtil
							.getTypesForProject(JavaCore.create(destination.getProject()));
					MarkerUtil.createMarker(astTypes, CorrespondenceHelper.getSource(userCorr),
							((NamedEntity) CorrespondenceHelper.getTarget(userCorr)).getName(), IMarker.PRIORITY_NORMAL,
							IMarker.SEVERITY_INFO);
				} catch (JavaModelException e) {
					LOGGER.log(Level.ERROR, e);
				}
			}
		}
		if (userCorr == null) {
			userCorr = addNewUserdefinedCorr(pmObject, dfdObject);
		}
		if (userCorr != null) {
			Deque<AbstractCorrespondence> stack = new LinkedList<>();
			stack.add(userCorr);
			while (!stack.isEmpty()) {
				AbstractCorrespondence next = stack.pop();
				mapping.getCorrespondences().add(next);
				mapping.getUserdefined().add(next);
				if (next instanceof AbstractMappingDerived) {
					stack.addAll(((AbstractMappingDerived) next).getDerived());
				}
			}
			for (IListener listener : userefinedListeners) {
				listener.notify(Collections.singleton(userCorr));
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
		List<Method2Element> list = new ArrayList<>();
		for (TMethod method : methods) {
			int rank = StringCompare.compare(element.getName(), method.getTName());
			if (rank > 0 && helper.canCreate(method, element, Collections.emptyMap())) {
				Method2Element corr = helper.createCorrespondence(method, element, rank);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
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
	private Stream<Type2NamedEntity> mapToType(Asset asset) {
		ArrayList<Type2NamedEntity> list = new ArrayList<Type2NamedEntity>();
		switch (asset.getType()) {
		case NUMBER:
//			TAbstractType number = pm.getAbstractType("java.lang.Number");
//			if (number != null) {
//				MappingOptimizer.getAllChildClasses(number).forEach(n -> {
//					Type2NamedEntity corr = helper.createCorrespondence(n, asset, 90);
//					mapping.getSuggested().add(corr);
//					list.add(corr);
//				});
//			}
			for (String name : new String[] { "int", "long", "float", "double" }) {
				Type2NamedEntity corr = helper.createCorrespondence(pm.getClass(name), asset, 90);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		case VECTOR:
		case OBJECT:
			return mapToType((NamedEntity) asset);
		case STRING:
			TPackage lang = pm.getPackage(new String[] { "java", "lang" });
			TAbstractType string = lang.getOwnedTypes().parallelStream().filter(t -> "String".equals(t.getTName()))
					.findAny().orElse(null);
			if (string == null) {
				string = BasicFactory.eINSTANCE.createTClass();
				string.setTName("String");
				lang.getOwnedTypes().add(string);
			}
			if (helper.canCreate(string, asset, Collections.emptyMap())) {
				Type2NamedEntity corr = helper.createCorrespondence(string, asset, 100);
				mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		case BOOLEAN:
			Type2NamedEntity objectCorr = helper.createCorrespondence(pm.getType("java.lang.Boolean"), asset, 90);
			mapping.getSuggested().add(objectCorr);
			list.add(objectCorr);
			Type2NamedEntity primitiveCorr = helper.createCorrespondence(pm.getType("boolean"), asset, 90);
			mapping.getSuggested().add(primitiveCorr);
			list.add(primitiveCorr);
			break;
		default:
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
		List<Type2NamedEntity> list = new ArrayList<>();
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
	 * A getter for mappings for the given process
	 * 
	 * @param process the process for which mappings are requested
	 * @return the mappings
	 */
	public Set<TMethodDefinition> getMapping(Process process) {
		return cache.getElementMemberMapping().getOrDefault(process, Collections.emptySet()).parallelStream()
				.filter(member -> (member instanceof TMethodDefinition)).map(member -> (TMethodDefinition) member)
				.collect(Collectors.toSet());
	}

	/**
	 * A getter for mappings for the given asset
	 * 
	 * @param asset the asset for which mappings are requested
	 * @return the mappings
	 */
	public Collection<TAbstractType> getMapping(Asset asset) {
		return cache.getEntityTypeMapping().getOrDefault(asset, Collections.emptySet());
	}

	public Process getMapping(TMethodDefinition method) {
		Set<Process> processes = helper.getCorrespondences(method).parallelStream()
				.map(corr -> (Process) CorrespondenceHelper.getTarget(corr)).collect(Collectors.toSet());
		int size = processes.size();
		if(size == 1) {
			return processes.iterator().next();
		}
		if(size > 1) {
			throw new IllegalStateException();
		}
		return null;
	}

	public Set<Asset> getMapping(TAbstractType type) {
		return helper.getCorrespondences(type).parallelStream()
				.map(corr -> (Asset) CorrespondenceHelper.getTarget(corr)).collect(Collectors.toSet());
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

	public void addRandom() {
		Map<Element, Set<TSignature>> elementSignatureMapping = cache.getElementSignatureMapping();
		Map<Element, Set<TMember>> elementMemberMapping = cache.getElementMemberMapping();
		Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = cache.getEntityTypeMapping();

//		for (Entry<Element, Set<TSignature>> entry : elementSignatureMapping.entrySet()) {
//			Element element = entry.getKey();
//			for (TSignature signature : entry.getValue()) {
//				if (signature instanceof TMethodSignature) {
//					TMethodSignature methodSignature = (TMethodSignature) signature;
//					if(methodSignature.getDefinitions().size() != 1) {
//						continue;
//					}	
//					MappingProcessSignature sigCorr = (MappingProcessSignature) helper.getCorrespondence(signature,
//							element);
//					if (sigCorr.getDeriving().isEmpty()) {
//						TMethodDefinition methodDefinition = methodSignature.getDefinitions().get(0);
//						if(helper.canCreate(methodDefinition, sigCorr.getTarget(), Collections.emptyMap())) {
//							MappingProcessDefinition newCorr = helper.createCorrespondence(methodDefinition, sigCorr.getTarget(), 45, Collections.singleton(sigCorr));
//							mapping.getSuggested().add(newCorr);
//						}
//					}
//				}
//			}
//		}

		Set<MappingProcessDefinition> relevantProcessDefinitionMappings = Stream
				.concat(mapping.getUserdefined().parallelStream(), mapping.getAccepted().parallelStream())
				.filter(corr -> corr instanceof MappingProcessDefinition).map(corr -> (MappingProcessDefinition) corr)
				.filter(corr -> (corr.getTarget() instanceof Process)).collect(Collectors.toSet());

		for (MappingProcessDefinition mappingProcessDefinition : relevantProcessDefinitionMappings) {
			Process process = (Process) mappingProcessDefinition.getTarget();
			TMethodDefinition method = (TMethodDefinition) mappingProcessDefinition.getSource();

			Set<Process> targetProcesses = process.getOutflows().parallelStream()
					.flatMap(flow -> flow.getTarget().parallelStream()).filter(element -> element instanceof Process)
					.filter(targetProcess -> !elementMemberMapping.containsKey(targetProcess)
							|| !elementMemberMapping.get(targetProcess).contains(method))
					.map(element -> (Process) element).collect(Collectors.toSet());
			if (targetProcesses.isEmpty()) {
				continue;
			}

			Set<TAbstractType> assets = process.getOutflows().parallelStream()
					.flatMap(flow -> flow.getAssets().parallelStream())
					.filter(asset -> entityTypeMapping.containsKey(asset))
					.flatMap(asset -> entityTypeMapping.get(asset).parallelStream()).collect(Collectors.toSet());

			Stream<TMethodDefinition> calling = Stream.empty();
			TAbstractType returnType = method.getSignature().getReturnType();
			if ("void".equals(returnType.getTName()) || assets.contains(returnType)) {
				calling = CallHelper.getAllInCalls(method).parallelStream()
						.filter(member -> member instanceof TMethodDefinition)
						.map(member -> (TMethodDefinition) member);
			} else {
				if (assets.contains(returnType)) {
					for (TMethodDefinition caller : CallHelper.getAllInCalls(method).parallelStream()
							.filter(member -> member instanceof TMethodDefinition)
							.map(member -> (TMethodDefinition) member).collect(Collectors.toSet())) {
						process.getOutflows().parallelStream()
//								.filter(flow -> flow.getAssets().parallelStream()
//										.filter(asset -> entityTypeMapping.containsKey(asset)).findAny().isPresent())
								.flatMap(flow -> flow.getTarget().stream()).forEach(p -> {
									MappingProcessDefinition newCorr = helper.createCorrespondence(caller, p, 30,
											Collections.emptySet());
									mapping.getSuggested().add(newCorr);
								});
					}
				}
			}

			Set<TMethodDefinition> notMappedAccessedDefinitions = Stream
					.concat(calling, CallHelper.getAllOutCalls(method).parallelStream()
							.filter(member -> member instanceof TMethodDefinition).filter(member -> {
								for (AbstractCorrespondence c : helper.getCorrespondences(member)) {
									if (c instanceof MappingProcessDefinition
											&& mapping.getCorrespondences().contains(c)) {
										return false;
									}
								}
								return true;
							}).map(member -> (TMethodDefinition) member).filter(definiton -> {
								if (assets.contains(definiton.getDefinedBy())) {
									return true;
								}
								for (TParameter param : definiton.getSignature().getParameters()) {
									if (assets.contains(param.getType())) {
										return true;
									}
								}
								return false;
							}))
					.collect(Collectors.toSet());

			Set<TMethodDefinition> definitionWithKnownAsset = notMappedAccessedDefinitions.parallelStream()
					.filter(def -> def.getDefinedBy().isDeclared()).collect(Collectors.toSet());
			for (TMethodDefinition toMap : definitionWithKnownAsset) {
				Set<Asset> calledMethodAssets = Stream
						.concat(toMap.getSignature().getParameters().parallelStream().map(TParameter::getType),
								Stream.of(toMap.getDefinedBy(), toMap.getReturnType()))
						.flatMap(param -> helper.getCorrespondences(param).parallelStream())
						.map(CorrespondenceHelper::getTarget).filter(target -> target instanceof Asset)
						.map(target -> (Asset) target).collect(Collectors.toSet());

				List<Element> create = process.getOutflows().parallelStream()
						.filter(pr -> pr.getAssets().parallelStream().anyMatch(a -> calledMethodAssets.contains(a)))
						.flatMap(flow -> flow.getTarget().parallelStream().filter(t -> !(t instanceof ExternalEntity)))
						.collect(Collectors.toList());
				for (Element p : create) {
					if (helper.canCreate(toMap, p, Collections.emptyMap())) {
						MappingProcessDefinition newCorr = helper.createCorrespondence(toMap, p, 30,
								Collections.emptySet());
						mapping.getSuggested().add(newCorr);
					}
				}
			}
		}
	}

}
