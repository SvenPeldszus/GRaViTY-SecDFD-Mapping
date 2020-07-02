/**
 * 
 */
package org.gravity.flowdroid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	 * @param asset
	 * @return
	 */

	public SinkFinder(Mapper mapper, Asset asset) {
		allowed = new HashSet<>();
		forbidden = new HashSet<>();
		EDFD dfd = mapper.getDFD();

		Set<Element> attackerzones = getAttackerZones(dfd);

		// elements with incoming data flow
		for (Element el : getElementsWithIncomingFlow(dfd)) {
			List<TMember> elementMappings = getMapppedTMembers(mapper, el);
			if (attackerzones.contains(el) || el.isAttacker()) {
				forbidden.addAll(elementMappings);
			} else if (el instanceof ExternalEntity || el instanceof DataStore) {
				// find mappings of previous element (processes of the incoming flows)
				final Set<TMember> borderProcesses = getBorderMembers(mapper, el);

				// if any incoming flow contains current asset, then sink allowed.
				if (doesIncomingFlowContainAsset(el, asset)) {
					allowed.addAll(borderProcesses);

					// if DataStore, add all the method signatures that are defined over the mapped
					// Type (.e.g, hashmap.put(..) ) as allowed sinks
					if (el instanceof DataStore) {
						allowed.addAll(getAllowedSinks(mapper, el));
					}
				} else {
					// only add if it was in attacker zone -> DFD is not detailed enough
					//forbidden.addAll(borderProcesses);
				}

			}
		}
	}

	/**
	 * @param mapper
	 * @param element
	 * @return
	 */
	private List<TMember> getMapppedTMembers(Mapper mapper, Element element) {
		return mapper.getMapping(element).parallelStream().filter(TMember.class::isInstance)
				.map(TMember.class::cast).collect(Collectors.toList());
	}

	/**
	 * @param dfd
	 * @return
	 */
	private Set<Element> getElementsWithIncomingFlow(EDFD dfd) {
		return dfd.getElements().parallelStream().filter(el -> !el.getInflows().isEmpty())
				.collect(Collectors.toSet());
	}

	/**
	 * @param dfd
	 * @return
	 */
	private Set<Element> getAttackerZones(EDFD dfd) {
		return dfd.getTrustzones().parallelStream().filter(
				zone -> zone.getAttackerprofile().parallelStream().anyMatch(profile -> profile.getObservation() > 0))
				.flatMap(zone -> zone.getElements().parallelStream()).collect(Collectors.toSet());
	}

	/**
	 * @param mapper
	 * @param element
	 * @return
	 */
	private Set<TMember> getBorderMembers(Mapper mapper, Element element) {
		return element.getInflows().parallelStream()
				.flatMap(flow -> mapper.getMapping(flow.getSource()).parallelStream()).filter(TMember.class::isInstance)
				.map(TMember.class::cast).collect(Collectors.toSet());
	}

	/**
	 * @param mapper
	 * @param sinkElement
	 * @return
	 */
	private Set<TMember> getAllowedSinks(Mapper mapper, Element sinkElement) {
		Set<? extends EObject> pmElements = mapper.getMapping(sinkElement);
		return pmElements.parallelStream().flatMap(element -> {
			if (element instanceof TMember) {
				return Stream.of((TMember) element);
			} else if (element instanceof TAbstractType) {
				TAbstractType tType = (TAbstractType) element;
				return tType.getDefines().parallelStream().filter(defined -> defined instanceof TMember);
			} else {
				return Stream.empty();
			}
		}).flatMap(member -> {
			Stream<TMember> stream = Stream.of(member);
			if (member instanceof TMethodDefinition) {
				TMethodDefinition current = ((TMethodDefinition) member);
				while((current = current.getOverriding()) != null) {
					stream = Stream.concat(stream, Stream.of(current));
				}
			}
			return stream;
		})
		.collect(Collectors.toSet());
	}

	/**
	 * @param element
	 * @param asset
	 * @return
	 */
	private boolean doesIncomingFlowContainAsset(Element element, Asset asset) {
		return element.getInflows().parallelStream().flatMap(inflow -> inflow.getAssets().parallelStream())
				.collect(Collectors.toSet()).contains(asset);
	}

	public Set<TMember> getAllowedsinks() {
		return allowed;
	}

	public Set<TMember> getForbiddensinks() {
		return forbidden;
	}
}
