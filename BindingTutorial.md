**Compatible with GwtGL version 0.9.1.**

# Introduction #
This tutorial will show you how you can create a simple GwtGL application that uses GwtGL's WebGL [binding](BindingOverview.md) to render a white triangle to the screen.
A white triangle is not very spectacular, but it will teach you the basics of using GwtGL.

# Preparations #
For this tutorial you need a clean GWT application. Create an emtpy GWT app (use project name _GwtGLBindingDemo_ and package name _gwtgl.binding_), add GwtGL dependency and add a div with ID _gwtGL_ to your html file as a placeholder for your WebGL Canvas.
If you don't know how you can create an empty GWT app, read [how to create an empty GwtGL enabled GWT app](HowToCreateAnEmptyGWTApp.md).

# First Steps #
Now in the client package, open the client class, e.g. _GwtGLBindingDemo.java_.
Replace any content in this file with the following code:
```
package gwtgl.binding.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

public class GwtGLBindingDemo implements EntryPoint {

	private WebGLRenderingContext glContext;
	private WebGLProgram shaderProgram;
	private int vertexPositionAttribute;
	private WebGLBuffer vertexBuffer;

	public void onModuleLoad() {
		final Canvas webGLCanvas = Canvas.createIfSupported();
		webGLCanvas.setCoordinateSpaceHeight(500);
		webGLCanvas.setCoordinateSpaceWidth(500);
		glContext = (WebGLRenderingContext) webGLCanvas.getContext("experimental-webgl");
		if(glContext == null) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}
		glContext.viewport(0, 0, 500, 500);
		
		RootPanel.get("gwtGL").add(webGLCanvas);
		start();
	}
}
```
The _onModuleLoad()_ method is the entry point of your GWT application.
The Canvas is the area on the page where the 3d scene is rendered.
The WebGLRenderingContext is the central class when using the binding in GwtGL. You will find all WebGL constants and method in that class.
So now you have an application with an html page that contains the WebGL canvas.

# Initialize WebGL #

Add a start() method to the class _GwtGLBindingDemo_. The _start()_ method is called once to initialize WebGL.
```
private void start() {
	initShaders();
	glContext.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
	glContext.clearDepth(1.0f);
	glContext.enable(WebGLRenderingContext.DEPTH_TEST);
	glContext.depthFunc(WebGLRenderingContext.LEQUAL);
	initBuffers();

	drawScene();
}
```
We initialize the shader, set a color that will be used to clear the canvas, configure the depth buffer so that objects near the camera overlap objects that have a higher distance to the camera.
We initialize the buffer that will contain our vertices and finally draw the scene. In a real application, the drawScene method would be called periodically, but in our simple example, it is sufficient to call it just once.

# Initialize shaders #
Now implement the initShaders() method.
Use the following code fragment:
```
public void initShaders() {
	WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.fragmentShader().getText());
	WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader().getText());

	shaderProgram = glContext.createProgram();
	glContext.attachShader(shaderProgram, vertexShader);
	glContext.attachShader(shaderProgram, fragmentShader);
	glContext.linkProgram(shaderProgram);

	if (!glContext.getProgramParameterb(shaderProgram, WebGLRenderingContext.LINK_STATUS)) {
		throw new RuntimeException("Could not initialise shaders");
	}

	glContext.useProgram(shaderProgram);

	vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "vertexPosition");
	glContext.enableVertexAttribArray(vertexPositionAttribute);
}
```
We create two shaders - a vertex and a fragment shader - and assign them to a shader program. We link (linkProgram()) and use (useProgram()) this shader program.
Finally, we enable the vertex shaders vertexPosition attribute.

The getShader() method is quite simple:
```
private WebGLShader getShader(int type, String source) {
	WebGLShader shader = glContext.createShader(type);

	glContext.shaderSource(shader, source);
	glContext.compileShader(shader);

	if (!glContext.getShaderParameterb(shader, WebGLRenderingContext.COMPILE_STATUS)) {
		throw new RuntimeException(glContext.getShaderInfoLog(shader));
	}

	return shader;
}
```
This method creates a new shader object, assignes the sourcecode of the shader to the shader object, compiles the shader and finally returns the shader object to the caller.

# Initialize Buffers #

Now implement the initBuffers() method. An array buffer holds vertex data - in our simple cases the vertices of a single triangle.
This buffer will be used later to render the scene. Add the following code fragment to your class:
```
private void initBuffers() {
	vertexBuffer = glContext.createBuffer();
	glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
	float[] vertices = new float[]{
			 0.0f,  1.0f,  -5.0f, // first vertex
			-1.0f, -1.0f,  -5.0f, // second vertex
			 1.0f, -1.0f,  -5.0f  // third vertex
	};
	glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Float32Array.create(vertices), WebGLRenderingContext.STATIC_DRAW);
}
```

# Draw the scene #

Now implement the drawScene() method.
```
private void drawScene() {
	glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);
	float[] perspectiveMatrix = createPerspectiveMatrix(45, 1, 0.1f, 1000);
	WebGLUniformLocation uniformLocation = glContext.getUniformLocation(shaderProgram, "perspectiveMatrix");
	glContext.uniformMatrix4fv(uniformLocation, false, perspectiveMatrix);
	glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
	glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 3);
}
```
First, you clear the screen with the color you defined in the _start()_ method (black color).
The second step is to create a perspective matrix. The perspective matrix is needed to make the scene look three dimensional.
You need to attach this perspective matrix to the shader program. You do this by getting the location of the corresponding shader variable (_glContext.getUniformLocation()_) and then you assign the matrix to this shader variable (_glContext.uniformMatrix4fv()_).
The glContext.vertexAttribPointer() method activates the vertex buffer so you can render our triangle. The second parameter with value 3 indicates that every vertex consists of 3 float values (x,y,z).
Finally, the drawArrays() method renders the triangle using the buffer that you have set up before. The third parameter with value 3 indicates that you render 3 vertices.

The createPerspectiveMatrix() method is needed for the 3D look of our scene.
```
private float[] createPerspectiveMatrix(int fieldOfViewVertical, float aspectRatio, float minimumClearance, float maximumClearance) {
	float top    = minimumClearance * (float)Math.tan(fieldOfViewVertical * Math.PI / 360.0);
	float bottom = -top;
	float left   = bottom * aspectRatio;
	float right  = top * aspectRatio;

	float X = 2*minimumClearance/(right-left);
	float Y = 2*minimumClearance/(top-bottom);
	float A = (right+left)/(right-left);
	float B = (top+bottom)/(top-bottom);
	float C = -(maximumClearance+minimumClearance)/(maximumClearance-minimumClearance);
	float D = -2*maximumClearance*minimumClearance/(maximumClearance-minimumClearance);

	return new float[]{	X, 0.0f, A, 0.0f,
						0.0f, Y, B, 0.0f,
						0.0f, 0.0f, C, -1.0f,
						0.0f, 0.0f, D, 0.0f};
};
```
I'm not going to explain the algebra behind this, just take it for granted for the moment.

# Implement the shaders #

The last thing that you have to do to render the white triangle is to provide the [vertex and fragment shader](http://en.wikipedia.org/wiki/Shader_%28realtime,_logical%29) source.

## Vertex shader ##

Add a file _vertex-shader.txt_ to your package _gwtgl.binding.client_ with the following content:
```
attribute vec3 vertexPosition;
uniform mat4 perspectiveMatrix;
void main(void)
{
  gl_Position = perspectiveMatrix * vec4(vertexPosition, 1.0);
}
```

## Fragment shader ##

Add a file _fragment-shader.txt_ to your package _gwtgl.binding.client_ with the following content:
```
void main(void)
{
  gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);
}
```

## Make shader source available ##

To make these shaders available to your application, you need a  [GWT Client Bundle](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideClientBundle.html).
Add a file _Shaders.java_ to your package _gwtgl.binding.client_ with the following content:
```
package gwtgl.binding.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Shaders extends ClientBundle {
	public static Shaders INSTANCE=GWT.create(Shaders.class);
	
	@Source(value={"fragment-shader.txt"})
	TextResource fragmentShader();
	
	@Source(value={"vertex-shader.txt"})
	TextResource vertexShader();
}
```

# Start your application #

That's it - now you can start your application.
The easiest way to try your code is to run it in development mode. To do this, right click on your project and choose _Run As_ -> _Web Application_.

Development mode allows you to debug your code, but unfortunatly, it is much slower than running it in a servlet container.
So if you want to try your code at full speed, you have to build a war file and deploy it to a servlet container, e.g. [Apache Tomcat 6](http://tomcat.apache.org/download-60.cgi).
To do so, compile your application: right click on your project -> _Google_ -> _GWT Compile_.

Zip the contents of the war directory in your project folder, name it _GwtGLBindingDemo.war_ and copy it to the webapps folder of your tomcat installation. Start tomcat and open the following URL in your WebGL enabled browser: http://localhost:8080/GwtGLBindingDemo/ .
Enjoy your white triangle ;-)

# List of all imports needed #
Here is a list of all imports needed in this tutorial:
```
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;
```