package kata.scala

import scala.collection.mutable

class EdgeWeightedGraph {
    private val edges = mutable.Map[Int, mutable.ArrayBuffer[WeightedEdge]]()

    def adjacentTo(vertex: Int): Iterator[WeightedEdge] = {
        edges(vertex).iterator
    }

    def startingVertex: Int = edges.keys.iterator.next()

    def isEmpty: Boolean = edges.isEmpty

    def addEdge(edge: WeightedEdge) = {
        val from = edge.either()
        val to = edge.other(from)
        if (!edges.contains(from)) {
            edges += (from -> new mutable.ArrayBuffer[WeightedEdge]())
        }
        edges(from) += edge
        if (!edges.contains(to)) {
            edges += (to -> new mutable.ArrayBuffer[WeightedEdge]())
        }
        edges(to) += edge
    }

}

class WeightedEdge(private val from: Int, private val to: Int, private val weight: Double) extends Ordered[WeightedEdge] {
    def either(): Int = from

    def other(vertex: Int): Int = {
        if (vertex == from) to
        else from
    }

    override def compare(that: WeightedEdge): Int = {
        if (weight > that.weight) -1
        else if (weight < that.weight) 1
        else 0
    }

    override def equals(obj: scala.Any): Boolean = {
        obj match {
            case obj: WeightedEdge => obj.from == from && obj.to == to && obj.weight == weight
            case _ => false
        }
    }

    override def hashCode(): Int = {
        from + to + weight.toInt
    }

    override def toString(): String = "[ Edge from - " + from + " to - " + to + " weight - " + weight + " ]"
}
