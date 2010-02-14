/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.example.client.util.math;

/**
 * Represents a vector with three elements.
 * 
 * @author Sönke Sothmann
 * @author Steffen Schäfer
 * 
 */
public class Vector3f {
	private float x;
	private float y;
	private float z;

	/**
	 * Constructs a new instance of the Vector3f with the given coordinates to
	 * set.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector3f(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns the x coordinate.
	 * 
	 * @return the x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x coordinate.
	 * 
	 * @param x
	 *            the x coordinate to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Returns the z coordinate.
	 * 
	 * @return the z coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y coordinate.
	 * 
	 * @param y
	 *            the y coordinate to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Returns the y coordinate.
	 * 
	 * @return the y coordinate
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the z coordinate.
	 * 
	 * @param z
	 *            the z coordinate to set
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * Creates a new Vector3f that is this vector multiplied with the given
	 * scalar.
	 * 
	 * @param scalar
	 * @return the multiplied Vector3f
	 */
	public Vector3f multiply(float scalar) {
		return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
	}

	/**
	 * Returns the length of the vector.
	 * 
	 * @return the length of the vector
	 */
	public float length() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z
				* this.z);
	}

	/**
	 * Creates a new Vector3f that is the unit vector of this vector.
	 * 
	 * @return the unit vector
	 */
	public Vector3f toUnitVector() {
		float length = length();
		return new Vector3f(this.x / length, this.y / length, this.z / length);
	}

	/**
	 * Returns the data of this vector as array.
	 * 
	 * @return the data as array
	 */
	public float[] toArray() {
		return new float[] { this.x, this.y, this.z };
	}
}
