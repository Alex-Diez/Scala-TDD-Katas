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

    it should "not create a depth first search when graph does not contain start vertex" in {
        DepthFirstSearch.create(graph, 1) shouldBe None
    }

    it should "have a path to transient vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        val search = DepthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe true
    }

    it should "have not a path to not connected vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(3, 4)

        val search = DepthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe false
    }
}
