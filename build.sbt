name := "ScalaTests"

version := "0.1"

scalaVersion := "2.12.4"

// set the main class for 'sbt run'

mainClass in (Compile, run) := Some("main")

//libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.12.4"
libraryDependencies += "org.reflections" % "reflections" % "0.9.10"
//libraryDependencies += "com.geirsson" %% "scalafmt-core" % "1.4.0"