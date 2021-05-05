/**
 *
 */
package org.gravity.mapping.secdfd.mapping;

import java.io.FileOutputStream;
import java.io.IOException;
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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.gravity.eclipse.util.JavaASTUtil;
import org.gravity.eclipse.util.MarkerUtil;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.Method2Element;
import org.gravity.mapping.secdfd.StringCompare;
import org.gravity.mapping.secdfd.Type2NamedEntity;
import org.gravity.mapping.secdfd.helpers.CallHelper;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.helpers.Logging;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingBase;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingDerived;
import org.gravity.mapping.secdfd.model.mapping.AbstractMappingRanking;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.mapping.secdfd.model.mapping.MappingEntityType;
import org.gravity.mapping.secdfd.model.mapping.MappingFactory;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessDefinition;
import org.gravity.mapping.secdfd.model.mapping.MappingProcessSignature;
import org.gravity.mapping.secdfd.ui.views.IListener;
import org.gravity.mapping.secdfd.ui.views.MappingLabelProvider;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TConstructor;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.secdfd.dsl.validation.SecDFDValidator;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;
import org.secdfd.model.ModelPackage;
import org.secdfd.model.NamedEntity;
import org.secdfd.model.Process;

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

	private final MappingCache cache = new MappingCache();

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

	private CorrespondenceManager helper;

	private MappingOptimizer optimizer;

	private final Set<IListener> userefinedListeners = new HashSet<>();

	private final ResourceSet rs;

	public Mapper(final TypeGraph pm, final EDFD dfd, final IFile destination) {
		this.pm = pm;
		this.rs = pm.eResource().getResourceSet();
		this.dfd = dfd;
		this.destination = destination;

		initMethodsAndTypes(pm);

		initializeMapping(pm, dfd, destination);

		for (final Asset asset : dfd.getAsset()) {
			this.cache.addAll(mapToType(asset).map(Type2NamedEntity::getSource).collect(Collectors.toSet()), asset);
		}

		for (final Element node : dfd.getElements()) {
			if (node.getName() != null) {
				if (ModelPackage.eINSTANCE.getProcess().isSuperTypeOf(node.eClass())) {
					final Set<TMethod> correspondingMethods = mapToMethod(node).map(Method2Element::getSource)
							.collect(Collectors.toSet());
					this.cache.addAllMethods(correspondingMethods, node);
				} else if (ModelPackage.eINSTANCE.getDataStore().isSuperTypeOf(node.eClass())) {
					final Set<TAbstractType> correspondingTypes = mapToType(node).map(Type2NamedEntity::getSource)
							.collect(Collectors.toSet());
					this.cache.addAll(correspondingTypes, node);
				}
			}
		}
		this.optimizer = new MappingOptimizer(this.helper, this.cache, this.mapping);
	}

	/**
	 * Initializes the mapper with an existing mapping
	 *
	 * @param mapping     An existing mapping
	 * @param mappingFile The file containing the mapping
	 */
	public Mapper(final Mapping mapping, final IFile mappingFile) {
		this.mapping = mapping;
		this.destination = mappingFile;
		this.rs = mapping.eResource().getResourceSet();
		this.pm = (TypeGraph) mapping.getSource();
		this.dfd = (EDFD) mapping.getTarget();

		initMethodsAndTypes(this.pm);

		this.cache.load(mapping);
		this.helper = new CorrespondenceManager(mapping, JavaCore.create(this.destination.getProject()), this.cache);

		this.optimizer = new MappingOptimizer(this.helper, this.cache, mapping);
	}

	/**
	 * Initializes the mapper from a file with an existing mapping
	 *
	 * @param mappingFile The file containing the mapping
	 * @param rs          The resource set which should be used
	 * @throws IOException
	 * @throws CoreException
	 */
	public Mapper(final IFile mappingFile, final ResourceSet rs) throws IOException, CoreException {
		this(loadMapping(mappingFile, rs), mappingFile);
	}

	/**
	 * Initializes the mapper from a file with an existing mapping using a new
	 * resource set
	 *
	 * @param mappingFile The file containing the mapping
	 * @throws IOException
	 * @throws CoreException
	 */
	public Mapper(final IFile mappingFile) throws IOException, CoreException {
		this(mappingFile, new ResourceSetImpl());
	}

	protected Mapper(final ResourceSet rs, final TypeGraph pm, final EDFD dfd) {
		this.rs = rs;
		this.pm = pm;
		this.dfd = dfd;
	}

	/**
	 * Searches all methods and types in the program model
	 *
	 * @param pm The program model
	 */
	private void initMethodsAndTypes(final TypeGraph pm) {
		// Save types and methods from the program model in fields as they are accessed
		// very often
		this.types = pm.getOwnedTypes().stream().filter(t -> !"T".equals(t.getTName()))
				.filter(t -> !"Anonymous".equals(t.getTName())).collect(Collectors.toList());
		this.methods = pm.getMethods().stream().filter(m -> !containsConstructors(m)).collect(Collectors.toList());
	}

	private boolean containsConstructors(final TMethod m) {
		return m.getSignatures().parallelStream().flatMap(sig -> sig.getDefinitions().parallelStream())
				.anyMatch(TConstructor::isConstructor);
	}

	/**
	 * Loads an existing mapping from the file system
	 *
	 * @param corr The file containing the mapping
	 * @param rs   The resource set into which the mapping should be loaded
	 * @return The loaded mapping
	 * @throws IOException
	 * @throws CoreException
	 */
	private static Mapping loadMapping(final IFile corr, final ResourceSet rs) throws IOException, CoreException {
		final String path = corr.getFullPath().toString();
		final Resource corrRes = rs.createResource(URI.createPlatformResourceURI(path, true));
		corrRes.load(corr.getContents(), Collections.emptyMap());
		EcoreUtil.resolveAll(rs);
		return (Mapping) corrRes.getContents().get(0);
	}

	public void addUserdefinedListener(final IListener listener) {
		this.userefinedListeners.add(listener);
	}

	/**
	 * Create a correspondence model between the two models
	 *
	 * @param pm          The program model
	 * @param dfd         The DFD
	 * @param destination The location where the model should be stored
	 */
	private void initializeMapping(final TypeGraph pm, final EDFD dfd, final IFile destination) {
		final URI uri = URI.createPlatformResourceURI(
				destination.getProject().getName() + '/' + destination.getProjectRelativePath().toString(), true);
		if (destination.exists()) {
			for (final Resource resource : this.rs.getResources()) {
				if (uri.equals(resource.getURI())) {
					resource.unload();
				}
			}
			try {
				destination.delete(true, new NullProgressMonitor());
			} catch (final CoreException e) {
			}
		}

		final EList<EObject> contents = this.rs.createResource(uri).getContents();
		if (!contents.isEmpty()) {
			contents.clear();
		}
		this.mapping = MappingFactory.eINSTANCE.createMapping();
		this.mapping.setSource(pm);
		this.mapping.setTarget(dfd);
		this.mapping.setName(dfd.getName());
		contents.add(this.mapping);

		// Create a correspondence model between the two models
		this.helper = new CorrespondenceManager(this.mapping, JavaCore.create(destination.getProject()), this.cache);
	}

	/**
	 * Accept the given correspondence
	 *
	 * @param corr   The correspondence
	 * @param update If the serialized files should be updated
	 */
	public void accept(final AbstractCorrespondence corr) {
		if ((this.mapping.getCorrespondences().contains(corr) && !this.mapping.getUserdefined().contains(corr))
				|| this.mapping.getIgnored().contains(corr)) {
			final boolean remove = this.mapping.getIgnored().remove(corr);
			if (remove) {
				this.mapping.getCorrespondences().add(corr);
			} else {
				this.mapping.getSuggested().remove(corr);
			}
			this.mapping.getAccepted().add(corr);
			updateRanking(corr, 100);
			if (corr instanceof AbstractMappingDerived) {
				((AbstractMappingDerived) corr).getDerived().forEach(this::accept);
			}
			if (corr instanceof MappingProcessDefinition) {
				this.helper.getCorrespondences(CorrespondenceHelper.getSource(corr)).forEach(other -> {
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
	public void reject(final AbstractCorrespondence corr) {
		reject(corr, false);
	}

	/**
	 * Reject the given correspondence
	 *
	 * @param corr  The correspondence
	 * @param force If the deletion should be done even if it is user defined or
	 *              accepted
	 */
	public void reject(final AbstractCorrespondence corr, final boolean force) {
		if (!this.mapping.getCorrespondences().contains(corr)) {
			return;
		}

		final EList<AbstractCorrespondence> userdefined = this.mapping.getUserdefined();
		final EList<AbstractCorrespondence> accepted = this.mapping.getAccepted();
		if (!force && (userdefined.contains(corr) || accepted.contains(corr))) {
			return;
		}

		final EList<AbstractCorrespondence> ignored = this.mapping.getIgnored();
		final EList<AbstractCorrespondence> suggested = this.mapping.getSuggested();

		ignored.add(corr);
		userdefined.remove(corr);
		suggested.remove(corr);
		accepted.remove(corr);

		final EObject pmObject = CorrespondenceHelper.getSource(corr);
		final EObject dfdObject = CorrespondenceHelper.getTarget(corr);
		if (dfdObject instanceof Process) {
			rejectProcessMapping(pmObject, (Process) dfdObject);
		} else if ((dfdObject instanceof Asset) || (dfdObject instanceof DataStore)) {
			rejectMapping(corr, pmObject, dfdObject);
		}
		try {
			final Map<String, IType> astTypes = JavaASTUtil
					.getTypesForProject(JavaCore.create(this.destination.getProject()));
			MarkerUtil.deleteMarker(astTypes, CorrespondenceHelper.getSource(corr));
		} catch (final JavaModelException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * @param corr
	 * @param pmObject
	 * @param dfdObject
	 */
	private void rejectMapping(final AbstractCorrespondence corr, final EObject pmObject, final EObject dfdObject) {
		if (pmObject instanceof TMember) {
			final Set<TMember> value = this.cache.getElementMemberMapping().get(dfdObject);
			if (value != null) {
				value.remove(pmObject);
			}
		} else {
			final Set<TAbstractType> value = this.cache.getEntityTypeMapping().get(dfdObject);
			if (value != null) {
				value.remove(pmObject);
			}
			final EList<AbstractMappingDerived> deriving = ((AbstractMappingBase) corr).getDeriving();
			for (int i = 0; i < deriving.size(); i++) {
				final AbstractMappingDerived derivingCorr = deriving.remove(0);
				final EList<AbstractMappingBase> derivedFrom = derivingCorr.getDerived();
				derivedFrom.remove(corr);
				if (derivedFrom.size() == 1) {
					reject(derivingCorr);
				}
			}
		}
	}

	/**
	 * @param pmObject
	 * @param dfdObject
	 */
	private void rejectProcessMapping(final EObject pmObject, final Process dfdObject) {
		if (pmObject instanceof TMember) {
			final Set<TMember> value = this.cache.getElementMemberMapping().get(dfdObject);
			if (value != null) {
				value.remove(pmObject);
			}
		} else if (pmObject instanceof TSignature) {
			final Set<TSignature> value = this.cache.getElementSignatureMapping().get(dfdObject);
			if (value != null) {
				value.remove(pmObject);
			}
			((TMethodSignature) pmObject).getDefinitions().forEach(definiton -> {
				this.helper.getCorrespondences(definiton).forEach(this::reject);
			});
		} else if (pmObject instanceof TMethod) {
			final Set<TMethod> value = this.cache.getElementMethodMapping().get(dfdObject);
			if (value != null) {
				value.remove(pmObject);
			}
			((TMethod) pmObject).getSignatures()
			.forEach(signature -> this.helper.getCorrespondences(signature).forEach(this::reject));
		}
	}

	/**
	 * Set the correspondence between the two objects to userdefined or create a
	 * correspondence
	 *
	 * @param pmObject  An object from a program model
	 * @param dfdObject An object from a DFD
	 */
	public void userdefined(final EObject pmObject, final EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		final Collection<AbstractCorrespondence> correspondences = this.helper.getCorrespondences(pmObject);
		if (!correspondences.isEmpty()) {
			for (final AbstractCorrespondence corr : correspondences) {
				if (CorrespondenceHelper.getTarget(corr).equals(dfdObject)) {
					userCorr = corr;
					break;
				}
			}
			this.mapping.getSuggested().remove(userCorr);
			this.mapping.getAccepted().remove(userCorr);
			if (this.mapping.getIgnored().contains(userCorr)) {
				try {
					final Map<String, IType> astTypes = JavaASTUtil
							.getTypesForProject(JavaCore.create(this.destination.getProject()));
					MarkerUtil.createMarker(astTypes, CorrespondenceHelper.getSource(userCorr),
							((NamedEntity) CorrespondenceHelper.getTarget(userCorr)).getName(), IMarker.PRIORITY_NORMAL,
							IMarker.SEVERITY_INFO);
				} catch (final JavaModelException e) {
					LOGGER.log(Level.ERROR, e);
				}
			}
		}
		if (userCorr == null) {
			userCorr = addNewUserdefinedCorr(pmObject, dfdObject);
		}
		if (userCorr != null) {
			final Deque<AbstractCorrespondence> stack = new LinkedList<>();
			stack.add(userCorr);
			while (!stack.isEmpty()) {
				final AbstractCorrespondence next = stack.pop();
				this.mapping.getCorrespondences().add(next);
				this.mapping.getUserdefined().add(next);
				if (next instanceof AbstractMappingDerived) {
					stack.addAll(((AbstractMappingDerived) next).getDerived());
				}
			}
			for (final IListener listener : this.userefinedListeners) {
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
	private AbstractCorrespondence addNewUserdefinedCorr(final EObject pmObject, final EObject dfdObject) {
		AbstractCorrespondence userCorr = null;
		if (pmObject instanceof TMethodDefinition) {
			final TMethodDefinition method = (TMethodDefinition) pmObject;
			if (dfdObject instanceof Process) {
				final Process process = (Process) dfdObject;
				userCorr = this.helper.createCorrespondence(method, process, 100, Collections.emptyList());
				this.cache.add(method, process);
			} else if (dfdObject instanceof DataStore) {
				final DataStore store = (DataStore) dfdObject;
				userCorr = this.helper.createCorrespondence(method, store, 100, Collections.emptyList());
				this.cache.add(method, store);
			}
		} else if (pmObject instanceof TAbstractType) {
			final TAbstractType type = (TAbstractType) pmObject;
			if (dfdObject instanceof Asset) {
				final Asset asset = (Asset) dfdObject;
				userCorr = this.helper.createCorrespondence(type, asset, 100);
				this.cache.add(type, asset);
			} else if (dfdObject instanceof DataStore) {
				final DataStore store = (DataStore) dfdObject;
				userCorr = this.helper.createCorrespondence(type, store, 100);
				this.cache.add(type, store);
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
		Logging.writeLog(this.mapping.getCorrespondences());
	}

	/**
	 * Recursively updates the ranking
	 *
	 * @param corr A correspondence
	 */
	private void updateRanking(final AbstractCorrespondence corr, final int ranking) {
		if (corr instanceof AbstractMappingRanking) {
			((AbstractMappingRanking) corr).setRanking(ranking);
		} else if (corr instanceof MappingProcessSignature) {
			for (final AbstractCorrespondence parentCorr : this.helper.getCorrespondences(
					((TMethodSignature) ((MappingProcessSignature) corr).getSource()).getMethod())) {
				if (CorrespondenceHelper.getTarget(parentCorr).equals(((MappingProcessSignature) corr).getTarget())) {
					((AbstractMappingRanking) parentCorr).setRanking(ranking);
				}
			}
		} else if (corr instanceof MappingProcessDefinition) {
			for (final AbstractCorrespondence parentCorr : this.helper.getCorrespondences(
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
			final Map<String, Set<String>> map = new HashMap<>();
			this.mapping.getCorrespondences().stream()
			.filter(corr -> (corr instanceof MappingProcessDefinition) || (corr instanceof MappingEntityType))
			.forEach(corr -> {
				final String dfdElementName = ((NamedEntity) CorrespondenceHelper.getTarget(corr)).getName();
				Set<String> pmElementStrings;
				if (map.containsKey(dfdElementName)) {
					pmElementStrings = map.get(dfdElementName);
				} else {
					pmElementStrings = new HashSet<>();
					map.put(dfdElementName, pmElementStrings);
				}
				final EObject pmElement = CorrespondenceHelper.getSource(corr);
				final String pmElementString = MappingLabelProvider.prettyPrint(pmElement);
				pmElementStrings.add(pmElementString);
			});
			SecDFDValidator.setMap(map);
			final URI uri = this.dfd.eResource().getURI();
			IFile file;
			if (uri.isFile()) {
				file = this.destination.getParent().getFile(new Path(uri.toFileString()));
			} else if (uri.isPlatformResource()) {
				file = this.destination.getWorkspace().getRoot().getFile(Path.fromOSString(uri.toPlatformString(true)));
			} else {
				throw new IllegalStateException();
			}
			file.touch(new NullProgressMonitor());
		} catch (final CoreException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * Writes the mapping to the file system
	 */
	public void updateMappingOnFilesystem() {
		updateMarkers();
		try {
			this.mapping.eResource().save(new FileOutputStream(this.destination.getLocation().toFile()), Collections.emptyMap());
		} catch (final IOException e) {
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
	private Stream<Method2Element> mapToMethod(final Element element) {
		final List<Method2Element> list = new ArrayList<>();
		for (final TMethod method : this.methods) {
			final int rank = StringCompare.compare(element.getName(), method.getTName());
			if ((rank > 0) && this.helper.canCreate(method, element, Collections.emptyMap())) {
				final Method2Element corr = this.helper.createCorrespondence(method, element, rank);
				this.mapping.getSuggested().add(corr);
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
	private Stream<Type2NamedEntity> mapToType(final Asset asset) {
		final ArrayList<Type2NamedEntity> list = new ArrayList<>();
		switch (asset.getType()) {
		case NUMBER:
			for (final String name : new String[] { "int", "long", "float", "double" }) {
				final Type2NamedEntity corr = this.helper.createCorrespondence(this.pm.getClass(name), asset, 90);
				this.mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		case VECTOR:
		case OBJECT:
			return mapToType((NamedEntity) asset);
		case STRING:
			final TAbstractType string = this.pm.getType("java.lang.String");
			if ((string != null) && this.helper.canCreate(string, asset, Collections.emptyMap())) {
				final Type2NamedEntity corr = this.helper.createCorrespondence(string, asset, 100);
				this.mapping.getSuggested().add(corr);
				list.add(corr);
			}
			break;
		case BOOLEAN:
			final Type2NamedEntity objectCorr = this.helper.createCorrespondence(this.pm.getType("java.lang.Boolean"), asset, 90);
			this.mapping.getSuggested().add(objectCorr);
			list.add(objectCorr);
			final Type2NamedEntity primitiveCorr = this.helper.createCorrespondence(this.pm.getType("boolean"), asset, 90);
			this.mapping.getSuggested().add(primitiveCorr);
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
	private Stream<Type2NamedEntity> mapToType(final NamedEntity entity) {
		final List<Type2NamedEntity> list = new ArrayList<>();
		for (final TAbstractType type : this.types) {
			final int rank = StringCompare.compare(entity.getName(), type.getTName());
			if ((rank > 0) && this.helper.canCreate(type, entity, Collections.emptyMap())) {
				final Type2NamedEntity corr = this.helper.createCorrespondence(type, entity, rank);
				this.mapping.getSuggested().add(corr);
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
		return this.mapping;
	}

	public Set<? extends EObject> getMapping(final Element element) {
		if (element instanceof DataStore) {
			final DataStore dataStore = (DataStore) element;
			final Stream<TAbstractType> typeStream = this.cache.getEntityTypeMapping()
					.getOrDefault(dataStore, Collections.emptySet()).parallelStream();
			final Stream<TMember> memberStream = this.cache.getElementMemberMapping()
					.getOrDefault(dataStore, Collections.emptySet()).parallelStream();
			return Stream.concat(typeStream, memberStream).collect(Collectors.toSet());

		} else if (element instanceof Process) {
			return getMapping((Process) element);
		} else if (element instanceof ExternalEntity) {
			return Collections.emptySet();
		}
		LOGGER.warn("Didn't consider mapping for: " + element);
		return Collections.emptySet();
	}

	/**
	 * A getter for mappings for the given process
	 *
	 * @param process the process for which mappings are requested
	 * @return the mappings
	 */
	public Set<TMethodDefinition> getMapping(final Process process) {
		return this.cache.getElementMemberMapping().getOrDefault(process, Collections.emptySet()).parallelStream()
				.filter(member -> (member instanceof TMethodDefinition)).map(member -> (TMethodDefinition) member)
				.collect(Collectors.toSet());
	}

	/**
	 * A getter for mappings for the given asset
	 *
	 * @param asset the asset for which mappings are requested
	 * @return the mappings
	 */
	public Collection<TAbstractType> getMapping(final Asset asset) {
		return this.cache.getEntityTypeMapping().getOrDefault(asset, Collections.emptySet());
	}

	public Set<Element> getMapping(final TMethodDefinition method) {
		return this.helper.getCorrespondences(method).parallelStream()
				.map(corr -> (Element) CorrespondenceHelper.getTarget(corr)).collect(Collectors.toSet());
	}

	public Set<Asset> getMapping(final TAbstractType type) {
		return this.helper.getCorrespondences(type).parallelStream()
				.map(corr -> (Asset) CorrespondenceHelper.getTarget(corr)).collect(Collectors.toSet());
	}

	public Set<DataStore> getDataStoreMapping(final TAbstractType type) {
		return this.helper.getCorrespondences(type).parallelStream().map(CorrespondenceHelper::getTarget)
				.filter(e -> e instanceof DataStore).map(e -> (DataStore) e).collect(Collectors.toSet());
	}

	/**
	 * A getter for the proggram model
	 *
	 * @return the pm
	 */
	public TypeGraph getPM() {
		return this.pm;
	}

	/**
	 * A getter for the DFD
	 *
	 * @return the DFD
	 */
	public EDFD getDFD() {
		return this.dfd;
	}

	/**
	 * A getter for the location where the mapping is stored
	 *
	 * @return The location
	 */
	public IFile getCorrespondenceModelFile() {
		return this.destination;
	}

	public IFolder getGravityFolder() {
		return (IFolder) this.destination.getParent();
	}

	public void addRandom() {
		final Map<Element, Set<TSignature>> elementSignatureMapping = this.cache.getElementSignatureMapping();
		final Map<Element, Set<TMember>> elementMemberMapping = this.cache.getElementMemberMapping();
		final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = this.cache.getEntityTypeMapping();

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

		final Set<MappingProcessDefinition> relevantProcessDefinitionMappings = Stream
				.concat(this.mapping.getUserdefined().parallelStream(), this.mapping.getAccepted().parallelStream())
				.filter(corr -> corr instanceof MappingProcessDefinition).map(corr -> (MappingProcessDefinition) corr)
				.filter(corr -> (corr.getTarget() instanceof Process)).collect(Collectors.toSet());

		for (final MappingProcessDefinition mappingProcessDefinition : relevantProcessDefinitionMappings) {
			final Process process = (Process) mappingProcessDefinition.getTarget();
			final TMethodDefinition method = (TMethodDefinition) mappingProcessDefinition.getSource();

			final Set<Process> targetProcesses = process.getOutflows().parallelStream()
					.flatMap(flow -> flow.getTarget().parallelStream()).filter(element -> element instanceof Process)
					.filter(targetProcess -> !elementMemberMapping.containsKey(targetProcess)
							|| !elementMemberMapping.get(targetProcess).contains(method))
					.map(element -> (Process) element).collect(Collectors.toSet());
			if (targetProcesses.isEmpty()) {
				continue;
			}

			final Set<TAbstractType> assets = process.getOutflows().parallelStream()
					.flatMap(flow -> flow.getAssets().parallelStream()).filter(entityTypeMapping::containsKey)
					.flatMap(asset -> entityTypeMapping.get(asset).parallelStream()).collect(Collectors.toSet());

			Stream<TMethodDefinition> calling = Stream.empty();
			final TAbstractType returnType = method.getSignature().getReturnType();
			if ("void".equals(returnType.getTName()) || assets.contains(returnType)) {
				calling = CallHelper.getAllInCalls(method).parallelStream()
						.filter(member -> member instanceof TMethodDefinition)
						.map(member -> (TMethodDefinition) member);
			} else if (assets.contains(returnType)) {
				for (final TMethodDefinition caller : CallHelper.getAllInCalls(method).parallelStream()
						.filter(member -> member instanceof TMethodDefinition)
						.map(member -> (TMethodDefinition) member).collect(Collectors.toSet())) {
					process.getOutflows().parallelStream().flatMap(flow -> flow.getTarget().stream()).forEach(p -> {
						final MappingProcessDefinition newCorr = this.helper.createCorrespondence(caller, p, 30,
								Collections.emptySet());
						this.mapping.getSuggested().add(newCorr);
					});
				}
			}

			final Set<TMethodDefinition> notMappedAccessedDefinitions = Stream
					.concat(calling, CallHelper.getAllOutCalls(method).parallelStream()
							.filter(member -> member instanceof TMethodDefinition).filter(member -> {
								for (final AbstractCorrespondence c : this.helper.getCorrespondences(member)) {
									if ((c instanceof MappingProcessDefinition)
											&& this.mapping.getCorrespondences().contains(c)) {
										return false;
									}
								}
								return true;
							}).map(member -> (TMethodDefinition) member).filter(definiton -> {
								if (assets.contains(definiton.getDefinedBy())) {
									return true;
								}
								for (final TParameter param : definiton.getSignature().getParameters()) {
									if (assets.contains(param.getType())) {
										return true;
									}
								}
								return false;
							}))
					.collect(Collectors.toSet());

			final Set<TMethodDefinition> definitionWithKnownAsset = notMappedAccessedDefinitions.parallelStream()
					.filter(def -> def.getDefinedBy().isDeclared()).collect(Collectors.toSet());
			for (final TMethodDefinition toMap : definitionWithKnownAsset) {
				final Set<Asset> calledMethodAssets = Stream
						.concat(toMap.getSignature().getParameters().parallelStream().map(TParameter::getType),
								Stream.of(toMap.getDefinedBy(), toMap.getReturnType()))
						.flatMap(param -> this.helper.getCorrespondences(param).parallelStream())
						.map(CorrespondenceHelper::getTarget).filter(target -> target instanceof Asset)
						.map(target -> (Asset) target).collect(Collectors.toSet());

				final List<Element> create = process.getOutflows().parallelStream()
						.filter(pr -> pr.getAssets().parallelStream().anyMatch(a -> calledMethodAssets.contains(a)))
						.flatMap(flow -> flow.getTarget().parallelStream().filter(t -> !(t instanceof ExternalEntity)))
						.collect(Collectors.toList());
				for (final Element p : create) {
					if (this.helper.canCreate(toMap, p, Collections.emptyMap())) {
						final MappingProcessDefinition newCorr = this.helper.createCorrespondence(toMap, p, 30,
								Collections.emptySet());
						this.mapping.getSuggested().add(newCorr);
					}
				}
			}
		}
	}

	public Map<TAbstractType, Set<Asset>> getAssets() {
		final Set<Asset> dfdassets = this.dfd.getAsset().stream().collect(Collectors.toSet());
		// create a hashmap of dfd assets and the mapped java types
		final Map<TAbstractType, Set<Asset>> assets = new HashMap<>();
		for (final Asset a : dfdassets) {
			for (final TAbstractType type : getMapping(a)) {
				assets.computeIfAbsent(type, x -> new HashSet<>()).add(a);
			}
		}
		return assets;
	}
}
