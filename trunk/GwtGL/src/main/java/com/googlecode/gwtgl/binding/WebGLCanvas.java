/**   
 * Copyright 2009-2010 Sönke Sothmann & Steffen Schäfer
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
package com.googlecode.gwtgl.binding;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;
import com.googlecode.gwtgl.binding.impl.WebGLMethods;


/**
 * Canvas widget to support WebGL rendering. To render on the widget using WebGL,
 * you can request the WebGLRendering context by calling getGlContext(). 
 * 
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 *
 */
public class WebGLCanvas extends FocusWidget {
	
	private final WebGLMethods glContext = GWT.create(WebGLMethods.class);
	
	/**
	 * Constructs a WebGLCanvas with width=200px and height=200px.
	 */
	public WebGLCanvas() {
		this(null);
	}
	
	/**
	 * Constructs a WebGLCanvas with width=200px and height=200px using the given contextAttributes.
	 * @param contextAttributes the {@link WebGLContextAttributes} used to construct the {@link WebGLRenderingContext}
	 */
	public WebGLCanvas(WebGLContextAttributes contextAttributes) {
		this(contextAttributes, "200px", "200px");
	}
	
	/**
	 * Constructs a WebGLCanvas with the given width and height.
	 * 
	 * @param width the width of the {@link WebGLCanvas}
	 * @param height the height of the {@link WebGLCanvas}
	 */
	public WebGLCanvas(String width, String height) {
		this(null, width, height);
	}

	/**
	 * Constructs a WebGLCanvas with the given width, height and the contextAttributes.
	 * 
	 * @param contextAttributes the {@link WebGLContextAttributes} used to construct the {@link WebGLRenderingContext}
	 * @param width the width of the {@link WebGLCanvas}
	 * @param height the height of the {@link WebGLCanvas}
	 */
	public WebGLCanvas(WebGLContextAttributes contextAttributes, String width, String height) {
		if (width == null || height == null) {
			throw new IllegalArgumentException();
		}
		setElement(DOM.createElement("canvas"));
		
		// TODO create a JavaScriptObject of the glContext?
		JavaScriptObject nativeGlContext;
		if(contextAttributes==null) {
			nativeGlContext = createGlContext(getElement());
		} else {
			nativeGlContext = createGlContext(getElement(), contextAttributes);
		}
		if(nativeGlContext == null) {
			throw new RuntimeException("Sorry, your browser doesn't support WebGL");
		}
		glContext.init(nativeGlContext);
		setWidth(width);
		setHeight(height);
	}
	
	private native JavaScriptObject createGlContext(Element element ,WebGLContextAttributes contextAttributes) /*-{
		try {
			return element.getContext("experimental-webgl", contextAttributes);
		} catch(e)  {}
		return null;
	}-*/;
	
	private native JavaScriptObject createGlContext(Element element) /*-{
		try {
			return element.getContext("experimental-webgl");
		} catch(e)  {}
		return null;
	}-*/;

	@Override
	public void setWidth(String width) {
		DOM.setElementAttribute(getElement(), "width", width);
	}

	@Override
	public void setHeight(String height) {
		DOM.setElementAttribute(getElement(), "height", height);
	}

	/**
	 * Returns the WebGLRenderingContext of this {@link WebGLCanvas}.
	 * 
	 * @return the WebGLRenderingContext
	 */
	public WebGLRenderingContext getGlContext() {
		return glContext;
	}
	
}
