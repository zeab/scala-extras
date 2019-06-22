//Imports
import sbt._

object Dependencies {

  //List of Versions
  val V = new {
    val scalaReflect                = "2.12.6"
    val scalaTest                   = "3.0.5"
    val logbackJson                 = "6.1"
    val logback                     = "1.2.3"
  }

  //List of Dependencies
  val D = new {
    //Reflection
    val reflect                     = "org.scala-lang" % "scala-reflect" % "2.12.6"
    //Test
    val scalaTest                   = "org.scalatest" %% "scalatest" % V.scalaTest
    //Logging
    val logback                     = "ch.qos.logback" % "logback-classic" % V.logback
    val logbackJson                 = "net.logstash.logback" % "logstash-logback-encoder" % V.logbackJson
  }

  val rootDependencies: Seq[ModuleID] = Seq(
    D.reflect,
    D.scalaTest,
    D.logback,
    D.logbackJson
  )

}
