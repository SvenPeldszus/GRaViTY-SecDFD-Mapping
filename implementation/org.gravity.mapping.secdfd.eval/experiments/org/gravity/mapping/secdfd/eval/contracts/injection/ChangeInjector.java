package org.gravity.mapping.secdfd.eval.contracts.injection;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Combinations;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gravity.mapping.secdfd.helpers.PrintHelper;
import org.secdfd.model.Asset;
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

	public ChangeInjector(final EDFD dfd, final boolean delete, final boolean inject, final ResponsibilityType... supported) {
		this.dfd = dfd;
		this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain(dfd.eResource().getResourceSet());
		this.possible = new LinkedList<>();
		for (final Element element : this.dfd.getElements()) {
			if (element instanceof Process) {
				final Process process = (Process) element;

				for (final Responsibility responsibility : process.getResponsibility()) {
					final EList<ResponsibilityType> actions = responsibility.getAction();
					if (containsAny(actions, supported) && delete) {
						deleteContract(process, responsibility, actions);
					}
				}

				if (inject) {
					final List<Asset> in = new ArrayList<>(process.getInflows().stream()
							.flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toList()));
					final List<Asset> out = new ArrayList<>(process.getOutflows().stream()
							.flatMap(flow -> flow.getAssets().stream()).collect(Collectors.toList()));

					for (final ResponsibilityType type : supported) {
						switch (type) {
						case FORWARD:
							this.possible.addAll(generateContract(in, 1, 1, out, 1, 1, process, type));
							break;
						case JOINER:
							this.possible.addAll(generateContract(in, 2, Integer.MAX_VALUE, out, 1, 1, process, type));
							break;
						case ENCRYPT_OR_HASH:
							this.possible.addAll(generateContract(in, 2, 2, out, 1, 1, process, type));
							break;
						case DECRYPT:
							this.possible.addAll(generateContract(in, 2, 2, out, 1, 1, process, type));
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
	private void deleteContract(final Process process, final Responsibility responsibility, final List<ResponsibilityType> actions) {
		final Command remove = new RecordingCommand(this.editingDomain, DELETE_RESPONSIBILITY,
				process.getName() + ": " + PrintHelper.getStringRepresentation(responsibility)) {

			@Override
			protected void doExecute() {
				process.getResponsibility().remove(responsibility);
			}

		};
		this.possible.add(new SimpleEntry<>(new ExpectedMissingContract(process, actions.get(0),
				responsibility.getIncomeassets(), responsibility.getOutcomeassets(), DELETE_RESPONSIBILITY), remove));
	}

	private Collection<Entry<ExpectedError, Command>> generateContract(final List<Asset> in, final int minIn, final int maxIn,
			final List<Asset> out, final int minOut, final int maxOut, final Process process, final ResponsibilityType type) {
		final List<Entry<ExpectedError, Command>> commands = new LinkedList<>();

		final List<List<Asset>> inCombinations = combinations(in, minIn, maxIn);
		final List<List<Asset>> outCombinations = combinations(out, minOut, maxOut);
		for (final List<Asset> inVal : inCombinations) {
			for (final List<Asset> outVal : outCombinations) {
				if (!isAlreadyImplemented(process.getResponsibility(), inVal, outVal)) {
					final Command command = new RecordingCommand(this.editingDomain, INJECT_RESPONSIBILITY,
							process.getName() + ": ?") {

						private final List<Asset> incoming = new ArrayList<>(inVal);
						private final List<Asset> outgoing = new ArrayList<>(outVal);

						@Override
						protected void doExecute() {
							final Responsibility responsibility = ModelFactory.eINSTANCE.createResponsibility();
							process.getResponsibility().add(responsibility);
							responsibility.getAction().add(type);
							responsibility.getIncomeassets().addAll(this.incoming);
							responsibility.getOutcomeassets().addAll(this.outgoing);
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

	private static List<List<Asset>> combinations(final List<Asset> values, final int min, final int max) {
		final List<List<Asset>> combinations = new LinkedList<>();
		for (int i = min; (i <= max) && (i <= values.size()); i++) {
			final Iterator<int[]> iterator = new Combinations(values.size(), i).iterator();
			while (iterator.hasNext()) {
				final int[] next = iterator.next();
				final List<Asset> comb = new ArrayList<>(next.length);
				for (final int index : next) {
					comb.add(values.get(index));
				}
				combinations.add(comb);
			}
		}
		return combinations;
	}

	private boolean isAlreadyImplemented(final List<Responsibility> contracts, final List<Asset> proposedInAssets,
			final List<Asset> proposedOutAssets) {
		for (final Responsibility existingContract : contracts) {
			final EList<Asset> existingInAssets = existingContract.getIncomeassets();
			final EList<Asset> existingOutAssets = existingContract.getOutcomeassets();
			if ((existingInAssets.size() == proposedInAssets.size())
					&& existingInAssets.containsAll(proposedInAssets)
					&& (existingOutAssets.size() == proposedOutAssets.size())
					&& existingOutAssets.containsAll(proposedOutAssets)) {
				return true;
			}
		}
		return false;
	}

	private <T> boolean containsAny(final Collection<T> collection, final T[] values) {
		for (final T t : values) {
			if (collection.contains(t)) {
				return true;
			}
		}
		return false;
	}

	public Entry<ExpectedError, Command> next() {
		if (!this.possible.isEmpty()) {
			return this.possible.remove(this.random.nextInt(this.possible.size()));
		} else {
			return null;
		}
	}

}
