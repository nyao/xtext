package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.impl.LegacyTransientValueService;

import com.google.inject.ImplementedBy;

/**
 * Implementations of this interface decide which values are serialized during serialization. The behavior differs
 * slightly for single-value features and multi-value features, because single-value-features have an extra status:
 * "optional".
 * 
 * Transient Values must not be serialized in any case.
 * 
 * Optional Values should not be serialized, but the serializer may decide to serialize them anyway, if needed. The use
 * case for this is that if a features holds its default value, this values doesn't need to be serialized. However, the
 * grammar may require the grammar to be serialized. Example: (x=INT y=INT)?; For x=1 and y=0 with 0 being y's default
 * value, 0 needs to be serialized since otherwise x can not be serialized.
 * 
 * Multi-Value-Features don't have this "optional" status, because even if their list holds a default-value, this valu
 * needs to be serialized to be preserved.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(LegacyTransientValueService.class)
public interface ITransientValueService {

	enum ListTransient {
		NO, SOME, YES
	}

	enum ValueTransient {
		NO, PREFERABLY, YES
	}

	public ListTransient isListTransient(EObject semanitcObject, EStructuralFeature feature);

	public boolean isValueInListTransient(EObject semanitcObject, int index, EStructuralFeature feature);

	public ValueTransient isValueTransient(EObject semanitcObject, EStructuralFeature feature);
}