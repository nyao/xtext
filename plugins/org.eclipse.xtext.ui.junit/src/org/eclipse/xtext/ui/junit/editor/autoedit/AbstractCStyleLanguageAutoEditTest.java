/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.junit.editor.autoedit;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractCStyleLanguageAutoEditTest extends AbstractAutoEditTest {

	public void testParenthesis_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, '(');
		assertState("((|))", editor);
		pressKey(editor, SWT.BS);
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, ')');
		assertState("()|", editor);
		pressKey(editor, SWT.BS);
		assertState("(|", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_3() throws Exception {
		XtextEditor editor = openEditor("|)");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_4() throws Exception {
		XtextEditor editor = openEditor("|foobar");
		pressKey(editor, '(');
		assertState("(|foobar", editor);
	}

	public void testParenthesis_5() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, ')');
		assertState(")|", editor);
		pressKey(editor, ')');
		assertState("))|", editor);
		pressKey(editor, SWT.BS);
		assertState(")|", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_6() throws Exception {
		XtextEditor editor = openEditor("(|\n)");
		pressKey(editor, ')');
		assertState("()|\n)", editor);
		pressKey(editor, SWT.BS);
		assertState("(|\n)", editor);
	}

	public void testParenthesis_7() throws Exception {
		XtextEditor editor = openEditor("(((|)");
		pressKey(editor, ')');
		assertState("((()|)", editor);
		pressKey(editor, ')');
		assertState("((())|)", editor);
		pressKey(editor, ')');
		assertState("((()))|", editor);
	}
	
	public void testParenthesis_8() throws Exception {
		XtextEditor editor = openEditor("(foobar|)");
		pressKey(editor, ')');
		assertState("(foobar)|", editor);
	}

	public void testSingleQuotedStringLiteral_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '\'');
		assertState("\'|\'", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testSingleQuotedStringLiteral_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '\'');
		assertState("\'|\'", editor);
		pressKey(editor, '\'');
		assertState("\'\'|", editor);
		pressKey(editor, SWT.BS);
		assertState("\'|", editor);
	}

	public void testSingleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|'");
		pressKey(editor, '\'');
		assertState("'|'", editor);
		pressKey(editor, '\'');
		assertState("''|", editor);
		pressKey(editor, '\'');
		assertState("'''|'", editor);
	}

	public void testSingleQuotedStringLiteral_4() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\'');
		assertState("'|foo", editor);
		pressKey(editor, '\'');
		assertState("''|foo", editor);
	}

	public void testSingleQuotedStringLiteral_5() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\'');
		assertState("'|foo", editor);
		pressKey(editor, '\'');
		assertState("''|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("'|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("|foo", editor);
	}

	public void testSingleQuotedStringLiteral_6() throws Exception {
		XtextEditor editor = openEditor("'| '");
		pressKey(editor, '\'');
		assertState("''| '", editor);
		pressKey(editor, SWT.BS);
		assertState("'| '", editor);
	}

	public void testSingleQuotedStringLiteral_7() throws Exception {
		XtextEditor editor = openEditor("'' '| '");
		pressKey(editor, '\'');
		assertState("'' ''| '", editor);
		pressKey(editor, SWT.BS);
		assertState("'' '| '", editor);
	}

	public void testSingleQuotedStringLiteral_8() throws Exception {
		XtextEditor editor = openEditor("'| ' ' '");
		pressKey(editor, '\'');
		assertState("''| ' ' '", editor);
		pressKey(editor, SWT.BS);
		assertState("'| ' ' '", editor);
	}
	
	public void testDoubleQuotedStringLiteral_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testDoubleQuotedStringLiteral_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, '"');
		assertState("\"\"|", editor);
		pressKey(editor, SWT.BS);
		assertState("\"|", editor);
	}

	public void testDoubleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|\"");
		pressKey(editor, '\"');
		assertState("\"|\"", editor);
		pressKey(editor, '\"');
		assertState("\"\"|", editor);
		pressKey(editor, '\"');
		assertState("\"\"\"|\"", editor);
	}

	public void testDoubleQuotedStringLiteral_4() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\"');
		assertState("\"|foo", editor);
		pressKey(editor, '\"');
		assertState("\"\"|foo", editor);
	}

	public void testDoubleQuotedStringLiteral_5() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\"');
		assertState("\"|foo", editor);
		pressKey(editor, '\"');
		assertState("\"\"|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("\"|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("|foo", editor);
	}

	public void testDoubleQuotedStringLiteral_6() throws Exception {
		XtextEditor editor = openEditor("\"| \"");
		pressKey(editor, '\"');
		assertState("\"\"| \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"| \"", editor);
	}

	public void testDoubleQuotedStringLiteral_7() throws Exception {
		XtextEditor editor = openEditor("\"\" \"| \"");
		pressKey(editor, '\"');
		assertState("\"\" \"\"| \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"\" \"| \"", editor);
	}

	public void testDoubleQuotedStringLiteral_8() throws Exception {
		XtextEditor editor = openEditor("\"| \" \" \"");
		pressKey(editor, '\"');
		assertState("\"\"| \" \" \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"| \" \" \"", editor);
	}
	
	public void testCurlyBracesBlock_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '{');
		assertState("{|}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_2() throws Exception {
		XtextEditor editor = openEditor("{|\n}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_3() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '}');
		assertState("}|", editor);
	}

	public void testCurlyBracesBlock_4() throws Exception {
		XtextEditor editor = openEditor("foo {|");
		pressKey(editor, '\n');
		assertState("foo {\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_5() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_6() throws Exception {
		XtextEditor editor = openEditor("{| }");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_7() throws Exception {
		XtextEditor editor = openEditor("{ |foo }");
		pressKey(editor, '\n');
		assertState("{ \n\t|foo\n}", editor);
	}

	public void testCurlyBracesBlock_8() throws Exception {
		XtextEditor editor = openEditor("{ foo| }");
		pressKey(editor, '\n');
		assertState("{ foo\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_9() throws Exception {
		XtextEditor editor = openEditor("'{' foo| }");
		pressKey(editor, '\n');
		assertState("'{' foo\n| }", editor);
	}

	public void testCurlyBracesBlock_10() throws Exception {
		XtextEditor editor = openEditor("/*{*/ foo|");
		pressKey(editor, '\n');
		assertState("/*{*/ foo\n|", editor);
	}
	
	public void testCurlyBracesBlock_11() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_12() throws Exception {
		XtextEditor editor = openEditor("{foo|}");
		pressKey(editor, '\n');
		assertState("{foo\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_13() throws Exception {
		XtextEditor editor = openEditor("{foo|bar}");
		pressKey(editor, '\n');
		assertState("{foo\n\t|bar\n}", editor);
	}

	public void testCurlyBracesBlock_14() throws Exception {
		XtextEditor editor = openEditor("{\nfoo|bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo\n|bar}", editor);
	}

	public void testCurlyBracesBlock_15() throws Exception {
		XtextEditor editor = openEditor("{\nfoo}|{bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo}\n|{bar}", editor);
	}

	public void testCurlyBracesBlock_16() throws Exception {
		XtextEditor editor = openEditor("{\n|}");
		pressKey(editor, '\n');
		assertState("{\n\n|}", editor);
	}

	public void testCurlyBracesBlock_17() throws Exception {
		XtextEditor editor = openEditor("{\n|");
		pressKey(editor, '\n');
		assertState("{\n\n|\n}", editor);
	}

	public void testCurlyBracesBlock_18() throws Exception {
		XtextEditor editor = openEditor("{{foo}|{bar}}");
		pressKey(editor, '\n');
		assertState("{{foo}\n\t|{bar}\n}", editor);
	}

	public void testMLComments_01() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("/*| */", editor);

		pressKey(editor, '\n');
		assertState("/*\n * |\n */", editor);

		pressKey(editor, '\n');
		assertState("/*\n * \n * |\n */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("/*\n * \n * foo bar\n * |\n */", editor);
	}

	public void testMLComments_02() throws Exception {
		XtextEditor editor = openEditor("   |");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("   /*| */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n    * |\n    */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n    * \n    * |\n    */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("   /*\n    * \n    * foo bar\n    * |\n    */", editor);
	}

	public void testMLComments_03() throws Exception {
		XtextEditor editor = openEditor("/*\n *| */");

		pressKey(editor, '\n');
		assertState("/*\n *\n * | */", editor);
	}

	public void testMLComments_04() throws Exception {
		XtextEditor editor = openEditor("\t/*\n\t *|\n\t */");

		pressKey(editor, '\n');
		assertState("\t/*\n\t *\n\t * |\n\t */", editor);
	}

	public void testMLComments_05() throws Exception {
		XtextEditor editor = openEditor("foo /*\n     *|\n      */");

		pressKey(editor, '\n');
		assertState("foo /*\n     *\n     * |\n      */", editor);
	}

	public void testMLComments_07() throws Exception {
		XtextEditor editor = openEditor("/* */|");

		pressKey(editor, '\n');
		assertState("/* */\n|", editor);
	}

	public void testMLComments_08() throws Exception {
		XtextEditor editor = openEditor("  /* foo | */");

		pressKey(editor, '\n');
		assertState("  /* foo \n   * |\n   */", editor);
	}

	public void testMLComments_09() throws Exception {
		XtextEditor editor = openEditor("/* foo |*/");

		pressKey(editor, '\n');
		assertState("/* foo \n * |*/", editor);
	}

	public void testMLComments_10() throws Exception {
		XtextEditor editor = openEditor("   /* foo |*/");

		pressKey(editor, '\n');
		assertState("   /* foo \n    * |*/", editor);
	}

	public void testMLComments_11() throws Exception {
		XtextEditor editor = openEditor("/* */\n * |");

		pressKey(editor, '\n');
		assertState("/* */\n * \n |", editor);
	}

	public void testMLComments_12() throws Exception {
		XtextEditor editor = openEditor("foo /*| */");

		pressKey(editor, '\n');
		assertState("foo /*\n * |\n */", editor);
	}

	public void testMLComments_13() throws Exception {
		XtextEditor editor = openEditor("/* foo| */");
		pressKey(editor, '\n');
		assertState("/* foo\n * |\n */", editor);
	}

	public void testMLComments_14() throws Exception {
		XtextEditor editor = openEditor("/* foo|*/");
		pressKey(editor, '\n');
		assertState("/* foo\n * |*/", editor);
	}

	public void testMLComments_15() throws Exception {
		XtextEditor editor = openEditor("  /* foo| */");
		pressKey(editor, '\n');
		assertState("  /* foo\n   * |\n   */", editor);
	}

	public void testMLComments_16() throws Exception {
		XtextEditor editor = openEditor("  /* foo|*/");
		pressKey(editor, '\n');
		assertState("  /* foo\n   * |*/", editor);
	}

	public void testMLComments_17() throws Exception {
		XtextEditor editor = openEditor("  /*\n| *\n */");
		pressKey(editor, '\n');
		assertState("  /*\n\n| *\n */", editor);
	}
	
}