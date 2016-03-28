name := "scala-sbt"

lazy val root = Project("scala-sbt", file("."))
        .aggregate(
            listKataDay1, listKataDay2, listKataDay3, listKataDay4, listKataDay5, listKataDay6, listKataDay7,
            stringCalcDay1, stringCalcDay2
        )

lazy val listKataDay1 = Project("list-kata-day-1", file("list-kata/list-kata-day-1"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay2 = Project("list-kata-day-2", file("list-kata/list-kata-day-2"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay3 = Project("list-kata-day-3", file("list-kata/list-kata-day-3"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay4 = Project("list-kata-day-4", file("list-kata/list-kata-day-4"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay5 = Project("list-kata-day-5", file("list-kata/list-kata-day-5"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay6 = Project("list-kata-day-6", file("list-kata/list-kata-day-6"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val listKataDay7 = Project("list-kata-day-7", file("list-kata/list-kata-day-7"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val stringCalcDay1 = Project("string-calc-day-1", file("string-calc/string-calc-day-1"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )

lazy val stringCalcDay2 = Project("string-calc-day-2", file("string-calc/string-calc-day-2"))
        .settings(version := "1.0.0",
            scalaVersion := "2.11.7",
            libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test"),
            scalacOptions ++= Seq("-deprecation", "-feature")
        )
