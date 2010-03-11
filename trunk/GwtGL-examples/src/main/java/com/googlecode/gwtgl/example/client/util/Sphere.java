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

package com.googlecode.gwtgl.example.client.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for creation of sphere geometry Inspired by "The WebGL Cookbook"
 * - http://learningwebgl.com/cookbook/index.php/How_to_draw_a_sphere
 * 
 * @author Sönke Sothmann
 * 
 */
public class Sphere extends Geometry {
	private final float[] verticesArray;
	private final float[] texCoordsArray;
	private final float[] vertexNormals;
	private final byte[] indices;

	/**
	 * Create sphere geometry
	 * @param latitudeBands
	 * @param longitudeBands
	 * @param radius
	 */
	public Sphere(int latitudeBands, int longitudeBands, int radius) {
		List<Float> vertexNormalsList = new ArrayList<Float>();
		List<Float> texCoordsList = new ArrayList<Float>();
		List<Float> verticesList = new ArrayList<Float>();

		for (int latNumber = 0; latNumber <= latitudeBands; latNumber++) {
			double theta = latNumber * Math.PI / latitudeBands;
			double sinTheta = Math.sin(theta);
			double cosTheta = Math.cos(theta);

			for (int longNumber = 0; longNumber <= longitudeBands; longNumber++) {
				double phi = longNumber * 2 * Math.PI / longitudeBands;
				double sinPhi = Math.sin(phi);
				double cosPhi = Math.cos(phi);

				double x = cosPhi * sinTheta;
				double y = cosTheta;
				double z = sinPhi * sinTheta;
				double u = 1 - (longNumber / longitudeBands);
				double v = latNumber / latitudeBands;

				vertexNormalsList.add((float) x);
				vertexNormalsList.add((float) y);
				vertexNormalsList.add((float) z);
				texCoordsList.add((float) u);
				texCoordsList.add((float) v);
				verticesList.add((float) (radius * x));
				verticesList.add((float) (radius * y));
				verticesList.add((float) (radius * z));
			}
		}

		List<Byte> indicesList = new ArrayList<Byte>();
		for (int latNumber = 0; latNumber < latitudeBands; latNumber++) {
			for (int longNumber = 0; longNumber < longitudeBands; longNumber++) {
				byte first = (byte) ((latNumber * (longitudeBands + 1)) + longNumber);
				byte second = (byte) (first + longitudeBands + 1);
				indicesList.add(first);
				indicesList.add(second);
				indicesList.add((byte) (first + 1));

				indicesList.add(second);
				indicesList.add((byte) (second + 1));
				indicesList.add((byte) (first + 1));
			}
		}
		
		verticesArray = floatListToFloatArray(verticesList);
		texCoordsArray = floatListToFloatArray(texCoordsList);
		vertexNormals = floatListToFloatArray(vertexNormalsList);
		indices = byteListToByteArray(indicesList);
	}

	/**
	 * Create sphere geometry with latitudeBands=30, longitudeBands=30 and radius=2
	 */
	public Sphere() {
		this(30, 30, 2);
	}
	
	/**
	 * Returns the vertex coordinates for this sphere.
	 * 
	 * @return the vertex coordinates
	 */
	public float[] getVertices() {
		return verticesArray;
	}

	/**
	 * Returns the texture coordinates for this sphere.
	 * 
	 * @return the texture coordinates
	 */
	public float[] getTexCoords() {
		return texCoordsArray;
	}

	/**
	 * Returns the vertex normals for this sphere.
	 * 
	 * @return the vertex normals
	 */
	public float[] getVertexNormals() {
		return vertexNormals;
	}
	
	/**
	 * Returns the indices for this sphere.
	 * 
	 * @return the indices
	 */
	public byte[] getIndices() {
		return indices;
	}
}
