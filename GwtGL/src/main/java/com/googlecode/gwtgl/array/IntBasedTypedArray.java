/* 
 * Copyright 2009-2011 Sönke Sothmann, Steffen Schäfer and others
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.googlecode.gwtgl.util.JsArrayUtil;

/**
 * Abstract parent class for all TypedArrays which use int to get/set the inner values.
 * Do not rely on this class as it's not part of the spec and only
 * introduced in GwtGL to simplify the implementation of the Int*Arrays.
 *
 * @param <T>
 */
public abstract class IntBasedTypedArray<T extends IntBasedTypedArray<T>> extends TypedArray<T> {
	
	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected IntBasedTypedArray() {
		super();
	}
	
	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return the element at the given index
	 */
	public final native int get(int index) /*-{
		return this[index];
	}-*/;
	
	/**
	 * 
	 * Sets the element at the given index to the given value. If the index is out of range, an exception is raised. This is an index setter function, and may be invoked via array index syntax where applicable.
	 * 
	 * If the given value is out of range for the type of the array, a C-style cast operation is performed to coerce the value to the valid range. No clamping or rounding is performed.
	 * 
	 * @param index
	 * @param value
	 */
	public final native void set(int index, int value) /*-{
		this[index] = value;
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 */
	public final void set(int[] array) {
		if(GWT.isScript()) {
			innerSet(array);
		}
		innerSet(JsArrayUtil.wrapArray(array));
	};
	
	private static native void innerSet(int[] array) /*-{
		this.set(array);
	}-*/;
	
	private static native void innerSet(JsArrayInteger array) /*-{
		this.set(array);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public final void set(int[] array, int offset) {
		if(GWT.isScript()) {
			innerSet(array, offset);
		}
		innerSet(JsArrayUtil.wrapArray(array), offset);
	};
	
	private static native void innerSet(int[] array, int offset) /*-{
		this.set(array, offset);
	}-*/;
	
	private static native void innerSet(JsArrayInteger array, int offset) /*-{
		this.set(array, offset);
	}-*/;
}