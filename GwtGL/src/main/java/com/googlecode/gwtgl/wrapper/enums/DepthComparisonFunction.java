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
 * Specifies the conditions under which the pixel will be drawn
 * 
 * @author Sönke Sothmann
 * 
 */
public enum DepthComparisonFunction implements IWebGLConstEnum {
	/**
	 * Never passes
	 */
	NEVER(WebGLRenderingContext.NEVER),

	/**
	 * Passes if the incoming depth value is less than the stored depth value
	 */
	LESS(WebGLRenderingContext.LESS),

	/**
	 * Passes if the incoming depth value is equal to the stored depth value
	 */
	EQUAL(WebGLRenderingContext.EQUAL),

	/**
	 * Passes if the incoming depth value is less than or equal to the stored
	 * depth value
	 */
	LEQUAL(WebGLRenderingContext.LEQUAL),

	/**
	 * Passes if the incoming depth value is greater than the stored depth value
	 */
	GREATER(WebGLRenderingContext.GREATER),

	/**
	 * Passes if the incoming depth value is not equal to the stored depth value
	 */
	NOTEQUAL(WebGLRenderingContext.NOTEQUAL),

	/**
	 * Passes if the incoming depth value is greater than or equal to the stored
	 * depth value
	 */
	GEQUAL(WebGLRenderingContext.GEQUAL),

	/**
	 * Always passes
	 */
	ALWAYS(WebGLRenderingContext.ALWAYS);

	private final int value;

	DepthComparisonFunction(int value) {
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
	public static DepthComparisonFunction getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
}
