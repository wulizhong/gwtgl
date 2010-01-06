package com.googlecode.gwtgl.binding;

/**
 * Abstract parent class for all WebGLArrays which use int to get/set the inner values.
 * 
 *
 * @param <T>
 */
public abstract class IntBasedWebGLArray<T extends IntBasedWebGLArray<T>> extends WebGLArray<T> {
	
	protected IntBasedWebGLArray() {
		super();
	}
	
	/**
	 * Return the element at the given index. If the index is out of range, an exception is raised. This is an index getter function, and may be invoked via array index syntax where applicable.
	 * 
	 * @param index
	 * @return
	 */
	public final native int get(int index) /*-{
		return this.get(index);
	}-*/;
	
	/**
	 * 
	 * Sets the element at the given index to the given value. If the index is out of range, an exception is raised. This is an index setter function, and may be invoked via array index syntax where applicable.
	 * 
	 * If the given value is out of range for the type of the array, a C-style cast operation is performed to coerce the value to the valid range. No clamping or rounding is performed.
	 * 
	 * @param index
	 * @param value
	 */
	public final native void set(int index, int value) /*-{
		this.set(index, value);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public final native void set(T array, int offset) /*-{
		this.set(array, offset);
	}-*/;
	
	/**
	 * Set multiple values, reading input values from the array. The optional offset value indicates the index in the current array where values are written. If omitted, it is assumed to be 0.
	 * 
	 * If the offset plus the length of the given array is out of range for the current WebGLArray, an exception is raised.
	 * 
	 * @param array
	 * @param offset
	 */
	public final native void set(int[] array, int offset) /*-{
		this.set(array, offset);
	}-*/;
}