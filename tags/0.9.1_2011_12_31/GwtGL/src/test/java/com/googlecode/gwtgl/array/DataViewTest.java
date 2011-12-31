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
 * Tests for {@link DataView}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class DataViewTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.googlecode.gwtgl.array";
  }

  public void testInt8() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }

    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setInt8(0, 127);
    dataView.setInt8(1, 5);
    assertEquals(127, dataView.getInt8(0));
    assertEquals(5, dataView.getInt8(1));
    
    // test that the overflow happens but no neighbor is affected
    dataView.setInt8(0, 0);
    dataView.setInt8(1, 128);
    assertEquals(-128, dataView.getInt8(1));
    assertEquals(0, dataView.getInt8(0));
    assertEquals(0, dataView.getInt8(2));
  }
  
  public void testUint8() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setUint8(0, 255);
    dataView.setUint8(1, 5);
    assertEquals(255, dataView.getUint8(0));
    assertEquals(5, dataView.getUint8(1));
    
    // test that the overflow happens but no neighbor is affected
    dataView.setUint8(0, 0);
    dataView.setUint8(1, 256);
    assertEquals(0, dataView.getUint8(1));
    assertEquals(0, dataView.getInt8(0));
    assertEquals(0, dataView.getInt8(2));
  }
  
  public void testInt16() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setInt16(0, 32767);
    dataView.setInt16(2, 5);
    assertEquals(32767, dataView.getInt16(0));
    assertEquals(5, dataView.getInt16(2));
    
    // test that the overflow happens but no neighbor is affected
    dataView.setInt16(0, 0);
    dataView.setInt16(2, 32768);
    assertEquals(-32768, dataView.getInt16(2));
    assertEquals(0, dataView.getInt16(0));
    assertEquals(0, dataView.getInt16(4));
  }
  
  public void testUint16() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setUint16(0, 65535);
    dataView.setUint16(2, 5);
    assertEquals(65535, dataView.getUint16(0));
    assertEquals(5, dataView.getUint16(2));
    
    // test that the overflow happens but no neighbor is affected
    dataView.setUint16(0, 0);
    dataView.setUint16(2, 65536);
    assertEquals(0, dataView.getUint16(1));
    assertEquals(0, dataView.getUint16(0));
    assertEquals(0, dataView.getUint16(4));
  }
  
  public void testInt32() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setInt32(0, 2147483647);
    dataView.setInt32(4, 5);
    assertEquals(2147483647, dataView.getInt32(0));
    assertEquals(5, dataView.getInt32(4));
  }
  
  public void testUint32() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setUint32(0, 2147483647);
    dataView.setUint32(4, 5);
    assertEquals(2147483647, dataView.getUint32(0));
    assertEquals(5, dataView.getUint32(4));
  }
  
  public void testFloat32() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setFloat32(0, 1.2f);
    dataView.setFloat32(4, 123.45f);
    assertEquals(1.2f, dataView.getFloat32(0), 0.00001f);
    assertEquals(123.45f, dataView.getFloat32(4), 0.00001f);
  }
  
  public void testFloat64() {
    if (!DataView.isSupported()) {
      // Typed Arrays aren't supported -> do not run the test
      return;
    }
    
    ArrayBuffer buffer = ArrayBuffer.create(24);
    DataView dataView = DataView.create(buffer);
    
    dataView.setFloat64(0, 1.2);
    dataView.setFloat64(4, 123.45);
    assertEquals(1.2, dataView.getFloat64(0), 0.00001);
    assertEquals(123.45, dataView.getFloat64(4), 0.00001);
  }
}