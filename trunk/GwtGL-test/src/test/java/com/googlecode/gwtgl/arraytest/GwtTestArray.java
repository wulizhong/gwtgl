package com.googlecode.gwtgl.arraytest;

import com.google.gwt.junit.client.GWTTestCase;
import com.googlecode.gwtgl.array.ArrayBuffer;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.array.Int16Array;
import com.googlecode.gwtgl.array.Int32Array;
import com.googlecode.gwtgl.array.Int8Array;
import com.googlecode.gwtgl.array.Uint16Array;

public class GwtTestArray extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.googlecode.gwtgl.arraytest";
	}
	
	public void testIntArrayFromJavaArray() {
		Int32Array array = Int32Array.create(new int[]{0,1,2,3,4,5});
		assertEquals(0, array.get(0));
		assertEquals(1, array.get(1));
		assertEquals(2, array.get(2));
		assertEquals(3, array.get(3));
		assertEquals(4, array.get(4));
		assertEquals(5, array.get(5));
	}
	
	public void testIntArraySetJavaArray() {
		Int32Array array = Int32Array.create(3);
		
		// set 2 values at offset 0
		array.set(new int[] {1337, 1338});

		assertEquals(1337, array.get(0));
		assertEquals(1338, array.get(1));
		
		// set 2 values at offset 1
		array.set(new int[] {1, 2}, 1);
		assertEquals(1337, array.get(0));
		assertEquals(1, array.get(1));
		assertEquals(2, array.get(2));
	}
	
	public void testIntArraySetIntArray() {
		Int32Array array = Int32Array.create(2);
		Int32Array array2 = Int32Array.create(new int []{1337, 1338});
		
		array.set(array2);
		assertEquals(1337, array.get(0));
		assertEquals(1338, array.get(1));
	}
	
	public void testInt32ValueRange() {
		Int32Array int32Array = Int32Array.create(2);
		
		// 2^31-1
		int32Array.set(0, 2147483647);
		// -(2^31)
		int32Array.set(1, -2147483648);
		
		assertEquals(2147483647, int32Array.get(0));
		assertEquals(-2147483648, int32Array.get(1));
	}
	
	public void testInt8ValueRange() {
		Int8Array int8Array = Int8Array.create(3);
		
		// 2^7-1
		int8Array.set(0, 127);
		// -(2^7)
		int8Array.set(1, -128);
		// 2^7 -> overflow
		int8Array.set(2, 128);
		
		assertEquals(127, int8Array.get(0));
		assertEquals(-128, int8Array.get(1));
		assertEquals(-128, int8Array.get(2));
	}
	
	public void testUint16ValueRange() {
		Uint16Array uint16Array = Uint16Array.create(3);
		
		// 2^16-1
		uint16Array.set(0, 65535);
		// negative value
		uint16Array.set(1, -1);
		// 2^16 -> overflow
		uint16Array.set(2, 65536);
		
		assertEquals(65535, uint16Array.get(0));
		assertEquals(65535, uint16Array.get(1));
		assertEquals(0, uint16Array.get(2));
	}
	
	public void testTwoArrays() {
		ArrayBuffer arrayBuffer = ArrayBuffer.create(2);
		Int8Array array1 = Int8Array.create(arrayBuffer);
		Int8Array array2 = Int8Array.create(arrayBuffer);
		
		array1.set(0, 13);
		array1.set(1, 37);

		assertEquals(13, array2.get(0));
		assertEquals(37, array2.get(1));
	}
	
	public void testDifferentOffset() {
		ArrayBuffer arrayBuffer = ArrayBuffer.create(8);
		Int32Array array1 = Int32Array.create(arrayBuffer);
		Int32Array array2 = Int32Array.create(arrayBuffer, 4);
		
		array1.set(0, 1337);
		array1.set(1, 1338);
		
		assertEquals(1338, array2.get(0));
	}
	
	public void testMixedValues() {
		ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
		Int8Array int8Array = Int8Array.create(arrayBuffer, 0, 2);
		Int16Array int16Array = Int16Array.create(arrayBuffer, 2, 1);
		
		int8Array.set(0, 55);
		int8Array.set(1, 77);
		int16Array.set(0, 555);
		
		assertEquals(55, int8Array.get(0));
		assertEquals(77, int8Array.get(1));
		assertEquals(555, int16Array.get(0));
	}
	
	public void testIntValueConversion() {
		ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
		Int8Array int8Array = Int8Array.create(arrayBuffer);
		Int32Array int32Array = Int32Array.create(arrayBuffer);
		
		// TODO think about that
		// is it dependent on the number representation (big endian, little endian)?
		// from my point of view, it must be int8Array.set(3, 7); to set the 4th byte of the 32 bit int
		
		// 0000 0111
		int8Array.set(0, 7);
		assertEquals(7, int32Array.get(0));
		
		// 1000 0000
		int8Array.set(0, -128);
		assertEquals(128, int32Array.get(0));
		
		// 1 0000 0000
		int8Array.set(0, 0);
		int8Array.set(1, 1);
		assertEquals(256, int32Array.get(0));
	}
	
	public void testFloatArrayFromJavaArray() {
		Float32Array array = Float32Array.create(new float[]{0.1f, 1337.0f});
		
		assertEquals(0.1f, array.get(0));
		assertEquals(1337.0f, array.get(1));
	}
	
	public void testIntToFloatConversion() {
		ArrayBuffer arrayBuffer = ArrayBuffer.create(4);
		Int32Array int32Array = Int32Array.create(arrayBuffer);
		Float32Array float32Array = Float32Array.create(arrayBuffer);
		
		int32Array.set(0, 456675678);
		
		assertEquals(1.5246414E-22f, float32Array.get(0));
	}

}