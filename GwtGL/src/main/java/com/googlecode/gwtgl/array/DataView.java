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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Steffen Schäfer
 *
 */
public class DataView extends ArrayBufferView {

	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected DataView() {
		super();
	}
	
	/**
	 * Create a new DataView object using the passed ArrayBuffer for its storage.
	 * 
	 * @param buffer
	 * @return the created DataView
	 */
	public static native DataView create(ArrayBuffer buffer) /*-{
		return new DataView(buffer);
	}-*/;
	
	/**
	 * Create a new DataView object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the DataView spans the entire ArrayBuffer range. If the length is omitted, the DataView extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @return the created DataView
	 */
	public static native DataView create(ArrayBuffer buffer, int byteOffset) /*-{
		return new DataView(buffer, byteOffset);
	}-*/;
	
	/**
	 * Create a new DataView object using the passed ArrayBuffer for its storage. Optional byteOffset and length can be used to limit the section of the buffer referenced. The byteOffset indicates the offset in bytes from the start of the ArrayBuffer, and the length is the count of elements from the offset that this ByteArray will reference. If both byteOffset and length are omitted, the DataView spans the entire ArrayBuffer range. If the length is omitted, the DataView extends from the given byteOffset until the end of the ArrayBuffer.
	 * 
	 * @param buffer
	 * @param byteOffset
	 * @param length
	 * @return the created DataView
	 */
	public static native DataView create(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new DataView(buffer, byteOffset, length);
	}-*/;
	
	public native int getInt8(int byteOffset) /*-{
		return this.getInt8(byteOffset);
	}-*/;
	
	public native int getUint8(int byteOffset) /*-{
		return this.getUint8(byteOffset);
	}-*/;
	
	public native int getInt16(int byteOffset) /*-{
		return this.getInt16(byteOffset);
	}-*/;
	
	public native int getInt16(int byteOffset, boolean littleEndian) /*-{
		return this.getInt16(byteOffset, littleEndian);
	}-*/;
	
	public native int getUint16(int byteOffset) /*-{
		return this.getUint16(byteOffset);
	}-*/;
	
	public native int getUint16(int byteOffset, boolean littleEndian) /*-{
		return this.getUint16(byteOffset, littleEndian);
	}-*/;
	
	public native int getInt32(int byteOffset) /*-{
		return this.getInt32(byteOffset);
	}-*/;
	
	public native int getInt32(int byteOffset, boolean littleEndian) /*-{
		return this.getInt32(byteOffset, littleEndian);
	}-*/;
	
	public native int getUint32(int byteOffset) /*-{
		return this.getUint32(byteOffset);
	}-*/;
	
	public native int getUint32(int byteOffset, boolean littleEndian) /*-{
		return this.getUint32(byteOffset, littleEndian);
	}-*/;
	
	public native float getFloat32(int byteOffset) /*-{
		return this.getFloat32(byteOffset);
	}-*/;
	
	public native float getFloat32(int byteOffset, boolean littleEndian) /*-{
		return this.getFloat32(byteOffset, littleEndian);
	}-*/;
	
	public native double getFloat64(int byteOffset) /*-{
		return this.getFloat64(byteOffset);
	}-*/;
	
	public native double getFloat64(int byteOffset, boolean littleEndian) /*-{
		return this.getFloat64(byteOffset, littleEndian);
	}-*/;
	
	public native void setInt8(int byteOffset, int value) /*-{
		this.setInt8(byteOffset, value);
	}-*/;
	
	public native void setUint8(int byteOffset, int value) /*-{
		this.setUint8(byteOffset, value);
	}-*/;
	
	public native void setInt16(int byteOffset, int value) /*-{
		this.setInt16(byteOffset, value);
	}-*/;
	
	public native void setInt16(int byteOffset, int value, boolean littleEndian) /*-{
		this.setInt16(byteOffset, value, littleEndian);
	}-*/;
	
	public native void setUint16(int byteOffset, int value) /*-{
		this.setUint16(byteOffset, value);
	}-*/;
	
	public native void setUint16(int byteOffset, int value, boolean littleEndian) /*-{
		this.setUint16(byteOffset, value, littleEndian);
	}-*/;
	
	public native void setInt32(int byteOffset, int value) /*-{
		this.setInt32(byteOffset, value);
	}-*/;
	
	public native void setInt32(int byteOffset, int value, boolean littleEndian) /*-{
		this.setInt32(byteOffset, value, littleEndian);
	}-*/;
	
	public native void setUint32(int byteOffset, int value) /*-{
		this.setUint32(byteOffset, value);
	}-*/;
	
	public native void setUint32(int byteOffset, int value, boolean littleEndian) /*-{
		this.setUint32(byteOffset, value, littleEndian);
	}-*/;
	
	public native void setFloat32(int byteOffset, float value) /*-{
		this.setFloat32(byteOffset, value);
	}-*/;
	
	public native void setFloat32(int byteOffset, float value, boolean littleEndian) /*-{
		this.setFloat32(byteOffset, value, littleEndian);
	}-*/;
	
	public native void setFloat64(int byteOffset, double value) /*-{
		this.setFloat64(byteOffset, value);
	}-*/;
	
	public native void setFloat64(int byteOffset, double value, boolean littleEndian) /*-{
		this.setFloat64(byteOffset, value, littleEndian);
	}-*/;

}
