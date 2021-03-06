/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.IDelegatingScopeProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * This implementation skips the declarative API of the {@link AbstractDeclarativeScopeProvider}
 * while still delegating to another {@link org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider#NAMED_DELEGATE provider}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtypeScopeProvider extends AbstractScopeProvider implements IDelegatingScopeProvider {

	@Inject
	@Named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)
	private IScopeProvider delegate;
	
	public IScope getScope(EObject context, EReference reference) {
		return delegateGetScope(context, reference);
	}
	
	protected IScope delegateGetScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public void setDelegate(IScopeProvider delegate) {
		this.delegate = delegate;
	}

	public IScopeProvider getDelegate() {
		return delegate;
	}

}
