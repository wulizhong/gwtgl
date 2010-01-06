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
package com.googlecode.gwtgl.binding.impl;

import com.googlecode.gwtgl.gen.api.GenConst;
import com.googlecode.gwtgl.gen.api.IConst;

/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
@GenConst("webgl_type")
public interface IWebGLConstants extends IConst {
	 /* ClearBufferMask */
	int DEPTH_BUFFER_BIT();
	int STENCIL_BUFFER_BIT();
	int COLOR_BUFFER_BIT();
    
    /* BeginMode */
	int POINTS();
	int LINES();
	int LINE_LOOP();
	int LINE_STRIP();
	int TRIANGLES();
	int TRIANGLE_STRIP();
	int TRIANGLE_FAN();
    
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
	int ZERO();
	int ONE();
	int SRC_COLOR();
	int ONE_MINUS_SRC_COLOR();
	int SRC_ALPHA();
	int ONE_MINUS_SRC_ALPHA();
	int DST_ALPHA();
	int ONE_MINUS_DST_ALPHA();
    
    /* BlendingFactorSrc */
    /*      ZERO */
    /*      ONE */
	int DST_COLOR();
	int ONE_MINUS_DST_COLOR();
	int SRC_ALPHA_SATURATE();
    /*      SRC_ALPHA */
    /*      ONE_MINUS_SRC_ALPHA */
    /*      DST_ALPHA */
    /*      ONE_MINUS_DST_ALPHA */
    
    /* BlendEquationSeparate */
	int FUNC_ADD();
	int BLEND_EQUATION();
	int BLEND_EQUATION_RGB();   /* same as BLEND_EQUATION */
	int BLEND_EQUATION_ALPHA();
    
    /* BlendSubtract */
	int FUNC_SUBTRACT();
	int FUNC_REVERSE_SUBTRACT();
    
    /* Separate Blend Functions */
	int BLEND_DST_RGB();
	int BLEND_SRC_RGB();
	int BLEND_DST_ALPHA();
	int BLEND_SRC_ALPHA();
	int CONSTANT_COLOR();
	int ONE_MINUS_CONSTANT_COLOR();
	int CONSTANT_ALPHA();
	int ONE_MINUS_CONSTANT_ALPHA();
	int BLEND_COLOR();
    
    /* Buffer Objects */
	int ARRAY_BUFFER();
	int ELEMENT_ARRAY_BUFFER();
	int ARRAY_BUFFER_BINDING();
	int ELEMENT_ARRAY_BUFFER_BINDING();
	int STREAM_DRAW();
	int STATIC_DRAW();
	int DYNAMIC_DRAW();
	int BUFFER_SIZE();
	int BUFFER_USAGE();
	int CURRENT_VERTEX_ATTRIB();
    
    /* CullFaceMode */
	int FRONT();
	int BACK();
	int FRONT_AND_BACK();
    
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
	int TEXTURE_2D();
	int CULL_FACE();
	int BLEND();
	int DITHER();
	int STENCIL_TEST();
	int DEPTH_TEST();
	int SCISSOR_TEST();
	int POLYGON_OFFSET_FILL();
	int SAMPLE_ALPHA_TO_COVERAGE();
	int SAMPLE_COVERAGE();
    
    /* ErrorCode */
	int NO_ERROR();
	int INVALID_ENUM();
	int INVALID_VALUE();
	int INVALID_OPERATION();
	int OUT_OF_MEMORY();
    
    /* FrontFaceDirection */
	int CW();
	int CCW();
    
    /* GetPName */
	int LINE_WIDTH();
	int ALIASED_POINT_SIZE_RANGE();
	int ALIASED_LINE_WIDTH_RANGE();
	int CULL_FACE_MODE();
	int FRONT_FACE();
	int DEPTH_RANGE();
	int DEPTH_WRITEMASK();
	int DEPTH_CLEAR_VALUE();
	int DEPTH_FUNC();
	int STENCIL_CLEAR_VALUE();
	int STENCIL_FUNC();
	int STENCIL_FAIL();
	int STENCIL_PASS_DEPTH_FAIL();
	int STENCIL_PASS_DEPTH_PASS();
	int STENCIL_REF();
	int STENCIL_VALUE_MASK();
	int STENCIL_WRITEMASK();
	int STENCIL_BACK_FUNC();
	int STENCIL_BACK_FAIL();
	int STENCIL_BACK_PASS_DEPTH_FAIL();
	int STENCIL_BACK_PASS_DEPTH_PASS();
	int STENCIL_BACK_REF();
	int STENCIL_BACK_VALUE_MASK();
	int STENCIL_BACK_WRITEMASK();
	int VIEWPORT();
	int SCISSOR_BOX();
    /*      SCISSOR_TEST */
	int COLOR_CLEAR_VALUE();
	int COLOR_WRITEMASK();
	int UNPACK_ALIGNMENT();
	int PACK_ALIGNMENT();
	int MAX_TEXTURE_SIZE();
	int MAX_VIEWPORT_DIMS();
	int SUBPIXEL_BITS();
	int RED_BITS();
	int GREEN_BITS();
	int BLUE_BITS();
	int ALPHA_BITS();
	int DEPTH_BITS();
	int STENCIL_BITS();
	int POLYGON_OFFSET_UNITS();
    /*      POLYGON_OFFSET_FILL */
	int POLYGON_OFFSET_FACTOR();
	int TEXTURE_BINDING_2D();
	int SAMPLE_BUFFERS();
	int SAMPLES();
	int SAMPLE_COVERAGE_VALUE();
	int SAMPLE_COVERAGE_INVERT();
    
    /* GetTextureParameter */
    /*      TEXTURE_MAG_FILTER */
    /*      TEXTURE_MIN_FILTER */
    /*      TEXTURE_WRAP_S */
    /*      TEXTURE_WRAP_T */
	int NUM_COMPRESSED_TEXTURE_FORMATS();
	int COMPRESSED_TEXTURE_FORMATS();
    
    /* HintMode */
	int DONT_CARE();
	int FASTEST();
	int NICEST();
    
    /* HintTarget */
	int GENERATE_MIPMAP_HINT();
    
    /* DataType */
	int BYTE();
	int UNSIGNED_BYTE();
	int SHORT();
	int UNSIGNED_SHORT();
	int INT();
	int UNSIGNED_INT();
	int FLOAT();
    
    /* PixelFormat */
	int DEPTH_COMPONENT();
	int ALPHA();
	int RGB();
	int RGBA();
	int LUMINANCE();
	int LUMINANCE_ALPHA();
    
    /* PixelType */
    /*      UNSIGNED_BYTE */
	int UNSIGNED_SHORT_4_4_4_4();
	int UNSIGNED_SHORT_5_5_5_1();
	int UNSIGNED_SHORT_5_6_5();
    
    /* Shaders */
	int FRAGMENT_SHADER();
	int VERTEX_SHADER();
	int MAX_VERTEX_ATTRIBS();
	int MAX_VERTEX_UNIFORM_VECTORS();
	int MAX_VARYING_VECTORS();
	int MAX_COMBINED_TEXTURE_IMAGE_UNITS();
	int MAX_VERTEX_TEXTURE_IMAGE_UNITS();
	int MAX_TEXTURE_IMAGE_UNITS();
	int MAX_FRAGMENT_UNIFORM_VECTORS();
	int SHADER_TYPE();
	int DELETE_STATUS();
	int LINK_STATUS();
	int VALIDATE_STATUS();
	int ATTACHED_SHADERS();
	int ACTIVE_UNIFORMS();
	int ACTIVE_UNIFORM_MAX_LENGTH();
	int ACTIVE_ATTRIBUTES();
	int ACTIVE_ATTRIBUTE_MAX_LENGTH();
	int SHADING_LANGUAGE_VERSION();
	int CURRENT_PROGRAM();
    
    /* StencilFunction */
	int NEVER();
	int LESS();
	int EQUAL();
	int LEQUAL();
	int GREATER();
	int NOTEQUAL();
	int GEQUAL();
	int ALWAYS();
    
    /* StencilOp */
    /*      ZERO */
	int KEEP();
	int REPLACE();
	int INCR();
	int DECR();
	int INVERT();
	int INCR_WRAP();
	int DECR_WRAP();
    
    /* StringName */
	int VENDOR();
	int RENDERER();
	int VERSION();
	int EXTENSIONS();
    
    /* TextureMagFilter */
	int NEAREST();
	int LINEAR();
    
    /* TextureMinFilter */
    /*      NEAREST */
    /*      LINEAR */
	int NEAREST_MIPMAP_NEAREST();
	int LINEAR_MIPMAP_NEAREST();
	int NEAREST_MIPMAP_LINEAR();
	int LINEAR_MIPMAP_LINEAR();
    
    /* TextureParameterName */
	int TEXTURE_MAG_FILTER();
	int TEXTURE_MIN_FILTER();
	int TEXTURE_WRAP_S();
	int TEXTURE_WRAP_T();
    
    /* TextureTarget */
    /*      TEXTURE_2D */
	int TEXTURE();
	int TEXTURE_CUBE_MAP();
	int TEXTURE_BINDING_CUBE_MAP();
	int TEXTURE_CUBE_MAP_POSITIVE_X();
	int TEXTURE_CUBE_MAP_NEGATIVE_X();
	int TEXTURE_CUBE_MAP_POSITIVE_Y();
	int TEXTURE_CUBE_MAP_NEGATIVE_Y();
	int TEXTURE_CUBE_MAP_POSITIVE_Z();
	int TEXTURE_CUBE_MAP_NEGATIVE_Z();
	int MAX_CUBE_MAP_TEXTURE_SIZE();
    
    /* TextureUnit */
	int TEXTURE0();
	int TEXTURE1();
	int TEXTURE2();
	int TEXTURE3();
	int TEXTURE4();
	int TEXTURE5();
	int TEXTURE6();
	int TEXTURE7();
	int TEXTURE8();
	int TEXTURE9();
	int TEXTURE10();
	int TEXTURE11();
	int TEXTURE12();
	int TEXTURE13();
	int TEXTURE14();
	int TEXTURE15();
	int TEXTURE16();
	int TEXTURE17();
	int TEXTURE18();
	int TEXTURE19();
	int TEXTURE20();
	int TEXTURE21();
	int TEXTURE22();
	int TEXTURE23();
	int TEXTURE24();
	int TEXTURE25();
	int TEXTURE26();
	int TEXTURE27();
	int TEXTURE28();
	int TEXTURE29();
	int TEXTURE30();
	int TEXTURE31();
	int ACTIVE_TEXTURE();
    
    /* TextureWrapMode */
	int REPEAT();
	int CLAMP_TO_EDGE();
	int MIRRORED_REPEAT();
    
    /* Uniform Types */
	int FLOAT_VEC2();
	int FLOAT_VEC3();
	int FLOAT_VEC4();
	int INT_VEC2();
	int INT_VEC3();
	int INT_VEC4();
	int BOOL();
	int BOOL_VEC2();
	int BOOL_VEC3();
	int BOOL_VEC4();
	int FLOAT_MAT2();
	int FLOAT_MAT3();
	int FLOAT_MAT4();
	int SAMPLER_2D();
	int SAMPLER_CUBE();
    
    /* Vertex Arrays */
	int VERTEX_ATTRIB_ARRAY_ENABLED();
	int VERTEX_ATTRIB_ARRAY_SIZE();
	int VERTEX_ATTRIB_ARRAY_STRIDE();
	int VERTEX_ATTRIB_ARRAY_TYPE();
	int VERTEX_ATTRIB_ARRAY_NORMALIZED();
	int VERTEX_ATTRIB_ARRAY_POINTER();
	int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING();
    
    /* Read Format */
	int IMPLEMENTATION_COLOR_READ_TYPE();
	int IMPLEMENTATION_COLOR_READ_FORMAT();
    
    /* Shader Source */
	int COMPILE_STATUS();
	int INFO_LOG_LENGTH();
	int SHADER_SOURCE_LENGTH();
	int SHADER_COMPILER();
    
    /* Shader Precision-Specified Types */
	int LOW_FLOAT();
	int MEDIUM_FLOAT();
	int HIGH_FLOAT();
	int LOW_INT();
	int MEDIUM_INT();
	int HIGH_INT();
    
    /* Framebuffer Object. */
	int FRAMEBUFFER();
	int RENDERBUFFER();
	int RGBA4();
	int RGB5_A1();
	int RGB565();
	int DEPTH_COMPONENT16();
	int STENCIL_INDEX();
	int STENCIL_INDEX8();
	int RENDERBUFFER_WIDTH();
	int RENDERBUFFER_HEIGHT();
	int RENDERBUFFER_INTERNAL_FORMAT();
	int RENDERBUFFER_RED_SIZE();
	int RENDERBUFFER_GREEN_SIZE();
	int RENDERBUFFER_BLUE_SIZE();
	int RENDERBUFFER_ALPHA_SIZE();
	int RENDERBUFFER_DEPTH_SIZE();
	int RENDERBUFFER_STENCIL_SIZE();
	int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
	int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
	int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
	int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
	int COLOR_ATTACHMENT0();
	int DEPTH_ATTACHMENT();
	int STENCIL_ATTACHMENT();
	int NONE();
	int FRAMEBUFFER_COMPLETE();
	int FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
	int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
	int FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
	int FRAMEBUFFER_UNSUPPORTED();
	int FRAMEBUFFER_BINDING();
	int RENDERBUFFER_BINDING();
	int MAX_RENDERBUFFER_SIZE();
	int INVALID_FRAMEBUFFER_OPERATION();
}
