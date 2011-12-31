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
 * Tests for {@link Int16Array}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Int16ArrayTest extends GWTTestCase {

  private static final int numBytes = 2;

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

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testInitWithArrayBuffer() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * numBytes);

    Int16Array array = Int16Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 1) * numBytes);

    Int16Array array = Int16Array.create(arrayBuffer, numBytes);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 2) * numBytes);

    Int16Array array = Int16Array.create(arrayBuffer, numBytes, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    Int16Array array = Int16Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    Int16Array array = Int16Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    Int16Array arraySrc = Int16Array.create(testData);

    Int16Array array = Int16Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    Int16Array array = Int16Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    Int16Array array = Int16Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    Int16Array array = Int16Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    Int16Array array = Int16Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    Int16Array arraySrc = Int16Array.create(testData);

    Int16Array array = Int16Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    Int16Array arraySrc1 = Int16Array.create(testDataPart1);
    Int16Array arraySrc2 = Int16Array.create(testDataPart2);

    Int16Array array = Int16Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    Int16Array array = Int16Array.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
    Int16Array array = Int16Array.create(4);

    // 2^7-1
    array.set(0, 32767);
    // -(2^7)
    array.set(1, -32768);
    // -(2^7+1)
    array.set(2, -32769);
    // 2^7 -> overflow
    array.set(3, 32768);

    assertEquals(32767, array.get(0));
    assertEquals(-32768, array.get(1));
    assertEquals(32767, array.get(2));
    assertEquals(-32768, array.get(3));
  }

  private void assertIsTestData(Int16Array array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}