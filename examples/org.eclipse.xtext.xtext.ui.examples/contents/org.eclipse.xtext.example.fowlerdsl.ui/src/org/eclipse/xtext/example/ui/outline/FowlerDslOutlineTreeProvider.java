/*
* generated by Xtext
*/
package org.eclipse.xtext.example.ui.outline;

import org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage;
import org.eclipse.xtext.example.fowlerdsl.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.Transition;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * customization of the default outline structure
 * 
 */
public class FowlerDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(DocumentRootNode parentNode, Statemachine statemachine) {
		createEStructuralFeatureNode(parentNode, statemachine, FowlerdslPackage.Literals.STATEMACHINE__EVENTS,
				labelProvider.getImage("events"), "events", false);
		createEStructuralFeatureNode(parentNode, statemachine, FowlerdslPackage.Literals.STATEMACHINE__COMMANDS,
				labelProvider.getImage("commands"), "commands", false);
		createEStructuralFeatureNode(parentNode, statemachine, FowlerdslPackage.Literals.STATEMACHINE__STATES,
				labelProvider.getImage("states"), "states", false);
	}

	protected Object _text(Transition transition) {
		return transition.getEvent().getName() + " => " + transition.getState().getName();
	}

}