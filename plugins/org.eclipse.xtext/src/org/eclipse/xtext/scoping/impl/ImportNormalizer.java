/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class ImportNormalizer {

	private final QualifiedName importedNamespacePrefix;

	private final boolean hasWildCard;

	private final boolean ignoreCase;

	public ImportNormalizer(QualifiedName importedNamespace, boolean wildCard, boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
		if (importedNamespace == null || importedNamespace.getSegmentCount() < 1) {
			throw new IllegalArgumentException("Imported namespace must not be null / empty");
		}
		hasWildCard = wildCard;
		this.importedNamespacePrefix = importedNamespace;
	}

	public QualifiedName deresolve(QualifiedName fullyQualifiedName) {
		if (hasWildCard) {
			if (!ignoreCase) {
				if (fullyQualifiedName.startsWith(importedNamespacePrefix) 
						&& fullyQualifiedName.getSegmentCount() != importedNamespacePrefix.getSegmentCount()) {
					return fullyQualifiedName.skipFirst(importedNamespacePrefix.getSegmentCount());
				}
			} else {
				if (fullyQualifiedName.startsWithIgnoreCase(importedNamespacePrefix) 
					&& fullyQualifiedName.getSegmentCount() != importedNamespacePrefix.getSegmentCount()) {
					return fullyQualifiedName.skipFirst(importedNamespacePrefix.getSegmentCount());
				}
			}
		} else {
			if (!ignoreCase) {
				if (fullyQualifiedName.equals(importedNamespacePrefix))
					return QualifiedName.create(fullyQualifiedName.getLastSegment());
			} else {
				if (fullyQualifiedName.equalsIgnoreCase(importedNamespacePrefix))
					return QualifiedName.create(fullyQualifiedName.getLastSegment());
			}
		}
		return null;
	}

	public QualifiedName resolve(QualifiedName relativeName) {
		if (hasWildCard) {
			return importedNamespacePrefix.append(relativeName);
		} else {
			if (!ignoreCase) {
				if (relativeName.getSegmentCount()==1 && relativeName.getLastSegment().equals(importedNamespacePrefix.getLastSegment())) {
					return importedNamespacePrefix;
				}
			} else {
				if (relativeName.getSegmentCount()==1 && relativeName.getLastSegment().equalsIgnoreCase(importedNamespacePrefix.getLastSegment())) {
					return importedNamespacePrefix.skipLast(1).append(relativeName.getLastSegment());
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return importedNamespacePrefix.toString() + (hasWildCard ? ".*" : "");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (obj instanceof ImportNormalizer) {
			ImportNormalizer other = (ImportNormalizer)obj;
			//TODO not ignore case aware
			return other.hasWildCard==hasWildCard &&
				other.ignoreCase==ignoreCase &&
				other.importedNamespacePrefix.equals(importedNamespacePrefix);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return importedNamespacePrefix.hashCode();
	}

}