/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.splitting;

import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.Expression;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.util.SimpleExpressionsSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConditionSimplifier extends SimpleExpressionsSwitch<Expression>{

	public void simplify(IfCondition condition) {
		Expression expression = simplifyRecursive(condition.getCondition());
		condition.setCondition(expression);
	}

	public Expression simplifyRecursive(Expression expression) {
		return doSwitch(expression);
	}

	@Override
	public Expression caseAndExpression(AndExpression object) {
		if (object.getRight() == null)
			return doSwitch(object.getLeft());
		if (object.getLeft() == null)
			return doSwitch(object.getRight());
		Expression left = doSwitch(object.getLeft());
		Expression right = doSwitch(object.getRight());
		if (areSemanticallyEqual(left, right))
			return left;
		object.setLeft(left);
		object.setRight(right);
		return object;
	}

	@Override
	public Expression caseOrExpression(OrExpression object) {
		if (object.getRight() == null)
			return doSwitch(object.getLeft());
		if (object.getLeft() == null)
			return doSwitch(object.getRight());
		Expression left = doSwitch(object.getLeft());
		Expression right = doSwitch(object.getRight());
		if (areSemanticallyEqual(left, right))
			return left;
		if (left instanceof AndExpression) {
			AndExpression leftAsAnd = (AndExpression) left;
			if (areSemanticallyEqual(leftAsAnd.getLeft(), right)
				|| areSemanticallyEqual(leftAsAnd.getRight(), right))
				return right;
		} else if (right instanceof AndExpression) {
			AndExpression rightAsAnd = (AndExpression) right;
			if (areSemanticallyEqual(rightAsAnd.getLeft(), left)
				|| areSemanticallyEqual(rightAsAnd.getRight(), left))
				return left;
		}
		if (left instanceof OrExpression) {
			OrExpression leftAsOr = (OrExpression) left;
			if (areSemanticallyEqual(leftAsOr.getLeft(), right)
				|| areSemanticallyEqual(leftAsOr.getRight(), right))
				return left;
		} else if (right instanceof OrExpression) {
			OrExpression rightAsOr = (OrExpression) right;
			if (areSemanticallyEqual(rightAsOr.getLeft(), left)
				|| areSemanticallyEqual(rightAsOr.getRight(), left))
				return right;
		}
		object.setLeft(left);
		object.setRight(right);
		return object;
	}

	@Override
	public Expression caseNotExpression(NotExpression object) {
		if (object.getExpression() instanceof NotExpression)
			return doSwitch(((NotExpression) object.getExpression()).getExpression());
		object.setExpression(doSwitch(object.getExpression()));
		return object;
	}

	@Override
	public Expression caseExpression(Expression object) {
		return object;
	}

	public boolean areSemanticallyEqual(Expression left, Expression right) {
		if (left.eClass() != right.eClass())
			return false;
		if (left instanceof OrExpression) {
			OrExpression leftOrExpression = (OrExpression) left;
			OrExpression rightOrExpression = (OrExpression) right;
			return (areSemanticallyEqual(leftOrExpression.getLeft(), rightOrExpression.getLeft())
				&& areSemanticallyEqual(leftOrExpression.getRight(), rightOrExpression.getRight()))
				|| (areSemanticallyEqual(leftOrExpression.getRight(), rightOrExpression.getLeft())
				&& areSemanticallyEqual(leftOrExpression.getLeft(), rightOrExpression.getRight()));
		}
		if (left instanceof AndExpression) {
			AndExpression leftAndExpression = (AndExpression) left;
			AndExpression rightAndExpression = (AndExpression) right;
			return (areSemanticallyEqual(leftAndExpression.getLeft(), rightAndExpression.getLeft())
				&& areSemanticallyEqual(leftAndExpression.getRight(), rightAndExpression.getRight()))
				|| (areSemanticallyEqual(leftAndExpression.getRight(), rightAndExpression.getLeft())
				&& areSemanticallyEqual(leftAndExpression.getLeft(), rightAndExpression.getRight()));
		}
		if (left instanceof NotExpression) {
			return areSemanticallyEqual(((NotExpression) left).getExpression(), ((NotExpression) right).getExpression());
		}
		if (left instanceof Comparison) {
			Comparison leftComparison = (Comparison) left;
			Comparison rightComparison = (Comparison) right;
			return ((Comparison) left).getOperator().equals(rightComparison.getOperator())
				&& areSemanticallyEqual(leftComparison.getLeft(), rightComparison.getLeft())
				&& areSemanticallyEqual(leftComparison.getRight(), rightComparison.getRight());
		}
		if (left instanceof NumberLiteral) {
			int leftValue = ((NumberLiteral) left).getValue();
			int rightValue = ((NumberLiteral) right).getValue();
			return leftValue == rightValue;
		}
		if (left instanceof MethodCall) {
			String leftMethod = ((MethodCall) left).getValue();
			String rightMethod = ((MethodCall) right).getValue();
			return leftMethod.equals(rightMethod);
		}
		throw new IllegalStateException(left + " - " + right);
	}

}
