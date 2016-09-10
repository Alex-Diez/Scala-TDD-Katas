package org.stack

class Stack[T](val maxSize: Int) {
    private var head: Element[T] = new Empty

    def pop: Option[T] = {
        val r = head.value
        head = head.previous
        r
    }

    def push(e: T): Boolean =
        if (size != maxSize) {
            head = new NonEmpty(head.index + 1, e, head)
            true
        }
        else false

    def size: Int = head.index + 1

    def isEmpty: Boolean = head.index == -1

    sealed abstract class Element[E] {
        def index: Int

        def previous: Element[E]

        def value: Option[E]
    }

    class Empty[E] extends Element[E] {
        override def index: Int = -1

        override def previous: Element[E] = this

        override def value: Option[Nothing] = None
    }

    class NonEmpty[E](val index: Int, val e: E, val p: Element[E]) extends Element[E] {
        override def previous: Element[E] = p

        override def value: Option[E] = Some(e)
    }

}
