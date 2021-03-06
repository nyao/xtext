package org.eclipse.xtext.example.gmf.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.example.gmf.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEntitiesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'{'", "'}'", "'extends'", "'property'", "':'", "'reference'", "'[]'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalEntitiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEntitiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEntitiesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g"; }


     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EntitiesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:104:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:117:1: ( ruleType EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:118:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType181);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:125:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:129:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:130:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:130:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:131:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:132:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:132:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType214);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleSimpleType"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:144:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:145:1: ( ruleSimpleType EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:146:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType241);
            ruleSimpleType();

            state._fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:153:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:157:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:159:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:160:1: ( rule__SimpleType__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:160:2: rule__SimpleType__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274);
            rule__SimpleType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:172:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:173:1: ( ruleEntity EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:174:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity301);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:181:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:185:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:186:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:186:1: ( ( rule__Entity__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:187:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:188:1: ( rule__Entity__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:188:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity334);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:200:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:201:1: ( ruleProperty EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:202:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty361);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:209:1: ruleProperty : ( ( rule__Property__Alternatives ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:213:2: ( ( ( rule__Property__Alternatives ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:214:1: ( ( rule__Property__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:214:1: ( ( rule__Property__Alternatives ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:215:1: ( rule__Property__Alternatives )
            {
             before(grammarAccess.getPropertyAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:216:1: ( rule__Property__Alternatives )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:216:2: rule__Property__Alternatives
            {
            pushFollow(FOLLOW_rule__Property__Alternatives_in_ruleProperty394);
            rule__Property__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleSimpleProperty"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:228:1: entryRuleSimpleProperty : ruleSimpleProperty EOF ;
    public final void entryRuleSimpleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:229:1: ( ruleSimpleProperty EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:230:1: ruleSimpleProperty EOF
            {
             before(grammarAccess.getSimplePropertyRule()); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty421);
            ruleSimpleProperty();

            state._fsp--;

             after(grammarAccess.getSimplePropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleProperty"


    // $ANTLR start "ruleSimpleProperty"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:237:1: ruleSimpleProperty : ( ( rule__SimpleProperty__Group__0 ) ) ;
    public final void ruleSimpleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:241:2: ( ( ( rule__SimpleProperty__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:242:1: ( ( rule__SimpleProperty__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:242:1: ( ( rule__SimpleProperty__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:243:1: ( rule__SimpleProperty__Group__0 )
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:244:1: ( rule__SimpleProperty__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:244:2: rule__SimpleProperty__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty454);
            rule__SimpleProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleProperty"


    // $ANTLR start "entryRuleReference"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:256:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:257:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:258:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference481);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:265:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:269:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:270:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:270:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:271:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:272:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:272:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference514);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "rule__Type__Alternatives"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:284:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:288:1: ( ( ruleSimpleType ) | ( ruleEntity ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:289:1: ( ruleSimpleType )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:289:1: ( ruleSimpleType )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:290:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleType_in_rule__Type__Alternatives550);
                    ruleSimpleType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:295:6: ( ruleEntity )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:295:6: ( ruleEntity )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:296:1: ruleEntity
                    {
                     before(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEntity_in_rule__Type__Alternatives567);
                    ruleEntity();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__Property__Alternatives"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:306:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReference ) );
    public final void rule__Property__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:310:1: ( ( ruleSimpleProperty ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:311:1: ( ruleSimpleProperty )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:311:1: ( ruleSimpleProperty )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:312:1: ruleSimpleProperty
                    {
                     before(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives599);
                    ruleSimpleProperty();

                    state._fsp--;

                     after(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:317:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:317:6: ( ruleReference )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:318:1: ruleReference
                    {
                     before(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Property__Alternatives616);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:330:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:334:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:335:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0646);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0649);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:342:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:346:1: ( ( () ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:347:1: ( () )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:347:1: ( () )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:348:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:349:1: ()
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:351:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:361:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:365:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:366:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1707);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1710);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:373:1: rule__Model__Group__1__Impl : ( ( rule__Model__ImportsAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:377:1: ( ( ( rule__Model__ImportsAssignment_1 )* ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:378:1: ( ( rule__Model__ImportsAssignment_1 )* )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:378:1: ( ( rule__Model__ImportsAssignment_1 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:379:1: ( rule__Model__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:380:1: ( rule__Model__ImportsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:380:2: rule__Model__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1__Impl737);
            	    rule__Model__ImportsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:390:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:394:1: ( rule__Model__Group__2__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:395:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2768);
            rule__Model__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:401:1: rule__Model__Group__2__Impl : ( ( rule__Model__ElementsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:405:1: ( ( ( rule__Model__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:406:1: ( ( rule__Model__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:406:1: ( ( rule__Model__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:407:1: ( rule__Model__ElementsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:408:1: ( rule__Model__ElementsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:408:2: rule__Model__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2__Impl795);
            	    rule__Model__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:424:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:428:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:429:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0832);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0835);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:436:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:440:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:441:1: ( 'import' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:441:1: ( 'import' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:442:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0__Impl863); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:455:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:459:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:460:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1894);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:466:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:470:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:471:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:471:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:472:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:473:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:473:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl921);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__SimpleType__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:487:1: rule__SimpleType__Group__0 : rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:491:1: ( rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:492:2: rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__0__Impl_in_rule__SimpleType__Group__0955);
            rule__SimpleType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0958);
            rule__SimpleType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleType__Group__0"


    // $ANTLR start "rule__SimpleType__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:499:1: rule__SimpleType__Group__0__Impl : ( 'type' ) ;
    public final void rule__SimpleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:503:1: ( ( 'type' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:504:1: ( 'type' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:504:1: ( 'type' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:505:1: 'type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__SimpleType__Group__0__Impl986); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleType__Group__0__Impl"


    // $ANTLR start "rule__SimpleType__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:518:1: rule__SimpleType__Group__1 : rule__SimpleType__Group__1__Impl ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:522:1: ( rule__SimpleType__Group__1__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:523:2: rule__SimpleType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__1__Impl_in_rule__SimpleType__Group__11017);
            rule__SimpleType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleType__Group__1"


    // $ANTLR start "rule__SimpleType__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:529:1: rule__SimpleType__Group__1__Impl : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:533:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:534:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:534:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:535:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:536:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:536:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1__Impl1044);
            rule__SimpleType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleType__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:550:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:554:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:555:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01078);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01081);
            rule__Entity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:562:1: rule__Entity__Group__0__Impl : ( 'entity' ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:566:1: ( ( 'entity' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:567:1: ( 'entity' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:567:1: ( 'entity' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:568:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Entity__Group__0__Impl1109); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:581:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:585:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:586:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11140);
            rule__Entity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11143);
            rule__Entity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:593:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:597:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:598:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:598:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:599:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:600:1: ( rule__Entity__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:600:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl1170);
            rule__Entity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:610:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:614:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:615:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__21200);
            rule__Entity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21203);
            rule__Entity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2"


    // $ANTLR start "rule__Entity__Group__2__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:622:1: rule__Entity__Group__2__Impl : ( ( rule__Entity__Group_2__0 )? ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:626:1: ( ( ( rule__Entity__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:627:1: ( ( rule__Entity__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:627:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:628:1: ( rule__Entity__Group_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:629:1: ( rule__Entity__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:629:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2__Impl1230);
                    rule__Entity__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2__Impl"


    // $ANTLR start "rule__Entity__Group__3"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:639:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:643:1: ( rule__Entity__Group__3__Impl rule__Entity__Group__4 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:644:2: rule__Entity__Group__3__Impl rule__Entity__Group__4
            {
            pushFollow(FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__31261);
            rule__Entity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31264);
            rule__Entity__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3"


    // $ANTLR start "rule__Entity__Group__3__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:651:1: rule__Entity__Group__3__Impl : ( '{' ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:655:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:656:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:656:1: ( '{' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:657:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__Entity__Group__3__Impl1292); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3__Impl"


    // $ANTLR start "rule__Entity__Group__4"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:670:1: rule__Entity__Group__4 : rule__Entity__Group__4__Impl rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:674:1: ( rule__Entity__Group__4__Impl rule__Entity__Group__5 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:675:2: rule__Entity__Group__4__Impl rule__Entity__Group__5
            {
            pushFollow(FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__41323);
            rule__Entity__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41326);
            rule__Entity__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4"


    // $ANTLR start "rule__Entity__Group__4__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:682:1: rule__Entity__Group__4__Impl : ( ( rule__Entity__PropertiesAssignment_4 )* ) ;
    public final void rule__Entity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:686:1: ( ( ( rule__Entity__PropertiesAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:687:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:687:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:688:1: ( rule__Entity__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:689:1: ( rule__Entity__PropertiesAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:689:2: rule__Entity__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4__Impl1353);
            	    rule__Entity__PropertiesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4__Impl"


    // $ANTLR start "rule__Entity__Group__5"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:699:1: rule__Entity__Group__5 : rule__Entity__Group__5__Impl ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:703:1: ( rule__Entity__Group__5__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:704:2: rule__Entity__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Entity__Group__5__Impl_in_rule__Entity__Group__51384);
            rule__Entity__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__5"


    // $ANTLR start "rule__Entity__Group__5__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:710:1: rule__Entity__Group__5__Impl : ( '}' ) ;
    public final void rule__Entity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:714:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:715:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:715:1: ( '}' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:716:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__5__Impl1412); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__5__Impl"


    // $ANTLR start "rule__Entity__Group_2__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:741:1: rule__Entity__Group_2__0 : rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:745:1: ( rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:746:2: rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1
            {
            pushFollow(FOLLOW_rule__Entity__Group_2__0__Impl_in_rule__Entity__Group_2__01455);
            rule__Entity__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01458);
            rule__Entity__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_2__0"


    // $ANTLR start "rule__Entity__Group_2__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:753:1: rule__Entity__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Entity__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:757:1: ( ( 'extends' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:758:1: ( 'extends' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:758:1: ( 'extends' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:759:1: 'extends'
            {
             before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group_2__0__Impl1486); 
             after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_2__0__Impl"


    // $ANTLR start "rule__Entity__Group_2__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:772:1: rule__Entity__Group_2__1 : rule__Entity__Group_2__1__Impl ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:776:1: ( rule__Entity__Group_2__1__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:777:2: rule__Entity__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Entity__Group_2__1__Impl_in_rule__Entity__Group_2__11517);
            rule__Entity__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_2__1"


    // $ANTLR start "rule__Entity__Group_2__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:783:1: rule__Entity__Group_2__1__Impl : ( ( rule__Entity__ExtendsAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:787:1: ( ( ( rule__Entity__ExtendsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:788:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:788:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:789:1: ( rule__Entity__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:790:1: ( rule__Entity__ExtendsAssignment_2_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:790:2: rule__Entity__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__1__Impl1544);
            rule__Entity__ExtendsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_2__1__Impl"


    // $ANTLR start "rule__SimpleProperty__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:804:1: rule__SimpleProperty__Group__0 : rule__SimpleProperty__Group__0__Impl rule__SimpleProperty__Group__1 ;
    public final void rule__SimpleProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:808:1: ( rule__SimpleProperty__Group__0__Impl rule__SimpleProperty__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:809:2: rule__SimpleProperty__Group__0__Impl rule__SimpleProperty__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__0__Impl_in_rule__SimpleProperty__Group__01578);
            rule__SimpleProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01581);
            rule__SimpleProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__0"


    // $ANTLR start "rule__SimpleProperty__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:816:1: rule__SimpleProperty__Group__0__Impl : ( 'property' ) ;
    public final void rule__SimpleProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:820:1: ( ( 'property' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:821:1: ( 'property' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:821:1: ( 'property' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:822:1: 'property'
            {
             before(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SimpleProperty__Group__0__Impl1609); 
             after(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__0__Impl"


    // $ANTLR start "rule__SimpleProperty__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:835:1: rule__SimpleProperty__Group__1 : rule__SimpleProperty__Group__1__Impl rule__SimpleProperty__Group__2 ;
    public final void rule__SimpleProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:839:1: ( rule__SimpleProperty__Group__1__Impl rule__SimpleProperty__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:840:2: rule__SimpleProperty__Group__1__Impl rule__SimpleProperty__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__1__Impl_in_rule__SimpleProperty__Group__11640);
            rule__SimpleProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11643);
            rule__SimpleProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__1"


    // $ANTLR start "rule__SimpleProperty__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:847:1: rule__SimpleProperty__Group__1__Impl : ( ( rule__SimpleProperty__NameAssignment_1 ) ) ;
    public final void rule__SimpleProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:851:1: ( ( ( rule__SimpleProperty__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:852:1: ( ( rule__SimpleProperty__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:852:1: ( ( rule__SimpleProperty__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:853:1: ( rule__SimpleProperty__NameAssignment_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:854:1: ( rule__SimpleProperty__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:854:2: rule__SimpleProperty__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__1__Impl1670);
            rule__SimpleProperty__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__1__Impl"


    // $ANTLR start "rule__SimpleProperty__Group__2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:864:1: rule__SimpleProperty__Group__2 : rule__SimpleProperty__Group__2__Impl ;
    public final void rule__SimpleProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:868:1: ( rule__SimpleProperty__Group__2__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:869:2: rule__SimpleProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__2__Impl_in_rule__SimpleProperty__Group__21700);
            rule__SimpleProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__2"


    // $ANTLR start "rule__SimpleProperty__Group__2__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:875:1: rule__SimpleProperty__Group__2__Impl : ( ( rule__SimpleProperty__Group_2__0 )? ) ;
    public final void rule__SimpleProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:879:1: ( ( ( rule__SimpleProperty__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:880:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:880:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:881:1: ( rule__SimpleProperty__Group_2__0 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:882:1: ( rule__SimpleProperty__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:882:2: rule__SimpleProperty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__2__Impl1727);
                    rule__SimpleProperty__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group__2__Impl"


    // $ANTLR start "rule__SimpleProperty__Group_2__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:898:1: rule__SimpleProperty__Group_2__0 : rule__SimpleProperty__Group_2__0__Impl rule__SimpleProperty__Group_2__1 ;
    public final void rule__SimpleProperty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:902:1: ( rule__SimpleProperty__Group_2__0__Impl rule__SimpleProperty__Group_2__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:903:2: rule__SimpleProperty__Group_2__0__Impl rule__SimpleProperty__Group_2__1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__0__Impl_in_rule__SimpleProperty__Group_2__01764);
            rule__SimpleProperty__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01767);
            rule__SimpleProperty__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__0"


    // $ANTLR start "rule__SimpleProperty__Group_2__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:910:1: rule__SimpleProperty__Group_2__0__Impl : ( ':' ) ;
    public final void rule__SimpleProperty__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:914:1: ( ( ':' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:915:1: ( ':' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:915:1: ( ':' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:916:1: ':'
            {
             before(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__SimpleProperty__Group_2__0__Impl1795); 
             after(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__0__Impl"


    // $ANTLR start "rule__SimpleProperty__Group_2__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:929:1: rule__SimpleProperty__Group_2__1 : rule__SimpleProperty__Group_2__1__Impl rule__SimpleProperty__Group_2__2 ;
    public final void rule__SimpleProperty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:933:1: ( rule__SimpleProperty__Group_2__1__Impl rule__SimpleProperty__Group_2__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:934:2: rule__SimpleProperty__Group_2__1__Impl rule__SimpleProperty__Group_2__2
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__1__Impl_in_rule__SimpleProperty__Group_2__11826);
            rule__SimpleProperty__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11829);
            rule__SimpleProperty__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__1"


    // $ANTLR start "rule__SimpleProperty__Group_2__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:941:1: rule__SimpleProperty__Group_2__1__Impl : ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) ;
    public final void rule__SimpleProperty__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:945:1: ( ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:946:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:946:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:947:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:948:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:948:2: rule__SimpleProperty__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__1__Impl1856);
            rule__SimpleProperty__TypeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__1__Impl"


    // $ANTLR start "rule__SimpleProperty__Group_2__2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:958:1: rule__SimpleProperty__Group_2__2 : rule__SimpleProperty__Group_2__2__Impl ;
    public final void rule__SimpleProperty__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:962:1: ( rule__SimpleProperty__Group_2__2__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:963:2: rule__SimpleProperty__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__2__Impl_in_rule__SimpleProperty__Group_2__21886);
            rule__SimpleProperty__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__2"


    // $ANTLR start "rule__SimpleProperty__Group_2__2__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:969:1: rule__SimpleProperty__Group_2__2__Impl : ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) ;
    public final void rule__SimpleProperty__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:973:1: ( ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:974:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:974:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:975:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:976:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:976:2: rule__SimpleProperty__ManyAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__2__Impl1913);
                    rule__SimpleProperty__ManyAssignment_2_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__Group_2__2__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:992:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:996:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:997:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__01950);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01953);
            rule__Reference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1004:1: rule__Reference__Group__0__Impl : ( 'reference' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1008:1: ( ( 'reference' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1009:1: ( 'reference' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1009:1: ( 'reference' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1010:1: 'reference'
            {
             before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Reference__Group__0__Impl1981); 
             after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1023:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1027:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1028:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__12012);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12015);
            rule__Reference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1035:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__NameAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1039:1: ( ( ( rule__Reference__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1040:1: ( ( rule__Reference__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1040:1: ( ( rule__Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1041:1: ( rule__Reference__NameAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1042:1: ( rule__Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1042:2: rule__Reference__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__1__Impl2042);
            rule__Reference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1052:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1056:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1057:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__22072);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22075);
            rule__Reference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1064:1: rule__Reference__Group__2__Impl : ( ':' ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1068:1: ( ( ':' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1069:1: ( ':' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1069:1: ( ':' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1070:1: ':'
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Reference__Group__2__Impl2103); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1083:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1087:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1088:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__32134);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32137);
            rule__Reference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1095:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__TypeAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1099:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1100:1: ( ( rule__Reference__TypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1100:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1101:1: ( rule__Reference__TypeAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1102:1: ( rule__Reference__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1102:2: rule__Reference__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__3__Impl2164);
            rule__Reference__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1112:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1116:1: ( rule__Reference__Group__4__Impl )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1117:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__42194);
            rule__Reference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1123:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__ManyAssignment_4 )? ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1127:1: ( ( ( rule__Reference__ManyAssignment_4 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1128:1: ( ( rule__Reference__ManyAssignment_4 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1128:1: ( ( rule__Reference__ManyAssignment_4 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1129:1: ( rule__Reference__ManyAssignment_4 )?
            {
             before(grammarAccess.getReferenceAccess().getManyAssignment_4()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1130:1: ( rule__Reference__ManyAssignment_4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1130:2: rule__Reference__ManyAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__4__Impl2221);
                    rule__Reference__ManyAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getManyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Model__ImportsAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1151:1: rule__Model__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1155:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1156:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1156:1: ( ruleImport )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1157:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_12267);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ImportsAssignment_1"


    // $ANTLR start "rule__Model__ElementsAssignment_2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1166:1: rule__Model__ElementsAssignment_2 : ( ruleType ) ;
    public final void rule__Model__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1170:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1171:1: ( ruleType )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1171:1: ( ruleType )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1172:1: ruleType
            {
             before(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Model__ElementsAssignment_22298);
            ruleType();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment_2"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1181:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1185:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1186:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1186:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1187:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_12329); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__SimpleType__NameAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1196:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1200:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1201:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1201:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1202:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_12360); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleType__NameAssignment_1"


    // $ANTLR start "rule__Entity__NameAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1211:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1215:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1216:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1216:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1217:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_12391); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_1"


    // $ANTLR start "rule__Entity__ExtendsAssignment_2_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1226:1: rule__Entity__ExtendsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1230:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1231:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1231:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1232:1: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1233:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1234:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_12426); 
             after(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__ExtendsAssignment_2_1"


    // $ANTLR start "rule__Entity__PropertiesAssignment_4"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1245:1: rule__Entity__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1249:1: ( ( ruleProperty ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1250:1: ( ruleProperty )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1250:1: ( ruleProperty )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1251:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_42461);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__PropertiesAssignment_4"


    // $ANTLR start "rule__SimpleProperty__NameAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1260:1: rule__SimpleProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1264:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1265:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1265:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1266:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_12492); 
             after(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__NameAssignment_1"


    // $ANTLR start "rule__SimpleProperty__TypeAssignment_2_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1275:1: rule__SimpleProperty__TypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__SimpleProperty__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1279:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1280:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1280:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1281:1: ( RULE_ID )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1282:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1283:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_12527); 
             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__TypeAssignment_2_1"


    // $ANTLR start "rule__SimpleProperty__ManyAssignment_2_2"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1294:1: rule__SimpleProperty__ManyAssignment_2_2 : ( ( '[]' ) ) ;
    public final void rule__SimpleProperty__ManyAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1298:1: ( ( ( '[]' ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1299:1: ( ( '[]' ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1299:1: ( ( '[]' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1300:1: ( '[]' )
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1301:1: ( '[]' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1302:1: '[]'
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            match(input,20,FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_22567); 
             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleProperty__ManyAssignment_2_2"


    // $ANTLR start "rule__Reference__NameAssignment_1"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1317:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1321:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1322:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1322:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1323:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12606); 
             after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NameAssignment_1"


    // $ANTLR start "rule__Reference__TypeAssignment_3"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1332:1: rule__Reference__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1336:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1337:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1337:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1338:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1339:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1340:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32641); 
             after(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__TypeAssignment_3"


    // $ANTLR start "rule__Reference__ManyAssignment_4"
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1351:1: rule__Reference__ManyAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__Reference__ManyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1355:1: ( ( ( '[]' ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1356:1: ( ( '[]' ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1356:1: ( ( '[]' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1357:1: ( '[]' )
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1358:1: ( '[]' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/ui/contentassist/antlr/internal/InternalEntities.g:1359:1: '[]'
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__Reference__ManyAssignment_42681); 
             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }

             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__ManyAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Alternatives_in_ruleProperty394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Property__Alternatives616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0646 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1707 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1__Impl737 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2__Impl795 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0832 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Group__0__Impl863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__0__Impl_in_rule__SimpleType__Group__0955 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0__Impl986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__1__Impl_in_rule__SimpleType__Group__11017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1__Impl1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01078 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Entity__Group__0__Impl1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11140 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__21200 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2__Impl1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__31261 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Entity__Group__3__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__41323 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4__Impl1353 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_rule__Entity__Group__5__Impl_in_rule__Entity__Group__51384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__5__Impl1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0__Impl_in_rule__Entity__Group_2__01455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group_2__0__Impl1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1__Impl_in_rule__Entity__Group_2__11517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__1__Impl1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__0__Impl_in_rule__SimpleProperty__Group__01578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SimpleProperty__Group__0__Impl1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__1__Impl_in_rule__SimpleProperty__Group__11640 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__1__Impl1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__2__Impl_in_rule__SimpleProperty__Group__21700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__2__Impl1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__0__Impl_in_rule__SimpleProperty__Group_2__01764 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SimpleProperty__Group_2__0__Impl1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__1__Impl_in_rule__SimpleProperty__Group_2__11826 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__1__Impl1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__2__Impl_in_rule__SimpleProperty__Group_2__21886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__2__Impl1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__01950 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Reference__Group__0__Impl1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__12012 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__1__Impl2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__22072 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Reference__Group__2__Impl2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__32134 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__3__Impl2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__42194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__4__Impl2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_12267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Model__ElementsAssignment_22298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_12329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_12360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_12391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_12426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_42461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_12492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_12527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_22567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Reference__ManyAssignment_42681 = new BitSet(new long[]{0x0000000000000002L});

}