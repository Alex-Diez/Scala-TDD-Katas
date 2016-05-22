package kata.scala

import scala.collection.mutable

class SpanningTree(private val spanning: Set[WeightedEdge]) {
    def tree: Iterator[WeightedEdge] = spanning.iterator
}

object SpanningTree {
    def create(graph: EdgeWeightedGraph): Option[SpanningTree] = {
        if (graph.isEmpty) None
        else {
            def buildSpanningTree(): Set[WeightedEdge] = {
                val marked = mutable.Set[Int]()
                val tree = new mutable.Queue[WeightedEdge]()
                val priority = new mutable.PriorityQueue[WeightedEdge]()

                def visit(vertex: Int) = {
                    marked += vertex
                    priority ++= graph.adjacentTo(vertex).filterNot(edge => marked.contains(edge.other(vertex)))
                }
                visit(graph.startingVertex)
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
            Some(new SpanningTree(buildSpanningTree()))
        }
    }

}
