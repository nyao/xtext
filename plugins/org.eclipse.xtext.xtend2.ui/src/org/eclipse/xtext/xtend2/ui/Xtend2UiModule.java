/*
 * generated by Xtext
 */
package org.eclipse.xtext.xtend2.ui;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator;
import org.eclipse.xtext.xtend2.ui.autoedit.AutoEditStrategyProvider;
import org.eclipse.xtext.xtend2.ui.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.xtend2.ui.editor.Xtend2DoubleClickStrategyProvider;
import org.eclipse.xtext.xtend2.ui.editor.Xtend2FoldingRegionProvider;
import org.eclipse.xtext.xtend2.ui.findrefs.Xtend2FindReferenceQueryDataFactory;
import org.eclipse.xtext.xtend2.ui.highlighting.HighlightingConfiguration;
import org.eclipse.xtext.xtend2.ui.highlighting.RichStringAwareTokenScanner;
import org.eclipse.xtext.xtend2.ui.highlighting.RichStringHighlightingCalculator;
import org.eclipse.xtext.xtend2.ui.highlighting.ShowWhitespaceCharactersActionContributor;
import org.eclipse.xtext.xtend2.ui.highlighting.TokenToAttributeIdMapper;
import org.eclipse.xtext.xtend2.ui.outline.Xtend2OutlineNodeComparator;
import org.eclipse.xtext.xtend2.ui.refactoring.Xtend2DependentElementsCalculator;
import org.eclipse.xtext.xtend2.ui.refactoring.Xtend2FindRefsQueryDataFactory;
import org.eclipse.xtext.xtend2.ui.refactoring.Xtend2ReferenceUpdater;
import org.eclipse.xtext.xtend2.ui.refactoring.Xtend2RenameStrategy;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class Xtend2UiModule extends org.eclipse.xtext.xtend2.ui.AbstractXtend2UiModule {
	public Xtend2UiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}
	
	@Override
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TokenToAttributeIdMapper.class;
	}
	
	@Override
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return RichStringAwareTokenScanner.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return RichStringHighlightingCalculator.class;
	}
	
	public Class<? extends IRenameStrategy.Provider> bindIRenameStrategy$Provider() {
		return Xtend2RenameStrategy.Provider.class;
	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindTokenTypeToPartitionTypeMapper() {
		return TokenTypeToPartitionMapper.class;
	}
	
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}
	
	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace")).to(ShowWhitespaceCharactersActionContributor.class);
	}
	
	public Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return Xtend2DependentElementsCalculator.class;
	}
	
	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return Xtend2ReferenceUpdater.class;
	}
	
	public Class<? extends RefactoringReferenceQueryDataFactory> bindFindRefsQueryDataFactory() {
		return Xtend2FindRefsQueryDataFactory.class;
	}
	
	public Class<? extends FindReferenceQueryDataFactory> bindFindReferenceQueryDataFactory() {
		return Xtend2FindReferenceQueryDataFactory.class;
	}
	
	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return Xtend2DoubleClickStrategyProvider.class;
	}
	
	@Override
	public Class<? extends ReferenceProposalCreator> bindAbstractJavaBasedContentProposalProvider$ReferenceProposalCreator() {
		return XbaseReferenceProposalCreator.class;
	}
	
	@Override
	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
		return Xtend2OutlineNodeComparator.class;
	}
	
	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return Xtend2FoldingRegionProvider.class;
	}
}