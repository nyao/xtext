/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;

import com.google.inject.internal.Lists;

/**
 * The NodeModelUtils are a collection of useful methods when dealing with the node model directly. They encapsulate the
 * default construction semantics of the node model as it is created by the parser.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelUtils {

	/**
	 * Find the leaf node at the given offset. May return <code>null</code> if the given offset is not valid for the
	 * node (sub-)tree.
	 */
	public static ILeafNode findLeafNodeAtOffset(INode node, int leafNodeOffset) {
		int offset = node.getTotalOffset();
		int length = node.getTotalLength();
		BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) node).basicIterator();
		if (leafNodeOffset > (offset + length) / 2) {
			while (iterator.hasPrevious()) {
				AbstractNode previous = iterator.previous();
				int previousOffset = previous.getTotalOffset();
				int previousLength = previous.getTotalLength();
				if (!intersects(previousOffset, previousLength, leafNodeOffset)) {
					if (previousOffset + previousLength <= leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (previous instanceof ILeafNode)
						return (ILeafNode) previous;
				}
			}
		} else {
			while (iterator.hasNext()) {
				AbstractNode next = iterator.next();
				int nextOffset = next.getTotalOffset();
				int nextLength = next.getTotalLength();
				if (!intersects(nextOffset, nextLength, leafNodeOffset)) {
					if (nextOffset > leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (next instanceof ILeafNode)
						return (ILeafNode) next;
				}
			}
		}
		return null;
	}

	private static boolean intersects(int offset, int length, int lookupOffset) {
		if (offset <= lookupOffset && offset + length > lookupOffset)
			return true;
		return false;
	}

	/**
	 * @return the node that is directly associated with the given object by means of an EMF-Adapter.
	 * @see NodeModelUtils#findActualNodeFor(EObject)
	 */
	public static ICompositeNode getNode(EObject object) {
		if (object == null)
			return null;
		for (Adapter adapter : object.eAdapters()) {
			if (adapter instanceof ICompositeNode)
				return (ICompositeNode) adapter;
		}
		return null;
	}

	/**
	 * @return the list of nodes that were used to assign values to the given feature for the given object.
	 */
	public static List<INode> findNodesForFeature(EObject semanticObject, EStructuralFeature structuralFeature) {
		ICompositeNode node = findActualNodeFor(semanticObject);
		if (node != null) {
			return findNodesForFeature(semanticObject, node, structuralFeature);
		}
		return Collections.emptyList();
	}

	public static List<INode> findNodesForFeature(EObject semanticElement, INode node,
			EStructuralFeature structuralFeature) {
		List<INode> result = Lists.newArrayList();
		String featureName = structuralFeature.getName();
		BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
		while (iterator.hasNext()) {
			INode child = iterator.next();
			EObject grammarElement = child.getGrammarElement();
			if (grammarElement != null) {
				if (grammarElement instanceof Action) {
					Action action = (Action) grammarElement;
					if (child.getSemanticElement() == semanticElement) {
						child = iterator.next();
						if (featureName.equals(action.getFeature())) {
							result.add(child);
						}
					} else {
						// navigate the action's left side (first child) until we find an assignment (a rule call)
						// the assignment will tell us about the feature to which we assigned
						// the semantic object that has been created by the action
						INode firstChild = ((ICompositeNode) child).getFirstChild();
						while (firstChild.getGrammarElement() instanceof Action) {
							firstChild = ((ICompositeNode) firstChild).getFirstChild();
						}
						EObject firstChildGrammarElement = firstChild.getGrammarElement();
						Assignment assignment = GrammarUtil.containingAssignment(firstChildGrammarElement);
						if (assignment != null && featureName.equals(assignment.getFeature())) {
							result.add(child);
						}
					}
					iterator.prune();
				} else if (child != node) {
					Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
					if (assignment != null) {
						if (featureName.equals(assignment.getFeature())) {
							result.add(child);
						}
						iterator.prune();
					}
				}
			}
		}
		return result;
	}

	/**
	 * @return the node that covers all assigned values of the given object. It handles {@link Action Actions} and
	 *         {@link RuleCall unassigned rule calls}.
	 */
	public static ICompositeNode findActualNodeFor(EObject semanticObject) {
		ICompositeNode node = getNode(semanticObject);
		if (node != null) {
			while (node.getParent() != null && !node.getParent().hasDirectSemanticElement()) {
				node = node.getParent();
			}
		}
		return node;
	}

	/**
	 * @return the semantic object that is really associated with the actual container node of the given node. It
	 *         handles {@link Action Actions} and {@link RuleCall unassigned rule calls}.
	 */
	public static EObject findActualSemanticObjectFor(INode node) {
		if (node == null)
			return null;
		if (node.hasDirectSemanticElement())
			return node.getSemanticElement();
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement == null)
			return findActualSemanticObjectFor(node.getParent());
		Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
		if (assignment != null) {
			return findActualSemanticObjectFor(node.getParent());
		} else {
			EObject result = findActualSemanticObjectInChildren(node, grammarElement);
			if (result != null)
				return result;
		}
		return findActualSemanticObjectFor(node.getParent());
	}
	
	private static EObject findActualSemanticObjectInChildren(INode node, EObject grammarElement) {
		if (node.hasDirectSemanticElement())
			return node.getSemanticElement();
		AbstractRule rule = null;
		if (grammarElement instanceof RuleCall) {
			rule = ((RuleCall) grammarElement).getRule();
		} else if (grammarElement instanceof AbstractRule) {
			rule = (AbstractRule) grammarElement;
		}
		if (rule instanceof ParserRule && !GrammarUtil.isDatatypeRule(rule)) {
			if (node instanceof ICompositeNode) {
				for (INode child : ((ICompositeNode) node).getChildren()) {
					if (child instanceof ICompositeNode) {
						EObject childGrammarElement = child.getGrammarElement();
						if (childGrammarElement instanceof Action) {
							EObject result = findActualSemanticObjectInChildren(child, childGrammarElement);
							if (result != null)
								return result;
						} else if (childGrammarElement instanceof RuleCall) {
							RuleCall childRuleCall = (RuleCall) childGrammarElement;
							if (childRuleCall.getRule() instanceof ParserRule
									&& !GrammarUtil.isDatatypeRule(childRuleCall.getRule())) {
								EObject result = findActualSemanticObjectInChildren(child, childRuleCall);
								if (result != null)
									return result;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static String compactDump(INode node, boolean showHidden) {
		StringBuilder result = new StringBuilder();
		try {
			compactDump(node, showHidden, "", result);
		} catch (IOException e) {
			return e.getMessage();
		}
		return result.toString();
	}

	public static void compactDump(INode node, boolean showHidden, String prefix, Appendable result) throws IOException {
		if (!showHidden && node instanceof ILeafNode && ((ILeafNode) node).isHidden())
			return;
		if (prefix.length() != 0) {
			result.append("\n");
			result.append(prefix);
		}
		if (node instanceof ICompositeNode) {
			result.append(new GrammarElementTitleSwitch().doSwitch(node.getGrammarElement()));
			String newPrefix = prefix + "  ";
			result.append(" {");
			BidiIterator<INode> children = ((ICompositeNode) node).getChildren().iterator();
			while (children.hasNext()) {
				INode child = children.next();
				compactDump(child, showHidden, newPrefix, result);
			}
			result.append("\n");
			result.append(prefix);
			result.append("}");
		} else if (node instanceof ILeafNode) {
			if (((ILeafNode) node).isHidden())
				result.append("hidden ");
			result.append(new GrammarElementTitleSwitch().doSwitch(node.getGrammarElement()));
			result.append(" => '");
			result.append(node.getText());
			result.append("'");
		} else if (node == null) {
			result.append("(null)");
		} else {
			result.append("unknown type ");
			result.append(node.getClass().getName());
		}
	}

	public static String getTextWithoutHidden(INode node) {
		if (node instanceof ILeafNode) {
			ILeafNode ln = (ILeafNode) node;
			return ln.isHidden() ? "" : ln.getText();
		}
		BidiIterator<INode> it = node.getAsTreeIterable().iterator();
		StringBuilder result = new StringBuilder();
		while (it.hasNext()) {
			INode next = it.next();
			if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
				result.append(((ILeafNode) next).getText());
		}
		return result.toString();
	}

}