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
package com.googlecode.gwtgl.wrapper.enums;

import com.googlecode.gwtgl.binding.WebGLCanvas;
import com.googlecode.gwtgl.wrapper.util.EnumUtil;

/**
 * Specifies a symbolic constant indicating a GL capability
 * @author Sönke Sothmann
 *
 */
public enum GLCapability implements IWebGLConstEnum {
	BLEND(WebGLCanvas.BLEND),
	CULL_FACE(WebGLCanvas.CULL_FACE),
	DEPTH_TEST(WebGLCanvas.DEPTH_TEST),
	DITHER(WebGLCanvas.DITHER),
	POLYGON_OFFSET_FILL(WebGLCanvas.POLYGON_OFFSET_FILL),
	SAMPLE_ALPHA_TO_COVERAGE(WebGLCanvas.SAMPLE_ALPHA_TO_COVERAGE),
	SAMPLE_COVERAGE(WebGLCanvas.SAMPLE_COVERAGE),
	SCISSOR_TEST(WebGLCanvas.SCISSOR_TEST),
	STENCIL_TEST(WebGLCanvas.STENCIL_TEST);
	
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
