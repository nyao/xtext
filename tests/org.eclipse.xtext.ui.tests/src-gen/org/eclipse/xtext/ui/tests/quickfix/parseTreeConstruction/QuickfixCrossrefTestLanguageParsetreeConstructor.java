/*
* generated by Xtext
*/
package org.eclipse.xtext.ui.tests.quickfix.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class QuickfixCrossrefTestLanguageParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private QuickfixCrossrefTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Main_ElementsAssignment(this, this, 0, inst);
			case 1: return new Element_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Main ****************
 *
 * Main:
 * 	elements+=Element*;
 *
 **/

// elements+=Element*
protected class Main_ElementsAssignment extends AssignmentToken  {
	
	public Main_ElementsAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMainAccess().getElementsAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("elements",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("elements");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMainAccess().getElementsElementParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Main_ElementsAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule Main ****************/


/************ begin Rule Element ****************
 *
 * Element:
 * 	doc=STRING? name=ID "{" contained+=Element* ("ref" referenced+=[Element])* "}";
 *
 **/

// doc=STRING? name=ID "{" contained+=Element* ("ref" referenced+=[Element])* "}"
protected class Element_Group extends GroupToken {
	
	public Element_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getElementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_RightCurlyBracketKeyword_5(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getElementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// doc=STRING?
protected class Element_DocAssignment_0 extends AssignmentToken  {
	
	public Element_DocAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getElementAccess().getDocAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("doc",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("doc");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getElementAccess().getDocSTRINGTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getElementAccess().getDocSTRINGTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class Element_NameAssignment_1 extends AssignmentToken  {
	
	public Element_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getElementAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_DocAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// "{"
protected class Element_LeftCurlyBracketKeyword_2 extends KeywordToken  {
	
	public Element_LeftCurlyBracketKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// contained+=Element*
protected class Element_ContainedAssignment_3 extends AssignmentToken  {
	
	public Element_ContainedAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getElementAccess().getContainedAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("contained",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("contained");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getElementAccess().getContainedElementParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Element_ContainedAssignment_3(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Element_LeftCurlyBracketKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("ref" referenced+=[Element])*
protected class Element_Group_4 extends GroupToken {
	
	public Element_Group_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getElementAccess().getGroup_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_ReferencedAssignment_4_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "ref"
protected class Element_RefKeyword_4_0 extends KeywordToken  {
	
	public Element_RefKeyword_4_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getElementAccess().getRefKeyword_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_Group_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Element_ContainedAssignment_3(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Element_LeftCurlyBracketKeyword_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// referenced+=[Element]
protected class Element_ReferencedAssignment_4_1 extends AssignmentToken  {
	
	public Element_ReferencedAssignment_4_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getElementAccess().getReferencedAssignment_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_RefKeyword_4_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("referenced",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("referenced");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getElementAccess().getReferencedElementCrossReference_4_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getElementAccess().getReferencedElementCrossReference_4_1_0(); 
				return obj;
			}
		}
		return null;
	}

}


// "}"
protected class Element_RightCurlyBracketKeyword_5 extends KeywordToken  {
	
	public Element_RightCurlyBracketKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getElementAccess().getRightCurlyBracketKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_Group_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Element_ContainedAssignment_3(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Element_LeftCurlyBracketKeyword_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}


/************ end Rule Element ****************/

}
