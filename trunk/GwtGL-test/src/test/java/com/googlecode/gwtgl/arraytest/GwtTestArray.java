package com.googlecode.gwtgl.arraytest;

import com.google.gwt.junit.client.GWTTestCase;
import com.googlecode.gwtgl.array.Int32Array;

public class GwtTestArray extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.googlecode.gwtgl.arraytest";
	}
	
	public void testIntArray() {
		Int32Array array = Int32Array.create(new int[]{0,1,2,3,4,5});
		assertEquals(0, array.get(0));
		assertEquals(1, array.get(1));
		assertEquals(2, array.get(2));
		assertEquals(3, array.get(3));
		assertEquals(4, array.get(4));
		assertEquals(5, array.get(5));
	}

}