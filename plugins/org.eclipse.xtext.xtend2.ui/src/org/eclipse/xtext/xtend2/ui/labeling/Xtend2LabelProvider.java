/*
* generated by Xtext
*/
package org.eclipse.xtext.xtend2.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class Xtend2LabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	private UIStrings uiStrings;

	@Inject
	private Xtend2Images images;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Inject
	public Xtend2LabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public Image image(XtendFile element) {
		return images.forFile();
	}

	public Image image(XtendImport element) {
		return images.forImport();
	}

	public Image image(XtendClass element) {
		return images.forClass(0);
	}

	public Image image(XtendFunction element) {
		return images.forFunction(0);
	}

	public Image image(JvmOperation element) {
		return images.forDispatcherFunction(0);
	}
	
	public Image image(DeclaredDependency element) {
		return images.forDependency(element.isExtension());
	}

	public String text(XtendFile element) {
		return element.eResource().getURI().trimFileExtension().lastSegment();
	}

	public String text(XtendImport element) {
		return element.getImportedNamespace();
	}

	public String text(XtendClass element) {
		return element.getName() + ((element.getTypeParameters().isEmpty()) ? "" : uiStrings.typeParameters(element));
	}

	public String text(XtendFunction element) {
		return signature(element.getSimpleName(), xtend2jvmAssociations.getDirectlyInferredOperation(element));
	}
	
	public String text(DeclaredDependency element) {
		return element.getSimpleName() +" : " +element.getType().getSimpleName();
	}

	public String text(JvmOperation element) {
		return signature(element.getSimpleName(), element);
	}

	protected String signature(String simpleName, JvmIdentifiableElement element) {
		JvmTypeReference returnType = typeProvider.getTypeForIdentifiable(element);
		return simpleName + uiStrings.parameters(element) + " : "
				+ ((returnType != null) ? returnType.getSimpleName() : "void");
	}

}