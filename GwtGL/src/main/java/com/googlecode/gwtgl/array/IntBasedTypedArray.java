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
 * Abstract parent class for all {@link TypedArray}s which use int to get/set the inner values. Do not rely
 * on this class as it's not part of the spec and only introduced in GwtGL to simplify the
 * implementation of the Int*Arrays.
 * 
 * @param <T> the type of the {@link TypedArray} itself. Used for methods that use parameters that
 *          must have the same type than the TypedArray itself.
 */
public abstract class IntBasedTypedArray<T extends IntBasedTypedArray<T>> extends TypedArray<T> {

  /**
   * protected standard constructor as specified by
   * {@link com.google.gwt.core.client.JavaScriptObject}.
   */
  protected IntBasedTypedArray() {
    super();
  }

  /**
   * Reads the value at the given index. The index is based on the value length of the type used by
   * this {@link TypedArray}. Accessing an index that doesn't exist will cause an exception.
   * 
   * 
   * @param index the index relative to the beginning of the TypedArray.
   * @return the value at the given index
   */
  public final native int get(int index) /*-{
		return this[index];
  }-*/;

  /**
   * Writes the given value at the given index. The index is based on the value length of the type
   * used by this {@link TypedArray}. Accessing an index that doesn't exist will cause an exception.
   * 
   * Values that are out of the range for the type used by this TypedAray are silently casted to be
   * in range.
   * 
   * @param index the index relative to the beginning of the TypedArray.
   * @param value the new value to set
   */
  public final native void set(int index, int value) /*-{
		this[index] = value;
  }-*/;

  /**
   * Writes multiple values to the TypedArray using the values of the given Array.
   * 
   * @param array an array containing the new values to set.
   */
  public final void set(int[] array) {
    set(JsArrayUtil.wrapArray(array));
  };

  /**
   * Writes multiple values to the TypedArray using the values of the given Array. Writes the values
   * beginning at the given offset.
   * 
   * @param array an array containing the new values to set.
   * @param offset the offset relative to the beginning of the TypedArray.
   */
  public final void set(int[] array, int offset) {
    set(JsArrayUtil.wrapArray(array), offset);
  }

  /**
   * Writes multiple values to the TypedArray using the values of the given Array.
   * 
   * @param array an array containing the new values to set.
   */
  public final native void set(JsArrayInteger array) /*-{
		this.set(array);
  }-*/;;

  /**
   * Writes multiple values to the TypedArray using the values of the given Array. Writes the values
   * beginning at the given offset.
   * 
   * @param array an array containing the new values to set.
   * @param offset the offset relative to the beginning of the TypedArray.
   */
  public final native void set(JsArrayInteger array, int offset) /*-{
		this.set(array, offset);
  }-*/;
}