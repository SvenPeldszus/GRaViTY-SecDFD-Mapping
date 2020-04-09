package org.gravity.mapping.secdfd;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TypeGraph;
import org.junit.Test;
import org.secdfd.model.Asset;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

public class JoinTest {

	/**
	 * 
	 */
	@Test
	public void joinFailIsFwd() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		TypeGraph pm = (TypeGraph) rs.getResource(URI.createFileURI("instances/ForwardExample.xmi"), true).getContents()
				.get(0);
	
		Map<TAbstractType, Asset> assets = new HashMap<>();
		Asset assetAsset = ModelFactory.eINSTANCE.createAsset();
		assetAsset.setName("Asset");
		TAbstractType assetType = pm.getType("(default package).Asset");
		assets.put(assetType, assetAsset);
	
		Asset assetMain = ModelFactory.eINSTANCE.createAsset();
		assetMain.setName("Main");
		TAbstractType assetMainType = pm.getType("(default package).Main");
		assets.put(assetMainType, assetMain);
	
		Set<TMember> methods = new HashSet<>();
		TMethodDefinition method1 = pm.getMethodDefinition("(default package).Main.method1(Asset):void");
		methods.add(method1);
		TMethodDefinition method2 = pm.getMethodDefinition("(default package).Main.method2(Asset):Asset");
		methods.add(method2);
	
		TFlow entry = (TFlow) method1.getSignature().getFirstParameter().getIncomingFlows().get(0);
		Set<TFlow> entries = Collections.singleton(entry);
	
		TFlow exit = (TFlow) pm.getMethodSignature("exit(Asset):void").getFirstParameter().getIncomingFlows().get(0);
		Set<TFlow> exits = Collections.singleton(exit);
	
		Responsibility fwd = ModelFactory.eINSTANCE.createResponsibility();
		fwd.getAction().add(ResponsibilityType.JOINER);
		fwd.setProcess(ModelFactory.eINSTANCE.createProcess());
		fwd.getIncomeassets().add(assetAsset);
		fwd.getIncomeassets().add(assetMain);
		fwd.getOutcomeassets().add(assetAsset);
		//check(entries, exits, methods, null, Collections.singleton(fwd));
	}

}
