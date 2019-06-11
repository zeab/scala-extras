
//Imports
import Settings._
import Dependencies._
import Resolvers.allResolvers

//Sbt Log Level
logLevel := Level.Info

//Add all the command alias's
CommandAlias.allPublishAlias

lazy val scalaextras = (project in file("."))
  .settings(rootSettings: _*)
  .settings(libraryDependencies ++= rootDependencies)
  .enablePlugins(SonaType)
