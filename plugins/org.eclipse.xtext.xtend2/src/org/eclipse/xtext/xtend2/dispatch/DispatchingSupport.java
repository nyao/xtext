/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.dispatch;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DispatchingSupport {

	@Inject
	private FeatureOverridesService overridesService;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private Primitives primitives;

	public Multimap<Pair<String, Integer>, JvmOperation> getDispatchMethods(JvmGenericType type) {
		Multimap<Pair<String, Integer>, JvmOperation> result = LinkedHashMultimap.create();
		collectDispatchMethods(type, result);
		return result;
	}

	protected void collectDispatchMethods(final JvmGenericType type, Multimap<Pair<String, Integer>, JvmOperation> result) {
		Iterable<JvmOperation> features = filter(overridesService.getAllJvmFeatures(typeRefs.createTypeRef(type)),
				JvmOperation.class);
		for (JvmOperation operation : features) {
			if (isDispatchOperation(operation)) {
				final Pair<String, Integer> signatureTuple = Tuples.create(operation.getSimpleName().substring(1),
						operation.getParameters().size());
				result.put(signatureTuple, operation);
			}
		}
		removeNonLocalMethods(type, result);
	}

	protected void removeNonLocalMethods(final JvmGenericType type, Multimap<Pair<String, Integer>, JvmOperation> result) {
		List<Pair<String, Integer>> removeKeys = newArrayList(); 
		for(Pair<String, Integer> signatureTuple : result.keySet()) {
			Collection<JvmOperation> collection = result.get(signatureTuple);
			if(!any(collection, new Predicate<JvmOperation>() {
				public boolean apply(JvmOperation input) {
					return input.getDeclaringType() == type;
				}
			})) {
				removeKeys.add(signatureTuple);
			}
		}
		for(Pair<String, Integer> signatureTuple: removeKeys) {
			result.removeAll(signatureTuple);
		}
	}

	protected boolean isDispatchOperation(JvmOperation operation) {
		return !operation.getParameters().isEmpty() && !operation.isStatic()
				&& operation.getSimpleName().startsWith("_");
	}

	public List<JvmOperation> sort(Collection<JvmOperation> collection) {
		List<JvmOperation> list = newArrayList(collection);
		Collections.sort(list, new Comparator<JvmOperation>() {
			public int compare(JvmOperation o1, JvmOperation o2) {
				return DispatchingSupport.this.compare(o1, o2);
			}
		});
		return list;
	}
	
	protected int compare(JvmOperation o1, JvmOperation o2) {
		int params = o1.getParameters().size();
		for (int i = 0; i < params; i++) {
			final JvmTypeReference p1 = o1.getParameters().get(i).getParameterType();
			final JvmTypeReference p2 = o2.getParameters().get(i).getParameterType();
			int distance1 = getMaxDistanceToObject(p1);
			int distance2 = getMaxDistanceToObject(p2);
			if (distance1!=distance2) {
				return distance2 - distance1;
			}
		}
		String identifier1 = o1.getIdentifier();
		String parameterTypes1 = identifier1.substring(identifier1.indexOf('('));
		String identifier2 = o2.getIdentifier();
		String parameterTypes2 = identifier2.substring(identifier2.indexOf('('));
		return parameterTypes1.compareTo(parameterTypes2);
	}
	
	protected int getMaxDistanceToObject(JvmTypeReference type) {
		type = primitives.asWrapperTypeIfPrimitive(type);
		if (typeRefs.is(type, Object.class))
			return 0;
		JvmType jvmType = type.getType();
		int maxDistance = 1;
		if (jvmType instanceof JvmDeclaredType) {
			EList<JvmTypeReference> list = ((JvmDeclaredType) jvmType).getSuperTypes();
			for (JvmTypeReference jvmTypeReference : list) {
				int result = 1 + getMaxDistanceToObject(jvmTypeReference);
				if (result>maxDistance)
					maxDistance = result;
			}
		}
		return maxDistance;
	}

}