/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.serializer.syntacticsequencertest.Add0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Add1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Add2;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Exp2;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.Mult2;
import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestFactory;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyntacticsequencertestPackageImpl extends EPackageImpl implements SyntacticsequencertestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mandatoryKeywordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exp0EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exp1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exp2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleCrossReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass add0EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass val0EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass add1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass val1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass add2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mult2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass val2EClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SyntacticsequencertestPackageImpl()
  {
    super(eNS_URI, SyntacticsequencertestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SyntacticsequencertestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SyntacticsequencertestPackage init()
  {
    if (isInited) return (SyntacticsequencertestPackage)EPackage.Registry.INSTANCE.getEPackage(SyntacticsequencertestPackage.eNS_URI);

    // Obtain or create and register package
    SyntacticsequencertestPackageImpl theSyntacticsequencertestPackage = (SyntacticsequencertestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SyntacticsequencertestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SyntacticsequencertestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSyntacticsequencertestPackage.createPackageContents();

    // Initialize created meta-data
    theSyntacticsequencertestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSyntacticsequencertestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SyntacticsequencertestPackage.eNS_URI, theSyntacticsequencertestPackage);
    return theSyntacticsequencertestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X1()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X2()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X3()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X4()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X5()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMandatoryKeywords()
  {
    return mandatoryKeywordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryKeywords_Val1()
  {
    return (EAttribute)mandatoryKeywordsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryKeywords_Val2()
  {
    return (EAttribute)mandatoryKeywordsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMandatoryKeywords_Val3()
  {
    return (EAttribute)mandatoryKeywordsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExp0()
  {
    return exp0EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExp1()
  {
    return exp1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExp2()
  {
    return exp2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleCrossReference()
  {
    return singleCrossReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleCrossReference_Name()
  {
    return (EAttribute)singleCrossReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleCrossReference_Ref1()
  {
    return (EReference)singleCrossReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleCrossReference_Ref2()
  {
    return (EReference)singleCrossReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleCrossReference_Ref3()
  {
    return (EReference)singleCrossReferenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleCrossReference_Ref4()
  {
    return (EReference)singleCrossReferenceEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdd0()
  {
    return add0EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd0_Left()
  {
    return (EReference)add0EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd0_Right()
  {
    return (EReference)add0EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVal0()
  {
    return val0EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVal0_Name()
  {
    return (EAttribute)val0EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdd1()
  {
    return add1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd1_Left()
  {
    return (EReference)add1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd1_Right()
  {
    return (EReference)add1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVal1()
  {
    return val1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVal1_Name()
  {
    return (EAttribute)val1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdd2()
  {
    return add2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd2_Left()
  {
    return (EReference)add2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdd2_Right()
  {
    return (EReference)add2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMult2()
  {
    return mult2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMult2_Left()
  {
    return (EReference)mult2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMult2_Right()
  {
    return (EReference)mult2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVal2()
  {
    return val2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVal2_Name()
  {
    return (EAttribute)val2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyntacticsequencertestFactory getSyntacticsequencertestFactory()
  {
    return (SyntacticsequencertestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__X1);
    createEReference(modelEClass, MODEL__X2);
    createEReference(modelEClass, MODEL__X3);
    createEReference(modelEClass, MODEL__X4);
    createEReference(modelEClass, MODEL__X5);

    mandatoryKeywordsEClass = createEClass(MANDATORY_KEYWORDS);
    createEAttribute(mandatoryKeywordsEClass, MANDATORY_KEYWORDS__VAL1);
    createEAttribute(mandatoryKeywordsEClass, MANDATORY_KEYWORDS__VAL2);
    createEAttribute(mandatoryKeywordsEClass, MANDATORY_KEYWORDS__VAL3);

    exp0EClass = createEClass(EXP0);

    exp1EClass = createEClass(EXP1);

    exp2EClass = createEClass(EXP2);

    singleCrossReferenceEClass = createEClass(SINGLE_CROSS_REFERENCE);
    createEAttribute(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__NAME);
    createEReference(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__REF1);
    createEReference(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__REF2);
    createEReference(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__REF3);
    createEReference(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__REF4);

    add0EClass = createEClass(ADD0);
    createEReference(add0EClass, ADD0__LEFT);
    createEReference(add0EClass, ADD0__RIGHT);

    val0EClass = createEClass(VAL0);
    createEAttribute(val0EClass, VAL0__NAME);

    add1EClass = createEClass(ADD1);
    createEReference(add1EClass, ADD1__LEFT);
    createEReference(add1EClass, ADD1__RIGHT);

    val1EClass = createEClass(VAL1);
    createEAttribute(val1EClass, VAL1__NAME);

    add2EClass = createEClass(ADD2);
    createEReference(add2EClass, ADD2__LEFT);
    createEReference(add2EClass, ADD2__RIGHT);

    mult2EClass = createEClass(MULT2);
    createEReference(mult2EClass, MULT2__LEFT);
    createEReference(mult2EClass, MULT2__RIGHT);

    val2EClass = createEClass(VAL2);
    createEAttribute(val2EClass, VAL2__NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    add0EClass.getESuperTypes().add(this.getExp0());
    val0EClass.getESuperTypes().add(this.getExp0());
    add1EClass.getESuperTypes().add(this.getExp1());
    val1EClass.getESuperTypes().add(this.getExp1());
    add2EClass.getESuperTypes().add(this.getExp2());
    mult2EClass.getESuperTypes().add(this.getExp2());
    val2EClass.getESuperTypes().add(this.getExp2());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_X1(), this.getMandatoryKeywords(), null, "x1", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X2(), this.getExp0(), null, "x2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X3(), this.getExp1(), null, "x3", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X4(), this.getExp2(), null, "x4", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X5(), this.getSingleCrossReference(), null, "x5", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mandatoryKeywordsEClass, MandatoryKeywords.class, "MandatoryKeywords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMandatoryKeywords_Val1(), ecorePackage.getEString(), "val1", null, 0, 1, MandatoryKeywords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryKeywords_Val2(), ecorePackage.getEString(), "val2", null, 0, 1, MandatoryKeywords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMandatoryKeywords_Val3(), ecorePackage.getEString(), "val3", null, 0, 1, MandatoryKeywords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exp0EClass, Exp0.class, "Exp0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exp1EClass, Exp1.class, "Exp1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exp2EClass, Exp2.class, "Exp2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(singleCrossReferenceEClass, SingleCrossReference.class, "SingleCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleCrossReference_Name(), ecorePackage.getEString(), "name", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleCrossReference_Ref1(), this.getSingleCrossReference(), null, "ref1", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleCrossReference_Ref2(), this.getSingleCrossReference(), null, "ref2", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleCrossReference_Ref3(), this.getSingleCrossReference(), null, "ref3", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleCrossReference_Ref4(), this.getSingleCrossReference(), null, "ref4", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(add0EClass, Add0.class, "Add0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdd0_Left(), this.getExp0(), null, "left", null, 0, 1, Add0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdd0_Right(), this.getExp0(), null, "right", null, 0, 1, Add0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(val0EClass, Val0.class, "Val0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVal0_Name(), ecorePackage.getEString(), "name", null, 0, 1, Val0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(add1EClass, Add1.class, "Add1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdd1_Left(), this.getExp1(), null, "left", null, 0, 1, Add1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdd1_Right(), this.getExp1(), null, "right", null, 0, 1, Add1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(val1EClass, Val1.class, "Val1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVal1_Name(), ecorePackage.getEString(), "name", null, 0, 1, Val1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(add2EClass, Add2.class, "Add2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdd2_Left(), this.getExp2(), null, "left", null, 0, 1, Add2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdd2_Right(), this.getExp2(), null, "right", null, 0, 1, Add2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mult2EClass, Mult2.class, "Mult2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMult2_Left(), this.getExp2(), null, "left", null, 0, 1, Mult2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMult2_Right(), this.getExp2(), null, "right", null, 0, 1, Mult2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(val2EClass, Val2.class, "Val2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVal2_Name(), ecorePackage.getEString(), "name", null, 0, 1, Val2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SyntacticsequencertestPackageImpl