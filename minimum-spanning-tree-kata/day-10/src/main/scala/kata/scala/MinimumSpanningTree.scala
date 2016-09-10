package kata.scala

import scala.collection.mutable

class MinimumSpanningTree(private val spanningTree: Set[WeightedEdge]) {
    def tree: TraversableOnce[WeightedEdge] = spanningTree.iterator
}

object MinimumSpanningTree {
    def create(graph: EdgeWeightedGraph) = {
        if (graph.isEmpty) None
        else {
            def buildSpanningTree(): Set[WeightedEdge] = {
                val marked = mutable.Set[Int]()
                val tree = mutable.Set[WeightedEdge]()
                val priority = new mutable.PriorityQueue[WeightedEdge]()

                def visit(vertex: Int): Unit = {
                    marked += vertex
                    priority ++= graph.adjacentTo(vertex).filter(e => !marked.contains(e.other(vertex)))
                }

                visit(graph.startVertex)
                while (priority.nonEmpty) {
                    val edge = priority.dequeue()

                    val from = edge.either()
                    val to = edge.other(from)

                    if (!marked.contains(from) || !marked.contains(to)) {
                        tree += edge
                    }

                    if (!marked.contains(from)) {
                        visit(from)
                    }
                    if (!marked.contains(to)) {
                        visit(to)
                    }
                }

                Set() ++ tree
            }
            Some(new MinimumSpanningTree(buildSpanningTree()))
        }
    }

}
