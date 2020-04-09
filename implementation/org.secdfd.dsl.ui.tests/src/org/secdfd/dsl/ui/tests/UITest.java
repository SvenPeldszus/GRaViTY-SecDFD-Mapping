package org.secdfd.dsl.ui.tests;


import org.junit.jupiter.api.Test;

import com.google.inject.Injector;

public class UITest {
	
	private Injector injector;

	public UITest() {
		injector = new SecDFDUiInjectorProvider().getInjector();
	}

	@Test
	public void test( ) {
		//TODO: Implement tests
	}
}
