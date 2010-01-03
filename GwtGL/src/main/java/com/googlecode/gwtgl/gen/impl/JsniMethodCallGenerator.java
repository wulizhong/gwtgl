/**   
 * Copyright 2009 Sönke Sothmann & Steffen Schäfer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.gen.impl;

import java.io.PrintWriter;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.googlecode.gwtgl.gen.api.IBinding;
import com.googlecode.gwtgl.gen.api.JsName;
import com.googlecode.gwtgl.gen.api.Unwrap;
import com.googlecode.gwtgl.gen.api.Wrap;


/**
 * @author Steffen Schäfer
 *
 */
public class JsniMethodCallGenerator extends Generator {

	private String qualifiedInterfaceName;
	private String qualifiedClassName;
	private String className;
	private String packageName;
	private ClassSourceFileComposerFactory composer;

	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		
		TypeOracle typeOracle = context.getTypeOracle();
		try {
			// get class infos
			JClassType interfaceType = typeOracle.getType(typeName);
			if(interfaceType.isInterface()==null) {
				throw new IllegalArgumentException("The generator only works for interfaces.");
			}
			qualifiedInterfaceName = interfaceType.isInterface().getQualifiedSourceName();
			packageName = interfaceType.getPackage().getName();
			String simpleInterfaceName = interfaceType.getSimpleSourceName();
			className = simpleInterfaceName + "Binding";
			qualifiedClassName = packageName+"."+className;
			// Generate the class if it doesn't exist yet
			generateBindingClass(logger, context, interfaceType);
		} catch (Exception e) {
			logger.log(Type.ERROR, e.getMessage());
			throw new UnableToCompleteException();
		}
		return qualifiedClassName;

	}

	private void generateBindingClass(TreeLogger logger,
			GeneratorContext context, JClassType classType) {

		PrintWriter printWriter = context.tryCreate(logger, packageName,
				className);

		if (printWriter == null) {
			return;
		}

		composer = null;
		composer = new ClassSourceFileComposerFactory(packageName, className);
		composer.addImplementedInterface(qualifiedInterfaceName);
		composer.addImport(JavaScriptObject.class.getName());
		SourceWriter sourceWriter = null;
		sourceWriter = composer.createSourceWriter(context, printWriter);

		// create the native obj field and the init method impl
		sourceWriter.println("private JavaScriptObject nativeObj;");
		sourceWriter.println("public void init(JavaScriptObject nativeObj) {");
		sourceWriter.println("this.nativeObj = nativeObj;");
		sourceWriter.println("}");
		sourceWriter.println();

		generateForType(classType, sourceWriter);
		
		sourceWriter.commit(logger);
	}

	private void generateForType(JClassType classType, SourceWriter sourceWriter) {
		if (IBinding.class.getPackage().getName().equals(
				classType.getPackage().getName())
				&& IBinding.class.getSimpleName().equals(
						classType.getSimpleSourceName())) {
			// The initialization code for this interface is already generated
			return;
		}
		
		// generate the implementation of all defined methods
		JMethod[] methods = classType.getMethods();
		for (JMethod method : methods) {
			JsName jsName = method.getAnnotation(JsName.class);
			String jsMethod = method.getName();
			if(jsName!=null) {
				jsMethod=jsName.value();
			}
			
			JType returnType = method.getReturnType();
			String ret = returnType.getQualifiedSourceName();
			
			sourceWriter.print(method.getReadableDeclaration(false, false, false, false, true).replaceFirst("public", "public native"));
			
			boolean wrapped=false;
			sourceWriter.println(" /*-{");
			if (!"void".equals(ret)) {
				sourceWriter.print("return ");
				Wrap wrap=method.getAnnotation(Wrap.class);
				if(wrap!=null) {
					wrapped=true;
					Class<?> wrapperClass=wrap.value();
					// TODO generic impl to find constructor with param that is JavaScriptObject or a subclass
					sourceWriter.print("@"+wrapperClass.getPackage().getName()+"."+wrapperClass.getSimpleName()+
							"::new(Lcom/google/gwt/core/client/JavaScriptObject;)(");
				}
			}

			sourceWriter.print("this.@" + packageName + "." + className
					+ "::nativeObj." + jsMethod + "(");

			boolean first = true;
			for (JParameter parameter : method.getParameters()) {
				if (!first) {
					sourceWriter.print(", ");
				}
				first = false;
				sourceWriter.print(parameter.getName());
				Unwrap unwrap=parameter.getAnnotation(Unwrap.class);
				if(unwrap != null) {
					JType paramType = parameter.getType();
					sourceWriter.print(".@"+paramType.getQualifiedSourceName()+"::");
					sourceWriter.print(unwrap.value()+"()()");
				}
			}
			sourceWriter.print(")");
			if(wrapped) {
				sourceWriter.print(")");
			}
			sourceWriter.println(";");

			sourceWriter.println("}-*/;");
		}
		
		for(JClassType clazz:classType.getImplementedInterfaces()) {
			generateForType(clazz, sourceWriter);
		}
	}

}
