package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class DepthFirstSearchTest extends FlatSpec with Matchers with BeforeAndAfter {

    var graph = new Graph

    before {
        graph = new Graph
    }

    it should "create a depth first search" in {
        graph.addEdge(1, 2)

        DepthFirstSearch.create(graph, 1) should not be None
    }

    it should "not create a depth first search when graph does not contains the starting vertex" in {
        DepthFirstSearch.create(graph, 1) shouldBe None
    }

    it should "have a path to transient vertex" in {
        graph.addEdge(1, 2)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        val search = DepthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe true
    }

    it should "not have a path to not connected vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(3, 4)

        val search = DepthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe false
    }

}
