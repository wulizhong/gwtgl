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
 * @author Steffen Schäfer
 * 
 */
public enum TextureTarget implements IWebGLConstEnum {
	/**
	 * Value to identify TextureTarget TEXTURE_2D.
	 */
	TEXTURE_2D(WebGLRenderingContext.TEXTURE_2D),
	/**
	 * Value to identify TextureTarget TEXTURE_CUBE_MAP.
	 */
	TEXTURE_CUBE_MAP(WebGLRenderingContext.TEXTURE_CUBE_MAP);

	private final int target;

	TextureTarget(int target) {
		this.target = target;
	}

	public int getIntValue() {
		return target;
	}

	/**
	 * Returns the matching enum value for the given int value.
	 * 
	 * @param value
	 * @return the matching enum value for the given int value
	 */
	public static TextureTarget getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
}