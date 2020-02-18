package org.gravity.mapping.secdfd.checks;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gravity.mapping.secdfd.mapping.Mapper;
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
import org.xtext.example.mydsl.validation.SProblem;
import org.xtext.example.mydsl.validation.SProblem.PState;
import org.xtext.example.mydsl.validation.SProblem.PType;

import eDFDFlowTracking.Asset;
import eDFDFlowTracking.EDFDFlowTrackingFactory;
import eDFDFlowTracking.Process;
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
		check(entries, exits, methods, null, Collections.singleton(fwd ));
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
		check(entries, exits, methods, null, Collections.singleton(fwd ));
	}


	/**
	 * OBSOLETE
	 * @param problems 
	 * @param entries
	 * @param exits
	 * @param methods
	 * @param assets
	 */
	public static void check(Set<TFlow> entries, Set<TFlow> exits, Set<? extends TMember> methods,
			Mapper mapper, Set<Responsibility> resposibilities) {
		Map<TAbstractType, Asset> assets = mapper.getAssets();
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
					
					//absence
					Set<Asset> foundAssetCommunications = found.stream().flatMap(f -> getCommunicatedAssets(f, assets).stream()).collect(Collectors.toSet());
					EList<Asset> inComeAssets = responsibility.getIncomeassets();
					if(!foundAssetCommunications.containsAll(inComeAssets)) {
						System.err.println("Not all expected flows have been implemented!");
					}

					//divergence
					Set<TAbstractType> incomeAssetTypes = inComeAssets.stream().flatMap(a -> mapper.getMapping(a).stream()).collect(Collectors.toSet());
					Set<TAbstractType> foundTypes = found.stream().flatMap(f -> getCommunicatedTypes(f).stream()).collect(Collectors.toSet());
					
					
					
					//TODO: for each asset: is there an exit flow containing asset that is on the entry flow
					Collections.disjoint(foundTypes, incomeAssetTypes);
					
					
					//TODO: - problem raised when more than one flow enters (for fwd)
					if(!(valid &= inComeAssets.isEmpty())) {
						System.err.println("More than the defined asset flows have been implemented!");
					}
					if(valid) {
						System.out.println("Outgoing asset has correct flow: "+outComeAsset);
					}
				}
			}
		}
	}

	private static Set<TFlow> searchBackwards(TFlow exit, Set<? extends TMember> methods) {
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
				if (methods.contains(next)) {
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
					if (!methods.contains(source)) {
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
			for(Asset asset : foundAssets) {
				map.computeIfAbsent(asset, s -> new HashSet<>()).add(flow);
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
		Set<TAbstractType> foundTypes = getCommunicatedTypes(flow);
		Set<Asset> foundAssets = new HashSet<>();
		for(TAbstractType type : foundTypes) {
			addToAssetsIfMapped(foundAssets, assets, type);
		}
		return foundAssets;
	}

	/**
	 * @param flow
	 * @return
	 */
	private static Set<TAbstractType> getCommunicatedTypes(TFlow flow) {
		Set<TAbstractType> foundTypes = new HashSet<>();
		for (TAbstractFlowElement source : flow.getIncomingFlows()) {
			if (source instanceof TMethodSignature) {
				foundTypes.add(((TMethodSignature) source).getReturnType());
			} else if (source instanceof TMethodDefinition) {
				TMethodDefinition def = (TMethodDefinition) source;
				if (def.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()) {
					throw new IllegalStateException("Method definition has outgoing flow but is not a constructor!");
				}
				TAbstractType type = def.getDefinedBy();
				foundTypes.add(type);
			} else if (source instanceof TParameter) {
				TAbstractType type = ((TParameter) source).getType();
				foundTypes.add(type);
			} else if (source instanceof TAccess) {
				// Skip
			} else {
				System.out.println("Unknows source of flow with source: " + source.eClass().getName());
				throw new IllegalStateException("Unkown source of flow: " + source.eClass().getName());
			}
		}
		for (TAbstractFlowElement target : flow.getOutgoingFlows()) {
			if (target instanceof TParameter) {
				foundTypes.add(((TParameter) target).getType());
			} else if (target instanceof TAccess) {
				// Skip
			} else {
				System.out.println("Unknows traget of flow with source: " + target.eClass().getName());
				throw new IllegalStateException("Unkown target of flow: " + target.eClass().getName());
			}
		}
		return foundTypes;
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

	public Set<SProblem> check(Set<TFlow> entries, Set<TFlow> exits, Process p, Mapper mapper,
			Responsibility responsibility) {
		Map<TAbstractType, Asset> assets = mapper.getAssets();
		Map<Asset, Set<TFlow>> exitMapping = classifyFlows(exits, assets);
		Set<TMethodDefinition> methods = mapper.getMapping(p);
		Set<SProblem> problems = new HashSet<>();

		for (Asset outComeAsset : responsibility.getOutcomeassets()) {
			Set<TFlow> outgoingAssetFlows = exitMapping.get(outComeAsset);

			if (outgoingAssetFlows == null || outgoingAssetFlows.isEmpty()) {
				// absence
				problems.add(new SProblem(PState.WARNING, PType.FWDJOIN, (EObject) p, methods,
						"Outgoing asset hasn't been implemented."));
				System.err.println("Outgoing asset hasn't been implemented: " + outComeAsset);
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
				for (Asset expectedAsset : responsibility.getIncomeassets()) {
					// Exactly one found flow has to communicate this asset
					int counter = 0;
					for (TFlow ff : found) {
						Set<Asset> comma = getCommunicatedAssets(ff, assets);
						if (comma.contains(expectedAsset)) {
							counter += 1;
							if(counter>1) {
								//TODO: if expectedAsset has been mapped to the same type more than once, check if ok
								valid = false;
							}
						}
					}
					if (counter > 1 && !valid) {
						problems.add(new SProblem(PState.WARNING, PType.FWDJOIN, (EObject) p, methods,
								"More than one flow is communicating the asset upon process entry (divergence)."));
						System.err.println(
								"More than one flow is communicating the asset upon process entry (divergence).");
					} else if (counter < 1) {
						valid = false;
						problems.add(new SProblem(PState.WARNING, PType.FWDJOIN, (EObject) p, methods,
								"No flow is communicating the asset upon process entry (absence)."));
						System.err
								.println("No flow is communicating the asset upon process entry (absence).");
					} else {
						valid = true;
						problems.add(new SProblem(PState.OK, PType.SUCCESS, (EObject) p, methods, "Outgoing asset has correct flow."));
						System.out.println("Outgoing asset has correct flow: " + outComeAsset);
					}
				}
			}
		}
		return problems;
	}

}
