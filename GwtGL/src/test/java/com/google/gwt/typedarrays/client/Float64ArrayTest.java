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

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link Float64Array}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Float64ArrayTest extends GWTTestCase {
  private static final int numBytes = 8;

  private static final double[] testData = new double[] {0d, 0.1d, 1d, 2d, 3d, 1337d, -1337d};

  private static final double[] testDataPart1 = new double[] {0d, 0.1d, 1d, 2d, 3d};

  private static final double[] testDataPart2 = new double[] {1337d, -1337d};

  private static native JsArrayNumber testDataJsArray() /*-{
    return [ 0, 0.1, 1, 2, 3, 1337, -1337 ];
  }-*/;

  private static native JsArrayNumber testDataJsArrayPart1() /*-{
    return [ 0, 0.1, 1, 2, 3 ];
  }-*/;

  private static native JsArrayNumber testDataJsArrayPart2() /*-{
    return [ 1337, -1337 ];
  }-*/;

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testInitWithArrayBuffer() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * numBytes);

    Float64Array array = Float64Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 1) * numBytes);

    Float64Array array = Float64Array.create(arrayBuffer, numBytes);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 2) * numBytes);

    Float64Array array = Float64Array.create(arrayBuffer, numBytes, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array arraySrc = Float64Array.create(testData);

    Float64Array array = Float64Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, testDataPart1.length);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), testDataPart1.length);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array arraySrc = Float64Array.create(testData);

    Float64Array array = Float64Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array arraySrc1 = Float64Array.create(testDataPart1);
    Float64Array arraySrc2 = Float64Array.create(testDataPart2);

    Float64Array array = Float64Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, arraySrc1.getLength());
    assertIsTestData(array);
  }

  public void testSetValues() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    Float64Array array = Float64Array.create(2);

    // 2^31-1
    array.set(0, Double.MAX_VALUE);
    // -(2^31)
    array.set(1, Double.MIN_VALUE);

    assertEquals(Double.MAX_VALUE, array.get(0));
    assertEquals(Double.MIN_VALUE, array.get(1));
  }

  private void assertIsTestData(Float64Array array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}
