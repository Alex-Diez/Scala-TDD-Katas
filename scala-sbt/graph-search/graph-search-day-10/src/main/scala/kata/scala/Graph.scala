package kata.scala

import scala.collection.mutable

class Graph {
    private val edges = mutable.Map[Int, mutable.ArrayBuffer[Int]]()

    def adjacentTo(vertex: Int): Iterator[Int] = {
        edges(vertex).iterator
    }

    def contains(vertex: Int): Boolean = {
        edges.contains(vertex)
    }

    def addEdge(from: Int, to: Int) = {
        if (!edges.contains(from)) {
            edges += (from -> new mutable.ArrayBuffer[Int]())
        }
        edges(from) += to
        if(!edges.contains(to)) {
            edges += (to -> new mutable.ArrayBuffer[Int]())
        }
        edges(to) += from
    }

}
