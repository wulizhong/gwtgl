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
package com.googlecode.gwtgl.wrapper.util;

import com.googlecode.gwtgl.wrapper.enums.IWebGLConstEnum;

/**
 * @author Steffen Schäfer
 *
 */
public final class EnumUtil {

	private EnumUtil() {
	}
	
	/**
	 * Finds and returnes the valueToFind in the given enum values.
	 * 
	 * @param <T>
	 * @param values
	 * @param valueToFind
	 * @return the enum value with the matching int value or null if no matching
	 *         value was found.
	 */
	public static <T extends IWebGLConstEnum> T getByIntValue(T[] values, int valueToFind) {
		for(T val:values) {
			if(val.getIntValue()==valueToFind) {
				return val;
			}
		}
		return null;
	}

}
