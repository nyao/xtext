/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class MyResolvedTypes extends ResolvedTypes {
	new(DefaultReentrantTypeResolver resolver) {
		super(resolver)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AccessibleReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	override public setTypeComputer(ITypeComputer typeComputer) {
		super.setTypeComputer(typeComputer)
	}
	
	override public getBatchScopeProvider() {
		super.getBatchScopeProvider()
	}
	
}