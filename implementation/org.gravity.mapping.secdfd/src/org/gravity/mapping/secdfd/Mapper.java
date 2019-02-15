/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.mapping.StringCompare;
import org.gravity.mapping.XtextParser;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TypeGraph;
import org.junit.Test;
import org.moflon.tgg.runtime.CorrespondenceModel;
import org.moflon.tgg.runtime.RuntimeFactory;
import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTracking1Package;
import eDFDFlowTracking.Element;

/**
 * @author speldszus
 *
 */
public class Mapper {

	private static final SecdfdFactory FACTORY = SecdfdFactory.eINSTANCE;

	/**
	 * The correspondence model built by this class
	 */
	private CorrespondenceModel corr;

	/**
	 * All types and operations from the program model
	 */
	private static List<TAbstractType> types;
	private static List<TMethod> methods;

	/**
	 * The main method for testing
	 * 
	 * @throws IOException If a model cannot be read
	 */
	@Test
	public void test() throws IOException {
		// Init a resource set and load the models
		XtextParser parser = new XtextParser();
		EDFD dfd = (EDFD) parser.parse(URI.createFileURI("instances/JPmail.mydsl"));

		ResourceSet rs = initResourceSet(parser.getResourceSet());
		TypeGraph pm = (TypeGraph) loadModel(rs, "instances/pm.xmi");
		
		CorrespondenceModel corr = new Mapper().map(pm, dfd);

		for (EObject c : corr.getCorrespondences()) {
			System.out.print(c.eClass().getName() + ": ");
			try {
				System.out.println(c.getClass().getDeclaredMethod("getSource").invoke(c) + " <---> "
						+ c.getClass().getDeclaredMethod("getTarget").invoke(c));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}

	}

	private CorrespondenceModel map(TypeGraph pm, EDFD dfd) {
		// Save types and methods from the program model in fields as they are accessed
		// very often
		types = pm.getOwnedTypes().parallelStream().filter(t -> t.isDeclared()).collect(Collectors.toList());
		methods = pm.getMethods();

		// Create a correspondence model between the two models
		corr = RuntimeFactory.eINSTANCE.createCorrespondenceModel();
		createCorrespondence(pm, dfd);

		HashMap<EObject, Set<EObject>> mapping = new HashMap<>();

		// Search for correspondences between graph assets and types in the pm
		for (Asset asset : dfd.getAsset()) {
				mapping.put(asset, find(asset).map(c -> c.getSource()).collect(Collectors.toSet()));
			}

		// Search for correspondences between nodes and operations
		for (Element node : dfd.getElements()) {
				if (node.getName() != null) {
					mapping.put(node, find(node).map(c -> c.getSource()).collect(Collectors.toSet()));
				}
		}

		return corr;
	}

	/**
	 * Search methods in the pm corresponding to the node and create correspondences
	 * for them
	 * 
	 * @param asset The node for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Method2Element> find(Element node) {
		return methods.parallelStream().filter(m -> StringCompare.compare(node.getName(), m.getTName()))
				.map(m -> createCorrespondence(node, m));
	}

	/**
	 * Search classes in the pm corresponding to the asset and create
	 * correspondences for them
	 * 
	 * @param asset The asset for which correspondences should be found
	 * @return A stream of correspondences
	 */
	private Stream<Type2Asset> find(Asset asset) {
		return types.parallelStream().filter(t -> StringCompare.compare(asset.getName(), t.getTName()))
				.map(t -> createCorrespondence(asset, t));

	}

	/**
	 * Loads an emf model into the given resource set
	 * 
	 * @param rs   The resource set
	 * @param file The file containing the model
	 * @return The root object of the model
	 * @throws IOException @see void
	 *                     org.eclipse.emf.ecore.resource.Resource.load(Map<?, ?>
	 *                     options) throws IOException
	 */
	private static EObject loadModel(ResourceSet rs, String file) throws IOException {
		Resource resource = rs.createResource(URI.createURI(file));
		resource.load(Collections.emptyMap());
		return resource.getContents().get(0);
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param node   A node object
	 * @param method A method object
	 * @return The correspondence
	 */
	private Method2Element createCorrespondence(Element node, TMethod method) {
		Method2Element method2node = FACTORY.createMethod2Element();
		method2node.setSource(method);
		method2node.setTarget(node);
		corr.getCorrespondences().add(method2node);
		return method2node;
	}

	/**
	 * Creates a new correspondence between the two objects and adds it to the
	 * correspondence model
	 * 
	 * @param asset An asset object
	 * @param type  A type object
	 * @return The correspondence
	 */
	private Type2Asset createCorrespondence(Asset asset, TAbstractType type) {
		Type2Asset type2asset = FACTORY.createType2Asset();
		type2asset.setSource(type);
		type2asset.setTarget(asset);
		corr.getCorrespondences().add(type2asset);
		return type2asset;
	}

	/**
	 * Creates a new correspondence between a program model and a data flow diagram
	 * and adds it to the correspondence model
	 * 
	 * @param pm  The program model
	 * @param dfd The data flow diagram
	 */
	private TypeGraph2EDFD createCorrespondence(TypeGraph pm, EDFD dfd) {
		TypeGraph2EDFD pm2dfd = FACTORY.createTypeGraph2EDFD();
		pm2dfd.setSource(pm);
		pm2dfd.setTarget(dfd);
		corr.getCorrespondences().add(pm2dfd);
		return pm2dfd;
	}

	/**
	 * Initializes a new resource set
	 * 
	 * @return the resource set
	 */
	private static ResourceSet initResourceSet(ResourceSet rs) {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getPackageRegistry().put(EDFDFlowTracking1Package.eNS_URI, EDFDFlowTracking1Package.eINSTANCE);
		return rs;
	}

}
