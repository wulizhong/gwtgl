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
 * 
 * @author Sönke Sothmann
 * 
 */
public enum PrimitiveRenderingMode implements IWebGLConstEnum {
	/**
	 * Value to identify PrimitiveRenderingMode POINTS.
	 */
	POINTS(WebGLRenderingContext.POINTS),
	/**
	 * Value to identify PrimitiveRenderingMode LINE_STRIP.
	 */
	LINE_STRIP(WebGLRenderingContext.LINE_STRIP),
	/**
	 * Value to identify PrimitiveRenderingMode LINE_LOOP.
	 */
	LINE_LOOP(WebGLRenderingContext.LINE_LOOP),
	/**
	 * Value to identify PrimitiveRenderingMode LINES.
	 */
	LINES(WebGLRenderingContext.LINES),
	/**
	 * Value to identify PrimitiveRenderingMode TRIANGLE_STRIP.
	 */
	TRIANGLE_STRIP(WebGLRenderingContext.TRIANGLE_STRIP),
	/**
	 * Value to identify PrimitiveRenderingMode TRIANGLE_FAN.
	 */
	TRIANGLE_FAN(WebGLRenderingContext.TRIANGLE_FAN),
	/**
	 * Value to identify PrimitiveRenderingMode TRIANGLES.
	 */
	TRIANGLES(WebGLRenderingContext.TRIANGLES), ;

	private final int value;

	PrimitiveRenderingMode(int value) {
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
	public static PrimitiveRenderingMode getByIntValue(int value) {
		return EnumUtil.getByIntValue(values(), value);
	}
}
