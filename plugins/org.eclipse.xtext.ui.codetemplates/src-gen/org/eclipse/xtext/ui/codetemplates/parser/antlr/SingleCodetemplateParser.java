/*
* generated by Xtext
*/
package org.eclipse.xtext.ui.codetemplates.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.ui.codetemplates.services.SingleCodetemplateGrammarAccess;

public class SingleCodetemplateParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private SingleCodetemplateGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	
	@Override
	protected org.eclipse.xtext.ui.codetemplates.parser.antlr.internal.InternalSingleCodetemplateParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtext.ui.codetemplates.parser.antlr.internal.InternalSingleCodetemplateParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Codetemplates";
	}
	
	public SingleCodetemplateGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SingleCodetemplateGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}