/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmExecutable#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmExecutable#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmExecutable#isVarArgs <em>Var Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable()
 * @model abstract="true"
 * @generated
 */
public interface JvmExecutable extends JvmFeature, JvmTypeParameterDeclarator
{
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable_Parameters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable_Exceptions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<JvmTypeReference> getExceptions();

	/**
	 * Returns the value of the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Args</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Args</em>' attribute.
	 * @see #setVarArgs(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmExecutable_VarArgs()
	 * @model
	 * @generated
	 */
	boolean isVarArgs();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmExecutable#isVarArgs <em>Var Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Args</em>' attribute.
	 * @see #isVarArgs()
	 * @generated
	 */
	void setVarArgs(boolean value);

} // JvmExecutable
