/*
 * generated by Xtext 2.20.0
 */
package org.secdfd.dsl.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.secdfd.dsl.SecDFDRuntimeModule
import org.secdfd.dsl.SecDFDStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class SecDFDIdeSetup extends SecDFDStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new SecDFDRuntimeModule, new SecDFDIdeModule))
	}
	
}