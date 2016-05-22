package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MinimumSpanningTreeTest extends FlatSpec with Matchers with BeforeAndAfter {

    var graph = new EdgeWeightedGraph

    before {
        graph = new EdgeWeightedGraph
    }

    it should "create a minimum spanning tree" in {
        graph.addEdge(new WeightedEdge(1, 2, 1.0))

        MinimumSpanningTree.create(graph) should not be None
    }

    it should "not create a minimum spanning tree when graph is empty" in {
        MinimumSpanningTree.create(graph) shouldBe None
    }

    it should "have two edges" in {
        graph.addEdge(new WeightedEdge(1, 2, 1.0))
        graph.addEdge(new WeightedEdge(2, 3, 1.0))
        graph.addEdge(new WeightedEdge(1, 3, 10.0))

        val spanningTree = MinimumSpanningTree.create(graph).get

        spanningTree.tree.toStream should contain allOf(new WeightedEdge(1, 2, 1.0), new WeightedEdge(2, 3, 1.0))
    }

    it should "have three edges" in {
        graph.addEdge(new WeightedEdge(1, 2, 1.0))
        graph.addEdge(new WeightedEdge(2, 3, 1.0))
        graph.addEdge(new WeightedEdge(3, 4, 1.0))
        graph.addEdge(new WeightedEdge(1, 4, 10.0))

        val spanningTree = MinimumSpanningTree.create(graph).get

        spanningTree.tree.toStream should contain allOf(new WeightedEdge(1, 2, 1.0), new WeightedEdge(2, 3, 1.0), new WeightedEdge(3, 4, 1.0))
    }
}
