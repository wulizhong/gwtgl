/*
 * Copyright 2009-2011 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtgl.array;

import com.google.gwt.core.client.JsArrayInteger;

/**
 * {@link TypedArray} that contains 8 Bit unsigned integer values. The difference to
 * {@link Uint8Array} is when setting values: The Uint8ClampedArray uses clamping. Values that are
 * >255 will be set to 255 and values <0 will be set to 0 instead of calculating the effective value
 * based on a modulo operation.
 * 
 */
public class Uint8ClampedArray extends IntBasedTypedArray<Uint8ClampedArray> {

  /**
   * Creates a new instance of the {@link TypedArray} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @return the created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(ArrayBuffer buffer) /*-{
		return new Uint8ClampedArray(buffer);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link TypedArray} is created using the byteOffset to specify the starting point (in bytes)
   * of the {@link TypedArray} relative to the beginning of the underlying {@link ArrayBuffer}. The
   * byte offset must match (multiple) the value length of this {@link TypedArray}.
   * 
   * if the byteLength is not valid for the given {@link ArrayBuffer}, an exception is thrown
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @return the newly created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(ArrayBuffer buffer, int byteOffset) /*-{
		return new Uint8ClampedArray(buffer, byteOffset);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link TypedArray} is created using the byteOffset and length to specify the start and end
   * (in bytes) of the {@link TypedArray} relative to the beginning of the underlying
   * {@link ArrayBuffer}. The byte offset must match (multiple) the value length of this
   * {@link TypedArray}. The length is in values of the type of the {@link TypedArray}
   * 
   * if the byteLength or length is not valid for the given {@link ArrayBuffer}, an exception is
   * thrown
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @param length the length of the {@link TypedArray} in vales.
   * @return the newly created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new Uint8ClampedArray(buffer, byteOffset, length);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} of the given length in values. All values are
   * set to 0.
   * 
   * @param length the length in values of the type used by this {@link TypedArray}
   * @return the created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(int length) /*-{
		return new Uint8ClampedArray(length);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} of the length of the given array in values.
   * The values are set to the values of the given array.
   * 
   * @param array the array to get the values from
   * @return the created {@link TypedArray}.
   */
  public static Uint8ClampedArray create(int[] array) {
    return create(JsArrayUtil.wrapArray(array));
  }

  /**
   * Creates a new instance of the {@link TypedArray} of the length of the given array in values.
   * The values are set to the values of the given array.
   * 
   * @param array the array to get the values from
   * @return the created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(JsArrayInteger array) /*-{
		return new Uint8ClampedArray(array);
  }-*/;;

  /**
   * Creates a new instance of the {@link TypedArray} of the same length as the given
   * {@link TypedArray}. The values are set to the values of the given {@link TypedArray}.
   * 
   * @param array the {@link TypedArray} to get the values from
   * @return the created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(Uint8Array array) /*-{
		return new Uint8ClampedArray(array);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} of the same length as the given
   * {@link TypedArray}. The values are set to the values of the given {@link TypedArray}.
   * 
   * @param array the {@link TypedArray} to get the values from
   * @return the created {@link TypedArray}.
   */
  public static native Uint8ClampedArray create(Uint8ClampedArray array) /*-{
		return new Uint8ClampedArray(array);
  }-*/;

  /**
   * Checks if the Browser supports the {@link Uint8ClampedArray}. There's a special check, as not
   * all browsers that do support {@link TypedArray} support {@link Uint8ClampedArray} too. Thats
   * because {@link Uint8ClampedArray} is a late addition to the specification.
   * 
   * @return true, if Uint8ClampedArray is supported, false otherwise.
   */
  public static boolean isSupported() {
    // use the compile time check of TypedArray. If TypedArray isn't supported, Uint8ClampedArray
    // isn't supported either.
    if (!TypedArray.isSupported()) {
      return false;
    }
    return isSupportedRuntime();
  };

  /**
   * Checks at runtime if the Browser supports the {@link Uint8ClampedArray}. There's a special
   * check, as not all browsers that do support {@link TypedArray} support {@link Uint8ClampedArray}
   * too. Thats because {@link Uint8ClampedArray} is a late addition to the specification.
   * 
   * @return true, if Uint8ClampedArray is supported, false otherwise.
   */
  private static native boolean isSupportedRuntime() /*-{
                                                     return !!window.Uint8ClampedArray;
                                                     }-*/;

  /**
   * protected standard constructor as specified by
   * {@link com.google.gwt.core.client.JavaScriptObject}.
   */
  protected Uint8ClampedArray() {
    super();
  }

  /**
   * Set multiple values, of the given array to this array.
   * 
   * @param array the array to get the values from
   */
  public final native void set(Uint8Array array)/*-{
                                                this.set(array);
                                                }-*/;

  /**
   * Set multiple values, of the given array to this array starting at the given offset.
   * 
   * @param array the array to get the values from
   * @param offset the offset to start setting the values
   */
  public final native void set(Uint8Array array, int offset)/*-{
                                                            this.set(array, offset);
                                                            }-*/;

}
