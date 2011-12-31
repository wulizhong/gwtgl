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
import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;

/**
 * Tests for TypedArrays.
 *
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class TypedArraySuite {

  /**
   * @return the TestSuite.
   */
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for TypedArrays GWTTestCases");

    suite.addTestSuite(JsArrayUtilTest.class);
    suite.addTestSuite(TypedArrayTest.class);
    suite.addTestSuite(IntBasedTypedArrayTest.class);
    suite.addTestSuite(Int8ArrayTest.class);
    suite.addTestSuite(Int16ArrayTest.class);
    suite.addTestSuite(Int32ArrayTest.class);
    suite.addTestSuite(Uint16ArrayTest.class);
    suite.addTestSuite(Uint32ArrayTest.class);
    suite.addTestSuite(Float32ArrayTest.class);
    suite.addTestSuite(Float64ArrayTest.class);

    return suite;
  }

  private TypedArraySuite() {
  }

}
