/*
 * generated by Xtext 2.12.0
 */
package org.secdfd.dsl.validation

import java.util.Collection
import java.util.Collections
import java.util.HashMap
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check
import org.secdfd.dsl.validation.SResult.PState
import org.secdfd.model.EDFD
import org.secdfd.model.ModelPackage
import org.secdfd.model.NamedEntity
import org.secdfd.model.DataStore
import org.secdfd.model.Asset

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class SecDFDValidator extends AbstractSecDFDValidator {

	// EObject is the edfd instance, the set of strings are the names of the source elements in the program model
	static Map<String, Set<String>> map = new HashMap();
	static Collection<SResult> problems = Collections.emptySet;

	def static setMap(Map<String, Set<String>> newMap) {
		map = newMap;
	}

	def static setProblems(Collection<SResult> pr) {
		problems = pr;
	}

	public static val COMPLIANCE_ABSENCE = 'absent in implementation'
	public static val SECURITY_COMPLIANCE_ABSENCE = 'security absent in implementation'

	@Check(FAST)
	def AbsenceInImplementation(EObject eobject) {
		if (eobject instanceof DataStore || eobject instanceof Process || eobject instanceof Asset) {
			if (!map.containsKey((eobject as NamedEntity).name)) {
				warning('Absence of asset in implementation. Please create a mapping or modify the code.',
					ModelPackage.Literals.NAMED_ENTITY__NAME, COMPLIANCE_ABSENCE
				)
			} else {
//				var message = 'The element has been mapped to '
//				val pm = map.get((eobject as NamedEntity).name)
//				message += Integer.toString(pm.size())
//				message += ' elements:'
//				for (sig : pm) {
//					message += '\n' + sig
//				}
//				info(message, ModelPackage.Literals.NAMED_ENTITY__NAME, COMPLIANCE_ABSENCE)				
			}
		}
	}

	@Check(FAST)
	def SecurityAbsenceInImplementation(EObject eobject) {
		var dfd = eobject;
		if (eobject instanceof NamedEntity) {
			while (dfd !== null && !(dfd instanceof EDFD)) {
				dfd = dfd.eContainer;
			}
			var dfdName = (dfd as EDFD).getName;
			for (SResult sp : problems) {
				val dfdElement = sp.getDfdElement
				var oDfd = dfdElement;
				while (oDfd !== null && !(oDfd instanceof EDFD)) {
					oDfd = oDfd.eContainer;
				}
				if (dfdName.equals((oDfd as EDFD).getName) && (dfdElement as NamedEntity).name.equals(eobject.name)) {
					val state = sp.getState
					if (state == PState.SUCCESS) {
						info(sp.getDescription, ModelPackage.Literals.NAMED_ENTITY__NAME, SECURITY_COMPLIANCE_ABSENCE);
					} else if (state == PState.WARNING) {
						warning(sp.getDescription, ModelPackage.Literals.NAMED_ENTITY__NAME, SECURITY_COMPLIANCE_ABSENCE);
					} else {
						error(sp.getDescription, ModelPackage.Literals.NAMED_ENTITY__NAME, SECURITY_COMPLIANCE_ABSENCE);
					}
				}
			}
		}
	}

}
