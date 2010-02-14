/**   
 * Copyright 2009-2010 Sönke Sothmann & Steffen Schäfer
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
import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.SelectionProperty;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.googlecode.gwtgl.gen.api.GenConst;
import com.googlecode.gwtgl.gen.api.JsName;

/**
 * @author Steffen Schäfer
 *
 */
public class JsniConstAccessorGenerator extends Generator {

	/** Simple name of class to be generated */
	private String className = null;

	/** Package name of class to be generated */
	private String packageName = null;

	private String simpleSourceName;

	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		
		TypeOracle typeOracle = context.getTypeOracle();
		try {
			// get class infos
			JClassType classType = typeOracle.getType(typeName);
			packageName = classType.getPackage().getName();
			simpleSourceName = classType.getSimpleSourceName();
			className = simpleSourceName + "Binding_"+getUserAgent(logger, context);
			// Generate the class if it doesn't exist yet
			generateBindingClass(logger, context, classType);
		} catch (Exception e) {
			logger.log(Type.ERROR, e.getMessage());
			throw new UnableToCompleteException();
		}
		return packageName + "." + className;

	}

	private void generateBindingClass(TreeLogger logger,
			GeneratorContext context, JClassType classType) {

		PrintWriter printWriter = context.tryCreate(logger, packageName,
				className);

		if (printWriter == null) {
			return;
		}

		ClassSourceFileComposerFactory composer = null;
		composer = new ClassSourceFileComposerFactory(packageName, className);
		composer.addImplementedInterface(packageName + "." + simpleSourceName);
		composer.addImport(JavaScriptObject.class.getName());
		SourceWriter sourceWriter = null;
		sourceWriter = composer.createSourceWriter(context, printWriter);
		
		GenConst genConst = classType.getAnnotation(GenConst.class);
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
		String jsType = selectionProperty.getCurrentValue();
		if(jsType == null) {
			throw new IllegalArgumentException("The property "+typeProperty+" has no value!");
		}

		// generate the implementation of all defined methods
		JMethod[] methods = classType.getMethods();
		for (JMethod method : methods) {
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

		sourceWriter.commit(logger);
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

}
