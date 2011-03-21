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
package com.googlecode.gwtgl.example.client.examples.lighting.wrapper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;
import com.googlecode.gwtgl.example.client.AbstractGwtGLWrapperExample;
import com.googlecode.gwtgl.example.client.util.MatrixWidget;
import com.googlecode.gwtgl.example.client.util.math.FloatMatrix4x4;
import com.googlecode.gwtgl.example.client.util.math.MatrixUtil;
import com.googlecode.gwtgl.example.client.util.math.Vectorf;
import com.googlecode.gwtgl.example.client.util.math.Vector3f;
import com.googlecode.gwtgl.example.client.util.mesh.CubeFactory;
import com.googlecode.gwtgl.example.client.util.mesh.Mesh;
import com.googlecode.gwtgl.wrapper.Buffer;
import com.googlecode.gwtgl.wrapper.FloatArray;
import com.googlecode.gwtgl.wrapper.Shader;
import com.googlecode.gwtgl.wrapper.ShaderProgram;
import com.googlecode.gwtgl.wrapper.Texture2D;
import com.googlecode.gwtgl.wrapper.enums.BufferTarget;
import com.googlecode.gwtgl.wrapper.enums.BufferUsage;
import com.googlecode.gwtgl.wrapper.enums.ClearFlag;
import com.googlecode.gwtgl.wrapper.enums.DataType;
import com.googlecode.gwtgl.wrapper.enums.DepthComparisonFunction;
import com.googlecode.gwtgl.wrapper.enums.GLCapability;
import com.googlecode.gwtgl.wrapper.enums.GLError;
import com.googlecode.gwtgl.wrapper.enums.PrimitiveRenderingMode;
import com.googlecode.gwtgl.wrapper.enums.ShaderType;
import com.googlecode.gwtgl.wrapper.enums.TextureMagFilter;
import com.googlecode.gwtgl.wrapper.enums.TextureMinFilter;
import com.googlecode.gwtgl.wrapper.enums.TextureTarget;

/**
 * Example that shows a rotating cube with a texture applied to all sides with
 * basic lighting.
 * 
 * @author Sönke Sothmann
 * @author Steffen Schäfer
 * 
 */
public class LightingWrapperExample extends AbstractGwtGLWrapperExample {

	private static final String VERTICES = "vertices";
	private static final String TEX_COORDS = "tex_coords";
	private static final String NORMALS = "normals";

	private Mesh cube = CubeFactory.createNewInstance(1.0f);
	private MatrixWidget perspectiveMatrixWidget;
	private MatrixWidget translationMatrixWidget;
	private MatrixWidget rotationMatrixWidget;
	private MatrixWidget resultingMatrixWidget;

	private Texture2D texture;
	private WebGLUniformLocation textureUniform;
	private ShaderProgram shaderProgram;
	private Buffer buffer;

	private int angleX = 0;
	private int angleY = 0;
	private int angleZ = 0;
	private float translateZ = -2;
	private FloatMatrix4x4 perspectiveMatrix;
	private FloatMatrix4x4 translationMatrix;
	private FloatMatrix4x4 rotationMatrix;
	private FloatMatrix4x4 resultingMatrix;
	private Vectorf lightingDirection = new Vector3f(0, -1, -1);
	private float directionalColorRed = 1.0f;
	private float directionalColorGreen = 0.1f;
	private float directionalColorBlue = 0.1f;
	private float ambientColorRed = 0.5f;
	private float ambientColorGreen = 0.5f;
	private float ambientColorBlue = 0.5f;

	/**
	 * Constructs an instance of the LightingWrapperExample.
	 */
	public LightingWrapperExample() {
		// create an panel to show the matrices
		HorizontalPanel matrixPanel = new HorizontalPanel();
		perspectiveMatrixWidget = new MatrixWidget(4, 4, "perspective matrix:");
		translationMatrixWidget = new MatrixWidget(4, 4, "translation matrix:");
		rotationMatrixWidget = new MatrixWidget(4, 4, "rotation matrix:");
		resultingMatrixWidget = new MatrixWidget(4, 4, "resulting matrix:");
		matrixPanel.add(perspectiveMatrixWidget);
		matrixPanel.add(translationMatrixWidget);
		matrixPanel.add(rotationMatrixWidget);
		matrixPanel.add(resultingMatrixWidget);

		setWidget(2, 0, matrixPanel);
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>Lighting Wrapper Example</h2><h3>Controls</h3><p>PAGEGUP - Zoom in<br/>PAGEDOWN - Zoom out</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#init()
	 */
	@Override
	protected void init() {
		initParams();
		initTexture();
		initShaders();
		initBuffers();
		initControls();

		showMatrices();
	}

	/**
	 * Updates the Matrix widgets every 500ms
	 */
	private void showMatrices() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				perspectiveMatrixWidget.setData(perspectiveMatrix);
				translationMatrixWidget.setData(translationMatrix);
				rotationMatrixWidget.setData(rotationMatrix);
				resultingMatrixWidget.setData(resultingMatrix);
			}
		};
		timer.scheduleRepeating(500);
	}

	/**
	 * Initializes the controls of the example.
	 */
	private void initControls() {
		// Handle keyboard input
		webGLCanvas.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_PAGEUP) {
					translateZ += 0.1f;
					event.stopPropagation();
					event.preventDefault();
				}
				if (event.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN) {
					translateZ -= 0.1f;
					event.stopPropagation();
					event.preventDefault();
				}
			}
		});
	}

	/**
	 * Initialized the params of WebGL.
	 */
	private void initParams() {
		// Set the background color
		webGLWrapper.clearColor(0.2f, 0.2f, 0.2f, 1.0f);
		// Set the clear depth (everything is cleared)
		webGLWrapper.clearDepth(1.0f);

		// Activate depth test and set the depth function
		webGLWrapper.enable(GLCapability.DEPTH_TEST);
		webGLWrapper.depthFunc(DepthComparisonFunction.LEQUAL);
	}

	/**
	 * Checks the WebGL Errors and throws an exception if there is an error.
	 */
	private void checkErrors() {
		GLError error = webGLWrapper.getError();
		if (error != GLError.NO_ERROR) {
			String message = "WebGL Error: " + error;
			GWT.log(message, null);
			throw new RuntimeException(message);
		}
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void initShaders() {
		Shader vertexShader = getShader(ShaderType.VERTEX_SHADER,
				Resources.INSTANCE.vertexShader().getText());
		Shader fragmentShader = getShader(ShaderType.FRAGMENT_SHADER,
				Resources.INSTANCE.fragmentShader().getText());
		// Create the program object
		shaderProgram = new ShaderProgram(webGLWrapper, vertexShader,
				fragmentShader);
		// Bind vertexPosition to attribute 0
		shaderProgram.bindAttribLocation(0, "vertexPosition");
		// Bind texPosition to attribute 1
		shaderProgram.bindAttribLocation(1, "texPosition");
		// Bind vertexNormal to attribute 2
		shaderProgram.bindAttribLocation(2, "vertexNormal");
		// Check the link status
		boolean linked = shaderProgram.isLinked();
		if (!linked) {
			String infoLog = shaderProgram.getProgramInfoLog();
			GWT.log("Error linking program:\n" + infoLog, null);
			shaderProgram.delete();
			return;
		}

		textureUniform = shaderProgram.getUniformLocation("tex");

		checkErrors();
	}

	/**
	 * Initializes the buffers for vertex coordinates, normals and texture
	 * coordinates.
	 */
	private void initBuffers() {
		buffer = new Buffer(webGLWrapper, BufferTarget.ARRAY_BUFFER,
				BufferUsage.STATIC_DRAW);
		buffer.addData(VERTICES, new FloatArray(cube.getVertices()));
		buffer.addData(TEX_COORDS, new FloatArray(cube.getTexCoords()));
		buffer.addData(NORMALS, new FloatArray(cube.getVertexNormals()));

		checkErrors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#draw()
	 */
	@Override
	protected void draw() {
		angleX = (angleX + 1) % 360;
		angleY = (angleY + 1) % 360;
		// angleZ=(angleZ+2)%360;

		webGLWrapper.clear(ClearFlag.COLOR_BUFFER, ClearFlag.DEPTH_BUFFER);
		checkErrors();
		shaderProgram.useProgram();
		checkErrors();

		// activate buffers
		buffer.bind();
		webGLWrapper.enableVertexAttribArray(0);
		webGLWrapper.vertexAttribPointer(0, 3, DataType.FLOAT, false, 0, buffer
				.getOffset(VERTICES));

		webGLWrapper.enableVertexAttribArray(1);
		webGLWrapper.vertexAttribPointer(1, 2, DataType.FLOAT, false, 0, buffer
				.getOffset(TEX_COORDS));

		webGLWrapper.enableVertexAttribArray(2);
		webGLWrapper.vertexAttribPointer(2, 3, DataType.FLOAT, false, 0, buffer
				.getOffset(NORMALS));

		// set up projection matrix
		WebGLUniformLocation mvUniform = shaderProgram.getUniformLocation("projectionMatrix");
		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f,
				100);
		translationMatrix = MatrixUtil
				.createTranslationMatrix(0, 0, translateZ);
		rotationMatrix = MatrixUtil
				.createRotationMatrix(angleX, angleY, angleZ);
		resultingMatrix = perspectiveMatrix.multiply(translationMatrix)
				.multiply(rotationMatrix);
		webGLWrapper.uniformMatrix4fv(mvUniform, false, resultingMatrix
				.getColumnWiseFlatData());
		checkErrors();

		// Texturing
		// Bind the texture to texture unit 0
		texture.setActiveAndBind(0);
		checkErrors();
		// Point the uniform sampler to texture unit 0
		webGLWrapper.uniform1i(textureUniform, 0);

		// Lighting
		webGLWrapper.uniform3f(
				shaderProgram.getUniformLocation("ambientColor"),
				ambientColorRed, ambientColorGreen, ambientColorBlue);
		Vectorf adjustedLightDirection = lightingDirection.toUnitVector()
				.multiply(-1);
		float[] flatLightDirection = adjustedLightDirection.toArray();
		webGLWrapper.uniform3f(shaderProgram
				.getUniformLocation("lightingDirection"),
				flatLightDirection[0], flatLightDirection[1],
				flatLightDirection[2]);
		webGLWrapper.uniform3f(shaderProgram
				.getUniformLocation("directionalColor"), directionalColorRed,
				directionalColorGreen, directionalColorBlue);

		FloatMatrix4x4 normalMatrix = rotationMatrix.inverse();
		normalMatrix = normalMatrix.transpose();
		webGLWrapper.uniformMatrix4fv(shaderProgram
				.getUniformLocation("normalMatrix"), false, normalMatrix
				.getColumnWiseFlatData());

		checkErrors();
		webGLWrapper.drawArrays(PrimitiveRenderingMode.TRIANGLES, 0, 36);
		checkErrors();
		webGLWrapper.flush();
	}

	/**
	 * Initializes the texture of this example.
	 */
	private void initTexture() {
		// Create and initialize the WebGLTexture object.
		texture = new Texture2D(webGLWrapper, Resources.INSTANCE.texture());

		// set the texture active on texture unit 0 and bind the texture
		texture.setActiveAndBind(0);
		// 
		webGLWrapper.setTextureMinFilter(TextureTarget.TEXTURE_2D,
				TextureMinFilter.LINEAR);
		webGLWrapper.setTextureMagFilter(TextureTarget.TEXTURE_2D,
				TextureMagFilter.LINEAR);
	}

	/**
	 * Creates an Shader instance defined by the ShaderType and the source.
	 * 
	 * @param shaderType
	 *            the type of the shader to create
	 * @param source
	 *            the source of the shader
	 * @return the created Shader instance.
	 */
	Shader getShader(ShaderType shaderType, String source) {
		Shader shader = new Shader(webGLWrapper, shaderType, source);

		// check if the Shader is successfully compiled
		if (!shader.isCompiled()) {
			throw new RuntimeException(shader.getInfoLog());
		}

		return shader;

	}

}
