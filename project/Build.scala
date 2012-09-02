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
        "org.specs2" %% "specs2" % "1.9" % "test",
        "com.twitter" %% "util-eval" % "3.0.0"
      )
      // add other settings here
    )
  ).dependsOn(takezoe_utils)
  lazy val takezoe_utils = uri("hg:https://bitbucket.org/takezoe/scala-utils")
}
