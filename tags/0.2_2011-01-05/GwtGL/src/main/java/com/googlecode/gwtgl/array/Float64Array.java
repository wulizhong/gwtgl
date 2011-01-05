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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.googlecode.gwtgl.util.JsArrayUtil;

/**
 * @author Steffen Schäfer
 *
 */
public class Float64Array extends TypedArray<Float64Array> {
	
	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected Float64Array() {
		super();
	}
	
	/**
	 * Create a new Float32Array object of the given length with a new underlying ArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 * @return the created Float32Array
	 */
	public static native Float64Array create(int length) /*-{
		return new Float32Array(length);
	}-*/;
	
	/**
	 * Create a new Float32Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 * @return the created Float32Array
	 */
	public static native Float64Array create(Float64Array array) /*-{
		return new Float32Array(array);
	}-*/;
	
	/**
	 * Create a new Float32Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 * @return the created Float32Array
	 */
	public static Float64Array create(double[] array) {
		if(GWT.isScript()) {
			return innerCreate(array);
		}
		return innerCreate(JsArrayUtil.wrapArray(array));
	};
	
	private static native Float64Array innerCreate(double[] array) /*-{
		return new Float32Array(array);
	}-*/;
	
	private static native Float64Array innerCreate(JsArrayNumber array) /*-{
		return new Float32Array(array);
	}-*/;
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage.
	 * 
	 * @param buffer
	 * @return the created Float32Array
	 */
	public static native Float64Array create(ArrayBuffer buffer) /*-{
		return new Float32Array(buffer);
	}-*/;
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the TypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the TypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.Create a new TypeNameArray object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the TypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the TypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @return the created Float32Array
	 */
	public static native Float64Array create(ArrayBuffer buffer, int byteOffset) /*-{
		return new Float32Array(buffer, byteOffset);
	}-*/;
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the TypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the TypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.Create a new TypeNameArray object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the TypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the TypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @param length
	 * @return the created Float32Array
	 */
	public static native Float64Array create(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new Float32Array(buffer, byteOffset, length);
	}-*/;
	
	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return the element at the given index
	 */
	public final native float get(int index) /*-{
		return this.get(index);
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
	public final native void set(int index, double value) /*-{
		this.set(index, value);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 */
	public final void set(double[] array) {
		if(GWT.isScript()) {
			innerSet(array);
		}
		innerSet(JsArrayUtil.wrapArray(array));
	};
	
	private static native void innerSet(double[] array) /*-{
		this.set(array);
	}-*/;
	
	private static native void innerSet(JsArrayNumber array) /*-{
		this.set(array);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current Array, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public final void set(double[] array, int offset) {
		if(GWT.isScript()) {
			innerSet(array, offset);
		}
		innerSet(JsArrayUtil.wrapArray(array), offset);
	};
	
	private static native void innerSet(double[] array, int offset) /*-{
		this.set(array);
	}-*/;
	
	private static native void innerSet(JsArrayNumber array, int offset) /*-{
		this.set(array);
	}-*/;

}
