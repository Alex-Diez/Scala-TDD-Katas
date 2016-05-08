package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class BreadthFirstSearchTest extends FlatSpec with Matchers with BeforeAndAfter {

    var graph = new Graph

    before {
        graph = new Graph
    }

    it should "create a breadth first search" in {
        graph.addEdge(1, 2)

        BreadthFirstSearch.create(graph, 1) should not be None
    }

    it should "not create a breadth first search when graph does not contain the starting vertex" in {
        BreadthFirstSearch.create(graph, 1) shouldBe None
    }

    it should "have a path to transient vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        val search = BreadthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe true
    }

    it should "not have a path to not connected vertices" in {
        graph.addEdge(1, 2)
        graph.addEdge(3, 4)

        val search = BreadthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe false
    }

}
