package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.JvmDeclaredTypeSignatureHashProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * The remaining tests are in xtend.core.tests, as it is a lot easier to specify JvmModels in Xtend ;-)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeSignatureHashTest extends AbstractXbaseTestCase {
  @Inject
  private JvmDeclaredTypeSignatureHashProvider _jvmDeclaredTypeSignatureHashProvider;
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Test
  public void testSubType() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmMember> _members = it.getMembers();
          TypeSignatureHashTest.this._jvmTypesBuilder.<JvmGenericType>operator_add(_members, bar);
        }
      };
    final JvmGenericType foo = this._jvmTypesBuilder.toClass(eObject, "Foo", _function);
    final String hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    EList<JvmMember> _members = bar.getMembers();
    final Procedure1<JvmConstructor> _function_1 = new Procedure1<JvmConstructor>() {
        public void apply(final JvmConstructor it) {
        }
      };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(eObject, _function_1);
    this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
    String _hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    Assert.assertEquals(hash, _hash);
    bar.setSimpleName("Baz");
    String _hash_1 = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    boolean _equal = Strings.equal(hash, _hash_1);
    Assert.assertFalse("Expected different hashes", _equal);
  }
  
  @Test
  public void testUnsealedType() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    String _hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(bar);
    boolean _equal = Strings.equal("Bar", _hash);
    Assert.assertFalse(_equal);
  }
  
  @Test
  public void testSealedType() {
    try {
      final XExpression e = this.expression("null");
      JvmType _findDeclaredType = this._typeReferences.findDeclaredType(String.class, e);
      String _hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(((JvmDeclaredType) _findDeclaredType));
      Assert.assertEquals("java.lang.String", _hash);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
