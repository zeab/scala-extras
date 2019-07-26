//Imports
import sbt._

object Dependencies {

  //List of Versions
  val V = new {
    val scalaTest                   = "3.0.5"
    val reflect                     = "2.12.8"
  }

  //List of Dependencies
  val D = new {
    //Reflection
    val reflect                     = "org.scala-lang" % "scala-reflect" % V.reflect
    //Test
    val scalaTest                   = "org.scalatest" %% "scalatest" % V.scalaTest
  }

  val rootDependencies: Seq[ModuleID] = Seq(
    D.reflect,
    D.scalaTest
  )

}
