name := "scala-sbt"

lazy val common = Seq (
    version := "1.0.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
    scalacOptions ++= Seq("-deprecation", "-feature")
)

lazy val root = Project("scala-sbt", file("."))
        .aggregate(
            listKataDay1, listKataDay2, listKataDay3, listKataDay4, listKataDay5, listKataDay6, listKataDay7,
            stringCalcDay1, stringCalcDay2, stringCalcDay3,
            lexerKataDay1, lexerKataDay2,
            graphSearchDay1, graphSearchDay2, graphSearchDay3, graphSearchDay4
        )

lazy val listKataDay1 = Project("list-kata-day-1", file("list-kata/list-kata-day-1")).settings(common : _*)
lazy val listKataDay2 = Project("list-kata-day-2", file("list-kata/list-kata-day-2")).settings(common : _*)
lazy val listKataDay3 = Project("list-kata-day-3", file("list-kata/list-kata-day-3")).settings(common : _*)
lazy val listKataDay4 = Project("list-kata-day-4", file("list-kata/list-kata-day-4")).settings(common : _*)
lazy val listKataDay5 = Project("list-kata-day-5", file("list-kata/list-kata-day-5")).settings(common : _*)
lazy val listKataDay6 = Project("list-kata-day-6", file("list-kata/list-kata-day-6")).settings(common : _*)
lazy val listKataDay7 = Project("list-kata-day-7", file("list-kata/list-kata-day-7")).settings(common : _*)
lazy val stringCalcDay1 = Project("string-calc-day-1", file("string-calc/string-calc-day-1")).settings(common : _*)
lazy val stringCalcDay2 = Project("string-calc-day-2", file("string-calc/string-calc-day-2")).settings(common : _*)
lazy val stringCalcDay3 = Project("string-calc-day-3", file("string-calc/string-calc-day-3")).settings(common : _*)
lazy val lexerKataDay1 = Project("lexer-kata-day-1", file("lexer/lexer-kata-day-1")).settings(common : _*)
lazy val lexerKataDay2 = Project("lexer-kata-day-2", file("lexer/lexer-kata-day-2")).settings(common : _*)
lazy val graphSearchDay1 = Project("graph-search-day-1", file("graph-search/graph-search-day-1")).settings(common : _*)
lazy val graphSearchDay2 = Project("graph-search-day-2", file("graph-search/graph-search-day-2")).settings(common : _*)
lazy val graphSearchDay3 = Project("graph-search-day-3", file("graph-search/graph-search-day-3")).settings(common : _*)
lazy val graphSearchDay4 = Project("graph-search-day-4", file("graph-search/graph-search-day-4")).settings(common : _*)
