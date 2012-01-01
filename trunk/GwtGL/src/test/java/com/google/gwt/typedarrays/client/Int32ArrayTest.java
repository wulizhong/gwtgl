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

import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link Int32Array}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Int32ArrayTest extends GWTTestCase {
  private static final int[] testData = new int[] {0, 1, 2, 3, 2147483647, -2147483648};

  private static final int[] testDataPart1 = new int[] {0, 1, 2, 3};

  private static final int[] testDataPart2 = new int[] {2147483647, -2147483648};

  private static native JsArrayInteger testDataJsArray() /*-{
		return [ 0, 1, 2, 3, 2147483647, -2147483648 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart1() /*-{
		return [ 0, 1, 2, 3 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart2() /*-{
		return [ 2147483647, -2147483648 ];
  }-*/;

  private static native JsArrayInteger testDataValueRange() /*-{
		return [ 2147483647, -2147483648, -2147483649, 2147483648 ];
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

    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * Int32Array.BYTES_PER_ELEMENT);

    Int32Array array = Int32Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    ArrayBuffer arrayBuffer =
        ArrayBuffer.create((testData.length + 1) * Int32Array.BYTES_PER_ELEMENT);

    Int32Array array = Int32Array.create(arrayBuffer, Int32Array.BYTES_PER_ELEMENT);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    ArrayBuffer arrayBuffer =
        ArrayBuffer.create((testData.length + 2) * Int32Array.BYTES_PER_ELEMENT);

    Int32Array array =
        Int32Array.create(arrayBuffer, Int32Array.BYTES_PER_ELEMENT, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array arraySrc = Int32Array.create(testData);

    Int32Array array = Int32Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array arraySrc = Int32Array.create(testData);

    Int32Array array = Int32Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array arraySrc1 = Int32Array.create(testDataPart1);
    Int32Array arraySrc2 = Int32Array.create(testDataPart2);

    Int32Array array = Int32Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testData.length);

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

    Int32Array int32Array = Int32Array.create(2);

    // 2^31-1
    int32Array.set(0, 2147483647);
    // -(2^31)
    int32Array.set(1, -2147483648);

    assertEquals(2147483647, int32Array.get(0));
    assertEquals(-2147483648, int32Array.get(1));
  }

  @DoNotRunWith(Platform.Devel)
  public void testValueRangeProdOnly() {
    if (!TypedArray.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    Int32Array array = Int32Array.create(testDataValueRange());

    assertEquals(2147483647, array.get(0));
    assertEquals(-2147483648, array.get(1));
    assertEquals(2147483647, array.get(2));
    assertEquals(-2147483648, array.get(3));
  }

  private void assertIsTestData(Int32Array array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}