/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.validation.csvalidationtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.List1#getVal1 <em>Val1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getList1()
 * @model
 * @generated
 */
public interface List1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val1</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getList1_Val1()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal1();

} // List1
