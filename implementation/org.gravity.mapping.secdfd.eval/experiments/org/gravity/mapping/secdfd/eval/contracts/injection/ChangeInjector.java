package org.gravity.mapping.secdfd.eval.contracts.injection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import org.apache.commons.math3.util.Combinations;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.secdfd.model.Asset;
import org.secdfd.model.AssetType;
import org.secdfd.model.EDFD;
import org.secdfd.model.Element;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

public class ChangeInjector {

	private static final String DELETE_RESPONSIBILITY = "Delete responsibility";

	private static final String INJECT_RESPONSIBILITY = "Inject Responsibility";

	private final EDFD dfd;

	private final List<Entry<ExpectedError, Command>> possible;
	private final Random random = new Random();
	private final TransactionalEditingDomain editingDomain;

	public ChangeInjector(EDFD dfd, boolean delete, boolean inject, ResponsibilityType... supported) {
		this.dfd = dfd;
		this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain(dfd.eResource().getResourceSet());
		this.possible = new LinkedList<>();
		for (Element element : this.dfd.getElements()) {
			if (element instanceof Process) {
				Process process = (Process) element;

				for (Responsibility responsibility : process.getResponsibility()) {
					EList<ResponsibilityType> actions = responsibility.getAction();
					if (containsAny(actions, supported) && delete) {
						deleteContract(process, responsibility, actions);
					}
				}

				if (inject) {
					List<Asset> in = new ArrayList<>(process.getInflows().stream()
							.flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toList()));
					List<Asset> out = new ArrayList<>(process.getOutflows().stream()
							.flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toList()));

					for (ResponsibilityType type : supported) {
						switch (type) {
						case FORWARD:
							possible.addAll(generateContract(in, 1, 1, out, 1, 1, process, type));
							break;
						case JOINER:
							possible.addAll(generateContract(in, 2, Integer.MAX_VALUE, out, 1, 1, process, type));
							break;
						case ENCRYPT_OR_HASH:
							possible.addAll(generateContract(in, 2, 2, out, 1, 1, process, type));
							break;
						case DECRYPT:
							possible.addAll(generateContract(in, 2, 2, out, 1, 1, process, type));
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * @param process
	 * @param responsibility
	 * @param actions
	 */
	private void deleteContract(Process process, Responsibility responsibility, List<ResponsibilityType> actions) {
		Command remove = new RecordingCommand(editingDomain, DELETE_RESPONSIBILITY,
				process.getName() + ": " + PrintHelper.getStringRepresentation(responsibility)) {

			@Override
			protected void doExecute() {
				process.getResponsibility().remove(responsibility);
			}

		};
		this.possible.add(new SimpleEntry<>(new ExpectedMissingContract(process, actions.get(0),
				responsibility.getIncomeassets(), responsibility.getOutcomeassets(), DELETE_RESPONSIBILITY), remove));
	}

	private Collection<Entry<ExpectedError, Command>> generateContract(List<Asset> in, int minIn, int maxIn,
			List<Asset> out, int minOut, int maxOut, Process process, ResponsibilityType type) {
		List<Entry<ExpectedError, Command>> commands = new LinkedList<>();

		List<List<Asset>> inCombinations = combinations(in, minIn, maxIn);
		List<List<Asset>> outCombinations = combinations(out, minOut, maxOut);
		for (List<Asset> inVal : inCombinations) {
			for (List<Asset> outVal : outCombinations) {
				if (!isAlreadyImplemented(process.getResponsibility(), inVal, outVal)) {
					Command command = new RecordingCommand(editingDomain, INJECT_RESPONSIBILITY,
							process.getName() + ": ?") {

						private List<Asset> incoming = new ArrayList<>(inVal);
						private List<Asset> outgoing = new ArrayList<>(outVal);

						@Override
						protected void doExecute() {
							Responsibility responsibility = ModelFactory.eINSTANCE.createResponsibility();
							process.getResponsibility().add(responsibility);
							responsibility.getAction().add(type);
							responsibility.getIncomeassets().addAll(incoming);
							responsibility.getOutcomeassets().addAll(outgoing);
							this.description = process.getName() + ": "
									+ PrintHelper.getStringRepresentation(responsibility);
						}
					};
					commands.add(new SimpleEntry<>(
							new ExpectedMissingImplementation(process, type, inVal, outVal, INJECT_RESPONSIBILITY),
							command));
				}
			}
		}
		return commands;
	}

	private static List<List<Asset>> combinations(List<Asset> values, int min, int max) {
		List<List<Asset>> combinations = new LinkedList<>();
		for (int i = min; i <= max && i <= values.size(); i++) {
			Iterator<int[]> iterator = new Combinations(values.size(), i).iterator();
			while (iterator.hasNext()) {
				int[] next = iterator.next();
				List<Asset> comb = new ArrayList<>(next.length);
				for (int index : next) {
					comb.add(values.get(index));
				}
				combinations.add(comb);
			}
		}
		return combinations;
	}

	private boolean isAlreadyImplemented(List<Responsibility> contracts, List<Asset> proposedInAssets,
			List<Asset> proposedOutAssets) {
		for (Responsibility existingContract : contracts) {
			EList<Asset> existingInAssets = existingContract.getIncomeassets();
			EList<Asset> existingOutAssets = existingContract.getOutcomeassets();
			if (existingInAssets.size() == proposedInAssets.size() 
					&& existingInAssets.containsAll(proposedInAssets)
					&& existingOutAssets.size() == proposedOutAssets.size()
					&& existingOutAssets.containsAll(proposedOutAssets)) {
				return true;
			}
		}
		return false;
	}

	private <T> boolean containsAny(Collection<T> collection, T[] values) {
		for (T t : values) {
			if (collection.contains(t)) {
				return true;
			}
		}
		return false;
	}

	public Entry<ExpectedError, Command> next() {
		if (!possible.isEmpty()) {
			return possible.remove(random.nextInt(possible.size()));
		} else
			return null;
	}

}
