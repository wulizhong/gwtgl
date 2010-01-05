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
import com.googlecode.gwtgl.gen.api.IBinding;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 *
 */
public class WebGLCanvas extends FocusWidget {
	
	private static AbstractWebGlContextInitializer webGlCanvasImpl = (AbstractWebGlContextInitializer) GWT
			.create(AbstractWebGlContextInitializer.class);
	
	protected interface IWebGLMethods extends IBinding, WebGLRenderingContext {
	}
	
	private final IWebGLMethods glContext = GWT.create(IWebGLMethods.class);
	
	private static final IWebGLConstants webGLConstants=GWT.create(IWebGLConstants.class);
	
	 /* ClearBufferMask */
	public static final int DEPTH_BUFFER_BIT = webGLConstants.DEPTH_BUFFER_BIT();
	public static final int STENCIL_BUFFER_BIT = webGLConstants.STENCIL_BUFFER_BIT();
	public static final int COLOR_BUFFER_BIT = webGLConstants.COLOR_BUFFER_BIT();
	    
	    /* BeginMode */
	public static final int POINTS = webGLConstants.POINTS();
	public static final int LINES = webGLConstants.LINES();
	public static final int LINE_LOOP = webGLConstants.LINE_LOOP();
	public static final int LINE_STRIP = webGLConstants.LINE_STRIP();
	public static final int TRIANGLES = webGLConstants.TRIANGLES();
	public static final int TRIANGLE_STRIP = webGLConstants.TRIANGLE_STRIP();
	public static final int TRIANGLE_FAN = webGLConstants.TRIANGLE_FAN();
	    
	    /* AlphaFunction (not supported in ES20) */
	    /*      NEVER */
	    /*      LESS */
	    /*      EQUAL */
	    /*      LEQUAL */
	    /*      GREATER */
	    /*      NOTEQUAL */
	    /*      GEQUAL */
	    /*      ALWAYS */
	    
	    /* BlendingFactorDest */
	public static final int ZERO = webGLConstants.ZERO();
	public static final int ONE = webGLConstants.ONE();
	public static final int SRC_COLOR = webGLConstants.SRC_COLOR();
	public static final int ONE_MINUS_SRC_COLOR = webGLConstants.ONE_MINUS_SRC_COLOR();
	public static final int SRC_ALPHA = webGLConstants.SRC_ALPHA();
	public static final int ONE_MINUS_SRC_ALPHA = webGLConstants.ONE_MINUS_SRC_ALPHA();
	public static final int DST_ALPHA = webGLConstants.DST_ALPHA();
	public static final int ONE_MINUS_DST_ALPHA = webGLConstants.ONE_MINUS_DST_ALPHA();
	    
	    /* BlendingFactorSrc */
	    /*      ZERO */
	    /*      ONE */
	public static final int DST_COLOR = webGLConstants.DST_COLOR();
	public static final int ONE_MINUS_DST_COLOR = webGLConstants.ONE_MINUS_DST_COLOR();
	public static final int SRC_ALPHA_SATURATE = webGLConstants.SRC_ALPHA_SATURATE();
	    /*      SRC_ALPHA */
	    /*      ONE_MINUS_SRC_ALPHA */
	    /*      DST_ALPHA */
	    /*      ONE_MINUS_DST_ALPHA */
	    
	    /* BlendEquationSeparate */
	public static final int FUNC_ADD = webGLConstants.FUNC_ADD();
	public static final int BLEND_EQUATION = webGLConstants.BLEND_EQUATION();
	public static final int BLEND_EQUATION_RGB = webGLConstants.BLEND_EQUATION_RGB();   /* same as BLEND_EQUATION */
	public static final int BLEND_EQUATION_ALPHA = webGLConstants.BLEND_EQUATION_ALPHA();
	    
	    /* BlendSubtract */
	public static final int FUNC_SUBTRACT = webGLConstants.FUNC_SUBTRACT();
	public static final int FUNC_REVERSE_SUBTRACT = webGLConstants.FUNC_REVERSE_SUBTRACT();
	    
	    /* Separate Blend Functions */
	public static final int BLEND_DST_RGB = webGLConstants.BLEND_DST_RGB();
	public static final int BLEND_SRC_RGB = webGLConstants.BLEND_SRC_RGB();
	public static final int BLEND_DST_ALPHA = webGLConstants.BLEND_DST_ALPHA();
	public static final int BLEND_SRC_ALPHA = webGLConstants.BLEND_SRC_ALPHA();
	public static final int CONSTANT_COLOR = webGLConstants.CONSTANT_COLOR();
	public static final int ONE_MINUS_CONSTANT_COLOR = webGLConstants.ONE_MINUS_CONSTANT_COLOR();
	public static final int CONSTANT_ALPHA = webGLConstants.CONSTANT_ALPHA();
	public static final int ONE_MINUS_CONSTANT_ALPHA = webGLConstants.ONE_MINUS_CONSTANT_ALPHA();
	public static final int BLEND_COLOR = webGLConstants.BLEND_COLOR();
	    
	    /* Buffer Objects */
	public static final int ARRAY_BUFFER = webGLConstants.ARRAY_BUFFER();
	public static final int ELEMENT_ARRAY_BUFFER = webGLConstants.ELEMENT_ARRAY_BUFFER();
	public static final int ARRAY_BUFFER_BINDING = webGLConstants.ARRAY_BUFFER_BINDING();
	public static final int ELEMENT_ARRAY_BUFFER_BINDING = webGLConstants.ELEMENT_ARRAY_BUFFER_BINDING();
	public static final int STREAM_DRAW = webGLConstants.STREAM_DRAW();
	public static final int STATIC_DRAW = webGLConstants.STATIC_DRAW();
	public static final int DYNAMIC_DRAW = webGLConstants.DYNAMIC_DRAW();
	public static final int BUFFER_SIZE = webGLConstants.BUFFER_SIZE();
	public static final int BUFFER_USAGE = webGLConstants.BUFFER_USAGE();
	public static final int CURRENT_VERTEX_ATTRIB = webGLConstants.CURRENT_VERTEX_ATTRIB();
	    
	    /* CullFaceMode */
	public static final int FRONT = webGLConstants.FRONT();
	public static final int BACK = webGLConstants.BACK();
	public static final int FRONT_AND_BACK = webGLConstants.FRONT_AND_BACK();
	    
	    /* DepthFunction */
	    /*      NEVER */
	    /*      LESS */
	    /*      EQUAL */
	    /*      LEQUAL */
	    /*      GREATER */
	    /*      NOTEQUAL */
	    /*      GEQUAL */
	    /*      ALWAYS */
	    
	    /* EnableCap */
	public static final int TEXTURE_2D = webGLConstants.TEXTURE_2D();
	public static final int CULL_FACE = webGLConstants.CULL_FACE();
	public static final int BLEND = webGLConstants.BLEND();
	public static final int DITHER = webGLConstants.DITHER();
	public static final int STENCIL_TEST = webGLConstants.STENCIL_TEST();
	public static final int DEPTH_TEST = webGLConstants.DEPTH_TEST();
	public static final int SCISSOR_TEST = webGLConstants.SCISSOR_TEST();
	public static final int POLYGON_OFFSET_FILL = webGLConstants.POLYGON_OFFSET_FILL();
	public static final int SAMPLE_ALPHA_TO_COVERAGE = webGLConstants.SAMPLE_ALPHA_TO_COVERAGE();
	public static final int SAMPLE_COVERAGE = webGLConstants.SAMPLE_COVERAGE();
	    
	    /* ErrorCode */
	public static final int NO_ERROR = webGLConstants.NO_ERROR();
	public static final int INVALID_ENUM = webGLConstants.INVALID_ENUM();
	public static final int INVALID_VALUE = webGLConstants.INVALID_VALUE();
	public static final int INVALID_OPERATION = webGLConstants.INVALID_OPERATION();
	public static final int OUT_OF_MEMORY = webGLConstants.OUT_OF_MEMORY();
	    
	    /* FrontFaceDirection */
	public static final int CW = webGLConstants.CW();
	public static final int CCW = webGLConstants.CCW();
	    
	    /* GetPName */
	public static final int LINE_WIDTH = webGLConstants.LINE_WIDTH();
	public static final int ALIASED_POINT_SIZE_RANGE = webGLConstants.ALIASED_POINT_SIZE_RANGE();
	public static final int ALIASED_LINE_WIDTH_RANGE = webGLConstants.ALIASED_LINE_WIDTH_RANGE();
	public static final int CULL_FACE_MODE = webGLConstants.CULL_FACE_MODE();
	public static final int FRONT_FACE = webGLConstants.FRONT_FACE();
	public static final int DEPTH_RANGE = webGLConstants.DEPTH_RANGE();
	public static final int DEPTH_WRITEMASK = webGLConstants.DEPTH_WRITEMASK();
	public static final int DEPTH_CLEAR_VALUE = webGLConstants.DEPTH_CLEAR_VALUE();
	public static final int DEPTH_FUNC = webGLConstants.DEPTH_FUNC();
	public static final int STENCIL_CLEAR_VALUE = webGLConstants.STENCIL_CLEAR_VALUE();
	public static final int STENCIL_FUNC = webGLConstants.STENCIL_FUNC();
	public static final int STENCIL_FAIL = webGLConstants.STENCIL_FAIL();
	public static final int STENCIL_PASS_DEPTH_FAIL = webGLConstants.STENCIL_PASS_DEPTH_FAIL();
	public static final int STENCIL_PASS_DEPTH_PASS = webGLConstants.STENCIL_PASS_DEPTH_PASS();
	public static final int STENCIL_REF = webGLConstants.STENCIL_REF();
	public static final int STENCIL_VALUE_MASK = webGLConstants.STENCIL_VALUE_MASK();
	public static final int STENCIL_WRITEMASK = webGLConstants.STENCIL_WRITEMASK();
	public static final int STENCIL_BACK_FUNC = webGLConstants.STENCIL_BACK_FUNC();
	public static final int STENCIL_BACK_FAIL = webGLConstants.STENCIL_BACK_FAIL();
	public static final int STENCIL_BACK_PASS_DEPTH_FAIL = webGLConstants.STENCIL_BACK_PASS_DEPTH_FAIL();
	public static final int STENCIL_BACK_PASS_DEPTH_PASS = webGLConstants.STENCIL_BACK_PASS_DEPTH_PASS();
	public static final int STENCIL_BACK_REF = webGLConstants.STENCIL_BACK_REF();
	public static final int STENCIL_BACK_VALUE_MASK = webGLConstants.STENCIL_BACK_VALUE_MASK();
	public static final int STENCIL_BACK_WRITEMASK = webGLConstants.STENCIL_BACK_WRITEMASK();
	public static final int VIEWPORT = webGLConstants.VIEWPORT();
	public static final int SCISSOR_BOX = webGLConstants.SCISSOR_BOX();
	    /*      SCISSOR_TEST */
	public static final int COLOR_CLEAR_VALUE = webGLConstants.COLOR_CLEAR_VALUE();
	public static final int COLOR_WRITEMASK = webGLConstants.COLOR_WRITEMASK();
	public static final int UNPACK_ALIGNMENT = webGLConstants.UNPACK_ALIGNMENT();
	public static final int PACK_ALIGNMENT = webGLConstants.PACK_ALIGNMENT();
	public static final int MAX_TEXTURE_SIZE = webGLConstants.MAX_TEXTURE_SIZE();
	public static final int MAX_VIEWPORT_DIMS = webGLConstants.MAX_VIEWPORT_DIMS();
	public static final int SUBPIXEL_BITS = webGLConstants.SUBPIXEL_BITS();
	public static final int RED_BITS = webGLConstants.RED_BITS();
	public static final int GREEN_BITS = webGLConstants.GREEN_BITS();
	public static final int BLUE_BITS = webGLConstants.BLUE_BITS();
	public static final int ALPHA_BITS = webGLConstants.ALPHA_BITS();
	public static final int DEPTH_BITS = webGLConstants.DEPTH_BITS();
	public static final int STENCIL_BITS = webGLConstants.STENCIL_BITS();
	public static final int POLYGON_OFFSET_UNITS = webGLConstants.POLYGON_OFFSET_UNITS();
	    /*      POLYGON_OFFSET_FILL */
	public static final int POLYGON_OFFSET_FACTOR = webGLConstants.POLYGON_OFFSET_FACTOR();
	public static final int TEXTURE_BINDING_2D = webGLConstants.TEXTURE_BINDING_2D();
	public static final int SAMPLE_BUFFERS = webGLConstants.SAMPLE_BUFFERS();
	public static final int SAMPLES = webGLConstants.SAMPLES();
	public static final int SAMPLE_COVERAGE_VALUE = webGLConstants.SAMPLE_COVERAGE_VALUE();
	public static final int SAMPLE_COVERAGE_INVERT = webGLConstants.SAMPLE_COVERAGE_INVERT();
	    
	    /* GetTextureParameter */
	    /*      TEXTURE_MAG_FILTER */
	    /*      TEXTURE_MIN_FILTER */
	    /*      TEXTURE_WRAP_S */
	    /*      TEXTURE_WRAP_T */
	public static final int NUM_COMPRESSED_TEXTURE_FORMATS = webGLConstants.NUM_COMPRESSED_TEXTURE_FORMATS();
	public static final int COMPRESSED_TEXTURE_FORMATS = webGLConstants.COMPRESSED_TEXTURE_FORMATS();
	    
	    /* HintMode */
	public static final int DONT_CARE = webGLConstants.DONT_CARE();
	public static final int FASTEST = webGLConstants.FASTEST();
	public static final int NICEST = webGLConstants.NICEST();
	    
	    /* HintTarget */
	public static final int GENERATE_MIPMAP_HINT = webGLConstants.GENERATE_MIPMAP_HINT();
	    
	    /* DataType */
	public static final int BYTE = webGLConstants.BYTE();
	public static final int UNSIGNED_BYTE = webGLConstants.UNSIGNED_BYTE();
	public static final int SHORT = webGLConstants.SHORT();
	public static final int UNSIGNED_SHORT = webGLConstants.UNSIGNED_SHORT();
	public static final int INT = webGLConstants.INT();
	public static final int UNSIGNED_INT = webGLConstants.UNSIGNED_INT();
	public static final int FLOAT = webGLConstants.FLOAT();
	    
	    /* PixelFormat */
	public static final int DEPTH_COMPONENT = webGLConstants.DEPTH_COMPONENT();
	public static final int ALPHA = webGLConstants.ALPHA();
	public static final int RGB = webGLConstants.RGB();
	public static final int RGBA = webGLConstants.RGBA();
	public static final int LUMINANCE = webGLConstants.LUMINANCE();
	public static final int LUMINANCE_ALPHA = webGLConstants.LUMINANCE_ALPHA();
	    
	    /* PixelType */
	    /*      UNSIGNED_BYTE */
	public static final int UNSIGNED_SHORT_4_4_4_4 = webGLConstants.UNSIGNED_SHORT_4_4_4_4();
	public static final int UNSIGNED_SHORT_5_5_5_1 = webGLConstants.UNSIGNED_SHORT_5_5_5_1();
	public static final int UNSIGNED_SHORT_5_6_5 = webGLConstants.UNSIGNED_SHORT_5_6_5();
	    
	    /* Shaders */
	public static final int FRAGMENT_SHADER = webGLConstants.FRAGMENT_SHADER();
	public static final int VERTEX_SHADER = webGLConstants.VERTEX_SHADER();
	public static final int MAX_VERTEX_ATTRIBS = webGLConstants.MAX_VERTEX_ATTRIBS();
	public static final int MAX_VERTEX_UNIFORM_VECTORS = webGLConstants.MAX_VERTEX_UNIFORM_VECTORS();
	public static final int MAX_VARYING_VECTORS = webGLConstants.MAX_VARYING_VECTORS();
	public static final int MAX_COMBINED_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_COMBINED_TEXTURE_IMAGE_UNITS();
	public static final int MAX_VERTEX_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_VERTEX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_TEXTURE_IMAGE_UNITS = webGLConstants.MAX_TEXTURE_IMAGE_UNITS();
	public static final int MAX_FRAGMENT_UNIFORM_VECTORS = webGLConstants.MAX_FRAGMENT_UNIFORM_VECTORS();
	public static final int SHADER_TYPE = webGLConstants.SHADER_TYPE();
	public static final int DELETE_STATUS = webGLConstants.DELETE_STATUS();
	public static final int LINK_STATUS = webGLConstants.LINK_STATUS();
	public static final int VALIDATE_STATUS = webGLConstants.VALIDATE_STATUS();
	public static final int ATTACHED_SHADERS = webGLConstants.ATTACHED_SHADERS();
	public static final int ACTIVE_UNIFORMS = webGLConstants.ACTIVE_UNIFORMS();
	public static final int ACTIVE_UNIFORM_MAX_LENGTH = webGLConstants.ACTIVE_UNIFORM_MAX_LENGTH();
	public static final int ACTIVE_ATTRIBUTES = webGLConstants.ACTIVE_ATTRIBUTES();
	public static final int ACTIVE_ATTRIBUTE_MAX_LENGTH = webGLConstants.ACTIVE_ATTRIBUTE_MAX_LENGTH();
	public static final int SHADING_LANGUAGE_VERSION = webGLConstants.SHADING_LANGUAGE_VERSION();
	public static final int CURRENT_PROGRAM = webGLConstants.CURRENT_PROGRAM();
	    
	    /* StencilFunction */
	public static final int NEVER = webGLConstants.NEVER();
	public static final int LESS = webGLConstants.LESS();
	public static final int EQUAL = webGLConstants.EQUAL();
	public static final int LEQUAL = webGLConstants.LEQUAL();
	public static final int GREATER = webGLConstants.GREATER();
	public static final int NOTEQUAL = webGLConstants.NOTEQUAL();
	public static final int GEQUAL = webGLConstants.GEQUAL();
	public static final int ALWAYS = webGLConstants.ALWAYS();
	    
	    /* StencilOp */
	    /*      ZERO */
	public static final int KEEP = webGLConstants.KEEP();
	public static final int REPLACE = webGLConstants.REPLACE();
	public static final int INCR = webGLConstants.INCR();
	public static final int DECR = webGLConstants.DECR();
	public static final int INVERT = webGLConstants.INVERT();
	public static final int INCR_WRAP = webGLConstants.INCR_WRAP();
	public static final int DECR_WRAP = webGLConstants.DECR_WRAP();
	    
	    /* StringName */
	public static final int VENDOR = webGLConstants.VENDOR();
	public static final int RENDERER = webGLConstants.RENDERER();
	public static final int VERSION = webGLConstants.VERSION();
	public static final int EXTENSIONS = webGLConstants.EXTENSIONS();
	    
	    /* TextureMagFilter */
	public static final int NEAREST = webGLConstants.NEAREST();
	public static final int LINEAR = webGLConstants.LINEAR();
	    
	    /* TextureMinFilter */
	    /*      NEAREST */
	    /*      LINEAR */
	public static final int NEAREST_MIPMAP_NEAREST = webGLConstants.NEAREST_MIPMAP_NEAREST();
	public static final int LINEAR_MIPMAP_NEAREST = webGLConstants.LINEAR_MIPMAP_NEAREST();
	public static final int NEAREST_MIPMAP_LINEAR = webGLConstants.NEAREST_MIPMAP_LINEAR();
	public static final int LINEAR_MIPMAP_LINEAR = webGLConstants.LINEAR_MIPMAP_LINEAR();
	    
	    /* TextureParameterName */
	public static final int TEXTURE_MAG_FILTER = webGLConstants.TEXTURE_MAG_FILTER();
	public static final int TEXTURE_MIN_FILTER = webGLConstants.TEXTURE_MIN_FILTER();
	public static final int TEXTURE_WRAP_S = webGLConstants.TEXTURE_WRAP_S();
	public static final int TEXTURE_WRAP_T = webGLConstants.TEXTURE_WRAP_T();
	    
	    /* TextureTarget */
	    /*      TEXTURE_2D */
	public static final int TEXTURE = webGLConstants.TEXTURE();
	public static final int TEXTURE_CUBE_MAP = webGLConstants.TEXTURE_CUBE_MAP();
	public static final int TEXTURE_BINDING_CUBE_MAP = webGLConstants.TEXTURE_BINDING_CUBE_MAP();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_X = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_X();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_X();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_Y();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_Y();
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = webGLConstants.TEXTURE_CUBE_MAP_POSITIVE_Z();
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = webGLConstants.TEXTURE_CUBE_MAP_NEGATIVE_Z();
	public static final int MAX_CUBE_MAP_TEXTURE_SIZE = webGLConstants.MAX_CUBE_MAP_TEXTURE_SIZE();
	    
	    /* TextureUnit */
	public static final int TEXTURE0 = webGLConstants.TEXTURE0();
	public static final int TEXTURE1 = webGLConstants.TEXTURE1();
	public static final int TEXTURE2 = webGLConstants.TEXTURE2();
	public static final int TEXTURE3 = webGLConstants.TEXTURE3();
	public static final int TEXTURE4 = webGLConstants.TEXTURE4();
	public static final int TEXTURE5 = webGLConstants.TEXTURE5();
	public static final int TEXTURE6 = webGLConstants.TEXTURE6();
	public static final int TEXTURE7 = webGLConstants.TEXTURE7();
	public static final int TEXTURE8 = webGLConstants.TEXTURE8();
	public static final int TEXTURE9 = webGLConstants.TEXTURE9();
	public static final int TEXTURE10 = webGLConstants.TEXTURE10();
	public static final int TEXTURE11 = webGLConstants.TEXTURE11();
	public static final int TEXTURE12 = webGLConstants.TEXTURE12();
	public static final int TEXTURE13 = webGLConstants.TEXTURE13();
	public static final int TEXTURE14 = webGLConstants.TEXTURE14();
	public static final int TEXTURE15 = webGLConstants.TEXTURE15();
	public static final int TEXTURE16 = webGLConstants.TEXTURE16();
	public static final int TEXTURE17 = webGLConstants.TEXTURE17();
	public static final int TEXTURE18 = webGLConstants.TEXTURE18();
	public static final int TEXTURE19 = webGLConstants.TEXTURE19();
	public static final int TEXTURE20 = webGLConstants.TEXTURE20();
	public static final int TEXTURE21 = webGLConstants.TEXTURE21();
	public static final int TEXTURE22 = webGLConstants.TEXTURE22();
	public static final int TEXTURE23 = webGLConstants.TEXTURE23();
	public static final int TEXTURE24 = webGLConstants.TEXTURE24();
	public static final int TEXTURE25 = webGLConstants.TEXTURE25();
	public static final int TEXTURE26 = webGLConstants.TEXTURE26();
	public static final int TEXTURE27 = webGLConstants.TEXTURE27();
	public static final int TEXTURE28 = webGLConstants.TEXTURE28();
	public static final int TEXTURE29 = webGLConstants.TEXTURE29();
	public static final int TEXTURE30 = webGLConstants.TEXTURE30();
	public static final int TEXTURE31 = webGLConstants.TEXTURE31();
	public static final int ACTIVE_TEXTURE = webGLConstants.ACTIVE_TEXTURE();
	    
	    /* TextureWrapMode */
	public static final int REPEAT = webGLConstants.REPEAT();
	public static final int CLAMP_TO_EDGE = webGLConstants.CLAMP_TO_EDGE();
	public static final int MIRRORED_REPEAT = webGLConstants.MIRRORED_REPEAT();
	    
	    /* Uniform Types */
	public static final int FLOAT_VEC2 = webGLConstants.FLOAT_VEC2();
	public static final int FLOAT_VEC3 = webGLConstants.FLOAT_VEC3();
	public static final int FLOAT_VEC4 = webGLConstants.FLOAT_VEC4();
	public static final int INT_VEC2 = webGLConstants.INT_VEC2();
	public static final int INT_VEC3 = webGLConstants.INT_VEC3();
	public static final int INT_VEC4 = webGLConstants.INT_VEC4();
	public static final int BOOL = webGLConstants.BOOL();
	public static final int BOOL_VEC2 = webGLConstants.BOOL_VEC2();
	public static final int BOOL_VEC3 = webGLConstants.BOOL_VEC3();
	public static final int BOOL_VEC4 = webGLConstants.BOOL_VEC4();
	public static final int FLOAT_MAT2 = webGLConstants.FLOAT_MAT2();
	public static final int FLOAT_MAT3 = webGLConstants.FLOAT_MAT3();
	public static final int FLOAT_MAT4 = webGLConstants.FLOAT_MAT4();
	public static final int SAMPLER_2D = webGLConstants.SAMPLER_2D();
	public static final int SAMPLER_CUBE = webGLConstants.SAMPLER_CUBE();
	    
	    /* Vertex Arrays */
	public static final int VERTEX_ATTRIB_ARRAY_ENABLED = webGLConstants.VERTEX_ATTRIB_ARRAY_ENABLED();
	public static final int VERTEX_ATTRIB_ARRAY_SIZE = webGLConstants.VERTEX_ATTRIB_ARRAY_SIZE();
	public static final int VERTEX_ATTRIB_ARRAY_STRIDE = webGLConstants.VERTEX_ATTRIB_ARRAY_STRIDE();
	public static final int VERTEX_ATTRIB_ARRAY_TYPE = webGLConstants.VERTEX_ATTRIB_ARRAY_TYPE();
	public static final int VERTEX_ATTRIB_ARRAY_NORMALIZED = webGLConstants.VERTEX_ATTRIB_ARRAY_NORMALIZED();
	public static final int VERTEX_ATTRIB_ARRAY_POINTER = webGLConstants.VERTEX_ATTRIB_ARRAY_POINTER();
	public static final int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = webGLConstants.VERTEX_ATTRIB_ARRAY_BUFFER_BINDING();
	    
	    /* Read Format */
	public static final int IMPLEMENTATION_COLOR_READ_TYPE = webGLConstants.IMPLEMENTATION_COLOR_READ_TYPE();
	public static final int IMPLEMENTATION_COLOR_READ_FORMAT = webGLConstants.IMPLEMENTATION_COLOR_READ_FORMAT();
	    
	    /* Shader Source */
	public static final int COMPILE_STATUS = webGLConstants.COMPILE_STATUS();
	public static final int INFO_LOG_LENGTH = webGLConstants.INFO_LOG_LENGTH();
	public static final int SHADER_SOURCE_LENGTH = webGLConstants.SHADER_SOURCE_LENGTH();
	public static final int SHADER_COMPILER = webGLConstants.SHADER_COMPILER();
	    
	    /* Shader Precision-Specified Types */
	public static final int LOW_FLOAT = webGLConstants.LOW_FLOAT();
	public static final int MEDIUM_FLOAT = webGLConstants.MEDIUM_FLOAT();
	public static final int HIGH_FLOAT = webGLConstants.HIGH_FLOAT();
	public static final int LOW_INT = webGLConstants.LOW_INT();
	public static final int MEDIUM_INT = webGLConstants.MEDIUM_INT();
	public static final int HIGH_INT = webGLConstants.HIGH_INT();
	    
	    /* Framebuffer Object. */
	public static final int FRAMEBUFFER = webGLConstants.FRAMEBUFFER();
	public static final int RENDERBUFFER = webGLConstants.RENDERBUFFER();
	public static final int RGBA4 = webGLConstants.RGBA4();
	public static final int RGB5_A1 = webGLConstants.RGB5_A1();
	public static final int RGB565 = webGLConstants.RGB565();
	public static final int DEPTH_COMPONENT16 = webGLConstants.DEPTH_COMPONENT16();
	public static final int STENCIL_INDEX = webGLConstants.STENCIL_INDEX();
	public static final int STENCIL_INDEX8 = webGLConstants.STENCIL_INDEX8();
	public static final int RENDERBUFFER_WIDTH = webGLConstants.RENDERBUFFER_WIDTH();
	public static final int RENDERBUFFER_HEIGHT = webGLConstants.RENDERBUFFER_HEIGHT();
	public static final int RENDERBUFFER_INTERNAL_FORMAT = webGLConstants.RENDERBUFFER_INTERNAL_FORMAT();
	public static final int RENDERBUFFER_RED_SIZE = webGLConstants.RENDERBUFFER_RED_SIZE();
	public static final int RENDERBUFFER_GREEN_SIZE = webGLConstants.RENDERBUFFER_GREEN_SIZE();
	public static final int RENDERBUFFER_BLUE_SIZE = webGLConstants.RENDERBUFFER_BLUE_SIZE();
	public static final int RENDERBUFFER_ALPHA_SIZE = webGLConstants.RENDERBUFFER_ALPHA_SIZE();
	public static final int RENDERBUFFER_DEPTH_SIZE = webGLConstants.RENDERBUFFER_DEPTH_SIZE();
	public static final int RENDERBUFFER_STENCIL_SIZE = webGLConstants.RENDERBUFFER_STENCIL_SIZE();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = webGLConstants.FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
	public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = webGLConstants.FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = webGLConstants.FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
	public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = webGLConstants.FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
	public static final int COLOR_ATTACHMENT0 = webGLConstants.COLOR_ATTACHMENT0();
	public static final int DEPTH_ATTACHMENT = webGLConstants.DEPTH_ATTACHMENT();
	public static final int STENCIL_ATTACHMENT = webGLConstants.STENCIL_ATTACHMENT();
	public static final int NONE = webGLConstants.NONE();
	public static final int FRAMEBUFFER_COMPLETE = webGLConstants.FRAMEBUFFER_COMPLETE();
	public static final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT = webGLConstants.FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = webGLConstants.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
	public static final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS = webGLConstants.FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
	public static final int FRAMEBUFFER_UNSUPPORTED = webGLConstants.FRAMEBUFFER_UNSUPPORTED();
	public static final int FRAMEBUFFER_BINDING = webGLConstants.FRAMEBUFFER_BINDING();
	public static final int RENDERBUFFER_BINDING = webGLConstants.RENDERBUFFER_BINDING();
	public static final int MAX_RENDERBUFFER_SIZE = webGLConstants.MAX_RENDERBUFFER_SIZE();
	public static final int INVALID_FRAMEBUFFER_OPERATION = webGLConstants.INVALID_FRAMEBUFFER_OPERATION();
	
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
