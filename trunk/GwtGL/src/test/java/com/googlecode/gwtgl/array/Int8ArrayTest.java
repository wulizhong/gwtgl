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
 * Tests for {@link Int8Array}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Int8ArrayTest extends GWTTestCase {

  private static final int[] testData = new int[] {0, 1, 2, 3, 127, -128};

  private static final int[] testDataPart1 = new int[] {0, 1, 2, 3};

  private static final int[] testDataPart2 = new int[] {127, -128};

  private static native JsArrayInteger testDataJsArray() /*-{
		return [ 0, 1, 2, 3, 127, -128 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart1() /*-{
		return [ 0, 1, 2, 3 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart2() /*-{
		return [ 127, -128 ];
  }-*/;

  @Override
  public String getModuleName() {
    return "com.googlecode.gwtgl.array";
  }

  public void testInitWithArrayBuffer() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length);

    Int8Array array = Int8Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length + 1);

    Int8Array array = Int8Array.create(arrayBuffer, 1);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length + 2);

    Int8Array array = Int8Array.create(arrayBuffer, 1, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    Int8Array array = Int8Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    Int8Array array = Int8Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    Int8Array arraySrc = Int8Array.create(testData);

    Int8Array array = Int8Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    Int8Array array = Int8Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    Int8Array array = Int8Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    Int8Array array = Int8Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    Int8Array array = Int8Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    Int8Array arraySrc = Int8Array.create(testData);

    Int8Array array = Int8Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    Int8Array arraySrc1 = Int8Array.create(testDataPart1);
    Int8Array arraySrc2 = Int8Array.create(testDataPart2);

    Int8Array array = Int8Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    Int8Array array = Int8Array.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
    Int8Array array = Int8Array.create(4);

    // 2^7-1
    array.set(0, 127);
    // -(2^7)
    array.set(1, -128);
    // -(2^7+1)
    array.set(2, -129);
    // 2^7 -> overflow
    array.set(3, 128);

    assertEquals(127, array.get(0));
    assertEquals(-128, array.get(1));
    assertEquals(127, array.get(2));
    assertEquals(-128, array.get(3));
  }

  private void assertIsTestData(Int8Array array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}