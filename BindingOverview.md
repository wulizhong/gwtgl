# Introduction #

The GwtGL binding is an almost 1:1 mapping of the WebGL API for GWT.
The aim of the binding is to provide a basic but complete GWT based API with minimal overhead.
The other main goal of the binding is, to be as close as possible to the original API. So WebGL tutorials and articles should also help you to understand the GwtGL binding.

# API differences between WebGL and the GwtGL binding #

Java and JavaScript in spite of their similar names have many differences. Therefore it wasn't possible to map every facet of the API 1:1 to Java.

In detail the differences are:
  * WebGL uses a canvas element to display the 3d stuff. To render on this canvas you request the WebGLRenderingContext by calling getContext(contextName). In the GwtGL binding the canvas is wrapped into a GWT widget called WebGLCanvas. You can get access to the rendering context by calling getGlContext() on an instance of the WebGLCanvas.
  * The WebGLArray classes have no constructors in the binding. However there are factory methods in the WebGLArray classes. The factory methods are called create(...) and there is one for every missing constructor with matching parameters.
  * All methods that can return different primitive values or primitive values and objects, are mapped as multiple methods. The method that returns objects has the original name, the methods that return the primitive values have suffixes:
    * i for int
    * b for boolean
    * f for float

# technical background #

The GwtGL binding heavily uses the JavaScript Native Interface (JSNI) defined by GWT. Most of the JavaScript code is generated using GWT deferred binding. This is possible because of the almost 1:1 mapping of the API. So the JavaScript calls can be generated using the declared Java Interface.
There are two generators:
  * The JsniMethodCallGenerator generates method calls out of an Java interface.
  * The JsniConstAccessorGenerator generates methods to access the constants defined by WebGL.