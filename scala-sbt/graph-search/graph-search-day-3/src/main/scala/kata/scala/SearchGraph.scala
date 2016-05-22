package kata.scala

class SearchGraph(private val marked: Set[Int]) {
    def hasPathTo(vertex: Int) = marked.contains(vertex)
}

object DepthFirstSearch {
    def create(graph: Graph, startVertex: Int): Option[SearchGraph] = {
        if (!graph.contains(startVertex)) None
        else {
            def depthFirstSearch(vertex: Int, marked: Set[Int]): Set[Int] = {
                graph.adjacentTo(vertex).filterNot(v => marked.contains(v)).foldLeft(marked + vertex)((marked, v) => depthFirstSearch(v, marked))
            }
            Some(new SearchGraph(depthFirstSearch(startVertex, Set())))
        }
    }
}

object BreadthFirstSearch {
    def create(graph: Graph, startVertex: Int): Option[SearchGraph] = {
        if (!graph.contains(startVertex)) None
        else {
            def breadthFirstSearch(vertex: Int): Set[Int] = {
                val queue = new scala.collection.mutable.Queue[Int] += vertex
                val marked = scala.collection.mutable.Set[Int]() += vertex
                while (queue.nonEmpty) {
                    val v = queue.dequeue()
                    graph.adjacentTo(v).filterNot(v => marked.contains(v)).foreach(
                        v => {
                            marked += v
                            queue += v
                        }
                    )
                }
                Set() ++ marked
            }
            Some(new SearchGraph(breadthFirstSearch(startVertex)))
        }
    }

}
