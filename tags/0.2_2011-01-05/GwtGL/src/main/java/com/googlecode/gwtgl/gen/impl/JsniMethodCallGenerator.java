/**   
 * Copyright 2009-2011 Sönke Sothmann, Steffen Schäfer and others
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.googlecode.gwtgl.gen.api.IBinding;
import com.googlecode.gwtgl.gen.api.JsName;
import com.googlecode.gwtgl.util.JsArrayUtil;

/**
 * @author Steffen Schäfer
 *
 */
public class JsniMethodCallGenerator extends AbstractMethodCallGenerator {

	@Override
	protected String getGeneratedClassName(GeneratorContext context, TreeLogger logger,
			String simpleSourceName) {
		return simpleSourceName + "Binding";
	}

	@Override
	protected void addImports(ClassSourceFileComposerFactory composer) {
		composer.addImport(JavaScriptObject.class.getName());
		composer.addImport(JsArrayNumber.class.getName());
		composer.addImport(JsArrayInteger.class.getName());
		composer.addImport(JsArrayUtil.class.getName());
		composer.addImport(GWT.class.getName());
	}

	@Override
	protected void generateInitialClassContent(SourceWriter sourceWriter) {
		// create the native obj field and the init method impl
		sourceWriter.println("private JavaScriptObject nativeObj;");
		sourceWriter.println("public void init(JavaScriptObject nativeObj) {");
		sourceWriter.println("this.nativeObj = nativeObj;");
		sourceWriter.println("}");
		sourceWriter.println();
	}

	@Override
	protected boolean checkType(JClassType classType) {
		if (IBinding.class.getPackage().getName()
				.equals(classType.getPackage().getName())
				&& IBinding.class.getSimpleName().equals(
						classType.getSimpleSourceName())) {
			// The initialization code for this interface is already generated
			return false;
		} else if ("java.lang.Object".equals(classType
				.getQualifiedSourceName())) {
			return false;
		}
		return true;
	}
	
	@Override
	protected void generateForMethod(SourceWriter sourceWriter, JMethod method) {
		generateForMethodWrapper(sourceWriter, method);
		generateForMethodNative(sourceWriter, method, true);
		generateForMethodNative(sourceWriter, method, false);
	}

	private void generateForMethodWrapper(SourceWriter sourceWriter,
			JMethod method) {

		sourceWriter.print(method.getReadableDeclaration(false, false, false,
				false, true));
		sourceWriter.println(" {");

		sourceWriter.println("if(GWT.isScript()) {");
		generateMethodCall(sourceWriter, method, false);
		sourceWriter.println("} else {");
		generateMethodCall(sourceWriter, method, true);
		sourceWriter.println("}");

		sourceWriter.println("}");
	}

	private void generateMethodCall(SourceWriter sourceWriter, JMethod method,
			boolean devMode) {
		JType returnType = method.getReturnType();
		String ret = returnType.getQualifiedSourceName();
		if (!"void".equals(ret)) {
			sourceWriter.print("return ");
		}

		if (devMode) {
			sourceWriter.print(method.getName() + "Dev(");
		} else {
			sourceWriter.print(method.getName() + "Prod(");
		}

		boolean first = true;
		for (JParameter parameter : method.getParameters()) {
			if (!first) {
				sourceWriter.print(", ");
			}
			first = false;
			if (devMode && parameter.getType().isArray() != null) {
				sourceWriter.print("JsArrayUtil.wrapArray(");
			}
			sourceWriter.print(parameter.getName());
			if (devMode && parameter.getType().isArray() != null) {
				sourceWriter.print(")");
			}
		}
		sourceWriter.print(");");
	}

	private void generateForMethodNative(SourceWriter sourceWriter,
			JMethod method, boolean devMode) {
		JsName jsName = method.getAnnotation(JsName.class);
		String jsMethod = method.getName();
		if (jsName != null) {
			jsMethod = jsName.value();
		}

		JType returnType = method.getReturnType();
		String ret = returnType.getQualifiedSourceName();

		String methodDeclaration = method.getReadableDeclaration(false, false,
				false, false, true).replaceFirst("public", "public native");
		if (devMode) {
			methodDeclaration = methodDeclaration.replaceAll(method.getName(),
					method.getName() + "Dev");
		} else {
			methodDeclaration = methodDeclaration.replaceAll(method.getName(),
					method.getName() + "Prod");
		}
		if (devMode) {
			methodDeclaration = methodDeclaration.replaceAll("float\\[\\]",
					"JsArrayNumber");
			methodDeclaration = methodDeclaration.replaceAll("double\\[\\]",
					"JsArrayNumber");
			methodDeclaration = methodDeclaration.replaceAll("int\\[\\]",
					"JsArrayInteger");
		}
		sourceWriter.print(methodDeclaration);

		sourceWriter.println(" /*-{");
		if (!"void".equals(ret)) {
			sourceWriter.print("return ");
		}

		sourceWriter.print("this.@" + packageName + "." + generatedClassName
				+ "::nativeObj." + jsMethod + "(");

		boolean first = true;
		for (JParameter parameter : method.getParameters()) {
			if (!first) {
				sourceWriter.print(", ");
			}
			first = false;
			sourceWriter.print(parameter.getName());
		}
		sourceWriter.print(")");
		sourceWriter.println(";");

		sourceWriter.println("}-*/;");
	}

	@Override
	protected void preprocessSuperType(TreeLogger logger,
			GeneratorContext context, JClassType superType) {
		// nothing to do
	}
}
