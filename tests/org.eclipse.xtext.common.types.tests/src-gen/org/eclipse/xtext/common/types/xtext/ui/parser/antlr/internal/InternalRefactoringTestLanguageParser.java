package org.eclipse.xtext.common.types.xtext.ui.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'$'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g"; }



     	private RefactoringTestLanguageGrammarAccess grammarAccess;
     	
        public InternalRefactoringTestLanguageParser(TokenStream input, RefactoringTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected RefactoringTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_referenceHolder_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:79:28: ( ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:80:1: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:80:1: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:81:1: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    {
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:81:1: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:82:3: lv_referenceHolder_0_0= ruleReferenceHolder
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_ruleModel130);
            	    lv_referenceHolder_0_0=ruleReferenceHolder();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"referenceHolder",
            	            		lv_referenceHolder_0_0, 
            	            		"ReferenceHolder");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:106:1: entryRuleReferenceHolder returns [EObject current=null] : iv_ruleReferenceHolder= ruleReferenceHolder EOF ;
    public final EObject entryRuleReferenceHolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceHolder = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:107:2: (iv_ruleReferenceHolder= ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:108:2: iv_ruleReferenceHolder= ruleReferenceHolder EOF
            {
             newCompositeNode(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder166);
            iv_ruleReferenceHolder=ruleReferenceHolder();

            state._fsp--;

             current =iv_ruleReferenceHolder; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceHolder176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:115:1: ruleReferenceHolder returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) ;
    public final EObject ruleReferenceHolder() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:118:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:120:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:121:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceHolder218); 

            			newLeafNode(lv_name_0_0, grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceHolderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:137:2: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:138:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:138:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:139:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceHolderRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleReferenceHolder246);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:160:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:161:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:162:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN283);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN294); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:169:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:172:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:173:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:173:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:173:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN334); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:180:1: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:181:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleFQN353); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN368); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:193:3: (kw= '$' this_ID_4= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/parser/antlr/internal/InternalRefactoringTestLanguage.g:194:2: kw= '$' this_ID_4= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFQN389); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            	        
            	    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN404); 

            	    		current.merge(this_ID_4);
            	        
            	     
            	        newLeafNode(this_ID_4, grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_ruleModel130 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceHolder218 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN334 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_11_in_ruleFQN353 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN368 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_12_in_ruleFQN389 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN404 = new BitSet(new long[]{0x0000000000001002L});
    }


}