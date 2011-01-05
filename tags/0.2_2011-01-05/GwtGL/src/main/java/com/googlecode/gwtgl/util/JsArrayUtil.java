package com.googlecode.gwtgl.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

/**
 * @author Steffen Schäfer
 *
 */
public final class JsArrayUtil {

	private JsArrayUtil() {
	}

	/**
	 * Wraps a Java String Array to a JsArrayString for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayString wrapArray(String[] srcArray) {
		JsArrayString result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}
	
	/**
	 * Wraps a Java float Array to a JsArrayNumber for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayNumber wrapArray(float[] srcArray) {
		JsArrayNumber result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}
	
	/**
	 * Wraps a Java double Array to a JsArrayNumber for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayNumber wrapArray(double[] srcArray) {
		JsArrayNumber result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}
	
	/**
	 * Wraps a Java int Array to a JsArrayInteger for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayInteger wrapArray(int[] srcArray) {
		JsArrayInteger result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}
	
	/**
	 * Wraps a Java byte Array to a JsArrayInteger for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayInteger wrapArray(byte[] srcArray) {
		JsArrayInteger result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}
	
	/**
	 * Wraps a Java boolean Array to a JsArrayBoolean for dev mode.
	 * 
	 * @param srcArray the array to wrap
	 * @return the wrapped array
	 */
	public static JsArrayBoolean wrapArray(boolean[] srcArray) {
		JsArrayBoolean result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

}
