/**   
 * Copyright 2009 Sönke Sothmann & Steffen Schäfer
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
package com.googlecode.gwtgl.binding.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;


/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public class AbstractWebGlContextInitializer {

	/**
	 * Initializes the WebGLCanvas and returns the glContext or null if none was created.
	 * 
	 * @param element
	 * @return
	 */
	public JavaScriptObject getWebGlContext(Element element) {
		return createGlContext(getContextName(), element);
	}

	private native JavaScriptObject createGlContext(String contextName, Element element) /*-{
		try {
			return element.getContext(contextName);
		} catch(e)  {}
		return null;
	}-*/;

	protected String getContextName() {
		return null;
	}

}
