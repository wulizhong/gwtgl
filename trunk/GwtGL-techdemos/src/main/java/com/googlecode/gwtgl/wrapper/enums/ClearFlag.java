/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
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
 * Indicates the buffers to be cleared.
 * 
 * @author Sönke Sothmann
 * 
 */
public enum ClearFlag implements IWebGLConstEnum {
	/**
	 * Value to identify ClearFlag COLOR_BUFFER.
	 */
	COLOR_BUFFER(WebGLRenderingContext.COLOR_BUFFER_BIT),
	/**
	 * Value to identify ClearFlag DEPTH_BUFFER.
	 */
	DEPTH_BUFFER(WebGLRenderingContext.DEPTH_BUFFER_BIT),
	/**
	 * Value to identify ClearFlag STENCIL_BUFFER.
	 */
	STENCIL_BUFFER(WebGLRenderingContext.STENCIL_BUFFER_BIT);

	private final int value;

	ClearFlag(int value) {
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
	public static ClearFlag getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}

}
