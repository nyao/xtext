/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class TypeConformanceValidatorTest extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	public void testIfPredicate() throws Exception {
		assertNoConformanceError("if (true) 'foo'");
		assertConformanceError("if (27) 'foo'", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Boolean");
	}

	public void testWhilePredicate() throws Exception {
		assertNoConformanceError("while (true) 'foo'");
		assertConformanceError("while (27) 'foo'", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Boolean");
		assertNoConformanceError("do 'foo' while (true)");
		assertConformanceError("do 'foo' while ('bar')", XbasePackage.Literals.XSTRING_LITERAL, "java.lang.String",
				"java.lang.Boolean");
	}

	public void testCast_00() throws Exception {
		assertNoConformanceError("'foo' as Object");
	}

	public void testCast_01() throws Exception {
		assertCastError("'foo' as Boolean", XbasePackage.Literals.XCASTED_EXPRESSION, "Cannot", "Boolean");
	}

	public void testCast_02() throws Exception {
		assertCastError("new NullPointerException() as StringBuilder", XbasePackage.Literals.XCASTED_EXPRESSION,
				"cannot", "StringBuilder");
	}

	public void testCast_03() throws Exception {
		assertNoConformanceError("new NullPointerException() as CharSequence");
	}

	public void testCast_04() throws Exception {
		// class MyNPE extends NullPointerException implements CharSequence {}
		// TODO: should we check the actual type in case the a casted expression
		// is an upcast?
		assertNoConformanceError("('foo' as CharSequence) as NullPointerException");
	}

	public void testCast_05() throws Exception {
		assertCastError("('foo' as CharSequence) as Integer", XbasePackage.Literals.XCASTED_EXPRESSION, "cannot",
				"CharSequence", "Integer");
	}

	public void testVariableDeclaration() throws Exception {
		assertNoConformanceError("{ var s = 'foo' }");
		assertNoConformanceError("{ var java.lang.String s = 'foo' }");
		assertConformanceError("{ var java.lang.Boolean s = 'foo' }", XbasePackage.Literals.XSTRING_LITERAL,
				"java.lang.Boolean", "java.lang.String");
	}

	public void testCatchClause() throws Exception {
		assertNoConformanceError("try 'foo' catch (java.lang.Exception foo) 'bar'");
		assertNoConformanceError("try 'foo' catch (java.lang.IllegalArgumentException foo) 'bar'");
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'",
				TypesPackage.Literals.JVM_FORMAL_PARAMETER, "Throwable", "java.lang.String");
	}

	public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Throwable");
	}

	public void testForLoop() throws Exception {
		assertNoConformanceError("for(String foo : new java.util.ArrayList<String>()) 'bar'");
		assertConformanceError("for(Integer foo : true) 'bar'", XbasePackage.Literals.XBOOLEAN_LITERAL,
				"java.lang.Boolean", "java.lang.Integer");
		assertConformanceError("for(Integer foo : new java.util.ArrayList<String>()) 'bar'",
				XbasePackage.Literals.XCONSTRUCTOR_CALL, "java.lang.Iterable<? extends java.lang.Integer>",
				"java.util.ArrayList<java.lang.String>");
	}

	protected void assertConformanceError(String expression, EClass objectType, String... messageParts)
			throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INCOMPATIBLE_TYPES, messageParts);
	}

	protected void assertCastError(String expression, EClass objectType, String... messageParts) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INVALID_CAST, messageParts);
	}

	protected void assertNoConformanceError(String expression) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertNoError(xExpression, INCOMPATIBLE_TYPES);
	}

}