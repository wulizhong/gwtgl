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
 * Tests for {@link Uint8ClampedArray}.
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Uint8ClampedArrayTest extends GWTTestCase {
  private static final int numBytes = 1;

  private static final int[] testData = new int[] {0, 1, 2, 3, 255};

  private static final int[] testDataPart1 = new int[] {0, 1, 2, 3};

  private static final int[] testDataPart2 = new int[] {255};

  private static native JsArrayInteger testDataJsArray() /*-{
    return [ 0, 1, 2, 3, 255 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart1() /*-{
    return [ 0, 1, 2, 3 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart2() /*-{
    return [ 255 ];
  }-*/;

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testInitWithArrayBuffer() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * numBytes);

    Uint8ClampedArray array = Uint8ClampedArray.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 1) * numBytes);

    Uint8ClampedArray array = Uint8ClampedArray.create(arrayBuffer, numBytes);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 2) * numBytes);

    Uint8ClampedArray array = Uint8ClampedArray.create(arrayBuffer, numBytes, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray arraySrc = Uint8ClampedArray.create(testData);

    Uint8ClampedArray array = Uint8ClampedArray.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray arraySrc = Uint8ClampedArray.create(testData);

    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray arraySrc1 = Uint8ClampedArray.create(testDataPart1);
    Uint8ClampedArray arraySrc2 = Uint8ClampedArray.create(testDataPart2);

    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray array = Uint8ClampedArray.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
    if (!Uint8ClampedArray.isSupported()) {
      // Uint8ClampedArray (or Typed Arrays) aren't supported -> do not run the test
      return;
    }
    Uint8ClampedArray uint8Array = Uint8ClampedArray.create(4);

    // 2^8-1
    uint8Array.set(0, 255);
    // 0 is the min value for unsigned datatypes
    uint8Array.set(1, 0);
    // negative value
    uint8Array.set(2, -1);
    // 2^8
    uint8Array.set(3, 256);

    assertEquals(255, uint8Array.get(0));
    assertEquals(0, uint8Array.get(1));
    // no overflow
    assertEquals(0, uint8Array.get(2));
    assertEquals(255, uint8Array.get(3));
  }

  private void assertIsTestData(Uint8ClampedArray array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}
