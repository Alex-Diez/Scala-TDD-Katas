name := "scala-tdd-katas"
version := "1.0"
scalaVersion := "2.12.4"

lazy val common = Seq(
  version := "1.0",
  scalaVersion := "2.12.4",
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.4" % Test
  )
)

scalacOptions ++= Seq("-deprecation", "-feature")

lazy val bowling_game_day_1 = project.in(file("bowling_game_kata/bowling_game_day_1"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_1")
