/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.Method;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.lib.Functions.FunctionX;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureInvocationHandler extends AbstractClosureInvocationHandler {

	private final IExpressionInterpreter interpreter;

	private final IEvaluationContext context;
	
	private final XClosure closure;

	private CancelIndicator indicator;
	
	public ClosureInvocationHandler(XClosure closure, IEvaluationContext context, IExpressionInterpreter interpreter, CancelIndicator indicator) {
		this.closure = closure;
		this.context = context;
		this.interpreter = interpreter;
		this.indicator = indicator;
	}
	
	@Override
	protected Object doInvoke(Method method, Object[] args) throws Throwable {
		IEvaluationContext forkedContext = context.fork();
		if (args != null) {
			if (!FunctionX.class.equals(method.getDeclaringClass())) {
				initializeClosureParameters(forkedContext, args);
			} else {
				initializeClosureParameters(forkedContext, (Object[])args[0]);
			}
		}
		IEvaluationResult result = interpreter.evaluate(closure.getExpression(), forkedContext, indicator);
		return result.getResult();
	}

	protected void initializeClosureParameters(IEvaluationContext context, Object[] args) {
		if (args.length != closure.getFormalParameters().size())
			throw new IllegalStateException("Number of arguments did not match. Expected: " + 
					closure.getFormalParameters().size() + " but was: " + args.length);
		int i = 0;
		for(JvmFormalParameter param: closure.getFormalParameters()) {
			context.newValue(QualifiedName.create(param.getName()), args[i]);
			i++;
		}
	}
	
	@Override
	protected String proxyToString(Object proxy) {
		Class<?> interfaceType = proxy.getClass().getInterfaces()[0];
		return "Proxy for " + interfaceType.getName() + ": "+ closure.toString();
	}

}