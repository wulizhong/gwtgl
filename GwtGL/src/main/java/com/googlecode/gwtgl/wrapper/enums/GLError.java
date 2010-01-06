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
 * 
 * @author Sönke Sothmann
 *
 */
public enum GLError implements IWebGLConstEnum{
	/**
	 * No error has been recorded
	 */
	NO_ERROR(WebGLCanvas.NO_ERROR),
	
	/**
	 * An unacceptable value is specified for an enumerated argument. The offending command is ignored and has no other side effect than to set the error flag.
	 */
	INVALID_ENUM(WebGLCanvas.INVALID_ENUM),
	
	/**
	 * A numeric argument is out of range. The offending command is ignored and has no other side effect than to set the error flag.
	 */
	INVALID_VALUE(WebGLCanvas.INVALID_VALUE),
	
	/**
	 * The specified operation is not allowed in the current state. he offending command is ignored and has no other side effect than to set the error flag.
	 */
	INVALID_OPERATION(WebGLCanvas.INVALID_OPERATION),
	
	/**
	 * The command is trying to render to or read from the framebuffer while the currently bound framebuffer is not framebuffer complete. The offending command is ignored and has no other side effect than to set the error flag.
	 */
	INVALID_FRAMEBUFFER_OPERATION(WebGLCanvas.INVALID_FRAMEBUFFER_OPERATION),
	
	/**
	 * There is not enough memory left to execute the command
	 */
	OUT_OF_MEMORY(WebGLCanvas.OUT_OF_MEMORY);
	
	private final int value;

	GLError(int value) {
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
	public static GLError getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
}
