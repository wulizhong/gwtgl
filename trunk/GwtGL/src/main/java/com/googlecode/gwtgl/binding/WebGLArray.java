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
 * @param <T>
 */
public abstract class WebGLArray<T extends WebGLArray<T>> {
	// Info: Subclasses of this class must be directly instantiable. So
	// extending JavaScriptObject is not an option :(
	private final JavaScriptObject nativeArray;

	protected WebGLArray(JavaScriptObject nativeArray) {
		this.nativeArray = nativeArray;
	}

	public JavaScriptObject getNativeArray() {
		return nativeArray;
	}
	
	public native int getByteOffset() /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLArray::nativeArray.byteOffset;
	}-*/;
	
	public native int getByteLength() /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLArray::nativeArray.byteLength;
	}-*/;
	
	public native int getLength() /*-{
		return this.@com.googlecode.gwtgl.binding.WebGLArray::nativeArray.length;
	}-*/;
	
	public abstract T slice(int offset, int length);
	
	protected native JavaScriptObject innerSlice(int offset, int length)/*-{
		return this.@com.googlecode.gwtgl.binding.WebGLArray::nativeArray.slice(offset, length);
	}-*/;

}
