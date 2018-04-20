package org.stack

class Stack[E](size: Int) {
    var currentSize = 0
    val maxSize = if (size < 1) {
        0
    } else {
        16
    }
    var elements = List[E]()

    def pop: Option[E] = {
        if (currentSize == 0) {
            Option.empty
        }
        else {
            val e = elements.drop(currentSize - 1).dropRight(currentSize-1)(1)
            currentSize -= 1
            Option.apply(e)
        }
    }

    def push(e: E): Boolean = {
        if (currentSize < maxSize) {
            elements = elements :+ e
            currentSize += 1
            true
        }
        else {
            false
        }
    }
}
