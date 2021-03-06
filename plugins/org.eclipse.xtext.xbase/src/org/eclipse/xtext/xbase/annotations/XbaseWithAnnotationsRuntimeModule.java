/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class XbaseWithAnnotationsRuntimeModule extends org.eclipse.xtext.xbase.annotations.AbstractXbaseWithAnnotationsRuntimeModule {
	
	@Override
	public Class<? extends ITypeProvider> bindITypeProvider() {
		return XbaseWithAnnotationsTypeProvider.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XbaseWithAnnotationsScopeProvider.class;
	}
	
}
