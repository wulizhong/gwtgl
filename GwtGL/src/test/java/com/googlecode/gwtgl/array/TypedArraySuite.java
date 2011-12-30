package com.googlecode.gwtgl.array;

import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;

/**
 * Tests for TypedArrays.
 *
 */
public class TypedArraySuite {

  /**
   * @return the TestSuite.
   */
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for TypedArrays GWTTestCases");

    suite.addTestSuite(TypedArrayTest.class);
    suite.addTestSuite(JsArrayUtilTest.class);

    return suite;
  }

  private TypedArraySuite() {
  }

}
