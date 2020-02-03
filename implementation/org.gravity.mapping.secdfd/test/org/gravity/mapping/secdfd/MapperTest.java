/**
 * 
 */
package org.gravity.mapping.secdfd;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;
import org.junit.Test;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.model.mapping.Mapping;

import eDFDFlowTracking.EDFD;
import eDFDFlowTracking.EDFDFlowTrackingPackage;

/**
 * @author speldszus
 *
 */
public class MapperTest {
	/**
	 * The main method for testing
	 * 
	 * @throws IOException If a model cannot be read
	 */
	@Test
	public void test() throws IOException {
		// Init a resource set and load the models
		XtextParser parser = new XtextParser();
		HashMap<File, EDFD> dfds = new HashMap<>();
		for (File f : new File("instances").listFiles()) {
			if (f.toString().endsWith(".mydsl")) {
				dfds.put(f, (EDFD) parser.parse(URI.createFileURI(f.toString())));
			}
		}

		ResourceSet rs = initResourceSet(parser.getResourceSet());
		TypeGraph pm = (TypeGraph) loadModel(rs, "instances/pm.xmi");

		for (Entry<File, EDFD> entry : dfds.entrySet()) {
			EDFD dfd = entry.getValue();
			Mapping corr = new Mapper(pm, dfd, null).getMapping();
			System.out.println("#####\nMapping pm to: " + entry.getKey());
			System.out.println();
			for (EObject c : corr.getCorrespondences()) {
				System.out.print(c.eClass().getName() + ": ");
				try {
					System.out.println(toString(CorrespondenceHelper.getSource((AbstractCorrespondence) c)) + " <---> "
							+ CorrespondenceHelper.getTarget((AbstractCorrespondence) c));
				} catch (IllegalArgumentException | SecurityException e) {
					e.printStackTrace();
				}
			}
			System.out.println("#####\n");
		}

	}


	private String toString(EObject eObject) {
		EClass eClass = eObject.eClass();
		if(BasicPackage.eINSTANCE.getTSignature().isSuperTypeOf(eClass)) {
			return ((TSignature) eObject).getSignatureString();
		}
		if(BasicPackage.eINSTANCE.getTAbstractType().isSuperTypeOf(eClass)) {
			return ((TAbstractType) eObject).getFullyQualifiedName();
		}
		if(BasicPackage.eINSTANCE.getTMethod().isSuperTypeOf(eClass)) {
			return ((TMethod) eObject).getTName();
		}
		if(BasicPackage.eINSTANCE.getTMember().isSuperTypeOf(eClass)) {
			return ((TMember) eObject).getDefinedBy().getFullyQualifiedName()+"."+((TMember) eObject).getSignatureString();
		}
		return eObject.toString();
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
	 * Initializes a new resource set
	 * 
	 * @return the resource set
	 */
	private static ResourceSet initResourceSet(ResourceSet rs) {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getPackageRegistry().put(EDFDFlowTrackingPackage.eNS_URI, EDFDFlowTrackingPackage.eINSTANCE);
		return rs;
	}
}
