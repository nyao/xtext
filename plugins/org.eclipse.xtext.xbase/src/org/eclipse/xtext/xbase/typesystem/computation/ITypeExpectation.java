/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * TODO JavaDoc, toString
 */
public interface ITypeExpectation {

	void acceptActualType(JvmTypeReference type, ConformanceHint hint);
	
	/**
	 * Returns the expected type. The expected type may be not too concrete thus {@link #getExpectedType()} may return
	 * <code>null</code> or some sort of unresolved, specialized reference. If <code>null</code> is returned, clients
	 * may want to check {@link #isNoTypeExpectation()} or {@link #isVoidTypeAllowed()}.
	 * @return the expected type. This may be <code>null</code>. 
	 */
	JvmTypeReference getExpectedType();
	
	/**
	 * Returns <code>true</code> if anything is allowed and no constraints are expected.
	 * @return <code>true</code> if anything is allowed and no constraints are expected.
	 */
	boolean isNoTypeExpectation();
	
	/**
	 * Returns <code>true</code> if {@link Void#TYPE} is a valid type. It may be the only valid type
	 * or there may exist others.
	 * @return <code>true</code> if primitive <code>void</code> is allowed.
	 */
	boolean isVoidTypeAllowed();
	
}
