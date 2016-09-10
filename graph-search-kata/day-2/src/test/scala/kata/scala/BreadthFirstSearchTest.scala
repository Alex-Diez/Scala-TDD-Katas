package kata.scala

import org.scalatest.{FlatSpec, Matchers}

class BreadthFirstSearchTest extends FlatSpec with Matchers {

    it should "create a breadth first search" in {
        val graph = new Graph

        graph.addEdge(1, 2)

        BreadthFirstSearch.create(graph, 1).isDefined shouldBe true
    }

    it should "not create a breadth first search when graph does not contain a start vertex" in {
        val graph = new Graph

        BreadthFirstSearch.create(graph, 1) shouldBe None
    }

    it should "have a path to transients vertices" in {
        val graph = new Graph

        graph.addEdge(1, 2)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        val search = BreadthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe true
    }

    it should "not have a path to not connected vertices" in {
        val graph = new Graph

        graph.addEdge(1, 2)
        graph.addEdge(3, 4)

        val search = BreadthFirstSearch.create(graph, 1).get

        search.hasPathTo(4) shouldBe false
    }

}
