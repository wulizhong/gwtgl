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
import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link Int32Array}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Int32ArrayTest extends GWTTestCase {

  private static final int numBytes = 4;

  private static final int[] testData = new int[] {0, 1, 2, 3, 32767, -32768};

  private static final int[] testDataPart1 = new int[] {0, 1, 2, 3};

  private static final int[] testDataPart2 = new int[] {32767, -32768};

  private static native JsArrayInteger testDataJsArray() /*-{
		return [ 0, 1, 2, 3, 32767, -32768 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart1() /*-{
		return [ 0, 1, 2, 3 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart2() /*-{
		return [ 32767, -32768 ];
  }-*/;

  private static native JsArrayInteger testDataValueRange() /*-{
		return [ 2147483647, -2147483648, -2147483649, 2147483648 ];
  }-*/;

  @Override
  public String getModuleName() {
    return "com.googlecode.gwtgl.array";
  }

  public void testInitWithArrayBuffer() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * numBytes);

    Int32Array array = Int32Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 1) * numBytes);

    Int32Array array = Int32Array.create(arrayBuffer, numBytes);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 2) * numBytes);

    Int32Array array = Int32Array.create(arrayBuffer, numBytes, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    Int32Array array = Int32Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    Int32Array array = Int32Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    Int32Array arraySrc = Int32Array.create(testData);

    Int32Array array = Int32Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    Int32Array array = Int32Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    Int32Array array = Int32Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    Int32Array arraySrc = Int32Array.create(testData);

    Int32Array array = Int32Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    Int32Array arraySrc1 = Int32Array.create(testDataPart1);
    Int32Array arraySrc2 = Int32Array.create(testDataPart2);

    Int32Array array = Int32Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    Int32Array array = Int32Array.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
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