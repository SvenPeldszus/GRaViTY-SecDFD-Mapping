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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TypeGraph;
import org.moflon.tgg.runtime.CorrespondenceModel;
import org.moflon.tgg.runtime.RuntimeFactory;
import graph.Graph;
import graph.GraphAsset;
import graph.GraphPackage;
import graph.Node;
import graph.Subgraphs;

/**
 * @author speldszus
 *
 */
public class Mapper {

	private static final SecdfdFactory FACTORY = SecdfdFactory.eINSTANCE;
	private CorrespondenceModel corr;

	private static List<TAbstractType> types;
	private static List<TMethod> methods;

	/**
	 * The main method for testing
	 * 
	 * @param args
	 * @throws IOException If a model cannot be read
	 */
	public static void main(String[] args) throws IOException {
		ResourceSet rs = initResourceSet();

		TypeGraph pm = (TypeGraph) loadModel(rs, "instances/pm.xmi");
		Graph dfd = (Graph) loadModel(rs, "instances/dfd.xmi");

		types = pm.getOwnedTypes();
		methods = pm.getMethods();

		CorrespondenceModel corr = new Mapper().map(pm, dfd);

		for (EObject c : corr.getCorrespondences()) {
			System.out.print(c.eClass().getName()+": ");
			try {
				System.out.println(c.getClass().getDeclaredMethod("getSource").invoke(c) + " <---> "
						+ c.getClass().getDeclaredMethod("getTarget").invoke(c));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}

	}

	private CorrespondenceModel map(TypeGraph pm, Graph dfd) {
		corr = RuntimeFactory.eINSTANCE.createCorrespondenceModel();

		createCorrespondence(pm, dfd);

		HashMap<EObject, Set<EObject>> mapping = new HashMap<>();
		for (Subgraphs subGraph : dfd.getSubgraphs()) {
			for (GraphAsset asset : subGraph.getAssets()) {
				mapping.put(asset, find(asset).map(c -> c.getSource()).collect(Collectors.toSet()));
			}
		}

		for (Subgraphs subGraph : dfd.getSubgraphs()) {
			for (Node node : subGraph.getNodes()) {
				if (node.getName() != null) {
					mapping.put(node, find(node).map(c -> c.getSource()).collect(Collectors.toSet()));
				}
			}
		}

		return corr;
	}

	private Stream<Method2Node> find(Node node) {
		return methods.parallelStream().filter(m -> node.getName().equalsIgnoreCase(m.getTName()))
				.map(m -> createCorrespondence(node, m));
	}

	private Stream<Type2GraphAsset> find(GraphAsset asset) {
		return types.parallelStream().filter(t -> asset.getID().equalsIgnoreCase(t.getTName()))
				.map(t -> createCorrespondence(asset, t));

	}

	private static EObject loadModel(ResourceSet rs, String file) throws IOException {
		Resource resource = rs.createResource(URI.createURI(file));
		resource.load(Collections.emptyMap());
		return resource.getContents().get(0);
	}

	private Method2Node createCorrespondence(Node node, TMethod method) {
		Method2Node method2node = FACTORY.createMethod2Node();
		method2node.setSource(method);
		method2node.setTarget(node);
		corr.getCorrespondences().add(method2node);
		return method2node;
	}

	private Type2GraphAsset createCorrespondence(GraphAsset asset, TAbstractType type) {
		Type2GraphAsset type2asset = FACTORY.createType2GraphAsset();
		type2asset.setSource(type);
		type2asset.setTarget(asset);
		corr.getCorrespondences().add(type2asset);
		return type2asset;
	}

	/**
	 * Creates a new correspondence between a program model and a data flow diagram
	 * 
	 * @param pm The program model
	 * @param dfd The data flow diagram
	 */
	private TypeGraph2Graph createCorrespondence(TypeGraph pm, Graph dfd) {
		TypeGraph2Graph pm2dfd = FACTORY.createTypeGraph2Graph();
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
	private static ResourceSet initResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getPackageRegistry().put(GraphPackage.eNS_URI, GraphPackage.eINSTANCE);
		return rs;
	}

}
