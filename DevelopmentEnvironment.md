# The development environment #

The development environment is based on Eclipse. You need at least the following:
  * [Eclipse](http://www.eclipse.org/downloads/) 3.7 (e.g. Eclipse for Java Developers)
  * The [Google Plugin for Eclipse](http://code.google.com/intl/de-DE/eclipse/docs/install-eclipse-3.7.html) (install the plugin and the GWT SDK)
  * A Subversion plugin
    * [Subversive](http://eclipse.org/subversive/)
    * [Subclipse](http://subclipse.tigris.org/)

# Checkout of the projects #

All needed projects are contained in the SVN Repository at Googlecode. Create a repository location for the URL https://gwtgl.googlecode.com/svn/ in Eclipse. Use your Googlecode username and password to be able to commit.

Checkout the following folders as Eclipse projects:
  * /trunk/GwtGL

The projects are configured to work out of the box in Eclipse with the Google Plugin.

# Deploy and run the examples #

To compile the examples, you must select the examples project in the package explorer. Then press the "GWT CompileProject" action (the red toolbox) in the toolbar.
If you want to debug the resulting JavaScript code later, change output style to pretty.

When the examples project is compiled sucessfully, you can create a war archive by simply packing the contents of the folder "war" inside the examples project. Change the file extension of the zip file to "war".
Then you can deploy the project to an standard Servlet container (e.g. tomcat or jetty)