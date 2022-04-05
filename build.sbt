import Dependencies._

ThisBuild / scalaVersion               := "2.13.8"
ThisBuild / organization               := "io.saveveltri"
ThisBuild / organizationName           := "saveveltri"
ThisBuild / semanticdbEnabled          := true
ThisBuild / semanticdbVersion          := scalafixSemanticdb.revision
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

ThisBuild / scalafixDependencies ++= List(
  "com.github.vovapolu" %% "scaluzzi" % "0.1.21"
)

// Formatting and Linting
ThisBuild / scalafmtCheck    := true
ThisBuild / scalafmtSbtCheck := true

lazy val Scalaga = (project in file("."))
  .settings(
    name                            := "Scalaga",
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
  .enablePlugins(AutomateHeaderPlugin)
  .settings(LicenseHeader.settings: _*)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
addCommandAlias("format", "; all scalafmtSbt scalafmtAll")
addCommandAlias("fix", "scalafixAll")
addCommandAlias("fixAndFormat", "; scalafixAll; headerCreate; all scalafmtSbt scalafmtAll")
addCommandAlias("styleCheck", "; scalafmtSbtCheck; scalafmtCheckAll; headerCheck; scalafixAll --check")
