package org.eclipse.xtext.purexbase.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.jdt.annotation.NonNull

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. 
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link IJvmModelAssociator}.</p>     
 */
class PureXbaseJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder
	@Inject IEarlyExitComputer computer
	@Inject XbaseCompiler compiler

   	def dispatch void infer(Model m, @NonNull IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
   		val e  = m.block
   		acceptor.accept(e.toClass(e.eResource.name)).initializeLater [
   			annotations += e.toAnnotation(typeof(SuppressWarnings), "all")
   			members += e.toMethod("main", e.newTypeRef(Void::TYPE)) [
   				^static = true
   				parameters += e.toParameter("args", e.newTypeRef(typeof(String)).addArrayTypeDimension)
   				if (!e.containsReturn) {
   					setBody [
   						append("try {").increaseIndentation
   						e.compile(trace(e))
   						decreaseIndentation.newLine.append("} catch (Throwable t) {}")
   					]
   				} else {
   					setBody [append('''
						try {
							xbaseExpression();
						} catch (Throwable t) {}
   					'''.toString)]
   				}
   			]
   			if ( e.containsReturn ) {
   				members += e.toMethod("xbaseExpression", e.newTypeRef(typeof(Object))) [
   				^static = true
				setBody [
					append("if (Boolean.TRUE) ").increaseIndentation
					e.compile(trace(e))
					decreaseIndentation.newLine.append("return null;")
				]
   			]
   			}
   		]
   	}
   	
   	def name(Resource res) {
		val s = res.URI.lastSegment
		return s.substring(0, s.length - '.xbase'.length)
	}
	
	def containsReturn(XExpression expr) {
		val exitPoints = computer.getExitPoints(expr as XExpression)
		for (point : exitPoints) {
			if (point.expression instanceof XReturnExpression)
				return true
		}
		return false
	}
	
	def void compile(XBlockExpression obj, ITreeAppendable appendable) {
		appendable.increaseIndentation
		compiler.compile(obj, appendable, obj.newTypeRef(Void::TYPE))
		appendable.decreaseIndentation
	}
	
}
