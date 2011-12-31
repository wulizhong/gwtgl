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

import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link IntBasedTypedArray}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class IntBasedTypedArrayTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.googlecode.gwtgl.array";
  }

  public void testByte() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    byte[] array = new byte[] {0, 1, 2, Byte.MAX_VALUE, Byte.MIN_VALUE};
    Int8Array typedArray = Int8Array.create(array.length);

    typedArray.set(array);

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getByte(i));
    }

    typedArray = Int8Array.create(array.length);

    for (int i = 0; i < array.length; i++) {
      typedArray.set(i, array[i]);
    }

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getByte(i));
    }
  }
  
  public void testShort() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    short[] array = new short[] {0, 1, 2, Short.MAX_VALUE, Short.MIN_VALUE};
    Int16Array typedArray = Int16Array.create(array.length);
    
    typedArray.set(array);
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getShort(i));
    }
    
    typedArray = Int16Array.create(array.length);
    
    for (int i = 0; i < array.length; i++) {
      typedArray.set(i, array[i]);
    }
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getShort(i));
    }
  }
  
  public void testInt() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    int[] array = new int[] {0, 1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE};
    Int32Array typedArray = Int32Array.create(array.length);
    
    typedArray.set(array);
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.get(i));
    }
    
    typedArray = Int32Array.create(array.length);
    
    for (int i = 0; i < array.length; i++) {
      typedArray.set(i, array[i]);
    }
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.get(i));
    }
  }
  
  public void testLong() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    long[] array = new long[] {0, 1, 2, 4294967295L};
    Uint32Array typedArray = Uint32Array.create(array.length);
    
    typedArray.set(array);
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getLong(i));
    }
    
    typedArray = Uint32Array.create(array.length);
    
    for (int i = 0; i < array.length; i++) {
      typedArray.set(i, array[i]);
    }
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], typedArray.getLong(i));
    }
  }
}