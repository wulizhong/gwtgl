# 0.9.1 - Dec 31, 2011 #

GwtGL is mostly bugfix release.

Details
  * Added more tests for the Typed Arrays
  * fixed several bugs in the Typed Arrays Binding
    * multiple set methods were broken
    * the method subarray(int, int) was broken
  * Added explicit checks for browser support of Typed Arrays

# 0.9 - Dec 27, 2011 #

GwtGL 0.9 provides an improved binding for the WebGL 1.0 spec, support for the GWT 2.2 Canvas widget and support for the current Typed Arrays spec.

The work areas of this version in detail:
  * Improvements for the WebGLRenderingContext and WebGlCanvas
    * GWT 2.2 Canvas Support
    * WebGLRenderingContext is now a JavaScriptObject
    * Generator for accessing the constants WebGL was removed
  * Basic Tests for the Typed Arrays binding
  * Binding of the current Typed Arays specification
    * Bugfixing of the existing binding (set methods were partially broken)
    * Binding of new functionality (newe class Uint8ClampedArray)
  * Improved handling of Java Arrays using the JsArrayUtil

_this release breaks the existing APIs in some parts_

# 0.3 - Mar 21, 2011 #

GwtGL 0.3 provides basic compatibility to browsers implementing WebGL 1.0 (Chrome 10, Firefox 4) and an updated version of the Typed Arrays binding.

The work areas of this version in detail:
  * Update of the poms (used plugins, GWT 2.2, ...)
  * spec changes
    * implement changes of the Typed Arrays spec
    * basic support for extensions
  * Update of the Typed Arrays JavaDocs

# 0.2 - Jan 05, 2011 #

The focus of release 0.2 is updating the binding to reflect the spec changes since 0.1.

The work areas of this version in detail:
  * Spec changes
    * Implementation of the [Typed arrays specification](TypedArrays.md)
    * Added/changed/removed methods and constants
  * Infrastructure
    * Moved the wrapper to a new tech demo area to make clear that the wrapper is not part of the core API
    * updated the poms
    * cleanup of the project structure
    * Refactoring/cleanup of the code generators
  * Examples
    * updated the examples to reflect the spec changes
    * Created more binding demos

# 0.1 - Feb 15, 2010 #

0.1 is the first release of GwtGL. The binding API should be mostly done with sufficient JavaDocs.
An initial version of the wrapper is contained to show some technical ideas.

The work areas of this version in detail:
  * Implementation of the binding
    * Binding of all constants and methods according to the specification
    * JavaDocs for all elements
  * initial version of the wrapper
    * Wrapper classes for the objects and methods needed for basic examples
    * GWT Image support for 2D textures
    * A wrapper for the Buffer to ease the resource management and do the index calculation automatically
  * Basic documentation in the wiki
    * Overview of the binding and wrapper
    * Simple tutorial
    * Basic developer documentation
  * Examples
    * Simple example for binding
    * Simple example for wrapper
    * Texturing example for wrapper
    * Lightning example for wrapper
  * Infrastructure
    * Created a Maven2 based build