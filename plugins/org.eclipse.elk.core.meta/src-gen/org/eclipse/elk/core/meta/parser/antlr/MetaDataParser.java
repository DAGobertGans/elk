/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.core.meta.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.elk.core.meta.parser.antlr.internal.InternalMetaDataParser;
import org.eclipse.elk.core.meta.services.MetaDataGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class MetaDataParser extends AbstractAntlrParser {

	@Inject
	private MetaDataGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMetaDataParser createParser(XtextTokenStream stream) {
		return new InternalMetaDataParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "MdModel";
	}

	public MetaDataGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MetaDataGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
