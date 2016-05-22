package kata.scala

import scala.collection.mutable

class GraphSearch(private val marked: Set[Int]) {
    def hasPathTo(vertex: Int): Boolean = marked.contains(vertex)

}

object DepthFirstSearch {
    def create(graph: Graph, startVertex: Int): Option[GraphSearch] = {
        if (!graph.contains(startVertex)) None
        else {
            def depthFirstSearch(vertex: Int, marked: Set[Int]): Set[Int] = {
                graph.adjacentTo(vertex).filterNot(v => marked.contains(v)).foldLeft(marked + vertex)((marked, v) => depthFirstSearch(v, marked))
            }
            Some(new GraphSearch(depthFirstSearch(startVertex, Set())))
        }
    }
}

object BreadthFirstSearch {
    def create(graph: Graph, startVertex: Int): Option[GraphSearch] = {
        if (!graph.contains(startVertex)) None
        else {
            def breadthFirstSearch(vertex: Int): Set[Int] = {
                val queue = new mutable.Queue[Int]() += vertex
                val marked = mutable.Set[Int]() += vertex
                while (queue.nonEmpty) {
                    val v = queue.dequeue()
                    graph.adjacentTo(v).filterNot(v => marked.contains(v)).foreach(
                        v => {
                            queue += v
                            marked += v
                        }
                    )
                }
                Set() ++ marked
            }
            Some(new GraphSearch(breadthFirstSearch(startVertex)))
        }
    }
}
