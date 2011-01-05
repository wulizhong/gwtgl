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

import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

/**
 * @author Steffen Schäfer
 * 
 */
public abstract class AbstractMethodCallGenerator extends Generator {

	/**
	 * The name of the generated class.
	 */
	protected String generatedClassName;
	/**
	 * The name of the package to use for the generated class.
	 */
	protected String packageName;

	/* (non-Javadoc)
	 * @see com.google.gwt.core.ext.Generator#generate(com.google.gwt.core.ext.TreeLogger, com.google.gwt.core.ext.GeneratorContext, java.lang.String)
	 */
	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {

		TypeOracle typeOracle = context.getTypeOracle();
		try {
			// get the type that was used in the GWT.create call.
			// this is the super class or interface for the generated class.
			JClassType superType = typeOracle.getType(typeName);

			// Generate the class if it doesn't exist yet
			return generateForSuperClass(logger, context, superType);
		} catch (Exception e) {
			logger.log(Type.ERROR, e.getMessage());
			throw new UnableToCompleteException();
		}
	}

	/**
	 * Calculates the name of the generated class.
	 * 
	 * @param context the GeneratorContext
	 * @param simpleSourceName the simple source name of the supertype
	 * @return the name of the class to be generated
	 */
	protected abstract String getGeneratedClassName(GeneratorContext context,
			String simpleSourceName);

	/**
	 * A possibility for the generator to add imports needed by the generated class.
	 * 
	 * @param composer the {@link ClassSourceFileComposerFactory} to add imports to
	 */
	protected abstract void addImports(ClassSourceFileComposerFactory composer);

	/**
	 * A possibility for the generator to add static contents to the generated class.
	 * 
	 * @param sourceWriter
	 */
	protected abstract void generateInitialClassContent(SourceWriter sourceWriter);

	/**
	 * Checks weather the methods of this type should be processed by the generator.
	 * 
	 * @param classType the class or interface to check.
	 * @return true if the type should be processed, false otherwise.
	 */
	protected abstract boolean checkType(JClassType classType);

	/**
	 * Generator method for all processed methods.
	 * 
	 * @param sourceWriter the {@link SourceWriter} to generate the methods with.
	 * @param method the method to process.
	 */
	protected abstract void generateForMethod(SourceWriter sourceWriter, JMethod method);

	private String generateForSuperClass(TreeLogger logger,
			GeneratorContext context, JClassType superType) {

		packageName = superType.getPackage().getName();
		String simpleSourceName = superType.getSimpleSourceName();
		generatedClassName = getGeneratedClassName(context, simpleSourceName);
		String qualifiedClassName = packageName + "." + generatedClassName;

		PrintWriter printWriter = context.tryCreate(logger, packageName,
				generatedClassName);

		if (printWriter == null) {
			// the generated type already exists
			return qualifiedClassName;
		}

		generateNewClass(logger, context, superType, printWriter);
		return qualifiedClassName;
	}

	/**
	 * Generates the new class using the given super type (super class or interface).
	 * 
	 * @param logger the logger to use.
	 * @param context the GeneratorContext to use.
	 * @param superType the super type to generate a concrete implemetation for.
	 * @param printWriter the {@link PrintWriter} to generate the contents with.
	 */
	private void generateNewClass(TreeLogger logger, GeneratorContext context,
			JClassType superType, PrintWriter printWriter) {
		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(
				packageName, generatedClassName);
		if (superType.isInterface() != null) {
			composer.addImplementedInterface(superType.isClassOrInterface()
					.getQualifiedSourceName());
		} else if (superType.isClass() != null) {
			composer.setSuperclass(superType.isClassOrInterface()
					.getQualifiedSourceName());
		}

		addImports(composer);

		SourceWriter sourceWriter = composer.createSourceWriter(context,
				printWriter);

		generateInitialClassContent(sourceWriter);

		processType(superType, sourceWriter);

		sourceWriter.commit(logger);
	}

	/**
	 * recursively processes the methods of the given type and all super classes and interfaces.
	 * 
	 * @param typeToProcess the type to process.
	 * @param sourceWriter the {@link SourceWriter} to use when generating the class contents.
	 */
	private void processType(JClassType typeToProcess, SourceWriter sourceWriter) {
		if (!checkType(typeToProcess)) {
			return;
		}

		// generate the implementation of all defined methods
		JMethod[] methods = typeToProcess.getMethods();
		for (JMethod method : methods) {
			// only process methods of interfaces and abstract methods.
			if(typeToProcess.isInterface() != null || method.isAbstract()) {
				generateForMethod(sourceWriter, method);
			}
		}

		// process all interfaces
		for (JClassType clazz : typeToProcess.getImplementedInterfaces()) {
			processType(clazz, sourceWriter);
		}
		// process the super class
		processType(typeToProcess.getSuperclass(), sourceWriter);
	}

}
