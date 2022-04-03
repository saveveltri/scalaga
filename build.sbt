import Dependencies._

ThisBuild / scalaVersion               := "2.13.8"
ThisBuild / organization               := "com.example"
ThisBuild / organizationName           := "example"
ThisBuild / semanticdbEnabled          := true
ThisBuild / semanticdbVersion          := scalafixSemanticdb.revision
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

ThisBuild / scalafixDependencies ++= List(
  "com.github.vovapolu" %% "scaluzzi" % "0.1.20"
)

// Formatting and Linting
ThisBuild / scalafmtCheck    := true
ThisBuild / scalafmtSbtCheck := true

lazy val root = (project in file("."))
  .settings(
    name                            := "Scala Seed Project",
    scalacOptions                   := Seq(
      "-unchecked",
      "-deprecation",
      "-Ywarn-unused",
      "-Ywarn-unused:imports",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-encoding",
      "utf8"
    ),
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
addCommandAlias("format", "; all scalafmtSbt scalafmtAll")
addCommandAlias("fix", "scalafixAll")
addCommandAlias("fixAndFormat", "; scalafixAll; all scalafmtSbt scalafmtAll")
