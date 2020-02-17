package org.gravity.mapping.secdfd.checks;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractFlowElement;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TAccess;
import org.gravity.typegraph.basic.TFlow;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TSignature;
import org.gravity.typegraph.basic.TypeGraph;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFDFlowTrackingFactory;
import eDFDFlowTracking.Responsibility;
import eDFDFlowTracking.ResponsibilityType;

public class DataProcessingCheck {

	public static void main(String[] args) {
		System.out.println("Test success:");
		fwdCorrect();
		
		System.out.println("\nTest fail:");
		joinFailIsFwd();
	}
	
	/**
	 * 
	 */
	private static void joinFailIsFwd() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		TypeGraph pm = (TypeGraph) rs.getResource(URI.createFileURI("instances/ForwardExample.xmi"), true).getContents()
				.get(0);


		Map<TAbstractType, Asset> assets = new HashMap<>();
		Asset assetAsset = EDFDFlowTrackingFactory.eINSTANCE.createAsset();
		assetAsset.setName("Asset");
		TAbstractType assetType = pm.getType("(default package).Asset");
		assets.put(assetType, assetAsset);
		
		Asset assetMain = EDFDFlowTrackingFactory.eINSTANCE.createAsset();
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

		Responsibility fwd = EDFDFlowTrackingFactory.eINSTANCE.createResponsibility();
		fwd.getAction().add(ResponsibilityType.JOINER);
		fwd.setProcess(EDFDFlowTrackingFactory.eINSTANCE.createProcess());
		fwd.getIncomeassets().add(assetAsset);
		fwd.getIncomeassets().add(assetMain);
		fwd.getOutcomeassets().add(assetAsset);
		check(entries, exits, methods, assets, Collections.singleton(fwd ));
	}

	/**
	 * 
	 */
	private static void fwdCorrect() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(BasicPackage.eNS_URI, BasicPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		TypeGraph pm = (TypeGraph) rs.getResource(URI.createFileURI("instances/ForwardExample.xmi"), true).getContents()
				.get(0);

		Asset asset = EDFDFlowTrackingFactory.eINSTANCE.createAsset();
		TAbstractType assetType = pm.getType("(default package).Asset");

		Map<TAbstractType, Asset> assets = new HashMap<>();
		assets.put(assetType, asset);

		Set<TMember> methods = new HashSet<>();
		TMethodDefinition method1 = pm.getMethodDefinition("(default package).Main.method1(Asset):void");
		methods.add(method1);
		TMethodDefinition method2 = pm.getMethodDefinition("(default package).Main.method2(Asset):Asset");
		methods.add(method2);

		TFlow entry = (TFlow) method1.getSignature().getFirstParameter().getIncomingFlows().get(0);
		Set<TFlow> entries = Collections.singleton(entry);

		TFlow exit = (TFlow) pm.getMethodSignature("exit(Asset):void").getFirstParameter().getIncomingFlows().get(0);
		Set<TFlow> exits = Collections.singleton(exit);

		Responsibility fwd = EDFDFlowTrackingFactory.eINSTANCE.createResponsibility();
		fwd.getAction().add(ResponsibilityType.FORWARD);
		fwd.setProcess(EDFDFlowTrackingFactory.eINSTANCE.createProcess());
		fwd.getIncomeassets().add(asset);
		fwd.getOutcomeassets().add(asset);
		check(entries, exits, methods, assets, Collections.singleton(fwd ));
	}

	/**
	 * @param entries
	 * @param exits
	 * @param methods
	 * @param assets
	 */
	private static void check(Set<TFlow> entries, Set<TFlow> exits, Set<TMember> methods,
			Map<TAbstractType, Asset> assets, Set<Responsibility> resposibilities) {
		Map<Asset, Set<TFlow>> entryMapping = classifyFlows(entries, assets);
		Map<Asset, Set<TFlow>> exitMapping = classifyFlows(exits, assets);

		for (Responsibility responsibility : resposibilities) {
			for (Asset outComeAsset : responsibility.getOutcomeassets()) {
				Set<TFlow> outgoingAssetFlows = exitMapping.get(outComeAsset);
				if(outgoingAssetFlows == null || outgoingAssetFlows.isEmpty()) {
					System.err.println("Outgoing asset hasn't been implemented: "+outComeAsset);
					continue;
				}
				for (TFlow flow : outgoingAssetFlows) {
					Set<TFlow> found = searchBackwards(flow, methods);

					System.out.println(found.stream()
							.map(f -> f.toString() + " - asset: "
									+ getCommunicatedAssets(f, assets).stream().map(Object::toString)
											.collect(Collectors.joining(", ")))
							.collect(Collectors.joining(",\n", "Found the following entry flows:\n", "\n")));

					boolean valid = true;
					for(Asset inComeAsset : responsibility.getIncomeassets()) {
						Set<TFlow> expected = entryMapping.computeIfAbsent(inComeAsset, asset -> new HashSet<>());
						valid &= found.containsAll(expected);
					}
					
					if(!valid) {
						System.err.println("Not all expected flows have been implemented!");
					}

					Set<Asset> expectedAssets = new HashSet<>(responsibility.getIncomeassets());
					for(TFlow foundFlow : found) {
						expectedAssets.removeAll(getCommunicatedAssets(foundFlow, assets));
					}
					if(!(valid &= expectedAssets.isEmpty())) {
						System.err.println("More than the defined asset flows have been implemented!");
					}
					if(valid) {
						System.out.println("Outgoing asset has correct flow: "+outComeAsset);
					}
				}
			}
		}
	}

	private static Set<TFlow> searchBackwards(TFlow exit, Set<TMember> consider) {
		Set<TFlow> found = new HashSet<>();
		Deque<TAbstractFlowElement> stack = new LinkedList<>();
		stack.add(exit);
		Set<TAbstractFlowElement> seen = new HashSet<>();
		while (!stack.isEmpty()) {
			TAbstractFlowElement next = stack.pop();
			if (seen.contains(next)) {
				continue;
			}
			seen.add(next);

			if (next instanceof TMethodDefinition) {
				if (consider.contains(next)) {
					stack.addAll(next.getIncomingFlows());
				}
			} else if (next instanceof TMethodSignature) {
				stack.addAll(next.getIncomingFlows());
				stack.addAll(((TMethodSignature) next).getDefinitions());
			} else if (next instanceof TParameter || next instanceof TAccess) {
				stack.addAll(next.getIncomingFlows());
			} else if (next instanceof TFlow) {
				boolean leftProcess = false;
				for (TMember source : getSourceMember((TFlow) next)) {
					if (!consider.contains(source)) {
						found.add((TFlow) next);
						leftProcess = true;
						break;
					}
				}
				if (!leftProcess) {
					stack.addAll(next.getIncomingFlows());
				}
			} else {
				throw new IllegalStateException("Flow to not supported element: " + next.eClass().getName());
			}
		}
		return found;
	}

	private static Set<TMember> getSourceMember(TFlow next) {
		Set<TMember> members = new HashSet<>();
		for (TAbstractFlowElement source : next.getIncomingFlows()) {
			if (source instanceof TMember) {
				members.add((TMember) source);
			} else if (source instanceof TParameter) {
				members.addAll(((TMethodSignature) ((TParameter) source).eContainer()).getDefinitions());
			} else if (source instanceof TFlow) {
				members.addAll(getSourceMember((TFlow) source));
			} else if (source instanceof TAccess) {
				members.addAll(((TAccess) source).getIncomingFlows().stream()
						.flatMap(in -> getSourceMember((TFlow) in).stream()).collect(Collectors.toSet()));
			} else if (source instanceof TSignature) {
				members.addAll(((TSignature) source).getDefinitions());
			}
		}
		return members;
	}

	private static Set<TFlow> searchBackwards(TFlow exit, Set<TFlow> entries, Set<TMember> consider) {
		Set<TFlow> found = new HashSet<>();
		Deque<TAbstractFlowElement> stack = new LinkedList<>();
		stack.add(exit);
		Set<TAbstractFlowElement> seen = new HashSet<>();
		while (!stack.isEmpty()) {
			TAbstractFlowElement next = stack.pop();
			if (seen.contains(next)) {
				continue;
			}
			seen.add(next);
			if (next instanceof TMethodDefinition) {
				if (consider.contains(next)) {
					stack.addAll(next.getIncomingFlows());
				}
			} else if (next instanceof TMethodSignature) {
				stack.addAll(next.getIncomingFlows());
				stack.addAll(((TMethodSignature) next).getDefinitions());
			} else if (next instanceof TParameter || next instanceof TAccess) {
				stack.addAll(next.getIncomingFlows());
			} else if (next instanceof TFlow) {
				if (entries.contains(next)) {
					found.add((TFlow) next);
				} else {
					stack.addAll(next.getIncomingFlows());
				}
			} else {
				throw new IllegalStateException("Flow to not supported element: " + next.eClass().getName());
			}
		}
		return found;
	}

	static Map<Asset, Set<TFlow>> classifyFlows(Set<TFlow> flows, Map<TAbstractType, Asset> assets) {
		Map<Asset, Set<TFlow>> map = new HashMap<>();

		for (TFlow flow : flows) {
			Set<Asset> foundAssets = getCommunicatedAssets(flow, assets);
			switch (foundAssets.size()) {
			case 1:
				map.computeIfAbsent(foundAssets.iterator().next(), s -> new HashSet<>()).add(flow);
				break;
			case 0:
				// Not every flow is necessarily communicating an asset
				break;
			default:
				throw new IllegalStateException("One flow has been mapped to multiple assets!");
			}
		}

		return map;
	}

	/**
	 * @param flow
	 * @param assets
	 * @return
	 */
	private static Set<Asset> getCommunicatedAssets(TFlow flow, Map<TAbstractType, Asset> assets) {
		Set<Asset> foundAssets = new HashSet<>();
		for (TAbstractFlowElement source : flow.getIncomingFlows()) {
			if (source instanceof TMethodSignature) {
				TAbstractType type = ((TMethodSignature) source).getReturnType();
				addToAssetsIfMapped(foundAssets, assets, type);
			} else if (source instanceof TMethodDefinition) {
				TMethodDefinition def = (TMethodDefinition) source;
				if (def.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()) {
					throw new IllegalStateException("Method definition has outgoing flow but is not a constructor!");
				}
				TAbstractType type = def.getDefinedBy();
				addToAssetsIfMapped(foundAssets, assets, type);
			} else if (source instanceof TParameter) {
				TAbstractType type = ((TParameter) source).getType();
				addToAssetsIfMapped(foundAssets, assets, type);
			} else if (source instanceof TAccess) {
				// Skip
			} else {
				throw new IllegalStateException("Unkown source of flow: " + source.eClass().getName());
			}
		}
		for (TAbstractFlowElement target : flow.getOutgoingFlows()) {
			if (target instanceof TParameter) {
				TAbstractType type = ((TParameter) target).getType();
				addToAssetsIfMapped(foundAssets, assets, type);
			} else if (target instanceof TAccess) {
				// Skip
			} else {
				throw new IllegalStateException("Unkown source of flow: " + target.eClass().getName());
			}
		}
		return foundAssets;
	}

	/**
	 * @param assets  The set of assets the types corresponding asset should be
	 *                added to
	 * @param mapping A mapping of all assets
	 * @param type    The type whose corresponding asset should be added to the set
	 * @return true, if the asset was mapped
	 */
	private static boolean addToAssetsIfMapped(Set<Asset> assets, Map<TAbstractType, Asset> mapping,
			TAbstractType type) {
		if (mapping.containsKey(type)) {
			assets.add(mapping.get(type));
			return true;
		}
		return false;
	}

}
