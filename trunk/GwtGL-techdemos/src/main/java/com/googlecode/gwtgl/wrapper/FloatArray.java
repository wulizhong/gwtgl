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
package com.googlecode.gwtgl.wrapper;

import java.util.Iterator;

import com.googlecode.gwtgl.array.ArrayBuffer;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.wrapper.enums.DataType;

/**
 * Wrapper for float array
 * @author Steffen Schäfer
 *
 */
public class FloatArray extends Array<Float32Array, Float> {

	/**
	 * Create a new Float32Array object of the given length with a new underlying ArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 */
	public FloatArray(int length) {
		super(Float32Array.create(length));
	};
	
	/**
	 * Create a new Float32Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public FloatArray(Float32Array array) {
		super(Float32Array.create(array));
	};
	
	/**
	 * Create a new Float32Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public FloatArray(float[] array) {
		super(Float32Array.create(array));
	};
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage.
	 * 
	 * @param buffer
	 */
	public FloatArray(ArrayBuffer buffer) {
		super(Float32Array.create(buffer));
	};
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.Create a new WebGLTypeNameArray object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.
	 * 
	 * @param buffer
	 * @param byteOffset
	 */
	public FloatArray(ArrayBuffer buffer, int byteOffset) {
		super(Float32Array.create(buffer, byteOffset));
	};
	
	/**
	 * Create a new Float32Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.Create a new WebGLTypeNameArray object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * The given byteOffset must be a multiple of the element size of the specific type, otherwise an exception is raised.
	 * 
	 * If a given byteOffset and length references an area beyond the end of the ArrayBuffer an exception is raised.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @param length
	 */
	public FloatArray(ArrayBuffer buffer, int byteOffset, int length) {
		super(Float32Array.create(buffer, byteOffset, length));
	};

	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return the element at the given index
	 */
	public float get(int index) {
		return getNativeArray().get(index);
	};
	
	/**
	 * 
	 * Sets the element at the given index to the given value. If the index is out of range, an exception is raised. This is an index setter function, and may be invoked via array index syntax where applicable.
	 * 
	 * If the given value is out of range for the type of the array, a C-style cast operation is performed to coerce the value to the valid range. No clamping or rounding is performed.
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, float value) {
		getNativeArray().set(index, value);
	};
	
	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 */
	public void set(Float32Array array) {
		getNativeArray().set(array);
	};
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public void set(Float32Array array, int offset) {
		getNativeArray().set(array, offset);
	};
	
	/**
	 * Set multiple values, reading input values from the array.
	 * 
	 * @param array
	 */
	public void set(float[] array) {
		getNativeArray().set(array);
	};
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public void set(float[] array, int offset) {
		getNativeArray().set(array, offset);
	};

	@Override
	public DataType getDataType() {
		return DataType.FLOAT;
	}

	@Override
	public Iterator<Float> iterator() {
		return new Iterator<Float>() {
			private int idx = 0;

			@Override
			public boolean hasNext() {
				return getLength() > idx;
			}

			@Override
			public Float next() {
				return get(idx++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
