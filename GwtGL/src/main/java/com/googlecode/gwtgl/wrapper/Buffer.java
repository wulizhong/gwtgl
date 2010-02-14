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
package com.googlecode.gwtgl.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.wrapper.enums.BufferTarget;
import com.googlecode.gwtgl.wrapper.enums.BufferUsage;
import com.googlecode.gwtgl.wrapper.enums.DataType;

/**
 * Wrapper class for the {@link WebGLBuffer} with automatic management of
 * multiple arrays in one buffer.
 * 
 * @author Steffen Schäfer
 * 
 */
/**
 * @author Sönke Sothmann
 * @author Steffen Schäfer
 *
 */
public class Buffer {
	
	/**
	 * A BufferFragment represents one set of datas inside a buffer object.
	 */
	@SuppressWarnings("unused")
	private class BufferFragment {
		private Array<?, ?> dataToSet;
		private int offset;
		private int byteLength;
		private int maxLength;
		private int numElements;
		private DataType dataType;
		
		/**
		 * @return the offset
		 */
		public int getOffset() {
			return offset;
		}
		
		/**
		 * @return the byteLength
		 */
		public int getByteLength() {
			return byteLength;
		}
		
		/**
		 * @return the maxLength
		 */
		public int getMaxLength() {
			return maxLength;
		}
		
		/**
		 * @return the numElements
		 */
		public int getNumElements() {
			return numElements;
		}

		/**
		 * @return the dataType
		 */
		public DataType getDataType() {
			return dataType;
		}

		private void setData(Array<?, ?> dataToSet) {
			setData(dataToSet, false);
		}
		
		private void setData(Array<?, ?> dataToSet, boolean initial) {
			if (fixed && maxLength < dataToSet.getByteLength()) {
				throw new IllegalStateException(
						"The fragement's size is too small for the data to set!");
			}
			unsetData = true;

			this.dataToSet = dataToSet;
			if(initial) {
				maxLength = byteLength;
				if (fragments.isEmpty()) {
					offset = 0;
				} else {
					// get the last fragment to calculate the offset of the new one
					BufferFragment lastFragment = fragments.get(fragments.size() - 1);
					offset = lastFragment.offset + lastFragment.byteLength;
				}
			}
			byteLength = dataToSet.getByteLength();
			dataType=dataToSet.getDataType();
			numElements=dataToSet.getLength();
			if(maxLength < dataToSet.getByteLength()) {
				maxLength=dataToSet.getByteLength();
				recalcOffsets();
			}
		}
	}

	private List<BufferFragment> fragments = new ArrayList<BufferFragment>();
	private Map<String, BufferFragment> namedFragments = new HashMap<String, BufferFragment>();

	private boolean fixed = false;
	private boolean unsetData = false;

	private final WebGLBuffer nativeBufferObject;
	private final WebGLRenderingContext glContext;
	private final WebGLWrapper webGLWrapper;
	private final BufferTarget target;
	private final BufferUsage usage;

	/**
	 * Creates a Buffer associated to the given webGLWrapper. The Buffer has a
	 * BufferTarget and BufferUsage which is used to set the data.
	 * 
	 * @param webGLWrapper
	 * @param target
	 * @param usage
	 */
	public Buffer(WebGLWrapper webGLWrapper, BufferTarget target, BufferUsage usage) {
		this.webGLWrapper = webGLWrapper;
		this.glContext = webGLWrapper.glContext;
		this.nativeBufferObject = glContext.createBuffer();
		this.target = target;
		this.usage = usage;
	}

	/**
	 * Adds a new managed array to the Buffer.
	 * 
	 * @param name
	 * @param dataToSet
	 */
	public void addData(String name, Array<?, ?> dataToSet) {
		if (fixed) {
			throw new IllegalStateException(
					"The buffer is already fixed and no new data can be added.");
		}
		unsetData = true;
		
		BufferFragment fragment1 = new BufferFragment();
		
		fragment1.setData(dataToSet, true);
		BufferFragment fragment = fragment1;
		fragments.add(fragment);
		namedFragments.put(name, fragment);
	}

	/**
	 * Sets new values for the named data array.
	 * 
	 * @param name
	 * @param dataToSet
	 */
	public void setData(String name,Array<?, ?> dataToSet) {
		BufferFragment fragment = namedFragments.get(name);
		if (fragment == null) {
			throw new IllegalStateException("Fragment with name " + name
					+ " not found!");
		}
		fragment.setData(dataToSet);
	}

	private void recalcOffsets() {
		int offset = 0;
		for (BufferFragment fragment : fragments) {
			fragment.offset = offset;
			offset += fragment.maxLength;
		}
	}

	/**
	 * Is buffer bound?
	 * @return true if buffer is bound, false otherwise
	 */
	// TODO check if this works and make the method public
	private boolean isBound() {
		WebGLBuffer buffer = glContext.getParameter(target.getBinding());
		if (buffer == nativeBufferObject || nativeBufferObject.equals(buffer)) {
			return true;
		}
		return false;
	}

	/**
	 * Binds the Buffer to the associated BufferTarget.
	 */
	public void bind() {
		glContext.bindBuffer(target.getIntValue(), nativeBufferObject);
		// initialize the buffer and set the data if necessary
		setData();
	}

	private void setData() {
		if (!fixed) {
			// buffer is not initialized
			// claculate the needed size for all fragments to set and initialize
			// the buffer
			glContext.bufferData(target.getIntValue(), getLenght(), usage
					.getIntValue());
			fixed = true;
		}
		if (unsetData) {
			// some data is not set yet
			for (BufferFragment fragment : fragments) {
				if(fragment.dataToSet != null) {
					glContext.bufferSubData(target.getIntValue(), fragment.offset,
							fragment.dataToSet.getNativeArray());
					fragment.dataToSet = null;
				}
			}
			unsetData = false;
		}
	}

	private int getLenght() {
		int length = 0;
		for (BufferFragment fragment : fragments) {
			length += fragment.byteLength;
		}
		return length;
	}
	
	/**
	 * Returns the byte offset of the given array.
	 * 
	 * @param name
	 * @return the byte offset of the given array
	 */
	public int getOffset(String name) {
		BufferFragment fragment = namedFragments.get(name);
		if (fragment == null) {
			throw new IllegalStateException("Fragment with name " + name
					+ " not found!");
		}
		return fragment.offset;
	}
	
	/**
	 * Returns the byte length of the given array.
	 * 
	 * @param name
	 * @return the byte length of the given array
	 */
	public int getByteLength(String name) {
		BufferFragment fragment = namedFragments.get(name);
		if (fragment == null) {
			throw new IllegalStateException("Fragment with name " + name
					+ " not found!");
		}
		return fragment.byteLength;
	}

	/**
	 * Delete the underlying Buffer object.
	 */
	public void delete() {
		glContext.deleteBuffer(nativeBufferObject);
	}

	/**
	 * Returns the {@link WebGLWrapper} the Buffer is associated to.
	 * 
	 * @return the {@link WebGLWrapper} the Buffer is associated to
	 */
	public WebGLWrapper getWebGLWrapper() {
		return webGLWrapper;
	}

}
