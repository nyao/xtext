/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynEmitterState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.acceptor.IUnassignedTokenSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencer extends AbstractSyntacticSequencer {

	@Override
	protected void transition(ISynTransition transition, INode fromNode, INode toNode, RCStack stack,
			IUnassignedTokenSequenceAcceptor tokenAcceptor, Acceptor errorAcceptor) {
		if (!transition.hasEmitters())
			return;
		if (transition.isSyntacticallyAmbiguous())
			ambiguousTransition(transition, fromNode, toNode, stack, tokenAcceptor, errorAcceptor);
	}

	protected void ambiguousTransition(ISynTransition transition, INode fromNode, INode toNode, RCStack stack,
			IUnassignedTokenSequenceAcceptor tokenAcceptor, Acceptor errorAcceptor) {
		acceptNodes(transition, fromNode, toNode, stack.clone(), tokenAcceptor);
	}

	protected void acceptNode(INode node, IUnassignedTokenSequenceAcceptor tokenAcceptor) {
		Object ge = node.getGrammarElement();
		if (ge instanceof Keyword)
			tokenAcceptor.acceptUnassignedKeyword((Keyword) ge, (ILeafNode) node);
		else if (ge instanceof RuleCall) {
			RuleCall rc = (RuleCall) ge;
			if (rc.getRule() instanceof TerminalRule)
				tokenAcceptor.acceptUnassignedTerminal(rc, node.getText(), (ILeafNode) node);
			else if (rc.getRule() instanceof ParserRule)
				tokenAcceptor.acceptUnassignedDatatype(rc, node.getText(), (ICompositeNode) node);
			else if (rc.getRule() instanceof EnumRule)
				tokenAcceptor.acceptUnassignedEnum(rc, node.getText(), (ICompositeNode) node);
		} else if (ge instanceof Action)
			tokenAcceptor.acceptUnassignedAction((Action) ge);
		else
			throw new RuntimeException("Unexpected grammar element: " + node.getGrammarElement());
	}

	protected void acceptNodes(ISynNavigable fromState, INode fromNode, INode toNode, RCStack stack,
			IUnassignedTokenSequenceAcceptor tokenAcceptor) {
		EmitterNodeIterator ni = new EmitterNodeIterator(fromNode, toNode, false, false);
		while (ni.hasNext()) {
			INode next = ni.next();
			List<ISynState> path = fromState.getShortestPathTo((AbstractElement) next.getGrammarElement(), stack, true);
			if (path != null) {
				if (path.get(path.size() - 1) instanceof ISynEmitterState)
					fromState = (ISynEmitterState) path.get(path.size() - 1);
				else
					return;
				acceptNode(next, tokenAcceptor);
			}
		}
	}

}