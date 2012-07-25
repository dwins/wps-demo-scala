# A Small Demo of a GeoTools Process Plugin in Scala

This project is a minimal "split polygon" process plugin for GeoTools implemented in Scala instead of Java.

## Build

For UNIX-like OSs, all you need is Git and a Java VM.  The following commands should do the trick:

```#!sh
git clone git://github.com/dwins/wps-demo-scala.git 
cd wps-demo-scala/
sh sbt package
```

After this the plugin will be in a Jar file in ``target/scala_2.9.1``.
If you want to actually deploy it to GeoServer you'll need to also include a copy of scala-library.jar when you deploy to GeoServer.
