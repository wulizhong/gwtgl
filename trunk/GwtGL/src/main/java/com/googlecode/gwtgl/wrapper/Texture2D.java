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
package com.googlecode.gwtgl.wrapper;

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLTexture;
import com.googlecode.gwtgl.wrapper.enums.TextureTarget;

/**
 * A wrapper class for a 2D texture with transparent image loading. The
 * Texture2D can be set active to a texture unit via setActiveAndBind.
 * 
 * @author Steffen Schäfer
 */
public class Texture2D {

	private final WebGLTexture nativeTextureObject;
	private final WebGLRenderingContext glContext;
	private Image imageToSet;
	private boolean destroyed = false;
	private final TextureTarget target = TextureTarget.TEXTURE_2D;
	private HandlerRegistration handlerRegistration;
	private final WebGLWrapper webGLWrapper;
	private int levelOfDetail = 0;

	/**
	 * Creates a Texture2D associated to the given webGLWrapper.
	 * 
	 * @param webGLWrapper
	 */
	public Texture2D(final WebGLWrapper webGLWrapper) {
		this.webGLWrapper = webGLWrapper;
		this.glContext = webGLWrapper.glContext;
		this.nativeTextureObject = glContext.createTexture();
	}
	
	/**
	 * Creates a Texture2D associated to the given webGLWrapper. The imageResource is used to
	 * set the image that is visible on the texture.
	 * 
	 * @param webGLWrapper
	 * @param imageResource
	 */
	public Texture2D(final WebGLWrapper webGLWrapper, final ImageResource imageResource) {
		this(webGLWrapper, imageResource, 0);
	}

	/**
	 * Creates a Texture2D associated to the given webGLWrapper. The imageResource is used to
	 * set the image that is visible on the texture.
	 * 
	 * @param webGLWrapper
	 * @param imageResource
	 * @param levelOfDetail
	 */
	public Texture2D(final WebGLWrapper webGLWrapper, final ImageResource imageResource, final int levelOfDetail) {
		this(webGLWrapper);
		this.levelOfDetail = levelOfDetail;
		setImage(imageResource);
	}

	/**
	 * Sets the image to be used for this texture. The image is loaded and set
	 * when the texture is activated via setActiveAndBind.
	 * 
	 * @param imageResource
	 */
	public void setImage(final ImageResource imageResource) {
		if (destroyed) {
			throw new IllegalStateException(
					"The Texture2D is already destroyed");
		}

		final Image img = new Image();
		handlerRegistration = img.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				imageToSet=img;
				
				RootPanel.get().remove(img);
				
				if (handlerRegistration != null) {
					handlerRegistration.removeHandler();
					handlerRegistration = null;
				}
			}
		});
		img.setVisible(false);
		RootPanel.get().add(img);
		// image.setResource(imageResource);
		// TODO doesn't work with more than one image bundled to one
		// ImageBundle if the browser doesn't support data:... urls
		// So it's no problem at the moment because Chrome and FF support it
		img.setUrl(imageResource.getURL());
		System.out.println(imageResource.getURL());

	}

	/**
	 * Returns weather the texture is destroyed (true) or not (false).
	 * 
	 * @return true if the texture object is destroyed, false otherwise
	 */
	public boolean isDestroyed() {
		return destroyed;
	}

	/**
	 * Delete the underlying Texture object.
	 */
	public void delete() {
		destroyed = true;
		glContext.deleteTexture(nativeTextureObject);
		imageToSet = null;
	}

	/**
	 * Sets the specified textureUnit active and binds the texture to it.
	 * 
	 * @param textureUnit 0, 1, ... MAX
	 */
	public void setActiveAndBind(int textureUnit) {
		glContext.activeTexture(WebGLRenderingContext.TEXTURE0 + textureUnit);
		glContext.bindTexture(target.getIntValue(), nativeTextureObject);
		if (imageToSet != null) {
			glContext.texImage2D(target.getIntValue(), levelOfDetail, imageToSet
					.getElement());
			imageToSet=null;
		}
	}

	/**
	 * Returns the {@link WebGLWrapper} the texture is associated to.
	 * 
	 * @return the {@link WebGLWrapper} the texture is associated to
	 */
	public WebGLWrapper getWebGLWrapper() {
		return webGLWrapper;
	}

	/**
	 * Returns the wrapped native texture object.
	 * 
	 * @return the wrapped native texture object
	 */
	protected WebGLTexture getNativeTextureObject() {
		return nativeTextureObject;
	}

}