/**
 * 
 */
package org.secdfd.dsl.validation;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.secdfd.model.ResponsibilityType;

/**
 * A class representing the Problem reported to the user regarding security
 * compliance issue
 * 
 * @author katjat
 *
 */
public class SResult {
	public static enum PState {
		SUCCESS, WARNING, ERROR;
	}

	private ResponsibilityType type;
	private PState state;
	private EObject dfdElement;
	private Set<TMethodDefinition> pmElement;
	private String description;

	/**
	 * 
	 */
	public SResult(PState state, ResponsibilityType type, EObject dfdElement, Set<TMethodDefinition> pmElement,
			String description) {
		this.state = state;
		this.type = type;
		this.dfdElement = dfdElement;
		this.pmElement = pmElement;
		this.description = description;
	}

	/**
	 * @return the dfdElement
	 */
	public EObject getDfdElement() {
		return dfdElement;
	}

	/**
	 * @return the type
	 */
	public ResponsibilityType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ResponsibilityType type) {
		this.type = type;
	}

	/**
	 * @return the state
	 */
	public PState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(PState state) {
		this.state = state;
	}

	/**
	 * @return the pmElement
	 */
	public Set<TMethodDefinition> getPmElement() {
		return pmElement;
	}

	/**
	 * @param pmElement the pmElement to set
	 */
	public void setPmElement(Set<TMethodDefinition> pmElement) {
		this.pmElement = pmElement;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return state + ": " + getDescription() + " - on " + getDfdElement();
	}
}
