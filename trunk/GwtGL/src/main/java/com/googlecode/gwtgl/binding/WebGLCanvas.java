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
import com.googlecode.gwtgl.binding.impl.IWebGl;
import com.googlecode.gwtgl.binding.impl.IWebGlConst;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 *
 */
public class WebGLCanvas extends FocusWidget {
	
	private static AbstractWebGlContextInitializer webGlCanvasImpl = (AbstractWebGlContextInitializer) GWT
			.create(AbstractWebGlContextInitializer.class);
	
	private final IWebGl glContext = GWT.create(IWebGl.class);
	
	private static final IWebGlConst webGlConsts=GWT.create(IWebGlConst.class);
	public static final int DEPTH_TEST = webGlConsts.DEPTH_TEST();
	public static final int VERTEX_SHADER = webGlConsts.VERTEX_SHADER();
	public static final int FRAGMENT_SHADER = webGlConsts.FRAGMENT_SHADER();
	public static final int COMPILE_STATUS = webGlConsts.COMPILE_STATUS();
	public static final int DELETE_STATUS = webGlConsts.DELETE_STATUS();
	public static final int LINK_STATUS = webGlConsts.LINK_STATUS();
	public static final int LEQUAL = webGlConsts.LEQUAL();
	public static final int ELEMENT_ARRAY_BUFFER = webGlConsts.ELEMENT_ARRAY_BUFFER();
	public static final int ARRAY_BUFFER = webGlConsts.ARRAY_BUFFER();
	public static final int STREAM_DRAW = webGlConsts.STREAM_DRAW();
	public static final int STATIC_DRAW = webGlConsts.STATIC_DRAW();
	public static final int DYNAMIC_DRAW = webGlConsts.DYNAMIC_DRAW();
	public static final int COLOR_BUFFER_BIT = webGlConsts.COLOR_BUFFER_BIT();
	public static final int DEPTH_BUFFER_BIT = webGlConsts.DEPTH_BUFFER_BIT();
	public static final int STENCIL_BUFFER_BIT = webGlConsts.STENCIL_BUFFER_BIT();
	public static final int FLOAT = webGlConsts.FLOAT();
	public static final int TEXTURE0 = webGlConsts.TEXTURE0();
	public static final int TEXTURE_2D = webGlConsts.TEXTURE_2D();
	public static final int TEXTURE_CUBE_MAP = webGlConsts.TEXTURE_CUBE_MAP();
	public static final int CULL_FACE = webGlConsts.CULL_FACE();
	public static final int FRONT = webGlConsts.FRONT();
	public static final int BACK = webGlConsts.BACK();
	public static final int FRONT_AND_BACK = webGlConsts.FRONT_AND_BACK();
	public static final int CW = webGlConsts.CW();
	public static final int CCW = webGlConsts.CCW();
	public static final int TEXTURE_MIN_FILTER = webGlConsts.TEXTURE_MIN_FILTER();
	public static final int TEXTURE_MAG_FILTER = webGlConsts.TEXTURE_MAG_FILTER();
	public static final int LINEAR = webGlConsts.LINEAR();
	public static final int NO_ERROR = webGlConsts.NO_ERROR();
	public static final int INFO_LOG_LENGTH = webGlConsts.INFO_LOG_LENGTH();
	public static final int SHADER_SOURCE_LENGTH = webGlConsts.SHADER_SOURCE_LENGTH();
	public static final int FUNC_ADD = webGlConsts.FUNC_ADD();
	public static final int FUNC_SUBTRACT = webGlConsts.FUNC_SUBTRACT();
	public static final int FUNC_REVERSE_SUBTRACT = webGlConsts.FUNC_REVERSE_SUBTRACT();
	public static final int ZERO = webGlConsts.ZERO();
	public static final int ONE = webGlConsts.ONE();
	public static final int SRC_COLOR = webGlConsts.SRC_COLOR();
	public static final int DST_COLOR = webGlConsts.DST_COLOR();
	public static final int SRC_ALPHA = webGlConsts.SRC_ALPHA();
	public static final int DST_ALPHA = webGlConsts.DST_ALPHA();
	public static final int CONSTANT_COLOR = webGlConsts.CONSTANT_COLOR();
	public static final int CONSTANT_ALPHA = webGlConsts.CONSTANT_ALPHA();
	public static final int ONE_MINUS_SRC_ALPHA = webGlConsts.ONE_MINUS_SRC_ALPHA();
	public static final int ONE_MINUS_DST_ALPHA = webGlConsts.ONE_MINUS_DST_ALPHA();
	public static final int ONE_MINUS_SRC_COLOR = webGlConsts.ONE_MINUS_SRC_COLOR();
	public static final int ONE_MINUS_DST_COLOR = webGlConsts.ONE_MINUS_DST_COLOR();
	public static final int ONE_MINUS_CONSTANT_COLOR = webGlConsts.ONE_MINUS_CONSTANT_COLOR();
	public static final int ONE_MINUS_CONSTANT_ALPHA = webGlConsts.ONE_MINUS_CONSTANT_ALPHA();
	public static final int SRC_ALPHA_SATURATE = webGlConsts.SRC_ALPHA_SATURATE();
	public static final int NEVER = webGlConsts.NEVER();
	public static final int LESS = webGlConsts.LESS();
	public static final int EQUAL = webGlConsts.EQUAL();
	public static final int GREATER = webGlConsts.GREATER();
	public static final int NOTEQUAL = webGlConsts.NOTEQUAL();
	public static final int GEQUAL = webGlConsts.GEQUAL();
	public static final int ALWAYS = webGlConsts.ALWAYS();
	public static final int FRAMEBUFFER = webGlConsts.FRAMEBUFFER();
	public static final int FRAMEBUFFER_COMPLETE = webGlConsts.FRAMEBUFFER_COMPLETE();
	public static final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT = webGlConsts.FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = webGlConsts.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS = webGlConsts.FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
	public static final int FRAMEBUFFER_UNSUPPORTED = webGlConsts.FRAMEBUFFER_UNSUPPORTED();
	public static final int DEPTH_ATTACHMENT = webGlConsts.DEPTH_ATTACHMENT();
	public static final int COLOR_ATTACHMENT0 = webGlConsts.COLOR_ATTACHMENT0(); 
	public static final int STENCIL_ATTACHMENT = webGlConsts.STENCIL_ATTACHMENT();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_X = webGlConsts.TEXTURE_CUBE_MAP_POSITIVE_X();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = webGlConsts.TEXTURE_CUBE_MAP_NEGATIVE_X();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = webGlConsts.TEXTURE_CUBE_MAP_POSITIVE_Y();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = webGlConsts.TEXTURE_CUBE_MAP_NEGATIVE_Y();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = webGlConsts.TEXTURE_CUBE_MAP_POSITIVE_Z();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = webGlConsts.TEXTURE_CUBE_MAP_NEGATIVE_Z();
	public static final int TEXTURE_WRAP_S = webGlConsts.TEXTURE_WRAP_S();
	public static final int TEXTURE_WRAP_T = webGlConsts.TEXTURE_WRAP_T();
	public static final int LUMINANCE = webGlConsts.LUMINANCE();
	public static final int LUMINANCE_ALPHA = webGlConsts.LUMINANCE_ALPHA();
	public static final int TEXTURE_BINDING_2D = webGlConsts.TEXTURE_BINDING_2D();
	public static final int TEXTURE_BINDING_CUBE_MAP = webGlConsts.TEXTURE_BINDING_CUBE_MAP();
	public static final int MAX_TEXTURE_SIZE = webGlConsts.MAX_TEXTURE_SIZE();
	public static final int MAX_CUBE_MAP_TEXTURE_SIZE = webGlConsts.MAX_CUBE_MAP_TEXTURE_SIZE();
	public static final int ACTIVE_TEXTURE = webGlConsts.ACTIVE_TEXTURE();
	public static final int MAX_TEXTURE_IMAGE_UNITS = webGlConsts.MAX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_VERTEX_TEXTURE_IMAGE_UNITS = webGlConsts.MAX_VERTEX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_COMBINED_TEXTURE_IMAGE_UNITS = webGlConsts.MAX_COMBINED_TEXTURE_IMAGE_UNITS();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = webGlConsts.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = webGlConsts.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = webGlConsts.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = webGlConsts.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
	public static final int PACK_ALIGNMENT = webGlConsts.PACK_ALIGNMENT();
	public static final int UNPACK_ALIGNMENT = webGlConsts.UNPACK_ALIGNMENT();
	public static final int ALPHA = webGlConsts.ALPHA();
	public static final int RGB = webGlConsts.RGB();
	public static final int RGBA = webGlConsts.RGBA();
	public static final int UNSIGNED_BYTE = webGlConsts.UNSIGNED_BYTE();
	public static final int UNSIGNED_SHORT = webGlConsts.UNSIGNED_SHORT();
	public static final int UNSIGNED_SHORT_4_4_4_4 = webGlConsts.UNSIGNED_SHORT_4_4_4_4();
	public static final int UNSIGNED_SHORT_5_5_5_1 = webGlConsts.UNSIGNED_SHORT_5_5_5_1();
	public static final int UNSIGNED_SHORT_5_6_5 = webGlConsts.UNSIGNED_SHORT_5_6_5();
	public static final int MAX_VERTEX_UNIFORM_VECTORS = webGlConsts.MAX_VERTEX_UNIFORM_VECTORS();
	public static final int MAX_FRAGMENT_UNIFORM_VECTORS = webGlConsts.MAX_FRAGMENT_UNIFORM_VECTORS();
	public static final int KEEP = webGlConsts.KEEP();
	public static final int INCR = webGlConsts.INCR();
	public static final int INCR_WRAP = webGlConsts.INCR_WRAP();
	public static final int REPLACE = webGlConsts.REPLACE();
	public static final int INVERT = webGlConsts.INVERT();
	public static final int DECR = webGlConsts.DECR();
	public static final int DECR_WRAP = webGlConsts.DECR_WRAP();
	public static final int STENCIL_TEST = webGlConsts.STENCIL_TEST();
	public static final int STENCIL_CLEAR_VALUE = webGlConsts.STENCIL_CLEAR_VALUE();
	public static final int STENCIL_FUNC = webGlConsts.STENCIL_FUNC();
	public static final int STENCIL_FAIL = webGlConsts.STENCIL_FAIL();
	public static final int STENCIL_REF = webGlConsts.STENCIL_REF();
	public static final int STENCIL_VALUE_MASK = webGlConsts.STENCIL_VALUE_MASK();
	public static final int STENCIL_WRITEMASK = webGlConsts.STENCIL_WRITEMASK();
	public static final int STENCIL_BACK_FUNC = webGlConsts.STENCIL_BACK_FUNC();
	public static final int STENCIL_BACK_FAIL = webGlConsts.STENCIL_BACK_FAIL();
	public static final int STENCIL_BACK_REF = webGlConsts.STENCIL_BACK_REF();
	public static final int STENCIL_BITS = webGlConsts.STENCIL_BITS();
	public static final int STENCIL_BACK_WRITEMASK = webGlConsts.STENCIL_BACK_WRITEMASK();
	public static final int STENCIL_BACK_VALUE_MASK = webGlConsts.STENCIL_BACK_VALUE_MASK();
	public static final int STENCIL_BACK_PASS_DEPTH_FAIL = webGlConsts.STENCIL_BACK_PASS_DEPTH_FAIL();
	public static final int STENCIL_BACK_PASS_DEPTH_PASS = webGlConsts.STENCIL_BACK_PASS_DEPTH_PASS();
	public static final int STENCIL_PASS_DEPTH_FAIL = webGlConsts.STENCIL_PASS_DEPTH_FAIL();
	public static final int STENCIL_PASS_DEPTH_PASS = webGlConsts.STENCIL_PASS_DEPTH_PASS();
	public static final int POINTS = webGlConsts.POINTS();
	public static final int LINES = webGlConsts.LINES();
	public static final int LINE_LOOP = webGlConsts.LINE_LOOP();
	public static final int LINE_STRIP = webGlConsts.LINE_STRIP();
	public static final int TRIANGLES = webGlConsts.TRIANGLES();
	public static final int TRIANGLE_STRIP = webGlConsts.TRIANGLE_STRIP();
	public static final int TRIANGLE_FAN = webGlConsts.TRIANGLE_FAN();
	public static final int SAMPLE_COVERAGE = webGlConsts.SAMPLE_COVERAGE();
	public static final int SAMPLE_ALPHA_TO_COVERAGE = webGlConsts.SAMPLE_ALPHA_TO_COVERAGE();
	public static final int SAMPLE_COVERAGE_VALUE = webGlConsts.SAMPLE_COVERAGE_VALUE();
	public static final int SAMPLE_COVERAGE_INVERT = webGlConsts.SAMPLE_COVERAGE_INVERT();
	public static final int SAMPLE_BUFFERS = webGlConsts.SAMPLE_BUFFERS();
	public static final int SAMPLES = webGlConsts.SAMPLES();
	public static final int DITHER = webGlConsts.DITHER();
	public static final int INVALID_ENUM = webGlConsts.INVALID_ENUM();
	public static final int INVALID_VALUE = webGlConsts.INVALID_VALUE();
	public static final int INVALID_OPERATION = webGlConsts.INVALID_OPERATION();
	public static final int INVALID_FRAMEBUFFER_OPERATION = webGlConsts.INVALID_FRAMEBUFFER_OPERATION();
	public static final int OUT_OF_MEMORY = webGlConsts.OUT_OF_MEMORY();
	public static final int VIEWPORT = webGlConsts.VIEWPORT();
	public static final int MAX_VIEWPORT_DIMS = webGlConsts.MAX_VIEWPORT_DIMS();
	public static final int COLOR_CLEAR_VALUE = webGlConsts.COLOR_CLEAR_VALUE();
	public static final int SCISSOR_BOX = webGlConsts.SCISSOR_BOX();
	public static final int LINE_WIDTH = webGlConsts.LINE_WIDTH();
	public static final int ALIASED_POINT_SIZE_RANGE = webGlConsts.ALIASED_POINT_SIZE_RANGE();
	public static final int ALIASED_LINE_WIDTH_RANGE = webGlConsts.ALIASED_LINE_WIDTH_RANGE();
	public static final int COLOR_WRITEMASK = webGlConsts.COLOR_WRITEMASK();
	public static final int SUBPIXEL_BITS = webGlConsts.SUBPIXEL_BITS();
	
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
