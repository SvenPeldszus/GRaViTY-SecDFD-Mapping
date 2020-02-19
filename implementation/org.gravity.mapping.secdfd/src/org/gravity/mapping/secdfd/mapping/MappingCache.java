package org.gravity.mapping.secdfd.mapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;
import org.gravity.mapping.secdfd.helpers.CorrespondenceHelper;
import org.gravity.mapping.secdfd.model.mapping.Mapping;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TSignature;

import org.secdfd.model.Element;
import org.secdfd.model.NamedEntity;

public class MappingCache {
	/**
	 * HashMaps for the mapped entries
	 */
	private final Map<NamedEntity, Set<TAbstractType>> entityTypeMapping = new HashMap<>();
	private final Map<Element, Set<TMethod>> elementMethodMapping = new HashMap<>();
	private final Map<Element, Set<TSignature>> elementSignatureMapping = new HashMap<>();
	private final Map<Element, Set<TMember>> elementMemberMapping = new HashMap<>();

	public void load(Mapping mapping) {
		mapping.getAccepted().forEach(this::load);
		mapping.getUserdefined().forEach(this::load);
		mapping.getSuggested().forEach(this::load);
		
	}

	/**
	 * Loads the correspondence into the cache
	 * 
	 * @param correspondence A correspondence
	 */
	private void load(AbstractCorrespondence correspondence) {
		EObject source = CorrespondenceHelper.getSource(correspondence);
		EObject target = CorrespondenceHelper.getTarget(correspondence);
		if (source instanceof TAbstractType) {
			entityTypeMapping.computeIfAbsent((NamedEntity) target, f -> new HashSet<>())
					.add((TAbstractType) source);
		} else if (source instanceof TMethod) {
			elementMethodMapping.computeIfAbsent((Element) target, f -> new HashSet<>()).add((TMethod) source);
		} else if (source instanceof TSignature) {
			elementSignatureMapping.computeIfAbsent((Element) target, f -> new HashSet<>())
					.add((TSignature) source);
		} else if (source instanceof TMember) {
			elementMemberMapping.computeIfAbsent((Element) target, f -> new HashSet<>()).add((TMember) source);
		}
	}

	void add(TMember member, Element element) {
		elementMemberMapping.computeIfAbsent(element, f -> new HashSet<>()).add(member);
		add(member.getSignature(), element);
	}

	void add(TSignature signature, Element element) {
		elementSignatureMapping.computeIfAbsent(element, f -> new HashSet<>()).add(signature);
		if (signature instanceof TMethodSignature) {
			add(((TMethodSignature) signature).getMethod(), element);
		}
	}

	public void addAllSignatures(Set<TSignature> sigantures, Element element) {
		elementSignatureMapping.computeIfAbsent(element, f -> new HashSet<>()).addAll(sigantures);
	}

	void add(TMethod method, Element element) {
		elementMethodMapping.computeIfAbsent(element, f -> new HashSet<>()).add(method);
	}

	void addAllMethods(Set<TMethod> methods, Element element) {
		elementMethodMapping.computeIfAbsent(element, f -> new HashSet<>()).addAll(methods);
	}

	void add(TAbstractType type, NamedEntity entity) {
		entityTypeMapping.computeIfAbsent(entity, f -> new HashSet<>()).add(type);
	}

	void addAll(Set<TAbstractType> types, NamedEntity entity) {
		entityTypeMapping.computeIfAbsent(entity, f -> new HashSet<>()).addAll(types);
	}

	/**
	 * @return the entityTypeMapping
	 */
	public Map<NamedEntity, Set<TAbstractType>> getEntityTypeMapping() {
		return entityTypeMapping;
	}

	/**
	 * @return the elementMemberMapping
	 */
	public Map<Element, Set<TMember>> getElementMemberMapping() {
		return elementMemberMapping;
	}

	/**
	 * @return the elementMethodMapping
	 */
	public Map<Element, Set<TMethod>> getElementMethodMapping() {
		return elementMethodMapping;
	}

	/**
	 * @return the elementSignatureMapping
	 */
	public Map<Element, Set<TSignature>> getElementSignatureMapping() {
		return elementSignatureMapping;
	}

	/**
	 * @param pmElement
	 * @param dfdElement
	 */
	void remove(EObject pmElement, EObject dfdElement) {
		Set<TMember> members = getElementMemberMapping().get(dfdElement);
		if (members != null) {
			members.remove(pmElement);
		}
		Set<TSignature> sigs = getElementSignatureMapping().get(dfdElement);
		if (sigs != null) {
			sigs.remove(pmElement);
		}
		Set<TMethod> names = getElementMethodMapping().get(dfdElement);
		if (names != null) {
			names.remove(pmElement);
		}
		Set<TAbstractType> types = getEntityTypeMapping().get(dfdElement);
		if (types != null) {
			types.remove(pmElement);
		}
	}

}