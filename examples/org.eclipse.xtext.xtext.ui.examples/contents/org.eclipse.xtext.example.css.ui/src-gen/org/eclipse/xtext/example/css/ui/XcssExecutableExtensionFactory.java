/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.css.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XcssExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.xtext.example.css.ui.internal.XcssActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipse.xtext.example.css.ui.internal.XcssActivator.getInstance().getInjector("org.eclipse.xtext.example.css.Xcss");
	}
	
}