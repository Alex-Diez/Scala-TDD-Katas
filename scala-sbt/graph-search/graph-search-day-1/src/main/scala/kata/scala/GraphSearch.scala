package kata.scala

import scala.collection.mutable

class GraphSearch(private val marked: List[Int]) {
    def hasPath(vertex: Int): Boolean = marked.contains(vertex)
}

object DepthFirstSearch {

    def create(graph: Graph, startInt: Int): Option[GraphSearch] = {
        if (graph.isEmpty) None
        else Some(new DepthFirstSearchBuilder(graph, startInt).buildSearch())
    }

    private class DepthFirstSearchBuilder(private val graph: Graph, private val startVertex: Int) {
        def buildSearch(): GraphSearch = {
            def depthFirstSearch(v: Int, marked: List[Int]): List[Int] = {
                if (marked.contains(v)) marked
                else {
                    graph.adjacentTo(v)
                            .filter(v => !marked.contains(v))
                            .foldLeft(v :: marked)((l, v) => depthFirstSearch(v, l))
                }
            }

            new GraphSearch(depthFirstSearch(startVertex, List()).reverse)
        }
    }

}

object BreadthFirstSearch {
    def create(graph: Graph, startVertex: Int): Option[GraphSearch] = {
        if (graph.isEmpty) None
        else Some(new BreadthFirstSearchBuilder(graph, startVertex).buildSearch())
    }

    class BreadthFirstSearchBuilder(private val graph: Graph, private val startVertex: Int) {
        def buildSearch(): GraphSearch = {
            def breadthFirstSearch(vertex: Int): List[Int] = {
                val queue = mutable.Queue[Int]() += startVertex
                val marked = mutable.ArrayBuffer[Int]() += startVertex
                while (queue.nonEmpty) {
                    val v = queue.dequeue()
                    graph.adjacentTo(v)
                            .filter(v => !marked.contains(v))
                            .foreach(
                                v => {
                                    marked += v
                                    queue.enqueue(v)
                                }
                            )
                }
                marked toList
            }
            new GraphSearch(breadthFirstSearch(startVertex))
        }
    }

}
