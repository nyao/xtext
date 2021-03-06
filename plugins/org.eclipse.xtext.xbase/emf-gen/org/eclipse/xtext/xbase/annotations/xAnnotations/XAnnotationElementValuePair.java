/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmOperation;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation Element Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValuePair()
 * @model
 * @generated
 */
public interface XAnnotationElementValuePair extends EObject
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValuePair_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(JvmOperation)
	 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage#getXAnnotationElementValuePair_Element()
	 * @model
	 * @generated
	 */
	JvmOperation getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(JvmOperation value);

} // XAnnotationElementValuePair
