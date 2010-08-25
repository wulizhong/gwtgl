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
package com.googlecode.gwtgl.example.client.examples.whitetriangle.wrapper;

import com.googlecode.gwtgl.binding.WebGLUniformLocation;
import com.googlecode.gwtgl.example.client.AbstractGwtGLWrapperExample;
import com.googlecode.gwtgl.example.client.util.math.FloatMatrix;
import com.googlecode.gwtgl.example.client.util.math.MatrixUtil;
import com.googlecode.gwtgl.wrapper.Buffer;
import com.googlecode.gwtgl.wrapper.FloatArray;
import com.googlecode.gwtgl.wrapper.Shader;
import com.googlecode.gwtgl.wrapper.ShaderProgram;
import com.googlecode.gwtgl.wrapper.enums.BufferTarget;
import com.googlecode.gwtgl.wrapper.enums.BufferUsage;
import com.googlecode.gwtgl.wrapper.enums.ClearFlag;
import com.googlecode.gwtgl.wrapper.enums.DataType;
import com.googlecode.gwtgl.wrapper.enums.DepthComparisonFunction;
import com.googlecode.gwtgl.wrapper.enums.GLCapability;
import com.googlecode.gwtgl.wrapper.enums.PrimitiveRenderingMode;
import com.googlecode.gwtgl.wrapper.enums.ShaderType;

/**
 * Example that shows a white triangle created with the GwtGL wrapper.
 * 
 * @author Steffen Schäfer
 * 
 */
public class WhiteTriangleWrapperExample extends AbstractGwtGLWrapperExample {

	private ShaderProgram shaderProgram;
	private FloatMatrix projectionMatrix;
	private Buffer vertexBuffer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#init()
	 */
	@Override
	protected void init() {
		createShaderProgram();
		initParams();
		initVertexBuffer();
		initProjectionMatrix();
	}

	/**
	 * initializes the projection matrix used in this example.
	 */
	private void initProjectionMatrix() {
		projectionMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f,
				100);
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
	 * Initializes the buffer containing the vertex coordinates.
	 */
	private void initVertexBuffer() {
		// One Triangle with 3 Points à 3 coordinates
		float[] vertices = new float[] { 0.0f, 1.0f, -2.0f, -1.0f, -1.0f,
				-2.0f, 1.0f, -1.0f, -2.0f };
		// create the vertexBuffer
		vertexBuffer = new Buffer(webGLWrapper, BufferTarget.ARRAY_BUFFER,
				BufferUsage.STATIC_DRAW);
		vertexBuffer.addData("vertices", new FloatArray(vertices));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#draw()
	 */
	@Override
	protected void draw() {
		// Clear the color buffer and the depth buffer
		webGLWrapper.clear(ClearFlag.COLOR_BUFFER, ClearFlag.DEPTH_BUFFER);

		// Set the ShaderProgram active
		shaderProgram.useProgram();

		// Set the buffer containing the vertex coordinates active
		vertexBuffer.bind();

		// Bind the vertex position attribute of the shader to the buffer
		int vertexPositionAttribute = shaderProgram
				.getAttribLocation("vertexPosition");
		webGLWrapper.vertexAttribPointer(vertexPositionAttribute, 3,
				DataType.FLOAT, false, 0, 0);
		webGLWrapper.enableVertexAttribArray(vertexPositionAttribute);

		// Bind the projection matrix to the shader
		WebGLUniformLocation pUniform = shaderProgram.getUniformLocation("projectionMatrix");
		webGLWrapper.uniformMatrix4fv(pUniform, false, projectionMatrix
				.getColumnWiseFlatData());

		// Draw the polygons (3 triangles)
		webGLWrapper.drawArrays(PrimitiveRenderingMode.TRIANGLES, 0, 3);
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void createShaderProgram() {
		// Create the Shaders
		Shader fragmentShader = getShader(ShaderType.FRAGMENT_SHADER,
				Shaders.INSTANCE.fragmentShader().getText());
		Shader vertexShader = getShader(ShaderType.VERTEX_SHADER,
				Shaders.INSTANCE.vertexShader().getText());

		// Create a ShaderProgram with the Shaders set
		shaderProgram = new ShaderProgram(webGLWrapper, vertexShader,
				fragmentShader);

		// Check if the ShaderProgram is correctly linked
		if (!shaderProgram.isLinked()) {
			throw new RuntimeException(shaderProgram.getProgramInfoLog());
		}

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
