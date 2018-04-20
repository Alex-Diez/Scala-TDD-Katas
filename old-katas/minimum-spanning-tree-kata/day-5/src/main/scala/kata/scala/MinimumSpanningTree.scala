package kata.scala

import scala.collection.mutable

class MinimumSpanningTree[V](private val spanningTree: Set[WeightedEdge[V]]) {
    def tree: Iterator[WeightedEdge[V]] = spanningTree.iterator
}

object MinimumSpanningTree {
    def create[V](graph: EdgeWeightedGraph[V]):Option[MinimumSpanningTree[V]] = {
        if (graph.isEmpty) None
        else {
            def buildSpanningTree():Set[WeightedEdge[V]] = {
                val marked = mutable.Set[V]()
                val priority = new mutable.PriorityQueue[WeightedEdge[V]]()
                val tree = mutable.Set[WeightedEdge[V]]()

                def visit(vertex: V) = {
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
