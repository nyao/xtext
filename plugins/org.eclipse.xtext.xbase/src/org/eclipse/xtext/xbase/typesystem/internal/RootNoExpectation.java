/*******************************************************************************
a * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class RootNoExpectation extends AbstractRootTypeExpectation {

	public RootNoExpectation(AbstractTypeComputationState state) {
		super(state);
	}

	public JvmTypeReference getExpectedType() {
		return null;
	}

	public boolean isNoTypeExpectation() {
		return true;
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		return true;
	}
	
	@Override
	public void acceptActualType(JvmTypeReference type, ConformanceHint hint) {
		// TODO resolve all unbound type parameters
//		AbstractTypeComputationState state = getState();
//		if (hint contains RAW) {
//		UnboundTypeParameterSubstitutor substitutor = new UnboundTypeParameterSubstitutor(
//				Collections.<JvmTypeParameter, JvmTypeReference>emptyMap(), state.getServices());
//		JvmTypeReference substitute = substitutor.substitute(type);
//		}
		super.acceptActualType(type, hint);
	}
}
