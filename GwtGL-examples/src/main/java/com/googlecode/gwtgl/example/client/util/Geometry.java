package com.googlecode.gwtgl.example.client.util;

import java.util.List;

/**
 * Base class for geometry
 * @author Sönke Sothmann
 *
 */
public class Geometry {
	/**
	 * Coverts Float-List to float array
	 * @param list List to convert
	 * @return float array
	 */
	protected float[] floatListToFloatArray(List<Float> list) {
		float[] array = new float[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	/**
	 * Converts Integer-List to int array
	 * @param list List to convert
	 * @return int array
	 */
	protected int[] integerListToIntegerArray(List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	/**
	 * Converts Byte-List to byte array
	 * @param list List to convert
	 * @return byte array
	 */
	protected byte[] byteListToByteArray(List<Byte> list) {
		byte[] array = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
}
