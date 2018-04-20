package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class DepthFirstSearchTest extends FlatSpec with Matchers with BeforeAndAfter {

    var graph = new Graph

    before {
        graph = new Graph
    }

    it should "create a depth first search" in {
        graph.addEdge(1, 2)

        DepthFirstSearch.create(graph, 1).isDefined shouldBe true
    }

    it should "not create a depth first search from an empty graph" in {
        DepthFirstSearch.create(graph, 1) shouldBe None
    }

    it should "have a path to transient vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        val depthFirstSearch = DepthFirstSearch.create(graph, 1).get

        depthFirstSearch.hasPath(4) shouldBe true
    }

    it should "not have a path to not connected vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(3, 4)

        val depthFirstSearch = DepthFirstSearch.create(graph, 1).get

        depthFirstSearch.hasPath(4) shouldBe false
    }
}
