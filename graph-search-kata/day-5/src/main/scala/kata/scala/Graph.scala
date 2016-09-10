package kata.scala

import scala.collection.mutable

class Graph  {
    private val vertices = mutable.Map[Int, mutable.ArrayBuffer[Int]]()

    def adjacentTo(vertex: Int): Iterator[Int] = {
        vertices(vertex).iterator
    }

    def contains(vertex: Int) = vertices.contains(vertex)

    def addEdge(from: Int, to: Int) = {
        if (!vertices.contains(from)) {
            vertices += (from -> new mutable.ArrayBuffer[Int]())
        }
        vertices(from) += to
        if (!vertices.contains(to)) {
            vertices += (to -> new mutable.ArrayBuffer[Int]())
        }
        vertices(to) += from
    }

}
