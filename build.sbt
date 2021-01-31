ThisBuild / scalaVersion     := scalaLangVersion
ThisBuild / version          := "0.2.0"
ThisBuild / organization     := "io.github.yoyama"
ThisBuild / organizationName := "yoyama"
ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature")
ThisBuild / cancelable in Global := true

ThisBuild / resolvers ++= Seq(
  "central" at "https://repo1.maven.org/maven2",
  "jcenter" at "https://jcenter.bintray.com/",
  "digdag" at "https://dl.bintray.com/digdag/maven",
  "digdag-snapshots" at "https://dl.bintray.com/digdag/maven-snapshots",
)

ThisBuild / publishConfiguration := publishConfiguration.value.withOverwrite(true)
ThisBuild / publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)
ThisBuild / publishTo := Some(MavenCache("local-maven", file("~/.m2/repository")))

lazy val airframeVersion = "21.1.0"
lazy val scalaLangVersion = "2.13.4"

lazy val root = (project in file("."))
  .settings(
    name := "digdag-basic-auth-mt",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaLangVersion,
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.4.0",
      "io.digdag" % "digdag-spi" % "0.10.0" % "provided",
      "org.slf4j" % "slf4j-api" % "1.7.21" % "provided",
      "commons-codec" % "commons-codec" % "1.14",
      "org.wvlet.airframe" %% "airspec" % airframeVersion % "test"
    ),
    testFrameworks += new TestFramework("wvlet.airspec.Framework")
  )

