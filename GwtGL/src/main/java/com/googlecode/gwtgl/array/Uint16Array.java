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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.googlecode.gwtgl.gen.util.JsArrayUtil;


/**
 * @author Steffen Schäfer
 *
 */
public class Uint16Array extends IntBasedTypedArray<Uint16Array> {

	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected Uint16Array() {
		super();
	}
	
	/**
	 * Create a new Uint16Array object of the given length with a new underlying ArrayBuffer large enough to hold length elements of the specific type. Data in the buffer is initialized to 0.
	 * 
	 * @param length
	 * @return the created Uint16Array
	 */
	public static native Uint16Array create(int length) /*-{
		return new Uint16Array(length);
	}-*/;
	
	/**
	 * Create a new Uint16Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 * @return the created Uint16Array
	 */
	public static native Uint16Array create(Uint16Array array) /*-{
		return new Uint16Array(array);
	}-*/;
	
	/**
	 * Create a new Uint16Array object with a new underlying ArrayBuffer large enough to hold the given data, then copy the passed data into the buffer.
	 * 
	 * @param array
	 * @return the created Uint16Array
	 */
	public static Uint16Array create(int[] array) {
		if(GWT.isScript()) {
			return innerCreate(array);
		}
		return innerCreate(JsArrayUtil.wrapArray(array));
	};
	
	private static native Uint16Array innerCreate(int[] array) /*-{
		return new Uint16Array(array);
	}-*/;
	
	private static native Uint16Array innerCreate(JsArrayInteger array) /*-{
		return new Uint16Array(array);
	}-*/;
	
	/**
	 * Create a new Uint16Array object using the passed ArrayBuffer for its storage.
	 * 
	 * @param buffer
	 * @return the created Uint16Array
	 */
	public static native Uint16Array create(ArrayBuffer buffer) /*-{
		return new Uint16Array(buffer);
	}-*/;
	
	/**
	 * Create a new Uint16Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
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
	 * @return the created Uint16Array
	 */
	public static native Uint16Array create(ArrayBuffer buffer, int byteOffset) /*-{
		return new Uint16Array(buffer, byteOffset);
	}-*/;
	
	/**
	 * Create a new Uint16Array object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this WebGLByteArray will reference. If both byteOffset and length are omitted, the WebGLTypeNameArray spans the entire ArrayBuffer range. If the length is omitted, the WebGLTypeNameArray extends from the given byteOffset until the end of the ArrayBuffer.
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
	 * @return the created Uint16Array
	 */
	public static native Uint16Array create(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new Uint16Array(buffer, byteOffset, length);
	}-*/;

}
