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
package com.googlecode.gwtgl.binding;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtgl.gen.api.IBinding;
import com.googlecode.gwtgl.gen.api.JsName;
import com.googlecode.gwtgl.gen.api.Unwrap;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public interface WebGLRenderingContext extends IBinding {

	// ///////
	// Misc //
	// ///////
	
	void viewport(int x, int y, int w, int h);
	
	void lineWidth(float width);
	
	void flush();
	
	void finish();
	
	/**
	 * @param mask COLOR_BUFFER_BIT DEPTH_BUFFER_BIT STENCIL_BUFFER_BIT
	 */
	public void clear(int mask);
	
	void colorMask(boolean red, boolean green, boolean blue, boolean alpha);
	
	public void clearColor(float red, float green, float blue, float alpha);
	
	void scissor(int x, int y, int width, int height);
	

	/**
	 * @param param DEPTH_TEST
	 */
	public void enable(int param);

	public void disable(int param);

	public void enableVertexAttribArray(int attribArray);

	/**
	 * @param pname
	 *            ALIASED_LINE_WIDTH_RANGE, ALIASED_POINT_SIZE_RANGE,
	 *            ARRAY_BUFFER_BINDING, BLEND_COLOR, COLOR_CLEAR_VALUE,
	 *            COLOR_WRITEMASK, CURRENT_PROGRAM, DEPTH_RANGE,
	 *            ELEMENT_ARRAY_BUFFER_BINDING, FRAMEBUFFER_BINDING,
	 *            MAX_VIEWPORT_DIMS, RENDERBUFFER_BINDING, SCISSOR_BOX,
	 *            TEXTURE_BINDING_2D, TEXTURE_BINDING_CUBE_MAP, VIEWPORT
	 */
	// TODO one method per array type (WebGLFloatArray, ...)
	public <T extends JavaScriptObject> T getParameter(int pname);
	
	/**
	 * @param pname
	 *            ACTIVE_TEXTURE, ALPHA_BITS, BLEND_DST_ALPHA, BLEND_DST_RGB,
	 *            BLEND_EQUATION_ALPHA, BLEND_EQUATION_RGB, BLEND_SRC_ALPHA,
	 *            BLEND_SRC_RGB, BLUE_BITS, CULL_FACE_MODE, DEPTH_BITS,
	 *            DEPTH_FUNC, FRONT_FACE, GENERATE_MIPMAP_HINT, GREEN_BITS,
	 *            MAX_COMBINED_TEXTURE_IMAGE_UNITS, MAX_CUBE_MAP_TEXTURE_SIZE,
	 *            MAX_FRAGMENT_UNIFORM_VECTORS, MAX_RENDERBUFFER_SIZE,
	 *            MAX_TEXTURE_IMAGE_UNITS, MAX_TEXTURE_SIZE,
	 *            MAX_VARYING_VECTORS, MAX_VERTEX_ATTRIBS,
	 *            MAX_VERTEX_TEXTURE_IMAGE_UNITS, MAX_VERTEX_UNIFORM_VECTORS,
	 *            NUM_COMPRESSED_TEXTURE_FORMATS, PACK_ALIGNMENT, RED_BITS,
	 *            SAMPLE_BUFFERS, SAMPLES, STENCIL_BACK_FAIL, STENCIL_BACK_FUNC,
	 *            STENCIL_BACK_PASS_DEPTH_FAIL, STENCIL_BACK_PASS_DEPTH_PASS,
	 *            STENCIL_BACK_REF, STENCIL_BACK_VALUE_MASK,
	 *            STENCIL_BACK_WRITEMASK, STENCIL_BITS, STENCIL_CLEAR_VALUE,
	 *            STENCIL_FAIL, STENCIL_FUNC, STENCIL_PASS_DEPTH_FAIL,
	 *            STENCIL_PASS_DEPTH_PASS, STENCIL_REF, STENCIL_VALUE_MASK,
	 *            STENCIL_WRITEMASK, SUBPIXEL_BITS, UNPACK_ALIGNMENT
	 * @return
	 */
	@JsName("getParameter")
	public int getParameteri(int pname);

	/**
	 * @param pname
	 *            BLEND, CULL_FACE, DEPTH_TEST, DEPTH_WRITEMASK, DITHER,
	 *            POLYGON_OFFSET_FILL, SAMPLE_COVERAGE_INVERT, SCISSOR_TEST,
	 *            STENCIL_TEST
	 * @return
	 */
	@JsName("getParameter")
	public boolean getParameterb(int pname);

	/**
	 * @param pname
	 *            DEPTH_CLEAR_VALUE, LINE_WIDTH, POLYGON_OFFSET_FACTOR,
	 *            POLYGON_OFFSET_UNITS, SAMPLE_COVERAGE_VALUE
	 * @return
	 */
	@JsName("getParameter")
	public float getParameterf(int pname);

	/**
	 * @param idx
	 * @param size
	 * @param type FLOAT
	 * @param norm
	 * @param stride
	 * @param offset
	 */
	public void vertexAttribPointer(int idx, int size, int type, boolean norm,
			int stride, int offset);
	
	public int getError();
	
	// //////////
	// Buffers //
	// //////////

	public WebGLBuffer createBuffer();

	public JavaScriptObject deleteBuffer(WebGLBuffer buffer);

	public void isBuffer(WebGLBuffer buffer);

	/**
	 * @param target ARRAY_BUFFER ELEMENT_ARRAY_BUFFER
	 * @param buffer
	 */
	public void bindBuffer(int target, WebGLBuffer buffer);

	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param dta
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public void bufferData(int target, @Unwrap("getNativeArray") WebGLArray<?> dta, int usage);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param dta
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public void bufferData(int target, @Unwrap("getNativeBuffer") WebGLArrayBuffer dta, int usage);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param size the size of the buffer to create
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public void bufferData(int target, int size, int usage);

	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param offset
	 * @param data
	 */
	public void bufferSubData(int target, int offset, @Unwrap("getNativeArray") WebGLArray<?> data);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param offset
	 * @param data
	 */
	public void bufferSubData(int target, int offset, @Unwrap("getNativeBuffer") WebGLArrayBuffer data);

	/**
	 * @param target
	 * @param value BUFFER_SIZE, BUFFER_USAGE
	 * @return
	 */
	@JsName("getBufferParameter")
	public int getBufferParameteri(int target, int value);

	// ////////////////
	// Renderbuffers //
	// ////////////////

	public WebGLRenderbuffer createRenderbuffer();

	public void deleteRenderbuffer(WebGLRenderbuffer buffer);

	/**
	 * @param target RENDERBUFFER
	 * @param buffer
	 */
	public void bindRenderbuffer(int target, WebGLRenderbuffer buffer);

	/**
	 * @param target
	 * @param pname
	 *            RENDERBUFFER_WIDTH, RENDERBUFFER_HEIGHT,
	 *            RENDERBUFFER_INTERNAL_FORMAT, RENDERBUFFER_RED_SIZE,
	 *            RENDERBUFFER_GREEN_SIZE, RENDERBUFFER_BLUE_SIZE,
	 *            RENDERBUFFER_ALPHA_SIZE, RENDERBUFFER_DEPTH_SIZE,
	 *            RENDERBUFFER_STENCIL_SIZE
	 */
	public int getRenderbufferParameteri(int target, int pname);

	/**
	 * @param target
	 * @param format RGBA4 RGB565 RGB5_A1 DEPTH_COMPONENT16 STENCIL_INDEX8
	 * @param width
	 * @param height
	 */
	public void renderbufferStorage(int target, int format, int width,
			int height);

	public boolean isRenderbuffer(WebGLRenderbuffer buffer);

	// ///////////////////
	// Program objects //
	// ///////////////////

	public WebGLProgram createProgram();

	public void validateProgram(WebGLProgram program);

	public void linkProgram(WebGLProgram program);

	public void deleteProgram(WebGLProgram program);

	/**
	 * @param program
	 * @param param LINK_STATUS, DELETE_STATUS, VALIDATE_STATUS
	 * @return
	 */
	@JsName(value = "getProgramParameter")
	public boolean getProgramParameterb(WebGLProgram program,
			int param);

	/**
	 * @param program
	 * @param param
	 *            INFO_LOG_LENGTH, ACTIVE_ATTRIBUTE_MAX_LENGTH,
	 *            ACTIVE_UNIFORM_MAX_LENGTH, ATTACHED_SHADERS, ACTIVE_UNIFORMS,
	 *            ACTIVE_ATTRIBUTES
	 * @return
	 */
	@JsName(value = "getProgramParameter")
	public int getProgramParameteri(WebGLProgram program, int param);

	public String getProgramInfoLog(JavaScriptObject program);

	public boolean isProgram(WebGLProgram program);

	public void useProgram(WebGLProgram program);

	public int getAttribLocation(WebGLProgram program, String name);

	public int getUniformLocation(WebGLProgram program, String name);
	
	public void bindAttribLocation(WebGLProgram program, int idx,
			String name);

	// ///////////
	// Shaders //
	// ///////////

	/**
	 * Create a shader object
	 * @param shaderType VERTEX_SHADER FRAGMENT_SHADER
	 * @return
	 */
	public WebGLShader createShader(int shaderType);

	public void compileShader(WebGLShader shader);

	public void attachShader(WebGLProgram program, WebGLShader shader);

	public void detachShader(WebGLProgram program, WebGLShader shader);

	public void deleteShader(WebGLShader shader);

	public String getShaderSource(WebGLShader shader);

	public void shaderSource(WebGLShader shader, String shaderSrc);

	public String getShaderInfoLog(WebGLShader shader);

	/**
	 * @param shader
	 * @param param DELETE_STATUS, COMPILE_STATUS
	 * @return
	 */
	@JsName(value = "getShaderParameter")
	public boolean getShaderParameterb(WebGLShader shader, int param);

	/**
	 * @param shader
	 * @param param SHADER_TYPE, INFO_LOG_LENGTH, SHADER_SOURCE_LENGTH
	 * @return
	 */
	@JsName(value = "getShaderParameter")
	public int getShaderParameteri(WebGLShader shader, int param);

	public WebGLObjectArray<WebGLShader> getAttachedShaders(WebGLProgram program);

	public boolean isShader(JavaScriptObject shader);

	// ////////////
	// Textures //
	// ////////////

	public WebGLTexture createTexture();

	public void deleteTexture(WebGLTexture texture);

	/**
	 * @param target TEXTURE_2D, TEXTURE_CUBE_MAP
	 * @param texture the texture to delete
	 */
	public void bindTexture(int target, WebGLTexture texture);

	/**
	 * @param texture the texture unit (TEXTURE0, TEXTURE1, ...)
	 */
	public void activeTexture(int texture);

	/**
	 * @param target TEXTURE_2D, TEXTURE_CUBE_MAP
	 * @param level
	 * @param data JavaScript Image to set
	 */
	public void texImage2D(int target, int level, JavaScriptObject data);

	/**
	 * @param target TEXTURE_2D, TEXTURE_CUBE_MAP
	 * @param level
	 * @param intformat ALPHA, RGB, RGBA, LUMINANCE, LUMINANCE_ALPHA
	 * @param width
	 * @param height
	 * @param border
	 * @param format ALPHA, RGB, RGBA, LUMINANCE, LUMINANCE_ALPHA
	 * @param type UNSIGNED_BYTE, UNSIGNED_SHORT_4_4_4_4, UNSIGNED_SHORT_5_5_5_1, UNSIGNED_SHORT_5_6_5
	 * @param data JavaScript Image to set
	 */
	public void texImage2D(int target, int level, int intformat, int width,
			int height, int border, int format, int type, JavaScriptObject data);

	public boolean isTexture(WebGLTexture texture);

	public void generateMipmap(int target);
	
	/**
	 * @param target
	 * @param pname TEXTURE_MAG_FILTER, TEXTURE_MIN_FILTER, TEXTURE_WRAP_S, TEXTURE_WRAP_T
	 * @return
	 */
	@JsName("getTexParameter")
	public int getTexParameteri(int target, int pname);
	
	public void texParameteri(int target, int pname, int value);
	
	public void texParameterf(int target, int pname, float value);

	void copyTexSubImage2D(int target, int level, int intformat, int xoffset, int yoffset, int x, int y, int width, int height);
	
	void copyTexImage2D(int target, int level, int intformat, int x, int y, int width, int height, int border);
	
	void texSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, JavaScriptObject data);

	// //////////
	// Culling //
	// //////////

	/**
	 * @param mode FRONT BACK FRONT_AND_BACK
	 */
	public void cullFace(int mode);

	/**
	 * @param mode CW CCW
	 */
	public void frontFace(int mode);
	
	// /////////////
	// Array data //
	// /////////////

	public JavaScriptObject createFloatArray(float[] array);
	
	// TODO Object createByteArray(Array values)

	// TODO Object createUnsignedByteArray(Array values)
	
	// TODO Object createShortArray(Array values)
	
	// TODO Object createUnsignedShortArray(Array values)
	
	// TODO Object createIntArray(Array values)
	
	// TODO Object createUnsignedIntArray(Array values)
	
	/**
	 * @param mode POINTS LINES LINE_LOOP LINE_STRIP TRIANGLES TRIANGLE_STRIP TRIANGLE_FAN
	 * @param first
	 * @param count
	 */
	public void drawArrays(int mode, int first, int count);
	
	/**
	 * @param mode
	 * @param count
	 * @param type UNSIGNED_BYTE UNSIGNED_SHORT
	 * @param offset
	 */
	void drawElements(int mode, int count, int type, int offset);  
	
	// ///////////
	// Blending //
	// ///////////
	
	/**
	 * @param sfactor ZERO ONE SRC_COLOR DST_COLOR SRC_ALPHA DST_ALPHA CONSTANT_COLOR CONSTANT_ALPHA ONE_MINUS_SRC_ALPHA ONE_MINUS_DST_ALPHA ONE_MINUS_SRC_COLOR ONE_MINUS_DST_COLOR ONE_MINUS_CONSTANT_COLOR ONE_MINUS_CONSTANT_ALPHA SRC_ALPHA_SATURATE
	 * @param dfactor ZERO ONE SRC_COLOR DST_COLOR SRC_ALPHA DST_ALPHA CONSTANT_COLOR CONSTANT_ALPHA ONE_MINUS_SRC_ALPHA ONE_MINUS_DST_ALPHA ONE_MINUS_SRC_COLOR ONE_MINUS_DST_COLOR ONE_MINUS_CONSTANT_COLOR ONE_MINUS_CONSTANT_ALPHA
	 */
	public void blendFunc(int sfactor, int dfactor);
	
	public void blendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
	
	/**
	 * @param mode FUNC_ADD FUNC_SUBTRACT FUNC_REVERSE_SUBTRACT
	 */
	public void blendEquation(int mode);
	
	public void blendEquationSeparate(int modeRGB, int modeAlpha);
	
	public void blendColor(float red, float green, float blue, float alpha);  
	
	// ///////////////
	// Depth buffer //
	// ///////////////
	
	/**
	 * @param func NEVER LESS EQUAL LEQUAL GREATER NOTEQUAL GEQUAL ALWAYS
	 */
	public void depthFunc(int func);  

	public void depthMask(boolean flag);  
	
	public void depthRange(float nearVal, float farVal);  
	
	public void clearDepth(float depth);
	
	public void polygonOffset(float factor, float units);  
	
	// ///////////////
	// Framebuffers //
	//////////////////
	
	public WebGLFramebuffer createFramebuffer();
	
	public void deleteFramebuffer(WebGLFramebuffer buffer);
	
	/**
	 * @param target FRAMEBUFFER
	 * @param buffer
	 */
	public void bindFramebuffer(int target, WebGLFramebuffer buffer);
	
	/**
	 * @param target
	 * @return one of the following constants: FRAMEBUFFER_COMPLETE FRAMEBUFFER_INCOMPLETE_ATTACHMENT FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT FRAMEBUFFER_INCOMPLETE_DIMENSIONS FRAMEBUFFER_UNSUPPORTED
	 */
	public int checkFramebufferStatus(int target);
	
	/**
	 * @param target
	 * @param attachment DEPTH_ATTACHMENT COLOR_ATTACHMENT0 STENCIL_ATTACHMENT
	 * @param rbtarget
	 * @param rbuffer
	 * @return
	 */
	public int framebufferRenderbuffer(int target, int att, int rbtarget, WebGLRenderbuffer rbuffer);
	
	/**
	 * @param target
	 * @param attachment FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE FRAMEBUFFER_ATTACHMENT_OBJECT_NAME FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
	 * @param pname
	 * @return
	 */
	public int getFramebufferAttachmentParameteri(int target, int attachment, int pname);
	
	/**
	 * @param target
	 * @param att
	 * @param textarget TEXTURE_2D TEXTURE_CUBE_MAP_POSITIVE_X TEXTURE_CUBE_MAP_NEGATIVE_X TEXTURE_CUBE_MAP_POSITIVE_Y TEXTURE_CUBE_MAP_NEGATIVE_Y TEXTURE_CUBE_MAP_POSITIVE_Z TEXTURE_CUBE_MAP_NEGATIVE_Z
	 * @param tex
	 * @param level
	 * @return
	 */
	public int framebufferTexture2D(int target, int att, int textarget, WebGLTexture tex, int level);
	
	/**
	 * @param pname PACK_ALIGNMENT UNPACK_ALIGNMENT
	 * @param param
	 */
	public void pixelStorei(int pname, int param);
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param format ALPHA RGB RGBA
	 * @param type UNSIGNED_BYTE UNSIGNED_SHORT_4_4_4_4 UNSIGNED_SHORT_5_5_5_1 UNSIGNED_SHORT_5_6_5
	 * @return
	 */
	// TODO check return type
	public int[] readPixels(int x, int y, int width, int height, int format, int type);
	
	public boolean isFramebuffer(WebGLFramebuffer buffer);
	
	// ////////////////////
	// Uniform variables //
	// ////////////////////
	
	public void uniform1f(int location, float v0);
	
	public void uniform1fv(int location, @Unwrap("getNativeArray") WebGLFloatArray v);
	
	public void uniform1fv(int location, float[] values);

	public void uniform1i(int location, int v0);
	
//	public void uniform1iv(int location, @Unwrap("getNativeArray") WebGLIntArray v);
	
	public void uniform1iv(int location, int[] values);
	
	public void uniform2f(int location, float v0, float v1);
	
	public void uniform2fv(int location, @Unwrap("getNativeArray") WebGLFloatArray v);
	
	public void uniform2fv(int location, float[] values);

	public void uniform2i(int location, int v0, int v1);
	
//	public void uniform2iv(int location, @Unwrap("getNativeArray") WebGLIntArray v);
	
	public void uniform2iv(int location, int[] values);
	
	public void uniform3f(int location, float v0, float v1, float v2);
	
	public void uniform3fv(int location, @Unwrap("getNativeArray") WebGLFloatArray v);
	
	public void uniform3fv(int location, float[] values);

	public void uniform3i(int location, int v0, int v1, int v2);
	
//	public void uniform3iv(int location, @Unwrap("getNativeArray") WebGLIntArray v);
	
	public void uniform3iv(int location, int[] values);
	
	public void uniform4f(int location, float v0, float v1, float v2, float v3);
	
	public void uniform4fv(int location, @Unwrap("getNativeArray") WebGLFloatArray v);
	
	public void uniform4fv(int location, float[] values);

	public void uniform4i(int location, int v0, int v1, int v2, int v3);
	
//	public void uniform4iv(int location, @Unwrap("getNativeArray") WebGLIntArray );
	
	public void uniform4iv(int location, int[] values);

	public void uniformMatrix2fv(int location, boolean transpose,
			@Unwrap("getNativeArray") WebGLFloatArray value);
	
	public void uniformMatrix2fv(int location, boolean transpose,
			float[] value);

	public void uniformMatrix3fv(int location, boolean transpose,
			@Unwrap("getNativeArray") WebGLFloatArray value);
	
	public void uniformMatrix3fv(int location, boolean transpose,
			float[] value);

	public void uniformMatrix4fv(int location, boolean transpose,
			@Unwrap("getNativeArray") WebGLFloatArray value);
	
	public void uniformMatrix4fv(int location, boolean transpose,
			float[] value);

	public JavaScriptObject getActiveUniform(WebGLProgram program, int idx);
	
	// //////////////////////
	// Attribute variables //
	// //////////////////////
	
	// TODO add attribute variable methods
	
	// /////////////////
	// Stencil buffer //
	// /////////////////
	
	/**
	 * @param func NEVER LESS EQUAL LEQUAL GREATER NOTEQUAL GEQUAL ALWAYS
	 * @param ref
	 * @param mask
	 */
	void stencilFunc(int func, int ref, int mask);
	
	/**
	 * @param face FRONT BACK FRONT_AND_BACK
	 * @param func
	 * @param ref
	 * @param mask
	 */
	void stencilFuncSeparate(int face, int func, int ref, int mask);
	
	void stencilMask(int mask);
	
	void stencilMaskSeparate(int face, int mask);
	
	/**
	 * @param sfail KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 * @param dpfail KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 * @param dppass KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 */
	void stencilOp(int sfail, int dpfail, int dppass);
	
	void stencilOpSeparate(int face, int sfail, int dpfail, int dppass);
	
	void clearStencil(int s);
	
	// ////////////////
	// Multisampling //
	// ////////////////
	
	void sampleCoverage(float value, boolean invert);
	
}
