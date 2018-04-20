package org.stack

class Stack(size: Int) {
    private var elements: List[Int] = List()
    private val maxSize = size

    def pop: Option[Int] = {
        if (elements.isEmpty) Option.empty
        else {
            val e = elements.head
            elements = elements.tail
            Option.apply(e)
        }
    }

    def push(e: Int): Boolean = {
        if (elements.size != maxSize) {
            elements = e +: elements
            true
        }
        else false
    }

    def isEmpty: Boolean = elements.isEmpty
}
