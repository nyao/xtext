/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.collect.Sets;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class BuilderConfigurationBlock extends OptionsConfigurationBlock {
	private static final String SETTINGS_SECTION_NAME = "BuilderConfigurationBlock"; //$NON-NLS-1$

	private EclipseOutputConfigurationProvider configurationProvider;

	public BuilderConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			EclipseOutputConfigurationProvider configurationProvider, IWorkbenchPreferenceContainer container) {
		super(project, getKeys(project, configurationProvider), preferenceStore, container);
		this.configurationProvider = configurationProvider;
	}

	private static String[] getKeys(IProject project, EclipseOutputConfigurationProvider configurationProvider) {
		Set<String> keys = Sets.newHashSet(BuilderPreferenceAccess.PREF_AUTO_BUILDING, OptionsConfigurationBlock.IS_PROJECT_SPECIFIC);
		Set<OutputConfiguration> outputConfigurations = configurationProvider.getOutputConfigurations(project);
		for (OutputConfiguration outputConfiguration : outputConfigurations) {
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY));
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_CREATE_DIRECTORY));
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY));
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE));
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_DERIVED));
			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
					EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED));
		}
		return keys.toArray(new String[] {});
	}

	@Override
	protected Control createContents(Composite parent) {
		PixelConverter pixelConverter = new PixelConverter(parent);
		setShell(parent.getShell());
		Composite mainComp = new Composite(parent, SWT.NONE);
		mainComp.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainComp.setLayout(layout);
		Composite othersComposite = createBuildPathTabContent(mainComp);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.heightHint = pixelConverter.convertHeightInCharsToPixels(20);
		othersComposite.setLayoutData(gridData);
		validateSettings(null, null, null);
		return mainComp;
	}

	private Composite createBuildPathTabContent(Composite parent) {
		String[] trueFalseValues = new String[] { IPreferenceStore.TRUE, IPreferenceStore.FALSE };
		int columns = 3;
		final ScrolledPageContent pageContent = new ScrolledPageContent(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = columns;
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		Composite composite = pageContent.getBody();
		composite.setLayout(layout);
		String label = Messages.BuilderConfigurationBlock_GeneralSection_Label;
		ExpandableComposite excomposite = createStyleSection(composite, label, columns);

		Composite othersComposite = new Composite(excomposite, SWT.NONE);
		excomposite.setClient(othersComposite);
		othersComposite.setLayout(new GridLayout(columns, false));

		addCheckBox(othersComposite, Messages.BuilderPreferencePage_GenerateAuto,
				BuilderPreferenceAccess.PREF_AUTO_BUILDING, trueFalseValues, 0);

		Set<OutputConfiguration> outputConfigurations = configurationProvider.getOutputConfigurations(getProject());

		for (OutputConfiguration outputConfiguration : outputConfigurations) {
			label = outputConfiguration.getDescription();
			excomposite = createStyleSection(composite, label, columns);
			othersComposite = new Composite(excomposite, SWT.NONE);
			excomposite.setClient(othersComposite);
			othersComposite.setLayout(new GridLayout(columns, false));
			addTextField(othersComposite, Messages.OutputConfigurationPage_Directory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY), 0, 200);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CreateDirectory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CREATE_DIRECTORY), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_OverrideExistingResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CreatesDerivedResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_DERIVED), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CleanupDerivedResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CleanDirectory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY), trueFalseValues, 0);
		}
		IDialogSettings section = Activator.getDefault().getDialogSettings().getSection(SETTINGS_SECTION_NAME);
		restoreSectionExpansionStates(section);
		return pageContent;
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
	}

	@Override
	public void dispose() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().addNewSection(SETTINGS_SECTION_NAME);
		storeSectionExpansionStates(settings);
		super.dispose();
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = Messages.BuilderConfigurationBlock_SettingsChanged_Title;
		String message;
		if (workspaceSettings) {
			message = Messages.BuilderConfigurationBlock_SettingsChanged_WorkspaceBuild;
		} else {
			message = Messages.BuilderConfigurationBlock_SettingsChanged_ProjectBuild;
		}
		return new String[] { title, message };
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new BuildJob(Messages.BuilderConfigurationBlock_BuildJob_Title0, project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;
	}

	private static final class BuildJob extends Job {
		private final IProject project;

		private BuildJob(String name, IProject project) {
			super(name);
			this.project = project;
		}

		public boolean isCoveredBy(BuildJob other) {
			if (other.project == null) {
				return true;
			}
			return project != null && project.equals(other.project);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			synchronized (getClass()) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				Job[] buildJobs = Job.getJobManager().find(ResourcesPlugin.FAMILY_MANUAL_BUILD);
				for (int i = 0; i < buildJobs.length; i++) {
					if (buildJobs[i] != this && buildJobs[i] instanceof BuildJob) {
						BuildJob job = (BuildJob) buildJobs[i];
						if (job.isCoveredBy(this)) {
							buildJobs[i].cancel();
						}
					}
				}
			}
			try {
				if (project != null) {
					monitor.beginTask(String.format(
							Messages.BuilderConfigurationBlock_BuildJob_TitleBuildProject_TaskName,
							TextProcessor.process(project.getName(), ":.")), //$NON-NLS-2$
							2);
					project.build(IncrementalProjectBuilder.FULL_BUILD, new SubProgressMonitor(monitor, 1));
					ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
							new SubProgressMonitor(monitor, 1));
				} else {
					monitor.beginTask(Messages.BuilderConfigurationBlock_BuildJob_TitleBuildAll_TaskName, 2);
					ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD,
							new SubProgressMonitor(monitor, 2));
				}
			} catch (CoreException e) {
				return e.getStatus();
			} catch (OperationCanceledException e) {
				return Status.CANCEL_STATUS;
			} finally {
				monitor.done();
			}
			return Status.OK_STATUS;
		}

		@Override
		public boolean belongsTo(Object family) {
			return ResourcesPlugin.FAMILY_MANUAL_BUILD == family;
		}
	}

}