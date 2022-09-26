package org.gravity.mapping.secdfd.helpers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TFlow;
import org.secdfd.model.Asset;

public final class AssetHelper {

	private AssetHelper() {
		// This class shouldn't be instantiated
	}

	/**
	 * Searches which assets can be communicated over this flow
	 *
	 * @param flow The flow
	 * @param assets All known type to asset mappings
	 * @return
	 */
	public static Set<Set<Asset>> getCommunicatedAssets(final TFlow flow, final Map<TAbstractType, Set<Asset>> assets) {
		final var foundTypes = FlowHelper.getCommunicatedTypes(flow);
		final Set<Set<Asset>> foundAssets = new HashSet<>();
		for (final TAbstractType type : foundTypes) {
			foundAssets.add(getMappedAssets(assets, type));

		}
		return foundAssets;
	}

	/**
	 * @param mapping A mapping of all assets
	 * @param type    The type whose corresponding asset should be added to the set
	 * @return The corresponding assets
	 */
	private static Set<Asset> getMappedAssets(final Map<TAbstractType, Set<Asset>> mapping,
			final TAbstractType type) {
		if (mapping.containsKey(type)) {
			return mapping.get(type);
		}
		return Collections.emptySet();
	}

}
