/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeComputationStateWithNonVoidExpectation extends AbstractStackedTypeComputationState {

	protected TypeComputationStateWithNonVoidExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
	}

	@Override
	public List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState) {
		ITypeExpectation result = createTypeExpectation(null, actualState);
		return Collections.singletonList(result);
	}
	
	protected AbstractTypeExpectation createTypeExpectation(@Nullable JvmTypeReference expectedType, AbstractTypeComputationState actualState) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			throw new IllegalArgumentException("expectedType should be null");
		} 
		result = new TypeExpectation(null, actualState, false);
		return result;
	}

}
