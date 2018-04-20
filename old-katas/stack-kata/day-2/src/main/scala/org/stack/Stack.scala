package org.stack

class Stack(size: Int) {
    private val maxSize = size
    private var currentSize = 0
    private var elements = List[Int]()

    def push(e: Int):Boolean = {
        if(currentSize < maxSize) {
            elements = e :: elements
            currentSize += 1
            true
        }
        else {
            false
        }
    }

    def pop:Option[Int] = {
        if(elements.isEmpty) {
            Option.empty
        }
        else {
            val top = elements.head
            elements = elements.tail
            Option.apply(top)
        }
    }
}
