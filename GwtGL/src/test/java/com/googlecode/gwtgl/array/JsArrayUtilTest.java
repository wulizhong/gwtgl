package com.googlecode.gwtgl.array;

import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link TypedArray} and subclasses.
 * 
 */
public class JsArrayUtilTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.googlecode.gwtgl.array";
  }

  public void testWrapInt() {
    int[] array = new int[] {0, 1, 2, 3, Integer.MAX_VALUE, Integer.MIN_VALUE};
    JsArrayInteger wrappedArray = JsArrayUtil.wrapArray(array);

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

  public void testWrapBoolean() {
    boolean[] array = new boolean[] {Boolean.TRUE, Boolean.FALSE};
    JsArrayBoolean wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], wrappedArray.get(i));
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

  public void testWrapDouble() {
    double[] array =
        new double[] {
            0.0, 1.0, -1.0, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL,
            Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY};
    JsArrayNumber wrappedArray = JsArrayUtil.wrapArray(array);

    assertEquals(array.length, wrappedArray.length());

    for (int i = 0; i < array.length; i++) {
      // no calculations are done, so the values should be really equal
      assertEquals(array[i], (float) wrappedArray.get(i), 0.0);
    }
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
    // be equivalent to theoriginal array.
    assertEquals(array.length, unwrappedArray.length);
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], unwrappedArray[i]);
    }
  }

}