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
 * Tests for {@link DataView}.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class DataViewTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
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
}