/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.contextFinderTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextFinderTestFactoryImpl extends EFactoryImpl implements ContextFinderTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ContextFinderTestFactory init()
  {
    try
    {
      ContextFinderTestFactory theContextFinderTestFactory = (ContextFinderTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/contextfindertestlanguage"); 
      if (theContextFinderTestFactory != null)
      {
        return theContextFinderTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ContextFinderTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ContextFinderTestPackage.MODEL: return createModel();
      case ContextFinderTestPackage.ATTRIBUTE_EXCLUSION_TEST: return createAttributeExclusionTest();
      case ContextFinderTestPackage.NESTED_TYPE_TEST: return createNestedTypeTest();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD: return createNestedTypeChild();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD1: return createNestedTypeChild1();
      case ContextFinderTestPackage.NESTED_TYPE_CHILD2: return createNestedTypeChild2();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST: return createNestedTypeRecursiveTest();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST1: return createNestedTypeRecursiveTest1();
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST2: return createNestedTypeRecursiveTest2();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeExclusionTest createAttributeExclusionTest()
  {
    AttributeExclusionTestImpl attributeExclusionTest = new AttributeExclusionTestImpl();
    return attributeExclusionTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeTest createNestedTypeTest()
  {
    NestedTypeTestImpl nestedTypeTest = new NestedTypeTestImpl();
    return nestedTypeTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild createNestedTypeChild()
  {
    NestedTypeChildImpl nestedTypeChild = new NestedTypeChildImpl();
    return nestedTypeChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild1 createNestedTypeChild1()
  {
    NestedTypeChild1Impl nestedTypeChild1 = new NestedTypeChild1Impl();
    return nestedTypeChild1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeChild2 createNestedTypeChild2()
  {
    NestedTypeChild2Impl nestedTypeChild2 = new NestedTypeChild2Impl();
    return nestedTypeChild2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest createNestedTypeRecursiveTest()
  {
    NestedTypeRecursiveTestImpl nestedTypeRecursiveTest = new NestedTypeRecursiveTestImpl();
    return nestedTypeRecursiveTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest1 createNestedTypeRecursiveTest1()
  {
    NestedTypeRecursiveTest1Impl nestedTypeRecursiveTest1 = new NestedTypeRecursiveTest1Impl();
    return nestedTypeRecursiveTest1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest2 createNestedTypeRecursiveTest2()
  {
    NestedTypeRecursiveTest2Impl nestedTypeRecursiveTest2 = new NestedTypeRecursiveTest2Impl();
    return nestedTypeRecursiveTest2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestPackage getContextFinderTestPackage()
  {
    return (ContextFinderTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ContextFinderTestPackage getPackage()
  {
    return ContextFinderTestPackage.eINSTANCE;
  }

} //ContextFinderTestFactoryImpl