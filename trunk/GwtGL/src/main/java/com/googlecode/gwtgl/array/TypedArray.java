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
package com.googlecode.gwtgl.array;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steffen Schäfer
 *
 * @param <T>
 */
public abstract class TypedArray<T extends TypedArray<T>> extends ArrayBufferView {

	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected TypedArray() {
		super();
	}
	
	/**
	 * Returns the number of objects contained in the array.
	 * 
	 * @return the length of the array
	 */
	public final native int getLength() /*-{
		return this.length;
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 */
	public final native void set(T array)/*-{
		return this.set(array);
	}-*/;

	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 * @param offset
	 */
	public final native void set(T array, int offset)/*-{
		return this.set(array, offset);
	}-*/;

	/**
	 * Returns a new Array with the same underlying {@link ArrayBuffer}.
	 * 
	 * @param offset
	 * @return the new Array
	 */
	public final native T slice(int offset)/*-{
		return this.slice(offset);
	}-*/;
	
	/**
	 * Returns a new Array with the same underlying {@link ArrayBuffer}.
	 * 
	 * @param offset
	 * @param length
	 * @return the new Array
	 */
	public final native T slice(int offset, int length)/*-{
		return this.slice(offset, length);
	}-*/;

}