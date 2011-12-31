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
 * Tests for {@link ArrayBufferView}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class ArrayBufferViewTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testGetBuffer() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(1);
    Int8Array array = Int8Array.create(arrayBuffer);

    ArrayBuffer arrayBufferFromView = array.getBuffer();

    assertNotNull(arrayBufferFromView);
    assertEquals(arrayBuffer, arrayBufferFromView);
  }
  
  public void testByteLength() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(8);
    
    Int8Array int8Array = Int8Array.create(arrayBuffer);
    assertEquals(8, int8Array.getByteLength());
    
    Int16Array int16Array = Int16Array.create(arrayBuffer);
    assertEquals(8, int16Array.getByteLength());
  }
  
  public void testByteLengthWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(8);
    
    Int8Array int8Array = Int8Array.create(arrayBuffer, 1);
    assertEquals(7, int8Array.getByteLength());
    
    Int16Array int16Array = Int16Array.create(arrayBuffer, 2);
    assertEquals(6, int16Array.getByteLength());
  }
  
  public void testLengthWithOffsetAndLength() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(8);
    
    Int8Array int8Array = Int8Array.create(arrayBuffer, 1, 2);
    assertEquals(2, int8Array.getByteLength());
    
    Int16Array int16Array = Int16Array.create(arrayBuffer, 2, 2);
    assertEquals(4, int16Array.getByteLength());
  }
  
  public void testOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(8);
    
    Int8Array int8Array = Int8Array.create(arrayBuffer, 1);
    assertEquals(1, int8Array.getByteOffset());
    
    int8Array = Int8Array.create(arrayBuffer, 1, 2);
    assertEquals(1, int8Array.getByteOffset());
    
    Int16Array int16Array = Int16Array.create(arrayBuffer, 2);
    assertEquals(2, int16Array.getByteOffset());
    
    int16Array = Int16Array.create(arrayBuffer, 2, 2);
    assertEquals(2, int16Array.getByteOffset());
  }
}