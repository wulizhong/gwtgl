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
package com.googlecode.gwtgl.binding;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steffen Schäfer
 *
 * @param <T>
 */
public abstract class WebGLArray<T extends WebGLArray<T>> extends JavaScriptObject {

	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected WebGLArray() {
		super();
	}
	
	/**
	 * Returns the offset of the WebGLArray in the underlying {@link WebGLArrayBuffer}.
	 * 
	 * @return the offset of the WebGLArray in the WebGLArrayBuffer
	 */
	public final native int getByteOffset() /*-{
		return this.byteOffset;
	}-*/;
	
	/**
	 * Returns the length of the Array in bytes.
	 * 
	 * @return the length of the Array in bytes
	 */
	public final native int getByteLength() /*-{
		return this.byteLength;
	}-*/;
	
	/**
	 * Returns the number of objects contained in the array.
	 * 
	 * @return the length of the array
	 */
	public final native int getLength() /*-{
		return this.length;
	}-*/;

	/**
	 * Returns a new WebGLArray with the same underlying {@link WebGLArrayBuffer}.
	 * 
	 * @param offset
	 * @param length
	 * @return the new WebGLArray
	 */
	protected final native T slice(int offset, int length)/*-{
		return this.slice(offset, length);
	}-*/;

}
