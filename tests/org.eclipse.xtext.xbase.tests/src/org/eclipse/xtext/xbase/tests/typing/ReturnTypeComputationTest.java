/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ReturnTypeComputationTest extends AbstractXbaseTestCase {
	@Inject
	private ITypeProvider typeProvider;
	
	public void testReturnType_00() throws Exception {
		assertReturnType("java.lang.String", "return 'foo'");
	}
	
	public void testReturnType_01() throws Exception {
		assertReturnType("void", "'foo'");
	}
	
	public void testReturnType_02() throws Exception {
		assertReturnType("java.lang.Void", "return null");
	}
	
	public void testReturnType_03() throws Exception {
		assertReturnType("void", "[| return e]");
	}
	
	public void testReturnType_04() throws Exception {
		assertReturnType("void", "{ [| return '']}");
	}
	
	public void testReturnType_05() throws Exception {
		assertReturnType("org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>", "return [| '']");
	}
	
	public void testReturnType_06() throws Exception {
		assertReturnType("org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>", "return [| return '']");
	}
	
	public void testReturnType_07() throws Exception {
		assertReturnType("java.lang.Object", "if (true) return 'x' else return new Object()");
	}
	
	public void testReturnType_08() throws Exception {
		assertReturnType("java.lang.Object", "if (true) return 'x' else return new Object()");
	}
	
	public void testReturnType_09() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.Object", "if (true) return 'x' else [|'x']");
	}
	
	public void testReturnType_10() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.String", "if (true) return 'x' else 'y'");
	}
	
	public void testReturnType_11() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.Object", 
				"{" +
				" val x = [|if (true) return 'y' else new Object()]" +
				" x.apply()" +
				"}");
	}
	
	public void testReturnType_12() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.String", 
				"{" +
				" val x = [|if (true) return 'y' else 'x']" +
				" x.apply()" +
		"}");
	}
	
	public void testThrownTypes_00() throws Exception {
		assertThrownTypes("throw new RuntimeException()", RuntimeException.class.getName());
	}
	
	public void testThrownTypes_01() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else throw new IllegalArgumentException() }", 
				IllegalArgumentException.class.getName(), 
				RuntimeException.class.getName());
	}
	
	public void testThrownTypes_02() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else [|throw new IllegalArgumentException()] }", 
				RuntimeException.class.getName());
	}
	
	public void testThrownTypes_03() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {}", 
				RuntimeException.class.getName());
	}
	
	public void testThrownTypes_04() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"}", 
				NullPointerException.class.getName(),
				RuntimeException.class.getName());
	}
	
	public void testThrownTypes_05() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"} catch (NullPointerException e) {" + 
				"} catch (RuntimeException e) {}", 
				NullPointerException.class.getName());
	}
	
	public void testThrownTypes_06() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"} catch (NullPointerException e) {" + 
				"} catch (RuntimeException e) {" +
				"} finally {" +
				"  throw new UnsupportedOperationException()" +
				"}", 
				NullPointerException.class.getName(),
				UnsupportedOperationException.class.getName());
	}
	
	public void testThrownTypes_07() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else throw new RuntimeException() }", 
				RuntimeException.class.getName());
	}
	
	public void testThrownTypes_08() throws Exception {
		assertThrownTypes("(null as java.io.InputStream).read()", 
				IOException.class.getName());
	}
	
	protected void assertThrownTypes(String expression, String...thrownTypes) throws Exception {
		final XExpression expr = expression(expression);
		final Iterable<JvmTypeReference> thrown = typeProvider.getThrownExceptionTypes(expr);
		ArrayList<String> actual = newArrayList(transform(thrown, new Function<JvmTypeReference, String>() {
			public String apply(JvmTypeReference from) {
				return from.getIdentifier();
			}
		}));
		ArrayList<String> expected = newArrayList(Arrays.asList(thrownTypes));
		Collections.sort(actual);
		Collections.sort(expected);
		assertEquals(expected.toString(), actual.toString());
	}
		
	public void assertReturnTypeWithImplictReturnExpression(String expected, String expression) throws Exception {
		final XExpression expr = expression(expression);
		final JvmTypeReference returnType = typeProvider.getCommonReturnType(expr, true);
		assertEquals(expected,returnType.getIdentifier());
	}
	
	public void assertReturnType(String expected, String expression) throws Exception {
		final XExpression expr = expression(expression);
		final JvmTypeReference returnType = typeProvider.getCommonReturnType(expr, false);
		assertEquals(expected,returnType.getIdentifier());
	}
}