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
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public abstract class AbstractLinkingCandidateWithTypeParameter<LinkingCandidate extends ILinkingCandidate<LinkingCandidate>> 
		extends AbstractLinkingCandidate<LinkingCandidate> implements ObservableTypeExpectation.Observer { 
	
	protected class LazyExpectation extends AbstractReentrantTypeReferenceProvider {
		private final JvmTypeReference declaredType;
		private final UnboundTypeParameterPreservingSubstitutor substitutor;

		protected LazyExpectation(JvmTypeReference declaredType) {
			this.declaredType = declaredType;
			substitutor = new UnboundTypeParameterPreservingSubstitutor(getDeclaratorParameterMapping(), getState().getServices());
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
		}

		@Override
		protected JvmTypeReference doGetTypeReference() {
			// TODO enhance with expectation
			JvmTypeReference substitute = substitutor.substitute(declaredType);
			return substitute;
		}
	}

	private final ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping;
	
	protected AbstractLinkingCandidateWithTypeParameter(XExpression expression, IEObjectDescription description,
			AbstractTypeComputationState state) {
		super(expression, description, state);
		this.typeParameterMapping = ArrayListMultimap.create(2, 2);
	}

	public void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint) {
		// TODO traverse the expectation and read the actual parameter data from the actual mapping by means of a type parameter substitutor
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			return;
		}
		if (expectedType instanceof XComputedTypeReference) {
			XComputedTypeReference computedTypeReference = (XComputedTypeReference) expectedType;
			if (computedTypeReference.getTypeProvider() instanceof UnboundTypeParameter) {
				UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) computedTypeReference.getTypeProvider();
				JvmTypeReference wrappedActual = asWrapperType(actual);
				unboundTypeParameter.acceptHint(wrappedActual);
			}
		} else if (expectedType.getType() instanceof JvmTypeParameter) {
			if (!(actual instanceof JvmAnyTypeReference)) {
				JvmTypeReference wrappedActual = asWrapperType(actual);
				typeParameterMapping.put((JvmTypeParameter) expectedType.getType(), new BoundTypeArgument(wrappedActual, BoundTypeArgumentSource.INFERRED, new Object(), VarianceInfo.OUT, VarianceInfo.OUT));
			}
		} else {
			resolveAgainstActualType(expectedType, actual);
		}
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			return ((JvmTypeParameterDeclarator) feature).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	@Override
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = getDeclaredType(feature);
		getState().getResolvedTypes().acceptLinkingInformation(getExpression(), this);
		computeArgumentTypes(feature, featureType);
		List<ITypeExpectation> expectations = getState().getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			TypeParameterSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(getDeclaratorParameterMapping(), getState().getServices()) {
				
				@Override
				public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
						Set<JvmTypeParameter> param) {
					if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
						XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
						result.setTypeProvider(reference.getTypeProvider());
						return result;
					}
					return super.doVisitComputedTypeReference(reference, param);
				}
				
				@Override
				protected JvmTypeReference getUnmappedSubstitute(JvmParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
					XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
					result.setTypeProvider(new UnboundTypeParameter(getExpression(), type, getServices()));
					return result;
				}
				
			};
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
			// TODO enhance with expectation
			JvmTypeReference substitute = substitutor.substitute(featureType);
			deferredBindTypeArguments(expectation, substitute);
			expectation.acceptActualType(substitute, ConformanceHint.UNCHECKED);
		}
	}
	
//	@Override
//	protected JvmTypeReference asWrapperType(JvmTypeReference potentialPrimitive) {
//		if (potentialPrimitive instanceof XComputedTypeReference) {
//			if (((XComputedTypeReference) potentialPrimitive).getTypeProvider() instanceof UnboundTypeParameter){
//				return potentialPrimitive;
//			}
//		}
//		Primitives primitives = getState().getServices().getPrimitives();
//		JvmTypeReference result = primitives.asWrapperTypeIfPrimitive(potentialPrimitive);
//		return result;
//	}
//	
//	@Override
//	protected JvmTypeParameter getTypeParameter(JvmTypeReference referenceToTypeParameter) {
//		if (referenceToTypeParameter instanceof XComputedTypeReference) {
//			if (((XComputedTypeReference) referenceToTypeParameter).getTypeProvider() instanceof UnboundTypeParameter){
//				return null;
//			}
//			return getTypeParameter(((XComputedTypeReference) referenceToTypeParameter).getEquivalent());
//		}
//		JvmType result = referenceToTypeParameter.getType();
//		if (result instanceof JvmTypeParameter) {
//			return (JvmTypeParameter) result;
//		}
//		return null;
//	}
	
	@Override
	protected void computeArgumentTypes(JvmIdentifiableElement feature, JvmTypeReference featureType) {
		int declaredParameterCount = 0;
		int fixedArityParameterCount = 0;
		List<JvmFormalParameter> parameters = null;
		boolean varArgs = false;
		if (feature instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) feature;
			declaredParameterCount = executable.getParameters().size();
			varArgs = executable.isVarArgs();
			fixedArityParameterCount = varArgs ? declaredParameterCount - 1 : declaredParameterCount;
			parameters = executable.getParameters();
		}
		List<XExpression> arguments = getArguments();
		int fixedArityArgumentCount = Math.min(fixedArityParameterCount, arguments.size());
		List<StackedResolvedTypes> stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		if (parameters != null) {
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				final JvmFormalParameter parameter = parameters.get(i);
				final JvmTypeReference parameterType = parameter.getParameterType();
				XExpression argument = arguments.get(i);
				IJvmTypeReferenceProvider expectation = new LazyExpectation(parameterType);
				AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
						getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				stackedResolvedTypes.add(resolveArgumentType(argument, parameterType, argumentState));
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				final JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				
				IJvmTypeReferenceProvider expectation = new LazyExpectation(componentType);
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
	//				XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				} else {
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				}
				for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
					XExpression argument = arguments.get(i);
					stackedResolvedTypes.add(resolveArgumentType(argument, null, argumentState));
				}
			}
		}
		if (!varArgs) {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				stackedResolvedTypes.add(resolveArgumentType(argument, null, getState().fork().withNonVoidExpectation()));
			}
		}
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
	}

	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
		JvmIdentifiableElement feature = getFeature();
		// TODO this(..) and super(..) for generic types
		if (feature instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
			if (!typeParameters.isEmpty()) {
				ActualTypeArgumentCollector implementation = new UnboundTypeParameterAwareTypeArgumentCollector(typeParameters, getState().getServices());
				implementation.populateTypeParameterMapping(declaredType, actualType);
				typeParameterMapping.putAll(implementation.rawGetTypeParameterMapping());
			}
		}
	}

	protected Map<JvmTypeParameter, JvmTypeReference> getFeatureTypeParameterMapping() {
		Map<JvmTypeParameter, JvmTypeReference> consolidatedMap = Maps.newHashMap();
		for(JvmTypeParameter typeParameter: typeParameterMapping.keySet()) {
			List<BoundTypeArgument> boundTypeArguments = typeParameterMapping.get(typeParameter);
			MergedBoundTypeArgument mergedTypeArguments = getState().getTypeArgumentMerger().merge(boundTypeArguments);
			if (mergedTypeArguments != null)
				consolidatedMap.put(typeParameter, mergedTypeArguments.getTypeReference());
		}
		return consolidatedMap;
	}

}
