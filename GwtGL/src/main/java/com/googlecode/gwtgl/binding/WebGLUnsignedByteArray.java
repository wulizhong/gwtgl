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
public class WebGLUnsignedByteArray extends WebGLArray<WebGLUnsignedByteArray> {
	
	/**
	 * Create a new WebGLUnsignedByteArray object of the given length with a new underlying WebGLArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 */
	public WebGLUnsignedByteArray(int length) {
		super(create(length));
	}
	
	private static native JavaScriptObject create(int length) /*-{
		return new WebGLUnsignedByteArray(length);
	}-*/;
	
	/**
	 * Create a new WebGLUnsignedByteArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public WebGLUnsignedByteArray(WebGLUnsignedByteArray array) {
		super(create(array.getNativeArray()));
	}
	
	private static native JavaScriptObject create(JavaScriptObject array) /*-{
		return new WebGLUnsignedByteArray(array);
	}-*/;
	
	/**
	 * Create a new WebGLUnsignedByteArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public WebGLUnsignedByteArray(float[] array) {
		super(create(array));
	}
	
	private static native JavaScriptObject create(float[] array) /*-{
		return new WebGLUnsignedByteArray(array);
	}-*/;

	/**
	 * Constructor for automatic wrapping. This constructor is not intended to
	 * be called manually.
	 * 
	 * @param nativeArray the native array object to wrap.
	 */
	protected WebGLUnsignedByteArray(JavaScriptObject nativeArray) {
		super(nativeArray);
	}
	
	/**
	 * Create a new WebGLUnsignedByteArray object using the passed WebGLArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the WebGLArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire WebGLArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the WebGLArrayBuffer.
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
	protected WebGLUnsignedByteArray(WebGLArrayBuffer buffer, int byteOffset, int length) {
		super(create(buffer.getNativeBuffer(), byteOffset, length));
	}
	
	private static native JavaScriptObject create(JavaScriptObject buffer, int byteOffset, int length) /*-{
		return new WebGLUnsignedByteArray(buffer, byteOffset, length);
	}-*/;

	@Override
	public WebGLUnsignedByteArray slice(int offset, int length) {
		return new WebGLUnsignedByteArray(innerSlice(offset, length));
	}
	
	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return
	 */
	public native int get(int index) /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLUnsignedByteArray::getNativeArray().get(index);
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
	public native void set(int index, int value) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLUnsignedByteArray::getNativeArray().set(index, value);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public void set(WebGLUnsignedByteArray array, int offset) {
		innerSet(array.getNativeArray(), offset);
	}

	private native void innerSet(JavaScriptObject array, int offset) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLUnsignedByteArray::getNativeArray().set(array, offset);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public native void set(int[] array, int offset) /*-{
		this.@com.googlecode.gwtgl.binding.WebGLUnsignedByteArray::getNativeArray().set(array, offset);
	}-*/;

	@Override
	public int getDataTypeKey() {
		return WebGLCanvas.INT;
	}

}
