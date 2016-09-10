package kata.scala

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MinimumSpanningTreeTest extends FlatSpec with Matchers with BeforeAndAfter {

    var graph = new EdgeWeightedGraph[Int]

    before {
        graph = new EdgeWeightedGraph[Int]
    }

    it should "create a minimum spanning tree" in {
        graph.addEdge(new WeightedEdge[Int](1, 2, 1.0))

        MinimumSpanningTree.create[Int](graph) should not be None
    }

    it should "not create a minimum spanning tree when graph is empty" in {
        MinimumSpanningTree.create[Int](graph) shouldBe None
    }

    it should "have two edges" in {
        graph.addEdge(new WeightedEdge[Int](1, 2, 1.0))
        graph.addEdge(new WeightedEdge[Int](2, 3, 1.0))
        graph.addEdge(new WeightedEdge[Int](1, 3, 10.0))

        val spanningTree = MinimumSpanningTree.create[Int](graph).get

        spanningTree.tree.toStream should contain allOf (new WeightedEdge[Int](1, 2, 1.0), new WeightedEdge[Int](2, 3, 1.0))
    }

    it should "have three edges" in {
        graph.addEdge(new WeightedEdge[Int](1, 2, 1.0))
        graph.addEdge(new WeightedEdge[Int](2, 3, 1.0))
        graph.addEdge(new WeightedEdge[Int](3, 4, 1.0))
        graph.addEdge(new WeightedEdge[Int](1, 4, 10.0))

        val spanningTree = MinimumSpanningTree.create[Int](graph).get

        spanningTree.tree.toStream should contain allOf(new WeightedEdge[Int](1, 2, 1.0), new WeightedEdge[Int](2, 3, 1.0), new WeightedEdge[Int](3, 4, 1.0))
    }

}
