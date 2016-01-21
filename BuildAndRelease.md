# Introduction #

The build of GwtGL is based on [Maven2](http://maven.apache.org/).

See the following page on how to install Maven:
http://maven.apache.org/download.html#Installation

# The build #

To make a local build, just execute the following command in the project:
```
mvn install
```

After that you can find the following files under <project.home>/target:
  * `gwtgl-<VERSION>.jar`
  * `gwtgl-<VERSION>-sources.jar`
  * `gwtgl-<VERSION>-javadocs.jar`

# The release #

A release (bin, src and javadoc zipped together) can be build using the maven assembly plugin. Just execute:
```
mvn assembly:assembly
```

The artifact can be found at `<project.home>/target/gwtgl-<VERSION>-dist.zip`