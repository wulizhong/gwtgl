package com.googlecode.gwtgl.example.client.util.mesh;

/**
 * Class that holds a mesh's data using indices
 * @author Sönke Sothmann
 */
public class IndexedMesh extends Mesh {
	
	/**
	 * Indices of this IndexedMesh
	 */
	protected byte[] indices;
	
	/**
	 * Returns the indices for this IndexedMesh.
	 * 
	 * @return the indices
	 */
	public byte[] getIndices() {
		return indices;
	}
	
}
