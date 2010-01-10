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
import com.googlecode.gwtgl.binding.impl.IWebGLConstants;
import com.googlecode.gwtgl.gen.api.JsName;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public abstract class WebGLRenderingContext {

	private static final IWebGLConstants webGLConstants = GWT.create(IWebGLConstants.class);
	
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
	

	// ///////
	// Misc //
	// ///////
	
	public abstract void viewport(int x, int y, int w, int h);
	
	public abstract void lineWidth(float width);
	
	public abstract void flush();
	
	public abstract void finish();
	
	/**
	 * @param mask COLOR_BUFFER_BIT DEPTH_BUFFER_BIT STENCIL_BUFFER_BIT
	 */
	public abstract void clear(int mask);
	
	public abstract void colorMask(boolean red, boolean green, boolean blue, boolean alpha);
	
	public abstract void clearColor(float red, float green, float blue, float alpha);
	
	public abstract void scissor(int x, int y, int width, int height);
	

	/**
	 * @param param DEPTH_TEST
	 */
	public abstract void enable(int param);

	public abstract void disable(int param);

	/**
	 * @param pname
	 *            ARRAY_BUFFER_BINDING, CURRENT_PROGRAM,
	 *            ELEMENT_ARRAY_BUFFER_BINDING, FRAMEBUFFER_BINDING,
	 *            RENDERBUFFER_BINDING, TEXTURE_BINDING_2D,
	 *            TEXTURE_BINDING_CUBE_MAP, ALIASED_LINE_WIDTH_RANGE,
	 *            ALIASED_POINT_SIZE_RANGE, BLEND_COLOR, COLOR_CLEAR_VALUE,
	 *            DEPTH_RANGE, MAX_VIEWPORT_DIMS, SCISSOR_BOX, VIEWPORT,
	 *            COLOR_WRITEMASK
	 */
	public abstract <T extends JavaScriptObject> T getParameter(int pname);
	
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
	public abstract int getParameteri(int pname);

	/**
	 * @param pname
	 *            BLEND, CULL_FACE, DEPTH_TEST, DEPTH_WRITEMASK, DITHER,
	 *            POLYGON_OFFSET_FILL, SAMPLE_COVERAGE_INVERT, SCISSOR_TEST,
	 *            STENCIL_TEST
	 * @return
	 */
	@JsName("getParameter")
	public abstract boolean getParameterb(int pname);

	/**
	 * @param pname
	 *            DEPTH_CLEAR_VALUE, LINE_WIDTH, POLYGON_OFFSET_FACTOR,
	 *            POLYGON_OFFSET_UNITS, SAMPLE_COVERAGE_VALUE
	 * @return
	 */
	@JsName("getParameter")
	public abstract float getParameterf(int pname);
	
	public abstract int getError();
	
	// //////////
	// Buffers //
	// //////////

	public abstract WebGLBuffer createBuffer();

	public abstract void deleteBuffer(WebGLBuffer buffer);

	public abstract void isBuffer(WebGLBuffer buffer);

	/**
	 * @param target ARRAY_BUFFER ELEMENT_ARRAY_BUFFER
	 * @param buffer
	 */
	public abstract void bindBuffer(int target, WebGLBuffer buffer);

	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param dta
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public abstract void bufferData(int target, WebGLArray<?> dta, int usage);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param dta
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public abstract void bufferData(int target, WebGLArrayBuffer dta, int usage);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param size the size of the buffer to create
	 * @param usage STREAM_DRAW STATIC_DRAW DYNAMIC_DRAW
	 */
	public abstract void bufferData(int target, int size, int usage);

	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param offset
	 * @param data
	 */
	public abstract void bufferSubData(int target, int offset, WebGLArray<?> data);
	
	/**
	 * @param target ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
	 * @param offset
	 * @param data
	 */
	public abstract void bufferSubData(int target, int offset, WebGLArrayBuffer data);

	/**
	 * @param target
	 * @param value BUFFER_SIZE, BUFFER_USAGE
	 * @return
	 */
	@JsName("getBufferParameter")
	public abstract int getBufferParameteri(int target, int value);

	// ////////////////
	// Renderbuffers //
	// ////////////////

	public abstract WebGLRenderbuffer createRenderbuffer();

	public abstract void deleteRenderbuffer(WebGLRenderbuffer buffer);

	/**
	 * @param target RENDERBUFFER
	 * @param buffer
	 */
	public abstract void bindRenderbuffer(int target, WebGLRenderbuffer buffer);

	/**
	 * @param target
	 * @param pname
	 *            RENDERBUFFER_WIDTH, RENDERBUFFER_HEIGHT,
	 *            RENDERBUFFER_INTERNAL_FORMAT, RENDERBUFFER_RED_SIZE,
	 *            RENDERBUFFER_GREEN_SIZE, RENDERBUFFER_BLUE_SIZE,
	 *            RENDERBUFFER_ALPHA_SIZE, RENDERBUFFER_DEPTH_SIZE,
	 *            RENDERBUFFER_STENCIL_SIZE
	 */
	public abstract int getRenderbufferParameteri(int target, int pname);

	/**
	 * @param target
	 * @param format RGBA4 RGB565 RGB5_A1 DEPTH_COMPONENT16 STENCIL_INDEX8
	 * @param width
	 * @param height
	 */
	public abstract void renderbufferStorage(int target, int format, int width,
			int height);

	public abstract boolean isRenderbuffer(WebGLRenderbuffer buffer);

	// ///////////////////
	// Program objects //
	// ///////////////////

	public abstract WebGLProgram createProgram();

	public abstract void validateProgram(WebGLProgram program);

	public abstract void linkProgram(WebGLProgram program);

	public abstract void deleteProgram(WebGLProgram program);

	/**
	 * @param program
	 * @param param LINK_STATUS, DELETE_STATUS, VALIDATE_STATUS
	 * @return
	 */
	@JsName(value = "getProgramParameter")
	public abstract boolean getProgramParameterb(WebGLProgram program,
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
	public abstract int getProgramParameteri(WebGLProgram program, int param);

	public abstract String getProgramInfoLog(WebGLProgram program);

	public abstract boolean isProgram(WebGLProgram program);

	public abstract void useProgram(WebGLProgram program);
	
	// ///////////
	// Shaders //
	// ///////////

	/**
	 * Create a shader object
	 * @param shaderType VERTEX_SHADER FRAGMENT_SHADER
	 * @return
	 */
	public abstract WebGLShader createShader(int shaderType);

	public abstract void compileShader(WebGLShader shader);

	public abstract void attachShader(WebGLProgram program, WebGLShader shader);

	public abstract void detachShader(WebGLProgram program, WebGLShader shader);

	public abstract void deleteShader(WebGLShader shader);

	public abstract String getShaderSource(WebGLShader shader);

	public abstract void shaderSource(WebGLShader shader, String shaderSrc);

	public abstract String getShaderInfoLog(WebGLShader shader);

	/**
	 * @param shader
	 * @param param DELETE_STATUS, COMPILE_STATUS
	 * @return
	 */
	@JsName(value = "getShaderParameter")
	public abstract boolean getShaderParameterb(WebGLShader shader, int param);

	/**
	 * @param shader
	 * @param param SHADER_TYPE, INFO_LOG_LENGTH, SHADER_SOURCE_LENGTH
	 * @return
	 */
	@JsName(value = "getShaderParameter")
	public abstract int getShaderParameteri(WebGLShader shader, int param);

	public abstract WebGLObjectArray<WebGLShader> getAttachedShaders(WebGLProgram program);

	public abstract boolean isShader(JavaScriptObject shader);
	
	// ////////////////////
	// Uniform variables //
	// ////////////////////
	
	public abstract void uniform1f(int location, float v0);
	
	public abstract void uniform1fv(int location, WebGLFloatArray v);
	
	public abstract void uniform1fv(int location, float[] values);

	public abstract void uniform1i(int location, int v0);
	
	public abstract void uniform1iv(int location, WebGLIntArray v);
	
	public abstract void uniform1iv(int location, int[] values);
	
	public abstract void uniform2f(int location, float v0, float v1);
	
	public abstract void uniform2fv(int location, WebGLFloatArray v);
	
	public abstract void uniform2fv(int location, float[] values);

	public abstract void uniform2i(int location, int v0, int v1);
	
	public abstract void uniform2iv(int location, WebGLIntArray v);
	
	public abstract void uniform2iv(int location, int[] values);
	
	public abstract void uniform3f(int location, float v0, float v1, float v2);
	
	public abstract void uniform3fv(int location, WebGLFloatArray v);
	
	public abstract void uniform3fv(int location, float[] values);

	public abstract void uniform3i(int location, int v0, int v1, int v2);
	
	public abstract void uniform3iv(int location, WebGLIntArray v);
	
	public abstract void uniform3iv(int location, int[] values);
	
	public abstract void uniform4f(int location, float v0, float v1, float v2, float v3);
	
	public abstract void uniform4fv(int location, WebGLFloatArray v);
	
	public abstract void uniform4fv(int location, float[] values);

	public abstract void uniform4i(int location, int v0, int v1, int v2, int v3);
	
	public abstract void uniform4iv(int location, WebGLIntArray v);
	
	public abstract void uniform4iv(int location, int[] values);

	public abstract void uniformMatrix2fv(int location, boolean transpose,
			WebGLFloatArray value);
	
	public abstract void uniformMatrix2fv(int location, boolean transpose,
			float[] value);

	public abstract void uniformMatrix3fv(int location, boolean transpose,
			WebGLFloatArray value);
	
	public abstract void uniformMatrix3fv(int location, boolean transpose,
			float[] value);

	public abstract void uniformMatrix4fv(int location, boolean transpose,
			WebGLFloatArray value);
	
	public abstract void uniformMatrix4fv(int location, boolean transpose,
			float[] value);

	public abstract WebGLActiveInfo getActiveUniform(WebGLProgram program, int idx);
	
	@JsName("getUniform")
	public abstract boolean getUniformb(WebGLProgram program, int location);
	
	@JsName("getUniform")
	public abstract int getUniformi(WebGLProgram program, int location);
	
	@JsName("getUniform")
	public abstract float getUniformf(WebGLProgram program, int location);
	
	@JsName("getUniform")
	public abstract <T extends WebGLArray<?>> T getUniforma(WebGLProgram program, int location);

	public abstract int getUniformLocation(WebGLProgram program, String name);
	
	// //////////////////////
	// Attribute variables //
	// //////////////////////
	
	public abstract void vertexAttribPointer(int idx, int size, int type, boolean norm,
			int stride, int offset);

	public abstract void enableVertexAttribArray(int index);
	
	public abstract void disableVertexAttribArray(int index);

	public abstract int getAttribLocation(WebGLProgram program, String name);
	
	public abstract void bindAttribLocation(WebGLProgram program, int idx,
			String name);
	
	public abstract WebGLActiveInfo getActiveAttrib(WebGLProgram program, int idx);

	/**
	 * @param index
	 * @param pname
	 *            VERTEX_ATTRIB_ARRAY_BUFFER_BINDING, CURRENT_VERTEX_ATTRIB
	 * @return
	 */
	public abstract <T extends JavaScriptObject> T getVertexAttrib(int index, int pname);
	
	/**
	 * @param index
	 * @param pname
	 *            VERTEX_ATTRIB_ARRAY_ENABLED, VERTEX_ATTRIB_ARRAY_NORMALIZED
	 * @return
	 */
	@JsName("getVertexAttrib")
	public abstract boolean getVertexAttribb(int index, int pname);

	/**
	 * @param index
	 * @param pname
	 *            VERTEX_ATTRIB_ARRAY_SIZE, VERTEX_ATTRIB_ARRAY_STRIDE,
	 *            VERTEX_ATTRIB_ARRAY_TYPE
	 * @return
	 */
	@JsName("getVertexAttrib")
	public abstract int getVertexAttribi(int index, int pname);
	
	public abstract int getVertexAttribOffset(int index, String pname);
	
	public abstract void vertexAttrib1f(int indx, float x);

	public abstract void vertexAttrib2f(int indx, float x, float y);

	public abstract void vertexAttrib3f(int indx, float x, float y, float z);

	public abstract void vertexAttrib4f(int indx, float x, float y, float z, float w);

	public abstract void vertexAttrib1fv(int indx, WebGLFloatArray values);

	public abstract void vertexAttrib1fv(int indx, float[] values);

	public abstract void vertexAttrib2fv(int indx, WebGLFloatArray values);

	public abstract void vertexAttrib2fv(int indx, float[] values);

	public abstract void vertexAttrib3fv(int indx, WebGLFloatArray values);

	public abstract void vertexAttrib3fv(int indx, float[] values);

	public abstract void vertexAttrib4fv(int indx, WebGLFloatArray values);

	public abstract void vertexAttrib4fv(int indx, float[] values);
	
	// /////////////
	// Array data //
	// /////////////
	
	/**
	 * @param mode POINTS LINES LINE_LOOP LINE_STRIP TRIANGLES TRIANGLE_STRIP TRIANGLE_FAN
	 * @param first
	 * @param count
	 */
	public abstract void drawArrays(int mode, int first, int count);
	
	/**
	 * @param mode
	 * @param count
	 * @param type UNSIGNED_BYTE UNSIGNED_SHORT
	 * @param offset
	 */
	public abstract void drawElements(int mode, int count, int type, int offset);  

	// ////////////
	// Textures //
	// ////////////

	public abstract WebGLTexture createTexture();

	public abstract void deleteTexture(WebGLTexture texture);

	/**
	 * @param target TEXTURE_2D, TEXTURE_CUBE_MAP
	 * @param texture the texture to delete
	 */
	public abstract void bindTexture(int target, WebGLTexture texture);

	/**
	 * @param texture the texture unit (TEXTURE0, TEXTURE1, ...)
	 */
	public abstract void activeTexture(int texture);

	/**
	 * @param target TEXTURE_2D, TEXTURE_CUBE_MAP
	 * @param level
	 * @param data JavaScript Image to set
	 */
	public abstract void texImage2D(int target, int level, JavaScriptObject data);

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
	public abstract void texImage2D(int target, int level, int intformat, int width,
			int height, int border, int format, int type, JavaScriptObject data);

	public abstract boolean isTexture(WebGLTexture texture);

	public abstract void generateMipmap(int target);
	
	/**
	 * @param target
	 * @param pname TEXTURE_MAG_FILTER, TEXTURE_MIN_FILTER, TEXTURE_WRAP_S, TEXTURE_WRAP_T
	 * @return
	 */
	@JsName("getTexParameter")
	public abstract int getTexParameteri(int target, int pname);
	
	public abstract void texParameteri(int target, int pname, int value);
	
	public abstract void texParameterf(int target, int pname, float value);

	public abstract void copyTexSubImage2D(int target, int level, int intformat, int xoffset, int yoffset, int x, int y, int width, int height);
	
	public abstract void copyTexImage2D(int target, int level, int intformat, int x, int y, int width, int height, int border);
	
	public abstract void texSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, JavaScriptObject data);

	// //////////
	// Culling //
	// //////////

	/**
	 * @param mode FRONT BACK FRONT_AND_BACK
	 */
	public abstract void cullFace(int mode);

	/**
	 * @param mode CW CCW
	 */
	public abstract void frontFace(int mode);
	
	// ///////////
	// Blending //
	// ///////////
	
	/**
	 * @param sfactor ZERO ONE SRC_COLOR DST_COLOR SRC_ALPHA DST_ALPHA CONSTANT_COLOR CONSTANT_ALPHA ONE_MINUS_SRC_ALPHA ONE_MINUS_DST_ALPHA ONE_MINUS_SRC_COLOR ONE_MINUS_DST_COLOR ONE_MINUS_CONSTANT_COLOR ONE_MINUS_CONSTANT_ALPHA SRC_ALPHA_SATURATE
	 * @param dfactor ZERO ONE SRC_COLOR DST_COLOR SRC_ALPHA DST_ALPHA CONSTANT_COLOR CONSTANT_ALPHA ONE_MINUS_SRC_ALPHA ONE_MINUS_DST_ALPHA ONE_MINUS_SRC_COLOR ONE_MINUS_DST_COLOR ONE_MINUS_CONSTANT_COLOR ONE_MINUS_CONSTANT_ALPHA
	 */
	public abstract void blendFunc(int sfactor, int dfactor);
	
	public abstract void blendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
	
	/**
	 * @param mode FUNC_ADD FUNC_SUBTRACT FUNC_REVERSE_SUBTRACT
	 */
	public abstract void blendEquation(int mode);
	
	public abstract void blendEquationSeparate(int modeRGB, int modeAlpha);
	
	public abstract void blendColor(float red, float green, float blue, float alpha);  
	
	// ///////////////
	// Depth buffer //
	// ///////////////
	
	/**
	 * @param func NEVER LESS EQUAL LEQUAL GREATER NOTEQUAL GEQUAL ALWAYS
	 */
	public abstract void depthFunc(int func);  

	public abstract void depthMask(boolean flag);  
	
	public abstract void depthRange(float nearVal, float farVal);  
	
	public abstract void clearDepth(float depth);
	
	public abstract void polygonOffset(float factor, float units);  
	
	// ///////////////
	// Framebuffers //
	//////////////////
	
	public abstract WebGLFramebuffer createFramebuffer();
	
	public abstract void deleteFramebuffer(WebGLFramebuffer buffer);
	
	/**
	 * @param target FRAMEBUFFER
	 * @param buffer
	 */
	public abstract void bindFramebuffer(int target, WebGLFramebuffer buffer);
	
	/**
	 * @param target
	 * @return one of the following constants: FRAMEBUFFER_COMPLETE FRAMEBUFFER_INCOMPLETE_ATTACHMENT FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT FRAMEBUFFER_INCOMPLETE_DIMENSIONS FRAMEBUFFER_UNSUPPORTED
	 */
	public abstract int checkFramebufferStatus(int target);
	
	/**
	 * @param target
	 * @param attachment DEPTH_ATTACHMENT COLOR_ATTACHMENT0 STENCIL_ATTACHMENT
	 * @param rbtarget
	 * @param rbuffer
	 * @return
	 */
	public abstract int framebufferRenderbuffer(int target, int att, int rbtarget, WebGLRenderbuffer rbuffer);
	
	/**
	 * @param target
	 * @param attachment FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE FRAMEBUFFER_ATTACHMENT_OBJECT_NAME FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
	 * @param pname
	 * @return
	 */
	public abstract int getFramebufferAttachmentParameteri(int target, int attachment, int pname);
	
	/**
	 * @param target
	 * @param att
	 * @param textarget TEXTURE_2D TEXTURE_CUBE_MAP_POSITIVE_X TEXTURE_CUBE_MAP_NEGATIVE_X TEXTURE_CUBE_MAP_POSITIVE_Y TEXTURE_CUBE_MAP_NEGATIVE_Y TEXTURE_CUBE_MAP_POSITIVE_Z TEXTURE_CUBE_MAP_NEGATIVE_Z
	 * @param tex
	 * @param level
	 * @return
	 */
	public abstract int framebufferTexture2D(int target, int att, int textarget, WebGLTexture tex, int level);
	
	/**
	 * @param pname PACK_ALIGNMENT UNPACK_ALIGNMENT
	 * @param param
	 */
	public abstract void pixelStorei(int pname, int param);
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param format ALPHA RGB RGBA
	 * @param type UNSIGNED_BYTE UNSIGNED_SHORT_4_4_4_4 UNSIGNED_SHORT_5_5_5_1 UNSIGNED_SHORT_5_6_5
	 * @return
	 */
	public abstract <T extends WebGLArray<?>> T readPixels(int x, int y, int width, int height, int format, int type);
	
	public abstract boolean isFramebuffer(WebGLFramebuffer buffer);
	
	// /////////////////
	// Stencil buffer //
	// /////////////////
	
	/**
	 * @param func NEVER LESS EQUAL LEQUAL GREATER NOTEQUAL GEQUAL ALWAYS
	 * @param ref
	 * @param mask
	 */
	public abstract void stencilFunc(int func, int ref, int mask);
	
	/**
	 * @param face FRONT BACK FRONT_AND_BACK
	 * @param func
	 * @param ref
	 * @param mask
	 */
	public abstract void stencilFuncSeparate(int face, int func, int ref, int mask);
	
	public abstract void stencilMask(int mask);
	
	public abstract void stencilMaskSeparate(int face, int mask);
	
	/**
	 * @param sfail KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 * @param dpfail KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 * @param dppass KEEP ZERO INCR INCR_WRAP REPLACE INVERT DECR DECR_WRAP
	 */
	public abstract void stencilOp(int sfail, int dpfail, int dppass);
	
	public abstract void stencilOpSeparate(int face, int sfail, int dpfail, int dppass);
	
	public abstract void clearStencil(int s);
	
	// ////////////////
	// Multisampling //
	// ////////////////
	
	public abstract void sampleCoverage(float value, boolean invert);
	
}
