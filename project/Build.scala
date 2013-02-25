import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "isobeyaki-counter"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "org.twitter4j" % "twitter4j-core" % "3.0.3",
    "org.twitter4j" % "twitter4j-stream" % "3.0.3",
    "org.fusesource.scalate" % "scalate-core_2.10" % "1.6.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "FuseSource Public Repository" at "http://repo.fusesource.com/nexus/content/repositories/public/"
  )

}
