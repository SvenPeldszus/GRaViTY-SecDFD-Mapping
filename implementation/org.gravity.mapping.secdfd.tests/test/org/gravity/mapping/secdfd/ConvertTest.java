package org.gravity.mapping.secdfd;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.secdfd.model.ModelPackage;

@FixMethodOrder
public class ConvertTest {

	private static final URI TEMP = URI.createURI("out/EDFD.xmi");

	@Test
	public void testEDFDtoXMI() throws IOException {
		// Load DFD
		final Resource xtextResource = new XtextParser().getResourceSet()
				.getResource(URI.createURI("instances/ForwardExample/EDFD.secdfd"), true);

		// Create and init new resource
		final ResourceSetImpl set = initResourceSet();

		// Add DFD to new resource and save
		final Resource resource = set.createResource(TEMP);
		resource.getContents().addAll(xtextResource.getContents());
		resource.save(Collections.emptyMap());
	}

	@Test
	public void testXMItoEDFD() throws IOException {
		final ResourceSetImpl set = initResourceSet();

		final Resource resource = set.getResource(TEMP, true);
		final EList<EObject> contents = resource.getContents();

		final Resource xtextResource = new XtextParser().getResourceSet()
				.createResource(URI.createURI("out/EDFD.secdfd"));
		xtextResource.getContents().addAll(contents);
		final Map<String, String> map = new HashMap<>();
		map.put(XtextResource.OPTION_ENCODING, java.nio.charset.Charset.defaultCharset().name());
		xtextResource.save(map);
	}

	/**
	 * @return
	 */
	private ResourceSetImpl initResourceSet() {
		final ResourceSetImpl set = new ResourceSetImpl();
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		set.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		return set;
	}
}
