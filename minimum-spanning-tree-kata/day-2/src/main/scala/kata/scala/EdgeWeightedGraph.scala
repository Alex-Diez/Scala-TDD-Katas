package kata.scala

import scala.collection.mutable

class EdgeWeightedGraph[V] {

    private val edges = mutable.Map[V, mutable.ArrayBuffer[WeightedEdge[V]]]()

    def startingVertex: V = {
        edges.keys.iterator.next()
    }

    def adjacentTo(vertex: V): Iterator[WeightedEdge[V]] = {
        edges(vertex).iterator
    }

    def addEdge(edge: WeightedEdge[V]) = {
        val from = edge.either()
        val to = edge.other(from)
        if (!edges.contains(from)) edges += (from -> new mutable.ArrayBuffer[WeightedEdge[V]]())
        edges(from) += edge
        if (!edges.contains(to)) edges += (to -> new mutable.ArrayBuffer[WeightedEdge[V]]())
        edges(to) += edge
    }

    def isEmpty: Boolean = edges.isEmpty

}

class WeightedEdge[V](private val from: V, private val to: V, private val weight: Double) extends Ordered[WeightedEdge[V]] {

    def either(): V = from

    def other(vertex: V): V = {
        if (vertex == from) to
        else from
    }

    override def compare(that: WeightedEdge[V]): Int = {
        if (weight > that.weight) -1
        else if (weight < that.weight) 1
        else 0
    }

    override def hashCode(): Int = from.hashCode() + to.hashCode() + weight.toInt

    override def equals(obj: scala.Any): Boolean = {
        obj match {
            case obj: WeightedEdge[V] => (obj.from equals from) && (obj.to equals to) && (obj.weight == weight)
            case _ => false
        }
    }

    override def toString: String = "[ Edge from - " + from + " to - " + to + " weight - " + weight + " ]"
}
