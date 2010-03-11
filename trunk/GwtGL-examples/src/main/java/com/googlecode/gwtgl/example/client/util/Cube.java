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
import java.util.Arrays;
import java.util.List;

import com.googlecode.gwtgl.example.client.util.math.Vector2f;
import com.googlecode.gwtgl.example.client.util.math.Vector3f;

/**
 * Helper class for creation of cube geometry
 * 
 * @author Sönke Sothmann
 * 
 */
public class Cube extends Geometry {
	private final float[] verticesArray;
	private final float[] texCoordsArray;
	private final float[] vertexNormals;

	private float scale;
	private float halfscale;

	/**
	 * Constructs a new cube with the given scale.
	 * 
	 * @param scale
	 */
	public Cube(float scale) {
		this.scale = scale;
		this.halfscale = this.scale / 2;

		// create the values
		this.verticesArray = createVerticesArray();
		this.texCoordsArray = createTexCoordsArray();
		this.vertexNormals = createVertexNormalsArray();
	}

	private List<Vector3f> createPlaneVertices(Vector3f topleft,
			Vector3f topright, Vector3f bottomright, Vector3f bottomleft) {
		List<Vector3f> plane = new ArrayList<Vector3f>(6);
		plane.addAll(Arrays.asList(topleft, topright, bottomleft, bottomleft,
				topright, bottomright));
		return plane;
	}

	private List<Vector2f> createPlaneTexCoords() {
		List<Vector2f> texCoords = new ArrayList<Vector2f>(6);
		texCoords.addAll(Arrays.asList(
				vec(0, 0), 
				vec(1, 0), 
				vec(0, 1), 
				vec(0, 1), 
				vec(1, 0), 
				vec(1, 1)));
		return texCoords;
	}

	private float[] createVerticesArray() {
		List<Vector3f> front = createPlaneVertices(
				// topleft
				vec(-halfscale, halfscale, halfscale),
				// topright
				vec(halfscale, halfscale, halfscale),
				// bottomright
				vec(halfscale, -halfscale, halfscale),
				// bottomleft
				vec(-halfscale, -halfscale, halfscale));
		List<Vector3f> back = createPlaneVertices(
				// topleft
				vec(halfscale, halfscale, -halfscale),
				// topright
				vec(-halfscale, halfscale, -halfscale),
				// bottomright
				vec(-halfscale, -halfscale, -halfscale),
				// bottomleft
				vec(halfscale, -halfscale, -halfscale));
		List<Vector3f> left = createPlaneVertices(
				// topleft
				vec(-halfscale, halfscale, -halfscale),
				// topright
				vec(-halfscale, halfscale, halfscale),
				// bottomright
				vec(-halfscale, -halfscale, halfscale),
				// bottomleft
				vec(-halfscale, -halfscale, -halfscale));
		List<Vector3f> right = createPlaneVertices(
				// topleft
				vec(halfscale, halfscale, halfscale),
				// topright
				vec(halfscale, halfscale, -halfscale),
				// bottomright
				vec(halfscale, -halfscale, -halfscale),
				// bottomleft
				vec(halfscale, -halfscale, halfscale));
		List<Vector3f> top = createPlaneVertices(
				// topleft
				vec(-halfscale, halfscale, halfscale),
				// topright
				vec(-halfscale, halfscale, -halfscale),
				// bottomright
				vec(halfscale, halfscale, -halfscale),
				// bottomleft
				vec(halfscale, halfscale, halfscale));
		List<Vector3f> bottom = createPlaneVertices(
				// topleft
				vec(halfscale, -halfscale, halfscale),
				// topright
				vec(halfscale, -halfscale, -halfscale),
				// bottomright
				vec(-halfscale, -halfscale, -halfscale),
				// bottomleft
				vec(-halfscale, -halfscale, halfscale));

		List<Float> vertices = new ArrayList<Float>(108);
		vertices.addAll(flattenVector3fList(front));
		vertices.addAll(flattenVector3fList(back));
		vertices.addAll(flattenVector3fList(left));
		vertices.addAll(flattenVector3fList(right));
		vertices.addAll(flattenVector3fList(top));
		vertices.addAll(flattenVector3fList(bottom));
		return floatListToFloatArray(vertices);
	}

	private float[] createTexCoordsArray() {
		List<Vector2f> side = createPlaneTexCoords();

		List<Float> texCoords = new ArrayList<Float>(72);
		texCoords.addAll(flattenVector2fList(side));
		texCoords.addAll(flattenVector2fList(side));
		texCoords.addAll(flattenVector2fList(side));
		texCoords.addAll(flattenVector2fList(side));
		texCoords.addAll(flattenVector2fList(side));
		texCoords.addAll(flattenVector2fList(side));
		return floatListToFloatArray(texCoords);
	}

	private float[] createVertexNormalsArray() {
		// throw new UnsupportedOperationException("not implemented yet");
		List<Vector3f> normals = new ArrayList<Vector3f>(24);
		Vector3f front = vec(0, 0, 1);
		Vector3f back = vec(0, 0, -1);
		Vector3f left = vec(-1, 0, 0);
		Vector3f right = vec(1, 0, 0);
		Vector3f top = vec(0, 1, 0);
		Vector3f bottom = vec(0, -1, 0);
		normals.add(front);
		normals.add(front);
		normals.add(front);
		normals.add(front);
		normals.add(front);
		normals.add(front);
		normals.add(back);
		normals.add(back);
		normals.add(back);
		normals.add(back);
		normals.add(back);
		normals.add(back);
		normals.add(left);
		normals.add(left);
		normals.add(left);
		normals.add(left);
		normals.add(left);
		normals.add(left);
		normals.add(right);
		normals.add(right);
		normals.add(right);
		normals.add(right);
		normals.add(right);
		normals.add(right);
		normals.add(top);
		normals.add(top);
		normals.add(top);
		normals.add(top);
		normals.add(top);
		normals.add(top);
		normals.add(bottom);
		normals.add(bottom);
		normals.add(bottom);
		normals.add(bottom);
		normals.add(bottom);
		normals.add(bottom);

		List<Float> vertexNormals = flattenVector3fList(normals);
		return floatListToFloatArray(vertexNormals);
	}

	/**
	 * Returns the vertex coordinates for this cube.
	 * 
	 * @return the vertex coordinates
	 */
	public float[] getVertices() {
		return verticesArray;
	}

	/**
	 * Returns the texture coordinates for this cube.
	 * 
	 * @return the texture coordinates
	 */
	public float[] getTexCoords() {
		return texCoordsArray;
	}

	/**
	 * Returns the vertex normals for this cube.
	 * 
	 * @return the vertex normals
	 */
	public float[] getVertexNormals() {
		return vertexNormals;
	}

	private Vector3f vec(float x, float y, float z) {
		return new Vector3f(x, y, z);
	}

	private Vector2f vec(float u, float v) {
		return new Vector2f(u, v);
	}

	private List<Float> flattenVector3fList(List<Vector3f> inList) {
		List<Float> outList = new ArrayList<Float>(inList.size() * 3);
		for (Vector3f v : inList) {
			outList.addAll(Arrays.asList(v.getX(), v.getY(), v.getZ()));
		}
		return outList;
	}

	private List<Float> flattenVector2fList(List<Vector2f> inList) {
		List<Float> outList = new ArrayList<Float>(inList.size() * 2);
		for (Vector2f v : inList) {
			outList.addAll(Arrays.asList(v.getU(), v.getV()));
		}
		return outList;
	}
}
