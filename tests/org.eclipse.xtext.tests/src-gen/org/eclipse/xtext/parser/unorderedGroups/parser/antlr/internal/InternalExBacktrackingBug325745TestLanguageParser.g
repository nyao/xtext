/*
* generated by Xtext
*/
parser grammar InternalExBacktrackingBug325745TestLanguageParser;

options {
	tokenVocab=InternalExBacktrackingBug325745TestLanguageLexer;
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@header {
package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.unorderedGroups.services.ExBacktrackingBug325745TestLanguageGrammarAccess;

}

@members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/
 

	private ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;
	 	
	public InternalExBacktrackingBug325745TestLanguageParser(TokenStream input, ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}
	
	@Override
	protected String getFirstRuleName() {
		return "DelegateModel";	
	} 
	   	   	
	@Override
	protected ExBacktrackingBug325745TestLanguageGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
}

@rulecatch { 
	catch (RecognitionException re) { 
	    recover(input,re); 
	    appendSkippedTokens();
	}
}




// Entry rule entryRuleDelegateModel
entryRuleDelegateModel returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDelegateModelRule()); }
	 iv_ruleDelegateModel=ruleDelegateModel 
	 { $current=$iv_ruleDelegateModel.current; } 
	 EOF 
;

// Rule DelegateModel
ruleDelegateModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall()); 
    }
    this_Model_0=ruleModel
    {
        $current = $this_Model_0.current;
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getModelAccess().getModelAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getFieldsElementParserRuleCall_1_0()); 
	    }
		lv_fields_1_0=ruleElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"fields",
        		lv_fields_1_0, 
        		"Element");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
;





// Entry rule entryRuleElement
entryRuleElement returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getElementRule()); }
	 iv_ruleElement=ruleElement 
	 { $current=$iv_ruleElement.current; } 
	 EOF 
;

// Rule Element
ruleElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getElementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0()); 
	    }
		lv_dataType_1_0=ruleDataType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElementRule());
	        }
       		set(
       			$current, 
       			"dataType",
        		lv_dataType_1_0, 
        		"DataType");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getElementAccess().getExpressionExpressionParserRuleCall_2_0()); 
	    }
		lv_expression_2_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElementRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_2_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)
	otherlv_3=KEYWORD_3
    {
    	newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3());
    }
)
;





// Entry rule entryRuleDataType
entryRuleDataType returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getDataTypeRule()); }
	 iv_ruleDataType=ruleDataType 
	 { $current=$iv_ruleDataType.current; } 
	 EOF 
;

// Rule DataType
ruleDataType returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_baseType_0_0=RULE_ID
		{
			newLeafNode(lv_baseType_0_0, grammarAccess.getDataTypeAccess().getBaseTypeIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataTypeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"baseType",
        		lv_baseType_0_0, 
        		"ID");
	    }

)
)(
	otherlv_1=KEYWORD_6
    {
    	newLeafNode(otherlv_1, grammarAccess.getDataTypeAccess().getColonEqualsSignKeyword_1_0());
    }
(
(
		lv_defaultValue_2_0=RULE_STRING
		{
			newLeafNode(lv_defaultValue_2_0, grammarAccess.getDataTypeAccess().getDefaultValueSTRINGTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataTypeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"defaultValue",
        		lv_defaultValue_2_0, 
        		"STRING");
	    }

)
))?)
;





// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]
	@init { 
		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
		);
	}
	:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	 iv_ruleExpression=ruleExpression 
	 { $current=$iv_ruleExpression.current; } 
	 EOF 
;
finally {
	myUnorderedGroupState.restore();
}

// Rule Expression
ruleExpression returns [EObject current=null] 
    @init { enterRule(); 
		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
		);
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getExpressionAccess().getExpressionAction_0(),
            $current);
    }
)(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
	 				}
					({true}?=>(
	otherlv_2=KEYWORD_4
    {
    	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_1_0());
    }
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
	 				}
					({true}?=>(
(
		lv_prefix_3_0=RULE_STRING
		{
			newLeafNode(lv_prefix_3_0, grammarAccess.getExpressionAccess().getPrefixSTRINGTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"prefix",
        		lv_prefix_3_0, 
        		"STRING");
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
	}

)((
	otherlv_4=KEYWORD_4
    {
    	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getExpressionAccess().getTermsSimpleTermParserRuleCall_2_1_0()); 
	    }
		lv_terms_5_0=ruleSimpleTerm		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpressionRule());
	        }
       		add(
       			$current, 
       			"terms",
        		lv_terms_5_0, 
        		"SimpleTerm");
	        afterParserOrEnumRuleCall();
	    }

)
)(
	otherlv_6=KEYWORD_5
    {
    	newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2());
    }
)?)*(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
	 				}
					({true}?=>(
	otherlv_8=KEYWORD_5
    {
    	newLeafNode(otherlv_8, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_3_0());
    }
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
	 				}
					({true}?=>(
(
		lv_postfix_9_0=RULE_STRING
		{
			newLeafNode(lv_postfix_9_0, grammarAccess.getExpressionAccess().getPostfixSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"postfix",
        		lv_postfix_9_0, 
        		"STRING");
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
	}

))
;
finally {
	myUnorderedGroupState.restore();
}





// Entry rule entryRuleSimpleTerm
entryRuleSimpleTerm returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSimpleTermRule()); }
	 iv_ruleSimpleTerm=ruleSimpleTerm 
	 { $current=$iv_ruleSimpleTerm.current; } 
	 EOF 
;

// Rule SimpleTerm
ruleSimpleTerm returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		lv_lineCount_0_0=RULE_INT
		{
			newLeafNode(lv_lineCount_0_0, grammarAccess.getSimpleTermAccess().getLineCountINTTerminalRuleCall_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleTermRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"lineCount",
        		lv_lineCount_0_0, 
        		"INT");
	    }

)
)(
	otherlv_1=KEYWORD_2
    {
    	newLeafNode(otherlv_1, grammarAccess.getSimpleTermAccess().getAsteriskKeyword_0_1());
    }
)?(
(
		lv_charCount_2_0=RULE_INT
		{
			newLeafNode(lv_charCount_2_0, grammarAccess.getSimpleTermAccess().getCharCountINTTerminalRuleCall_0_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleTermRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"charCount",
        		lv_charCount_2_0, 
        		"INT");
	    }

)
)?(
	otherlv_3=KEYWORD_1
    {
    	newLeafNode(otherlv_3, grammarAccess.getSimpleTermAccess().getExclamationMarkKeyword_0_3());
    }
)?(
(
		lv_charSet_4_0=RULE_ID
		{
			newLeafNode(lv_charSet_4_0, grammarAccess.getSimpleTermAccess().getCharSetIDTerminalRuleCall_0_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleTermRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"charSet",
        		lv_charSet_4_0, 
        		"ID");
	    }

)
)?)
    |(
(
		lv_refChar_5_0=RULE_ID
		{
			newLeafNode(lv_refChar_5_0, grammarAccess.getSimpleTermAccess().getRefCharIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleTermRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"refChar",
        		lv_refChar_5_0, 
        		"ID");
	    }

)
))
;




