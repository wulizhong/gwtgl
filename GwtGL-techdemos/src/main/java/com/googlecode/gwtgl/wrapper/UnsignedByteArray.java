/**   
 * Copyright 2010 Sönke Sothmann, Steffen Schäfer and others
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

import com.google.gwt.typedarrays.client.ArrayBuffer;
import com.google.gwt.typedarrays.client.Uint8Array;
import com.googlecode.gwtgl.wrapper.Array.IntBasedArray;
import com.googlecode.gwtgl.wrapper.enums.DataType;

/**
 * Wrapper for unsigned byte array type.
 * 
 * @author Sönke Sothmann
 *
 */
public class UnsignedByteArray extends IntBasedArray<Uint8Array> {
	
	/**
	 * Create a new Uint8Array object of the given length with a new underlying ArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 */
	public UnsignedByteArray(int length) {
		super(Uint8Array.create(length));
	};
	
	/**
	 * Create a new Uint8Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public UnsignedByteArray(Uint8Array array) {
		super(Uint8Array.create(array));
	};
	
	/**
	 * Create a new Uint8Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public UnsignedByteArray(int[] array) {
		super(Uint8Array.create(array));
	};
	
	/**
	 * Create a new Uint8Array object using the passed ArrayBuffer for its storage.
	 * 
	 * @param buffer
	 */
	public UnsignedByteArray(ArrayBuffer buffer) {
		super(Uint8Array.create(buffer));
	};
	
	/**
	 * Create a new Uint8Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
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
	public UnsignedByteArray(ArrayBuffer buffer, int byteOffset) {
		super(Uint8Array.create(buffer, byteOffset));
	};
	
	/**
	 * Create a new Uint8Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
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
	public UnsignedByteArray(ArrayBuffer buffer, int byteOffset, int length) {
		super(Uint8Array.create(buffer, byteOffset, length));
	};

	@Override
	public DataType getDataType() {
		return DataType.UNSIGNED_BYTE;
	}

}
