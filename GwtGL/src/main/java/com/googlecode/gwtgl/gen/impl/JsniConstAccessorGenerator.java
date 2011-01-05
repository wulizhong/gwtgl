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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.SelectionProperty;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.googlecode.gwtgl.gen.api.GenConst;
import com.googlecode.gwtgl.gen.api.JsName;

/**
 * @author Steffen Schäfer
 *
 */
public class JsniConstAccessorGenerator extends AbstractMethodCallGenerator {

	private String jsType;

	@Override
	protected String getGeneratedClassName(GeneratorContext context, TreeLogger logger,
			String simpleSourceName) {
		return simpleSourceName + "Binding_"+getUserAgent(logger, context);
	}
	
	private String getUserAgent(TreeLogger logger, GeneratorContext context) {
		SelectionProperty userAgentProp;
		try {
			userAgentProp = context.getPropertyOracle().getSelectionProperty(logger, "user.agent");
		} catch (BadPropertyValueException e) {
			throw new IllegalArgumentException("The property user.agent is not defined!");
		}
		return userAgentProp.getCurrentValue();
	}

	@Override
	protected void addImports(ClassSourceFileComposerFactory composer) {
		composer.addImport(JavaScriptObject.class.getName());
	}

	@Override
	protected void generateInitialClassContent(SourceWriter sourceWriter) {
		// nothing to do
	}

	@Override
	protected void preprocessSuperType(TreeLogger logger, GeneratorContext context, JClassType superType) {
		GenConst genConst = superType.getAnnotation(GenConst.class);
		if(genConst == null) {
			throw new IllegalArgumentException("The type has no annotation of type GenConst");
		}
		String typeProperty = genConst.value();
		SelectionProperty selectionProperty;
		try {
			selectionProperty = context.getPropertyOracle().getSelectionProperty(logger, typeProperty);
		} catch (BadPropertyValueException e) {
			throw new IllegalArgumentException("The property "+typeProperty+" is not defined!");
		}
		jsType = selectionProperty.getCurrentValue();
		if(jsType == null) {
			throw new IllegalArgumentException("The property "+typeProperty+" has no value!");
		}
	}

	@Override
	protected boolean checkType(JClassType classType) {
		if ("java.lang.Object".equals(classType
				.getQualifiedSourceName())) {
			return false;
		}
		return true;
	}

	@Override
	protected void generateForMethod(SourceWriter sourceWriter, JMethod method) {
		JsName jsName = method.getAnnotation(JsName.class);
		String jsConst = method.getName();
		if(jsName!=null) {
			jsConst=jsName.value();
		}
		
		JType returnType = method.getReturnType();
		String ret = returnType.getQualifiedSourceName();

		sourceWriter.println("public native " + ret + " " + method.getName()
				+ "() /*-{");
			sourceWriter.println("return " + jsType + "." + jsConst + ";");

		sourceWriter.println("}-*/;");
	}

}
