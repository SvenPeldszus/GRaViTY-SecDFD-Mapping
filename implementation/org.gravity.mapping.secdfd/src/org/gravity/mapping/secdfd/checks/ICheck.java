package org.gravity.mapping.secdfd.checks;

import java.util.Collection;

import org.gravity.mapping.secdfd.mapping.Mapper;
import org.secdfd.dsl.validation.SResult;

public interface ICheck {

	Collection<SResult> check(Mapper mapper);
}
