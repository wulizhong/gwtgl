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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FocusWidget;
import com.googlecode.gwtgl.binding.impl.AbstractWebGlContextInitializer;
import com.googlecode.gwtgl.binding.impl.IWebGLConstants;
import com.googlecode.gwtgl.binding.impl.IWebGLMethods;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 *
 */
public class WebGLCanvas extends FocusWidget {
	
	private static AbstractWebGlContextInitializer webGlCanvasImpl = (AbstractWebGlContextInitializer) GWT
			.create(AbstractWebGlContextInitializer.class);
	
	private final IWebGLMethods glContext = GWT.create(IWebGLMethods.class);
	
	private static final IWebGLConstants webGLConstants=GWT.create(IWebGLConstants.class);
	public static final int DEPTH_TEST = webGLConstants.DEPTH_TEST();
	public static final int VERTEX_SHADER = webGLConstants.VERTEX_SHADER();
	public static final int FRAGMENT_SHADER = webGLConstants.FRAGMENT_SHADER();
	public static final int COMPILE_STATUS = webGLConstants.COMPILE_STATUS();
	public static final int DELETE_STATUS = webGLConstants.DELETE_STATUS();
	public static final int LINK_STATUS = webGLConstants.LINK_STATUS();
	public static final int VALIDATE_STATUS = webGLConstants.VALIDATE_STATUS();
	public static final int LEQUAL = webGLConstants.LEQUAL();
	public static final int ELEMENT_ARRAY_BUFFER = webGLConstants.ELEMENT_ARRAY_BUFFER();
	public static final int ARRAY_BUFFER = webGLConstants.ARRAY_BUFFER();
	public static final int STREAM_DRAW = webGLConstants.STREAM_DRAW();
	public static final int STATIC_DRAW = webGLConstants.STATIC_DRAW();
	public static final int DYNAMIC_DRAW = webGLConstants.DYNAMIC_DRAW();
	public static final int COLOR_BUFFER_BIT = webGLConstants.COLOR_BUFFER_BIT();
	public static final int DEPTH_BUFFER_BIT = webGLConstants.DEPTH_BUFFER_BIT();
	public static final int STENCIL_BUFFER_BIT = webGLConstants.STENCIL_BUFFER_BIT();
	public static final int FLOAT = webGLConstants.FLOAT();
	public static final int TEXTURE0 = webGLConstants.TEXTURE0();
	public static final int TEXTURE_2D = webGLConstants.TEXTURE_2D();
	public static final int TEXTURE_CUBE_MAP = webGLConstants.TEXTURE_CUBE_MAP();
	public static final int CULL_FACE = webGLConstants.CULL_FACE();
	public static final int FRONT = webGLConstants.FRONT();
	public static final int BACK = webGLConstants.BACK();
	public static final int FRONT_AND_BACK = webGLConstants.FRONT_AND_BACK();
	public static final int CW = webGLConstants.CW();
	public static final int CCW = webGLConstants.CCW();
	public static final int TEXTURE_MIN_FILTER = webGLConstants.TEXTURE_MIN_FILTER();
	public static final int TEXTURE_MAG_FILTER = webGLConstants.TEXTURE_MAG_FILTER();
	public static final int NO_ERROR = webGLConstants.NO_ERROR();
	public static final int INFO_LOG_LENGTH = webGLConstants.INFO_LOG_LENGTH();
	public static final int SHADER_SOURCE_LENGTH = webGLConstants.SHADER_SOURCE_LENGTH();
	public static final int FUNC_ADD = webGLConstants.FUNC_ADD();
	public static final int FUNC_SUBTRACT = webGLConstants.FUNC_SUBTRACT();
	public static final int FUNC_REVERSE_SUBTRACT = webGLConstants.FUNC_REVERSE_SUBTRACT();
	public static final int ZERO = webGLConstants.ZERO();
	public static final int ONE = webGLConstants.ONE();
	public static final int SRC_COLOR = webGLConstants.SRC_COLOR();
	public static final int DST_COLOR = webGLConstants.DST_COLOR();
	public static final int SRC_ALPHA = webGLConstants.SRC_ALPHA();
	public static final int DST_ALPHA = webGLConstants.DST_ALPHA();
	public static final int CONSTANT_COLOR = webGLConstants.CONSTANT_COLOR();
	public static final int CONSTANT_ALPHA = webGLConstants.CONSTANT_ALPHA();
	public static final int ONE_MINUS_SRC_ALPHA = webGLConstants.ONE_MINUS_SRC_ALPHA();
	public static final int ONE_MINUS_DST_ALPHA = webGLConstants.ONE_MINUS_DST_ALPHA();
	public static final int ONE_MINUS_SRC_COLOR = webGLConstants.ONE_MINUS_SRC_COLOR();
	public static final int ONE_MINUS_DST_COLOR = webGLConstants.ONE_MINUS_DST_COLOR();
	public static final int ONE_MINUS_CONSTANT_COLOR = webGLConstants.ONE_MINUS_CONSTANT_COLOR();
	public static final int ONE_MINUS_CONSTANT_ALPHA = webGLConstants.ONE_MINUS_CONSTANT_ALPHA();
	public static final int SRC_ALPHA_SATURATE = webGLConstants.SRC_ALPHA_SATURATE();
	public static final int NEVER = webGLConstants.NEVER();
	public static final int LESS = webGLConstants.LESS();
	public static final int EQUAL = webGLConstants.EQUAL();
	public static final int GREATER = webGLConstants.GREATER();
	public static final int NOTEQUAL = webGLConstants.NOTEQUAL();
	public static final int GEQUAL = webGLConstants.GEQUAL();
	public static final int ALWAYS = webGLConstants.ALWAYS();
	public static final int FRAMEBUFFER = webGLConstants.FRAMEBUFFER();
	public static final int FRAMEBUFFER_COMPLETE = webGLConstants.FRAMEBUFFER_COMPLETE();
	public static final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT = webGLConstants.FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = webGLConstants.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS = webGLConstants.FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
	public static final int FRAMEBUFFER_UNSUPPORTED = webGLConstants.FRAMEBUFFER_UNSUPPORTED();
	public static final int DEPTH_ATTACHMENT = webGLConstants.DEPTH_ATTACHMENT();
	public static final int COLOR_ATTACHMENT0 = webGLConstants.COLOR_ATTACHMENT0(); 
	public static final int STENCIL_ATTACHMENT = webGLConstants.STENCIL_ATTACHMENT();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_X = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_X();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_X();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_Y();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_Y();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_Z();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_Z();
	public static final int TEXTURE_WRAP_S = webGLConstants.TEXTURE_WRAP_S();
	public static final int TEXTURE_WRAP_T = webGLConstants.TEXTURE_WRAP_T();
	public static final int LUMINANCE = webGLConstants.LUMINANCE();
	public static final int LUMINANCE_ALPHA = webGLConstants.LUMINANCE_ALPHA();
	public static final int TEXTURE_BINDING_2D = webGLConstants.TEXTURE_BINDING_2D();
	public static final int TEXTURE_BINDING_CUBE_MAP = webGLConstants.TEXTURE_BINDING_CUBE_MAP();
	public static final int MAX_TEXTURE_SIZE = webGLConstants.MAX_TEXTURE_SIZE();
	public static final int MAX_CUBE_MAP_TEXTURE_SIZE = webGLConstants.MAX_CUBE_MAP_TEXTURE_SIZE();
	public static final int ACTIVE_TEXTURE = webGLConstants.ACTIVE_TEXTURE();
	public static final int MAX_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_VERTEX_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_VERTEX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_COMBINED_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_COMBINED_TEXTURE_IMAGE_UNITS();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = webGLConstants.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = webGLConstants.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = webGLConstants.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = webGLConstants.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
	public static final int PACK_ALIGNMENT = webGLConstants.PACK_ALIGNMENT();
	public static final int UNPACK_ALIGNMENT = webGLConstants.UNPACK_ALIGNMENT();
	public static final int ALPHA = webGLConstants.ALPHA();
	public static final int RGB = webGLConstants.RGB();
	public static final int RGBA = webGLConstants.RGBA();
	public static final int UNSIGNED_BYTE = webGLConstants.UNSIGNED_BYTE();
	public static final int UNSIGNED_SHORT = webGLConstants.UNSIGNED_SHORT();
	public static final int UNSIGNED_SHORT_4_4_4_4 = webGLConstants.UNSIGNED_SHORT_4_4_4_4();
	public static final int UNSIGNED_SHORT_5_5_5_1 = webGLConstants.UNSIGNED_SHORT_5_5_5_1();
	public static final int UNSIGNED_SHORT_5_6_5 = webGLConstants.UNSIGNED_SHORT_5_6_5();
	public static final int MAX_VERTEX_UNIFORM_VECTORS = webGLConstants.MAX_VERTEX_UNIFORM_VECTORS();
	public static final int MAX_FRAGMENT_UNIFORM_VECTORS = webGLConstants.MAX_FRAGMENT_UNIFORM_VECTORS();
	public static final int KEEP = webGLConstants.KEEP();
	public static final int INCR = webGLConstants.INCR();
	public static final int INCR_WRAP = webGLConstants.INCR_WRAP();
	public static final int REPLACE = webGLConstants.REPLACE();
	public static final int INVERT = webGLConstants.INVERT();
	public static final int DECR = webGLConstants.DECR();
	public static final int DECR_WRAP = webGLConstants.DECR_WRAP();
	public static final int STENCIL_TEST = webGLConstants.STENCIL_TEST();
	public static final int STENCIL_CLEAR_VALUE = webGLConstants.STENCIL_CLEAR_VALUE();
	public static final int STENCIL_FUNC = webGLConstants.STENCIL_FUNC();
	public static final int STENCIL_FAIL = webGLConstants.STENCIL_FAIL();
	public static final int STENCIL_REF = webGLConstants.STENCIL_REF();
	public static final int STENCIL_VALUE_MASK = webGLConstants.STENCIL_VALUE_MASK();
	public static final int STENCIL_WRITEMASK = webGLConstants.STENCIL_WRITEMASK();
	public static final int STENCIL_BACK_FUNC = webGLConstants.STENCIL_BACK_FUNC();
	public static final int STENCIL_BACK_FAIL = webGLConstants.STENCIL_BACK_FAIL();
	public static final int STENCIL_BACK_REF = webGLConstants.STENCIL_BACK_REF();
	public static final int STENCIL_BITS = webGLConstants.STENCIL_BITS();
	public static final int STENCIL_BACK_WRITEMASK = webGLConstants.STENCIL_BACK_WRITEMASK();
	public static final int STENCIL_BACK_VALUE_MASK = webGLConstants.STENCIL_BACK_VALUE_MASK();
	public static final int STENCIL_BACK_PASS_DEPTH_FAIL = webGLConstants.STENCIL_BACK_PASS_DEPTH_FAIL();
	public static final int STENCIL_BACK_PASS_DEPTH_PASS = webGLConstants.STENCIL_BACK_PASS_DEPTH_PASS();
	public static final int STENCIL_PASS_DEPTH_FAIL = webGLConstants.STENCIL_PASS_DEPTH_FAIL();
	public static final int STENCIL_PASS_DEPTH_PASS = webGLConstants.STENCIL_PASS_DEPTH_PASS();
	public static final int POINTS = webGLConstants.POINTS();
	public static final int LINES = webGLConstants.LINES();
	public static final int LINE_LOOP = webGLConstants.LINE_LOOP();
	public static final int LINE_STRIP = webGLConstants.LINE_STRIP();
	public static final int TRIANGLES = webGLConstants.TRIANGLES();
	public static final int TRIANGLE_STRIP = webGLConstants.TRIANGLE_STRIP();
	public static final int TRIANGLE_FAN = webGLConstants.TRIANGLE_FAN();
	public static final int SAMPLE_COVERAGE = webGLConstants.SAMPLE_COVERAGE();
	public static final int SAMPLE_ALPHA_TO_COVERAGE = webGLConstants.SAMPLE_ALPHA_TO_COVERAGE();
	public static final int SAMPLE_COVERAGE_VALUE = webGLConstants.SAMPLE_COVERAGE_VALUE();
	public static final int SAMPLE_COVERAGE_INVERT = webGLConstants.SAMPLE_COVERAGE_INVERT();
	public static final int SAMPLE_BUFFERS = webGLConstants.SAMPLE_BUFFERS();
	public static final int SAMPLES = webGLConstants.SAMPLES();
	public static final int DITHER = webGLConstants.DITHER();
	public static final int INVALID_ENUM = webGLConstants.INVALID_ENUM();
	public static final int INVALID_VALUE = webGLConstants.INVALID_VALUE();
	public static final int INVALID_OPERATION = webGLConstants.INVALID_OPERATION();
	public static final int INVALID_FRAMEBUFFER_OPERATION = webGLConstants.INVALID_FRAMEBUFFER_OPERATION();
	public static final int OUT_OF_MEMORY = webGLConstants.OUT_OF_MEMORY();
	public static final int VIEWPORT = webGLConstants.VIEWPORT();
	public static final int MAX_VIEWPORT_DIMS = webGLConstants.MAX_VIEWPORT_DIMS();
	public static final int COLOR_CLEAR_VALUE = webGLConstants.COLOR_CLEAR_VALUE();
	public static final int SCISSOR_BOX = webGLConstants.SCISSOR_BOX();
	public static final int LINE_WIDTH = webGLConstants.LINE_WIDTH();
	public static final int ALIASED_POINT_SIZE_RANGE = webGLConstants.ALIASED_POINT_SIZE_RANGE();
	public static final int ALIASED_LINE_WIDTH_RANGE = webGLConstants.ALIASED_LINE_WIDTH_RANGE();
	public static final int COLOR_WRITEMASK = webGLConstants.COLOR_WRITEMASK();
	public static final int SUBPIXEL_BITS = webGLConstants.SUBPIXEL_BITS();
	public static final int CURRENT_PROGRAM = webGLConstants.CURRENT_PROGRAM();
	public static final int ARRAY_BUFFER_BINDING = webGLConstants.ARRAY_BUFFER_BINDING();
	public static final int ELEMENT_ARRAY_BUFFER_BINDING = webGLConstants.ELEMENT_ARRAY_BUFFER_BINDING();
	public static final int ACTIVE_ATTRIBUTE_MAX_LENGTH = webGLConstants.ACTIVE_ATTRIBUTE_MAX_LENGTH();
	public static final int ACTIVE_UNIFORM_MAX_LENGTH = webGLConstants.ACTIVE_UNIFORM_MAX_LENGTH();
	public static final int ATTACHED_SHADERS = webGLConstants.ATTACHED_SHADERS();
	public static final int ACTIVE_UNIFORMS = webGLConstants.ACTIVE_UNIFORMS();
	public static final int ACTIVE_ATTRIBUTES = webGLConstants.ACTIVE_ATTRIBUTES();
	public static final int CLAMP_TO_EDGE = webGLConstants.CLAMP_TO_EDGE();
	public static final int REPEAT = webGLConstants.REPEAT();
	
	public static final int NEAREST = webGLConstants.NEAREST();
	public static final int LINEAR = webGLConstants.LINEAR();
	public static final int NEAREST_MIPMAP_NEAREST = webGLConstants.NEAREST_MIPMAP_NEAREST();
	public static final int LINEAR_MIPMAP_NEAREST = webGLConstants.LINEAR_MIPMAP_NEAREST();
	public static final int NEAREST_MIPMAP_LINEAR = webGLConstants.NEAREST_MIPMAP_LINEAR();
	public static final int LINEAR_MIPMAP_LINEAR = webGLConstants.LINEAR_MIPMAP_LINEAR();
	public static final int BYTE = webGLConstants.BYTE();
	public static final int SHORT = webGLConstants.SHORT();
	public static final int INT = webGLConstants.INT();
	public static final int UNSIGNED_INT = webGLConstants.UNSIGNED_INT();
	
	public WebGLCanvas() {
		this("200px", "200px");
	}

	public WebGLCanvas(String width, String height) {
		if (width == null || height == null) {
			throw new IllegalArgumentException();
		}
		setElement(DOM.createElement("canvas"));
		
		// TODO create a JavaScriptObject of the glContext?
		JavaScriptObject nativeGlContext = webGlCanvasImpl.getWebGlContext(getElement());
		if(nativeGlContext == null) {
			throw new RuntimeException("Sorry, your browser doesn't support WebGL");
		}
		glContext.init(nativeGlContext);
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(String width) {
		DOM.setElementAttribute(getElement(), "width", width);
	}

	public void setHeight(String height) {
		DOM.setElementAttribute(getElement(), "height", height);
	}

	/**
	 * Returns the WebGLRenderingContext of this {@link WebGLCanvas}.
	 * 
	 * @return the WebGLRenderingContext
	 */
	public WebGLRenderingContext getGlContext() {
		return glContext;
	}
	
}
