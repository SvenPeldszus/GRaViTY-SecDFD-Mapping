package org.gravity.mapping.secdfd.helpers;

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
	public static Set<Asset> getCommunicatedAssets(TFlow flow, Map<TAbstractType, Set<Asset>> assets) {
		Set<TAbstractType> foundTypes = FlowHelper.getCommunicatedTypes(flow);
		Set<Asset> foundAssets = new HashSet<>();
		for (TAbstractType type : foundTypes) {
			addToAssetsIfMapped(foundAssets, assets, type);
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
	private static boolean addToAssetsIfMapped(Set<Asset> assets, Map<TAbstractType, Set<Asset>> mapping,
			TAbstractType type) {
		if (mapping.containsKey(type)) {
			assets.addAll(mapping.get(type));
			return true;
		}
		return false;
	}

}
