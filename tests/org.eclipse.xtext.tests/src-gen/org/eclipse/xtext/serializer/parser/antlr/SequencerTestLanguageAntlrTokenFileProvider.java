/*
* generated by Xtext
*/
package org.eclipse.xtext.serializer.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SequencerTestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.tokens");
	}
}