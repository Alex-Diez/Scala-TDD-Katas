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
            graphSearchDay1, graphSearchDay2, graphSearchDay3, graphSearchDay4, graphSearchDay5, graphSearchDay6,
            graphSearchDay7, graphSearchDay8, graphSearchDay9, graphSearchDay10,
            minimumSpanningTreeDay1, minimumSpanningTreeDay2, minimumSpanningTreeDay3, minimumSpanningTreeDay4,
            minimumSpanningTreeDay5, minimumSpanningTreeDay6, minimumSpanningTreeDay7, minimumSpanningTreeDay8,
            minimumSpanningTreeDay9
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
lazy val graphSearchDay5 = Project("graph-search-day-5", file("graph-search/graph-search-day-5")).settings(common : _*)
lazy val graphSearchDay6 = Project("graph-search-day-6", file("graph-search/graph-search-day-6")).settings(common : _*)
lazy val graphSearchDay7 = Project("graph-search-day-7", file("graph-search/graph-search-day-7")).settings(common : _*)
lazy val graphSearchDay8 = Project("graph-search-day-8", file("graph-search/graph-search-day-8")).settings(common : _*)
lazy val graphSearchDay9 = Project("graph-search-day-9", file("graph-search/graph-search-day-9")).settings(common : _*)
lazy val graphSearchDay10 = Project("graph-search-day-10", file("graph-search/graph-search-day-10")).settings(common : _*)
lazy val minimumSpanningTreeDay1 = Project("minimum-spanning-tree-day-1", file("minimum-spanning-tree/minimum-spanning-tree-day-1")).settings(common : _*)
lazy val minimumSpanningTreeDay2 = Project("minimum-spanning-tree-day-2", file("minimum-spanning-tree/minimum-spanning-tree-day-2")).settings(common : _*)
lazy val minimumSpanningTreeDay3 = Project("minimum-spanning-tree-day-3", file("minimum-spanning-tree/minimum-spanning-tree-day-3")).settings(common : _*)
lazy val minimumSpanningTreeDay4 = Project("minimum-spanning-tree-day-4", file("minimum-spanning-tree/minimum-spanning-tree-day-4")).settings(common : _*)
lazy val minimumSpanningTreeDay5 = Project("minimum-spanning-tree-day-5", file("minimum-spanning-tree/minimum-spanning-tree-day-5")).settings(common : _*)
lazy val minimumSpanningTreeDay6 = Project("minimum-spanning-tree-day-6", file("minimum-spanning-tree/minimum-spanning-tree-day-6")).settings(common : _*)
lazy val minimumSpanningTreeDay7 = Project("minimum-spanning-tree-day-7", file("minimum-spanning-tree/minimum-spanning-tree-day-7")).settings(common : _*)
lazy val minimumSpanningTreeDay8 = Project("minimum-spanning-tree-day-8", file("minimum-spanning-tree/minimum-spanning-tree-day-8")).settings(common : _*)
lazy val minimumSpanningTreeDay9 = Project("minimum-spanning-tree-day-9", file("minimum-spanning-tree/minimum-spanning-tree-day-9")).settings(common : _*)
