package org.secdfd.dsl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import com.google.inject.Injector;


public class XtextParser {
	 
	private XtextResourceSet resourceSet;
 
    public XtextParser() {
        setupParser();
    }
    
    private void setupParser() {
    	Injector injector = new SecDFDStandaloneSetup().createInjectorAndDoEMFRegistration();
    	resourceSet = injector.getInstance(XtextResourceSet.class);
    	getResourceSet().addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
    }
 
    /**
     * Parses an input stream and returns the resulting object tree root element.
     * @param in Input Stream
     * @return Root model object
     * @throws IOException When and I/O related parser error occurs
     */
    public EObject parse(InputStream in) throws IOException
    {
    	Resource resource = getResourceSet().createResource(URI.createURI("dummy:/xtext.secdfd"));
    	resource.load(in, Collections.emptyMap());
        return resource.getContents().get(0);
    }
    
    public EObject parse(URI uri) throws IOException
    {
    	Resource resource = getResourceSet().getResource(uri, true);
        return resource.getContents().get(0);
    }

	/**
	 * @return the resourceSet
	 */
	public XtextResourceSet getResourceSet() {
		return resourceSet;
	}
	
//	public static void main(String[] args) throws IOException {
//		XtextParser ya = new XtextParser();
//		
//		ya.setupParser();
//		URI fileURI = URI.createURI("/Users/Margit/git/Thesis/ArchitecturalThreatAnalysis/workspace/Viatra_Query/eDFD.secdfd", false);
//		//URI fileURI = URI.createPlatformPluginURI("/Viatra_Query/eDFD.secdfd", false);
//		ya.parse(fileURI);
//	}
}
