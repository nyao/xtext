/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.IRichStringIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.IRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidatingRichStringAcceptor extends AbstractRichStringPartAcceptor.ForLoopOnce implements IRichStringIndentationHandler {

	private final ValidationMessageAcceptor acceptor;
	private int currentOffset = -1;
	private RichStringLiteral recent = null;
	private RichStringLiteral root = null;
	private LinkedList<String> indentationStack;
	private String unfulfilledIndentationExpectation = null;
	private int lastOffsetOfLiteral = -1;
	
	public ValidatingRichStringAcceptor(ValidationMessageAcceptor acceptor) {
		this.acceptor = acceptor;
		this.indentationStack = Lists.newLinkedList();
	}

	@Override
	public void announceNextLiteral(RichStringLiteral object) {
		resetCurrentOffset(object);
	}

	@Override
	public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
		resetCurrentOffset(origin);
		currentOffset += text.length();
	}

	protected void resetCurrentOffset(RichStringLiteral origin) {
		if (root == null)
			root = origin;
		if (origin != null && origin != recent) {
			// no actions are involved, we are interested in the real node
			recent = origin;
			List<INode> featureNodes = NodeModelUtils.findNodesForFeature(origin,
					XbasePackage.Literals.XSTRING_LITERAL__VALUE);
			if (featureNodes.size() == 1) {
				INode node = featureNodes.get(0);
				currentOffset = node.getOffset();
				String nodeText = node.getText();
				if (nodeText.endsWith("'''")) {
					lastOffsetOfLiteral = currentOffset + node.getLength() - 3;
				}
				if (nodeText.charAt(0) == '\'') {
					currentOffset += 3;
				} else {
					currentOffset += 1;
				}
			}
		}
	}

	@Override
	public void acceptTemplateText(CharSequence text, RichStringLiteral origin) {
		resetCurrentOffset(origin);
		currentOffset += text.length();
	}

	@Override
	public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
		resetCurrentOffset(origin);
		currentOffset += charCount;
	}

	@Override
	public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		resetCurrentOffset(origin);
		currentOffset += charCount;
	}

	public void pushTemplateIndentation(CharSequence completeIndentation) {
		pushIndentation(completeIndentation);
	}

	public void pushSemanticIndentation(CharSequence completeIndentation) {
		pushIndentation(completeIndentation);
	}

	protected void pushIndentation(CharSequence completeIndentation) {
		if (indentationStack.isEmpty()) {
			indentationStack.add(completeIndentation.toString());
		} else {
			String indentationString = completeIndentation.toString();
			String previous = indentationStack.getLast();
			if (!indentationString.startsWith(previous)) {
				unfulfilledIndentationExpectation = previous;
			}
			indentationStack.add(indentationString);
		}
	}

	public void popIndentation() {
		indentationStack.removeLast();
	}

	public void accept(IRichStringPartAcceptor acceptor) {
		if (indentationStack.isEmpty())
			return;
		String indentation = indentationStack.getLast();
		if (unfulfilledIndentationExpectation != null) {
			if (currentOffset + indentation.length() != lastOffsetOfLiteral) {
				this.acceptor.acceptWarning("Inconsistent indentation", root, currentOffset, indentation.length(), 
						IssueCodes.INCONSISTENT_INDENTATION, unfulfilledIndentationExpectation);
			}
			unfulfilledIndentationExpectation = null;
		}
		currentOffset+=indentation.length();
	}

	public CharSequence getTotalSemanticIndentation() {
		return "";
	}
	
	public CharSequence getTotalIndentation() {
		if (indentationStack.isEmpty())
			return "";
		return indentationStack.getLast();
	}

}