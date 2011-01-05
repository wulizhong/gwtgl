/* 
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
package com.googlecode.gwtgl.array;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steffen Schäfer
 *
 */
public class ArrayBuffer extends JavaScriptObject {
	
	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected ArrayBuffer() {
		super();
	}

	/**
	 * Create a new ArrayBuffer of the passed length in bytes. Data in the
	 * buffer is initialized to 0.
	 * 
	 * @param length the byte length of the newly created ArrayBuffer
	 * @return the created ArrayBuffer
	 */
	public static native ArrayBuffer create(int length) /*-{
		return new ArrayBuffer(length);
	}-*/;
	
	/**
	 * Returns the length of the ArrayBuffer in bytes.
	 * 
	 * @return the length of the ArrayBuffer in bytes
	 */
	public final native int getByteLength() /*-{
		return this.byteLength;
	}-*/;

}
