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
package com.googlecode.gwtgl.example.client;

import com.googlecode.gwtgl.wrapper.WebGLWrapper;

/**
 * Abstract parent class for the GwtGL Wrapper examples.
 * 
 * @author Steffen Schäfer
 * 
 */
public abstract class AbstractGwtGLWrapperExample extends AbstractGwtGLExample {

	/**
	 * The {@link WebGLWrapper} to use for rendering.
	 */
	protected final WebGLWrapper webGLWrapper;

	/**
	 * Constructs an instance of the GwtGL wrapper example.
	 */
	public AbstractGwtGLWrapperExample() {
		webGLWrapper = new WebGLWrapper(webGLCanvas.getGlContext());
	}

}
