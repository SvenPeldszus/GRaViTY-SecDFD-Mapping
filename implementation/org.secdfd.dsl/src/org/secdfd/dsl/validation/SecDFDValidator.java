/**
 * generated by Xtext 2.12.0
 */
package org.secdfd.dsl.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.secdfd.model.Asset;
import org.secdfd.model.DataStore;
import org.secdfd.model.EDFD;
import org.secdfd.model.ModelPackage;
import org.secdfd.model.NamedEntity;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class SecDFDValidator extends AbstractSecDFDValidator {
  private static Map<String, Set<String>> map = new HashMap<String, Set<String>>();

  private static Collection<SResult> problems = Collections.<SResult>emptySet();

  public static Map<String, Set<String>> setMap(final Map<String, Set<String>> newMap) {
    return SecDFDValidator.map = newMap;
  }

  public static Collection<SResult> setProblems(final Collection<SResult> pr) {
    return SecDFDValidator.problems = pr;
  }

  public static final String COMPLIANCE_ABSENCE = "absent in implementation";

  public static final String SECURITY_COMPLIANCE_ABSENCE = "security absent in implementation";

  @Check(CheckType.FAST)
  public Object AbsenceInImplementation(final EObject eobject) {
    Object _xifexpression = null;
    if ((((eobject instanceof DataStore) || (eobject instanceof Process)) || (eobject instanceof Asset))) {
      Object _xifexpression_1 = null;
      boolean _containsKey = SecDFDValidator.map.containsKey(((NamedEntity) eobject).getName());
      boolean _not = (!_containsKey);
      if (_not) {
        this.warning("Absence of asset in implementation. Please create a mapping or modify the code.", 
          ModelPackage.Literals.NAMED_ENTITY__NAME, SecDFDValidator.COMPLIANCE_ABSENCE);
      } else {
        _xifexpression_1 = null;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  @Check(CheckType.FAST)
  public void SecurityAbsenceInImplementation(final EObject eobject) {
    EObject dfd = eobject;
    if ((eobject instanceof NamedEntity)) {
      while (((dfd != null) && (!(dfd instanceof EDFD)))) {
        dfd = dfd.eContainer();
      }
      String dfdName = ((EDFD) dfd).getName();
      for (final SResult sp : SecDFDValidator.problems) {
        {
          final EObject dfdElement = sp.getDfdElement();
          EObject oDfd = dfdElement;
          while (((oDfd != null) && (!(oDfd instanceof EDFD)))) {
            oDfd = oDfd.eContainer();
          }
          if ((dfdName.equals(((EDFD) oDfd).getName()) && ((NamedEntity) dfdElement).getName().equals(((NamedEntity)eobject).getName()))) {
            final SResult.PState state = sp.getState();
            boolean _equals = Objects.equals(state, SResult.PState.SUCCESS);
            if (_equals) {
              this.info(sp.getDescription(), ModelPackage.Literals.NAMED_ENTITY__NAME, SecDFDValidator.SECURITY_COMPLIANCE_ABSENCE);
            } else {
              boolean _equals_1 = Objects.equals(state, SResult.PState.WARNING);
              if (_equals_1) {
                this.warning(sp.getDescription(), ModelPackage.Literals.NAMED_ENTITY__NAME, SecDFDValidator.SECURITY_COMPLIANCE_ABSENCE);
              } else {
                this.error(sp.getDescription(), ModelPackage.Literals.NAMED_ENTITY__NAME, SecDFDValidator.SECURITY_COMPLIANCE_ABSENCE);
              }
            }
          }
        }
      }
    }
  }
}
