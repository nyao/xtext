/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.IDocument;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class TerminalsTokenTypeToPartitionMapper extends TokenTypeToStringMapper implements ITokenTypeToPartitionTypeMapper {
	public final static String COMMENT_PARTITION = "__comment";
	public final static String STRING_LITERAL_PARTITION = "__string";
	
	protected static final String[] SUPPORTED_PARTITIONS = new String[]{
		COMMENT_PARTITION,
		STRING_LITERAL_PARTITION,
		IDocument.DEFAULT_CONTENT_TYPE
	};
	
	public String getPartitionType(int antlrTokenType) {
		return getMappedValue(antlrTokenType);
	}
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}

	public String[] getSupportedPartitionTypes() {
		return SUPPORTED_PARTITIONS;
	}

}