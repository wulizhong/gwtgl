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
package com.googlecode.gwtgl.binding;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steffen Schäfer
 *
 */
public class WebGLFloatArray extends WebGLArray<WebGLFloatArray> {
	
	/**
	 * Create a new WebGLTypeNameArray object of the given length with a new underlying WebGLArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 */
	public WebGLFloatArray(int length) {
		super(create(length));
	}
	
	private static native JavaScriptObject create(int length) /*-{
		return new WebGLFloatArray(length);
	}-*/;
	
	/**
	 * Create a new WebGLTypeNameArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public WebGLFloatArray(WebGLFloatArray array) {
		super(create(array.getNativeArray()));
	}
	
	private static native JavaScriptObject create(JavaScriptObject array) /*-{
		return new WebGLFloatArray(array);
	}-*/;
	
	/**
	 * Create a new WebGLTypeNameArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public WebGLFloatArray(float[] array) {
		super(create(array));
	}
	
	private static native JavaScriptObject create(float[] array) /*-{
		return new WebGLFloatArray(array);
	}-*/;
	
	private WebGLFloatArray(JavaScriptObject nativeArray) {
		super(nativeArray);
	}
	
	/**
	 * Create a new WebGLTypeNameArray object using the passed WebGLArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the WebGLArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire WebGLArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the WebGLArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the WebGLArrayBuffer an exception is raised.Create a new WebGLTypeNameArray object using the passed WebGLArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the WebGLArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire WebGLArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the WebGLArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the WebGLArrayBuffer an exception is raised.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @param length
	 */
	protected WebGLFloatArray(WebGLArrayBuffer buffer, int byteOffset, int length) {
		super(create(buffer.getNativeBuffer(), byteOffset, length));
	}
	
	private static native JavaScriptObject create(JavaScriptObject buffer, int byteOffset, int length) /*-{
		return new WebGLFloatArray(buffer, byteOffset, length);
	}-*/;

	@Override
	public WebGLFloatArray slice(int offset, int length) {
		return new WebGLFloatArray(innerSlice(offset, length));
	}
	
	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return
	 */
	public native float get(int index) /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLFloatArray::getNativeArray().get(index);
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
	public native void set(int index, float value) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLFloatArray::getNativeArray().set(index, value);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public void set(WebGLFloatArray array, int offset) {
		innerSet(array.getNativeArray(), offset);
	}

	private native void innerSet(JavaScriptObject array, int offset) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLFloatArray::getNativeArray().set(array, offset);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public native void set(float[] array, int offset) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLFloatArray::getNativeArray().set(array, offset);
	}-*/;

}
