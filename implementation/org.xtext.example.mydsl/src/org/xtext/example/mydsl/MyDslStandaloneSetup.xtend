/*
 * generated by Xtext 2.17.1
 */
package org.xtext.example.mydsl

import com.google.inject.Injector
import eDFDFlowTracking.EDFDFlowTrackingPackage
import org.eclipse.emf.ecore.EPackage

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class MyDslStandaloneSetup extends MyDslStandaloneSetupGenerated {

	def static void doSetup() {
		new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.example.org/eDFDFlowTracking")) {
	            EPackage.Registry.INSTANCE.put(EDFDFlowTrackingPackage.eNS_URI, EDFDFlowTrackingPackage.eINSTANCE);
	        }
		super.register(injector)
	}
}