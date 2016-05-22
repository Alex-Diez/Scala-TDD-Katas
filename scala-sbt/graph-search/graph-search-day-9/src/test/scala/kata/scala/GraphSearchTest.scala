package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSpec, Matchers}

class GraphSearchTest extends FunSpec with Matchers with BeforeAndAfter {

    var graph = new Graph

    before {
        graph = new Graph
    }

    describe("depth first search") {

        it("should create a depth first search") {
            graph.addEdge(1, 2)

            DepthFirstSearch.create(graph, 1) should not be None
        }

        it("should not create a depth first search when graph does not contain the starting vertex") {
            DepthFirstSearch.create(graph, 1) shouldBe None
        }

        it("should have a path to a transient vertex") {
            graph.addEdge(1, 2)
            graph.addEdge(2, 3)
            graph.addEdge(3, 4)

            val search = DepthFirstSearch.create(graph, 1).get

            search.hasPathTo(4) shouldBe true
        }

        it("should not have a path to a not connected vertex") {
            graph.addEdge(1, 2)
            graph.addEdge(3, 4)

            val search = DepthFirstSearch.create(graph, 1).get

            search.hasPathTo(4) shouldBe false
        }
    }

    describe("breadth first search") {

        it("should create a breadth first search") {
            graph.addEdge(1, 2)

            BreadthFirstSearch.create(graph, 1) should not be None
        }

        it("should not create a breadth first search when graph does not contain the starting vertex") {
            BreadthFirstSearch.create(graph, 1) shouldBe None
        }

        it("should have a path to a transient vertex") {
            graph.addEdge(1, 2)
            graph.addEdge(2, 3)
            graph.addEdge(3, 4)

            val search = BreadthFirstSearch.create(graph, 1).get

            search.hasPathTo(4) shouldBe true
        }

        it("should not have a path to a not connected vertex") {
            graph.addEdge(1, 2)
            graph.addEdge(3, 4)

            val search = BreadthFirstSearch.create(graph, 1).get

            search.hasPathTo(4) shouldBe false
        }
    }

}
