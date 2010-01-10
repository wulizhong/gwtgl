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

import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.wrapper.util.EnumUtil;

/**
 * @author Steffen Schäfer
 *
 */
public enum BufferTarget implements IWebGLConstEnum {
	ARRAY_BUFFER(WebGLRenderingContext.ARRAY_BUFFER, WebGLRenderingContext.ARRAY_BUFFER_BINDING), ELEMENT_ARRAY_BUFFER(
			WebGLRenderingContext.ELEMENT_ARRAY_BUFFER,
			WebGLRenderingContext.ELEMENT_ARRAY_BUFFER_BINDING);
	
	private final int target;
	private final int binding;

	BufferTarget(int target, int binding) {
		this.target = target;
		this.binding = binding;
	}

	public int getIntValue() {
		return target;
	}

	public int getBinding() {
		return binding;
	}
	
	/**
	 * Returns the matching enum value for the given int value.
	 * 
	 * @param value
	 * @return the matching enum value for the given int value
	 */
	public static BufferTarget getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
	
}