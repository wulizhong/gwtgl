/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
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

import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;

/**
 * A wrapper class for the shader program
 * @author Steffen Schäfer
 *
 */
public class ShaderProgram {
	
	final WebGLProgram nativeProgramObject;
	private final WebGLRenderingContext glContext;
	private final WebGLWrapper webGLWrapper;

	/**
	 * Creates a ShaderProgram associated to the given webGLWrapper.
	 * 
	 * @param webGLWrapper
	 */
	public ShaderProgram(WebGLWrapper webGLWrapper) {
		this.webGLWrapper = webGLWrapper;
		this.glContext = webGLWrapper.glContext;
		this.nativeProgramObject = glContext.createProgram();
	}
	
	/**
	 * Creates a Texture2D associated to the given webGLWrapper. The given Shaders are attached to the
	 * ShaderProgram and the ShaderProgram is linked.
	 * 
	 * @param webGLWrapper
	 * @param shaders
	 */
	public ShaderProgram(WebGLWrapper webGLWrapper, Shader... shaders) {
		this(webGLWrapper);
		for(Shader shader:shaders) {
			attachShader(shader);
		}
		linkProgram();
	}
	
	// TODO check if this is correct and make the method public
	@SuppressWarnings("unused")
	private boolean isCurrent() {
		WebGLProgram program = glContext.getParameter(WebGLRenderingContext.CURRENT_PROGRAM);
		if(program == nativeProgramObject || nativeProgramObject.equals(program)) {
			return true;
		}
		return false;
	}

	/**
	 * Attaches the given Shader to the ShaderProgram.
	 * 
	 * @param shader the shader to attach
	 */
	public void attachShader(Shader shader) {
		glContext
				.attachShader(nativeProgramObject, shader.nativeShaderObject);
	}
	
	/**
	 * Links the ShaderProgram.
	 */
	public void linkProgram() {
		glContext.linkProgram(nativeProgramObject);
	}

	/**
	 * Delete the underlying Program object.
	 */
	public void delete() {
		glContext.deleteProgram(nativeProgramObject);
	}
	
	/**
	 * Returns if the ShaderProgram is successfully linked.
	 * 
	 * @return true, if the program is linked, false otherwise
	 */
	public boolean isLinked() {
		return glContext.getProgramParameterb(nativeProgramObject, WebGLRenderingContext.LINK_STATUS);
	}
	
	/**
	 * Returns if the ShaderProgram is deleted.
	 * 
	 * @return true, if the program is deleted, false otherwise
	 */
	public boolean isDeleted() {
		return glContext.getProgramParameterb(nativeProgramObject, WebGLRenderingContext.DELETE_STATUS);
	}
	
	/**
	 * Returns if the ShaderProgram is valid.
	 * 
	 * @return true, if the program is valid, false otherwise
	 */
	public boolean isValid() {
		return glContext.getProgramParameterb(nativeProgramObject, WebGLRenderingContext.VALIDATE_STATUS);
	}
	
	/**
	 * Returns the info log length.
	 * 
	 * @return the info log length
	 */
	public int getInfoLogLength() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.INFO_LOG_LENGTH);
	}
	
	/**
	 * Returns the active attribute max length length.
	 * 
	 * @return the active attribute max length length
	 */
	public int getActiveAttributeMaxLength() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.ACTIVE_ATTRIBUTE_MAX_LENGTH);
	}
	
	/**
	 * Returns the active uniform max length length.
	 * 
	 * @return the active uniform max length length
	 */
	public int getActiveUniformMaxLength() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.ACTIVE_UNIFORM_MAX_LENGTH);
	}
	
	/**
	 * Returns the number of attached shaders.
	 * 
	 * @return the number of attached shaders
	 */
	public int getNumAttachedShaders() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.ATTACHED_SHADERS);
	}

	/**
	 * Returns the number active uniforms.
	 * 
	 * @return the number active uniforms
	 */
	public int getNumActiveUniforms() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.ACTIVE_UNIFORMS);
	}
	
	/**
	 * Returns the number active attributes.
	 * 
	 * @return the number active attributes
	 */
	public int getNumActiveAttributes() {
		return glContext.getProgramParameteri(nativeProgramObject, WebGLRenderingContext.ACTIVE_ATTRIBUTES);
	}
	
	/**
	 * Sets the ShaderProgram as active ShaderProgram.
	 */
	public void useProgram() {
		glContext.useProgram(nativeProgramObject);
	}
	
	/**
	 * Returns the location of the attribute with the given name.
	 * 
	 * @param name
	 * @return the location of the attribute with the given name
	 */
	public int getAttribLocation(String name) {
		return glContext.getAttribLocation(nativeProgramObject, name);
	}
	
	/**
	 * Returns the location of the uniform variable with the given name.
	 * 
	 * @param name
	 * @return the location of the uniform variable with the given name
	 */
	public WebGLUniformLocation getUniformLocation(String name) {
		return glContext.getUniformLocation(nativeProgramObject, name);
	}
	
	/**
	 * Binds the Attribute with the given name to the given index.
	 * 
	 * @param idx
	 * @param name
	 */
	public void bindAttribLocation(int idx, String name) {
		glContext.bindAttribLocation(nativeProgramObject, idx, name);
	}
	
	/**
	 * Returns the current contents of the program info log.
	 * 
	 * @return the current contents of the program info log
	 */
	public String getProgramInfoLog() {
		return glContext.getProgramInfoLog(nativeProgramObject);
	}

	/**
	 * Returns the {@link WebGLWrapper} the ShaderProgram is associated to.
	 * 
	 * @return the {@link WebGLWrapper} the ShaderProgram is associated to
	 */
	public WebGLWrapper getWebGLWrapper() {
		return webGLWrapper;
	}

}
