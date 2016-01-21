# Create GWT application #

Create a new Google Web Application Project in Eclipse (File -> New -> Other -> Google -> Web Application Project)
Enter a project and package name.
Check _Use Google Web Toolkit_ (Version 2.2)
Click Finish.

# Delete generated files that are not needed #

The Google Eclipse plugin generates a sample project with some stuff that you don't need in your GwtGL app, so we are going to delete some files.
Delete the generated server package (e.g. _com.example.gwtgl.server_). We don't need any server code for this howto.
In the client-package (e.g. _com.example.gwtgl.client_), delete the generated classes _GreetingService.java_ and _GreetingServiceAsync.java_.

Now you have only files in the project that we actually need.

# Configuration #
Continue with some configuration.

Open the web.xml file in directory _war/WEB-INF_. Delete the generated _greetServlet_ servlet by removing the following code from the file:
```
<!-- Servlets -->
<servlet>
  <servlet-name>greetServlet</servlet-name>
  <servlet-class>com.example.gwtgl.server.GreetingServiceImpl</servlet-class>
</servlet>
  
<servlet-mapping>
  <servlet-name>greetServlet</servlet-name>
  <url-pattern>/yourproject/greet</url-pattern>
</servlet-mapping>
```

Your web.xml should now look like this:
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE web-app
    PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
    "http://java.sun.com/dtd/web-app_2_3.dtd">

<web-app>
  
  <!-- Default page to serve -->
  <welcome-file-list>
    <welcome-file>YourProjectName.html</welcome-file>
  </welcome-file-list>

</web-app>
```

# Add GwtGL to your project #

Extract the GwtGL bin and src jar files from the zip download to the directory _war/WEB-INF/lib_ in your project folder. Add these jars to the build path: right mouse click on your
project -> Properties -> Java Build Path -> Tab Libraries-> Click Add JARs-> select the two GwtGL jar files -> click OK -> click OK.

Open file YourProjectName.html in _war_ directory.
Scroll to the body tag. Below the noscript tag you will find a headline and a sample, generated html table. replace the table with the following code:
```
<div id="gwtGL"></div>
```
This is our placeholder that will contain the WebGL canvas.

Open the gwt xml configuration file in the root package (e.g. _your.package.structure.GwtGLBindingDemo.gwt.xml_).
Add the following entry:
```
<inherits name='com.googlecode.gwtgl.binding'/>
```
This will make the WebGL binding available in your project.

# Implement the entry point #

In the client package, open the remaining class, e.g. _YourProjectName.java_.
Replace any content in this file with the following code:
```
package com.example.gwtgl.client;

import com.google.gwt.core.client.EntryPoint;

public class GwtGLBindingDemo implements EntryPoint {
	
	public void onModuleLoad() {
	}
}
```

That's it. You can now start to build your GwtGL app.