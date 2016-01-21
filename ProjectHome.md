# What is GwtGL? #

GwtGL provides a basic GWT widget and [binding](BindingOverview.md) for the upcoming WebGL standard (maintained by the WebGL working group at Khronos Group).

GwtGL enables you to develop 3D websites and web applications using the Java programming language instead of JavaScript.
Type safety and the Java Toolset help you to write your apps in less time compared to plain JavaScript development.
The GWT compiler generates optimized JavaScript code, so you will achieve higher frame rates.

# What is WebGL? #

WebGL is a graphics API based on OpenGL ES 2.0.
It enables developers to create hardware accelerated 3D graphics which can be embedded into HTML websites.
All mayor browsers will support WebGL in the near future (Chrome and Firefox already support it),
so there is no need for a plugin to be able to view WebGL enriched sites.

# Demos #

![![](http://gwtgl.googlecode.com/svn/wiki/img/demo_small.png)](http://gwtgl.googlecode.com/svn/wiki/img/demo.png)

[Click here](http://gwtgl-examples.appspot.com/) to see a live version of our demos. You need a [WebGL enabled browser](BrowserSupport.md) to see the examples.
**Updated 13-02-2011**

# News #

  * Dec 31, 2011: [Release 0.9.1](http://code.google.com/p/gwtgl/wiki/ReleaseNotes)
  * Dec 27, 2011: [Release 0.9](http://code.google.com/p/gwtgl/wiki/ReleaseNotes)
  * Mar 21, 2011: [Release 0.3](http://code.google.com/p/gwtgl/wiki/ReleaseNotes)
  * Jan 05, 2011: [Release 0.2](http://code.google.com/p/gwtgl/wiki/ReleaseNotes)
  * Feb 15, 2010: [Release 0.1](http://code.google.com/p/gwtgl/wiki/ReleaseNotes)

# Using GwtGL in your GWT project #

Include GwtGL into your classpath.
Add the following line to your **.gwt.xml to have access to the WebGL [binding](BindingOverview.md):
```
<inherits name='com.googlecode.gwtgl.binding'/>
```**

# Getting started #

The easiest way to start learning GwtGL is to read the [Documentation](Documentation.md) in our wiki.
Don't forget to install a [WebGL compatible browser](BrowserSupport.md).