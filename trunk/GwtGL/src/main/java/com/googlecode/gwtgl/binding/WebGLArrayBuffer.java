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
public class WebGLArrayBuffer {

	private final JavaScriptObject nativeBuffer;

	/**
	 * Create a new WebGLArrayBuffer of the passed length in bytes. Data in the
	 * buffer is initialized to 0.
	 * 
	 * @param length
	 * @return
	 */
	public WebGLArrayBuffer(int length) {
		this(create(length));
	}

	private static native JavaScriptObject create(int length) /*-{
		return new WebGLFloatArray(length);
	}-*/;

	private WebGLArrayBuffer(JavaScriptObject nativeBuffer) {
		this.nativeBuffer = nativeBuffer;
	}

	public JavaScriptObject getNativeBuffer() {
		return nativeBuffer;
	}
	
	public native int getByteLength() /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLArrayBuffer::nativeBuffer.byteLength;
	}-*/;

}
