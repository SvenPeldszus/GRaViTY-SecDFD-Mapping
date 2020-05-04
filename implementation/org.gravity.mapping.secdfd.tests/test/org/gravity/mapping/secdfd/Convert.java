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
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Test;
import org.secdfd.model.EDFD;

public class Convert {

	@Test
	public void test() throws IOException {
		Resource resource = new ResourceSetImpl().getResource(URI.createURI("instances/ForwardExample/EDFD.xmi"), true);
		EList<EObject> contents = resource.getContents();
		EDFD dfd = (EDFD) contents.get(0);
		Resource xtextResource = new XtextParser().getResourceSet().createResource(URI.createURI("instances/ForwardExample/EDFD.secdfd"));
		xtextResource.getContents().addAll(contents);
		Map<String, String> map = new HashMap<>();
		map.put(XtextResource.OPTION_ENCODING, java.nio.charset.Charset.defaultCharset().name());
		xtextResource.save(map );
	}
}
