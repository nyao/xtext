/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTrace implements ITrace {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceRegistry;
	
	@Inject
	private IStorage2UriMapper storage2uriMapper;
	
	@Inject
	private IWorkspaceRoot workspaceRoot;
	
	/**
	 * Returns the root trace region where {@link TraceRegion#getFromOffset()} and
	 * {@link TraceRegion#getFromLength()} return the information for the
	 * resource that this {@link ITrace} is associated with. 
	 * @return the root trace region. May be <code>null</code> if no trace data is available.
	 */
	protected abstract ITraceRegion getRootTraceRegion();
	
	public ILocationInResource getBestAssociatedLocation(ITextRegion region) {
		ITraceRegion left = findLeafAtLeftOffset(region.getOffset());
		ITraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
		return mergeRegions(left, right);
	}

	protected ILocationInResource mergeRegions(ITraceRegion left, ITraceRegion right) {
		if (left == null) {
			if (right != null)
				return createLocationInResourceFor(right);
			return null;
		}
		if (right == null || left.equals(right)) {
			return createLocationInResourceFor(left);
		} else if (left.getToPath().equals(right.getToPath())) {
			return createLocationInResourceFor(left, right);	
		} 
		// TODO the remaining cases have yet to be implemented
		throw new IllegalStateException("TODO the remaining cases have yet to be implemented");
	}

	/**
	 * Creates a new location for a target resource that matches the given {@code traceRegion}.
	 * @param traceRegion the start of the location
	 * @return the location in resource. Never <code>null</code>.
	 */
	protected ILocationInResource createLocationInResourceFor(ITraceRegion traceRegion) {
		return createLocationInResourceFor(traceRegion, traceRegion);
	}
	
	/**
	 * Creates a new location for a target resource where the location spans more than one trace region.
	 * The given left and right region have to point to the very same resource and project.
	 * @param left the start of the location
	 * @param right the end of the location
	 * @return the location in resource. Never <code>null</code>.
	 */
	protected ILocationInResource createLocationInResourceFor(ITraceRegion left, ITraceRegion right) {
		int offset = left.getToOffset();
		int length = right.getToLength() + right.getToOffset() - offset;
		return new OffsetBasedLocationInResource(offset, length, left.getToPath(), left.getToProjectName(), this);
	}

	public ITraceRegion findLeafAtRightOffset(int offset) {
		return findLeafNodeAt(offset, false);
	}

	protected ITraceRegion findLeafNodeAt(int offset, boolean left) {
		ITraceRegion candidate = getRootTraceRegion();
		if (candidate == null || !encloses(candidate, offset, left)) {
			// we have an inconsistent state - no candidate matches
			return null;
		}
		outer: while(candidate != null) {
			List<TraceRegion> children = candidate.getNestedRegions();
			if (children.isEmpty()) {
				return candidate;
			}
			for(ITraceRegion child: children) {
				if (encloses(child, offset, left)) {
					candidate = child;
					continue outer;
				} else {
					if (child.getFromOffset() > offset)
						return candidate;
				}
			}
			return candidate;
		}
		return null;
	}

	public ITraceRegion findLeafAtLeftOffset(int offset) {
		return findLeafNodeAt(offset, true);
	}
	
	/**
	 * Calculate whether the given {@code region} encloses the offset.
	 * @param region the region to be checked. May not be <code>null</code>.
	 * @param offset the offset that should be enclosed by the region.
	 * @param includeRegionEnd whether a region is enclosing the offset if it ends at that location.
	 * @return <code>true</true> if the given region encloses the offset.
	 */
	public boolean encloses(ITraceRegion region, int offset, boolean includeRegionEnd) {
		if (offset < 0)
			// TODO should this be return false;?
			throw new IllegalArgumentException("offset may not be negative");
		int relativeOffset = offset - region.getFromOffset();
		boolean result = relativeOffset >= 0 && (includeRegionEnd ? relativeOffset <= region.getFromLength() : relativeOffset < region.getFromLength());
		return result;
	}
	
	/**
	 * Calculate whether the given {@code region} encloses the offset.
	 * @param regionOffset the start of the region that should be checked.
	 * @param regionLength the length of the region that should be checked.
	 * @param offset the offset that should be enclosed by the region.
	 * @param includeRegionEnd whether a region is enclosing the offset if it ends at that location.
	 * @return <code>true</true> if the given region encloses the offset.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public boolean encloses(int regionOffset, int regionLength, int offset, boolean includeRegionEnd) {
		if (offset < 0)
			// TODO should this be return false;?
			throw new IllegalArgumentException("offset may not be negative");
		int relativeOffset = offset - regionOffset;
		boolean result = relativeOffset == 0 || (relativeOffset > 0 && (includeRegionEnd ? relativeOffset <= regionLength : relativeOffset < regionLength));
		return result;
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region) {
		Iterable<ITraceRegion> allTraceRegions = getAllTraceRegions(region);
		return toLocations(allTraceRegions);
	}
	
	protected Iterable<ILocationInResource> toLocations(Iterable<ITraceRegion> allTraceRegions) {
		return Iterables.transform(allTraceRegions, new Function<ITraceRegion, ILocationInResource>() {
			public ILocationInResource apply(ITraceRegion input) {
				return createLocationInResourceFor(input);
			}
		});
	}

	protected Iterable<ITraceRegion> getAllTraceRegions(ITextRegion region) {
		final ITraceRegion left = findLeafAtLeftOffset(region.getOffset());
		final ITraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
		if (left == null || right == null) {
			return Collections.emptyList();
		}
		return new Iterable<ITraceRegion>() {

			public Iterator<ITraceRegion> iterator() {
				ITraceRegion root = getRootTraceRegion();
				if (root == null)
					return Iterators.emptyIterator();
				final Iterator<ITraceRegion> allLeafs = root.leafIterator();
				Iterator<ITraceRegion> result = new AbstractIterator<ITraceRegion>() {
					
					ITraceRegion first;
					{
						while(allLeafs.hasNext()) {
							ITraceRegion next = allLeafs.next();
							if (next.getFromOffset() == left.getFromOffset()) {
								this.first = next;
								break;
							}
						}
					}
					
					@Override
					protected ITraceRegion computeNext() {
						if (first != null) {
							ITraceRegion result = first;
							first = null;
							return result;
						}
						if (!allLeafs.hasNext())
							return endOfData();
						ITraceRegion candidate = allLeafs.next();
						if (candidate.getFromOffset() >= right.getFromOffset() + right.getFromLength()) {
							return endOfData();
						}
						return candidate;
					}
				};
				return result;
			}
			
		};
	}

	public Iterable<ILocationInResource> getAllLocations() {
		Iterable<ITraceRegion> allTraceRegions = getAllTraceRegions();
		return toLocations(allTraceRegions);		
	}
	
	protected Iterable<ITraceRegion> getAllTraceRegions() {
		return new Iterable<ITraceRegion>() {
			public Iterator<ITraceRegion> iterator() {
				ITraceRegion root = getRootTraceRegion();
				if (root == null)
					return Iterators.emptyIterator();
				final Iterator<ITraceRegion> result = root.leafIterator();
				return result;
			}
		};
	}

	protected Resource getResource(URI toPath, IProject project) {
		IResourceSetProvider resourceSetProvider = getService(toPath, IResourceSetProvider.class);
		if (resourceSetProvider != null) {
			ResourceSet resourceSet = resourceSetProvider.get(project);
			try {
				Resource result = resourceSet.getResource(toPath, true);
				return result;
			} catch(RuntimeException e) {
				// expected
				return null;
			}
		}
		return null;
	}

	protected IStorage findStorage(URI toPath, IProject project) {
		Iterable<Pair<IStorage, IProject>> allStorages = storage2uriMapper.getStorages(toPath);
		for(Pair<IStorage, IProject> storage: allStorages) {
			if (project.equals(storage.getSecond())) {
				return storage.getFirst();
			}
		}
		throw new IllegalStateException("No storage found for given path: " + toPath);
	}
	
	protected IProject findProject(String projectName) {
		IProject result = workspaceRoot.getProject(projectName);
		return result;
	}
	
	protected LanguageInfo findLanguage(URI toPath) {
		IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(toPath);
		if (serviceProvider != null) {
			return serviceProvider.get(LanguageInfo.class);
		}
		return null;
	}
	
	protected <T> T getService(URI toPath, Class<T> type) {
		IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(toPath);
		if (serviceProvider != null) {
			return serviceProvider.get(type);
		}
		return null;
	}

}