package org.gravity.mapping.secdfd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethod;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TSignature;

import eDFDFlowTracking.Element;
import eDFDFlowTracking.NamedEntity;

public class MappingCache {
	/**
	 * HashMaps for the mapped entries
	 */
	private final HashMap<NamedEntity, Set<TAbstractType>> entityTypeMapping = new HashMap<>();
	private final HashMap<Element, Set<TMethod>> elementMethodMapping = new HashMap<>();
	private final HashMap<Element, Set<TSignature>> elementSignatureMapping = new HashMap<>();
	private HashMap<Element, Set<TMember>> elementMemberMapping = new HashMap<>();
	
	void add(TMember member, Element element) {
		Set<TMember> memberValues;
		if (elementMemberMapping.containsKey(element)) {
			memberValues = elementMemberMapping.get(element);
		} else {
			memberValues = new HashSet<>();
			elementMemberMapping.put(element, memberValues);
		}
		memberValues.add(member);
		add(member.getSignature(), element);
	}

	void add(TSignature signature, Element element) {
		Set<TSignature> memberValues;
		if (getElementSignatureMapping().containsKey(element)) {
			memberValues = getElementSignatureMapping().get(element);
		} else {
			memberValues = new HashSet<>();
			getElementSignatureMapping().put(element, memberValues);
		}
		memberValues.add(signature);
		if(signature instanceof TMethodSignature) {
			add(((TMethodSignature)signature).getMethod(), element);
		}
	}

	public void addAllSignatures(Set<TSignature> sigantures, Element element) {
		Set<TSignature> memberValues;
		if (getElementSignatureMapping().containsKey(element)) {
			memberValues = getElementSignatureMapping().get(element);
		} else {
			memberValues = new HashSet<>();
			getElementSignatureMapping().put(element, memberValues);
		}
		memberValues.addAll(sigantures);
	}

	void add(TMethod method, Element element) {
		Set<TMethod> memberValues;
		if (getElementMethodMapping().containsKey(element)) {
			memberValues = getElementMethodMapping().get(element);
		} else {
			memberValues = new HashSet<>();
			getElementMethodMapping().put(element, memberValues);
		}
		memberValues.add(method);
	}

	void addAllMethods(Set<TMethod> methods, Element element) {
		Set<TMethod> memberValues;
		if (getElementMethodMapping().containsKey(element)) {
			memberValues = getElementMethodMapping().get(element);
		} else {
			memberValues = new HashSet<>();
			getElementMethodMapping().put(element, memberValues);
		}
		memberValues.addAll(methods);
	}

	void add(TAbstractType type, NamedEntity entity) {
		Set<TAbstractType> memberValues;
		if (entityTypeMapping.containsKey(entity)) {
			memberValues = entityTypeMapping.get(entity);
		} else {
			memberValues = new HashSet<>();
			entityTypeMapping.put(entity, memberValues);
		}
		memberValues.add(type);
	}

	void addAll(Set<TAbstractType> types, NamedEntity entity) {
		Set<TAbstractType> memberValues;
		if (entityTypeMapping.containsKey(entity)) {
			memberValues = entityTypeMapping.get(entity);
		} else {
			memberValues = new HashSet<>();
			entityTypeMapping.put(entity, memberValues);
		}
		memberValues.addAll(types);
	}

	/**
	 * @return the entityTypeMapping
	 */
	public HashMap<NamedEntity, Set<TAbstractType>> getEntityTypeMapping() {
		return entityTypeMapping;
	}

	/**
	 * @return the elementMemberMapping
	 */
	public HashMap<Element, Set<TMember>> getElementMemberMapping() {
		return elementMemberMapping;
	}

	/**
	 * @param elementMemberMapping the elementMemberMapping to set
	 */
	public void setElementMemberMapping(HashMap<Element, Set<TMember>> elementMemberMapping) {
		this.elementMemberMapping = elementMemberMapping;
	}

	/**
	 * @return the elementMethodMapping
	 */
	public HashMap<Element, Set<TMethod>> getElementMethodMapping() {
		return elementMethodMapping;
	}

	/**
	 * @return the elementSignatureMapping
	 */
	public HashMap<Element, Set<TSignature>> getElementSignatureMapping() {
		return elementSignatureMapping;
	}

	/**
	 * @param pmElement
	 * @param dfdElement
	 */
	void remove(EObject pmElement, EObject dfdElement) {
		Set<TMember> members = getElementMemberMapping().get(dfdElement);
		if(members!=null) {
			members.remove(pmElement);
		}
		Set<TSignature> sigs = getElementSignatureMapping().get(dfdElement);
		if(sigs != null) {
			sigs.remove(pmElement);
		}
		Set<TMethod> names = getElementMethodMapping().get(dfdElement);
		if(names != null) {
			names.remove(pmElement);
		}
		Set<TAbstractType> types = getEntityTypeMapping().get(dfdElement);
		if(types!=null) {
			types.remove(pmElement);
		}
	}

}