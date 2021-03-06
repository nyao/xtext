/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.IOutputConfigurationProvider.Delegate;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class EclipseOutputConfigurationProvider extends Delegate {
	public static final String OUTPUT_PREFERENCE_TAG = "outlet";
	public static final String OUTPUT_NAME = "name";
	public static final String OUTPUT_DESCRIPTION = "description";
	public static final String OUTPUT_DIRECTORY = "directory";
	public static final String OUTPUT_CREATE_DIRECTORY = "createDirectory";
	public static final String OUTPUT_CLEAN_DIRECTORY = "cleanDirectory";
	public static final String OUTPUT_OVERRIDE = "override";
	public static final String OUTPUT_CLEANUP_DERIVED = "cleanupDerived";
	public static final String OUTPUT_DERIVED = "derived";
	private IPreferenceStoreAccess preferenceStoreAccess;

	public IPreferenceStoreAccess getPreferenceStoreAccess() {
		return preferenceStoreAccess;
	}

	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}

	@Inject
	public EclipseOutputConfigurationProvider(IOutputConfigurationProvider delegate) {
		super(delegate);
	}

	public Set<OutputConfiguration> getOutputConfigurations(IProject project) {
		IPreferenceStore store = getPreferenceStoreAccess().getContextPreferenceStore(project);
		Set<OutputConfiguration> outputConfigurations = Sets.newHashSetWithExpectedSize(getOutputConfigurations()
				.size());
		for (OutputConfiguration output : getOutputConfigurations()) {
			OutputConfiguration configuration = createAndOverlayOutputConfiguration(store, output);
			outputConfigurations.add(configuration);
		}
		return outputConfigurations;
	}

	protected OutputConfiguration createAndOverlayOutputConfiguration(IPreferenceStore store, OutputConfiguration output) {
		OutputConfiguration result = new OutputConfiguration(output.getName());
		boolean clearOutputDirectory = getBoolean(output, OUTPUT_CLEAN_DIRECTORY, store,
				output.isCanClearOutputDirectory());
		result.setCanClearOutputDirectory(clearOutputDirectory);
		boolean cleanUpDerivedResources = getBoolean(output, OUTPUT_CLEANUP_DERIVED, store,
				output.isCleanUpDerivedResources());
		result.setCleanUpDerivedResources(cleanUpDerivedResources);
		boolean createOutputDirectory = getBoolean(output, OUTPUT_CREATE_DIRECTORY, store,
				output.isCreateOutputDirectory());
		result.setCreateOutputDirectory(createOutputDirectory);
		boolean overrideExistingResources = getBoolean(output, OUTPUT_OVERRIDE, store,
				output.isOverrideExistingResources());
		result.setOverrideExistingResources(overrideExistingResources);
		boolean setDerivedProperty = getBoolean(output, OUTPUT_DERIVED, store, output.isSetDerivedProperty());
		result.setSetDerivedProperty(setDerivedProperty);
		String description = getString(output, OUTPUT_DESCRIPTION, store, output.getDescription());
		result.setDescription(description);
		String directory = getString(output, OUTPUT_DIRECTORY, store, output.getOutputDirectory());
		result.setOutputDirectory(directory);
		return result;
	}

	private boolean getBoolean(OutputConfiguration outputConfiguration, String name, IPreferenceStore preferenceStore,
			Boolean defaultValue) {
		String preferenceKey = getKey(outputConfiguration, name);
		return preferenceStore.contains(preferenceKey) ? preferenceStore.getBoolean(preferenceKey) : defaultValue;
	}

	private String getString(OutputConfiguration outputConfiguration, String name, IPreferenceStore preferenceStore,
			String defaultValue) {
		String preferenceKey = getKey(outputConfiguration, name);
		return preferenceStore.contains(preferenceKey) ? preferenceStore.getString(preferenceKey) : defaultValue;
	}

	private String getKey(OutputConfiguration outputConfiguration, String preferenceName) {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + outputConfiguration.getName()
				+ PreferenceConstants.SEPARATOR + preferenceName;
	}

}
