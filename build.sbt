organization := "org.example.wps"

name := "wps-demo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.geotools" % "gt-process" % "8.0-RC2",
  "org.geotools" % "gt-geometry" % "8.0-RC2")

resolvers += "opengeo" at "http://repo.opengeo.org/"

resolvers += "osgeo" at "http://download.osgeo.org/webdav/geotools/"
