import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-parse",
      organization := "cc.clv",
      version := "0.1-SNAPSHOT",
      scalacOptions ++= Seq("-deprecation"),
      scalaVersion := "2.9.1",
      libraryDependencies ++= Seq(
        // test
        "org.specs2" %% "specs2" % "1.9" % "test",
            
        //log
        "org.clapper" %% "grizzled-slf4j" % "0.6.8",
        "ch.qos.logback" % "logback-classic" % "1.0.1"
      )
      // add other settings here
    )
  )
}
