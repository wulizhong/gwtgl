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
package com.googlecode.gwtgl.wrapper;

import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.wrapper.enums.ShaderType;

/**
 * A wrapper for the shader
 * @author Steffen Schäfer
 * 
 */
public class Shader {

	final WebGLShader nativeShaderObject;
	private final WebGLRenderingContext glContext;
	private final WebGLWrapper webGLWrapper;
	
	/**
	 * Creates a Shader of the given type associated to the given webGLWrapper.
	 * 
	 * @param webGLWrapper
	 * @param shaderType
	 */
	public Shader(WebGLWrapper webGLWrapper, ShaderType shaderType) {
		this.webGLWrapper = webGLWrapper;
		this.glContext = webGLWrapper.glContext;
		this.nativeShaderObject = glContext.createShader(shaderType.getIntValue());
	}
	
	/**
	 * Creates a Shader of the given type associated to the given webGLWrapper.
	 * The shader source is set and the shader is compiled afterwards.
	 * 
	 * @param webGLWrapper
	 * @param shaderType
	 * @param source
	 */
	public Shader(WebGLWrapper webGLWrapper, ShaderType shaderType, String source) {
		this(webGLWrapper, shaderType);
		setSourceAndCompile(source);
	}

	/**
	 * @param source
	 */
	public void setSourceAndCompile(String source) {
		setSource(source);
		compile();
	}

	/**
	 * @param source
	 */
	public void setSource(String source) {
		glContext.shaderSource(nativeShaderObject, source);
	}

	/**
	 * TODO throw exception if compile is not successful
	 */
	public void compile() {
		glContext.compileShader(nativeShaderObject);
	}

	/**
	 * Delete the underlying Shader object.
	 */
	public void delete() {
		glContext.deleteShader(nativeShaderObject);
	}
	
	/**
	 * Returns if the Shader is successfully compiled.
	 * 
	 * @return true, if the shader is compiled, false otherwise
	 */
	public boolean isCompiled() {
		return glContext.getShaderParameterb(nativeShaderObject, WebGLRenderingContext.COMPILE_STATUS);
	}
	
	/**
	 * Returns if the Shader is deleted.
	 * 
	 * @return true, if the shader is deleted, false otherwise
	 */
	public boolean isDeleted() {
		return glContext.getShaderParameterb(nativeShaderObject, WebGLRenderingContext.DELETE_STATUS);
	}

	/**
	 * Returns the Type of the Shader Object.
	 * 
	 * @return the Type of the Shader Object 
	 */
	public ShaderType getShaderType() {
		int val = glContext.getShaderParameteri(nativeShaderObject, WebGLRenderingContext.SHADER_TYPE);
		return ShaderType.getByIntValue(val);
	}
	
	/**
	 * Returns the length of the info log of this Shader.
	 * 
	 * @return the length of the info log
	 */
	public int getInfoLogLength() {
		return glContext.getShaderParameteri(nativeShaderObject, WebGLRenderingContext.INFO_LOG_LENGTH);
	}
	
	/**
	 * Returns the Shader source length.
	 * 
	 * @return the Shader source length
	 */
	public int getShaderSourceLength() {
		return glContext.getShaderParameteri(nativeShaderObject, WebGLRenderingContext.SHADER_SOURCE_LENGTH);
	}

	/**
	 * Returns the contents of the shaders info log.
	 * 
	 * @return the contents of the shaders info log
	 */
	public String getInfoLog() {
		return glContext.getShaderInfoLog(nativeShaderObject);
	}

	/**
	 * Returns the {@link WebGLWrapper} the Shader is associated to.
	 * 
	 * @return the {@link WebGLWrapper} the Shader is associated to
	 */
	public WebGLWrapper getWebGLWrapper() {
		return webGLWrapper;
	}
}
