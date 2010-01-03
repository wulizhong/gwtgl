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
@GenConst(typeProperty = "webgl_type")
public interface IWebGLConstants extends IConst {
	int DEPTH_TEST();

	int VERTEX_SHADER();

	int FRAGMENT_SHADER();

	int COMPILE_STATUS();

	int LINK_STATUS();

	int LEQUAL();

	int ELEMENT_ARRAY_BUFFER();

	int ARRAY_BUFFER();

	int STREAM_DRAW();

	int STATIC_DRAW();

	int DYNAMIC_DRAW();

	int COLOR_BUFFER_BIT();

	int DEPTH_BUFFER_BIT();

	int STENCIL_BUFFER_BIT();

	int TRIANGLES();

	int FLOAT();

	int TEXTURE0();

	int TEXTURE_2D();

	int TEXTURE_CUBE_MAP();

	int CULL_FACE();

	int FRONT();

	int BACK();

	int FRONT_AND_BACK();

	int CW();

	int CCW();

	int NO_ERROR();
	
	int FUNC_ADD();
	
	int FUNC_SUBTRACT();
	
	int FUNC_REVERSE_SUBTRACT();
	
	int ZERO();
	
	int ONE();

	int SRC_COLOR();

	int DST_COLOR();

	int SRC_ALPHA();

	int DST_ALPHA();

	int CONSTANT_COLOR();

	int CONSTANT_ALPHA();

	int ONE_MINUS_SRC_ALPHA();

	int ONE_MINUS_DST_ALPHA();

	int ONE_MINUS_SRC_COLOR();

	int ONE_MINUS_DST_COLOR();

	int ONE_MINUS_CONSTANT_COLOR();

	int ONE_MINUS_CONSTANT_ALPHA();

	int SRC_ALPHA_SATURATE();
	
	int NEVER();
	
	int LESS();
	
	int EQUAL();
	
	int GREATER();
	
	int NOTEQUAL();
	
	int GEQUAL();
	
	int ALWAYS();
	
	int FRAMEBUFFER();
	
	int FRAMEBUFFER_COMPLETE();
	
	int FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
	
	int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
	
	int FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
	
	int FRAMEBUFFER_UNSUPPORTED();

	int DEPTH_ATTACHMENT();
	
	int COLOR_ATTACHMENT0(); 
	
	int STENCIL_ATTACHMENT();
	
	int TEXTURE_CUBE_MAP_POSITIVE_X();
	
	int TEXTURE_CUBE_MAP_NEGATIVE_X();
	
	int TEXTURE_CUBE_MAP_POSITIVE_Y();
	
	int TEXTURE_CUBE_MAP_NEGATIVE_Y();
	
	int TEXTURE_CUBE_MAP_POSITIVE_Z();
	
	int TEXTURE_CUBE_MAP_NEGATIVE_Z();
	
	int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
	
	int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
	
	int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
	
	int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
	
	int PACK_ALIGNMENT();
	
	int UNPACK_ALIGNMENT();
	
	int ALPHA();
	
	int RGB();
	
	int RGBA();
	
	int UNSIGNED_BYTE();
	
	int UNSIGNED_SHORT_4_4_4_4();
	
	int UNSIGNED_SHORT_5_5_5_1();
	
	int UNSIGNED_SHORT_5_6_5();
	
	int DELETE_STATUS();

	int INFO_LOG_LENGTH();

	int SHADER_SOURCE_LENGTH();

	int MAX_VERTEX_UNIFORM_VECTORS();

	int MAX_FRAGMENT_UNIFORM_VECTORS();

	int KEEP();

	int INCR();

	int INCR_WRAP();

	int REPLACE();

	int INVERT();

	int DECR();

	int DECR_WRAP();

	int STENCIL_TEST();

	int STENCIL_CLEAR_VALUE();

	int STENCIL_FUNC();

	int STENCIL_FAIL();

	int STENCIL_REF();

	int STENCIL_VALUE_MASK();

	int STENCIL_WRITEMASK();

	int STENCIL_BACK_FUNC();

	int STENCIL_BACK_FAIL();

	int STENCIL_BACK_REF();

	int STENCIL_BITS();

	int STENCIL_BACK_WRITEMASK();

	int STENCIL_BACK_VALUE_MASK();

	int STENCIL_BACK_PASS_DEPTH_FAIL();

	int STENCIL_BACK_PASS_DEPTH_PASS();

	int STENCIL_PASS_DEPTH_FAIL();

	int STENCIL_PASS_DEPTH_PASS();

	int UNSIGNED_SHORT();

	int POINTS();

	int LINES();

	int LINE_LOOP();

	int LINE_STRIP();

	int TRIANGLE_FAN();

	int TRIANGLE_STRIP();

	int SAMPLE_COVERAGE();

	int SAMPLE_ALPHA_TO_COVERAGE();

	int SAMPLE_COVERAGE_VALUE();

	int SAMPLE_COVERAGE_INVERT();

	int SAMPLE_BUFFERS();

	int SAMPLES();

	int DITHER();

	int INVALID_ENUM();

	int INVALID_VALUE();

	int INVALID_OPERATION();

	int INVALID_FRAMEBUFFER_OPERATION();

	int OUT_OF_MEMORY();

	int VIEWPORT();

	int MAX_VIEWPORT_DIMS();

	int COLOR_CLEAR_VALUE();

	int SCISSOR_BOX();

	int LINE_WIDTH();

	int ALIASED_POINT_SIZE_RANGE();

	int ALIASED_LINE_WIDTH_RANGE();

	int COLOR_WRITEMASK();

	int SUBPIXEL_BITS();

	int TEXTURE_WRAP_S();

	int TEXTURE_WRAP_T();

	int LUMINANCE();

	int LUMINANCE_ALPHA();

	int TEXTURE_BINDING_2D();

	int TEXTURE_BINDING_CUBE_MAP();

	int MAX_TEXTURE_SIZE();

	int MAX_CUBE_MAP_TEXTURE_SIZE();

	int ACTIVE_TEXTURE();

	int MAX_TEXTURE_IMAGE_UNITS();

	int MAX_VERTEX_TEXTURE_IMAGE_UNITS();

	int MAX_COMBINED_TEXTURE_IMAGE_UNITS();

	int CURRENT_PROGRAM();

	int ARRAY_BUFFER_BINDING();

	int ELEMENT_ARRAY_BUFFER_BINDING();

	int VALIDATE_STATUS();

	int ACTIVE_ATTRIBUTE_MAX_LENGTH();

	int ACTIVE_UNIFORM_MAX_LENGTH();

	int ATTACHED_SHADERS();

	int ACTIVE_UNIFORMS();

	int ACTIVE_ATTRIBUTES();

	int CLAMP_TO_EDGE();
	
	int REPEAT();

	int TEXTURE_MIN_FILTER();

	int TEXTURE_MAG_FILTER();

	int LINEAR();
	
	int NEAREST();

	int NEAREST_MIPMAP_NEAREST();

	int LINEAR_MIPMAP_NEAREST();

	int NEAREST_MIPMAP_LINEAR();

	int LINEAR_MIPMAP_LINEAR();

	int BYTE();

	int SHORT();

	int INT();

	int UNSIGNED_INT();

	int SHADER_TYPE();
}
