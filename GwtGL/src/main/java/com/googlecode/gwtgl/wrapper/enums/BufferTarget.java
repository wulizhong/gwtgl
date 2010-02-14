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
 * @author Steffen Schäfer
 * 
 */
public enum BufferTarget implements IWebGLConstEnum {
	/**
	 * Value to identify BufferTarget ARRAY_BUFFER.
	 */
	ARRAY_BUFFER(WebGLRenderingContext.ARRAY_BUFFER,
			WebGLRenderingContext.ARRAY_BUFFER_BINDING),
	/**
	 * Value to identify BufferTarget ELEMENT_ARRAY_BUFFER.
	 */
	ELEMENT_ARRAY_BUFFER(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER,
			WebGLRenderingContext.ELEMENT_ARRAY_BUFFER_BINDING);

	private final int target;
	private final int binding;

	private BufferTarget(int target, int binding) {
		this.target = target;
		this.binding = binding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.wrapper.enums.IWebGLConstEnum#getIntValue()
	 */
	public int getIntValue() {
		return target;
	}

	/**
	 * Returns the value for the binding of this BufferTarget.
	 * 
	 * @return the value for the binding of this BufferTarget.
	 */
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