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
package com.google.gwt.typedarrays.client;

import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link TypedArray} and subclasses.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class TypedArrayTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testIntToFloatConversion() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
    Int32Array int32Array = Int32Array.create(arrayBuffer);
    Float32Array float32Array = Float32Array.create(arrayBuffer);

    int32Array.set(0, 456675678);

    assertEquals(1.5246414E-22f, float32Array.get(0));
  }

  public void testIntValueConversion() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
    Int8Array int8Array = Int8Array.create(arrayBuffer);
    Int32Array int32Array = Int32Array.create(arrayBuffer);

    // TODO think about that
    // is it dependent on the number representation (big endian, little endian)?
    // from my point of view, it must be int8Array.set(3, 7); to set the 4th byte of the 32 bit int

    // 0000 0111
    int8Array.set(0, 7);
    assertEquals(7, int32Array.get(0));

    // 1000 0000
    int8Array.set(0, -128);
    assertEquals(128, int32Array.get(0));

    // 1 0000 0000
    int8Array.set(0, 0);
    int8Array.set(1, 1);
    assertEquals(256, int32Array.get(0));
  }

  public void testMixedValues() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
    Int8Array int8Array = Int8Array.create(arrayBuffer, 0, 2);
    Int16Array int16Array = Int16Array.create(arrayBuffer, 2, 1);

    int8Array.set(0, 55);
    int8Array.set(1, 77);
    int16Array.set(0, 555);

    assertEquals(55, int8Array.get(0));
    assertEquals(77, int8Array.get(1));
    assertEquals(555, int16Array.get(0));
  }

  public void testTwoArrays() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(2);
    Int8Array array1 = Int8Array.create(arrayBuffer);
    Int8Array array2 = Int8Array.create(arrayBuffer);

    array1.set(0, 13);
    array1.set(1, 37);

    assertEquals(13, array2.get(0));
    assertEquals(37, array2.get(1));
  }

}