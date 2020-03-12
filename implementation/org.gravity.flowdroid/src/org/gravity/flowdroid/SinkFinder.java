/**
 * 
 */
package org.gravity.flowdroid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ExternalEntity;

/**
 * @author katjat
 *
 */
public final class SinkFinder {

	/**
	 * Map of allowed sinks inferred from the design
	 */
	private Set<TMember> allowed;
	private Set<TMember> forbidden;

	/**
	 * A class for preparing a list of sinks by: 1) loading SuiSi lists 2) asset
	 * final targets (in case of DataStore, ExternalEntity) 3) (if present)
	 * specified attacker zone elements 4? source code flows - secdfd flows. Not
	 * sure if this makes sense
	 *
	 * 2) incoming data flows to DS and EE per asset. only add to sinks if on
	 * incoming flows the asset is not expected but we have it as return value in
	 * method signature. 3) + if modeler specified trust zones, attacker attribute
	 * 
	 * If sink expected, add to allowedSinks
	 * 
	 * @param mapper
	 * @param dfd
	 * @return
	 */
	
	public SinkFinder(Mapper mapper, Asset asset, boolean disableReturnTypeCheck) {
		allowed = new HashSet<>();
		forbidden = new HashSet<>();
		EDFD dfd = mapper.getDFD();

		Set<Element> attackerzones = dfd.getTrustzones().parallelStream().filter(
				zone -> zone.getAttackerprofile().parallelStream().anyMatch(profile -> profile.getObservation() > 0))
				.flatMap(zone -> zone.getElements().parallelStream()).collect(Collectors.toSet());

		// elements with incoming data flow
		Set<Element> elements = dfd.getElements().parallelStream().filter(el -> !el.getInflows().isEmpty())
				.collect(Collectors.toSet());
		for (Element el : elements) {
			List<TMember> elementMappings = mapper.getMapping(el).parallelStream().filter(TMember.class::isInstance)
					.map(TMember.class::cast).collect(Collectors.toList());
			if (attackerzones.contains(el) || el.isAttacker()) {
				forbidden.addAll(elementMappings);
			} else {
				if (el instanceof ExternalEntity || el instanceof DataStore) {
					// find mappings of previous element (processes of the incoming flows)
					final Set<TMember> borderProcesses = el.getInflows().parallelStream()
							.flatMap(flow -> mapper.getMapping(flow.getSource()).parallelStream())
							.filter(TMember.class::isInstance).map(TMember.class::cast).collect(Collectors.toSet());

					// if any incoming flow contains current asset, then sink allowed.
					if (el.getInflows().parallelStream().flatMap(inflow -> inflow.getAssets().parallelStream())
							.collect(Collectors.toSet()).contains(asset)) {
						if (allowed == null)
							allowed = new HashSet<>();
						allowed.addAll(borderProcesses);
						
						// if DataStore, add all the method signatures that are defined over the mapped Type (.e.g, hashmap.put(..) ) as allowed sinks
						if (el instanceof DataStore) {
							Set<? extends EObject> pmElements = mapper.getMapping(el);
							Set<TMember> members = pmElements.parallelStream().flatMap(element -> {
								if (element instanceof TMember) {
									return Stream.of((TMember) element);
								} else if (element instanceof TAbstractType) {
									TAbstractType tType = (TAbstractType) element;
									return tType.getDefines().parallelStream().filter(defined -> defined instanceof TMember);
								} else {
									return Stream.empty();
								}
							}).collect(Collectors.toSet());
							allowed.addAll(members);
						}
					} else {
						forbidden.addAll(borderProcesses);
					}
					/*
					 * else {
						if (disableReturnTypeCheck) {
							forbidden.addAll(borderProcesses);
						} else {
							// get mapped types of asset
							Set<EObject> assetMappedTypes = mapper.getMapping(asset).parallelStream()
									.collect(Collectors.toSet());
							// if method definition contains mapped asset type on return value then its a
							// sink
							for (TMember source : borderProcesses) {
								if (source instanceof TMethodDefinition) {
									if (assetMappedTypes.contains(((TMethodDefinition) source).getReturnType())) {
										// add to list of not allowed sinks
										forbidden.add(source);
									}
								}
							}

						}
					}
					*/

				}
			}
		}
	}

	/**
	 * 1) susi list for sinks
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	static Set<String> loadSinksFromFile(IFile file) throws IOException {
		IOException exception = null;
		File suSiSinksFile = file.getLocation().toFile();
		Set<String> susisinks = new HashSet<>();
		if (suSiSinksFile.exists()) {
			try {
				for (String s : Files.readAllLines(suSiSinksFile.toPath())) {
					// parse file
					if ((s.indexOf('<') > -1) && (s.indexOf('>') > -1) && !s.contains("android")) {
						s = s.substring(s.indexOf('<'), s.indexOf('>') + 1);
						susisinks.add(s);
					}
				}
			} catch (IOException e) {
				exception = e;
			}
		}
		if (exception != null) {
			throw exception;
		}

		return susisinks;
	}

	public Set<TMember> getAllowedsinks() {
		return allowed;
	}
	
	public Set<TMember> getForbiddensinks() {
		return forbidden;
	}
}
