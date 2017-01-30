name := "IO"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )
