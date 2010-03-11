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

import com.googlecode.gwtgl.binding.WebGLArrayBuffer;
import com.googlecode.gwtgl.binding.WebGLUnsignedByteArray;
import com.googlecode.gwtgl.wrapper.Array.IntBasedArray;
import com.googlecode.gwtgl.wrapper.enums.DataType;

/**
 * Wrapper for unsigned byte array type.
 * 
 * @author Sönke Sothmann
 *
 */
public class UnsignedByteArray extends IntBasedArray<WebGLUnsignedByteArray> {
	
	/**
	 * Create a new WebGLUnsignedByteArray object of the given length with a new underlying WebGLArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 */
	public UnsignedByteArray(int length) {
		super(WebGLUnsignedByteArray.create(length));
	};
	
	/**
	 * Create a new WebGLUnsignedByteArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public UnsignedByteArray(WebGLUnsignedByteArray array) {
		super(WebGLUnsignedByteArray.create(array));
	};
	
	/**
	 * Create a new WebGLUnsignedByteArray object with a new underlying WebGLArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 */
	public UnsignedByteArray(byte[] array) {
		super(WebGLUnsignedByteArray.create(array));
	};
	
	/**
	 * Create a new WebGLUnsignedByteArray object using the passed WebGLArrayBuffer for its storage.
	 * 
	 * @param buffer
	 */
	public UnsignedByteArray(WebGLArrayBuffer buffer) {
		super(WebGLUnsignedByteArray.create(buffer));
	};
	
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
	 */
	public UnsignedByteArray(WebGLArrayBuffer buffer, int byteOffset) {
		super(WebGLUnsignedByteArray.create(buffer, byteOffset));
	};
	
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
	public UnsignedByteArray(WebGLArrayBuffer buffer, int byteOffset, int length) {
		super(WebGLUnsignedByteArray.create(buffer, byteOffset, length));
	};

	@Override
	public DataType getDataType() {
		return DataType.UNSIGNED_BYTE;
	}

}
