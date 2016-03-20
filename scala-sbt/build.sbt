name := "scala-sbt"

lazy val root = Project("scala-sbt", file(".")).aggregate(list)

lazy val list = Project("list-kata", file("list-kata"))
  .settings(version := "1.0.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
    scalacOptions ++= Seq("-deprecation", "-feature"))