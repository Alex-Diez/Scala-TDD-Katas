package org.stack

class Stack[T] {
    private var head: Element[T] = new Empty(0)

    def len: Int = head.index

    def isEmpty: Boolean = head.previous.isEmpty

    def push(v: T) = {
        head = new NonEmpty(len + 1, v, head)
    }

    def pop: Option[T] = {
        if(isEmpty) None
        else {
            val r = head
            head = head.previous.get
            r.values
        }
    }

    abstract class Element[E](val index: Int) {

        def previous: Option[Element[E]]

        def values: Option[E]
    }

    class Empty[E](index: Int) extends Element[E](index) {

        override def previous: Option[Element[E]] = None

        override def values: Option[E] = None
    }

    class NonEmpty[E](index: Int, val v: E, val p: Element[E]) extends Element[E](index) {

        override def previous: Option[Element[E]] = Some(p)

        override def values: Option[E] = Some(v)
    }

}
