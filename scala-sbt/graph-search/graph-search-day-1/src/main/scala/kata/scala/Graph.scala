package kata.scala

import scala.collection.mutable

class Graph {
    private val edges: mutable.Map[Int, mutable.ArrayBuffer[Int]] = mutable.Map.empty

    def adjacentTo(v: Int): Iterable[Int] = {
        edges(v)
    }

    def isEmpty: Boolean = edges.isEmpty

    def vertices(): Iterable[Int] = edges.keys

    def addEdge(v: Int, w: Int) = {
        if (edges.contains(v)) {
            edges(v) += w
        }
        else {
            val buffer = new mutable.ArrayBuffer[Int]()
            buffer += w
            edges.put(v, buffer)
        }
        if (edges.contains(w)) {
            edges(w) += v
        }
        else {
            val buffer = new mutable.ArrayBuffer[Int]()
            buffer += v
            edges.put(w, buffer)
        }
    }
}
