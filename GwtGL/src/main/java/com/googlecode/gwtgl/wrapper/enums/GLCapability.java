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
package com.googlecode.gwtgl.wrapper.enums;

import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.wrapper.util.EnumUtil;

/**
 * Specifies a symbolic constant indicating a GL capability.
 * 
 * @author Sönke Sothmann
 * 
 */
public enum GLCapability implements IWebGLConstEnum {
	/**
	 * Value to identify GLCapability BLEND.
	 */
	BLEND(WebGLRenderingContext.BLEND),
	/**
	 * Value to identify GLCapability CULL_FACE.
	 */
	CULL_FACE(WebGLRenderingContext.CULL_FACE),
	/**
	 * Value to identify GLCapability DEPTH_TEST.
	 */
	DEPTH_TEST(WebGLRenderingContext.DEPTH_TEST),
	/**
	 * Value to identify GLCapability DITHER.
	 */
	DITHER(WebGLRenderingContext.DITHER),
	/**
	 * Value to identify GLCapability POLYGON_OFFSET_FILL.
	 */
	POLYGON_OFFSET_FILL(WebGLRenderingContext.POLYGON_OFFSET_FILL),
	/**
	 * Value to identify GLCapability SAMPLE_ALPHA_TO_COVERAGE.
	 */
	SAMPLE_ALPHA_TO_COVERAGE(WebGLRenderingContext.SAMPLE_ALPHA_TO_COVERAGE),
	/**
	 * Value to identify GLCapability SAMPLE_COVERAGE.
	 */
	SAMPLE_COVERAGE(WebGLRenderingContext.SAMPLE_COVERAGE),
	/**
	 * Value to identify GLCapability SCISSOR_TEST.
	 */
	SCISSOR_TEST(WebGLRenderingContext.SCISSOR_TEST),
	/**
	 * Value to identify GLCapability STENCIL_TEST.
	 */
	STENCIL_TEST(WebGLRenderingContext.STENCIL_TEST);

	private final int value;

	private GLCapability(int value) {
		this.value = value;
	}

	@Override
	public int getIntValue() {
		return value;
	}

	/**
	 * Returns the matching enum value for the given int value.
	 * 
	 * @param value
	 * @return the matching enum value for the given int value
	 */
	public static GLCapability getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
}
