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

import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link TypedArray} and subclasses.
 * 
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class JsArrayUtilTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testSetAndGetLong() {
    long[] array = new long[] {0, 1, 2, 3, 4294967295L, 4294967294L, 4294967293L, 4294967292L};
    JsArrayInteger jsArray = JsArrayInteger.createArray().cast();

    for (int i = 0; i < array.length; i++) {
      JsArrayUtil.setLongToJsArrayInteger(jsArray, i, array[i]);
    }

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], JsArrayUtil.getLongFromJsArrayInteger(jsArray, i));
    }
  }

  public void testUnwrapString() {
    JsArrayString wrappedArray = createTestdataJsArrayString();

    // check that the contents are exactly the expected.
    assertEquals(3, wrappedArray.length());
    assertEquals("Test", wrappedArray.get(0));
    assertEquals("abc", wrappedArray.get(1));
    assertEquals("", wrappedArray.get(2));

    String[] unwrappedArray = JsArrayUtil.unwrapArray(wrappedArray);

    assertEquals(wrappedArray.length(), unwrappedArray.length);
    for (int i = 0; i < wrappedArray.length(); i++) {
      assertEquals(wrappedArray.get(i), unwrappedArray[i]);
    }
  }

  public void testWrapBoolean() {
    boolean[] array = new boolean[] {Boolean.TRUE, Boolean.FALSE};
    JsArrayBoolean wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
    }
  }

  public void testWrapByte() {
    byte[] array = new byte[] {0, 1, 2, 3, Byte.MAX_VALUE, Byte.MIN_VALUE};
    JsArrayInteger wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
    }
  }

  public void testWrapDouble() {
    double[] array = new double[] {
        0.0, 1.0, -1.0, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL,
        Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY};
    JsArrayNumber wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      // no calculations are done, so the values should be really equal
      assertEquals(array[i], wrappedArray.get(i), 0.0);
    }
  }

  public void testWrapFloat() {
    float[] array =
        new float[] {
            0.0f, 1.0f, -1.0f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL,
            Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY};
    JsArrayNumber wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      // no calculations are done, so the values should be really equal
      assertEquals(array[i], (float) wrappedArray.get(i), 0.0f);
    }
  }
  
  public void testWrapShort() {
    short[] array = new short[] {0, 1, 2, 3, Short.MAX_VALUE, Short.MIN_VALUE};
    JsArrayInteger wrappedArray = JsArrayUtil.wrapArray(array);
    
    assertEquals(array.length, wrappedArray.length());
    
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
    }
  }

  public void testWrapInt() {
    int[] array = new int[] {0, 1, 2, 3, Integer.MAX_VALUE, Integer.MIN_VALUE};
    JsArrayInteger wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
    }
  }

  public void testWrapLong() {
    // we are only interested in values that are used by the Uint32Integer
    long[] array = new long[] {0, 1, 2, 3, 4294967295L, 4294967294L, 4294967293L, 4294967292L};
    JsArrayInteger wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    assertTrue(checkLongArrayContents(wrappedArray));
  }

  public void testWrapString() {
    String[] array = new String[] {"Test", "abc", "123", ""};

    JsArrayString wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
    }

    String[] unwrappedArray = JsArrayUtil.unwrapArray(wrappedArray);

    // wrapping/unwrapping must not change the contents and order of the array. unwrappedArray must
    // be equivalent to the original array.
    assertEquals(array.length, unwrappedArray.length);
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], unwrappedArray[i]);
    }
  }

  private native boolean checkLongArrayContents(JsArrayInteger array) /*-{
		var referenceValues = [ 0, 1, 2, 3, 4294967295, 4294967294, 4294967293,
				4294967292 ];

		for ( var i = 0; i < referenceValues.length; i++) {
			if (referenceValues[i] !== array[i]) {
				return false;
			}
		}
		return true;
  }-*/;

  private native JsArrayString createTestdataJsArrayString() /*-{
		return [ "Test", "abc", "" ];
  }-*/;
}