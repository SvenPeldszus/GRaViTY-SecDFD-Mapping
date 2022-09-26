package org.gravity.mapping.secdfd.helpers;

import java.util.List;

import org.secdfd.model.Asset;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

public class PrintHelper {

	public static String getStringRepresentation(Responsibility responsibility) {
		List<Asset> in = responsibility.getIncomeassets();
		List<ResponsibilityType> actions = responsibility.getAction();
		List<Asset> out = responsibility.getOutcomeassets();
		return getStringRepresentation(in, actions, out);
	}

	public static String getStringRepresentation(List<Asset> incoming, List<ResponsibilityType> actions,
			List<Asset> outgoing) {
		StringBuilder string = new StringBuilder();
		string.append('(');
		if (!incoming.isEmpty()) {
			string.append(incoming.get(0).getName());
			for (int i = 1; i < incoming.size(); i++) {
				string.append(", ").append(incoming.get(i).getName());
			}
		}
		string.append(") --[");
		if (!actions.isEmpty()) {
			string.append(actions.get(0).getLiteral());
			for (int i = 1; i < actions.size(); i++) {
				string.append(", ");
				string.append(actions.get(i));
			}
		}
		string.append("]--> (");
		if (!outgoing.isEmpty()) {
			string.append(outgoing.get(0).getName());
			for (int i = 1; i < outgoing.size(); i++) {
				string.append(", ").append(outgoing.get(i).getName());
			}
		}
		string.append(')');
		return string.toString();
	}

}
