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

lazy val bowling_game_day_2 = project.in(file("bowling_game_kata/bowling_game_day_2"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_2")

lazy val bowling_game_day_3 = project.in(file("bowling_game_kata/bowling_game_day_3"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_3")

lazy val bowling_game_day_4 = project.in(file("bowling_game_kata/bowling_game_day_4"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_4")

lazy val bowling_game_day_5 = project.in(file("bowling_game_kata/bowling_game_day_5"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_5")

lazy val bowling_game_day_6 = project.in(file("bowling_game_kata/bowling_game_day_6"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_6")

lazy val bowling_game_day_7 = project.in(file("bowling_game_kata/bowling_game_day_7"))
  .settings(common: _*)
  .settings(name := "bowling_game_day_7")

lazy val binary_tree_day_01 = project.in(file("binary_tree_kata/binary_tree_day_01"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_01")

lazy val binary_tree_day_02 = project.in(file("binary_tree_kata/binary_tree_day_02"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_02")

lazy val binary_tree_day_03 = project.in(file("binary_tree_kata/binary_tree_day_03"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_03")

lazy val binary_tree_day_04 = project.in(file("binary_tree_kata/binary_tree_day_04"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_04")

lazy val binary_tree_day_05 = project.in(file("binary_tree_kata/binary_tree_day_05"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_05")

lazy val binary_tree_day_06 = project.in(file("binary_tree_kata/binary_tree_day_06"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_06")

lazy val binary_tree_day_07 = project.in(file("binary_tree_kata/binary_tree_day_07"))
  .settings(common: _*)
  .settings(name := "binary_tree_day_07")
